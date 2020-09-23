package com.mobil.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobil.qa.base.Testbase;
import com.mobil.qa.pages.Homepage;
import com.mobil.qa.pages.Loginpage;

public class LoginPageTest extends Testbase{
	
	Loginpage logpage ;
	Homepage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		
		initialization();
		
		logpage  =  new Loginpage();
		
		
	}
	
	
	@Test(priority=1)
	
	public void loginpagetitletest() {
		
	String title = logpage.validateloginpagetitle();
	
	Assert.assertEquals(title, "User Login");
	
		
		
	}
	
	
	@Test(priority=2)
	
	public void loginbuttontest() {
		
		boolean button = logpage.validateloginbutton();
		Assert.assertTrue(button);
	}
	
	
	@Test(priority=3)
	
	
	public void login() {
		
		homepage=logpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}

}
