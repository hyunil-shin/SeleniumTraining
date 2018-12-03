package com.lazerycode.selenium.tests.exam;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.TestProperties;

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
		//driver.findElement().click();
	
		// Due 데이터를 array에 저장
		//List<WebElement> dues = driver.findElements()
		//List<Float> v = new ArrayList<>();
		
		// sorting 되었는지 확인
		//assertThat(v).isSorted();
	}
	
}
