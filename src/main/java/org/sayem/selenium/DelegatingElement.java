package org.sayem.selenium;

import org.openqa.selenium.WebElement;

/**
 * Created by sayem on 08/02/17.
 */
public class DelegatingElement extends DelegatingWebElement {

    DelegatingElement(WebElement delegate) {
        super(delegate);
    }

    @Override
    public String toString() {
        String tagName = delegate.getTagName();
        return "[DelegatingElement: " + (tagName.equals("input") ?
                delegate.getAttribute("value") : tagName.equals("img") ?
                delegate.getAttribute("src") : delegate.getText()) + "] wrapping " + delegate;
    }
}
