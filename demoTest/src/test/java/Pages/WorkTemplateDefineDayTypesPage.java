package Pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import test.BaseTest;

public class WorkTemplateDefineDayTypesPage
{

	WebDriver			driver;

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	String				dayTypeValue		= "";

	public WorkTemplateDefineDayTypesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[contains(text(),'DEFINE DAY TYPES')]")
	WebElement	defineDayTypesBtn;

	@FindBy(xpath = "//iframe[@id='contentFrame']")
	WebElement	iframe;

	@FindBy(xpath = "//input[@id='addBtn']")
	WebElement	defineDayTypesAddBtn;

	@FindBy(xpath = "//body[@class='modal-open']//div[@id='alert-model-body']")
	WebElement	alertMsgTxt;

	@FindBy(xpath = "//body[@class=\"modal-open\"]//button[contains(text(),'OK')]")
	WebElement	alertMsgOkBtn;

	@FindBy(xpath = "//select[@id='dayType']")
	WebElement	dayTypeDropDown;

	@FindBy(xpath = "//input[@id='aliaseName']")
	WebElement	dayTypeAliasNameTxtBx;

	@FindBy(xpath = "//td[@id='btnTDId']//input[@value='SAVE']")
	WebElement	dayTypeModifySaveBtn;

	@FindBy(xpath = "//td[@id='btnTDId']//input[@value='CANCEL']")
	WebElement	dayTypeModifyCancelBtn;

	@FindBy(xpath = "//span[@id='success']")
	WebElement	dayTypeSuccessMessage;

	@FindBy(xpath = "//span[@id='error']")
	WebElement	dayTypeErrorMessage;

	@FindBy(xpath = "//div[@id='NotificationFilterModal']//button[@aria-label='Close']")
	WebElement	dayTypeCloseBtn;

	@FindBy(xpath = "(//div[@id=\"aliaseTable\"]//span[contains(text(),'Automation')]/ancestor-or-self::tr[last()-1]//td//i)[last()-1]")
	WebElement	dayTypeModifyIcon;

	@FindBy(xpath = "(//div[@id=\"aliaseTable\"]//span[contains(text(),'Automation')]/ancestor-or-self::tr[last()-1]//td//i)[last()]")
	WebElement	dayTypeDeleteIcon;

	@FindBy(xpath = "//span[contains(text(),'Automation modified')]")
	WebElement	checkDayTypeDeleted;

	@FindBy(xpath = "//div[@id=\"adminBodyContent\"]//parent::body//following-sibling::div[@id=\"alert-model-body\"]")
	WebElement	dayTypeEmptyValidationAlert;

	@FindBy(xpath = "//div[@id=\"adminBodyContent\"]//parent::body//following-sibling::div[@class=\"alert-modal-footer\"]/button")
	WebElement	dayTypeEmptyValidationAlertBtn;

	@FindBy(xpath = "//input[@id=\"clearBtn\"]")
	WebElement	dayTypeClearBtn;

	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	By			loadingIcon;

	// select[@id='dayType']/option[@value='WD']

	// span[text()='Business travel']/../..//i[@title='Modify']

	// span[text()='Business travel']/../..//i[@title='Delete']

	public void clickDefineDayTypesBtn()
	{
		this.defineDayTypesBtn.click();
	}

	public void clickDefineDayTypesDayTypeDropDown(String value)
	{
		commonMethodsPage.waitUntilTime(dayTypeDropDown);
		this.dayTypeDropDown.click();
		dayTypeValue = value;
		By dayTypeDrpDown = By.xpath("//select[@id='dayType']/option[@value='" + dayTypeValue + "']");
		driver.findElement(dayTypeDrpDown).click();
	}

	public void aliasNameTxtBx(String aliasName)
	{
		this.dayTypeAliasNameTxtBx.clear();
		this.dayTypeAliasNameTxtBx.sendKeys(aliasName);
	}

	public void clickAddDayTypes()
	{
		commonMethodsPage.waitUntilTime(defineDayTypesAddBtn);
		this.defineDayTypesAddBtn.click();
	}

	public void successMessageValidation(String message) throws InterruptedException
	{
		Thread.sleep(70);
		commonMethodsPage.waitUntilTime(dayTypeSuccessMessage);
		String receivedMessage = dayTypeSuccessMessage.getText();
		assertEquals(receivedMessage, message);
	}

	public void errorMessageValidation(String message) throws InterruptedException
	{
		Thread.sleep(50);
		commonMethodsPage.waitUntilTime(dayTypeErrorMessage);
		String receivedMessage = dayTypeErrorMessage.getText();
		assertEquals(receivedMessage, message);
	}

	public void verifyAddedAliasInTable(String aliasName)
	{
		By aliasNameModify = By.xpath("//span[text()='" + aliasName + "']/../..//i[@title='Modify']");
		commonMethodsPage.waitUntilTime(driver.findElement(aliasNameModify));
		driver.findElement(aliasNameModify).isDisplayed();
	}

	public void dayTypeCloseBtn()
	{
		this.dayTypeCloseBtn.click();
		softAssert.assertAll();
	}

	public void clickDayTypeModifyIcon()
	{
		commonMethodsPage.waitUntilTime(dayTypeModifyIcon);
		this.dayTypeModifyIcon.click();
	}

	public void clickDayTypeDeleteIcon()
	{
		commonMethodsPage.waitUntilTime(dayTypeDeleteIcon);
		this.dayTypeDeleteIcon.click();
	}

	public void clickDayTypeModifySaveBtn()
	{
		this.dayTypeModifySaveBtn.click();
	}

	public void clickDayTypeClearBtn()
	{
		this.dayTypeClearBtn.click();
	}

	public void conformationAlertForDeleteDayType() throws InterruptedException
	{
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		alert.accept();
		softAssert.assertEquals(alertMessage, "Are you sure you want to delete?");
		Thread.sleep(200);
	}

	public void verifyDayTypedeletedAliasInTable()
	{

		commonMethodsPage.waitForElementNotVisible(Duration.ofMinutes(5), driver, loadingIcon);

		boolean flag = isElementPresent(By.id("//span[contains(text(),'Automation modified')]"));

		System.out.println(flag);
		softAssert.assertFalse(flag);

	}

	public boolean isElementPresent(By locator)
	{
		try
		{
			driver.findElement(locator);
			return true;
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			return false;
		}
	}

	public void emptyFiledValidationAlter(String expected)
	{
		if (!this.dayTypeEmptyValidationAlert.isDisplayed())
		{
			commonMethodsPage.waitUntilTime(dayTypeEmptyValidationAlert);
		}
		softAssert.assertTrue(this.dayTypeEmptyValidationAlert.isDisplayed(), "Validation Message is not showing");
		String actual = this.dayTypeEmptyValidationAlert.getText();
		softAssert.assertEquals(actual, expected, "Validation message Not showing");
		this.dayTypeEmptyValidationAlertBtn.click();

	}

	public void validateClearBtn(String expected, String expecedTextBox)
	{
		Select select = new Select(this.dayTypeDropDown);
		WebElement o = select.getFirstSelectedOption();
		String selectedoption = o.getText();
		softAssert.assertNotEquals(selectedoption, expected);
		String textBox = this.dayTypeAliasNameTxtBx.getText();
		System.out.println("stihj" + textBox);
		softAssert.assertEquals(textBox, expecedTextBox);
	}

}
