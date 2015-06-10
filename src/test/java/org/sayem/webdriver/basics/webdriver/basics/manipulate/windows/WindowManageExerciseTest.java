package org.sayem.webdriver.basics.webdriver.basics.manipulate.windows;


import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.sayem.webdriver.basics.webdriver.examples.Driver;

import java.awt.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class WindowManageExerciseTest {

    @Test
    public void maximizeTheWindow() {
        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/bounce.html", false);

        driver.manage().window().maximize();
        Dimension fullScreenSize = driver.manage().window().getSize();
        java.awt.Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        String expected = "";

        expected = ((int) screenDimension.getWidth()) + " approx (90% tolerance) " + fullScreenSize.getWidth();
        assertTrue(expected, (screenDimension.getWidth() * 0.9) < fullScreenSize.getWidth());
        expected = ((int) screenDimension.getHeight()) + " approx (90% tolerance) " + (fullScreenSize.getHeight() * 0.9);
        assertTrue(expected, (screenDimension.getHeight() * 0.9) < fullScreenSize.getHeight());
    }

    @Test
    public void halfSizeTheWindow() {
        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/bounce.html");
        driver.manage().window().maximize();

        Dimension fullScreenSize = driver.manage().window().getSize();

        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth() / 2, fullScreenSize.getHeight() / 2));

        assertEquals("Width Half Equals", fullScreenSize.getWidth() / 2, driver.manage().window().getSize().getWidth());
        assertEquals("Height Half Equals", fullScreenSize.getHeight() / 2, driver.manage().window().getSize().getHeight());
    }

    @Test
    public void moveHalfSizeToCenterTheWindow() {
        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/bounce.html");
        driver.manage().window().maximize();

        Dimension fullScreenSize = driver.manage().window().getSize();
        Point pos = driver.manage().window().getPosition();

        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth() / 2, fullScreenSize.getHeight() / 2));

        driver.manage().window().setPosition(new Point(fullScreenSize.getWidth() / 4, fullScreenSize.getHeight() / 4));
    }

    @Test
    public void bounceTheWindow() {
        WebDriver driver = Driver.get("http://www.compendiumdev.co.uk/selenium/bounce.html");
        driver.manage().window().maximize();
        Dimension fullScreenSize = driver.manage().window().getSize();

        int changeWidth = fullScreenSize.getWidth();
        int changeHeight = fullScreenSize.getHeight();

        while (changeWidth > 100) {
            changeWidth = changeWidth - 50;

            if (changeHeight > 200)
                changeHeight = changeHeight - 50;

            driver.manage().window().setSize(new Dimension(changeWidth, changeHeight));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        int xDir = 10;
        int yDir = 10;

        Point position = driver.manage().window().getPosition();

        for (int bounceIterations = 0; bounceIterations < 1000; bounceIterations++) {

            position = position.moveBy(xDir, yDir);

            driver.manage().window().setPosition(position);

            if (position.getX() > (fullScreenSize.getWidth() - changeWidth)) {
                xDir = -10;
            }
            if (position.getX() < 0) {
                xDir = 10;
            }

            if (position.getY() > (fullScreenSize.getHeight() - changeHeight)) {
                yDir = -10;
            }
            if (position.getY() < 0) {
                yDir = 10;
            }
        }

    }
}
