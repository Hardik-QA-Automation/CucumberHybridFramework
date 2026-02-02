package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneFiled;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordFiled;

	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement YesNewsLetterOption;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@name='password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterFirstName(String firstName) {
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String LastName) {

		elementUtils.typeTextIntoElement(lastNameField, LastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmail(String email) {
		elementUtils.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterTelephone(String telephone) {
		elementUtils.typeTextIntoElement(telephoneFiled, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String Password) {
		elementUtils.typeTextIntoElement(passwordField, Password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String confirmPassword) {
		elementUtils.typeTextIntoElement(confirmPasswordFiled, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountSuccessPage clickOnContinue() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}

	public void selectYesNewsletterOption() {
		elementUtils.clickOnElement(YesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessageText() {

		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
