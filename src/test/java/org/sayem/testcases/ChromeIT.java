package org.sayem.testcases;

import org.sayem.TestBase;
import org.sayem.pages.HomePage;
import org.testng.annotations.Test;

public class ChromeIT extends TestBase {

    @Test
    public void googleSearchTest(){
        new HomePage(getDriver())
                .googleSearch();

    }
}


