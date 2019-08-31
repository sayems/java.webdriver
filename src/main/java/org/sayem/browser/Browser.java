package org.sayem.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.element.Element;
import org.sayem.selenium.DelegatingElement;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by sayem on 08/02/17.
 */

public interface Browser<T extends WebDriver> {

    T driver();

    DateTimePicker dateTime();

    WebElement findElement(By by);

    DelegatingElement findElement(Supplier<By> by);

    List<DelegatingElement> findElements(Supplier<By> by);

    WebElement untilFound(By by);

    DelegatingElement untilFound(Supplier<By> by);

    Element element();
}
