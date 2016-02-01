package org.sayem.webdriver.pages.internet;

import com.jayway.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.selectors.CssSelector;
import org.sayem.webdriver.selenium.Browser;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

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
        String image = browser.findElements(CssSelector.BROKEN_IMAGE)
                .map(s -> s.getAttribute("src"))
                .findFirst().get();

        response = given().get(image).then().extract().response();
        if (200 != response.getStatusCode()) {
            System.out.println(image + " gave a response code of " + response.getStatusCode());
        }
        return this;
    }

    public BrokenImagePage brokenImages() {
        List<WebElement> links = browser.findElements(By.cssSelector(".example>img"));
        String jpg;

        for (WebElement link : links) {
            jpg = link.getAttribute("src");
            response = given().get(jpg).then().extract().response();

            if (200 != response.getStatusCode()) {
                System.out.println(jpg + " gave a response code of " + response.getStatusCode());
            }
        }
        return this;
    }
}
