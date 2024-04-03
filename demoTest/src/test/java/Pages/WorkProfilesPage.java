package Pages;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WorkProfilesPage {

	boolean message = false;
	WebDriver driver;
	
	@FindBy(xpath= "//label[contains(text(),'ADD NEW')]")
	WebElement addNew;
	
	@FindBy(xpath= "//div[@id ='adminBodyContent']/form/div[2]/div/div/table/tbody/tr/td[2]/div/input")
	WebElement name;

	
	@FindBy(xpath= "//td/div/textarea[@id='workProfileDescription']")
	WebElement description;
	
	@FindBy(xpath= "//span[contains(text(),'Activities On System')]")
	WebElement activitiesOnSystem;
	
	@FindBy(xpath= "//span[contains(text(),'Activities Away From System')]")
	WebElement activitiesAwayFromSystem;
	
	@FindBy(xpath= "//span[contains(text(),'Activity Tags')]")
	WebElement activityTags;

	@FindBy(xpath= "//tr[@id ='applnDetailsTable']/td/table/tbody/tr/td[2]/select/option[2]")
	WebElement applicationName;
	
	@FindBy(xpath= "//tr[@id ='applnDetailsTable']/td/table/tbody/tr/td[2]/select/option[1]")
	WebElement applicationNameForModify;
	
	@FindBy(xpath= "//tr[@id ='idleTimeTable']/td/table/tbody/tr/td[2]/select/option[2]")
	WebElement awfs;
	
	@FindBy(xpath= "//tr[@id ='idleTimeTable']/td/table/tbody/tr/td[2]/select/option[1]")
	WebElement awfsForModify;
	
	@FindBy(xpath= "//tr[@id ='activityTagTable']/td/table/tbody/tr/td[2]/input")
	WebElement addBtn;
	
	@FindBy(xpath= "(//input[@name='activityTagSelectCheckbox'])[1]")
	WebElement selectActivityTag;
	
	@FindBy(xpath= "//button[contains(text(),'ADD')]")
	WebElement addActivityTagBtn;
	
	@FindBy(xpath= "//button[contains(text(),'CANCEL')]")
	WebElement cancelActivityTagBtn;
	
	@FindBy(xpath= "//tr[@id ='activityTagTable']/td/table/tbody/tr/td[1]/input")
	WebElement removeBtn;
	
	@FindBy(xpath= "//tr[@id ='applnDetailsTable']/td/table/tbody/tr/td[2]/input")
	WebElement addApplicationNameBtn;
	
	@FindBy(xpath= "//input[@id='rating_9_175']")
	WebElement ratingForAOS;
	
	@FindBy(xpath= "//tr[@id ='idleTimeTable']/td/table/tbody/tr/td[2]/input")
	WebElement addBtnForAWFS;
	
	@FindBy(xpath= "//input[@id ='itRating_7_48']")
	WebElement ratingBtnForAWFS;
	  
	@FindBy(xpath= "//input[@id ='saveImputId']")
	WebElement saveBtn;
	
	@FindBy(xpath= "//div[@id ='adminBodyContent']/form/div[2]/div/div/table[2]/tbody/tr/td/span[1]/input;")
	WebElement clearBtn;
	
	@FindBy(xpath ="//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td/a[1]/i")
	WebElement modifyBtn;
	
	@FindBy(xpath ="//td/div[contains(text(),\"0\")]/../../td[1]/a[2]/i")
	WebElement deleteBtn;
	
	@FindBy(xpath ="//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td[1]/a[2]/i")
	WebElement dependencyDeleteBtn;
	
	@FindBy(xpath ="//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td/a[3]/i")
	WebElement cloneBtn;
	
	@FindBy(xpath ="//button[contains(text(),\"OK\")]")
	WebElement activitytagPopUP;
	
	@FindBy(linkText = "×")
	WebElement closeAggregationPopUp;
	
	@FindBy(xpath ="//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath ="//span/span[contains(text(),\"Click here\")]")
	WebElement clickHereBtn;

	@FindBy(xpath ="//li/a[contains(text(),\"Users\")]")
	WebElement usersBtn;
	
	@FindBy(xpath ="//li[2][contains(text(),\"Teams\")]")
	WebElement teamsBtn;
	
	@FindBy(xpath ="//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/a[1]/i")
	WebElement teamsModifyBtn;
	
	@FindBy(xpath ="//select[@id =\"workProfileId\"]/option")
	List<WebElement> workProfilesName;
	
	@FindBy(xpath ="//span[contains(text() ,'All Work Profiles Configuration')]")
	WebElement allWorkProfileExcel;
	
	@FindBy(xpath ="//img[@src=\"/prohance/images/excel.png\"]")
	WebElement excel;
	
	@FindBy(xpath ="//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> nameList;
	
	@FindBy(xpath ="//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement pdf;
	
	@FindBy(xpath ="//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> teams;
	
	@FindBy(xpath ="//li/label[contains(text(),\"BACK\")]")
	WebElement backBtn;

	@FindBy(xpath ="//div[@id=\"arrow-bot\"]/i")
	WebElement bottomArrom;
	//th[contains(text(),"#Teams")]
	@FindBy(xpath ="//th[contains(text(),\"#Teams\")]")
	WebElement teamsSorting;
	
	public WorkProfilesPage(WebDriver driver) {
		  
		  this.driver=driver; PageFactory.initElements(driver,this);
		  
		  }
	public void scrollSideNavigationBar()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Business Hierarchy')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	public void clickAddNewBtn()
	{
		this.addNew.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void FillNameTxtBox(String name)
	{
		//this.name.sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.name)).sendKeys(name);
	}
	
	
	public void checkCheckBoxJavaScipt(WebElement locator) {
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected()) {
			jsexecutour.executeScript("arguments[0].click();", locator);
		}

	}
	public void FillDescriptionTxtbox(String des)
	{
		//this.description.sendKeys(des);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.description)).sendKeys(des);
	}
	public void clearDescription()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.description)).clear();
	}
	public void clickSaveBtn()
	{
		this.saveBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void clickAOSBtn()
	{
		this.activitiesOnSystem.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void  selectApplicationName()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.applicationName.click();
	}
	public void clickOnAddApplicationName()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.addApplicationNameBtn.click();
	}
	
	public void selectRatingForAOS()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//this.ratingForAOS.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(this.ratingForAOS)).click();
	}
	
	public void clickAWFSBtn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.activitiesAwayFromSystem.click();
	}
	public void selectAWFS()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Select appName = new Select(this.awfs);
