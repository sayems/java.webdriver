package org.sayem.webdriver.basics.webdriver.basic.part1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesExample {


    public static void main(String[] args) {

        DesiredCapabilities capailities = new DesiredCapabilities();
        capailities.setJavascriptEnabled(true);
        //capailities.setCapability(CapabilityType.PROXY, value);


        FirefoxDriver driver = new FirefoxDriver(capailities);

        System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
        ChromeDriver d1 = new ChromeDriver(capailities);


    }

}
