Feature: quantitySteppersPDP.feature

  Background:
    Then clear all array list
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49181 - verify minus quantity stepper cannot cause quantity to drop below 1 for eaches
    Given user navigate to test environment URL
    And the user sets testcase configurations '49181' '28464' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'alt_uom:ea' product
    Then at random, click on a product to view its PDP
    Then verify quantity field displays errors on pdp page
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then click PLUS quantity stepper on pdp page and verify quantity in quantity field goes up by 1
    Then click MINUS quantity stepper on pdp page and verify quantity in quantity field goes down by 1
    Then click MINUS quantity stepper on pdp page
    Then verify value in quantity field on pdp page is 1

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49182 - verify invalid quantity values produce a warning and disable add to cart
    Given user navigate to test environment URL
    And the user sets testcase configurations '49182' '28467' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'upc:21307600000' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then type '1.10' into quantity field on pdp page
    Then verify error Please enter increments of stepsize
    Then verify add to cart button is disabled on pdp page

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49183 - verify minus stepper reduces quantity field by 1 for eaches
    Given user navigate to test environment URL
    And the user sets testcase configurations '49183' '28470' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'is_random_weight:false' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then type '10' into quantity field on pdp page
    Then click MINUS quantity stepper on pdp page
    Then click MINUS quantity stepper on pdp page and verify quantity in quantity field goes down by 1

    Examples:
      |  |
      |  |
  
  @PI5
  @OUT_DATED
  Scenario Outline: TC 49184 - verify plus stepper increases quantity field by 1 for eaches
    Given user navigate to test environment URL
    And the user sets testcase configurations '49184' '28473' '45068'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'is_random_weight:false' product
    Then at random, click on a product to view its PDP
    Then verify display of PDP page
    Then type '10' into quantity field on pdp page
    Then click PLUS quantity stepper on pdp page and verify quantity in quantity field goes up by 1

    Examples:
      |  |
      |  |
