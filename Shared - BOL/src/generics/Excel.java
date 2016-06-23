package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getCellValue(String xlpath,String sheet,int row,int cell)
	{
		String v =" ";
		try
		{
			FileInputStream fis=new FileInputStream(xlpath);
			Workbook wb=WorkbookFactory.create(fis);
			v=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			
		}
		return v;
		
	}
	
public static int getRowCount(String xlpath,String sheet)
{
	int rc=0;
	try
	{
		FileInputStream fis=new FileInputStream(xlpath);
		Workbook wb=WorkbookFactory.create(fis);
		rc=wb.getSheet(sheet).getLastRowNum();
		System.out.println("rowcount = "+rc);
	}
	catch(Exception e)
	{
		
	}
	return rc;
}

public static Set<String> getGroupName(String xlpath, String Sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	int rc=0;
	String c = "";
	Set<String> aGroup=new HashSet<>();
	
	FileInputStream fis=new FileInputStream(xlpath);
	Workbook wb=WorkbookFactory.create(fis);
	rc=wb.getSheet(Sheet).getLastRowNum();
	
	try
	{
		
		
		for(int i=1;i<=rc;i++)
		{
			for(int j=0;j<=9;j++)
			{
				c=wb.getSheet(Sheet).getRow(i).getCell(1).toString();
				aGroup.add(c);								
			}
		}

	}
	catch(Exception e)
	{
		
	}
	return aGroup;
}

}


