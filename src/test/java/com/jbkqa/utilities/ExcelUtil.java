package com.jbkqa.utilities;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtil {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	XSSFCell cell;
	String excelFilePath;

	private Map<String, Integer> columns = new HashMap<>();
	
	public ExcelUtil(String excelPath) throws Exception 
	{
		try {
			File src = new File(excelPath);
					//("/Users/rohini/Documents/SigninContacts.xlsx");
			FileInputStream fis =  new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheet1 = wb.getSheetAt(0);
			this.excelFilePath = excelPath;
			
			sheet1.getRow(0).forEach(cell -> {
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public String getSignUpData(int row, int column)
	{
		
		
		try {
		cell = sheet1.getRow(row).getCell(column);
		String cellData = null;
		switch(cell.getCellType())
		{
		case STRING:
			cellData = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellData = String.valueOf((long)cell.getNumericCellValue());
			break;
		case BLANK:
			cellData = "";
			break;
		default:
			break;
			
		}
	
		return cellData;
		}
		
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return ("Invalid data");
		
		// String data = NumberToTextConverter(sheet1.getRow(row).getCell(column).getNumericCellValue());
		
		//String data = sheet1.getRow(row).getCell(column).getNumericCellValue();
		
		
		
		
		
	}
	
	public String getSignUpcellData(String columnName, int rownum)
	{
		return getSignUpData(rownum, columns.get(columnName));
	}
	public String getData(int sheetnumber, int row, int column)
	{
		sheet1 = wb.getSheetAt(0);
		
		
		String data = NumberToTextConverter.toText(sheet1.getRow(row).getCell(column).getNumericCellValue());
		
		//String data = sheet1.getRow(row).getCell(column).getNumericCellValue();
		
		return data;
		
		
	}
	
	public int getRowCount(int sheetIndex)
	{
		int numRow = wb.getSheetAt(sheetIndex).getLastRowNum();
		numRow = numRow+1;
		return numRow;
	}

}
