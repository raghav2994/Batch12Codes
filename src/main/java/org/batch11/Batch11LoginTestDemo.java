package org.batch11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Batch11LoginTestDemo {
    WebDriver wd;
    ChromeOptions chromeOption;
    FirefoxOptions firefoxOptions;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String browserName) throws MalformedURLException {
        System.out.println("Value of the browser is "+ browserName);
    switch(browserName) {
        case "chrome":
            chromeOption = new ChromeOptions();
            wd = new RemoteWebDriver(new URL("http://192.168.31.159:4444"), chromeOption);
            break;

        case "firefox":
            firefoxOptions = new FirefoxOptions();
            wd = new RemoteWebDriver(new URL("http://192.168.31.159:4444"), firefoxOptions);
            break;
    }
    }

    @Test(groups = {"Raghavendra"})
    public void testSuccessLogin() {
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.findElement(By.xpath("//button [@type='submit']")).click();
    }

    @Test(groups = {"Raghav"})
    public void testUnsuccessLogin() {
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password123");
        wd.findElement(By.xpath("//button [@type='submit']")).click();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String fetchErrorMessage = wd.findElement(By.xpath("//div[@class='text-critical mb-1']")).getText();
        Assert.assertEquals(fetchErrorMessage,"Invalid email or password");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        wd.quit();
    }

}
