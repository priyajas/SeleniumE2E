package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShadowDOMPage {

    private WebDriver driver;

    @FindBy(id = "shadow-host")
    private WebElement shadowHost;

    public ShadowDOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void verifyShadowItem(){
        Assert.assertTrue(getShadowElement("div.box").getText().equals("Hello from Shadow DOM!"));
    }

    public WebElement getShadowElement(String insideShadowSelector) {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        return shadowRoot.findElement(By.cssSelector(insideShadowSelector));
    }
}
