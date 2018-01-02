Feature: JDHsprint-3_4.feature

  Background:
    Then clear all array list

  @Zombie
  Scenario Outline: TC 20363 - Hidden Store Id value in Time Slot Modal - Guest User Signing In
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    And user clicks 'Sign In to Reserve a Time Slot' link
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Pickup Timeslot pop up window display
    Then verify store id in time slot modal
    Then reserve an available pickup slot at least '48' hours in future and click Reserve button

    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto2@email.com | password1 |

  @Zombie
  Scenario Outline: TC 20372 - PDP Product Description in Meta Description
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify product details in meta description

    Examples:
      | zipCode | storeName     | search                    |
      | 49525   | Knapps Corner | is_click_and_collect:true |

  @Zombie
  Scenario Outline: TC 12298 - Validate Schema PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then user view source code
    Then verify PDP schema - name, image, description, price, priceValidUntil

    Examples:
      | zipCode | storeName     | search                    |
      | 49525   | Knapps Corner | is_click_and_collect:true |

  @Zombie
  Scenario Outline: TC 12298 - Validate Schema Store Page
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user clicks Store name in the account header
    Then verify your store page displays
    Then user view source code
    Then verify store page schema - name, address, store hours

    Examples:
      | zipCode | storeName |
      | 49512   | Cascade   |

  @Zombie
  Scenario Outline: TC 20363 - Schedule and Pickup Flow Without Errors - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout as Guest on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify pickup time not selected, time slot modal appears
    Then reserve an available pickup slot at least '5' hours in future and click Reserve button
    Then click Next button on order flow
    Then billing page display

    Examples:
      | zipCode | storeName | search           | first_name | last_name | ph_number  | email               |
      | 49512   | Cascade   | is_sellable:true | FirstName  | LastName  | 6168523214 | testemail@email.com |

  @Zombie
  Scenario Outline: TC 20363 - Schedule and Pickup Flow Without Errors - Signed-In
    Given user navigate to test environment URL
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
    Then user searches for '<search>' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames TotalItemQty and Subtotal
    Then click Checkout on Shopping Cart page
    Then pickup Page display
    Then enter full pickup info details '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then click Next button on order flow
    Then verify pickup time not selected, time slot modal appears
    Then reserve an available pickup slot at least '5' hours in future and click Reserve button
    Then click Next button on order flow
    Then billing page display

    Examples:
      | email                  | password  | zipCode | storeName | search           | first_name | last_name | ph_number  |
      | meijer_auto5@email.com | password1 | 49512   | Cascade   | is_sellable:true | FirstName  | LastName  | 6168523214 |
