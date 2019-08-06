package org.sayem.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.function.Supplier;

public class ChromeBrowser implements Adapter<ChromeDriver> {
    @Override
    public Browser<ChromeDriver> browser() {
        WebDriverManager.chromedriver().setup();
        return new BrowserAdapter<>(new ChromeDriver());
    }
}
