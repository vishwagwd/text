package com.mobil.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobil.qa.base.Testbase;

public class Homepage extends Testbase {
	
	
	@FindBy(xpath="//*[@id=\"uscMenu_uscTimeEntryItems1_tblApproval\"]/tbody/tr/td[1]')]")
	WebElement timeentrycalenderlabel;
	
	@FindBy(xpath="//*[@id=\"uscMenu_uscTimeEntryItems1_tblApproval\"]/tbody/tr/td[3]")
	WebElement weekly;
	
	@FindBy(className="ColToday1")
	WebElement today;
	
	public Homepage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyhomepagetitle() {
		
		return driver.getTitle();
	}
	
	
	public String clickonweekly() {
		
		weekly.click();
		
		return driver.getTitle();
	}
	
	
	public Printpopuppage clickontoday() {
		
		today.click();
		
		return new Printpopuppage();
	}
}
