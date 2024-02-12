package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Homepage extends Testbase{
	
	@FindBy(xpath = "//td[contains(text(),' mohammed')]")
    WebElement usernamelabel ;
	
	@FindBy(xpath = "//a[text()='Contacts']")
    WebElement contactlink ;
	@FindBy(xpath = "//a[text()='Contacts']")
    WebElement contactlink1 ;
	
	@FindBy(xpath = "//a[text()='Deals']")
    WebElement dealslink ;
	
	@FindBy(xpath = "//a[text()='Tasks']")
    WebElement tasklink ;
	
	@FindBy(xpath= "//a[text()='New Contact']")
	WebElement newcontact ;
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifycorrectusername() {
		return usernamelabel.isDisplayed();
	}
	
	public String verifyhomepagetitle() {
		return  driver.getTitle();

	}
	
	public contactpage clickoncontactlink() {
		contactlink.click();
        return new contactpage() ;
	}
	
	public Dealspage clickondealslink() {
		dealslink.click();
     return new Dealspage();
	}
	
	public Taskpage clickontasklink() {
		tasklink.click();
    return new Taskpage();

	}
	
	public void newcontactlink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlink1).build().perform();
		newcontact.click();
	}
	
	
}
