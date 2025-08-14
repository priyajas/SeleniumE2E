package testscripts;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.WebTable;

public class WebTableTest extends BaseTest {

    WebTable webTable;

    @BeforeClass
    public void setUp() {
        getHomePage();
        openUrl(BASE_URL);
        webTable = homePage.clickOnWebTable();
    }

    @Test
    public void tableDataTest() {
        webTable.getTableData();
    }


}
