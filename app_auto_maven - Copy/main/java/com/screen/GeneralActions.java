package com.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GeneralActions {
    AndroidDriver driver;

    public GeneralActions(AndroidDriver driver){
        this.driver = driver;
    }
    public static final int SMALL_TIME = 15;
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
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public void clickOnTopRight() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(850, 50)).perform();
        waitInSeconds(SMALL_TIME);
    }

    public void clickOnBottomRight() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(800, 1550)).perform();
        waitInSeconds(SMALL_TIME);
    }

    public void clickOnTopLeft() throws InterruptedException{
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(50, 50)).perform();
        waitInSeconds(SMALL_TIME);
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
