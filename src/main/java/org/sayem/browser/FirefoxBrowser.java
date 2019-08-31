package org.sayem.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Adapter<FirefoxDriver> {

    @Override
    public Browser browser() {
        WebDriverManager.firefoxdriver().setup();
        return new BrowserAdapter(new FirefoxDriver());
    }
}
