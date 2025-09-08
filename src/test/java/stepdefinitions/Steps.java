package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;
import utils.DriverFactory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Steps {
	private WebDriver driver;
	private LoginPage login;
	private ProductsPage products;
	private CartPage cart;
	private CheckoutStepOnePage checkout1;
	private CheckoutStepTwoPage checkout2;
	private CheckoutCompletePage complete;
	private Properties prop = new Properties();

	@Before
	public void setup() throws Exception {
		prop.load(new FileInputStream("src/test/resources/config.properties"));
		driver = DriverFactory.initDriver();
		login = new LoginPage(driver);
		products = new ProductsPage(driver);
		cart = new CartPage(driver);
		checkout1 = new CheckoutStepOnePage(driver);
		checkout2 = new CheckoutStepTwoPage(driver);
		complete = new CheckoutCompletePage(driver);
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	@Given("I open the saucedemo site")
	public void i_open_the_saucedemo_site() {
		login.open(prop.getProperty("baseUrl"));
	}

	@When("I login with username {string} and password {string}")
	public void i_login_with_username_and_password(String user, String pass) {
		login.login(user, pass);
	}

	@Then("I should see error containing {string}")
	public void i_should_see_error_containing(String text) {
		Assert.assertTrue(login.getError().contains(text));
	}

	@Then("I should see products page with at least {int} items")
	public void i_should_see_products_page_with_at_least_items(Integer count) {
		Assert.assertTrue(products.countItems() >= count);
	}

	@When("I add {int} items to cart")
	public void i_add_items_to_cart(Integer count) {
		for (int i = 0; i < count; i++) {
			products.addItemToCartByIndex(i);
		}
	}

	@Then("cart count should be {int}")
	public void cart_count_should_be(Integer expected) {
		Assert.assertEquals(products.getCartCount(), expected.intValue());
	}

	@When("I open the cart")
	public void i_open_the_cart() {
		products.openCart();
	}

	@When("I click checkout")
	public void i_click_checkout() {
		cart.checkout();
	}

	@When("I fill checkout info with {string}, {string}, {string}")
	public void i_fill_checkout_info_with(String fn, String ln, String zip) {
		checkout1.fillInfo(fn, ln, zip);
	}

	@When("I finish checkout")
	public void i_finish_checkout() throws InterruptedException {
		Thread.sleep(2000);
		checkout2.finish();
	}

	@Then("I should see order complete text {string}")
	public void i_should_see_order_complete_text(String text) {
	    String actualText = complete.getCompleteText();
	    Assert.assertTrue(actualText.equalsIgnoreCase(text), 
	        "Expected text: " + text + ", but found: " + actualText);
	}


	@When("I remove {int} item from cart by index {int}")
	public void i_remove_item_from_cart_by_index(Integer removeCount, Integer index) {
		// removeCount is not used here; remove by index
		products.removeItemFromCartByIndex(index);
	}

	@When("I sort products by {string}")
	public void i_sort_products_by(String option) {
		products.sortBy(option);
	}

	@Then("the product names list should be returned")
	public void the_product_names_list_should_be_returned() {
		List<String> names = products.itemNames();
		Assert.assertTrue(names.size() > 0);
	}
}
