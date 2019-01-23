package com.selenium.dataTable;

import java.io.FileInputStream;
import java.io.IOException;
import com.selenium.config.Constants;
import com.selenium.main.DriverScript;
import com.selenium.util.Logs;

import org.apache.poi.xssf.usermodel.*;

public class ReadTestCasesFile {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	
	//Set file path and open excel file. Provide filepath as argument
	 public static void setFilePath(String path) throws IOException
	 {
		 try {
			 FileInputStream TestCasesFileInput = new FileInputStream(path);
			 workbook = new XSSFWorkbook(TestCasesFileInput);
		 }
		 catch(Exception e) {
			 Logs.error("....."+ e.getMessage());
			 DriverScript.result = false;
		 }
		 
	 }

	 //Read data from excel row and col. Provide row no.,column no. and sheet name as argument
	 public static String getExcelCellData(int RowNo, int ColNo, String sheetName)
	 {
		 sheet = workbook.getSheet(sheetName);
		 try {
			 cell = sheet.getRow(RowNo).getCell(ColNo);
			 String cellData = cell.getStringCellValue();
			 return cellData;
		 }
		 catch(Exception e) {
			 Logs.error(".........."+e.getMessage());
			 DriverScript.result = false;
			 return "";
			 
			 
		 }
		 
	 }
	 
	 // Get row count of any sheet in excelFile
	 public static int getRowCount(String sheetName)
	 {
		 int number = 0;
		 try {
		 sheet = workbook.getSheet(sheetName);
         number= sheet.getLastRowNum()+1;
         return number;
		 }
		 catch(Exception e) {
			 Logs.error(e.getMessage());
			 DriverScript.result = false;
			 return number;
		 }
     }
	 
	 // Get the row number of the TestCase from Controller sheet
	 public static int getRowNumber(String testCaseName, int ColNo,String sheetName) throws Exception
	 {
         int i=1;
         try {
         sheet = workbook.getSheet(sheetName);
         int rowCount = ReadTestCasesFile.getRowCount(sheetName);
         for (; i<rowCount; i++)
         {
        	 if  (ReadTestCasesFile.getExcelCellData(i, ColNo, sheetName).equalsIgnoreCase(testCaseName))
        	 {
        		 break;
        	 }
         }
         return i;
         }
         catch(Exception e) {
        	 Logs.error(e.getMessage());
        	 DriverScript.result = false;
        	 return i;
         }
     }
		 
	 // Get the count of test Steps in a Test Case from Test_Steps sheet
	 public static int getTestStepsCount(String sheetName, String testCaseID, int testCaseStart) throws Exception
	 {
		 int count = 0;
		 try {
		 for (int i = testCaseStart; i <= ReadTestCasesFile.getRowCount(sheetName); i++)
		 {
			 if (!testCaseID.equals( ReadTestCasesFile.getExcelCellData(i,Constants.col_TestCase_ID,sheetName)))
			 {
				 count = i;
				 break;
			 }
		 }
		 /*sheet = workbook.getSheet(sheetName);
		 int number = sheet.getLastRowNum() ; */
		 return count;
		 }
		 catch(Exception e) {
			 Logs.error(e.getMessage());
			 DriverScript.result = false;
			 return count;
		 }
	 }
}
