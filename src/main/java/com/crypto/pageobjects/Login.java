package com.crypto.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crypto.generic.BaseLib;

public class Login extends BaseLib {
    
		
		@FindBy(xpath="//input[@id='loginform-identity']")
		WebElement username ;
		
		@FindBy(xpath="//input[@id='loginform-password']")
		WebElement password;
		
		@FindBy(name="login-button")
		WebElement Signinbtn;
		
		@FindBy(xpath= "//img[@class='light-logo']")
		WebElement logo;	
		

		public Login()
		{
			PageFactory.initElements(driver, this);
		}
		
		
		public WebElement UnTxtbx()
		{
			return username;
		}
		
		public WebElement PwdTxtbx()
		{
			return password;
		}
		
		public WebElement SigninBtn()
		{
			return Signinbtn;
		}
		
		
		public WebElement Logo()
		{
			return logo;
		}		
	
		
	}

