package org.sayem.webdriver.function;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

/**
 * Created by sayem on 10/05/15.
 */

public class IsAlertPresent implements Predicate<WebDriver> {
    @Override
    public boolean test(final WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException nape) {
            return false;
        }
    }
}
