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
public class SeleniumAdapter<T extends WebDriver> implements Browser<T> {

    private T driver;

    public SeleniumAdapter(T driver) {
        this.driver = driver;
    }

    @Override
    public T driver() {
        return driver;
    }
}
