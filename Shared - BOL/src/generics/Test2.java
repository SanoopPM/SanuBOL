package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.eclipse.jdt.internal.compiler.ast.WhileStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.CAMMainPage;

public class Test2 {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
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
//			if(aa1.getText().contains("Business Online"))
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
//				String a2="//tbody/tr//div/a[contains(text(),'Business')]";
				String a2="//tbody/tr//div/a[contains(text(),'MyABB')]";
				WebElement app2=driver.findElement(By.xpath(a2));
				app2.click();
			}		
			
			
			
			String s2="//ul/li/div[@class='menuMainItem']/a[text()='Groups']";
			WebElement Group=driver.findElement(By.xpath(s2));
			Group.click();
			
			
	
		
		FileInputStream fis=new FileInputStream("./TestData/SD2206882_mateusz.oldak@pl.abb.com.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		int rc = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println("Last row = " +rc);
		
		Set<String> aGroup=new HashSet<>();
		String c = "";
		
		
		for(int i=1;i<=rc;i++)
		{
			for(int j=0;j<=9;j++)
			{
				c=wb.getSheet("Sheet1").getRow(i).getCell(9).toString();
				aGroup.add(c);		
								
			}		}

		HashSet<String> hs1=new HashSet<String>();
		hs1.addAll(aGroup);
		System.out.println("agroup size = " + aGroup.size());
			System.out.println("group content = " +aGroup);
			System.out.println("hs1 list = " + hs1);
			
			ArrayList<String> lst=new ArrayList<String>();
			lst.addAll(aGroup);
			for(String str:lst)
			{
//				System.out.println(str);
				
				String s3="//div[@id='filter.search.fields']//input[@name='filter']";
				WebElement SearchBy=driver.findElement(By.xpath(s3));
				SearchBy.clear();
				SearchBy.sendKeys(str);
				
				String s4="//div[@id='fielter.buttons']//input[@id='DataTableFilterSearchButton']";
				WebElement Search=driver.findElement(By.xpath(s4));
				Search.click();
				
				WebElement NoofSearchResult=driver.findElement(By.xpath("//div[@class='camDataTablePaggingSection']//b"));
				
				System.out.println(str + "Exist");
				
				Thread.sleep(1000);
				if (NoofSearchResult.getText().contains("0"))
				{
					System.out.println("No Search Result Found**********  " + str );
					
					
				}

			}
	}
}

