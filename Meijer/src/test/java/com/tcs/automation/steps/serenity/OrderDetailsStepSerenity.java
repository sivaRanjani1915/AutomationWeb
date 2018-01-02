package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.HomePage;
import com.tcs.automation.pages.OrderDetailPage;
import com.tcs.automation.pages.OrderPickupPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

import java.text.ParseException;

public class OrderDetailsStepSerenity extends ScenarioSteps {

    OrderDetailPage orderDetailPage;
    OrderPickupPage orderPickUpPage;
    HomePage homePage;
    utilityhelper UtilityHelper;

    @Step
    public void orderHistoryDetailsPageDisplay() {
        orderDetailPage.orderHistoryDetailsPageDisplay();
    }


    @Step
    public void validateOrderHistoryDetailLookAndFeelValidation() {
        orderDetailPage.validateOrderHistoryDetailLookAndFeelValidation();
    }

    @Step
    public void validateActivePickupTimeDisplay() {
        orderDetailPage.validateActivePickupTimeDisplay();
    }

    @Step
    public void validate_OrderNumberDisplay() {
        orderDetailPage.orderNumberDisplay_Valdiation();
    }

    @Step
    public void validateOrderStatusDisplay() {
        orderDetailPage.validateOrderStatusDisplay();
    }

    @Step
    public void validate_OrderDateDisplay() {
        orderDetailPage.orderDateDisplayValidationOrderDetailsPage();
    }

    @Step
    public void verify_contentPaymentAndCouponsDetailsValidation(String address1, String ccaddress2, String ccnumber) {
        orderDetailPage.contentPaymentAndCouponsDetailsValidation(address1, ccaddress2);
        orderDetailPage.validate_CCEndingDisplay(ccnumber);
    }

    @Step
    public void highLightPlusAddAnItemButton() {
        UtilityHelper.highLightElement(orderDetailPage.PLUS_ADD_ITEM_BUTTON);
    }

    @Step
    public void userClickOnPlusAddAnItemOption() {
        orderDetailPage.userClickOnPlusAddAnItemOption();
    }

    @Step
    public void user_verifyAddAnItemSearchWasNotPerformed() {
        orderDetailPage.userVerifyAddAnItemSearchWasNotPerformed();
    }

    @Step
    public void user_storeEditOrderUrl() {
        orderDetailPage.storeEditOrderUrl();
    }

    @Step
    public void user_verifyUserIsNotRedirectedToAnotherPage() {
        orderDetailPage.userVerifyUserIsNotRedirectedToAnotherPage();
    }

    @Step
    public void waitUntilAddItemModalIsDisplayed() {
        orderDetailPage.waitUntilAddItemModalIsDisplayed();
    }

    @Step
    public void type_BeerAndSearchTheItem(String alcohol) {
        orderDetailPage.beerSearchOnPopupUpdateOrder(alcohol);
    }

    @Step
    public void type_BoardGamesAndSearchTheItem(String toserachitem) {
        orderDetailPage.chockinghazarditemSearchOnPopupUpdateOrder(toserachitem);
    }

    @Step
    public void type_AndSearchAppleItem(String toserachitem) {
        orderDetailPage.appleitemSearchOnPopupUpdateOrder(toserachitem);
    }

    @Step
    public void user_TypeItemAndSearchIt(String toserachitem) {
        orderDetailPage.ipa_itemSearchOnPopupUpdateOrder(toserachitem);
    }


    @Step
    public void userSearchesViaAddItemModal(String searchTerm) {
        orderDetailPage.userSearchesViaAddItemModal(searchTerm);
    }

    @Step
    public void userSelectsItemsToBeAddedViaEditOrderMode(WebElement element, String itemQty) {
        orderDetailPage.userSelectsItemsToBeAddedViaEditOrderMode(element, itemQty);
    }

