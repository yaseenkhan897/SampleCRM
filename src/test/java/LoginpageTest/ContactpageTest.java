package LoginpageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactpage;
import com.crm.qa.util.Testutil;

public class ContactpageTest extends Testbase 
{
	
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Testutil util ;
	public static contactpage contactpage;
	public static String sheetname = "Contacts";

	public ContactpageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		init();
		 homepage=new Homepage();
		 loginpage = new Loginpage();
		  contactpage = new contactpage();
		 util = new Testutil();
		 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 util.switichtoframe();
		//contactpage= homepage.clickoncontactlink();
		 
			 
	}
	
	//@Test
	public void verifyfirstcheckboxtest() {
		contactpage.verifyfirstcheckbox();

	}
	
	//@Test
	public void verifysecondcheckboxtest() {
		contactpage.verifysecondcheckbox();

	}
	
	
	@DataProvider
	public Object[][] getCRMTestdata() {
	Object data[][]=	Testutil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(dataProvider = "getCRMTestdata")
	public void validatecreatenewcontact(String title , String FirstName , String LastName , String Company , String Email) {
		homepage.newcontactlink();
		contactpage.createnewcontactclick(title, FirstName, LastName, Company, Email);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
