package org.sayem.webdriver.function;

/**
 * Created by sayem on 10/05/15.
 */
public interface QuadConsumer<T, U, V, Z> {
    void accept(T t, U u, V v, Z z);
}

