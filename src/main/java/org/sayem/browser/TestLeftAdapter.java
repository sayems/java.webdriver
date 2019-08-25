package org.sayem.browser;

import com.smartbear.testleft.Driver;

public class TestLeftAdapter<T extends Driver> implements Browser<T> {
    private T driver;

    public TestLeftAdapter(T driver) {
        this.driver = driver;
    }

    @Override
    public T driver() {
        return driver;
    }
}
