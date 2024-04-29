package sit707_week2.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sit707_week2.constants.Constants;
import sit707_week2.entity.Login;

public class LoginPage {

	private WebDriver webdriver;
	
	@FindBy(id="okta-signin-username")
	WebElement username;

	
	//*[@id="okta-signin-password"]
	
	@FindBy(id="okta-signin-password")
	WebElement password;

	//*[@id="retailLogin"]/input
	@FindBy(id="okta-signin-submit")
	WebElement loginButton;
	
	
	
	public LoginPage(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean fillLoginCredential(Login login) {
		
		username.sendKeys(login.getUsername());
		password.sendKeys(login.getPassword());
		
		loginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verifyLoginSuccesful();
	}
	
	public boolean verifyLoginSuccesful() {
		String currUrl = webdriver.getCurrentUrl();
		return currUrl.equals(Constants.HOMEPAGE_URL);
	}
}

