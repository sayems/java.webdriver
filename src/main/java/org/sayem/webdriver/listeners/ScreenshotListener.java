package org.sayem.webdriver.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static org.sayem.webdriver.TestBase.driver;

/**
 * Test listener to remove duplicate retried attempts (retry analyzer).
 * <p>
 * Created by sayem on 12/21/15.
 */
public class ScreenshotListener extends TestListenerAdapter {

    /**
     * Hash function to identify a test result.
     *
     * @param pTestResult
     * @return
     */
    private static int getId(final ITestResult pTestResult) {
        int id = pTestResult.getTestClass().getName().hashCode();
        id = 31 * id + pTestResult.getMethod().getMethodName().hashCode();
        id = 31 * id + (pTestResult.getParameters() != null ? Arrays.hashCode(pTestResult.getParameters()) : 0);
        return id;
    }

    private boolean createFile(File screenshot) {
        boolean fileCreated = false;

        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                try {
                    fileCreated = screenshot.createNewFile();
                } catch (IOException errorCreatingScreenshot) {
                    errorCreatingScreenshot.printStackTrace();
                }
            }
        }

        return fileCreated;
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    private void writeScreenshotToFile(WebDriver driver, File screenshot) {
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        } catch (IOException unableToWriteScreenshot) {
            System.err.println("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult failingTest) {
        try {
            WebDriver driver = driver();
            String screenshotDirectory = System.getProperty("screenshotDirectory", "target/screenshots");
            String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_" + failingTest.getName() + ".png";
            File screenshot = new File(screenshotAbsolutePath);
            if (createFile(screenshot)) {
                try {
                    writeScreenshotToFile(driver, screenshot);
                } catch (ClassCastException weNeedToAugmentOurDriverObject) {
                    writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
                }
                System.out.println("Written screenshot to " + screenshotAbsolutePath);
            } else {
                System.err.println("Unable to create " + screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            System.err.println("Unable to capture screenshot...");
            ex.printStackTrace();
        }
    }

    /**
     * Remove failed attempts (retry analyzer).
     * <p>
     * 1. Collect all passed test. If i encounter a failed test with at least one passed test i remove the failed test (That would cover case 2 and 3 from
     * above)
     * 2. Iterate over all failed test. If i encounter a failed test which previously failed i remove the current failed result. (That would cover case 3 and 4
     * actually). That also means i will only keep the first failed result if there are several failed results.
     */
    @Override
    public final void onFinish(final ITestContext pTestContext) {

        super.onFinish(pTestContext);

        // List of test results which we will delete later
        final List<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();

        // collect all id's from passed test
        final Set<Integer> passedTestIds = new HashSet<Integer>();
        for (final ITestResult passedTest : pTestContext.getPassedTests().getAllResults()) {
            passedTestIds.add(getId(passedTest));
        }

        final Set<Integer> failedTestIds = new HashSet<Integer>();
        for (final ITestResult failedTest : pTestContext.getFailedTests().getAllResults()) {

            // id = class + method + dataprovider
            final int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        // finally delete all tests that are marked
        for (final Iterator<ITestResult> iterator = pTestContext.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            final ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
                iterator.remove();
            }
        }

        // TNG: force SKIP state for skipped tests
        for (final ITestResult r : pTestContext.getSkippedTests().getAllResults()) {
            if (r.getStatus() != ITestResult.SKIP) {
                r.setStatus(ITestResult.SKIP);
            }
        }
    }
}