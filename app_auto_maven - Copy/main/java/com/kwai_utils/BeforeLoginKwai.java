package com.kwai_utils;
import com.screen.GeneralActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class BeforeLoginKwai {
    public String GOOGLE_USER_LOGIN_OPTION_XPATH;
    public static final String CONTINUAR_COM_GOOGLE_XPATH="//android.widget.TextView[@text=\"Continuar com Google\"]";
    public static final String CLOSE_DISCLAIMER_ID="com.kwai.video:id/close_img";

    AndroidDriver driver;
    GeneralActions ga;

    public BeforeLoginKwai(AndroidDriver driver, String accountEmail){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
        this.GOOGLE_USER_LOGIN_OPTION_XPATH = "//android.widget.TextView[@text=\""+accountEmail+"\"]";
    }
//KWAI_SÉRIES
    public void login() throws InterruptedException {
          ga.waitInSeconds(20);
          ga.clickOnBottomRight();
          ga.clickByXpath(CONTINUAR_COM_GOOGLE_XPATH);
          ga.clickByXpath(GOOGLE_USER_LOGIN_OPTION_XPATH);
          clickDisclaimerIfItAppears();
    }

    public void clickDisclaimerIfItAppears(){
        try{
            ga.clickById(CLOSE_DISCLAIMER_ID);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
