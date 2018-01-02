Feature: UnavailableItemsModal.feature

  Background:
    Then clear all array list

#################################################################
# Modal Notification of Unavailable Items in Shopping Cart page #
#################################################################
# FSO - Full Signed Out #
#########################
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66606 - Modal Notification of Unavailable Items - FSO - Displays
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 66606 | 67909    | 66121   | 49512   | Cascade   | 49544    | Alpine     |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66608 - Modal Notification of Unavailable Items - FSO - Remove Items
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears
    Then set array list of items to be deleted via Notification Modal
    Then user clicks Remove Items From Cart button via Notification Modal
    Then compare items Removed with existing items in Shopping Cart Page

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 66608 | 67910    | 66121   | 49512   | Cascade   | 49544    | Alpine     |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66609 - Modal Notification of Unavailable Items - FSO - Close, Leave and Return To Shopping Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 1st time
    Then verify modal notification of unavailable items appears
    Then user closes notification of unavailable items modal
    Then shopping cart page display
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 2nd time
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 66609 | 67911    | 66121   | 49512   | Cascade   | 49544    | Alpine     |

########################
# FSI - Full Signed In #
########################  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66644 - Modal Notification of Unavailable Items - FSI - Displays
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66644 | 68154    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression1@email.com | password1 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 66645 - Modal Notification of Unavailable Items - FSI - Remove Items
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears
    Then set array list of items to be deleted via Notification Modal
    Then user clicks Remove Items From Cart button via Notification Modal
    Then compare items Removed with existing items in Shopping Cart Page

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66645 | 68155    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression1@email.com | password1 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66646 - Modal Notification of Unavailable Items - FSI - Close, Leave and Return To Shopping Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 1st time
    Then verify modal notification of unavailable items appears
    Then user closes notification of unavailable items modal
    Then shopping cart page display
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 2nd time
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66646 | 68156    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression1@email.com | password1 |

########################
# SSI - Semi Signed In #
########################  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66654 - Modal Notification of Unavailable Items - SSI - Displays
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66654 | 68168    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression2@email.com | password1 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66655 - Modal Notification of Unavailable Items - SSI - Remove Items
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then verify modal notification of unavailable items appears
    Then set array list of items to be deleted via Notification Modal
    Then user clicks Remove Items From Cart button via Notification Modal
    Then compare items Removed with existing items in Shopping Cart Page

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66655 | 68169    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression2@email.com | password1 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 66656 - Modal Notification of Unavailable Items - SSI - Close, Leave and Return To Shopping Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_alcohol:true' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user return to Meijer Home Page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 1st time
    Then verify modal notification of unavailable items appears
    Then user closes notification of unavailable items modal
    Then shopping cart page display
    Then user return to Meijer Home Page
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    # appears 2nd time
    Then verify modal notification of unavailable items appears

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 | email                     | password  |
      | 66656 | 68170    | 66121   | 49512   | Cascade   | 49544    | Alpine     | autoRegression2@email.com | password1 |