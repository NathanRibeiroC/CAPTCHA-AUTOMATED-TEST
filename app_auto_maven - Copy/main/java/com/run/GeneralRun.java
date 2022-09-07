package com.run;

import com.kwai_utils.AfterLoginKwai;
import com.kwai_utils.BeforeLoginKwai;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class GeneralRun {
    public void runTest(String deviceIp, String accountEmail, String inputSearchContent, String userToBeClickedAfterSearch, String serverPortAddress) throws MalformedURLException, InterruptedException{
        for (;;) {
            try {
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceIp);
                dc.setCapability("platformName", "android");
                dc.setCapability("appPackage", "com.kwai.video");
                dc.setCapability("appActivity", "com.yxcorp.gifshow.homepage.HomeActivity");
                AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL(serverPortAddress), dc);

                BeforeLoginKwai bl = new BeforeLoginKwai(driver, accountEmail);
                bl.login();

                AfterLoginKwai af = new AfterLoginKwai(driver, inputSearchContent, userToBeClickedAfterSearch);
                af.followPeople();

                driver.resetApp();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}
