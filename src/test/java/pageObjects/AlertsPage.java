package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AlertUtil;

import java.util.List;

public class AlertsPage {
    private WebDriver driver;
    AlertUtil alertUtil;

    @FindBy(xpath = "//*[contains(text(), 'Show Confirm')]")
    private WebElement ShowConfirm;
    @FindBy(xpath = "//*[contains(text(), 'Show Alert')]")
    private WebElement ShowAlert;
    @FindBy(xpath = "//*[contains(text(), 'Show Prompt')]")
    private WebElement ShowPrompt;
    //xpath parent example

    @FindBy(xpath = "//*[@class='card-header']/parent::div")
    private WebElement parentDiv;
    //xpath following  sibling example
    @FindBy (xpath="(//*[@class='row']//div[contains(@class,'text-center')])[1]//following-sibling::div")
    private List<WebElement> siblingDiv;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
        alertUtil = new AlertUtil(driver);
    }

    public void verifyAlert() {
        Assert.assertTrue(parentDiv.isDisplayed());
        Assert.assertTrue(siblingDiv.size()==2);
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
