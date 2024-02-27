package Pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.format.CellFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
	@Test(dataProvider = "driveTest")
	public void testCase(String user,String username,String password) {
		System.out.println(user+username+password);

}
	@DataProvider(name="driveTest")
	public Object[][] adactinData() throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Documents\\orielly.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		
	Object data[][]=new Object[rowCount-1][colCount];
	for(int i=0;i<rowCount-1;i++) {
		row=sheet.getRow(i+1);
	
		for(int j=0;j<colCount;j++) {
			XSSFCell cell=row.getCell(j);
			data[i][j]=row.getCell(j).toString();
					//.formatCellValue(cell);
		}
	}
	return data;
	}
	
	}
