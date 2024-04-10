package test.WorkTemplateAddModifyDelete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SettingsPage;
import Pages.SideNavigationMenuPage;
import Pages.WorkTemplateDefineDayTypesPage;
import Pages.WorkTemplatePage;
import Pages.loginPage;
import test.BaseTest;
import test.GenderalVariables;
import test.Listeners;

public class WorkTemplateTableSortingValidation extends BaseTest
{
	WebDriver						driver;

	loginPage						loginPage				= new loginPage(BaseTest.driver);

	WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);

	WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);

	SettingsPage					settingsPage			= new SettingsPage(BaseTest.driver);

	SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);

	SoftAssert						softAssert				= new SoftAssert();

	WorkTemplatePage				workTemplatePage		= new WorkTemplatePage(BaseTest.driver);
	
	Listeners						Listeners				= new Listeners();

	@Test
	public void workTemplateTableSortingValidation() throws InterruptedException, IOException

	{

		driver = initializeDriverMysql();
		
		Listeners.testStepDescription("Login Into Prohance Application");
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		Listeners.testStepDescription("Navigate to  Organization > Settings Tab in Side Menu Bar");
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		Listeners.testStepDescription("Validate sorting is happen or not in all columns");
		List<WebElement> tableColumnList = driver.findElements(By.xpath("//div[@class=\"dataTables_scrollHeadInner\"]//table[@class=\"dataTable no-footer\"]/thead/tr[1]/th"));

		for (int i = 1; i <= tableColumnList.size() - 1; i++)
		{
			if (i != 1)
			{

				workTemplatePage.clickForSorting(String.valueOf(i));

			}

			List<String> webSortedList = workTemplatePage.getSortedWorkTemplateWebData(i);
			List<String> expcetedList = new ArrayList<String>();
			expcetedList.addAll(webSortedList);
			Collections.sort(expcetedList, Comparator.comparing(String::toLowerCase));
			System.out.println(webSortedList);
			System.out.println(expcetedList);
			softAssert.assertEquals(webSortedList, expcetedList);

			workTemplatePage.clickForSorting(String.valueOf(i));
			List<String> webSortedListReverse = workTemplatePage.getSortedWorkTemplateWebData(i);
			List<String> expcetedListReverse = new ArrayList<String>();
			expcetedListReverse.addAll(webSortedListReverse);
			Collections.sort(webSortedListReverse, Collections.reverseOrder(Comparator.comparing(String::toLowerCase)));
			System.out.println(webSortedListReverse);
			System.out.println(expcetedListReverse);
			softAssert.assertEquals(webSortedListReverse, expcetedListReverse);
                
		}
		softAssert.assertAll();

	}

}
