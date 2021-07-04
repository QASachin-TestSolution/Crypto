package com.crypto.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	XSSFSheet sheet; // instance data members
	XSSFWorkbook wb; // instance data members

	public Excelutils(String Path) // constructor
	{
		try {
			File src = new File(Path);
			FileInputStream fls = new FileInputStream(src);
			wb = new XSSFWorkbook(fls);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	

	public int getlastRow(int sheetNo) {
		int lastrow = wb.getSheetAt(sheetNo).getLastRowNum();
		return lastrow;
	}
	
	public int getlastCol(int sheetNo,int rownum) {
		int lastCol = wb.getSheetAt(sheetNo).getRow(rownum).getLastCellNum();
		return lastCol;
	}

	
	public String getdata(int sheetNum, int row, int column) {
		sheet = wb.getSheetAt(sheetNum);

				String data = sheet.getRow(row).getCell(column).getStringCellValue();

				return data;
	}
		
	}