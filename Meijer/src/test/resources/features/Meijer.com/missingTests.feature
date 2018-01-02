Feature: Regression Digital Shopping




  @missingTests11
  Scenario Outline: update Pickup Time during Checkout (Signed-in)
#login
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
#drop timeslot
    When user searches '49512' and sets store to 'Cascade'
#checkout
    Then click Cart Icon in Header and click View Cart
    Then click Checkout on Shopping Cart page
#pickup page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then user clicks Select Pick Up Time button via checkout
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click Next button on order flow
#billing page
    Then billing page display
    Then user select existing Credit Card for providing payment info '<ccv>'
    Then click edit pickup time link on Billing Page
    Then select next day first day available Pickup slot
    Then click edit pickup time link on Billing Page
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click Next button on order flow
#order review page
    Then order review page display
    Then click edit pickup time link on Order Review Page
    Then select next day first day available Pickup slot
    Then click edit pickup time link on Order Review Page
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click on Place Order
#complete checkout
    Then confirm page display
    Then user click Return Home button on confirm page

    Examples:
      | email          | password | productType | qty | ccv |
      | zod@meijer.com | d3stroys | CNC         | 1   | 121 |


  @missingTests
  Scenario Outline: verify comment section max length(Signed-in)
#login
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
#checkout
    Then click Cart Icon in Header and click View Cart
    Then user enter max 1024 character in comment section
    Then user enters max 1024 character in comment section without first clearing the field
    Then validate 1024 or fewer characters in comments section

#    Then validate curbside display for Get Direction and Edit Pickup Time Links


    Examples:
      | productType | qty |
      | not alcohol | 5   |



    #THIS TEST IS NOT COMPLETE
  @missingTests
  Scenario Outline: Validate Search Pagination (Signed-in)
#login
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for '<productType>' product
#need step to validate landed on next page

    Examples:
      | email          | password | productType |
      | zod@meijer.com | d3stroys | not alcohol |


   #THIS TEST IS NOT COMPLETE
  @missingTests
  Scenario Outline: TC062 - Cart View - RHR (Anonymous)
#login
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
#   Then Meijer Home page displays User is signed in successfully
#init
#   When user select desire store '<store_name>' '<str_zipCode>'
#   Then validate and reset shopping cart to 0 item
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '49512' and sets store to 'Cascade'
    When user searches '49512' and sets store to 'Knapps Corner'
    Then clear all array list
#shop
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
#checkout
    Then click Cart Icon in Header and click View Cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
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


    Then validate No Grocery Substitution options field display
    Then validate No text field for comments display
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate overall Total Calulation of Single Item
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
    Then validate default display of Comment Text field
    Then validate default display of Grocery Substitution option on Shopping Cart Page
    Then validate No text field for comments display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then validate the buttons display on Shopping Cart page for Anonymous user

    Examples:
      | email          | password | productType | qty | ccv |
      | zod@meijer.com | d3stroys | CNC         | 1   | 121 |