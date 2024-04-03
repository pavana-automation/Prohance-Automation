
package test.DataAggregation;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.DataAggregationPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class DataAggregationForAllType extends BaseTest {
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);

	DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
	Listeners listeners = new Listeners();

	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void alltypeValidation() throws InterruptedException, StaleElementReferenceException {
		driver = initializeDriver6688();
		driver = initializeDriver6688();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		listeners.testStepDescription("Step 2: Open Side NavigationMenuBar");
		nav.clickSideNavigationBtn();
		listeners.testStepDescription("Step 3: Click Data Aggregation");
		nav.clickDataAggregationBtn();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 4: Click on month");
		aggregation.clickcalenderBtn();
		listeners.testStepDescription("Step 5: Select any year which is wanted to do aggregation");
		aggregation.selectYear("2023");
		listeners.testStepDescription("Step 6: Select any month which is wanted to do aggregation");
		aggregation.selectMonth("November");
		listeners.testStepDescription("Step 7: Click on GO button");
		aggregation.clickGoBtn();
		listeners.testStepDescription("Step 4: Select particular date");
		aggregation.clickDateChkBoxChkBox();
		listeners.testStepDescription("Step 5: Select all type of aggregation");
		aggregation.clickAllTypeChkBtn();
		listeners.testStepDescription("Step 6: Click aggregation for all users");
		aggregation.clickAggregationForAllUsers();
		listeners.testStepDescription("Step 7: Click RUN button");
		aggregation.clickRunAggregation();
		listeners.testStepDescription("Step 8: Go to Audit logs page");
		aggregation.clickAuditLogBtn();
		listeners.testStepDescription("Step 9:Click Fetch Button");
		//aggregation.clickFetchBtn();
		listeners.testStepDescription("Step 10: Check starting and completeing of aggregation");
		aggregation.getAggregationStatusForAllType();
		listeners.testStepDescription("Step 11: Aggregation for Single Date and All Type Completed Sucessfully");



	}

}

