package org.sayem.webdriver.testcases;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.HomePage;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase{

    /***
     * You can override browser and URL
     * Example, System.setProperty("browser", "firefox")
     */

    @Test
    public void dropdownTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.goToDropdownPage()
                .selectDropDown();
    }
}
