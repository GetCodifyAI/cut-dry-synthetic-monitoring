package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class TrackerPage extends LoginPage{
    By txt_tracker = By.xpath("//div[contains(text(),'Task Tracker')]");
    By txt_featureRequests = By.xpath("//div[contains(text(),'Feature Requests')]");
    By btn_featureRequests = By.xpath("//a[contains(text(),'Feature Requests')]");

    public boolean isTrackerTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_tracker);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_tracker);
    }

    public boolean isFeatureRequestTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_featureRequests);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_featureRequests);
    }
    public void clickOnFeatureRequest(){
        distributorUI.waitForVisibility(btn_featureRequests);
        distributorUI.click(btn_featureRequests);
    }
}
