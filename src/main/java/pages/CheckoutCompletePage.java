package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage {

    private WebDriver driver;
    private By completeTextLocator = By.className("complete-header"); // Use the correct class from site

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompleteText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(completeTextLocator));
            return element.getText().trim(); // trim spaces
        } catch (Exception e) {
            throw new RuntimeException("Failed to get order complete text: " + e.getMessage());
        }
    }
}
