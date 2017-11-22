package selenide.test;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.fest.assertions.api.Assertions.*;

public class SelenideTest {

	static String username = "user@phptravels.com";
	static String pw = "demouser";
	
	@BeforeClass
	public static void beforeClass() throws Exception {
    	System.setProperty("selenide.browser", "chrome");
    	String chrome_driver_path = "src/test/resources/selenium_standalone_binaries/windows/googlechrome/64bit/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chrome_driver_path);
    	
		open("http://www.phptravels.net/");
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
		
		SelenideElement nav = $("div.navbar.navbar-static-top.navbar-default").should(visible);
		nav.$("#li_myaccount").click();
		nav.$("#li_myaccount > ul > li:nth-child(1) > a").click();

		$(By.name("username")).sendKeys(username);
		$(By.name("password")).sendKeys(pw);
		$(By.xpath("//button[contains(.,'Login')]")).click();
		
		// login 확인
		$("#body-section > div > div.row > div > div.col-md-6.go-right.RTL > h3").should(text("Hi, Johny Smith"));
		
		// hotel 예약으로 이동
		SelenideElement nav2 = $("nav.navbar.navbar-default.navbar-orange.hidden-xs");
		nav2.findElement(By.partialLinkText("HOTELS")).click();
		WebDriver driver = WebDriverRunner.getWebDriver();
		assertThat(driver.getCurrentUrl()).isEqualTo("http://www.phptravels.net/hotels");
	}
	
}
