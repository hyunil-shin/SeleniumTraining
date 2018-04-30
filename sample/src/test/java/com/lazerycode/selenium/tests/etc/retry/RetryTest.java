package com.lazerycode.selenium.tests.etc.retry;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.lazerycode.selenium.DriverBase;

public class RetryTest extends DriverBase {

	
	@Rule public RetryRule retry = new RetryRule(3);
	
	
    @Test
	public void test() throws Exception {
        
    	String a = RandomStringUtils.randomNumeric(1, 3);
    	System.out.println("a: " + a);
    	if(a.length() == 1) {
    		fail("실패");
    	}
	}
}
