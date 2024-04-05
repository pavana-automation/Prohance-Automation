package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import test.BaseTest;

public class CategoryPage extends BaseTest
{
	public String		activityAOSName1;

	public String		activityAOSName2;

	public String		categoryNameToAdd	= "Test Demo Category";

	public String		categoryNameModify	= "Test Demo Category Modify";

	WebDriver			driver;

	CommonMethodsPage	commons				= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	@FindBy(xpath = "//li[text()='Categories']")
	WebElement			categoriesBtn;

	@FindBy(xpath = "//span[text()='Category']/ancestor::li")
	WebElement			categoryTab;

	@FindBy(xpath = "//label[text()='ADD NEW']")
	WebElement			addNewBtn;

	@FindBy(xpath = "//input[@name=\"applicationCategoryName\"]")
	WebElement			inputCategoryNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"applicationCategoryDescription\"]")
	WebElement			inputCategoryDescriptionTxtBx;

	@FindBy(xpath = "//label[text()=\"Activities On System\"]//parent::div/input")
	WebElement			inputActivitiesOnSystemChkBk;

	@FindBy(xpath = "//label[text()=\"Activities Away From System\"]//parent::div/input[last()-1]")
	WebElement			inputActivitiesAwayFromSystemChkBk;

	@FindBy(xpath = "//tr[@id=\"applnDetailsTable\"]//input[@value=\"ADD\"]")
	WebElement			activityAOSAddbtn;

	@FindBy(xpath = "//div[@class=\"tabDetailDataDiv body-padded\"]//input[@value=\"SAVE\"]")
	WebElement			categorysavebtn;

	@FindBy(xpath = "//iframe[@id=\"contentFrame\"]")
	WebElement			iframe;

	@FindBy(xpath = "//span[text()='Activities On System']")
	WebElement			activitiesOnSystemTab;

	@FindBy(xpath = "//span[text()='Activities Away From System']")
	WebElement			activitiesAwayFromSystemTab;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]//input")
	WebElement			activitiesAOSChkBk1;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[2]//input")
	WebElement			activitiesAOSChkBk2;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td[2]")
	WebElement			getNameOfAOSactivitiesToAdd1;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[2]/td[2]")
	WebElement			getNameOfAOSactivitiesToAdd2;

	@FindBy(xpath = "//button[@name=\"add\"]")
	WebElement			addSelectedAOSactivitiesbtn;

	@FindBy(xpath = "//table[@id=\"customAosDatatable\"]/tbody/tr[1]/td")
	WebElement			getNameOfAOSactivitiesAfterAdd1;

	@FindBy(xpath = "//table[@id=\"customAosDatatable\"]/tbody/tr[2]/td")
	WebElement			getNameOfAOSactivitiesAfterAdd2;

	@FindBy(xpath = "//tr[@id=\"idleTimeTable\"]//table//tr[1]/td[2]//input")
	WebElement			activityAAFSAddBtn;

	@FindBy(xpath = "//form[@id=\"ConfigureApplicationCategoryForm\"]//input[@value=\"SAVE\"]")
	WebElement			saveCategoryBtn;

	@FindBy(xpath = "//span[@id='successmsgdiv']")
	WebElement			successMsgAlart;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_filter\"]//input")
	WebElement			searchTxtBx;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody/tr[1]/td[2]")
	WebElement			nameCategoryTable;

	@FindBy(xpath = "//div[@id=\"confirmModal\"]//div/button[2]")
	WebElement			confirmToDeleteYesBtn;
	
	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	WebElement			loadingIcon;
	
	By					deleteIconCategory	= By.xpath("//div[text()=\'" + categoryNameModify + "\']//ancestor::tr//td/a[2]");

	By					modifyIconCategory	= By.xpath("//div[text()=\'" + categoryNameToAdd + "\']//ancestor::tr//td/a[1]");


	public CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickcategoriesBtn()
	{
		commons.waitUntilTime(categoriesBtn);
		this.categoriesBtn.click();
	}

	public void clickCategoryTab()
	{
		this.categoryTab.click();
	}

	public void clickaddNewBtn()
	{
		commons.waitUntilTime(addNewBtn);
		this.addNewBtn.click();
	}

	public void addNewCategory()
	{
		this.inputCategoryNameTxtBx.sendKeys(categoryNameToAdd);
		this.inputCategoryDescriptionTxtBx.sendKeys(categoryNameToAdd);
		commons.selectCheckBox(inputActivitiesOnSystemChkBk);
		commons.selectCheckBox(inputActivitiesAwayFromSystemChkBk);

	}

	public void selectFrame()
	{
		driver.switchTo().frame(iframe);
	}

	public void clickActivitiesOnSystemTab()
	{
		this.activitiesOnSystemTab.click();
	}

	public void clickActivitiesAwayFromSystemTab()
	{
		this.activitiesAwayFromSystemTab.click();
	}

	public void clickActivityAOSAddbtn()
	{
		this.activityAOSAddbtn.click();
	}

	public void addAOSActivities()
	{
		commons.selectjavaScriptCheckBox(activitiesAOSChkBk1);
		commons.selectjavaScriptCheckBox(activitiesAOSChkBk2);
		activityAOSName1 = getNameOfAOSactivitiesToAdd1.getText();
		activityAOSName2 = getNameOfAOSactivitiesToAdd2.getText();
		commons.scrollElementToView(addSelectedAOSactivitiesbtn);
		addSelectedAOSactivitiesbtn.click();

	}

	public void validateAOSActivityiesNames()
	{
		String activityTypeNameAdded1 = getNameOfAOSactivitiesAfterAdd1.getText();
		String activityTypeNameAdded2 = getNameOfAOSactivitiesAfterAdd2.getText();

		softAssert.assertEquals(activityTypeNameAdded1, activityAOSName1, "ASO Names are not Added in Activity Type");

		softAssert.assertEquals(activityTypeNameAdded2, activityAOSName2, "ASO Names are not Added in Activity Type");
	}

	public void navigateMainWindow(String mainWindow)
	{

		driver.switchTo().window(mainWindow);

	}

	public void clickActivityAAFSAddBtn()
	{
		this.activityAAFSAddBtn.click();
	}

	public void saveCategoryBtn()
	{
		this.saveCategoryBtn.click();
	}

	public void validateAddedSuccessMessage()
	{

		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Success Message is not showing");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameToAdd + " added successfully");
	}

	public void inputSearchTxtBx()
	{
		this.searchTxtBx.sendKeys(categoryNameToAdd);
	}

	public void validateAddedCategory()
	{
		String addedCategory = this.nameCategoryTable.getText();
		softAssert.assertTrue(addedCategory.contains(categoryNameToAdd), "Categoryies are not Added into Category Table");

	}

	public void clickModifyIconCategory()
	{
		driver.findElement(modifyIconCategory).click();
	}

	public void clcikDeleteIconCategory()
	{
		driver.findElement(deleteIconCategory).click();
	}

	public void clcikConfirmToDeleteYesBtn()
	{
		this.confirmToDeleteYesBtn.click();

	}

	public void validateDeletedMessageCategory()
	{
		 //commons.waitForElementNotVisible(Duration.ofMinutes(45), driver,loadingIcon);
		//commons.waitForElement(Duration.ofMinutes(45), driver, loadingIcon);
		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Detele Message is not showing or category not Deleted");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameModify + " deleted successfully");
	}

	public void modifyTheCategory()
	{
		this.inputCategoryNameTxtBx.clear();
		this.inputCategoryNameTxtBx.sendKeys(categoryNameModify);
		commons.unselectjavaScriptCheckBox(activitiesAwayFromSystemTab);
	}

	public void validateModifiedMessage()
	{
		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Modified Message is not showing or Category not Modified");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameModify + " Modified successfully");

	}

	public void serachAftermodifiedTxtBx()
	{

		this.searchTxtBx.sendKeys(categoryNameModify);
	}

	public void validateModifiedCategory()
	{
		String modifiedCategory = this.nameCategoryTable.getText();
		softAssert.assertTrue(modifiedCategory.contains(categoryNameModify), "Categoryies are not Modified in Category Table");

	}

}