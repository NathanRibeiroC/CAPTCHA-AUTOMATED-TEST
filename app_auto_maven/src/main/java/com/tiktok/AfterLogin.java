package com.tiktok;

import com.screen.GeneralActions;
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

    public static final String FOLLOWERS_LIST_XPATH = "//android.widget.TextView[@text=\"Seguir\"]/..";
    public static final String ENVIAR_MENSAGEM_ICON = "//android.widget.TextView[@text=\"Enviar mensagem\"]/..";
    public static final String ENVIAR_MENSAGEM_INPUT = "//android.widget.EditText[@text=\"Enviar uma mensagem...\"]";
    public static final String FOLLOWER_NAME_ID = "com.zhiliaoapp.musically:id/dwr";
    public static final String FOLLOWER_a_ID = "com.zhiliaoapp.musically:id/her";
    public static final String SEND_BUTTON_ID = "com.zhiliaoapp.musically:id/fio";
    public static final String RETURN_BUTTON_CHAT_SCREEN_ID = "com.zhiliaoapp.musically:id/cq5";
    public static final String SEGUIR_BUTTON_ID = "com.zhiliaoapp.musically:id/eme";

    AndroidDriver driver;
    GeneralActions ga;
    String profileName;
    String[] followersA={};

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
        sendMessagesAndFollow(FOLLOWERS_LIST_XPATH);
    }

    public void sendMessagesAndFollow(String xpath) throws InterruptedException{
        String b;
        String followerName;
        List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsByXPath(xpath);
        for(MobileElement e: elementsOne){
            ga.clickByMobileElement(e);
            followerName = ga.getTextUsingId(FOLLOWER_a_ID);
            b  = driver.getPageSource();
            ga.clickById(SEGUIR_BUTTON_ID);
            clickOnReturnButton();
//            clickOn3Dots();
//            ga.waitInSeconds(10);
//            ga.clickByXpath(ENVIAR_MENSAGEM_ICON);
//            ga.writeUsingXpath(ENVIAR_MENSAGEM_INPUT, generateMessage(followerName));
//            b  = driver.getPageSource();
//            ga.clickById(SEND_BUTTON_ID);
//            b  = driver.getPageSource();
//            ga.clickById(RETURN_BUTTON_CHAT_SCREEN_ID);
        }
//        for (int i=0;i<13;i++) {
//            System.out.println(xpath + i + "]\"");
//            ga.clickByXpath(xpath + i + "]");
//        }
    }
    public void clickOn3Dots() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(850, 50)).perform();
    }

    public void clickOnReturnButton() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(50, 50)).perform();
    }

    public String generateMessage(String followerName){
        String message = "Fala aí " + followerName + ", curti demais seu feed. Eu também curto séries, filmes e cinema. " +
                "Eu e meu parceiro estamos pra fazer umas lives aqui na plataforma abordando cinema, trailers, séries e outros temas diversos, mas pra isso é necessário" +
                " 1000 seguidores, anima seguir nosso perfil pra gente chegar nessa meta ? " +
                " Lá tem um vídeo apresentando a iniciativa. De qualquer forma vou te seguir aqui, e não te mando mais mensagem. Obrigado! Tudo de bom !!";
        return message;
    }
}
