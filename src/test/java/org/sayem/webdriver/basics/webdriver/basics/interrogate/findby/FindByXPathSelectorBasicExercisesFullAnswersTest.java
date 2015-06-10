package org.sayem.webdriver.basics.webdriver.basics.interrogate.findby;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByXPathSelectorBasicExercisesFullAnswersTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage() {
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.quit();
    }

    @Test
    public void findByUsingXPathDataDriven() {

        class TestData {
            public String xpath;
            public String name;
            public String value;
            public String alt;

            public TestData(String xpath, String name,
                            String value, String alternativeTo) {
                this.xpath = xpath;
                this.name = name;
                this.value = value;
                this.alt = alternativeTo;
            }
        }

        List<TestData> dataItems = Arrays.asList(
                new TestData("//*[@id='p31']", "name", "pName31", "By.id(\"p31\")"),
                new TestData("//p[@id='p31']", "name", "pName31", "By.id(\"p31\")"),
                new TestData("//*[@name='ulName1']", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("//ul[@name='ulName1']", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("//*[starts-with(@name,'ulName1') and string-length(@name)=7]", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("//*[@class='specialDiv']", "id", "div1", "By.className(\"specialDiv\")"),
                new TestData("//div[@class='specialDiv']", "id", "div1", "By.className(\"specialDiv\")"),
                new TestData("//li", "name", "liName1", "By.tagName(\"li\")")
        );

        WebElement element;

        for (TestData dataItem : dataItems) {
            element = driver.findElement(By.xpath(dataItem.xpath));

            System.out.println(
                    String.format(
                            "Instead of %s use By.xpath(\"%s\")",
                            dataItem.alt, dataItem.xpath.replaceAll("\"", "\\\\\"")));


            assertThat(element.getAttribute(dataItem.name), is(dataItem.value));
        }
    }
}
