
package test.DataAggregation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.DataAggregationPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class DataAggregation extends BaseTest {

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);

	DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
	Listeners listeners = new Listeners();

	@Test
	public void aggregationForSingleType() throws InterruptedException, StaleElementReferenceException {
		driver = initializeDriver6688();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		listeners.testStepDescription("Step 2: Open Side NavigationMenuBar");
		nav.clickSideNavigationBtn();
		listeners.testStepDescription("Step 3: Open Data Aggregation");
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
		listeners.testStepDescription("Step 8: Select particular date");
		aggregation.clickDateChkBoxChkBox();
		listeners.testStepDescription("Step 9: Select anyone type of aggregation ");
		aggregation.clickTypeChkBox();
		listeners.testStepDescription("Step 10: Click aggregation for all users");
		aggregation.clickAggregationForAllUsers();
		listeners.testStepDescription("Step 11: Click RUN Button");
		aggregation.clickRunAggregation();
		listeners.testStepDescription("Step 12: Go to Audit Logs page");
		aggregation.clickAuditLogBtn();
		listeners.testStepDescription("Step 13:Click Fetch Button");
		//aggregation.clickFetchBtn();
		listeners.testStepDescription("Step 14: Check starting and completeing of aggregation");
		Thread.sleep(1000);
		aggregation.getAggregationStarted();

		listeners.testStepDescription("Step 15: Aggregation for Single Date and Single Type Completed Sucessfully");
		
	}

}

