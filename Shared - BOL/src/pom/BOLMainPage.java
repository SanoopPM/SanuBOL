package pom;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOLMainPage {
	
	WebDriver driver;

	@FindBy(xpath="//div[@id='mainRegion']//a[text()='CAM - Common Authorization Management']")
	private WebElement CAM;
	
	@FindBy(xpath="//li[@class='navigate']/a")
	private WebElement navigatebutton;
	
	@FindBy(xpath="(//a[@title='Admin'])[2]")
	private WebElement AdminTab;
	
	@FindBy(xpath="//div[@id='mainRegion']//a[text()='Switch identity']")
	private WebElement SwitchIdentityTab;
	
	@FindBy(xpath="//span[text()='Close']")
	private WebElement CloseBtn;

	
	
	public BOLMainPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickNavigationButton() throws InterruptedException
	{
		if (CloseBtn.isDisplayed()) {
			CloseBtn.click();
			
		}
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(navigatebutton).click(navigatebutton).perform();
		//
		//dummy
//		navigatebutton.click();
	}
	
	public void clickAdmin()
	{

		AdminTab.click();
	}
	
	public void clickCAM()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("AdminFrame");

		CAM.click();
		//Switching to new window
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().activeElement();
		
		Set<String> w = driver.getWindowHandles();
		for (String s : w) 
		{
			System.out.println(s);
			driver.switchTo().window(s);
		}
	}
}
