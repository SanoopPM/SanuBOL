package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generics.Excel;
import pom.BOLMainPage;
import pom.CAMMainPage;
import pom.LoginPage;

public class CreateUser extends BaseTest{
	
	@Test
	public void UserCreation() throws InterruptedException
	{
		LoginPage LP=new LoginPage(driver);
		LP.clicklogin();
		Thread.sleep(2000);
		BOLMainPage BMP=new BOLMainPage(driver);
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BMP.clickNavigationButton();
		BMP.clickAdmin();
		BMP.clickCAM();
		
		String xlpath="./TestData/SD2228809_patrycja.kuzmiuk@pl.abb.com.xlsx";
		String sheet="Sheet1";
		String sheet3="Reason";
		String Reason=Excel.getCellValue(xlpath, sheet3, 0, 0);
		CAMMainPage CAMMP=new CAMMainPage(driver);
		CAMMP.currentapplication();
		CAMMP.gotoEditMode(Reason);
	
	
	int rc=Excel.getRowCount(xlpath, sheet);
	for(int i=1;i<=rc;i++)
	{
		String UserName=Excel.getCellValue(xlpath, sheet, i, 0).toLowerCase();
		String Email=Excel.getCellValue(xlpath, sheet, i, 0).toLowerCase();
		String FirstName=Excel.getCellValue(xlpath, sheet, i, 1);
		String MiddleName=Excel.getCellValue(xlpath, sheet, i, 2);
		String LastName=Excel.getCellValue(xlpath, sheet, i, 3);
		String CompanyName=Excel.getCellValue(xlpath, sheet, i, 4);
		String CountryCode=Excel.getCellValue(xlpath, sheet, i, 5).toUpperCase();
		String PhoneNumber=Excel.getCellValue(xlpath, sheet, i, 6);
		String Internal=Excel.getCellValue(xlpath, sheet, i, 7);
//		String PreferredLang=Excel.getCellValue(xlpath, sheet, i, 8);
//		String Priviledge=Excel.getCellValue(xlpath, sheet, i, 9);
		


		CAMMP.createUser(UserName, CompanyName, CountryCode, FirstName, MiddleName, LastName, Email, PhoneNumber, Internal);
	}
	Reporter.log("Task Completed Successfully", true);
	}


}
