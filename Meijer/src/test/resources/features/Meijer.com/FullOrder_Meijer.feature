#Author: Pritam.Maibam@meijer.com
Feature: FullOrder.feature

#
# TODO Automation BUCKET LIST:
#     -[#264683] Tier Browsing - Sort Search Results
#     -[#264685] Tier Browsing - Filter
#         Both of these test cases needs steps added to verify the
#         functionality of the product tiles
#  TODO: -Automate Error Messaging - The TRUE NOT Happy Path
#  TODO: -Automate multiple orders validation
#           New logic will now display the closest to PICKUP in the header
#           widget VS. the most recently placed order
#  TODO: -Automate Button Functionality for search Results - CNC, SPO
#           *** In progress - By: 107793 ***


  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: TC001 Full Order- 1 Alcohol Item 13 Qty 10 SPO 10 STH (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<item_tosearch1>' product
    Then user select '<no_item>' Miejer Gift Card with qty '<item_qty>' and add to cart
    Then user searches for '<item_tosearch2>' product
    Then choose '<no_item>' Age Restricted Product Update Qty to '<item_qty3>' and Click Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then select Shopping Cart Substitution For Grocery '<shop_cartsub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
#   SPO Items not showing in cart
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<dvry_methd>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then verify Pickup Info Display on Pickup page '<store_name>' '<address1>' '<ship_adr2>' '<dvry_methd>' '<item_count>'
    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    And enter pickup location info '<car_desc>'
    Then user clicks Select Pick Up Time button via checkout
    And select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then select use billing address checkbox
    Then validate auto filled value in payment info section '<first_name>' '<last_name>' '<address1>' '<city>' '<state_code>' '<zip_code>'
    Then user enter Credit Card payment info details '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then revalidate selected item details
    Then validate calculated total value display correct
    Then click on Place Order
    Then age restriction popup appear while placing order
    Then user confirm on age restriction popup
    Then confirm page display
    Then user click Return Home button on confirm page

    Examples:
      | store_name    | str_zipCode | tier1   | tier2  | tier3       | tier4                 | no_item | item_qty | item_qty3 | car_desc     | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name        | item_tosearch1 | item_tosearch2 | item_count | comment            | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                 | dvry_methd        | gift_msg      | shop_cartsub | ship_adr2             | state_code |
      | Knapps Corner | 49525       | Grocery | Bakery | Party Trays | Pre-Order Party Trays | 1       | 10       | 13        | Honda RJK898 | Curbside        | 4055060000000000 | 12          | 2018        | 222             | Vick AutoSmart | gift card      | beer           | 33         | Auto1 Comment Text | Vick       | AutoSmart | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552221104 | sel_priauto@gmail.com | Standard Shipping | auto gift msg | Any Brand    | Cincinnati, OH, 45209 | OH         |


#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC002 CNC - 5 Items 1 Qty 10 SPO 10 STH (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'banana' product
    When user adds '<no_item_toselect>' different products to cart
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<gift_card>' product
    Then user select '<no_item>' Miejer Gift Card with qty '<item_qty>' and add to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then select Shopping Cart Substitution For Grocery '<shop_cartsub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<dvry_methd>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then verify Pickup Info Display on Pickup page '<store_name>' '<address1>' '<ship_adr2>' '<dvry_methd>' '<item_count>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    And enter pickup location info '<car_desc>'
    Then user clicks Select Pick Up Time button via checkout
    And select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then validate auto filled value in payment info section '<first_name>' '<last_name>' '<address1>' '<city>' '<state_code>' '<zip_code>'
    Then user enter Credit Card payment info details '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
#    Then user validate price displayed in order review page
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page

    Examples:
      | store_name    | str_zipCode | tier11  | tier22  | tier1   | tier2  | tier3       | tier4                 | no_item_toselect | no_item | item_qty | car_desc    | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | gift_card | item_count | comment           | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                    | dvry_methd        | gift_msg      | shop_cartsub | ship_adr2             | state_code |
      | Knapps Corner | 49525       | Grocery | Produce | Grocery | Bakery | Party Trays | Pre-Order Party Trays | 2                | 1       | 10       | Car MPK 123 | CURBSIDE        | 4055060000000000 | 12          | 2018        | 222             | MeijTestC AutoSelC | gift card | 22         | Auto Comment Text | MeijTestC  | AutoSelC  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552901103 | pritam.maibam@meijer.com | Standard Shipping | auto gift msg | Any Brand    | Cincinnati, OH, 45209 | OH         |


#  @skipped
  @Zombie
  Scenario Outline: TC004 - One line item with quantity thirteen then remove to cancel order (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for '<cnc_item>' product
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to National Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then user click in edit order button
    Then validate order edit mode display
    Then click on Remove link of a product
    Then user click undo button
    Then click on Remove link of a product
    Then click on Update Order Button to update the order
    Then update order popup confirmation message display
    Then user click update order button on popup confirmation
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate Edit order page after all order removed

    #Then validate order status after successfully cancelled order
    Examples:
      | store_name    | str_zipCode | cnc_item | no_item_toselect | item_qty | item_count | car_desc       | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1        | ccaddress2            | pickup_location | zip_code | shopcart_sub   | comment           | order_status | first_name | last_name | ph_number  | email                         | city       | state |
      | Knapps Corner | 49525       | Mango    | 1                | 20       | 20         | Hummer ABC 100 | 4055060000000000  | 12          | 2018        | 222             | MeijTestD AutoSelD | 3874 PAXTON AVE | Cincinnati, OH, 45209 | CURBSIDE        | 45209    | National Brand | Auto Comment Text | Cancelled    | MeijTestD  | AutoSelD  | 5552901104 | random_autotest4@mijrtest.com | Cincinnati | Ohio  |

#  @passed
  @freshTestData
  Scenario Outline: TC007 Full Order & STH (Signed-in)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then user searches for '<gift_card>' product
    Then user select '<no_item>' Miejer Gift Card with qty '<item_qty>' and add to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then user increase Qty of Gift card by one
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details except email '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>'
    Then user Select Save This Address On Address Book CheckBox
    Then select Expedited Shipping option under Delivery method '<dvry_methd>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then user select existing Credit Card for providing payment info '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then validate Meijer homepage display Edit and View Order text links under curbside widget

    Examples:
      | email                   | password  | store_name    | tier1   | tier2   | no_item_toselect | str_zipCode | car_desc     | cc_securityCode | cc_name        | address1        | ccaddress2              | pickup_location | gift_card            | no_item | item_qty | item_count | comment           | gift_msg      | dvry_methd         | first_name | last_name | city         | state    | zip_code | ph_number  |
      | pritest_auto6@gmail.com | Selenium1 | Knapps Corner | Grocery | Produce | 15               | 49525       | CHEVY MPS123 | 999             | AutoABI SelABR | 1540 28th St SE | Grand Rapids, MI, 49508 | CURBSIDE        | is_ship_to_home:true | 1       | 5        | 21         | Auto Comment Text | Auto gift msg | Expedited Shipping | PritestF   | SelAutoF  | Grand Rapids | Michigan | 49508    | 5552991106 |

#  @passed
  @Zombie
  Scenario Outline: TC031 Cancel an order (Signed In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zipcode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then validate correct items display on order history detail page
    Then user click on Cancel Order link
    Then user click Go Back button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate correct items display on order history detail page
    #Then validate order status after successfully cancelled order

    Examples:
      | store_name    | str_zipCode | email                   | password  | tier1   | tier2   | no_item_toselect | car_desc       | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zipcode | ccaddress2            | cc_name           | pickup_location | item_count |
      | Knapps Corner | 49525       | pritest_auto7@gmail.com | Selenium1 | Grocery | Produce | 15               | Mustand abc123 | PritestG   | SelAutoG  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209   | Cincinnati, OH, 45209 | PritestG SelAutoG | CURBSIDE        | 15         |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC006 Full Order & SPO - Party Tray update qty and remove products (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    When user adds '<no_item_toselect>' different products to cart
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then user click in edit order button
    Then validate order edit mode display
    Then increase the QTY of each product in Order Edit '<increase_qty>'
    Then remove CNC products from order and store product name except 1st item '<no_item_toremove>'
    Then user Undo for one of the product
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then validate order update display correctly after item removed '<remaining_item>'

    Examples:
      | store_name | str_zipCode | tier1   | tier2  | tier3       | tier4                 | tier11 | tier22  | no_item_toselect | no_item | item_qty | shopcart_sub | comment               | car_desc             | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1        | ccaddress2            | zip_code | first_name | last_name | ph_number  | email                         | city       | state | increase_qty | no_item_toremove | remaining_item |
      | Cascade    | 49512       | Grocery | Bakery | Party Trays | Pre-Order Party Trays | Home   | Kitchen | 14               | 1       | 1        | Any Brand    | Auto New Comment Text | Truck White CHVY 909 | CURBSIDE        | 4055060000000000 | 12          | 2018        | 222             | MeijTestE AutoSelE | 3874 PAXTON AVE | Cincinnati, OH, 45209 | 45209    | MeijTestE  | AutoSelE  | 5552901105 | random_autotest5@mijrtest.com | Cincinnati | Ohio  | 7            | 7                | 9              |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC008 Full Order, SPO, and STH (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user navigates Shop to '<tier11>' to '<tier22>' submenu Tier2
    Then select item '<no_giftcard_item>' with desire qty '1' and Add to Cart
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_CNC_item>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<delivery_method>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    And enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | store_name      | str_zipCode | tier11     | tier22            | tier1   | tier2   | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | no_giftcard_item | no_CNC_item | car_desc           | pickup_location | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1          | ccaddress2            | first_name | last_name | city      | state       | zip_code | ph_number  | email                         | delivery_method   | gift_msg      | item_count | state_code |
      | Springboro Pike | 45449       | Gift Cards | Meijer Gift Cards | Grocery | Produce | 2            | 1              | 1                  | 0                  | 2           | 1               | 3               | auto cake msg | 2              | Auto Special Msg | 1                | 14          | Camero Red XML 445 | CURBSIDE        | 5127112000500983  | 1           | 2018        | 909             | MeijTestF AutoSelF | 7550 Airways Blvd | Southaven , MS, 38671 | MeijTestF  | AutoSelF  | Southaven | Mississippi | 38671    | 5552901106 | random.autotest6@mijrtest.com | Standard Shipping | auto gift msg | 16         | MS         |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC014 SPO - Cake (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to Meijer Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then validate pickup location for cake/deli item
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then order review page display
    Then user validate pickup information on Order Review Page without car desc Deli-Cake '<pickup_location>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart

    Examples:
      | store_name      | str_zipCode | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_count | shopcart_sub | comment      | first_name | last_name | ph_number  | email                         | pickup_location |
      | Springboro Pike | 45449       | 1            | 0              | 1                  | 0                  | 1           | 5               | 4               | auto cake msg | 1              | Auto Special Msg | 1          | Meijer Brand | Test Comment | MeijTestG  | AutoSelG  | 5552901107 | random.autotest7@mijrtest.com | DELI/BAKERY     |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC015 SPO - Cake and Party Tray verify order not editable (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user select Cupcake Cake from LHS navigation
    Then user click Create This Cake for the selected category
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    Then select Cupcake Cake optional attributes '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user searches for '<item_tosearch>' product
    Then select item '<no_item_toselect>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Substitution Preference to No Substitution Shopping Cart '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then validate the order could not found Message display

    Examples:
      | store_name | str_zipCode | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_tosearch             | no_item_toselect | item_count | shopcart_sub    | comment      | first_name | last_name | ph_number  | email                    | zip_code |
      | Canton     | 48187       | 1            | 0              | 1                  | 0                  | auto cake msg | 1              | Auto Special Msg | Meijer Classic Party Tray | 1                | 2          | No Substitution | Test Comment | Docker     | Rockers   | 5552221121 | autotest_pri10@gmail.com | 49544    |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC017 SPO & STH - Cake and gift card verify order not editable (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then select item '<no_giftcard_item>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Substitution Preference to No Substitution Shopping Cart '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<delivery_method>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then validate pickup location for cake/deli item
    Then click Next button on order flow
    Then billing page display
    Then user validate pickup information on Order Review Page without car desc Deli-Cake '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page without car desc Deli-Cake '<pickup_location>'
    Then user validate price displayed in order review page
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display

    Examples:
      | store_name      | str_zipCode | tier1      | tier2             | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | no_giftcard_item | shopcart_sub    | comment           | car_desc              | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1        | ccaddress2            | first_name | last_name | city       | state | zip_code | ph_number  | email                          | delivery_method  | gift_msg      | item_count | state_code |
      | Springboro Pike | 45449       | Gift Cards | Meijer Gift Cards | 2            | 1              | 1                  | 0                  | 2           | 1               | 3               | auto cake msg | 2              | Auto Special Msg | 1                | No Substitution | Auto Text Comment | Mustang Black SGG-495 | DELI/BAKERY     | 4055060000000000 | 12          | 2018        | 222             | MeijTestG AutoSelG | 3874 PAXTON AVE | Cincinnati, OH, 45209 | MeijTestG  | AutoSelG  | Cincinnati | Ohio  | 45209    | 5552221301 | random.autotest8@mijrtest8.com | Express Shipping | auto gift msg | 2          | OH         |

#cant pass until cakes are fixed
#  @skipped
  @Zombie
  Scenario Outline: TC018 SPO & STH - Cake, deli tray, and gift card (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then select item '<no_giftcard_item>' with desire qty '1' and Add to Cart
    Then user searches for '<item_tosearch>' product
    Then select item '<no_item_toselect>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<delivery_method>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user validate pickup information on Order Review Page without Car desc curbside '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page without Car desc curbside '<pickup_location>'
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | store_name | str_zipCode | tier1      | tier2             | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | no_giftcard_item | item_tosearch | no_item_toselect | item_count | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                         | delivery_method   | gift_msg      | pickup_location | state_code | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | ccaddress2            |
      | Canton     | 48187       | Gift Cards | Meijer Gift Cards | 2            | 1              | 1                  | 0                  | 2           | 1               | 1               | auto cake msg | 5              | Auto Special Msg | 1                | Party Tray    | 1                | 3          | MeijTestH  | AutoSelH  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552901108 | random.autotest9@mijrtest.com | Standard Shipping | auto gift msg | CURBSIDE        | OH         | 4055060000000000 | 12          | 2018        | 222             | MeijTestH AutoSelH | Cincinnati, OH, 45209 |

#cant pass until cakes are fixed
#  @skipped
  @freshdata
  Scenario Outline: TC019 SPO & STH - Deli tray and gift card (Signed-in)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then validate and reset shopping cart to 0 item
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<item_tosearch>' product
    Then select item '<no_item_toselect>' with desire qty '1' and Add to Cart
    Then user searches for '<gift_card>' product
    Then user adds '<no_item_toselect>' of one gift card to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details except email '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>'
    Then user enter delivery method shipping information details without giftcard msg '<delivery_method>'
    Then user Select Save This Address On Address Book CheckBox
    Then click Next button on order flow
    Then pickup Page display
    Then validate complete prefilled value under pickup info fields '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then user select Save Credit Card to your Account checkbox
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate price displayed in order review page
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page without car desc Deli-Cake '<pickup_location>'
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | email                 | password  | store_name | str_zipCode | item_tosearch             | no_item_toselect | gift_card | comment           | first_name | last_name | address1            | city       | state | zip_code | ph_number  | delivery_method   | state_code | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name          | ccaddress2            | pickup_location | item_count |
      | brotest228@meijer.com | Selenium1 | Saline Rd  | 48103       | Meijer Classic Party Tray | 1                | gift card | Auto Text Comment | NewTest    | AutoTest  | 49513874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552221302 | Standard Shipping | OH         | 4055060000000000 | 12          | 2018        | 222             | NewTest AutoTest | Cincinnati, OH, 45209 | Deli/Bakery     | 2          |

#  @passed
  @Zombie
  Scenario Outline: TC020 STH - Gift Card verify order not editable (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<item_tosearch>' product
    Then user select '<no_item>' Miejer Gift Card with qty '<item_qty>' and add to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<delivery_method>' '<gift_msg>'
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
#    Then user validate price displayed in order review page
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then validate order history page for button and links disabled
    Then validate Ship To home section is display correct
    Then validate ordered items are displayed correct

    Examples:
      | store_name    | str_zipCode | item_tosearch     | no_item | item_qty | item_count | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                  | delivery_method   | gift_msg                                              | blockhelper_msg                  | del10txtBlcHlp_msg               | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name        | ccaddress2            |
      | Knapps Corner | 49525       | Meijer Gift Cards | 1       | 1        | 1          | AutoABF    | SelABU    | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552221303 | abcTest_mail@gmail.com | Standard Shipping | Auto Lengthy Text validation for Gift Message textbox | 17 characters, Max 70 characters | 27 characters, Max 70 characters | 40550600000000003 | 12          | 2018        | 222             | AutoABF SelABU | Cincinnati, OH, 45209 |

#cant pass until cakes are fixed
#  @FeatureOverNight
  @Zombie
  Scenario Outline: TC005 Full Order & SPO - Cake remove all CNC and Edit Pickup Time (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user select Cupcake Cake from LHS navigation
    Then user click Create This Cake for the selected category
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    Then select Cupcake Cake optional attributes '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to Meijer Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate pickup information on Order Review Page '<car_desc>' '<pickup_location>'
    Then user validate price displayed in order review page
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from Your Account section
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then validate charge at pick for curbside text
    Then user click in edit order button
    Then validate order edit mode display
    Then increase the QTY of each product in Order Edit '<increase_qty>'
    Then at random, remove '4' items from Active Order
    Then validate display of item after clicked on removed button
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then user click on Edit Pickup Time
    Then Select new future pickup time and update it
    Then validate the newly selected pickup time display correct

    Examples:
      | store_name | str_zipCode | tier1   | tier2   | no_CNC_item | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_count | shopcart_sub | comment      | first_name | last_name | ph_number  | email                    | car_desc                | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1          | ccaddress2           | zip_code | city      | state       | increase_qty | no_item_toremove |
      | Canton     | 48187       | Grocery | Produce | 14          | 1            | 0              | 1                  | 0                  | auto cake msg | 1              | Auto Special Msg | 15         | Meijer Brand | Test Comment | MeijTestI  | AutoSelI  | 5552901109 | pritam.maibam@meijer.com | Red Ford Excape NEW 999 | CURBSIDE        | 4055060000000000 | 12          | 2018        | 222             | MeijTestI AutoSelI | 7550 Airways Blvd | Southaven, MS, 38671 | 38671    | Southaven | Mississippi | 3            | 14               |


  @Zombie
  Scenario Outline: TC 021 - Bulk Gift Card Discount (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for 'gift card' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then change the qty of item to get 3000 or more Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details without giftcard msg '<delivery_method>'
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
#    Then user validate price displayed in order review page
    Then validate promotional discount display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | store_name    | str_zipCode | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                         | delivery_method   | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name        | ccaddress2            |
      | Knapps Corner | 49525       | AutoABB    | SelABY    | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552221304 | seltest1_automation@gmail.com | Standard Shipping | 4055060000000000 | 12          | 2018        | 222             | AutoABB SelABY | Cincinnati, OH, 45209 |

#cant pass until cakes are fixed
#  @skipped
  @freshdata
  Scenario Outline: TC032 Cancel FC Mixed Order (Signed In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then user navigates Shop to '<tier11>' to '<tier22>' submenu Tier2
    Then user adds '<no_item>' of one gift card to cart
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
    Then shipping Page display
    Then user Enter Shipping details except email '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>'
    Then user enter delivery method shipping information details without giftcard msg '<delivery_method>'
    Then click Next button on order flow
    Then pickup Page display
    Then validate complete prefilled value under pickup info fields '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate price displayed in order review page
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then validate correct item name display except Custom Cake in order history detail page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate correct item name display except Custom Cake in order history detail page
    Then validate order status remains same as Order Placed

    Examples:
      | email                 | password  | store_name | str_zipCode | tier1   | tier2   | tier11     | tier22            | no_item_toselect | no_item | item_qty | first_name | last_name | address1        | city       | state | zip_code | ph_number  | delivery_method   | state_code | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name        | ccaddress2            | pickup_location | item_count | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   |
      | brotest111@meijer.com | Selenium1 | Cascade    | 49512       | Grocery | Produce | Gift Cards | Meijer Gift Cards | 15               | 1       | 3        | AutoABA    | SelABZ    | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5559008832 | Standard Shipping | OH         | 4055060000000000 | 12          | 2018        | 222             | AutoABA SelABZ | Cincinnati, OH, 45209 | CURBSIDE        | 19         | 2            | 1              | 1                  | 0                  | 2           | 1               | 1               | auto cake msg | 5              | Auto Special Msg |

#cant pass until cakes are fixed
#  @pass
  @Zombie
  Scenario Outline: TC033 Cancel CNC+SPO (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then enter pickup location info '<car_desc>'
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then validate correct item name display except Custom Cake in order history detail page
    Then validate Curbside Contents pickup display '<store_name>' '<car_desc>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate correct item name display except Custom Cake in order history detail page
    Then validate order status after successfully cancelled order

    Examples:
      | store_name    | str_zipCode | tier1   | tier2   | no_item_toselect | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_count | first_name | last_name | ph_number  | email                          | car_desc      | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | ccaddress2            |
      | Knapps Corner | 49525       | Grocery | Produce | 15               | 2            | 1              | 1                  | 0                  | 2           | 1               | 1               | auto cake msg | 5              | Auto Special Msg | 16         | AutoABD    | SelABW    | 5552292104 | AutoABD.SelABW@testselauto.com | NISSAN XYZ100 | CURBSIDE        | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Cincinnati, OH, 45209 |

#cant pass until cakes are fixed
#  @passed
  @freshdata
  Scenario Outline: TC034 Cancel CNC+STH (Signed In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then verify user has no active order
    Then user navigates Shop to 'Grocery' to 'Produce' submenu Tier2
    Then select item '4' with desire qty '1' and Add to Cart
    Then user navigates Shop to 'Gift Cards' to 'Meijer Gift Cards' submenu Tier2
    Then user adds '1' of one gift card to cart
    Then user adds '1' of one gift card to cart
    Then user adds '1' of one gift card to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details except email '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>'
    Then user enter delivery method shipping information details without giftcard msg '<delivery_method>'
    Then click Next button on order flow
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '72' hours in future and click Reserve button
#    3 Days Out ^
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address2>' '<city2>' '<state2>' '<zip_code2>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate price displayed in order review page
    Then user validate Shipping information display on Order Review Page '<address1>' '<address1A>' '<delivery_method>'
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then TEST CASE FAILS DUE TO BUG REPORT #'33254'

    Examples:
      | email                | password  | store_name | str_zipCode | first_name | last_name | address1        | city    | state    | zip_code | address1A          | ph_number  | delivery_method   | cc_number       | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name        | ccaddress2            | address2        | city2      | state2 | zip_code2 |
      | dttest138@meijer.com | Selenium1 | Cascade    | 49512       | AutoABM    | SelABN    | 1540 28th St SW | WYOMING | Michigan | 49509    | WYOMING, MI, 49509 | 5552292113 | Standard Shipping | 4055060000000000 | 12          | 2018        | 222            | AutoABM SelABN | CINCINNATI, OH, 45209 | 3874 Paxton Ave | Cincinnati | Ohio   | 45209     |


#cant pass until cakes are fixed
#  @skipped
  @freshdata
  Scenario Outline: TC016 SPO - Party Tray (Signed-in)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to National Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Log In and Checkout on Shopping Cart page
    When user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then select Pickup slot several days in future
    Then validate pickup location for cake/deli item
    Then click Next button on order flow
    Then order review page display
    Then user validate price displayed in order review page
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate order status display
    #Then validate order date display
    Then validate content in Cake-Deli Store pickup display '<store_name>'
    Then user click on Edit Pickup Time
    Then user select a new pickup time
    Then user cancel edit pickup time
    Then user click on Edit Pickup Time
    Then user select a new pickup time
    Then user close edit pickup time popup window
    Then user click on Edit Pickup Time
    Then select pickup time just before-after current pickup slot
    Then update new selected pickup time
    Then validate the newly selected pickup time display correct
    Then user click on Cancel Order link
    Then user click Go Back button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click X Button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate no longer displays pickup time and links for the order you cancelled
    Then validate order status after successfully cancelled order

    Examples:
      | email                 | password  | store_name | str_zipCode | tier1   | tier2  | tier3       | tier4                 | no_item | item_qty | item_count | shopcart_sub   | comment                    |
      | brotest281@meijer.com | Selenium1 | Cascade    | 49512       | Grocery | Bakery | Party Trays | Pre-Order Party Trays | 1       | 1        | 1          | National Brand | This is auto comment text. |

#cant pass until cakes are fixed
#  @FeatureOverNight
  @freshdata
  Scenario Outline: TC039 Cancel SPO (Signed In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
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
    Then select Pickup slot several days in future
    Then validate pickup location for cake/deli item
    Then click Next button on order flow
    Then order review page display
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate order status after successfully cancelled order

    Examples:
      | email                   | password  | store_name | str_zipCode | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_count |
      | pritest_auto1@gmail.com | Selenium1 | Cascade    | 49512       | 2            | 1              | 1                  | 0                  | 2           | 1               | 1               | auto cake msg | 5              | Auto Special Msg | 1          |

#  @passed
  @freshdata
  Scenario Outline: TC040 Cancel STH (Signed In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then user adds '<item_qty>' of one gift card to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details except email '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>'
    Then user enter delivery method shipping information details without giftcard msg '<delivery_method>'
    Then click Next button on order flow
    Then billing page display
    Then user select Billing Info same as Shipping Info Checkbox
    Then user enter Credit Card payment info details '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then validate Ship To home section is display correct
    Then validate ordered items are displayed correct
    Then validate cancel order link is not displayed

    Examples:
      | email                   | password  | store_name | tier1      | tier2             | str_zipCode | no_item | item_qty | item_count | first_name | last_name | address1        | city       | state | zip_code | ph_number  | delivery_method   | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name           | ccaddress2            |
      | pritest_auto2@gmail.com | Selenium1 | Cascade    | Gift Cards | Meijer Gift Cards | 49512       | 1       | 3        | 3          | PritestB   | SelAutoB  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552991102 | Standard Shipping | 4055060000000000 | 12          | 2018        | 222             | PritestB SelAutoB | Cincinnati, OH, 45209 |

#  @passed
  @Zombie
  Scenario Outline: TC041 Add Alcohol to Order (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then type beer and search the item '<alchohol_item>'
    Then user select '<item_add1>' item edit qty to '<qty_edit1>' and click plusAdd button
    Then validate plusAdd button change to Remove link
    Then click on Add X Items button
    Then order history details page display
    Then validate newly added item is listed
    Then validate notification message after 1 item added but before updating order
    Then click on Update Order Button to update the order
    Then update order popup confirmation message display
    Then user click update order button on popup confirmation
    Then age restriction popup appear while updating order
    Then user select cancel on age restriction popup
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then user confirm on age restriction popup
    Then validate order details page has newly added item

    Examples:
      | store_name    | str_zipCode | tier1   | tier2   | no_item_toselect | item_count | first_name | last_name | ph_number  | email                       | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name              | address1        | city       | state | zip_code | ccaddress2            | alchohol_item | item_add1 | qty_edit1 |
      | Knapps Corner | 49525       | Grocery | Produce | 2                | 2          | MeijTestAB | AutoSelAB | 5552901101 | random1_email1@meijtest.com | 4055060000000000 | 12          | 2018        | 222             | MeijTestAB AutoSelAB | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Cincinnati, OH, 45209 | Beer          | 1         | 1         |

#  @skipped
  @freshdata
  Scenario Outline: TC042 Add Alcohol to Order (Signed-In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    #Then navigate to menu Shop-Grocery-Produce
    Then user navigates Shop to 'Grocery' to 'Produce' submenu Tier2
    Then navigate to next page of product list
    When user adds '<no_item_toselect>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click Edit Link option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then type beer and search the item '<alchohol_item>'
    Then user select '<item_add1>' item edit qty to '<qty_edit1>' and click plusAdd button
    Then validate plusAdd button change to Remove link
    Then click on Add X Items button
    Then order history details page display
    Then validate newly added item is listed
    Then validate notification message after 1 item added but before updating order
    Then click on Update Order Button to update the order
    Then update order popup confirmation message display
    Then user click update order button on popup confirmation
    Then age restriction popup appear while updating order
    Then user select cancel on age restriction popup
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then user confirm on age restriction popup
    Then validate order details page has newly added item

    Examples:
      | email                   | password  | store_name    | str_zipCode | no_item_toselect | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | cc_name           | ccaddress2            | alchohol_item | item_add1 | qty_edit1 |
      | pritest_auto3@gmail.com | Selenium1 | Knapps Corner | 49525       | 15               | 15         | PritestC   | SelAutoC  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | PritestC SelAutoC | Cincinnati, OH, 45209 | beer          | 1         | 1         |

#this test case needs a more direct way to find products with choking hazard, as not all board games have a choking hazard
  #and some with warnings have small parts warning but do not say choking hazard JoeG - 12-21-2016
#  @skipped
  @Zombie
  Scenario Outline: TC043 Add Choking Hazard Product to Order (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then navigate to next page of product list
    When user adds '<no_item_toselect>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then validate homepage display 0 item in Cart
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then type board games and search the item '<search_item1>'
    Then user select '<item_add1>' choking hazard item edit qty to '<qty_edit1>' and click plusAdd button
    #Then validate choking hazard popup message display
    Then validate plusAdd button change to Remove link
    Then click on Add X Items button
    Then order history details page display
    Then validate newly added item is listed
    Then validate notification message after 1 item added but before updating order
    Then click on Update Order Button to update the order
    Then update order popup confirmation message display
    Then user click update order button on popup confirmation
    Then validate order details page has newly added item

    Examples:
      | store_name    | str_zipCode | tier1   | tier2   | no_item_toselect | item_count | first_name | last_name | ph_number  | email                      | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1        | city       | state | zip_code | ccaddress2            | search_item1 | item_add1 | qty_edit1 |
      | Knapps Corner | 49525       | Grocery | Produce | 15               | 15         | MeijTestB  | AutoSelB  | 5552901102 | random_email2@meijtest.com | 4055060000000000 | 12          | 2018        | 222             | MeijTestB AutoSelB | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Cincinnati, OH, 45209 | board games  | 1         | 1         |

#see above
#  @skipped
  @freshdata
  Scenario Outline: TC044 Add Choking Hazard Product to Order (Signed-In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user adds '<no_item_toselect>' different products to cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click Edit Link option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then user click on plusAdd an Item option
    Then validate add item modal display correctly
    Then type board games and search the item '<search_item1>'
    Then user select '<item_add1>' choking hazard item edit qty to '<qty_edit1>' and click plusAdd button
    #Then validate choking hazard popup message display
    Then validate plusAdd button change to Remove link
    Then click on Add X Items button
    Then order history details page display
    Then validate newly added item is listed
    Then validate notification message after 1 item added but before updating order
    Then click on Update Order Button to update the order
    Then update order popup confirmation message display
    Then user click update order button on popup confirmation
    Then validate order details page has newly added item

    Examples:
      | email                   | password  | store_name    | tier1   | tier2   | str_zipCode | no_item_toselect | item_count | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | cc_name           | ccaddress2            | search_item1 | item_add1 | qty_edit1 |
      | pritest_auto5@gmail.com | Selenium1 | Knapps Corner | Grocery | Produce | 49525       | 15               | 15         | PritestE   | SelAutoE  | 4055060000000000 | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | PritestE SelAutoE | Cincinnati, OH, 45209 | board games  | 1         | 1         |

  @Zombie
  Scenario Outline: TC046 Cancel CNC Order (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then select Pickup slot several days in future
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then user provide order number and billing zip code and search for order '<zip_code>'
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate cancel button and edit order buttons are enabled
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Go Back button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click X Button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate no longer displays pickup time and links for the order you cancelled
    #Then validate order status after successfully cancelled order

    Examples:
      | store_name    | str_zipCode | cnc_item | no_item | item_qty | item_count | first_name | last_name | ph_number  | email                    | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | address1        | city       | state | zip_code | ccaddress2            |
      | Knapps Corner | 49525       | Brush    | 1       | 12       | 12         | MeijTestJ  | AutoSelJ  | 5552901110 | pritam.maibam@meijer.com | 4055060000000000 | 12          | 2018        | 222             | MeijTestJ AutoSelJ | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Cincinnati, OH, 45209 |


  @Zombie
  Scenario Outline: TC047 Cancel CNC Order (Signed-In)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click Edit Link option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate ordered items are displayed correct
    Then user click on Cancel Order link
    Then user click Go Back button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click X Button on Order Cancel Confirmation Message
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate no longer displays pickup time and links for the order you cancelled
    #Then validate order status after successfully cancelled order

    Examples:
      | email                   | password  | store_name    | str_zipCode | cnc_item     | no_item | item_qty | item_count | first_name | last_name | cc_number         | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | cc_name           | ccaddress2            |
      | pritest_auto7@gmail.com | Selenium1 | Knapps Corner | 49525       | water bottle | 1       | 12       | 12         | PritestG   | SelAutoG  | 4055060000000000  | 12          | 2018        | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | PritestG SelAutoG | Cincinnati, OH, 45209 |

  @freshdata
  Scenario Outline: TC037 Cancel CNC+SPO (Signed In)
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
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then select item '<no_item>' with desire qty '<item_qty1>' and Add to Cart
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
    Then select Pickup slot several days in future
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate correct item name display except Custom Cake in order history detail page
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate ordered items Except Cake are still displayed same even after order is cancelled
    #Then validate order status after successfully cancelled order

    Examples:
      | email                   | password  | store_name    | str_zipCode | tier1   | tier2   | no_item | item_qty1 | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg     | idx_custmsgclr | txtspcInstrmsg              | item_count | first_name | last_name | address1         | city       | state | zip_code | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name           | ccaddress2            |
      | pritest_auto9@gmail.com | Selenium1 | Knapps Corner | 49525       | Grocery | Produce | 1       | 1         | 2            | 1              | 0                  | 1                  | 3           | 8               | 11              | Automation Cake | 5              | Special Automation Cake Msg | 2          | PritestI   | SelAutoI  | 33874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 4055060000000000 | 12          | 2018        | 222             | PritestI SelAutoI | Cincinnati, OH, 45209 |


  @Zombie
  Scenario Outline: TC038 Cancel CNC+STH (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then select item '<no_item>' with desire qty '<item_qty1>' and Add to Cart
    Then user navigates Shop to '<tier11>' to '<tier22>' submenu Tier2
    Then select item '<no_item>' with desire qty '<item_qty2>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    #Then validate shopping cart display for ProductNames TotalItemQty and Subtotal '<item_count>'
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<dvry_methd>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then verify Pickup Info Display on Pickup page '<store_name>' '<address1>' '<ccaddress2>' '<dvry_methd>' '<item_count>'
    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then enter pickup location info '<car_desc>'
    Then select Pickup slot several days in future
    Then click Next button on order flow
    Then billing page display
    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then validate calculated total value display correct
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
    Then validate ordered items are still displayed same even after order is cancelled
    Then validate order status remains same as Order Placed

    Examples:
      | store_name | str_zipCode | tier1   | tier2   | tier11     | tier22            | no_item | item_qty1 | item_qty2 | item_count | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                       | dvry_methd        | gift_msg               | car_desc               | pickup_location | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | ccaddress2            | state_code |
      | Cascade    | 49512       | Grocery | Produce | Gift Cards | Meijer Gift Cards | 1       | 1         | 1         | 2          | MeijTestM  | AutoSelM  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552901113 | random_email13@meijtest.com | Standard Shipping | Auto Gift Message Test | 2015 Ferrari LaFerrari | Curbside        | 4055060000000000 | 12          | 2018        | 222             | MeijTestM AutoSelM | Cincinnati, OH, 45209 | OH         |

#  @passed
  @Zombie
  Scenario Outline: TC058- Edit Qty - Unit of Measure (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<item_tosearch>' product
    Then select '<no_item_toselect>' item '1' qty with desired 'lb' UOM message
    Then select '<no_item_toselect>' item '1' qty with desired 'ea' UOM message
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to National Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then enter pickup location info '<car_desc>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history details page display
    Then validate the look and feel of order history details page
    Then validate order status display
    #Then validate order date display
    Then validate ordered items are displayed correct
    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
    Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then user click in edit order button
    Then validate order edit mode display
    Then user increase count of item with Pound as UOM '<lb_IncQty>'
    Then user reduce count of item which has UOM as Pound '<lb_ReduQty>'
    Then user increase count of item with Each as UOM '<ea_IncQty>'
    Then user reduce count of item which has UOM as Each '<ea_ReduQty>'
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate page refresh and page is no longer in edit mode

    Examples:
      | store_name    | str_zipCode | no_item_toselect | item_tosearch | item_count | shopcart_sub   | comment                 | first_name | last_name | address1        | city       | state | zip_code | ph_number  | email                    | car_desc             | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | ccaddress2            | lb_IncQty | ea_IncQty | lb_ReduQty | ea_ReduQty |
      | Knapps Corner | 49525       | 1                | meat counter  | 2          | National Brand | Test Automation Comment | MeijTestO  | AutoSelO  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 5552901115 | pritam.maibam@meijer.com | Ford Escape 2016 Red | 4055060000000000 | 12          | 2018        | 222             | MeijTestO AutoSelO | Cincinnati, OH, 45209 | 9         | 9         | 7.25       | 7          |

#  @passed
  @freshdata
  Scenario Outline: TC059 - Edit Qty - Unit of Measure (Signed-In)
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
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<item_tosearch>' product
    Then select '<no_item_toselect>' item '1' qty with desired 'lb' UOM message
    Then select '<no_item_toselect>' item '1' qty with desired 'ea' UOM message
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then set Shopping Cart Substitution to National Brand '<shopcart_sub>'
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then enter pickup location info '<car_desc>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate overall Total Calulation of Single Item
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click Edit Link option next to order just placed
    Then order history details page display
#    Then validate the look and feel of order history details page
#    Then validate ordered items are displayed correct
#    Then validate order status display
#    Then validate order date display
#    Then validate order edit mode display
#    Then validate content in Cubside pickup display '<store_name>' '<car_desc>' '<shopcart_sub>' '<comment>'
 #   Then verify CC details content in Payment and Coupon details '<address1>' '<ccaddress2>' '<cc_number>'
    Then user increase count of item with Pound as UOM '<lb_IncQty>'
    Then user reduce count of item which has UOM as Pound '<lb_ReduQty>'
    Then user increase count of item with Each as UOM '<ea_IncQty>'
    Then user reduce count of item which has UOM as Each '<ea_ReduQty>'
    Then click on Update Order Button to update the order
    Then user click update order button on popup confirmation
    Then validate page refresh and page is no longer in edit mode

    Examples:
      | email                    | password  | store_name    | str_zipCode | item_tosearch | no_item_toselect | item_count | shopcart_sub   | comment                      | car_desc                        | first_name | last_name | address1        | city       | state | zip_code | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name           | ccaddress2            | lb_IncQty | ea_IncQty | lb_ReduQty | ea_ReduQty |
      | pritest_auto12@gmail.com | Selenium1 | Knapps Corner | 49525       | meat counter  | 1                | 2          | National Brand | Automation Auto Comment Text | Lamborghini Galarado 2012 Green | PritestL   | SelAutoL  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | 4055060000000000 | 12          | 2018        | 222             | PritestL SelAutoL | Cincinnati, OH, 45209 | 9         | 9         | 7.25       | 7          |


#  @fullorderj
  @Zombie
  Scenario Outline: TC026 - Reorder CNC+STH (Anonymous)
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user navigate to Order History from the account header
    Then user enter '<order_no>' and billing '<zipCode>' and search order
    Then order history details page display
    Then user click on Select All checkbox
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then update qty of items so total qty is greater than 12 '<desire_itemCount>'
    Then click Add items to cart on Reorder Items pop up
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout as Guest on Shopping Cart page
    Then shipping Page display
    Then user Enter Shipping details '<first_name>' '<last_name>' '<address1>' '<city>' '<state>' '<zip_code1>' '<ph_number>' '<email>'
    Then user enter delivery method shipping information details '<delivery_method>' '<gift_msg>'
    Then click Next button on order flow
    Then pickup Page display
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then click Next button on order flow
    Then billing page display
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code1>'
    Then user enter Credit Card payment info details '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then user validate entered credit card details '<cc_name>' '<cc_number>'
    Then user validate billing information on Order Review Page '<address1>' '<ccaddress2>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<delivery_method>'
    Then validate calculated total value display correct
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page

    Examples:
      | store_name | str_zipCode | order_no | zipCode | first_name | last_name | address1        | city       | state | zip_code1 | ph_number  | email                       | delivery_method   | gift_msg           | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | cc_name            | ccaddress2            | comment                   | desire_itemCount |
      | Cascade    | 49512       | 130780   | 49544   | MeijTestS  | AutoSelS  | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209     | 5552901119 | random_email19@meijtest.com | Standard Shipping | auto Gift msg text | 4055060000000000 | 12          | 2018        | 222             | MeijTestS AutoSelS | Cincinnati, OH, 45209 | reOrder Auto comment Text | 12               |

