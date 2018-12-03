package com.lazerycode.selenium.tests.exam.sample;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

import static org.fest.assertions.api.Assertions.*;
import static org.junit.Assert.*;

public class LoginTest extends DriverBase {

	static WebDriver driver;;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Before
	public void setup() throws Exception {
		driver.get(TestProperties.test_url + "/login");
	}
	
	
	@Test
	public void fail() {
	
		// login
		driver.findElement(By.cssSelector("#username")).sendKeys("hello");
		driver.findElement(By.cssSelector("#password")).sendKeys("hello");
		driver.findElement(By.className("radius")).click();
	
		// then
		String msg = driver.findElement(By.id("flash")).getText();
		assertThat(msg).contains("invalid");
	}
	
	@Test
	public void pass() {
	
		// login
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		
	
		// then
		assertTrue(driver.findElement(By.cssSelector("#content > div > a > i")).isDisplayed());
		
		// logout
		driver.findElement(By.cssSelector("#content > div > a > i")).click();
		
		// then
		assertTrue(driver.findElement(By.className("radius")).isDisplayed());
		
	}
	
}
