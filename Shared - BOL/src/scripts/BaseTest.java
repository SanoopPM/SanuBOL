package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.xml.XmlTest;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void preCondition(XmlTest b)
	{
//		String browser=b.getParameter("browser");
//		Reporter.log(browser,true);
//		if(browser.equals("GC"))
//		{
			System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
//		}
//		else if (browser.equals("IE")) 
//		{
//			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
//			driver=new InternetExplorerDriver();
//		}
//		else
//		{
//			driver=new FirefoxDriver();
//			
//		}
		driver.get("http://ace.abb.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void postCondition()
	{
//		driver.close();
	}
	

}
