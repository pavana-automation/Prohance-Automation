package MSSQLPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Pages.CommonMethodsPage;
import Pages.SuperGroupMysqlPage;
import test.BaseTest;

public class SuperGroupMSSQLPage extends BaseTest
{

	WebDriver			driver;

	CommonMethodsPage	commons				= new CommonMethodsPage(BaseTest.driver);

	SuperGroupMysqlPage	superGroupMysqlPage	= new SuperGroupMysqlPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	@FindBy(xpath = "//ul[@id=\"menu-content\"]//li[contains(text(),'Super Groups')]")
	WebElement			superGroupTab;

	@FindBy(xpath = "//input[@id=\"rLevels_2\"]")
	WebElement			level2rBtn;

	@FindBy(xpath = "//input[@id=\"rLevels_1\"]")
	WebElement			level1rBtn;

	@FindBy(xpath = "//input[@id=\"rLevels_0\"]")
	WebElement			level0rBtn;

	@FindBy(xpath = "//input[@id=\"superGroupName\"]")
	WebElement			superGroupName;

	@FindBy(xpath = "//textarea[@id=\"superGroupDesc\"]")
	WebElement			superGroupDescription;

	@FindBy(xpath = "//table//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successAlter;

	@FindBy(xpath = "//select[@id=\"cmbLevel2\"]")
	WebElement			level2DropDown;

	@FindBy(xpath = "//select[@id=\"cmbLevel\"]")
	WebElement			level1DropDown;

	@FindBy(xpath = "//label[contains(text(),\"BACK\")]")
	WebElement			backBtn;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_filter\"]//input")
	WebElement			superGroupNamesTableserachTxtBx;

	@FindBy(xpath = "(//div[contains(text(),'Leve2 Super Team')]//ancestor::tr//td/a)[5]")
	WebElement			modifyIconForLeve0;

	@FindBy(xpath = "(//div[contains(text(),'Leve2 Super Team')]//ancestor::tr//td/a)[1]")
	WebElement			modifyIconForLeve2;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successMsgAlart;

	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	By					loadingIcon;

	public SuperGroupMSSQLPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSuperGroupTab() throws InterruptedException
	{

		commons.waitUntilTime(superGroupTab);
		this.superGroupTab.click();
	}

	public void addleve2SuperGroupName(String leve2SuperGroupName)
	{
		commons.waitUntilTime(saveBtn);
		this.level2rBtn.click();
		this.superGroupName.sendKeys(leve2SuperGroupName);
		this.superGroupDescription.sendKeys(leve2SuperGroupName);
		this.saveBtn.click();
		validateSuccessAlterForAdd(leve2SuperGroupName);

	}

	public void validateSuccessAlterForAdd(String superGroupName)
	{
		softAssert.assertTrue(successAlter.isDisplayed());
		softAssert.assertEquals(successAlter.getText(), "Super Groups: " + superGroupName + " added successfully");

	}

	public void addleve1SuperGroupName(String leve2SuperGroupName, String leve1SuperGroupName)
	{
		commons.waitUntilTime(saveBtn);
		this.level1rBtn.click();
		Select objSelect = new Select(level2DropDown);
		objSelect.selectByVisibleText(leve2SuperGroupName);
		this.superGroupName.sendKeys(leve1SuperGroupName);
		this.superGroupDescription.sendKeys(leve1SuperGroupName);
		this.saveBtn.click();
		validateSuccessAlterForAdd(leve1SuperGroupName);
	}

	public void addleve0SuperGroupName(String leve2SuperGroupName, String leve1SuperGroupName, String leve0SuperGroupName)
	{
		commons.waitUntilTime(saveBtn);
		this.level0rBtn.click();
		Select objSelect = new Select(level2DropDown);
		objSelect.selectByVisibleText(leve2SuperGroupName);
		Select objSelect1 = new Select(level1DropDown);
		objSelect1.selectByVisibleText(leve1SuperGroupName);
		this.superGroupName.sendKeys(leve0SuperGroupName);
		this.superGroupDescription.sendKeys(leve0SuperGroupName);
		this.saveBtn.click();
		validateSuccessAlterForAdd(leve0SuperGroupName);
	}

