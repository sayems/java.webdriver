package org.sayem.browser;

import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.function.Supplier;

public class ChromeBrowser implements Adapter<ChromeDriver> {
    @Override
    public Browser<ChromeDriver> get() {
        return new BrowserAdapter<>(new ChromeDriver());
    }
}
