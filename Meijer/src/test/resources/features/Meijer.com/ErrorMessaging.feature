#Author: jordan.palma@meijer.com
Feature: Generic Regression - Error Messaging

  Background:
    Then clear all array list

#  /*-------------------- Sign-In --------------------*/

  @ErrorMge
  Scenario Outline: RTC001 - Validating Error Messaging - Sign-In - Quantity - Eaches Search Results
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then user verify tool tip error messaging '/EA'

    Examples:
      | str_zipCode | email                  | password  | zipCode | storeName     | cnc_item |
      | 49512       | meijer_auto6@email.com | password1 | 49525   | Knapps Corner | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49512   | Cascade       | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49428   | Jenison       | ham      |

  @ErrorMge321
  Scenario Outline: RTC002 - Validating Error Messaging - Sign-In - Quantity - Eaches PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then user verify tool tip error messaging via PDP page '/EA'

    Examples:
      | str_zipCode | email                  | password  | zipCode | storeName     | cnc_item |
      | 49512       | meijer_auto6@email.com | password1 | 49525   | Knapps Corner | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49512   | Cascade       | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49428   | Jenison       | ham      |

  @ErrorMge
  Scenario Outline: RTC003 - Validating Error Messaging - Sign-In - Quantity - Weight Search Results
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then user verify tool tip error messaging '/LB'

    Examples:
      | str_zipCode | email                  | password  | zipCode | storeName     | cnc_item |
      | 49512       | meijer_auto6@email.com | password1 | 49525   | Knapps Corner | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49512   | Cascade       | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49428   | Jenison       | ham      |

  @ErrorMge
  Scenario Outline: RTC004 - Validating Error Messaging - Sign-In - Quantity - Weight PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a 'lb' product to view its PDP
    Then verify display of PDP page
    Then user verify tool tip error messaging via PDP page '/LB'

    Examples:
      | str_zipCode | email                  | password  | zipCode | storeName     | cnc_item |
      | 49512       | meijer_auto6@email.com | password1 | 49525   | Knapps Corner | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49512   | Cascade       | ham      |
      | 49512       | meijer_auto6@email.com | password1 | 49428   | Jenison       | ham      |


#  /*-------------------- Guest --------------------*/

  @ErrorMge
  Scenario Outline: RTC005 - Validating Error Messaging - Guest - Quantity - Eaches Search Results
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then user verify tool tip error messaging '/EA'

    Examples:
      | str_zipCode | cnc_item |
      | 49512       | ham      |
      | 49428       | ham      |
      | 49525       | ham      |

  @ErrorMge
  Scenario Outline: RTC006 - Validating Error Messaging - Guest - Quantity - Eaches PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then user verify tool tip error messaging via PDP page '/EA'

    Examples:
      | str_zipCode | cnc_item |
      | 49512       | ham      |
      | 49428       | ham      |
      | 49525       | ham      |

  @ErrorMge
  Scenario Outline: RTC007 - Validating Error Messaging - Guest - Quantity - Weight Search Results
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then user verify tool tip error messaging '/LB'

    Examples:
      | str_zipCode | cnc_item |
      | 49512       | ham      |
      | 49428       | ham      |
      | 49525       | ham      |

  @ErrorMge
  Scenario Outline: RTC008 - Validating Error Messaging - Guest - Quantity - Weight PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then at random, click on a 'lb' product to view its PDP
    Then verify display of PDP page
    Then user verify tool tip error messaging via PDP page '/LB'

    Examples:
      | str_zipCode | cnc_item |
      | 49512       | ham      |
      | 49428       | ham      |
      | 49525       | ham      |

  @ErrorMge
  Scenario Outline: RTC009 - Validate Error Messaging Checkout Flow - Sign-In
    Given user navigate to test environment URL
    When user searches '<zipCode>' and sets store to '<storeName>'
    When user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then reset shopping cart to 0 item - mini cart
    Then user searches for '<cnc_item>' product
    Then select item '<no_item>' with desire qty '<item_qty>' and Add to Cart
    Then user searches for '<spo_item>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then click Next button on order flow
    Then verify pickup time not selected, time slot modal appears
    Then reserve an available pickup with lead time of '8' hrs for Mixed Cart
    Then clear input values on Pickup Page
    Then click Next button on order flow
    Then verify error messaging on Pickup Page
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then billing page display
    Then click Next button on order flow
    Then verify error messaging on Billing page

    Examples:
      | zipCode | storeName     | email                  | password  | cnc_item                  | no_item | item_qty | spo_item              | first_name | last_name | ph_number  | email                  |
      | 49525   | Knapps Corner | meijer_auto4@email.com | password1 | is_click_and_collect:true | 3       | 1        | is_prepared_item:true | Meijer     | AutoFour  | 6166549317 | meijer_auto4@email.com |
      | 49512   | Cascade       | meijer_auto4@email.com | password1 | is_click_and_collect:true | 3       | 1        | is_prepared_item:true | Meijer     | AutoFour  | 6166549317 | meijer_auto4@email.com |
      | 49428   | Jenison       | meijer_auto4@email.com | password1 | is_click_and_collect:true | 3       | 1        | is_prepared_item:true | Meijer     | AutoFour  | 6166549317 | meijer_auto4@email.com |

