
package UserRoles;

import java.util.ArrayList;
import java.util.Set;

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
import Pages.UserRolePage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import java.util.Iterator;

public class UserRolesModifyManagerDefineNewActivity extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	AOSPage aos = new AOSPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	UserRolePage userRole = new UserRolePage(BaseTest.driver);
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	//@Test
	public void userRolesModifyManagerDefineNewActivity() throws InterruptedException
	{
		driver=initializeDriver3333();

		loginPage.clickLogin("adminp","1");

		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavManagerTesting");

		userRole.clickModifyBtn();
		
		//userRole.checkallowEmailExportChkBoxIsEnabled();
		
		userRole.clickUserRolePrmissionBtn();
		
		userRole.selectModuleIdDrpDwn();
		
		driver.findElement(By.xpath("//input[contains(@VALUE,'GO')]")).click();
		
		userRole.enableEditActivityRatingChkBox();
		
		userRole.clickOnSaveBtn();
		
		driver=initializeDriver3333();

		loginPage.clickLogin("managerp","1");
		
		driver.findElement(By.id("drilldown-container_4")).click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentwindow=(String) it.next();
		System.out.print("parent id"+parentwindow);
		String childwindow=(String) it.next();
		System.out.print("child id"+childwindow);
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		boolean expected = driver.findElement(By.xpath("//b[contains(text(),'EDIT RATING')]")).isDisplayed();
		
		Assert.assertEquals(true, expected);
		
		driver.findElement(By.xpath("//span[contains(text(),'Unknown AOS')]")).click();
		
		
		boolean expected1 = driver.findElement(By.xpath("//input[@title='Add Selected Applications']")).isDisplayed();
		
		Assert.assertEquals(true, expected);
		
	}

}
