package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.IFramePage;

public class IFramePageTest extends BaseTest {
    IFramePage iFramePage;

    @BeforeClass
    public void setUp() {
        openUrl(BASE_URL);
        iFramePage = homePage.clickOnIFrame();
    }

    @Test
    public void testIFrames() {
        iFramePage.selectFirstSecondIFrame();
    }
}
