package com.mobil.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobil.qa.base.Testbase;
import com.mobil.qa.util.Testutil;

public class Printpopuppage extends Testbase {
	
	Testutil testutil;
	
	@FindBy(xpath="//*[@id=\"uscMenu_uscTimeEntryItems1_tblApproval\"]/tbody/tr/td[2]")
	
	WebElement dailypage;
	
	@FindBy(name="txtTetDiary")
	
	WebElement reason;
	
	@FindBy(name="cmdSave")
	
	WebElement save;
	
	@FindBy(name="btnPrintTimeSheet")
	
	WebElement print;
	

	public Printpopuppage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyprintpopuppagetitle() {
		
		return driver.getTitle();
	}
	
	
	public void createmobilproentry(String project,String job,String task,String time,String diary) {
		
		
		Select pro = new Select(driver.findElement(By.name("cboProject")));
		pro.selectByVisibleText(project);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Select jo = new Select(driver.findElement(By.name("cboJob")));
		jo.selectByVisibleText(job);
		
		Select tas= new Select(driver.findElement(By.name("cboTask")));
		tas.selectByVisibleText(task);
		
		
		driver.findElement(By.name("txtTetTime")).sendKeys(time);
		reason.sendKeys(diary);
		save.click();//comment
	}
	
	public void sendmail() {
		
		
	}
}