//		appName.selectByValue(name);
		this.awfs.click();
	}
	public void clickAddBtnOnAWFS()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.addBtnForAWFS.click();
	}
	
	public void selectRatingForAWFS()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.ratingBtnForAWFS.click();
	}
	
	public void clickActivityTagsBtn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.activityTags.click();
	}
	
	public void clickAddOnActivityTagsBtn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.addBtn.click();
	}
	public void moveToAddPage()
	{
		
		Set<String> handles = this.driver.getWindowHandles();
		Iterator it = handles.iterator();
		String parentwindow = (String) it.next();
		String childwindow = (String) it.next();
		driver.switchTo().window(childwindow);
		
	}
	public void clickToAddActivityTag()
	{
		checkCheckBoxJavaScipt(selectActivityTag);
	}
	public void moveToparentWindow()
	{
		
		System.out.println("parent window");
		Set<String> ids = this.driver.getWindowHandles();
	    Iterator<String> i = ids.iterator();
	    String parentID = i.next(); 
	    while(i.hasNext())
	    {
	        String childID = i.next(); 
	        this.driver.switchTo().window(childID); 
	    }

	    this.driver.switchTo().window(parentID); 
		
	}
	public void clickAddActivityTagBtn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.addActivityTagBtn.click();
		
	}
	public void clickModifyBtn()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.modifyBtn.click();
	}
	public void clickApplicationNameForModify()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.applicationNameForModify.click();
	}
	
	public void clickAwfsForModify()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.awfsForModify.click();
	}
	public void clickActivitytagPopUP()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.activitytagPopUP.click();
	}

	 public void clickCloseAggregationPopUp()
	 {
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		this.closeAggregationPopUp.click();
	 }
	 public void clickDeleteBtn()
	 {
		 this.deleteBtn.click();
	 }
	 public void clickYesBtn()
	 {
		 this.yesBtn.click();
	 }
	 public void clickCloneBtn()
	 {
		 this.cloneBtn.click();
	 }
	 public void clickDependencyDeleteBtn()
	 {
		 this.dependencyDeleteBtn.click();
	 }
	 public void clickClickHereBtn()
	 {
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 this.clickHereBtn.click();
	 }
	 public void clickUsersBtn()
	 {
		 this.usersBtn.click();
	 }
	 public void clickTeamsBtn()
	 {
		 this.teamsBtn.click();
	 }
	 public void clickOnTeamsModifyBtn()
	 {
		// this.teamsModifyBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOf(this.teamsModifyBtn)).click();;
	 }
	 public  Set<String> getWorkProfilesName()
	 {
		 List <WebElement> col = null;
		 Set<String> teamsList = new TreeSet();
		 col = this.workProfilesName;
		 int len = col.size();
		  for(int i = 1;i<len;i++)
		  {
			  teamsList.add(this.workProfilesName.get(i).getText().replaceAll("\\s+",""));
			 
		  }
		 // System.out.println(teamsList);
		  return teamsList;
	 }
	 public void clickAllWorkProfileExcel()
	 {
		 this.allWorkProfileExcel.click();
	 }
	 public Set<String> getWorkProfileList()
	 {
		 System.out.println("check");
		 List <WebElement> col = null;
		 Set<String> name = new TreeSet();
		 col = this.nameList;
		 
		 for(int i = 0;i<col.size();i++)
		  {
			 name.add(this.nameList.get(i).getText().replaceAll("\\s+",""));
			 
		  }
		// System.out.println("\n"+name);
		return name;
	 }
	 public void clickPDFBtn()
	 {
		 this.pdf.click();
	 }
	 public void clickBackBtn()
	 {
		 this.backBtn.click();
	 }
	 public void clickBottomArrom()
	 {
		 this.bottomArrom.click();
	 }
	 public void clickTeamsSorting()
	 {
		 
		 this.teamsSorting.click();
		 this.teamsSorting.click();
	 }
	
}
