package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import sit707_week2.constants.Constants;
import sit707_week2.entity.Login;
import sit707_week2.handlers.BrowserHandler;
import sit707_week2.pageobject.LoginPage;

/**
 * @author Ahsan Habib
 */
public class MainTest {

	private WebDriver webdriver;

	@Before
	public void setup() throws InterruptedException {
		BrowserHandler handler = new BrowserHandler("firefox");
		webdriver = handler.getDriver();
		webdriver.get(Constants.LOGIN_URL);
		Thread.sleep(5000);
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "224114235";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Shreya";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testValidUsernameValidPassword() {
		Login login = new Login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertTrue(status);

	}

	@Test
	public void testInValidUsernameValidPassword() {
		Login login = new Login(Constants.INVALID_USERNAME, Constants.VALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}

	@Test
	public void testValidUsernameInValidPassword() {
		Login login = new Login(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}

	@Test
	public void testEmptyUsernameValidPassword() {
		Login login = new Login("", Constants.VALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}

	@Test
	public void testValidUsernameEmptyPassword() {
		Login login = new Login(Constants.VALID_USERNAME, "");
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}

	@Test
	public void testEmptyUsernameEmptyPassword() {
		Login login = new Login("", "");
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}
	
	@Test
	public void testInvalidUsernameInvalidPassword() {
		Login login = new Login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}
	
	@Test
	public void testWrongFormatUsernameValidPassword() {
		Login login = new Login(Constants.WRONG_FORMAT, Constants.VALID_PASSWORD);
		LoginPage loginPage = new LoginPage(webdriver);
		boolean status = loginPage.fillLoginCredential(login);

		Assert.assertFalse(status);

	}
	
	
	@After
	public void cleanUp() {
		webdriver.quit();
	}
	

}
