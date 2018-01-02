#Author: Pritam.Maibam@meijer.com
Feature: Digital Shopping - Order Placed page - View Order and Edit Order Related Scenarios

  Background:
    Then clear all array list

  @freshdata
  Scenario Outline: Test Case 1225 - Desktop - Expiration Time is consistent with Time Slot selected
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then validate and reset shopping cart to 0 item
    Then validate View Order link not display in Curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user click View link in Curbside Widget
    Then order history details page display
    Then validate order number display
    Then validate order status display
    Then validate order date display

    Examples:
      | email                    | password  | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | pritest_auto25@gmail.com | Selenium1 | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestY   | SelAutoY  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |

  @freshdata
  Scenario Outline: Test Case 1250 - Desktop - Sign-In - View Order Link  - With An Active Order - SPO
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then validate and reset shopping cart to 0 item
    Then validate View Order link not display in Curbside wizard
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate user is allowed to select pickup time up to 30 Days in advance
    Then Randomly select any Available Slot for CAKE only Item
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate View Order link not display in Curbside wizard
    Then validate past orders and Quick shop links display
    Then click on Past Order link display on Curbside Wizard
    Then validate Past Order Summary Page display
    Then validate order History summary page for order items

    Examples:
      | email                    | password  | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               |
      | pritest_auto26@gmail.com | Selenium1 | 1            | 0              | 1                  | 1                  | 2           | 7               | 8               | Happy BDay Automation | 0              | All Text should be in Italic |

  @freshdata
  Scenario Outline: Test Case 1251 - Desktop - Sign-In - Edit Order Link - With An Active Order - NON-SPO
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then validate and reset shopping cart to 0 item
    Then validate EditOrder link Not Display in Curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user click Edit Order link in Curbside Widget
    Then order history details page display
    Then validate order number display
    Then validate order status display
    Then validate order date display

    Examples:
      | email                    | password  | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1          | city      | state       | zip_code |
      | pritest_auto27@gmail.com | Selenium1 | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAA  | SelAutoAA | 5127112000500983  | 1           | 2018        | 909             | 7550 Airways Blvd | Southaven | Mississippi | 38671    |

  @freshdata
  Scenario Outline: Test Case 1252 - Dekstop - Sign-In - Edit Order Link - With An Active Order - SPO
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then validate and reset shopping cart to 0 item
    Then validate EditOrder link Not Display in Curbside wizard
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate user is allowed to select pickup time up to 30 Days in advance
    Then Randomly select any Available Slot for CAKE only Item
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate EditOrder link Not Display in Curbside wizard
    Then validate past orders and Quick shop links display
    Then click on Past Order link display on Curbside Wizard
    Then validate Past Order Summary Page display
    Then validate order History summary page for order items
    Then validate Edit link not display on Order History page for SPO only item

    Examples:
      | email                    | password  | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               |
      | pritest_auto26@gmail.com | Selenium1 | 3            | 1              | 1                  | 1                  | 2           | 7               | 8               | Happy BDay Automation | 0              | All Text should be in Italic |

  @freshdata
  Scenario Outline: Test Case 1362 - Desktop - Sign-In - View Order Link  - With An Active Order - SPO & NON-SPO
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then validate and reset shopping cart to 0 item
    Then validate View Order link not display in Curbside wizard
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user click View link in Curbside Widget
    Then order history details page display
    Then validate order number display
    Then validate order status display
    Then validate order date display

    Examples:
      | email                    | password  | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | pritest_auto30@gmail.com | Selenium1 | 2            | 1              | 1                  | 1                  | 0           | 5               | 2               | Happy BDay Automation | 9              | All Text should be in Italic | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAD  | SelAutoAD | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |

  @freshdata
  Scenario Outline: Test Case 1363 - Dekstop - Sign-In - Edit Order Link - With An Active Order - SPO & NON-SPO
    Given user navigate to MeijerDotCom
    When user select Sign In from Setting Geo Location popup
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then validate and reset shopping cart to 0 item
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate EditOrder link Not Display in Curbside wizard
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user click Edit Order link in Curbside Widget
    Then order history details page display
    Then validate order number display
    Then validate order status display
    Then validate order date display

    Examples:
      | email                    | password  | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | store_name    | str_zipCode |
      | pritest_auto31@gmail.com | Selenium1 | 3            | 0              | 1                  | 0                  | 0           | 2               | 3               | Happy BDay Automation | 9              | All Text should be in Italic | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAE  | SelAutoAE | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Knapps Corner | 49525       |
