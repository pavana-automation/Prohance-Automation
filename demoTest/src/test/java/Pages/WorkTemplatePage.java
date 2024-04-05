package Pages;

import static org.testng.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import test.BaseTest;

public class WorkTemplatePage
{

	WebDriver			driver;

	String				monthValue			= "";

	String				dateValue			= "";

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	public WorkTemplatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[contains(text(),'ADD NEW')]")
	WebElement	addNewBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement	nameTxtBx;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement	descriptionTxtBx;

	@FindBy(xpath = "//button[@name='save']")
	WebElement	saveTemplateBtn;

	@FindBy(xpath = "//td[@id='workTimeTargetTD']/span[@class='nav-label']")
	WebElement	workTimeTargetsLabel;

	@FindBy(xpath = "//input[@id='mon']")
	WebElement	checkBoxMonday;

	@FindBy(xpath = "//input[@id='tue']")
	WebElement	checkBoxTuesday;

	@FindBy(xpath = "//input[@id='wed']")
	WebElement	checkBoxWednesday;

	@FindBy(xpath = "//input[@id='thu']")
	WebElement	checkBoxThursday;

	@FindBy(xpath = "//input[@id='fri']")
	WebElement	checkBoxFriday;

	WebElement	mondayLoggedHours;

	WebElement	mondayTimeOnSystem;

	WebElement	mondayTimeAwayFromSystem;

	WebElement	mondayProductiveHours;

	WebElement	tuesdayLoggedHours;

	WebElement	tuesdayTimeOnSystem;

	WebElement	tuesdayTimeAwayFromSystem;

	WebElement	tuesdayProductiveHours;

	WebElement	wedLoggedHours;

	WebElement	wedTimeOnSystem;

	WebElement	wedTimeAwayFromSystem;

	WebElement	wedProductiveHours;

	WebElement	thuLoggedHours;

	WebElement	thuTimeOnSystem;

	WebElement	thuTimeAwayFromSystem;

	WebElement	thuProductiveHours;

	WebElement	checkboxConsiderWDasAB;

	WebElement	checkboxconsiderWDasSD;

	@FindBy(xpath = "//form[@id='WorkTimeTargetForm']//button[@name='save']")
	WebElement	workTimeTargetSaveBtn;

	@FindBy(xpath = "//form[@id='WorkTimeTargetForm']//button[@name='clear']")
	WebElement	workTimeTargetClearBtn;

	@FindBy(xpath = "//td[@id='holidaysTD']/span[@class='nav-label']")
	WebElement	workTemplateHolidays;

	@FindBy(xpath = "//input[@id='holidayName']")
	WebElement	holidayNameTxtBx;

	@FindBy(xpath = "//input[@id='holidayDateId']")
	WebElement	holidayDatePicker;

	@FindBy(xpath = "//td[@id='userGroupTD']/span[@class='nav-label']")
	WebElement	workTemplateTeamsMapping;

	@FindBy(xpath = "//button[@name='addApps']")
	WebElement	teamsMappingAddBtn;

	@FindBy(xpath = "(//input[@name='userGroupSelectCheckbox'])[1]")
	WebElement	teamAddChkBox;

	@FindBy(xpath = "(//input[@name='userGroupSelectCheckbox'])[1]/../../../td[2]/div")
	WebElement	teamAddCheckedTeamName;

	@FindBy(xpath = "//form[@id='ConfigureUserForm']//button[@name='add']")
	WebElement	teamAddBtn;

	@FindBy(xpath = "//table[@id='CommonDataTableId']/tbody/tr[1]/td[1]/div")
	WebElement	teamNameValidationTxt;

	@FindBy(xpath = "//td[@id='workLoadTD']/span[@class='nav-label']")
	WebElement	workTemplateWorkLoadCategories;

	@FindBy(xpath = "//input[@id='organizationLevel']")
	WebElement	workLoadCategoriesGlobalRuleRadioBtn;

	@FindBy(xpath = "//input[@id='workTemplateLevel']")
	WebElement	workLoadCategoriesSpecificRuleRadioBtn;

	@FindBy(xpath = "//span[@id=\"messagesuccessspan\"]/span")
	WebElement	successAlertMsg;

