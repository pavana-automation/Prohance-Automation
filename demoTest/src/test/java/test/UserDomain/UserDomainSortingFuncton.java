package test.UserDomain;



import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class UserDomainSortingFuncton extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void sortingFunction() throws InterruptedException
	{
		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		listeners.testStepDescription("Step 2: Click SideNavigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Step 3: Click on UserDomain");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		listeners.testStepDescription("Step 4: Store the WebElements of Name and apply sort function and save as Expected List");
		String expectedList = userdomain.getElementsInRowToList().toString();
		
		listeners.testStepDescription("Step 5: Click on Sorting Button and save the list as actual List");
		userdomain.clickDomainAliasHeaderBtn();
		//Thread.sleep(1000);
		String actualList = userdomain.getElementsInRowToList().toString();
		
		listeners.testStepDescription("Step 6: Compare Expected with Actual List");
		
		Assert.assertEquals(expectedList, actualList);	
		
		listeners.testStepDescription("Step 7: Sorting is working as expected");
	}
		
}

