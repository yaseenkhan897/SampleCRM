package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.crm.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop ; 
	public static ExtentTest extenttest;
	public static String  tcname;
	public static ExtentReports extentreport;
	
	
	public Testbase()  {
		try {
		 prop = new Properties();
			FileInputStream fip = new FileInputStream("C:\\Users\\MOHAMMED YASEEN KHAN\\eclipse-workspace\\"
					+ "framework2023\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(fip);
			}	
			catch (FileNotFoundException e) {
	
				e.printStackTrace(); }
				catch (IOException e) {
					
					e.printStackTrace();
			}
				 
				
				
	}
	public void init() {

		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\MOHAMMED YASEEN KHAN\\"
					+ "eclipse-workspace\\framework2023\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			
			driver = new FirefoxDriver();
		}

				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(Testutil.implicity_wait, TimeUnit.SECONDS);
				driver.get("https://classic.freecrm.com/index.html");
			
		}
	

	
	@BeforeMethod
	public void BeforetestExecution(Method method) {
		
	 tcname =	method.getName();
	System.out.println("CURRENTLY EXECUTING TESTCASE NAME IS:"+tcname);
	extenttest = extentreport.startTest(tcname);


	}
	@AfterMethod
	public void AftertestExecution(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("TC is Passed :"+result.getName());
			extenttest.log(LogStatus.PASS, "TC is passed"+result.getTestName());
			
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("TC is Failed :"+result.getName());
			extenttest.log(LogStatus.FAIL, "TC is failed"+result.getTestName());
		String imagepath= Testutil.Takescreenshot();
		extenttest.addScreenCapture(imagepath);
			
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			System.out.println("TC is Skipped :"+result.getName());
			extenttest.log(LogStatus.SKIP, "TC is skip"+result.getTestName());
			 Testutil.Takescreenshot();
			
		}
		extentreport.endTest(extenttest);

	}
		
		@BeforeTest
		public void initreport() {
		 extentreport = new ExtentReports("C:\\Users\\MOHAMMED YASEEN KHAN\\"
		 		+ "eclipse-workspace\\framework2023\\src\\main\\java\\com\\crm\\qa\\extentreport\\report.html");

		}
		
		@AfterTest
		public void generateReport() {
			extentreport.flush();
			extentreport.close();
			
			
		}
		
		public static ExtentTest getExtenttest() {
			return extenttest;
		}

	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
