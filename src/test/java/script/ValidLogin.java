package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage;
/*Author: Umesh
 *Reviewer: Geetha 
 *Approver: Sarthak
 *LMD:08-01-2025 
 */

public class ValidLogin extends BaseTest
{

	@Test(priority = 1,groups="smoke")
	public void testValidLogin()
	{
		String un = Utility.getExcelData("./data/input.xlsx","ValidLogin",1,0);
		String pw = Utility.getExcelData("./data/input.xlsx","ValidLogin",1,1);
//		1. enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
//		2. enter valid password
		loginPage.setPassword(pw);
//		3. click on go button
		loginPage.clickGoButton();
//		4. verify that home page is displayed
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyHomePageIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
