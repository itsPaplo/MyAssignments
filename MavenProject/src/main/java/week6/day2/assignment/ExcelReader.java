package week6.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] readExcel(String shtnm) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/Leaftaps.xlsx");
		XSSFSheet sheet = wb.getSheet(shtnm);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(rowCount).getLastCellNum();

		String [][] data = new String[rowCount][colCount];
		for(int i =1;i<=rowCount;i++) {
			for(int j = 0; j<colCount;j++) {
				data[i=1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}

}
