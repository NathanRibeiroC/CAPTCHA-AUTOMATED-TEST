package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AfterLogin {
    // id click on profile during scroll view com.zhiliaoapp.musically:id/he6
    // comentarios on scroll com.zhiliaoapp.musically:id/an    // compartilhar com.zhiliaoapp.musically:id/flh
    public static String SEARCH_CHANNEL = "dicastbrasil";
    public static final String PROCURAR_WRITE_FIELD_XPATH = "//android.widget.EditText[@text=\"Procurar\"]";
    public static final String PROCURAR_WRITE_BUTTON_XPATH = "//android.widget.TextView[@text=\"Procurar\"]";
//    public static final String RESULT_TAB_XPATH  = "//android.widget.TextView[@text=\"seriededicas\"]";
    public static final String RESULT_TAB_XPATH  = "//android.widget.TextView[@text=\""+SEARCH_CHANNEL+"\"]";
    public static final String POS_RESULT_TAB_XPATH  = "//android.widget.TextView[@text=\"\u200E\u2068"+SEARCH_CHANNEL+"\u2069\"]";
    public static final String PROFILE_NAME_ID  = "com.zhiliaoapp.musically:id/dwr";
    public static final String SEGUIDORES_BUTTON_XPATH  = "//android.widget.TextView[@text=\"Seguidores\"]/..";
//    public static final String FOLLOWERS_ID  = "com.zhiliaoapp.musically:id/hbe";
    public static final String FOLLOWERS_XPATH  = "\"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout" +
        "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout" +
        "/android.widget.FrameLayout/android.widget.LinearLayout/X.0GM/android.widget.FrameLayout/android.view.ViewGroup" +
        "/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[";

    AndroidDriver driver;
    GeneralActions ga;
    String profileName;

    public AfterLogin(AndroidDriver driver){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
    }

    public void followPeople() throws InterruptedException {
        ga.clickOnSearch();
        ga.writeUsingXpath(PROCURAR_WRITE_FIELD_XPATH, SEARCH_CHANNEL);
        ga.clickByXpath(RESULT_TAB_XPATH);
        ga.clickByXpath(POS_RESULT_TAB_XPATH);
        String profileName = ga.getTextUsingId(PROFILE_NAME_ID);
        ga.clickByXpath(SEGUIDORES_BUTTON_XPATH);
        String a  = driver.getPageSource();
        sendMessagesAndFollow(FOLLOWERS_XPATH);
    }

    public void sendMessagesAndFollow(String xpath) throws InterruptedException{
        for (int i=0;i<13;i++) {
            System.out.println(xpath + i + "]\"");
            ga.clickByXpath(xpath + i + "]");
        }
    }

}
