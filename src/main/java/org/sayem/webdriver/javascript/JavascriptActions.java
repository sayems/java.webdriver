package org.sayem.webdriver.javascript;

import org.openqa.selenium.*;
import org.sayem.webdriver.selenium.DelegatingWebDriver;
import org.sayem.webdriver.selenium.Element;
import org.sayem.webdriver.selenium.ExplicitWait;
import org.sayem.webdriver.selenium.SearchScope;
import org.slf4j.Logger;

import java.util.function.Supplier;

import static org.sayem.webdriver.TestBase.driver;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by sayem on 10/05/15.
 * Set of commonly used actions invoked by executing JavaScript on a web page
 */
public class JavascriptActions extends DelegatingWebDriver
        implements ExplicitWait, SearchScope, JavascriptExecutor {

    public static final String NO_JQUERY_ERROR = "ReferenceError: $ is not defined";
    private static final String J_QUERY_IS_NOT_DEFINED = "JQuery is not defined";
    private static final String JS_ERROR = "JSError";
    Logger logger = getLogger(JavascriptActions.class);
    private WebDriver webDriver;

    public JavascriptActions(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    @Override
    public Element findElement(Supplier<By> by) {
        Element element = new Element(super.findElement(by.get()));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }

    @Override
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver();
        return javascriptExecutor.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver();
        return javascriptExecutor.executeAsyncScript(script, args);
    }

    public void click(String cssSelector) {
        executeScript("$('" + cssSelector + "').click()");
    }

    public void click(WebElement element) {
        executeScript("$(arguments[0])[0].click()", element);
    }

    public void focus(String cssSelector) {
        executeScript("$('" + cssSelector + "').focus()");
    }

    public void focus(WebElement element) {
        executeScript("$(arguments[0]).focus()", element);
    }

    public Object execute(String script) {
        // TODO: Get rid of this wait
        try {
            Object value = executeScript("return " + script);
            Thread.sleep(1000);
            return value;
        } catch (InterruptedException e) {
            logger.info("execute", e, false);
            return null;
        } catch (UnsupportedOperationException e) {
            logger.info("execute", e, true);
            return null;
        }
    }

    public void mouseOver(WebElement element) {
        executeScript("$(arguments[0]).mouseenter()", element);
    }

    public boolean isElementInViewPort(WebElement element) {
        return (Boolean) executeScript(
                "return ($(window).scrollTop() + 60 < $(arguments[0]).offset().top) && ($(window).scrollTop() "
                        + "+ $(window).height() > $(arguments[0]).offset().top + $(arguments[0]).height() + 60)",
                element);
    }

    public void scrollToElement(By elementBy) {
        try {
            executeScript(
                    "var x = $(arguments[0]);" + "window.scroll(0,parseInt(x.offset().top - 60));",
                    webDriver.findElement(elementBy));
        } catch (WebDriverException e) {
            if (e.getMessage().contains(NO_JQUERY_ERROR)) {
                logger.info(JS_ERROR, J_QUERY_IS_NOT_DEFINED, false);
            }
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            executeScript(
                    "var x = $(arguments[0]); " +
                            "window.scroll(0,parseInt(x.offset().top - 100));",
                    element
            );
        } catch (WebDriverException e) {
            if (e.getMessage().contains(NO_JQUERY_ERROR)) {
                logger.info(JS_ERROR, J_QUERY_IS_NOT_DEFINED, false);
            }
        }
    }

    public void scrollToElement(WebElement element, int offset) {
        try {
            executeScript(
                    "var x = $(arguments[0]);" +
                            "window.scroll(0,parseInt(x.offset().top - arguments[1]));",
                    element,
                    offset
            );
        } catch (WebDriverException e) {
            if (e.getMessage().contains(NO_JQUERY_ERROR)) {
                logger.info(JS_ERROR, J_QUERY_IS_NOT_DEFINED, false);
            }
        }
    }

    public void scrollElementIntoViewPort(WebElement element) {
        if (!isElementInViewPort(element)) {
            scrollToElement(element);
        }
    }
}
