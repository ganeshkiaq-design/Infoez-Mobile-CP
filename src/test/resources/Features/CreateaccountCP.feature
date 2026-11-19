Feature: Verify the Customer Panel Create Account

  Background:
    Given the user launches the application
    When the user taps the profile button
    And the user taps the login or register button

  Scenario: Verify customer account creation with valid details
    When the user taps the create account card
    And the user enters a fullname "Guru"
    And the user enters an email "guru@infoez.com"
    And the user enters a password "Guru@1234"
    And the user taps on the create account button
    Then the account creation result should be "valid"

  Scenario Outline: Verify customer account creation with invalid details
    When the user taps the create account card
    And the user enters a fullname "<fullName>"
    And the user enters an email "<email>"
    And the user enters a password "<password>"
    And the user taps on the create account button
    Then the account creation result should be "<expected>"

    Examples:
      | fullName                   | email             | password    | expected |
      |                            | raja@infoez.com   | Test@123    | invalid1 |
      | Raja                       |                   | Test@1234   | invalid2 |
      | Raja                       | rajainfoez.com    |             | invalid3 |
      | lojjsdhjfddbsvdtfgcdfadfcs | raja@infoez       | Test@1234   | invalid4 |
      | Raja                       | raja@infoez.com   | test        | invalid5 |
      | !@#$%##@!#@                | raja@infoez.com   | @!@#$#@@!#  | invalid6 |
      | 12345678                   | raja@infoez.com   | Test@1234   | invalid7 |
      | Suresh V                   | suresh@infoez.com | suresh@1234 | invalid8 |
