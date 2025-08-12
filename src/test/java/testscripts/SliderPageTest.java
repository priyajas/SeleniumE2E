package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SliderPage;

public class SliderPageTest extends BaseTest {
    SliderPage sliderPage;

    @BeforeClass
    public void setUp() {
        openUrl(BASE_URL);
        sliderPage = homePage.clickOnSlider();
    }

    @Test
    public void testSlider() {
        sliderPage.moveSlider();
    }

}
