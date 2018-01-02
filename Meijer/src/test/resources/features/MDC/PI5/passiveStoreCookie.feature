Feature: passiveStoreCookies.feature

  Background:
    Then clear all array list

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44311 - verify DefaultStoreNotificationCookie set 158 and saved in DefaultStore cookie and clicks keep store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44311' '19823' '39631'
    When user searches '49512' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user selects Keep this Store on passive store selection modal
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal
    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44312 - verify DefaultStoreNotificationCookie set 158 and saved in DefaultStore cookie and clicks select new store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44312' '19824' '39631'
    When user searches '49512' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user clicks Select New Store on passive store selection modal
    Then user selects new store from an already open store selection modal
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal

    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44313 - verify DefaultStoreNotificationCookie set 158 and saved in DefaultStore cookie and clicks off modal to close it
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44313' '19825' '39631'
    When user searches '49512' and sets store to 'Knapps Corner'
    Then verify user has correct store 'Knapps Corner'
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user clicks Off of passive store selection modal to close it
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal

    Examples:
      |  |
      |  |

#first time dialogue cookie is deployed, this will be the case (if user had store other than 158 stored in cookie)
  @PI5
  @OUT_DATED
  Scenario Outline: TC 44314 - verify DefaultStoreNotificationCookie is set when DefaultStore cookie empty, set 158 based on geo and clicks keep store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44314' '19826' '39631'
    Then verify the Passive Store modal is displayed
    Then user selects Keep this Store on passive store selection modal
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal

    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44315 - verify DefaultStoreNotificationCookie is set when DefaultStore cookie empty, set 158 based on geo and clicks select new store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44315' '19827' '39631'
    Then verify the Passive Store modal is displayed
    Then user clicks Select New Store on passive store selection modal
    Then user selects new store from an already open store selection modal
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal

    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44316 - verify DefaultStoreNotificationCookie is set when DefaultStore cookie empty set 158 based on geo and clicks off modal to close it
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44316' '19828' '39631'
    Then verify the Passive Store modal is displayed
    Then user clicks Off of passive store selection modal to close it
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal

    Examples:
      |  |
      |  |

# Passive Store Selection default Store Cookie
  @PI5
  @OUT_DATED
  Scenario Outline: TC 44317 - verify DefaultStore cookie remains unchanged when user has 158 saved and clicks keep store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44317' '19829' '39631'
    When user searches '<zip>' and sets store to '<store>'
    Then verify user has correct store 'Knapps Corner'
    Then grab and save store name from header
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user clicks Keep this Store on passive store selection modal
    Then verify DefaultStore cookie remains unchanged

    Examples:
      | zip   | store         |
      | 49512 | Knapps Corner |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44318 - verify DefaultStore cookie set to users selection and clicks select new store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44318' '19830' '39631'
    When user searches '<zip>' and sets store to '<store>'
    Then verify user has correct store 'Knapps Corner'
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user clicks Select New Store on passive store selection modal
    Then user selects new store from an already open store selection modal
    Then verify store saved in DefaultStore cookie matches store in header

    Examples:
      | zip   | store         |
      | 49512 | Knapps Corner |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 44319 - verify DefaultStore cookie remains unchanged when user has 158 and clicks off modal to close it
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '44319' '19831' '39631'
    When user searches '<zip>' and sets store to '<store>'
    Then verify user has correct store 'Knapps Corner'
    Then delete cookie to simulate having not seen Passive Store modal
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then verify the Passive Store modal is displayed
    Then user clicks Off of passive store selection modal to close it
    Then verify DefaultStore cookie remains unchanged

    Examples:
      | zip   | store         |
      | 49512 | Knapps Corner |

###############################
#first time dialogue cookie is deployed, this will be the case (if user had store other than 158 stored in cookie)
  @PI5
  @OUT_DATED
  Scenario Outline: TC 40320 - verify DefaultStore cookie set 158 when DefaultStore cookie empty, set to 158 based on geo and clicks keep store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations 'TC_40320' '5844' '39631'
    Then grab and save store name from header
    Then verify the Passive Store modal is displayed
    Then user clicks Keep this Store on passive store selection modal
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal
    Then verify DefaultStore cookie remains unchanged

    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 40326 - verify DefaultStore cookie set to users selection when DefaultStore cookie empty, set to 158 based on geo and clicks select new store
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '40326' '5849' '39631'
    Then verify the Passive Store modal is displayed
    Then user clicks Select New Store on passive store selection modal
    Then user selects new store from an already open store selection modal
    Then grab and save store name from header
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal
    Then verify store saved in DefaultStore cookie matches store in header

    Examples:
      |  |
      |  |

  @PI5
  @OUT_DATED
  Scenario Outline: TC 40328 - verify DefaultStore cookie set when store other than 158 saved in DefaultStore cookie
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    And the user sets testcase configurations '40328' '5851' '39631'
    Then verify the Passive Store modal is displayed
    Then user clicks Off of passive store selection modal to close it
    Then verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal
    Then verify DefaultStore cookie is set to '<store>'
    Then verify user has correct store 'Knapps Corner'

    Examples:
      | store         |
      | Knapps Corner |
