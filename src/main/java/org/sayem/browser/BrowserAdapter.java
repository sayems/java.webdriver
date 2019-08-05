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
public class BrowserAdapter<T extends WebDriver> implements Browser<T> {

    private T driver;
    private ElementAdapter<T> element;
    private DateTimePickerAdapter dateTime;

    public BrowserAdapter(T driver) {
        this.driver = driver;
        this.element = new ElementAdapter<>(this);
        this.dateTime = new DateTimePickerAdapter();
    }

    @Override
    public T driver() {
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
