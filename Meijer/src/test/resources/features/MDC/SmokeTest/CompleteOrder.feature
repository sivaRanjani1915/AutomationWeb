Feature: CompleteOrder.feature

  Background:
    Then clear all array list

  #############
  # CNC ORDER #
  #############
  @NR_DS_desktop
  Scenario Outline: TC 62135 - Place CNC Order - Sign In
    And the user sets testcase configurations '1214' '30014' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '7' with desire qty '3' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then increase the Quantity by '1' of '2' products in Shopping Cart page
    Then decrease the Quantity by '1' of 'all' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      |  email                     | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      |  autoRegression1@email.com | password1 | 49525   | Knapps Corner | AutoOne   | Regression | 6168521365 |

  @NR_DS_desktop
  Scenario Outline: TC 62136 - Place CNC Order - Guest
    And the user sets testcase configurations '62136' '61620' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '2' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
#    Then increase the Quantity by '1' of 'all' products in Shopping Cart page
#    Then decrease the Quantity by '1' of '2' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '45209'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      |  zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      |  49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 95892 - Place CNC Order - SSI
    And the user sets testcase configurations '95892' '117351' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user searches for 'cnc' product
    Then select item '7' with desire qty '3' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then increase the Quantity by '1' of '2' products in Shopping Cart page
    Then decrease the Quantity by '1' of 'all' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user navigate to Order History from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                  | password  | zipCode | storeName     | firstName | lastName | phoneNum   |
      | meijer_auto1@email.com | password1 | 49525   | Knapps Corner | Meijer    | AutoOne  | 6168594435 |

  #############
  # SPO ORDER #
  #############
  @NR_DS_desktop
  Scenario Outline: TC 63488 - Place SPO Order - Sign In
    And the user sets testcase configurations '63488' '61642' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '5' with desire qty '2' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then increase the Quantity by '2' of 'all' products in Shopping Cart page
    Then decrease the Quantity by '1' of '3' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                     | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      | autoRegression2@email.com | password1 | 49525   | Knapps Corner | AutoTwo   | Regression | 6167879876 |

  @NR_DS_desktop
  Scenario Outline: TC 63489 - Place SPO Order - Guest
    And the user sets testcase configurations '63489' '61643' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '5' with desire qty '2' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
#    Then increase the Quantity by '1' of 'all' products in Shopping Cart page
#    Then decrease the Quantity by '1' of '2' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168975643 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 95877 - Place SPO Order - SSI
    And the user sets testcase configurations '95877' '117346' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user searches for 'spo' product
    Then select item '5' with desire qty '2' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then increase the Quantity by '2' of 'all' products in Shopping Cart page
    Then decrease the Quantity by '1' of '3' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user navigate to Order History from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then order history summary page display
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                     | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      | autoRegression6@email.com | password1 | 49525   | Knapps Corner | AutoSix   | Regression | 6167879876 |

  #################
  # CNC+SPO ORDER #
  #################
  @NR_DS_desktop
  Scenario Outline: TC 63595 - Place CNC+SPO Order - Sign In
    And the user sets testcase configurations '63595' '61657' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '2' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '3' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
