
package org;


import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DataProviderTest extends WebDriverManager {
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    WebDriver wd;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String browserName) throws MalformedURLException {
        System.out.println("Value of Browser is: "+ browserName);
        switch (browserName) {
            case "chrome": {
                chromeOptions = new ChromeOptions();
                wd = new RemoteWebDriver( new URL( "http://localhost:4444/"), chromeOptions);
                WebDriverManager.setWebDriver(wd); // Store WebDriver in ThreadLocal
                break;
            }

            case "firefox": {
                firefoxOptions = new FirefoxOptions();
                wd = new RemoteWebDriver(new URL( "http://localhost:4444/"), firefoxOptions);
                WebDriverManager.setWebDriver(wd); // Store WebDriver in ThreadLocal
                break;
            }
        }
    }

    @DataProvider(name = "LoginData")
    public Object[][] generateData() throws IOException {
        return ExcelManager.getData();
    }

    @Test(dataProvider = "LoginData")
    public void successLogin(String UN, String PW) throws MalformedURLException {
        WebDriver wd = WebDriverManager.getWebDriver(); // Retrieve WebDriver from ThreadLocal
        // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys(UN);
        wd.findElement(By.name("password")).sendKeys(PW);
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
