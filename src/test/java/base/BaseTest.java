package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pageObjects.HomePage;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static HomePage homePage;
    protected static final String BASE_URL = ConfigReader.getProperty("baseUrl");

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Optional: set window size since Firefox doesn't start maximized by default
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver.set( new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver.set( new EdgeDriver(edgeOptions));
                getDriver().manage().window().maximize();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }

    public HomePage getHomePage() {
            homePage = new HomePage(getDriver());
        return homePage;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            getDriver().quit();
        }
    }
}

