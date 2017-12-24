package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class EditLeadPage extends ProjectMethods {
	
	
	public EditLeadPage(RemoteWebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test;
	}
	
	@FindBy(how = How.ID, using = "updateLeadForm_companyName")
	private WebElement eleCompanyname;

	public EditLeadPage typeCompanyName(String companyName)
	{
		
		type(eleCompanyname,companyName);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name = 'submitButton']")
	private WebElement eleUpdateBtn;
	public ViewLeadPage clickUpdateBtn()
	{
		click(eleUpdateBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ViewLeadPage(driver, test);
	}
}
