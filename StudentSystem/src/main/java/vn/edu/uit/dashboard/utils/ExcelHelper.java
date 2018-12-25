package vn.edu.uit.dashboard.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletContext;

public class ExcelHelper {
	@Autowired
	ServletContext context;
	
	
	//private final static String FILE_PATH = System.getProperty("user.dir") + "/documents";
	
	public static String writeExcel(Object[][] data, String name, String path) {
		String fileName = "";
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");
        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
        		Utils.createFolder(path);
        		fileName = String.format("%s-%s.xlsx", name, Calendar.getInstance().getTimeInMillis());
        		String filePath = String.format("%s/%s", path, fileName);
        		FileOutputStream outputStream = new FileOutputStream(filePath);
        		workbook.write(outputStream);
        		workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileName = "";
        } catch (IOException e) {
            e.printStackTrace();
            fileName = "";
        }
        
        return fileName;
	}
	
	public static void readExcel(String path) throws IOException {
			FileInputStream inputStream = new FileInputStream(path);
			
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					
				}

			}
			workbook.close();
		}
}