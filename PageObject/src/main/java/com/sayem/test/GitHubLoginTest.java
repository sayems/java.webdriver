package com.sayem.test;

import static com.example.setup.SeleniumDriver.getDriver;
import static org.fest.assertions.api.Assertions.assertThat;

import com.example.pageobjects.GitHubHomePage;
import com.example.pageobjects.GitHubLoginPage;
import org.junit.AfterClass;
import org.junit.Test;

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
