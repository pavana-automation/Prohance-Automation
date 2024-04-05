package test.WorkTemplateAddModifyDelete;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplateDefineDayTypesPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateExcelValidation extends BaseTest
{

	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	SoftAssert						softAssert				= new SoftAssert();

	Listeners						Listeners				= new Listeners();

	@Test
	public void workTemplateExcelValidation() throws InterruptedException, IOException

	{

		driver = initializeDriverMysql();

		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		Listeners.testStepDescription("Navigate to  Organization > WorkTemplate Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		Listeners.testStepDescription("Get Web data");
		List<String> webData = workTemplateMainPage.getWorkTemplateWebData();

		Listeners.testStepDescription("Get Excel Report and data");
		workTemplateMainPage.clickexcelWorkTemplateTable();
		List<String> excelData = workTemplateMainPage.getExcelActivityTagTableData();

		Listeners.testStepDescription("Validate Excel Data With Web");
		webData.forEach(data -> {

			softAssert.assertTrue(excelData.contains(data), "Web data and Excel Data are not match");
		});
		
		softAssert.assertAll();
	}

}