    @Step
    public void verifyAddItemsButtonCountViaEditOrderMode(int totalItemsToAdd) {
        orderDetailPage.verifyAddItemsButtonCountViaEditOrderMode(totalItemsToAdd);
    }

    @Step
    public void user_SelectItemWithChokingHazardAndClickOnPlusAdd(int itemadd, String qtyedit) {
        orderDetailPage.selectAndAddChockingHazardItemFromSearchList(itemadd, qtyedit);
    }

    @Step
    public void validate_PlusAddButtonChangeToRemoveLink() {
        orderDetailPage.clickplusAddButtonChangeToRemoveLinkItemPopup();
    }

    @Step
    public void highLightAddXItemsButton() {
        UtilityHelper.highLightElement(orderDetailPage.ADD_ITEM_MODAL_ADD_ITEM_BUTTON);
    }

    @Step
    public void waitUntilAddItemModalVanishes() {
        orderDetailPage.waitUntilAddItemModalVanishes();
    }

    @Step
    public void clickOnAddXItemsButton() {
        orderDetailPage.clickOnAddXItemsButton();
    }

    @Step
    public void validate_NotificationMessageAfter1itemAddedButBeforeUpdatingOrder() {
        orderDetailPage.toBeNotifyMsg1itemadded_BeforeOrderUpdate();
    }

    @Step
    public void validate_NotificationMessageAfter3itemsAddedbutBeforUpdatingOrder() {
        orderDetailPage.tobeNotifuMsg3ItemAddedOrderUpdate();
    }

    @Step
    public void validate_NotificationMsgAfter4itemsAddedButBeforeUpdatingOrder() {
        orderDetailPage.tobeNotifuMsg4ItemAddedOrderUpdate();
    }
    @Step
    public void moveToViewUpdateOrderButton() {
        orderDetailPage.moveToViewUpdateOrderButton();
    }

    @Step
    public void highLightUpdateOrderButton() throws InterruptedException {
        orderDetailPage.highLightUpdateOrderButton();
    }

    @Step
    public void clickOnUpdateOrderButtonToUpdateTheOrder() {
        orderDetailPage.clickOnUpdateOrderButtonToUpdateTheOrder();
    }

    @Step
    public void update_OrderPopupConfirmationMessageDisplay() {
        orderDetailPage.updateOrderConfirmationPopUp();
    }

    @Step
    public void user_SelectCancelOptionOnUpdateOrderPopupConfirmationMessage() {
        orderDetailPage.clickCancel_OrderUpdatePopUpConfirmation();
    }

    @Step
    public void user_ClickXbuttonOnUpdateOrderPopupConfirmationMessage() {
        orderDetailPage.clickXbutton_OrderUpdatePopUpConfirmation();
    }

    @Step
    public void waitUntilUpdateOrderConfirmationPopUpDisplay() {
        orderDetailPage.waitUntilUpdateOrderConfirmationPopUpDisplay();
    }

    @Step
    public void highLightUpdateOrderButtonOnConfirmationPopUp() {
        UtilityHelper.highLightElement(orderDetailPage.UPDATE_CONFIRMATION_MODAL_UPDATE_BUTTON);
    }

    @Step
    public void userClickUpdateOrderButtonOnPopupConfirmation() {
        orderDetailPage.userClickUpdateOrderButtonOnPopupConfirmation();
    }

    @Step
    public void waitUntilAgeRestrictedConfirmationModalAppears() {
        orderDetailPage.waitUntilAgeRestrictedConfirmationModalAppears();
    }

    @Step
    public void highLightConfirmButtonOnAgeRestrictedModal() {
        orderDetailPage.highLightConfirmButtonOnAgeRestrictedModal();
    }

    @Step
    public void userClicksConfirmOnAgeRestrictedConfirmationModal() {
        orderDetailPage.userClicksConfirmOnAgeRestrictedConfirmationModal();
    }

