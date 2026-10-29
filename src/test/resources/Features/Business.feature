@Infoez @Business

Feature: Infoez Business Details

  Background:
    Given the Infoez login screen is displayed
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed
    When I search for "business_name"
    And I open the first business result
    Then the Business Details screen should be displayed

  Scenario: TC_29 Verify Business Details
    Then the Business Details screen should be displayed

  Scenario Outline: Verify business contact and navigation options
    When I tap "<action>"

    Examples:
      | action    |
      | Call      |
      | WhatsApp  |
      | Directions|
      | Share     |