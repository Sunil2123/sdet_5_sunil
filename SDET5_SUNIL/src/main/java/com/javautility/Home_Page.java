package com.javautility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	WebDriver driver;
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgtext;
		
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement sltcontsct;
	
	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement logoutimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutbtn;
	
	public WebElement getLogoutimg() 
	{
		return logoutimg;
	}
	public WebElement getLogoutbtn()
	{
		return logoutbtn;
	}

	public WebElement getSltcontsct() {
		return sltcontsct;
	}
	public WebElement getOrgtext() 
	{
		return orgtext;
	}
	
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void logoutapp()
	{
		WebDriverUtils utils=new WebDriverUtils(driver);
		utils.actionclass(logoutimg);
		utils.actionclass(logoutbtn);
		logoutbtn.click();
		
	}
	
	

}
