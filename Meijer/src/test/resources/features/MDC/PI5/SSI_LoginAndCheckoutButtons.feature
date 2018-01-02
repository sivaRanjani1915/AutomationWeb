Feature: LoginAndCheckoutButtons.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45158 - verify login and checkout is displayed and checkout as guest is not displayed on shopping cart page in SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '45158' '20110' '45068'
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    # SSI
    When user searches for 'is_click_and_collect:true' product
    Then user adds '5' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify 'Log in and Check Out' button is displayed
    Then verify 'Checkout as guest' is NOT displayed
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45161 - verify login and checkout and checkout as guest are displayed after signing out from SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '45161' '20116' '45068'
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    # SSI
    When user searches for 'is_click_and_collect:true' product
    Then user adds '5' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify 'Log in and Check Out' button is displayed
    Then verify 'Checkout as guest' is NOT displayed
    Then user return to Meijer Home Page
    Then click 'Not You' link on the account header
    Then user clicks x to close sign in modal
    Then Meijer Home page displays for Guest user
#    Then user logs out
    When user searches for 'is_click_and_collect:true' product
    Then user adds '5' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify 'Checkout as guest' is displayed
    Then verify 'Log in and Check Out' button is displayed

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45159 - verify checkout button is the only button available when signed in from SSI state
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '45159' '20113' '45068'
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    # SSI
    Then user closes and opens browser to enter SSI state
    Then verify SSI token exists
    When user searches for 'is_click_and_collect:true' product
    Then user adds '5' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    # SSI checkout
    Then verify 'Log in and Check Out' button is displayed
    Then user return to Meijer Home Page
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
    # FSI
    When user searches for 'is_click_and_collect:true' product
    Then user adds '5' of one product to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify 'Log in and Check Out' button is NOT displayed
    Then verify 'Checkout as guest' is NOT displayed
    Then verify 'Checkout' button is displayed

    Examples:
      |  |
      |  |
