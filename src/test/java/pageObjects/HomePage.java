package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "img.img-fluid")
    private WebElement titleLogo;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void verifyHomePageTitle() {
        Assert.assertEquals(titleLogo.getAttribute("alt"), "QA Automation Labs", "Website title (alt text) mismatch!");

    }


}
