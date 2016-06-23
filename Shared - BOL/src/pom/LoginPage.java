package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='login2abbcom']")
	private WebElement LogintoProd;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicklogin()
	{
		List<WebElement> outerframe=driver.findElements(By.tagName("frame"));
		int countouterframe=outerframe.size();
		System.out.println(countouterframe);
		
		//Switching to frame
		driver.switchTo().frame(0);
		LogintoProd.click();
	}

}
