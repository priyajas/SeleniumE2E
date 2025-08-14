package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CheckBoxPage;

public class CheckBoxPageTest extends BaseTest {
    CheckBoxPage checkBoxPage;

    @BeforeClass
    public void setUp() {
        getHomePage();
        openUrl(BASE_URL);
        checkBoxPage = homePage.clickOnCheckbox();
    }

    @Test
    public void testSingleCheckBox() {
       checkBoxPage.singleCheckbox();
    }
    @Test
    public void testEnableDisableCheckbox() {
        checkBoxPage.verifyEnableDisableCheckbox();
    }

    @Test
    public void verifyAllCheckBoxFunctionality(){
        checkBoxPage.verifyAllCheckButtonCheckbox();
    }



}
