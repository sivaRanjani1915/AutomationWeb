Feature: NotMeLink.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49165 - not you link does not appear on first visit for guest users
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '49165' '28408' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then verify SSI token does NOT exist
    Then verify 'Not You' link does not display on the account header

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49167 - not you link does not appear for fully authenticated users
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '49167' '28411' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then verify SSI token exists
    Then verify 'Not You' link does not display on the account header

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49168 - not you link appears when user comes back to meijer.com after logging out of a previous session
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '49168' '28414' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    Then verify 'Not You' link displays on the account header

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49169 - not you link does not appear when user logs out of a fully authenticated session
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '49169' '28417' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user logs out from the account header
    Then verify SSI token does NOT exist
    Then verify 'Not You' link does not display on the account header

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49170 - not you link does not appear when user logs out from an ssi state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '49170' '28420' '45068'
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
    Then verify SSI token does NOT exist
    Then verify 'Not You' link does not display on the account header

    Examples:
      |  |
      |  |
