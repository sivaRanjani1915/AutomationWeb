Feature: managedContent.feature

  Background:
    Then clear all array list
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9515 Managed Content Block appears for tier2 when managed content is present
    When the user sets testcase configurations '9515' '2151' '7143'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then verify managed content block exists


    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9517 Managed Content Block appears for tier3 when managed content is present
    When the user sets testcase configurations '9517' '2153' '7143'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify managed content block exists

    Examples:
      | email               | password  | tier1   | tier2   | tier3 |
      | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9519 Managed Content Block appears for tier4 when managed content is present
    When the user sets testcase configurations '9519' '2155' '7143'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify managed content block exists

    Examples:
      | email               | password  | tier1   | tier2   | tier3 | tier4   |
      | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit | Bananas |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9510 Managed Content Block is present when cms keyword is searched
    When the user sets testcase configurations '9510' '2146' '7143'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then clear all array list
    When user searches for '<productType>' product
    Then verify managed content block exists

    Examples:
      | email               | password  | productType   |
      | matt_auto@gmail.com | password1 | is_sellable:true |
