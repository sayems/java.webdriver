package org.sayem.webdriver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.Select;

import java.util.function.Supplier;

import static org.sayem.webdriver.TestBase.driver;

/**
 * Created by sayem on 1/20/16.
 */
public class Action extends DelegatingWebDriver
        implements ExplicitWait, SearchScope, HasInputDevices {

    private WebDriver driver;

    public Action(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public Element findElement(Supplier<By> by) {
        Element element = new Element(super.findElement(by.get()));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }

    @Override
    public Keyboard getKeyboard() {
        HasInputDevices t = (HasInputDevices) driver();
        waitForPageToLoad();
        return t.getKeyboard();
    }

    @Override
    public Mouse getMouse() {
        HasInputDevices t = (HasInputDevices) driver();
        waitForPageToLoad();
        return t.getMouse();
    }

    // Method to mouse hover to an element and click
    public void mouseOverAndClick(Supplier<By> from, Supplier<By> to) {
        Actions action = new Actions(driver());
        action.moveToElement(driver.findElement(from.get()))
                .moveToElement(driver.findElement(to.get())).click().build().perform();
    }

    // Method to select value from drop down based on visible text
    public void selectDropdown(Supplier<By> by, String value) {
        WebElement locator = driver.findElement(by.get());
        Select dropdown = new Select(locator);
        dropdown.selectByVisibleText(value);
    }

    //drag and drop function build.dragAndDrop
    public Actions dragDrop(Supplier<By> drag, Supplier<By> drop) {
        Actions build = new Actions(driver);
        build.dragAndDrop(driver.findElement(drag.get()), driver.findElement(drop.get())).perform();
        return build;
    }

    //drag and drop function using clickAndHold, moveToElement & release with Lint Text
    public Actions dragDropClickMoveRelease(Supplier<By> from, Supplier<By> to) {
        Actions build = new Actions(driver);
        build.clickAndHold(driver.findElement(from.get())).build().perform();
        build.moveToElement(driver.findElement(to.get())).build().perform();
        build.release(driver.findElement(to.get())).perform();
        return build;
    }

    //for hover and click using svg xpath element
    public void hoverAndClick(Supplier<By> by) {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(by.get())).build().perform();
        driver.findElement(by.get()).click();
    }

    public void rightClick(Supplier<By> by) {
        Actions hover = new Actions(driver);
        hover.contextClick(driver.findElement(by.get())).build().perform();
    }

    public void clickAndHold(String locator, int timeout) {

    }

    public void mouseHover(Supplier<By> by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by.get())).build().perform();
    }

    public void offsetClick(Supplier<By> by, int x, int y) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by.get()), x, y).click().build().perform();
    }

    //scrolling up using Actions class
    public void scrollUp() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();
    }

    //scrolling down using Actions class
    public void scrollDown() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    }

    public void pageDown() {
        Actions clicker = new Actions(driver);
        clicker.sendKeys(Keys.PAGE_DOWN);
    }

    public void pageUp() {
        Actions clicker = new Actions(driver);
        clicker.sendKeys(Keys.PAGE_DOWN);
    }

    public void pressCtrlKey() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.CONTROL).build().perform();
    }

    public void pressBackSpaceKey() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.BACK_SPACE).build().perform();
    }

    // Method to Press Enter Key
    public void pressEnterKey() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    // Method to double click
    public void doubleClick() {
        Actions action = new Actions(driver);
        action.doubleClick().build().perform();
    }


    // Method to press tab
    public void pressTab() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).build().perform();
    }

    // Method to press shift + tab
    public void pressShiftAndTab() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.SHIFT),
                Keys.chord(Keys.TAB)).build().perform();
    }
}

