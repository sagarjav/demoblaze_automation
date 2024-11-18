package com.demoblaze.utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch (Exception e)
		{
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("BaseUrl");
		return url;
	}
	
	public String getValidUserName()
	{
		String Valid_UserName=pro.getProperty("VALID_USERNAME");
		return Valid_UserName;
	}
	
	public String getValidPassword()
	{
		String Valid_Password=pro.getProperty("VALID_PASSWORD");
		return Valid_Password;
	}
	
	public String getInValidUserName()
	{
		String InValid_UserName=pro.getProperty("INVALID_USERNAME");
		return InValid_UserName;
	}
	
	public String getInValidPassword()
	{
		String InValid_Password=pro.getProperty("INVALID_PASSWORD");
		return InValid_Password;
	}
	
	public String getChromeClasspath()
	{
		String ChromeClasspath=pro.getProperty("classpath");
		return ChromeClasspath;
	}
	
	

}
