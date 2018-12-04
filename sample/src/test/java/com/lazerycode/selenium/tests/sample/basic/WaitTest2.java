package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest2 extends DriverBase {

    WebDriver driver;
    
    @Before
    public void setup() throws Exception {
    	
    	driver = getDriver();
        driver.get(TestProperties.test_url + "/dynamic_loading/2");
    }

    static String target = "#finish > h4";
    
    @Test
    public void willFailWhenNoWait() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#start > button"));
        element.click();
        WebElement text = driver.findElement(By.cssSelector(target));
        System.out.println("text: " + text.getText());
        assertThat(text.getText()).contains("Hello");
    }

    @Test
    public void willPass_explicitWait() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#start > button"));
        element.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	WebElement text = driver.findElement(By.cssSelector(target));
                return text.getText().contains("Hello");
            }
        });
    }
    
    @Test
    public void willPass_explicitWait2() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#start > button"));
        element.click();
       (new WebDriverWait(driver, 10)).until(
    		   	ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(target), "Hello"));
    }
  
    @Test
    public void timeout() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#start > button"));
        element.click();
       (new WebDriverWait(driver, 2)).until(
    		   	ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
    }


}