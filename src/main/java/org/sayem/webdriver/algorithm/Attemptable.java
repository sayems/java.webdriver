package org.sayem.webdriver.algorithm;

/**
 * Created by sayem on 10/05/15.
 */
public interface Attemptable<T> {
    T attempt() throws Exception;
}