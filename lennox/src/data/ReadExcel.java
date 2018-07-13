package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {

	public String[][] getExcelData(String filePath, String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		Workbook workbook = null;

		try {
			File file = new File(filePath + fileName);
			FileInputStream inputStream = new FileInputStream(file);

			workbook = new HSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);

			int totalNoOfRows = sheet.getPhysicalNumberOfRows();
			int totalNoOfCols = 4;
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {
				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

			workbook.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return arrayExcelData;
	}

}