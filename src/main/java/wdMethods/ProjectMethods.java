package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;

import utils.ExcelDataProvider;

public class ProjectMethods extends SeMethods{
	
	public String browserName = "chrome";
	public String dataSheetName;
	public String testCaseName;
	public String testDescription;
	public String category;
	public String author;
	
	
	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(author);
		startApp(browserName,"http://leaftaps.com/opentaps");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id", "password"), "crmsfa");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(locateElement("class", "decorativeSubmit"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(locateElement("link", "CRM/SFA"));
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		closeAllBrowsers();
		
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return new ExcelDataProvider().getExcelData(dataSheetName);		
	}	
	
}
