package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement WarningMessage;

	public void enterEmailAddress(String email) {
		elementUtils.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}

	public String getWarningMessage() {
		return elementUtils.getTextFromElement(WarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
