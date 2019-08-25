package org.sayem.testcases;

import org.sayem.config.TestBase;
import org.sayem.webdriver.pages.HomePage;
import org.testng.annotations.Test;

public class SeleniumTest extends TestBase {

    @Test
    public void googleSearchTest() {
        new HomePage(webDriver())
                .googleSearch();
    }
}


