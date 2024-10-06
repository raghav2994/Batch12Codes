package org.batch12;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterConcept {

    @Parameters({"Username"})
    @Test
    public void succesfulLogin(String un){
        FirefoxDriver cd = new FirefoxDriver();
        cd.get("https://demo.evershop.io/account/login");
        cd.findElement(By.xpath("//input[@name = 'email']")).sendKeys(un);
        cd.findElement(By.name("password")).sendKeys("Password");
        cd.findElement(By.xpath("//button[@type = 'submit']")).click();
        cd.quit();
    }




}
