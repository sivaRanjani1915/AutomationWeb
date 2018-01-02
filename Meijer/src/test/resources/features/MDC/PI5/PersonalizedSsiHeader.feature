Feature: PersonalizedSsiHeader.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45441 - header widget pulls name from cookie in SSI state on homepage
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '45441' '20355' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    Then verify account header widget displays welcome message

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45075 - header widget still recognizes user when fully authenticated
    And the user sets testcase configurations '45075' '20020' '45068'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then user clicks Keep this Store on passive store selection modal
    Then verify SSI token exists
    Then verify account header widget displays welcome message
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then verify account header widget displays welcome message

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45076 - header still does not recognize user when fully logged out
    Given user navigate to test environment URL
    And the user sets testcase configurations '45076' '20023' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    Then verify account header widget displays welcome message
    Then click 'Not You' link on the account header
    Then user clicks x to close sign in modal
    Then verify account header widget does not display welcome message

    Examples:
      |  |
      |  |
