package pagetests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MyHomePage;
import wdMethods.ProjectMethods;

public class EditLead extends ProjectMethods {

	@BeforeClass()
	public void setValues()
	{
		browserName = "chrome";
		dataSheetName = "EditLead";
		testCaseName = "Edit Lead";
		testDescription = "Edit a lead for the given Lead Name";
		category  = "Regression";
		author = "Charanya";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void editLead(String firstname, String compName)
	{
		new MyHomePage(driver, test)
		.clickLeadTab()
		.clickFindLead()
		.typeFirstName(firstname)
		.clickFindLeadsBtn()
		.SearchResult()   //searchResult returns to findlead itself. same method to be reused in case i use them for mergelead, where it lands to same findlead but on a diff wndw
		.clickEditButton()    //from view lead, selecting the search result goes to editPage in EditLead. for merge lead, after findleads, it goes to merge lead. but the method is common. how to reuse?
		.typeCompanyName(compName)
		.clickUpdateBtn()
		.verifyCompanyName(compName);
		
		
		
		
	}
}
