package org.sayem.webdriver.function;

/**
 * Function interface which accepts three parameters and returns no value.
 *
 * @param <T> the first parameter
 * @param <U> the second parameter
 * @param <V> the third parameter
 *            <p>
 *            Created by sayem on 10/05/15.
 */
@FunctionalInterface
@SuppressWarnings("UnusedDeclaration")
public interface TriConsumer<T, U, V> {

    /**
     * Consumes the three specified parameters.
     *
     * @param v the first parameter
     * @param u the second parameter
     * @param v the third parameter
     */
    void accept(T t, U u, V v);
}
