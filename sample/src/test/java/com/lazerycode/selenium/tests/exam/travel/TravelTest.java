package com.lazerycode.selenium.tests.exam.travel;

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
	

	/**
	 * -> 로그인 (user@phptravels.com, demouser)
	 * -> HOTELS
	 * -> Swissotel Le Plaza Basel (any hotel)
	 * -> Delux Room (any type)
	 * -> No. Rooms 2
	 * -> Book Now
	 * -> Extra 모두 Yes
	 * -> No Coupon
	 * -> Pay on Arrival
	 * -> 확인
	 *    - Reserved message
	 *    - Total $346,50
	 * @throws InterruptedException 
	 */
	@Test
	public void reserveHotel() throws Exception {
		// nav 변수가 필요한 이유
//		WebElement nav = driver.findElement(By.cssSelector("div.navbar.navbar-static-top.navbar-default"));
//		nav.findElement(By.cssSelector("#li_myaccount")).click();
//		nav.findElement(By.cssSelector("#li_myaccount > ul > li:nth-child(1) > a")).click();

		// login
		// css selector와 name selector 비교
		// #loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > div > div:nth-child(1) > input
//		driver.findElement(By.name("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(pw);
//		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		//driver.findElement(By.cssSelector("#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button")).click();
		
		// login 확인
	//	String welcomeMsg = driver.findElement(By.cssSelector("#body-section > div > div.row > div > div.col-md-6.go-right.RTL > h3")).getText();
	//	assertThat(welcomeMsg).isEqualTo("Hi, Johny Smith");
	
		
		// hotel 예약으로 이동
		//findCss("nav.navbar.navbar-default.navbar-orange.hidden-xs > div > div > div > ul > li:nth-child(2) > a").click();
		WebElement nav2 = findCss("nav.navbar.navbar-default.navbar-orange.hidden-xs");
		nav2.findElement(By.partialLinkText("HOTELS")).click();
		String curUrl = driver.getCurrentUrl();
		assertThat(curUrl).isEqualTo("http://www.phptravels.net/hotels");

		// search hotel
		findCss("#body-section > div.header-mob.mt-25 > div > div > div:nth-child(6) > div > a").click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement d = findCss("#dpd2 > input");
        wait.until(ExpectedConditions.visibilityOf(d));
		d.clear();
		d.sendKeys("23/12/2017");
		findCss("#modify > div.container > div > form > div.row > div.bgfade.col-md-4.col-xs-12 > button").click();
		
		// select a hotel
		wait.until(ExpectedConditions.visibilityOf(findCss(".bgwhite.table.table-striped")));
		WebElement tbody = findCss("#body-section > div.container.offset-0 > div:nth-child(2) > div > table > tbody");
		//tr:nth-child(3) > td > div.col-md-8.col-xs-7.g0-left > div > h4 > a > b
		List<WebElement> hotelsFound = tbody.findElements(By.cssSelector("tr > td > div.col-md-8.col-xs-7.g0-left > div > h4 > a"));
		for(WebElement e: hotelsFound) {
			System.out.println("hotel: " + e.getText());
			if(e.getText().contains("Hyatt Regency Perth")) {
				e.click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(findCss("#ROOMS > div > div.panel-heading.go-text-right.panel-inverse.ttu")));
		
		// 호텔 예약
		findCss(".btn.btn-md.btn-action.btn-block.btn.chk.mob-fs10").click();
		String totalAmount = findCss("#displaytotal").getText();
		assertThat(totalAmount).contains("9,765");
	
	}
	
	WebElement findCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}
	
}
