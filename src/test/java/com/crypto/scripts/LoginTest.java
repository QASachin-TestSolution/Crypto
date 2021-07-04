package com.crypto.scripts;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crypto.actions.LoginActions;
import com.crypto.generic.BaseLib;
import com.crypto.pageobjects.Login;
import com.crypto.utils.Excelutils;



public class LoginTest extends BaseLib {
	
	static Login lp;
	static LoginActions la;

	static Excelutils ul;
	
			@BeforeMethod
			
			public void setup() {
				lp= new Login();
				
			}
			
		@Test(dataProvider = "Logindetails")	
			public  void logincheck(String un,String pwd) throws InterruptedException
			{
				
				logger.debug("              #             #                #                #           #            #           #              #");
				logger.debug("              #             #                #                #           #            #           #              #");
				logger.debug("              #             #                #                #           #            #           #              #");
				logger.debug("              #             #                #                #           #            #           #              #");
				                                                                                                           
			    logger.debug("--#----#----#--- New Test Suite has been started ---#-----#----#-------#-----");	
			    logger.debug("------------- Strting Login into application------------------------");
	            Thread.sleep(2000);
		        LoginActions.login(un,pwd);
//		        boolean res=LoginActions.VerifyLogo();
		        System.out.println("************************************************************************");
		        System.out.println("************************************************************************");
		        System.out.println("************************************************************************");
		        boolean result= LoginActions.VerifyLogo();
		        
//		        System.out.println(result);
				Thread.sleep(2000);
				if(result==true) {
					System.out.println("Test is passed and user logged in");
					assertEquals(true, result);
				}
			     
				else {
					System.out.println("Test is failed and user is not able to logged in");
					assertEquals(true, result);
				}
			
		 
	}
		
		@DataProvider(name="Logindetails")
		public Object[][] data() throws IOException {
			
			Excelutils Ex = new Excelutils("C:\\Users\\sachin\\eclipse-workspace\\Crypto\\data\\testdata (2).xlsx");
			int lastrow =Ex.getlastRow(0);
			int lastcol =Ex.getlastCol(0, 1);
			
			Object Logindata[][]=new Object[lastrow-1][lastcol];
			
		for (int i = 1; i < lastrow; i++) {
					
			for (int j = 0; j < 2; j++) {
						
			Logindata[i-1][j]=Ex.getdata(0, i, j);
			System.out.println(Ex.getdata(0, i, j));   //Note this line will return you username 		
					}
		  				
			}
		
	       return Logindata;
		}
}
