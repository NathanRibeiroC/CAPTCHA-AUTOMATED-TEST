package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class AfterLogin {

    public static final String LUPA_ICON_ID = "com.zhiliaoapp.musically:id/an8";
    AndroidDriver driver;
    GeneralActions ga;

    public AfterLogin(AndroidDriver driver){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
    }

    public void followPeople() throws InterruptedException {
        String a  = driver.getPageSource();
        ga.clickById(LUPA_ICON_ID);
    }

}
