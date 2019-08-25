package org.sayem.testcases;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.RestConnectionRefused;
import com.smartbear.testleft.TestAgentRunException;
import org.sayem.config.TestBase;
import org.sayem.testleft.pages.HomePage;
import org.testng.annotations.Test;

public class TestLeftTest extends TestBase {

    @Test
    public void googleSearchTest() throws TestAgentRunException,
            RestConnectionRefused, HttpException, ApiException {
        new HomePage(driver())
                .googleSearch();
    }
}
