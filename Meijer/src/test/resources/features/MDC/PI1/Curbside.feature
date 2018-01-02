#Author: Pritam.Maibam@meijer.com
Feature: Curbside.feature

  Background:
    Then clear all array list

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1910 - Desktop - Sign-In - Online Shopping Dropdown - Curbside Link - 1st on the List - Header
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then user Click on header menu online shopping
    Then validate curbside 1st on dropdown list

    Examples:
      | email                    | password  |
      | pritest_auto34@gmail.com | Selenium1 |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1911 - Desktop - Anonymous - Online Shopping Dropdown - Curbside Link - 1rd on the List - Header
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user Click on header menu online shopping
    Then validate curbside 1st on dropdown list

    Examples:
      | TC_ID | POINT_ID | PLAN_ID |
      | 1911  | 30015    | 3070    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 1918 - Desktop - Anonymous - Curbside Content Page
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user Click on header menu online shopping
    Then click curbside from online shopping dropdown
#    Then validate Curbside page display successfully

    Examples:
      | TC_ID | POINT_ID | PLAN_ID |
      | 1918  | 64667    | 3070    |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 83407 - Shipt Home Delivery will display under Online shopping menu option in global nav
    And the user sets testcase configurations '83407' '103164' '74109'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then user Click on header menu online shopping
    Then validate shipt 2nd on dropdown list

    Examples:
      | email                    | password  |
      | pritest_auto34@gmail.com | Selenium1 |

  @PI1
  @OUT_DATED
  Scenario Outline: TC 83408 - Shipt Home Delivery link under Online Shopping will navigate to Shipt/Meijer page
    And the user sets testcase configurations '83408' '103165' '74109'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user Click on header menu online shopping
    Then click shipt from online shopping dropdown
#    Then validate Shipt page display successfully

    Examples:
      |  |
      |  |
