package com.mobil.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mobil.qa.util.Testutil;
import com.mobil.qa.util.WebEventListener;

public class Testbase {
	
	
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventlistener;
	
	public Testbase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream( "F:\\vishwa\\text\\src\\main\\java\\com\\mobil\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\vishwa\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}else if(browsername.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "F:\\vishwa\\chromedriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TiIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}

