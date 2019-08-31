package org.sayem.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.browser.BrowserAdapter;

import java.util.List;

/**
 * Created by sayem on 08/02/17.
 */
public class ElementAdapter implements Element {

    private WebDriver driver;

    public ElementAdapter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
