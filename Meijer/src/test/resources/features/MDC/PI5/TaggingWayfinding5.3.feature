Feature: Tagging of wayfinding tiles

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC - 50456 [Desktop]-Clicking on wayfinding tile on tier 3 and verifying URL with tier and category
    Given user navigate to test environment URL
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' to '<tier3>' submenu Tier3
#    Then verify the wayfinding tiles are displayed
    #Then verify wayfinding tiles displayed contains ICIDs '<tier2>' and '<tier3>'
    Then user clicks on wayfinding tiles '<tier2>' and '<tier3>'
#    Then verify displayed new page contains ICIDs '<tier2>' and '<tier3>'

    Examples:
      | zipCode | storeName | tier1   | tier2   | tier3 | TestCaseID | TestPointID | TestPlanID |
      | 49512   | Cascade   | Grocery | Produce | Fruit | 49593      | 29783       | 50455      |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC - 50454 Desktop-Clicking on wayfinding tile on tier 2 and verifying URL with tier and category
    Given user navigate to test environment URL
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user navigates Shop to '<tier1>' to '<tier2>' submenu Tier2
    Then user clicks on wayfinding tiles '<tier2>'

    Examples:
      | zipCode | storeName | tier1   | tier2   | TestCaseID | TestPointID | TestPlanID |
      | 49512   | Cascade   | Grocery | Produce | 50454      | 29781       | 49593      |