package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Contactpageinformation extends Testbase {

	@FindBy(xpath ="//input[@value='New Contact']")
	WebElement newcontactclick;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@name='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@type ='submit' and  @value='Save']")
	WebElement save;
	
	public Contactpageinformation() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifynewcontactclick() {
		newcontactclick.click();
		
	}

	public void contactpageentrys(String fname,String lname) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		save.click();
		
	}
	
	
}

