Feature: CurbToNonCurb.feature

  Background:
    Then clear all array list

#########################################
# Curbside -> Non-Curbside - Keep Store #
#########################################
  @NR_DS_desktop
  Scenario Outline: TC 34318 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC - Click "keep Store"
    And the user sets testcase configurations '34318' '127674' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Keep Store button
    Then verify user has correct store '<storeName>'

    Examples:
      |  zipCode | storeName     | zipCode2 | storeName2 |
      |  49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35550 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+SPO - Click "keep Store"
    And the user sets testcase configurations '35550' '127681' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '6' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Keep Store button
    Then verify user has correct store '<storeName>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      |  49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35551 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+STH - Click "keep Store"
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Keep Store button
    Then verify user has correct store '<storeName>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | zipCode2 | storeName2 |
      | 35551 | 30049    | 3070    | 49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35552 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+SPO+STH - Click "keep Store"
    And the user sets testcase configurations '35552' '127682' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '6' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '2' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Keep Store button
    Then verify user has correct store '<storeName>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49534    | Standale   |

###########################################
# Curbside -> Non-Curbside - Change Store #
###########################################
  @NR_DS_desktop
  Scenario Outline: TC 35606 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC - Click "Change Store"
    And the user sets testcase configurations '35606' '127675' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '1' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Continue, Change Store button
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35608 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+SPO - Click "Change Store"
    And the user sets testcase configurations '35608' '127684' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '3' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Continue, Change Store button
    Then verify user has correct store '<storeName2>'

    Examples:
      |  zipCode | storeName     | zipCode2 | storeName2 |
      |  49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35609 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+STH - Click "Change Store"
    And the user sets testcase configurations '35609' '127685' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '6' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Continue, Change Store button
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35612 - Pop Up Message When Changing Store - Curbside -> Non-Curbside - CNC+SPO+STH - Click "Change Store"
    And the user sets testcase configurations '35612' '127686' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify changing from Curbside to Non-Curbside conflict modal appears
    Then user clicks Continue, Change Store button
    Then verify user has correct store '<storeName2>'

    Examples:
      |  zipCode | storeName     | zipCode2 | storeName2 |
      |  49525   | Knapps Corner | 49534    | Standale   |

#############################################
# Curbside -> Non-Curbside - No Pop Message #
#############################################
  @NR_DS_desktop
  Scenario Outline: TC 35548 - NO Pop Up Message When Changing Store - Curbside -> Non-Curbside - SPO
    And the user sets testcase configurations '35548' '127676' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '6' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      |zipCode | storeName     | zipCode2 | storeName2 |
      | 49525  | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35553 - NO Pop Up Message When Changing Store - Curbside -> Non-Curbside - STH
    And the user sets testcase configurations '35553' '127683' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      |  49525   | Knapps Corner | 49534    | Standale   |

  @SKIP
  Scenario Outline: TC 35554 - NO Pop Up Message When Changing Store - Curbside -> Non-Curbside - SPO+STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | zipCode2 | storeName2 |
      | 35554 | 64661    | 3070    | 49525   | Knapps Corner | 49534    | Standale   |

  @Zombie
  Scenario Outline: TC 35555 - NO Pop Up Message When Changing Store - Curbside -> Non-Curbside - Empty Cart
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49418    | Grandville |

