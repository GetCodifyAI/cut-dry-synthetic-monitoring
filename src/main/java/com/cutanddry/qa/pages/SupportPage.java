package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SupportPage extends TestBase {

    By support_center = By.xpath("//div[@class='hf-header-support-center-name']");

    public boolean isSupportCenterHeaderDisplayed(){
        distributorUI.waitForVisibility(support_center);
        return distributorUI.isDisplayed(support_center);
    }

}
