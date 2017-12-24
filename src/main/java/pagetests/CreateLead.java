package pagetests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MyHomePage;
import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods{

	
	@BeforeClass()
	public void setValues()
	{
		browserName = "chrome";
		dataSheetName = "CreateLead";
		testCaseName = "Create Lead";
		testDescription = "Create a new lead";
		category  = "Smoke";
		author = "Charanya";
	}
	
	
	@Test(dataProvider="fetchData")
	public void createLead(String cName,String fName,String lName) {
		new MyHomePage(driver, test)
		.clickLeadTab()
		.clickCreateLead()
		.typeFirstName(fName)
		.typeLastName(lName)
		.typeCompanyName(cName)
		.clickCreateLeadBtn()
		.verifyFirstname(fName);
		
	}
}
