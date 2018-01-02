Feature: MagnumPI5.2_Adbreak.feature

  Background:
    Then clear all array list

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45703 - verify the static message is displayed in shopping cart on Shopping cart for the order CNC only
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email           | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | honey@gmail.com | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC 45703   | 20586       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45705 - verify the static message is displayed in shopping cart on shopping cart for the order SPO only
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email          | spo_item                  | no_item | item_qty | first_name | last_name | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC 45705   | 20589       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45706 - Verify the shoppingcart doesnot contain the static message for STH order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify no static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then verify there is no static message in shopping cart
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then verify no static message in shipping page
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then verify there is no static message in billing page
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then verify no static message in review page
    Then click on Place Order
    Then confirm page display
    Then verify no static message in confirm page
    Then note down order number after order placed

    Examples:
      | email         | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             | TC 45706   | 20592       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45707 - verify the static message is displayed in shopping cart on shoppingcart when the order has  CNC/ SPO and STH
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then click Next button on order flow
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed

    Examples:
      | email          | cnc_item     | spo_item                  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | zip_Code | TestCaseID | TestPointID | TestPlanID | ph_number  | phoneNum   | firstName | lastName |
      | fish@gmail.com | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 5444009999222205 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC 45707   | 20595       | 45305      | 6162279010 | 5559000904 | siva      | Ran      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45708 - verify the static message is displayed  on shoppingcart for CNC order(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed
    Examples:
      | email              | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | mjr_auto@email.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC 45708   | 20598       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45709 - verify the static message is displayed in shopping cart for the order SPO only(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email          | password  | spo_item                  | no_item | item_qty | first_name | last_name | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC 45709   | 20601       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45710 - Verify the shoppingcart doesnot contain the static message for STH order(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify no static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then verify there is no static message in shopping cart
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then verify no static message in shipping page
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then verify there is no static message in billing page
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then verify no static message in review page
    Then click on Place Order
    Then confirm page display
    Then verify no static message in confirm page
    Then note down order number after order placed

    Examples:
      | email         | password  | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | password1 | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             | TC 45710   | 20604       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45711 - verify the static message is displayed in shopping cart  when the order has  CNC/ SPO and STH(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then click Next button on order flow
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed

    Examples:
      | email              | password  | cnc_item     | spo_item                  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | zip_Code | TestCaseID | TestPointID | TestPlanID | ph_number  | firstName | lastName | phoneNum   |
      | mjr_auto@email.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC 45711   | 20607       | 45305      | 6162279010 | siva      | Ran      | 5559000904 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45323 - Verify the tooltip is displayed for the only CNC order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email           | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | honey@gmail.com | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC 45323   | 20212       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45325 - Verify the tooltip is displayed for only SPO orders
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email          | spo_item                  | no_item | item_qty | first_name | last_name | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC 45325   | 20215       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45327 - Verify there is no tooltip displayed for only STH order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify no static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then verify there is no static message in shopping cart
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then verify no static message in shipping page
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then verify there is no static message in billing page
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then verify no static message in review page
    Then click on Place Order
    Then confirm page display
    Then verify no static message in confirm page
    Then note down order number after order placed

    Examples:
      | email         | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             | TC 45327   | 20221       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45326 - Verify the tooltip is displayed for CNC/SPO and STH
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then click Next button on order flow
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed

    Examples:
      | email          | cnc_item     | spo_item                  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | zip_Code | TestCaseID | TestPointID | TestPlanID | ph_number  | phoneNum   | firstName | lastName |
      | fish@gmail.com | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC 45326   | 20218       | 45305      | 6162279010 | 5559000904 | siva      | Ran      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45370 - Verify the tooltip is displayed for the only CNC order(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed
    Examples:
      | email              | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  | leadTime |
      | mjr_auto@email.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC 45370   | 20317       | 45305      | 6162279010 | 8        |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45375 - Verify the tooltip is displayed for only SPO orders(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed

    Examples:
      | email          | password  | spo_item                  | no_item | item_qty | first_name | last_name | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC 45375   | 20321       | 45305      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45377 - Verify there is no tooltip displayed for only STH order (login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify no static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then verify there is no static message in shopping cart
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then verify no static message in shipping page
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<ccNum>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_Code>'
    Then verify there is no static message in billing page
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then verify no static message in review page
    Then click on Place Order
    Then confirm page display
    Then verify no static message in confirm page
    Then note down order number after order placed

    Examples:
      | email         | password  | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum            | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | password1 | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222             | TC 45377   | 20327       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 45376 - Verify the tooltip is displayed for CNC/SPO and STH (login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for 'sth' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then click on questionmark and verify tooltip
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<firstName>' '<lastName>' '<address1>' '<city>' '<state>' '<zip_Code>' '<phoneNum>' '<email>'
    Then user enter delivery method shipping information details 'Standard Shipping' 'auto gift msg'
    Then click Next button on order flow
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify the static message is displayed in billing page
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then verify static message is displayed in review page
    Then click on Place Order
    Then confirm page display
    Then verify static message is displayed in confirm page
    Then note down order number after order placed

    Examples:
      | email              | password  | cnc_item     | spo_item                  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | zip_Code | TestCaseID | TestPointID | TestPlanID | ph_number  | firstName | lastName | phoneNum   |
      | mjr_auto@email.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 5444009999222205 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC 45376   | 20324       | 45305      | 6162279010 | siva      | Ran      | 5559000904 |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 50576 - Verify THU adbreak for all slots (login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then verify thu adbreak for all time slot

    Examples:
      | zipCode | storeName | email         | password  | cnc_item | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | 49512   | Cascade   | cat@gmail.com | password1 | apple    | 1       | 1        | TC 50576   | 29863       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 50577 - Verify THU adbreak for all slots (Guest)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then verify thu adbreak for all time slot

    Examples:
      | cnc_item | no_item | item_qty | TestCaseID | TestPointID | TestPlanID | zipCode | storeName |
      | apple    | 1       | 1        | TC 50577   | 29866       | 45305      | 49512   | cascade   |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 50578 - Verify SUN adbreak for all slots(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then verify sun adbreak for all time slot

    Examples:
      | zipCode | storeName | email         | password  | cnc_item | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | 49525   | Knapps    | cat@gmail.com | password1 | apple    | 1       | 1        | TC 50578   | 29869       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 50579 - Verify SUN adbreak for all slots(Guest)
    Given user navigate to MeijerDotCom
   # And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then verify sun adbreak for all time slot

    Examples:
      | cnc_item | no_item | item_qty |
      | apple    | 1       | 1        |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 49364 - Verify THU adbreak for all SPO slots (login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then verify thu adbreak for all time slot spo

    Examples:
      | zipCode | storeName | email         | password  | spo_item                  | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | 49512   | Cascade   | cat@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | TC 49364   | 28561       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 49357 - Verify THU adbreak for all slots spo (Guest)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then verify thu adbreak for all time slot spo

    Examples:
      | spo_item                  | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | Meijer Classic Party Tray | 1       | 1        | TC 49357   | 28549       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 49365 - Verify SUN adbreak for all slots spo(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    # Then wait until the slot appears
    Then sun spo adbreak for all time slot

    Examples:
      | zipCode | storeName | email         | password  | spo_item                  | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | 49525   | Knapps    | cat@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | TC 49365   | 28564       | 45305      |

  @PI5
  @OUT_DATED
  Scenario Outline: : TC 49358 - Verify SUN adbreak for all slots spo (Guest)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then verify static message is displayed in pickup page
    Then user clicks Select Pick Up Time button via checkout
    Then sun spo adbreak for all time slot

    Examples:
      | spo_item                  | no_item | item_qty | TestCaseID | TestPointID | TestPlanID |
      | Meijer Classic Party Tray | 1       | 1        | TC 49358   | 28552       | 45305      |
