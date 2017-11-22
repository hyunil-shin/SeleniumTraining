package com.lazerycode.selenium.tests.pageobjects.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.tests.TestProperties;

public class DynamicControlPage {

	WebDriver driver;
	
	public DynamicControlPage(WebDriver d) {
		this.driver = d;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.test_url + "/dynamic_controls");
	}

	
	public void add() {
		WebElement button = driver.findElement(By.id("btn"));
		String buttonText = button.getText();
		if(buttonText.compareTo("Add") != 0) {
			return;
		}
		button.click();
		
		System.out.println("clicked add");
	}
	
	public void remove() {
		WebElement button = driver.findElement(By.id("btn"));
		String buttonText = button.getText();
		if(buttonText.compareTo("Remove") != 0) {
			return;
		}
		button.click();
		
		System.out.println("clicked remove");
	}
	
	public String getMessage() {
		// 일정 시간이 지나고 message element가 나타난다.
		return driver.findElement(By.id("message")).getText();
	}
	
	public void messageShouldBe(String expectedString) {
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	            	if(getMessage().compareTo(expectedString) == 0) {
	            		return true;
	            	}else {
	            		return false;
	            	}
	            }
	        });	

	}
}
