package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GeneralActions {
    AndroidDriver driver;

    public GeneralActions(AndroidDriver driver){
        this.driver = driver;
    }
    public static final int SMALL_TIME = 10;
    public void clickByXpath(String xpath) throws InterruptedException{
        MobileElement element = (MobileElement) driver.findElementByXPath(xpath);
        element.click();
        waitInSeconds(SMALL_TIME);
    }

    public void clickById(String id) throws InterruptedException{
        MobileElement element = (MobileElement) driver.findElementById(id);
        element.click();
        waitInSeconds(SMALL_TIME);
    }

    public void clickByMobileElement(MobileElement element) throws InterruptedException{
        element.click();
        waitInSeconds(SMALL_TIME);
    }

    public void waitInSeconds(int waitTime) throws InterruptedException {
        TimeUnit.SECONDS.sleep(waitTime);
    }

    public boolean waitElementAppear(MobileElement element){
        boolean isElementPresent;
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementPresent = element.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        }
    }

    public void scrollUp() throws InterruptedException{
        Dimension size = driver.manage().window().getSize();
        System.out.println("Size: " + size);
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;

        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(450, 1280))
                .moveTo(PointOption.point(450, 320))
                .release()
                .perform();
        waitInSeconds(SMALL_TIME);
    }

    public void clickOnTopRight() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(850, 50)).perform();
    }

    public void clickOnBottomRight() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(800, 1550)).perform();
    }

    public void clickOnTopLeft() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(50, 50)).perform();
    }

    public void writeUsingId(String id, String content) throws InterruptedException{
        MobileElement element = (MobileElement) driver.findElementById(id);
        element.sendKeys(content);
        waitInSeconds(SMALL_TIME);
    }

    public void writeUsingXpath(String xpath, String content) throws InterruptedException{
        MobileElement element = (MobileElement) driver.findElementByXPath(xpath);
        element.sendKeys(content);
        waitInSeconds(SMALL_TIME);
    }

    public String getTextUsingId(String id){
        MobileElement element = (MobileElement) driver.findElementById(id);
        return element.getText();
    }

    public List<MobileElement> getElementsById(String id){
        List<MobileElement> elements = (List<MobileElement>) driver.findElementsById(id);
        return elements;
    }
}
