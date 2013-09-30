package com.sayem.test;

import com.sayem.pageobjects.GitHubHomePage;
import com.sayem.pageobjects.GitHubLoginPage;
import org.junit.AfterClass;
import org.junit.Test;

import static com.sayem.setup.SeleniumDriver.getDriver;
import static org.fest.assertions.api.Assertions.assertThat;

public class GitHubLoginTest {

	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@Test
	public void should_not_login_with_wrong_credentials() {
		//given
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("user", "password");
		//then
		assertThat(loginPage.isLoginError()).isTrue();
	}
}
