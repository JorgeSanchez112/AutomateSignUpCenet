package Pages;

import Components.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenuComponent extends PageBase {
    @FindBy(css = ".list-inline >* .hidden-md")
    List<WebElement> HeaderMenuElements;
    @FindBy(css = ".dropdown-menu >* a")
    List<WebElement> AccountElements;

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ClickOnMyAccountElement() {
        clickOnAnElement(HeaderMenuElements.get(1));
    }

    public RegisterPage ClickOnRegisterDropDown() {
        clickOnAnElement(AccountElements.get(0));
        return new RegisterPage(driver);
    }

}
