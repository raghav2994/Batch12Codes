package podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM {

    WebDriver wd;

//    @FindBy(name = "email")
//    private WebElement userName;

   /*Using constructor to avoid invoking webDriver on method level.
    As when this call is called constructor will be invoked automaticakky
    and so we are overloading the constructor with WebDriver as parameter */

    public LoginPOM(WebDriver wd){
        this.wd = wd;
    }

    // Properties

         //User Name
         private By userName = By.name("email");

         // Password
         private By passwordField = By.name("password");

         //URL
    private String pageURL = "https://demo.evershop.io/account/login";

         //Submit
    private By submitButton = By.xpath("//button [@type='submit']");

    //Behaviours[Methods]

        //fill in the form

    public LoginPOM fillCredentials(String userNameText, String passwordText){

       // We should avoid hardcoding and we will be creating variables for each variable
//
//         wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
//         wd.findElement(By.name("password")).sendKeys("Password");
//
//        wd.findElement(userName).sendKeys("akhiljda@gmail.com");
//       wd.findElement(passwordField).sendKeys("Password");

        wd.findElement(userName).sendKeys(userNameText);
        wd.findElement(passwordField).sendKeys(passwordText);
        return this;

    }

    public LoginPOM enterEmail(String emailText){
        wd.findElement(userName).sendKeys(emailText);
        return this;
    }

    public LoginPOM enterPassword(String password){
        wd.findElement(passwordField).sendKeys(password);
        return this;
    }

        //click on Submit, using return type as class name to achieve the concept of chaining

    public void clickOnSubmit(){
        wd.findElement(submitButton).click();
    }

    public LoginPOM get(){
        wd.get(pageURL);
        return this;
    }
}
