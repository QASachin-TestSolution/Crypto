package com.crypto.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
//import org.testng.Reporter;
public class BrowserFactory {

		public static WebDriver LaunchBrowser (String browserName)
		{

		WebDriver driver=null ;
		if (browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sachin\\eclipse-workspace\\Crypto\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("chrome launched",true);
		}


		else if (browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "./Exefiles/geckodriver.exe");
		driver = new FirefoxDriver();
		Reporter.log("firefox",true);


		}

		return driver;


		}
		}
	
	
