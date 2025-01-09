package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test(priority = 2,groups="smoke")
	public void testInvalidLogin()
	{
//		1. enter invalid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("abc");
//		2. enter invalid password
		loginPage.setPassword("xyz");
//		3. click on go button
		loginPage.clickGoButton();
//		4. verify that error msg displayed
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
