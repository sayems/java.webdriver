package org.sayem.webdriver.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by sayem on 10/05/15.
 */
public class WaitForUrlToChange implements QuadConsumer<WebDriver, String, Integer, Integer> {

    public void accept(WebDriver driver, String originalUrl, Integer pollingTimeout, Integer pollingInterval) {
        new FluentWait<>(driver)
                .withTimeout(pollingTimeout, TimeUnit.SECONDS)
                .pollingEvery(pollingInterval, TimeUnit.SECONDS)
                .until((WebDriver driver1) -> !driver1.getCurrentUrl().equals(originalUrl));
    }
}
