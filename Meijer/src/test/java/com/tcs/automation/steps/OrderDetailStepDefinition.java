package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.OrderDetailsStepSerenity;
import com.tcs.utilityhelpers.utilityhelper;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class OrderDetailStepDefinition {

    @Steps
    OrderDetailsStepSerenity orderDetailStepSerenity;
    utilityhelper UtilityHelper;

    @Then("order history details page display")
    public void orderHistoryDetailsPageDisplay() {
        orderDetailStepSerenity.orderHistoryDetailsPageDisplay();
    }

    @Then("validate the look and feel of order history details page")
    public void validateTheLookAndFeelOfOrderHistoryDetailsPage() {
        orderDetailStepSerenity.validateOrderHistoryDetailLookAndFeelValidation();
        orderDetailStepSerenity.validateActivePickupTimeDisplay();

    }

    @Then("validate add an item and edit order buttons are inactive")
    public void validateAddAnItemAndEditOrderButtonsAreInactive() {
//		orderDetailStepSerenity.validate_AddAnItemAndEditButtonAreInactive();
    }

    @Then("validate order number display")
    public void validateOrderNumberDisplay() {
        orderDetailStepSerenity.validate_OrderNumberDisplay();
    }

    @Then("validate order status display")
    public void validateOrderStatusDisplay() {
        orderDetailStepSerenity.validateOrderStatusDisplay();
    }

    @Then("validate order date display")
    public void validateOrderDateDisplay() {
        orderDetailStepSerenity.validate_OrderDateDisplay();
    }

    @Then("validate content in Cubside pickup display '(.*)' '(.*)' '(.*)' '(.*)'")
    public void validateContentInCubsidePickupDisplay(String storename, String cardesc, String shopcartsub, String comment) {
        orderDetailStepSerenity.validate_ContentInCubsidePickupDisplay(storename, cardesc, shopcartsub, comment);
    }

    @Then("validate content of Curbside pickup without comment '(.*)' '(.*)' '(.*)'")
    public void validateContentofCurbsidePickupWithoutComment(String storename, String cardesc, String shopcartsub) {
        orderDetailStepSerenity.validate_ContentofCurbsidePickupWithoutComment(storename, cardesc, shopcartsub);
    }

    @Then("validate max comment length display on curbside piclup")
    public void validateMaxCommentLengthDisplayOnCurbsidePiclup() {
        orderDetailStepSerenity.validate_MaxCommentLengthDisplayOnCurbsidePiclup();
    }

    @Then("validate curbside display for Get Direction and Edit Pickup Time Links")
    public void validateCurbsideDisplayForGetDirectionAndEditPickupTimeLinks() {
        orderDetailStepSerenity.validate_CurbsideDisplayForGetDirectionAndEditPickupTimeLinks();
    }

    @Then("validate Curbside Contents pickup display '(.*)' '(.*)'")
    public void validateCurbsideContentspickupdisplay(String storename, String cardesc) {
        orderDetailStepSerenity.validate_CurbsideContentspickupdisplay(storename, cardesc);
    }

    @Then("validate content in Cubside pickup display without car desc '(.*)' '(.*)' '(.*)'")
    public void validateContentInCubsidePickupDisplayWithoutCarDesc(String storename, String shopcartsub, String comment) {
        orderDetailStepSerenity.validate_ContentInCubsidePickupDisplayWithoutCarDesc(storename, shopcartsub, comment);
    }

    @Then("validate content in Cake-Deli Store pickup display '(.*)'")
    public void validateContentInCakeDeliStorePickupDisplay(String storename) {
        orderDetailStepSerenity.validate_ContentInCakeDeliStorePickupDisplay(storename);
    }

    @Then("verify CC details content in Payment and Coupon details '(.*)' '(.*)' '(.*)'")
    public void verifyContentPaymentAndCouponDetails(String address1, String ccaddress2, String ccnumber) {
        orderDetailStepSerenity.verify_contentPaymentAndCouponsDetailsValidation(address1, ccaddress2, ccnumber);
    }

    @Then("user click on plusAdd an Item option")
    public void userClickOnPlusAddAnItemOption() {
        orderDetailStepSerenity.highLightPlusAddAnItemButton();
        orderDetailStepSerenity.userClickOnPlusAddAnItemOption();
    }

    @Then("verify Add an Item search was not performed")
    public void userVerifiesAddAnItemSearchWasNotPerformed() {
        orderDetailStepSerenity.user_verifyAddAnItemSearchWasNotPerformed();
    }


    @Then("user stores edit order page url")
    public void userStoresEditOrderwUrl() {
        orderDetailStepSerenity.user_storeEditOrderUrl();
    }

    @Then("verify user is NOT redirected to another page")
    public void verifyUserIsNotRedirectedToAnotherPage() {
        orderDetailStepSerenity.user_verifyUserIsNotRedirectedToAnotherPage();
    }

    @Then("validate add item modal display correctly")
    public void waitUntilAddItemModalIsDisplayed() {
        orderDetailStepSerenity.waitUntilAddItemModalIsDisplayed();
    }

    @Then("type beer and search the item '(.*)'")
    public void typeBeerAndSearchTheItem(String alcohol) {
        orderDetailStepSerenity.type_BeerAndSearchTheItem(alcohol);
    }

    @Then("type board games and search the item '(.*)'")
    public void typeBoardGamesAndSearchTheItem(String toserachitem) {
        orderDetailStepSerenity.type_BoardGamesAndSearchTheItem(toserachitem);
    }

    @Then("type and search apple item '(.*)'")
    public void typeAndSearchAppleItem(String toserachitem) {
        orderDetailStepSerenity.type_AndSearchAppleItem(toserachitem);
    }

    @Then("user type item '(.*)' and search it")
    public void userTypeItemAndSearchIt(String toserachitem) {
        orderDetailStepSerenity.user_TypeItemAndSearchIt(toserachitem);
    }

    @Then("user searches for '(.*)' on add item modal on edit order screen")
    public void userSearchesViaAddItemModal(String toserachitem) {
        orderDetailStepSerenity.userSearchesViaAddItemModal(toserachitem);
    }

    @Then("user select '(.*)' item edit qty to '(.*)' and click plusAdd button")
    public void userSelectItemEditQtyAndClickPlusAddItem(int totalItemsToAdd, String itemQty) {
        int limit = 0, elementIndex;
        String availability;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='prod-sort-list']"));
        List<WebElement> productsToAdd = getDriver().findElements(By.xpath("//*[@id='prod-sort-list']/li"));
        UtilityHelper.shuffleList(1, productsToAdd.size());
        for (WebElement element : productsToAdd) {
            if (limit != totalItemsToAdd) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + elementIndex + "]"));
                availability = UtilityHelper.elementGetAttribute(element, "class");
                if (availability.contains("unavailable") || availability.contains("instore")) {
                    continue;
                }
                UtilityHelper.moveToViewElement(element);
                orderDetailStepSerenity.userSelectsItemsToBeAddedViaEditOrderMode(element, itemQty);
                limit++;
            }
        }
        orderDetailStepSerenity.verifyAddItemsButtonCountViaEditOrderMode(totalItemsToAdd);

    }

    @Then("user select '(.*)' choking hazard item edit qty to '(.*)' and click plusAdd button")
    public void userSelectItemWithChokingHazardAndClickOnPlusAdd(int totalItemsToAdd, String itemQty) {
        int limit = 0, elementIndex;
        boolean isChokingHazard;
        WebElement hazardousItem;
        String availability;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='prod-sort-list']"));
        List<WebElement> productsToAdd = getDriver().findElements(By.xpath("//*[@id='prod-sort-list']/li"));
        UtilityHelper.shuffleList(1, productsToAdd.size());
        for (WebElement element : productsToAdd) {
            if (limit != totalItemsToAdd) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/li[" + elementIndex + "]"));
                availability = UtilityHelper.elementGetAttribute(element, "class");
//                TODO:
//                Non-Functional at this time.
//                hazardousItem = element.findElement(By.xpath(".//div[@class='has-warning']"));
//                isChokingHazard = UtilityHelper.elementGetText(hazardousItem).contains("Choking Hazard");

                if (availability.contains("unavailable") || availability.contains("instore")) {
                    continue;
                }
                UtilityHelper.moveToViewElement(element);
                orderDetailStepSerenity.userSelectsItemsToBeAddedViaEditOrderMode(element, itemQty);
                limit++;
            }
        }
        orderDetailStepSerenity.user_SelectItemWithChokingHazardAndClickOnPlusAdd(totalItemsToAdd, itemQty);
    }

    @Then("validate plusAdd button change to Remove link")
    public void validatePlusAddButtonChangeToRemoveLink() {
        orderDetailStepSerenity.validate_PlusAddButtonChangeToRemoveLink();
    }

    @Then("click on Add X Items button")
    public void clickOnAddXItemsButton() {
        orderDetailStepSerenity.highLightAddXItemsButton();
        orderDetailStepSerenity.clickOnAddXItemsButton();
        orderDetailStepSerenity.waitUntilAddItemModalVanishes();
    }

    @Then("validate newly added item is listed")
    public void validateAddedNewItemIsListed() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
    }

    @Then("validate notification message after 1 item added but before updating order")
    public void validateNotificationMessageAfter1itemAddedButBeforeUpdatingOrder() {
        orderDetailStepSerenity.validate_NotificationMessageAfter1itemAddedButBeforeUpdatingOrder();
    }

    @Then("validate notification message after 3 items added but before updating order")
    public void validateNotificationMessageAfter3itemsAddedbutBeforUpdatingOrder() {
        orderDetailStepSerenity.validate_NotificationMessageAfter3itemsAddedbutBeforUpdatingOrder();
    }

    @Then("validate notification message after 04 items were added but before updating order")
    public void validateNotificationMsg4itemsAddedButBeforeUpdatingOrder() {
        orderDetailStepSerenity.validate_NotificationMsgAfter4itemsAddedButBeforeUpdatingOrder();
    }


    @Then("click on Update Order Button to update the order")
    public void clickOnUpdateOrderButtonToUpdateTheOrder() throws InterruptedException {
        orderDetailStepSerenity.moveToViewUpdateOrderButton();
        orderDetailStepSerenity.highLightUpdateOrderButton();
        orderDetailStepSerenity.clickOnUpdateOrderButtonToUpdateTheOrder();
    }

    @Then("update order popup confirmation message display")
    public void updateOrderPopupConfirmationMessageDisplay() {
        orderDetailStepSerenity.update_OrderPopupConfirmationMessageDisplay();
    }

    @Then("user select Cancel option on Update order pop up confirmation message")
    public void userSelectCancelOptionOnUpdateOrderPopupConfirmationMessage() {
        orderDetailStepSerenity.user_SelectCancelOptionOnUpdateOrderPopupConfirmationMessage();
    }

    @Then("user click X button on Update order pop up confirmation message")
    public void userClickXbuttonOnUpdateOrderPopupConfirmationMessage() {
        orderDetailStepSerenity.user_ClickXbuttonOnUpdateOrderPopupConfirmationMessage();
    }


    @Then("user click update order button on popup confirmation")
    public void userClickUpdateOrderButtonOnPopupConfirmation() {
        orderDetailStepSerenity.waitUntilUpdateOrderConfirmationPopUpDisplay();
        orderDetailStepSerenity.highLightUpdateOrderButtonOnConfirmationPopUp();
        orderDetailStepSerenity.userClickUpdateOrderButtonOnPopupConfirmation();
    }

    @Then("user click confirm on Age Restricted confirmation modal")
    public void userClicksConfirmOnAgeRestrictedConfirmationModal() {
        orderDetailStepSerenity.waitUntilAgeRestrictedConfirmationModalAppears();
        orderDetailStepSerenity.highLightConfirmButtonOnAgeRestrictedModal();
        orderDetailStepSerenity.userClicksConfirmOnAgeRestrictedConfirmationModal();
    }

    @Then("user select cancel on age restriction popup")
    public void userSelectCancelOnAgeRestrictionPopup() {
        orderDetailStepSerenity.user_SelectCancelOnAgeRestrictionPopup();
    }

    @Then("validate order details page has newly added item")
    public void validateOrderDetailsPageHasNewlyAddedItem() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
    }

    @Then("user click on Cancel Order link")
    public void userClickOnCancelOrderLink() {
        orderDetailStepSerenity.moveToViewCancelOrderLink();
        orderDetailStepSerenity.highLightCancelOrderLink();
        orderDetailStepSerenity.userClickOnCancelOrderLink();
    }

    @Then("user click Cancel My Order Button on Order Cancel Confirmation Message")
    public void userClickOnCancelOrderOnConfirmationPopUp() {
        orderDetailStepSerenity.moveToViewCancelOrderConfirmationPopUp();
        orderDetailStepSerenity.highLightCancelOrderOnConfirmationPopUp();
        orderDetailStepSerenity.userClickOnCancelOrderOnConfirmationPopUp();
    }

    @Then("user click Go Back button on Order Cancel Confirmation Message")
    public void userClickGoBackButtonOnOrderCancelConfirmationMessage() {
        orderDetailStepSerenity.user_ClickGoBackButtonOnOrderCancelConfirmationMessage();
    }

    @Then("user click in edit order button")
    public void userClickEditOrderButton() throws InterruptedException {
        orderDetailStepSerenity.highLightEditOrderButton();
        orderDetailStepSerenity.userClickEditOrderButton();
    }

    @Then("validate charge at pick for curbside text")
    public void validateChargeAtPickupForCurbsideText() {
        orderDetailStepSerenity.validate_ChargeAtPickupForCurbsideText();
    }

    @Then("validate order edit mode display")
    public void validateOrderEditModeDisplay() {
        orderDetailStepSerenity.validateOrderEditModeDisplay();
    }

    @Then("click on Remove link of a product")
    public void clickOnRemoveLinkOfProduct() {
        orderDetailStepSerenity.click_OnRemoveLinkOfProduct();
    }

    @Then("user click undo button")
    public void userClickUndoButton() {
        orderDetailStepSerenity.user_ClickUndoButton();
    }

    @Then("validate order status after cancelled '(.*)'")
    public void validateOrderStatusAfterCancelled(String orderstatus) {
        orderDetailStepSerenity.validate_OrderStatusAfterCancelled(orderstatus);
    }

    @Then("validate Edit order page after all order removed")
    public void validateEditOrderPageAfterOrderRemoved() {
        orderDetailStepSerenity.validate_EditOrderPageAfterAllOrderRemoved();
    }

    @Then("increase the QTY of each product in Order Edit '(.*)'")
    public void increaseQTYofEachProductinOrderEdit(int editQty) throws InterruptedException {
        orderDetailStepSerenity.increase_QTYofEachProductinOrderEdit(editQty);

    }

    @Then("remove CNC products from order and store product name except 1st item '(.*)'")
    public void removeCNCProductsFromOrderAndStoreProductName(int itemremove) {
        orderDetailStepSerenity.remove_CNCProductsFromOrderStoreProdName(itemremove);
    }

    @Then("user Undo for one of the product")
    public void userUndofor1ofTheProduct() {
        orderDetailStepSerenity.user_Undofor1ofTheProduct();
    }

    @Then("validate order update display correctly after item removed '(.*)'")
    public void validateOrderUpdateDisplayCorrectly(String remainingitem) {
        orderDetailStepSerenity.validate_OrderUpdateDisplayCorrectly(remainingitem);
    }

    @Then("validate order history page for button and links disabled")
    public void validateOrderHistoryPageForButtonAndLinksDisabled() {
        orderDetailStepSerenity.validate_OrderHistoryPageForButtonAndLinksDisabled();
    }

    @Then("validate Ship To home section is display correct")
    public void validateShipToHomeSectionIsDisplayCorrect() {
        orderDetailStepSerenity.validate_ShipToHomeSectionIsDisplayCorrect();
    }

    @Then("validate ordered items are displayed correct")
    public void validateOrderedItemsAreDisplayedCorrect() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
        orderDetailStepSerenity.validate_orderitemDisplayCorrectOrderHistoryDetailPage();
    }

    @Then("validate ordered items are still displayed same even after order is cancelled")
    public void validateOrderedItemsAreStillDisplayedSameEvenAfterOrdeIsCancelled() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
        orderDetailStepSerenity.validate_orderitemDisplayCorrectOrderHistoryDetailPage();
    }

    @Then("validate ordered items Except Cake are still displayed same even after order is cancelled")
    public void validateOrderedItemsExceptCakeAreStillDisplayedSameAfterCancelledOrder() {
        orderDetailStepSerenity.validate_CorrectItemNameDisplayExceptCakeInOrderHistoryDetailPage();
    }


    @Then("validate correct items display on order history detail page")
    public void validateCorrectItemsDisplayOnOrderHistoryDetailPage() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
        orderDetailStepSerenity.validate_orderitemDisplayCorrectOrderHistoryDetailPage();
    }

    @Then("validate correct item name display except Custom Cake in order history detail page")
    public void validateCorrectItemNameDisplayExceptCakeInOrderHistoryDetailPage() {
        orderDetailStepSerenity.validate_CorrectItemNameDisplayExceptCakeInOrderHistoryDetailPage();
    }

    @Then("validate all items in order still displayed the same '(.*)'")
    public void allItemsInOrderStillDisplayedTheSame(int itemcount) {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
        orderDetailStepSerenity.all_ItemsInOrderStillDisplayedTheSame(itemcount);
    }

    @Then("valdiate all items in order still displayed the same exlcuding cake '(.*)'")
    public void valdiateAllItemsInOrderStillDisplayedSameExlcudingCake(int itemcount) {
        orderDetailStepSerenity.valdiate_AllItemsInOrderStillDisplayedSameExlcudingCake(itemcount);
    }

    @Then("user click on Edit Pickup Time")
    public void userClickonEditPickupTime() throws InterruptedException {
        orderDetailStepSerenity.user_ClickonEditPickupTime();
    }

    @Then("Select new future pickup time and update it")
    public void SelectNewFuturePickupTimeAndUpdateIt() throws InterruptedException {
        orderDetailStepSerenity.user_SelectaNewPickupTimeAndUpdateIt();
    }

    @Then("user select a new pickup time")
    public void userSelectaNewPickupTime() {
        orderDetailStepSerenity.user_SelectaNewPickupTime();
    }

    @Then("select pickup time just before-after current pickup slot")
    public void selectPickupTimeJustBeforeorAfterCurrentPickupSlot() {
        orderDetailStepSerenity.user_SelectNewPickupTimeJustBeforeorAfterCurrentPickupSlot();
    }

    @Then("validate the newly selected pickup time display correct")
    public void validateTheNewlySelectedPickupTimeDisplayCorrect() throws ParseException {
        orderDetailStepSerenity.validate_TheNewlySelectedPickupTimeDisplayCorrect();
    }

    @Then("validate newly selected adjacent pickup time display correct")
    public void validateNewlySelectedAdjacentPickupTimeDisplayCorrect() {
        orderDetailStepSerenity.validate_NewlySelectedAdjacentPickupTimeDisplayCorrect();
    }

    @Then("validate display of item after clicked on removed button")
    public void validateDisplayOfItemAfterClickedonRemovedButton() {
        orderDetailStepSerenity.validate_DisplayOfItemAfterClickedonRemovedButton();
    }

    @Then("validate popup cancel order modal close and order history detail page refresh")
    public void validatePopupCancelOrderModalCloseAndOrderHistoryDetailPageRefresh() {
        orderDetailStepSerenity.validate_OrderHistoryPageForButtonAndLinksDisabled();
    }

    @Then("validate order status after successfully cancelled order")
    public void validateOrderStatusAfterSuccessfullyCancelledOrder() throws InterruptedException {
        orderDetailStepSerenity.validate_OrderStatusAfterSuccessfullyCancelledOrder();
    }


    @Then("validate order status remains same as Order Placed")
    public void validateOrderStatusRemainsSameAsOrderPlaced() {
        orderDetailStepSerenity.validate_OrderStatusRemainsSameAsOrderPlaced();
    }

    @Then("user cancel edit pickup time")
    public void userCancelEditPickupTime() {
        orderDetailStepSerenity.validate_cancelEditOrder();
    }

    @Then("user close edit pickup time popup window")
    public void userCloseEditPickupTimePopupWindow() {
        orderDetailStepSerenity.user_CloseEditPickupTimePopupWindow();
    }

    @Then("update new selected pickup time")
    public void updateNewSelectedPickupTime() throws InterruptedException {
        orderDetailStepSerenity.update_NewSelectedPickupTime();
    }

    @Then("user click X Button on Order Cancel Confirmation Message")
    public void userClickXButtonOnOrderCancelConfirmationMessage() {
        orderDetailStepSerenity.user_ClickXButtonOnOrderCancelConfirmationMessage();
    }

    @Then("validate no longer displays pickup time and links for the order you cancelled")
    public void validateNoLongerDisplayPickupTimeAndLinksForOrderCanceled() {
        orderDetailStepSerenity.validate_NoLongerDisplayPickupTimeAndLinksForOrderCanceled();
    }

    @Then("validate cancel order link is not displayed")
    public void validateCancelOrderLinkIsNotDisplayed() {
        orderDetailStepSerenity.validate_CancelOrderLinkIsNotDisplayed();
    }

    @Then("validate choking hazard popup message display")
    public void chokingHazardPopUpMessageValidation() {
        orderDetailStepSerenity.chokingHazardPopUpMessageValidation();
    }

    /**
     * @param variable , Use: 'Return to Shopping' OR 'Add To Cart'
     */
    @Then("user selects '(.*)' on choking hazard popup")
    public void userSelectsVariableOnChokingHazardPopUp(String variable) {
        orderDetailStepSerenity.userSelectsVariableOnChokingHazardPopUp(variable);
    }

    @Then("validate cancel button and edit order buttons are enabled")
    public void validateCancelButtonAndEditOrderButtonsAreEnabled() {
        orderDetailStepSerenity.validate_CancelButtonAndEditOrderButtonsAreEnabled();
    }

    @Then("user increase count of item with Pound as UOM '(.*)'")
    public void userIncreaseCountOfItemWithPoundAsUOM(int lbIncQty) {
        orderDetailStepSerenity.user_IncreaseCountOfItemWithPoundAsUOM(lbIncQty);
    }

    @Then("user increase count of item with Each as UOM '(.*)'")
    public void userIncreaseCountOfItemWithEachandAsUOM(int eaIncQty) {
        orderDetailStepSerenity.user_IncreaseCountOfItemWithEachAsUOM(eaIncQty);
    }

    @Then("user reduce count of item which has UOM as Pound '(.*)'")
    public void userReduceCountOfItemWhichHasUOMasPound(float lbReduQty) {
        orderDetailStepSerenity.userReduceCountOfItemWhichHasUOMasPound(lbReduQty);
    }

    @Then("user reduce count of item which has UOM as Each '(.*)'")
    public void userReduceCountOfItemWhichHasUOMasEach(int eaReduQty) {
        orderDetailStepSerenity.userReduceCountOfItemWhichHasUOMasEach(eaReduQty);
    }

    @Then("validate page refresh and page is no longer in edit mode")
    public void validatePageRefreshAndPageIsNoLongerInEditMode() {
        orderDetailStepSerenity.validatePageRefreshAndPageIsNoLongerInEditMode();
    }

    @Then("user edit order for '(.*)' items to increase qty to '(.*)'")
    public void userEditOrderForItemsToIncreaseQty(int noitemtoEdit, int desireQty) throws InterruptedException {
        orderDetailStepSerenity.user_EditOrderForItemsToIncreaseQty(noitemtoEdit, desireQty);
    }

    @Then("user edit order for '(.*)' items to decrease qty to '(.*)'")
    public void userEditOrderForItemsToDecreaseQty(int noitemtoEdit, int desireQty) throws InterruptedException {
        orderDetailStepSerenity.user_EditOrderForItemsToDecreaseQty(noitemtoEdit, desireQty);
    }

    @Then("validate Subtotal is updated correctly after edit order")
    public void validateSubtotalIsUpdatedCorrectlyAfterEditOrder() {
        orderDetailStepSerenity.validate_SubtotalIsUpdatedCorrectlyAfterEditOrder();
    }

    @Then("validate item count after order update '(.*)'")
    public void validateItemCountAfterOrderUpdate(String updateitemcount) {
        orderDetailStepSerenity.validate_ItemCountAfterOrderUpdate(updateitemcount);
    }

    @Then("user click XButton to clear Search Field")
    public void userClickXButtonToClearSearchField() {
        orderDetailStepSerenity.user_ClickXButtonToClearSearchField();
    }

    @Then("validate placeholder text on Search field of Add an Item screen")
    public void validatePlaceholderTextonSearchFieldofAddanItemScreen() {
        orderDetailStepSerenity.validate_PlaceholderTextonSearchFieldofAddanItemScreen();
    }

    @Then("validate Add X items button is enabled")
    public void validateAddXitemsButtonisEnabled() {
        orderDetailStepSerenity.validate_AddXitemsButtonisEnabled();
    }

    @Then("user return to Meijer Home Page")
    public void userClickMeijerHomePageLogo() {
        orderDetailStepSerenity.highLightMeijerLogo();
        orderDetailStepSerenity.userClickMeijerLogo();
    }

    @Then("user click on Select All checkbox")
    public void userClickOnSelectAllCheckbox() {
        orderDetailStepSerenity.user_ClickOnSelectAllCheckbox();
    }

    @Then("user selects '(.*)' items for Reordering")
    public void userSelectsRandomItemForReOrdering(String itemsToAdd) {
        int limit = 0, elementIndex;
        List<WebElement> checkBoxes = getDriver().findElements(By.xpath("//*[contains(@class,'item-row')]"));
        if ((itemsToAdd.toUpperCase().equals("ALL")) || (Integer.valueOf(itemsToAdd) > checkBoxes.size())) {
            itemsToAdd = String.valueOf(checkBoxes.size());
        }
        UtilityHelper.shuffleList(1, checkBoxes.size());
        for (WebElement element : checkBoxes) {
            if (limit != Integer.valueOf(itemsToAdd)) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("//*[contains(@class,'item-row')][" + elementIndex + "]"));
                UtilityHelper.moveToViewElement(element);
                orderDetailStepSerenity.userSelectsRandomItemForReOrdering(element);
                limit++;
            }
        }
    }

    @Then("validate whether Reorder Items button is enabled")
    public void validateReorderItemsButtonIsEnabled() {
        orderDetailStepSerenity.validateReorderItemsButtonIsEnabled();
    }

    @Then("click on Reorder Item button")
    public void clickOnReorderItemButton() {
        orderDetailStepSerenity.highLightReorderItemsButton();
        orderDetailStepSerenity.clickOnReorderItemButton();
        orderDetailStepSerenity.waitUntilReorderPopUp();
    }

    @Then("validate Reorder Item pop up look and feel")
    public void validateReorderItemPopupLookAndFeel() {
        orderDetailStepSerenity.validateReorderItemPopupLookAndFeel();
    }

    //Created By: 107793 1/4/17
    @Then("validate ALL items during Reordering process")
    public void validateAllAlt_UoM_ItemsDuringReOrderingProcess() {
        orderDetailStepSerenity.validateAllAltUoM_ItemsDuringReOrderingProcess();
    }

    @Then("click Add items to cart on Reorder Items pop up")
    public void clickAddItemsToCartOnReorderItemsPopUp() throws InterruptedException {
        orderDetailStepSerenity.highLightAddItemsButtonReorderPopUp();
        orderDetailStepSerenity.clickAddItemsToCartOnReorderItemsPopUp();
        orderDetailStepSerenity.waitForProductsToBeAddedToCartFromOrderHistory();
    }

    @Then("update qty of items so total qty is greater than 12 '(.*)'")
    public void updateQtyofItemssoTotalQtyisGreaterThan12(int desireitemcount) {
        orderDetailStepSerenity.update_QtyofItemssoTotalQtyisGreaterThan12(desireitemcount);
    }

    @Then("validate current pickup Time display correct on OrderHistory detail page")
    public void validateCurrentPickupTimeDisplayCorrectOnOrderHistoryDetailPage() {
        orderDetailStepSerenity.validate_CurrentPickupTimeDisplayCorrectOn_OrderHistoryDetailPage();
    }

    @Then("also validate newly selected time display correct on curbside wizard")
    public void validateNewlySelectedTimeDisplayCorrectOnCurbsideWizard() throws ParseException {
        orderDetailStepSerenity.validate_NewlySelectedTimeDisplayCorrectOnCurbsideWizard();
    }

    @Then("validate content of each Pickup Time slot on OrderHistory Detail Page")
    public void validateContentOfEachPickupTimeSlotOnOrderHistoryDetailPage() throws InterruptedException {
        orderDetailStepSerenity.validate_ContentOfEachPickupTimeSlotOnOrderHistoryDetailPage();
    }

    @Then("validate DATE and TIME of selected Time Slot via Order History Details page")
    public void validateSelectedDateAndTImeViaOrderHistoryDetailPage() {
        orderDetailStepSerenity.validateSelectedDateAndTImeViaOrderHistoryDetailPage();
    }

    @Then("set array list with current product names via Order Details Page")
    public void setArrayListWithCurrentProductNamesViaOrderDetailsPage() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithCurrentProductNamesViaOrderDetailsPage(element);
            elementIndex++;
        }
    }

    @Then("compare newly added items against existing items in Active Order")
    public void compareNewlyAddedItemsAgainstExistingItemsInActiveOrder() {
        int elementIndex = 1;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> setArrayList = getDriver().findElements(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])"));
        for (WebElement element : setArrayList) {
            element = getDriver().findElement(By.xpath("(//*[@id='reorderContainer']//*[@class='product-details'])[" + elementIndex + "]"));
            orderDetailStepSerenity.setArrayListWithNewlyAddedItems(element);
            elementIndex++;
        }
        orderDetailStepSerenity.compareNewlyAddedItemsWithExistingItemsInActiveOrderUpdate();
    }

    @Then("compare removed items against existing items in Active Order")
    public void compareRemovedItemsAgainstExistingItemsInActiveOrder() {
        orderDetailStepSerenity.compareRemovedItemsAgainstExistingItemsInActiveOrder();
    }

    @Then("at random, remove '(.*)' items from Active Order")
    public void atRandomRemoveItemsFromActiveOrder(int itemsToRemove) {
        int limit = 0, elementIndex;
        UtilityHelper.waitUntilClickable(By.xpath("//*[@id='reorderContainer']"));
        List<WebElement> existingItems = getDriver().findElements(By.xpath("(//*[contains(@class,'item-row')])"));
        if (itemsToRemove >= existingItems.size()) {
            itemsToRemove = (existingItems.size() - 1);
        }
        UtilityHelper.shuffleList(1, existingItems.size());
        for (WebElement element : existingItems) {
            if (limit != itemsToRemove) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("(//*[contains(@class,'item-row')])[" + elementIndex + "]"));
                orderDetailStepSerenity.atRandomRemoveItemsFromActiveOrder(element);
                limit++;
            }
        }
    }

    @Then("verify user is NOT allowed to search for SPO/SHT products")
    public void verifyUserIsNotAllowedToAddSPOSHTProductsViaEditActiveOrder() {
        orderDetailStepSerenity.verifyUserIsNotAllowedToAddSPOSHTProductsViaEditActiveOrder();
    }

    @Then("user retains current DATE and TIME of Active Order in Order Details page")
    public void userRetainsCurrentDateAndTimeOfActiveOrderInOrderDetailsPage() {
        orderDetailStepSerenity.userRetainsCurrentDateAndTimeOfActiveOrderInOrderDetailsPage();
    }

    @Then("user validates current DATE and TIME with Time Slot Modal")
    public void userValidateCurrentDateAndTimeWithTimeSlotModal() {
        orderDetailStepSerenity.waitUntilTimeSlotAppears();
        orderDetailStepSerenity.verifyCurrentDateAndTimeViaOrderDetailsPage();
    }

    @Then("validate active order DATE and TIME on Order Details page")
    public void userValidatesDateAndTimeOnActiveOrderOnOrderDetailsPage() {
        orderDetailStepSerenity.userValidatesDateOnActiveOrderOnOrderDetailsPage();
        orderDetailStepSerenity.userValidatesTimeOnActiveOrderOnOrderDetailsPage();
    }

    @Then("verify 'Warning: Choking Hazard' while in edit mode")
    public void verifyWarningChokingHazardCopyWhileInEditMode() {
        orderDetailStepSerenity.verifyWarningChokingHazardCopyWhileInEditMode();
    }

    @Then("verify 'AGE RESTRICTED' message in order details")
    public void verifyAgeRestrictedMessageInOrderDetails() {
        orderDetailStepSerenity.verifyAgeRestrictedMessageInOrderDetails();
    }
}	
