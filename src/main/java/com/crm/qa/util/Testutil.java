package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.security.Credentials;

import com.crm.qa.base.Testbase;

public class Testutil extends Testbase {
	
	public static long Page_load_timeout =20;
	public static long implicity_wait =10;
	public static String Excelsheetpath = "C:\\Users\\MOHAMMED YASEEN KHAN\\eclipse-workspace\\framework2023\\src\\main"
			    + "\\java\\com\\crm\\qa\\testdata\\CRMdatasheet.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	
	
	public void switichtoframe() {
		driver.switchTo().frame("mainpanel");

	}

	public static Object[][] getTestData(String sheetname){
		FileInputStream file = null;
		try
		{
			file = new FileInputStream(Excelsheetpath);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}	
    try 
    {
	 book = WorkbookFactory.create(file);
    } catch (EncryptedDocumentException e) {
	  e.printStackTrace();
     } catch (IOException e) {
	e.printStackTrace();
  }
    
 sheet = book.getSheet(sheetname); 
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k] =	sheet.getRow(i+1).getCell(k).toString();
			}
		}

		return data;
		
	}
	
	
	public  static String Takescreenshot( ) {
		String currentpath = "C:\\Users\\MOHAMMED YASEEN KHAN\\eclipse-workspace\\"
				+ "framework2023\\screenshot" +System.currentTimeMillis()+ "png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	File file=	screenshot.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file, new File(currentpath));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return Takescreenshot();
	}
	 
	
	public void acceptAlert() {
		
	getDriver().switchTo().alert().accept();;
	}
	
	public void DismissAlert() {
		
		getDriver().switchTo().alert().dismiss();;
		}
	
}
