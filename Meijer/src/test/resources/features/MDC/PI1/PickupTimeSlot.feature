#Author: Pritam.Maibam@meijer.com
Feature: PickupTimeSlot.feature

  Background:
    Then clear all array list

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2001 - Sign-In - Active Order Widget
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
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
    Then validate order date display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message

    #Then validate order status after successfully cancelled order
    Examples:
      | str_zipCode | store_name    | email                    | password  | cnc_item | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | 49525       | Knapps Corner | pritest_auto17@gmail.com | Selenium1 | Apple    | 1       | 1        | PritestQ   | SelAutoQ  | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2081 - Slot Reservatoin - Store Change - Header - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate timeslot Reserved Until is displayed
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate Header widget drops your current reservation hold
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | str_zipCode | store_name | str_zipCode1 |
      | pritest_auto18@gmail.com | Selenium1 | 49525       | cacasde    | 49512        |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2082 - Slot Reservatoin - Store Change - Checkout Flow - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then select Edit link to Change Store on Pickup Page
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then shopping cart page display
    Then validate Header widget drops your current reservation hold
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | store_name | str_zipCode | str_zipCode1 |
      | pritest_auto18@gmail.com | Selenium1 | Apple    | 1       | 1        | Casecade   | 49512       | 49525        |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2083 - Slot Reservatoin - Store Change - Footer - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then select Store Locator from Footer
    Then select MI icon from map on Store Locator Pge
    Then Select a Curbside Enabled Store from Store Locator Page
    Then validate Header widget drops your current reservation hold
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | str_zipCode |
      | pritest_auto18@gmail.com | Selenium1 | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1976 - Customers Reserved Slot Displayed on Checkout Flow - Pickup Slot Pg - NON-SPO - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate pre-selected time slot HOLD display correct

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | str_zipCode |
      | pritest_auto19@gmail.com | Selenium1 | Apple    | 1       | 1        | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1980 - Customers Reserved Slot Displayed on Checkout Flow -> Pickup Slot Pg - NON-SPO & SPO - Sign-In
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
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then select Available time Slot 2Days Later to Place HOLD a Slot
    Then select Reserve Time button
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate pickup time drop reserved drop

    Examples:
      | email                    | password  | store_name    | str_zipCode | cnc_item | no_item | item_qty | spo_item                  | item_count | str_zipCode |
      | pritest_auto19@gmail.com | Selenium1 | Knapps Corner | 49525       | Apple    | 1       | 1        | Meijer Classic Party Tray | 2          | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1984 - Edit Modifies Time Slot - NON-SPO - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate pre-selected time slot HOLD display correct
    Then user click on change link to edit Pickup Time
    Then validate Pickup Time modal display
    Then validate current hold slot display correctly
    Then validate user is able to select a new pickup date
    Then user close edit pickup time popup window

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | str_zipCode |
      | pritest_auto54@gmail.com | Selenium1 | Apple    | 1       | 1        | 49512       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1987 - Edit Modifies Time Slot - NON-SPO & SPO - Sign-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate pre-selected time slot HOLD display correct
    Then user click on change link to edit Pickup Time
    Then validate Pickup Time modal display
    Then validate current hold slot display correctly
    Then validate user is able to select a new pickup date
    Then user close edit pickup time popup window

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | spo_item                  | item_count | str_zipCode | store_name    |
      | pritest_auto19@gmail.com | Selenium1 | Apple    | 1       | 1        | Meijer Classic Party Tray | 2          | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2125 - Checkout Flow - Time Slot Modal Copy in the Selected Reserved Slot - NON-SPO & SPO - Sign-In
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
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then validate Pickup Time modal display
    Then validate user is able to select a new pickup date
    Then user close edit pickup time popup window

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | spo_item                  | item_count | str_zipCode | store_name    |
      | pritest_auto19@gmail.com | Selenium1 | Apple    | 1       | 1        | Meijer Classic Party Tray | 2          | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 400 - Guest customers can see earliest available time slot - However cannot reserve them upfront
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate timeslot available display contents of curbside wizard
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then compare first available time Slot is same as displayed in curbside wizard

    Examples:
      | email                    | password  | str_zipCode | store_name |
      | pritest_auto47@gmail.com | Selenium1 | 49512       | Cascade    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 402 - Only Sign-in Users Can Reserve Curbside Pickup Slots - Anonymous
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate timeslot available display contents of curbside wizard
    And user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then compare first available time Slot is same as displayed in curbside wizard

    Examples:
      | email                    | password  | store_name    | str_zipCode | store_name    |
      | pritest_auto47@gmail.com | Selenium1 | Knapps Corner | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 823 - Only Sign-in Users Can Reserve Curbside Pickup Slots - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate past orders and Quick shop links display
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                    | password  | store_name    | str_zipCode |
      | 823   | 30040    | 3070    | pritest_auto47@gmail.com | Selenium1 | Knapps Corner | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1663 - Slot Reserved are Persistent Across Multiple devices as long as the reservation is valid
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate timeslot Reserved Until is displayed

    Examples:
      | email                    | password  | store_name    | str_zipCode |
      | pritest_auto48@gmail.com | Selenium1 | Knapps Corner | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 638 - Reserving - Persistent in the header - Signed-In
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate timeslot available display contents of curbside wizard
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then compare first available time Slot is same as displayed in curbside wizard
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then user searches for '<any_item>' product
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | store_name | str_zipCode | any_item     | tier1 | tier2   | tier3    | tier4       |
      | pritest_auto20@gmail.com | Selenium1 | Cascade    | 49512       | Sleeping Bag | Home  | Kitchen | Bakeware | Baking Sets |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 412 - Customer chooses a day/time to reserve a slot (allow order up to 5 business days in advance)-Desktop
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then validate user is allow upto additional 5 business days for advanced pickup time selection

    Examples:
      | email                    | password  | str_zipCode | store_name    |
      | pritest_auto21@gmail.com | Selenium1 | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 306 - Reserving time slot - Before adding an item to cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                    | password  | str_zipCode | store_name    |
      | 306   | 30113    | 3070    | pritest_auto21@gmail.com | Selenium1 | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 307 - Reserving time slot - After adding an item to cart
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then select '<no_item_toselect>' item '1' qty with desired 'ea' UOM message
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button

    Examples:
      | email                    | password  | str_zipCode | store_name    | tier1   | tier2   | tier3 | no_item_toselect |
      | pritest_auto49@gmail.com | Selenium1 | 49525       | Knapps Corner | Grocery | Produce | Fruit | 1                |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 305 - Reserving a time slot option - Persistent in the header anytime during shopping
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate timeslot available display contents of curbside wizard
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<any_item1>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then select pickup slot for same day
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then user click Edit Cart on Order Reveiew Page
    Then shopping cart page display
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then user searches for '<any_item2>' product
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | str_zipCode | store_name    | any_item1  | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code | any_item2 |
      | pritest_auto22@gmail.com | Selenium1 | 49525       | Knapps Corner | shower gel | 1       | 1        | PritestV   | SelAutoV  | 4055060000000000 | 12          | 2           | 222             | 3874 PAXTON AVE | Cincinnati | Ohio  | 45209    | Potatoes  |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 394 - Curbside Pickup Slots are Reserved upto the rounded up Value - Aonymous
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate timeslot available display contents of curbside wizard
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then compare first available time Slot is same as displayed in curbside wizard

    Examples:
      | email                    | password  | str_zipCode | store_name |
      | pritest_auto21@gmail.com | Selenium1 | 49534       | Standale   |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 397 - Expiration time displayed and Actual slot Reservation time are consistent in the header, pickup slot selector, and backend - No Item(s)
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
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate timeslot Reserved Until is displayed

    Examples:
      | email                    | password  | store_name    | str_zipCode |
      | pritest_auto50@gmail.com | Selenium1 | Knapps Corner | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 448 - Reserving time slot - After adding an item to cart - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select '<no_item_toselect>' item '1' qty with desired 'ea' UOM message
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                    | password  | store_name    | str_zipCode | tier1   | tier2   | tier3 | tier4   | no_item_toselect |
      | 448   | 30112    | 3070    | pritest_auto20@gmail.com | Selenium1 | Knapps Corner | 49525       | Grocery | Produce | Fruit | Bananas | 1                |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 641 - Reserving - Persistent in the header - Anonymous
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then user searches for '<any_item>' product
    Then validate Sign In to Reserve A time Slot text on curbside wizard

    Examples:
      | str_zipCode | store_name    | any_item | tier1   | tier2  | tier3             | tier4       |
      | 49525       | Knapps Corner | Bottle   | Grocery | Frozen | Frozen Vegetables | Frozen Peas |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 771 - Display We Will Hold Until time on each slot in the timeslot selector - Checkout flow - Sign-In
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then select '<no_item_toselect>' item '1' qty with desired 'ea' UOM message
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then validate content of each slot on Pickup Timeslot wizard

    Examples:
      | email                    | password  | store_name    | str_zipCode | tier1   | tier2   | tier3 | tier4   | no_item_toselect |
      | pritest_auto51@gmail.com | Selenium1 | Knapps Corner | 49525       | Grocery | Produce | Fruit | Bananas | 1                |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1182 - Reserve Curbside Pickup Time is displayed Once Customer Signs-In - Anonymous
    And the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    When user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then close Pickup Timeslot pop up window
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | email                    | password  | str_zipCode | store_name    | TC_ID | POINT_ID | PLAN_ID |
      | pritest_auto21@gmail.com | Selenium1 | 49525       | Knapps Corner | 1182  | 30013    | 3070    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1213 - Past Orders Link Displays - Sign-In
    And the user sets testcase configurations '1213' '64670' '3070'
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
    Then validate past orders and Quick shop links display
    Then click on Past Order link display on Curbside Wizard
    Then validate Past Order Summary Page display
    Then click on Quick Shop link on Curbside Wizard
    Then validate Quick Shop Page display

    Examples:
      | email                    | password  | str_zipCode | store_name |
      | pritest_auto21@gmail.com | Selenium1 | 49512       | Cascade    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1214 - Past Orders Link Does Not Display - Anonymous
    And the user sets testcase configurations '1214' '64671' '3070'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate Links Past Order not display

    Examples:
      |   |
      |   |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1216 - Quick Shop Link Does Not Display - Anonymous
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then validate Sign In to Reserve A time Slot text on curbside wizard
    Then validate Links Quick Shop not display

    Examples:
      | str_zipCode | TC_ID     | POINT_ID | PLAN_ID |
      | 49525       | TC_ID1216 | 340      | 966     |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1215 - Quick Shop Link Displays - Sign-In
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then validate past orders and Quick shop links display
    Then click on Quick Shop link on Curbside Wizard
    Then validate Quick Shop Page display

    Examples:
      | email                    | password  | TC_ID     | POINT_ID | PLAN_ID | str_zipCode | store_name |
      | pritest_auto21@gmail.com | Selenium1 | TC_ID1215 | 339      | 966     | 49512       | Cascade    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1225 - Expiration Time is consistent with Time Slot selected
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then select FIRST available pickup time slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate timeslot Reserved Until is displayed

    Examples:
      | email                    | password  | store_name    | str_zipCode |
      | pritest_auto23@gmail.com | Selenium1 | Knapps Corner | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1121 - Expiration time displayed and Actual slot Reservation time are consistent in the header, pickup slot selector, and backend - With Item(s)
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate timeslot Reserved Until is displayed

    Examples:
      | email                    | password  | tier1   | tier2   | tier3 | tier4  | no_item | item_qty | store_name    | str_zipCode |
      | pritest_auto52@gmail.com | Selenium1 | Grocery | Produce | Fruit | Apples | 1       | 1        | Knapps Corner | 49525       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1560 - Time Slot Reserved - Store Locator From FOOTER - Dynamic Warning Text
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then select Store Locator from Footer
    Then select MI icon from map on Store Locator Pge
    Then Select a Curbside Enabled Store from Store Locator Page
    Then validate Header widget drops your current reservation hold
    Then validate curbside display Reserve Curbside Pickup Time Text

    Examples:
      | email                    | password  | str_zipCode | store_name    |
      | pritest_auto18@gmail.com | Selenium1 | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1564 - Time Slot Reserved - Store Locator From Header - Dynamic Warning Text
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then validate DATE and TIME display under curbside widget via Home page
    Then user click change store from the account header
    Then validate the warning note display to drop Curbside Reservation on Select Store screen

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                    | password  | str_zipCode | store_name    |
      | 1564  | 30024    | 3070    | pritest_auto18@gmail.com | Selenium1 | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1568 - Time Slot Reserved - Store Locator From Checkout Flow - Dynamic Warning Text
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then user searches for '<cnc_item>' product
    Then select item '<no_item>' with desire qty '<item_qty1>' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then select Edit link to Change Store on Pickup Page
    Then validate the warning note display to drop Curbside Reservation on Select Store screen

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty1 | str_zipCode | store_name |
      | pritest_auto33@gmail.com | Selenium1 | Orange   | 1       | 1         | 49512       | Cascade    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1641 - Stores Time Zone Consistent - ET/CT Time Zone - Search using store zipcode
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode1>' and sets store to '<store_name1>'
    Then verify user has correct store '<store_name1>'
    Then validate Time Zone display in Eastern Time
    When user searches '<str_zipCode2>' and sets store to '<store_name2>'
    Then verify user has correct store '<store_name2>'
    Then validate Time Zone display in Central Time Zone

    Examples:
      | email                    | password  | store_name1 | str_zipCode1 | store_name2      | str_zipCode2 |
      | pritest_auto28@gmail.com | Selenium1 | Cascade     | 49512        | Champaign/Urbana | 61821        |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1644 - Slot Reserved - Stores Time Zone Consistent - CT Time Zone - Sign-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    #Then validate Time Zone display in Curbside Pickup Time after Slot Reserved
    Then validate curbside header display TimeZone as Central Time

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                    | password  | store_name       | str_zipCode |
      | 1644  | 30023    | 3070    | pritest_auto34@gmail.com | Selenium1 | Champaign/Urbana | 61821       |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1645 - Stores Time Zone Consistent - CT/ET Time Zone - Search using city and State
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode1>' and sets store to '<store_name1>'
    Then verify user has correct store '<store_name1>'
    Then validate Time Zone display in Central Time Zone
    When user searches '<str_zipCode2>' and sets store to '<store_name2>'
    Then verify user has correct store '<store_name2>'
    Then validate Time Zone display in Eastern Time

    Examples:
      | str_zipCode1 | store_name1      | str_zipCode2 | store_name2 |
      | 61821        | Champaign/Urbana | 49534        | Standale    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2027 - Checkout Flow - Time Slot Modal Copy Change - NON-SPO - Sign-In
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
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate content of each Pickup Time slot on Pickup page
    Then Randomly Highlight an available TimeSlot
    Then validate Button Text is Select Pickup Time
    Then select Reserve Time button
    Then validate user Selected Pickup Time display correct
    Then user return to Meijer Home Page
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | str_zipCode | store_name | str_zipCode1 | store_name1   |
      | pritest_auto36@gmail.com | Selenium1 | Apple    | 1       | 1        | 49512       | Cascade    | 49525        | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2030 - Checkout Flow - Time Slot Modal Copy Change - NON-SPO & SPO - Sign-In
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
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then validate content of each Pickup Time slot on Pickup page
    Then Randomly Highlight an available TimeSlot
    Then validate Button Text is Select Pickup Time
    Then select Reserve Time button
    Then validate user Selected Pickup Time display correct
    Then user return to Meijer Home Page
    Then user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'

    Examples:
      | email                    | password  | cnc_item | no_item | item_qty | spo_item                  | no_item | str_zipCode | store_name    |
      | pritest_auto39@gmail.com | Selenium1 | Apple    | 1       | 1        | Meijer Classic Party Tray | 1       | 49525       | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2033 - Checkout Flow - Time Slot Modal Copy Change - NON-SPO - Anonymous
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
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then validate content of each Pickup Time slot on Pickup page
    Then Randomly Highlight an available TimeSlot
    Then validate Button Text is Select Pickup Time
    Then select Reserve Time button
    Then validate user Selected Pickup Time display correct

    Examples:
      | str_zipCode | store_name | cnc_item | no_item | item_qty | str_zipCode1 | store_name1   |
      | 49512       | Cascade    | Banana   | 1       | 1        | 49525        | Knapps Corner |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2036 - Checkout Flow - Time Slot Modal Copy Change - NON-SPO & SPO - Anonymous
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<store_name>'
    Then verify user has correct store '<store_name>'
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    #Then user Browse through Shop and select Create a Cake
    #Then custom Cake Landing page display
    #Then user Click Create This Cake on a Theme Cake
    #Then user Select mandatory attributes on Custom Cake '<indexof_size>' '<indexof_flavor>' '<icingIdx_FrostType>' '<icingIdx_FrostFlvr>'
    #And select optional attributes on Custom Cake '<idx_filling>' '<idx_topbordrclr>' '<idx_btmbordrclr>' '<txt_custmsg>' '<idx_custmsgclr>' '<txtspcInstrmsg>'
    #Then user click on Add to Cart for design cake
    Then user searches for '<item_tosearch>' product
    Then select item '<no_item_toselect>' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then validate content of each Pickup Time slot on Pickup page
    Then Randomly Highlight an available TimeSlot
    Then validate Button Text is Select Pickup Time
    Then select Reserve Time button
    Then validate user Selected Pickup Time display correct

    Examples:
      | str_zipCode | store_name    | cnc_item | no_item | item_qty | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | idx_filling | idx_topbordrclr | idx_btmbordrclr | txt_custmsg   | idx_custmsgclr | txtspcInstrmsg   | item_tosearch             | no_item_toselect |
      | 49525       | Knapps Corner | Orange   | 1       | 1        | 4            | 2              | 1                  | 0                  | 5           | 6               | 7               | auto cake msg | 8              | Auto Special Msg | Meijer Classic Party Tray | 1                |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 2959 - Curbside Only Cart - Add SPO
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
    Then user searches for '<cnc_item>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then Select Randomly Available time Slot to Place HOLD a Slot
    Then select Reserve Time button
    Then validate DATE and TIME display under curbside widget via Home page
    Then validate timeslot Reserved Until is displayed
    Then user searches for '<spo_item>' product
    Then select item '<no_item>' with desire qty '1' and Add to Cart
    Then validate Header widget drops your current reservation hold
    Then validate curbside display Reserve Curbside Pickup Time Text
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time

    #Then validate user is allow upto additional 5 business days for advanced pickup time selection
    Examples:
      | str_zipCode | store_name    | email                    | password  | cnc_item | no_item | item_qty | spo_item                  |
      | 49525       | Knapps Corner | pritest_auto46@gmail.com | Selenium1 | Banana   | 1       | 1        | Meijer Classic Party Tray |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 3003 - SPO-Only Cart Time Slot Modal Behavior
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
    Then user click on Add to Cart for design cake
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then Pickup Timeslot pop up window display
    Then validate First timeslot display with minimum 24 hrs lead time
    And validate Max 30 days slider display for SPO only item

    Examples:
      | email                    | password  | indexof_size | indexof_flavor | icingIdx_FrostType | icingIdx_FrostFlvr | str_zipCode | store_name |
      | pritest_auto46@gmail.com | Selenium1 | 4            | 1              | 1                  | 1                  | 49512       | Casacde    |
