Feature: SsiPersonalizedSearch.feature

  Background:
    Then clear all array list

#  38225 SSI-Personalized category and search results
  @ssiPersonalizedSearch
  Scenario Outline: TC 39897 -  When user is in SSI state the search results should be the same as an authenticated user who has purchase history
    Given user navigate to MeijerDotCom
#THESE REPORTING NUMBERS ARE PLACEHOLDERS.. FILL THEM IN
    And the user sets testcase configurations '39897' '5720' '39711'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    When user searches for '<searchTerm>' product
    Then user records search results
    Then store cartID
    Then user closes and opens browser to enter SSI state
    When user searches for 'milk' product
    Then user verifies search results match previous results

    Examples:
      | searchTerm |
      | milk       |
      | bananas    |
      | beer       |

  @ssiPersonalizedSearch
  Scenario Outline: TC 39897 -  When user is in SSI state the tier browsing results should be the same as an authenticated user who has purchase history
    Given user navigate to MeijerDotCom
#THESE REPORTING NUMBERS ARE PLACEHOLDERS.. FILL THEM IN
    And the user sets testcase configurations '39897' '5720' '39711'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then user records search results
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then user verifies search results match previous results

    Examples:
      | tier1   | tier2          |
      | Grocery | Pantry         |








