package Tests;

import Components.config.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {

    @BeforeMethod
    public void initializeClass(){
        headerMenu.ClickOnMyAccountElement();
        registerPage = headerMenu.ClickOnRegisterDropDown();
    }

    @Test
    @Parameters({"firstName","lastName","email","telephone","password"})
    public void validateRegisterCreated(String firstName, String lastName, String email, String telephone, String password){
        registerPage.scrollToFirstNameField();
        registerPage.typeInFirstNameField(firstName);

        registerPage.scrollToLastNameField();
        registerPage.typeInLastNameField(lastName);

        registerPage.scrollToEmailField();
        registerPage.typeInEmailField(email);

        registerPage.scrollToTelephoneField();
        registerPage.typeInTelephoneField(telephone);

        registerPage.scrollToPasswordField();
        registerPage.typeInPasswordField(password);

        registerPage.scrollToConfirmPasswordField();
        registerPage.typeInConfirmPasswordField(password);

        registerPage.scrollToSubscribeLabel();
        registerPage.clickOnYesInSubscribeRadioButton();
        registerPage.clickOnPrivacyPolicyCheckButton();

        Assert.assertTrue(registerPage.clickOnContinueButton().isSuccessRegisterMessageVisible());

    }
}
