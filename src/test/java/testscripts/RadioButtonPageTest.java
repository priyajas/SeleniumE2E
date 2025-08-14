package testscripts;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.RadioButtonPage;

public class RadioButtonPageTest extends BaseTest {
    RadioButtonPage radioButtonPage;

    @BeforeClass
    public void setUp() {
        getHomePage();
        openUrl(BASE_URL);
        radioButtonPage = homePage.clickOnRadioButton();
    }

    @Test
    public void testGenderSelection() {
        radioButtonPage.selectGender("Female");
        Assert.assertTrue(radioButtonPage.isGenderSelected("Female"));
    }
}
