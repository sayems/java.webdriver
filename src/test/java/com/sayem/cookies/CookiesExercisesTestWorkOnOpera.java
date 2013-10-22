package com.sayem.cookies;

import com.sayem.webdriver.examples.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

// this is different from CookiesExercisesTest,
// this has additional synchronisation to allow it to work on Opera
// but it seems opera doesn't add cookies if date is in the past, but that is what the getExpiry on a cookie in Opera returns
public class CookiesExercisesTestWorkOnOpera {


    private static WebDriver driver;
    public static final String SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS = "seleniumSimplifiedSearchNumVisits";
    private WebElement queryInput;
    private WebElement submitButton;

    @Before
    public void setup(){

        driver = Driver.get("http://compendiumdev.co.uk/selenium/" +
                        "search.php");

        //seleniumSimplifiedSearchLastVisit
        //seleniumSimplifiedSearchNumVisits
        //seleniumSimplifiedLastSearch

        //clear any cookies so it is
        // always the first time we have been here
        driver.manage().deleteAllCookies();

        refreshPageObjects();

    }

    private void refreshPageObjects(){
        queryInput = driver.findElement(By.name("q"));
        submitButton = driver.findElement(By.name("btnG"));
    }

    @Test
    public void doASearchAndCheckForCookies(){

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie aCookie : cookies){
            if(aCookie.getName().contentEquals(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS)){
                assertEquals(   "Should be my first visit",
                                String.valueOf(1),
                                aCookie.getValue());
            }
        }
    }

    @Test
    public void getCookieDirectly(){

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        waitForResultsToDisplay();

        Cookie aCookie = driver.manage().getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);

        assertEquals(   "Should be my first visit",
                        1,
                        Integer.parseInt(aCookie.getValue()));
    }

    public void waitForResultsToDisplay(){
        // need to do this otherwise Opera races ahead and throws null pointer exceptions on the cookies
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("resultList")));
        waitForCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
    }

    private Cookie waitForCookieNamed(String cookieName) {
        return new WebDriverWait(driver,10).until(cookieExistsNamed(cookieName));
    }



    private ExpectedCondition<Cookie> cookieExistsNamed(final String cookieName) {
        return new ExpectedCondition<Cookie>() {
            @Override
            public Cookie apply(WebDriver input) {
                return input.manage().getCookieNamed(cookieName);
            }
        };
    }


    private Cookie waitForCookieWithValue(String cookieName, String cookieValue) {
        return new WebDriverWait(driver,10).until(cookieWithValueExists(cookieName, cookieValue));
    }

    private ExpectedCondition<Cookie> cookieWithValueExists(final String cookieName, final String cookieValue){
        return new ExpectedCondition<Cookie>(){

            @Override
            public Cookie apply(WebDriver input) {
                Cookie cookie = waitForCookieNamed(cookieName);
                if(cookie!=null){
                    if(cookie.getValue().equals(cookieValue)){
                        return cookie;
                    }
                }
                return null;
            };
        };
    }





    @Test
    public void changeCookieVisitsCount(){

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        waitForResultsToDisplay();

        Cookie aCookie = driver.manage().
                                getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);

        assertEquals(   "Should be my first visit",
                        1,
                        Integer.parseInt(aCookie.getValue()));

        // clone cookie and set value to what I want
        Cookie aNewCookie = null;
        if(Driver.currentDriver == Driver.BrowserName.OPERA){
            // Opera does not return the correct expiry date for cookies
            // so work around it
            aNewCookie = new Cookie( aCookie.getName(),
                String.valueOf(42),
                aCookie.getDomain(),
                aCookie.getPath(),
                null,
                aCookie.isSecure());
        }else{
            aNewCookie = new Cookie( aCookie.getName(),
                    String.valueOf(42),
                    aCookie.getDomain(),
                    aCookie.getPath(),
                    aCookie.getExpiry(),
                    aCookie.isSecure());
        }

        int cookieCount = driver.manage().getCookies().size();
        driver.manage().deleteCookie(aCookie);
        driver.manage().addCookie(aNewCookie);
        assertEquals("we added the cookie correctly", cookieCount, driver.manage().getCookies().size());

        // do this after cookie processing otherwise Opera throws a stale element exception
        refreshPageObjects();

        queryInput.clear();
        queryInput.sendKeys("Cookie Changed Test");
        submitButton.click();

        waitForResultsToDisplay();
        waitForCookieWithValue(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS, "43");

        aCookie = driver.manage().getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
        assertEquals("I should be a frequent visitor", 43, Integer.parseInt(aCookie.getValue()));
    }

    @Test
    public void changeCookieVisitsCountUsingCookieBuilder(){

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        waitForResultsToDisplay();

        Cookie aCookie = driver.manage().getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
        assertEquals("Should be my first visit", 1, Integer.parseInt(aCookie.getValue()));



        Cookie aNewCookie = null;
        // clone cookie and set value to what I want
        if(Driver.currentDriver == Driver.BrowserName.OPERA){
            // opera driver returns the wrong expiry date for the cookie - it returns  Sat Jan 17 02:23:04 GMT 1970
            // but actual value was 2013/12/18 16:36
            // therefore we can't use the expiry date
            aNewCookie = new Cookie.Builder( aCookie.getName(), String.valueOf(29))
                                    .domain(aCookie.getDomain())
                                    .path( aCookie.getPath())
                                    /*.expiresOn(aCookie.getExpiry())*/
                                    .isSecure(aCookie.isSecure()).build();

            if(!aCookie.getExpiry().toString().contains("GMT 1970")){
                fail("Opera Driver may be returning the correct date for cookies now " + aCookie.getExpiry());
            }

        }else{
            aNewCookie = new Cookie.Builder( aCookie.getName(), String.valueOf(29))
                    .domain(aCookie.getDomain())
                    .path( aCookie.getPath())
                    .expiresOn(aCookie.getExpiry())
                    .isSecure(aCookie.isSecure()).build();
        }

        int cookieCount = driver.manage().getCookies().size();
        driver.manage().deleteCookie(aCookie);
        driver.manage().addCookie(aNewCookie);
        assertEquals("we added the cookie correctly", cookieCount, driver.manage().getCookies().size());

        refreshPageObjects();

        queryInput.clear();
        queryInput.sendKeys("Cookie Changed Test");
        submitButton.click();

        waitForResultsToDisplay();
        waitForCookieWithValue(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS, "30");

        aCookie = driver.manage().getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
        assertEquals("I should be a frequent visitor", 30, Integer.parseInt(aCookie.getValue()));
    }



    @Test
    public void changeCookieVisitsCountSimply(){

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        waitForResultsToDisplay();


        driver.manage().deleteCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
        driver.manage().addCookie(
                new Cookie.Builder(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS,
                                    String.valueOf(402)).
                        path("/selenium").build());

        refreshPageObjects();
        queryInput.clear();
        queryInput.sendKeys("Simple Cookie Change Test");
        submitButton.click();

        waitForResultsToDisplay();
        waitForCookieWithValue(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS, "403");

        Cookie aCookie = driver.manage().getCookieNamed(SELENIUM_SIMPLIFIED_SEARCH_NUM_VISITS);
        assertEquals("I should be a very frequent visitor", 403, Integer.parseInt(aCookie.getValue()));
    }





}
