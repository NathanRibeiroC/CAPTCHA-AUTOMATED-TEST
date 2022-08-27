package com.run;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;

import com.screen.*;

public class Main {
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
//        VERY USEFUL:         String a  = driver.getPageSource(); debug to view all the DOM content of a screen
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:5555");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage","com.zhiliaoapp.musically");
        dc.setCapability("appActivity","com.ss.android.ugc.aweme.splash.SplashActivity");
        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);

        InitialScreen is = new InitialScreen(driver);

        is.login();

        Assert.assertEquals(driver.findElementById("com.zhiliaoapp.musically:id/ad7").getText(),"Não conseguiu entrar?");
    }
}

