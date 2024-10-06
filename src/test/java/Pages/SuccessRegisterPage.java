package Pages;

import Components.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessRegisterPage extends PageBase {
    @FindBy(xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
    WebElement successRegisterMessage;


    public SuccessRegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessRegisterMessageVisible() {
        return successRegisterMessage.isDisplayed();
    }

}
