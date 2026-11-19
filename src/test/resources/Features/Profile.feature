Feature: Customer Profile Module

Background: Given user is logged into the Infoez application

Scenario Outline: Verify business search with valid business names 
When user navigates to explore businesses 
And user searches for business "<businessName>" 
Then business listing should be displayed 
And business "<businessName>" should be available

Examples:
  | businessName |
  | Aroma Cafe   |
  | Hotel        |
  | Cafe         |


Scenario Outline: Verify business search with invalid business names 
When user navigates to explore businesses 
And user searches for business "<businessName>" 
Then no matching business should be displayed

Examples:
  | businessName       |
  | InvalidBusiness123 |
  | XYZ98765           |
  | UnknownBusiness    |


Scenario Outline: Verify adding businesses to saved places 
When user navigates to explore businesses 
And user saves the business "<businessName>" 
And user navigates to saved places 
Then saved business "<businessName>" should be displayed

Examples:
  | businessName |
  | Aroma Cafe   |
  | Hotel        |
  | Cafe         |

Scenario Outline: Verify removing businesses from saved places 
Given business "<businessName>" is already saved 
When user navigates to saved places 
And user removes the saved business "<businessName>" 
Then saved business "<businessName>" should not be displayed

Examples:
  | businessName  |
  | Mobile shop   |
  | Iron Peak Gym |
  

Scenario Outline: Verify customer notifications 
When user navigates to notifications 
Then notification "<notificationTitle>" should be displayed 
And notification message should contain "<message>"

Examples:
  | notificationTitle | message      |
  | Claim Approved    | was approved |
  | Claim Rejected    | was rejected |

Scenario Outline: Verify unavailable notifications 
When user navigates to notifications 
Then notification "<notificationTitle>" should not be displayed

Examples:
  | notificationTitle |
  | Payment Failed    |
  | Booking Cancelled |


Scenario Outline: Verify submitting enquiry with valid messages 
When user navigates to explore businesses 
And user searches for business "<businessName>" 
And user opens the first business result 
Then the Business Details screen should be displayed 
When user opens Enquiries 
And user enters enquiry message "<message>" 
And user submits the enquiry 
Then the enquiry should be submitted successfully

Examples:
  | businessName | message                   |
  | Aroma Cafe   | I would like more details |


Scenario Outline: Verify submitting enquiry with empty messages 
When user navigates to explore businesses 
And user searches for business "<businessName>" 
And user opens the first business result 
Then the Business Details screen should be displayed 
When user opens Enquiries 
And user enters enquiry message "<message>" 
And user submits the enquiry 
Then an enquiry validation error should be displayed

Examples:
  | businessName | message |
  | Aroma Cafe   |         |