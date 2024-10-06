package org;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDemo {

    public static void main(String[] args) throws MalformedURLException {

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.0.0.build-130.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-renu.bairola-96601");
        sauceOptions.setCapability("accessKey", "6edef394-9970-4202-894f-75f50c69c4dd");
        sauceOptions.setCapability("build", "appium-build-6QQ4E");
        sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver dr = new AndroidDriver(url, caps);
        dr.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        dr.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys( "10203040");
        dr.findElement (AppiumBy.accessibilityId("test-LOGIN")).click();

    }
}
