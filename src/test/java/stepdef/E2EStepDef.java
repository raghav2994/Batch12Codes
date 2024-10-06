package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import podtest.pom.HomePOM;
import podtest.pom.ItemPOM;
import podtest.pom.LoginPOM;

import java.net.MalformedURLException;
import java.net.URL;

public class E2EStepDef {

    private WebDriver wd;
    LoginPOM login;
    HomePOM home;
    ItemPOM item;

    @Before
    public void setUpWebDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.29.125:4444"), chromeOptions);
        login = new LoginPOM(wd);
        home = new HomePOM(wd);
        item = new ItemPOM(wd);
    }

    @After
    public void tearDownWebDriver() {
        if (wd != null) {
            wd.quit();
        }
    }


    @Given("User is already loggedIn with credentials as {string} and {string}")
    public void userLogin(String UN, String PW) {
        login.get().fillCredentials(UN, PW).clickOnSubmit();
    }

    @Given("User clicks on Item {string}")
    public void clickItem(String itemName) throws InterruptedException {
        Thread.sleep(2000);
        home.clickItem(itemName);
    }

    @When("User selects the item options size as {string} and color as {string}")
    public void selectItemOption(String size, String colour) throws InterruptedException {
        Thread.sleep(10000); // Just to show you the execution, I have added it
        item.fillQuantity("2")
                .selectSize(size)
                .selectColour(colour);
    }

    @When("User clicks on AddToCart")
    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(3000); // Just to show you the execution, I have added it
        item.clickAddToCart();
    }

}
