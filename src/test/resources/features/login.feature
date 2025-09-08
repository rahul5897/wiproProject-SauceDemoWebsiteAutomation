Feature: Login functionality

  Scenario: Successful login with standard user
    Given I open the saucedemo site
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see products page with at least 1 items

  Scenario: Locked out user should see error
    Given I open the saucedemo site
    When I login with username "locked_out_user" and password "secret_sauce"
    Then I should see error containing "locked out"

  Scenario: Wrong password shows error
    Given I open the saucedemo site
    When I login with username "standard_user" and password "wrong"
    Then I should see error containing "Username and password do not match"