package com.lazerycode.selenium.tests.exam;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

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
	public void wrongUsernameOrPassword() {
	
		// login
		//driver.findElement().sendKeys("hello");
		//driver.findElement().sendKeys("hello");
		//driver.findElement().click();
	
		// then
		//String errorMsg = driver.findElement().getText();
		//assertThat(errorMsg).contains("");
	}
	
}
