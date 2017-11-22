package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleExampleTest extends DriverBase {

	
	/**
	 * 기본 Steps
	 *  1. get driver (웹브라우져 실행)
	 *	2. open url
	 *	3. find element
	 * 	4. element.action()
	 *  5. get data of element and verify
	 */
	
    @Test
    public void googleCheeseExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // 실험 #1
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
       
        
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    
        assertTrue(driver.findElement(By.linkText("Cheese - Wikipedia")).isDisplayed());
        //driver.findElement(By.linkText("Cheese - Wikipedia1"));
    
        // 테스트 실패
        //assertTrue(driver.findElement(By.linkText("Cheese - Wikipedia1")).isDisplayed());
    }

    @Test
    public void googleMilkExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Milk!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	System.out.println("this is explicit wait    " + System.currentTimeMillis());
                return d.getTitle().toLowerCase().startsWith("milk!");
            }
        });

        // expected: Milk - Wikipedia 
        WebElement r = driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[3]/div/div/h3"));
        System.out.println("result: " + r.getText());
        
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }
}