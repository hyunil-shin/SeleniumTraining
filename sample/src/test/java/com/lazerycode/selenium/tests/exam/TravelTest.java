package com.lazerycode.selenium.tests.exam;

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
		
		// hotel 예약 페이지로 이동

		// search hotel
		// - modify search condition and search
		
		// select a hotel
		
		// 호텔 예약
		// -> Book Now
		// -> Confirm this booking
		
		// Invoid 확인
		// - Total Amount
	}
}
