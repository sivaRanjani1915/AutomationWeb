Feature: SsiAccessQuickshop.feature

  Background:
    Then clear all array list

  @PI5
  @OUT_DATED
  Scenario Outline: TC 57418 - frequent purchases list is maintained from authenticated to SSI state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57418' '36799' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then store frequent purchases list
    Then user closes and opens browser to enter SSI state
    Then click on Quick Shop link on Curbside Wizard
    Then validate Quick Shop Page display
    Then verify frequent purchases list previous state

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57423 - frequent purchases list is maintained from SSI state to authenticated
  #--users frequent purchases populates
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57423' '36800' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then store frequent purchases list
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then verify frequent purchases list previous state

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57441 - frequent purchases view all list is maintained from authenticated to SSI state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57441' '36801' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then store frequent purchases list
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks view all from Frequent Purchases
    Then store view all frequent purchases list
    Then verify view all frequent purchases list matches previous state

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57449 - frequent purchases view all list is maintained from SSI state to authenticated
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57449' '36802' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks view all from Frequent Purchases
    Then store view all frequent purchases list
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks view all from Frequent Purchases
    Then verify view all frequent purchases list matches previous state

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57456 - user suggested purchases list is maintained from authenticated to SSI state
  #--users suggested purchases populates
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57456' '36803' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then store suggested purchase list
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then validate suggested purchases list matches previous state

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57464 - user suggested purchases list is maintained from SSI state to authenticated
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57464' '36804' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then store suggested purchase list
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then validate suggested purchases list matches previous state

    Examples:
      |  |
      |  |
