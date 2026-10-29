
@Infoez @Login
Feature: Infoez Customer Login functionality

  Background:
    Given the user launch the application
    When the user tap profile button
    And the user tap login or register button

  @Positive @Login_Positive
  Scenario Outline: Verify complete customer login positive flow

    Then the Infoez application should be launched successfully
    And the Infoez login screen should be displayed
    When the user enter username "<username>"
    And the user enter password "<password>"
    And the user click on login button
    Then the user redirected the home page "<HomePage>"

    Examples:
      | username            | password     | HomePage |
      | customer@infoez.com | Customer@123 | Valid    |

  @Negative @Login_Negative
  Scenario Outline: Verify customer login negative validations

    When the user enter username "<username>"
    And the user enter password "<password>"
    And the user click on login button
    Then the login validation error should be displayed

    Examples:
      | username            | password     |
      | invalid-email       | Customer@123 |
      | unknown@test.com    | Customer@123 |
      | customer@infoez.com | invalid123   |
      |                     |              |
