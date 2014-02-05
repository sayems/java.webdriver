package com.sayem;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.seleniumhq.jetty7.util.security.Credential;

import static org.openqa.selenium.remote.BrowserType.*;

/**
 * Hello world!
 *
 */
public class App implements BrowserType{

    public static void main( String[] args ){


        System.out.println(Platform.getCurrent());
    }
}
