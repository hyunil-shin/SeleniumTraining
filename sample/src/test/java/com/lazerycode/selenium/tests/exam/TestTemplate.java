package com.lazerycode.selenium.tests.exam;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

public class TestTemplate extends DriverBase {

	static WebDriver driver;;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.test_url + "/xxx");
	}
	
	@Before
	public void setup() throws Exception {
	}
	
	
	@Test
	public void test1() {
	}
	
	@Test
	public void test2() {
	}
	
}
