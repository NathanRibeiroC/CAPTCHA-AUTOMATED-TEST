package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.util.concurrent.TimeUnit;

public class AfterLogin {
    // id click on profile during scroll view com.zhiliaoapp.musically:id/he6
    // comentarios on scroll com.zhiliaoapp.musically:id/an    // compartilhar com.zhiliaoapp.musically:id/flh

    public static final String PROCURAR_WRITE_FIELD_XPATH = "//android.widget.EditText[@text=\"Procurar\"]";
    public static final String PROCURAR_WRITE_BUTTON_XPATH = "//android.widget.TextView[@text=\"Procurar\"]";

    AndroidDriver driver;
    GeneralActions ga;

    public AfterLogin(AndroidDriver driver){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
    }

    public void followPeople() throws InterruptedException {
        ga.clickOnSearch();
//        String a  = driver.getPageSource();
        ga.writeUsingXpath(PROCURAR_WRITE_FIELD_XPATH, "seriesdicas");
//        ga.clickByXpath(PROCURAR_WRITE_BUTTON_XPATH);
        String a  = driver.getPageSource();
    }

}
