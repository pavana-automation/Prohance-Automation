
package UserRoles;

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
import Pages.UserRolePage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class UserRolesModifyManagerHierarchyLevel extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	AOSPage aos = new AOSPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	UserRolePage userRole = new UserRolePage(BaseTest.driver);
	
	//@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	@Test
	public void userRolesModifyManagerHierarchyLevel() throws InterruptedException
	{
		driver=initializeDriver3333();

		loginPage.clickLogin("adminp","1");

		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavManagerTesting");

		userRole.clickModifyBtn();
		
		userRole.checkMeOnlyRdBtnIsSelected();
		
		userRole.selectMembersDirectlyToMeIsSelected();
		
		userRole.checkMembersDirectlyToMeIsSelected();
	}

}