Feature: AddToCart.feature

  Background:
    Then clear all array list

  @NR_DS_desktop
  Scenario Outline: TC 72863 - Guest Cart Merged to Signed In Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate guest cart merged with signed in user
    Then while on Shopping Cart Page, remove all existing items

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                       | password  |
      | 72863 | 3076    | 3070    | testingnewaccount@email.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 70460 - Add ALL Items From Order History With Slot Reservation - Sign In
    And the user sets testcase configurations '70460' '70476' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user selects 'all' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process

    Examples:
      |  zipCode | storeName     | email                         | password  |
      |  49525   | Knapps Corner | reorderOrderHistory@email.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 70461 - Add ALL Items From Order History Without Slot Reservation - Sign In
    And the user sets testcase configurations '70461' '70477' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user selects 'all' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process

    Examples:
      | zipCode | storeName     | email                         | password  |
      | 49525   | Knapps Corner | reorderOrderHistory@email.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 70545 - Add Select Items From Order History With Slot Reservation - Sign In
    And the user sets testcase configurations '70545' '70493' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user selects '5' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process

    Examples:
      | zipCode | storeName     | email                         | password  |
      | 49525   | Knapps Corner | reorderOrderHistory@email.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 70546 - Add Select Items From Order History Without Slot Reservation - Sign In
    And the user sets testcase configurations '70546' '70494' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigate to Order History from the account header
    Then order history summary page display
    Then user click on view option next to order just placed
    Then order history details page display
    Then user selects 'all' items for Reordering
    Then validate whether Reorder Items button is enabled
    Then click on Reorder Item button
    Then validate Reorder Item pop up look and feel
    Then click Add items to cart on Reorder Items pop up
    Then user opens mini-cart
    Then user clicks Checkout button via Mini-Cart
    Then shopping cart page display
    Then validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process

    Examples:
      |  zipCode | storeName     | email                         | password  |
      |  49525   | Knapps Corner | reorderOrderHistory@email.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 96022 - Add Choking Hazard - Tile
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'Games & Puzzles' product
    Then user adds 'choking hazard' item with qty '2'
    Then validate choking hazard popup message display
    Then user selects 'Return to Shopping' on choking hazard popup
    Then user adds 'choking hazard' item with qty '1'
    Then validate choking hazard popup message display
    Then user selects 'Add To Cart' on choking hazard popup

    Examples:
      |  |
      |  |

  ###############################
  # Add Product to Cart via PDP #
  ###############################
  @NR_DS_desktop
  Scenario Outline: TC 95250 - Add 'EA' items to cart - PDP
    And the user sets testcase configurations '95250' '116942' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'apple' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then user add '4' product via PDP page

    Examples:
      | |
      | |

  @NR_DS_desktop
  Scenario Outline: TC 95251 - Add 'LB' items to cart - PDP
    And the user sets testcase configurations '95251' '116943' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'ham' product
    Then at random, click on a 'lb' product to view its PDP
    Then verify display of PDP page
    Then user add '2.50' product via PDP page

    Examples:
      |  |
      |  |

  @NR_DS_desktop
  Scenario Outline: TC 95252 - Add SPO items to cart - PDP
    And the user sets testcase configurations '95252' '116944' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'spo' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then user add '3' product via PDP page

    Examples:
      | |
      | |

  @NR_DS_desktop
  Scenario Outline: TC 96021 - Add Choking Hazard - PDP
    And the user sets testcase configurations '96021' '117358' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'Games & Puzzles' product
    Then at random, click on an 'chokingHazard' product to view its PDP
    Then verify display of PDP page
    Then user add '4' product via PDP page

    Examples:
      |  |
      |  |

  ###############################
  # Product Qty Error Messaging #
  ###############################
  @NR_DS_desktop
  Scenario Outline: TC 95253 - Verify Error Message 'EA' item - Tile
    And the user sets testcase configurations '95253' '116945' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'apple' product
    Then user verify tool tip error messaging '/EA'

    Examples:
      | |
      | |

  @NR_DS_desktop
  Scenario Outline: TC 95254 - Verify Error Message 'EA' item - PDP
    And the user sets testcase configurations '95254' '116946' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'apple' product
    Then at random, click on a 'ea' product to view its PDP
    Then user verify tool tip error messaging via PDP page '/EA'

    Examples:
      |  |
      |  |

  @NR_DS_desktop
  Scenario Outline: TC 95256 - Verify Error Message 'LB' item - Tile
    And the user sets testcase configurations '95256' '116947' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'ham' product
    Then user verify tool tip error messaging '/LB'

    Examples:
      | |
      | |

  @NR_DS_desktop
  Scenario Outline: TC 95257 - Verify Error Message 'LB' item - PDP
    And the user sets testcase configurations '95257' '116948' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'ham' product
    Then at random, click on a 'lb' product to view its PDP
    Then user verify tool tip error messaging via PDP page '/LB'

    Examples:
      | |
      | |


