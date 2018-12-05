package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FailedTest extends DriverBase {

    @Test
    public void timeout() throws Exception {
        WebDriver driver = getDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Cheese!");
        element.submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("aaabbb");
            }
        });
       
    }

    @Test
    public void noSuchElement() throws Exception {
        WebDriver driver = getDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q1"));
        element.clear();
        element.sendKeys("Cheese!");
        element.submit();
    }

    @Test
    public void no() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://dooray.com/join?utm_source=Dooray&utm_medium=Brand_main_bottom&utm_campaign=X");
        WebElement element = driver.findElement(By.cssSelector("#home-wrapper > section > join-tenant > form > div.form-wrap.dooray-setting-content > div.setting-content > div:nth-child(6) > div.menu-content > div:nth-child(2) > button"));
        System.out.println(element.getText());
        System.out.println(element.isEnabled());
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#home-wrapper > section > join-tenant > form > div.form-wrap.dooray-setting-content > div.setting-content > div:nth-child(6) > div.menu-content > div:nth-child(2) > button")));
    }
}