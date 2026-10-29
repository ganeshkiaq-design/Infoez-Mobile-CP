@Infoez @Reviews

Feature: Infoez Reviews and Ratings

  Background:
    Given the Infoez login screen is displayed
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed
    When I search for "business_name"
    And I open the first business result
    Then the Business Details screen should be displayed
    When I open Reviews

  Scenario Outline: TC_54 Submit rating
    When I select rating "<rating>"
    And I submit the review
    Then the review should be submitted successfully

    Examples:
      | rating |
      | 3      |
      | 4      |
      | 5      |

  Scenario Outline: Submit review with different messages
    When I select rating "<rating>"
    And I enter review "<review>"
    And I submit the review
    Then <expectedResult>

    Examples:
      | rating | review                    | expectedResult                               |
      | 5      | Excellent service         | the review should be submitted successfully  |
      | 4      | Good experience           | the review should be submitted successfully  |
      | 5      |                           | review validation should be displayed        |