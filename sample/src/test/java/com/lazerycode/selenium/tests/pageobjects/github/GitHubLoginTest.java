package com.lazerycode.selenium.tests.pageobjects.github;




import static org.junit.Assert.*;

import org.junit.Test;

import com.lazerycode.selenium.DriverBase;


public class GitHubLoginTest extends DriverBase {

	@Test
	public void should_not_login_with_wrong_credentials() throws Exception {
		//given
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		
		//when
		loginPage.login("user", "password");
		
		//then
		assertTrue(loginPage.isLoginError());
	}
}
