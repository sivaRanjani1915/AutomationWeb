#Author: Pritam.Maibam@meijer.com
Feature: Meijer.com\Regression_Generic.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: RTC001, 2155 - Sign In - Place CNC Order - Edit Active Order
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
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
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
#    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
#    Then validate order status after successfully cancelled order

    Examples:
      | zipCode | storeName | email                    | password  | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49512   | Cascade   | pritest_auto37@gmail.com | Selenium1 | PritestAK  | SelAutoAK | 4055060000000000 | 12          | 2018        | 222             | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    |

  @Zombie
  Scenario Outline: RTC002, 2158 - Sign In - Place CNC+SPO Order
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
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
#    Then validate DATE and TIME display under curbside widget via Home page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
#    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
#    Then validate order status after successfully cancelled order

    Examples:
      | zipCode | storeName     | email                  | password  | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49525   | Knapps Corner | meijer_auto4@email.com | password1 | PritestAL  | SelAutoAL | 4055060000000000 | 12          | 2018        | 222             | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    |

  @Zombie
  Scenario Outline: RTC003, 2161 - Guest User - CNC-Only Order - Edit Active Order Time Slot
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '84' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
#    Then validate order date display
    Then validate ordered items are displayed correct
    Then click edit pickup time link on Order Review Page
    Then reserve an available pickup slot at least '86' hours in future and click Reserve button
    Then also validate newly selected time display correct on curbside wizard
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
#    Then validate order status after successfully cancelled order

    Examples:
      | email                  | first_name | last_name | ph_number  | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | meijer_auto5@email.com | PritestAL  | SelAutoAL | 6165815937 | 4055060000000000 | 12          | 2018        | 222             | 3874 Paxton Ave | Cincinnati | Ohio  | 45209    |

  @Zombie
  Scenario Outline: RTC004, 2164 - Guest User - Place CNC + Custom Cake Order
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
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
    Then reserve an available pickup slot at least '84' hours in future and click Reserve button
#    ^ 3.5 days out
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
#    Then validate order status display
    Then validate order date display
    Then validate correct item name display except Custom Cake in order history detail page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
#    Then validate order status after successfully cancelled order

    Examples:
      | email                    | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | first_name | last_name | ph_number  | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1                | city    | state    | zip_code |
      | pritest_auto40@gmail.com | 1            | 2              | 0                  | 0                  | PritestAN  | SelAutoAN | 5552991140 | 6011206426044688 | 7           | 2018        | 222             | 113 N Washington Square | Lansing | Michigan | 48933    |

  @Zombie
  Scenario Outline: RTC005, 2208 - Guest User - Buttons enabled or disabled validation along with error msg
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then validate and reset shopping cart to 0 item
    Then click on Shopping Cart Icon on HomePage
    Then validate Checkout button is disabled on mini card
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user click on Next button without providing any details
    Then validate the error messages displayed for mandatory fields on Pickup Page
    Then user clicks Select Pick Up Time button via checkout
    Then validate Select Pickup Time button on Pickup Times popup window is disabled
    Then close Pickup Timeslot pop up window
    Then Select Randomly any Available time Slot
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user click on Next button without providing any details
    Then validate error messages displayed for mandatory fields on Billing and Payment Page
    Then user enter only credit card number '4556118359029550'
    Then click Next button on order flow
    Then validate error messages displayed for CC Expiration Date and Security Code fields

    Examples:
      | email                    | first_name | last_name | ph_number  |
      | pritest_auto39@gmail.com | PritestAM  | SelAutoAK | 5552991139 |

  @Zombie
  Scenario Outline: RTC005 - Sign-In - Place SPO item order in all Curbside Enabled Stores
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user searches for '<spo_item>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
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
    Then user click Return Home button on confirm page
    Then validate View Order link not display in Curbside wizard
    Then validate EditOrder link Not Display in Curbside wizard
    Then validate past orders and Quick shop links display
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | zipCode | storeName     | email                  | password  | spo_item              | item_qty | first_name | last_name | ph_number  |
      | 49525   | Knapps Corner | meijer_auto3@email.com | password1 | is_prepared_item:true | 1        | FirstName  | LastName  | 6169873574 |

  @Zombie
  Scenario Outline: TC026 - Reorder CNC-Only - Bulk Items
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user navigate to Order History from the account header
    Then user enter '<order_no>' and billing '<orderZipCode>' and search order
    Then order history details page display
    Then user click on Select All checkbox
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then validate ALL items during Reordering process
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then click Checkout on Mini Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '5' hours in future and click Reserve button
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code1>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<orderZipCode>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | order_no | orderZipCode | firstName | lastName | address1        | city       | state | zip_code1 | phoneNum   | email                      | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name         | comment                   | desire_itemCount |
      | 181774   | 45209        | Active    | OrderOne | 3874 Paxton Ave | Cincinnati | Ohio  | 45209     | 6169874561 | testactiveorder1@email.com | 4055060000000000 | 12          | 2018        | 222             | Active OrderOne | reOrder Auto comment Text | 12               |

  @Zombie
  Scenario Outline: TC026 - Reorder CNC-Only - Single Item
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user navigate to Order History from the account header
    Then user enter '<order_no>' and billing '<orderZipCode>' and search order
    Then order history details page display
    Then user selects '1' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then click Checkout on Mini Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<firstName>' '<lastName>' '<phoneNum>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '48' hours in future and click Reserve button
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<firstName>' '<lastName>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code1>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<orderZipCode>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | order_no | orderZipCode | firstName | lastName | address1        | city       | state | zip_code1 | phoneNum   | email                      | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name         | comment                   | desire_itemCount |
      | 181774   | 45209        | Active    | OrderOne | 3874 Paxton Ave | Cincinnati | Ohio  | 45209     | 6169874561 | testactiveorder1@email.com | 4055060000000000 | 12          | 2018        | 222             | Active OrderOne | reOrder Auto comment Text | 12               |


  #@freshdata
  Scenario Outline: RTC001, 2155 - Sign In - Place CNC item order in all curbside enabled Stores
    Given user navigate to MeijerDotCom
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<str_zipCode>' and sets store to 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
#    Then validate DATE and TIME display under curbside widget via Home page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    #Then validate order status after successfully cancelled order

    Examples:
      | str_zipCode | email                    | password  | cnc_item | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49525       | pritest_auto37@gmail.com | Selenium1 | Apple    | 1       | 1        | 1          | PritestAK  | SelAutoAK | 4055060000000000 | 12          | 2018           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |
  #|       49512 | pritest_auto37@gmail.com | Selenium1 | Orange   |       1 |        1 |          1 | PritestAK  | SelAutoAK | 4929733142798681 |           2 |           2018 |             222 | 3874 PAXTON AVE | Cincinnati | Ohio |    45209 |

  #@freshdata
  Scenario Outline: RTC002, 2158 - SIgn In - Place an CNC and SPO items order in all curbside enabled Stores
    Given user navigate to MeijerDotCom
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<str_zipCode>' and sets store to 'Knapps Corner'
#    Then validate and reset shopping cart to 0 item
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<cnc_item>' product
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
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    #Then validate order status after successfully cancelled order

    Examples:
      | str_zipCode | email                    | password  | cnc_item     | spo_item                  | no_item | item_qty | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49525       | pritest_auto38@gmail.com | Selenium1 | Water Bottle | Meijer Classic Party Tray | 1       | 1        | 2          | PritestAL  | SelAutoAL | 4055060000000000 | 12          | 2018           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |
