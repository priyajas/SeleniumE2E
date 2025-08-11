package testscripts;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomePageTest  extends BaseTest {


    @Test
    public void testHomeLanding(){
        HomePage homePage = new HomePage(driver);
        openUrl("https://testing.qaautomationlabs.com/index.php");

    }




}
