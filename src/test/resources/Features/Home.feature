
Feature: Infoez Home Module Functionality

  Background:
    Given user is on the Infoez home screen


  @Home @Positive
  Scenario: Verify Infoez home screen elements
    Then user should see Infoez logo
    And user should see search field
    And user should see Near Me button
    And user should see current location
    And user should see Explore Categories section
    And user should see Featured section
    And user should see bottom navigation


  @Home @Search @Positive
  Scenario Outline: Verify search with valid inputs
    When user enters "<searchInput>" in the search field
    And user clicks the search button
    Then user should see search results

    Examples:
      | searchInput   |
      | Restaurant    |
      | Beauty & Spa  |
      | Fitness       |
      | Home Services |


  @Home @Search @Negative
  Scenario Outline: Verify search with invalid inputs
    When user enters "<searchInput>" in the search field
    And user clicks the search button
    Then user should see "<expectedMessage>"

    Examples:
      | searchInput   | expectedMessage |
      | Invalid123XYZ | NO_RESULTS      |
      | @@@###$$$     | NO_RESULTS      |
      | EMPTY         | VALIDATION      |
      | SPACES        | VALIDATION      |


  @Home @NearMe @Positive
  Scenario: Verify Near Me functionality
    When user clicks Near Me button
    Then user should see nearby businesses


  @Home @NearMe @Negative
  Scenario: Verify Near Me when location permission is denied
    When user denies location permission
    And user clicks Near Me button
    Then user should see location permission message


  @Home @Location @Positive
  Scenario: Verify location dropdown navigation
    When user clicks current location
    Then user should navigate to location selection screen


  @Home @Location @Positive
  Scenario Outline: Verify location selection
    When user clicks current location
    And user selects "<location>"
    Then selected location should be displayed

    Examples:
      | location  |
      | Chennai   |
      | Bangalore |
      | Mumbai    |


  @Home @Location @Negative
  Scenario Outline: Verify invalid location selection
    When user clicks current location
    And user searches for "<location>"
    Then user should see location message "<expectedMessage>"

    Examples:
      | location        | expectedMessage |
      | InvalidCity123  | LOCATION_NOT_FOUND |


  @Home @Categories @Positive
  Scenario Outline: Verify Explore Categories navigation
    When user selects "<category>" category
    Then user should navigate to the selected category

    Examples:
      | category         |
      | Restaurants      |
      | Beauty & Spa     |
      | Fitness & Wellness |
      | Home Services    |


  @Home @Categories @Positive
  Scenario: Verify See All categories
    When user clicks See All categories
    Then user should see all available categories


  @Home @Navigation @Positive
  Scenario Outline: Verify bottom navigation
    When user clicks "<tab>" tab
    Then user should navigate to "<tab>" screen

    Examples:
      | tab     |
      | Home    |
      | Search  |
      | Saved   |
      | Profile |