    @Step
    public void user_SelectCancelOnAgeRestrictionPopup() {
        orderDetailPage.cancelButtonOnAgeRestrictionPopMsgOrderUpdate();
    }

    @Step
    public void moveToViewCancelOrderLink() {
        orderDetailPage.moveToViewCancelOrderLink();
    }

    @Step
    public void highLightCancelOrderLink() {
        UtilityHelper.highLightElement(orderDetailPage.CANCEL_ORDER_LINK);
    }

    @Step
    public void userClickOnCancelOrderLink() {
        orderDetailPage.userClickOnCancelOrderLink();
    }

    @Step
    public void moveToViewCancelOrderConfirmationPopUp() {
        orderDetailPage.moveToViewCancelOrderConfirmationPopUp();
    }

    @Step
    public void highLightCancelOrderOnConfirmationPopUp() {
        UtilityHelper.highLightElement(orderDetailPage.CANCEL_ORDER_POPUP_BUTTON);
    }

    @Step
    public void userClickOnCancelOrderOnConfirmationPopUp() {
        orderDetailPage.userClickOnCancelOrderOnConfirmationPopUp();
    }

    @Step
    public void user_ClickGoBackButtonOnOrderCancelConfirmationMessage() {
        orderDetailPage.clickGoBackButtonOrderDetail();
    }

    @Step
    public void validate_ContentInCubsidePickupDisplay(String storename, String cardesc, String shopcartsub, String comment) {
        orderDetailPage.orderHisdetail_StoreNameValidation(storename);
        orderDetailPage.orderHisdetail_PickuplocationValidation();
        orderDetailPage.orderHisdetail_CarDescValidation(cardesc);
        orderDetailPage.orderHisdetail_ShoppingSubValidation(shopcartsub);
        orderDetailPage.orderHisdetail_CommentValidation(comment);
    }

    @Step
    public void validate_ContentofCurbsidePickupWithoutComment(String storename, String cardesc, String shopcartsub) {
        orderDetailPage.orderHisdetail_StoreNameValidation(storename);
        orderDetailPage.orderHisdetail_PickuplocationValidation();
        orderDetailPage.orderHisdetail_CarDescValidation(cardesc);
        orderDetailPage.orderHisdetail_ShoppingSubValidation(shopcartsub);
    }

    @Step
    public void validate_MaxCommentLengthDisplayOnCurbsidePiclup() {
        orderDetailPage.validate_MaxCommentText_OHDPage();
    }

    @Step
    public void validate_CurbsideDisplayForGetDirectionAndEditPickupTimeLinks() {
        orderDetailPage.editPickupTime_linkDisplay_Valdiation();
        orderDetailPage.getDirection_linkDisplay_Valdiation();
    }

    @Step
    public void validate_CurbsideContentspickupdisplay(String storename, String cardesc) {
        orderDetailPage.orderHisdetail_StoreNameValidation(storename);
        orderDetailPage.orderHisdetail_PickuplocationValidation();
        orderDetailPage.orderHisdetail_CarDescValidation(cardesc);
    }


    @Step
    public void validate_ContentInCubsidePickupDisplayWithoutCarDesc(String storename, String shopcartsub, String comment) {
        orderDetailPage.orderHisdetail_StoreNameValidation(storename);
        orderDetailPage.orderHisdetail_PickuplocationValidation();
        //orderDetailPage.orderHisdetail_ShoppingSubValidation(shopcartsub);
        orderDetailPage.orderHisdetail_CommentValidation(comment);
    }

    @Step
    public void validate_ContentInCakeDeliStorePickupDisplay(String storename) {
        orderDetailPage.orderHisdetail_StoreNameUnderDeliCakeValidation(storename);
        orderDetailPage.orderHisdetail_PickuplocationDeliBakeryValidation();
    }

    @Step
    public void highLightEditOrderButton() {
        UtilityHelper.highLightElement(orderDetailPage.EDIT_ORDER_BUTTON);
    }

