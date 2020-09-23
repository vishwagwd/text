package com.mobil.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.mobil.qa.base.Testbase;
import com.mobil.qa.pages.Homepage;
import com.mobil.qa.pages.Loginpage;
import com.mobil.qa.pages.Printpopuppage;
import com.mobil.qa.util.Testutil;



public class PrintpopuppageTest extends Testbase {
	Loginpage Logpage;
	Homepage homepage;
	Printpopuppage printpopuppage;
	String sheetName ="Test";
	
	
	public PrintpopuppageTest() {
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		
		initialization();
		Logpage = new Loginpage();
		homepage=Logpage.login(prop.getProperty("username"), prop.getProperty("password"));
		printpopuppage = homepage.clickontoday();
	}
	
	
	@Test
	
	public void verifyprintpopuppagetitletest() {
		
		String popuppagetitle=homepage.verifyhomepagetitle();
		
		Assert.assertEquals(popuppagetitle, "Daily Time Entry");
	}
	
	
	@DataProvider
	public Object[][] getmobildata() {
		Object[][] data =Testutil.getTestdata(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getmobildata")
	
	public void createmobilproentrytest(String project, String job, String task, String time, String diary) {
		
		//printpopuppage.createmobilproentry("Administration","General Administration","MailChecking, MobilPro Entry", "0.75", "entry");
		printpopuppage.createmobilproentry(project,job, task, time, diary);
		
			
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
