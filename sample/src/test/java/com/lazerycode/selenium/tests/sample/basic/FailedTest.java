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
    public void googleCheeseExample() throws Exception {
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
}