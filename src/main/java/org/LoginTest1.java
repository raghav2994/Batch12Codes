
package org;


import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest1 extends WebDriverManager {
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;

    SafariOptions safariOptions;
    WebDriver wd;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String browserName) throws MalformedURLException {
        System.out.println("Value of Browser is: "+ browserName);
        switch (browserName) {
            case "chrome": {
                chromeOptions = new ChromeOptions();
                wd = new RemoteWebDriver( new URL( "http://localhost:4444/"), chromeOptions);
                break;
            }
            case "firefox": {
                firefoxOptions = new FirefoxOptions();
                wd = new RemoteWebDriver(new URL( "http://localhost:4444/"), firefoxOptions);
                break;
            }
        }
    }


    @Test(priority = 1)
    public void successLogin() throws MalformedURLException {

        // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.findElement(By.xpath("//button [@type='submit']")).click();
    }

    @Test(priority = 2)
    public void unsuccessLogin() throws MalformedURLException {

        // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        FluentWait fluentWait = new FluentWait(wd)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@type='submit']")));
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.findElement(By.xpath("//button [@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }

}
