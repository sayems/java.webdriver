package org.sayem.webdriver.basics.webdriver.datadriven;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BasicDataDrivenTest {

    public static String url = "http://www.compendiumdev.co.uk/selenium/calculate.php";
    public static WebDriver driver;

    private String number1;
    private String function;
    private String number2;
    private String answer;

    public BasicDataDrivenTest(
            String num1, String function, String num2, String answer) {
        this.number1 = num1;
        this.function = function;
        this.number2 = num2;
        this.answer = answer;
    }


    @Parameters
    public static Collection data() {
        return Arrays.asList(
                new Object[][]{
                        {"1", "plus", "1", "2"},
                        {"2", "times", "2", "4"},
                        {"5", "divide", "2", "2.5"},
                        {"10", "minus", "4", "6"},
                }
        );
    }


    @BeforeClass
    static public void startServer() {
        driver = Driver.get(url);
    }

    @Test
    public void test_calculate_two_values() {
        driver.get(url);

        WebElement number1 = driver.findElement(By.id("number1"));
        number1.sendKeys(this.number1);

        WebElement number2 = driver.findElement(By.id("number2"));
        number2.sendKeys(this.number2);

        WebElement functionList = driver.findElement(By.id("function"));
        functionList.findElement(
                By.cssSelector(
                        "option[value='" + this.function + "']"))
                .click();

        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();

        WebElement answer = new WebDriverWait(driver, 10).
                until(ExpectedConditions.
                        visibilityOfElementLocated(
                                By.id("answer")));

        assertThat(answer.getText(), is(equalTo(this.answer)));

    }


    //If you want to see an example using Excel then visit
    //http://weblogs.java.net/blog/johnsmart/archive/2009/11/28/data-driven-tests-junit-4-and-excel

}
