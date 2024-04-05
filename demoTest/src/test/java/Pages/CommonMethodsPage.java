package Pages;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethodsPage
{
	WebDriver			driver;

	JavascriptExecutor	jsexecutour	= (JavascriptExecutor) driver;

	public CommonMethodsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectCheckBox(WebElement locator)
	{

		if (!locator.isSelected())
		{
			locator.click();
		}
	}

	public String navigateNextWindow()
	{
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		windowHandles.remove(currentWindowHandle);
		driver.switchTo().window(windowHandles.iterator().next());
		driver.manage().window().maximize();
		return currentWindowHandle;
	}

	public void scrollElementToView(WebElement locator)
	{
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;

		jsexecutour.executeScript("arguments[0].scrollIntoView(true);", locator);
	}

	public void selectjavaScriptCheckBox(WebElement locator)
	{
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected())
		{
			jsexecutour.executeScript("arguments[0].click();", locator);
		}
	}

	public String waitForElementNotVisible(Duration timeOutInSeconds, WebDriver driver, By elementXPath)
	{
		if ((driver == null) || (elementXPath == null))
		{

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try
		{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(elementXPath));
			return null;
		}
		catch (TimeoutException e)
		{
			return "Build your own errormessage...";
		}
	}

	public void unselectjavaScriptCheckBox(WebElement locator)
	{
		if (locator.isSelected())
		{
			JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
			jsexecutour.executeScript("arguments[0].click();", locator);
		}
	}

	public void unselectCheckBox(WebElement locator)
	{

		if (locator.isSelected())
		{
			locator.click();
		}
	}

	public String getRecentFilePath()
	{

		String downloadDirectory = System.getProperty("user.home") + "/Downloads";

		Path parentFolder = Paths.get(downloadDirectory);

		Optional<File> mostRecentFileOrFolder = Arrays.stream(parentFolder.toFile().listFiles()).max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFile = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isFile())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFolder = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isDirectory())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

		if (mostRecentFolder.isPresent())
		{
			File mostRecent = mostRecentFileOrFolder.get();
			return mostRecent.getPath();
		}
		else
		{
			return "folder is empty!";
		}

	}

	public boolean deleteFileByPath(String path)
	{
		File file = new File(path);
		return file.delete();
	}

	public void waitUntilTime(WebElement path)
	{
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(path));
		}catch(Exception e) {
			
		}

	}
	
	public void waitUntilTimeElementVivible(By path)
	{
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		}catch(Exception e) {
			
		}

	}

	public String waitForElement(Duration timeOutInSeconds, WebDriver driver, WebElement elementXPath)
	{
		if ((driver == null) || (elementXPath == null))
		{

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try
		{
			// new WebDriverWait(driver,
			// timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(elementXPath));
			// return null;

			Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(d -> elementXPath.isDisplayed());

		}
		catch (TimeoutException e)
		{
			return "Build your own errormessage...";
		}
		return null;

	}
}
