package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutStepTwoPage {

    private WebDriver driver;
    private By finishButton = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finish() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(finishButton));
            button.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Finish button: " + e.getMessage());
        }
    }
}
