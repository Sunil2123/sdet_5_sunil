package com.javautility;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.github.javafaker.Faker;

public class Generic 
{
	/**
	 * @author ADMIN
	 * this method is read property from property_file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String dataDriven(String key) throws Throwable
	{
	FileInputStream fis=new FileInputStream(IAutoconstants.propath);
	Properties p=new Properties();
	p.load(fis);
	String s=p.getProperty(key);
	return s;	
	}
	/**
	 * @author ADMIN
	 * this is used to read the data
	 * @param path
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String dataDriven(String path,String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String s=p.getProperty(key);
		return s;	
		
	}
	/**
	 * @author ADMIN
	 * this is used for duplicating organisation name
	 * @return
	 */
	
	public String getOrgname() {
		Faker faker=new Faker();
		return faker.company().industry();
	
	}
	public String getfakephonenum()
	{
		Faker faker=new Faker();
		return faker.phoneNumber().phoneNumber();
	}
	/**
	 * this is used for generate random variable
	 * @return
	 */
	public int randomNumber()
	{
		Random r=new Random();
		int random = r.nextInt();
		return random;
	}
	/**
	 * @author ADMIN
	 * get today date
	 * @return
	 */
	public String getTodayDate()
	{
		Date date=new Date();
		return date.toString();
	}

}

