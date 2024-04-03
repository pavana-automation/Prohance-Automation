package AssertOptimizationPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkStationGroupsPages {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),\"ASSET OPTIMIZATION\")]")
	WebElement assertOptimization;
	
	@FindBy(xpath = "//ul/li[contains(text(),'Workstation Groups')]")
	WebElement workStationGroups;
	
	@FindBy(xpath = "//a/span[contains(text(),'Administration')]")
	WebElement administration;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addNew;
	
	@FindBy(id = "WSGroupId")
	WebElement name;
	
	@FindBy(id = "descriptionId")
	WebElement description;
	
	@FindBy(xpath = "//tr[@id =\"enableGeoLocationRowId\"]/td[2]/div/label")
	WebElement location;
	
	@FindBy(xpath = "//td[@class =\"wizard-tab-buttons\"]/input[2]")
	WebElement saveBtn;
	
	@FindBy(id = "scanIntervalId")
	WebElement scanTime;
	
	@FindBy(id = "isActiveId")
	WebElement active;
	
	@FindBy(xpath = "//label[contains(text(),\"BACK\")]")
	WebElement back;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[1]")
	WebElement modifyBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[2]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//span[contains(text(),\"Associate Clients\")]")
	WebElement associateClients;
	
	
	@FindBy(id = "addApps")
	WebElement addClient;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td/div/label")
	WebElement selectClient;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement addMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement modifyMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement deleteMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/a")
	WebElement closeXIconBtn;
	
	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement popupMsg;
	
	@FindBy(xpath = "//td[@class =\"wizard-tab-buttons\"]/input[1]")
	WebElement clear;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td/span[1]")
	WebElement Clearmodify;
	
	
	public WorkStationGroupsPages(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void switchTabs() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

	}

	public void scrollSideNavigationBar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a/span[contains(text(),'Administration')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	public void clickAdministration()
	{
		this.administration.click();
	}
	
	public void clickAssertOptimization() {
		this.assertOptimization.click();
	}
	
	public void clickWorkStationGroups()
	{
		this.workStationGroups.click();
	}
	
	public void clickAddNew()
	{
		this.addNew.click();
	}
	
	public void clickName(String name)
	{
		this.name.sendKeys(name);
	}
	
	public void clickDescription(String desc)
	{
		this.description.sendKeys(desc);
	}
	
	public void clickLocation()
	{
		//this.location.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.location);
	}
	
	public void clickSAVEBtn()
	{
		this.saveBtn.click();
	}
	
	public void clickScanTime(String time)
	{
		this.scanTime.clear();
		this.scanTime.sendKeys(time);
	}
	
	public void clickActive()
	{
		//this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.active);
	}
	
	public void clickBackBtn()
	{
		this.back.click();
	}
	
	public void clickModifyBtn()
	{
		this.modifyBtn.click();
	}
	
	public void clickDeleteBtn()
	{
		this.deleteBtn.click();
	}
	
	public void clickYESBtn() {
		this.yesBtn.click();
	}
	
	public void clickAssociateClients()
	{
		this.associateClients.click();
	}
	
	public void clickAddClientBtn()
	{
		this.addClient.click();
	}
	
	public void checkCheckBoxJavaScipt(WebElement locator) {
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected()) {
			jsexecutour.executeScript("arguments[0].click();", locator);
		}

	}

	public void clickSelectSuperClient() throws InterruptedException {
		Thread.sleep(6000);
		checkCheckBoxJavaScipt(selectClient);

	}
	public void moveToAddPage() {

		Set<String> handles = this.driver.getWindowHandles();
		Iterator it = handles.iterator();
		String parentwindow = (String) it.next();
		String childwindow = (String) it.next();
		driver.switchTo().window(childwindow);

	}
	

	public void moveToparentWindow() {

		System.out.println("parent window");
		Set<String> ids = this.driver.getWindowHandles();
		Iterator<String> i = ids.iterator();
		String parentID = i.next();
		while (i.hasNext()) {
			String childID = i.next();
			this.driver.switchTo().window(childID);
		}

		this.driver.switchTo().window(parentID);

	}
	public boolean clickAddMsg()
	 {
		 String ms = this.addMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "WorkstationGroup:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public boolean clickModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "WorkstationGroup:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public boolean clickDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "WorkstationGroup:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public void clickCloseXIconBtn()
	{
		this.closeXIconBtn.click();
	}
	
	
	public boolean clickRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "Nameisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public void Clearmodify()
	{
		this.Clearmodify.click();
	}
	
	public void clicksCLEARBtn()
	{
		this.clear.click();
	}
	public boolean clickScanRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "ScanIntervalisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
}
