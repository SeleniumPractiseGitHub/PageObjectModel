package pagetests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MyHomePage;
import pages.ViewLeadPage;
import wdMethods.ProjectMethods;

public class DeleteLead extends ProjectMethods {

	@BeforeClass()
	public void setValues()
	{
		browserName = "chrome";
		dataSheetName = "DeleteLead";
		testCaseName = "Delete Lead";
		testDescription = "Delete a lead searched with ph no.";
		category  = "Smoke";
		author = "Charanya";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void DeleteLeadTest(String phNo)
	{
		new MyHomePage(driver, test)
		.clickLeadTab()
		.clickFindLead()
		.typePhNo(phNo)
		.clickFindLeadsBtn()
		.SearchResult()
		.FetchLeadID()
		.clickDeleteButton()
		.clickFindLead()
		.typeLeadID((ViewLeadPage.fetchleadID()))
		.clickFindLeadsBtn()
		.noResultFoundValidation();
		
	}
}
