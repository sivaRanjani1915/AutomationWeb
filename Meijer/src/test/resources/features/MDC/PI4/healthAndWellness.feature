Feature: healthAndWellness.feature

  Background:
    Then clear all array list

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31475 - Nutritional Attributes show in pdp
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #   Then verify display of PDP page
    Then verify nutritional attributes are displayed
    Then verify nutritional attributes displayed before ingredients
    Then verify there are no more than 12 attributes displayed
    Then verify nutritional attributes '<attribute1>' '<attribute2>' '<attribute3>' '<attribute4>' '<attribute5>' '<attribute6>' '<attribute7>' '<attribute8>' '<attribute9>' '<attribute10>' '<attribute11>' '<attribute12>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string      | zipCode | storeName | attribute1 | attribute2 | attribute3 | attribute4 | attribute5 | attribute6 | attribute7 | attribute8 | attribute9 | attribute10 | attribute11 | attribute12 |
      | 31475 | 36313    | 3070    | fish@gmail.com | password1 | 72037950116 | 49512   | Cascade   | Organic    | GMO Free   | Kosher     |            |            |            |            |            |            |             |             |             |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31834 - Nutritional Attributes do not show in pdp when there are none
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify nutritional attributes are not displayed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string      | zipCode | storeName |
      | 31834 | 36314    | 3070    | fish@gmail.com | password1 | 71928349000 | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31489 - Ingredients show in pdp
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify product ingredients are displayed
    Then verify nutritional attributes displayed before ingredients
    Then verify product ingredients displayed before warnings

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string     | zipCode | storeName |
      | 31489 | 29987    | 3070    | fish@gmail.com | password1 | 1112600411 | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31492 - No ingredients to be shown
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify product ingredients are not displayed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string      | zipCode | storeName |
      | 31492 | 36315    | 3070    | fish@gmail.com | password1 | 22058000000 | 49525   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31503 - Warnings on PDP
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify product warnings are displayed
    Then verify product ingredients displayed before warnings
    Then verify product warnings displayed before nutrition details

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string     | zipCode | storeName |
      | 31503 | 29988    | 3070    | fish@gmail.com | password1 | 1112600411 | 49512   | Cascade   |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 31507 - No Warnings on PDP
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify product warnings are not displayed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | zipCode | storeName | string      |
      | 31507 | 29989    | 3070    | fish@gmail.com | password1 | 49512   | Cascade   | 89002900135 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 32942 - Nutrition label header displays nutrition information on item
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify nutritional details panel displayed before nutritional label header
    Then verify nutrition Label header displayed before nutrition label main
    Then verify header heading displays Nutrition Facts
    Then verify servings per container is displayed and reflects correct data '<servingsPerContainer>'
    Then verify serving size is displayed and reflects correct data '<servingSize1>' '<servingSize2>'
    Then verify calorie count is displayed and reflects correct data '<calorieCount>'
    Then verify calories from fat is displayed and reflects correct data '<caloriesFromFat>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string     | servingsPerContainer | servingSize1 | servingSize2 | calorieCount | caloriesFromFat     |
      | 32942 | 29990    | 3070    | fish@gmail.com | password1 | 1112600411 | ABOUT 17             | 3 Tbsp       | (30g)        | 100          | Calories from Fat 0 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 32947 - Nutrition label main displays for item
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify display of nutrition label main

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string      |
      | 32947 | 36316    | 3070    | fish@gmail.com | password1 | 89002900135 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34512 - Verify Nutrition label main data for item
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify display of nutrition label main
    Then validate nutrition label main data '<item1>' '<item2>' '<item3>' '<item4>' '<item5>' '<item6>' '<item7>' '<item8>' '<item9>' '<item10>' '<item11>' '<item12>' '<item13>' '<item14>' '<item15>' '<item16>'

    Examples:
      | email          | password  | string      | item1          | item2 | item3              | item4 | item5        | item6           | item7 | item8        | item9 | item10                 | item11 | item12           | item13 | item14     | item15     | item16 |
      | fish@gmail.com | password1 | 89002900135 | Total Fat 3.5g | 5%    | Saturated Fat 0.5g | 3%    | Trans Fat 0g | Cholesterol 5mg | < 1%  | Sodium 140mg | 6%    | Total Carbohydrate 18g | 6%     | Dietary Fiber 4g | 16%    | Sugars 12g | Protein 2g | 4%     |

#    TODO:Fix this testcase as things are wrong
  @PI4
  @OUT_DATED
  @WIP
  Scenario Outline: TC 33109 - Nutrition label micronutrients display in PDP
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify nutrition label main displayed before nutrition label micronutrients
    Then verify nutrition label micronutrients displayed before Nutrition label footer
    Then validate mandatory micronutrients are displayed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email          | password  | string     |
      | 33109 | 29991    | 3070    | fish@gmail.com | password1 | 1112600411 |

  #Not valid test cases
  @PI4
  @OUT_DATED
  @WIP
  Scenario Outline: TC 34509 - Verify Nutrition label micronutrients data for item
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #    Then verify display of PDP page
    Then verify display of nutrition label main
    Then validate nutrition label main data '<item1>' '<item2>' '<item3>' '<item4>' '<item5>' '<item6>' '<item7>' '<item8>' '<item9>' '<item10>' '<item11>' '<item12>' '<item13>' '<item14>' '<item15>' '<item16>'

    Examples:
      | email                | password  | string    | item1          | item2 | item3              | item4 | item5        | item6           | item7 | item8        | item9 | item10                 | item11 | item12           | item13 | item14     | item15     | item16 |
      | matt_auto1@gmail.com | password1 | 834602639 | Total Fat 3.5g | 5%    | Saturated Fat 0.5g | 3%    | Trans Fat 0g | Cholesterol 5mg | < 1%  | Sodium 140mg | 6%    | Total Carbohydrate 18g | 6%     | Dietary Fiber 4g | 16%    | Sugars 12g | Protein 2g | 4%     |

 # will not work in uat until etl job runs
  @PI4
  @OUT_DATED
  Scenario Outline: TC 32972 - validate legal disclaimers for vitamins and supplements
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
    Then user searches for '<upc>' product
    Then at random, click on an '<availability>' product to view its PDP
    Then verify display of PDP page
    Then verify copy matches noncollapse legal disclaimer2
    Then user clicks show more disclaimer
    Then verify copy matches collapse legal disclaimer2
    Then verify disclaimers displayed before nutritional details

    Examples:
      | email                | password  | upc         | availability |
      | matt_auto1@gmail.com | password1 | 84433401031 | OUTOFSTOCK   |

