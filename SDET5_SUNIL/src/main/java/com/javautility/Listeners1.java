package com.javautility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.javautility.Base_Class;
import com.javautility.IAutoconstants;

public class Listeners1 extends Base_Class implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		System.out.println("test case started");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("test case sucessfull");
		
	}

	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot sh=(TakesScreenshot)sdriver;
		File fs=sh.getScreenshotAs(OutputType.FILE);
		File dest=new File(IAutoconstants.shpath+result.getMethod().getMethodName()+".png");
		try {
			Files.copy(fs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("test case skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
			}

}
