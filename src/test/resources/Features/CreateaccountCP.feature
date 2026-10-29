
@Infoez @Customer @CreateAccount
Feature: Infoez Customer Create Account

  Background:
    Given the Infoez create account screen is displayed

  @Positive @CreateAccount_Positive
  Scenario Outline: Verify complete customer create account positive flow

    Then the create account screen should be visible
    When I select the Customer account type
    Then the Customer account type should be selected
    When I enter full name "<fullName>"
    And I enter email "<email>"
    And I enter password "<password>"
    And I click the Create account button
    Then the customer account should be created successfully
    When the Infoez create account screen is displayed
    And I click the Log in tab
    Then the login screen should be displayed
    When the Infoez create account screen is displayed
    And I click the "<demoType>" demo account
    Then the customer demo account should be opened
    When the Infoez create account screen is displayed
    And I click the close button
    Then the create account screen should be closed

    Examples:
      | fullName      | email                  | password   | demoType |
      | Test Customer | customer01@example.com | Test@12345 | Customer |

  @Negative @CreateAccount_Negative
  Scenario Outline: Verify customer registration negative validations

    When I select the Customer account type
    Then the Customer account type should be selected
    When I enter full name "<fullName>"
    And I enter email "<email>"
    And I enter password "<password>"
    And I click the Create account button
    Then the registration validation should be displayed

    Examples:
      | fullName      | email            | password   |
      | Test Customer | invalidemail     | Test@12345 |
      | Test Customer | invalid@         | Test@12345 |
      | Test Customer | @example.com     | Test@12345 |
      | Test Customer | test@example.com | 123        |
      | Test Customer | test@example.com | 12345      |
      | Test Customer | test@example.com | 1234567    |
