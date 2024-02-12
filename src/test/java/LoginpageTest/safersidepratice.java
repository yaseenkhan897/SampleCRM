package LoginpageTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class safersidepratice {

	public static void main(String[] args) {
		ExtentReports extentreport = new ExtentReports("C:\\Users\\MOHAMMED YASEEN KHAN\\eclipse-workspace\\"
				+ "framework2023\\src\\main\\java\\com\\crm\\qa\\extentreport\\report.html");

	ExtentTest et=	extentreport.startTest("salam");
		et.log(LogStatus.PASS, "url is entered as www.gmai;.com");
		extentreport.endTest(et);
		extentreport.flush();
	}

}
