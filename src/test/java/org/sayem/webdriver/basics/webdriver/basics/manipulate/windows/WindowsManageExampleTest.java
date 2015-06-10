package org.sayem.webdriver.basics.webdriver.basics.manipulate.windows;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import static junit.framework.Assert.assertEquals;

public class WindowsManageExampleTest {

    @Test
    public void manageWindow() {

        WebDriver driver = Driver.get(
                "http://www.compendiumdev.co.uk/selenium/frames");

        driver.manage().window().setPosition(new Point(10, 20));
        Point pos = driver.manage().window().getPosition();

        assertEquals(10, pos.getX());
        assertEquals(20, pos.getY());

        driver.manage().window().setSize(new Dimension(350, 400));
        Dimension winSizes = driver.manage().window().getSize();

        assertEquals(350, winSizes.getWidth());
        assertEquals(400, winSizes.getHeight());
    }
}
