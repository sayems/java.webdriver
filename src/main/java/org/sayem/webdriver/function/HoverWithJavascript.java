package org.sayem.webdriver.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.BiConsumer;

/**
 * Takes a {@code WebDriver} and {@code WebElement} as input parameters and uses {@link JavascriptExecutor} to perform
 * a hover on the {@code WebElement}.
 * <p>
 * This lambda function is useful for executing clicks in situations where the native Selenium hover action fails
 * silently. That is, the hover action runs without throwing any {@code Exceptions}, but the element is
 * not actually hovered.
 * <p>
 * Created by sayem on 10/05/15.
 */
public class HoverWithJavascript implements BiConsumer<WebDriver, WebElement> {

    /**
     * Uses {@code JavascriptExecutor} with the specified driver to perform a hover on the specified element.
     *
     * @param driver  the {@code WebDriver} to use with {@code JavascriptExecutor} for performing the hover
     * @param element the {@code WebElement} to hover
     */
    public void accept(WebDriver driver, WebElement element) {

        String script = "if(document.createEvent) {" +
                "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initEvent( 'mouseover', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);" +
                "} else if( document.createEventObject ) {" +
                "arguments[0].fireEvent('onmouseover');" +
                "}";

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script, element);
    }
}
