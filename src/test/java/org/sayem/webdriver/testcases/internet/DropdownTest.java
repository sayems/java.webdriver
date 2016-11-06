package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Firefox;
import org.sayem.webdriver.annotations.Url;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.THE_INTERNET;

/**
 * Created by sayem on 1/31/16.
 */
public class DropdownTest extends TestBase {

    /***
     * You can override browser and URL
     * Example, System.setProperty("browser", "firefox")
     * <p>
     * You can run single test from command line
     * mvn clean install -Dbrowser=chrome -Dit.test=dropdownTest
     * <p>
     * You can also run test with PhantomJS
     * mvn clean install -Dbrowser=phantomjs
     */

    @Test
    @Firefox
    public void dropdownTest() {
        HomePage page = pageFactory(HomePage.class);
        page.dropdown()
                .selectDropDown();
    }
}
