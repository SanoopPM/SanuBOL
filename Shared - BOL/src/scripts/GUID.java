package scripts;

import org.testng.annotations.Test;

import generics.Excel;
import pom.BOLMainPage;
import pom.CAMMainPage;
import pom.LoginPage;

public class GUID extends BaseTest{
	
	@Test
	public void CheckGUID() throws InterruptedException
	{
		LoginPage LP=new LoginPage(driver);
		LP.clicklogin();
		Thread.sleep(3000);
		BOLMainPage BMP=new BOLMainPage(driver);
		BMP.clickNavigationButton();
		BMP.clickAdmin();
		BMP.clickCAM();
		
		String xlpath="./TestData/SD2228809_patrycja.kuzmiuk@pl.abb.com.xlsx";
		String sheet1="Sheet1";
		String sheet3="Reason";
		String Reason=Excel.getCellValue(xlpath, sheet3, 0, 0);
		CAMMainPage CAMMP=new CAMMainPage(driver);
		CAMMP.currentapplication();
		CAMMP.gotoEditMode(Reason);
	
	
		int rc=Excel.getRowCount(xlpath, sheet1);
		for(int i=1;i<=rc;i++)
		{
			String User=Excel.getCellValue(xlpath, sheet1, i, 0);
			String GUID=Excel.getCellValue(xlpath, sheet1, i, 8);
		
		
			CAMMP.CheckGUIDSetisPresent(User, GUID);


		}
	}
}
