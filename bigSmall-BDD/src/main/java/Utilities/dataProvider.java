package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProvider {
	

	public String send_Username() throws IOException {
		
		String name=""; 
		FileInputStream fis= new FileInputStream("C:\\Users\\sarthak madaan\\Desktop\\Comprehensive Case Study\\testData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow= rows.next();
				Iterator<Cell> cells=firstrow.cellIterator();
				int k=0;
				int column=0;
				while(cells.hasNext())
				{
					Cell value=cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("username"))
					{
						column=k;
					}
					k++;
				}
				
				
				Row secondrow= rows.next();
				Iterator<Cell> cv= secondrow.cellIterator();
				
				 name= cv.next().getStringCellValue();
				
			}
				
		}
		return name;
	}
	public String send_Password() throws IOException {
				
		String name=""; String pwd="";
		FileInputStream fis= new FileInputStream("C:\\Users\\sarthak madaan\\Desktop\\Comprehensive Case Study\\testData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow= rows.next();
				Iterator<Cell> cells=firstrow.cellIterator();
				int k=0;
				int column=0;
				while(cells.hasNext())
				{
					Cell value=cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("username"))
					{
						column=k;
					}
					k++;
				}
				
				
				Row secondrow= rows.next();
				Iterator<Cell> cv= secondrow.cellIterator();
				
				 name= cv.next().getStringCellValue();
				 pwd= cv.next().getStringCellValue();
				
			}
				
		}
		return pwd;
	}

		
	   
	}


