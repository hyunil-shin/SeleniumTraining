package com.lazerycode.selenium.tests.pageobjects.github;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.lazerycode.selenium.DriverBase;

public abstract class GitHubPage<T> {

	private static final String BASE_URL = "https://github.com";
	private static final int LOAD_TIMEOUT = 30;
	private static final int REFRESH_RATE = 2;

	public T openPage(Class<T> clazz) throws Exception {
		T page = PageFactory.initElements(DriverBase.getDriver(), clazz);
		DriverBase.getDriver().get(BASE_URL + getPageUrl());
		System.out.println(BASE_URL + getPageUrl());
		ExpectedCondition pageLoadCondition = ((GitHubPage) page).getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) throws Exception {
		Wait wait = new FluentWait(DriverBase.getDriver())
				.withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

		wait.until(pageLoadCondition);
	}

	/**
	 * Provides condition when page can be considered as fully loaded.
	 *
	 * @return
	 */
	protected abstract ExpectedCondition getPageLoadCondition();

	/**
	 * Provides page relative URL/
	 *
	 * @return
	 */
	public abstract String getPageUrl();
}
