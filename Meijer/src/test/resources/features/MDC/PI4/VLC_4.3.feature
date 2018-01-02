# Author: jordan.palma@meijer.com
Feature: VLC_4.3.feature

  Background:
    Then clear all array list

  @zombie
  Scenario Outline: TC 34253 - Mini-Cart Product Availability Conflict - Curbside - Signed In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # DEV Configurations
    Then user searches for 'clementine mandarins 3 lbs' in 'DEV' environment
    # UAT Configurations
    Then user searches for 'Cortland Apple' in 'UAT' environment
    Then select item '1' with desire qty '3' and Add to Cart
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '3' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user opens mini-cart
    Then validate state of Unavailable items in Mini-Cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                  | password  | zipCode | storeName | zipCode2 | storeName2    |
      | 34253 | 30912    | 3070    | meijer_auto8@email.com | password1 | 49512   | Cascade   | 49525    | Knapps Corner |

  @zombie
  Scenario Outline: TC 34253 - Mini-Cart Product Availability Conflict - Curbside - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # DEV Configurations
    Then user searches for 'clementine mandarins 3 lbs' in 'DEV' environment
    # UAT Configurations
    Then user searches for 'Cortland Apple' in 'UAT' environment
    Then select item '1' with desire qty '3' and Add to Cart
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '3' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user opens mini-cart
    Then validate state of Unavailable items in Mini-Cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2    |
      | 34253 | 30912    | 3070    | 49512   | Cascade   | 49525    | Knapps Corner |

  @Zombie
  Scenario Outline: TC 34262 - Slot Reserved While Attempting to Add Custom Cake Pop Up Messaging - Slot Type 1 - Leave ouf of Cart
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then reserve an available pickup slot at least '36' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '2' '1' '0' '1'
    Then user click on Add to Cart for design cake
    Then validate adding SPO item warning message display
    Then user clicks leave out of cart button
    Then TEST CASE FAILS DUE TO BUG REPORT #'<35868>'
#    TODO: BLOCKER bug #35868


    Examples:
      | email                  | password  | zipCode | storeName     |
      | meijer_auto9@email.com | password1 | 49525   | Knapps Corner |

  @Zombie
  Scenario Outline: TC 35246 - Slot Reserved While Attempting to Add Custom Cake Pop Up Messaging - Slot Type 1 - Continue, Add Item to Cart
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then reserve an available pickup slot at least '36' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '2' '1' '0' '1'
    Then user click on Add to Cart for design cake
    Then validate adding SPO item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                  | password  | zipCode | storeName     |
      | meijer_auto9@email.com | password1 | 49525   | Knapps Corner |

  @Zombie
  Scenario Outline: TC 35247 - Slot Reserved While Attempting to Add Custom Cake Pop Up Messaging - Slot Type 4 - Leave out of Cart
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then reserve an available pickup slot at least '36' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '2' '1' '0' '1'
    Then user click on Add to Cart for design cake
    Then validate adding SPO item warning message display
    Then user clicks leave out of cart button
    Then TEST CASE FAILS DUE TO BUG REPORT #'<35868>'
#    TODO: BLOCKER bug #35868

    Examples:
      | email                   | password  | zipCode | storeName     |
      | meijer_auto10@email.com | password1 | 49525   | Knapps Corner |

  @Zombie
  Scenario Outline: TC 35248 - Slot Reserved While Attempting to Add Custom Cake Pop Up Messaging - Slot Type 4 - Continue, Add Item to Cart
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then reserve an available pickup slot at least '1' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '2' '1' '0' '1'
    Then user click on Add to Cart for design cake
    Then validate adding SPO item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                   | password  | zipCode | storeName     |
      | meijer_auto11@email.com | password1 | 49525   | Knapps Corner |

  @Zombie
  Scenario Outline: TC 35249 - Slot Reserved While Attempting to Add Custom Cake Pop Up Messaging - Slot Type 2 - Warning Message Will Not Display
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '2' '1' '0' '0'
    Then user click on Add to Cart for design cake
    Then validate item warning message not display

    Examples:
      | email                  | password  | zipCode | storeName     |
      | meijer_auto8@email.com | password1 | 49525   | Knapps Corner |

  @Zombie
  Scenario Outline: TC 34233 - Prioritize CNC Orders - SPO Order and CNC+SPO Order
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
#    Begin SPO Order
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '72' hours in future and click Reserve button
#     3 Days out ^
    Then click Next button on order flow
#    Then billing page display
#    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
#    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then validate active order by order type 'SPO'
#    Begin CNC Order
    Then clear all array list
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '96' hours in future and click Reserve button
#      4 Days out ^
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then validate active order by order type 'CNC'
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                  | password  | zipCode | storeName     | firstName | lastName  | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode |
      | meijer_auto7@email.com | password1 | 49525   | Knapps Corner | Meijer    | AutoSeven | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             |

  @Zombie
  Scenario Outline: TC 34272 - Prioritize CNC Orders - SPO Order and CNC+SPO+STH Order
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
#    Begin SPO Order
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '72' hours in future and click Reserve button
#     3 Days out ^
    Then click Next button on order flow
#    Then billing page display
#    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
#    Then click Next button on order flow
    Then order review page display
#    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then validate active order by order type 'SPO'
#    Begin CNC Order
    Then clear all array list
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then click Next button on order flow
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '84' hours in future and click Reserve button
#      3.5 Days out ^
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then click Next button on order flow
    Then order review page display
#    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then validate active order by order type 'CNC'
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then TEST CASE FAILS DUE TO BUG REPORT #'33254'
    Then validate order status after successfully cancelled order

    Examples:
      | email                  | password  | zipCode | storeName     | firstName | lastName  | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode |
      | meijer_auto1@email.com | password1 | 49525   | Knapps Corner | Meijer    | AutoSeven | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             |
