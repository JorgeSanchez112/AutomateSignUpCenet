package Pages;

import Components.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenuComponent extends PageBase {
    @FindBy(css = ".list-inline > li >  a")
    List<WebElement> headerMenuElements;
    @FindBy(css = ".dropdown-menu-right >* a")
    List<WebElement> accountElements;

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ClickOnMyAccountElement() {
        try {
            waitForVisibility(headerMenuElements.get(1));
            clickOnAnElementWithWait(headerMenuElements.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public RegisterPage ClickOnRegisterDropDown() {
        waitForVisibility(accountElements.get(0));
        clickOnAnElementWithWait(accountElements.get(0));
        return new RegisterPage(driver);
    }

}
