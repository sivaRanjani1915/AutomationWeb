Feature:

  @Zombie
  Scenario Outline: Edit Order - Searching in the add an item modal does not redirect user
#login
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for 'banana' product
    Then user adds '1' of one product to cart
#drop timeslot
    When user searches '49512' and sets store to 'Cascade'
#checkout
    Then click Cart Icon in Header and click View Cart
    Then click Checkout on Shopping Cart page
#pickup page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then select next day first day available Pickup slot
    Then user clicks Select Pick Up Time button via checkout
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click Next button on order flow
#billing page
    Then billing page display
    Then user select existing Credit Card for providing payment info '232'
    Then click edit pickup time link on Billing Page
    Then select next day first day available Pickup slot
    Then click edit pickup time link on Billing Page
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click Next button on order flow
#order review page
    Then order review page display
    Then click edit pickup time link on Order Review Page
    Then select next day first day available Pickup slot
    Then click edit pickup time link on Order Review Page
    Then validate pickup time modal - With Reservation
    Then user close edit pickup time modal
    Then click on Place Order
#complete checkout
    Then confirm page display
    Then user clicks edit order button on order confirmation page
    Then user stores edit order page url
    Then user click on plusAdd an Item option
    Then user searches for '' on add item modal on edit order screen
    Then verify Add an Item search was not performed
    Then verify user is NOT redirected to another page


    Examples:
      | email          | password | string    | zipCode | storeName |
      | zod@meijer.com | d3stroys | 834602639 | 49512   | Cascade   |







