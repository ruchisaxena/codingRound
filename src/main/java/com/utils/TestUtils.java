package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {
	
	public static long 	IMPLESIT_WAIT = 10;
	public static long 	PAGE_LOAD_TIMEOUT = 20;
	public static long 	EXPLICITLY_WAIT = 20;
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "C:/Users/DELL PC/git/codingRound/src/main/java/com/testData/DataProviderWorkBook.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(fis);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i<sheet.getLastRowNum(); i++){
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
