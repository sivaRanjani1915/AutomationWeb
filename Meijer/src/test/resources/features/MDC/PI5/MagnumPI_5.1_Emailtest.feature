Feature: MagnumPI_5.1_EmailTest.feature

  Background:
    Then clear all array list

  #TODO: Email Test not ran in Regression 5.1 Date: 2/8/17
  @Zombie
  Scenario Outline: TC 39897 - Enter valid datas in emailtest form
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then click on the email test
    Then email test form display
    Then enter firstname '<efirst_name>'
    Then enter lastname '<elast_name>'
    Then enter email '<eemail>'
    Then click on emailtest submit button
    Then verify the success status message

    Examples:
      | efirst_name               | elast_name                | eemail                | TestCaseID | TestPointID | TestPlanID |
      | siva                      | automation                | ransivwqaaw@gmail.com | TC_39897   | 5720        | 39711      |
      | sivasivasivasivasivasivas | automation                | sivaransqw@gmail.com  | TC_39901   | 5723        | 39711      |
      | automation                | ranranranranranranranranr | sivaefqd@gmail.com    | TC_39902   | 5724        | 39711      |

  @Zombie
  Scenario Outline: TC 39899 - Enter invalid datas in emailtest form
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then click on the email test
    Then email test form display
    Then enter firstname '<efirst_name>'
    Then enter lastname '<elast_name>'
    Then enter email '<eemail>'
    Then click on emailtest submit button
    Then verify the error message for invalid

    Examples:
      | efirst_name | elast_name | eemail            | TestCaseID | TestPointID | TestPlanID |
      | siva        | ran        | ransivagmail.com  | TC_39907   | 5728        | 39711      |
      | siva12      | ran        | sivaran@gmail.com | TC_39904   | 5726        | 39711      |
      | siva        | ran23      | sivae@gmail.com   | TC_39906   | 5727        | 39711      |

  @Zombie
  Scenario Outline: TC 39900 - Enter blank datas in emailtest form
    Given user navigate to MeijerDotCom
    And the user sets testcase configurations '<TestCaseID>' '<TestPointID>' '<TestPlanID>'
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then click on the email test
    Then email test form display
    Then enter firstname '<efirst_name>'
    Then enter lastname '<elast_name>'
    Then enter email '<eemail>'
    Then click on emailtest submit button
    Then verify the error message for blank

    Examples:
      | efirst_name | elast_name | eemail         | TestCaseID | TestPointID | TestPlanID |
      | siva        |            | ran@gmail.com  | TC_39908   | 5729        | 39711      |
      |             | ran        | fish@gmail.com | TC_39900   | 5722        | 39711      |
      | siva        | ran        |                | TC_41078   | 6465        | 39711      |
