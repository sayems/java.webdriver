package com.sayem.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object representing github login page.
 */
public class GitHubLoginPage extends GitHubPage<GitHubLoginPage> {

	@FindBy(id = "login_field")
	WebElement loginField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(name = "commit")
	WebElement commitButton;

	@FindBy(className = "flash-error")
	WebElement errorBox;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginField);
	}

	@Override
	public String getPageUrl() {
		return "/login";
	}

	public void login(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		commitButton.click();

	}

	public boolean isLoginError() {
		return errorBox.isDisplayed();
	}

	public String getErrorMessage() {
		return errorBox.getText();
	}
}
