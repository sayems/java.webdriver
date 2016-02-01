package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

/**
 * Created by sayem on 1/31/16.
 */
public class BrokenImageTest extends TestBase{

    @Test
    public void brokenImageTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.brokenImage()
                .brokenImage();
    }

    @Test
    public void brokenImagesTest(){
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.brokenImage()
                .brokenImages();
    }
}
