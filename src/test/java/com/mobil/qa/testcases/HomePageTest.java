package com.mobil.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobil.qa.base.Testbase;
import com.mobil.qa.pages.Homepage;
import com.mobil.qa.pages.Loginpage;
import com.mobil.qa.pages.Printpopuppage;

public class HomePageTest extends Testbase {
	Loginpage logpage;
	Homepage homepage;
	Printpopuppage printpopuppage;
	
	public HomePageTest() {
		
		super();
	}

	@BeforeMethod()
	
	public void setup() {
		
		initialization();
		logpage= new Loginpage();
		homepage=logpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	
	public void verifyhomepagtitletest() {
		
		String homepagetitle = homepage.verifyhomepagetitle();
		
		Assert.assertEquals(homepagetitle, "TimeEntry Calendar", "Homepage title not matched");
	}
	
	
	
	
	@Test(priority=2)
	
	public void clickontodaytest() {
		
		printpopuppage= homepage.clickontoday();
	}
	
	
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}
}
