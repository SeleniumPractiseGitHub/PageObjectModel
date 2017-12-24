package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class MyHomePage extends ProjectMethods{
	
	public MyHomePage(RemoteWebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Leads")
	private WebElement eleLeads;
	
	public MyLeadPage clickLeadTab() {
		
		click(eleLeads);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MyLeadPage(driver,test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
