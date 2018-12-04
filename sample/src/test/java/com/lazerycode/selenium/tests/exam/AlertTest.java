package com.lazerycode.selenium.tests.exam;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.api.Assertions.assertThat;

public class AlertTest extends DriverBase {

	static WebDriver driver;;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.test_url + "/javascript_alerts");
	}
	
	@Before
	public void setup() throws Exception {
	}
	
	
	@Test
	public void accept() {
		// 1. Click 'Click for JS Alert'

		// 2. Get the alert message
		//driver.switchTo().alert().getText();

		// 3. Click ok in the dialog
		// driver.switchTo().alert().accept();
	}
	
	@Test
	public void dimiss() {
		//driver.switchTo().alert().dismiss();
	}
	
	
	@Test
	public void prompt() {
		//driver.switchTo().alert().sendKeys("hello");
		//driver.switchTo().alert().accept();
	}
	
}
