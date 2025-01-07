package generic;


import java.util.Properties;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	public static String getProperty(String path,String key)
	{
		String value="";
		try 
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value = p.getProperty(key);
			System.out.println(value);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static String getExcelData(String path,String sheet,int row,int col)
	{
		String value="";
		
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
			System.out.println(value);
			wb.close();
		}
		catch (Exception e) 
		{
		 e.printStackTrace();
		}
		
		return value;
	}
}
