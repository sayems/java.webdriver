package com.sayem.drivermanager;


import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DriverManager {


    public static final String SELENIUM2_BASICS_DRIVER = "selenium2Basics.driver";

    public static WebDriver get() {

        String browserToUse="";

        if(System.getProperties().containsKey(SELENIUM2_BASICS_DRIVER)){
            browserToUse = System.getProperty(SELENIUM2_BASICS_DRIVER);
        }

        switch(browserToUse){
            case "opera":
                return new OperaDriver();
            case "firefox":
                return new FirefoxDriver();
            case "htmlunit":
                return new HtmlUnitDriver();
            default:
                return new HtmlUnitDriver();
        }

    }
}
