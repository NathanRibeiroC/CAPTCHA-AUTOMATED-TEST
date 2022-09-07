package com.run;

import com.kwai_utils.AfterLoginKwai;
import com.kwai_utils.BeforeLoginKwai;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class GeneralRun extends Thread{
    AndroidDriver<AndroidElement> driver;
    String accountEmail;
    String inputSearchContent;
    String userToBeClickedAfterSearch;
    public GeneralRun(String deviceIp, String accountEmail, String inputSearchContent, String userToBeClickedAfterSearch, String serverPortAddress) throws MalformedURLException, InterruptedException{
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceIp);
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.kwai.video");
        dc.setCapability("appActivity", "com.yxcorp.gifshow.homepage.HomeActivity");
        this.driver = new AndroidDriver(new URL(serverPortAddress), dc);
        this.accountEmail = accountEmail;
        this.inputSearchContent = inputSearchContent;
        this.userToBeClickedAfterSearch = userToBeClickedAfterSearch;
    }

    public void run(){
        for (;;) {
            try {
                BeforeLoginKwai bl = new BeforeLoginKwai(driver, accountEmail);
                bl.login();

                AfterLoginKwai af = new AfterLoginKwai(driver, inputSearchContent, userToBeClickedAfterSearch);
                af.followPeople();

                driver.resetApp();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //continue;
            }
        }
    }
}
