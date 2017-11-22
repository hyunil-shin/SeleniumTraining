package com.lazerycode.selenium.tests.sample.realexample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lazerycode.selenium.DriverBase;

import static org.fest.assertions.api.Assertions.*;

public class BugsTest extends DriverBase {

	static WebDriver driver;;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.bugs.co.kr/");
	}
	
	@Before
	public void setup() throws Exception {
	}
	

	/**
	 * 검색 기능 테스트
	 * 
	 * 검색어: 거꾸로
	 * 자동완성 목록에서 거꾸로 강을 거슬러 오르는 저 힘찬 연어들처럼을 선택
	 * 검색 결과에서 거꾸로 강을 거슬러 오르는 저 힘찬 연어들처럼이 있는지를 확인
	 */
	@Test
	public void searchMusic() {
		
		driver.findElement(By.id("headerSearchInput")).sendKeys("거꾸로");
		List<WebElement> suggests = driver.findElement(By.id("suggest")).findElements(By.cssSelector("li"));
		for(WebElement e: suggests) {
			System.out.println(e.getText());
			if(e.getText().compareTo("거꾸로 강을 거슬러 오르는 저 힘찬 연어들처럼") == 0) {
			//if(e.getText().contains("거꾸로 강을 거슬러 오르는 저 힘찬 연어들처럼")) {
				e.click();
				// 첫번째 노래 제목 확인
				WebElement a = driver.findElement(By.xpath("//*[@id='DEFAULT0']/table/tbody/tr[1]/th/p/a/mark"));
				assertThat(a.getText()).isEqualTo("거꾸로 강을 거슬러 오르는 저 힘찬 연어들처럼");
				
				return;
			}
		}

		fail("Not found");
	}
	
}
