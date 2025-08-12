package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }
}
