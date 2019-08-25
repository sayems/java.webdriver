package org.sayem.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumChrome implements Adapter<ChromeDriver> {
    @Override
    public Browser<ChromeDriver> browser() {
        WebDriverManager.chromedriver().setup();
        return new SeleniumAdapter<>(new ChromeDriver());
    }
}
