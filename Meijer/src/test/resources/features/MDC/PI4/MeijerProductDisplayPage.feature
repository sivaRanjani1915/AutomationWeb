Feature: MeijerProductDisplayPage.feature

  Background:
    Then clear all array list

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33198 - Update Parameters for addItem Request - CNC - In Stock
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<item_Parameter>' product
    Then user verify number of items displayed per page is 40
    And user verify Store against each item and main store selected are same

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | item_Parameter |
      | 33198 | 30114    | 3070    | 49512   | Cascade   | alt_uom:ea     |

  @PI4
  @OUT_DATED
  Scenario Outline: TC 33200 - Update Parameters for addItem Request - CNC - Out of Stock
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<item_Parameter>' product
    Then user verify number of items displayed per page is 40
    And user verify Store against each item and main store selected are same

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | item_Parameter    |
      | 33200 | 30120    | 3070    | 49512   | Cascade   | is_sellable:false |
  
  @PI4
  @OUT_DATED
  Scenario Outline: TC 33201 - Update Parameters for addItem Request - CNC - In Store Only
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for '<item_Parameter>' product
    Then user verify number of items displayed per page is 40
    And user verify Store against each item and main store selected are same

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | item_Parameter             |
      | 33201 | 30117    | 3070    | 49512   | Cascade   | is_click_and_collect:false |