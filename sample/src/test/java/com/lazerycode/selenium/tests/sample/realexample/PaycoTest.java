package com.lazerycode.selenium.tests.sample.realexample;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.DriverBase;

import static org.fest.assertions.api.Assertions.*;

/**
 * 
 *
 */
public class PaycoTest extends DriverBase {

	static WebDriver driver;
	
	static String url = "https://www.payco.com/";
	static String login_id = "";
	static String login_pw = "";
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(url);
		
		// login
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gnbGlobalInfo']/ul[2]/li[1]"))).click();

        String a = driver.getWindowHandle();
		driver.switchTo().window("PaycoLoginPopup");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
		driver.findElement(By.id("id")).sendKeys(login_id);
		driver.findElement(By.id("pw")).sendKeys(login_pw);
		driver.findElement(By.id("loginBtn")).submit();
		
		driver.switchTo().window(a);
		System.out.println(driver.getCurrentUrl());
	}
	
	@Before
	public void setup() throws Exception {
	}
	
	
	@Test
	public void checkPayments() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnb']/li[4]/a"))).click();
        WebElement paymentCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div[2]/div[1]/div[1]/dl/dd/span[1]/a/span[1]")));
        System.out.println("4월 결제내역: " + paymentCount.getText() + "건");
	}
	
}
