package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    private WebDriver driver;



    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    // Dynamic element locator method
    public WebElement getGenderRadioButton(String gender) {
        String xpath = String.format("//div[@class='card-tools']//input[@value='%s']", gender);
        return driver.findElement(By.xpath(xpath));
    }

    // Method to click on gender
    public void selectGender(String gender) {
        getGenderRadioButton(gender).click();
    }

    // Method to verify if selected
    public boolean isGenderSelected(String gender) {
        return getGenderRadioButton(gender).isSelected();
    }
}
