
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {
    public static void main(String args[]) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:5555");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage","com.zhiliaoapp.musically");
        dc.setCapability("appActivity","com.ss.android.ugc.aweme.splash.SplashActivity");

        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);

        MobileElement el3 = (MobileElement) driver.findElementById("com.zhiliaoapp.musically:id/ajq");
        el3.click();

        Assert.assertEquals(driver.findElementById("com.zhiliaoapp.musically:id/ad7").getText(),"Não conseguiu entrar?");
    }
}

