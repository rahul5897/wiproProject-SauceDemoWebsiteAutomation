Feature: Products listing, sorting and names

  Scenario: Products listing has multiple items
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see products page with at least 6 items

  Scenario: Sort products by Price (low to high)
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    And I sort products by "Price (low to high)"
    Then the product names list should be returned

  Scenario: Sort products by Name (A to Z)
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    And I sort products by "Name (A to Z)"
    Then the product names list should be returned