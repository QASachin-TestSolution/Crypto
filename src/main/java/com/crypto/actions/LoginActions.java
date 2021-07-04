package com.crypto.actions;

import com.crypto.pageobjects.Login;

public class LoginActions {

	static Login lp;
	String un;
	
	public static void login(String un,String pwd)
	{
		lp=new Login();
		lp.UnTxtbx().sendKeys(un);
		lp.PwdTxtbx().sendKeys(pwd);
		lp.SigninBtn().click();
	}
	
	public static boolean VerifyLogo()
	 {
		
		try
		{
		 if(lp.Logo().isDisplayed()) {
		    	 
		 }
		}
		
		catch(Exception e)
		{
		return false;
		}
		
		return true;

	 }
	
}