	public void clickBackBtn()
	{
		commons.waitUntilTime(backBtn);
		this.backBtn.click();
	}

	public void searchSuperGroupTxtBx(String superGroupNameAdd)
	{
		commons.waitUntilTime(superGroupNamesTableserachTxtBx);
		this.superGroupNamesTableserachTxtBx.sendKeys(superGroupNameAdd);
	}

	public void clickModifyIconForLeve2()
	{
		this.modifyIconForLeve2.click();
	}

	public void clickDeleteIconForLeves(String superGroupName, int number)
	{

		By modifyIconActivityTag = By.xpath("(//div[contains(text(),\'" + superGroupName + "\')]//ancestor::tr//td/a)[" + number + "]");
		driver.findElement(modifyIconActivityTag).click();
	}

	public void clickModifyIconForLeve0()
	{
		this.modifyIconForLeve0.click();
	}

	public void modifySuperGroupNameForLeve2(String leve2SuperGroupNameModify)
	{
		commons.waitUntilTime(saveBtn);
		this.superGroupName.clear();
		this.superGroupName.sendKeys(leve2SuperGroupNameModify);
		this.superGroupDescription.clear();
		this.superGroupDescription.sendKeys(leve2SuperGroupNameModify);
		this.saveBtn.click();
		validateSuccessAlterForModify(leve2SuperGroupNameModify);
	}

	public void modifySuperGroupNameForLeve1(String leve2SuperGroupNameModify, String leve1SuperGroupNameModify)
	{

		commons.waitUntilTime(saveBtn);
		Select objSelect = new Select(level2DropDown);
		objSelect.selectByVisibleText(leve2SuperGroupNameModify);
		this.superGroupName.clear();
		this.superGroupName.sendKeys(leve1SuperGroupNameModify);
		this.superGroupDescription.clear();
		this.superGroupDescription.sendKeys(leve1SuperGroupNameModify);
		this.saveBtn.click();
		validateSuccessAlterForModify(leve1SuperGroupNameModify);

	}

	public void modifySuperGroupNameForLeve0(String leve2SuperGroupNameModify, String leve1SuperGroupNameModify, String leve0SuperGroupNameModify)
	{
		commons.waitUntilTime(saveBtn);
		Select objSelect = new Select(level2DropDown);
		objSelect.selectByVisibleText(leve2SuperGroupNameModify);
		Select objSelect1 = new Select(level1DropDown);
		objSelect1.selectByVisibleText(leve1SuperGroupNameModify);
		this.superGroupName.clear();
		this.superGroupName.sendKeys(leve0SuperGroupNameModify);
		this.superGroupDescription.clear();
		this.superGroupDescription.sendKeys(leve0SuperGroupNameModify);
		this.saveBtn.click();
		validateSuccessAlterForModify(leve0SuperGroupNameModify);
	}

	public void validateSuccessAlterForModify(String superGroupName)
	{
		softAssert.assertTrue(successAlter.isDisplayed());
		softAssert.assertEquals(successAlter.getText(), "Super Groups: " + superGroupName + " modified successfully");
	}

	public void clickModifyIconForLeves(String superGroupName, int number)
	{
		By modifyIconActivityTag = By.xpath("(//div[contains(text(),\'" + superGroupName + "\')]//ancestor::tr//td/a)[" + number + "]");
		driver.findElement(modifyIconActivityTag).click();
	}

