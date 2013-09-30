package com.sayem.pageobjects;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object representing github home page.
 *
 * @author mlipski
 */
public class GitHubHomePage extends GitHubPage<GitHubHomePage> {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.titleContains("GitHub · Build software better, together.");
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public GitHubLoginPage goToLoginPage() {
		return new GitHubLoginPage().openPage(GitHubLoginPage.class);
	}

	public GitHubHomePage open() {
		return new GitHubHomePage().openPage(GitHubHomePage.class);
	}

}
