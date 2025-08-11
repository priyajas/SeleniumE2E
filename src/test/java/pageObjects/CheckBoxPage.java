package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;

    @FindBy(id = "myCheckbox")
    private WebElement singleCheckBox;

    @FindBy(xpath = "(//div[contains(@class, 'card-tools')])[2]//label//input")
    private List<WebElement> allCheckBoxes;

    @FindBy(xpath = "(//div[contains(@class, 'card-tools')])[3]//label//input")
    private List<WebElement> AllCheckButtonCheckBoxes;

    @FindBy(id = "toggleBtn")
    private WebElement AllCheckButton;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void singleCheckbox() {
        singleCheckBox.click();
        boolean isChecked = singleCheckBox.isSelected();
        Assert.assertTrue(isChecked, "Checkbox is selected");
    }

    public void verifyEnableDisableCheckbox() {
        for (int i = 0; i < allCheckBoxes.size(); i++) {
            WebElement checkbox = allCheckBoxes.get(i);
            boolean enabled = checkbox.isEnabled();

            System.out.println("Checkbox " + (i + 1) + " is " + (enabled ? "enabled" : "disabled"));

        }
    }

    public void verifyAllCheckButtonCheckbox() {
        AllCheckButton.click();
        Assert.assertTrue(AllCheckButton.getText().equals("Uncheck All"));
        for (int i = 0; i < AllCheckButtonCheckBoxes.size(); i++) {
            Assert.assertTrue(AllCheckButtonCheckBoxes.get(i).isSelected());
        }
    }
}
