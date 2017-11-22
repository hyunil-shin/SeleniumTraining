package com.lazerycode.selenium.tests.pageobjects.sample;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.lazerycode.selenium.DriverBase;

public class DisappearingGalleryTest extends DriverBase {
	private static DisappearingGalleryPage page;

	@Rule
	public RepeatingRule rule = new RepeatingRule();
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		page = new DisappearingGalleryPage(getDriver());
	}
	
	
	@Test
	//@Repeating(repetition = 10)
	public void test() {
	
		if(page.isGalleryVisible() == true) {
			// 테스트 실패
			System.out.println("1. gallery visible");
			page.refresh();
		
			// A
//			try {
//				Thread.sleep(5 * 1000);
//			} catch (InterruptedException e) {
//			}
			
			// B
			page.waitUntilInvisible();
			
			assertFalse(page.isGalleryVisible());
			System.out.println("no gallery");
		}else {
			// 테스트 성공
			System.out.println("1. no gallery");
			page.refresh();
			assertTrue(page.isGalleryVisible());
			System.out.println("gallery visible");
		}
		
	}
	
}
