package org.sayem.webdriver.testcases;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.pages.jquery.JQueryDemoPage;
import org.testng.annotations.Test;

/**
 * Created by sayem on 1/30/16.
 */
public class JQueryTest extends TestBase{

    @Test
    public void draggableTest(){
        System.setProperty("browser", "chrome");
        System.setProperty("seleniumUrl", "http://jqueryui.com/draggable/");

        JQueryDemoPage page = pageFactory(JQueryDemoPage.class);
        page.draggable();
    }
}
