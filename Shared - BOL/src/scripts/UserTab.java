package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import generics.Excel;
import pom.BOLMainPage;
import pom.CAMMainPage;
import pom.LoginPage;

public class UserTab extends BaseTest {
	
	@Test
	public void setCustomerGUID() throws InterruptedException
	{
		LoginPage LP=new LoginPage(driver);
		LP.clicklogin();
		Thread.sleep(3000);
		BOLMainPage BMP=new BOLMainPage(driver);
		
		BMP.clickAdmin();
		BMP.clickCAM();
		
		String xlpath="./TestData/SD2087820_michal.paradowski@pl.abb.com.xlsx";
		String sheet1="Sheet1";
		String sheet3="Reason";
		String Reason=Excel.getCellValue(xlpath, sheet3, 0, 0);
		CAMMainPage CAMMP=new CAMMainPage(driver);
		CAMMP.currentapplication();
		CAMMP.gotoEditMode(Reason);
	
		
		int rc=Excel.getRowCount(xlpath, sheet1);
		for(int i=53;i<=rc;i++)
		{
			String User=Excel.getCellValue(xlpath, sheet1, i, 0);
			String CGUID=Excel.getCellValue(xlpath, sheet1, i, 8);
		
		CAMMP.clickUsersButton();
		CAMMP.setSearchByTextBox(User);
		CAMMP.clickSearchButton();
		CAMMP.clickSearchResult();
		CAMMP.clickUsersAttributeTab();
		CAMMP.clickUserAttributeTabEditButton();
		CAMMP.setUserAttributeCustomerGUID(CGUID);
		CAMMP.clickUserAttributeSaveButton();
		Reporter.log(User+ "---" + CGUID + "successfully imported",true);

		}
			
		
	}
		
	

}
