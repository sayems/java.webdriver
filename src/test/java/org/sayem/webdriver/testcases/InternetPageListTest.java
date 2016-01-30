package org.sayem.webdriver.testcases;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.InternetPage;
import org.testng.annotations.Test;

public class InternetPageListTest extends TestBase{

    /***
     * You can override browser and URL
     * Example, System.setProperty("browser", "firefox")
     */

    @Test
    public void dropdownTest(){
        System.setProperty("browser", "firefox");
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        InternetPage page = pageFactory(InternetPage.class);
        page.goToDrownPage()
                .selectDropDown();
    }
}
