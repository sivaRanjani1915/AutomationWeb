package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderDetailPage extends PageObject {

    public static List<String> listOfOrderHistoryItem = new ArrayList<>();
    public static List<String> listOfNewlyAddedItems = new ArrayList<>();
    public static List<String> listoforderhistoryitemExceptCake = new ArrayList<>();
    public static List<String> listOfDeletedItems = new ArrayList<>();
    public static List<String> listOfItemsAfterDelete = new ArrayList<>();
    public static List<String> extraNamesOfItemList = new ArrayList<>();
    public static List<String> reOrderItemList = new ArrayList<>();
    public static List<String> selectedReorderItemList = new ArrayList<>();
    public static List<String> orderBySelectedReorderItemList = new ArrayList<>();
    public static String orderReviewUrl = null;
    public static String pickupdate = null;
    public static String pickuptime = null;
    public static String firstpickuptime = null;

    //Order Number * [Note: element contains bother Order: {number} ]
    @FindBy(xpath = "//*[@class='orderDetailNum']")
    public WebElement orderNumberDisplayOrderDetailPage;

    //Order Date value Display
    @FindBy(xpath = "//*[@class='orderDate leftSide col-xs-4 no-padding']/span[2]")
    public WebElement orderDateValueDisplayOrderDetailPage;

    /*----------------------------Details select order history page ---------------------------------------------*/
    @FindBy(xpath = "//*[contains(@class,'orderDetailContent')]")
    public WebElement ORDER_DETAILS_PAGE;

    //Order Status Display
    @FindBy(xpath = "//*[@class='orderStatus rightSide']/span[2]/i")
    public WebElement ORDER_STATUS;

    //Curbside Pickup SubHeading BoldText
    @FindBy(xpath = "//*[@id='pickupSummary']/div[1]/h3")
    public WebElement curbsidePickupSubHeadingBoldTextOrderDetailPage;

    //Pickup Time Details
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@id='pickupTimeDetail']")
    public WebElement activeOrderPickupTime;

    //Pickup Date Details
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@id='pickupDateDetail']")
    public WebElement activeOrderPickupDate;

    // +Add an Item button
    @FindBy(xpath = "//*[@id='btnAddItem']")
    public WebElement PLUS_ADD_ITEM_BUTTON;

    //Edit Order Button
    @FindBy(xpath = "//*[@id='edit-button-wrapper']//button[@id='btnEditOrder']")
    public WebElement EDIT_ORDER_BUTTON;

    @FindBy(xpath = "//*[contains(@class,'itemEditMode')]")
    public WebElement EDIT_ORDER_MODE;

    //Merchandise Grand Sub-total value
    @FindBy(xpath = "//*[@id='pickupSummary'][contains (@class, 'pickupSummary')]//*[@class='price-table subTotal']/tbody/tr[1]/td[2]")
    public WebElement merchGrandSubtotalvalueOHDP;

    //Cancel Order link at bottom of the screen
    @FindBy(xpath = "//*[@id='btnCancelOrder']")
    public WebElement CANCEL_ORDER_LINK;

    //Cancel Order confirmation popup - Cancel My Order Button
    @FindBy(xpath = "//button[text()='Cancel My Order']")
    public WebElement CANCEL_ORDER_POPUP_BUTTON;

    //Cancel Order confirmation popup - Go back Button
    @FindBy(xpath = "//button[text()='Go Back']")
    public WebElement goBackButtonCancelPopupOrderDetailPage;

    //Pickup Time Display
    @FindBy(xpath = "//*[@id='pickupTimeDetail']")
    public WebElement RESERVED_PICKUP_TIME;

    //Pickup Date Display
    @FindBy(xpath = "//*[@id='pickupDateDetail']")
    public WebElement RESERVED_PICKUP_DATE;

    //Pickup Store Name display under Store Information
    @FindBy(xpath = "//*[@id='pickupSummary']//h4[@class='storeLocation-name']")
    public WebElement selectedStoreNameDisplayOrderDetailPage;

    //Pickup Store Deli-Cake display  [Note: Store Name alone is not able to identify, Need to trim to validate]
    @FindBy(xpath = "//*[@class='storeLocation']")
    public WebElement selectedStoreNameDisplayDeliCakeSectionOrderDetailPage;

    //Selected Pickup Location value Display
    @FindBy(xpath = "//span[@data-qa='pickupType']")
    public WebElement selectedPickUpLocationDisplayOrderDetailPage;

    //Selected Pickup Location value Display - Deli/Bakery
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@class='pickupDetails']/strong")
    public WebElement selectedPickUpLocationDisplayDeliBakerySecOrderDetailPage;

    //Select Car Description value Display
    @FindBy(xpath = "//span[@data-qa='pickupCar']")
    public WebElement selectedCarDescriptionDisplayOrderDetailPage;

    //Select Order Substitution Information Display
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@class='grocerySubstitutions']/p")
    public WebElement orderSubstitutionValueDisplayOrderDetailPage;

    //Enter Order Comment value Display
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@class='comments col-xs-12']/p")
    public WebElement enteredOrderCommentValueDisplayOrderDetailPage;

    //Payment and Coupon Details - Payment Information Bold text
    @FindBy(xpath = "//*[@id='pickupSummary']/div[2]/div[1]/strong[1]")
    public WebElement paymentInformationBoldTextOrderDetailsPage;

    //Payment and Coupon Details - Billing Address Bold Text
    @FindBy(xpath = "//*[@id='pickupSummary']/div[2]/div[1]/strong[2]")
    public WebElement billingAddressBoldTextOrderDetailsPage;

    //Payment and Coupons Details - Billing Address Line1
    @FindBy(xpath = "//*[@id='pickupSummary']/div[2]//*[@class='pickupPerson col-sm-6']/div[1]")
    public WebElement billingAddressLine1OrderDetailsPage;

    //Payment and Coupons Details - Billing Address Line2
    @FindBy(xpath = "//*[@id='pickupSummary']/div[2]//*[@class='pickupPerson col-sm-6']/div[3]")
    public WebElement billingAddressLine2OrderDetailsPage;

    //Payment details Section* [Note= Element contains both payment info and billing address. unable to get element separately
    //for CC name and CC details
    @FindBy(xpath = "//*[@id='pickupSummary']//*[@class='pickupPerson col-sm-6']")
    public WebElement paymentInfoSection;

    //Payment and Coupon Detail SubHeading Bold text
    @FindBy(xpath = "//*[@id='pickupSummary']/h3")
    public WebElement paymentAndCouponsDetailsSubHeadingBoldTextOrderDetailsPage;

    //Notification Message after adding item but before updating order
    @FindBy(xpath = "//*[@id='teoNotifMsg']")
    public WebElement toBeNotifMegAfterItemAddedBeforeOrderUpdateOnOrderDetailsPage;

    /*-----------------------------Edit Mode--------------------------*/

    // Page Loader
    @FindBy(xpath = "//*[contains(@class,'loader') and contains(@style,'block')]")
    public WebElement PAGE_LOADER;

    //Update Order Button - Edit Mode
    @FindBy(xpath = "//*[@id='edit-button-wrapper']//*[@id='btnUpdateOrder']")
    public WebElement UPDATE_ORDER_BUTTON;

    //X Button
    @FindBy(xpath = "//*[contains(@id,'modalContent')]")
    public WebElement ADD_ITEM_MODAL;

    //Search Field on Popup Add Item Order Details Page
    @FindBy(xpath = "//*[@id='nav_search_edit']")
    public WebElement ADD_ITEM_SEARCH_TEXTBOX;

    /*-----------------------------Edit Mode--------------------------*/

    //x icon to clear search item
    @FindBy(xpath = "//*[@id='clearSearch_edit']")
    public WebElement xIconToClearSearchResultPopUpODP;

    //beer type ahead value
    @FindBy(xpath = "//*[text()='beer']")
    public WebElement beerTypeAheadValuePopupAddItemOrderDetailsPage;

    //board games type ahead value
    @FindBy(xpath = "//*[text()='board games']")
    public WebElement boardgamesTypeAheadValuePopupAddItemOrderDetailsPage;

    //apple type-ahead value
    @FindBy(xpath = "//*[text()='apple']")
    public WebElement appleTypeAheadValuePopupAddItemOrderDetailsPage;

    //1st option in type ahead list value
    @FindBy(xpath = "//*[text()='ipa']")
    public WebElement ipaTypeAheadOptionPopupAddItemOrderDetailsPage;

    //Remove Link after click on +Add Button
    @FindBy(xpath = "//*[@id='prod-sort-list']/li[contains (@class, 'addOrder')]//*[@class='remove-item remove-product-link-text']")
    public WebElement removeLink1stItemPopupAddItemOrderDetailsPage;

    //Add 1 Items Button
    @FindBy(xpath = "//*[@id='addItems_edit']")
    public WebElement ADD_ITEM_MODAL_ADD_ITEM_BUTTON;

    /*------------------------------------Update Order Confirmation Popup------------------------*/
    //Are you Sure? Text on popup
    @FindBy(xpath = "//div[@class='pm-title']")
    public WebElement areYouSureTextupdateOrderConfmPopUp;

    //X Button
    @FindBy(xpath = "//*[@id='pgwModal']//*[@class='pm-close']")
    public WebElement xButtonupdateOrderConfmPopUp;

    //cancel Button
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement UPDATE_CONFIRMATION_MODAL_CANCEL_LINK;

    //Update Order Button Pop up
    @FindBy(xpath = "//*[contains(@class,'updateOrderOK')]")
    public WebElement UPDATE_CONFIRMATION_MODAL_UPDATE_BUTTON;

    //Confirmation message Text Update order popup
    @FindBy(xpath = "//*[@id='modalContent']/div[1]/div/p")
    public WebElement UPDATE_CONFIRMATION_MODAL;

    @FindBy(xpath = "//*[text()='Age Confirmation']")
    public WebElement CONFIRM_AGE_RESTRICTED_MODAL;

    @FindBy(xpath = "//*[contains(@class,'confirmAgeForm')]")
    public WebElement CONFIRM_AGE_RESTRICTED_BUTTON;

    //Age Confirmation description text pop up update order
    @FindBy(xpath = "//*[@id='modalContent']/div[1]/span[1]")
    public WebElement ageConfirmationDescPopupUpdateOrder;

    /*---------------Age Restriction Confirmation Message Udpate Order [This is different from placing order age confirmation -------------*/

    //xButton
    @FindBy(xpath = "//span[@class='pm-close']")
    public WebElement xButtonAgeConfirmationUpdateOrderScreen;

    //Remove Link on Edit Order
    @FindBy(xpath = "//span[text()='Remove']")
    public WebElement removeLinkEditOrder;

    //Undo link on Edit Order
    @FindBy(xpath = "//span[text()='Undo']")
    public WebElement undoButtonEditOrder;

    /*--------------Common button edit order-------------*/

    //Select All option Heading Edit Order
    @FindBy(xpath = "//*[@id='reorderContainer']/div[1]/div[1]/label")
    public WebElement selectAllHeadingEditOrder;

    //Edit Pick Up Time
    @FindBy(xpath = "//*[@class='edit-pickup-time']/a")
    public WebElement editPickTimeLink;

    //Charged Today Display for STH item only
    @FindBy(xpath = "//*[@class='price-table subTotal']//*[text()='(Charged today)']")
    public WebElement chargedTodayTextSTHItemOrderHistoryDetail;

    //Charged at Pickup for Curbside pickup (Charged at Pickup)
    @FindBy(xpath = "//*[@class='price-table subTotal']//*[text()='(Charged at Pickup)']")
    public WebElement chargedAtPickupTextCurbsidetemOrderHistoryDetail;

    //Get Directions Link
    @FindBy(xpath = "//*[text()='Get Directions']")
    public WebElement getDirectionsLinkOHD;

	/*----------------Choking hazard item---------------*/

    //Choking Hazard Warning description
    @FindBy(xpath = "//*[@id='modalContent']/div[contains (@class, 'warning')]/span[1]")
    public WebElement chokingHarardWarningDescPopup;

    //Reorder Items button
    @FindBy(xpath = "//*[@id='edit-button-wrapper']//*[@id='btnReorderItems']")
    public WebElement REORDER_ITEMS_BUTTON;

    @FindBy(xpath = "//*[@class='alert-modal-body']")
    public WebElement REORDER_ITEMS_POPUP;

    //Reorder Items Header Pop up
    @FindBy(xpath = "//*[@class='alert-modal-body']//h2[text()='Reorder Items']")
    public WebElement REORDER_ITEMS_POPUP_TITLE;


    /*================================>>ReOrder Elements<<==========================================*/

    //Add Items to Cart Button - Reorder Items Pop up
    @FindBy(xpath = "//*[@id='layer-reorderItems']//*[@class='alert-btn alert-blue-btn add-reorderitems-to-cart']")
    public WebElement ADD_ITEMS_REORDER_POPUP_BUTTON;


    /*-------------------Pickup Time edit-----------------------*/

    //Pickup day-2
    @FindBy(xpath = "//*[@id='date-2']")
    public WebElement day2pickupslotPickupTimespopup;

    //Pickup Times - Header Text on popup
    @FindBy(xpath = "//*[@class='basicModal pickupTime']//h1[text()='Pickup Times']")
    public WebElement pickupTimesHeaderTextPickupTimespopup;

    //pickup slot elements
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']/div[contains (@class, 'dayGroup day-2')]//*[@class='pickup-time-slot available']")
    public WebElement day2availablePickupSlotElements;

    //Your pickup time
    //@FindBy (xpath="//*[@id='pickup-time-slots-id']//*[class='slotMessage desired active']")
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']//*[@class='pickup-time-slot available selected active']")
    public WebElement currentPickUpTimeSlot;

    //Your Pickup Time Text on already selected slot
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']//div[contains (@class, 'selected active')]/span[2]/strong")
    public WebElement currentPickUpTimeTextSlot;

    //close icon
    @FindBy(xpath = "//*[@id='modalPickup_modal']//*[@class='modalClose mjr-close-btn']")
    public WebElement closeIconEditPickupWizard;

    //cancel button
    @FindBy(xpath = "//button[@class='mjr-link cancelEditPickupTime']")
    public WebElement cancelLinkEditPickupTimeWizard;

    //update pickup time button
    @FindBy(xpath = "//button[text()='Update Pickup Time']")
    public WebElement updatePickupTimeButtonEditPickTimeupWizard;

    //Success message after updated pickup time
    @FindBy(xpath = "//*[@id='pickupMessage']//*[@classs='successMessage']")
    public WebElement successMessageEditPickupTime;

    //In-line removed item message
    @FindBy(xpath = "//*[@class='item-row removeItem']/div[2]")
    public WebElement removedItemInlineMsgEditorder;

    //Active order pickup time - Curbside Widget
    @FindBy(xpath = "//*[@id='js-curbside-display-msg']//span[@class='mjr-small active pickupTime']")
    public WebElement activeOrderPickupTimeDisplayCurbsideWidgetHP;


    List<String> PriceListOH = new ArrayList<>();
    List<String> QtyListOH = new ArrayList<>();
    utilityhelper UtilityHelper;


	/*====================================================Order Detail Page Actions================================================*/

    public void orderHistoryDetailsPageDisplay() {
        Assert.assertTrue("Order Details Page displays", UtilityHelper.isDisplayed(ORDER_DETAILS_PAGE));
    }

    //
    public void validateOrderHistoryDetailLookAndFeelValidation() {

        Assert.assertTrue(orderNumberDisplayOrderDetailPage.getText().contains(Constants.headerOrder));
        if (UtilityHelper.elementNotExists(By.xpath("//*[@id='pickupSummary']/div[1]/h3"))) {
            Assert.assertTrue(selectedPickUpLocationDisplayDeliBakerySecOrderDetailPage.getText().contains(Constants.selectedPickUpLocationDisplayDeliBakerySecOrderDetailPage));
        } else {
            Assert.assertTrue(curbsidePickupSubHeadingBoldTextOrderDetailPage.getText().contains(Constants.hearderCurbsidePickup));
        }
        Assert.assertTrue(paymentAndCouponsDetailsSubHeadingBoldTextOrderDetailsPage.getText().contains(Constants.headerPaymentAndCouponDetails));
    }

    //Created By: 107793 11/14/16
    public void validateActivePickupTimeDisplay() {
        String storePickupTime = OrderPickupPage.pickupTime;
        String firstValue = storePickupTime.substring(0, 1);
        if (firstValue.equals("0")) {
            String removeZeroPrint = storePickupTime.substring(1);
            Assert.assertTrue("Validate Order Details Pickup Time Display ", activeOrderPickupTime.getText().contains(removeZeroPrint));
        } else {
            Assert.assertTrue("Validate Order Details Pickup Time Display ", activeOrderPickupTime.getText().contains(storePickupTime));
        }
    }

    //Order Number Display validation
    public void orderNumberDisplay_Valdiation() {
        Assert.assertTrue(orderNumberDisplayOrderDetailPage.getText().contains(OrderConfirmPage.orderNumber));
    }

    //Order Status Validation
    public void validateOrderStatusDisplay() {
        Assert.assertEquals("Verify Order Status is displayed: ",
                Constants.orderPlaced.toUpperCase(), UtilityHelper.elementGetText(ORDER_STATUS).toUpperCase());
    }

    //Order Date Validation
    public void orderDateDisplayValidationOrderDetailsPage() {
        Date cur_dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String strTodaysDate = dateFormat.format(cur_dt);
        Assert.assertEquals(strTodaysDate, orderDateValueDisplayOrderDetailPage.getText());
    }

    public void userClickOnPlusAddAnItemOption() {
        UtilityHelper.waitUntilClickable(PLUS_ADD_ITEM_BUTTON);
        UtilityHelper.click(PLUS_ADD_ITEM_BUTTON);
    }

    public void userVerifyAddAnItemSearchWasNotPerformed() {
        Assert.assertTrue("=== assert no products should be returned on empty search: ", getDriver().findElements(By.xpath("//*[contains(@class, 'prod-item')]")).size() < 1);
    }

    public void storeEditOrderUrl() {
        orderReviewUrl = getDriver().getCurrentUrl();
    }


    public void userVerifyUserIsNotRedirectedToAnotherPage() {
        Assert.assertEquals("=== assert user is not redirected to a new page: ", getDriver().getCurrentUrl(), orderReviewUrl);
    }

    //to validate pop up modal display
    public void waitUntilAddItemModalIsDisplayed() {
        UtilityHelper.waitUntilElementVisible(ADD_ITEM_MODAL);
        Assert.assertTrue("Edit Order - Add Item Modal Displays: ", UtilityHelper.isDisplayed(ADD_ITEM_MODAL));
    }

    //Type beer and Search in popup search field
    public void beerSearchOnPopupUpdateOrder(String alcohol) {
        UtilityHelper.waitUntilClickable(ADD_ITEM_SEARCH_TEXTBOX);
        ADD_ITEM_SEARCH_TEXTBOX.sendKeys(alcohol);
        UtilityHelper.waitUntilClickable(beerTypeAheadValuePopupAddItemOrderDetailsPage);
        beerTypeAheadValuePopupAddItemOrderDetailsPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //Type beer and Search in popup search field
    public void chockinghazarditemSearchOnPopupUpdateOrder(String toserachitem) {
        UtilityHelper.waitUntilClickable(ADD_ITEM_SEARCH_TEXTBOX);
        ADD_ITEM_SEARCH_TEXTBOX.sendKeys(toserachitem);
        UtilityHelper.waitUntilClickable(boardgamesTypeAheadValuePopupAddItemOrderDetailsPage);
        boardgamesTypeAheadValuePopupAddItemOrderDetailsPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //Type and search in pop up search field
    public void appleitemSearchOnPopupUpdateOrder(String toserachitem) {
        UtilityHelper.waitUntilClickable(ADD_ITEM_SEARCH_TEXTBOX);
        ADD_ITEM_SEARCH_TEXTBOX.sendKeys(toserachitem);
        UtilityHelper.waitUntilClickable(appleTypeAheadValuePopupAddItemOrderDetailsPage);
        appleTypeAheadValuePopupAddItemOrderDetailsPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //click 1st option of Type ahead
    public void ipa_itemSearchOnPopupUpdateOrder(String toserachitem) {
        UtilityHelper.waitUntilClickable(ADD_ITEM_SEARCH_TEXTBOX);
        ADD_ITEM_SEARCH_TEXTBOX.sendKeys(toserachitem);
        UtilityHelper.waitUntilClickable(ipaTypeAheadOptionPopupAddItemOrderDetailsPage);
        ipaTypeAheadOptionPopupAddItemOrderDetailsPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }


    public void userSearchesViaAddItemModal(String searchTerm) {
        UtilityHelper.waitUntilClickable(ADD_ITEM_SEARCH_TEXTBOX);
        UtilityHelper.typeIntoElement(ADD_ITEM_SEARCH_TEXTBOX, convertSearchTerm(searchTerm) + Keys.ENTER);
    }

    public String convertSearchTerm(String term) {
        String searchTerm;
        switch (term.toLowerCase()) {
            case "cnc":
                searchTerm = "is_click_and_collect:true";
                break;
            case "sellable":
                searchTerm = "is_sellable:true";
                break;
            case "alcohol":
                searchTerm = "is_alcohol:true";
                break;
            case "tobacco":
                searchTerm = "is_tobacco:true";
                break;
            case "hazardous":
                searchTerm = "is_hazardous_material:true";
                break;
            case "spo":
                searchTerm = "is_prepared_item:true";
                break;
            case "sth":
                searchTerm = "is_ship_to_home:true";
                break;
            case "prepared item":
                searchTerm = "is_prepared_item:true";
                break;
            case "age restricted":
                searchTerm = "is_age_restricted:true";
                break;
            case "on sale":
                searchTerm = "ways_to_save:Sale";
                break;
            case "mperks":
                searchTerm = "ways_to_save:mPerks";
                break;
            case "hot item":
                searchTerm = "hot_item_flag:true";
                break;
            case "random weight":
                searchTerm = "is_random_weight:true";
                break;
            case "price less than map":
                searchTerm = "price_less_than_map:true";
                break;
            //not flags
            case "not cnc":
                searchTerm = "is_click_and_collect:false";
                break;
            case "not sellable":
                searchTerm = "is_sellable:false";
                break;
            case "not alcohol":
                searchTerm = "is_alcohol:false";
                break;
            case "not tobacco":
                searchTerm = "is_tobacco:false";
                break;
            case "not hazardous":
                searchTerm = "is_hazardous_material:false";
                break;
            case "not spo":
                searchTerm = "is_prepared_item:false";
                break;
            case "not sth":
                searchTerm = "is_ship_to_home:false";
                break;
            case "not prepared item":
                searchTerm = "is_prepared_item:false";
                break;
            case "not age restricted":
                searchTerm = "is_age_restricted:false";
                break;
            case "not hot item":
                searchTerm = "hot_item_flag:false";
                break;
            case "not random weight":
                searchTerm = "is_random_weight:false";
                break;
            case "price greater than map":
                searchTerm = "price_less_than_map:false";
                break;
            default:
                System.out.println("SEARCHING [" + term + "]");
                searchTerm = term;
                break;
        }
        return searchTerm;

    }

    //validate plusAdd button change to Remove link
    public void clickplusAddButtonChangeToRemoveLinkItemPopup() {
        Assert.assertTrue(removeLink1stItemPopupAddItemOrderDetailsPage.isDisplayed());
    }

    public void clickOnAddXItemsButton() {
        UtilityHelper.waitUntilClickable(ADD_ITEM_MODAL_ADD_ITEM_BUTTON);
        UtilityHelper.click(ADD_ITEM_MODAL_ADD_ITEM_BUTTON);
    }

    public void waitUntilAddItemModalVanishes() {
        if (UtilityHelper.elementExists(ADD_ITEM_MODAL))
            UtilityHelper.waitUntilElementNotVisible(ADD_ITEM_MODAL);
    }

    //
    public void valdiateNewlyAddedItem3rdTC_OrderDetailsPage() {
        UtilityHelper.waitUntilClickable(PLUS_ADD_ITEM_BUTTON);
        System.out.println("product name store in getStringAddList: " + getStringAddList());
        UtilityHelper.additionalProdNameCompareOrderHistoryDetailPage();
    }

    //To Be Notify Msg After Item Added Before Order Update On Order Details Page
    public void toBeNotifyMsg1itemadded_BeforeOrderUpdate() {
        Assert.assertEquals(Constants.toBeNotifMegAfterItemAddedBeforeOrderUpdateOnOrderDetailsPage, toBeNotifMegAfterItemAddedBeforeOrderUpdateOnOrderDetailsPage.getText());
    }

    //To be notify msg after 3 items added into order - Order details page
    public void tobeNotifuMsg3ItemAddedOrderUpdate() {
        Assert.assertEquals(Constants.NotifMsgAfter3ItemAddedOnOrderDetailsPage, toBeNotifMegAfterItemAddedBeforeOrderUpdateOnOrderDetailsPage.getText());
    }

    //To be notify msg after 4 items added into order - Order details page
    public void tobeNotifuMsg4ItemAddedOrderUpdate() {
        Assert.assertEquals(Constants.NotifMsgAfter4ItemAddedOnOrderDetailsPage, toBeNotifMegAfterItemAddedBeforeOrderUpdateOnOrderDetailsPage.getText());
    }

    public void moveToViewUpdateOrderButton() {
        UtilityHelper.moveToViewElement(UPDATE_ORDER_BUTTON);
    }

    public void highLightUpdateOrderButton() throws InterruptedException {
        int limit = 8, counter = 0;
        if (UtilityHelper.elementExists(PAGE_LOADER)) {
            Thread.sleep(1000);
            while (UtilityHelper.isClickable(PAGE_LOADER)) {
                Thread.sleep(2000);
                if (limit == counter) {
                    Assert.fail("Took too long to add items via Edit Active Order Mode.");
                }
                counter++;
            }
        }
        UtilityHelper.highLightElement(UPDATE_ORDER_BUTTON);
    }

    public void clickOnUpdateOrderButtonToUpdateTheOrder() {
        UtilityHelper.click(UPDATE_ORDER_BUTTON);
    }

    //Update order Confirmation
    public void updateOrderConfirmationPopUp() {
        UtilityHelper.waitUntilElementVisible(areYouSureTextupdateOrderConfmPopUp);
        Assert.assertEquals(Constants.areYouSureTextupdateOrderConfmPopUp, areYouSureTextupdateOrderConfmPopUp.getText());
        Assert.assertEquals(Constants.confirmationMessageupdateOrderConfmPopUp, UPDATE_CONFIRMATION_MODAL.getText());
    }

    //Click Cancel on Update order confirmation Pop-up
    public void clickCancel_OrderUpdatePopUpConfirmation() {
        UtilityHelper.waitUntilElementVisible(areYouSureTextupdateOrderConfmPopUp);
        UPDATE_CONFIRMATION_MODAL_CANCEL_LINK.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //Click X Button on Update order confirmation Pop-up
    public void clickXbutton_OrderUpdatePopUpConfirmation() {
        UtilityHelper.waitUntilElementVisible(areYouSureTextupdateOrderConfmPopUp);
        xButtonupdateOrderConfmPopUp.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    public void waitUntilUpdateOrderConfirmationPopUpDisplay() {
        UtilityHelper.waitUntilElementVisible(UPDATE_CONFIRMATION_MODAL);
    }

    //Click UpdateOrder on Update order confirmation Pop-up
    public void userClickUpdateOrderButtonOnPopupConfirmation() {
        UtilityHelper.click(UPDATE_CONFIRMATION_MODAL_UPDATE_BUTTON);
    }

    public void waitUntilAgeRestrictedConfirmationModalAppears() {
        UtilityHelper.waitUntilElementVisible(CONFIRM_AGE_RESTRICTED_MODAL);
    }

    public void highLightConfirmButtonOnAgeRestrictedModal() {
        UtilityHelper.highLightElement(CONFIRM_AGE_RESTRICTED_BUTTON);
    }

    public void userClicksConfirmOnAgeRestrictedConfirmationModal() {
        UtilityHelper.click(CONFIRM_AGE_RESTRICTED_BUTTON);
        UtilityHelper.waitUntilClickable(EDIT_ORDER_BUTTON);
    }

    //Cancel Button on Age Restriction pop up message Order Udpate
    public void cancelButtonOnAgeRestrictionPopMsgOrderUpdate() {
        UtilityHelper.waitUntilClickable(UPDATE_CONFIRMATION_MODAL_CANCEL_LINK);
        UPDATE_CONFIRMATION_MODAL_CANCEL_LINK.click();
    }

    public void moveToViewCancelOrderLink() {
        UtilityHelper.moveToViewElement(CANCEL_ORDER_LINK);
    }

    public void userClickOnCancelOrderLink() {
        UtilityHelper.click(CANCEL_ORDER_LINK);
    }

/*-----------------------Endof item validation on order details page----------------------*/

    public void clickGoBackButtonOrderDetail() {
        UtilityHelper.waitUntilClickable(goBackButtonCancelPopupOrderDetailPage);
        goBackButtonCancelPopupOrderDetailPage.click();
    }

    public void moveToViewCancelOrderConfirmationPopUp() {
        UtilityHelper.waitUntilClickable(CANCEL_ORDER_POPUP_BUTTON);
    }

    public void userClickOnCancelOrderOnConfirmationPopUp() {
        UtilityHelper.click(CANCEL_ORDER_POPUP_BUTTON);
        UtilityHelper.waitUntilElementNotVisible(CANCEL_ORDER_POPUP_BUTTON);
        if (UtilityHelper.elementExists(PAGE_LOADER)) {
            UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
        }
    }

    //Store Name Validation - Order History Detail
    public void orderHisdetail_StoreNameValidation(String storename) {
        UtilityHelper.waitUntilElementVisible(selectedStoreNameDisplayOrderDetailPage);
        Assert.assertEquals(storename.toUpperCase(), selectedStoreNameDisplayOrderDetailPage.getText().toUpperCase());
    }

    //Pickup Time Validation - Order History
    public void orderHisdetail_PickupTimeValidation() {
        UtilityHelper.waitUntilElementVisible(RESERVED_PICKUP_TIME);
        Assert.assertTrue(RESERVED_PICKUP_TIME.getText().contains(OrderPickupPage.pickupTime));
    }

    //Store Name Validation under Deli-Cake - Order History Detail
    public void orderHisdetail_StoreNameUnderDeliCakeValidation(String storename) {
        UtilityHelper.waitUntilElementVisible(selectedStoreNameDisplayDeliCakeSectionOrderDetailPage);
        Assert.assertTrue(selectedStoreNameDisplayDeliCakeSectionOrderDetailPage.getText().toUpperCase().contains(storename.toUpperCase()));
    }

    //Pickup Location Validation - Curbside Order History Detail
    public void orderHisdetail_PickuplocationValidation() {
        UtilityHelper.moveToViewElement(selectedPickUpLocationDisplayOrderDetailPage);
        Assert.assertTrue("Verify Order Placed at Curbside Services ===>> ",
                selectedPickUpLocationDisplayOrderDetailPage.getText().toUpperCase().contains(Constants.selectedPickUpLocationDisplayOrderDetailPage.toUpperCase()));
//        Assert.assertEquals(Constants.selectedPickUpLocationDisplayOrderDetailPage.toUpperCase(), selectedPickUpLocationDisplayOrderDetailPage.getText().toUpperCase());
    }

    //Pickup Location Validation - Deli/Bakery Order History Detail
    public void orderHisdetail_PickuplocationDeliBakeryValidation() {
        Assert.assertEquals(Constants.selectedPickUpLocationDisplayDeliBakerySecOrderDetailPage.toUpperCase(), selectedPickUpLocationDisplayDeliBakerySecOrderDetailPage.getText().toUpperCase());
    }

    //Car Description Validation - Order History Detail
    public void orderHisdetail_CarDescValidation(String cardesc) {
        Assert.assertTrue("Verify Car Description Details ===>> ",
                selectedCarDescriptionDisplayOrderDetailPage.getText().toUpperCase().contains(cardesc.toUpperCase()));
//        Assert.assertEquals(cardesc.toUpperCase(), selectedCarDescriptionDisplayOrderDetailPage.getText().toUpperCase());
    }


    public String getSubstitutionFromSelectedOption(String selection) {
        //this method is here because no susbtitution does not match no substitutions
        //so the fix for that future proofs it a bit in case the others cease to match as well //JoeG 11-30-2016
        switch (selection) {
            case "No Substitution":
                return "No Substitutions";
            case "Meijer Brand":
                return "Meijer Brand";
            case "Any Brand":
                return "Any Brand";
            case "National Brand":
                return "National Brand";
        }
        return "";
    }


    //Shopping Substitution Validation  - Order History Detail
    public void orderHisdetail_ShoppingSubValidation(String shopcartsub) {
        Assert.assertEquals(getSubstitutionFromSelectedOption(shopcartsub).toUpperCase(), orderSubstitutionValueDisplayOrderDetailPage.getText().toUpperCase());
    }

    //Comment Validation - Order History Detail
    public void orderHisdetail_CommentValidation(String comment) {
        Assert.assertEquals(comment.toUpperCase(), enteredOrderCommentValueDisplayOrderDetailPage.getText().toUpperCase());
    }

    //To validate max comment text
    public void validate_MaxCommentText_OHDPage() {
        Assert.assertEquals(Constants.max1024characterofcommentsection.toUpperCase(), enteredOrderCommentValueDisplayOrderDetailPage.getText().toUpperCase());
    }

    //
    public void contentPaymentAndCouponsDetailsValidation(String address1, String ccaddress2) {
        Assert.assertEquals(Constants.paymentInformationBoldTextOrderDetailsPage.toUpperCase(), paymentInformationBoldTextOrderDetailsPage.getText().toUpperCase());
        Assert.assertEquals(Constants.billingAddressBoldTextOrderDetailsPage.toUpperCase(), billingAddressBoldTextOrderDetailsPage.getText().toUpperCase());
        Assert.assertEquals(address1.toUpperCase(), billingAddressLine1OrderDetailsPage.getText().toUpperCase());
        Assert.assertEquals(ccaddress2.toUpperCase(), billingAddressLine2OrderDetailsPage.getText().toUpperCase());
    }

    public void validate_CCEndingDisplay(String ccnumber) {

        String ccEnding = null;
        if (ccnumber.startsWith("4")) {
            ccEnding = "Visa ending in *";
            System.out.println("=== Card Type is: " + ccEnding);
        } else if (ccnumber.startsWith("5")) {
            ccEnding = "Master Card ending in *";
            System.out.println("=== Card Type is: " + ccEnding);
        } else if (ccnumber.startsWith("6")) {
            ccEnding = "Discover ending in *";
            System.out.println("=== Card Type is: " + ccEnding);
        } else if (ccnumber.startsWith("3")) {
            ccEnding = "American Express ending in *";

            System.out.println("=== Card Type is: " + ccEnding);
        } else {
            ccEnding = "Unknown Visa type";
            System.out.println("=== Card Type is: " + ccEnding);
        }

        //String last4digCC=ccnumber.substring(12);
        String last4digCC = ccnumber.replaceAll("\\w(?=\\w{4})", "");
        System.out.println("=== substring return of cc: " + last4digCC);
        String visaEnding = ccEnding + last4digCC;
        System.out.println("=== Visa End from logic:  " + visaEnding);
        Assert.assertTrue(paymentInfoSection.getText().contains(visaEnding));
    }

    //+Add an Item button is displayed
    public void plusAddAnItemEnabledValidation() {
        Assert.assertTrue(UtilityHelper.isEnabled(PLUS_ADD_ITEM_BUTTON));
    }

    //
    public void userClickEditOrderButton() throws InterruptedException {
        int limit = 3, counter = 0;
        if (!(UtilityHelper.isClickable(EDIT_ORDER_BUTTON))) {
            while (!(UtilityHelper.isClickable(EDIT_ORDER_BUTTON))) {
                if (limit == counter) {
                    Assert.fail("Leave 'Edit Order Mode' took too long.");
                }
                Thread.sleep(5000);
                counter++;
            }
        }
        UtilityHelper.click(EDIT_ORDER_BUTTON);
    }

    //
    public void editOrderEnabledValidation() {
        Assert.assertTrue(UtilityHelper.isEnabled(EDIT_ORDER_BUTTON));
    }

    //
    public void cancelOrderEnabledValidation() {
        Assert.assertTrue(UtilityHelper.isEnabled(CANCEL_ORDER_LINK));
    }

    //
    public void validateOrderEditModeDisplay() {
        UtilityHelper.waitUntilElementVisible(EDIT_ORDER_MODE);
    }

    //
    public void click1stProductRemoveLinkOrderEdit() {
        UtilityHelper.waitUntilClickable(removeLinkEditOrder);
        removeLinkEditOrder.click();
    }

    //
    public void clickUndoButtonOrderEdit() {
        UtilityHelper.waitUntilClickable(undoButtonEditOrder);
        undoButtonEditOrder.click();
    }

    //
    public void selectAllHeader_CheckBox() {
        UtilityHelper.waitUntilClickable(selectAllHeadingEditOrder);
        Assert.assertTrue(selectAllHeadingEditOrder.getText().contains("Select All"));
    }

    //
    public void orderStatusAfterCancelledValdiation(String orderstatus) {
        Assert.assertEquals(orderstatus.toUpperCase(), ORDER_STATUS.getText().toUpperCase());
    }

    //To Increase QTY of each items
    public void increaseQTYofEachProduct(int editQty) throws InterruptedException {
        List<WebElement> itemlist = getDriver().findElements(By.xpath("//*[@class='item-row'][not(contains (@style, 'none'))]//*[@class='form-control quantity quantityReorder']"));
        System.out.println("=== total number of avaiable item to add to cart: " + itemlist.size());
        for (WebElement webElement : itemlist) {
            WebElement clickPlusIcon = getDriver().findElement(By.xpath("//*[@class='plusMinusCircle noSelect plus']"));
            for (int i = 1; i < editQty; i++) {
                clickPlusIcon.click();
            }
        }
    }

    //To Remove items from order one by one and storing removing item names except first one
    public void removeCNCProductsFromOrderexcept1st(int itemremove) {
        List<WebElement> removelink = getDriver().findElements(By.xpath("//*[@class='item-row'][not(contains (@style, 'none'))]//*[@class='remove-product-link-text']"));
        System.out.println("=== total# of listed item remove in order: " + removelink.size());
        List<WebElement> nameofproduct = getDriver().findElements(By.xpath("//*[@id='pickupSummary']//*[@class='product-details']"));
        System.out.println("=== total# of listed item name in order: " + nameofproduct.size());
        for (WebElement webElement : removelink) {
            for (int i = 2; i <= itemremove + 1; i++) {
                WebElement clickremove = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + i + "]//*[@class='remove-product-link-text']"));
                clickremove.click();
                if (i >= 3) {
                    System.out.println("=== Name of the product: " + nameofproduct.get(i).getText());
                    listOfDeletedItems.add(webElement.getText());
                }
                setImplicitTimeout(5, TimeUnit.SECONDS);
            }
            break;
        }
    }

    //To Remove CNC items and storing removing item names
    public void atRandomRemoveItemsFromActiveOrder(WebElement element) {
        UtilityHelper.moveToViewElement(element);
        String productName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='product-details']")));
        WebElement removeThisItem = element.findElement(By.xpath(".//a[contains(@class,'remove-product')]"));
        UtilityHelper.moveToViewElement(removeThisItem);
        UtilityHelper.click(removeThisItem);
        UtilityHelper.waitUntilElementVisible(element.findElement(By.xpath(".//span[2]")));
        listOfDeletedItems.add(productName.replaceAll("\\s*\\bSALE\\b\\s*", "").trim());
    }

    //click undo button
    public void toUndofor1ofTheProductRemove() {
        undoButtonEditOrder.click();
    }

    //To validate remaining item count
    public void toValidateOrderUpdate_Display(String remainingitem) {
        List<WebElement> remainingitemcount = getDriver().findElements(By.xpath("//*[@id='pickupSummary']//*[@class='product-details']"));
        System.out.println("=== total number of remaining listed item in order: " + remainingitemcount.size());
        Assert.assertEquals(remainingitem, String.valueOf(remainingitemcount.size()));
    }

    //To captured remaining item names
    public void setItemListAfterDelete() {
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='pickupSummary']//*[@class='product-details']"));
        List<WebElement> remainingItemCount = getDriver().findElements(By.xpath("//*[@id='pickupSummary']//*[@class='product-details']"));
        for (WebElement remitem : remainingItemCount) {
            listOfItemsAfterDelete.add(UtilityHelper.elementGetText(remitem).replaceAll("\\s*\\bSALE\\b\\s*", "").trim());
        }
    }

    //To validate deleted items not display
    public void validateDelItemNamesNotDisplay() {
        System.out.println("List of Remaining Items ===>> " + listOfItemsAfterDelete);
        System.out.println("List of Deleted Items =====>> " + listOfDeletedItems);
        Assert.assertFalse(listOfItemsAfterDelete.containsAll(listOfDeletedItems));
    }

    //Cancel Button not display
    public void validate_cancelButtonNotDisplay() {
        Assert.assertTrue("=== Edit Link Not Present!", UtilityHelper.elementNotExists(CANCEL_ORDER_LINK));
    }

    //validate Ship To Home Section Display
    public void chargedTodaySTHitemOrderHistory() {
        Assert.assertEquals(Constants.chargedTodayTextOrderHistortDetailSTHitemOnly, chargedTodayTextSTHItemOrderHistoryDetail.getText());
    }

    //Validate Items are displayed correct
    public void orderitemDisplayCorrectOrderHistoryDetailPage() {
        System.out.println("=== Product name store in getListOfOrderHistoryItems: " + getListOfOrderHistoryItems());
        UtilityHelper.productNameCompareOrderHistoryDetailPage();
    }

    //To get Item in Order History Detail page
    public void setArrayListWithCurrentProductNamesViaOrderDetailsPage(WebElement element) {
        UtilityHelper.moveToViewElement(element);
        String name = UtilityHelper.elementGetText(element).replaceAll("\\s*\\bSALE\\b\\s*", "").trim();
        name = name.replace("®", "");
        name = name.replace("™", "");
        name = name.replace("?", "");
        listOfOrderHistoryItem.add(name);
    }

    public List<String> getListOfOrderHistoryItems() {
        Collections.sort(listOfOrderHistoryItem);
        return listOfOrderHistoryItem;
    }

    public void setArrayListWithNewlyAddedItems(WebElement element) {
        UtilityHelper.moveToViewElement(element);
        String name = UtilityHelper.elementGetText(element).replaceAll("\\s*\\bSALE\\b\\s*", "").trim();
        name = name.replace("®", "");
        name = name.replace("™", "");
        name = name.replace("?", "");
        listOfNewlyAddedItems.add(name);
    }

    public List<String> getListOfNewlyAddedItems() {
        Collections.sort(listOfNewlyAddedItems);
        return listOfNewlyAddedItems;
    }


    //Validate Items are displayed correct
    public void orderitemDisplayCorrectOrderHistoryDetailPageExceptCustomCake() {
        System.out.println("=== Product Name without cake: " + listoforderhistoryitemExceptCake);
        UtilityHelper.productNameCompareOrderHistoryDetailPageExceptCake();
    }

    //Validate Same item are still displayed after order is cancelled - Excluding Cake
    public void afterOrderCancelled_ItemsDisplayExcludingCustomCake(int itemcount) {
        Assert.assertEquals(listoforderhistoryitemExceptCake.size(), itemcount);
    }

    //Validate Same item are still displayed after order is cancelled
    public void afterOrderCancelled_ItemsDisplay(int itemcount) {
        Assert.assertEquals(listOfOrderHistoryItem.size(), itemcount);
    }

    //To get Item names except cake in Order History Detail page
    public void selecteditemvalidation_OrderHistiryDetailExcludeCake() {
        UtilityHelper.waitUntilClickable(By.xpath("//*[contains(@class,'checkedOutDetails')]//*[@class='product-details']"));
        List<WebElement> iteminshoppingcart = getDriver().findElements(By.xpath("//*[contains(@class,'checkedOutDetails')]//*[@class='product-details']"));
        for (WebElement scitem : iteminshoppingcart) {
            listoforderhistoryitemExceptCake.add(UtilityHelper.elementGetText(scitem).replaceAll("\\s*\\bSALE\\b\\s*", ""));
        }
    }

    public List<String> getStringListOrderHistoryExceptCake() {
        Collections.sort(listoforderhistoryitemExceptCake);
        return listoforderhistoryitemExceptCake;
    }

    //Charged at pick up text validation
    public void chargedAtPickupCurbsideItem() {
        Assert.assertEquals(Constants.chargedATPickupTextCurbsidePickupItemsOrderHistortDetail, chargedAtPickupTextCurbsidetemOrderHistoryDetail.getText());
    }

    //Click Edit Pickup Time
    public void clickEditPickUpTime() throws InterruptedException {
        UtilityHelper.waitUntilClickable(editPickTimeLink);
        editPickTimeLink.click();
        Thread.sleep(2000);
    }

    //Validate Edit Pickup Time link is displayed
    public void editPickupTime_linkDisplay_Valdiation() {
        Assert.assertTrue(editPickTimeLink.isDisplayed());
    }

    //Validate Get Direction link is displayed
    public void getDirection_linkDisplay_Valdiation() {
        Assert.assertTrue(getDirectionsLinkOHD.isDisplayed());
    }

    //to validate current pickup time slot display
    public void validate_CurrentPickupTimeSlot() {
        //Assert.assertTrue(currentPickUpTimeTextSlot.getText().contains(Constants.selectedPickuptimeslot));
        Assert.assertEquals(currentPickUpTimeTextSlot.getText(), Constants.selectedPickuptimeslot);
    }

    //Select navigate to next page
    public String selectNewPickupTimeEditPickup() {
        UtilityHelper.waitUntilClickable(pickupTimesHeaderTextPickupTimespopup);
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println("=== Available Number of days for Pickup Slot: " + allpickupDate.size());
        int randval1 = UtilityHelper.getRandomNumber(1, allpickupDate.size());
        System.out.println("=== Random value of of i is: " + randval1);
        WebElement pickupDate = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + randval1 + "]"));
        pickupDate.click();
        List<WebElement> avblepickupslot = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + randval1 + "]//*[@class='pickup-time-slot available']"));
        for (int i = 0; i < 28; i++) {
            int randval2 = UtilityHelper.getRandomNumber(1, avblepickupslot.size());
            System.out.println("=== Random value of of i is: " + randval2);
            try {
                WebElement pickupslot = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + randval1 + "]//*[@class='pickup-time-slot available' and @data-index='" + randval2 + "']"));
                pickuptime = pickupslot.getAttribute("data-starttime");
                pickupdate = pickupslot.getAttribute("data-date");
                pickupslot.click();
                System.out.println("=== Pickup time: " + pickuptime);
                System.out.println("=== Pickup Date: " + pickupdate);
                break;
            } catch (Exception e) {
                System.out.println("=== Pickup time is not active!!!!");
            }
        }
        return pickuptime;
    }

    //To select first available pickup time
    public void selectAvailableTime() {
        day2pickupslotPickupTimespopup.click();
        day2availablePickupSlotElements.click();
    }

    //To cancel edit pickup time
    public void selectCancelEditPickupTime() {
        UtilityHelper.waitUntilClickable(cancelLinkEditPickupTimeWizard);
        cancelLinkEditPickupTimeWizard.click();
    }

    //To Close edit pickup time
    public void clickXButtonIconEditPickupTimePopup() {
        UtilityHelper.waitUntilClickable(closeIconEditPickupWizard);
        closeIconEditPickupWizard.click();
    }

    //To click on Update Pickup Time Button
    public void clickUpdatePickupTimeButton() throws InterruptedException {
        UtilityHelper.waitUntilClickable(updatePickupTimeButtonEditPickTimeupWizard);
        Assert.assertEquals(Constants.updatepickupTimebuttonText, updatePickupTimeButtonEditPickTimeupWizard.getText());
        updatePickupTimeButtonEditPickTimeupWizard.click();
        Thread.sleep(5000);
    }

    // To validate store value in OrderPickupPage_Meier.pickupDate
    public void validateUpdatedPickUpDateViaOrderPickUpPageSavedValue() {
        UtilityHelper.waitUntilElementVisible(RESERVED_PICKUP_DATE);
        String value = RESERVED_PICKUP_DATE.getText().substring(0, 3).trim();
        Assert.assertTrue("Verify DATE of Active Order: ", value.toUpperCase().contains(OrderPickupPage.pickupDate));
    }

    // To validate store value in OrderPickupPage_Meier.pickupTime
    public void validateUpdatedPickUpTimeViaOrderPickUpPageSavedValue() {
        String savedTimeSlot;
        UtilityHelper.waitUntilElementVisible(RESERVED_PICKUP_TIME);
        String firstValue = OrderPickupPage.pickupTime.substring(0, 1);
        if (firstValue.equals("0")) {
            savedTimeSlot = OrderPickupPage.pickupTime.substring(1);
        } else {
            savedTimeSlot = OrderPickupPage.pickupTime;
        }
        Assert.assertTrue("Verify TIME of Active Order: ", UtilityHelper.elementGetText(RESERVED_PICKUP_TIME).contains(savedTimeSlot));
    }

    //to validate update pickup time is display correct
    public void validateUpdatedPickUpTime() {
        UtilityHelper.waitUntilElementVisible(RESERVED_PICKUP_TIME);
        String firstvalue = pickuptime.substring(0, 1);
        if (firstvalue.equals("0")) {
            String rmvZeroPT = pickuptime.substring(1);
            Assert.assertTrue("", RESERVED_PICKUP_TIME.getText().contains(rmvZeroPT));
        } else {
            Assert.assertTrue("Verify TIME of Active Order: ", RESERVED_PICKUP_TIME.getText().contains(pickuptime));
        }
    }

    //Validate order pickup time display - Date
    public void orderPickupTime_Date_Display_OrderHistoryDetailsPage() throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = originalFormat.parse(pickupdate);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEEE, MMMMM dd, yyyy");
        String expectedText = formatter.format(startDate);
        System.out.println("=== Formatted Date of selected Pickup Time Slot is: " + expectedText);
        Assert.assertEquals(expectedText, RESERVED_PICKUP_DATE.getText());
    }

    public void updateSuccessMsg_editPickupTime() {
        UtilityHelper.waitUntilElementVisible(successMessageEditPickupTime);
        Assert.assertEquals(Constants.successMessageEditPickUpTime, successMessageEditPickupTime.getText());
    }

    //To validate Undo button is displayed
    public void undoButtonDisplay() {
        Assert.assertTrue(undoButtonEditOrder.isDisplayed());
    }

    //To validate Items will be removed from order text msg
    public void removeItemInLineMsg() {
        Assert.assertEquals(Constants.orderRemovedInlineMessage, removedItemInlineMsgEditorder.getText());
    }

    public void refreshPageForSuccessfulCanceledOrder() throws InterruptedException {
        int counter = 0, limit = 4;
        // while status == "Placed Order" - refresh page
        while (UtilityHelper.elementGetText(ORDER_STATUS).toUpperCase().equals(Constants.orderPlaced.toUpperCase())) {
            getDriver().navigate().refresh();
            Thread.sleep(3000);
            // if status == "Cancelled" - break.
            if (UtilityHelper.elementGetText(ORDER_STATUS).toUpperCase().equals(Constants.orderCancelled.toUpperCase())) {
                break;
            } else if (counter == limit) {
                // To not get caught in a continuous loop.
                Assert.fail("Order Status did NOT read as 'Cancelled' ");
                break;
            }
            counter++;
        }
    }

    public void orderStatusCancelledDisplayValidation() {
        Assert.assertTrue("Verify Order Status After Cancellation: ", UtilityHelper.elementNotExists(CANCEL_ORDER_LINK));
    }


    public void validate_newlySelectPickUptime() {
        Assert.assertTrue(RESERVED_PICKUP_TIME.getText().contains(firstpickuptime));
    }

    public void click_XButtonOnConfirmationPopUp() {
        UtilityHelper.waitUntilClickable(xButtonAgeConfirmationUpdateOrderScreen);
        xButtonAgeConfirmationUpdateOrderScreen.click();
    }

    public void validate_editPickupTimeNoLongerDisplay() {
        //Assert.assertFalse(editPickTimeLink.isDisplayed());
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@class='edit-pickup-time']/a"));
        Assert.assertTrue("=== Edit Link Not Present!", list.size() == 0);
    }

    public String toSelectSlotPreviousToCurrentPickupSlot() {
        UtilityHelper.moveToViewElement(currentPickUpTimeSlot);
        UtilityHelper.waitUntilElementVisible(currentPickUpTimeSlot);
        String date = currentPickUpTimeSlot.getAttribute("id");
        String removeday = date.substring(4);
        //System.out.println("after day text remove ========>>>>> "+ removeday);
        String daynum = removeday.split("-")[0];
        //System.out.println("After trim day number is ====================>>>>>>>>"+ daynum);
        int d = Integer.valueOf(daynum);
        String CPT = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']//*[@class='pickup-time-slot available selected active']")).getAttribute("data-index");
        System.out.println("=== Current Index of pickup time is: " + CPT);
        int idx = Integer.valueOf(CPT);
        if (idx > 1) {
            for (int i = 1; i <= 10; i++) {
                try {
                    int val = idx - i;
                    //System.out.println("value of val is ====>>>> "+ val);
                    pickuptime = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + d + "+1]//*[@class='pickup-time-slot available' and @data-index='" + val + "']")).getAttribute("data-starttime");
                    //System.out.println("Selected Pickup Time ======>>>>> "+ pickupTime);
                    getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + d + "+1]//*[@class='pickup-time-slot available' and @data-index='" + val + "']")).click();
                    break;
                } catch (Exception e) {
                    System.out.println("slot is not available!!!");
                }
            }
        } else {
            pickuptime = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + d + "+1]//*[@class='pickup-time-slot available']")).getAttribute("data-starttime");
            //System.out.println("Selected Pickup Time ======>>>>> "+ pickupTime);
            getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + d + "+1]//*[@class='pickup-time-slot available']")).click();
        }
        return pickuptime;
    }

    //To select item(s) from pop up add item list and add to cart
    public void userSelectsItemsToBeAddedViaEditOrderMode(WebElement element, String itemQty) {
        UtilityHelper.moveToViewElement(element);
        UtilityHelper.waitUntilClickable(element);

        // Get products name
        String productName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='prod-title']")));
        System.out.println("Name: [" + productName + "]");
        listOfOrderHistoryItem.add(productName);

        // Enter desired quantity
        WebElement qtyField = element.findElement(By.xpath(".//*[@class='qtyField']/input"));
        UtilityHelper.moveToViewElement(qtyField);
        UtilityHelper.typeIntoElement(qtyField, itemQty);

        // Add product
        WebElement addToCartButton = element.findElement(By.xpath(".//*[contains(@class,'add-to-cart')]"));
        UtilityHelper.moveToViewElement(addToCartButton);
        UtilityHelper.click(addToCartButton);

        // Wait until 'remove' text is displayed
        WebElement removeLink = element.findElement(By.xpath(".//*[contains(@class, 'remove-item')]"));
        UtilityHelper.waitUntilClickable(removeLink);
    }

    public void verifyAddItemsButtonCountViaEditOrderMode(int totalItemsToAdd) {
        String actual = UtilityHelper.elementGetText(By.xpath("//*[@class='itemTotalNumber']"));
        Assert.assertEquals("Verify Add Item button Quantity: ", String.valueOf(totalItemsToAdd), actual);

    }

    public List<String> getStringAddList() {
        Collections.sort(extraNamesOfItemList);
        return extraNamesOfItemList;
    }

    //To select hazardous item(s) from popup add item list
    public void selectAndAddChockingHazardItemFromSearchList(int itemadd, String qtyedit) {
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='prod-sort-list']/li"));
        System.out.println("=== total number of search result items: " + noofitems.size());
        int j = 0;
        if (itemadd < noofitems.size()) {
            for (int i = 1; i <= noofitems.size(); i++) {
                try {
                    WebElement chokitem = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + i + "][not (contains(@class, 'unavailable'))]//*[@class='has-warning']"));
                    WebElement plusAddbutton = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + i + "]//*[@class='add-item btn btn-primary btn-block']"));
                    String productName = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + i + "]//*[@class='prod-title']")).getText();
                    System.out.println("ProductName is ===>>>: " + productName);
                    extraNamesOfItemList.add(productName);
                    WebElement qtyfield = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + i + "][not (contains(@class, 'unavailable'))]//*[@class='qtyField']/input"));
                    qtyfield.clear();
                    qtyfield.sendKeys(qtyedit);
                    plusAddbutton.click();
                    j = j + 1;
                    System.out.println("=== The number of selected item is: " + j);
                    if (j == itemadd) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("=== Item is not a choking hazard or Out of order Item!!!");
                }
            }
        } else {
            System.out.println("=== Not Enough items to add in cart. Search other item!");
        }

    }

	/*-----------------------------------------------------------------------------------------------------------*/

    /*===============****************************Need updated***********************===============================*/
    //Choking hazard popup message
    public void chokingHazardPopUpMessageValidation() {
        UtilityHelper.waitUntilElementVisible(By.xpath("//*[@id='pgwModal']//*[@class='pm-content']"));
        Assert.assertTrue(Constants.chokinghazardpopupwarningdesc.contains(UtilityHelper.elementGetText(chokingHarardWarningDescPopup)));
    }

    public void userSelectsVariableOnChokingHazardPopUp(String variable) {
        WebElement button;
        WebElement element = getDriver().findElement(By.xpath("//*[@id='pgwModal']//*[@class='pm-content']"));
        switch (variable.toLowerCase()) {
            case "return to shopping":
                button = element.findElement(By.xpath(".//button[contains(text(),'Return')]"));
                UtilityHelper.click(button);
                break;
            case "add to cart":
                button = element.findElement(By.xpath(".//button[contains(text(),'Add')]"));
                UtilityHelper.click(button);
                break;
        }
        UtilityHelper.waitUntilElementNotVisible(element);
    }

    //To Clear Array List
    public void emptyArrayList_ListOfOrderHistoryItem() {
        listOfOrderHistoryItem.clear();
        System.out.println("    Clear list of stored items in Order History page: " + listOfOrderHistoryItem);
    }

    public void emptyArrayList_ListOfOrderHistoryItemExceptCake() {
        listoforderhistoryitemExceptCake.clear();
        System.out.println("    Clear list of stored items in Order History page except Cake: " + listoforderhistoryitemExceptCake);
    }

    public void emptyArrayList_NameOfItemDeleteList() {
        listOfDeletedItems.clear();
        System.out.println("    Clear list of deleted items names From Order History page: " + listOfDeletedItems);
    }

    public void emptyArrayList_ItemListAfterDel() {
        listOfItemsAfterDelete.clear();
        System.out.println("    Clear list of Remaining Item Names after Delete in Order History Page: " + listOfItemsAfterDelete);
    }

    public void emptyArrayList_ExtrNamesOfItemList() {
        extraNamesOfItemList.clear();
        System.out.println("    Clear list of item names stored while adding items from Order History page: " + extraNamesOfItemList);
    }

    public void emptyArrayList_SelectedReorderItemList() {
        selectedReorderItemList.clear();
        System.out.println("    Clear list of Selected Items during ReOrdering Process: " + selectedReorderItemList);
    }

    public void emptyArrayList_ReOrderItemList() {
        reOrderItemList.clear();
        System.out.println("    Clear list of ALL Selected Items during ReOrdering Process: " + reOrderItemList);
    }

    public void emptyArrayList_OrderBySelectedReorderItemList() {
        orderBySelectedReorderItemList.clear();
        System.out.println("    Clear list of Order By Selected Items during ReOrdering Process: " + orderBySelectedReorderItemList);
    }

    public void emptyArrayList_NewlyAddedItems() {
        listOfNewlyAddedItems.clear();
        System.out.println("    Clear list of Newly Added Items: " + listOfNewlyAddedItems);
    }

    //To increase qty of one Item measure in UOM - LBs
    public void increase_qtyOfItemUOM_Pounds(int lbIncQty) {
        //lazily updates the first uom product in the list.
        List<WebElement> uomProducts = getDriver().findElements(By.xpath("//*[contains(@class, 'quantityInputs') and descendant::span[contains(text(), 'LB')]]"));

        if (uomProducts.size() > 0) {
            WebElement plusButton = uomProducts.get(0).findElement(By.xpath(".//div[text() = '+']"));
            for (int count = 0; count < lbIncQty; count++)
                plusButton.click();
        }
    }

    //To increase qty of one Item measure in UOM - EA
    public void increase_qtyOfItemUOM_Each(int eaIncQty) {
        //lazily updates the first uom product in the list.
        List<WebElement> uomProducts = getDriver().findElements(By.xpath("//*[contains(@class, 'quantityInputs') and descendant::span[contains(text(), 'ea')]]"));

        if (uomProducts.size() > 0) {
            WebElement plusButton = uomProducts.get(0).findElement(By.xpath(".//div[text() = '+']"));
            for (int count = 0; count < eaIncQty; count++)
                plusButton.click();
        }
    }

    //To Reduce QTY of one Item measure in UOM - LBs
    public void reduce_qtyOfItemUOM_Pound(float lbReduQty) {
        {
            //lazily updates the first uom product in the list.
            List<WebElement> uomProducts = getDriver().findElements(By.xpath("//*[contains(@class, 'quantityInputs') and descendant::span[contains(text(), 'LB')]]"));

            if (uomProducts.size() > 0) {
                WebElement plusButton = uomProducts.get(0).findElement(By.xpath(".//div[text() = '-']"));
                for (int count = 0; count < lbReduQty; count++)
                    plusButton.click();
            }
        }
    }

    //To Reduce QTY of one Item measure in UOM - EA
    public void reduce_qtyOfItemUOM_Each(int eaReduQty) {
        //lazily updates the first uom product in the list.
        List<WebElement> uomProducts = getDriver().findElements(By.xpath("//*[contains(@class, 'quantityInputs') and descendant::span[contains(text(), 'ea')]]"));

        if (uomProducts.size() > 0) {
            WebElement plusButton = uomProducts.get(0).findElement(By.xpath(".//div[text() = '-']"));
            for (int count = 0; count < eaReduQty; count++)
                plusButton.click();
        }
    }


