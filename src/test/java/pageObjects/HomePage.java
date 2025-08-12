package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ScrollUtils;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "img.img-fluid")
    private WebElement titleLogo;

    @FindBy(css = "a.nav-link")
    private WebElement navLink;

    @FindBy(css = "a.dropdown-item")
    private List<WebElement> navItems;

    @FindBy(xpath = "//div[contains(@class,'text-center') and contains(.,'Copyright')]")
    private WebElement footerText;

    @FindBy(xpath = "//a[text()='QA Automation Labs']")
    private WebElement footerLink;

    @FindBy(css = "li.nav-item > a.nav-link[href='index.php']")
    private WebElement dashBoardItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='checkbox.php']")
    private WebElement CheckBoxItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='radio-button.php']")
    private WebElement radioButtonItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='dropdown.php']")
    private WebElement dropDownItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='iframe.php']")
    private WebElement iFrameItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='shadow-dom.php']")
    private WebElement shadowDOMItem;

    @FindBy(css = "li.nav-item > a.nav-link[href='slider.php']")
    private WebElement sliderItem;
    @FindBy(css = "li.nav-item > a.nav-link[href='javaScript-alert.php']")
    private WebElement alertItem;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void verifyHomePageTitle() {
        Assert.assertEquals(titleLogo.getAttribute("alt"), "QA Automation Labs", "Website title (alt text) mismatch!");
    }

    public void verifyNavItems() {
        navLink.click();
        Assert.assertTrue(navItems.size() == 8, "Navigation Items missing");
    }

    public void verifyCopyrightText() {
        // Scroll to bottom using utility
        ScrollUtils.scrollToBottom(driver);
        // Footer visible
        Assert.assertTrue(footerText.isDisplayed(), "Footer text is not visible");

        // Footer link text
        String linkText = footerLink.getText();
        Assert.assertEquals(linkText, "QA Automation Labs", "Footer link text mismatch");

        // Footer link URL
        String href = footerLink.getAttribute("href");
        Assert.assertEquals(href, "https://qaautomationlabs.com/", "Footer link URL mismatch");

    }

    public void verifyDashBoardNavItemIsActive() {
        String classes = dashBoardItem.getAttribute("class");
        Assert.assertTrue(classes.contains("active"), "DashBoard nav item is NOT active by default");
    }

    public CheckBoxPage clickOnCheckbox() {
        CheckBoxItem.click();
        return new CheckBoxPage(driver);
    }


    public RadioButtonPage clickOnRadioButton() {
        radioButtonItem.click();
        return new RadioButtonPage(driver);
    }

    public DropDownPage clickOnDropDownButton() {
        dropDownItem.click();
        return new DropDownPage(driver);
    }

    public IFramePage clickOnIFrame() {
        iFrameItem.click();
        return new IFramePage(driver);
    }

    public ShadowDOMPage clickOnShadowDOM() {
        shadowDOMItem.click();
        return new ShadowDOMPage(driver);
    }

    public SliderPage clickOnSlider() {
        sliderItem.click();
        return new SliderPage(driver);
    }

    public AlertsPage clickOnAlerts() {
        alertItem.click();
        return new AlertsPage(driver);
    }


}
