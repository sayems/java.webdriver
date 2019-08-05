package org.sayem.selenium;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by sayem on 08/02/17.
 */
public class DelegatingWebElement
        extends DelegatingSearchContext<WebElement>
        implements WebElement, WrapsElement {

    DelegatingWebElement(WebElement delegate) {
        super(delegate);
    }

    @Override
    public void click() {
        delegate.click();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return super.findElements(by);
    }

    @Override
    public DelegatingElement findElement(By by) {
        return super.findElement(by);
    }

    @Override
    public void submit() {
        delegate.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        delegate.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public String getTagName() {
        return delegate.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return delegate.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return delegate.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return delegate.isEnabled();
    }

    @Override
    public String getText() {
        return delegate.getText();
    }

    @Override
    public boolean isDisplayed() {
        try {
            return delegate.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public String getValue() {
        return delegate.getAttribute("value");
    }

    @Override
    public Point getLocation() {
        return delegate.getLocation();
    }

    @Override
    public Dimension getSize() {
        return delegate.getSize();
    }

    @Override
    public Rectangle getRect() {
        return delegate.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return delegate.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return delegate.getScreenshotAs(outputType);
    }

    @Override
    public WebElement getWrappedElement() {
        return delegate;
    }
}