#    Then increase the Quantity by '2' of '5' products in Shopping Cart page
#    Then decrease the Quantity by '1' of '3' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                     | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      | autoRegression3@email.com | password1 | 49525   | Knapps Corner | AutoThree | Regression | 6168521365 |

  @NR_DS_desktop
  Scenario Outline:TC 63596 - Place CNC+SPO Order - Guest
    And the user sets testcase configurations '63596' '61658' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '2' with desire qty '5' and Add to Cart
    Then user searches for 'spo' product
    Then select item '1' with desire qty '3' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '45209'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168975643 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 95879 - Place CNC+SPO Order - SSI
    And the user sets testcase configurations '95879' '117347' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '2' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '3' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then increase the Quantity by '2' of '5' products in Shopping Cart page
    Then decrease the Quantity by '1' of '3' products in Shopping Cart page
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user navigate to Order History from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                 | password  | zipCode | storeName     | firstName     | lastName | phoneNum   |
      | meijer_auto@email.com | password1 | 49525   | Knapps Corner | MjrAutomation | Scripts  | 6168521365 |

  ##############################
  # ReOrder From Order History #
  ##############################
  @NR_DS_desktop
  Scenario Outline: TC 95880 - Reorder From Order History - Sign In
    And the user sets testcase configurations '95880' '117348' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigate to Order History from the account header
    # DEV Configurations
    Then user enter '220163' and billing '45209' and search for Order in 'DEV' environment
    # UAT Configurations
    Then user enter '181774' and billing '45209' and search for Order in 'UAT' environment
    Then order history details page display
    Then user selects '4' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    # FSI
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                  | password  | zipCode | storeName     | firstName | lastName  | phoneNum   |
      | meijer_auto8@email.com | password1 | 49525   | Knapps Corner | Meijer    | AutoEight | 6168964587 |

  @NR_DS_desktop
  Scenario Outline: TC 63663 - Reorder From Order History - Guest
    And the user sets testcase configurations '63663' '61659' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigate to Order History from the account header
    # DEV Configurations
    Then user enter '220163' and billing '45209' and search for Order in 'DEV' environment
    # UAT Configurations
    Then user enter '181774' and billing '45209' and search for Order in 'UAT' environment
    Then order history details page display
    Then user selects '4' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '45209'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6167865483 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 95881 - Reorder From Order History - SSI
    And the user sets testcase configurations '95881' '117349' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigate to Order History from the account header
    # DEV Configurations
    Then user enter '220163' and billing '45209' and search for Order in 'DEV' environment
    # UAT Configurations
    Then user enter '181774' and billing '45209' and search for Order in 'UAT' environment
    Then order history details page display
    Then user selects '4' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    # FSI
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate DATE and TIME of selected Time Slot via Order History Details page
    Then validate order status display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                  | password  | zipCode | storeName     | firstName | lastName | phoneNum   |
      | meijer_auto2@email.com | password1 | 49525   | Knapps Corner | Meijer    | AutoTwo  | 6169875984 |

  #####################
  # CNC+SPO+STH ORDER #
  #####################
  @NR_DS_desktop
  Scenario Outline: TC 67108 - Place CNC+SPO+STH Order - Sign In
    And the user sets testcase configurations '67108' '69305' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '2' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '2' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '2' and Add to Cart
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
      | address         | city       | state | zipCode |
      | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then user enter delivery method shipping information details 'Express Shipping' 'My test shipping method message'
    Then click Next button on order flow
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      | 67108 | 69305    | 3070    | cncsposth@email.com | password1 | 49525   | Knapps Corner | TestUser  | Regression | 6166985498 |

  @NR_DS_desktop
  Scenario Outline: TC 67109 - Place CNC+SPO+STH Order - Guest
    And the user sets testcase configurations '67109' '69306' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
      | address         | city       | state | zipCode |
      | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then user enter delivery method shipping information details 'Express Shipping' 'My test shipping method message'
    Then click Next button on order flow
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | email               | firstName | lastName   | phoneNum   |
      | 67109 | 69306    | 3070    | 49525   | Knapps Corner | cncsposth@email.com | TestUser  | Regression | 6166985498 |

  @NR_DS_desktop
  Scenario Outline: TC 95882 - Place CNC+SPO+STH Order - SSI
    And the user sets testcase configurations '95882' '117350' '3070'
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
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '2' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '2' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '2' and Add to Cart
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Log In and Checkout on Shopping Cart page
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    # FSI
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
      | address         | city       | state | zipCode |
      | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then user enter delivery method shipping information details 'Express Shipping' 'My test shipping method message'
    Then click Next button on order flow
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME of selected Time Slot via Pickup Page
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details: '<firstName>' '<lastName>'
      | ccNum            | expMon | expYr | ccSecurity | address         | city       | state | zipCode |
      | 4111111111111111 | 12     | 2018  | 222        | 3874 Paxton Ave | Cincinnati | Ohio  | 45209   |
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email            | password  | zipCode | storeName     | firstName | lastName   | phoneNum   |
      | cncsth@email.com | password1 | 49525   | Knapps Corner | TestUser  | Regression | 6166985498 |
