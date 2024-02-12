package LoginpageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactpage;
import com.crm.qa.util.Testutil;

public class HomepageTest extends Testbase {
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Testutil util ;
	contactpage contactpage;
	
	
	public HomepageTest() {
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
	 
}


 @Test(priority=1)
   public void verifyhomepagetitleTest() {
	String homepagetitle = homepage.verifyhomepagetitle();
   Assert.assertEquals(homepagetitle, "CRMPRO");
}

   @Test(priority=2)
    public void verifyusernameTest() {
	util.switichtoframe();
	Assert.assertTrue(homepage.verifycorrectusername());
	

}
    @Test(priority=3)
   public void verifycontactlinkTest() {
	util.switichtoframe();
   contactpage=homepage.clickoncontactlink();
	
}


@AfterMethod
public void teardown() {
	driver.quit();

}

}
