package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class FindLeadPage extends ProjectMethods{
	
	public FindLeadPage(RemoteWebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test= test;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@name='firstName'])[3]")
	private WebElement eleFirstName;
	public FindLeadPage typeFirstName(String firstName)
	{
		type(eleFirstName, firstName);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Find Leads')]")
	private WebElement eleFindLeadsBtn;
	public FindLeadPage clickFindLeadsBtn()
	{
		click(eleFindLeadsBtn);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleSearch;
	public ViewLeadPage SearchResult() 
	{
		click(eleSearch);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ViewLeadPage(driver, test);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleSearchResult;
	public MergeLeadPage SearchResultSelection() 
	{
		click(eleSearchResult);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToWindow(0);
		return new MergeLeadPage(driver, test);
	}
	
	@FindBy(how = How.XPATH , using = "//input[@name='id']")
	private WebElement eleLeadId;
	public FindLeadPage typeLeadID(String leadID)
	
	{
		type(eleLeadId, leadID);
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "(//table/tbody/tr/td/div/div/div/input)[13]")
	private WebElement elePhNo;
	@FindBy(how = How.XPATH, using = "(//span[@class='x-tab-strip-text '])[2]")
	private WebElement elePhTab;
	public FindLeadPage typePhNo(String phone)
	{
		click(elePhTab);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(elePhNo, phone);
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'No records to display')]")
	private WebElement eleMessage;
	public void noResultFoundValidation()
	{
		verifyExactText(eleMessage, "No records to display");
	}
	
	

}