    @Step
    public void userClickEditOrderButton() throws InterruptedException {
        orderDetailPage.userClickEditOrderButton();
    }

    @Step
    public void validateOrderEditModeDisplay() {
        orderDetailPage.validateOrderEditModeDisplay();
    }

    @Step
    public void click_OnRemoveLinkOfProduct() {
        orderDetailPage.click1stProductRemoveLinkOrderEdit();
    }

    @Step
    public void user_ClickUndoButton() {
        orderDetailPage.clickUndoButtonOrderEdit();
    }

    @Step
    public void validate_EditOrderPageAfterAllOrderRemoved() {
        orderDetailPage.selectAllHeader_CheckBox();
        //orderDetailPage.reOrderButton_Disabled();
        orderDetailPage.validate_cancelButtonNotDisplay();
    }

    @Step
    public void validate_OrderStatusAfterCancelled(String orderstatus) {
        orderDetailPage.orderStatusAfterCancelledValdiation(orderstatus);
    }

    @Step
    public void increase_QTYofEachProductinOrderEdit(int editQty) throws InterruptedException {
        orderDetailPage.increaseQTYofEachProduct(editQty);
    }

    @Step
    public void remove_CNCProductsFromOrderStoreProdName(int itemremove) {
        orderDetailPage.removeCNCProductsFromOrderexcept1st(itemremove);
    }

    @Step
    public void remove_CNCProductsFromOrderedList(WebElement element) {
        orderDetailPage.atRandomRemoveItemsFromActiveOrder(element);
    }

    @Step
    public void user_Undofor1ofTheProduct() {
        orderDetailPage.toUndofor1ofTheProductRemove();
    }

    @Step
    public void validate_OrderUpdateDisplayCorrectly(String remainingitem) {
        orderDetailPage.toValidateOrderUpdate_Display(remainingitem);
        orderDetailPage.setItemListAfterDelete();
        orderDetailPage.validateDelItemNamesNotDisplay();
    }


    @Step
    public void validate_OrderHistoryPageForButtonAndLinksDisabled() {
        //orderDetailPage.validate_AddAnItemButtonDisabled();
        //orderDetailPage.validate_EditOrderButtonDisabled();
        orderDetailPage.validate_cancelButtonNotDisplay();
        //orderDetailPage.validate_editpicktimeNotDisplay();
    }

    @Step
    public void validate_ShipToHomeSectionIsDisplayCorrect() {
        orderDetailPage.chargedTodaySTHitemOrderHistory();
    }


    @Step
    public void setArrayListWithCurrentProductNamesViaOrderDetailsPage(WebElement element) {
        orderDetailPage.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
    }

    @Step
    public void validate_orderitemDisplayCorrectOrderHistoryDetailPage() {
        orderDetailPage.orderitemDisplayCorrectOrderHistoryDetailPage();
    }

    @Step
    public void validate_CorrectItemNameDisplayExceptCakeInOrderHistoryDetailPage() {
        orderDetailPage.selecteditemvalidation_OrderHistiryDetailExcludeCake();
        orderDetailPage.orderitemDisplayCorrectOrderHistoryDetailPageExceptCustomCake();
    }

    @Step
    public void all_ItemsInOrderStillDisplayedTheSame(int itemcount) {
        orderDetailPage.afterOrderCancelled_ItemsDisplay(itemcount);
    }

    @Step
    public void valdiate_AllItemsInOrderStillDisplayedSameExlcudingCake(int itemcount) {
        orderDetailPage.selecteditemvalidation_OrderHistiryDetailExcludeCake();
        orderDetailPage.afterOrderCancelled_ItemsDisplayExcludingCustomCake(itemcount);
    }

    @Step
    public void user_ClickonEditPickupTime() throws InterruptedException {
        orderDetailPage.clickEditPickUpTime();
    }

