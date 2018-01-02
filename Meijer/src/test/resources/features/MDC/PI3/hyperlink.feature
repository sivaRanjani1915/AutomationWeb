Feature: hyperlink.feature

  Background:
    Then clear all array list

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9103 - Tier2 Page Hyperlink Altered when selecting mPerks Filter using bottom left menu in grid view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then click mPerks ways to save from bottom left
    Then verify url should match mperks filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9104 - Tier2 Page Hyperlink Altered when selecting Sale Filter using top dropdown menu in grid view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9369 - Tier2 Page Hyperlink Altered when selecting mPerks Filter using top dropdown menu in grid view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When click mPerks ways to save from top dropdown
    Then verify url should match mperks filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9370 - Tier2 Page Hyperlink Altered when selecting Sale Filter using bottom left menu in grid view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When click Sale ways to save from bottom left
    Then verify url should match Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9386 - Tier2 Page Hyperlink Altered when selecting mPerks and Sale Filters using bottom left menu in grid view
    When the user sets testcase configurations '9386' '3228' '3070'
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When click mPerks ways to save from bottom left
    When click Sale ways to save from bottom left
    Then verify url should match mPerks and Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9387 - Tier2 Page Hyperlink Altered when selecting mPerks and Sale Filters using top dropdown menu in grid view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When click mPerks ways to save from top dropdown
    When click Sale ways to save from top dropdown
    Then verify url should match mPerks and Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9668 - Tier2 Page Hyperlink Altered when selecting mPerks Filter using bottom left menu in list view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click mPerks ways to save from bottom left
    Then verify url should match mperks filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9674 - Tier2 Page Hyperlink Altered when selecting Sale Filter using top dropdown menu in list view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for tier2

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | tier1   | tier2  |
      | 9674  | 30075    | 3070    | matt_auto@gmail.com | password1 | Grocery | Frozen |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9677 - Tier2 Page Hyperlink Altered when selecting mPerks Filter using top dropdown menu in list view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click mPerks ways to save from top dropdown
    Then verify url should match mperks filters for tier2

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | tier1   | tier2  |
      | 9677  | 30849    | 3070    | matt_auto@gmail.com | password1 | Grocery | Frozen |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9679 - Tier2 Page Hyperlink Altered when selecting Sale Filter using bottom left menu in list view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click Sale ways to save from bottom left
    Then verify url should match Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2   |
      | matt_auto@gmail.com | password1 | Grocery | Produce |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9680 - Tier2 Page Hyperlink Altered when selecting mPerks and Sale Filters using bottom left menu in list view
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click mPerks ways to save from bottom left
    When click Sale ways to save from bottom left
    Then verify url should match mPerks and Sale filters for tier2

    Examples:
      | email               | password  | tier1   | tier2  |
      | matt_auto@gmail.com | password1 | Grocery | Pantry |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9681 - Tier2 Page Hyperlink Altered when selecting mPerks and Sale Filters using top dropdown menu in list view
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
    Then clear all array list
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    When user clicks on list view
    When click mPerks ways to save from top dropdown
    When click Sale ways to save from top dropdown
    Then verify url should match mPerks and Sale filters for tier2

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | tier1   | tier2  |
      | 9681  | 30890    | 3070    | matt_auto@gmail.com | password1 | Grocery | Frozen |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 29135 - Tier Page Hyperlink Altered when selecting Sale Filter in Tier3
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for tier3

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | tier1   | tier2   | tier3 |
      | 29135 | 30050    | 3070    | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 29136 - Tier Page Hyperlink Altered when selecting Sale Filter in Tier4
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' to '<tier4>' submenu Tier4
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for tier4

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | tier1   | tier2   | tier3 | tier4  |
      | 29136 | 30051    | 3070    | matt_auto@gmail.com | password1 | Grocery | Produce | Fruit | Apples |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 29137 - Tier Page Hyperlink Altered when selecting Brand Filter
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
    Then clear all array list
    When user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
    When user clicks brand in left navigation
    Then verify url should match brand filters for tiers

    Examples:
      | email               | password  | tier1       | tier2              | tier3 |
      | matt_auto@gmail.com | password1 | Electronics | TVs & Home Theater | TVs   |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9381 - Search Page Hyperlink Altered when selecting mPerks Filter using bottom left menu in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click mPerks ways to save from bottom left
    Then verify url should match mperks filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9382 - Search Page Hyperlink Altered when selecting mPerks Filter using top dropdown menu in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click mPerks ways to save from top dropdown
    Then verify url should match mperks filters for search

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | item_tosearch             |
      | 9382  | 30723    | 3070    | matt_auto@gmail.com | password1 | is_click_and_collect:true |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9384 - Search Page Hyperlink Altered when selecting Sale Filter using top dropdown in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for search

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | item_tosearch |
      | 9384  | 30765    | 3070    | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9385 - Search Page Hyperlink Altered when selecting mPerks and Sale Filters using top dropdown menu in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click mPerks ways to save from top dropdown
    When click Sale ways to save from top dropdown
    Then verify url should match mPerks and Sale filters for search

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | item_tosearch             |
      | 9385  | 3228     | 3070    | matt_auto@gmail.com | password1 | is_click_and_collect:true |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9389 - Search Page Hyperlink Altered when selecting mPerks and Sale Filters using bottom left menu in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click mPerks ways to save from bottom left
    When click Sale ways to save from bottom left
    Then verify url should match mPerks and Sale filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9685 - Search Page Hyperlink Altered when selecting mPerks Filter using bottom left menu in list view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When user clicks on list view
    When click mPerks ways to save from bottom left
    Then verify url should match mperks filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9686 - Search Page Hyperlink Altered when selecting mPerks Filter using top dropdown menu in grid view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When click mPerks ways to save from top dropdown
    Then verify url should match mperks filters for search

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | item_tosearch             |
      | 9686  | 30894    | 3070    | matt_auto@gmail.com | password1 | is_click_and_collect:true |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9688 - Search Page Hyperlink Altered when selecting Sale Filter using top dropdown menu in grid view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When click Sale ways to save from top dropdown
    Then verify url should match Sale filters for search

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | email               | password  | item_tosearch |
      | 9688  | 30896    | 3070    | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9690 - Search Page Hyperlink Altered when selecting Sale Filter using bottom left in grid view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When click Sale ways to save from bottom left
    Then verify url should match Sale filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9694 - Search Page Hyperlink Altered when selecting mPerks and Sale Filters using top dropdown menu in grid view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When click mPerks ways to save from top dropdown
    When click Sale ways to save from top dropdown
    Then verify url should match mPerks and Sale filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |

  @PI3
  @OUT_DATED
  Scenario Outline: TC 9698 - Search Page Hyperlink Altered when selecting mPerks and Sale Filters using bottom left menu in grid view
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
    Then clear all array list
    Then user searches for '<item_tosearch>' product
    When click mPerks ways to save from bottom left
    When click Sale ways to save from bottom left
    Then verify url should match mPerks and Sale filters for search

    Examples:
      | email               | password  | item_tosearch |
      | matt_auto@gmail.com | password1 | Fruit         |
