package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.Testutil;

public class DeleteContactnames extends Testbase {

	
	
	@FindBy(xpath="//td[@class='datatitle']/input[@onclick='checkAll(this);' ]")
	WebElement Allcheckbox ;
	
	@FindBy(xpath="//input[@value='DO']")
	WebElement Do;
	
	
	public DeleteContactnames() {
		PageFactory.initElements(driver, this);
	}


	public void checkingAllcheckbox() {	
         Allcheckbox.click();
	}

	public void	DDdeletedchecked(String deletecheck){
		Select select = new Select(driver.findElement(By.xpath("//select[@name='do_action']")));
		//select.selectByIndex(1);
		select.selectByVisibleText(deletecheck);
	}
	
	
	public void	clickingonOK(){
		Do.click();
	}
}
