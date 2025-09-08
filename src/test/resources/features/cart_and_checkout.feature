Feature: Cart and Checkout flows

  Scenario: Add two items and verify cart badge
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    And I add 2 items to cart
    Then cart count should be 2

  Scenario: Checkout completes successfully
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    And I add 1 items to cart
    And I open the cart
    And I click checkout
    And I fill checkout info with "Rahul", "Singh", "58972"
    And I finish checkout
    Then I should see order complete text "Thank you for your order!"

  Scenario: Remove item from products page updates cart badge
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    And I add 1 items to cart
    Then cart count should be 1
    When I remove 1 item from cart by index 0
    Then cart count should be 0