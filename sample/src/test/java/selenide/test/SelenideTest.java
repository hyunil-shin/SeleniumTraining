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
	
	@Test
	public void reserveHotel() throws Exception {
	
		// login
		SelenideElement nav = $(".tbar-top").should(visible);
		nav.$("#li_myaccount").click();
		nav.$("#li_myaccount > ul > li:nth-child(1) > a").click();
		$(By.name("username")).sendKeys(username);
		$(By.name("password")).sendKeys(pw);
		$(By.xpath("//button[contains(.,'Login')]")).click();
		SelenideElement welcomMsg = $(By.cssSelector("#body-section > div > div.row > div > div.col-md-6.go-right.RTL > h3"));
		welcomMsg.should(text("Hi,"));
		
	
		// move to hotel page
		$("#offcanvas-menu").find(By.partialLinkText("HOTELS")).click();
		String url = WebDriverRunner.getWebDriver().getCurrentUrl();
		assertThat(url).isEqualTo("http://www.phptravels.net/hotels");
	}
	
}
