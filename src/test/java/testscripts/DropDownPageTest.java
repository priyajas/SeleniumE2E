package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DropDownPage;

public class DropDownPageTest  extends BaseTest {
    DropDownPage dropDownPage;

    @BeforeClass
    public void setUp() {
        openUrl(BASE_URL);
        dropDownPage = homePage.clickOnDropDownButton();
    }

    @Test
    public void TestSecondLastOptionValue(){
        dropDownPage.selectSingleOption();
    }

    @Test
    public void TestMultiSelectOptionValue(){
        dropDownPage.selectMultipleOptions();
    }
}
