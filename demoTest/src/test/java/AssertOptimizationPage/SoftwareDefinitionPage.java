package AssertOptimizationPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SoftwareDefinitionPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//ul/li[contains(text(),'Software Definition')]")
	WebElement softwareDefinition;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addNew;
	
	@FindBy(id = "softwareNameId")
	WebElement name;
	
	@FindBy(id = "descriptionId")
	WebElement des;
	
	@FindBy(id = "associatedProcessId")
	WebElement associate;
	
	@FindBy(id = "class1")
	WebElement activity;
	
	@FindBy(id = "ignoresoftwareId")
	WebElement ignore;
	
	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[2]")
	WebElement save;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement addMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement modifyMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement deleteMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/a")
	WebElement closeXIconBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[1]")
	WebElement modifyBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[2]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//label[contains(text(),\"SOFTWARE TAGS\")]")
	WebElement softwareTags;
	
	@FindBy(id = "name")
	WebElement sName;
	
	@FindBy(id = "description")
	WebElement sDescription;
	
	@FindBy(xpath = "//td[@class =\"tab-buttons\"]/input[2]")
	WebElement sSave;
	
	@FindBy(xpath = "//td[@class =\"tab-buttons\"]/input[1]")
	WebElement sClear;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td/span[1]")
	WebElement sClearmodify;
	
	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement popupMsg;
	
	@FindBy(xpath = "//label[contains(text(),\"SOFTWARE TAG CLASSIFICATION\")]")
	WebElement softwatetab;
	
	@FindBy(xpath = "//table[@class =\"configtable table-bordered-tb\"]/tbody/tr[2]/td[2]/div/label")
	WebElement activityTag;
	
	@FindBy(xpath = "//div[@id=\"SWTagsId\"]/div/div/div/div/div/div[2]/button")
	WebElement cancelButton;
	
	@FindBy(xpath = "//select[@id=\"tagId\"]/option")
	WebElement activityTagOption;
	
	@FindBy(xpath = "//td[contains(text(),\"Activity Tag\")]")
	WebElement activitytag;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[1]")
	WebElement modifyForactivity;
	
	@FindBy(xpath ="//div[@id=\"arrow-bot\"]/i")
	WebElement bottomArrom;
	
	@FindBy(xpath ="//select[@id =\"class1\"]/option")
	List<WebElement> activityList;
	
	public SoftwareDefinitionPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void clickSoftwareDefinition()
	{
		this.softwareDefinition.click();
	}
	
	public void clickAddNewBtn()
	{
		this.addNew.click();
	}
	public void clickName(String name)
	{
		this.name.sendKeys(name);
	}
	
	public void clickDescription(String def)
	{
		this.des.sendKeys(def);
	}
	
	public void clickAssociateProcess(String associate)
	{
		this.associate.sendKeys(associate);
	}
	public void selectTag(String activity) {
		Select clickRole = new Select(this.activity);
		clickRole.selectByVisibleText(activity);
	}
	
	public void clickIgnoreChkBox()
	{
		this.ignore.click();
	}
	
	public void clickSAVEBtn()
	{
		this.save.click();
	}
	public boolean clickAddMsg()
	 {
		 String ms = this.addMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			 System.out.println(msg);
			String compareMsg = "SoftwareDefinition:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public boolean clickModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "SoftwareDefinition:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public boolean clickDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "SoftwareDefinition:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public boolean clicksAddMsg()
	 {
		 String ms = this.addMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			 System.out.println(msg);
			String compareMsg = "SoftwareTag:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public boolean clicksModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "SoftwareTag:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public boolean clicksDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "SoftwareTag:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }

	public void clickCloseXIconBtn()
	{
		this.closeXIconBtn.click();
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
	
	public void clikSoftwareTagsBtn()
	{
		//this.softwareTags.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.softwareTags);
	}
	
	public String clickSName(String name)
	{
		this.sName.sendKeys(name);
		return name;
	}
	
	public void clickSDescription(String des)
	{
		this.sDescription.sendKeys(des);
	}
	public void clickSDescriptionForModify()
	{
		this.sDescription.clear();
	}
	
	public void clicksSAVEBtn()
	{
		this.sSave.click();
	}
	
	public void sClearmodify()
	{
		this.sClearmodify.click();
	}
	
	public void clicksCLEARBtn()
	{
		this.sClear.click();
	}
	public boolean clickSoftwareRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "SoftwareTagisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public boolean clickAssociateRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "AssociatedProcessesisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public void clickSoftwareTabBtn()
	{
		this.softwatetab.click();
	}
	
	public boolean clickActivityTab()
	{
		boolean check1 = this.activityTag.isEnabled();
		System.out.println(check1);
		return check1;
		
	}
	public void clickCancelButton()
	{
		this.cancelButton.click();
	}
	public boolean clickActivityTagOption()
	{
		boolean check = this.activityTagOption.isDisplayed();
		System.out.println(check);
		return check;
	}
	
	public boolean clickActivityTag()
	{
		boolean check = this.activitytag.isDisplayed();
		System.out.println(check);
		return check;
	}
	
	public void clickModifyForactivity()
	{
		this.modifyForactivity.click();
	}
	
	public void clickBottomBtn()
	{
		this.bottomArrom.click();
	}
	public  List<String> getWorkProfilesName()
	 {
		 List <WebElement> col = null;
		 List<String> teamsList = new ArrayList();
		 col = this.activityList;
		 int len = col.size();
		  for(int i = 1;i<len;i++)
		  {
			  teamsList.add(this.activityList.get(i).getText().replaceAll("\\s+",""));
			 
		  }
		 System.out.println(teamsList);
		  return teamsList;
	 }
	 
}
