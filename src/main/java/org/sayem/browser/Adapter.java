package org.sayem.browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by sayem on 08/02/17.
 */
public interface Adapter<T extends WebDriver> {

    Browser<T> browser();
}
