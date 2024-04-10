package test.WorkFlow;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import WorkFlowPage.CustomAttributeBulkUploadPages;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;
import utilities.ReadXLSdata;

public class CustomAttributeWithDeleteWithDependency extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	CustomAttributeBulkUploadPages custom = new CustomAttributeBulkUploadPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;

	@Test
	public void customAttributeWithModifyFieldType() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriverMysql();
		//driver=initializeDriver3333();
		//listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		//listeners.testStepDescription("Step 2: Click on Work Flow");
		custom.clickWorkFlowBtn();
		Thread.sleep(1000);
		custom.switchTabs();
		//listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		//listeners.testStepDescription("Step 4: Scroll down the navigation");
		custom.scrollSideNavigationBar();
		//listeners.testStepDescription("Step 5: Click on Administartion ");
		custom.clickAdministrationBtn();
		Thread.sleep(1000);
		//listeners.testStepDescription("Step 6: Click on Custom Attribute");
		custom.clickCustomAttribute();
		driver.switchTo().frame("contentFrame");
		//listeners.testStepDescription("Step 7: Click on Bulk Upload");
		custom.clickBulkUpload();
		//listeners.testStepDescription("Step 8: Click on Template with existing Custom Attributes");
		custom.clickTempWithData();
		//listeners.testStepDescription("Step 9: Click on Click here btn");
		custom.clickClickHereBtn();
		//listeners.testStepDescription("Step 10: Get custom attribute list");
		excel.getCustomAttributeWithDeleteWithDependency();
		custom.clickChooseFileBtn(excel.getRecentFilePath());
		//listeners.testStepDescription("Step 11: Compare the fail message");
		boolean check = custom.getFailMsg();
		Assert.assertTrue(check);
	}


}
