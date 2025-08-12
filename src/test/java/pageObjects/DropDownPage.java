package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDownPage {

    private WebDriver driver;

    @FindBy(id = "fruitDropdown")
    private WebElement dropDownMenu;

    @FindBy(id = "countryDropdown")
    private WebElement countryDropDown;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void selectSingleOption() {
        Select select = new Select(dropDownMenu);
        List<WebElement> allOptions = select.getOptions();
        select.selectByIndex(allOptions.size() - 2);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(allOptions.get(allOptions.size() - 2).getText()), "Second last value selected");
    }

    public void selectMultipleOptions() {
        Select select = new Select(countryDropDown);
        select.selectByIndex(1);
        List<WebElement> allOptions = select.getOptions();
        select.selectByIndex(allOptions.size() - 2);
        // Get all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

// Expected options based on indexes selected
        String expectedOption1 = allOptions.get(1).getText();
        String expectedOption2 = allOptions.get(allOptions.size() - 2).getText();

// Validation: check both options are selected
        boolean option1Selected = selectedOptions.stream()
                .anyMatch(opt -> opt.getText().equals(expectedOption1));

        boolean option2Selected = selectedOptions.stream()
                .anyMatch(opt -> opt.getText().equals(expectedOption2));
        Assert.assertTrue((option1Selected &&option2Selected), "All value selected are matched");


    }

}