/*---------------------->>>>>>>>>>>>To validate SubTotal Calculation after order update<<<<<<<<<<<<<-----------------------------*/

    //To Increase QTY of given item numbers
    public void increaseQTYofGivenProductCount(int noitemtoEdit, int desireQty) throws InterruptedException {
        List<WebElement> itemlist = getDriver().findElements(By.xpath("//*[@class='item-row'][not(contains (@style, 'none'))]//*[@class='form-control quantity quantityReorder']"));
        System.out.println("=== total number of avaiable item to add to cart: " + itemlist.size());
        int j = 0;
        for (WebElement webElement : itemlist) {
            WebElement clickPlusIcon = getDriver().findElement(By.xpath("//*[@class='plusMinusCircle noSelect plus']"));

            for (int i = 1; i < desireQty; i++) {
                clickPlusIcon.click();
            }
            j = j + 1;
            System.out.println("=== The number of Edited item is: " + j);
            if (j == noitemtoEdit) {
                break;
            }
        }
    }

    //To Decrease QTY of given item numbers
    public void decreaseQTYofGivenProductCount(int noitemtoEdit, int desireQty) throws InterruptedException {

        List<WebElement> itemlist = getDriver().findElements(By.xpath("//*[@class='item-row']//*[@class='form-control quantity quantityReorder']"));
        System.out.println("=== total number of Items in order history: " + itemlist.size());
        int j = 0;
        for (int i = 1; i <= itemlist.size(); i++) {
            try {
                WebElement clickMinusIcon = getDriver().findElement(By.xpath("//*[@class='plusMinusCircle noSelect minus']"));
                String currentval = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + i + "][not(contains (@style, 'none'))]//*[@class='qtyField']/input")).getAttribute("value");
                System.out.println("=== Current QTY Value of item:  " + currentval);
                int curvalint = Integer.valueOf(currentval);
                int noofclickmax = curvalint - desireQty;
                for (int k = 1; k <= noofclickmax; k++) {
                    clickMinusIcon.click();
                }
                String updatedval = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + i + "][not(contains (@style, 'none'))]//*[@class='qtyField']/input")).getAttribute("value");
                String desireQtyStr = String.valueOf(desireQty);
                Assert.assertEquals(desireQtyStr, updatedval);
                System.out.println("=== Desire Qty is updated for the item");
                j = j + 1;
                System.out.println("=== The number of Edited item is: " + j);

                if (j == noitemtoEdit) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("=== item row is Display None");
            }

        }
    }

    //To calculate Sub total price in Shopping Cart
    public String calSubTotalvalueCommonLogic_OHDpage() {
        List<WebElement> listcount = getDriver().findElements(By.xpath("//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list of Items: " + listcount.size());
        for (int k = 2; k <= listcount.size() + 1; k++) {
            try {
                String itemprice = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + k + "][not(contains (@style, 'none'))]//*[@class='prodDtlSalePriceDollars']")).getText();
                System.out.println("=== Price List is: " + itemprice);
                PriceListOH.add(itemprice.replaceAll("[^0-9.]", ""));
            } catch (Exception e) {
                System.out.println("=== No Price Found in the list");
            }
        }

        for (int j = 2; j <= listcount.size() + 1; j++) {
            try {
                String itemQTY = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + j + "][not(contains (@style, 'none'))]//*[@class='qtyCol quantityInputs col-xs-2']")).getText();
                System.out.println("=== Qty is: " + itemQTY);
                QtyListOH.add(itemQTY.replaceAll("[^0-9]", ""));
            } catch (Exception e) {
                System.out.println("=== No QTY Found in the list");
            }
        }
        List<Float> PriceListflt = new ArrayList<>(PriceListOH.size());
        for (String mypriceInt : PriceListOH) {
            PriceListflt.add(Float.valueOf(mypriceInt));
        }
        System.out.println("value of pricelist array" + PriceListflt);
        List<Float> QtyListflt = new ArrayList<>(QtyListOH.size());
        for (String myqtyInt : QtyListOH) {
            QtyListflt.add(Float.valueOf(myqtyInt));
        }
        System.out.println("value of pricelist array" + QtyListflt);

        String formattedSubtotal;
        float finalitemPrice;
        float subtotal = 0;
        {
            for (int z = 0; z < PriceListflt.size(); z++) {
                finalitemPrice = PriceListflt.get(z) * QtyListflt.get(z);
                System.out.println("=== finalitemPrice in for loop: " + finalitemPrice);
                subtotal = subtotal + finalitemPrice;
                System.out.println("=== Subtotal Price in forloop: " + subtotal);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            formattedSubtotal = df.format(subtotal);
            System.out.println("=== Return subtotal value is: " + formattedSubtotal);
        }
        return formattedSubtotal;
    }

    //To validate shopping cart price is displayed correct
    public void compareCalSubtotalPriceVsSystemDisplay_OHDpage() {
        String systemsubtotal = merchGrandSubtotalvalueOHDP.getText();
        Assert.assertEquals(calSubTotalvalueCommonLogic_OHDpage(), systemsubtotal.replaceAll("[^0-9.]", ""));
        System.out.println("=== Subtotal Calculation in order history detail page is Correct!!!");
    }


    //Validation of item qty after update
    public void validate_updatedItemCount_Display(String updateitemcount) {
        List<WebElement> itemCount = getDriver().findElements(By.xpath("//*[@id='reorderContainer']/div//*[@class='qtyCol quantityInputs col-xs-2']/div[1]/span"));
        System.out.println("=== Price list of Items:" + itemCount.size());
        for (int i = 2; i <= itemCount.size() + 1; i++) {
            String eachitemcount = getDriver().findElement(By.xpath("//*[@id='reorderContainer']/div[" + i + "]//*[@class='qtyCol quantityInputs col-xs-2']/div[1]/span")).getText();
            Assert.assertEquals(updateitemcount, eachitemcount);
            System.out.println("=== Qty of the Item is displayed correct!!!");
        }
    }


    //Click X button to clear search field on Add item pop up screen
    public void click_Xbutton_ClearSearchField_AddItemPopupModal() {
        xIconToClearSearchResultPopUpODP.click();
    }

    //To validate Placeholder Text on Search Field Add an Item Screen
    public void validate_placeholderText_SearchField() {
        Assert.assertEquals(Constants.placeholderTextSearchField, ADD_ITEM_SEARCH_TEXTBOX.getAttribute("value"));
    }

    //To validate Add X Items button is enable
    public void validate_AddXItemsButton_Enabled() {
        Assert.assertTrue(ADD_ITEM_MODAL_ADD_ITEM_BUTTON.isEnabled());
    }

    // click Select All checkbox
    public void click_SelectAllCheckBox_OHDpage() {
        List<WebElement> checkboxes = getDriver().findElements(By.xpath("//*[contains(@for,'reorderSelectAll_')]/span"));
        System.out.println("=== Number of Select All checkboxes are: " + checkboxes.size());
        for (WebElement check : checkboxes) {
            check.click();
        }
    }

    //To select random item for ReOrder Process
    public void userSelectsRandomItemForReOrdering(WebElement element) {
        WebElement checkBox = element.findElement(By.xpath(".//label/span"));
        UtilityHelper.moveToViewElement(checkBox);
        UtilityHelper.click(checkBox);
        String name = element.findElement(By.xpath(".//p[@class='mjr-visually-hidden']")).getAttribute("innerHTML");
        selectedReorderItemList.add(name);
        System.out.println("Selected ReOrder Item : [" + name + "]");

    }

    //Validate Reorder Items button is enabled
    public void validateReorderItemsButtonIsEnabled() {
        Assert.assertTrue("Verify 'Reorder Items' button is enabled: ", UtilityHelper.isEnabled(REORDER_ITEMS_BUTTON));
    }

    //Click ReOrder Item Button
    public void clickOnReorderItemButton() {
        UtilityHelper.waitUntilClickable(REORDER_ITEMS_BUTTON);
        UtilityHelper.click(REORDER_ITEMS_BUTTON);
    }

    //To wait until ReOrder Pop Up Modal Appears
    public void waitUntilReorderPopUp() {
        UtilityHelper.waitUntilElementVisible(REORDER_ITEMS_POPUP);
    }

    //Reorder Items pop up - Header Validation
    public void headerValidationReorderItemPopup() {
        UtilityHelper.waitUntilElementVisible(REORDER_ITEMS_POPUP_TITLE);
        Assert.assertEquals(Constants.reOrderItemPopupHeaderTxt, REORDER_ITEMS_POPUP_TITLE.getText());
    }

    //Click Add Items to Cart Button
    public void clickAddItemsToCartOnReorderItemsPopUp() {
        UtilityHelper.click(ADD_ITEMS_REORDER_POPUP_BUTTON);
    }

    public void waitForProductsToBeAddedToCartFromOrderHistory() throws InterruptedException {
        int limit = 6, counter = 0;
        if (UtilityHelper.elementExists(PAGE_LOADER)) {
            while (UtilityHelper.elementExists(PAGE_LOADER)) {
                Thread.sleep(2000);
                if (limit == counter) {
                    Assert.fail("Failed to Add product from Order History.");
                }
                counter++;
            }
        }
        Assert.assertTrue(!(UtilityHelper.isDisplayed(PAGE_LOADER)));
    }

    //To Store ReOrder Item Names
    public void setReOrderItemArrayList() {
        List<WebElement> reOrderList = getDriver().findElements(By.xpath("//*[@class='orderList']/li//*[@class='prod-title text-left']"));
        for (WebElement item : reOrderList) {
            String name = item.getText();
            reOrderItemList.add(name.trim());
        }
    }

    public List<String> getStringReorderList() {
        Collections.sort(reOrderItemList);
        return reOrderItemList;
    }

    /* !! SAVE THIS !! */
    public List<String> getSelectedReorderItemList() {
        Collections.sort(selectedReorderItemList);
        return selectedReorderItemList;
    }

    /* !! SAVE THIS !! */
    public List<String> getOrderBySelectedReorderItemList() {
        Collections.sort(orderBySelectedReorderItemList);
        return orderBySelectedReorderItemList;
    }

    /* !! SAVE THIS !! */
    public void setOrderBySelectedReOrderItemList() {
        for (int i = (selectedReorderItemList.size() - 1); i >= 0; i--) {
            orderBySelectedReorderItemList.add(selectedReorderItemList.get(i));
        }
    }

    //Update Item Count so that total item count is grater than 12
    public void update_itemCount_ToReachFullorder(int desireitemcount) {
        int j = 0;
        List<WebElement> itemqtyrowcount = getDriver().findElements(By.xpath("//*[@class='item-row']/div[contains (@class, 'qtyCol quantityInputs col-xs-2')]/div[1]/span"));
        System.out.println("=== Total Number of Item count is:  " + itemqtyrowcount.size());
        for (int i = 1; i <= itemqtyrowcount.size(); i++) {
            String itemqty = getDriver().findElement(By.xpath("//*[@class='orderList']/li[" + i + "]//*[@id='reorderQty']/div[2]/div[2]/input")).getAttribute("value");
            int c = Integer.valueOf(itemqty);
            j = j + c;
            System.out.println("=== total item Qty value is: " + j);
        }

        if (j <= desireitemcount) {
            WebElement noofPlusclick = getDriver().findElement(By.xpath("//*[@class='orderList']/li//*[text()='+']"));
            int noofclick = (desireitemcount - j) + 5;
            System.out.println("=== number of click to increase count is:  " + noofclick);
            for (int i = 1; i < noofclick; i++) {
                noofPlusclick.click();
            }
        } else {
            System.out.println("=== No need to increase the count of the items!!!");
        }
    }

    public void validate_SelectedPickupTimeDisplay_CurbsideWizard() {
        String firstvalue = pickuptime.substring(0, 1);
        System.out.println("=== First value of Pickup time is: " + firstvalue);
        if (firstvalue.equals("0")) {
            String rmvZeroPT = pickuptime.substring(1);
            System.out.println("=== Zero remove pickup time: " + rmvZeroPT);
            Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(rmvZeroPT));
        } else {
            Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(pickuptime));
        }
    }

    //To Validate Curbside wizard pickup time - Day
    public void validate_Curbside_SelectedSlot_Day() throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = originalFormat.parse(pickupdate);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        String text = formatter.format(startDate);
        System.out.println("=== Day of the week is: " + text);
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(text));
    }

    //To select All Available slot and validate content of the slot
    public void highlight_validate_PickuptimeSlotContent() {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println("=== Available Number of days for Pickup Slot: " + allpickupDate.size());
        for (int i = 1; i <= allpickupDate.size(); i++) {
            WebElement pickupDate = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
            pickupDate.click();
            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]/div[contains (@class, 'pickup-time-slot available')][not (contains (@class, 'selected'))]"));
            System.out.println("=== Available Number of Pickup Slot: " + as.size());
            if (as.size() > 0) {
                for (WebElement element : as) {
                    element.click();
                    String newpickuptime = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//*[@class='pickup-time-slot available selected']/span[2]/strong[1]")).getText();
                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                    String wewillholduntiltext = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//*[@class='pickup-time-slot available selected']/span[2]")).getText();
                    Assert.assertFalse(wewillholduntiltext.contains(Constants.weWillHoldUntilText));
                }
            }
        }
    }

    //To Validate All Alt UoM is consistent with its product
    public void altUoM_AllItemsDuringReOrderingProcess() {
        List<WebElement> orderDetailList = getDriver().findElements(By.xpath("//*[contains(@class,'item-row')]//span[@class='uom']"));
        List<WebElement> reOrderList = getDriver().findElements(By.xpath("//div[@class='orderButtonWrap']//span[@class='uom']"));
        if (orderDetailList.size() == reOrderList.size()) {
            for (int i = 0; i < orderDetailList.size(); i++) {
                Assert.assertEquals("Verify Alt UoM Description Matches",
                        orderDetailList.get(i).getText().toUpperCase(), reOrderList.get(i).getText().toUpperCase());
            }
        } else {
            //To ensure there are the number of UoM items is correct
            System.out.println("Re-ordering Alt UoM != Order Detail Alt UoM ");
            Assert.assertEquals("Order Detail Alt UoM Count", orderDetailList.size(), reOrderList.size());
        }
    }

    public void compareNewlyAddedItemsWithExistingItemsInActiveOrderUpdate() {
        System.out.println("List of Product Names in Active Order ==========>> " + getListOfOrderHistoryItems());
        System.out.println("List of Newly Added Products in Active Order ===>> " + getListOfNewlyAddedItems());
        Assert.assertTrue("Active Order Items [" + getListOfOrderHistoryItems() + "] "
                        + " NOT contains Newly Added Items [" + getListOfNewlyAddedItems() + "]"
                , getListOfOrderHistoryItems().containsAll(getListOfNewlyAddedItems()));
    }

    public void verifyUserIsNotAllowedToAddSPOSHTProductsViaEditActiveOrder() {
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='searchEditResults']"));
        String actual = getDriver().findElement(By.xpath("//*[@id='searchEditResults']/p")).getText().trim();
        Assert.assertEquals("Verify user cant Add SPO or STH products via Edit Mode: ", "No results found", actual);
    }

    public void userRetainsCurrentDateAndTimeOfActiveOrderInOrderDetailsPage() {
        OrderPickupPage.pickupDate = activeOrderPickupDate.getText().substring(0, 3).trim();
        OrderPickupPage.pickupTime = activeOrderPickupTime.getText().substring(0, 5).trim();
        System.out.println("DATE: [" + OrderPickupPage.pickupDate + "]");
        System.out.println("TIME: [" + OrderPickupPage.pickupTime + "]");
    }

    public void userValidatesDateOnActiveOrderOnOrderDetailsPage() {
        String savedSlotDate = OrderPickupPage.pickupDate;
        String actualDate = UtilityHelper.elementGetText(activeOrderPickupDate).substring(0, 3).trim();
        Assert.assertEquals("Verify DATE on Order Details Page: ", savedSlotDate.toUpperCase(), actualDate.toUpperCase());
    }

    public void userValidatesTimeOnActiveOrderOnOrderDetailsPage() {
        String savedSlotTime = OrderPickupPage.pickupTime;
        if (savedSlotTime.charAt(0) == '0') {
            savedSlotTime = savedSlotTime.substring(1);
        }
        String actualTime = UtilityHelper.elementGetText(activeOrderPickupTime).substring(0, 5).trim();
        Assert.assertEquals("Verify TIME on Order Details Page: ", savedSlotTime.toUpperCase(), actualTime.toUpperCase());
    }

    public void verifyWarningChokingHazardCopyWhileInEditMode() {
        WebElement hasChokingHazardWarning = getDriver().findElement(By.xpath("(//*[@class='products']//*[@class='has-warning']//span)[1]"));
        UtilityHelper.moveToViewElement(hasChokingHazardWarning);
        Assert.assertTrue("Warning: Choking Hazard Copy is Displayed: ", UtilityHelper.elementExists(hasChokingHazardWarning));
    }

    public void verifyAgeRestrictedMessageInOrderDetails() {
        WebElement hasAgeRestrictedWarning = getDriver().findElement(By.xpath("(//*[@class='products']//*[@class='age-restricted'])[1]"));
        UtilityHelper.moveToViewElement(hasAgeRestrictedWarning);
        Assert.assertTrue("Age Restricted Message is Displayed: ", UtilityHelper.elementExists(hasAgeRestrictedWarning));
    }
}
