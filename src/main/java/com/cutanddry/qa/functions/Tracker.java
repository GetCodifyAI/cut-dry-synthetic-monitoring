package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.TrackerPage;

public class Tracker {

    static TrackerPage trackerPage = new TrackerPage();

    public static boolean isTrackerTextDisplayed(){
        return trackerPage.isTrackerTextDisplayed();
    }
    public static boolean isFeatureRequestTextDisplayed(){
        return trackerPage.isFeatureRequestTextDisplayed();
    }
    public static void clickOnFeatureRequest(){
        trackerPage.clickOnFeatureRequest();
    }
}
