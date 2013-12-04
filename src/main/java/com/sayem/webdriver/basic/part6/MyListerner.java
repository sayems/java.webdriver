package com.sayem.webdriver.basic.part6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class MyListerner extends AbstractWebDriverEventListener{


    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Hello");
    }

}
