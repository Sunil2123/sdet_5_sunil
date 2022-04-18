package com.javautility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils 
{
	WebDriver driver;
	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void pageloadtime() 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	public void selectclassByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
				
				
	}
	public void selectclassByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);				
	}
	public void selectclassByVisibleTex(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);				
	}
	public void actionclass(WebElement target)
	{
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();;
	}
	public void closebrowser()
	{
		driver.close();
	}
	public void switchTowindow(String title) {
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String currentwindow=iterator.next();
			String currenttitle=driver.switchTo().window(currentwindow).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}
	public void alertaccept()
	{
		Alert act=driver.switchTo().alert();
        act.accept();
	}
	public void alertdismis()
	{
		Alert act=driver.switchTo().alert();
        act.accept();
	}
}


