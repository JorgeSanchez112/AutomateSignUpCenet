package Components.config;


import Pages.HeaderMenuComponent;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    @Getter
    protected WebDriver driver;
    protected HeaderMenuComponent headerMenu;
    protected RegisterPage registerPage;
    protected Properties prop;

    @BeforeMethod(groups = {"negative test","happy test"})
    public void setUp() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=" + prop.getProperty("sizeResolution"));

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(prop.getProperty("urlHome"));

        headerMenu = new HeaderMenuComponent(driver); //Initialize main page class
    }

    @AfterMethod(groups = {"negative test","happy test"})
    public void tearDown() {
        driver.quit();
    }
}
