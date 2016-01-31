package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

/**
 * Created by sayem on 1/31/16.
 */
public class DragAndDropTest extends TestBase{

    @Test
    public void checkboxTest(){
        System.setProperty("browser", "firefox");
        System.setProperty("seleniumUrl", "http://the-internet.herokuapp.com/");
        HomePage page = pageFactory(HomePage.class);
        page.dragAndDrop()
                .swapBoxes();
    }
}
