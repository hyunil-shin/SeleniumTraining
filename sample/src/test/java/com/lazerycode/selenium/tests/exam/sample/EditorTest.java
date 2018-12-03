package com.lazerycode.selenium.tests.exam.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

import static org.fest.assertions.api.Assertions.*;

public class EditorTest extends DriverBase {

	static WebDriver driver;
	WebElement body;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Before
	public void setup() throws Exception {
		driver.get(TestProperties.test_url + "/tinymce");
		driver.switchTo().frame("mce_0_ifr");
		body = driver.findElement(By.id("tinymce"));
		body.clear();
	}
	
	
	@Test
	public void typeHello() {
		// hello를 입력하고 hello 인지 확인한다.
		
		body.sendKeys("hello");
		assertThat(body.getText()).isEqualTo("hello");
	}
	
	@Test
	public void typeGoodbye() {
		// goodbye를 입력하고 goodbye인지 확인한다.
		
		body.sendKeys("goodbye");
		assertThat(body.getText()).isEqualTo("goodbye");
	}
	
	@Test
	public void numbering() {
		body.sendKeys("goodbye");
		body.sendKeys(Keys.ENTER);
		body.sendKeys("selenium");
		body.sendKeys(Keys.chord(Keys.CONTROL, "a"));		// text 선택
	
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("#mceu_10 > button")).click();
		
		
		driver.switchTo().frame("mce_0_ifr");
		List<WebElement> list = body.findElements(By.cssSelector("li"));
		for(WebElement e: list) {
			System.out.println("li: " + e.getText());
		}
		assertThat(list.get(0).getText()).isEqualTo("goodbye");
		assertThat(list.get(1).getText()).isEqualTo("selenium");
	}
	
	
}
