package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test3 {
	
	public static void main(String[] args) throws InterruptedException 
	{

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
				
				WebElement CloseBtn = driver.findElement(By.xpath("//span[text()='Close']"));
				if (CloseBtn.isDisplayed()) {
					CloseBtn.click();
				}
				
				WebElement NavigateBtn=driver.findElement(By.xpath("//li[@class='navigate']/a"));				
				
				Actions action=new Actions(driver);
//				action.moveToElement(NavigateBtn).click().perform();
				action.moveToElement(NavigateBtn).click(NavigateBtn).perform();
//				NavigateBtn.click();
				
				//Click on Admin Tab
				String Admin="//li[@id='BOLtab_11']/a";
				WebElement Ad=driver.findElement(By.xpath(Admin));
			
				

		
					
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
					
					
	
					String s2="//ul/li/div[@class='menuMainItem']/a[text()='Users']";
					WebElement User=driver.findElement(By.xpath(s2));
					User.click();
					
					String s3="//div[@id='filter.search.fields']//input[@name='filter']";
					WebElement SearchBy=driver.findElement(By.xpath(s3));
					SearchBy.clear();
					SearchBy.sendKeys("VirtualAssistant.usiny@us.abb.com");
					
					String s4="//div[@id='fielter.buttons']//input[@id='DataTableFilterSearchButton']";
					WebElement Search=driver.findElement(By.xpath(s4));
					Search.click();
					
					Thread.sleep(3000);
					
					String s5="//div[@class='dataTableContent']//tbody//a";
					WebElement SearchResult=driver.findElement(By.xpath(s5));
					SearchResult.click();
					
					String s6="//div[@id='productMenu']//a[text()='Groups']";
					WebElement UserGroupTab=driver.findElement(By.xpath(s6));
					UserGroupTab.click();
					
			
					String s7="//fieldset[@id='groupSection']//tr/td[1]/div/a";
					List<WebElement> availGroup = driver.findElements(By.xpath(s7));
					int count=availGroup.size();
					System.out.println(count);
					for(int i=0;i<count;i++)
					{
						String text=availGroup.get(i).getText();
						System.out.println(text);
					}
					
							
			
	

}
	
	

}
