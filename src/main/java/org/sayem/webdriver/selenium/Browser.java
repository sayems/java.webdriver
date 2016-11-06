package org.sayem.webdriver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.algorithm.Retry;
import org.sayem.webdriver.javascript.JavascriptActions;
import org.slf4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by sayem on 10/05/15.
 */
@SuppressWarnings("Duplicates")
public class Browser extends DelegatingWebDriver
        implements ExplicitWait, SearchScope {

    public static final Logger log = getLogger(Browser.class);
    private static final String VALUE2 = "value";
    private Action action;
    private JavascriptActions javascript;
    private MultiSelect select;

    public Browser(WebDriver driver) {
        super(driver);
        this.action = new Action(driver);
        this.javascript = new JavascriptActions(driver);
        this.select = new MultiSelect(driver);
    }

    @Override
    public Element findElement(Supplier<By> by) {
        Element element = new Element(super.findElement(by.get()));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }

    public Stream<Element> findElements(Supplier<By> by) {
        return super.findElements(by.get()).stream().map(Element::new);
    }

    public void textInput(Supplier<By> by, String value) {
        Retry retry = new Retry(5, 1, TimeUnit.SECONDS);
        try {
            retry.attempt(
                    () -> {
                        Element element = findElement(by);
                        element.clear();
                        element.sendKeys(value);
//                        assert value.equals(element.getAttribute("value"));
                    }
            );
        } catch (Exception e) {
            log.info("Failed to set text {}", value);
        }
    }

    public void setInputTextLambda(Supplier<By> by, String value) {
        Retry retry = new Retry(5, 1, TimeUnit.SECONDS);
        retry.attempt(
                () -> {
                    Element element = findElement(by);
                    element.clear();
                    element.sendKeys(value);
                    assert value.equals(element.getAttribute(VALUE2));
                }
        );
    }

    public String getInputText(Supplier<By> by) {
        return untilFound(by).getAttribute(VALUE2);
    }

    public void setCheckboxValue(Supplier<By> by, boolean value) {
        Element checkbox = untilFound(by);
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }

    public boolean isChecked(Supplier<By> by) {
        return untilFound(by).isSelected();
    }

    public void setRadio(Supplier<By> by, String value) {
        List<WebElement> radiobuttons = findElements(by.get());

        assert radiobuttons.size() >= 2;

        for (WebElement e : radiobuttons) {
            if (e.getAttribute(VALUE2).equals(value)) {
                e.click();
                return;
            }
        }
        throw new IllegalArgumentException(
                "unable to find element with value " + value);
    }

    public String getRadio(By by) {
        List<WebElement> radiobuttons = findElements(by);

        assert radiobuttons.size() >= 2;

        for (WebElement e : radiobuttons) {
            if (Boolean.valueOf(e.getAttribute("checked"))) {
                return e.getAttribute(VALUE2);
            }
        }
        return null;
    }

    public void delayFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }

    public DatePicker getDate() {
        return new DatePicker();
    }

    public JavascriptActions getJavascript() {
        return javascript;
    }

    public Action getAction() {
        return action;
    }

    public MultiSelect getSelect() {
        return select;
    }
}