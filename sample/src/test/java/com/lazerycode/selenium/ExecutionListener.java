package com.lazerycode.selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * Maven 실행 시에만 적용된다.
 * 
 * @author NHNEnt
 *
 */
public class ExecutionListener extends RunListener {

	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		System.out.println("Number of testcases to execute : " + description.testCount());
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		System.out.println("Number of testcases executed : " + result.getRunCount());
	
		// 모든 테스트 종료 후 driver close 한다.
		DriverBase.quitDriver();
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		System.out.println("=================================");
		System.out.println("Starting execution of test case : "+ description.getMethodName());
	}

	/**
	 *  Called when an atomic test has finished, whether the test succeeds or fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception
	{
		System.out.println("Finished execution of test case : "+ description.getMethodName());
		System.out.println("=================================");
	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		System.out.println("Execution of test case failed : "+ failure.getMessage());
		screenshot(failure.getDescription());
	}

	/**
	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception
	{
		System.out.println("Execution of test case ignored : "+ description.getMethodName());
	}
	

	void screenshot(Description test) throws Exception{
		WebDriver driver = DriverBase.getDriver();
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String currentDir = System.getProperty("user.dir");
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    try {
	    	String png = currentDir + "\\target\\screenshots\\" + test.getMethodName() + timeStamp + ".png";
	        FileUtils.copyFile(scrFile, new File(png));
	        System.out.println("테스트 실패 scrrenshot: " + png);
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	  }
	
}
