package org.sayem.testcases;

import org.sayem.config.TestBase;
import org.sayem.pages.HomePage;
import org.testng.annotations.Test;

public class ChromeTest extends TestBase {

    @Test
    public void googleSearchTest(){
        new HomePage(getDriver())
                .googleSearch();
    }
}


