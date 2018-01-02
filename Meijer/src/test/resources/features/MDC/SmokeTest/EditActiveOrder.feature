Feature: EditActiveOrder.feature

  Background:
    Then clear all array list

  ######################################
  # Add Items To Existing Active Order #
  ######################################
  @NR_DS_desktop
  Scenario Outline: TC 66055 - Add CNC items to an Existing Active Order
    And the user sets testcase configurations '66055' '64106' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '3' and Add to Cart
    Then user view page '3' of search results
    Then select item '3' with desire qty '2' and Add to Cart
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
    Then validate order status display
    Then set array list with current product names via Order Details Page
    Then user click in edit order button
    Then validate order edit mode display
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then user searches for 'sellable' on add item modal on edit order screen
    Then user select '5' item edit qty to '1' and click plusAdd button
    Then click on Add X Items button
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate page refresh and page is no longer in edit mode
    Then compare newly added items against existing items in Active Order

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 66056 - Verify User Cant add SPO to Existing Active Order
    And the user sets testcase configurations '66056' '64107' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '3' and Add to Cart
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
    Then validate order status display
    Then user click in edit order button
    Then validate order edit mode display
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then user searches for 'spo' on add item modal on edit order screen
    Then verify user is NOT allowed to search for SPO/SHT products

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 66057 - Verify User Cant add STH to Existing Active Order
    And the user sets testcase configurations '66057' '64108' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '2' and Add to Cart
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
    Then validate order status display
    Then set array list with current product names via Order Details Page
    Then user click in edit order button
    Then validate order edit mode display
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then user searches for 'sth' on add item modal on edit order screen
    Then verify user is NOT allowed to search for SPO/SHT products

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 99955  - Add Choking Hazard to Existing Active Order
    And the user sets testcase configurations '99955' '119192' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '3' and Add to Cart
    Then user view page '3' of search results
    Then select item '3' with desire qty '2' and Add to Cart
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
    Then validate order status display
    Then set array list with current product names via Order Details Page
    Then user click in edit order button
    Then validate order edit mode display
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then user searches for 'Map of the united states' on add item modal on edit order screen
    Then user select '1' item edit qty to '1' and click plusAdd button
    Then click on Add X Items button
    Then verify 'Warning: Choking Hazard' while in edit mode
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate page refresh and page is no longer in edit mode

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49512   | Cascade | GuestUser | Regression | 6169851267 | regressionTestEmail@email.com |

  @NR_DS_desktop
  Scenario Outline: TC 99956  - Add Alcohol to Existing Active Order
    And the user sets testcase configurations '99956' '119193' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '3' and Add to Cart
    Then user view page '3' of search results
    Then select item '3' with desire qty '2' and Add to Cart
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
    Then validate order status display
    Then set array list with current product names via Order Details Page
    Then user click in edit order button
    Then validate order edit mode display
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then user searches for 'is_alcohol:true' on add item modal on edit order screen
    Then user select '5' item edit qty to '1' and click plusAdd button
    Then click on Add X Items button
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then user click confirm on Age Restricted confirmation modal
    Then validate page refresh and page is no longer in edit mode
    Then verify 'AGE RESTRICTED' message in order details

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6169851267 | regressionTestEmail@email.com |

  #########################################
  # Remove Items To Existing Active Order #
  #########################################
  @NR_DS_desktop
  Scenario Outline: TC 66058 - Remove CNC items form an Existing Active Order
    And the user sets testcase configurations '66058' '64109' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user view page '3' of search results
    Then select item '3' with desire qty '6' and Add to Cart
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
    Then validate order status display
    Then set array list with current product names via Order Details Page
    Then user click in edit order button
    Then validate order edit mode display
    Then at random, remove '4' items from Active Order
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate page refresh and page is no longer in edit mode
    Then compare removed items against existing items in Active Order

    Examples:
      | zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      | 49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |

  ###########################################
  # Edit Time Slot to Existing Active Order #
  ###########################################
  @NR_DS_desktop
  Scenario Outline: TC 66059 - Update Time Slot to an Existing Active Order
    And the user sets testcase configurations '66059' '64110' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
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
    Then validate order status display
    Then user click on Edit Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then validate active order DATE and TIME on Order Details page


    Examples:
      |  zipCode | storeName     | firstName | lastName   | phoneNum   | email                         |
      |  49525   | Knapps Corner | GuestUser | Regression | 6168597894 | regressionTestEmail@email.com |