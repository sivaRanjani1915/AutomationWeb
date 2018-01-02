Feature: MagnumPI5.3_MinicartAdbreak.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45312 - verify the static message is displayed in shopping cart on Minicart for the order CNC only
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
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
      | honey@gmail.com | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_45312   | 20200       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45315 - verify the static message is displayed in shopping cart on Minicart for the order SPO only
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
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
      | fish@gmail.com | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC_45315   | 20203       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45319 - Verify the minicart doesnot contain the static message for STH order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | email         | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum           | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222            | TC_45319   | 20206       | 45305      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45321 - verify the static message is displayed in shopping cart on Minicart when the order has  CNC/ SPO and STH
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | fish@gmail.com | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC_45321   | 20209       | 45305      | 6162279010 | 5559000904 | siva      | Ran      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45353 - verify the static message is displayed in shopping cart on Minicart for CNC order(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify the static message on mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
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
      | mjr_auto@email.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_45353   | 20290       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45354 - verify the static message is displayed  on Minicart for the order SPO only(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
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
      | fish@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC_45354   | 20293       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45355 - Verify the minicart doesnot contain the static message for STH order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
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
      | email         | password  | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum           | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | password1 | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222            | TC_45355   | 20296       | 45305      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45356 - verify the static message is displayed in shopping cart on Minicart when the order has  CNC/ SPO and STH
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
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
      | mjr_auto@email.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC_45356   | 20299       | 45305      | 6162279010 | siva      | Ran      | 5559000904 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45304 - Verify the tooltip is displayed for the only CNC order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | honey@gmail.com | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_45304   | 20197       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45338 - Verify the tooltip is displayed for only SPO orders
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | fish@gmail.com | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC_45338   | 20281       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45352 - Verify the minicart doesnot contain the static message and tooltip for STH order
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | email         | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum           | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222            | TC_45352   | 20287       | 45305      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45339 - Verify the tooltip is displayed for CNC/SPO and STH
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
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
      | fish@gmail.com | Water Bottle | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC_45339   | 20284       | 45305      | 6162279010 | 5559000904 | siva      | Ran      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45358 - Verify the tooltip is displayed for the only CNC order(login)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user opens mini-cart
    Then verify no static message and tooltip appears when empty cart
    Then user closes miniCart
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
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
      | email              | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | mjr_auto@email.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_45358   | 20302       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45361 - verify the tooltip is displayed  on Minicart for the order SPO only(login)
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
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
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
      | fish@gmail.com | password1 | Meijer Classic Party Tray | 1       | 1        | siva       | SelAutoAL | TC_45361   | 20305       | 45305      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 45363 - Verify the minicart doesnot contain the tooltip for STH order(login)
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
      | email         | password  | firstName | lastName | address1        | city       | state | zip_Code | phoneNum   | ccNum           | idx_ccexpmn | idx_ccexpyr | cc_securityCode | TestCaseID | TestPointID | TestPlanID |
      | cat@gmail.com | password1 | siva      | Autoseq  | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    | 6166549878 | 4055060000000000 | 12          | 2018        | 222            | TC_45363   | 20311       | 45305      |
