package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SliderPage {
    private WebDriver driver;

    @FindBy(id = "slider1")
    private WebElement slider;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void moveSlider() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
                slider, 70);
        // 2. Get the current value of the slider
        String actualValue = slider.getAttribute("value");

// 3. Validate it equals expected value (string compare because getAttribute returns String)
        Assert.assertEquals(actualValue, String.valueOf(70), "Slider value not set correctly!");
    }
}
