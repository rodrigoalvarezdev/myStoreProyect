package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static int rowNum(String path, String sheetName) throws IOException {
		FileInputStream f = new FileInputStream(path);
		XSSFWorkbook libro = new XSSFWorkbook(f);
		XSSFSheet hoja = libro.getSheet(sheetName);
		return hoja.getLastRowNum()+1;
	}
	
	public static int cellNum(String path, String sheetName) throws IOException {
		FileInputStream f = new FileInputStream(path);
		XSSFWorkbook libro = new XSSFWorkbook(f);
		XSSFSheet hoja = libro.getSheet(sheetName);
		return hoja.getRow(0).getLastCellNum();	
	}
	
	public static String cellValue(String path, String sheetName, int row, int cell) throws IOException {
		FileInputStream f = new FileInputStream(path);
		XSSFWorkbook libro = new XSSFWorkbook(f);
		XSSFSheet hoja = libro.getSheet(sheetName);
		Row fila = hoja.getRow(row);
		Cell celda = fila.getCell(cell);
		libro.close();
		return celda.getStringCellValue();
	
	}
}
