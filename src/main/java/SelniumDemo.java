
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

public class SelniumDemo {

    @Test
    public void SuccessLoginTest() throws MalformedURLException {

           //WebDriver cd = new ChromeDriver();
      //   WebDriver fd = new FirefoxDriver();
       //  cd.get("https://www.selenium.dev/downloads/");
         Wait fluentWait;

        // Using Selenium GRID
      // FirefoxOptions fo = new FirefoxOptions();
      //  ChromeDriver cd = new ChromeDriver();
        ChromeOptions cd = new ChromeOptions();
        WebDriver wd = new RemoteWebDriver(new URL("http://localhost:4444"), cd); // Inovking selenium grid

        wd.get("https://demo.evershop.io/account/login");
//       wd.findElement(By.xpath("//input[@name='email']"));
         wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");

    //    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); // Syntax for Explicit method ->> We have optimised time.


        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Syntax for implicit wait
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.quit();

      //  wd.findElement(By.name("email")).sendKeys("abc");
    }

    @Test
    public void UnSuccessLoginTest() throws MalformedURLException {
        ChromeOptions cd = new ChromeOptions();
        WebDriver wd = new RemoteWebDriver(new URL("http://localhost:4444"), cd); // Inovking selenium grid
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.quit();
    }
}
