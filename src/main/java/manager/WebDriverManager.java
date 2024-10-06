package manager;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return threadLocalDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }
}

