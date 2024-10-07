package Tests;

import Components.config.TestBase;
import Components.utilities.report.Listeners;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    @BeforeMethod(groups = {"happy test","negative test"})
    public void initializeClass(){
        headerMenu.ClickOnMyAccountElement();
        registerPage = headerMenu.ClickOnRegisterDropDown();
    }

    @Test(groups = "happy test")
    @Parameters({"firstName","lastName","email","telephone","password"})
    public void validateRegisterCreated(String firstName, String lastName, String email, String telephone, String password){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Filling out the first name field");
        registerPage.fillFirstNameField(firstName);
        test.info("Filling out the last name field");
        registerPage.fillLastNameField(lastName);
        test.info("Filling out the email field");
        registerPage.fillEmailField(email);
        test.info("Filling out the telephone field");
        registerPage.fillTelephoneField(telephone);
        test.info("Filling out the password field");
        registerPage.fillPasswordField(password);
        test.info("Filling out the confirm password field");
        registerPage.fillPasswordConfirmField(password);
        test.info("Agree with privacy policy");
        registerPage.clickOnPrivacyPolicyCheckButton();
        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Click on continue button");
        test.info("Validate message of success registration");
        Assert.assertTrue(registerPage.clickOnContinueButton().isSuccessRegisterMessageVisible());
    }

    @Test(groups = "negative test")
    public void areMessagesOfMandatoryFieldsPresent(){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Click on continue button");
        registerPage.clickOnContinueButton();
        test.info("Validate fields are mandatory");
        Assert.assertTrue(registerPage.areMessageOfMandatoryFieldsVisible());
    }

    @Test(groups = "negative test")
    @Parameters({"firstName","lastName","emailWithBadFormat","telephone","password"})
    public void validateEmailFormat(String firstName, String lastName, String email, String telephone, String password){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Filling out the first name field");
        registerPage.fillFirstNameField(firstName);
        test.info("Filling out the last name field");
        registerPage.fillLastNameField(lastName);
        test.info("Filling out the email field");
        registerPage.fillEmailField(email); //email without correct format
        test.info("Filling out the telephone field");
        registerPage.fillTelephoneField(telephone);
        test.info("Filling out the password field");
        registerPage.fillPasswordField(password);
        test.info("Filling out the confirm password field");
        registerPage.fillPasswordConfirmField(password);
        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Agree with privacy policy");
        registerPage.clickOnPrivacyPolicyCheckButton();
        test.info("Click on continue button");
        test.info("Validate email format");
        Assert.assertFalse(registerPage.clickOnContinueButton().isSuccessRegisterMessageVisible());
    }


    @Test(groups = "negative test")
    @Parameters("shortPassword")
    public void validatePasswordFormatWeak(String password){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Filling out the password field");
        registerPage.fillPasswordField(password); //password with less than 4 characters
        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Click on continue button");
        registerPage.clickOnContinueButton();
        test.info("Validate password does not meet the requirements to be accepted");
        Assert.assertTrue(registerPage.isMessageWrongPasswordFormatVisible());
    }

    @Test(groups = "negative test")
    @Parameters("longPassword")
    public void validatePasswordFormatTooLong(String password){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Filling out the password field");
        registerPage.fillPasswordField(password); //password with more than 20 characters
        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Click on continue button");
        registerPage.clickOnContinueButton();
        test.info("Validate password is more complex");
        Assert.assertTrue(registerPage.isMessageWrongPasswordFormatVisible());
    }

    @Test(groups = "negative test")
    @Parameters({"password","incorrectPassword"})
    public void validatePasswordAndConfirmPassword(String password, String incorrectPassword){
        ExtentTest test = Listeners.getExtentTest();

        test.info("Filling out the password field");
        registerPage.fillPasswordField(password);
        test.info("Filling out the confirm password field");
        registerPage.fillPasswordConfirmField(incorrectPassword);
        test.info("Scroll to continue button");
        registerPage.scrollToContinueButton();
        test.info("Click on continue button");
        registerPage.clickOnContinueButton();
        test.info("Validate appears message of mismatch password confirmation");
        Assert.assertTrue(registerPage.isMessageMismatchPasswordVisible());
    }
}
