package com.sayem.basics.interrogate.findby;

import com.sayem.webdriver.examples.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class FindByCSSSelectorBasicExercisesFullAnswersTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        //driver = new FirefoxDriver();
        driver = Driver.get("http://www.compendiumdev.co.uk" +
                "/selenium/find_by_playground.php");
    }




    @Test
    public void findByUsingCSSDataDriven(){

        class TestData{
            public String css;
            public String name;
            public String value;
            public String alt;

            public TestData(String css, String name,
                            String value, String alternativeTo) {
                this.css = css;
                this.name = name;
                this.value=value;
                this.alt = alternativeTo;
            }
        }

        List<TestData> dataItems = Arrays.asList(
                new TestData("#p31", "name", "pName31", "By.id(\"p31\")"),
                new TestData("*[id='p31']", "name", "pName31", "By.id(\"p31\")"),
                new TestData("[id='p31']", "name", "pName31", "By.id(\"p31\")"),
                new TestData("[id=\"p31\"]", "name", "pName31", "By.id(\"p31\")"),
                new TestData("[name='ulName1']", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("*[name='ulName1']", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("*[name=\"ulName1\"]", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("ul[name=\"ulName1\"]", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("ul[name='ulName1']", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("[name=\"ulName1\"]", "id", "ul1", "By.name(\"ulName1\")"),
                new TestData("div.specialDiv", "id", "div1","By.className(\"specialDiv\")"),
                new TestData(".specialDiv", "id", "div1","By.className(\"specialDiv\")"),
                new TestData("*.specialDiv", "id", "div1","By.className(\"specialDiv\")"),
                new TestData("li", "name", "liName1", "By.tagName(\"li\")")
        );

        WebElement element;

        for(TestData dataItem : dataItems){
            element = driver.findElement(By.cssSelector(dataItem.css));

            System.out.println(
                    String.format(
                            "Instead of %s use By.cssSelector(\"%s\")",
                            dataItem.alt, dataItem.css.replaceAll("\"", "\\\\\"")));


            assertThat(element.getAttribute(dataItem.name), is(dataItem.value));
        }
    }

    @AfterClass
    public static void closeBrowser(){
        //driver.quit();
    }
}
