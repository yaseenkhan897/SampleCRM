package LoginpageTest;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class safersidepratice extends Testbase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MOHAMMED YASEEN KHAN\\"
				+ "eclipse-workspace\\framework2023\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("yaseenkhan");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Aazambhai@123");
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		WebElement iframe = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(iframe);
		
		
		WebElement contact = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contact.click();
		
		/*WebElement iframe_contact = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(iframe_contact);*/
		
		
		WebElement allcheck = driver.findElement(By.xpath("//td[@class='datatitle']/input[@onclick='checkAll(this);' ]"));
		allcheck.click();
		
		
			Select select = new Select(driver.findElement(By.xpath("//select[@name='do_action']")));
			//String value="Delete Checked";
			select.selectByIndex(1);
			WebElement element = 	select.getFirstSelectedOption();
			System.out.println(element);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();;
		
	}

}
