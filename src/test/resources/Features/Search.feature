Feature: Search Functionality

Given user is on the Explore Businesses page

Scenario Outline: Verify business search with valid inputs 

When user enters "<searchKeyword>" in the business search field 
And user taps the business search button 
Then matching businesses should be displayed for "<searchKeyword>"

Examples: | searchKeyword | | Aroma Cafe | | VIDYASHARAM | | Spa | | Restaurant |

Scenario Outline: Verify business search with invalid inputs 

When user enters "<searchKeyword>" in the business search field 
And user taps the business search button 
Then the business search should show "<expectedResult>"

Examples: | searchKeyword | expectedResult | 
          | InvalidXYZ123 | NO_RESULTS | 
          | @@@###$$$ | NO_RESULTS | 
          | EMPTY | VALIDATION | 
          | SPACES | VALIDATION |

Scenario Outline: Verify business filter selection functionality 
When user taps the "<filterType>" filter 
Then the "<filterType>" filter should be selected 
And "<expectedResult>" should be displayed

Examples: | filterType | expectedResult | 
          | Verified | Only verified businesses | 
          | 4 plus rating | Businesses with 4 or above rating |
          | Featured | Only featured businesses |

Scenario Outline: Verify business filter deselection functionality 
When user taps the "<filterType>" filter 
And user taps the "<filterType>" filter again 
Then the "<filterType>" filter should be deselected 
And all matching businesses should be displayed

Examples: | filterType | 
          | Verified | 
          | 4 plus rating |
          | Featured |

Scenario Outline: Verify business sorting functionality 
When user taps the Most relevant sorting option 
And user selects "<sortOption>" 
Then businesses should be sorted by "<sortOption>"

Examples: | sortOption | | Most relevant | | Rating |
