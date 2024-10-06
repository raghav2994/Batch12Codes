package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageModel {
    WebDriver wd;
    //private By itemName = By.xpath("//div[@class='listing-tem']//a/span[text()='Seasonal color chuck 70']");
    private String homePageURL = "https://demo.evershop.io/";

    private String itemTextXpathLocator = "//div[@class='listing-tem']//a/span[text()='%s']";

    public HomePageModel(WebDriver wd) {this.wd = wd;}


    public void scrollToProductLineItem(WebElement element) {
        ( (JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectItemName(String itemName) throws InterruptedException {
        Thread.sleep(5000);
        String productLine = itemTextXpathLocator.replace("%s", itemName);
        System.out.println("Original String is" + itemTextXpathLocator);
        System.out.println("Replaced String is" + productLine);
        By itemTextLink = By.xpath(productLine);
        WebElement item = wd.findElement(itemTextLink);
        scrollToProductLineItem(item);
        item.click();
    }

}
