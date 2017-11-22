package com.lazerycode.selenium.tests.pageobjects.sample;

import static org.fest.assertions.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

import com.lazerycode.selenium.DriverBase;

public class DynamicControlsTest extends DriverBase {
	private DynamicControlPage page;

	@Before
	public void setUp() throws Exception {
		page = new DynamicControlPage(getDriver());
	}

	@Test
	public void test() throws InterruptedException {
		page.remove();
		assertThat(page.getMessage()).isEqualTo("It's gone!");
		
		page.add();
		assertThat(page.getMessage()).isEqualTo("It's back!");
	}
	
	
	@Test
	public void test2() throws Exception {
		// message element가 계속 있는 상태라면...
		page.remove();
		page.messageShouldBe("It's gone!");
	}


}
