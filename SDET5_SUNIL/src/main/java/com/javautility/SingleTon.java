package com.javautility;

public class SingleTon 
{
	public static SingleTon obj;
	String name="sunil";
	int age=25;
	private SingleTon()
	{
		
	}
	public static SingleTon getInstanc()
	{	
		obj=new SingleTon();
		return obj;
	}
	
		
	

}