	public void validateDeletedMessageSuperGroupName(String superGroupName) throws InterruptedException
	{
		Thread.sleep(5000);
		commons.waitForElementNotVisible(Duration.ofMinutes(45), driver, loadingIcon);
		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Detele Message is not showing or category not Deleted");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Super Groups: " + superGroupName + " deleted successfully");
		softAssert.assertAll();
	}

	public HashMap<String, List<String>> addSuperGroupNamesExcelBulckUploadForMSSQL() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		HashMap<String, List<String>> addSuperGroupLevelBulkUploadMap = new HashMap<>();
		List<String> level2SuperGroupList = new ArrayList<String>();

		level2SuperGroupList.add("ADD");
		level2SuperGroupList.add("Software Engineer Level 2");
		level2SuperGroupList.add("Software Engineer Level 2");
		level2SuperGroupList.add("Delivery Unit");

		List<String> level1SuperGroupList = new ArrayList<String>();

		level1SuperGroupList.add("ADD");
		level1SuperGroupList.add("Software Engineer Level 1");
		level1SuperGroupList.add("Software Engineer Level 1");
		level1SuperGroupList.add("Business Unit");
		level1SuperGroupList.add("Software Engineer Level 2");

		List<String> level0SuperGroupList = new ArrayList<String>();

		level0SuperGroupList.add("ADD");
		level0SuperGroupList.add("Software Engineer Level 0");
		level0SuperGroupList.add("Software Engineer Level 0");
		level0SuperGroupList.add("Super Groups");
		level0SuperGroupList.add("Software Engineer Level 1");

		addSuperGroupLevelBulkUploadMap.put("2", level2SuperGroupList);
		addSuperGroupLevelBulkUploadMap.put("1", level1SuperGroupList);
		addSuperGroupLevelBulkUploadMap.put("0", level0SuperGroupList);

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			List<String> listofKeys = new ArrayList<String>(addSuperGroupLevelBulkUploadMap.keySet());
			Collections.reverse(listofKeys);
			int rowNum = 2;
			for (String levels : listofKeys)
			{
				List<String> dataList = addSuperGroupLevelBulkUploadMap.get(levels);
				Row row = sheet.getRow(rowNum);
				int k = 0;
				for (int j = 1; j <= dataList.size() + 1; j++)
				{
					if (j == 2)
					{
						continue;
					}
					Cell cell = row.createCell(j);
					cell.setCellValue(dataList.get(k));
					k++;
				}
				rowNum++;
			}

			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		}
		return addSuperGroupLevelBulkUploadMap;
	}

	public List<String> modifySuperGroupExcelBulckUpload(List<String> addedSuperGroup) throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		String Level2 = "Software Engineer Level 2 Modified";

		List<String> level1 = new ArrayList<String>();
		level1.add("MOD");
		level1.add("Software Engineer Level 1 Modified");
		level1.add("Software Engineer Level 1 Modified");
		level1.add("Software Engineer Level 2 Modified");

		List<String> level0 = new ArrayList<String>();

		level0.add("MOD");
		level0.add("Software Engineer Level 0 Modified");
		level0.add("Software Engineer Level 0 Modified");
		level0.add("Software Engineer Level 1 Modified");

		List<String> reternList = new ArrayList<String>();
		reternList.add(Level2);
		reternList.add(level1.get(1));
		reternList.add(level0.get(1));

		String path = commons.getRecentFilePath();

		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{

			Sheet sheet = workbook.getSheetAt(0);

			int index = 0;
			for (String search : addedSuperGroup)
			{

				Row row = sheet.getRow(superGroupMysqlPage.getIndexModifiedSuperGroupNameExcelBulckUpload(search));

				switch (index)
				{

				case 0:

					writeStringValues(row, Level2);
					break;

				case 1:
					
					writeListValuesInExcel(row, level1);
					break;

				case 2:

					writeListValuesInExcel(row, level0);
					break;

				}

				index++;
			}

			FileOutputStream fileOutputStream = new FileOutputStream(path);

			workbook.write(fileOutputStream);

			fileOutputStream.close();

			workbook.close();

		}

		file.close();

		return reternList;

	}

	public void writeStringValues(Row row, String level2)
	{
		Cell celloperation = row.createCell(1);

		celloperation.setCellValue("MOD");

		Cell cell = row.createCell(3);

		cell.setCellValue(level2);

		Cell cell1 = row.createCell(4);

		cell1.setCellValue(level2);

	}

	public void writeListValuesInExcel(Row row, List<String> levels)
	{
		int listIndex = 0;

		for (int i = 1; i <= levels.size() + 1; i++)
		{
			if (i != 2 && i != 5)
			{
				Cell cell1 = row.createCell(i);

				cell1.setCellValue(levels.get(listIndex));

				listIndex++;
			}
			else
			{
				continue;
			}
		}
	}

	public void deleteSuperGroupExcelBulckUploadForMSSQL(String modifiedSuperGroup) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(superGroupMysqlPage.getIndexModifiedSuperGroupNameExcelBulckUpload(modifiedSuperGroup));
			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("DEL");

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
			
		}
		
		file.close();

	}

}
