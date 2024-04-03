package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.var;

public class UserRolePage {
	
WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	WebElement addnewBtn;
	
	@FindBy(id="roleTypeStyleId_Manager")
	WebElement managerRadioBtn;
	
	@FindBy(id="roleTypeStyleId_Member")
	WebElement memberRadioBtn;
	
	@FindBy(id="roleName")
	WebElement roleNameTxtBox;
	
	@FindBy(id="roleDescription")
	WebElement roleDescriptionTxtBox;
	
	@FindBy(id="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@name='selectedUserRole']")
	WebElement selectedUserChkBox;
	
	@FindBy(xpath="//label[contains(text(),'Search')]")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//select[@class='combobox']")
	WebElement hierarchyLevel;
	
	@FindBy(xpath="//label[contains(text(),'BULK UPDATE')]")
	WebElement bulkUpdateBtn;
	

	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//table[@id='CommonDataTableId']/tbody/tr/td[5]")
	WebElement roleTypeData;
	
	@FindBy(id="workTime")
	WebElement workTimeChkBox;
	
	@FindBy(id="workTimeLi")
	WebElement workTimeModuleBtn;
	
	@FindBy(id="selfRdBtnId")
	WebElement selfRadioBtn;
	
	@FindBy(id="bothPermissionTd")
	WebElement memberDirectlyToMe;
	
	@FindBy(id= "directIndirectPermissionTd")
	WebElement memberIndirectlyToMe;
	
	@FindBy(id="allowEmailExport")
	WebElement allowEmailExportChkBox;
	
	@FindBy(id="allowOnDemand")
	WebElement allowOnDemandChkBox;
	
	@FindBy(id="allowRecipientList")
	WebElement allowRecipientListChkBox;
	
	@FindBy(id= "drilldown-container_2")
	WebElement drillDownBtn;
	
	@FindBy(xpath="//span[contains(text(),'Role Permissions')]")
	WebElement rolePermissionBtn;
	
	@FindBy(id="moduleId")
	WebElement moduleIdDrpDwn;
	
	@FindBy(id="chk_level_R_305")
	WebElement editRatingChkBox;
	
	@FindBy(xpath="//span[contains(text(),'User Group Widgets')]")
	WebElement userGroupWidgetsBtn;
	
	
	 public UserRolePage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 public void clickAddNewBtn()
	 {
		 this.addnewBtn.click();
	 }
	 
	 public void selectManagerRadioBtn()
	 {
		 this.managerRadioBtn.click();
	 }
	 
	 public void selectMemberRadioBtn()
	 {
		 this.memberRadioBtn.click();
	 }
	 
	 public void inputRoleNameTxtBox(String Name)
	 {
		 this.roleNameTxtBox.sendKeys(Name);
	 }
	 
	 public void inputRoleDescrptionTxtBOx(String description)
	 {
		 this.roleDescriptionTxtBox.sendKeys(description);
	 }
	 
	 public void clickOnSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 public void clickOnDeleteBtn()
	 {
		 this.deleteBtn.click();
	 }
	 
