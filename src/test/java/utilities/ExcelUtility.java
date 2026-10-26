package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path = path;
	}
	
	// reading the total row count
	public int getrowcount(String sheetname) throws IOException
	{
		fi= new FileInputStream(path); 
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
	    int rowcount = ws.getLastRowNum();// total row count
	    wb.close();
	    fi.close();
	    return rowcount;
		
	}
	
	//reading the total cell count
	public  int getcellcount(String sheetname, int rownum) throws IOException 
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum(); // total cell count
		wb.close();
		fi.close();
		return cellcount;
		
	}
    // Reading the data
	public  String getcelldata(String sheetname, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);// give row number
		cell=row.getCell(cellnum);
		
		// handling exception
		String data;
		try {
			
			data = cell.toString(); //convert all the diff data formats into String
		}
		catch(Exception e)
		{
			data=""; // locate the cell value and returns empty if the cell doesnt have any value
		}
		
		wb.close();
		fi.close();
	    return data;
		
		
	}
	
	// writing the data
	public void setcelldata(String sheetname, int rownum , int cellnum, String data) throws IOException
	
	{
		File xlfile = new File(path);
		if(!xlfile.exists())
		{
			wb = new XSSFWorkbook();
			fo= new FileOutputStream(path);
			wb.write(fo);
		}
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public void fillgreencolor(String sheetname, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());// This method chooses the color
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // this method adds the color to the cell
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public void fillredcolor(String sheetname, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());// This method chooses the color
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // this method adds the color to the cell
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
}


