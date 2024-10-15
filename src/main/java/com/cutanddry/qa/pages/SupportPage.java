package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SupportPage extends TestBase {

    By support_center = By.xpath("//div[@class='hf-header-support-center-name']");

    public boolean isSupportCenterHeaderDisplayed(){
        String url = distributorUI.getText(support_icon,"href");
        try {
            return distributorUI.navigateToURL(url).isDisplayed(support_center);
        } catch (Exception e){
            return false;
        }
    }
}
