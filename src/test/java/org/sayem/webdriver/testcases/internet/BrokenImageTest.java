package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Browser;
import org.sayem.webdriver.annotations.WebSite;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.*;

/**
 * Created by sayem on 1/31/16.
 */
public class BrokenImageTest extends TestBase{

    @Browser(browser = FIREFOX)
    @WebSite(value = THE_INTERNET)
    @Test
    public void brokenImageTest(){
        HomePage page = pageFactory(HomePage.class);
        page.brokenImage()
                .brokenImage();
    }
}
