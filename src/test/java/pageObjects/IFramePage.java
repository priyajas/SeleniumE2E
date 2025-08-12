package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class IFramePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'CLick Me')]")
    private WebElement cLickMe;

    @FindBy(xpath = "//*[contains(text(),'Click Me')]")
    private WebElement clickMe;

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void selectFirstSecondIFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(0);
        cLickMe.click();
        driver.switchTo().defaultContent();
        Assert.assertTrue(getSelectionMsg().getText().equals("You have clicked on iframe 1 button"));
        driver.switchTo().frame("iframe2");
        clickMe.click();
        driver.switchTo().defaultContent();
        Assert.assertTrue(getSelectionMsg().getText().equals("You have clicked on iframe 2 button"));
    }

    public WebElement getSelectionMsg() {
        return driver.findElement(By.cssSelector("p#message"));
    }

}
