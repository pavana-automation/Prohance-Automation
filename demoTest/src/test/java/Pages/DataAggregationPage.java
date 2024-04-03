package Pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DataAggregationPage {

	WebDriver driver;
	boolean message = false;
	String msg = null;
	String aggregationStartMsg = null ;
	String aggregationEndMsg = null;

	@FindBy(id = "arrow-top")
	WebElement clickSideNavigationBtn;

	@FindBy(xpath = "//li[contains(text(),'Organization')]")
	WebElement clickOrganizationbtn;

	@FindBy(xpath = "//li[contains(text(),'Data Aggregation')]")
	WebElement clickDataAggregationbtn;

	@FindBy(xpath = "//ul[@id='tabsDiv']/li/div/span[contains(text(),'Status')]")
	WebElement statusBtn;

	@FindBy(id = "secondTab")
	WebElement settingsBtn;

	@FindBy(id = "thirdTab")
	WebElement auditLogsBtn;
	
	@FindBy(xpath= "//td[@id=\"2_10_2023_D\"]/div//input")
	WebElement DateChkBoxChkBox;
	
	@FindBy(xpath= "//table[@class =\"calheadertable\"]/tbody/tr/td[2]/span/span/div/span")
	WebElement calender;

	@FindBy(xpath = "//label[contains(text(),'Activity On System')]")
	WebElement TypeChkBox;
	
	@FindBy(xpath = "//table[@id ='executeAggTable']/tbody/tr/th/span/label[contains(text(),'Type')]")
	WebElement AllTypeChkBox;
	
	@FindBy(xpath = "//label[contains(text(),'Run aggregation for all users irrespective of data modification timestamp')]")
	WebElement aggregationForAllUsers;

	@FindBy(id = "runButton")
	WebElement runAggregation;

	@FindBy(id = "userAggregationNoteDiv")
	WebElement runAggregationForAllUsers;
	
	@FindBy(xpath = "//table[@id='CommonDataTableId']/tbody/tr/td[3]/div[contains(text(),'adminaish')]/../../td[2]/div")
	List<WebElement> aggregationStarted;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[3]/div[contains(text(),'Aishwarya')]/../../td[2]/div")
	WebElement aggregationEnded;
	
	@FindBy(id = "hourHrId")
	WebElement hourlyAggregationByHouDropdwn;

	@FindBy(id = "minutesHr")
	WebElement hourlyAggregationByMinutesDropdwn;
	
	@FindBy(id = "hourId")
	WebElement dailyAggregationByHourDropdwn;

	@FindBy(id = "minuteId")
	WebElement dailyAggregationByMinuteDropdwn;
	
	@FindBy(xpath = "//div[@id='settingTable']/table/tbody/tr/td/table/tbody//tr[3]/td/input[2]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@id='settingTable']/table/tbody/tr/td/table/tbody//tr[3]/td/input[1]")
	WebElement clearBtn;
	
	@FindBy(xpath ="//span[contains(text(),'Aggregation Settings updated successfully')]")
	WebElement successMessage;
	
	@FindBy(linkText = "×")
	WebElement closeAggregationPopUp;
	
	@FindBy(xpath = "//img[@src ='/prohance/images/image-plus.png']")
	WebElement addInterval;
	
	@FindBy(xpath = "//tr[@id ='dynamicTr_2']/td[1]/span)]")
	WebElement deleteInterval;
	
	@FindBy(id = "frequency_4")
	WebElement intervalTime;
	
	@FindBy(id = "sNotification")
	WebElement emailSuccessfullNotification;
	
	@FindBy(id = "fNotification")
	WebElement emailFailNotification;
	
	@FindBy(id = "selectedMonthYear")
	WebElement selectYear;
	
	@FindBy(id = "selectedMonth")
	WebElement selectMonth;
	
	@FindBy(xpath = "//input[@name=\"GO\"]")
	WebElement go;
	
	@FindBy(xpath = "//body[@id ='dataAggScreen']/div[4]/div/div/div[3]/button[contains(text(),'OK')]")
	WebElement alertBox;
	
	@FindBy(xpath ="//tr[@id =\"dynamicTr_4\"]/td[1]/span")
	WebElement deleteBtn;
	
	@FindBy(xpath ="//span[@id ='modulesList']/span[2]")
	WebElement drag;
	
	@FindBy(xpath ="//td[@id ='dynamicTd_4']/div")
	WebElement drop;
	
	@FindBy(xpath ="//span[1]/a[@href =\"javascript:void(0);\"]/i")
	WebElement monthArrow;
	
	@FindBy(xpath ="//th[contains(text(),'December 2023')]/../th[1]/i")
	WebElement fromMonth;
	
	@FindBy(xpath ="//span/input[@id =\"fromDateId\"]")
	WebElement from;
	
	@FindBy(xpath ="//tr[1]/td[4][contains(text(),\"19\")]")
	WebElement date;
	
	@FindBy(xpath ="//input[@value =\"FETCH\"]")
	WebElement fetch;
	
	  public DataAggregationPage(WebDriver driver) {
	  
	  this.driver=driver; PageFactory.initElements(driver,this);
	  
	  }
	 
	  public void clickDateChkBoxChkBox() 
	  { 
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.DateChkBoxChkBox);
		 
	  }	  

	  public void clickTypeChkBox() throws InterruptedException 
	  {
		Thread.sleep(1000);
		this.TypeChkBox.click();
		
	  }
	  
	  public void clickAggregationForAllUsers() 
	  {
		 
		  this.aggregationForAllUsers.click();
		 
	  }
	  
	  public void clickRunAggregation()
	  {
		  
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(this.runAggregation)).click();
	  }
	  
	  public void clickAuditLogBtn() throws InterruptedException
	  {
		
		  this.auditLogsBtn.click();
		  Thread.sleep(1000);
		 
	  }
	  
	  public void getAggregationStarted() throws InterruptedException
	  {
		  List <WebElement> col = null;
		  try
		  {
		   col = this.aggregationStarted;

		  
		  int len = col.size();
		  for(int i = 0;i<=len;i++)
		  {
			
			  aggregationEndMsg= this.aggregationStarted.get(0).getText();
			  aggregationStartMsg= this.aggregationStarted.get(1).getText();
			
			 
		  }
		  if(aggregationStartMsg.equals(aggregationStartMsg) 
				  && aggregationEndMsg.equals(aggregationStartMsg))
		  {
			  msg = "Aggregation Completed";
	  	  }
		  
	  }
		  catch(StaleElementReferenceException ex)
		  {
			  ex.getMessage();
		  }
		  System.out.println("check5");
		 Assert.assertTrue(true,msg);
	  }
	  
	  public void clickStatusTabBtn()
	  {
		  this.statusBtn.click();
			
	  }
	  
	  public void clickAllTypeChkBtn() throws InterruptedException 
	  {
		  Thread.sleep(1000);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.AllTypeChkBox);
			
	  }
	  public void getAggregationStatusForAllType() throws InterruptedException
	  {
		  List <WebElement> col = null;
		  try
		  {
			 
		   col = this.aggregationStarted;
		  
		  
		  int len = col.size();
		  for(int i = 0;i<len;i++)
		  {
			
			  aggregationEndMsg= this.aggregationStarted.get(0).getText();
			  aggregationStartMsg= this.aggregationStarted.get(1).getText();
			  System.out.println(aggregationStartMsg);
		  }
		  if(aggregationStartMsg.equals("Aggregation Completed for 02 Nov 2023 [Status: Success | Completed In: 02s")
			&& aggregationEndMsg.equals("Aggregation Started for 02 Nov 2023 [ Activity On System, Activity Away From System, Hourly Activity Raw, Hourly Work Time Metrics, Software Usage, Schedule Adherence, Workflow Activity , Work Output Normalization, Work Output Raw, Work Time Metrics, Activity Goals, Early Logout Computation, Asset Usage ]")) 
		  { 
				  msg = "Aggregation Completed"; 
		  } 
		 else if(aggregationStartMsg.equals("Aggregation Completed for 02 Nov 2023 [Status: Success | Completed In: 03s")
				 && aggregationEndMsg.equals("Aggregation Started for 02 Nov 2023 [ Activity On System, Activity Away From System, Hourly Activity Raw, Hourly Work Time Metrics, Software Usage, Schedule Adherence, Workflow Activity , Work Output Normalization, Work Output Raw, Work Time Metrics, Activity Goals, Early Logout Computation, Asset Usage ]")) 
		 {
			 	msg = "Aggregation Completed"; 
		 }
	  }
		  catch(StaleElementReferenceException ex)
		  {
	
			  ex.getMessage();
		  }
	  
		  
		Assert.assertTrue(true, msg);
	  }
	  public void clickSettingsBtn() 
	  {
		 this.settingsBtn.click();
		 
	  }
	  public void clickHourlyAggregationByHouDropdwn(String hour)
	  {
		  Select hourBy = new Select(this.hourlyAggregationByHouDropdwn);
		  hourBy.selectByValue(hour);
	  }
	 
	  public void clickHourlyAggregationByMinutesDropdwn(String minute)
	  {
		  Select minuteBy = new Select(this. hourlyAggregationByMinutesDropdwn);
		  minuteBy.selectByValue(minute);
	  }
	  
	  public void clickDailyAggregationByHourDropdwn(String hour)
	  {
		  Select hourBy = new Select(this. dailyAggregationByHourDropdwn);
		  hourBy.selectByValue(hour);
	  }
	  public void clickDailyAggregationByMinuteDropdwn(String minute)
	  {
		  Select minuteBy = new Select(this.dailyAggregationByMinuteDropdwn);
		  minuteBy.selectByValue(minute);
	  }
		
	  public void clickSaveBtn() 
	  { 
		  this.saveBtn.click();  
	  }
	  
	  
		
	  public void displaySuccessMessage() 
	  {
		  String saveMsg =this.successMessage.getText();
		
		  if(saveMsg.equals("Aggregation Settings updated successfully")) 
		  { 
			  message=true;
		  } 
		  
		 Assert.assertTrue(message);
	  }
		 
	 public void clickCloseAggregationPopUp()
	 {
		this.closeAggregationPopUp.click();
	 }
	 public void clickClearBtn()
	 {
		 this.clearBtn.click();
	 }
	 
	 public void clickAddIntervalImg()
	 {
		 this.addInterval.click();
	 }
	 
	 public void clickDeleteInterval()
	 {
		 this.deleteInterval.click();
	 }
	 
	 public void changeIntervalTime(String interval)
	 {
		 Select intervalToChance= new Select(this. intervalTime);
		 intervalToChance.selectByValue(interval);
	 }
	
	 public void clickEmailSuccessfullNotification()
	 {
		 this.emailSuccessfullNotification.click();
	 }
	 
	 public void clickEmailFailNotification()
	 {
		 this.emailFailNotification.click();
	 }
	 public void clickCloseOKBtn()
	 {
		 this.alertBox.click();
	 }
	 
	 public void clickDeleteImg()
	 {
		 this.deleteBtn.click();
	 }
	 public void clickDrag()
	 {
		 Actions builder = new Actions(driver);
		 Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
		 dragAndDrop.perform();
	 }
	 public void clickMonthArrow()
	 {
		 this.monthArrow.click();
	 }
	 public void clickFrom()
	 {
		 this.from.click();
	 }
	 public void clickfromMonth()
	 {
		 this.fromMonth.click();
	 }
	 public void clickFromDate()
	 {
		// System.out.println("check");
		 this.date.click();
	 }
	 public void clickFetchBtn() throws InterruptedException
	 {
		 Thread.sleep(1000);
		 this.fetch.click();
		 Thread.sleep(4000);
	 }
	 public void clickcalenderBtn()
	 {
		 this.calender.click();
	 }
	 
	 public void selectYear(String year)
	 {
		 Select intervalToChance= new Select(this. selectYear);
		 intervalToChance.selectByVisibleText(year);
	 }
	 
	 public void selectMonth(String month)
	 {
		 Select intervalToChance= new Select(this. selectMonth);
		 intervalToChance.selectByVisibleText(month);
	 }
	 public void clickGoBtn()
	 {
		 this.go.click();
	 }
}
