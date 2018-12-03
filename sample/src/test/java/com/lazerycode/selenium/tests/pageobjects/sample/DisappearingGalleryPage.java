package com.lazerycode.selenium.tests.pageobjects.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.TestProperties;

import static org.junit.Assert.assertTrue;

public class DisappearingGalleryPage {
	
	WebDriver driver;
	
	public DisappearingGalleryPage(WebDriver d) {
		this.driver = d;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.test_url + "/disappearing_elements");

		// C
		WebElement homeBtn = driver.findElement(By.linkText("Home"));
		assertTrue(homeBtn.isDisplayed());
	}

	public void refresh() {
		System.out.println("refresh");
		driver.navigate().refresh();
		
		WebElement homeBtn = driver.findElement(By.linkText("Home"));
		assertTrue(homeBtn.isDisplayed());
	}

	public boolean waitUntilInvisible() {
		
		 return (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	            	System.out.println("apply");
	            	try {
	            		return !d.findElement(By.linkText("Gallery")).isDisplayed();
	            	}catch(NoSuchElementException e) {
	            		System.out.println("no such element");
	            		return true;
	            	}
	            }
	        });	
		 
	}
	
	public boolean isGalleryVisible() {
		
		WebElement galleryBtn;
		try {
			galleryBtn = driver.findElement(By.linkText("Gallery"));
		}catch(NoSuchElementException e) {
       		System.out.println("no such element");
			return false;
		}
		
		return galleryBtn.isDisplayed();
	}
	
}
