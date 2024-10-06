package org.batch7;

import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CloudExample {

    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-shweta.sinha1212-5c397");
        sauceOptions.put("accessKey", "79f24971-10df-4f99-ac8c-cc28fe9dd7e1");
        sauceOptions.put("build", "selenium-build-ZVSJD");
        sauceOptions.put("name", "SDET-89");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        driver.get("https://demo.evershop.io/account/login");
        driver.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//button [@type='submit']")).click();

    }
}
