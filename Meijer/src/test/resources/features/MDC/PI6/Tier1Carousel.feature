Feature: Tier1Carousel

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 66256 - Total of 20 products in all pages
    Given user navigate to test environment URL
    When user navigates Shop to '<tier1>' submenu Tier1
    Then verify best sellers carousel is displayed
    Then verify best sellers carousel has total of 20 products

    Examples:
      | tier1   |
      | Grocery |
