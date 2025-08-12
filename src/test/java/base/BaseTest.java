package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.HomePage;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static HomePage homePage;
    protected static final String BASE_URL = ConfigReader.getProperty("baseUrl");

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Optional: set window size since Firefox doesn't start maximized by default
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getHomePage();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

