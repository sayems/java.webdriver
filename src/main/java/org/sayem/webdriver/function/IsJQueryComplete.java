package org.sayem.webdriver.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

/**
 * Created by sayem on 10/05/15.
 */
public class IsJQueryComplete implements Predicate<WebDriver> {

    @Override
    public boolean test(final WebDriver driver) {
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (Boolean) executor.executeScript("return jQuery.active == 0;");
    }
}
