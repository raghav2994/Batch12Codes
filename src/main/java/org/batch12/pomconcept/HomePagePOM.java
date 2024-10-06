package org.batch12.pomconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM {

    private WebDriver wd;

    public HomePagePOM(WebDriver webDriver){
        this.wd = webDriver;
    }

    private String productNameInString = "//div[@class='listing-tem']//a/span[text()='%s']";


    public HomePagePOM clickOnProduct(String itemName) throws InterruptedException {
        String productNameFinal = productNameInString.replace("%s",itemName);
        By item  = By.xpath(productNameFinal);
        Thread.sleep(4000);
        wd.findElement(item).click();
        return this;
    }

}
