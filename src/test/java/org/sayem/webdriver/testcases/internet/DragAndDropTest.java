package org.sayem.webdriver.testcases.internet;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Chrome;
import org.sayem.webdriver.annotations.Url;
import org.sayem.webdriver.pages.internet.HomePage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.THE_INTERNET;

/**
 * Created by sayem on 1/31/16.
 */
public class DragAndDropTest extends TestBase {

    @Test
    @Chrome
    public void checkboxTest() {
        HomePage page = pageFactory(HomePage.class);
        page.dragAndDrop()
                .swapBoxes();
    }
}
