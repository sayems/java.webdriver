package org.sayem.webdriver.testcases.jquery;

import org.sayem.webdriver.TestBase;
import org.sayem.webdriver.annotations.Chrome;
import org.sayem.webdriver.annotations.Url;
import org.sayem.webdriver.pages.jquery.JQueryDemoPage;
import org.testng.annotations.Test;

import static org.sayem.webdriver.Repository.JQUERY_DEMO;

/**
 * Created by sayem on 1/30/16.
 */
public class JQueryTest extends TestBase {

    // TODO - In progress
    @Test
    @Chrome
    @Url(value = JQUERY_DEMO)
    public void draggableTest() {
        JQueryDemoPage page = pageFactory(JQueryDemoPage.class);
        page.draggable();
    }
}
