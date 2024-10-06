package org.batch12.pomconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver wd;

    private By emailIDField = By.xpath("//input[@name = 'email']");
    private By passwordField = By.name("password");
    private By submitButtonCTA = By.xpath("//button[@type = 'submit']");

    private String url = "https://demo.evershop.io/account/login";

    public LoginPage(WebDriver webdriver){
        this.wd = webdriver;
    }

    public LoginPage enterEmail(String email){
        wd.findElement(emailIDField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String email){
        wd.findElement(passwordField).sendKeys(email);
        return this;
    }

    public void clickOnSubmitButton(){
        wd.findElement(submitButtonCTA).click();
    }

    public LoginPage getTheURL(){
        wd.get(url);
        return this;
    }


}
