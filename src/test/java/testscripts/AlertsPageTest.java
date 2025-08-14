package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;

public class AlertsPageTest extends BaseTest {
    AlertsPage alertsPage;

    @BeforeClass
    public void setUp() {
        openUrl(BASE_URL);
        getHomePage();
        alertsPage = homePage.clickOnAlerts();
    }

    @Test
    public void testAlert() {
        alertsPage.verifyAlert();
    }
    @Test
    public void testDismissAlert() {
        alertsPage.verifyDismissAlert();
    }

    @Test
    public void testPromptAlert() {
        alertsPage.verifyPromptAlert();
    }

}
