package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String  getDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./testdata/testscriptdat.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		String data=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		workbook.close();
		return data;
	}
	
	public int  getRowCount(String sheet) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./testdata/testscriptdat.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		int data=workbook.getSheet(sheet).getLastRowNum();
		workbook.close();
		return data;
	}
	
	public int  getCellCount(String sheet,int rowCount) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./testdata/testscriptdat.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		int data=workbook.getSheet(sheet).getRow(rowCount).getLastCellNum();
		workbook.close();
		return data;
	}
	
	public void  setDataIntoExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./testdata/testscriptdat.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		workbook.getSheet(sheet).getRow(row).createCell(cell).getStringCellValue();
		
		FileOutputStream fos=new FileOutputStream("./testdata/testscriptdat.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}
	
	public String[][] readMultipleDataFromExcel(String sheetName) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./testdata/testscriptdat.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		Sheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(1).getLastCellNum();
		String[][] data=new String[rowCount][cellCount];
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
			System.out.println();
		}
		return data;
	}

}
