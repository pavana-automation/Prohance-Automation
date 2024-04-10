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

public class AOSBulkUploadModify extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	AOSPage aos = new AOSPage(BaseTest.driver);

	 @Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	//@Test
	public void aosBulkUploadModify() throws InterruptedException, IOException

	{

		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver = initializeDriver3333();
		loginPage.clickLogin("adminp", "1");

		listeners.testStepDescription("Step 2: Click on Side Navigation Page");
		sidenavPage.clickSideNavigationBtn();

		//listeners.testStepDescription("Step 3: Click on Activities");
		sidenavPage.clickActivitiesBtn();

		listeners.testStepDescription("Step 4: Click on AOS");
		sidenavPage.clickAOSBtn();
		driver.switchTo().frame("contentFrame");
		
		Thread.sleep(3000);

		listeners.testStepDescription("Step 5: Click on More Action");
		aos.clickMoreActionBtn();

		//listeners.testStepDescription("Step 6: Click on Bulk Upload");
		driver.findElement(By.xpath("//a[contains(text(),'BULK UPLOAD')]")).click();

		listeners.testStepDescription("Step 7: Click Here to download Pree Filled Template");
		driver.findElement(By.xpath("//label[contains(text(),'With Prefilled Data')]")).click();

		//listeners.testStepDescription("Step 8: Click on 'click here' to download the excel");
		aos.clickOnClickHereBtn();

		listeners.testStepDescription("Step 9: Modify the data in excel ans upload the file");
		Thread.sleep(2000);
		String result1 = aos.addActivityTagExcelBulkUploadWorkProfileModify();
		aos.clickChooseFileInBulkUpload();
		aos.clickBackBtnAosPage();

		listeners.testStepDescription("Step 10: Check whether modified data is saved in the application");
		//Thread.sleep(5000);
		//ArrayList<String> ActualList1 = userdomain.getElementsInRowToList();
		//System.out.println("the actual list is******"+ActualList1);
		//Assert.assertTrue(ActualList1.contains(result1));
		Thread.sleep(2000);
		
		aos.clickSearchBtn(result1);
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")).getText();
		Assert.assertEquals(result1,actual);
		//aos.clickOnClickHereBtn();
	
		//String result = aos.addActivityTagExcelBulckUpload();
		
		//System.out.println("the result is :" +result);
		
		//aos.addActivityTagExcelBulckUploadAOSSignature();
		
		//aos.addActivityTagExcelBulckUploadWorkProfile();
		
		//aos.clickChooseFileInBulkUpload();
		
		//aos.clickBackBtnAosPage();
		//Thread.sleep(2000);
		//aos.clickSearchBtn(result);
		//Thread.sleep(4000);
		//String actual = driver.findElement(By.xpath("//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")).getText();
		//Assert.assertEquals(result,actual);
		
		listeners.testStepDescription("Step 11: Modified data is uploaded successfully");
	}
}