package org.sayem.webdriver.browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sayem.webdriver.browsers.config.IBrowserThreads;

import java.io.File;

/**
 * Created by sayem on 10/05/15.
 */
public class FirefoxBrowser implements IBrowserThreads {

    @Override
    public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
        FirefoxProfile profile = new FirefoxProfile();

        profile.addExtension(new File("libs/firebug-2.0.16-fx.xpi"));
        profile.addExtension(new File("libs/firefinder_for_firebug-1.4-fx.xpi"));
        profile.addExtension(new File("libs/firepath-0.9.7.1-fx.xpi"));

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setCapability("screenResolution", "1280x1024");
        capabilities.setCapability("marionette", true);
        return addProxySettings(capabilities, proxySettings);
    }

    @Override
    public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {

        String win64 = "selenium_standalone\\windows\\marionette\\64bit\\geckodriver.exe";
        String win32 = "selenium_standalone\\windows\\marionette\\32bit\\geckodriver.exe";
        String mac64 = "selenium_standalone/osx/marionette/64bit/geckodriver";
        String mac32 = "selenium_standalone/osx/marionette/32bit/geckodriver";
        String linux64 = "selenium_standalone/linux/marionette/64bit/geckodriver";
        String linux32 = "selenium_standalone/linux/marionette/32bit/geckodriver";

        if (System.getProperty("os.name").contains("Mac")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.gecko.driver", mac64);
        else if (System.getProperty("os.name").contains("Mac")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.gecko.driver", mac32);
        else if (System.getProperty("os.name").contains("Windows")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.gecko.driver", win64);
        else if (System.getProperty("os.name").contains("Windows")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.gecko.driver", win32);
        else if (System.getProperty("os.name").contains("Linux")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.gecko.driver", linux64);
        else if (System.getProperty("os.name").contains("Linux")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.gecko.driver", linux32);
        return new FirefoxDriver(capabilities);
    }
}