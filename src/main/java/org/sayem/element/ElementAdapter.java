package org.sayem.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sayem on 08/02/17.
 */
public class ElementAdapter<T extends WebDriver> implements Element {

    private T driver;

    public ElementAdapter(T driver) {
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
