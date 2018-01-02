#Author: jordan.palma@meijer.com
Feature: Generic Regression - Button Functionality in Search Results

  Background:
    Then clear all array list

  @validateMaintanance
  Scenario Outline: RTC010 - Validating Button Functionality - Product Tiles
    #Then validate choking hazard popup message display
    #Then validate No Grocery Substitution options field display
    #Then validate No text field for comments display
    #Then validate order status after successfully cancelled order
    Then revalidate selected item details

    Then user validate pickup information on Order Review Page without Car desc curbside '<pickup_location>'
    Then user validate pickup information on Order Review Page without car desc Deli-Cake '<pickup_location>'
    Then user validate Shipping information display on Order Review Page '<address1>' '<ccaddress2>' '<dvry_methd>'

    Then validate add item modal display correctly
    Then validate Add X items button is enabled
    Then validate auto filled value in payment info section '<first_name>' '<last_name>' '<address1>' '<city>' '<state_code>' '<zip_code>'
    Then validate cancel button and edit order buttons are enabled
    Then validate charge at pick for curbside text
    Then validate choking hazard popup message display
    Then validate complete prefilled value under pickup info fields '<first_name>' '<last_name>' '<ph_number>' '<email>'
    Then validate content in Cake-Deli Store pickup display '<store_name>'
    Then validate content of Curbside pickup without comment '<store_name>' '<car_desc>' '<shopcart_sub>'
    Then validate correct items display on order history detail page
    Then validate curbside display for Get Direction and Edit Pickup Time Links
    Then validate order status after successfully cancelled order
    Then validate default display of Comment Text field
    Then validate default display of Grocery Substitution option on Shopping Cart Page
    Then validate display of item after clicked on removed button
    Then validate Edit order page after all order removed
    Then validate item count after order update '<increase_qty>'
    Then validate max comment length display on curbside piclup
    Then validate no longer displays pickup time and links for the order you cancelled
    Then validate No text field for comments display
    Then validate notification message after 04 items were added but before updating order
    Then validate notification message after 3 items added but before updating order
    Then validate order date display
    Then validate order edit mode display
    Then validate order history page for button and links disabled
    Then validate order update display correctly after item removed '<remaining_item>'
    Then validate ordered items are still displayed same even after order is cancelled
    Then validate ordered items Except Cake are still displayed same even after order is cancelled
    Then validate page refresh and page is no longer in edit mode
    Then validate placeholder text on Search field of Add an Item screen
    Then validate Reorder Item pop up look and feel
    Then validate Subtotal is updated correctly after edit order
    Then validate the buttons display on Shopping Cart page for Anonymous user
    Then validate the newly selected pickup time display correct

    Then validate the order could not found Message display
    Then validate whether Reorder Items button is enabled

    Examples:
      | zipCode | storeName | cnc_item                  |
      | 49512   | Cascade   | is_click_and_collect:true |

