package com.javautility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class 
{
	public   WebDriver driver;
	public static WebDriver sdriver;
	public Generic gen;
	public  WebDriverUtils utils;

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("connecting to DB");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("close the DB connection");
	}
	// @Parameters("BROWSER")
	@BeforeClass
	public void beforeClass() throws Throwable
	{
		gen=new Generic(); 
		String browser = gen.dataDriven("browser");
		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if (browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		sdriver=driver;	

		utils=new WebDriverUtils(driver);

	}
	@AfterClass
	private void afterClass() 
	{

		utils.closebrowser();	

	}
	@BeforeMethod
	public void login() throws Throwable
	{
		Login_Page lp=new Login_Page(driver);
		driver.get(gen.dataDriven("URL"));
		utils.pageloadtime();
		utils.maximize();
		lp.loginapp();	
	}
	@AfterMethod
	public void logout()
	{
		Home_Page hp=new Home_Page(driver);
		hp.logoutapp();
	}
}
