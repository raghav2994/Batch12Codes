package org.batch12.pomtest;

import manager.WebDriverManager;
import org.batch12.pomconcept.HomePagePOM;
import org.batch12.pomconcept.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoEverTest {

    FirefoxOptions fd;
    WebDriver wd;

    @BeforeMethod
    public void intialisingDriver() throws MalformedURLException {
        fd = new FirefoxOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.29.125:4444"),fd);
        WebDriverManager.setWebDriver(wd);
    }

    @Test()
    public void addToCart() throws InterruptedException {
        WebDriver wd = WebDriverManager.getWebDriver();
        LoginPage login = new LoginPage(wd);
        HomePagePOM hom = new HomePagePOM(wd);
        login.getTheURL()
                .enterEmail("akhiljda@gmail.com")
                .enterPassword("Password")
                .clickOnSubmitButton();
        hom.clickOnProduct("Nike court vision low");
    }

    @Test()
    public void addToCart1() throws InterruptedException {
        WebDriver wd = WebDriverManager.getWebDriver();
        LoginPage login = new LoginPage(wd);
        HomePagePOM hom = new HomePagePOM(wd);
        login.getTheURL()
                .enterEmail("akhiljda@gmail.com")
                .enterPassword("Password")
                .clickOnSubmitButton();
        hom.clickOnProduct("Nike court vision low");
    }
}
