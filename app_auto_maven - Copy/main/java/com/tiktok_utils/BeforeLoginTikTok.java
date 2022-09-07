package com.tiktok_utils;

import com.screen.GeneralActions;
import io.appium.java_client.android.AndroidDriver;

public class BeforeLoginTikTok {
    public static final int SMALL_TIME = 10;
    public static final int MEDIUM_TIME = 14;
    public static final String PERFIL_ICON_XPATH = "//android.widget.TextView[@text=\"Perfil\"]/..";
    public static final String CONTINUAR_COM_GOOGLE_LOGIN_OPTION_XPATH = "//android.widget.TextView[@text=\"Continuar com Google\"]/..";
    public static final String PULAR_BUTTON_XPATH = "//android.widget.TextView[@text=\"Pular\"]";
    public static final String COMECAR_ASSISTIR_BUTTON_XPATH = "//android.widget.TextView[@text=\"Começar a assistir\"]";
    public static final String LOGIN_WITH_GOOGLE_ACCOUNT_OPTION_XPATH = "//android.widget.TextView[@text=\"elianasants22@gmail.com\"]/..";
    public static final String DISCLAIMER_ID = "com.zhiliaoapp.musically:id/a8q";
    public static final String NEGAR_ACESSAR_CONTATO_XPATH = "//android.widget.Button[@text=\"NEGAR\"]";
    public static final String PULAR_BUTTON_NUMERO_TELEFONE_XPATH = "//android.widget.TextView[@text=\"Pular\"]";
    public static final String ENTRAR_OPTION_ALTERNATIVE_LOGIN_XPATH = "//android.widget.TextView[@text=\"Já tem uma conta? Entrar\"]";
    public static final String DISMISS_CONTINUAR_COM_CONTA_ID = "com.zhiliaoapp.musically:id/fqt";
    public static final String FAZER_LOGIN_OU_CRIAR_CONTA_XPATH = "//android.widget.TextView[@text=\"Fazer login ou criar conta\"]";

    AndroidDriver driver;
    GeneralActions ga;

    public BeforeLoginTikTok(AndroidDriver driver){
        this.driver = driver;
        this.ga = new GeneralActions(driver);
    }

    public void login() throws InterruptedException {
        ga.waitInSeconds(7);
        ga.clickById(DISCLAIMER_ID);
        ga.clickByXpath(PULAR_BUTTON_XPATH);
        ga.clickByXpath(COMECAR_ASSISTIR_BUTTON_XPATH);
        ga.scrollUp();
        ga.clickByXpath(PERFIL_ICON_XPATH);
        selectLoginOption();
        dismissDisclaimerAfterLogin();
    }

    public void selectLoginOption() throws InterruptedException{
        try{
            loginOption1();
        }catch (Exception e){
            try{
                ga.clickById(DISMISS_CONTINUAR_COM_CONTA_ID);
                ga.clickByXpath(FAZER_LOGIN_OU_CRIAR_CONTA_XPATH);
                loginOption1();
            }catch (Exception er){
                loginOption2();
                System.out.println(er.getMessage());
            }
            System.out.println(e.getMessage());
        }
    }

    public void loginOption1() throws InterruptedException {
        ga.clickByXpath(CONTINUAR_COM_GOOGLE_LOGIN_OPTION_XPATH);
        ga.clickByXpath(LOGIN_WITH_GOOGLE_ACCOUNT_OPTION_XPATH);
    }

    public void loginOption2() throws InterruptedException {
        ga.clickByXpath(ENTRAR_OPTION_ALTERNATIVE_LOGIN_XPATH);
    }

    public void dismissDisclaimerAfterLogin() throws InterruptedException {
        try {
            ga.clickByXpath(NEGAR_ACESSAR_CONTATO_XPATH);
        }catch(Exception e){
            ga.clickByXpath(PULAR_BUTTON_NUMERO_TELEFONE_XPATH);
            ga.clickByXpath(NEGAR_ACESSAR_CONTATO_XPATH);
            System.out.println(e.getMessage());
        }
    }

}
