package org.sayem.webdriver.deprecated.keyboard;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;

/**
 * Hello world!
 */
public class App implements BrowserType {

    public static void main(String[] args) {


        System.out.println(Platform.getCurrent());
    }
}
