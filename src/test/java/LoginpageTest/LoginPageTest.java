package LoginpageTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends Testbase {
	
	public static Loginpage loginpage ;
	public static Homepage homepage ;
	
	public LoginPageTest()  {
		super();	
	}
	@BeforeMethod
	public void setup() {
		init();
		loginpage = new Loginpage();	
	}
	
	@Test(priority=1)
	public void validateloginpagetitletest() {
		String title = loginpage.validateloginpagetitle();
Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	 
	@Test(priority=2)
      public void CRMlogoimagetest() {
		boolean flag = loginpage.valdiateCRMimage();
       Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest() {
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}
	
	@AfterMethod
	 public void teardown() {
		driver.quit();

	}
	
	
}
