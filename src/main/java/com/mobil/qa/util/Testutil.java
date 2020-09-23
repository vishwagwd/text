package com.mobil.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.mobil.qa.base.Testbase;



public class Testutil extends Testbase {

	public static long PAGE_LOAD_TiIMEOUT = 20;
	public static long IMPLICIT_WAIT= 3;
	
	public static String test_sheet_Path="F:\\vishwa\\text\\src\\main\\java\\Text\\text\\gone.xlsx";
	
		static Workbook book;
		static Sheet sheet;
	 
	
	public static Object[][] getTestdata(String sheetName) {
	
		FileInputStream file = null;
		try {
			
				file = new FileInputStream(test_sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			try {
				book =  WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		sheet =book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i=0; i<sheet.getLastRowNum(); i++) {
				
				for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					System.out.println();
				}
			}
			return data;
	}


	public  static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrfile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
