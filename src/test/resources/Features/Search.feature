
@Infoez @Customer @ExploreBusinesses
Feature: Infoez Customer Explore Businesses functionality

  Background:
    Given the user is on the Explore Businesses page

  @Positive @Explore_Positive
  Scenario Outline: Verify complete Explore Businesses positive flow

    When the user searches for "<searchText>"
    Then the search results should be displayed
    And the results should match the search text "<searchText>"
    When the user selects the "<filterName>" filter
    Then the "<filterName>" filter should be selected
    And the filtered business results should be displayed
    When the user sorts results by "<sortOption>"
    Then the results should be sorted by "<sortOption>"
    When the user searches for "<businessName>"
    Then the business "<businessName>" should be displayed
    And the business rating should be displayed
    And the business location should be displayed
    And the business availability should be displayed

    Examples:
      | searchText            | filterName | sortOption    | businessName          |
      | Aroma Cafe            | Verified   | Most relevant | Aroma Cafe            |
      | Saloon                | 4+ rating  | Rating        | Saloon                |
      | Artisan Dental Clinic | Featured   | Most relevant | Artisan Dental Clinic |
      | Dental Clinic         | Verified   | Rating        | Artisan Dental Clinic |
      | Cafe                  | Featured   | Most relevant | Aroma Cafe            |

  @Negative @Explore_Negative
  Scenario Outline: Verify Explore Businesses negative search validations

    When the user searches for "<searchText>"
    Then no matching business results should be displayed
    And the search empty state message should be displayed

    Examples:
      | searchText              |
      | xyzinvalidbusiness123   |
      | @@@###$$$               |
      | 999999999999999         |
