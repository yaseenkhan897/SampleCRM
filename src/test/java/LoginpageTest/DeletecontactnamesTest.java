package LoginpageTest;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.DeleteContactnames;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactpage;
import com.crm.qa.util.Testutil;

public class DeletecontactnamesTest extends Testbase {
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Testutil util ;
	public static contactpage contactpage;
	public static String sheetname = "Contacts";
	public static String sheetname1 = "Dropdown";
	public static DeleteContactnames deletecontactname ;

	public DeletecontactnamesTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		init();
		 homepage=new Homepage();
		 loginpage = new Loginpage();
		  contactpage = new contactpage();
		 util = new Testutil();
		 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 util.switichtoframe();
		contactpage= homepage.clickoncontactlink();
	 deletecontactname = new DeleteContactnames();
	}
	
	
	
	@DataProvider
	public Object[][] getDropDown() {
	Object data[][]=	Testutil.getTestData(sheetname1);
		return data;
	}
	
	@Test(priority=2,dataProvider = "getDropDown")
	public  void ValidateDeletecontactnamesTest(String deletecheck) throws InterruptedException  {

		deletecontactname.checkingAllcheckbox();
		deletecontactname.DDdeletedchecked(deletecheck);
		deletecontactname.clickingonOK();
		util.acceptAlert();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().close();

	}
	
	
}
