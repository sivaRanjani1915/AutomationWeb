#Author: pritam.maibam@meijer.com
Feature: MyList.feature

  Background:
    Then clear all array list

  @NR_DS_desktop
  Scenario Outline: TC 1676 - My List Counter >= 1 - Sign-In
    And the user sets testcase configurations '1676' '30022' '3070'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user click Shopping List option from the account header
    Then clear Shopping List if any value is present
    Then user click Shopping List option from the account header
    Then enter '2' in Shopping List
    Then user click Shopping List option from the account header
    Then validate Shopping List count '2'

    Examples:
      | email                   | password  |
      | testautomation1@tcs.com | password1 |

  @NR_DS_desktop
  Scenario Outline: TC 1675 - My List Counter = 0 - Sign-In
    And the user sets testcase configurations '1675' '30022' '3070'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user click Shopping List option from the account header
    Then clear Shopping List if any value is present
    Then user clicks account header caret
    Then validate Shopping List count '0'

    Examples:
      | email               | password  |
      | matt_visa@gmail.com | password1 |


  @NR_DS_desktop
  Scenario Outline: TC 1240 - My List moves from the header to the My Account drop down - Anonymous
    And the user sets testcase configurations '1240' '29984' '3070'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user searches '<str_zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user click Shopping List option from the account header
    Then validate Please Sign-In to Create Your Shopping List popup modal display
    Then click on Sign-In button on Sign-In to Create Your Shopping List modal
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user click Shopping List option from the account header
    Then validate Shopping List Modal is displayed

    Examples:
      |  email                    | password  | str_zipCode | storeName     |
      |  pritest_auto24@gmail.com | Selenium1 | 49525       | Knapps Corner |

  @NR_DS_desktop
  Scenario Outline: TC 1241 - My List moves from the header to the My Account drop down - Signed-In
    And the user sets testcase configurations '1241' '29985' '3070'
    Given user navigate to MeijerDotCom
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    Then user click Shopping List option from the account header
    Then validate Shopping List Modal is displayed

    Examples:
      | email                    | password  |
      | pritest_auto24@gmail.com | Selenium1 |

