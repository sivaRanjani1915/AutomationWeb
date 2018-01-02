Feature: ProductDetailPage.feature

  Background:
    Then clear all array list

  @NR_DS_desktop
  Scenario Outline: TC 7955 - Remove the Select New Store link on the PDP, Item is In Stock, For A Curbside Store - Guest
    And the user sets testcase configurations '7955' '127694' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify removal of copy on PDP page

    Examples:
      | zipCode | storeName     | search           |
      | 49525   | Knapps Corner | is_sellable:true |

  @NR_DS_desktop
  Scenario Outline: TC 7954 - Remove the Select New Store link on the PDP, Item is In Stock, For A NON-Curbside Store - Guest
    And the user sets testcase configurations '7954' '127697' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'inStoreOnly' product to view its PDP
    Then verify display of PDP page
    Then verify removal of copy on PDP page

    Examples:
      | zipCode | storeName  | search           |
      | 49418   | Grandville | is_sellable:true |

  @NR_DS_desktop
  Scenario Outline: TC 8353 - Item is In-Stock, E-Comm Flag is Off, At Curbside Store - Guest
    And the user sets testcase configurations '8353' '127695' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'inStoreOnly' product to view its PDP
    Then verify display of PDP page
    Then verify removal of 'Find a Store Near You' if e-comm flag is off

    Examples:
      | zipCode | storeName | search                     |
      | 49512   | Cascade   | is_click_and_collect:false |

  @NR_DS_desktop
  Scenario Outline: TC 8352 - Item is In-Stock, E-Comm Flag is Off, At NON-Curbside Store - Guest
    And the user sets testcase configurations '8352' '127698' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'inStoreOnly' product to view its PDP
    Then verify display of PDP page
    Then verify removal of 'Find a Store Near You' if e-comm flag is off

    Examples:
      | zipCode | storeName  | search                     |
      | 49418   | Grandville | is_click_and_collect:false |

  @NR_DS_desktop
  Scenario Outline: TC 8198 - Remove Add To Cart button on PDP, Item is Out of Stock - Curbside Stores - Guest
    And the user sets testcase configurations '8198' '127699' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'outOfStock' product to view its PDP
    Then verify display of PDP page
    Then verify removal of 'Add to Cart' button for Out of Stock item

    Examples:
      | zipCode | storeName     | search            |
      | 49525   | Knapps Corner | is_sellable:false |

  @NR_DS_desktop
  Scenario Outline: TC 8269 - Remove Add To Cart button on PDP, Item is Out of Stock - Non-Curbside Stores - Guest
    And the user sets testcase configurations '8269' '127701' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'outOfStock' product to view its PDP
    Then verify display of PDP page
    Then verify removal of 'Add to Cart' button for Out of Stock item

    Examples:
      | zipCode | storeName  | search            |
      | 49418   | Grandville | is_sellable:false |

  @zombie
  Scenario Outline: MAP Pricing Item - 'See price in cart' copy, Item is In Stock - Curbside Store - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then verify 'price less than map' copy on PDP page

    Examples:
      | zipCode | storeName     | search                   |
      | 49525   | Knapps Corner | price_less_than_map:true |

  @zombie
  Scenario Outline: MAP Pricing Item - 'See price in cart' copy, E-Comm Flag is Off, At NON-Curbside Store - Guest
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<search>' product
    Then at random, click on an 'inStoreOnly' product to view its PDP
    Then verify display of PDP page
    Then verify 'price less than map' copy on PDP page

    Examples:
      | zipCode | storeName  | search                   |
      | 49418   | Grandville | price_less_than_map:true |
