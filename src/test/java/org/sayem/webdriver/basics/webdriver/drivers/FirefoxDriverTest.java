package org.sayem.webdriver.basics.webdriver.drivers;

import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FirefoxDriverTest {

    @Test
    public void basicFirefoxDriver() {

        WebDriver firefox = new FirefoxDriver();

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }

    @Test
    public void firefoxDriverWithProfile() {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);

        WebDriver firefox = new FirefoxDriver(profile);

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }


    @Test
    public void firefoxDriverWithCapabilitiesForProxy() {

        Proxy proxy = new Proxy();
        proxy.setHttpProxy(Driver.PROXY)
                .setFtpProxy(Driver.PROXY)
                .setSslProxy(Driver.PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver firefox = new FirefoxDriver(capabilities);

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }

    @Test
    public void firefoxUseExtensions() throws IOException {

        // **************************************************************************
        // profile is good for setting preferences and fiddling with browser settings
        // **************************************************************************

        // Download the extension to a local folder
        String s = File.separator;
        String extensionPath = System.getProperty("user.dir") +
                String.format("%ssrc%stest%sresources%s%s", s, s, s, s, "firebug-1.10.5-fx.xpi");

        System.out.println(extensionPath);

        FirefoxProfile profile = new FirefoxProfile();

        // stop firebug showing the first run screen by_class setting the last version
        // to the current one
        profile.setPreference("extensions.firebug.currentVersion", "1.10.5");

        // add the extension to firefox
        profile.addExtension(new File(extensionPath));

        WebDriver firefox = new FirefoxDriver(profile);
        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }


}
