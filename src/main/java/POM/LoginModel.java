package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModel {

    WebDriver wd;
    private By email = By.name("email");
    private By password = By.name("password");
    private String loginURL = "https://demo.evershop.io/account/login";
    private By submitButton = By.xpath("//button [@type='submit']");

    public LoginModel(WebDriver wd) {this.wd = wd;}

    public LoginModel enterTheURL(){
        wd.get(loginURL);
        return this;
    }

    public LoginModel fillCredentials(String emailId, String passwordField) {
        wd.findElement(email).sendKeys(emailId);
        wd.findElement(password).sendKeys(passwordField);
        return this;
    }

    public LoginModel clickSubmitButton() {
        wd.findElement(submitButton).click();
        return this;
    }

}
