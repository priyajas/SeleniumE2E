package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AlertUtil;

public class AlertsPage {
    private WebDriver driver;
    AlertUtil alertUtil;

    @FindBy(xpath = "//*[contains(text(), 'Show Confirm')]")
    private WebElement ShowConfirm;
    @FindBy(xpath = "//*[contains(text(), 'Show Alert')]")
    private WebElement ShowAlert;
    @FindBy(xpath = "//*[contains(text(), 'Show Prompt')]")
    private WebElement ShowPrompt;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
        alertUtil = new AlertUtil(driver);
    }

    public void verifyAlert() {
        ShowAlert.click();
        Assert.assertTrue(alertUtil.isAlertPresent());
        alertUtil.acceptAlert();
        Assert.assertFalse(alertUtil.isAlertPresent());
    }

    public void verifyDismissAlert() {
        ShowConfirm.click();
        Assert.assertTrue(alertUtil.isAlertPresent());
        alertUtil.dismissAlert();
        Assert.assertFalse(alertUtil.isAlertPresent());
    }

    public void verifyPromptAlert() {
        ShowPrompt.click();
        Assert.assertTrue(alertUtil.isAlertPresent());
        alertUtil.sendTextToAlert("alert accepted");
        alertUtil.acceptAlert();
        Assert.assertFalse(alertUtil.isAlertPresent());
    }

}
