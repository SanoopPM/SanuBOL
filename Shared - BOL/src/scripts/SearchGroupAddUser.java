package scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import generics.Excel;
import pom.BOLMainPage;
import pom.CAMMainPage;
import pom.LoginPage;

public class SearchGroupAddUser extends BaseTest{
	
	@Test
	public void GroupSet() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		LoginPage LP=new LoginPage(driver);
		LP.clicklogin();
		Thread.sleep(3000);
		BOLMainPage BMP=new BOLMainPage(driver);
		BMP.clickNavigationButton();
		BMP.clickAdmin();
		BMP.clickCAM();
		

		String xlpath="./TestData/New Microsoft Excel Worksheet.xlsx";	
		String sheet="Sheet2";
		String sheet3="Reason";
		String Reason=Excel.getCellValue(xlpath, sheet3, 0, 0);
		CAMMainPage CAMMP=new CAMMainPage(driver);
		CAMMP.currentapplication();
		CAMMP.gotoEditMode(Reason);
		
		//Adding the distinct value of group to set of string
		Set<String> GroupName = Excel.getGroupName(xlpath, sheet);
		System.out.println(GroupName);
		
		//Adding the set of string to an Array
		ArrayList<String> lst=new ArrayList<String>();
		lst.addAll(GroupName);
		
		//code is for adding user through search for group and goto group relation and click on edit and add
		
		
		int rc=Excel.getRowCount(xlpath, sheet);
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
	
		
		for(String str:lst)
		{
			CAMMP.clickGroupButton();
			CAMMP.setSearchByTextBox(str);
			CAMMP.clickSearchButton();
			CAMMP.clickSearchResult();
			CAMMP.clickGroupRelationEditButton();
			
			for(int i=1;i<=rc;i++)
			{
				
					if(wb.getSheet(sheet).getRow(i).getCell(1).toString().equals(str))
					{
						String un = wb.getSheet(sheet).getRow(i).getCell(0).toString();
						
						CAMMP.setSearchByTextBox(un);
						CAMMP.clickSearchButton();
						CAMMP.ManageUserinGroup();
					}
				}
			}


		
		
		
		
		
		
	}

}
