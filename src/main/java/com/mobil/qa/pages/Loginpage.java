package com.mobil.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobil.qa.base.Testbase;

public class Loginpage extends Testbase{
	
	//Pagefactory /object repository;

		@FindBy(name = "txtUserID")
		WebElement username;
		
		@FindBy(name = "txtPassword")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginbutton;
		
		//initiatizing page obects
		public Loginpage() {
			
			
			PageFactory.initElements(driver, this);//instead of this we can use login page also
		}
		
		
		//ACTIONS
		public String validateloginpagetitle() {
			
			return driver.getTitle();
		}
		
		public Boolean validateloginbutton() {
			
			return loginbutton.isDisplayed();
		}
		
		public Homepage login(String un, String  pwd) {
			
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginbutton.click();
			
			return new Homepage();
		}
	

}
