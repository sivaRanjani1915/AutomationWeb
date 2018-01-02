Feature: improvementsToSEO.feature

  Background:
    Then clear all array list
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8610 - H3 Tags for Product Names On Search/Tier Results - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then verify h3 tags for product name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify h3 tags for product name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify h3 tags for product name

    Examples:
      | zipCode | storeName     | search           | tier1   | tier2   | tier3  | tier4            |
      | 49525   | Knapps Corner | is_sellable:true | Grocery | Pantry  | Baking | Baking Chocolate |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8610 - H3 Tags for Product Names On Search/Tier Results - Signed
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
    Then verify h3 tags for product name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify h3 tags for product name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify h3 tags for product name

    Examples:
      | email                  | password  | zipCode | storeName  | search           | tier1   | tier2   | tier3  | tier4            |
      | meijer_auto@email.com  | password1 | 49512   | Cascade    | is_sellable:true | Grocery | Pantry  | Baking | Baking Chocolate |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8608 - Alt Tags for Product Image On Search/Tier Results - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify alt tags on product images
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify alt tags on product images
    Then user searches for '<search>' product
    Then verify alt tags on product images

    Examples:
      | zipCode | storeName | tier1   | tier2   | tier3  | tier4            | search                    |
      | 49512   | Cascade   | Grocery | Pantry  | Baking | Baking Chocolate | is_click_and_collect:true |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8608 - Alt Tags for Product Image On Search/Tier Results - Signed-In
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify alt tags on product images
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify alt tags on product images
    Then user searches for '<search>' product
    Then verify alt tags on product images

    Examples:
      | email                  | password  | zipCode | storeName       | tier1   | tier2   | tier3  | tier4            | search                    |
      | meijer_auto2@email.com | password1 | 49525   | Knapps Corner   | Grocery | Pantry  | Baking | Baking Chocolate | is_click_and_collect:true |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8961 - H1 Tag for Category Name On Tier Results - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify h1 tag on category name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify h1 tag on category name

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | tier1   | tier2   | tier3  | tier4            |
      | 8961  | 30026    | 3070    | 49428   | Jenison   | Grocery | Pantry  | Baking | Baking Chocolate |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8961 - H1 Tag for Category Name On Tier Results - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then verify h1 tag on category name
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then verify h1 tag on category name

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                  | password  | zipCode | storeName | tier1   | tier2   | tier3  | tier4            |
      | 8961  | 30026    | 3070    | meijer_auto@email.com  | password1 | 49428   | Jenison   | Grocery | Pantry  | Baking | Baking Chocolate |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9869 - H1 Tag for Product Title on PDP - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify h1 tag on product name

    Examples:
      | zipCode | storeName     | tier1   | tier2   | tier3 |
      | 49525   | Knapps Corner | Grocery | Produce | Fruit |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9869 - H1 Tag for Product Title on PDP - Signed-In
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify h1 tag on product name

    Examples:
      | email                  | password  | zipCode | storeName  | tier1   | tier2   | tier3 |
      | meijer_auto4@email.com | password1 | 49428   | Jenison    | Grocery | Produce | Fruit |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8957 - Alt Tags for Product Image on PDP  - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify alt tags on product image on PDP

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName  | tier1   | tier2   | tier3 |
      | 8957  | 30715    | 3070    | 49428   | Jenison    | Grocery | Produce | Fruit |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8957 - Alt Tags for Product Image on PDP - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify title windows tab on PDP

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                  | password  | zipCode | storeName     | tier1   | tier2   | tier3      |
      | 8957  | 30715    | 3070    | meijer_auto4@email.com | password1 | 49525   | Knapps Corner | Grocery | Produce | Vegetables |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8949 - Product Name in Window Title tab on PDP - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify title windows tab on PDP

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | tier1   | tier2   | tier3      |
      | 8949  | 30041    | 3070    | 49525   | Knapps Corner | Grocery | Produce | Vegetables |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 8949 - Product Name in Window Title tab on PDP - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify title windows tab on PDP

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                  | password  | zipCode | storeName     | tier1   | tier2   | tier3      |
      | 8949  | 30041    | 3070    | meijer_auto4@email.com | password1 | 49525   | Knapps Corner | Grocery | Produce | Vegetables |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9405 - Breadcrumbs -  Tier Results - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then user verify look and feel of breadcrumbs

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | tier1   | tier2   | tier3 | tier4  |
      | 9405  | 30845    | 3070    | 49525   | Knapps Corner | Grocery | Produce | Fruit | Apples |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9405 - Breadcrumbs -  Tier Results - Signed-In
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
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
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    Then user verify look and feel of breadcrumbs

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                  | password  | zipCode | storeName     | tier1   | tier2   | tier3 | tier4  |
      | 9405  | 30845    | 3070    | meijer_auto2@email.com | password1 | 49525   | Knapps Corner | Grocery | Produce | Fruit | Apples |
  
  @PI3
  @OUT_DATED
  Scenario Outline: TC 9401 - Breadcrumbs - PDP - Guest
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    Then user verify look and feel of breadcrumbs
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then user verify look and feel of breadcrumbs

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | tier1   | tier2   | tier3 |
      | 9401  | 30797    | 3070    | 49428   | Jenison   | Grocery | Produce | Fruit |
