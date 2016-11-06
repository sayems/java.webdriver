package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Firefox;
import org.sayem.webdriver.annotations.Safari;
import org.sayem.webdriver.annotations.Url;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.THE_INTERNET;

/**
 * Created by sayem on 1/31/16.
 */
public class BrokenImageTest extends TestBase {

    @Firefox
    @Test
    public void brokenImageTest() {
        HomePage page = pageFactory(HomePage.class);
        page.brokenImage()
                .brokenImage();
    }
}