	 public void clickSelectedUserChkBox()
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.selectedUserChkBox);
	 }
	 
	 public void clickSearchTxtBox(String name)
	 {
		 this.searchTxtBox.sendKeys(name);
	 }
	 
	 public String getTextHierarchy()
	 { 
		 Select comboBox = new Select(this.hierarchyLevel);
		 System.out.println(comboBox);
		 String selectedComboValue = comboBox.getFirstSelectedOption().getText();
		 System.out.println("the value is :"+selectedComboValue);
		 return selectedComboValue;
		 
	 }
	 
	 public void setHierarchyLevelChange()
	 {
		//((JavascriptExecutor) driver).executeScript("return document.getElementById('select_899').selectedValue = "+ DIRECT_INDIRECT +);
		 //Select hierarchyLevel = new Select(this.hierarchyLevel);
		 //hierarchyLevel.selectByValue("DIRECT_INDIRECT");
		 this.hierarchyLevel.sendKeys("Members who directly or indirectly report into me");
	 }
	 
	 public void clickBilkUpdateBtn()
	 {
		 this.bulkUpdateBtn.click();
	 }
	 
	 public void clickRolePermissionBtn()
	 {
		 this.rolePermissionBtn.click();
	 }
	 
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 public String getRoleTypeData()
	 {
		 return this.roleTypeData.getText();
	 }
	 
	 public void selectModule() throws InterruptedException
	 {
		 if(this.workTimeChkBox.isSelected())
		 {
			 this.workTimeChkBox.click();
			 System.out.println("i am pavana");
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 driver.findElement(By.id("module_96")).click();
		 }
		 else
		 {
			 //Actions act = new Actions(driver);
			 //WebElement ele = driver.findElement(By.id("workTime"));
			 //act.doubleClick(ele).perform();
			 this.workTimeChkBox.click();
			 //Thread.sleep(3000);
			 this.workTimeChkBox.click();
			 //this.workTimeChkBox.click();
			 Thread.sleep(1000);
			 System.out.println("hellloooooooooo1");
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 System.out.println("hellloooooooooo2");
			 driver.findElement(By.id("module_96")).click();
			 //driver.findElement(By.xpath("//label[contains(text(),\"ACTIVITY DASHBOARD\")]")).click();
			 //driver.findElement(By.xpath("//label[contains(text(),\"WORKLOAD ANALYSIS\")]")).click();
			 //driver.findElement(By.xpath("//label[contains(text(),\"ATTENDANCE\")]")).click();
		 }
	 }
	 
	 public void selectWorkTimeModule()
	 {
		 this.workTimeModuleBtn.click();
	 }
	 
	 public boolean checkMeOnlyRdBtnIsSelected()
	 {
		 return this.selfRadioBtn.isSelected();
	 }
	 
	 public void selectMembersDirectlyToMeIsSelected()
	 {
		 this.memberDirectlyToMe.click();
	 }
	 
	 public boolean checkMembersDirectlyToMeIsSelected()
	 {
		 return this.memberDirectlyToMe.isSelected();
	 }
	 
	 public void checkallowEmailExportChkBoxIsEnabled()
	 {
		 if( this.allowEmailExportChkBox.isSelected())
		 {
			 System.out.println("Email option is already checked");
		 }
		 else
		 {
			 this.allowEmailExportChkBox.click();
		 }
	 }
	 
	 public void clickOnDrillDownBtn()
	 {
		 this.drillDownBtn.click();
	 }
	 
	 public void checkOnDemandMailIsEnabled()
	 {
		 if(driver.findElement(By.id("allowOnDemand")).isSelected())
		 {
			 System.out.println("On Demand Email option is already checked");
		 }
		 else
		 {
			 driver.findElement(By.id("allowOnDemand")).click();
		 }
	 }
	 
	 public void disableOnDemandMailRadioBtn()
	 {
		 if(driver.findElement(By.id("allowOnDemand")).isSelected())
		 {
			 driver.findElement(By.id("allowOnDemand")).click();
			 
		 }
		 else
		 {
			 System.out.println("On Demand Email option is diabled");
		 }
	 }
	 
	 public void exportexcelBtnToBeDisabled() throws InterruptedException
	 {
		if(driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).isDisplayed())
		{
			
			Thread.sleep(2000);
		
		  driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).click();
		}
		else
		{
			try {
				
				driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).click();
			}
			catch(NoSuchElementException x)
			{
				System.out.println("Element is disabled as expected");
			}
			
			String actual = driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]")).getText();
			
			Assert.assertEquals("You do not have permission to download this content", actual);
			// driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]"));
		}
	 }
	 
	 public void exportPDFBtnToBeDisabled()
	 {
			if(driver.findElement(By.xpath("//img[@title='Export to PDF']")).isDisplayed())
			{
			
			  driver.findElement(By.xpath("//img[@title='Export to PDF']")).click();
			}
			else
			{
				try {
					
					driver.findElement(By.xpath("//img[@title='Export to PDF']")).click();
					String actual = driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]")).getText();
					Assert.assertEquals("You do not have permission to download this content", actual);
				}
				catch(NoSuchElementException x)
				{
					System.out.println("Element is disabled as expected");
				}
				//String actual = driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]")).getText();
				
				
				// driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]"));
	 }
	 }
	 
	 public void clickUserRolePrmissionBtn()
	 {
		 this.rolePermissionBtn.click();
	 }
	 
	public void selectModuleIdDrpDwn()
	{
		 Select comboBox = new Select(this.moduleIdDrpDwn);
		 comboBox.selectByValue("1");
	}
	
	public void enableEditActivityRatingChkBox()
	{
		if(this.editRatingChkBox.isSelected())
		{
			System.out.println("Activity rating chkbox is already enabled");
		}
		else
			this.editRatingChkBox.click();
	}
	
	public void clickUserGroupWidgets()
	{
		this.userGroupWidgetsBtn.click();
	}
		 
	
	 
}