#dev3 or UAT environment will not work for disclaimers unless etl job runs
  @PI4
  @OUT_DATED
  Scenario Outline: TC 32977 - validate legal disclaimers for non-vitamins and non-supplements
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #Then verify display of PDP page
    Then verify disclaimers displayed before nutritional details
    Then verify copy matches noncollapse legal disclaimer1
    Then user clicks show more disclaimer
    Then verify copy matches collapse legal disclaimer1

    Examples:
      | email                | password  | string    |
      | matt_auto1@gmail.com | password1 | 834602639 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33130 - Nutritional Details displayed in PDP
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #Then verify display of PDP page
    Then verify disclaimers displayed before nutritional details
    Then verify nutritional details panel displayed before nutritional label header
    Then verify tiles for calories Fat Carbs Protein
    Then validate data in each tile is correct data '<cal>' '<fat>' '<carbs>' '<protein>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  | string     | cal | fat | carbs | protein |
      | 33130 | 29993    | 3070    | matt_auto1@gmail.com | password1 | 1112600411 | 100 | 3.5 | 2     | 3       |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33123 - Nutritional Data should not display if there is not any data
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
#     DEV Configurations
    Then user searches for '88133400147' in 'DEV' environment
    # UAT Configurations
    Then user searches for '1114110291' in 'UAT' environment
    Then at random, click on a product to view its PDP
    #Then verify display of PDP page
    Then verify no nutritional data displayed

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  |
      | 33123 | 29992    | 3070    | matt_auto1@gmail.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34508 - UPC with attributes and warnings but no ingredients
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
#     DEV Configurations
    Then user searches for '85768700214' in 'DEV' environment
    # UAT Configurations
    Then user searches for '85768700209' in 'UAT' environment
    Then at random, click on a product to view its PDP
    Then verify nutritional attributes displayed before warnings

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  |
      | 34508 | 29998    | 3070    | matt_auto1@gmail.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34507 - UPC with attributes and disclaimers but no ingredients or warnings
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
    # DEV Configurations
    Then user searches for '1571810430' in 'DEV' environment
    # UAT Configurations
    Then user searches for '1571810330' in 'UAT' environment
    Then at random, click on a product to view its PDP
    Then verify nutritional attributes displayed before disclaimers

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  |
      | 34507 | 29997    | 3070    | matt_auto1@gmail.com | password1 |

#not a valid test case
  @PI4
  @OUT_DATED
  @WIP
  Scenario Outline: TC 34506 - UPC with attributes and nutritional details but no ingredients, warnings or disclaimers
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
    Then user searches for '<string>' product
    Then at random, click on an 'outOfStock' product to view its PDP
    #Then verify display of PDP page
    Then verify nutritional attributes displayed before nutritional details

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  | string      |
      | 34506 | 29996    | 3070    | matt_auto1@gmail.com | password1 | 87989000001 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34499 - UPC with ingredients and disclaimers but no warnings
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
    Then user searches for '<string>' product
    Then at random, click on an 'outOfStock' product to view its PDP
    #Then verify display of PDP page
    Then verify product ingredients displayed before disclaimers

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  | string      |
      | 34499 | 29986    | 3070    | matt_auto1@gmail.com | password1 | 87989000001 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34497 - UPC with ingredients and nutrition details but no warnings or disclaimers
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
    # DEV Configurations
    Then user searches for '66072653411' in 'DEV' environment
    # UAT Configurations
    Then user searches for '87606300315' in 'UAT' environment
    Then at random, click on a product to view its PDP
    Then verify product ingredients displayed before nutrition details

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  |
      | 34497 | 29995    | 3070    | matt_auto1@gmail.com | password1 |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 34496 - UPC with warnings and disclaimers
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify product warnings displayed before disclaimers

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email                | password  | string      |
      | 34496 | 29994    | 3070    | matt_auto1@gmail.com | password1 | 87989000001 |

  #ADDED IN PI6
  @HWICON
  @WIP
  Scenario Outline: TC 74386 Milk Free icon displayed with milk free items
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'matt_auto1@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '2529300098' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then verify milk free icon is displayed

    Examples:
      |  |
      |  |

  @HWICON
  @WIP
  Scenario Outline: TC 74388 Milk free icon is not shown with items that have milk
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'matt_auto1@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '4125010210' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then verify milk free icon is not displayed


    Examples:
      |  |
      |  |

  @HWICON
  @WIP
  Scenario Outline: TC 75141 Verify Kosher icon does not display on any PDP
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'matt_auto1@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    When user searches '49525' and sets store to 'Knapps Corner'
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user searches for '4125010210' product
    Then at random, click on a 'ea' product to view its PDP
    Then verify display of PDP page
    Then verify kosher icon is not displayed

    Examples:
      |  |
      |  |
