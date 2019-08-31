package org.sayem.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.element.Element;
import org.sayem.element.ElementAdapter;
import org.sayem.selenium.DelegatingElement;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by sayem on 08/02/17.
 */
public class BrowserAdapter implements Browser<WebDriver> {

    private WebDriver driver;
    private ElementAdapter element;
    private DateTimePickerAdapter dateTime;

    BrowserAdapter(WebDriver driver) {
        this.driver = driver;
        this.element = new ElementAdapter(driver);
        this.dateTime = new DateTimePickerAdapter();
    }

    @Override
    public WebDriver driver() {
        return driver;
    }

    @Override
    public DateTimePicker dateTime() {
        return dateTime;
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public DelegatingElement findElement(Supplier<By> by) {
        return element.findElement(by);
    }

    @Override
    public List<DelegatingElement> findElements(Supplier<By> by) {
        return element.findElements(by);
    }

    @Override
    public WebElement untilFound(By by) {
        return element.untilFound(by);
    }

    @Override
    public DelegatingElement untilFound(Supplier<By> by) {
        return element.untilFound(by);
    }

    @Override
    public Element element() {
        return element;
    }
}
