package org.sayem.webdriver.pages.internet;

import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;

import static com.jayway.restassured.RestAssured.given;
import static org.sayem.webdriver.selectors.CssSelector.*;

/**
 * Created by sayem on 1/31/16.
 */
public class BrokenImagePage {

    private Browser browser;
    private Response response;

    public BrokenImagePage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public BrokenImagePage brokenImage() {
        browser.findElements(BROKEN_IMAGE)
                .map(s -> s.getAttribute("src"))
                .forEach(s -> {
                    response = given().get(s).then().extract().response();
                    if (200 != response.getStatusCode()) {
                        System.out.println(s + " gave a response code of "
                                + response.getStatusCode());
                    }
                });
        return this;
    }
}
