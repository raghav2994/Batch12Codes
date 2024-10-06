package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemModel {

    WebDriver wd;

    private By itemNameText = By.xpath("//h1[@class='product-single-name']");
    private By quantityTextBox = By.xpath("//input[@name='qty']");
    private By addToCartButton = By.xpath("//button[@type='button']");

    private String itemSizeXpathLocator = "//ul[contains(@class, 'variant-option-list')][1]/li/a[text()='%s']";
    private String itemColourXpathLocator = "//ul[contains(@class, 'variant-option-list')][1]/li/a[text()='%s']";

    public ItemModel(WebDriver wd) {this.wd = wd;}

    public String getItemName(){
        return wd.findElement(itemNameText).getText();
    }

    public ItemModel fillQuantity(String quantity){
        wd.findElement(quantityTextBox).clear();
        wd.findElement(quantityTextBox).sendKeys(quantity);
        return this;
    }

    public ItemModel selectSize(String size){
        String itemSizeLocator = itemSizeXpathLocator.replace("%s", size);
        By itemSizeLink = By.xpath(itemSizeLocator);
        wd.findElement(itemSizeLink).click();
        return this;
    }

    public ItemModel selectColour(String colour){
        String itemColourLocator = itemColourXpathLocator.replace("%s", colour);
        By itemColourLink = By.xpath(itemColourLocator);
        wd.findElement(itemColourLink).click();
        return this;
    }

    public void clickOnAddToCart(){
        wd.findElement(addToCartButton).click();
    }

}
