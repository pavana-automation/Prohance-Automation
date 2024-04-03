
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

public class UserDomainModify extends BaseTest
{
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modifyFunction() throws InterruptedException
	{
		listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		
		listeners.testStepDescription("Step 2: Click on sideNavigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		listeners.testStepDescription("Step 3: Click User Domain");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		listeners.testStepDescription("Step 4: Select particular record and store the value");
		String name = driver.findElement(By.xpath("//td[@class=\"sorting_1\"]")).getText();
		System.out.println("first data is :"+name);
		
		listeners.testStepDescription("Step 5: Click on Modify button and after modifying click pn save");
		userdomain.clickModifyBtn();
		String result = randomStringGenerator.randomStringGenerator();
		System.out.println("modified data is"+result);
		userdomain.inputDomainName(result);
		userdomain.clickSaveBtn();
		
		listeners.testStepDescription("Step 6: Verify the Modified data is reflected in the list");


		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(result));
		
		listeners.testStepDescription("Step 7: Modified data is reflected in the list successfully");
		
	}

}

