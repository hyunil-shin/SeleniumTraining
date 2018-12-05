package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selectors extends DriverBase {

    /*
     *  다양한 방법으로 element에 접근할 수 있다.
     */
    @Test
    public void test() throws Exception {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestProperties.test_url + "/tables");
        System.out.println(driver.getCurrentUrl());
        
        // 방법 1. css selector
        WebElement element = driver.findElement(By.cssSelector("#table1 > thead > tr > th.header > span"));
        System.out.println(element.getText());
        
        // 방법 2. xpath
        element = driver.findElement(By.xpath("//*[@id='table1']/thead/tr/th[1]/span"));
        System.out.println(element.getText());
        
        // 방법 3. chain
        element = driver.findElement(By.id("table1")).findElement(By.cssSelector("thead > tr > th.header > span"));
        System.out.println(element.getText());
        
        // Get list
        System.out.println("Element List");
        List<WebElement> list = driver.findElements(By.cssSelector("#table1 > tbody > tr"));
        for(WebElement e: list) {
        	System.out.println(e.getText());
        }

        // 배열 활용
        List<WebElement> trList = driver.findElement(By.id("table1")).findElements(By.cssSelector("thead > tr > th.header"));
        System.out.println(trList.get(0).findElement(By.cssSelector("span")).getText());
        System.out.println(trList.get(1).findElement(By.cssSelector("span")).getText());
    }
}