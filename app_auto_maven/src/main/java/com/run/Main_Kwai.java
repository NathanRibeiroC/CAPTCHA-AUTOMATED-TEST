package com.run;

import com.kwai_utils.AfterLoginKwai;
import com.kwai_utils.BeforeLoginKwai;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main_Kwai {
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
//        VERY USEFUL:         String a  = driver.getPageSource(); debug to view all the DOM content of a screen
        for(;;){
            try{
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:5555");
                dc.setCapability("platformName", "android");
                dc.setCapability("appPackage","com.kwai.video");
                dc.setCapability("appActivity","com.yxcorp.gifshow.homepage.HomeActivity");
                AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);

                BeforeLoginKwai bl = new BeforeLoginKwai(driver);
                bl.login();

                AfterLoginKwai af = new AfterLoginKwai(driver);
                af.followPeople();

                driver.resetApp() ;
            }catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }
        }
//        Assert.assertEquals(driver.findElementById("com.zhiliaoapp.musically:id/ad7").getText(),"Não conseguiu entrar?");
    }
}