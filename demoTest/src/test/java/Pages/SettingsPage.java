package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import test.BaseTest;

public class SettingsPage
{

	WebDriver			driver;

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	public SettingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),\"The number of records to be shown in report summary\")]//parent::tr//td[last()-1]//select")
	WebElement	recordsDisplayInSummaryReport;

	@FindBy(xpath = "//td[contains(text(),\"The number of records to be shown in configuration summary\")]//parent::tr//td[last()-1]//select")
	WebElement	recordsDisplayInConfigurationSummary;
	
	@FindBy(xpath = "//div[@id=\"tr_buttons\"]//input[@value=\"SAVE\"]")
	WebElement	saveBtn;

	public void selectRecordsDisplayInSummaryReportDropDownValues(String values)
	{
		Select dropdown = new Select(recordsDisplayInSummaryReport);
		dropdown.selectByVisibleText(values);
	}
	
	public void selectRecordsDisplayInConfigurationSummaryDropDownValues(String values)
	{
		Select dropdown = new Select(recordsDisplayInConfigurationSummary);
		dropdown.selectByVisibleText(values);
	}
	
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}

}
