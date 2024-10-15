package com.cutanddry.qa.synthetic_monitoring.driscoll_foods;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheTrackerTest extends TestBase {
    static User user;
    static String DP = "Driscoll Foods";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public void VerifyTheTracker() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToDistributorPortalProd(DP);
        Dashboard.navigateToTracker();
        softAssert.assertTrue(Tracker.isTrackerTextDisplayed(),"navigation error");
        Tracker.clickOnFeatureRequest();
        softAssert.assertTrue(Tracker.isFeatureRequestTextDisplayed(),"navigation to feature req error");
        softAssert.assertAll();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
