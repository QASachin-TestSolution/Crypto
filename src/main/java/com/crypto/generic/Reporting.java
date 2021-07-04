package com.crypto.generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Reporting extends BaseLib implements ITestListener{
		
//		WebDriver driver;
		
		
		public void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile=new File(fileWithPath);
			//Copy file at destination
			Files.copy(SrcFile, DestFile);
			}
			
				
		public void onStart(ITestContext tr)
		{
			System.out.println("- -  --- -  - - - - - - -- - - - - - -  - -");
			System.out.println("- -  --- -  - - - - - - -- - - - - - -  - -");
			System.out.println("TestSuite has been started");
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//			String repName="Test-Report-"+timeStamp+".html";
			
		}
		public void onTestSuccess(ITestResult tr)
		{
			
			System.out.println(tr.getName() +"test has been passed8685");
        try {
				
				this.takeSnapShot(driver,"C:\\Users\\sachin\\eclipse-workspace\\Crypto\\Passedscreenshots\\"+tr.getName()+".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void onTestFailure(ITestResult tr) 
		{
			System.out.println(tr.getName()+"has been failed");
			
			
			try {
				
				this.takeSnapShot(driver,"C:\\Users\\sachin\\eclipse-workspace\\Crypto\\Failedscreenshots\\"+tr.getName()+".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			logger.addScreenCaptureFromPath("C:\\Users\\sachin\\eclipse-workspace\\Myhandydash\\Screenshots\\"+tr.getName()+".png");

		
		}
		
		public void onTestSkipped(ITestResult tr)
		{
			
			
		}
		
		public void onFinish(ITestContext tr)
		{
			System.out.println("TestExecuution has been finished ");
			
		}}


