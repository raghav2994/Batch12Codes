package org;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import podtest.pom.HomePOM;
import podtest.pom.ItemPOM;
import podtest.pom.LoginPOM;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.logging.log4j.*;

public class LoginTestParalllel {
    ChromeOptions chromeOptions;
    WebDriver wd;


    @BeforeMethod(alwaysRun = true)
    public void beforeClassMethod() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        Logger log = LogManager.getLogger("String Demo");

        System.out.println("This is logger demo");
        log.info("for information only"); // info message
        log.debug("For debug message");
        log.error("For error message");
        log.warn("for warning message");
        log.fatal("for fatal message");
    }

    @BeforeMethod(alwaysRun = false)
    public void beforeMethodRun() throws MalformedURLException {
        wd.get("https://demo.evershop.io/account/login");

    }

    @Test(groups = {"Sanity"})
    public void successLogin() throws MalformedURLException {
        // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.findElement(By.xpath("//button [@type='submit']")).click();
    }

    @Test
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


    @Test
    public void addCartTest() throws InterruptedException {
        LoginPOM login = new LoginPOM(wd);
        HomePOM home = new HomePOM(wd);
        ItemPOM item = new ItemPOM(wd);

        login.get();
        login.fillCredentials("akhiljda@gmail.com", "Password");
        login.clickOnSubmit();
        /*login.get().
                fillCredentials(UN, PW).
                clickOnSubmit();*/
        Thread.sleep(500); //Go for fluent wait instead of sleep
        home.clickItem("Nike air zoom pegasus 35");
        Assert.assertEquals(item.getItemName(),"Nike air zoom pegasus 35"); // Validation I am doing with the returned string
        Thread.sleep(200);
        item.fillQuantity("2").
                selectSize("L").
                selectColour("Green");

    }

    @AfterClass
    public void TearDown() throws InterruptedException {
        Thread.sleep(10000); // Just to show you the execution, I have added it
        wd.quit();
    }

}