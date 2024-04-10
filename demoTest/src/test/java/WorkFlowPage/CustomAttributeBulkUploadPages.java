package WorkFlowPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomAttributeBulkUploadPages {
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),\"WORKFLOW\")]")
	WebElement workflow;
	
	@FindBy(xpath = "//a[contains(text(),\"Administration\")]")
	WebElement administration;
	
	@FindBy(xpath = "//li[contains(text(),\"Custom Attributes\")]")
	WebElement customAttribute;
	
	@FindBy(xpath = "//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement bulkUpload;
	
	@FindBy(id = "showProcess_EP")
	WebElement tempWithData;
	
	@FindBy(xpath = "//tr[@id =\"downloadTR\"]/td/span[contains(text(),\"Click here\")]")
	WebElement clickHere;
	
	@FindBy(xpath = "//table[@id='uploadTable']/tbody/tr[1]/td[2]/div/span/span/span/input[@id=\"file_id\"]")
	WebElement chooseFileBtn;
	
	@FindBy(name = "upload")
	WebElement upload;
	
	@FindBy(xpath = "//div[@id=\"message-area\"]/div/span")
	WebElement successMsg;

	@FindBy(xpath = "//div[@id=\"message-area\"]/div/span")
	WebElement failMsg;
	
	@FindBy(id = "processListId")
	WebElement filterByProcess;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/span")
	List<WebElement> getProcessList;
	
	
	 public CustomAttributeBulkUploadPages(WebDriver driver) {
		  
		  this.driver=driver; PageFactory.initElements(driver,this);
		  
		  }
	 public void clickWorkFlowBtn()
	 {
		 this.workflow.click();
	 }
	
	 public void switchTabs()
	 {

		  ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      
	 }
	 public void scrollSideNavigationBar() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Administration')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", Element);
		}
	 public void clickAdministrationBtn()
	 {
		 this.administration.click();
	 }
	 public void clickCustomAttribute()
	 {
		 this.customAttribute.click();
	 }
	 public void clickBulkUpload()
	 {
		 this.bulkUpload.click();
	 }
	 public void clickTempWithData()
	 {
		 this.tempWithData.click();
	 }
	 public void clickClickHereBtn()
	 {
		 this.clickHere.click();
	 }
	 public String clickChooseFileBtn(String url) throws InterruptedException {
			System.out.println("enter");
			System.out.println(url);
			WebElement  choose = this.chooseFileBtn;
			choose.sendKeys(url);
			this.upload.click();
			return url; 

		}
	 public boolean clickSuccessMsg()
	 {
		 String ms = this.successMsg.getText();
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Uploadwassuccessful";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	 
	 public boolean getFailMsg() {
			String ms = this.failMsg.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Uploadcompletedwitherror(s)";
			boolean check = msg.equals(compareMsg);
			return check;

		}
	 public void selectFilterByProcess(String user) {
			Select clickAssUser = new Select(this.filterByProcess);
			clickAssUser.selectByVisibleText(user);
		}
	 public List<String> GetUserArrtribute() {
		 	List<WebElement> col = null;
			List<String> teamsList = new ArrayList();
			col = this.getProcessList;
			int len = col.size();
			System.out.println(len);
			for (int i = 0; i < len; i++) {
				teamsList.add(this.getProcessList.get(i).getText().replaceAll("\\s+", ""));
				// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
			}
			System.out.println(teamsList);
			return teamsList;
		}

}
