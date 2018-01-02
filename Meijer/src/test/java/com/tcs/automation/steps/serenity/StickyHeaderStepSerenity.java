package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.StickyHeaderPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


/**
 * Created by 108588 on 4/18/2017.
 */
public class StickyHeaderStepSerenity extends ScenarioSteps {

    StickyHeaderPage stickyHeaderPage;
    utilityhelper UtilityHelper;

    @Step
    public void highLightSignInFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.SIGN_IN_LINK);
    }

    @Step
    public void userClickSignInFromTheAccountHeader() {
        stickyHeaderPage.userClickSignInFromTheAccountHeader();
    }

    @Step
    public void highLightSSISignInFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.SSI_SIGN_IN_LINK);
    }

    @Step
    public void SSISignInFromTheAccountHeader(){
        stickyHeaderPage.SSISignInFromTheAccountHeader();
    }

    @Step
    public void userClicksAccountHeaderCaret() {
        stickyHeaderPage.userClicksAccountHeaderCaret();
    }

    @Step
    public void highLightQuickShopFromTheAccountHeader() {
        UtilityHelper.highLightElement(stickyHeaderPage.QUICK_SHOP_LINK);
    }
    @Step
    public void userClickQuickShopFromTheAccountHeader(){
       stickyHeaderPage.userClickQuickShopFromTheAccountHeader();
    }

    @Step
    public void highLightShoppingListFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.SHOPPING_LIST_LINK);
    }

    @Step
    public void userClickShoppingListFromTheAccountHeader() {
        stickyHeaderPage.userClickShoppingListFromTheAccountHeader();
    }

    @Step
    public void highLightOrderHistoryFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.ORDER_HISTORY_LINK);
    }

    @Step
    public void userClicksOrderHistoryFromTheAccountHeader() {
        stickyHeaderPage.userClicksOrderHistoryFromTheAccountHeader();
    }

    @Step
    public void highLightAccountSettingsFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.ACCOUNT_SETTINGS_LINK);
    }

    @Step
    public void userClickAccountSettingsFromTheAccountHeader() {
        stickyHeaderPage.clickAccountSettingsFromTheAccountHeader();
    }

    @Step
    public void highLightLogoutFromTheAccountHeader(){
        UtilityHelper.highLightElement(stickyHeaderPage.SIGN_OUT_LINK);
    }
    @Step
    public void userClickLogoutFromTheAccountHeader() {
        stickyHeaderPage.userClickLogoutFromTheAccountHeader();
    }

    @Step
    public void highLightCreateAccountFromTheAccountHeader() {
        UtilityHelper.highLightElement(stickyHeaderPage.CREATE_ACCOUNT_LINK);
    }

    @Step
    public void userClickCreateAccountFromTheAccountHeader() {
        stickyHeaderPage.userClickCreateAccountFromTheAccountHeader();
    }

    @Step
    public void highLightCreateAccountModalDisplays(){
        UtilityHelper.highLightElement(stickyHeaderPage.CREATE_ACCOUNT_MODAL);
    }

    @Step
    public void verifyCreateAccountModalDisplays(){
        stickyHeaderPage.verifyCreateAccountModalDisplays();
    }

    @Step
    public void waitForStoreSelectorModalToAppear() {
        stickyHeaderPage.waitForStoreSelectorModalToAppear();
    }

    @Step
    public void userEntersZipCodeInStoreSelectorModal(String zipCode) {
        stickyHeaderPage.userEntersZipCodeInStoreSelectorModal(zipCode);
    }

    @Step
    public void highLightSearchButtonInStoreSelectorModal() {
        UtilityHelper.highLightElement(stickyHeaderPage.STORE_SELECTOR_SEARCH_BUTTON);
    }

    @Step
    public void userClicksSearchButtonInStoreSelectorModal() {
        stickyHeaderPage.userClicksSearchButtonInStoreSelectorModal();
    }

    @Step
    public void userSearchesForDesiredStore(String storeName) {
        stickyHeaderPage.userSearchesForDesiredStore(storeName);
    }

    @Step
    public void highLightSelectThisStoreButton() {
        UtilityHelper.highLightElement(stickyHeaderPage.SELECT_THIS_STORE_BUTTON);
    }

    @Step
    public void userClicksSelectThisStoreButton() {
        stickyHeaderPage.userClicksSelectThisStoreButton();
    }

    @Step
    public void verifyUserHasCorrectStore(String store) {
        stickyHeaderPage.verifyUserHasCorrectStore(store);
    }

    @Step
    public void clear_ShoppingListIfAnyValueIsPresent() throws InterruptedException {
        stickyHeaderPage.clear_ShoppingListItems();
    }

    @Step
    public void validate_ShoppingListCountIsDisplayed(String expval) {
        stickyHeaderPage.validate_ShoppingListCountDisplay(expval);
    }

    @Step
    public void enter_ItemIntoShoppingList(String noofitemadd) throws InterruptedException {
        stickyHeaderPage.addItemsTo_ShoppingList(noofitemadd);
    }


    @Step
    public void validate_PleaseSignInToCreateYourShoppingListPopupModalDisplay() {
        stickyHeaderPage.validate_PleaseSignInToCreateYourShoppingListModal_Display();
    }

    @Step
    public void highLightSignInButtonOnSignInToCreateYourShoppingListModal() {
        UtilityHelper.highLightElement(stickyHeaderPage.signInButtonSignInToCreateShoppingListModal);
    }

    @Step
    public void click_SignInButtonOnSignInToCreateYourShoppingListModal() {
        stickyHeaderPage.click_SignIn_toCreateShoppingList();
    }

    @Step
    public void validate_ShoppingListModal_Display() {
        stickyHeaderPage.validate_ShoppingListModal_Display();
    }

    @Step
    public void highLightChangeStoreFromTheAccountHeader() {
        UtilityHelper.highLightElement(stickyHeaderPage.CHANGE_STORE);
    }

    @Step
    public void userClickChangeStoreFromTheAccountHeader() {
        stickyHeaderPage.userClickChangeStoreFromTheAccountHeader();
    }

    @Step
    public void accountHeaderWidgetDisplaysWelcome() {
        stickyHeaderPage.accountHeaderWidgetDisplaysWelcome();
    }

    @Step
    public void accountHeaderWidgetDoesNotDisplayWelcome() {
        stickyHeaderPage.accountHeaderWidgetDoesNotDisplayWelcome();
    }

    @Step
    public void notYouLinkDoesNotDisplayOnTheAccountHeader() {
        stickyHeaderPage.notYouLinkDoesNotDisplayOnTheAccountHeader();
    }

    @Step
    public void notYouLinkDisplaysOnTheAccountHeader(){
        stickyHeaderPage.notYouLinkDisplaysOnTheAccountHeader();
    }

    @Step
    public void highLightNotYouLinkOnTheAccountHeader() {
        UtilityHelper.highLightElement(stickyHeaderPage.NOT_YOU_LINK);
    }

    @Step
    public void clickNotYouLinkOnTheAccountHeader() {
        stickyHeaderPage.clickNotYouLinkOnTheAccountHeader();

    }

    @Step
    public void userScrollPageUp() {
        stickyHeaderPage.userScrollPageUp();
    }

    @Step
    public void userScrollPageDown() {
        stickyHeaderPage.userScrollPageDown();
    }

    @Step
    public void verifyBannerIsDisplayed(){
        stickyHeaderPage.verifyBannerIsDisplayed();
    }

    @Step
    public void verifyBannerIsNotDisplayed(){
        stickyHeaderPage.verifyBannerIsNotDisplayed();
    }

    @Step
    public void verifyNavigationIsDisplayed(){
        stickyHeaderPage.verifyNavigationIsDisplayed();
    }

    @Step
    public void verifyNavigationIsNotDisplayed(){
        stickyHeaderPage.verifyNavigationIsNotDisplayed();
    }

}
