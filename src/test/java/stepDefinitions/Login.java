package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils = new CommonUtils();;

	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("^User has entered valid email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field(String email) {
		
		loginPage.enterEmailAddress(email);
	}

	@When("^User has entred valid password (.+) into password field$")
	public void user_has_entred_valid_password_into_password_field(String password) {

		loginPage.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();

	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());

	}

	@When("User has entered invalid email address into email field")
	public void user_has_entered_invalid_email_address_into_email_field() {
		
//		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

	}

	@When("User has entred invalid password {string} into password field")
	public void user_has_entred_invalid_password_into_password_field(String invalidPassword) {

		loginPage.enterPassword(invalidPassword);

	}

	@Then("User gets a proper warning message about credential mismatch")
	public void user_gets_a_proper_warning_message_about_credential_mismatch() {

		Assert.assertTrue(
				loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

}
