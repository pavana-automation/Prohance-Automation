
package test.AOS;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.AOSPage;
import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;



public class AOSModifyFunction extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	AOSPage aos = new AOSPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void a0sModifyFunction() throws InterruptedException
	{
		
		driver=initializeDriver3333();

		loginPage.clickLogin("adminp","1");

		sidenavPage.clickSideNavigationBtn();
		
		sidenavPage.clickActivitiesBtn();
		
		sidenavPage.clickAOSBtn();
		
		driver.switchTo().frame("contentFrame");
		

		
		Thread.sleep(2000);
		
		aos.clickModifyBtn();
	
		String result = randomStringGenerator.randomStringGenerator();
		aos.sendApplicationNameTxt(result);
		
		
		aos.clickAddNewSaveBtn();
		
		Thread.sleep(2000);
		
		ArrayList<String> ActualList = userdomain.getElementsInRowToList();
		Thread.sleep(1000);
		Assert.assertTrue(ActualList.contains(result));
		
	}

}

