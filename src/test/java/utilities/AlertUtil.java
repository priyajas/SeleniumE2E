package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertUtil {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public AlertUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Switch to alert
    private Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    // Accept alert (OK button)
    public void acceptAlert() {
        try {
            switchToAlert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to accept.");
        }
    }

    // Dismiss alert (Cancel button)
    public void dismissAlert() {
        try {
            switchToAlert().dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to dismiss.");
        }
    }

    // Get alert text
    public String getAlertText() {
        try {
            return switchToAlert().getText();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
            return null;
        }
    }

    // Send text to prompt alert and accept it
    public void sendTextToAlert(String text) {
        try {
            Alert alert = switchToAlert();
            alert.sendKeys(text);
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No prompt alert present.");
        }
    }

    // Check if alert is present
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