    @Step
    public void user_SelectaNewPickupTimeAndUpdateIt() throws InterruptedException {

        orderDetailPage.selectNewPickupTimeEditPickup();
        orderDetailPage.selectAvailableTime();
        orderDetailPage.clickUpdatePickupTimeButton();
    }

    @Step
    public void user_SelectaNewPickupTime() {
        orderDetailPage.selectNewPickupTimeEditPickup();
        orderDetailPage.selectAvailableTime();
    }

    @Step
    public void validate_TheNewlySelectedPickupTimeDisplayCorrect() throws ParseException {
        //orderDetailPage.updateSuccessMsg_editPickupTime();
        orderDetailPage.validateUpdatedPickUpTime();
        orderDetailPage.orderPickupTime_Date_Display_OrderHistoryDetailsPage();
    }

    @Step
    public void validate_NewlySelectedAdjacentPickupTimeDisplayCorrect() {
        orderDetailPage.updateSuccessMsg_editPickupTime();
        //orderDetailPage.selected_NewPickUpTimeDisplayValdiation();
        orderDetailPage.validate_newlySelectPickUptime();
    }

    @Step
    public void validate_ChargeAtPickupForCurbsideText() {
        orderDetailPage.chargedAtPickupCurbsideItem();
    }

    @Step
    public void validate_DisplayOfItemAfterClickedonRemovedButton() {
        orderDetailPage.undoButtonDisplay();
        orderDetailPage.removeItemInLineMsg();
    }

    @Step
    public void validate_OrderStatusAfterSuccessfullyCancelledOrder() {
//        orderDetailPage.refreshPageForSuccessfulCanceledOrder();
        orderDetailPage.orderStatusCancelledDisplayValidation();
    }

    @Step
    public void validate_OrderStatusRemainsSameAsOrderPlaced() {
        orderDetailPage.validateOrderStatusDisplay();
    }

    @Step
    public void validate_cancelEditOrder() {
        orderDetailPage.selectCancelEditPickupTime();
    }

    @Step
    public void user_CloseEditPickupTimePopupWindow() {
        orderDetailPage.clickXButtonIconEditPickupTimePopup();
    }

    @Step
    public void user_SelectNewPickupTimeJustBeforeorAfterCurrentPickupSlot() {
        /*orderDetailPage.firstavailableStartPickupTime();
        orderDetailPage.select_PickupSlotJustAfterCurrentPickupSlot();*/
        orderDetailPage.toSelectSlotPreviousToCurrentPickupSlot();
    }

    @Step
    public void update_NewSelectedPickupTime() throws InterruptedException {
        orderDetailPage.clickUpdatePickupTimeButton();
    }

    @Step
    public void user_ClickXButtonOnOrderCancelConfirmationMessage() {
        orderDetailPage.click_XButtonOnConfirmationPopUp();
    }

    @Step
    public void validate_NoLongerDisplayPickupTimeAndLinksForOrderCanceled() {
        orderDetailPage.validate_editPickupTimeNoLongerDisplay();
    }

    @Step
    public void validate_CancelOrderLinkIsNotDisplayed() {
        orderDetailPage.validate_cancelButtonNotDisplay();
    }

    @Step
    public void chokingHazardPopUpMessageValidation() {
        orderDetailPage.chokingHazardPopUpMessageValidation();
    }

    @Step
    public void userSelectsVariableOnChokingHazardPopUp(String variable) {
        orderDetailPage.userSelectsVariableOnChokingHazardPopUp(variable);
    }

    @Step
    public void validate_CancelButtonAndEditOrderButtonsAreEnabled() {
        orderDetailPage.editOrderEnabledValidation();
        orderDetailPage.cancelOrderEnabledValidation();
    }

    @Step
    public void user_IncreaseCountOfItemWithPoundAsUOM(int lbIncQty) {
        orderDetailPage.increase_qtyOfItemUOM_Pounds(lbIncQty);
    }

