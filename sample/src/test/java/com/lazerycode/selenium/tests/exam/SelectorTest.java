package com.lazerycode.selenium.tests.exam;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectorTest extends DriverBase {

    @Test
    public void test() throws Exception {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestProperties.test_url + "/tables");
        System.out.println(driver.getCurrentUrl());

        // Exmaple 2 > 마지막 행(Conway)의 Web Site 찾기
        //WebElement element = driver.findElement();
        //System.out.println(element.getText());
    }
}