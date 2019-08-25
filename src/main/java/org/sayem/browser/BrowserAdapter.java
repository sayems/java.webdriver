package org.sayem.browser;

/**
 * Created by sayem on 08/02/17.
 */
public class BrowserAdapter<T> implements Browser<T> {

    private T driver;

    BrowserAdapter(T driver) {
        this.driver = driver;
    }

    @Override
    public T driver() {
        return driver;
    }
}
