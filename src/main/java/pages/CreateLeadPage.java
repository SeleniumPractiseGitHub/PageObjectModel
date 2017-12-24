package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class CreateLeadPage extends ProjectMethods{
	
	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test;
	}
	
	@FindBy(how = How.ID, using = "createLeadForm_firstName")
	private WebElement eleFirstName;
	public CreateLeadPage typeFirstName(String firstName)
	{
		type(eleFirstName,firstName);
		return this;
	}
	
	
	@FindBy(how = How.ID, using = "createLeadForm_lastName")
	private WebElement eleLastName;
	public CreateLeadPage typeLastName(String lastname)
	{
		type(eleLastName,lastname);
		return this;
	}
	
	@FindBy(how = How.ID, using = "createLeadForm_companyName")
	private WebElement eleCompany;
	public CreateLeadPage typeCompanyName(String companyname)
	{
		type(eleCompany,companyname);
		return this;
	}
	
	@FindBy(how = How.CLASS_NAME, using = "smallSubmit")
	private WebElement eleCreateLeadBtn;
	public ViewLeadPage clickCreateLeadBtn()
	{
		click(eleCreateLeadBtn);
		return  new ViewLeadPage(driver,test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
