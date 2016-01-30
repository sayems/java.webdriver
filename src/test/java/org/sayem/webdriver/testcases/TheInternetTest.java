package org.sayem.webdriver.testcases;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.HomePage;
import org.testng.annotations.Test;

public class TheInternetTest extends TestBase{

    /***
     * You can override browser and URL
     * Example, System.setProperty("browser", "firefox")
     *
     * You can run single test from command line
     * mvn clean install -Dbrowser=chrome -Dit.test=dropdownTest
     *
     * You can also run test with PhantomJS
     * mvn clean install -Dbrowser=phantomjs
     */

    @Test
    public void dropdownTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.dropdown()
                .selectDropDown();
    }

    @Test
    public void checkboxTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.checkboxes()
                .selectCheckbox();
    }

    @Test
    public void contextMenuTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.contextMenu()
                .selectContextMenu();
    }
}
