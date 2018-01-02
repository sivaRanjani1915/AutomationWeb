Feature: OmsGiftCardRate.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: verify shipping rate for given gift card totals and shipping method
  #Navigate
    Given user navigate to test environment URL
    And the user sets testcase configurations '49174' '28456' '39628'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal

    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    When user searches for 'is_ship_to_home:true' product
    Then user adds '<qty>' of one product to cart

  #checkout
    Then click Cart Icon in Header and click View Cart
    Then click Checkout as Guest on Shopping Cart page

    Then shipping Page display
    Then user Enter Shipping details 'john' 'doe' '3874 PAXTON AVE' 'Cincinnati' 'Ohio' '45209' '5552991102' 'no@no.no'
    Then user enter delivery method shipping information details '<shipping_method>' 'asdfasdfasdf'
    Then click Next button on order flow
    Then billing page display

  ###validate 0 tax, price of gift card, price of shipping and shipping method
    Then validate shipping rate for '<qty>' with shipping method '<shipping_method>'
    Then validate giftcard only order has zero taxes

    Then user Enter Full Payment info details 'john' 'doe' '4111111111111111' '12' '2018' '222' '3874 PAXTON AVE' 'Cincinnati' 'Ohio' '45209'
    Then click Next button on order flow
    Then order review page display

  ###validate 0 tax, price of gift card, price of shipping and shipping method
    Then validate shipping rate for '<qty>' with shipping method '<shipping_method>'
    Then validate giftcard only order has zero taxes

    Then click on Place Order
    Then confirm page display

  ###validate 0 tax, price of gift card, price of shipping and shipping method
    Then validate shipping rate for '<qty>' with shipping method '<shipping_method>'
    Then validate giftcard only order has zero taxes

#    Then user clicks edit order button on order confirmation page
  ###validate 0 tax, price of gift card, price of shipping and shipping method on edit order page
#    Then validate shipping rate for '<qty>' with shipping method '<shipping_method>'
#    Then validate giftcard only order has zero taxes


    Examples:
      | qty   | shipping_method    |
      | 10    | Standard Shipping  |
      | 20    | Standard Shipping  |
      | 40    | Standard Shipping  |
      | 80    | Standard Shipping  |
      | 100   | Standard Shipping  |
      | 1000  | Standard Shipping  |
      | 10000 | Standard Shipping  |
      | 10    | Expedited Shipping |
      | 20    | Expedited Shipping |
      | 40    | Expedited Shipping |
      | 80    | Expedited Shipping |
      | 100   | Expedited Shipping |
      | 1000  | Expedited Shipping |
      | 10000 | Expedited Shipping |
      | 10    | Express Shipping   |
      | 20    | Express Shipping   |
      | 40    | Express Shipping   |
      | 80    | Express Shipping   |
      | 100   | Express Shipping   |
      | 1000  | Express Shipping   |
      | 10000 | Express Shipping   |



