package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ShadowDOMPage;

public class ShadowDOMPageTest extends BaseTest {
    ShadowDOMPage shadowDOMPage;

    @BeforeClass
    public void setUp() {
        getHomePage();
        openUrl(BASE_URL);
        shadowDOMPage = homePage.clickOnShadowDOM();
    }

    @Test
    public void testShadow(){
        shadowDOMPage.verifyShadowItem();
    }

}
