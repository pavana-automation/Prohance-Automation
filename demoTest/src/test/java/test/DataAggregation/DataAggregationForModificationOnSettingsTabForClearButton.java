
package test.DataAggregation;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.DataAggregationPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class DataAggregationForModificationOnSettingsTabForClearButton extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);

	DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void modificationOnSettingsTabForClearButton() throws InterruptedException, StaleElementReferenceException {
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
		listeners.testStepDescription("Step 5: Click CLEAR button");
		aggregation.clickClearBtn();
		
	}

}
