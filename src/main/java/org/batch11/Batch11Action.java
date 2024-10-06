package org.batch11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Batch11Action {

    ChromeOptions chromeOptions;
    WebDriver wd;

    @BeforeClass(alwaysRun = true)
    public void beforeClassMethod() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.31.159:4444"), chromeOptions);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodMethod(){
       // wd.get("https://demo.evershop.io/account/login");
        wd.get("https://selectorshub.com/iframe-scenario/");
    }

    @Test(enabled=false)
    public void actionTest(){
        Actions action = new Actions(wd);
        WebElement el1 = wd.findElement(By.name("email"));
        action.
                moveToElement(el1).
                click().
                keyDown(Keys.SHIFT).
                sendKeys("raghav").
                keyUp(Keys.SHIFT).
                perform();


        action.moveToElement(el1).
                contextClick().
                perform();

    }


    @Test
    public void iFrameConcept(){
        wd.switchTo().frame("pact1"); // FRAME 1
        wd.findElement(By.xpath("//*[@id='inp_val']")).sendKeys("Raghav");
        wd.switchTo().frame("pact2"); // FRAME 2
        wd.findElement(By.xpath("//*[@id='jex']")).sendKeys("Renu");
        wd.switchTo().parentFrame();



    }
}
