package com.online_shopping.ecom.generic.fileutility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetname, int rowNum, int colNum) throws Throwable{

		FileInputStream fIs = new FileInputStream("C:\\Users\\T470\\eclipse-workspace\\E_Com_Online_Shopping_Application_FrameWork\\target\\ecommTestScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fIs);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;

	}
	
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fIs = new FileInputStream("C:\\Users\\T470\\eclipse-workspace\\E_Com_Online_Shopping_Application_FrameWork\\target\\ecommTestScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fIs);
		int rowNum = wb.getSheet(sheetname).getLastRowNum();
		return rowNum;
		
	}
	
	

}
