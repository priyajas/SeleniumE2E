package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        getHomePage();
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
