Feature: Regression Digital Shopping


  @basicFlow
  Scenario Outline: Basic Checkout Flow (Signed-in)
#Navigate
    Given user navigate to MeijerDotCom
    #OR
    Given user navigate to test environment URL
#login user
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
#guest user
    Then Meijer Home page displays for Guest user
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'

  #To Empty Shopping Cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
  #To Drop Existing Time Slot Hold
    #For Logged In Users
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'

#init
#   When user select desire store '<store_name>' '<str_zipCode>'
#   Then validate and reset shopping cart to 0 item
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    When user searches '<str_zipCode>' and sets store to '<store_name2>'
    Then clear all array list
#shop
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
#checkout
    Then click Cart Icon in Header and click View Cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow

    Then click Next button on order flow
    Then billing page display
    Then user select existing Credit Card for providing payment info '<ccv>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
#To Run an Expected Failed Cucumber Step
    Then test case fails due to bug report #'<BugID>'

    Examples:
      | email          | str_zipCode | password | productType           | store_name | store_name2   | qty | ccv |
      | zod@meijer.com | 49512       | d3stroys | is_prepared_item:true | Cascade    | Knapps Corner | 1   | 444 |





  @cartIDtest
  Scenario Outline: SSI Basic Maintain Cart (Signed-in)
    Given user navigate to MeijerDotCom
  #THESE REPORTING NUMBERS ARE PLACEHOLDERS.. FILL THEM IN
    And the user sets testcase configurations 'TC_39897' '5720' '39711'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully

    Then store cartID
    Then user closes and opens browser to enter SSI state

    Then verify SSI token exists

    Then verify cartID matches previous cartID
#    Then verify sensitive data is masked in cartXml
#    Then add products to cart and store products in list
#    Then verify products in minicart match products list
#    Then verify products in shopping cart match products list
#    Then save information for minicart header and reservation header
#    Then verify minicart header and reservation header match previous state


    Examples:
      | email          | str_zipCode | password | productType           | store_name | store_name2   | qty | ccv |
      | zod@meijer.com | 49512       | d3stroys | is_prepared_item:true | Cascade    | Knapps Corner | 1   | 444 |


