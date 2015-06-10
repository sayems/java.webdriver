package org.sayem.webdriver.basics.webdriver.examples;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A singleton style manager to maintain Drivers to prevent
 * test slowdown for creating a browser for each class with tests.
 * <p>
 * Also counts time to start a browser and extrapolates from that how much
 * time you have saved using such hacky code.
 */
public class Driver extends Thread {
    public static final long DEFAULT_TIMEOUT_SECONDS = 10;
    public static final String BROWSER_PROPERTY_NAME = "selenium2basics.webdriver";
    public static BrowserName currentDriver;
    // default for browsermob localhost:8080
    // default for fiddler: localhost:8888
    public static String PROXY = "localhost:8080";
    private static WebDriver aDriver = null;
    private static long browserStartTime = 0L;
    private static long savedTimecount = 0L;
    private static boolean avoidRecursiveCall = false;
    private static BrowserName useThisDriver = null;

    public static void set(BrowserName aBrowser) {
        useThisDriver = aBrowser;

        // close any existing driver
        if (aDriver != null) {
            aDriver.quit();
            aDriver = null;
        }
    }

    public static WebDriver get() {

        if (useThisDriver == null) {

            String defaultBrowser = System.getProperty(BROWSER_PROPERTY_NAME, "FIREFOX");
            switch (defaultBrowser) {
                case "FIREFOX":
                    useThisDriver = BrowserName.FIREFOX;
                    break;
                case "CHROME":
                    useThisDriver = BrowserName.GOOGLECHROME;
                    break;
                case "IE":
                    useThisDriver = BrowserName.IE;
                    break;
                case "OPERA":
                    useThisDriver = BrowserName.OPERA;
                    break;
                case "SAUCELABS":
                    useThisDriver = BrowserName.SAUCELABS;
                    break;
                case "HTMLUNIT":
                    useThisDriver = BrowserName.HTMLUNIT;
                    break;
                default:
                    throw new RuntimeException("Unknown Browser in " + BROWSER_PROPERTY_NAME + ": " + defaultBrowser);
            }

        }


        if (aDriver == null) {


            long startBrowserTime = System.currentTimeMillis();

            switch (useThisDriver) {
                case FIREFOX:
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setEnableNativeEvents(true);

                    aDriver = new FirefoxDriver();//profile);
                    currentDriver = BrowserName.FIREFOX;
                    break;

                case OPERA:

                    aDriver = new OperaDriver();
                    currentDriver = BrowserName.OPERA;
                    break;

                case HTMLUNIT:

                    aDriver = new HtmlUnitDriver();
                    currentDriver = BrowserName.HTMLUNIT;
                    break;

                case IE:

                    setDriverPropertyIfNecessary("webdriver.ie.driver", "/../tools/iedriver_64/IEDriverServer.exe", "C://webdrivers/iedriver_64/IEDriverServer.exe");

                    aDriver = new InternetExplorerDriver();
                    currentDriver = BrowserName.IE;
                    break;

                case GOOGLECHROME:

                    setDriverPropertyIfNecessary("webdriver.chrome.driver", "/../tools/chromedriver/chromedriver.exe", "C://webdrivers/chromedriver/chromedriver.exe");

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-plugins");
                    options.addArguments("disable-extensions");

                    aDriver = new ChromeDriver(options);
                    currentDriver = BrowserName.GOOGLECHROME;
                    break;

                case SAUCELABS:

                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("version", "5");
                    capabilities.setCapability("platform", Platform.XP);
                    try {
                        // add url to environment variables to avoid releasing with source
                        String sauceURL = System.getenv("SAUCELABS_URL");
                        aDriver = new RemoteWebDriver(
                                new URL(sauceURL),
                                capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    currentDriver = BrowserName.SAUCELABS;
                    break;
            }


            long browserStartedTime = System.currentTimeMillis();
            browserStartTime = browserStartedTime - startBrowserTime;

            // we want to shutdown the shared brower when the tests finish
            Runtime.getRuntime().addShutdownHook(
                    new Thread() {
                        public void run() {
                            Driver.quit();
                        }
                    }
            );

        } else {

            try {
                // is browser still alive
                if (aDriver.getWindowHandle() != null) {
                    // assume it is still alive
                }
            } catch (Exception e) {
                if (avoidRecursiveCall) {
                    // something has gone wrong as we have been here already
                    throw new RuntimeException();
                }

                quit();
                aDriver = null;
                avoidRecursiveCall = true;
                return get();
            }

            savedTimecount += browserStartTime;
            System.out.println("Saved another " + browserStartTime + "ms : total saved " + savedTimecount + "ms");
        }

        avoidRecursiveCall = false;
        return aDriver;
    }

    private static void setDriverPropertyIfNecessary(String propertyKey, String relativeToUserPath, String absolutePath) {
        // http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

        if (!System.getProperties().containsKey(propertyKey)) {

            String currentDir = System.getProperty("user.dir");
            String chromeDriverLocation = currentDir + relativeToUserPath;
            File driverExe = new File(chromeDriverLocation);
            if (driverExe.exists()) {
                System.setProperty(propertyKey, chromeDriverLocation);
            } else {
                driverExe = new File(absolutePath);
                if (driverExe.exists()) {
                    System.setProperty(propertyKey, absolutePath);
                } else {
                    // expect an error on the follow through when we try to use the driver
                }
            }
        }
    }

    public static WebDriver get(String aURL, boolean maximize) {
        get();
        aDriver.get(aURL);
        if (maximize) {
            try {
                aDriver.manage().window().maximize();
            } catch (UnsupportedCommandException e) {
                System.out.println("Remote Driver does not support maximise");
            } catch (UnsupportedOperationException e) {
                System.out.println("Opera driver does not support maximize yet");
            }
        }
        return aDriver;
    }

    public static WebDriver get(String aURL) {
        return get(aURL, true);
    }

    public static void quit() {
        if (aDriver != null) {
            System.out.println("total time saved by_class reusing browsers " + savedTimecount + "ms");
            try {
                aDriver.quit();
                aDriver = null;
            } catch (Exception e) {
                // I don't care about errors at this point
            }

        }
    }

    public enum BrowserName {FIREFOX, GOOGLECHROME, SAUCELABS, OPERA, IE, HTMLUNIT}
}
