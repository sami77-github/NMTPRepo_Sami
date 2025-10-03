package com.tekpyramid.vtiger.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility_2 {

	// To Read The Data From Excel
	public String getDataFromExcel_2(int rowNum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/ReadDataBasedOnCondition.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("Sheet1").getRow(rowNum).getCell(cellnum).toString();
		wb.close();
		return data;
	}
	
	// To Write The Data Back To Excel
		public void setDataToExcel_2(int rowNum, int cellnum, String Data) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/ReadDataBasedOnCondition.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Cell cel = wb.getSheet("Sheet1").getRow(rowNum).createCell(cellnum);
			cel.setCellType(CellType.STRING);
			cel.setCellValue(Data);
			
			FileOutputStream fos = new FileOutputStream("./TestData/ReadDataBasedOnCondition.xlsx");
			wb.write(fos);
			wb.close();
		}
		
		// To Read The Multiple Data From Excel
		public String getMultipleDataFromExcel(String filepath, String sheetname) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			int rowCount = sh.getLastRowNum();
			
			for(int i=0; i<rowCount; i++) {
				Row row = sh.getRow(i);
				 if (row == null) continue;
				short lastcell = row.getLastCellNum();
				for(int j=0; j<lastcell; j++) {
					String cell = row.getCell(j).toString();
					if (cell == null) continue;
					System.out.print(cell+" ");
				}
				System.out.println();
			}
			String cell = null;
			wb.close();
			return cell;
		}
		
		// To Read The Data Based on Condition
		 String expectedData;
		 String data ;
		public String getDataFromExcelBasedOnCondition(String filepath,String sheetname,int coloumNum,String expectedData) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			int rowcount = sh.getLastRowNum();
			for(int i=0; i<rowcount;i++) {
				String actualData = sh.getRow(i).getCell(coloumNum).toString();
				if(actualData.equalsIgnoreCase(expectedData)) {
					Row row = sh.getRow(i);
					String data = row.getCell(0).toString()+" "+
					              row.getCell(1).toString()+" "+
							      row.getCell(2).toString();	
					return data;
				}
			}
			return data;	
		}
}
