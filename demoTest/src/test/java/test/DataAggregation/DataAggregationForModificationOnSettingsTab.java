package test.DataAggregation;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.DataAggregationPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class DataAggregationForModificationOnSettingsTab extends BaseTest  {
	
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);

	DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modificationOnSettingsTab() throws InterruptedException, StaleElementReferenceException {
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Open Side NavigationMenuBar");
		nav.clickSideNavigationBtn();
		listeners.testStepDescription("Step 3: Open Data Aggregation");
		nav.clickDataAggregationBtn();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 4: Click settings tab");
		aggregation.clickSettingsBtn();
		listeners.testStepDescription("Step 5: Select hour for running cumulative hourly aggregation");
		aggregation.clickHourlyAggregationByHouDropdwn("10");
		listeners.testStepDescription("Step 6: Select minutes for running cumulative hourly aggregation");
		aggregation.clickHourlyAggregationByMinutesDropdwn("45");
		listeners.testStepDescription("Step 7: Select hour for running daily hourly aggregation");
		aggregation.clickDailyAggregationByHourDropdwn("11");
		listeners.testStepDescription("Step 8: Select minutes for running daily hourly aggregation");
		aggregation.clickDailyAggregationByMinuteDropdwn("15");
		listeners.testStepDescription("Step 9: Click on add image");
		aggregation.clickAddIntervalImg();
		listeners.testStepDescription("Step 10: Select interval time");
		aggregation.changeIntervalTime("30");
		listeners.testStepDescription("Step 11: Unselect Email success checkbox");
		aggregation.clickEmailSuccessfullNotification();
		listeners.testStepDescription("Step 12: Unselect Email failure checkbox");
		aggregation.clickEmailFailNotification();
		listeners.testStepDescription("Step 13: Select Email success checkbox");
		aggregation.clickEmailSuccessfullNotification();
		listeners.testStepDescription("Step 14: Select Email failure checkbox");
		aggregation.clickEmailFailNotification();
		listeners.testStepDescription("Step 15: Click SAVE button");
		aggregation.clickSaveBtn();
		listeners.testStepDescription("Step 16: Close the popup");
		aggregation.clickCloseOKBtn();
		listeners.testStepDescription("Step 17: Drag and drop module");
		aggregation.clickDrag();
		listeners.testStepDescription("Step 18: Delete the newly added interval");
		aggregation.clickDeleteImg();
		listeners.testStepDescription("Step 19: Click SAVE button");
		aggregation.clickSaveBtn();
		listeners.testStepDescription("Step 20: Displaying success messgae");
		aggregation.displaySuccessMessage();
		listeners.testStepDescription("Step 21: Close success message popup");
		aggregation.clickCloseAggregationPopUp();
		
		

	}

}