###############################################
# Slot Reservation Conflict with Product Type #
###############################################
  # Add To Cart Button #
  ######################
  @NR_DS_desktop
  Scenario Outline: TC 99781 - Reserve CNC Slot - Add SPO - Continue, Add To Cart Button - Sign In
    And the user sets testcase configurations '99781' '119140' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99782 - Reserve CNC Slot - Add SPO - Continue, Add To Cart Button - SSI
    And the user sets testcase configurations '99782' '119141' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99783 - Reserve SPO Slot - Add CNC - Continue, Add To Cart Button - Sign In
    And the user sets testcase configurations '99783' '119142' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99784 - Reserve SPO Slot - Add CNC - Continue, Add To Cart Button - SSI
    And the user sets testcase configurations '99784' '119143' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks continue, add item to cart button
    Then validate cart update and reserved slot is dropped

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  ############################
  # Leave Out of Cart Button #
  ############################
  @NR_DS_desktop
  Scenario Outline: TC 99785 - Reserve CNC Slot - Add SPO - Leave Out of Cart Button - Sign In
    And the user sets testcase configurations '99785' '119144' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks leave out of cart button

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99787 - Reserve CNC Slot - Add SPO - Leave Out of Cart Button - SSI
    And the user sets testcase configurations '99787' '119145' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding SPO item warning message display
    Then user clicks leave out of cart button

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99788 - Reserve SPO Slot - Add CNC - Leave Out of Cart Button - Sign In
    And the user sets testcase configurations '99788' '119146' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks leave out of cart button

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 99789 - Reserve SPO Slot - Add CNC - Leave Out of Cart Button - SSI
    And the user sets testcase configurations '99789' '119147' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user opens mini-cart
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then In Curbside Widget, user clicks Reserve Curbside Pickup Time
    Then at random, reserve an available pick up time and click Reserve button
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    Then validate adding CNC item warning message display
    Then user clicks leave out of cart button

    Examples:
      | email                     | password  | zipCode | storeName     |
      | testActiveOrder@email.com | password1 | 49525   | Knapps Corner |


  #//TODO: come back to finish
  @ButtonTest1
  Scenario Outline: TC 50751 - Add To Cart - All Alt_UoM:ea Products
  #    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'alt_uom:ea' product
    Then user view page '<pageIndex>' of search results
    Then validate each product tile button functionality

    Examples:
      | TC_ID                               | POINT_ID | PLAN_ID | zipCode | storeName     | pageIndex |
      | AddToCart_50696_AltUoM.EA_page1_iOS | 30204    | 3070    | 49525   | Knapps Corner |           |
      | AddToCart_50728_AltUoM.EA_page2_iOS | 30475    | 3070    | 49525   | Knapps Corner | 2         |
      | AddToCart_50744_AltUoM.EA_page3_iOS | 30485    | 3070    | 49525   | Knapps Corner | 3         |
      | AddToCart_50745_AltUoM.EA_page4_iOS | 30486    | 3070    | 49525   | Knapps Corner | 4         |
      | AddToCart_50746_AltUoM.EA_page5_iOS | 30487    | 3070    | 49525   | Knapps Corner | 5         |
      | AddToCart_50747_AltUoM.EA_page6_iOS | 30488    | 3070    | 49525   | Knapps Corner | 6         |
      | AddToCart_50748_AltUoM.EA_page7_iOS | 30489    | 3070    | 49525   | Knapps Corner | 7         |
      | AddToCart_50749_AltUoM.EA_page8_iOS | 30490    | 3070    | 49525   | Knapps Corner | 8         |
      | AddToCart_50750_AltUoM.EA_page9_iOS | 30491    | 3070    | 49525   | Knapps Corner | 9         |

#########################
# IS_RANDOM_WEIGHT:TRUE #
#########################
  @ButtonTest
  Scenario Outline: TC 50751 - Add To Cart - All is_random_weight:true Products
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'is_random_weight:true' product
    Then user view page '<pageIndex>' of search results
    Then validate each product tile button functionality

    Examples:
      | TC_ID                                        | POINT_ID | PLAN_ID | zipCode | storeName     | pageIndex |
      | AddToCart_50755_isRandomWeightTrue_page1_iOS | 30494    | 3070    | 49525   | Knapps Corner |           |
