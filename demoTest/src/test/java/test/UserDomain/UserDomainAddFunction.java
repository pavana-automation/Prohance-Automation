
package test.UserDomain;

import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class UserDomainAddFunction extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void addNewFunction() throws InterruptedException
	{
		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		sidenavPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Step 2: Click on UserDomain");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		
		listeners.testStepDescription("Step 3: click on Add new User Domain");
		userdomain.clickaddNewBtn();
		String result = randomStringGenerator.randomStringGenerator();
		
		listeners.testStepDescription("Step 4: Fill all the required details and save");
		userdomain.inputDomainName(result);
		userdomain.inputDomainDescriptionTxtBx(result);
		userdomain.inputHostName("103.211.81.27");
		userdomain.inputDomainTxtBx("${Login_Id}@test.com");
		userdomain.selectSSLChkBx();
		userdomain.selectEnableSyncData();
		userdomain.inputUserName("pavana_admin");
		userdomain.inputPassword("1");
		userdomain.inputConnString("testing");
		userdomain.clickTestConnectionBtn();
		userdomain.clickSaveBtn();
		
		listeners.testStepDescription("Step 5: Verify whether the newly added user domain is added in the existing list");
		String name = driver.findElement(By.xpath("//td[@class=\"sorting_1\"]")).getText();
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(name));
		//Assert.assertFalse(true);
		listeners.testStepDescription("Step 6: Added new User Domain successfully");
	}
	
}

