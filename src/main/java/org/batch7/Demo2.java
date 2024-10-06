package org.batch7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo2 {

public static void main(String[] args) throws MalformedURLException {
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);


}
}
