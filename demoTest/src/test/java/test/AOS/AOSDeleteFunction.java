
package test.AOS;

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

public class AOSDeleteFunction extends BaseTest {
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	AOSPage aos = new AOSPage(BaseTest.driver);
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void aosDeleteFunction() throws InterruptedException
	
	{
	
	listeners.testStepDescription("Step 1: Login into the prohance application");
	driver=initializeDriver3333();
	loginPage.clickLogin("adminp","1");
	
	listeners.testStepDescription("Step 2: Click on sideNavigation Page");
	sidenavPage.clickSideNavigationBtn();
	
	listeners.testStepDescription("Step 3: Click on AOS under Activities");
	sidenavPage.clickActivitiesBtn();
	
	Thread.sleep(2000);
	sidenavPage.clickAOSBtn();
	driver.switchTo().frame("contentFrame");
	Thread.sleep(2000);
	
	listeners.testStepDescription("Step 4: Select particular record and store the value");
	String name = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
	
	listeners.testStepDescription("Step 5: click on delete");
	userdomain.clickDeleteBtn();
	
	listeners.testStepDescription("Step 6: Verify, Record should not be deleted");
	try 
	{
	String actualMsg = driver.findElement(By.id("dialogfailurespan")).getText();
	String expectedMsg = "Activity On System: "+name+" cannot be deleted due to data dependency. Click here to view dependency";
	Assert.assertTrue(actualMsg.contains("Activity"));
	ArrayList<String> expectedList = userdomain.getElementsInRowToList();
	Assert.assertTrue(expectedList.contains(name));
	}
	catch(org.openqa.selenium.NoSuchElementException e) {
		driver.findElement(By.xpath("//input[@value='No']")).click();
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(name));
	}
	
	listeners.testStepDescription("Step 7: Record cannot be deleted , as dependency are there hence verifying the same");
	
	}

}

