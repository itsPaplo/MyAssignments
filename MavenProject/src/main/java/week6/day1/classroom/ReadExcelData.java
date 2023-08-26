package week6.day1.classroom;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String[][] readExcelData(String shtnm) throws IOException{
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/Lead.xlsx");
		XSSFSheet sheet = wb.getSheet(shtnm);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(rowCount).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellData;
			}
		}
		
		wb.close();
		return data;
		
	}
		
	
	
}
