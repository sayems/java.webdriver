package org.sayem.webdriver.basics.webdriver.drivers;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IEDriverTest {

    @BeforeClass
    public static void setupTheIEDriverSystemProperty() {

        // tell webdriver where to find the IE driver
        String currentUserDir = System.getProperty("user.dir");
        String IEDriverLocation = currentUserDir + "/../tools/iedriver_32/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", IEDriverLocation);
    }

    @Test
    public void basicIEDriverTest() {

        WebDriver iedriver = new InternetExplorerDriver();

        iedriver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(iedriver.getTitle(), is("HTML Form Elements"));

        iedriver.quit();
    }

    @Test
    public void ieDriverProxyTest() {

        // This doesn't do what you expect

        Proxy proxy = new Proxy();
        proxy.setHttpProxy(Driver.PROXY)
                .setFtpProxy(Driver.PROXY)
                .setSslProxy(Driver.PROXY);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver iedriver = new InternetExplorerDriver(capabilities);

        iedriver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(iedriver.getTitle(), is("HTML Form Elements"));

        iedriver.quit();
    }

}
