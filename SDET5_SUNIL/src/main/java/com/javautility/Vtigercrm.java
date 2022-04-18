package com.javautility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Vtigercrm 
{
	public static Properties testCase01() throws Throwable
	{
	FileInputStream fis=new FileInputStream("./data.properties");
	Properties p=new Properties();
    p.load(fis);
    return p;			
	}
	public static Cell excelSheet() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		Row ro=sheet.getRow(0);
		Cell co=ro.getCell(1);
		co.getStringCellValue();
		return co;
	}	
	
	public static String getorg() throws Throwable
	{
		return excelSheet().getStringCellValue();
	}
	
	public static String geturl() throws Throwable
	{
		return testCase01().getProperty("URL");

	}
	public static  String getusername() throws Throwable
	{
		return testCase01().getProperty("UN");
	}
    public static String getpassword() throws Throwable
    {
    	return testCase01().getProperty("PW");
    }
    public static String getfirstname() throws Throwable
    {
    	return testCase01().getProperty("firstName");
    }
    public static String getlastname() throws Throwable
    {
    	return testCase01().getProperty("lastName");
    }


}