    @Step
    public void user_IncreaseCountOfItemWithEachAsUOM(int eaIncQty) {
        orderDetailPage.increase_qtyOfItemUOM_Each(eaIncQty);
    }

    @Step
    public void userReduceCountOfItemWhichHasUOMasPound(float lbReduQty) {
        orderDetailPage.reduce_qtyOfItemUOM_Pound(lbReduQty);
    }

    @Step
    public void userReduceCountOfItemWhichHasUOMasEach(int eaReduQty) {
        orderDetailPage.reduce_qtyOfItemUOM_Each(eaReduQty);
    }

    @Step
    public void validatePageRefreshAndPageIsNoLongerInEditMode() {
        orderDetailPage.editOrderEnabledValidation();
        orderDetailPage.plusAddAnItemEnabledValidation();
    }

    @Step
    public void user_EditOrderForItemsToIncreaseQty(int noitemtoEdit, int desireQty) throws InterruptedException {
        orderDetailPage.increaseQTYofGivenProductCount(noitemtoEdit, desireQty);
    }

    @Step
    public void user_EditOrderForItemsToDecreaseQty(int noitemtoEdit, int desireQty) throws InterruptedException {
        orderDetailPage.decreaseQTYofGivenProductCount(noitemtoEdit, desireQty);
    }

    @Step
    public void validate_SubtotalIsUpdatedCorrectlyAfterEditOrder() {
        orderDetailPage.compareCalSubtotalPriceVsSystemDisplay_OHDpage();
    }

    @Step
    public void validate_ItemCountAfterOrderUpdate(String updateitemcount) {
        orderDetailPage.validate_updatedItemCount_Display(updateitemcount);
    }

    @Step
    public void user_ClickXButtonToClearSearchField() {
        orderDetailPage.click_Xbutton_ClearSearchField_AddItemPopupModal();
    }

    @Step
    public void validate_PlaceholderTextonSearchFieldofAddanItemScreen() {
        orderDetailPage.validate_placeholderText_SearchField();
    }

    @Step
    public void validate_AddXitemsButtonisEnabled() {
        orderDetailPage.validate_AddXItemsButton_Enabled();
    }

    @Step
    public void highLightMeijerLogo() {
        UtilityHelper.highLightElement(homePage.MEIJER_LOGO);
    }

    @Step
    public void userClickMeijerLogo() {
        homePage.userClickMeijerLogo();
    }

    @Step
    public void user_ClickOnSelectAllCheckbox() {
        orderDetailPage.click_SelectAllCheckBox_OHDpage();
    }

    @Step
    public void userSelectsRandomItemForReOrdering(WebElement element) {
        orderDetailPage.userSelectsRandomItemForReOrdering(element);
    }

    @Step
    public void validateReorderItemsButtonIsEnabled() {
        orderDetailPage.validateReorderItemsButtonIsEnabled();
    }

    @Step
    public void highLightReorderItemsButton() {
        UtilityHelper.highLightElement(orderDetailPage.REORDER_ITEMS_BUTTON);
    }

    @Step
    public void clickOnReorderItemButton() {
        orderDetailPage.clickOnReorderItemButton();
    }

    @Step
    public void waitUntilReorderPopUp() {
        orderDetailPage.waitUntilReorderPopUp();
    }

    @Step
    public void validateReorderItemPopupLookAndFeel() {
        orderDetailPage.headerValidationReorderItemPopup();
        orderDetailPage.setReOrderItemArrayList();
    }

    @Step
    public void validateAllAltUoM_ItemsDuringReOrderingProcess() {
        orderDetailPage.altUoM_AllItemsDuringReOrderingProcess();
    }

    @Step
    public void highLightAddItemsButtonReorderPopUp() {
        UtilityHelper.highLightElement(orderDetailPage.ADD_ITEMS_REORDER_POPUP_BUTTON);
    }

