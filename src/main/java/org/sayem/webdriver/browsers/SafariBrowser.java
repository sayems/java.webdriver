package org.sayem.webdriver.browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.sayem.webdriver.browsers.config.IBrowserThreads;

/**
 * Created by sayem on 10/05/15.
 */
public class SafariBrowser implements IBrowserThreads {

    /*
     *  Since Selenium 2.45.0, in order to use SafariDriver,
     *  you need to manually install the SafariDriver browser extension.
     *
     * The prebuilt SafariDriver extension can be downloaded from here:
     * http://selenium-release.storage.googleapis.com/index.html?path=2.48/
     * You'll need latest version of SafariDriver.safariextz(SafariDriver.safariextz)
     * Download it, double-click it, and click Trust when prompted.
     *
     * if you're going to run Safari on a remote node (or set of nodes),
     * you'll need to install and enable the SafariDriver browser extension on each of them.
     *
     */

    @Override
    public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        capabilities.setCapability("safari.cleanSession", true);
        capabilities.setCapability("screenResolution", "1280x1024");
        return addProxySettings(capabilities, proxySettings);
    }

    @Override
    public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        return new SafariDriver(capabilities);
    }
}
