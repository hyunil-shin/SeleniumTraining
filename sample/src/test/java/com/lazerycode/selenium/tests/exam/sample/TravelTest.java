package com.lazerycode.selenium.tests.exam.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.DriverBase;

import static org.fest.assertions.api.Assertions.*;

public class TravelTest extends DriverBase {

	static WebDriver driver;;
	static String username = "user@phptravels.com";
	static String pw = "demouser";
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.phptravels.net/");
	}
	
	@Before
	public void setup() throws Exception {
	}
	

	@Test
	public void reserveHotel() throws Exception {

		// login
		WebElement nav = driver.findElement(By.cssSelector(".tbar-top"));
		nav.findElement(By.cssSelector("#li_myaccount")).click();
		nav.findElement(By.cssSelector("#li_myaccount > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		driver.findElement(By.cssSelector("#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button")).click();
		
		// login 확인
		String welcomeMsg = driver.findElement(By.cssSelector("#body-section > div > div.row > div > div.col-md-6.go-right.RTL > h3")).getText();
		assertThat(welcomeMsg).contains("Hi,");
	
		
		// hotel 예약으로 이동
		WebElement nav2 = driver.findElement(By.id("offcanvas-menu"));
		nav2.findElement(By.partialLinkText("HOTELS")).click();
		String curUrl = driver.getCurrentUrl();
		assertThat(curUrl).isEqualTo("http://www.phptravels.net/hotels");

		// search hotel
		// - modify check-in/out date
		WebElement modifySearchCondition = findCss("#body-section > div.header-mob > div > div > div.col-xs-1.text-center.pull-right.hidden-xs.ttu.opl20pdr20 > div > a > i");
		modifySearchCondition.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement checkInDate = findCss("#dpd1 > input");
        wait.until(ExpectedConditions.visibilityOf(checkInDate));
		checkInDate.clear();
		checkInDate.sendKeys("20/05/2018");
		WebElement checkOutDate = findCss("#dpd2 > input");
        wait.until(ExpectedConditions.visibilityOf(checkOutDate));
		checkOutDate.clear();
		checkOutDate.sendKeys("25/05/2018");
		WebElement searchBtn = findCss("#modify > div.container > div > form > div:nth-child(3) > div.bgfade.col-md-12.form-group.go-right.col-xs-12 > button");
		searchBtn.click();
		
		// select a hotel
		WebElement hotelList = findCss(".bgwhite.table.table-striped");
		wait.until(ExpectedConditions.visibilityOf(hotelList));
		WebElement tbody = hotelList.findElement(By.cssSelector("tbody"));
		List<WebElement> availableHotels = tbody.findElements(By.cssSelector("tr > td > div.col-md-8.col-xs-7.g0-left > div > h4 > a"));
		String wantToReserve = "Hyatt Regency Perth";
		for(WebElement e: availableHotels) {
			System.out.println("hotel: " + e.getText());
			if(e.getText().contains(wantToReserve)) {
				e.click();
				break;
			}
		}
		
		// verify
		WebElement detailPage = findCss("#body-section > div.header-mob > div > div > div.col-xs-8.col-sm-7 > div > span:nth-child(1) > strong");
		wait.until(ExpectedConditions.visibilityOf(detailPage));
		
		// 호텔 예약
	
	}
	
	WebElement findCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}
	
}
