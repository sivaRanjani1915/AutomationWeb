#Author: siva
Feature: Eliminate_CyberSource.feature

  Background:
    Then clear all array list

  @PI5
  @OUT_DATED
  Scenario Outline: TC 43182 - Place the CNC order for valid visa card, mastercad, Meijermastercard, Amex, Discover
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
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
      | email           | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 5444009999222205 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 5552991139 |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 341111597242000  | 12          | 2018        | 1154            | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 5552991139 |
      | honey@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 5552991139 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 43183 - Place the CNC order for invalid visa card,mastercad,Meijermastercard,Amex,Discover(Good Zipcode and Bad address)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
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
      | email         | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1       | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | cat@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44308 - Place the CNC order for invalid visa card,mastercad,Meijermastercard,Amex,Discover(Bad Zipcode and Bad address)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
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
      | email         | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1    | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | cat@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |
      | cat@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 5444009999222205 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |
      | cat@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 341111597242000  | 12          | 2018        | 1154            | 55 Kibby Ln | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |
      | cat@gmail.com | password1 | Apple    | 1       | 1        | siva       | SelAutoQ  | 4055060000000000 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45209    | TC_43182   | 14607       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 43250 - Place the CNC and SPO(party tray) order for valid visa card,mastercad,Meijermastercard,Amex,Discover
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
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 5444009999222205 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 341111597242000  | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 43275 - Desktop - Place the CNC and SPO order(party tray) for invalid visa card,mastercad,Meijermastercard,Amex,Discover(Good Zipcode and Bad address)
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
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1       | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 5444009999222205 | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 341111597242000  | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43250   | 14799       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44309 - Place the CNC and SPO(party tray) order for invalid visa card,mastercad,Meijermastercard,Amex,Discover (Bad Zipcode and Bad address)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
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
      | email          | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1    | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45233    | TC_43275   | 14884       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 5444009999222205 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45233    | TC_43275   | 14884       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 341111597242000  | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45233    | TC_43275   | 14884       | 39711      | 6162279010 |
      | fish@gmail.com | password1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | siva       | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45233    | TC_43275   | 14884       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44321 - Place the CNC and SPO(cake) order for valid visa card,mastercad,Meijermastercard,Amex,Discover
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
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
      | email          | cnc_item | no_item | item_qty | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | item_count | first_name | last_name | ph_number  | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_44321   | 19832       | 39711      | 6162279010 |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 5444009999222205 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_44321   | 19832       | 39711      | 6162279010 |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 341111597242000  | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_44321   | 19832       | 39711      | 6162279010 |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | TC_44321   | 19832       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44322 - Place the CNC and SPO(cake) order for invalid visa card,mastercad,Meijermastercard,Amex,Discover (Good Zipcode and Bad address)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
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
      | email          | cnc_item | no_item | item_qty | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | item_count | first_name | last_name | ph_number  | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1       | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 4055060000000000  | 12          | 2018        | 222             | 4407 Brazee St | Cincinnati | Ohio  | 45209    | TC_43183   | 14608       | 39711      | 6162279010 |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44323 - Place the CNC and SPO(cake) order for invalid visa card,mastercad,Meijermastercard,Amex,Discover (Bad Zipcode and Bad address)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
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
      | email          | cnc_item | no_item | item_qty | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | item_count | first_name | last_name | ph_number  | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1    | city       | state | zip_code | TestCaseID | TestPointID | TestPlanID | ph_number  |
      | fish@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | siva       | SelAutoAN | 5552991140 | 4055060000000000  | 12          | 2018        | 222             | 55 Kibby Ln | Cincinnati | Ohio  | 45233    | TC_43183   | 14608       | 39711      | 6162279010 |
