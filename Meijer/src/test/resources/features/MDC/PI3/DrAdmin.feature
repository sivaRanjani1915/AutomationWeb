Feature: DrAdmin

  @happy
  Scenario Outline: 9118 QA [FE] Clicking on the Store ID must display all of the UPCs that are being bypassed
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    When user selects store '<store>'

    #Service call needed
    #	Then verify that all bypassed upcs are displayed
    Examples:
      | username | password | store |
      | 9997650  | iMeijer1 | 25    |

  @TestDrAdmin12
  Scenario Outline: TC9106 Clicking on the UPC must display all of the stores that are being bypassed
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab

    When user selects upc '<upc>'
    #Service call needed
    #	Then verify that all meijer corporate stores are displayed
    #	When user run findOverridesByFlag.sql and search for same store
    #	Then compare flags of database and flags displayed on DrAdmin
    Examples:
      | username | password | upc  |
      | 9997650  | iMeijer1 | 4011 |

  @TestDrAdmin12
  Scenario Outline: TC9361 Override Table Entries match DrAdmin Frontend UPC toggles both set to OFF
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    #	When user run findOverridsByFlag.sql and search for UPC with both flags set to false
    When user searches for upc '<upc>'
    When user selects upc '<upc>'
    #	When user selects entry for the store that corresponds to query
    Then verify display override toggle is Off
    Then verify orderable override toggle is Off

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @Test
  Scenario Outline: TC9362 Override Table Entries match DrAdmin Frontend UPC toggle display bypass On, Cart bypass Off
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    #user run findOverridesbyFlag.sql with display set to false and cart bypass to true
    When user searches for upc '<upc>'
    When user selects upc '<upc>'
    #	When user select the entry for the store that corresponds to your query
    #	Then the UPC toggle for display bypass is off, and the toggle for cart bypass is on
    Then verify display override toggle is Off
    Then verify orderable override toggle is On

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @Test
  Scenario Outline: TC9363 Override Table Entries match DrAdmin Frontend UPC toggles both set to ON
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    #user run findOverridesByFlag.sql and search for a UPC with both flags set to true
    When user searches for upc '<upc>'
    When user selects upc '<upc>'
    #	When user select the entry for the store that corresponds to your query
    Then verify display override toggle is On
    Then verify orderable override toggle is On

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @Test
  Scenario Outline: TC9364 Override Table Entries match DrAdmin Frontend UPC toggle display bypass OFF, Cart bypass ON
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    #user run findOverridesbyFlag.sql with display set to false and cart bypass to true
    When user searches for upc '<upc>'
    When user selects upc '<upc>'
    #	When user select the entry for the store that corresponds to your query
    #	Then the UPC toggle for display bypass is off, and the toggle for cart bypass is on
    Then verify display override toggle is Off
    Then verify orderable override toggle is On

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @Test
  Scenario Outline: TC10894 Adding UPC to bypass table will add the UPC to the database for all stores with flags set to OFF
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Add UPC to Bypass Table button
    Then verify Add UPC modal opens
    Then verify Save button is disabled
    #run findValidUPC.sql to find valid UPC
    When user types UPC in add search box '<upc>'
    When user clicks Search button
    When user clicks Add Save button
    Then verify upc is added to top of list '<upc>'
    Then verify display override toggle is Off
    Then verify orderable override toggle is Off
    When user selects upc '<upc>'

    #Service call needed
    #	Then verify that all meijer corporate stores are displayed
    #verify that database had been updated with new upc and all stores
    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @Test
  Scenario Outline: TC10895 Adding UPC to bypass table that already exists
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Add UPC to Bypass Table button
    Then verify Add UPC modal opens
    Then verify Save button is disabled
    #run findValidUPC.sql to find valid UPC
    When user types UPC in add search box '<upc>'
    When user clicks Search button
    When user clicks Add Save button

    #	Then verify upc is merged with previous upc
    #Service call needed
    #	Then verify that all meijer corporate stores are displayed
    #verify that database had been updated with new upc and all stores
    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @TestDrAdmin12
  Scenario Outline: TC9077 UPC is found When adding UPC to bypass table in Search by UPC
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Add UPC to Bypass Table button
    Then verify Add UPC modal opens
    #		Then verify Save button is disabled
    #	Run findValidUPC.sql to find a upc that is in the tore but not in the bypass table
    When user types UPC in add search box '<upc>'
    When user clicks Search button
    #		Then verify UPC was found in UI and database table
    Then verify adding upc message
    #	"This UPC will be added to all stores with 'display override' and 'Add to Cart' set to Off"
    Then verify Save button is enabled

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 112 |

  @TestDrAdmin
  Scenario Outline: TC9602 UPC is not found When adding UPC to bypass table in Search by UPC
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Add UPC to Bypass Table button
    Then verify Add UPC modal opens
    #	Then verify Save button is disabled
    #Use Invalid UPC
    When user types UPC in add search box '<upc>'
    When user clicks Search button
    Then verify Save button is disabled
    Then verify Adding Upc Error Message
    #"UPC not found"
    Then verify Save button is disabled

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 1   |

  @Test
  Scenario Outline: TC9112 Turn ON display only flag for one upc (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
#    Then list of stores with toggles appear
    When user clicks store checkbox '<store_id>'
    Then verify edit selected button is now active
    When user clicks edit selected button
    When user Set display override toggle to ON
    When user clicks Add Save button save button
    Then display override for that store has been set to ON
    Then select a store id checkbox
    When user clicks edit selected button
    When user click "Save" button
    Then display override for that store has been set to OFF

    Examples:
      | username | password | upc |
      | 9997650  | iMeijer1 | 4001|

  @Test
  Scenario Outline: TC9114 Edit display only flag for multiple upcs (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then list of stores with toggles appear
    Then verify edit selected button is active
    When user selects multiple store id checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for stores has changed to ON
    Then verify checkboxes are unchecked
    When user selects multiple store id checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Save button
    Then display override for stores has changed to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9115 Turn ON display and add to cart flags for one upc (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user change display override toggle
    Then verify display override toggle is set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle is set to ON
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    When user clicks Edit Save button
    Then orderable override for that store has changed to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9116 Turn ON display and add to cart flags for multiple upcs (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then list of upcs with toggles appear
    When user clicks store checkbox '<store>'
    When user clicks store checkbox on '<store>'
    When user clicks store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override for select upcs are set to ON
    Then verify checkboxes are unchecked

    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9343  Cancel button on edit UPC modal (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is inactive
    When user clicks check upc checkbox on '<upc>'
    When user clicks edit selected button
    When user change display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    When user click Cancel button
    Then verify display override toggle is still set to ON
    Then verify checkboxes still checked
    Then verify cancel button did not update upc settings
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9344 X close button on edit UPC modal (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is inactive
    When user clicks check upc checkbox on '<upc>'
    When user clicks edit selected button
    When user change display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    When user click X close button
    Then verify display override toggle is still set to ON
    Then verify checkboxes still checked
    Then verify cancel button did not update upc settings
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9346 Turn ON Add to Cart flag only for one upc for which Display is OFF (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check upc checkbox on '<upc>' for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected upc
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC9347 Turn ON Add to Cart flag only for multiple upcs for which Display is OFF (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check upc checkbox on '<upc>'
    When user clicks check upc checkbox on '<upc>' for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC15957 Turn OFF display only flag for one upc where orderable override is ON (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check upc checkbox on '<upc>' for which Display is OFF
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    Then user change orderable override toggle to ON
    When verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected upc
    Then verify checkboxes are unchecked
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC16009 Turn OFF display only flag for multiple upc where orderable override is ON (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check upc checkbox on '<upc>'
    When user clicks check upc checkbox on '<upc>' for which Display is OFF
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected upcs
    Then verify checkboxes are unchecked
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF for selected upcs
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC17718 Turn OFF display only flag for all upcs where orderable override is ON (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then display override and orderable override toggles set to ON for all upcs
    Then verify checkboxes are unchecked
    When user clicks check all upcs checkbox
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF for all upcs
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18045 Edit display and add to cart flags for all upcs (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check upc checkbox on '<upc>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override for all upcs has changed to ON
    Then verify checkboxes are unchecked
    When user clicks check all upcs checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override for all upcs has changed to ON
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18293 Edit display only flag for all upcs (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check all upcs checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for all upcs is set to ON
    Then verify checkboxes are unchecked
    When user clicks check all upcs checkbox
    When user clicks edit selected button
    When user change display override toggle to OFF
    When user clicks Edit Save button
    Then display override for all upcs has changed to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18361 Turn ON Add to Cart flag only for all upcs for which Display is OFF (UPC by Store)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    When user clicks Search by Store tab
    Then verify edit selected button is inactive
    When user selects store '<store>'
    Then list of upcs with toggles appear
    Then verify edit selected button is active
    When user clicks check all upcs checkbox for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override toggles set to ON for all upcs
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18364 Turn ON display only flag for one store (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for selected store is set to ON
    Then verify checkboxes are unchecked
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user changed display override toggle to OFF
    When user clicks Edit Save button
    Then display override for selected store is set to ON
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18367 Edit display only flag for multiple stores (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for selected stores is set to ON
    Then verify checkboxes are unchecked
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for selected stores is set to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18368 Turn ON display and add to cart flags for one store (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user change display override toggle
    Then verify display override toggle is set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle is set to ON
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user changed display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    When user clicks Edit Save button
    Then orderable override for that store has changed to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18369 Turn ON display and add to cart flags for multiple stores (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles have changed to ON for selected stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18370 Cancel button on edit UPC modal (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is inactive
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user changed display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    Then click Cancel button
    Then verify display override toggle is still set to ON
    Then verify checkboxes still checked
    Then verify cancel button did not update upc settings
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18371 X close button on edit UPC modal (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is inactive
    When user clicks check store checkbox on '<store>'
    When user clicks edit selected button
    When user changed display override toggle to OFF
    When user clicks edit selected button
    When user change orderable override toggle to OFF
    Then click X close button
    Then verify display override toggle is still set to ON
    Then verify checkboxes still checked
    Then verify cancel button did not update upc settings
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18383 Turn ON Add to Cart flag only for one store for which Display is OFF (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>' for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected store
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18429 Turn ON Add to Cart flag only for multiple stores for which Display is OFF (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>' for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18463 Turn OFF display only flag for one store where orderable override is ON (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>' for which Display is OFF
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected store
    Then verify checkboxes are unchecked
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18505 Turn OFF display only flag for multiple stores where orderable override is ON (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check store checkbox on '<store>'
    When user clicks check store checkbox on '<store>' for which Display is OFF
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then verify display override and orderable override toggles set to ON for selected stores
    Then verify checkboxes are unchecked
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF for selected stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18541 Turn OFF display only flag for all stores where orderable override is ON (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    Then display override toggle will be set to ON
    When user change orderable override toggle to ON
    Then verify orderable override toggle set to ON
    When user clicks Edit Save button
    Then display override and orderable override toggles set to ON for all stores
    Then verify checkboxes are unchecked
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to OFF
    Then display override and orderable override toggles set to OFF
    When user clicks Edit Save button
    Then verify table updated with display override and orderable override toggles set to OFF for all stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18598 Edit display and add to cart flags for all stores (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override for all stores is set to ON
    Then verify checkboxes are unchecked
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override for all stores is set to ON
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18616 Edit display only flag for all stores (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user change display override toggle to ON
    When user clicks Edit Save button
    Then display override for all stores is set to ON
    Then verify checkboxes are unchecked
    When user clicks check all stores checkbox
    When user clicks edit selected button
    When user changed display override toggle to OFF
    When user clicks Edit Save button
    Then display override for all stores is to OFF
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |

  @Test
  Scenario Outline: TC18624 Turn ON Add to Cart flag only for all stores for which Display is OFF (Store by UPC)
    Given user navigates to DrAdmin
    When user signs in to DrAdmin with '<username>' and '<password>'
    When user clicks UPC Override tab
    Then verify edit selected button is inactive
    When user selects upc '<upc>'
    Then verify list of stores with toggles opens
    Then verify edit selected button is active
    When user clicks check all stores checkbox for which Display is OFF
    When user clicks edit selected button
    When user change orderable override toggle to ON
    When user clicks Edit Save button
    Then display override and orderable override toggles set to ON for all stores
    Then verify checkboxes are unchecked
    Examples:
      | username | password | upc |
