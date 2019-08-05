package org.sayem.testcases;

import org.sayem.annotations.Firefox;
import org.sayem.browser.BrowserType;
import org.sayem.config.TestBase;
import org.sayem.annotations.Chrome;
import org.sayem.pages.HomePage;
import org.testng.annotations.Test;

public class ChromeIT extends TestBase {

    @Chrome
    @Test
    public void googleSearchTest(){
        new HomePage(getDriver())
                .googleSearch();
    }
}


