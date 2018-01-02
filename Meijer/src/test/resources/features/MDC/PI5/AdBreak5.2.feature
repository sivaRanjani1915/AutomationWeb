Feature: AdBreak5.2.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: TC 49365 - [Desktop]:Full Flow Adbreak test Checkout-Edit for SPO order for Sunday AdBreak Store-(Login)
    Given user navigate to test environment URL
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
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
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
#    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Validate the Sunday Ad Break message displayed for SPO
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display

    Examples:
      | zipCode | storeName     | email                  | password  | first_name | last_name | ph_number  | TestCaseID | TestPointID | TestPlanID |
      | 49525   | Knapps Corner | meijer_auto3@email.com | password1 | FirstName  | LastName  | 6169873574 | 45383      | 28564       | 45305      |

  @Zombie
  Scenario Outline: TC 49358 - [DeskTop]Full Flow Adbreak test Checkout-Edit for SPO order for Sunday AdBreak Store-(Guest)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Validate the Sunday Ad Break message displayed for SPO
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display

    Examples:
      | email                | first_name | last_name | ph_number  | email                | TestCaseID | TestPointID | TestPlanID |
      | test645252@gmail.com | test       | test      | 5552991140 | test645252@gmail.com | 45383      | 28552       | 45305      |

  @Zombie
  Scenario Outline: TC 49364 - [Desktop]Full Flow Adbreak test Checkout-Edit for SPO order for Thursday AdBreak Store-(Login)
    Given user navigate to test environment URL
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
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
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout on Shopping Cart page
#    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Validate the thursday Ad Break message displayed for SPO
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '8' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display

    Examples:
      | zipCode | storeName | email                | password   | first_name | last_name | ph_number  | TestCaseID | TestPointID | TestPlanID |
      | 46256   | E 96th St | test645252@gmail.com | 645252test | FirstName  | LastName  | 6169873574 | 45383      | 28561       | 45305      |

  # script needs update to pick a date passed the next ad break
  # does not work if run on thursday for cascade for instance.
  @Zombie
  Scenario Outline: TC 49357 - [DeskTop]Full Flow Adbreak test Checkout-Edit for SPO order for Thursday AdBreak Store-(Guest)
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '46256' and sets store to 'E 96th St'
    Then verify user has correct store 'E 96th St'
    Then validate and reset shopping cart to 0 item
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then user clicks Select Pick Up Time button via checkout
    Then Validate the thursday Ad Break message displayed for SPO
    Then user clicks Select Pick Up Time button via checkout
    Then reserve an available pickup slot at least '24' hours in future and click Reserve button
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display

    Examples:
      | email                | first_name | last_name | ph_number  | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1                | city    | state    | zip_code | TestCaseID | TestPointID | TestPlanID |
      | test645252@gmail.com | test       | test      | 5552991140 | 6011206426044688 | 7           | 3           | 222             | 113 N Washington Square | Lansing | Michigan | 48933    | 45383      | 28549       | 45305      |
