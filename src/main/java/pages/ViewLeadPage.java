package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class ViewLeadPage extends ProjectMethods{
	
	public String leadid;
	//to store values globally : 
	public static Map<String,String> resultleadid=new HashMap<String, String>();
	
	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test) {
	
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.test = test;
	}
	
	@FindBy(how = How.XPATH, using = "//span[@id = 'viewLead_firstName_sp']")
	private WebElement eleFirstName;
	
	public ViewLeadPage verifyFirstname(String firstname)
	{
		verifyExactText(eleFirstName,firstname);
		return new ViewLeadPage(driver, test);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Edit']")
	private WebElement eleEditBtn;
	public EditLeadPage clickEditButton()
	{
		click (eleEditBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new EditLeadPage(driver, test);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Delete']")
	private WebElement eleDeleteBtn;
	public MyLeadPage clickDeleteButton()
	{
		click (eleDeleteBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MyLeadPage(driver, test);
	}
	
	@FindBy(how = How.ID, using = "viewLead_companyName_sp")
	private WebElement eleCompanyName;
	
	public ViewLeadPage verifyCompanyName(String companyname)
	{
		verifyPartialText(eleCompanyName,companyname);
		return this;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//span[@id = 'viewLead_companyName_sp']")
	private WebElement eleLeadId;
	
	public ViewLeadPage verifyLeadId(String leadID)
	{
		verifyPartialText(eleLeadId,leadID);
		return new ViewLeadPage(driver, test);
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@id = 'viewLead_companyName_sp']")
	private WebElement eleLeadID;
	// how to return the lead id to a variable and store. for now declared at class level
	public ViewLeadPage FetchLeadID()
	{
		String compname = getText(eleLeadID);
		String[] splitcn = compname.split("\\s");
		String cn = splitcn[0];
		leadid = splitcn[1];
		leadid = leadid.replaceAll("\\p{P}", "");
		leadid = leadid.trim();
		System.out.println(cn + " " + leadid);
		//store the key and value : 
		//remove any containing hash key
		if (resultleadid.containsKey("leadID"))
		{
			resultleadid.clear();
		}
		resultleadid.put("leadID",leadid);
		System.out.println(resultleadid.get("leadID"));	
		
		return new ViewLeadPage(driver, test);
	}
	
	//to return the hashmap value of lead id in delete lead scenario 
	public static String fetchleadID()
	{
		String lid = resultleadid.get("leadID");
		return lid;
		
	}
	

}
