package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.ShoppingCartPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

public class ShoppingCartStepSerenity extends ScenarioSteps {

    ShoppingCartPage shoppingCartPage;
    utilityhelper UtilityHelper;

    @Step
    public void shoppingCartPageDisplay() {
        shoppingCartPage.shoppingCartPageDisplay();
    }

    @Step
    public void fromShoppingCartPageGetUserCartId() {
        shoppingCartPage.fromShoppingCartPageGetUserCartId();
    }

    @Step
    public void navigateBackFromGetCartIdWindow() {
        shoppingCartPage.navigateBackFromGetCartIdWindow();
    }

    @Step
    public void moveToViewClearAllItemsLink() {
        shoppingCartPage.moveToViewClearAllItemsLink();
    }

    @Step
    public void highLightClearAllItemsLink() {
        UtilityHelper.highLightElement(shoppingCartPage.CLEAR_ALL_ITEMS_LINK);
    }

    @Step
    public void clickClearAllItemsLink() {
        shoppingCartPage.clickClearAllItemsLink();
    }

    @Step
    public void highLightClearAllPopUp() {
        UtilityHelper.waitUntilClickable(shoppingCartPage.CONFIRM_CLEAR_ITEMS_MODAL);
        UtilityHelper.highLightElement(shoppingCartPage.CONFIRM_CLEAR_ITEMS_MODAL);
    }

    @Step
    public void highLightConfirmClearItemsButton() {
        UtilityHelper.highLightElement(shoppingCartPage.CONFIRM_CLEAR_ITEMS_BUTTON);
    }

    @Step
    public void clickConfirmClearItemsButton() {
        shoppingCartPage.clickConfirmClearItemsButton();
    }

    @Step
    public void waitForEmptyShoppingCart() {
        shoppingCartPage.waitForEmptyShoppingCart();
    }

    @Step
    public void reMoveAnyUnavailableItems(WebElement element) {
        shoppingCartPage.reMoveAnyUnavailableItems(element);
    }

    @Step
    public void setArrayListOfItemsInShoppingCart(WebElement element) {
        shoppingCartPage.setArrayListOfItemsInShoppingCart(element);
    }

    @Step
    public void validateShoppingCartItemCount() {
        shoppingCartPage.validate_ShoppingCartItemCount();
    }

    @Step
    public void CompareProductNameToShoppingCart() {
        shoppingCartPage.ProductName_ComparisionShoppingCart();
    }

    @Step
    public void compareGuestCartToSignedInCart() {
        shoppingCartPage.compareGuestCartToSignedInCart();
    }

    @Step
    public void compareShoppingCartToReOrderItems() {
        shoppingCartPage.compareShoppingCartToReOrderItems();
    }

    @Step
    public void validate_NoTextFieldForCommentDisplay() {
        shoppingCartPage.validate_CommentField_NotDisplay();
    }

    @Step
    public void validate_ButtonsDisplayOnShoppingCartForAnonymousUser() {
        shoppingCartPage.validate_ButtonsDisplayAnonymousUser_ShoppingCartPage();
    }


    @Step
    public void select_ShoppingCartSubstitutionForGrocery(String shopcartsub) {
        shoppingCartPage.selectShoppingCartSubstitutionoption(shopcartsub);
    }

    @Step
    public void user_EnterTextonCommentFieldShoppingCart(String comment) {
        shoppingCartPage.shoppingCartSubstitutionComment(comment);
    }

    @Step
    public void user_Validate1024orFewerCharactersInCommentsSection() {
        shoppingCartPage.validate1024charactersOrFewer();
    }

    @Step
    public void user_EnterMax1024CharacterInCommentSection() {
        shoppingCartPage.enter_Max1024characterComment();
    }

    @Step
    public void user_EnterMax1024CharacterInCommentSectionWithoutClearingTheField() {
        shoppingCartPage.enter_Max1024characterCommentWithoutClearingFirst();
    }

    @Step
    public void verifyCheckoutAsGuestIsDisplayed() {
        shoppingCartPage.verifyCheckoutAsGuestIsDisplayed();
    }

    @Step
    public void verifyCheckoutAsGuestIsNotDisplayed() {
        shoppingCartPage.verifyCheckoutAsGuestIsNotDisplayed();
    }


