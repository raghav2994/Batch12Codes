package org.batch7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;

public class Alerts {


    ChromeOptions chromeOptions;
    WebDriver wd;

    @BeforeClass(alwaysRun = true)
    public void beforeClassMethod() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    }

    @Test(enabled = false)
    public void alertBox() {
        wd.get("https://selectorshub.com/xpath-practice-page/");
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='content']/div/div[1]/section[2]/div/div[2]/div/div[2]/div/button[1]")));

        wd.findElement(By.xpath( "//*[@id='content']/div/div[1]/section[2]/div/div[2]/div/div[2]/div/button[1]")).click();
        System.out.println(wd.switchTo().alert().getText());
        wd.switchTo().alert().accept();
    }

    @Test(enabled = false)
    public void iFrameConcept() {
        wd.get("https://selectorshub.com/iframe-scenario/");
        //wd.findElement(By.xpath(  "//input[@id='inp_val']")).sendKeys("Raghav");
        wd.switchTo().frame("pact1");
        wd.findElement(By.xpath(  "//input[@id='inp_val']")).sendKeys("Raghav");
        wd.switchTo().frame("pact2");
        wd.findElement(By.xpath(  "//input[@id='jex']")).sendKeys("Singh");

        wd.switchTo().parentFrame(); // This will move to the Parent Frame of Pact 2 which is Pact1
        wd.switchTo().parentFrame(); // This will move to the Parent Frame of Pact 1 now
    }

    @Test(alwaysRun = true)
    public void actionTest() {
        Actions a1 = new Actions(wd); // Mimic Keyboard and Mouse Operation

        //Keyboard adding uppercase text
        wd.get("https://demo.evershop.io/account/login");
        WebElement el1 = wd.findElement(By.name("email"));
        // Concept of method chaining
        a1.moveToElement(el1).click().keyDown(Keys.SHIFT).sendKeys("raghav").keyUp(Keys.SHIFT).perform();

        //If you want to do the right click then you used use "Context Click"
        a1.moveToElement(el1).contextClick().perform();
        // or you can write the below line
        //  a1.contextClick(el1).perform();
    }
}
