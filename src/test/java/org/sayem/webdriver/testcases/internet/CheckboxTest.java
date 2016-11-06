package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Chrome;
import org.sayem.webdriver.annotations.Url;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.THE_INTERNET;

public class CheckboxTest extends TestBase {

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

    @Chrome
    @Test
    public void checkboxTest() {
        HomePage page = pageFactory(HomePage.class);
        page.checkboxes()
                .selectCheckbox();
    }
}
