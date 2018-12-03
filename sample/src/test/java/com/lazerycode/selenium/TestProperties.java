package com.lazerycode.selenium;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

/**
 * Test Properties
 *
 * Chrome Driver: http://chromedriver.chromium.org/downloads
 */
public class TestProperties {

	public static String test_url = "https://the-internet.herokuapp.com";
	public static String firefox_binary_path = "E:\\Program Files\\firefox.exe";

	public static String chrome_driver_path;
	public static boolean headless;

	static {
		System.out.println(SystemUtils.OS_NAME);
		if(SystemUtils.OS_NAME.contains("Windows")) {
			chrome_driver_path = "src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe";
		}else if(SystemUtils.OS_NAME.contains("Mac")) {
			chrome_driver_path = "src//test//resources//drivers//chromedriver_mac64//chromedriver";
		}

		headless = Boolean.valueOf(System.getProperty("headless", "false"));
	}
}
