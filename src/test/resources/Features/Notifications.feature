@Infoez @Notifications

Feature: Infoez Notifications

  Background:
    Given the Infoez login screen is displayed
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed

  Scenario: TC_61 Open Notifications
    When I open Notifications
    Then a notification item should be displayed