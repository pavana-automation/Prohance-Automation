package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import test.BaseTest;

public class ClassficationPage extends BaseTest
{

	public String		collectionMethodDropdownValue	= "User Specified";

	WebDriver			driver;

	CommonMethodsPage	commons							= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert						= new SoftAssert();

	@FindBy(xpath = "//li[text()='Classification']")
	WebElement			classificationBtn;

	@FindBy(xpath = "//input[@id=\"class_2\"]")
	WebElement			classBChkBx;

	@FindBy(xpath = "//input[@id=\"class_3\"]")
	WebElement			classCChkBx;

	@FindBy(xpath = "//select[@id=\"collectionId_3\"]")
	WebElement			collectionMethodDropdown;

	@FindBy(xpath = "//input[@name=\"className_2\"]")
	WebElement			nameOfClassB;

	@FindBy(xpath = "//input[@id=\"checkboxtagging_3\"]")
	WebElement			enableClassCChkBx;

	@FindBy(xpath = "//select[@id=\"parentClassification_3\"]")
	WebElement			parentDropDownForClassC;

	@FindBy(xpath = "//td[@class=\"tab-buttons\"]//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	@FindBy(xpath = "//iframe[@id=\"contentFrame\"]")
	WebElement			iframe;

	public ClassficationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickClassificationBtn()
	{
		commons.waitUntilTime(classificationBtn);
		this.classificationBtn.click();
	}

	public void selectFrame()
	{

		driver.switchTo().frame(iframe);
	}

	public void setTheParentClassification()
	{
		commons.selectjavaScriptCheckBox(classBChkBx);
		commons.selectjavaScriptCheckBox(classCChkBx);
		commons.selectjavaScriptCheckBox(enableClassCChkBx);
		Select objSelect = new Select(this.collectionMethodDropdown);
		objSelect.selectByVisibleText(collectionMethodDropdownValue);
		String parentClassName = this.nameOfClassB.getAttribute("value");
		Select objSelect1 = new Select(this.parentDropDownForClassC);
		objSelect1.selectByVisibleText(parentClassName);
		this.saveBtn.click();
	}

	public void unselectFrame()
	{

		driver.switchTo().defaultContent();
	}

}
