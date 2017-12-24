package pagetests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyHomePage;
import wdMethods.ProjectMethods;

public class MergeLead extends ProjectMethods {

	@BeforeClass()
	public void setValues()
	{
		browserName = "chrome";
		dataSheetName = "MergeLead";
		testCaseName = "Merge Lead";
		testDescription = "Merge two leads";
		category  = "Smoke";
		author = "Charanya";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void mergeLead(String fromID, String toID)
	{
		new MyHomePage(driver, test)
		.clickLeadTab()
		.clickMergeLead()
		.clickFromIDSelector()
		.typeLeadID(fromID)
		.clickFindLeadsBtn()
		.SearchResultSelection()
		.clickToIDSelector()
		.typeLeadID(toID)
		.clickFindLeadsBtn()
		.SearchResultSelection()
		.clickMergeBtn()
		.verifyLeadId(toID);
		
		//need to navigate the page to find lead to search for the from id. how to navigate
	}
}

