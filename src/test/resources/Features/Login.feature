@Infoez @Customer @Login
Feature: Infoez Customer Login functionality

  Background:
    Given the Infoez login screen is displayed

  @Positive @Login_Positive
  Scenario: Login with valid customer credentials
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed

  @Negative @Login_Negative
  Scenario Outline: Reject invalid customer login credentials
    When I enter email "<email>" and password "<password>"
    And I tap the Login button
    Then a login validation error should be displayed

    Examples:
      | email                    | password       |
      | invalid-email            | Customer@123   |
      | unknown@test.com         | Customer@123   |
      | customer@infoez.com      | incorrect-pass |
      |                          |                |
      | customer@infoez.com      |                |
      |                          | Customer@123   |
