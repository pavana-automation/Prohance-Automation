package test.WorkTemplateAddModifyDelete;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SideNavigationMenuPage;
import Pages.WorkTemplateDefineDayTypesPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplatePDFValidation extends BaseTest
{
	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	SoftAssert						softAssert				= new SoftAssert();
	
	Listeners						Listeners				= new Listeners();
	
	

	@Test
	public void workTemplatePDFValidation() throws InterruptedException, IOException

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
		
		Listeners.testStepDescription("Get PDF Report and data");
		workTemplateMainPage.clickPDFWorkTemplateTable();
		String pdfContent = workTemplateMainPage.getPDFWorkTemplateTableData().replace(" ", "");
		
		Listeners.testStepDescription("Validate PDF Data With Web");
		webData.forEach(data -> {
			data = data.replace(" ","");
			Assert.assertTrue(pdfContent.contains(data),"Web data and PDF Data are not match");
			
		});
		
		softAssert.assertAll();
		

	}

	
	
	
}
