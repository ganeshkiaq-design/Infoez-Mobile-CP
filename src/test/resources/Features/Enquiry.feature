@Infoez @Enquiry

Feature: Infoez Enquiry

  Background:
    Given the Infoez login screen is displayed
    When I enter valid Infoez credentials
    And I tap the Login button
    Then the Infoez Home or Explore screen should be displayed
    When I search for "business_name"
    And I open the first business result
    Then the Business Details screen should be displayed
    When I open Enquiries

  Scenario Outline: Submit enquiry with different messages
    When I enter enquiry message "<message>"
    And I submit the enquiry
    Then <expectedResult>

    Examples:
      | message                  | expectedResult                               |
      | I would like more details | the enquiry should be submitted successfully |
      |                          | an enquiry validation error should be displayed |