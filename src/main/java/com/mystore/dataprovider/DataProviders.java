package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utility.Excel;

public class DataProviders {
	@DataProvider
	public Object[][] dataLogin() throws IOException{
		String path = "src\\test\\resources\\testData\\loginData.xlsx";
		String sheetName = "Hoja1";
		int row = Excel.rowNum(path, sheetName);
		int cell = Excel.cellNum(path, sheetName);
		Object[][] data = new Object[row-1][cell];
		for(int i=0;i<row-1;i++) {
			for(int j=0;j<cell;j++) {
				data[i][j] = Excel.cellValue(path, sheetName, i+1, j);
			}
		}
		System.out.println(data);
		return data;
	}
}