
Feature: Infoez Home Page Validation

  Background:
    Given user is on the Infoez home page

  @smoke
  Scenario: Verify home page components
    Then the current location should be visible
    And the search field should be visible
    And the Near me button should be visible
    And the Explore categories section should be visible
    And the Featured in Chennai section should be visible
    And the bottom navigation should be visible

  @search
  Scenario Outline: Search for different keywords
    When user enters "<keyword>" in the search field
    And user taps the search button
    Then search results should be displayed for "<keyword>"

    Examples:
      | keyword     |
      | Restaurants |
      | Cafes       |
      | Beauty      |
      | Fitness     |

  @categories
  Scenario Outline: Select a category
    When user selects the "<category>" category
    Then the selected category page should be displayed for "<category>"

    Examples:
      | category     |
      | Restaurants  |
      | Beauty & Spa |
      | Fitness      |

  @navigation
  Scenario Outline: Navigate using bottom navigation
    When user taps the "<tab>" tab
    Then the "<tab>" page should be displayed

    Examples:
      | tab     |
      | Home    |
      | Search  |
      | Saved   |
      | Profile |

  @location
  Scenario: Open location selector
    When user taps the current location
    Then the location selection screen should be displayed

  @nearme
  Scenario: Navigate to nearby places
    When user taps the Near me button
    Then the nearby places screen should be displayed

  @featured
  Scenario: View all featured places
    When user taps View all in the featured section
    Then the featured places screen should be displayed
