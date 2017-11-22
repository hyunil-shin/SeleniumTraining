package com.lazerycode.selenium.tests.exam.travel;

import java.util.concurrent.TimeUnit;

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
		WebElement nav = driver.findElement(By.cssSelector("div.navbar.navbar-static-top.navbar-default"));
		nav.findElement(By.cssSelector("#li_myaccount")).click();
		nav.findElement(By.cssSelector("#li_myaccount > ul > li:nth-child(1) > a")).click();

		// login
		// css selector와 name selector 비교
		// #loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > div > div:nth-child(1) > input
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		//driver.findElement(By.cssSelector("#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button")).click();
		
		// login 확인
		String welcomeMsg = driver.findElement(By.cssSelector("#body-section > div > div.row > div > div.col-md-6.go-right.RTL > h3")).getText();
		assertThat(welcomeMsg).isEqualTo("Hi, Johny Smith");
		
		// hotel 예약으로 이동
		//findCss("nav.navbar.navbar-default.navbar-orange.hidden-xs > div > div > div > ul > li:nth-child(2) > a").click();
		WebElement nav2 = findCss("nav.navbar.navbar-default.navbar-orange.hidden-xs");
		nav2.findElement(By.partialLinkText("HOTELS")).click();
		String curUrl = driver.getCurrentUrl();
		assertThat(curUrl).isEqualTo("http://www.phptravels.net/hotels");
	}
	
	WebElement findCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}
	
}
