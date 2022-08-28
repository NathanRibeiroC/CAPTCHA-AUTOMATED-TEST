package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BeforeLogin {
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

    AndroidDriver driver;
    GeneralActions ga;

    public BeforeLogin(AndroidDriver driver){
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
        String a  = driver.getPageSource();
        selectLoginOption();
        dismissDisclaimerAfterLogin();
    }

    public void selectLoginOption() throws InterruptedException{
        try{
            ga.clickByXpath(CONTINUAR_COM_GOOGLE_LOGIN_OPTION_XPATH);
            ga.clickByXpath(LOGIN_WITH_GOOGLE_ACCOUNT_OPTION_XPATH);
        }catch (Exception e){
            ga.clickByXpath(ENTRAR_OPTION_ALTERNATIVE_LOGIN_XPATH);
            ga.clickByXpath(CONTINUAR_COM_GOOGLE_LOGIN_OPTION_XPATH);
            ga.clickByXpath(LOGIN_WITH_GOOGLE_ACCOUNT_OPTION_XPATH);
            System.out.println(e.getMessage());
        }
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
