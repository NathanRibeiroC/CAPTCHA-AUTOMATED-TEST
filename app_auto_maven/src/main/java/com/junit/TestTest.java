package com.junit;

import com.run.GeneralRun;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestTest{

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        GeneralRun gr1 = new GeneralRun("127.0.0.1:5555",
                "danworkhoff@gmail.com",
                "Pipocandoo Filmes",
                "pipocando filmes",
                "http://127.0.0.1:4726/wd/hub");

        GeneralRun gr2 = new GeneralRun("127.0.0.1:5585",
                "danworkhoff@gmail.com",
                "Pipocandoo Filmes",
                "pipocando filmes",
                "http://127.0.0.1:4727/wd/hub");

        gr1.start();
        gr2.start();

        System.out.println("adasdadsad");
    }
}

