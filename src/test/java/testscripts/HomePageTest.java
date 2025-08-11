package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest {


    private final String BASE_URL = "https://testing.qaautomationlabs.com/index.php";

    @BeforeClass
    public void setUp() {
        openUrl(BASE_URL);
    }


    @Test
    public void testHomeLanding() {
        homePage.verifyHomePageTitle();
    }

    @Test
    public void verifyNavItems() {
        homePage.verifyNavItems();
    }

    @Test
    public void verifyFooter() {
        homePage.verifyCopyrightText();
    }

    @Test
    public void verifyActiveItem() {
        homePage.verifyDashBoardNavItemIsActive();
    }


}
