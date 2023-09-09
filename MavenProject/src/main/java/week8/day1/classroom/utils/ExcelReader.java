package week8.day1.classroom.utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
	public static String[][] readExcel(String shtnm) throws IOException{
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/Leadserm.xlsx");
		XSSFSheet sheet = wb.getSheet(shtnm);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(rowCount).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				 data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		wb.close();
		return data;
		
	}
		
	
	
}
