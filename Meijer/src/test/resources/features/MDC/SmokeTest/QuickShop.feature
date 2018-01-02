Feature: QuickShop.feature

  Background:
    Then clear all array list

###########################
# QUICK SHOP DISPLAY PAGE #
###########################
  ##########################
  # FSO - Fully Signed Out #
  ##########################
  @NR_DS_desktop
  Scenario Outline: TC 57380 - quickshop is not available to logged out users
    And the user sets testcase configurations '57380' '116998' '3070'
    Given user navigate to MeijerDotCom
    Then user click Quick Shop from the account header
    Then verify quickshop lists are not present

    Examples:
      |  |
      |  |

  #########################
  # FSI - Fully Signed In #
  #########################
  @NR_DS_desktop
  Scenario Outline: TC 9404 - Breadcrumbs - Quick Shop Page
    And the user sets testcase configurations '9404' '116999' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email '<email>'
    Then user should navigate to Enter Password screen
    When user enter valid password '<password>'
    Then Meijer Home page displays User is signed in successfully
    Then reset shopping cart to 0 item - mini cart
    Then user closes miniCart
    When user searches '<zipCode>' and sets store to '<storeName>'
    Then verify user has correct store '<storeName>'
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks view all form your favorites
    Then user verify look and feel of breadcrumbs

    Examples:
      | email                  | password  | zipCode | storeName     |
      | meijer_auto3@email.com | password1 | 49525   | Knapps Corner |

  ########################
  # SSI - Semi Signed In #
  ########################
  @NR_DS_desktop
  Scenario Outline: TC 57396 - User is able to access quickshop from accounts menu in SSI state
    And the user sets testcase configurations '57396' '117000' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    When user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then validate SSI Quick Shop 'Favorites' section

    Examples:
      |  |
      |  |

################################################
# My Favorites & My Shopping List Icons Action #
################################################
  ##########################
  # FSO - Fully Signed Out #
  ##########################
  @NR_DS_desktop
  Scenario Outline: TC 95439 - User is prompted to login after clicking FAVORITES icon - Guest
    And the user sets testcase configurations '95439' '117001' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'apple' product
    Then user randomly selects '<icon>' icon on product via Search Results
    Then verify user is prompted with 'Please sign in' modal

    Examples:
      | icon  |
      | heart |

  @NR_DS_desktop
  Scenario Outline: TC 95440 - User is prompted to login after clicking my SHOPPING LIST icon - Guest
    And the user sets testcase configurations '95440' '117002' '3070'
    Given user navigate to MeijerDotCom
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user searches for 'apple' product
    Then user randomly selects '<icon>' icon on product via Search Results
    Then verify user is prompted with 'Please sign in' modal

    Examples:
      | icon |
      | list |

  #########################
  # FSI - Fully Signed In #
  #########################
  @NR_DS_desktop
  Scenario Outline: TC 95441 - User is allowed to click FAVORITES icon - Sign In
    And the user sets testcase configurations '95441' '117003' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user searches for 'apple' product
    Then user randomly selects '<icon>' icon on product via Search Results
    Then verify user is NOT prompted with 'Please sign in' modal

    Examples:
      | icon  |
      | heart |

  @NR_DS_desktop
  Scenario Outline: TC 95443 - User is allowed to click SHOPPING LIST icon - Sign In
    And the user sets testcase configurations '95443' '117005' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'matt_visa@gmail.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    Then user searches for 'apple' product
    Then user randomly selects '<icon>' icon on product via Search Results
    Then verify user is NOT prompted with 'Please sign in' modal

    Examples:
      | icon |
      | list |

  ########################
  # SSI - Semi Signed In #
  ########################
  @NR_DS_desktop
  Scenario Outline: TC 95448 - user is prompted for login after clicking favorites icon in quickshop - SSI
    And the user sets testcase configurations '95448' '117009' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'autoRegression1@email.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks '<icon>' icon on product via QuickShop page
    Then verify user is prompted with 'Please sign in' modal

    Examples:
      | icon  |
      | heart |

  @NR_DS_desktop
  Scenario Outline: TC 95449 - user is prompted for login after clicking my list icon on quickshop - SSI
    And the user sets testcase configurations '95449' '117010' '3070'
    Given user navigate to test environment URL
    Then Meijer Home page displays for Guest user
    Then user clicks Keep this Store on passive store selection modal
    Then user click Sign In from the account header
    And user enter correct email 'autoRegression1@email.com'
    Then user should navigate to Enter Password screen
    When user enter valid password 'password1'
    Then Meijer Home page displays User is signed in successfully
    # SSI
    Then user closes and opens browser to enter SSI state
    Then user click Quick Shop from the account header
    Then validate Quick Shop Page display
    Then user clicks '<icon>' icon on product via QuickShop page
    Then verify user is prompted with 'Please sign in' modal

    Examples:
      | icon |
      | list |