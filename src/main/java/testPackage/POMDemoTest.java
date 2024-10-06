package testPackage;

import POM.HomePageModel;
import POM.ItemModel;
import POM.LoginModel;
import manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class POMDemoTest {

    ChromeOptions chromeOptions;
    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.31.159:4444"), chromeOptions);
        WebDriverManager.setWebDriver(wd);
    }

    @Test
    public void addItemToCartForGeography() throws InterruptedException {
         WebDriver wd = WebDriverManager.getWebDriver();
        LoginModel login = new LoginModel(wd);
        HomePageModel homePageModel = new HomePageModel(wd);
        ItemModel itemModel = new ItemModel(wd);
        login.enterTheURL()
                .fillCredentials("akhiljda@gmail.com", "Password")
                .clickSubmitButton();
        homePageModel.selectItemName("Geography class chuck taylor all star");
        Assert.assertEquals(itemModel.getItemName(), "Geography Class Chuck Taylor All Star");
        itemModel.fillQuantity("4")
                .selectSize("XL")
                .selectColour("Black")
                .clickOnAddToCart();
    }

    @Test
    public void addItemToCartForNike() throws InterruptedException {
        WebDriver wd = WebDriverManager.getWebDriver();
        LoginModel login = new LoginModel(wd);
        HomePageModel homePageModel = new HomePageModel(wd);
        login.enterTheURL()
                .fillCredentials("akhiljda@gmail.com", "Password")
                .clickSubmitButton();
        homePageModel.selectItemName("Nike air zoom pegasus 35");
    }

    @Test
    public void addItemToCartForSeasonal() throws InterruptedException {
        WebDriver wd = WebDriverManager.getWebDriver();
        LoginModel login = new LoginModel(wd);
        HomePageModel homePageModel = new HomePageModel(wd);
        login.enterTheURL()
                .fillCredentials("akhiljda@gmail.com", "Password")
                .clickSubmitButton();
        homePageModel.selectItemName("Seasonal color chuck 70");
    }

//    @AfterMethod
//    public void tearDown(){
//        WebDriver wd = WebDriverManager.getWebDriver();
//        if(wd!=null){
//            wd.quit();
//            WebDriverManager.setWebDriver(null);
//        }
//    }
}
