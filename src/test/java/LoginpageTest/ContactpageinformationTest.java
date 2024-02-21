/*package LoginpageTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.security.Credentials;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.listeners.ReRunFailed;
import com.crm.qa.pages.Contactpageinformation;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactpage;
import com.crm.qa.util.Testutil;
import com.relevantcodes.extentreports.LogStatus;

public class ContactpageinformationTest extends Testbase{
	
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Testutil util ;
	public static contactpage contactpage ; 
	public static Contactpageinformation contactpageinformation;
	

	public ContactpageinformationTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init();	
		homepage=new Homepage();
		 loginpage = new Loginpage();
		  contactpage = new contactpage();
		 util = new Testutil();
		 contactpageinformation = new Contactpageinformation();
		 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 util.switichtoframe();
		contactpage= homepage.clickoncontactlink();
		//util.switichtoframe();
		
		
		 
// IN this method I have used listeners and extentreport , where the testcase is failed it retry
	}
	@Test(retryAnalyzer=ReRunFailed.class)
	public void verifynewcontactclickTest() throws InterruptedException {
	String url=	prop.getProperty("url");
		contactpageinformation.verifynewcontactclick();
	contactpageinformation.contactpageentrys(prop.getProperty("firstname")
			,prop.getProperty("lastname"));
	
	//In this class I have used the extentreport to generate report
	
	getExtenttest().log(LogStatus.PASS, "The url has entered as  "+url);
	getExtenttest().log(LogStatus.PASS, "username hase entered as "+"firstname");
	getExtenttest().log(LogStatus.PASS, "username hase entered as "+"password");
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
*/