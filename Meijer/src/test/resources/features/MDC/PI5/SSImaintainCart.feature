Feature: SSImaintainCart.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51553 -  user gets their same cartID assigned to them when they enter an SSI state.
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51553' '33184' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
#    Then Meijer Home page displays for Guest user
    Then verify cartID matches previous cartID

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51554 -  users cart contains products matching their authenticated cart when entering an SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51554' '33186' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches for 'apple' product
    Then user adds '3' of one product to cart
    When user searches for 'kiwi' product
    Then user adds '4' of one product to cart
    When user searches for 'berry' product
    Then user adds '1' of one product to cart

    Examples:
      |  |
      |  |

#########################
#  SSI: Shopping Cart from SSI to Authenticated  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51556 -  user gets their same cartID assigned to them after authenticating from SSI state.
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51556' '33190' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then verify cartID matches previous cartID

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51557 -  users cart contains products matching their authenticated cart after authenticating from SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51557' '33192' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches for 'apple' product
    Then user adds '3' of one product to cart
    When user searches for 'kiwi' product
    Then user adds '4' of one product to cart
    When user searches for 'berry' product
    Then user adds '1' of one product to cart
    When user searches for 'milk' product
    Then user adds '3' of one product to cart
    When user searches for 'bread' product
    Then user adds '4' of one product to cart
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then user opens mini-cart
    Then verify products in minicart match products list
    Then user closes miniCart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify products in shopping cart match products list

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51559 -  SSI Do Not Maintain Shopping Cart from SSI to Logged In as a Different User
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51559' '33196' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Then user closes and opens browser to enter SSI state
    Then user click Sign In from the account header
    And user enter correct email 'jorel@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then verify cartID does NOT match previous cartID

    Examples:
      |  |
      |  |

################################################
#  SSI: Shopping Cart from authenticated to logged out  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51560 -  user should have a new cart with fresh cart.xml after logging out from authenticated state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51560' '33198' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then store cartID
    Given user navigate to MeijerDotCom
    Then user logs out from the account header
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
#pop in some products to force getting a cart
    When user searches for 'apple' product
    Then user adds '3' of one product to cart
    Then verify cartID does NOT match previous cartID

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51561 -  minicart, cart, timeslot modal, reservation widget and minicart widget should all have default cleared state after logging out from authenticated state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51561' '33200' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    When user searches for 'banana' product
    Then user adds '2' of one product to cart
    Then user logs out from the account header
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify Minicart Widget Shows Zero Items
    Then verify Minicart Is Empty
    Then verify Reservation Widget Shows Sign In To Reserve Timeslot

    Examples:
      |  |
      |  |

#################################################
#  SSI: Shopping Cart from SSI to logged out  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51562 -  user should have a new cart with fresh cart.xml after clicking 'not you' from SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51562' '33202' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    Then store cartID
    Given user navigate to MeijerDotCom
    Then click 'Not You' link on the account header
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
#pop in some products to force getting a cart
    When user searches for 'apple' product
    Then user adds '3' of one product to cart
    Then verify cartID does NOT match previous cartID

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 51563 -  minicart, minicart widget, timeslot modal, and reservation widget should all have default cleared state after logging out from SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '51563' '33204' '49901'
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then user closes and opens browser to enter SSI state
    When user searches for 'banana' product
    Then user adds '2' of one product to cart
    Then wait Until Winkbar Dissappears
    Then click 'Not You' link on the account header
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify Minicart Widget Shows Zero Items
    Then verify Minicart Is Empty
    Then verify Reservation Widget Shows Sign In To Reserve Timeslot

    Examples:
      |  |
      |  |
