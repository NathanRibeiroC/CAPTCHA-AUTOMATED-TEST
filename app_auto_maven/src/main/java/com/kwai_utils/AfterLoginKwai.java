package com.kwai_utils;
import com.screen.GeneralActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class AfterLoginKwai {
    public static final String SEARCH_ID="com.kwai.video:id/search_editor";
    public static final String SEARCH_OPTION_XPATH="//android.widget.TextView[@text=\"kwai_series\"]";
    public static final String PROFILE_XPATH="//android.widget.TextView[@text=\"ID:Series.22\"]/..";
    public static final String SEGUIDORES_XPATH="//android.widget.TextView[@text=\"Seguidores\"]/..";
    public static final String FOLLOWERS_LIST_XPATH = "//android.widget.Button[@text=\"Seguir\"]/..";
    public static final String USER_NAME_ID = "com.kwai.video:id/title_tv";
    public static final String MORE_BUTTON_ID = "com.kwai.video:id/more_btn";
    public static final String FOLLOW_BUTTON_ID = "com.kwai.video:id/follow_button";
    public static final String SEND_MESSAGE_XPATH = "//android.widget.TextView[@text=\"Enviar mensagem\"]/..";
    public static final String INPUT_WRITE_TO_FOLLOWER_ID = "com.kwai.video:id/editor";

    AndroidDriver driver;
    GeneralActions ga;

    public AfterLoginKwai(AndroidDriver driver){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
    }
    //KWAI_SÉRIES
    public void followPeople() throws InterruptedException {
        //after login
        ga.clickOnTopRight();
        ga.waitInSeconds(10);
        ga.writeUsingId(SEARCH_ID,"KWAI_SERIES");
        ga.clickByXpath(SEARCH_OPTION_XPATH);
        ga.clickByXpath(PROFILE_XPATH);
        ga.clickByXpath(SEGUIDORES_XPATH);
        sendMessagesAndFollow(FOLLOWERS_LIST_XPATH);
        String a  = driver.getPageSource();
    }

    public void sendMessagesAndFollow(String xpath) throws InterruptedException{
        String b;
        List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsByXPath(xpath);
        for(MobileElement e: elementsOne){
            ga.clickByMobileElement(e);
            b  = driver.getPageSource();
            writeMessage();
            ga.clickById(FOLLOW_BUTTON_ID);
        }
    }

    public void writeMessage() throws InterruptedException{

        String message;
        message = generateMessage(ga.getTextUsingId(USER_NAME_ID));
        ga.clickById(MORE_BUTTON_ID);
        ga.clickByXpath(SEND_MESSAGE_XPATH);
        ga.writeUsingId(INPUT_WRITE_TO_FOLLOWER_ID, message);
        ga.clickById("com.kwai.video:id/finish_button");
        ga.clickOnTopLeft();
    }

    public String generateMessage(String followerName){
        String message = "Fala aí " + followerName + ", curti demais seu feed. Eu também curto séries, filmes e cinema. " +
                "Eu e meu parceiro estamos pra fazer umas lives aqui na plataforma abordando cinema, trailers, séries e outros temas diversos, mas pra isso é necessário" +
                " 1000 seguidores, anima seguir nosso perfil pra gente chegar nessa meta ? " +
                " Lá tem um vídeo apresentando a iniciativa. De qualquer forma vou te seguir aqui, e não te mando mais mensagem. Obrigado! Tudo de bom !!";
        return message;
    }
//    public void selectLoginOption() throws InterruptedException{
//        try{
//            loginOption1();
//        }catch (Exception e){
//            try{
//                ga.clickById(DISMISS_CONTINUAR_COM_CONTA_ID);
//                ga.clickByXpath(FAZER_LOGIN_OU_CRIAR_CONTA_XPATH);
//                loginOption1();
//            }catch (Exception er){
//                loginOption2();
//                System.out.println(er.getMessage());
//            }
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void loginOption1() throws InterruptedException {
//        ga.clickByXpath(CONTINUAR_COM_GOOGLE_LOGIN_OPTION_XPATH);
//        ga.clickByXpath(LOGIN_WITH_GOOGLE_ACCOUNT_OPTION_XPATH);
//    }
//
//    public void loginOption2() throws InterruptedException {
//        ga.clickByXpath(ENTRAR_OPTION_ALTERNATIVE_LOGIN_XPATH);
//    }
//
//    public void dismissDisclaimerAfterLogin() throws InterruptedException {
//        try {
//            ga.clickByXpath(NEGAR_ACESSAR_CONTATO_XPATH);
//        }catch(Exception e){
//            ga.clickByXpath(PULAR_BUTTON_NUMERO_TELEFONE_XPATH);
//            ga.clickByXpath(NEGAR_ACESSAR_CONTATO_XPATH);
//            System.out.println(e.getMessage());
//        }
//    }

}
