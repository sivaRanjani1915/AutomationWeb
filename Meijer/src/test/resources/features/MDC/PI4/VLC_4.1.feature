#Author: jordan.palma@meijer.com
Feature: VLC_4.1.feature

  Background:
    Then clear all array list

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33143 - Update State for Unavailable Items in Shopping Cart - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    # DEV Configurations
    Then user searches for 'clementine mandarins 3 lbs' in 'DEV' environment
    # UAT Configurations
    Then user searches for 'Cortland Apple' in 'UAT' environment
    Then select item '1' with desire qty '3' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '2' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then user closes notification of unavailable items modal
    Then shopping cart page display
    Then validate state of Unavailable items in Shopping Cart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2    | search2        |
      | 33143 | 30123    | 3070    | 49512   | Cascade   | 49525    | Knapps Corner | cortland apple |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31616 - Update State for Unavailable Items in Shopping Cart - Signed-In
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then select item '1' with desire qty '3' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'
    Then user searches for '<search2>' product
    Then select item '1' with desire qty '2' and Add to Cart
    Then click Cart Icon in Header and click View Cart
    Then shopping cart page display
    Then validate state of Unavailable items in Shopping Cart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then validate state of Unavailable items in Shopping Cart

    Examples:
      | zipCode | storeName     | email                  | password  | search                           | zipCode2 | storeName2 | search2        |
      | 49525   | Knapps Corner | meijer_auto7@email.com | password1 | Clementine Mandarins, Bag, 3 lbs | 49512    | Cascade    | cortland apple |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31466 - Mini-Cart Sort By Newest Item Added - CNC - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'red apple' product
    Then user clicks shop by category option 'Deli' in search results
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      | 31466 | 30910    | 3070    | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31467 - Mini-Cart Sort By Newest Item Added - SPO - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     |
      | 31467 | 30029    | 3070    | 49525   | Knapps Corner |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33142 - Mini-Cart Sort By Newest Item Added - STH - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      | 33142 | 30031    | 3070    | 49428   | Jenison   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31458 - Mini-Cart Sort By Newest Item Added - CNC - Signed-In
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'red apple' product
    Then user clicks shop by category option 'Deli' in search results
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31464 - Mini-Cart Sort By Newest Item Added - SPO - Signed-In
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | zipCode | storeName     | email                  | password  |
      | 49525   | Knapps Corner | meijer_auto4@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33141 - Mini-Cart Sort By Newest Item Added - STH - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate mini-cart sort by newest item added
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | email                  | password  |
      | 33141 | 30032    | 3070    | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31468 - Mini-Cart Sort By Newest Item Added - CNC Fulfillment Group Always At Top - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
    Then user closes miniCart
#    ^^ Validate STH ^^
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
    Then user closes miniCart
#    ^^ Validate SPO & STH ^^
    Then user searches for 'cnc' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO & STH ^^
    Then user removes all 'spo' items from mini-cart
    Then user closes miniCart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
    Then user closes miniCart
#    ^^ Validate CNC & STH
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO & STH ^^
    Then user removes all 'sth' items from mini-cart
    Then user closes miniCart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO ^^
    Then user removes all 'all' items from mini-cart
    Then user closes miniCart

    Examples:
      | zipCode | storeName |
      | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31465 - Mini-Cart Sort By Newest Item Added - CNC Fulfillment Group Always At Top - Signed-In
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
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
    Then user closes miniCart
#    ^^ Validate STH ^^
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate SPO & STH ^^
    Then user closes miniCart
    Then user searches for 'cnc' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO & STH ^^
    Then user removes all 'spo' items from mini-cart
    Then user closes miniCart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & STH
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO & STH ^^
    Then user removes all 'sth' items from mini-cart
    Then user closes miniCart
    Then user opens mini-cart
    Then validate fulfillment group order in mini-cart
#    ^^ Validate CNC & SPO ^^
    Then user removes all 'all' items from mini-cart
    Then user closes miniCart

    Examples:
      | zipCode | storeName     | email                  | password  |
      | 49525   | Knapps Corner | meijer_auto5@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - BAG
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'apple' product
    Then select '2' item '2' qty with desired 'bag' UOM message
    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - EA
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for 'apple' product
    Then select '2' item '2' qty with desired 'ea' UOM message
    Examples:
      | email                  | password  |
      | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - LB
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'ham' product
    Then select '1' item '3.75' qty with desired 'lb' UOM message
    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - PKG
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'alt_uom:ea' product
    Then user clicks shop by category option 'Meat' in search results
    Then select '2' item '2' qty with desired 'pkg' UOM message
    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - STH
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select '2' item '1' qty with desired '' UOM message
    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Signed-In - SPO
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select '1' item '2' qty with desired '' UOM message
    Examples:
      | zipCode | storeName | email                  | password  |
      | 49512   | Cascade   | meijer_auto7@email.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Guest - BAG
#    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'apple' product
    Then select '2' item '2' qty with desired 'bag' UOM message
    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      |       |          | 3070    | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page  Alt_UoM Count Update - Desktop - Guest - EA
#    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'apple' product
    Then select '2' item '2' qty with desired 'ea' UOM message
    Then user searches for 'apple' product
    Then at random, click on a 'ea' product to view its PDP
    Then user add '4' product via PDP page

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      |       |          | 3070    | 49525   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Guest - LB
#    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'ham' product
    Then select '1' item '3.75' qty with desired 'lb' UOM message
    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      |       |          | 3070    | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Guest - PKG
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'alt_uom:ea' product
    Then user clicks shop by category option 'Meat' in search results
    Then select '2' item '2' qty with desired 'pkg' UOM message
    Examples:
      | zipCode | storeName |
      | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Guest - STH
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select '2' item '1' qty with desired '' UOM message
    Examples:
      | zipCode | storeName |
      | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: Mini-Cart & Shopping Cart Page Alt_UoM Count Update - Desktop - Guest - SPO
#    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select '1' item '2' qty with desired '' UOM message
    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName |
      |       |          | 3070    | 49512   | Cascade   |
