package com.lazerycode.selenium.tests.exam.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

import static org.fest.assertions.api.Assertions.*;

public class SortingTest extends DriverBase {

	static WebDriver driver;;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestProperties.test_url + "/tables");
	}
	
	@Before
	public void setup() throws Exception {
	}
	
	
	@Test
	public void test1() {
		//driver.findElement(By.cssSelector("#table1 > thead  th:nth-child(4)")).click();
		//driver.findElements(By.cssSelector("#table1 > thead > tr > th")).get(3).click();
		//driver.findElement(By.cssSelector("#table1 > thead > tr")).findElement(By.linkText("Due")).click();
		driver.findElement(By.xpath("//*[@id='table1']/thead/tr/th[4]/span")).click();
				
		
		List<WebElement> dues = driver.findElement(By.cssSelector("#table1 > tbody")).findElements(By.cssSelector("td:nth-child(4)"));
		List<Float> v = new ArrayList<>();
		for(WebElement e: dues) {
			System.out.println(e.getText());
			v.add(Float.valueOf(e.getText().substring(1)));
		}
		assertThat(v).isSorted();
	}
	
	@Test
	public void test2() {
	}
	
}
