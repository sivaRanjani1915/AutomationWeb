Feature: SlotReservationDetails.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: Validate CNC item (default) Time Slot Modal Behavior - W/o Reservation - With Reservation - Update Reservation
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then clear all array list
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then In Curbside Widget edit reserve curbside pickup time
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then user updates reservation pickup time
    Then In Curbside Widget validate the newly reserved pickup time display correct

    Examples:
      | email                    | password  | store_name    | str_zipCode | productType | qty | leadTime |
      | pritest_auto19@gmail.com | Selenium1 | Knapps Corner | 49525       | not alcohol | 2   | 4        |

  @Zombie
  Scenario Outline:  Validate SPO item Time Slot Behavior - W/o Reservation - With Reservation - Update Reservation
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then clear all array list
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user Browse through Shop and select Create a Cake
    Then custom Cake Landing page display
    Then user Click Create This Cake on a Theme Cake
    Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    Then user click on Add to Cart for design cake
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - SPO - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user updates reservation pickup time
    Then In Curbside Widget validate the newly reserved pickup time display correct

    Examples:
      | email                    | password  | productType | qty | store_name    | str_zipCode | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | leadTime |
      | pritest_auto19@gmail.com | Selenium1 | not alcohol | 1   | Knapps Conrer | 49525       | 1            | 0              | 1                  | 0                  | 1           | 5               | 4               | auto cake msg | 1              | Auto Special Msg | 4        |

  @Zombie
  Scenario Outline:  Validate Mixed Cart Time Slot Behavior - W/o Reservation - With Reservation - Update Reservation
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate and reset shopping cart to 0 item
    Then user searches for '<CNC>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<SPO>' product
    Then select item '<no_item2>' with desire qty '<item_qty2>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Mixed Cart - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then In Curbside Widget edit reserve curbside pickup time
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then user updates reservation pickup time
    Then In Curbside Widget validate the newly reserved pickup time display correct

    Examples:
      | email                | password  | store_name    | str_zipCode | CNC                       | no_item | item_qty | SPO                   | no_item2 | item_qty2 | item_count | leadTime |
      | matt_auto1@gmail.com | password1 | Knapps Conrer | 49525       | is_click_and_collect:true | 1       | 1        | is_prepared_item:true | 1        | 1         | 2          | 4        |

  @Zombie
  Scenario Outline:  Curbside Cart When Adding SPO item to cart With Slot Reserved - Validate Warning Message
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then clear all array list
    Then clear arraylist of shopping cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user searches for '<CNC>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<SPO>' product
    Then select item '<no_item2>' with desire qty '<item_qty2>' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks leave out of cart button
    Then validate item was not added via Cart Icon and slot still reserved '<expected_count>'
    Then select item '<no_item2>' with desire qty '<item_qty2>' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks continue, add item to cart button
    Then validate item was added via Cart Icon and reserved slot is dropped '<expected_count2>'
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Mixed Cart - Without Reservation

    Examples:
      | email              | password  | store_name    | str_zipCode | CNC   | no_item | item_qty | SPO                   | no_item2 | item_qty2 | expected_count | expected_count2 | item_count2 | leadTime |
      | mjr_auto@email.com | password1 | Knapps Conrer | 49525       | apple | 1       | 1        | is_prepared_item:true | 1        | 1         | 1              | 2               | 2           | 4        |

  @Zombie
  Scenario Outline:  SPO Cart When Adding Curbside item to cart With Slot Reserved - Validate Warning Message
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate and reset shopping cart to 0 item
    Then user searches for '<SPO>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then user searches for '<CNC>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks leave out of cart button
    Then validate item was not added via Cart Icon and slot still reserved '<expected_count>'
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks continue, add item to cart button
    Then validate item was added via Cart Icon and reserved slot is dropped '<expected_count2>'
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Mixed Cart - Without Reservation

    Examples:
      | email              | password  | store_name    | str_zipCode | SPO                   | no_item | item_qty | CNC   | expected_count | expected_count2 | item_count | leadTime |
      | mjr_auto@email.com | password1 | Knapps Conrer | 49525       | is_prepared_item:true | 1       | 1        | apple | 1              | 2               | 2          | 4        |

  @Zombie
  Scenario Outline: Validate Curbside Widget - Active Curbside Order - With Slot Reserved before Checkout
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate and reset shopping cart to 0 item
    Then user searches for '<CNC>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then validate pickup time modal - Without Reservation
    Then reserve an available pickup slot at least '<leadTime>' hours in future and click Reserve button
    Then In Curbside Widget validate the reserved pickup time display correct
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate slot reservation is display correct in checkout flow
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then enter pickup location info '<car_desc>'
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
    Then In Curbside Widget validate active order is display correct
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then validate correct items display on order history detail page


    Examples:
      | email              | password  | store_name | str_zipCode | store_name2   | str_zipCode2 | CNC                       | no_item | item_qty | leadTime | item_count | first_name | last_name | ph_number  | car_desc     | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1           | city   | state    | zip_code | cc_name  | ccaddress2        |
      | mjr_auto@email.com | password1 | Cascade    | 49512       | Knapps Corner | 49525        | is_click_and_collect:true | 4       | 1        | 4        | 3          | Mjr        | Auto      | 6169876541 | Big oh Chevy | 4024007164184797 | 6           | 2018        | 456             | 2727 Walker Ave NW | Walker | Michigan | 49544    | Mjr Auto | Walker, MI, 49544 |

