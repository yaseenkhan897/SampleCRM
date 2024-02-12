package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

import junit.awtui.Logo;

public class Loginpage extends Testbase {
    

@FindBy(name = "username")
WebElement username;

@FindBy(name = "password")
WebElement password;

@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;


@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
WebElement signBtn;

@FindBy(xpath= "//img[contains(@alt,'Free CRM Softwa')]")
WebElement CRMlogo ;



public Loginpage() {
	PageFactory.initElements(driver, this);	
}

public String validateloginpagetitle() {
	return driver.getTitle();
}

public boolean valdiateCRMimage() {
	return CRMlogo.isDisplayed();
}

  public Homepage login(String un,String pswd) {
	username.sendKeys(un);
	password.sendKeys(pswd);
	loginBtn.click();

	return new Homepage();
}
  





}



