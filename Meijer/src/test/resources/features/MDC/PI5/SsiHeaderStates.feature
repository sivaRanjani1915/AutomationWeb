Feature: SsiHeaderStates.feature

  Background:
    Then clear all array list

  @PI5
  @OUT_DATED
  Scenario Outline: TC 57491 -  A customer in the SSI state with an Active Order will not see the Active Order link in the header widget at a curbside store
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57491' '36805' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    When user searches for 'is_sellable:true' product
    Then user adds '2' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then Verify active order message is not displayed in header widget
    Then Verify header widget says Reserve Curbside Pickup Time

    Examples:
      | email                     | password | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | ssiActiveOrder@meijer.com | d3stroys | zod        | krypton   | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | OH    | 45209    |

  @test1test2test3
  Scenario Outline: TC 57722 -  Clicking Order history link in the accounts dropdown will prompt user to login while in SSI state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57722' '36811' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user navigate to Order History from the account header
    #using this as a lazy way to prove user is asked to login
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully

    Examples:
      | email          | password | orderNumber | zipCode |
      | zod@meijer.com | d3stroys | 218769      | 45209   |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57704 -  Clicking Past Order link in header will prompt user to login while in SSI state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57704' '36810' '52074'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then click on Past Order link display on Curbside Wizard
#    using this as a lazy way to prove user is asked to login
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully

    Examples:
      | email          | password | orderNumber | zipCode |
      | zod@meijer.com | d3stroys | 218769      | 45209   |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57492 -  Quickshop link in header will take the user to the quickshop page in SSI state
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57492' '36806' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then click on Quick Shop link on Curbside Wizard
    Then validate Quick Shop Page display

    Examples:
      | email          | password |
      | zod@meijer.com | d3stroys |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 57493 -  A customer in the SSI state will not see the Active Order link in the header widget at a curbside store after placing a non cnc order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57493' '36807' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    When user searches for 'is_prepared_item:true' product
    Then user adds '2' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then Verify active order message is not displayed in header widget
    Then Verify header widget says Reserve Curbside Pickup Time

    Examples:
      | email                        | password |
      | ssiActiveSpoOrder@meijer.com | d3stroys |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 57494 -  A customer in the SSI state will not see the header widget at all at a non curbside store after placing a non cnc order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57494' '36808' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    When user searches for 'is_prepared_item:true' product
    Then user adds '2' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then store cartID
    Then user closes and opens browser to enter SSI state
    When user searches '49331' and sets store to 'Lowell'
    Then verify user has correct store 'Lowell'
    Then verify header widget is not present

    Examples:
      | email                        | password |
      | ssiActiveSpoOrder@meijer.com | d3stroys |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 57495 -  A customer in the SSI state will not see the header widget at all at a non curbside store after placing a cnc order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '57495' '36809' '52074'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    When user searches for 'is_sellable:true' product
    Then user adds '2' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then store cartID
    Then user closes and opens browser to enter SSI state
    When user searches '49331' and sets store to 'Lowell'
    Then verify user has correct store 'Lowell'
    Then verify header widget is not present

    Examples:
      | email                     | password | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | ssiActiveOrder@meijer.com | d3stroys | zod        | krypton   | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | OH    | 45209    |