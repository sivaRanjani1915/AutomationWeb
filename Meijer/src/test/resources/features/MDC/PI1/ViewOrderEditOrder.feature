#Author: Pritam.Maibam@meijer.com
Feature: ViewOrderEditOrder.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: Test Case 1225 - Desktop - Expiration Time is consistent with Time Slot selected
    Given user navigate to MeijerDotCom
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
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                    | password  | zipCode | storeName | string | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1         | city      | state    | zip_code | zipCode | storeName |
      | pritest_auto25@gmail.com | Selenium1 | 49512   | Cascade   | apple  | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestY   | SelAutoY  | 6011000993464365 | 12          | 2018        | 812             | 707 Osterman Ave | Deerfield | Illinois | 60015    | 49512   | Cascade   |

  @Zombie
  Scenario Outline: Test Case 1250 - Desktop - Sign-In - View Order Link  - With An Active Order - SPO
    Given user navigate to MeijerDotCom
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
    Then Randomly select any Available Slot for Mixed Cart
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
    Then validate DATE and TIME display under curbside widget via Home page
#    Then validate View Order link not display in Curbside wizard
#    Then validate EditOrder link Not Display in Curbside wizard
#       ^^^ Currently not functioning as designed ^^^
#    Then validate past orders and Quick shop links display
#       ^^^ Currently not functioning as designed ^^^
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email               | password  | zipCode | storeName | string | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               | zipCode | storeName |
      | matt_auto@gmail.com | password1 | 49512   | Cascade   | apple  | 1            | 0              | 1                  | 1                  | 2           | 7               | 8               | Happy BDay Automation | 0              | All Text should be in Italic | 49512   | Cascade   |

  @Zombie
  Scenario Outline: Test Case 1251 - Desktop - Sign-In - Edit Order Link - With An Active Order - NON-SPO
    Given user navigate to MeijerDotCom
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
    Then validate EditOrder link Not Display in Curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
#    Then click Checkout on Shopping Cart page
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email               | password  | zipCode | storeName | string | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city      | state | zip_code |
      | matt_auto@gmail.com | password1 | 49512   | Cascade   | apple  | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAA  | SelAutoAA | 4055060000000000 | 12          | 2018        | 222             | 3874 Paxton Ave | Cincinati | Ohio  | 45209    |

  @Zombie
  Scenario Outline: Test Case 1252 - Dekstop - Sign-In - Edit Order Link - With An Active Order - SPO
    Given user navigate to MeijerDotCom
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
    Then validate EditOrder link Not Display in Curbside wizard
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate user is allowed to select pickup time up to 30 Days in advance
    Then Randomly select any Available Slot for Mixed Cart
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
#    Then validate View Order link not display in Curbside wizard
#    Then validate EditOrder link Not Display in Curbside wizard
#       ^^^ Currently not functioning as designed ^^^
#    Then validate past orders and Quick shop links display
#       ^^^ Currently not functioning as designed ^^^
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email               | password  | zipCode | storeName | string | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               |
      | matt_auto@gmail.com | password1 | 49512   | Cascade   | apple  | 3            | 1              | 1                  | 1                  | 2           | 7               | 8               | Happy BDay Automation | 0              | All Text should be in Italic |

  @Zombie
  Scenario Outline: Test Case 1362 - Desktop - Sign-In - View Order Link  - With An Active Order - SPO & NON-SPO
    Given user navigate to MeijerDotCom
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
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Randomly select any Available Slot for Mixed Cart
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email               | password  | zipCode | storeName | string | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1         | city       | state | zip_code |
      | matt_auto@gmail.com | password1 | 49512   | Cascade   | apple  | 3            | 1              | 1                  | 1                  | 2           | 7               | 8               | Happy BDay Automation | 0              | All Text should be in Italic | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAD  | SelAutoAD | 4055060000000000 | 12          | 2018        | 222             | 3874 Paxton  Ave | Cincinnati | Ohio  | 45209    |

  @Zombie
  Scenario Outline: Test Case 1363 - Dekstop - Sign-In - Edit Order Link - With An Active Order - SPO & NON-SPO
    Given user navigate to MeijerDotCom
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
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Randomly select any Available Slot for Mixed Cart
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate Meijer homepage display Edit and View Order text links under curbside widget
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
#    ^^ Time Zone validation commented out. Bug #31626
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order
    Examples:
      | email                    | password  | zipCode | storeName | string | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg           | idx_custmsgclr | txtspcInstrmsg               | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | pritest_auto31@gmail.com | Selenium1 | 49512   | Cascade   | apple  | 3            | 0              | 1                  | 0                  | 0           | 2               | 3               | Happy BDay Automation | 9              | All Text should be in Italic | Grocery | Produce | Fruit | Apples | 1       | 1        | PritestAE  | SelAutoAE | 5444009999222205 | 12          | 2018        | 222             | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    |
