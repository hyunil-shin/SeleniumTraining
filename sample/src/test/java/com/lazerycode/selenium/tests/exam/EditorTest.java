package com.lazerycode.selenium.tests.exam;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.tests.TestProperties;

import static org.fest.assertions.api.Assertions.*;

public class EditorTest extends DriverBase {

	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Before
	public void setup() throws Exception {
		driver.get(TestProperties.test_url + "/tinymce");
		driver.switchTo().frame("");
	}
	
	
	@Test
	public void typeHello() {
		// hello를 입력하고 hello가 입력되었는지 확인한다.
	}
	
	@Test
	public void typeGoodbye() {
		// goodbye를 입력하고 goodbye인지 확인한다.
	}
	
	@Test
	public void numbering() {
		// goodbye, selenium을 입력하고 numbering 적용
	}
	
	
}
