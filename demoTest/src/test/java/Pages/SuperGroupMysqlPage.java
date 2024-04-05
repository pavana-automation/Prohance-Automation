package Pages;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test.BaseTest;

public class SuperGroupMysqlPage extends BaseTest
{

	List<String>		withPrefilledExcelDataList	= new ArrayList<String>();

	WebDriver			driver;

	CommonMethodsPage	commons						= new CommonMethodsPage(BaseTest.driver);

	@FindBy(xpath = "//ul[@id=\"menu-content\"]//li[contains(text(),'Functions')]")
	WebElement			funtionsTab;

	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement			addNewBtn;

	@FindBy(xpath = "//input[@id=\"superGroupName\"]")
	WebElement			superGroupNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"superGroupDesc\"]")
	WebElement			superGroupDescriptionTxtAr;

	@FindBy(xpath = "//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successMsgAlart;

	@FindBy(xpath = "//td[@id=\"userGroupTD\"]//span[contains(text(),'Teams')]")
	WebElement			teamsMappingTab;

	@FindBy(xpath = "//input[@onclick=\"fnAddUserGroups(this.form)\"]")
	WebElement			addTeamsBtn;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody/tr/td//input")
	WebElement			teamsChkBxToMap;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody/tr/td[2]")
	WebElement			getTeamName;

	@FindBy(xpath = "//div[@id=\"clearSaveDiv\"]//button[contains(text(),\"ADD\")]")
	WebElement			addBtnTeamsMappingPage;

	@FindBy(xpath = "//span[@id=\"messagesuccess\"]")
	WebElement			msgSuccessAlrt;

	@FindBy(xpath = "//button[contains(text(),'EXIT')]")
	WebElement			exitBtn;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody")
	WebElement			superGroupNamesTable;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_filter\"]//input")
	WebElement			superGroupNamesTableserachTxtBx;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//td/a")
	WebElement			modifyIconInSuperGroupTable;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//td/a[2]")
	WebElement			deleteIconInSuperGroupTable;

	@FindBy(xpath = "//input[@onclick=\"fnRemoveUserGroups(this.form)\"]")
	WebElement			removeBtn;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tr/th//input")
	WebElement			mappedTeamsAllChkBx;

	@FindBy(xpath = "//div[@id=\"confirmModal\"]//div/button[2]")
	WebElement			confirmToDeleteYesBtn;

	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	By					loadingIcon;

	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement			excelIconInSuperGroupTable;

	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement			pdfIconInSuperGroupTable;

	@FindBy(xpath = "//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement			bulkUploadBtn;

	@FindBy(xpath = "//input[@id=\"blankTemplate\"]")
	WebElement			blankTemplateChkBx;

	@FindBy(xpath = "//span[contains(text(),'Click here')]")
	WebElement			downloadTemplate;

	@FindBy(xpath = "//input[@id=\"superGroupUploadButton\"]")
	WebElement			uploadBtn;

	@FindBy(xpath = "//span[@class=\"btn btn-file resetError\"]/input")
	WebElement			chooseFileInBulkUploadinput;

	@FindBy(xpath = "//label[contains(text(),'BACK')]")
	WebElement			backBtnInBulkUpload;

	@FindBy(xpath = "//input[@id=\"dataTemplate\"]")
	WebElement			withPrefilledDataChkBx;
	
	@FindBy(xpath = "//input[@id=\"dataTemplate\"]")
	By			supergroupBulkUploadLoader;
	
	

	public SuperGroupMysqlPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFuntionsTab()
	{
		commons.waitUntilTime(funtionsTab);
		this.funtionsTab.click();
	}

	public void clickAddNewBtn()
	{
		commons.waitUntilTime(addNewBtn);
		this.addNewBtn.click();
	}

	public void inputSuperGroupName(String superGroupNameAdd)
	{
		commons.waitUntilTime(saveBtn);
		this.superGroupNameTxtBx.sendKeys(superGroupNameAdd);
	}

	public void inputSuperGroupNameDescription(String superGroupDescriptionAdd)
	{

		this.superGroupDescriptionTxtAr.sendKeys(superGroupDescriptionAdd);
	}

	public void clickSaveBtn()
	{

		this.saveBtn.click();
	}

	public void clickTeamsMappingTab()
	{
		commons.waitUntilTime(teamsMappingTab);
		this.teamsMappingTab.click();
	}

	public void clickAddTeamsBtn()
	{

		this.addTeamsBtn.click();
	}

	public void validateSucessMessageForAddSuperGroupName(String superGroupName)
	{
		{

			Assert.assertTrue(successMsgAlart.isDisplayed(), "Success Message is not showing");
			String successMsg = successMsgAlart.getText();
			Assert.assertEquals(successMsg, "Functions: " + superGroupName + " added successfully");
		}

	}

	public void selectTeamsChkBxToMap()
	{
		commons.waitUntilTime(getTeamName);
		commons.selectjavaScriptCheckBox(teamsChkBxToMap);
	}

	public String getTeamsNameMapped()
	{

		return this.getTeamName.getText();
	}

	public void clickAddBtnTeamsMappingPage()
	{
		this.addBtnTeamsMappingPage.click();
	}

	public void validataSucessMsgToMappedTeams(String superGroupName)
	{
		Assert.assertTrue(msgSuccessAlrt.isDisplayed(), "Success Message is not showing");
		String successMsg = msgSuccessAlrt.getText();
		Assert.assertEquals(successMsg, superGroupName + " saved successfully");

	}

	public void clickExitBtn()
	{
		commons.waitUntilTime(exitBtn);
		this.exitBtn.click();
	}

	public List<String> getWebSuperGroupData()
	{
		List<String> webSuperGroupNameDataList = new ArrayList<String>();
		commons.waitUntilTime(superGroupNamesTable);
		
		List<WebElement> rowsInTable = this.superGroupNamesTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != " " && !cell.isEmpty())
				{

					webSuperGroupNameDataList.add(cell);
				}
				else
				{
					continue;
				}
			}

			columnsInTable.clear();
		}
		rowsInTable.clear();
		return webSuperGroupNameDataList;

	}

	public void searchSuperGroupTxtBx(String superGroupName)
	{
		commons.waitUntilTime(superGroupNamesTableserachTxtBx);
		this.superGroupNamesTableserachTxtBx.sendKeys(superGroupName);
	}

	public void clickModifyIconInSuperGroupTable()
	{
		this.modifyIconInSuperGroupTable.click();
	}

	public void clickRemoveBtn()
	{
		this.removeBtn.click();
	}

	public void inputSuperGroupNameModify(String superGroupNameModify)
	{

		this.superGroupNameTxtBx.clear();
		this.superGroupNameTxtBx.sendKeys(superGroupNameModify);
		this.superGroupDescriptionTxtAr.clear();

		this.superGroupDescriptionTxtAr.sendKeys(superGroupNameModify);
	}

	public void validataSucessMsgToModifiedSuperGroupName(String superGroupNameModify)
	{
		Assert.assertTrue(successMsgAlart.isDisplayed(), "Success Message is not showing");
		String successMsg = successMsgAlart.getText();
		Assert.assertEquals(successMsg, "Functions: " + superGroupNameModify + " modified successfully");

	}

	public void selectTeamsChkBxToUnmap() throws InterruptedException
	{

		Thread.sleep(2000);

		commons.selectjavaScriptCheckBox(mappedTeamsAllChkBx);
	}

	public void clickDeleteIconInSuperGroupTable()
	{
		this.deleteIconInSuperGroupTable.click();
	}

	public void clcikConfirmToDeleteYesBtn()
	{
		this.confirmToDeleteYesBtn.click();

	}

	public void validateDeletedMessageSuperGroupName(String superGroupName) throws InterruptedException
	{
		Thread.sleep(5000);
		commons.waitForElementNotVisible(Duration.ofMinutes(45), driver, loadingIcon);
		Assert.assertTrue(successMsgAlart.isDisplayed(), "Detele Message is not showing or category not Deleted");
		String successMsg = successMsgAlart.getText();
		Assert.assertEquals(successMsg, "Functions: " + superGroupName + " deleted successfully");
	}

	public void clcikExcelIconInSuperGroupTable()
	{
		this.excelIconInSuperGroupTable.click();

	}

	public List<String> getExcelDataForSuperGroupTable() throws IOException
	{
		List<String> excelSuperGroupNameDataList = new ArrayList<String>();

		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		// FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++)
			{
				if (sheet.getRow(i).getCell(j) != null)
				{
					if (sheet.getRow(i).getCell(j).getStringCellValue() != null && sheet.getRow(i).getCell(j).getStringCellValue() != "")
					{

						excelSuperGroupNameDataList.add(sheet.getRow(i).getCell(j).getStringCellValue());

					}
					else
					{
						continue;
					}

				}
				else
				{
					break;
				}

			}

		}

		workbook.close();
		file.close();

		commons.deleteFileByPath(commons.getRecentFilePath());
		return excelSuperGroupNameDataList;

	}

	public void clcikPDFIconInSuperGroupTable()
	{
		this.pdfIconInSuperGroupTable.click();

	}

	public String getPDFSuperGroupTableData() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		driver.get("file:///" + commons.getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String pdfFileContent = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		inputstream.close();
		return pdfFileContent;

	}

	public void clickBulkUploadBtn()
	{
		this.bulkUploadBtn.click();

	}

	public void clickHereDownloadTemplate()
	{
		this.downloadTemplate.click();

	}

	public List<String> addSuperGroupNamesExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		List<String> addBulckUploadData = new ArrayList<String>();

		addBulckUploadData.add("ADD");
		addBulckUploadData.add("Software Engineer");
		addBulckUploadData.add("Software Engineer");

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			sheet.getLastRowNum();
			for (int i = 2; i <= 2; i++)
			{
				Row row = sheet.getRow(i);
				int cellcount = sheet.getRow(i).getLastCellNum() - 1;
				int k = 0;
				for (int j = 1; j <= cellcount; j++)
				{
					if (j == 2)
					{
						continue;
					}
					Cell cell = row.createCell(j);
					cell.setCellValue(addBulckUploadData.get(k));
					k++;
				}
			}
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		}
		return addBulckUploadData;
	}

	public void clickChooseFileInBulkUpload()
	{

		this.chooseFileInBulkUploadinput.sendKeys(commons.getRecentFilePath());
		// this.uploadBtn.click();
		commons.waitUntilTime(uploadBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", uploadBtn);
	}

	public void clickBackBtnInBulkUpload()
	{

		this.backBtnInBulkUpload.click();
	}

	public void selectBlankTemplateChkBx()
	{

		commons.selectjavaScriptCheckBox(blankTemplateChkBx);
	}

	public void selectWithPrefilledDataChkBx()
	{

		commons.selectjavaScriptCheckBox(withPrefilledDataChkBx);
	}

	public int getIndexModifiedSuperGroupNameExcelBulckUpload(String ExceptedData) throws IOException
	{
		int i;
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (i = 3; i <= rowCount; i++)
			{
				sheet.getRow(i).getLastCellNum();

				if (sheet.getRow(i).getCell(3) != null)
				{
					String columnData = sheet.getRow(i).getCell(3).getStringCellValue();

					if (columnData.equals(ExceptedData))
					{
						break;
					}
					else
					{
						continue;
					}

				}
				else
				{
					continue;
				}
			}
			workbook.close();
		}
		file.close();

		return i;
	}

	public void modifySuperGroupExcelBulckUpload(String superGroupNameAdd, String superGroupNameModify) throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(getIndexModifiedSuperGroupNameExcelBulckUpload(superGroupNameAdd));
			int cellcount = sheet.getRow(getIndexModifiedSuperGroupNameExcelBulckUpload(superGroupNameAdd)).getLastCellNum() - 1;

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("MOD");

			Cell cell = row.createCell(cellcount - 1);

			cell.setCellValue(superGroupNameModify);

			Cell cell1 = row.createCell(cellcount);

			cell1.setCellValue(superGroupNameModify);

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();

	}

	public void deleteSuperGroupExcelBulckUpload(String superGroupNameModify) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(getIndexModifiedSuperGroupNameExcelBulckUpload(superGroupNameModify));

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
