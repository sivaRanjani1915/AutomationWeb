Feature: Health and Wellness


  @siva333
  Scenario Outline: Product label (Ingredients,warnings,Claims) +Nutritional facts(Header,Main,Micronutrition,vitamins,Minerals)
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition details are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    # Then Verify Nutritional Vitamins are displayed
    # Then Verify Nutritional Mineral are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims)+No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims +No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims+No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings+No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims +No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings +No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients+No Nutritional facts
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed

    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
# Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
# Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  @siva24
  Scenario Outline: Test Case 31475 Nutritional Attributes show in pdp
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
#   Then verify display of PDP page
    Then verify nutritional attributes are displayed
    Then verify nutritional attributes displayed before ingredients
    Then verify there are no more than 12 attributes displayed
    Then verify nutritional attributes '<attribute1>' '<attribute2>' '<attribute3>' '<attribute4>' '<attribute5>' '<attribute6>' '<attribute7>' '<attribute8>' '<attribute9>' '<attribute10>' '<attribute11>' '<attribute12>'


    Examples:
      | email          | password  | string    | zipCode | storeName     | attribute1 | attribute2     | attribute3     | attribute4     | attribute5   | attribute6 | attribute7     | attribute8 | attribute9 | attribute10 | attribute11 | attribute12 |
      | fish@gmail.com | password1 | 834602639 | 49512   | Cascade       | Kosher     | High Vitamin C | High Vitamin D | High Vitamin E | High Calcium | High Iron  | High Magnesium |            |            |             |             |             |
      | fish@gmail.com | password1 | 980000071 | 49544   | Knapps Corner | Kosher     |                |                |                |              |            |                |            |            |             |             |             |

  @H&W
  Scenario Outline:Test Case 32972 validate legal disclaimers for vitamins and supplements
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
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

  @H&W
  Scenario Outline: Test Case 32977 validate legal disclaimers for non-vitamins and non-supplements
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
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

  @siva33
  Scenario Outline: Product label (Ingredients,warnings,Claims) +Nutritional facts(Header,Main,Micronutrition,vitamins,Minerals) Guest
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition details are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
  # Then Verify Nutritional Vitamins are displayed
  # Then Verify Nutritional Mineral are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims)+No Nutritional facts
    Given user navigate to test environment URL
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims +No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims+No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings+No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims +No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings +No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients+No Nutritional facts
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify no nutritional data displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed

    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition+vitamins
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Vitamins are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients + No Warnings and No claims , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify No product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+No Ingredients and No claims , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Claims+No Ingredients and No warnings , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify No product ingredients are not displayed
    Then verify No product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#  Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Warnings and No claims  , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
# Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Ingredients +Claims and NoWarnings  , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify No claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#   Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Warnings+claims and No Ingredients , Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify  No product ingredients are not displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
#    Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  Scenario Outline: Product label (Ingredients,warnings,Claims), Header+Main+Micronutrition+Minerals
    Given user navigate to test environment URL
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
    Then verify product ingredients are displayed
    Then verify product warnings are displayed
    Then verify claims are displayed
    Then verify Nutrition header are displayed
    Then Verify Nutritional Main are displayed
    Then Verify Nutritional Micronutrients are displayed
# Then Verify Nutritional Minerals are displayed
    Then verify the static footer is displayed

    Examples:
      |  |
      |  |

  @siva24
  Scenario Outline: Test Case 31475 Nutritional Attributes show in pdp
    Given user navigate to test environment URL
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then user searches for '<string>' product
    Then at random, click on a product to view its PDP
#   Then verify display of PDP page
    Then verify nutritional attributes are displayed
    Then verify nutritional attributes displayed before ingredients
    Then verify there are no more than 12 attributes displayed
    Then verify nutritional attributes '<attribute1>' '<attribute2>' '<attribute3>' '<attribute4>' '<attribute5>' '<attribute6>' '<attribute7>' '<attribute8>' '<attribute9>' '<attribute10>' '<attribute11>' '<attribute12>'


    Examples:
      | string    | str_zipCode | storeName     | attribute1 | attribute2     | attribute3     | attribute4     | attribute5   | attribute6 | attribute7     | attribute8 | attribute9 | attribute10 | attribute11 | attribute12 |
      | 834602639 | 49512       | Cascade       | Kosher     | High Vitamin C | High Vitamin D | High Vitamin E | High Calcium | High Iron  | High Magnesium |            |            |             |             |             |
      | 980000071 | 49544       | Knapps Corner | Kosher     |                |                |                |              |            |                |            |            |             |             |             |

  @H&W
  Scenario Outline:Test Case 32972 validate legal disclaimers for vitamins and supplements
    Given user navigate to test environment URL
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

  @H&W
  Scenario Outline: Test Case 32977 validate legal disclaimers for non-vitamins and non-supplements
    Given user navigate to test environment URL
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

  @siva66
  Scenario Outline: Test Case 31489 Ingredients show in pdp EXCEL
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then validate for all upc having HW ingredient and warnings

    Examples:
      | email          | password  | zipCode | storeName |
      | fish@gmail.com | password1 | 49512   | Cascade   |
