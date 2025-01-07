package generic;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public final String pptFile="config.properties";

	@Parameters({"env"})
	@BeforeMethod
	public void preCondition(@Optional(pptFile) String env) throws Exception
	{
		String pptPath="./"+env;
		Reporter.log("Read data from property file:"+pptPath,true);
		
		String grid=Utility.getProperty(pptPath,"GRID");
		String gridURL=Utility.getProperty(pptPath,"GRIDURL");
		String browser=Utility.getProperty(pptPath,"BROWSER");
		String appURL=Utility.getProperty(pptPath,"APPURL");
		int ITO=Integer.parseInt(Utility.getProperty(pptPath,"ITO"));
		int ETO=Integer.parseInt(Utility.getProperty(pptPath,"ETO"));
		
		if(grid.equalsIgnoreCase("yes"))
		{
			if(browser.equals("chrome"))
			{
				Reporter.log("Open Chrome Browser in Remote System",true);
				URI uri=new URI(gridURL);
				ChromeOptions option=new ChromeOptions();
				driver=new RemoteWebDriver(uri.toURL(),option);
			}
			else
			{
				Reporter.log("Open Edge Browser in Remote System",true);
				URI uri=new URI(gridURL);
				EdgeOptions option=new EdgeOptions();
				driver=new RemoteWebDriver(uri.toURL(),option);
			}
		}
		else
		{
			if(browser.equals("chrome"))
			{
				Reporter.log("Open Chrome Browser in Local System",true);
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Open Edge Browser in Local System",true);
				driver=new EdgeDriver();
			}
		}
		
		
		Reporter.log("Enter the URL:"+appURL,true);
		driver.get(appURL);
		
		Reporter.log("Maximize the browser",true);
		driver.manage().window().maximize();
		
		Reporter.log("Set ITO:"+ITO,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
		
		Reporter.log("Set ETO:"+ETO,true);
		wait=new WebDriverWait(driver, Duration.ofSeconds(ETO));
	}
	
	@AfterMethod
	public void postCondition()
	{
		Reporter.log("Close the Browser",true);
		driver.quit();
	}
}
