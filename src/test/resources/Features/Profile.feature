Feature: Profile page functionality

  Background:
    When the user navigates to the Profile page

  Scenario Outline: Verify profile menu options
    Then the "<menuOption>" option should be displayed

    Examples:
      | menuOption         |
      | Explore businesses |
      | Saved places       |
      | My enquiries       |
      | Notifications      |

  Scenario Outline: Navigate to profile menu pages
    When the user taps <menuOption>
    Then the <pageName> page should be displayed

    Examples:
      | menuOption         | pageName           |
      | Explore businesses | Explore businesses |
      | Saved places       | Saved places       |
      | My enquiries       | My enquiries       |
      | Notifications      | Notifications      |

  Scenario Outline: Verify bottom navigation
    Then the "<navigation>" navigation should be displayed

    Examples:
      | navigation |
      | Home       |
      | Search     |
      | Saved      |
      | Profile    |

  Scenario: Logout from profile
    When the user taps the Logout icon
    Then the logout confirmation or login page should be displayed