    @Step
    public void clickAddItemsToCartOnReorderItemsPopUp() {
        orderDetailPage.clickAddItemsToCartOnReorderItemsPopUp();
    }

    @Step
    public void waitForProductsToBeAddedToCartFromOrderHistory() throws InterruptedException {
        orderDetailPage.waitForProductsToBeAddedToCartFromOrderHistory();
    }

    @Step
    public void update_QtyofItemssoTotalQtyisGreaterThan12(int desireitemcount) {
        orderDetailPage.update_itemCount_ToReachFullorder(desireitemcount);
    }

    @Step
    public void validate_CurrentPickupTimeDisplayCorrectOn_OrderHistoryDetailPage() {
        orderDetailPage.validate_CurrentPickupTimeSlot();
    }

    @Step
    public void validate_NewlySelectedTimeDisplayCorrectOnCurbsideWizard() throws ParseException {
        orderDetailPage.validate_SelectedPickupTimeDisplay_CurbsideWizard();
        orderDetailPage.validate_Curbside_SelectedSlot_Day();
    }

    @Step
    public void validate_ContentOfEachPickupTimeSlotOnOrderHistoryDetailPage() throws InterruptedException {
        orderDetailPage.clickEditPickUpTime();
        orderDetailPage.highlight_validate_PickuptimeSlotContent();
    }

    @Step
    public void validateSelectedDateAndTImeViaOrderHistoryDetailPage() {
        orderDetailPage.validateUpdatedPickUpDateViaOrderPickUpPageSavedValue();
        orderDetailPage.validateUpdatedPickUpTimeViaOrderPickUpPageSavedValue();
    }

    @Step
    public void setArrayListWithNewlyAddedItems(WebElement element) {
        orderDetailPage.setArrayListWithNewlyAddedItems(element);
    }

    @Step
    public void compareNewlyAddedItemsWithExistingItemsInActiveOrderUpdate() {
        orderDetailPage.compareNewlyAddedItemsWithExistingItemsInActiveOrderUpdate();
    }

    @Step
    public void compareRemovedItemsAgainstExistingItemsInActiveOrder() {
        orderDetailPage.setItemListAfterDelete();
        orderDetailPage.validateDelItemNamesNotDisplay();
    }

    @Step
    public void atRandomRemoveItemsFromActiveOrder(WebElement element) {
        orderDetailPage.atRandomRemoveItemsFromActiveOrder(element);
    }

    @Step
    public void verifyUserIsNotAllowedToAddSPOSHTProductsViaEditActiveOrder() {
        orderDetailPage.verifyUserIsNotAllowedToAddSPOSHTProductsViaEditActiveOrder();
    }

    @Step
    public void userRetainsCurrentDateAndTimeOfActiveOrderInOrderDetailsPage() {
        orderDetailPage.userRetainsCurrentDateAndTimeOfActiveOrderInOrderDetailsPage();
    }

    @Step
    public void waitUntilTimeSlotAppears() {
        orderPickUpPage.waitUntilTimeSlotAppears();
    }

    @Step
    public void verifyCurrentDateAndTimeViaOrderDetailsPage() {
        orderPickUpPage.verifyCurrentDateAndTimeViaOrderDetailsPage();
    }

    @Step
    public void userValidatesDateOnActiveOrderOnOrderDetailsPage() {
        orderDetailPage.userValidatesDateOnActiveOrderOnOrderDetailsPage();
    }

    @Step
    public void userValidatesTimeOnActiveOrderOnOrderDetailsPage() {
        orderDetailPage.userValidatesTimeOnActiveOrderOnOrderDetailsPage();
    }

    @Step
    public void verifyWarningChokingHazardCopyWhileInEditMode() {
        orderDetailPage.verifyWarningChokingHazardCopyWhileInEditMode();
    }

    @Step
    public void verifyAgeRestrictedMessageInOrderDetails() {
        orderDetailPage.verifyAgeRestrictedMessageInOrderDetails();
    }
}
