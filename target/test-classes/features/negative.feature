Feature: Negative and edge cases

  Scenario: Empty username and password shows error
    Given I open the saucedemo site
    When I login with username "" and password ""
    Then I should see error containing "Username is required"

  Scenario: Problem user can login but UI may be broken
    Given I open the saucedemo site
    When I login with username "problem_user" and password "secret_sauce"
    Then I should see products page with at least 1 items