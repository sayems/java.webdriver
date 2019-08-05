package org.sayem.browser;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.function.Supplier;

/**
 * Created by sayem on 08/02/17.
 */
public interface Adapter<T extends WebDriver> {

    Browser<T> get();
}
