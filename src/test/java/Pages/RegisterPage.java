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
    @FindBy(xpath = "//label[contains(text(), 'Subscribe')]")
    private WebElement subscribeLabel;
    @FindBy(className = "radio-inline")
    private List<WebElement> subscribeRadioButtons;
    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckButton;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void scrollToFirstNameField(){
        scrollToElement(firstNameField);
    }

    public void scrollToLastNameField(){
        scrollToElement(lastNameField);
    }

    public void scrollToEmailField(){
        scrollToElement(emailField);
    }

    public void scrollToTelephoneField(){
        scrollToElement(telephoneField);
    }

    public void scrollToPasswordField(){
        scrollToElement(passwordField);
    }

    public void scrollToConfirmPasswordField(){
        scrollToElement(passwordConfirmField);
    }

    public void scrollToSubscribeLabel(){
        scrollToElement(subscribeLabel);
    }

    public void scrollToContinueButton(){
        scrollToElement(continueButton);
    }

    public void typeInFirstNameField(String firstName){
        typeInElement(firstNameField, firstName);
    }

    public void typeInLastNameField(String lastName){
        typeInElement(lastNameField, lastName);
    }

    public void typeInEmailField(String email){
        typeInElement(emailField, email);
    }

    public void typeInTelephoneField(String telephone){
        typeInElement(telephoneField, telephone);
    }

    public void typeInPasswordField(String password){
        typeInElement(passwordField, password);
    }

    public void typeInConfirmPasswordField(String password){
        typeInElement(passwordConfirmField, password);
    }

    public void clickOnYesInSubscribeRadioButton(){
        clickOnAnElement(subscribeRadioButtons.get(0));
    }

    public void clickOnPrivacyPolicyCheckButton(){
        clickOnAnElement(privacyPolicyCheckButton);
    }

    public SuccessRegisterPage clickOnContinueButton(){
        clickOnAnElement(continueButton);
        return new SuccessRegisterPage(driver);
    }


}
