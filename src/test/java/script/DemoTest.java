package script;


import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Utility;
import page.GooglePage;

public class DemoTest extends BaseTest
{
	@Test
	public void testDemo()
	{
	
		GooglePage g=new GooglePage(driver);
		String title=g.getTitle(driver);
		Reporter.log("test Demo:"+title,true);
		String v=Utility.getExcelData("./data/input.xlsx","sheet1",0,0);
		Reporter.log("Excel Data:"+v,true);
	}
}
