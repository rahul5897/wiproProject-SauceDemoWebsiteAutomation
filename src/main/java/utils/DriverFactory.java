package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            try {
                // Clear cache and ensure latest compatible driver is downloaded
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions options = new ChromeOptions();
        		options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } catch (Exception e) {
                System.out.println("Error initializing WebDriver: " + e.getMessage());
                throw new RuntimeException("Failed to initialize ChromeDriver", e);
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
