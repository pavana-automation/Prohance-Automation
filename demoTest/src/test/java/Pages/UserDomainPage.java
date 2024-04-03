package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDomainPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	WebElement addNewBtn;
	
	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchTxtBx;
	
	@FindBy(xpath="//img[@title='Export to Excel']")
	WebElement exportExcelBtn;
	
	@FindBy(xpath="//img[@title='Export to PDF']")
	WebElement exportPdfBtn;
	
	@FindBy(id="domainName")
	WebElement domainNameTxtBx;
	
	@FindBy(id="domainDescription")
	WebElement domainDescriptionTxtBx;
	
	@FindBy(id="hostName")
	WebElement hostNameTxtBx;
	
	@FindBy(id="port")
	WebElement portTxtBx;
	
	@FindBy(id="domain")
	WebElement domainTxtBx;
	
	@FindBy(id="isSSL")
	WebElement isSSLChkBx;
	
	@FindBy(id="enableSync")
	WebElement enableSyncChkBx;
	
	@FindBy(id="userName")
	WebElement userNameTxtBx;
	
	@FindBy(name="password")
	WebElement passwordTxtBx;
	
	@FindBy(id="connString")
	WebElement connStringTxtBx;
	
	@FindBy(xpath="//input[@class='btn btn-save btn-save-padded']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@onclick='fnClearForm(this.form)']")
	WebElement clearBtn;
	
	@FindBy(xpath="//input[@value=\"TEST CONNECTION\"]")
	WebElement testConnectionBtn;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement testConnAlertOkBtn;
	
	@FindBy(xpath="//th[contains(text(),'Domain Alias')]")
	WebElement domainAliasHeaderBtn;
	
	@FindBy(xpath="//button[@class='btn btn-save btn-save-padded alert-btn-save']")
	WebElement deleteConfirmationBtn;
	
	@FindBy(xpath="//table[@class='dataTable no-footer']/thead/tr/th[3]")
	WebElement UserRoleName;
	
	 public UserDomainPage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 public void clickaddNewBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(addNewBtn));
		 this.addNewBtn.click();
	 }
	 
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 public void clickDeleteBtn() throws InterruptedException
	 {
		 this.deleteBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(deleteConfirmationBtn));
		 this.deleteConfirmationBtn.click();
	 }
	 
	 public void clickSearchTxtBx()
	 {
		 this.searchTxtBx.click();
	 }
	 
	 public void clickExportToExcelBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(exportExcelBtn));
		 this.exportExcelBtn.click();
	 }
	 
	 public void clickExportToPdfBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(exportPdfBtn));
		 this.exportPdfBtn.click();
	 }
	 
	 public String  inputDomainName(String result)
	 {
		 this.domainNameTxtBx.clear();
		 this.domainNameTxtBx.sendKeys(result);
		return result;
	 }
	 
	 public void inputDomainDescriptionTxtBx(String description)
	 {
		 this.domainDescriptionTxtBx.sendKeys(description);
	 }
	 
	 public void inputHostName(String hostname)
	 {
		 this.hostNameTxtBx.sendKeys(hostname);
	 }
	 
	 public void inputPortTxtBx(String port)
	 {
		 this.portTxtBx.sendKeys(port);
	 }
	 
	 public void inputDomainTxtBx(String domain)
	 {
		 this.domainTxtBx.sendKeys(domain);
	 }
	 
	 public void selectSSLChkBx()
	 {
		//this.isSSLChkBx.click();
		//new WebDriverWait(driver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@formcontrolname='reportingDealPermission' and @ng-reflect-name='reportingDealPermission']"))).click();
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("isSSL"))).click();
		
		WebElement ele = driver.findElement(By.id("isSSL"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	 }
	 
	 public void selectEnableSyncData()
	 {
		//this.enableSyncChkBx.click();
		WebElement ele = driver.findElement(By.id("enableSync"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		 
	 }
	 
	 public void inputUserName(String name)
	 {
		 this.userNameTxtBx.sendKeys(name);
	 }
	 
	 public void inputPassword(String password)
	 {
		 this.passwordTxtBx.sendKeys(password);
	 }
	 
	 public void inputConnString(String connstring)
	 {
		 this.connStringTxtBx.sendKeys(connstring);
	 }
	 
	 public void clickSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 public void clickClearBtn()
	 {
		 this.clearBtn.click();
	 }
	 
	 public void clickTestConnectionBtn() throws InterruptedException
	 {
		 this.testConnectionBtn.click();
		 Thread.sleep(50000);
		 this.testConnAlertOkBtn.click();
	 }
	 
	 public ArrayList<String> getElementsInRowToList() throws InterruptedException
	 {
		Thread.sleep(2000); 
		 int rowCount = driver.findElements(By.xpath("//*[@id='CommonDataTableId']/tbody/tr")).size();
			System.out.println("total rows in table "+rowCount);
			
			int j=0;
			ArrayList<String> getElements = new ArrayList<String>(rowCount);
			for(int i=1;i<rowCount+1;i++)
			{
				
				WebElement names =driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[2]"));
				if(j<rowCount)
				{
					getElements.add(names.getText());
					j++;
				}
			}
		//Arrays.sort(getElements, Collections.reverseOrder());
		Collections.sort(getElements, Collections.reverseOrder());
		
		
		//return Arrays.toString(getElements);
		return getElements;
		 
	 }
	 
	 
	 public void clickDomainAliasHeaderBtn()
	 {
		 this.domainAliasHeaderBtn.click();
	 }
	 
	 public void clickUserRoleNameBtn()
	 {
		 this.UserRoleName.click();
	 }
	 
	 public ArrayList<String> getElementsInRowToList1() throws InterruptedException
	 {
		Thread.sleep(2000); 
		 int rowCount = driver.findElements(By.xpath("//*[@id='CommonDataTableId']/tbody/tr")).size();
		 System.out.println("total rows in table "+rowCount);
			
			int j=0;
			ArrayList<String> getElements = new ArrayList<String>(rowCount);
			for(int i=1;i<rowCount+1;i++)
			{
				
				WebElement names =driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[3]"));
				if(j<rowCount)
				{
					getElements.add(names.getText());
					j++;
				}
			}
			Collections.sort(getElements, Collections.reverseOrder());
			return getElements;
	 }
	

}
