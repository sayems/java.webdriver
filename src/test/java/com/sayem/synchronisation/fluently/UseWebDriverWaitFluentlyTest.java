package com.sayem.synchronisation.fluently;

import com.sayem.webdriver.examples.Driver;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class UseWebDriverWaitFluentlyTest {

    @Test
    public void wait5Seconds(){

        WebDriver driver = Driver.get("http://compendiumdev.co.uk");

        long currTime = System.currentTimeMillis();

        try{

            /* this will ignore the thrown exception in the apply */
            new WebDriverWait(driver, 1).
                    pollingEvery(100, TimeUnit.MILLISECONDS).
                    ignoring(IllegalStateException.class).
                    withTimeout(5, TimeUnit.SECONDS).
                    withMessage("See I told you a Timeout Happened").until(
                        new ExpectedCondition<Boolean>() {
                            @Override
                            public Boolean apply(WebDriver webDriver) {
                                throw new IllegalStateException();
                            }
                        }
                    );

            fail("A time out exception should have been thrown");

        }catch(TimeoutException e){
            assertTrue(e.getMessage().contains("See I told you a Timeout Happened"));
        }

        long nowTime = System.currentTimeMillis();
        System.out.println("Timeout calculated as " + (nowTime - currTime));

        assertTrue((nowTime - currTime) >= 5000);

    }

}
