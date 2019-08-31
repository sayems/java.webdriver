package org.sayem.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements Adapter<ChromeDriver> {
    @Override
    public Browser browser() {
        WebDriverManager.chromedriver().setup();
        return new BrowserAdapter(new ChromeDriver());
    }
}
