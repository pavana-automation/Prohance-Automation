package test.UserDomain;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;



public class UserDomainPDFValidation extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	ReadXLSdata ReadXLSdata = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void pdf() throws IOException, InterruptedException { 
	
	listeners.testStepDescription("Step 1: Login into the prohance application");
	driver=initializeDriver3333();
	loginPage.clickLogin("adminp","1");
	
	listeners.testStepDescription("Step 2: Click on Side Navigation Page");
	sidenavPage.clickSideNavigationBtn();
	
	listeners.testStepDescription("Step 3: Click on User Domain");
	sidenavPage.clickUserDomainBtn();
	driver.switchTo().frame("contentFrame");
	
	listeners.testStepDescription("Step 4: Store all the 'Name' in expected list");
	ArrayList<String> expectedList = userdomain.getElementsInRowToList();
	
	listeners.testStepDescription("Step 5: Click on download Pdf");
	userdomain.clickExportToPdfBtn();

	listeners.testStepDescription("Step 6: Get Data from PDF file and store in Actual List and compare with expected");
	String actualExcelValue = ReadXLSdata.getPDFData();
    
    for(int i=0;i<expectedList.size();i++)
    {
    	String data = expectedList.get(i);
    	System.out.println("the value is :" +data);
    	Assert.assertTrue(actualExcelValue.contains(data));
    }
    
    listeners.testStepDescription("Step 7: All the Actual record matches with the Expected record ");
	}
	

}