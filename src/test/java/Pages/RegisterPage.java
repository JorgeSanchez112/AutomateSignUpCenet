package Pages;

import Components.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends PageBase {
    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckButton;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;
    @FindBy(className = "text-danger")
    private List<WebElement> textDangerFields;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillFirstNameField(String firstName) {
        fillField(firstNameField, firstName);
    }

    public void fillLastNameField(String lastName) {
        fillField(lastNameField, lastName);
    }

    public void fillEmailField(String email) {
        fillField(emailField, email);
    }

    public void fillTelephoneField(String telephone) {
        fillField(telephoneField, telephone);
    }

    public void fillPasswordField(String password) {
        fillField(passwordField, password);
    }

    public void fillPasswordConfirmField(String passwordConfirm) {
        fillField(passwordConfirmField, passwordConfirm);
    }

    public void scrollToContinueButton(){
        scrollToElement(continueButton);
    }

    public void clickOnPrivacyPolicyCheckButton(){
        clickOnAnElementWithWait(privacyPolicyCheckButton);
    }

    public boolean areMessageOfMandatoryFieldsVisible(){
        return areElementsPresent(textDangerFields);
    }

    public boolean isMessageMismatchPasswordVisible(){
        waitForVisibility(textDangerFields.get(4));
        return isElementPresent(textDangerFields.get(4));
    }

    public boolean isMessageWrongPasswordFormatVisible(){
        try {
            waitForVisibility(textDangerFields.get(4));
            return isElementPresent(textDangerFields.get(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SuccessRegisterPage clickOnContinueButton(){
        clickOnAnElementWithWait(continueButton);
        return new SuccessRegisterPage(driver);
    }
}
