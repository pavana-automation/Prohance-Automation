
package test.AOS;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.AOSPage;
import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class AOSAddNew extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	AOSPage aos = new AOSPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addNewFunction() throws InterruptedException
	{
		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();

		loginPage.clickLogin("adminp","1");

		sidenavPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Step 2: click on Activities");
		sidenavPage.clickActivitiesBtn();
		
		listeners.testStepDescription("Step 3: click on AOS");
		Thread.sleep(2000);
		sidenavPage.clickAOSBtn();
		driver.switchTo().frame("contentFrame");
		
		listeners.testStepDescription("Step 4: click on add new AOS");
		aos.clickAddNewBtn();
		String result = randomStringGenerator.randomStringGenerator();
		
		listeners.testStepDescription("Step 5: Fill all the details and the expected result is :"+result);
		aos.sendApplicationNameTxt(result);
		aos.selectActivityTypeDrpDwn();
		
		listeners.testStepDescription("Step 6: click on Save Button");
		aos.clickAddNewSaveBtn();
		aos.clickSignatureOkBtn();
		
		listeners.testStepDescription("Step 7: Moves to the next Signature page and fill title");
		aos.sendWindowTitle("www");
		aos.clickAddTitleBtn();
		
		listeners.testStepDescription("Step 8: Click on Add and save the added title and save it");
		//test.info("Click on Add and save the added title and save it");
		aos.clickSaveSignatureBtn();
		
		listeners.testStepDescription("Step 9: Check whether the newly added record in present in the list");
		//test.info("Check whether the newly added record in present in the list");
		Thread.sleep(2000);
		ArrayList<String> ActualList = userdomain.getElementsInRowToList();
		Assert.assertTrue(ActualList.contains(result));
		
		listeners.testStepDescription("Step 10: AOS added new one successfully");
	}
}
