package org;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDemo1 {

    public static void main(String[] args) throws MalformedURLException {

        // Set desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "a54xnsxx");

        caps.setCapability("udid", "RZCW50Y632D"); //Give Device ID  caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("app-Package", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        AndroidDriver dr = new AndroidDriver(new URL(  "http://127.0.0.1:4723/wd/hub"), caps);

        dr.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        dr.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys( "secret_sauce");
        dr.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

    }
}