#########################################
# Curbside -> Curbside - No Pop Message #
#########################################
  @NR_DS_desktop
  Scenario Outline: TC 35556 - NO Pop Up Message When Changing Store - Curbside -> Curbside - CNC
    And the user sets testcase configurations '35565' '127691' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49512    | Cascade    |

  @SKIP
  Scenario Outline: TC 35557 - NO Pop Up Message When Changing Store - Curbside -> Curbside - CNC+SPO
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '5' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | zipCode2 | storeName2 |
      | 35557 | 64663    | 3070    | 49525   | Knapps Corner | 49512    | Cascade    |

  @SKIP
  Scenario Outline: TC 35559 - NO Pop Up Message When Changing Store - Curbside -> Curbside - CNC+STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | zipCode2 | storeName2 |
      | 35559 | 64664    | 3070    | 49525   | Knapps Corner | 49512    | Cascade    |

  @SKIP
  Scenario Outline: TC 35562 - NO Pop Up Message When Changing Store - Curbside -> Curbside - CNC+SPO+STH
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'cnc' product
    Then select item '5' with desire qty '1' and Add to Cart
    Then user searches for 'spo' product
    Then select item '3' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName     | zipCode2 | storeName2 |
      | 49525   | Knapps Corner | 49428    | Jenison    |

  @SKIP
  Scenario Outline: TC 35639 - NO Pop Up Message When Changing Store - Curbside -> Curbside - Empty Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName     | zipCode2 | storeName2 |
      | 35639 | 64665    | 3070    | 49525   | Knapps Corner | 49428    | Jenison    |

#############################################
# Non-Curbside -> Curbside - No Pop Message #
#############################################
  @NR_DS_desktop
  Scenario Outline: TC 35563 - NO Pop Up Message When Changing Store - NON-Curbside -> Curbside - SPO
    And the user sets testcase configurations '35563' '127679' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '6' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      |  zipCode | storeName | zipCode2 | storeName2    |
      | 49534   | Standale  | 49525    | Knapps Corner |

  @SKIP
  Scenario Outline: TC 35565 - NO Pop Up Message When Changing Store - NON-Curbside -> Curbside - STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2    |
      | 35565 | 30916    | 3070    | 49534   | Standale  | 49525    | Knapps Corner |

  @SKIP
  Scenario Outline: TC 35566 - NO Pop Up Message When Changing Store - NON-Curbside -> Curbside - SPO+STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2    |
      | 35566 | 30920    | 3070    | 49534   | Standale  | 49525    | Knapps Corner |

  @SKIP
  Scenario Outline: TC 35567 - NO Pop Up Message When Changing Store - NON-Curbside -> Curbside - Empty Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2    |
      | 35567 | 64666    | 3070    | 49534   | Standale  | 49525    | Knapps Corner |

#################################################
# Non-Curbside -> Non-Curbside - No Pop Message #
#################################################
  @NR_DS_desktop
  Scenario Outline: TC 35568 - NO Pop Up Message When Changing Store - NON-Curbside -> Non-Curbside - SPO
    And the user sets testcase configurations '35568' '127680' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '8' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | zipCode | storeName | zipCode2 | storeName2 |
      | 49534   | Standale  | 49418    | Grandville |

  @SKIP
  Scenario Outline: TC 35570 - NO Pop Up Message When Changing Store - NON-Curbside -> Non-Curbside - STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 35570 | 30924    | 3070    | 49534   | Standale  | 49418    | Grandville |

  @SKIP
  Scenario Outline: TC 35572 - NO Pop Up Message When Changing Store - NON-Curbside -> Non-Curbside - SPO+STH
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user searches for 'spo' product
    Then select item '4' with desire qty '1' and Add to Cart
    Then user searches for 'sth' product
    Then select item '2' with desire qty '1' and Add to Cart
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 35572 | 30928    | 3070    | 49534   | Standale  | 49418    | Grandville |

  @SKIP
  Scenario Outline: TC 35573 - NO Pop Up Message When Changing Store - NON-Curbside -> Non-Curbside - Empty Cart
    When the user sets testcase configurations '<TC_ID>' '<POINT_ID>' '<PLAN_ID>'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    When user searches '<zipCode2>' and sets store to '<storeName2>'
    Then verify user has correct store '<storeName2>'

    Examples:
      | TC_ID | POINT_ID | PLAN_ID | zipCode | storeName | zipCode2 | storeName2 |
      | 35573 | 30930    | 3070    | 49534   | Standale  | 49418    | Grandville |
