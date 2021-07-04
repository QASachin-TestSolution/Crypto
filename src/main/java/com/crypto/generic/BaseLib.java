package com.crypto.generic;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseLib {
	
public	static WebDriver driver;
public	static Properties prop;
public static Logger logger;
public static Logger logger2;
	
	public BaseLib()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\sachin\\eclipse-workspace\\Crypto\\src\\main\\java\\com\\crypto\\generic\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
//	@BeforeClass
//	
//	public void setup() {
//		
//	}
	
	
	@BeforeMethod
	public void preCondition() throws InterruptedException 
	{
	logger2 = Logger.getRootLogger();	
	logger=Logger.getLogger("devpinoyLogger");
		
    PropertyConfigurator.configure("log4j.properties");
	String browsername =prop.getProperty("browser");
	String url=	prop.getProperty("url");
	driver=BrowserFactory.LaunchBrowser(browsername);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.navigate().to(url);
	}

	@AfterMethod
	public void postCondition()
	{
	    driver.quit();
	   
	}}
//	
//
