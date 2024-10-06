
package org;


import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;
import podtest.pom.HomePOM;
import podtest.pom.ItemPOM;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest extends WebDriverManager {
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    WebDriver wd;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
//        System.out.println("Value of Browser is: "+ browserName);
//        switch (browserName) {
//            case "chrome": {
                chromeOptions = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://192.168.31.159:4444"), chromeOptions);
                WebDriverManager.setWebDriver(wd); // Store WebDriver in ThreadLocal
              //  break;
          //  }

//            case "firefox": {
//                firefoxOptions = new FirefoxOptions();
//                wd = new RemoteWebDriver(new URL( "http://localhost:4444"), firefoxOptions);
//                WebDriverManager.setWebDriver(wd); // Store WebDriver in ThreadLocal
//                break;
//            }
       // }
    }
    @DataProvider(name = "logindata")
    public Object[][] getData(){
        return new Object[][]{
                {"akhiljda@gmail.com","Password"},
                {"akhiljda1@gmail.com","Password"},
                {"akhiljda2@gmail.com","Password"},
                {"akhiljda3@gmail.com","Password"}
        };

    }

    @Test(dataProvider = "logindata")
    public void successLogin(String email, String password) throws MalformedURLException {
        WebDriver wd = WebDriverManager.getWebDriver(); // Retrieve WebDriver from ThreadLocal

        // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.xpath("//button [@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown() {
        WebDriver wd = WebDriverManager.getWebDriver(); // Retrieve WebDriver from ThreadLocal
        if (wd != null) {
            wd.quit();
            WebDriverManager.setWebDriver(null); // Remove WebDriver from ThreadLocal
        }
    }

}