#      | AddToCart_50756_isRandomWeightTrue_page2_iOS  | 30495    | 3070    | 49525   | Knapps Corner | 2         |
#      | AddToCart_50757_isRandomWeightTrue_page3_iOS  | 30496    | 3070    | 49525   | Knapps Corner | 3         |
#      | AddToCart_50758_isRandomWeightTrue_page4_iOS  | 30497    | 3070    | 49525   | Knapps Corner | 4         |
#      | AddToCart_50759_isRandomWeightTrue_page5_iOS  | 30498    | 3070    | 49525   | Knapps Corner | 5         |
#      | AddToCart_50760_isRandomWeightTrue_page6_iOS  | 30499    | 3070    | 49525   | Knapps Corner | 6         |
#      | AddToCart_50761_isRandomWeightTrue_page7_iOS  | 30500    | 3070    | 49525   | Knapps Corner | 7         |
#      | AddToCart_50762_isRandomWeightTrue_page8_iOS  | 30501    | 3070    | 49525   | Knapps Corner | 8         |
#      | AddToCart_50763_isRandomWeightTrue_page9_iOS  | 30502    | 3070    | 49525   | Knapps Corner | 9         |
#      | AddToCart_50764_isRandomWeightTrue_page10_iOS | 30503    | 3070    | 49525   | Knapps Corner | 10        |


#############################
# IS_CLICK_AND_COLLECT:TRUE #
#############################
  @ButtonTest
  Scenario Outline: TC 50751 - Add To Cart - All Alt_UoM:ea Products
  #    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'is_click_and_collect:true' product
    Then user view page '<pageIndex>' of search results
    Then validate each product tile button functionality

    Examples:
      | TC_ID                               | POINT_ID | PLAN_ID | zipCode | storeName     | pageIndex |
      | AddToCart_50696_AltUoM.EA_page1_iOS | 30204    | 3070    | 49525   | Knapps Corner |           |


##############################
# IS_CLICK_AND_COLLECT:FALSE #
##############################
  @NoAddToCart
  Scenario Outline: TC 50751 - Add To Cart - All Alt_UoM:ea Products
#    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then user clicks Keep this Store on passive store selection modal
    When user searches '49525' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then user searches for 'is_click_and_collect:false' product
    Then user view page '<pageIndex>' of search results
    Then validate each product tile messaging for non cnc items

    Examples:
      | TC_ID                               | POINT_ID | PLAN_ID | zipCode | storeName     | pageIndex |
      | AddToCart_50696_AltUoM.EA_page1_iOS | 30204    | 3070    | 49525   | Knapps Corner |           |


  @sortByName
  Scenario Outline: sort products by name
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for 'banana' product
    Then user clicks sort product name by A-Z
    Then verify product 'name' is sorted '[A-Z]'
    Then user clicks sort product name by Z-A
    Then verify product 'name' is sorted '[Z-A]'
    Examples:
      | placeholder |
      |             |


  @sortByPrice
  Scenario Outline: sort products by price
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully

#shop
    When user searches for 'banana' product
    Then user clicks sort product price low to high
    Then verify product 'price' is sorted 'low to high'
    Then user clicks sort product price high to low
    Then verify product 'price' is sorted 'high to low'
    Examples:
      | placeholder |
      |             |

  @Test
  Scenario Outline: TC 9188 - Search - Sort Sellable Items (Sign In)
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
    Then user searches for 'is_sellable:true' product
    When user click price low to high from sort dropdown
    Then verify prices are low to high
    Then validate each product tile button functionality
    When user click price high to low from sort dropdown
    Then user clicks sort product price low to high
    Then validate each product tile button functionality
    When user click A to Z from sort dropdown
    Then verify products are A to Z
    Then validate each product tile button functionality
    When user click Z to A from sort dropdown
    Then verify prices are Z to A
    Then validate each product tile button functionality


    Examples:
      | email                | password  | zipCode | storeName     |
      | matt_auto1@gmail.com | password1 | 49525   | Knapps Corner |


  @TestSortButtons
  Scenario Outline: TC 9192 - Search - Sort Sellable Items (Anonymous)
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'is_sellable:true' product
  #    Then user clicks sort product price low to high
  #    Then verify product 'price' is sorted 'low to high'
  #    Then validate each product tile button functionality
  #    Then user clicks sort product price high to low
  #    Then verify product 'price' is sorted 'high to low'
  #    Then validate each product tile button functionality
    Then user clicks sort product name by A-Z
    Then verify product 'name' is sorted '[A-Z]'
    Then validate each product tile button functionality
    Then user clicks sort product name by Z-A
    Then verify product 'name' is sorted '[Z-A]'
    Then validate each product tile button functionality

    Examples:
      | zipCode | storeName     |
      | 49525   | Knapps Corner |


  @sortByName
  Scenario Outline: TC ? -  sort products by name
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully
#shop
    When user searches for 'banana' product
    Then user clicks sort product name by A-Z
    Then verify product 'name' is sorted '[A-Z]'
    Then user clicks sort product name by Z-A
    Then verify product 'name' is sorted '[Z-A]'
    Examples:
      | placeholder |
      |             |


  @sortByPrice
  Scenario Outline: TC ? -  sort products by price
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'zod@meijer.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'd3stroys'
    Then Meijer Home page displays User is signed in successfully

#shop
    When user searches for 'banana' product
    Then user clicks sort product price low to high
    Then verify product 'price' is sorted 'low to high'
    Then user clicks sort product price high to low
    Then verify product 'price' is sorted 'high to low'
    Examples:
      | placeholder |
      |             |


#
