package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By checkoutBtn = By.id("checkout");
    private By continueShopping = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        driver.findElement(checkoutBtn).click();
    }

    public void continueShopping() {
        driver.findElement(continueShopping).click();
    }
}
