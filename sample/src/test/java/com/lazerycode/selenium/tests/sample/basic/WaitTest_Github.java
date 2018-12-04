package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitTest_Github extends DriverBase {
   
    
    @Test
    public void willFailWhenNoWait() throws Exception {
        WebDriver driver = getDriver();

        driver.get("https://www.github.com");

        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("selenium");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        WebElement r = driver.findElement(By.xpath("//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[3]/span"));
        System.out.println("result: " + r.getText());
    }
    
    @Test
    public void willPass() throws Exception {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.github.com");

        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("selenium");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        WebElement r = driver.findElement(By.xpath("//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[3]/span"));
        System.out.println("result: " + r.getText());
    }
    
 }