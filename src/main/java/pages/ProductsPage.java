package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;
    private By inventoryItems = By.cssSelector(".inventory_item");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By addToCartButtons = By.cssSelector(".inventory_item button");
    private By removeButtons = By.cssSelector(".inventory_item button");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By sortSelect = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public int countItems() {
        return driver.findElements(inventoryItems).size();
    }

    public void addItemToCartByIndex(int index) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(index).click();
    }

    public void removeItemFromCartByIndex(int index) {
        List<WebElement> buttons = driver.findElements(removeButtons);
        buttons.get(index).click();
    }

    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public int getCartCount() {
        try {
            String text = driver.findElement(cartBadge).getText();
            return Integer.parseInt(text);
        } catch (Exception e) {
            return 0;
        }
    }

    public void sortBy(String optionValue) {
        org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(driver.findElement(sortSelect));
        s.selectByVisibleText(optionValue);
    }

    public List<String> itemNames() {
        return driver.findElements(By.cssSelector(".inventory_item_name")).stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}
