package com.sayem.webdriver.basic.part1;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Profiling {

    public static void main(String[] args) {
        // ProfilesIni, FirefoxProfile

        ProfilesIni prof  = new ProfilesIni();
        FirefoxProfile p = prof.getProfile("Selenium_User");
        FirefoxDriver driver = new FirefoxDriver(p);


        driver.close(); // close the firefox window
        driver.quit(); // close all ff windows associated with driver
    }

}
