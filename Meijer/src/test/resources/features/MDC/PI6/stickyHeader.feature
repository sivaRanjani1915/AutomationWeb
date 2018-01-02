Feature: StickyHeader

  @StickyHeader123
  Scenario Outline: TC 74376 Quickshop works in stickyheader
    Then the user sets testcase configurations '74376' '75856' '74109'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display

    Examples:
      |email |password|
      | matt_auto1@gmail.com|password1|

  @StickyHeader1234
  Scenario Outline: TC 74378 Shopping list works in stickyheader
    Then the user sets testcase configurations '74378' '75857' '74109'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    Then user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    Then user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then user click Shopping List option from the account header
    Then validate Shopping List Modal is displayed

    Examples:
      |email |password|
      | matt_auto1@gmail.com|password1|

  @StickyHeader123
  Scenario Outline: TC 74379 Order history works in stickyheader
    Then the user sets testcase configurations '74379' '75858' '74109'
    Given user navigate to test environment URL
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then user navigate to Order History from the account header
    Then order history summary page display

    Examples:
      |email |password|
      | matt_auto1@gmail.com|password1|

  @StickyHeader123
  Scenario Outline: TC 74380 Create Account works in stickyheader
    Then the user sets testcase configurations '74380' '75859' '74109'
    Given user navigate to test environment URL
    Then user click create account from the account header
    Then verify create account modal displays

    Examples:
      | |
      | |

  @StickyHeader123
  Scenario Outline: TC 74381 Sign in works in stickyheader
    Then the user sets testcase configurations '74381' '75860' '74109'
    Given user navigate to test environment URL
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'

    Examples:
      |email |password|
      | matt_auto1@gmail.com|password1|

  @StickyHeader123
  Scenario Outline: TC 74382 Hide banner and navigation when scrolling down
    Then the user sets testcase configurations '74382' '75861' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify banner and navigation is not displayed

    Examples:
      | |
      | |

  @StickyHeader123
  Scenario Outline: TC 74384 The banner and naviagation should return when at top of page
    Then the user sets testcase configurations '74384' '75862' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify banner and navigation is not displayed
    Then user scroll page up
    Then verify banner and navigation are displayed

    Examples:
      | |
      | |

#    Tested in 74384
  @StickyHeader
  Scenario Outline: TC 74385 Not able to click on navigation when scrolled down
    Then the user sets testcase configurations '74385' '75863' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
#    Then verify user no/t able to click on services tab

    Examples:
      | |
      | |

  #Manual  
  @StickyHeader
  Scenario Outline: TC 75019 Shop menu changes to hamburger in sticky mode
    Then the user sets testcase configurations '75019' '88911' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu

    Examples:
      | |
      | |

  #Manual
  @StickyHeader
  Scenario Outline: TC 75021 Shop Hamburger contains all components of original shop menu
    Then the user sets testcase configurations '75021' '88912' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu
    Then click on shop menu
    Then verify that all components are displayed

    Examples:
      | |
      | |

  #Manual
  @StickyHeader
  Scenario Outline: TC 75022 Hamburger is located to the left of main Meijer logo
    Then the user sets testcase configurations '75022' '88913' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu
    Then verify hamburger is located to the left of the Meijer logo

    Examples:
      | |
      | |

  #Manual
  @StickyHeader
  Scenario Outline: TC 75026 All menu elements have decreased in size for smaller resolution screens
    Then the user sets testcase configurations '75026' '88914' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu
    Then verify all menu elements have smaller size

    Examples:
      | |
      | |

    #Manual
  @StickyHeader
  Scenario Outline: TC 75029 All elements of shop menu link to respective pages
    Then the user sets testcase configurations '75029' '88915' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu
    Then verify each link opens respective tier page

    Examples:
      | |
      | |

#Manual
  @StickyHeader
  Scenario Outline: TC 75030 Hamburger menu has same layout as original shop menu
    Then the user sets testcase configurations '75030' '88916' '74109'
    Given user navigate to test environment URL
    Then user scroll page down
    Then verify shop menu changes to hamburger menu
    Then verify shop menu has same layout as original

    Examples:
      | |
      | |






