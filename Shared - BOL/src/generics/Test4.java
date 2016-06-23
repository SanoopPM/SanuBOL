package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test4 {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
	FileInputStream fis=new FileInputStream("C:/Users/insapm/Sanoop/Java & Selenium/SanuCodes/BOL/TestData/SD2125997_michal.paradowski@pl.abb.com.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	
	int rc = wb.getSheet("Sheet1").getLastRowNum();
	System.out.println("Last row = " +rc);
	
	HashSet<String> aGroup = new HashSet<String>();
	String c = "";
	
	
	for(int i=1;i<=rc;i++)
	{
		for(int j=0;j<=9;j++)
		{
			c=wb.getSheet("Sheet1").getRow(i).getCell(9).toString();
			aGroup.add(c);	
			
							
		}
	}
	System.out.println("agroup after if statement " +aGroup.size());
	
	Iterator itr=aGroup.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}

	System.out.println("------------------------------------------------");
	
	ArrayList<String> al=new ArrayList<String>();
	al.addAll(aGroup);
	Collections.sort(al);
	for (String ss:al)
	{
		System.out.println(ss);
	}
		
//		ArrayList<String> lst=new ArrayList<String>();
//		lst.addAll(aGroup);
//		
//	
//		
////		PrintWriter out = new PrintWriter(new FileWriter("out.txt", true), true);
//		
//		PrintStream out=new PrintStream(new File("C:/sanu.txt"));
//		for(String str:lst)
//		{
//			for(int i=1;i<=rc;i++)
//			{
//				
//					if(wb.getSheet("Sheet1").getRow(i).getCell(9).toString().equals(str))
//					{
//						String un = wb.getSheet("Sheet1").getRow(i).getCell(0).toString();
//						
//						//write the output to text file
//
//						
//						out.println(un + " --- " + str + " --- " + i );
//						
//		
//						
//						System.out.println(un + " --- " + str + " --- " + i);
//
//					}
//				}
//			}
//		
//		out.close();	
}

}
