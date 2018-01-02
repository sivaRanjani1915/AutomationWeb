Feature: Timeslots

  @timeslots
  Scenario Outline: Basic Checkout Flow
   #login
    Given user navigate to MeijerDotCom
    When user signs in with '<username>' and '<password>'
   #init
#    When user searches '<zipcode>' and sets store to '<storeName>'				#I AM BROKEN. SHAME ME.
    When user searches '<zipCode>' and sets store to '<storeName>'
   #	When user select desire store '<store_name>' '<zipcode>'
    Then validate and reset shopping cart to 0 item
    Then clear all array list
   #shop
    When user searches for '<productType>' product
    Then user adds '<qty>' of one product to cart
   #checkout
    Then click Cart Icon in Header and click View Cart

   #	Then click Checkout on Shopping Cart page
   #    Then click Next button on order flow

   #	Then select next day first day available Pickup slot
   #    Then pickup Page display
   #	Then click Next button on order flow

   #	Then billing page display
   #	Then user select existing Credit Card for providing payment info '<ccv>'
   #	Then click Next button on order flow

   #	Then order review page display
   #	Then click on Place Order

   #	Then confirm page display
   #	Then user click Return Home button on confirm page

    Examples:
      | username       | password | zipcode | productType | storeName     | qty | ccv |
      | zod@meijer.com | d3stroys | 49085   | cnc         | Benton Harbor | 5   | 444 |
