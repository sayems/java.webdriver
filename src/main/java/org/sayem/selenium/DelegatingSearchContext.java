package org.sayem.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sayem on 08/02/17.
 */
public class DelegatingSearchContext<T extends SearchContext>  //<1>
        implements ExplicitWait {
    final T delegate; // <2>

    DelegatingSearchContext(T delegate) {
        this.delegate = delegate;
    }

    @Deprecated
    @Override
    public List<WebElement> findElements(By by) {
        return delegate.findElements(by);
    }

    @Deprecated
    @Override
    public DelegatingElement findElement(By by) {
        return new DelegatingElement(delegate.findElement(by));
    }
}
