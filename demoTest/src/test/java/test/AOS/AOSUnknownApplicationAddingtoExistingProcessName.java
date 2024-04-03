package test.AOS;

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

public class AOSUnknownApplicationAddingtoExistingProcessName extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	AOSPage aos = new AOSPage(BaseTest.driver);
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void aosUnknownApplicationAddingtoExistingProcessName() throws InterruptedException
	
	{
	
	listeners.testStepDescription("Step 1: Login into the prohance application");
	driver=initializeDriver3333();
	loginPage.clickLogin("adminp","1");
	
	listeners.testStepDescription("Step 2: Click on Side Navigation Page");
	sidenavPage.clickSideNavigationBtn();
	
	listeners.testStepDescription("Step 3: Click on Activities");
	sidenavPage.clickActivitiesBtn();
	
	listeners.testStepDescription("Step 4: Click on AOS");
	sidenavPage.clickAOSBtn();
	driver.switchTo().frame("contentFrame");
	
	listeners.testStepDescription("Step 5: Click on More Action");
	aos.clickMoreActionBtn();
	
	listeners.testStepDescription("Step 6: Click on Unknown Application");
	aos.clickUnknownApplicationBtn();
	
	listeners.testStepDescription("Step 7: Click on Qbutton and select one of the application to qualify the same");
	int tableCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr")).size();
	int qulafiedCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]/span/i")).size();
	if(tableCount == qulafiedCount)
	{
		listeners.testStepDescription("Step 8: There is no application to qulafy");
	}
	else
	{
	aos.clickQBtn();
	String expected =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	aos.selectChkBox();

	listeners.testStepDescription("Step 8: Click on Add button");
	aos.clickAddBtn();
	
	listeners.testStepDescription("Step 9: Add to an Existing application");
	aos.selectConfigureUnknownApplicationDrpDwn();
	driver.findElement(By.id("selectType_PN")).click();
	
	listeners.testStepDescription("Step 10: After Configuring the application save it");
	aos.clickSubmitBtn();
	aos.clickAddNewSaveBtn();
	
	listeners.testStepDescription("Step 11: Checking the application whether it is configured or not");
	aos.clickMoreActionBtn();
	aos.clickUnknownApplicationBtn();
	Thread.sleep(2000);
	aos.clickQBtn();
	String actual =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	Assert.assertNotEquals(expected, actual);
	
	listeners.testStepDescription("Step 12: The Application is configured successfully");

	}
	}

}