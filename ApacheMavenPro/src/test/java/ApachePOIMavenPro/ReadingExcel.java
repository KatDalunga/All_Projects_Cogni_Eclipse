package ApachePOIMavenPro;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

//File-->Workbook-->Sheets-->Rows-->Cells

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");  //workbook.getSheetAt(0);
		
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows:"+totalrows); //5
		System.out.println("Number of cells:"+totalcells);  //4
		String xyz="Africa";
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);
					
			for(int c=0;c<totalcells;c++)
			{
				//XSSFCell cell=currentRow.getCell(c);
				//String value=cell.toString();
				String value=currentRow.getCell(c).toString();
			
				//System.out.print(value+"      ");
				
				if(value.equalsIgnoreCase(xyz)) {
					XSSFCell currentCell=currentRow.getCell(c);
					int previousColumnIndex = currentCell.getColumnIndex() - 1;
					
					String previousCellVal = currentRow.getCell(previousColumnIndex).toString();
			       
			        System.out.println("Previous value: " + previousCellVal);
			            
					   
					
				}
				
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
		}

		
		/*
		Cell currentCell = row.getCell(1);

        // Calculate the previous column index (e.g., subtract 1)
        int previousColumnIndex = currentCell.getColumnIndex() - 1;

        // Get the previous cell (if it exists)
        Cell previousCell = row.getCell(previousColumnIndex);
        if (previousCell != null) {
            // Retrieve the value from the previous cell
            String previousValue = previousCell.getStringCellValue();
            System.out.println("Previous value: " + previousValue);
		
		*/
		
		
		
		
	}


