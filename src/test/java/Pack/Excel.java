package Pack;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws Exception {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\orielly.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int numOfSheets=workbook.getNumberOfSheets();
		for(int i=0;i<numOfSheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("mySheet")) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				System.out.println(sheet.getPhysicalNumberOfRows());
				Iterator<Row> rows=sheet.rowIterator();
				Row firstRow=rows.next();
				Iterator<Cell> cell=firstRow.cellIterator();
				int k=0;
				int column=0;
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("username")) {
						column=k;
					}
					k++;
					
				}
				System.out.println("++++++");
				System.out.println(column);
				while (rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("qa")) {
						Iterator<Cell>cv=r.cellIterator();
						while(cv.hasNext()) {
							a.add(cv.next().getStringCellValue());
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
								a.add(c.getStringCellValue());
							}
						}
					}
					
				}
			}
			
		
			
		}
		
		
		
		

	}

}
