package org.sayem.webdriver.algorithm;

/**
 * Created by sayem on 10/15/16.
 */
@FunctionalInterface
public interface Reattempt {
    void attempt() throws Exception;
}
