
	
package test.UserDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

import java.util.ArrayList;

import org.junit.Assert;

public class UserDomainDeleteFunction extends BaseTest {
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void deleteNewFunction() throws InterruptedException
	{
		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		
		listeners.testStepDescription("Step 2: Click on sideNavigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Step 3: Click on UserDomain under Organization");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		listeners.testStepDescription("Step 4: Select particular record and store the value");
		String name = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
		
		listeners.testStepDescription("Step 5: click on delete");
		userdomain.clickDeleteBtn();
		
		listeners.testStepDescription("Step 6: Verify, Deleted record should not be available in the list");
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertFalse(expectedList.contains(name));
		
		listeners.testStepDescription("Step 7: Record is deleted Successfully");
	}

}
