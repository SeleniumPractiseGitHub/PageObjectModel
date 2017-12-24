package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;
	
	public LoginPage typeUserName(String username) {
		type(eleUserName, username);
		return this;
	}
	
	//modified locator change and locator value change at page level. it will not impact testcases.
	@FindBy(how=How.XPATH,using="//input[@id = 'password']")
	private WebElement elePassword;
	
	public LoginPage typePassword(String password) {
		type(elePassword, password);
		return this;
	}
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	
	public HomePage clickLogin() {
		click(eleLogin);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver, test);
	}
	
	/*public void clickLogin1() {
		click(locateElement("xpath", "//input[@value='Login']"));
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
