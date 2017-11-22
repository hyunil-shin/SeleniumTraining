package com.lazerycode.selenium.tests.exam.sample;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.tests.TestProperties;

import static org.fest.assertions.api.Assertions.*;

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
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();

		//sleep(5);		// for demo
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		assertThat(alertMsg).isEqualTo("I am a JS Alert");
		
		String result = driver.findElement(By.id("result")).getText();
		assertThat(result).isEqualTo("You successfuly clicked an alert");
	}
	
	@Test
	public void dimiss() {
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();

		//sleep(5);		// for demo
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		
		String result = driver.findElement(By.id("result")).getText();
		assertThat(result).contains("Cancel");
		
	}
	
	
	@Test
	public void prompt() {
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();

		//sleep(5);		// for demo
		driver.switchTo().alert().sendKeys("hello");
		driver.switchTo().alert().accept();
		
		String result = driver.findElement(By.id("result")).getText();
		assertThat(result).contains("hello");
		
	}
	
}
