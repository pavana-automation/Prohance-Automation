package test.AOS;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.AOSPage;
import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class AOSBulkUploadDelete extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	AOSPage aos = new AOSPage(BaseTest.driver);

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	//@Test
	public void aosBulkUploadDelete() throws InterruptedException, IOException

	{

		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver = initializeDriver3333();
		loginPage.clickLogin("adminp", "1");

		listeners.testStepDescription("Step 2: Click on Side Navigation Page");
		sidenavPage.clickSideNavigationBtn();

		listeners.testStepDescription("Step 3: Click on Activities");
		sidenavPage.clickActivitiesBtn();

		// listeners.testStepDescription("Step 4: Click on AOS");
		sidenavPage.clickAOSBtn();
		driver.switchTo().frame("contentFrame");

		// listeners.testStepDescription("Step 5: Click on More Action");
		aos.clickMoreActionBtn();

		// listeners.testStepDescription("Step 6: Click on Bulk Upload");
		driver.findElement(By.xpath("//a[contains(text(),'BULK UPLOAD')]")).click();

		driver.findElement(By.xpath("//label[contains(text(),'With Prefilled Data')]")).click();

		// listeners.testStepDescription("Step 6: Click on Click Here to download
		// BlankTemplate");
		aos.clickOnClickHereBtn();
		
		//aos.addActivityTagExcelBulkUploadWorkProfileDelete();

		//aos.clickChooseFileInBulkUpload();

		Thread.sleep(1000);
		aos.addActivityTagExcelBulkUploadWorkProfileDelete();
		//System.out.println("Enter the string"+result1);
		aos.clickChooseFileInBulkUpload();
		aos.clickBackBtnAosPage();
		
		String expected ="No matching records found";
		String actual = driver.findElement(By.xpath("//table[@id=\"CommonDataTableId\"]/tbody/tr/td")).getText();
		Assert.assertNotEquals(expected,actual);

	}
}