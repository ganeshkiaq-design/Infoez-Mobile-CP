
Feature: Saved Places Module

  As a user of the Infoez mobile application
  I want to manage my saved places
  So that I can view and access my favourite places

  Background:
    Given the user launches the Infoez application
    And the user navigates to the Saved Places module

   Scenario Outline: Verify saved places are displayed correctly
    When the user views the saved places list
    Then the saved places screen should be displayed
    And the saved places count should be "<count>"
    And the place "<placeName>" should be displayed
    And the rating should be "<rating>"
    And the review count should be "<reviews>"
    And the location should be "<location>"
    

    Examples:
      | count | placeName  | rating | reviews | location 
      | 5     | Petal & Loom Bakery | 5.0    | 2       |


Scenario Outline: Verify negative scenarios in Saved Places module
  When the user views the saved places list
  Then the application should handle "<condition>" correctly
  And the application should display "<expectedResult>"

  Examples:
    | condition                  | expectedResult                 |
    | No saved places             | No saved places message         |
    | Location name is unavailable | Location unavailable message  |
		 
      
      