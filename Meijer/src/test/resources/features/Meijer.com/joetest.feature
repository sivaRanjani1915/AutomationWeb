Feature: Regression Digital Shopping


  @tierBrowsing
  Scenario Outline: Basic Checkout Flow (Signed-in)
    Given user navigate to MeijerDotCom
 #   When user navigates to '<tier1>' '<tier2>' '<tier3>' '<tier4>'
    When user searches for '<productType>' product

    Then user adds '<qty>' of one product to cart

    Examples:
      | productType | qty |
      | not alcohol | 5   |


  @joetest2
  Scenario Outline: Basic Checkout Flow (Signed-in)
    Given user navigate to MeijerDotCom
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate and reset shopping cart to 0 item
    Then clear all array list

#test alcohol, tobacco, choking hazard, cake and SPO
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then browse through Shop-Gift Cards-Meijer Gift Cards
    Then click Add to Cart on any of the gift card products '<no_giftcard_item>'


    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal	# THIS GUY RIGHT HERE, IS VALIDATING AGAINST A STATIC NUMBER, WE NEED IT TO ACTUALLY COUNT THE ITEMS...getting it to recognize line items and weighted items might be a pain
  #    Then set Substitution Preference to No Substitution Shopping Cart '<shopcart_sub>'
  #    Then user enter text on Comment field Shopping Cart '<comment>'
    Then click Checkout on Shopping Cart page
    Then click Next button on order flow


    Then user verify auto filled Name value on enter pickup info fields '<first_name>' '<last_name>'
    Then user enter Phone and Email details in Pickup Info '<ph_number>' '<email>'
    Then select next day first day available Pickup slot
#	And enter pickup location info '<car_desc>'


    Then pickup Page display




    Then select next day first day available Pickup slot
  #    Then enter pickup location info '<car_desc>'
  #    Then verify 3rd TC Pickup Info Display on Pickup
    Then click Next button on order flow
    Then billing page display
  #    Then validate pickup details on Billing page '<car_desc>' '<pickup_location>'
    Then user select existing Credit Card for providing payment info '<cc_securityCode>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then user click Return Home button on confirm page

    Examples:
      | store_name    | email                   | password  | no_item_toselect | item_tosearch1 | item_tosearch2 | no_item | four_qty | eight_qty | car_desc     | pickup_location | cc_securityCode | cc_name           | address1              | ccaddress2              | alchohol | item_count | comment           | shopcart_sub    | str_zipCode | item_add1 | qty_edit1 | no_giftcard_item | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg | idx_custmsgclr | txtspcInstrmsg |
      | Knapps Corner | pritest_auto4@gmail.com | Selenium1 | 3                | Meijer Bread   | Bagels         | 1       | 4        | 8         | Taxi CAL 999 | CURBSIDE        | 999             | PritestD SelAutoD | 411 Standale Plaza NW | GRAND RAPIDS, MI, 49534 | beer     | 15         | Auto Comment Text | No Substitution | 49525       | 1         | 1         | 1                | 2            | 1              | 1                  | 1                  | 1           | 1               | 3               | custmmssg   | 2              | testext instr  |