    @Step
    public void verifyLoginAndCheckoutButtonIsDisplayed() {
        shoppingCartPage.verifyLoginAndCheckoutButtonIsDisplayed();
    }


    @Step
    public void verifyLoginAndCheckoutButtonIsNotDisplayed() {
        shoppingCartPage.verifyLoginAndCheckoutButtonIsNotDisplayed();
    }

    @Step
    public void verifyCheckoutButtonIsDisplayed() {
        shoppingCartPage.verifyCheckoutButtonIsDisplayed();
    }

    @Step
    public void verifyCheckoutButtonIsNotDisplayed() {
        shoppingCartPage.verifyCheckoutButtonIsNotDisplayed();
    }

    @Step
    public void set_SubstitutionPreferenceToNoSbstitution(String shopcartsub) {
        shoppingCartPage.grocerySubstitutionTextDisplay();
        shoppingCartPage.selectShoppingCartSubstitutionoption(shopcartsub);
    }

    @Step
    public void moveToViewLogInAndCheckOutButton() {
        shoppingCartPage.moveToViewLogInAndCheckOutButton();
    }

    @Step
    public void highLightLogInAndCheckOutButton() {
        UtilityHelper.highLightElement(shoppingCartPage.LOG_IN_AND_CHECKOUT_BUTTON);
    }

    @Step
    public void clickLogInAndCheckOutButton() {
        shoppingCartPage.clickLogInAndCheckOutButton();
    }

    @Step
    public void moveToViewCheckOutAsGuestButton() {
        shoppingCartPage.moveToViewCheckOutAsGuestButton();
    }

    @Step
    public void highLightCheckoutAsGuestButton() {
        UtilityHelper.highLightElement(shoppingCartPage.CHECKOUT_AS_GUEST_BUTTON);
    }

    @Step
    public void clickCheckoutAsGuestButton() {
        shoppingCartPage.clickCheckoutAsGuestButton();
    }

    @Step
    public void moveToViewCheckOutButton() {
        shoppingCartPage.moveToViewCheckOutButton();
    }

    @Step
    public void highLightCheckOutButton() {
        UtilityHelper.highLightElement(shoppingCartPage.CHECKOUT_BUTTON);
    }

    @Step
    public void clickCheckOutButton() {
        shoppingCartPage.clickCheckOutButton();
    }

    @Step
    public void user_IncreaseQtyOfGiftCardByOne() throws InterruptedException {
        shoppingCartPage.plusIconClick$5GiftCard16thItemShoppingCart();
    }

    @Step
    public void set_ShoppingCartSubstitution(String shopcartsub) {
        shoppingCartPage.selectShoppingCartSubstitutionoption(shopcartsub);
    }

    @Step
    public void change_QtyofItemToGet3000orMoreSubtotal() throws InterruptedException {
        shoppingCartPage.editQTYtoreach3000subtotal();
    }

    @Step
    public void validate_DefaultDisplayofCommentTextfield() {
        shoppingCartPage.validate_defaultDisplayCommentField_ShoppingCart();
    }

    @Step
    public void validate_DefaultDisplayofGrocerySubstitutionOptionOnShoppingCartPage() {
        shoppingCartPage.validate_DefaultOptionGrocerySubstitution_ShoppingCart();
    }

    @Step
    public void validate_NoGrocerySubstitutionOptionsFieldDisplay() {
        shoppingCartPage.validate_GrocerySubOption_NotDisplay();
    }

    @Step
    public void user_ClickRemoveButtonofGeneralMerchandiseProduct(int noitemremove) {
        shoppingCartPage.clickRemoveButton_CNCItem(noitemremove);
    }

    @Step
    public void shopping_CartPageRefreshAndUpdateCorrectItemCountAndSubtotalPrice(String itemcount) {
        shoppingCartPage.compareCalSubtotalPriceVsSystemDisplay();
        shoppingCartPage.validate_ShoppingCartItemCount();
        shoppingCartPage.ProductName_ComparisionShoppingCart();
    }

    @Step
    public void click_CheckoutOnMiniCart() {
        shoppingCartPage.miniCartCheckout();
    }

    @Step
    public void user_ClickRemoveButtonNextToProduceItem(int noitemremove) {
        shoppingCartPage.clickRemoveButton_CNCItem(noitemremove);
    }

