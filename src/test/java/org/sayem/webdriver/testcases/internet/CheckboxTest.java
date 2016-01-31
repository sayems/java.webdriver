package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

public class CheckboxTest extends TestBase{

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
    public void checkboxTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.checkboxes()
                .selectCheckbox();
    }
}
