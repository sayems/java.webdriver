package org.sayem.webdriver.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by sayem on 2/3/16.
 */
public class TestNGRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
