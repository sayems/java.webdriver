package com.sayem.drivers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HtmlUnitDriverTest {

    @Test
    public void basicHTMLUnitDriverBrowserVersion(){

        WebDriver htmlunit = new HtmlUnitDriver(BrowserVersion.FIREFOX_3_6);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
    public void basicHTMLUnitDriverJavascriptOn(){

        WebDriver htmlunit = new HtmlUnitDriver(true);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
         public void basicHTMLUnitDriverCapabilities(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // setting this to false does not impact firefox
        capabilities.setJavascriptEnabled(true);

        WebDriver htmlunit = new HtmlUnitDriver(capabilities);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }

    @Test
    public void basicHTMLUnitDriverProxyCapabilities(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // setting this to false does not impact firefox
        capabilities.setJavascriptEnabled(true);

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(Driver.PROXY)
                .setFtpProxy(Driver.PROXY)
                .setSslProxy(Driver.PROXY);
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver htmlunit = new HtmlUnitDriver(capabilities);

        htmlunit.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(htmlunit.getTitle(), is("HTML Form Elements"));

        htmlunit.quit();
    }
}
