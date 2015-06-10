package org.sayem.webdriver.basics.webdriver.drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperaDriverTest {

    @Test
    public void basicOperaDriverUsage() {
        WebDriver opera = new OperaDriver();

        opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(opera.getTitle(), is("HTML Form Elements"));

        opera.quit();
    }

    @Test
    public void capabilitiesOperaDriverUsage() {

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(Driver.PROXY)
                .setFtpProxy(Driver.PROXY)
                .setSslProxy(Driver.PROXY);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver opera = new OperaDriver(capabilities);

        opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(opera.getTitle(), is("HTML Form Elements"));

        opera.quit();
    }

    // opera also has preferences that can be used
    //opera:config
    //http://www.opera.com/support/usingopera/operaini
    @Test
    public void preferencesOperaDriverUsage() {


//        OperaProfile profile = new OperaProfile();
//        // switching off Javascript will cause the opera driver to fail
//        profile.preferences().set("Extensions", "Scripting", 0);
//
//        WebDriver opera = new OperaDriver(profile);
//
//        opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
//
//        assertThat(opera.getTitle(), is("HTML Form Elements"));
//
//        opera.quit();
    }

}
