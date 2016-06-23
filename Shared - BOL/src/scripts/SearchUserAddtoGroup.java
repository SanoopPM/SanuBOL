package scripts;

import org.testng.annotations.Test;

import generics.Excel;
import pom.BOLMainPage;
import pom.CAMMainPage;
import pom.LoginPage;

public class SearchUserAddtoGroup extends BaseTest {
	
	@Test
	public void AddUsettoGropu() throws InterruptedException
	{
		LoginPage LP=new LoginPage(driver);
		LP.clicklogin();
		Thread.sleep(3000);
		BOLMainPage BMP=new BOLMainPage(driver);
		
		BMP.clickAdmin();
		BMP.clickCAM();
		

		String xlpath="./TestData/Book1.xlsx";	
		String sheet="Sheet1";
		String sheet3="Reason";
		String Reason=Excel.getCellValue(xlpath, sheet3, 0, 0);
		CAMMainPage CAMMP=new CAMMainPage(driver);
		CAMMP.currentapplication();
		CAMMP.gotoEditMode(Reason);

	int rc=Excel.getRowCount(xlpath, sheet);
	for(int i=1;i<=rc;i++)
	{
		String UserName=Excel.getCellValue(xlpath, sheet, i, 0);
		String GroupName=Excel.getCellValue(xlpath, sheet, i, 1);
		CAMMP.AddUserstoGroup(UserName,GroupName);
	}
	
	}
}

