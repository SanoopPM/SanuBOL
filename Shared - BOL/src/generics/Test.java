package generics;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		//Getting input from user whether go for user creation or order
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the option PO / UC");
				String i=sc.next().toLowerCase();
				
				System.out.println("Test");
				
				//Opening Brower
//				System.setProperty("webdriver.ie.driver","./exefiles/IEDriverServer.exe");
//				InternetExplorerDriver driver=new InternetExplorerDriver();
				
				System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				
				driver.get("http://ace.abb.com/");
				driver.manage().window().maximize();
				//counting frame
				List<WebElement> outerframe=driver.findElements(By.tagName("frame"));
				int countouterframe=outerframe.size();
				System.out.println(countouterframe);
				
				//Switching to frame
				driver.switchTo().frame(0);
				
				Thread.sleep(3000);
							
				//Click on Login
				String l="//input[@id='login2abbcom']";
				WebElement login=driver.findElement(By.xpath(l));
				login.click();
				
				System.out.println("Loging into BOL");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String url = driver.getCurrentUrl();
				
				//chekcing whether new UI
				if(url.equals("https://ace.test.abb.com/frontend/#/home"))
				{
					//If yes, switch to old
					WebElement oldUI=driver.findElement(By.xpath("//div[@data-ng-hide]/a"));
					oldUI.click();
				}
				
				
				//Click on Admin Tab
				String Admin="//li[@id='BOLtab_11']/a";
				WebElement Ad=driver.findElement(By.xpath(Admin));
			
				

				if(i.equals("uc"))
				{
					
					Ad.click(); 
					//Clik on CAM
					String C="//ul[@class='linkList']/li[2]/a";
					WebElement CAM=driver.findElement(By.xpath(C));
					CAM.click();
					
					//Switching to new window
					System.out.println(driver.getCurrentUrl());
					driver.switchTo().activeElement();
					
					Set<String> w = driver.getWindowHandles();
					System.out.println("Window Size" + w.size());
					for (String s : w) 
					{
						
						System.out.println(s);
						driver.switchTo().window(s);
					}
					
					System.out.println(driver.getCurrentUrl());
					
					Thread.sleep(3000);
					
					//Checking whether application is BOL or not
					String aa="//div[@class='breadCrumbsInner']//li[1]/a";
					WebElement aa1 = driver.findElement(By.xpath(aa));
					System.out.println(aa1.getText());
//					if(aa1.getText().contains("Business Online"))
					if(aa1.getText().contains("MyABB"))
					{
						System.out.println(driver.getCurrentUrl());
					}
					else
					{
						//click on Application tab
						String a1="//ul/li/div[@class='menuMainItem']/a[text()='Applications']";
						WebElement app1=driver.findElement(By.xpath(a1));
						app1.click();
						
						
						//click on Business Online Application
//						String a2="//tbody/tr//div/a[contains(text(),'Business')]";
						String a2="//tbody/tr//div/a[contains(text(),'MyABB')]";
						WebElement app2=driver.findElement(By.xpath(a2));
						app2.click();
					}		
					
					
					//Click on Edit Mode
					String e1="//div[@id='changeReasonContainer']/a";
					WebElement EditMode=driver.findElement(By.xpath(e1));
					EditMode.click();
					
					//Give Change reason
					String e2="//textarea[@id='change_reason']";
					WebElement ChangeReason=driver.findElement(By.xpath(e2));
					ChangeReason.sendKeys("SD2079827 pola.wojtasiewicz@pl.abb.com ");
					
					//Click on save
					String s1="//input[@class='button']";
					WebElement Save=driver.findElement(By.xpath(s1));
					Save.click();
					
					String s2="//ul/li/div[@class='menuMainItem']/a[text()='Users']";
					WebElement User=driver.findElement(By.xpath(s2));
					User.click();
					
					String s3="//div[@id='filter.search.fields']//input[@name='filter']";
					WebElement SearchBy=driver.findElement(By.xpath(s3));
					SearchBy.clear();
					SearchBy.sendKeys("mikael.miglis@se.abb.com");
					
					String s4="//div[@id='fielter.buttons']//input[@id='DataTableFilterSearchButton']";
					WebElement Search=driver.findElement(By.xpath(s4));
					Search.click();
					
					Thread.sleep(3000);
					
					String s5="//div[@class='dataTableContent']//tbody//a";
					WebElement SearchResult=driver.findElement(By.xpath(s5));
					SearchResult.click();
					
					String s6="//div[@id='productMenu']//a[text()='Attributes']";
					WebElement UAttribute=driver.findElement(By.xpath(s6));
					UAttribute.click();
					
					System.out.println("before action");

//					WebElement AEdit=driver.findElement(By.xpath(".//*[@id='row_15e23c969a7d44b38b376e939df95920_EditButton']/div"));
					WebElement aaaa=driver.findElement(By.xpath("//a[contains(text(),'Customer GUID:')]"));
					Actions a=new Actions(driver);
					
					Thread.sleep(3000);
					a.moveToElement(aaaa).perform();
					
					
//					Thread.sleep(2000);
					
					WebElement edit=driver.findElement(By.xpath("//a[contains(text(),'Customer GUID:')]/../../../..//div[text()='Edit']"));
					edit.click();
					
					System.out.println("after action");
					Thread.sleep(3000);
					WebElement CGUID=driver.findElement(By.id("CustomerGUID"));
					CGUID.clear();
					CGUID.sendKeys("SEABB_PA_PAPI_9AAE100784");
									
					
//					AEdit.click();
//					String s7="//div[@class='fieldset_10']/div[@class='topDetails section']//input[@value='Edit']";
//					WebElement AEdit=driver.findElement(By.xpath(s7));
//					AEdit.click();
					
					
//					String s8="//input[@id='CustomerGUID']";
//					WebElement CGUID=driver.findElement(By.id("CustomerGUID"));
//					CGUID.sendKeys("12345");
//					CGUID.clear();

					String s9="//input[@value='Save']";
					WebElement ASave=driver.findElement(By.xpath(s9));
					ASave.click();
					
				}
			
			else
			{
				//click on Admin
				Ad.click();
				
				Thread.sleep(5000);
				//Clik on Switch Identity
				String C="//ul[@class='linkList']/li[15]/a";
				WebElement CAM=driver.findElement(By.xpath(C));
				CAM.click();
				
				//Enter user name in switch identity
				String SIUN="//div[@class='changeidentitydropdownrow']//input[@name='changeidentity.username']";
				WebElement SI=driver.findElement(By.xpath(SIUN));
				SI.sendKeys("sonia.javeri@ae.abb.com");
		
	}
	

}
}
