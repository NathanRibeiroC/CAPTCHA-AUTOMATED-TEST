package com.kwai_utils;
import com.screen.GeneralActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import static com.screen.GeneralActions.Direction.UP;

public class AfterLoginKwai {
    public static final String SEARCH_ID="com.kwai.video:id/search_editor";
    public String SEARCH_OPTION_XPATH;
    public static final String PROFILE_XPATH ="//android.widget.TextView[@text=\"Seguir\"]/..";
    public static final String SEGUIDORES_XPATH="//android.widget.TextView[@text=\"Seguidores\"]/..";
    public static final String FOLLOWERS_LIST_XPATH = "//android.widget.Button[@text=\"Seguir\"]/..";
    public static final String USER_NAME_ID = "com.kwai.video:id/title_tv";
    public static final String MORE_BUTTON_ID = "com.kwai.video:id/more_btn";
    public static final String FOLLOW_BUTTON_ID = "com.kwai.video:id/follow_button";
    public static final String SEND_MESSAGE_XPATH = "//android.widget.TextView[@text=\"Enviar mensagem\"]/..";
    public static final String INPUT_WRITE_TO_FOLLOWER_ID = "com.kwai.video:id/editor";
    public static final String VIDEO_BUTTON_XPATH = "//android.widget.TextView[@text=\"Usuário\"]";
    public String INPUT_SEARCH_CONTENT;

    AndroidDriver driver;
    GeneralActions ga;

    public AfterLoginKwai(AndroidDriver driver, String inputSearchContent, String userToBeClickedAfterSearch){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
        this.INPUT_SEARCH_CONTENT = inputSearchContent;
        this.SEARCH_OPTION_XPATH = "//android.widget.TextView[@text=\""+userToBeClickedAfterSearch+"\"]";
    }
    //KWAI_SÉRIES
    public void followPeople() throws InterruptedException {
        //after login
        ga.clickOnTopRight();
        ga.waitInSeconds(10);
        ga.writeUsingId(SEARCH_ID,INPUT_SEARCH_CONTENT);
        ga.clickByXpath(SEARCH_OPTION_XPATH);
        ga.clickByXpath(VIDEO_BUTTON_XPATH);
        ga.clickByXpath(PROFILE_XPATH);
        ga.clickByXpath(SEGUIDORES_XPATH);
        sendMessagesAndFollow(FOLLOWERS_LIST_XPATH);
    }

    public void sendMessagesAndFollow(String xpath) throws InterruptedException{
        String b;
        for(;;) {
            int arraySize=0;
            List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsByXPath(xpath);
            List<MobileElement> elementsOne1 = (List<MobileElement>) driver.findElementsByXPath(xpath);
            arraySize = elementsOne.size();
            for (int i =0; i<arraySize;i++) {
                ga.clickByMobileElement(elementsOne.get(i));
                writeMessage();
                ga.clickById(FOLLOW_BUTTON_ID);
                ga.clickOnTopLeft();
                elementsOne = (List<MobileElement>) driver.findElementsByXPath(xpath);
                arraySize = elementsOne.size();
            }
            ga.swipeScreen(UP);
            ga.waitInSeconds(20);
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
        String message = "Fala aí " + followerName.substring(0, (followerName.length()/2)) + ", curti demais seu feed.\n Eu também curto séries, filmes e cinema. \n" +
                "2 amigos meus estão pra fazer umas lives aqui na plataforma abordando cinema, trailers, séries e outros temas diversos, mas pra isso é necessário" +
                " 1000 seguidores para a plataforma liberar as lives, anima seguir no perfil deles pra gente chegar nessa meta ? 10% do lucro vai pra caridade !" +
                " Lá tem um vídeo apresentando a iniciativa. De qualquer forma vou te seguir aqui, e não te incomodo mais. Obrigado! Tudo de bom !!\n" +
                "Segue o link do perfil deles aqui na plataforma: \n"+
                "https://s.kw.ai/u/fiLCbb5k";
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
