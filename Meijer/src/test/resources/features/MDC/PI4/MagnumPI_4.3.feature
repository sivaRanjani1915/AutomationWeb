Feature: Health and Wellness

  @Zombie
  Scenario Outline: TC 31834 - Nutritional Attributes do not show in pdp when there are none
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
      | email          | password  | string     | zipCode | storeName |
      | fish@gmail.com | password1 | 1300000464 | 49512   | Cascade   |

  @Zombie
  Scenario Outline: TC 31489 - Ingredients show in pdp
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
      | email          | password  | string    | zipCode | storeName |
      | fish@gmail.com | password1 | 834602639 | 49512   | Cascade   |

  @Zombie
  Scenario Outline: TC 31492 - No ingredients to be shown
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
      | email          | password  | string | zipCode | storeName |
      | fish@gmail.com | password1 | 4011   | 49512   | Cascade   |

  @Zombie
  Scenario Outline: TC 31503 - Warnings on PDP
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
    Then verify product warnings are displayed
    Then verify product ingredients displayed before warnings
    Then verify product warnings displayed before nutrition details


    Examples:
      | email          | password  | string    | zipCode | storeName |
      | fish@gmail.com | password1 | 834602639 | 49512   | Cascade   |

  @Zombie
  Scenario Outline: TC 31507 - No Warnings on PDP
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
      | email          | password  | zipCode | storeName | string    |
      | fish@gmail.com | password1 | 49512   | Cascade   | 834602639 |

  @Zombie
  Scenario Outline: TC 32942 - Nutrition label header displays nutrition information on item
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
    Then verify nutritional details panel displayed before nutritional label header
    Then verify nutrition Label header displayed before nutrition label main
    Then verify header heading displays Nutrition Facts
    Then verify servings per container is displayed and reflects correct data '<servingsPerContainer>'
    Then verify serving size is displayed and reflects correct data '<servingSize1>' '<servingSize2>'
    Then verify calorie count is displayed and reflects correct data '<calorieCount>'
    Then verify calories from fat is displayed and reflects correct data '<caloriesFromFat>'

    Examples:
      | email          | password  | string    | servingsPerContainer | servingSize1 | servingSize2 | calorieCount | caloriesFromFat      |
      | fish@gmail.com | password1 | 834602639 | 14                   | 0.25 cup     | (26g)        | 110          | Calories from Fat 30 |

#test results returned as "pending"
  @Zombie
  Scenario Outline: TC 32947 - Nutrition label main displays for item
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
      | email          | password  | string    |
      | fish@gmail.com | password1 | 834602639 |

#test results returned as "pending"
  @Zombie
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
      | email          | password  | string    | item1          | item2 | item3              | item4 | item5        | item6           | item7 | item8        | item9 | item10                 | item11 | item12           | item13 | item14     | item15     | item16 |
      | fish@gmail.com | password1 | 834602639 | Total Fat 3.5g | 5%    | Saturated Fat 0.5g | 3%    | Trans Fat 0g | Cholesterol 5mg | < 1%  | Sodium 140mg | 6%    | Total Carbohydrate 18g | 6%     | Dietary Fiber 4g | 16%    | Sugars 12g | Protein 2g | 4%     |

  @Zombie
  Scenario Outline: TC 33109 - Nutrition label micronutrients display in PDP
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
      | email          | password  | string    |
      | fish@gmail.com | password1 | 834602639 |

#test results returned as "pending"
  @Zombie
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
      | email          | password  | string    | item1          | item2 | item3              | item4 | item5        | item6           | item7 | item8        | item9 | item10                 | item11 | item12           | item13 | item14     | item15     | item16 |
      | fish@gmail.com | password1 | 834602639 | Total Fat 3.5g | 5%    | Saturated Fat 0.5g | 3%    | Trans Fat 0g | Cholesterol 5mg | < 1%  | Sodium 140mg | 6%    | Total Carbohydrate 18g | 6%     | Dietary Fiber 4g | 16%    | Sugars 12g | Protein 2g | 4%     |

  @Zombie
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
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    #Then verify display of PDP page
    Then verify copy matches noncollapse legal disclaimer2
    Then user clicks show more disclaimer
    Then verify copy matches collapse legal disclaimer2
    Then verify disclaimers displayed before nutritional details


    Examples:
      | email          | password  | string      |
      | fish@gmail.com | password1 | 84433401031 |

  @Zombie
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
      | email          | password  | string    |
      | fish@gmail.com | password1 | 834602639 |

  @Zombie
  Scenario Outline: TC 33130 - Nutritional Details displayed in PDP
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
      | email          | password  | string    | cal | fat | carbs | protein |
      | fish@gmail.com | password1 | 834602639 | 110 | 3.5 | 18    | 2       |

  @Zombie
  Scenario Outline: TC 34506 - UPC with attributes and nutritional details but no ingredients, warnings or disclaimers
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
    Then verify nutritional attributes displayed before nutritional details

    Examples:
      | email          | password  | string    |
      | fish@gmail.com | password1 | 834602639 |

  @Zombie
  Scenario Outline: TC 34496 - UPC with warnings and disclaimers
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
    Then verify product warnings displayed before disclaimers

    Examples:
      | email          | password  | string    |
      | fish@gmail.com | password1 | 87989000001 |

