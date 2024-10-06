package org;
import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class DataProviderConcept {

        @DataProvider(name = "loginData")
        public Object[][] loginDataProvider() {
            return new Object[][]{
                    {"akhiljda@gmail.com", "Password"},
                    {"user2@example.com", "Password2"},
                    {"user3@example.com", "Password3"}
            };
        }

        @Test(dataProvider = "loginData")
        public void successLogin(String username, String password) throws MalformedURLException, MalformedURLException {
           ChromeOptions chromeOptions = new ChromeOptions();
             WebDriver wd = new RemoteWebDriver( new URL( "http://localhost:4444"), chromeOptions);
            // Invoking selenium grid
            wd.get("https://demo.evershop.io/account/login");
            wd.findElement(By.name("email")).sendKeys(username);
            wd.findElement(By.name("password")).sendKeys(password);

            wd.findElement(By.xpath("//button[@type='submit']")).click();

            // Add your assertions here to verify the login was successful
        }
    }


