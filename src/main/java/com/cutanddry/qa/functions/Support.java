package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SupportPage;

public class Support {

    static SupportPage supportPage = new SupportPage();

    public static boolean isSupportCenterHeaderDisplayed(){
        return supportPage.isSupportCenterHeaderDisplayed();
    }
}
