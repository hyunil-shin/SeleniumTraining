package com.lazerycode.selenium;

import com.lazerycode.selenium.config.DriverFactory;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;

/**
 * test base 클래스
 *
 */
public class DriverBase {

    private static DriverFactory driverFactory;
    
    private static String chrome_driver = System.getProperty("webdriver.chrome.driver");	// this is null in Eclipse.

	@ClassRule
	public static ExternalResource resource = new ExternalResource() {
	
		boolean bInit = false;
		@Override
		protected void before() throws Throwable {
			if(bInit == true) {
				return;
			}
			bInit = true;
			
			// 최초 한번만 수행하는 동작들 (예, 로그인)
			System.out.println("external resource");
			driverFactory = new DriverFactory();
		}
			
		@Override
		protected void after() {
			if(chrome_driver == null) {
				driverFactory.quitDriver();
				bInit = false;
			}
			
		}
    };

    public static WebDriver getDriver() throws Exception {
        return driverFactory.getDriver();
    }
  
    public static void quitDriver() {
		driverFactory.quitDriver();
    }

    @After
    public void clearCookies() throws Exception {
        //getDriver().manage().deleteAllCookies();
    }
}