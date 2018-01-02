Feature: eliminateBestPricing.feature

  Background:
    Then clear all array list

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on product tiles when tier2 browsing
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
    Then user navigates Shop to '<tier1>' to '<tier1>' submenu Tier2
    Then verify weight messaging is not present on product tile

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on product tiles when tier3 browsing
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
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify weight messaging is not present on product tile

    Examples:
      | email               | password  | tier1   | tier2   | tier3 | tier4 |
      | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit |       |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on product tiles when tier4 browsing
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
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify weight messaging is not present on product tile

    Examples:
      | email               | password  | tier1   | tier2   | tier3 | tier4   |
      | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit | Bananas |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on product tiles when searching
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
    When user searches for '<productType>' product
    Then verify weight messaging is not present on product tile

    Examples:
      | email               | password  | productType        |
      | matt_auto@gmail.com | password1 | is_random_weight:1 |

#TODO: matt - find Test Case id in eliminatedBestPricing.feature
  @PI3
  @OUT_DATED
  @WIP
  Scenario Outline: weight messaging is present on product display page
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then verify weight messaging is present on product display page
    Then verify weight disclaimer is present on product display page

    Examples:
      | email               | password  | productType        |
      | matt_auto@gmail.com | password1 | is_random_weight:1 |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on mini cart
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then user opens mini-cart
    Then verify weight disclaimer is present in mini cart

    Examples:
      | email               | password  | productType        | no_item | item_qty |
      | matt_auto@gmail.com | password1 | is_random_weight:1 | 1       | 1        |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on cart page
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then verify weight disclaimer is present in cart

    Examples:
      | email               | password  | productType        | no_item | item_qty |
      | matt_auto@gmail.com | password1 | is_random_weight:1 | 1       | 1        |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on pickup
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then click Checkout on Shopping Cart page
    Then verify weight disclaimer is present in checkout

    Examples:
      | email                | password  | productType        | no_item | item_qty |
      | matt_auto1@gmail.com | password1 | is_random_weight:1 | 1       | 1        |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on billing
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then verify weight disclaimer is present in checkout

    Examples:
      | email                | password  | productType        | no_item | item_qty |
      | matt_auto2@gmail.com | password1 | is_random_weight:1 | 1       | 1        |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on Order Review
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then click Checkout on Shopping Cart page
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then verify weight disclaimer is present in order review

    Examples:
      | email                | password  | productType        | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | matt_auto3@gmail.com | password1 | is_random_weight:1 | 1       | 1        | Mattb      | Auto      | 5444009999222205 | 12          | 2018        | 222             | 3875 Paxton Ave | Cincinnati | Ohio  | 45209    |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on confirm
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then click Checkout on Shopping Cart page
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then verify weight disclaimer is present in order review

    Examples:
      | email                | password  | productType        | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | matt_auto4@gmail.com | password1 | is_random_weight:1 | 1       | 1        | Mattc      | Auto      | 5444009999222205 | 12          | 2018        | 222             | 3875 Paxton Ave | Cincinnati | Ohio  | 45209    |

  @PI3
  @OUT_DATED
  Scenario Outline: weight messaging is not present on edit order
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
    When user searches for '<productType>' product
    Then at random, click on a product to view its PDP
    Then user add '<item_qty>' product via PDP page
    Then click Cart Icon in Header and click View Cart
#	Then click Checkout on Mini Cart
    Then click Checkout on Shopping Cart page
    Then Select Randomly any Available time Slot
    Then click Next button on order flow
    Then user Enter Full Payment info details '<first_name>' '<last_name>' '<cc_number>' '<idx_ccexpmn>' '<idx_ccexpyr>' '<cc_securityCode>' '<address1>' '<city>' '<state>' '<zip_code>'
    Then click Next button on order flow
    Then order review page display
    Then click on Place Order
    Then confirm page display
    Then note down order number after order placed
    Then user click Return Home button on confirm page
    Then user click Edit Order link in Curbside Widget
    Then order history details page display
    Then validate order number display
    Then validate order status display
    Then validate order date display
    Then user click on Cancel Order link
    Then user click Cancel My Order Button on Order Cancel Confirmation Message
    Then verify weight disclaimer is present in edit order

    Examples:
      | email                | password  | productType        | no_item | item_qty | first_name | last_name | cc_number        | idx_ccexpmn | idx_ccexpyr | cc_securityCode | address1        | city       | state | zip_code |
      | matt_auto5@gmail.com | password1 | is_random_weight:1 | 1       | 1        | Mattd      | Auto      | 5444009999222205 | 12          | 2018        | 222             | 3875 Paxton Ave | Cincinnati | Ohio  | 45209    |

