package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitTest extends DriverBase {

    @Test
    public void willFailWhenNoWait() throws Exception {
        WebDriver driver = getDriver();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Milk!");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        // expected: Milk - Wikipedia 
        WebElement r = driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[3]/div/div/h3"));
        System.out.println("result: " + r.getText());
    }
    
     @Test
    public void willPass() throws Exception {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Milk!");
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
       
        // expected: Milk - Wikipedia 
        WebElement r = driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[3]/div/div/h3"));
        System.out.println("result: " + r.getText());
    }
}