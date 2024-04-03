
package UserRoles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class UserRoleExcelValidation extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	ReadXLSdata ReadXLSdata = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test()
	public void userRoleExcelValidation() throws InterruptedException, IOException {
		
		//listeners.testStepDescription("Step 1: Login into the prohance application");
		driver=initializeDriver3333();
		loginPage.clickLogin("adminp","1");
		
		//listeners.testStepDescription("Step 2: Click on side Navigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		//listeners.testStepDescription("Step 3: Click on User Domain");
		sidenavPage.ClickOnUserRoleBtn();
		driver.switchTo().frame("contentFrame");
		
		//listeners.testStepDescription("Step 4: Store all 'Name' WebElement into a List as Expected");
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		//Thread.sleep(2000);
		
		//listeners.testStepDescription("Step 5: Click to download the Excel");
		userdomain.clickExportToExcelBtn();
		//Thread.sleep(3000);
		
		//listeners.testStepDescription("Step 6: From excel get all 'Name' into Actual list and compare with Expected");
		List<String> actualExcelValue = ReadXLSdata.getData();
	    for(int i=0;i<expectedList.size();i++)
	    {
	    	String data = expectedList.get(i);
	    	Assert.assertTrue(actualExcelValue.contains(data));
	    }
	    
	    //listeners.testStepDescription("Step 7: All the Actual record matches with the Expected record");
	}

}

