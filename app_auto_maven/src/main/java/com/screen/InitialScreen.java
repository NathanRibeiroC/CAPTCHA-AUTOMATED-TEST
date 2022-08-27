package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InitialScreen {
    final static Logger logger = Logger.getLogger(InitialScreen.class);
//parent::android.widget.FrameLayout
    public static final String PERFIL_ICON_XPATH = "//android.widget.TextView[@text=\"Perfil\"]parent";
    public static final String PULAR_BUTTON_XPATH = "//android.widget.TextView[@text=\"Pular\"]";
    public static final String COMECAR_ASSISTIR_BUTTON_XPATH = "//android.widget.TextView[@text=\"Começar a assistir\"]";
    public static final String DESLIZE_PARA_CIMA_DISCLAIMER_XPATH = "//android.widget.TextView[@text=\"Deslize para cima para visualizar mais\"]";
    public static final String DISCLAIMER_ID = "com.zhiliaoapp.musically:id/a8q";

    AndroidDriver driver;

    public InitialScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public void login() throws InterruptedException {
        logger.debug("This is debug : ");
        waitInSeconds(7);
        clickDisclaimer();
        clickByXpath(PULAR_BUTTON_XPATH);
        waitInSeconds(7);
       // String a  = driver.getPageSource();
        clickByXpath(COMECAR_ASSISTIR_BUTTON_XPATH);
//        String a  = driver.getPageSource();
        waitInSeconds(3);
//        clickByXpath(PERFIL_ICON_XPATH);
    }

    public void clickDisclaimer(){
        MobileElement disclaimer = (MobileElement) driver.findElementById(DISCLAIMER_ID);
        disclaimer.click();
    }

    public void clickByXpath(String xpath){
        MobileElement element = (MobileElement) driver.findElementByXPath(xpath);
        element.click();
    }

    public void clickById(String id){
        MobileElement element = (MobileElement) driver.findElementById(id);
        element.click();
    }

    public void waitInSeconds(int waitTime) throws InterruptedException {
        TimeUnit.SECONDS.sleep(waitTime);
    }

    public void scrollUp(String xpath){
//        MobileElement disclaimerElement = (MobileElement) driver.findElementByXPath(xpath);
//        TouchActions action = new TouchActions(driver);
//        action.scroll(disclaimerElement, 10, 100);
//        action.perform();

//        WebElement slider =  driver.findElement(By.xpath(xpath));
//        slider.sendKeys("0.1");
        (new TouchAction(driver))
                .press(PointOption.point(833, 399))
            .moveTo(PointOption.point(876, 2237))
        .release()
        .perform();
    }
}
