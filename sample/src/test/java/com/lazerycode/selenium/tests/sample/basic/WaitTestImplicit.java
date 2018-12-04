package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.api.Assertions.assertThat;

public class WaitTestImplicit extends DriverBase {

    WebDriver driver;

    @Before
    public void setup() throws Exception {

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestProperties.test_url + "/dynamic_loading/2");
    }

    static String target = "#finish > h4";

    @Test
    public void willPass() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#start > button"));
        element.click();
        WebElement text = driver.findElement(By.cssSelector(target));
        System.out.println("text: " + text.getText());
        assertThat(text.getText()).contains("Hello");
    }

}
