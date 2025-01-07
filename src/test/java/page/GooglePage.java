package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//POM class
public class GooglePage {

	public GooglePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}
