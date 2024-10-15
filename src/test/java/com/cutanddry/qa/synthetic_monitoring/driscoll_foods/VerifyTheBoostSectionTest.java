package com.cutanddry.qa.synthetic_monitoring.driscoll_foods;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Boost;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Draft;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheBoostSectionTest extends TestBase {
    static User user;
    static String DP = "Driscoll Foods";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public void VerifyTheBoostSection() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToDistributorPortalProd(DP);
        Dashboard.navigateToBoost();
        softAssert.assertTrue(Boost.isUserNavigatedToBoost(),"navigation error");
        softAssert.assertTrue(Boost.isBroadcastAddMsgDisplayed(),"broadcast navigation error");
        Boost.clickCatalogHome();
        softAssert.assertTrue(Boost.isCatalogHomeTabDisplayed(),"catalog home navigation error");
        Boost.clickSuggestiveSales();
        softAssert.assertTrue(Boost.isSuggestiveTabDisplayed(),"suggestive sales navigation error");
        Boost.clickFeaturedLists();
        softAssert.assertTrue(Boost.isFeaturedTabDisplayed(),"featured lists navigation error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
