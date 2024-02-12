package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class contactpage extends Testbase{

	@FindBy(xpath="//a[contains(text(),'azam khan')]")	
	WebElement firstcheckbox ;
	
	@FindBy(xpath = "//a[contains(text(),'mohammed khan')]")
	WebElement secondcheckbox;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(xpath = "//input[@type ='submit' and  @value='Save']")
	WebElement saveBtn ; 
	
	
	
	public contactpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyfirstcheckbox() {
		firstcheckbox.click();
	}
	
	public void verifysecondcheckbox() {
		secondcheckbox.click();
	
	}
	
	public void createnewcontactclick(String title , String ftname , String ltname , String comp , String Email) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		email.sendKeys(Email);
		saveBtn.click();
		
	}
	

}