#      | 49512       | pritest_auto38@gmail.com | Selenium1 | Apple Juice  | Meijer Classic Party Tray | 1       | 1        | 2          | PritestAL  | SelAutoAL | 5262866994369870 | 2           | 2018           | 555             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |

  #@freshdata
  Scenario Outline: RTC003, 2161 - Guest User - Place CNC item order in all curbside enabled Stores
    Given user navigate to MeijerDotCom
    Then user clicks Keep this Store on passive store selection modal
#    Then validate and reset shopping cart to 0 item
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
    Then Select Randomly any Available time Slot
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    #Then validate order status after successfully cancelled order

    Examples:
      | str_zipCode | email                    | cnc_item    | no_item | item_qty | item_count | first_name | last_name | ph_number  | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49525       | pritest_auto39@gmail.com | Paper Towel | 1       | 1        | 1          | PritestAM  | SelAutoAK | 5552991139 | 4055060000000000 | 12          | 2018           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |

  #@freshdata
  Scenario Outline: RTC004, 2164 - Guest User - Place CNC and SPO item order in all curbside enabled Stores
    Given user navigate to MeijerDotCom
    Then user clicks Keep this Store on passive store selection modal
    Then validate and reset shopping cart to 0 item
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
    Then Select Randomly any Available time Slot
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate correct item name display except Custom Cake in order history detail page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    #Then validate order status after successfully cancelled order

    Examples:
      | str_zipCode | email                    | cnc_item | no_item | item_qty | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | item_count | first_name | last_name | ph_number  | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1          | city      | state       | zip_code |
      | 49525       | pritest_auto40@gmail.com | Tomato   | 1       | 1        | 1            | 2              | 0                  | 0                  | 2          | PritestAN  | SelAutoAN | 5552991140 | 5127112000500983  | 1           | 2018           | 909             | 7550 Airways Blvd | Southaven | Mississippi | 38671    |

  #|       49512 | pritest_auto40@gmail.com | Onion    |       1 |        1 |            2 |              2 |                  0 |                  1 |          2 | PritestAN  | SelAutoAN | 5552991140 | 6011206426044688 |           5 |           3 |             222 | 113 N Washington Square | Lansing | Michigan |    48933 |
  #@freshdata
  Scenario Outline: RTC005, 2208 - Guest User - Buttons enabled or disabled validation along with error msg
    Given user navigate to MeijerDotCom
    Then user clicks Keep this Store on passive store selection modal
    Then validate and reset shopping cart to 0 item
    Then click on Shopping Cart Icon on HomePage
    Then validate Checkout button is disabled on mini card
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user click on Next button without providing any details
    Then validate the error messages displayed for mandatory fields on Pickup Page
    Then user clicks Select Pick Up Time button via checkout
#
#   TODO. Verify in UAT testing
    Then validate Select Pickup Time button on Pickup Times popup window is disabled
#
    Then close Pickup Timeslot pop up window
    Then Select Randomly any Available time Slot
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then user click on Next button without providing any details
    Then validate error messages displayed for mandatory fields on Billing and Payment Page
    Then user enter only credit card number '4556118359029550'
    Then click Next button on order flow
    Then validate error messages displayed for CC Expiration Date and Security Code fields

    Examples:
      | str_zipCode | email                    | cnc_item | no_item | item_qty | first_name | last_name | ph_number  |
      | 49512       | pritest_auto39@gmail.com | apple    | 1       | 1        | PritestAM  | SelAutoAK | 5552991139 |
