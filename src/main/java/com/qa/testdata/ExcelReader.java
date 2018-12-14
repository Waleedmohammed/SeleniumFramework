package com.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ExcelReader {

	 static FileInputStream fis=null;

	public   FileInputStream getfileInputStream() {

		String filepath = "D:\\MyWorkSpace\\TAF_ME\\src\\main\\java\\com\\qa\\testdata\\UserData.xlsx"; //System.getProperty(("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\UserData.xlsx");

		File scrfile = new File(filepath);

		try {
			fis = new FileInputStream(scrfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fis;


	}


	public Object [][] getExcelData() throws IOException{

		fis = getfileInputStream(); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}

}
