
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

public class UserRolesBulkUpdateMember extends BaseTest{
	
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
	public void userRolesBulkUpdateMember() throws InterruptedException
	{
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		driver.switchTo().frame("contentFrame");
		userRole.clickAddNewBtn();
		userRole.selectMemberRadioBtn();
		String result = randomStringGenerator.randomStringGenerator();
		userRole.inputRoleNameTxtBox("AutomationTesting"+result);
		userRole.inputRoleDescrptionTxtBOx("Description1 to be written in description TExtBox for automation testing");
		userRole.clickOnSaveBtn();
		//userRole.clickOnSaveBtn();
		String txt = driver.findElement(By.id("dialogsuccessspan")).getText();
		System.out.println("success msg is :" +txt);
		String expected = "AutomationTesting"+result;
		String Final ="User Role: "+expected+" added successfully";
		Assert.assertTrue(txt.contains(Final));
		driver.findElement(By.xpath("//label[contains(text(),'BACK')]")).click();
		Thread.sleep(2000);
		userRole.clickSearchTxtBox(result);
		Thread.sleep(2000);
		userRole.clickSelectedUserChkBox();
		Thread.sleep(2000);
		//driver.switchTo().frame("contentFrame");
		String hirarchyExisted = userRole.getTextHierarchy();
		System.out.print(hirarchyExisted);
		
		userRole.setHierarchyLevelChange();
		Thread.sleep(2000);
		userRole.clickBilkUpdateBtn();
		userRole.clickSelectedUserChkBox();
		userRole.clickSearchTxtBox(result);
		String hirarchyupdated = userRole.getTextHierarchy();
		Assert.assertNotEquals(hirarchyExisted, hirarchyupdated);
		
	}
}