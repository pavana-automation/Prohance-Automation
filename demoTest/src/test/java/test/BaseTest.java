
package test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;

public class BaseTest
{

	// public static WebDriver driver;
	public static WebDriver			driver	= new ChromeDriver();

	public loginPage				loginPage;

	public SideNavigationMenuPage	sidenavPage;

	public UserDomainPage			userdomain;

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebDriver initializeDriver3333()
	{

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.210:3333/prohance/");
		return driver;
	}


	public WebDriver initializeDriver6969()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.128:6969/prohance/");
		return driver;
	}

	public WebDriver initializeDriverMssql()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.128:6969/prohance/");
		return driver;
	}
	
	public WebDriver initializeDriverMysql()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
		// driver = new ChromeDriver();
		// options.addArguments("download.default_directory=/path/to/download/directory");
		// options.addArguments("download.prompt_for_download=false");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.128:6868/prohance/");
		return driver;
	}
	@AfterTest
	public void teardown()
	{
		// driver.quit();
	}

	/*
	 * public String getScreenshotPath(String TestCaseName, WebDriver driver)
	 * throws IOException { TakesScreenshot ts=(TakesScreenshot)driver;
	 * System.out.println("It entered this part of code"); File
	 * source=ts.getScreenshotAs(OutputType.FILE); String destpath =
	 * System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png"; File
	 * file = new File(destpath); FileUtils.copyFile(source, file); return
	 * destpath;
	 * 
	 * }
	 */

	/*
	 * public List<HashMap<String,String>> getJsonDataToMap(String filepath)
	 * throws IOException { //reading json to string String jsonContent =
	 * FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	 * 
	 * //String to Hashmap ObjectMapper mapper = new ObjectMapper();
	 * List<HashMap<String, String>> data=mapper.readValue(jsonContent, new
	 * TypeReference<List<HashMap<String, String>>>() { }); return data;
	 * 
	 * }
	 */

	public void onTestStart(ITestResult result, String Message)
	{
		// TODO Auto-generated method stub

	}

	public void testStepDescription(String Message)
	{
		// TODO Auto-generated method stub

	}

}
