package org.sayem.webdriver.browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sayem.webdriver.browsers.config.IBrowserThreads;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by sayem on 10/05/15.
 */
public class ChromeBrowser implements IBrowserThreads {

    @Override
    public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches",
                Collections.singletonList("--no-default-browser-check"));
        HashMap<String, String> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.password_manager_enabled", "false");
        capabilities.setCapability("chrome.prefs", chromePreferences);
        capabilities.setCapability("screenResolution", "1280x1024");

        //**************

        String downloadFilepath = "src/test/resources/download";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return addProxySettings(capabilities, proxySettings);
    }

    @Override
    public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {

        String win64 = "selenium_standalone\\windows\\googlechrome\\64bit\\chromedriver.exe";
        String win32 = "selenium_standalone\\windows\\googlechrome\\32bit\\chromedriver.exe";
        String mac64 = "selenium_standalone/osx/googlechrome/64bit/chromedriver";
        String mac32 = "selenium_standalone/osx/googlechrome/32bit/chromedriver";
        String linux64 = "selenium_standalone/linux/googlechrome/64bit/chromedriver";
        String linux32 = "selenium_standalone/linux/googlechrome/32bit/chromedriver";

        if (System.getProperty("os.name").contains("Mac")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.chrome.driver", mac64);
        else if (System.getProperty("os.name").contains("Mac")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.chrome.driver", mac32);
        else if (System.getProperty("os.name").contains("Windows")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.chrome.driver", win64);
        else if (System.getProperty("os.name").contains("Windows")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.chrome.driver", win32);
        else if (System.getProperty("os.name").contains("Linux")
                && System.getProperty("os.arch").contains("64"))
            System.setProperty("webdriver.chrome.driver", linux64);
        else if (System.getProperty("os.name").contains("Linux")
                && System.getProperty("os.arch").contains("32"))
            System.setProperty("webdriver.chrome.driver", linux32);

        return new ChromeDriver(capabilities);
    }
}