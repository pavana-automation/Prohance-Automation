package MSSQLPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import Pages.CommonMethodsPage;
import Pages.UserGroupMysqlPage;
import test.BaseTest;

public class UserGroupMSSQLPage extends BaseTest
{

	String				bulkUploadModify	= "Demo test Team Modify";

	List<String>		addBulckUploadData	= new ArrayList<String>();

	WebDriver			driver;

	CommonMethodsPage	commons				= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	UserGroupMysqlPage	UserGroupMysqlPage	= new UserGroupMysqlPage(BaseTest.driver);

	@FindBy(xpath = "//input[@id=\"userGroupName\"]")
	WebElement			userGroupNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"userGroupDescription\"]")
	WebElement			userGroupNameDescriptionTxtA;

	@FindBy(xpath = "//select[@id=\"workTemplateId\"]")
	WebElement			workTemplateDropDown;

	@FindBy(xpath = "//select[@id=\"workProfileId\"]")
	WebElement			workProfileDropDown;

	@FindBy(xpath = "//select[@id=\"superGroupId\"]")
	WebElement			functionsDropDown;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//tr//td//a")
	WebElement			editIcon;

	@FindBy(xpath = "//button[@onclick=\"fnSaveUserGroupDetails(this.form)\"]")
	WebElement			detailsSaveBtn;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//tr//td//a[2]")
	WebElement			deleteIcon;

	public UserGroupMSSQLPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addDetailsInUserGroupForMSSQL()
	{
		commons.waitUntilTime(this.userGroupNameTxtBx);
		this.userGroupNameTxtBx.sendKeys("Production Team");
		this.userGroupNameDescriptionTxtA.sendKeys("Production Team");
		Select objSelect = new Select(this.workTemplateDropDown);
		objSelect.selectByVisibleText("QA TEMPLATE");

		objSelect = new Select(this.workProfileDropDown);
		objSelect.selectByVisibleText("Engineering Work Profile");

		objSelect = new Select(this.functionsDropDown);
		objSelect.selectByVisibleText("ProHance Enterprise / Product Quality / ProHance Automation");

	}

	public void clickEditIconForMSSQL()
	{
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Production Team");
		this.editIcon.click();

	}

	public void modifyDetailsForUserGroupForMSSQL()
	{
		this.userGroupNameTxtBx.clear();
		this.userGroupNameTxtBx.sendKeys("Production Modified Team");
		this.userGroupNameDescriptionTxtA.clear();
		this.userGroupNameDescriptionTxtA.sendKeys("Production Modified Team");

		Select objSelect = new Select(this.functionsDropDown);
		objSelect.selectByVisibleText("ProHance Enterprise / Product Quality / Quality Web Mgmt");
	}

	public void clickDeleteIconForMSSQL()
	{
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Production Modified Team");
		this.deleteIcon.click();

	}
	public void clickDeleteIconForBulkUploadMSSQL()
	{
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Demo test Team Modify");
		this.deleteIcon.click();
		
	}

	public List<String> addUserGroupNamesExcelBulckUploadMSSQL() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		addBulckUploadData.add("ADD");
		addBulckUploadData.add("Demo test Team");
		addBulckUploadData.add("Demo test Team");
		addBulckUploadData.add("DEV TEMPLATE");
		addBulckUploadData.add("Engineering Work Profile");
		addBulckUploadData.add("ProHance Enterprise / Product Development / ProHance Workflow");

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			sheet.getLastRowNum();
			for (int i = 2; i <= 2; i++)
			{
				Row row = sheet.getRow(i);

				// int cellcount = sheet.getRow(i).getLastCellNum() - 1;

				int k = 0;
				for (int j = 1; j <= addBulckUploadData.size() + 1; j++)
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

	public String modifySuperGroupExcelBulckUploadMSSQL() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			System.out.println(UserGroupMysqlPage.getIndexModifiedUserGroupNameExcelBulckUpload("Demo test Team"));
			Row row = sheet.getRow(UserGroupMysqlPage.getIndexModifiedUserGroupNameExcelBulckUpload("Demo test Team"));

			// System.out.println(UserGroupMysqlPage.getIndexModifiedUserGroupNameExcelBulckUpload("Demo
			// test Team"));
			// int cellcount =
			// sheet.getRow(UserGroupMysqlPage.getIndexModifiedUserGroupNameExcelBulckUpload("Demo
			// test Team")).getLastCellNum() - 1;

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("MOD");

			Cell cell = row.createCell(3);

			cell.setCellValue(bulkUploadModify);

			Cell cell1 = row.createCell(4);

			cell1.setCellValue(bulkUploadModify);

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();
		return bulkUploadModify;

	}

}
