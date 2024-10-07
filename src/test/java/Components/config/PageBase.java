package Components.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAnElement(WebElement element) {
        element.click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void typeInElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForInteractableElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fillField(WebElement element, String text) {
        scrollToElement(element);
        typeInElement(element, text);
    }

    public void clickOnAnElementWithWait(WebElement element) {
        waitForInteractableElement(element);
        clickOnAnElement(element);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean areElementsPresent(List<WebElement> elementList) {
        for (WebElement element : elementList) {
            if (element.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