	@FindBy(xpath = "//label[contains(text(),'BACK')]")
	WebElement	backBtnLabel;

	@FindBy(xpath = "//td[2]/div[text()='CS']/../..//i[@title='Delete']")
	WebElement	workLoadCategoryDeleteIcon;

	@FindBy(xpath = "//label[contains(text(),'DEFINE DAY TYPES')]")
	WebElement	workLoadDefineDayTypesBtn;

	@FindBy(xpath = "//select[@id='dayType']")
	WebElement	dayTypeDropdownSelect;

	@FindBy(xpath = "//iframe[@id='contentFrame']")
	WebElement	iframe;

	@FindBy(xpath = "//td[@id='holidaysTD']/span[@class='nav-label']")
	WebElement	workTemplateHoliday;

	@FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
	WebElement	monthAndYearDatePicker;

	@FindBy(xpath = "(//th[@class='datepicker-switch'])[2]")
	WebElement	yearDatePicker;

	@FindBy(xpath = "(//th[@class='prev'])[2]")
	WebElement	yearChangePrev;

	@FindBy(xpath = "(//th[@class='next'])[2]")
	WebElement	yearChangeNext;

	@FindBy(xpath = "//table[@id='maintableTD1']//button[contains(text(),'SAVE')]")
	WebElement	saveHolidayBtn;

	@FindBy(xpath = "//td[@id='userGroupTD']/span[@class='nav-label']")
	WebElement	workTemplateTeamMappingLabel;

	@FindBy(xpath = "//button[@name='addApps']")
	WebElement	addNewTeamToWorkTemplate;

	@FindBy(xpath = "(//input[@name='userGroupSelectCheckbox'])[1]")
	WebElement	workTemplateCheckFirstTeamChkBx;

	@FindBy(xpath = "(//input[@name='userGroupSelectCheckbox']/../../../td[2]/div)[1]")
	WebElement	workTemplateCheckFirstTeamName;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	WebElement	workTemplateTeamAddBtn;

	@FindBy(xpath = "//td[@id='workLoadTD']/span[@class='nav-label']")
	WebElement	workTemplateWorkLoadCategoriesLabel;

