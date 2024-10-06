package Components.config;


import Pages.HeaderMenuComponent;
import Pages.RegisterPage;
import Pages.SuccessRegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private Properties prop;

    protected WebDriver driver;
    protected HeaderMenuComponent headerMenu;
    protected RegisterPage registerPage;
    protected SuccessRegisterPage successRegisterPage;

    @BeforeMethod
    public void setUp() {
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            prop.load(ip);
        }catch (IOException e){
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("urlHome"));

        headerMenu = new HeaderMenuComponent(driver); //Initialize main page class
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
