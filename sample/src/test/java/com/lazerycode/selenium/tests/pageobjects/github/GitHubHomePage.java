package com.lazerycode.selenium.tests.pageobjects.github;

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
		return ExpectedConditions.titleContains("GitHub");
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public GitHubLoginPage goToLoginPage() throws Exception {
		return new GitHubLoginPage().openPage(GitHubLoginPage.class);
	}

	public GitHubHomePage open() throws Exception {
		return new GitHubHomePage().openPage(GitHubHomePage.class);
	}

}