	@FindBy(xpath = "//button[contains(text(),'EXIT')]")
	WebElement	workTemplateExitBtn;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody")
	WebElement	workTemplateTable;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/excel.png\"]")
	WebElement	excelWorkTemplateTable;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement	pdfWorkTemplateTable;

	@FindBy(xpath = "//select[@name=\"CommonDataTableId_length\"]")
	WebElement	recordsToDisplayDropdown;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_info\"]")
	WebElement	recordsToDisplayInTable;

	// methods
	public void clickAddNewBtn()
	{
		this.addNewBtn.click();
	}

	public void iframeSwitch()
	{
		driver.switchTo().frame(iframe);
	}

	public void unselectFrame()
	{
		driver.switchTo().defaultContent();
	}

	public void iframeUnselect()
	{
		driver.switchTo().defaultContent();
	}

	public void addNameAndDescription(String name, String description)
	{

		this.nameTxtBx.sendKeys(name);
		this.descriptionTxtBx.sendKeys(description);

	}

	public void addNameAndDescriptionModify(String name, String description)
	{
		this.nameTxtBx.clear();
		this.nameTxtBx.sendKeys(name);
		this.descriptionTxtBx.clear();
		this.descriptionTxtBx.sendKeys(description);

	}

	public void saveBtn()
	{

		this.saveTemplateBtn.click();
	}

	public void navigateToWorkTimeTargets()
	{
		this.workTimeTargetsLabel.click();

	}

	public void checkCheckBox(WebElement locator)
	{

		boolean isSelected = locator.isSelected();
		if (!isSelected)
		{
			locator.click();
		}

	}

	public void uncheckCheckBox(WebElement locator)
	{

		boolean isSelected = locator.isSelected();
		if (isSelected)
		{
			locator.click();
		}

	}

	public void checkCheckBoxJavaScipt(WebElement locator)
	{
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected())
		{
			jsexecutour.executeScript("arguments[0].click();", locator);
		}

	}

	public void checkWorkTimeTargetForMondayToFriday()
	{

		checkCheckBox(checkBoxMonday);
		checkCheckBox(checkBoxTuesday);
		checkCheckBox(checkBoxWednesday);
		checkCheckBox(checkBoxThursday);
		checkCheckBox(checkBoxFriday);

	}

	public void saveBtnWorkTemplate()
	{
		this.workTimeTargetSaveBtn.click();
	}

	public void successMessageValidate(String expectedMessage) throws InterruptedException
	{
		Thread.sleep(50);
		commonMethodsPage.waitUntilTime(successAlertMsg);
		String textMessage = this.successAlertMsg.getText();
		assertEquals(textMessage, expectedMessage);
	}

	public void clickHolidayLabel()
	{
		this.workTemplateHoliday.click();
	}

	public void holidayNameInput(String name)
	{
		this.holidayNameTxtBx.sendKeys(name);
	}

	public void selectDatePickerInHoliday()
	{
		this.holidayDatePicker.click();
	}

	public void selectDateInDatePicker(int year, String monthGiven, String dateGiven)
	{

		this.monthAndYearDatePicker.click();
		String yearString = this.yearDatePicker.getText();
		int yearInteger = Integer.parseInt(yearString);

		int difference = year - yearInteger;

		if (difference < 0)
		{
			for (int i = 0; i > difference; i--)
			{
				this.yearChangePrev.click();
			}
		}
		if (difference > 0)
		{
			for (int i = 0; i < difference; i++)
			{
				this.yearChangeNext.click();
			}
		}

		monthValue = monthGiven;
		By month = By.xpath("//div[@class='datepicker-months']//span[contains(text(),'" + monthValue + "')]");
		driver.findElement(month).click();

		dateValue = dateGiven;
		By date = By.xpath("(//td[text()='" + dateValue + "'])[1]");
		driver.findElement(date).click();

	}

	public void saveHoliday()
	{
		this.saveHolidayBtn.click();
	}

	public void navigateToTeamMappingLabel()
	{
		this.workTemplateTeamMappingLabel.click();
	}

	public void addButtonTeamMapping()
	{
		this.addNewTeamToWorkTemplate.click();
	}

	public void mainWindow(String childWindow)
	{

		Set<String> windowHandles = driver.getWindowHandles();
		for (Iterator<String> iterator = windowHandles.iterator(); iterator.hasNext();)
		{
			String string = (String) iterator.next();
			driver.switchTo().window(string);
		}

	}

	public String childWindow()
	{

		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		windowHandles.remove(currentWindowHandle);
		driver.switchTo().window(windowHandles.iterator().next());
		driver.manage().window().maximize();
		return currentWindowHandle;
	}

	public void checkFirstTeamInWorkTemplate()
	{
		checkCheckBoxJavaScipt(workTemplateCheckFirstTeamChkBx);

	}

	public String getSelectedTeamName()
	{

		String teamName = this.workTemplateCheckFirstTeamName.getText();
		return teamName;

	}

	public void addTeamWorkTemaplate()
	{
		this.workTemplateTeamAddBtn.click();
	}

	public void clickWorkLoadCategoriesLabel()
	{
		this.workTemplateWorkLoadCategoriesLabel.click();
	}

	public void clickExitBtn()
	{
		this.workTemplateExitBtn.click();
	}

	public boolean validateAddedTeamplateInTable(String templateName)
	{

		By tempName = By.xpath("//table[@id='CommonDataTableId']//tr/td[2]/div[text()='" + templateName + "']");
		boolean isExist = driver.findElement(tempName).isDisplayed();
		return isExist;

	}

	public boolean validateDeletedTeamplateNotInTable(String templateName)
	{

		By tempName = By.xpath("//table[@id='CommonDataTableId']//tr/td[2]/div[text()='" + templateName + "']");
		boolean isExist;
		try
		{
			isExist = driver.findElement(tempName).isDisplayed();
		}
		catch (Exception e)
		{
			isExist = false;
		}
		return isExist;

	}

	public void validateTemplateDeleted(boolean isTemplateExist)
	{

		assertEquals(false, isTemplateExist);
	}

	public void modifyWorkTemplate(String templateName)
	{

		By tempNameModify = By.xpath("//td[2]/div[contains(text(),'" + templateName + "')]/../..//i[@title='Modify']");
		driver.findElement(tempNameModify).click();

	}

	public void deleteWorkTemplate(String templateName)
	{

		By tempNameModify = By.xpath("//td[2]/div[contains(text(),'" + templateName + "')]/../..//i[@title='Delete']");
		driver.findElement(tempNameModify).click();
		By clickYesInAlert = By.xpath("//body[@class='modal-open']//button[contains(text(),'YES')]");
		driver.findElement(clickYesInAlert).click();
	}

	public void uncheckWorkTimeTargetForMondayToThursday()
	{

		uncheckCheckBox(checkBoxMonday);
		uncheckCheckBox(checkBoxTuesday);
		uncheckCheckBox(checkBoxWednesday);
		uncheckCheckBox(checkBoxThursday);

	}

	public List<String> getWorkTemplateWebData()
	{
		List<String> webActivityTagTableDataList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(workTemplateTable);
		List<WebElement> rowsInTable = this.workTemplateTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
				{
					webActivityTagTableDataList.add(cell.replace(" ", ""));

				}
				else
				{
					continue;
				}
			}
			columnsInTable.clear();

		}
		rowsInTable.clear();

		return webActivityTagTableDataList;

	}

	public void clickexcelWorkTemplateTable()
	{
		this.excelWorkTemplateTable.click();
	}

	public List<String> getExcelActivityTagTableData() throws IOException, InterruptedException
	{
		List<String> excelActivityTagTableDataList = new ArrayList<String>();
		Thread.sleep(2000);
		FileInputStream file = new FileInputStream(commonMethodsPage.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++)
			{

				Cell cell = sheet.getRow(i).getCell(j);

				switch (cell.getCellType())
				{

				case STRING:
					if (cell.getStringCellValue() != null && cell.getStringCellValue() != "")
					{
						excelActivityTagTableDataList.add(cell.getStringCellValue().replace(" ", ""));
					}
					else
					{
						continue;
					}
					break;
				case NUMERIC:

					if (cell != null || cell.getCellType() != CellType.BLANK)
					{

						excelActivityTagTableDataList.add(Double.toString(cell.getNumericCellValue()).replace(".0", ""));
					}
					else
					{
						continue;
					}

					break;
				default:
					break;
				}
			}

		}
		workbook.close();
		file.close();

		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		return excelActivityTagTableDataList;

	}

	public void clickPDFWorkTemplateTable()
	{
		this.pdfWorkTemplateTable.click();
	}

	public String getPDFWorkTemplateTableData() throws IOException, InterruptedException
	{

		Thread.sleep(2000);
		driver.get("file:///" + commonMethodsPage.getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String pdfConten = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		inputstream.close();

		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		return pdfConten;
	}

	public void selectrecordsToDisplayDropdown(String values)
	{
		Select dropdown = new Select(recordsToDisplayDropdown);
		dropdown.selectByVisibleText(values);
	}

	public void validaterecordsToDisplayDropdown(String values)
	{
		Select select = new Select(this.recordsToDisplayDropdown);
		WebElement o = select.getFirstSelectedOption();
		String selectedoption = o.getText();
		softAssert.assertNotEquals(selectedoption, values);
	}

	public void validaterecordsToDisplay(int expectedValues)
	{
		String[] no_of_count_array = this.recordsToDisplayInTable.getText().split(" ");
		int no_of_count = Integer.parseInt(no_of_count_array[2]);
		softAssert.assertTrue((int) no_of_count <= expectedValues);
	}

	public List<String> getSortedWorkTemplateWebData(int column)
	{
		List<String> webWorkTemplateSortedList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(workTemplateTable);
		List<WebElement> rowsInTable = this.workTemplateTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			String cell = columnsInTable.get(column).getText();

			if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
			{
				webWorkTemplateSortedList.add(cell);

			}
			else
			{
				continue;
			}
			columnsInTable.clear();

		}
		rowsInTable.clear();

		return webWorkTemplateSortedList;

	}

	public void clickForSorting(String columnNumber)
	{
		WebElement element = driver.findElement(By.xpath("//table[@class=\"dataTable no-footer\"]//th[@aria-controls=\"CommonDataTableId\"][" + columnNumber + "]"));
		element.click();
	}

}
