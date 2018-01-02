#Author: siva.ranjani@meijer.com
Feature: RemoveRadioButton5.3.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49592 - Place the order for CNC and verify the curbside radio button in shopping cart page
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
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
    Then Verify there is no curbside radio button is displayed

    Examples:
      | email           | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_49592   | 28635       | 49593      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49597 - Place the order for SPO and verify the radio button deli/bakery in shopping cart page
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
    Then Verify there is no Deli radio button is displayed

    Examples:
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_49597   | 28637       | 49593      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49598 - Place the order with CNC+SPO and verify the radio button cubside in shopping cart page
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then Verify there is no curbside radio button is displayed

    Examples:
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | zip_Code | TestCaseID | TestPointID | TestPlanID | ph_number  | phoneNum   | firstName | lastName |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 45209    | TC_49598   | 28639       | 49593      | 6162279010 | 5559000904 | siva      | Ran      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 50093 - Place the order for CNC and verify the curbside radio button in shopping cart page(login)
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
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then verify the static message is displayed in shopping cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
 #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Verify there is no curbside radio button is displayed

    Examples:
      | email           | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_50093   | 29473       | 49593      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 50094 - Place the order for SPO and verify the radio button deli/bakery in shopping cart page(login)
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
    Then Verify there is no Deli radio button is displayed

    Examples:
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_50094   | 29475       | 49593      | 6162279010 |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 50095 - Place the order with CNC+SPO and verify the radio button cubside in shopping cart page(login)
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
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
 #Then click Checkout on Shopping Cart page
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Verify there is no curbside radio button is displayed

    Examples:
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_50095   | 29477       | 49593      | 6162279010 |
    