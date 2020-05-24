package base;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class CusRegExcel {

	public static String[] CData = new String[5];
	public static String file_location = System.getProperty("user.dir")
			+ "\\src\\test\\java\\testdata\\HackathonTestData.xlsx";

	public static String[] readExcelData(String fileName) throws Exception {
		DataFormatter formatter = new DataFormatter();
		FileInputStream read = new FileInputStream(file_location);
		XSSFWorkbook workbook = new XSSFWorkbook(read);
		XSSFSheet sheet = workbook.getSheet("LoginTest");
		XSSFRow Row = sheet.getRow(0); // get my Row which start from 0 //its for column

		int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
		// int ColNum= Row.getLastCellNum(); // get last ColNum
		for (int i = 0; i < RowNum; i++) // Loop work for Rows
		{
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < 3; j++) // Loop work for column//(we are not using colnum variable because it iterates
										// all empty columns and take heavy time).
			{
				if (row == null)
					continue;
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						continue; // if it get Null value it pass no data
					else {
						String value = "";
						value = formatter.formatCellValue(cell);
						CData[j] = value; // This formatter get my all values as string i.e integer, float all type data
											// value
					}
				}
			}
		}

		return CData;

	}

}
