@Infoez @Favorites

Feature: Infoez Favorites

  Background:
    Given the Infoez login screen is displayed
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed
    When I search for "business_name"
    And I open the first business result
    Then the Business Details screen should be displayed

  Scenario Outline: Manage business Favorites
    When I perform "<action>" on the business Favorites

    Examples:
      | action |
      | Add    |
      | Remove |

  Scenario: TC_42 Open Favorites
    When I open Favorites
    Then the saved business should be displayed