    @Step
    public void user_ClickRemoveButtonNextToCustomCakeItem(int noitemremove) {
        shoppingCartPage.clickRemoveButton_SPOItem(noitemremove);
    }

    @Step
    public void clear_ArrayListOfShoppingCart() {
        shoppingCartPage.emptyArrayList_ListOfShoppingCardItems();
        shoppingCartPage.emptyArrayList_PriceQTY_ShoppingCard();
    }

    @Step
    public void user_ReduceQTYofCNCItem(int qtyToReduce) throws InterruptedException {
        shoppingCartPage.reduceQty_CNCItem(qtyToReduce);
    }

    @Step
    public void user_IncreaseQTYofCNCItem(int qtyToIncrease) throws InterruptedException {
        shoppingCartPage.increaseQty_CNCItem(qtyToIncrease);
    }

    @Step
    public void validate_ShoppingCartFor_SelectedProductNamesDisplay() {
        shoppingCartPage.ProductName_ComparisionShoppingCart();
    }

    //Created By: 107793 11/18/16
    @Step
    public void validate_MiniCartFor_SelectedProductNamesDisplay() {
        shoppingCartPage.setSelectedItemsToValidation_MiniCart();
        shoppingCartPage.productName_Comparision_MiniCart();
    }

    //Created By: 107793 11/18/16
    @Step
    public void validate_MiniCartFulfillmentGroup() {
        shoppingCartPage.miniCartFulfillmentGroupOrder();
    }

    //Created By: 107793 11/17/16
    @Step
    public void validate_StateOfUnavailableItems_InShoppingCart() {
        shoppingCartPage.emptyArrayList_ListOfShoppingCardItems();
        shoppingCartPage.stateForUnavailableItems_InShoppingCart();
    }

    //Created By: 107793 12/22/16
    @Step
    public void validate_StateOfUnavailableItems_InMiniCart() {
        shoppingCartPage.stateForUnavailableItems_InMiniCart();
    }

    @Step
    public void verifyNotificationOfUnavailableItemsModalAppears() {
        shoppingCartPage.verifyNotificationOfUnavailableItemsModalAppears();
    }

    @Step
    public void lookAndFeelOfNotificationModal() {
        shoppingCartPage.lookAndFeelOfNotificationModal();
    }

    @Step
    public void setArrayListOfItemsToBeDeletedViaNotificationModal() {
        shoppingCartPage.setArrayListOfItemsToBeDeletedViaNotificationModal();
    }

    @Step
    public void userClicksRemoveItemsFromCartButton() {
        shoppingCartPage.userClicksRemoveItemsFromCartButton();
    }

    @Step
    public void userClosesNotificationOfUnavailableItemsModal() {
        shoppingCartPage.userClosesNotificationOfUnavailableItemsModal();
    }

    @Step
    public void compareItemsRemovedWithExistingItemsInShoppingCartPage() {
        shoppingCartPage.validate_remainingItem_ShoppingCart();
    }

    @Step
    public void increaseQtyStepperOfRandomProductsInShoppingCartPage(WebElement element, int clickPlus) {
        shoppingCartPage.increaseQtyStepperOfRandomProductsInShoppingCartPage(element, clickPlus);
    }

    @Step
    public void decreaseQtyStepperOfRandomProductsInShoppingCartPage(WebElement element, int clickMinus) {
        shoppingCartPage.decreaseQtyStepperOfRandomProductsInShoppingCartPage(element, clickMinus);
    }

    @Step
    public void verifyStaticMessageOnMiniCart() {
        shoppingCartPage.verifyStaticMessageOnMiniCart();
    }

    @Step
    public void verifyNoStaticMessageOnMiniCart() {
        shoppingCartPage.verifyNoStaticMessageOnMiniCart();
    }

    @Step
    public void verifyStaticMessageIsDisplayedInShoppingCart() {
        shoppingCartPage.verifyStaticMessageIsDisplayedInShoppingCart();
    }

    @Step
    public void verifyNoStaticMessageIsDisplayedInShoppingCart() {
        shoppingCartPage.verifyNoStaticMessageIsDisplayedInShoppingCart();
    }

    @Step
    public void verifyNoStaticMessageAndTooltipAppearsWhenEmptyCart() {
        shoppingCartPage.verifyNoStaticMessageAndTooltipAppearsWhenEmptyCart();
    }



}
