package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.StickyHeaderStepSerenity;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static com.tcs.automation.steps.serenity.LaunchStepsSerenity.isSSI_State;


/**
 * Created by 108588 on 4/18/2017.
 */
public class StickyHeaderStepDefinition {

    @Steps
    StickyHeaderStepSerenity stickyHeaderStepSerenity;


    @When("user clicks account header caret")
    public void userClicksAccountHeaderCaret() throws InterruptedException {
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
    }

    @Then("user logs out from the account header")
    public void userClickLogoutFromTheAccountHeader() throws InterruptedException {
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightLogoutFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickLogoutFromTheAccountHeader();
    }

    @Then("user click create account from the account header")
    public void userClickCreateAccountFromTheAccountHeader(){
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightCreateAccountFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickCreateAccountFromTheAccountHeader();
    }

    @Then ("verify create account modal displays")
    public void verifyCreateAccountModalDisplays(){
        stickyHeaderStepSerenity.highLightCreateAccountModalDisplays();
        stickyHeaderStepSerenity.verifyCreateAccountModalDisplays();
    }

    @When("user click Sign In from the account header")
    public void userClickSignInFromTheAccountHeader() {
        if (isSSI_State) {
            stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
            stickyHeaderStepSerenity.highLightSSISignInFromTheAccountHeader();
            stickyHeaderStepSerenity.SSISignInFromTheAccountHeader();
        } else {
            stickyHeaderStepSerenity.highLightSignInFromTheAccountHeader();
            stickyHeaderStepSerenity.userClickSignInFromTheAccountHeader();
        }
    }

    @When("user click Quick Shop from the account header")
    public void userClickQuickShopFromTheAccountHeader() throws InterruptedException {
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightQuickShopFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickQuickShopFromTheAccountHeader();
    }

    @When("user searches '(.*)' and sets store to '(.*)'")
    public void userSearchesZipAndSetsStoreToStoreName(String zipCode, String storeName) throws InterruptedException {
        stickyHeaderStepSerenity.highLightChangeStoreFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickChangeStoreFromTheAccountHeader();
        stickyHeaderStepSerenity.waitForStoreSelectorModalToAppear();
        stickyHeaderStepSerenity.userEntersZipCodeInStoreSelectorModal(zipCode);
        stickyHeaderStepSerenity.highLightSearchButtonInStoreSelectorModal();
        stickyHeaderStepSerenity.userClicksSearchButtonInStoreSelectorModal();
        stickyHeaderStepSerenity.userSearchesForDesiredStore(storeName);
        stickyHeaderStepSerenity.highLightSelectThisStoreButton();
        stickyHeaderStepSerenity.userClicksSelectThisStoreButton();
    }

    @Then("verify user has correct store '(.*)'")
    public void userHasCorrectStore(String store) {
        stickyHeaderStepSerenity.verifyUserHasCorrectStore(store);
    }

    @Then("user navigate to Order History from the account header")
    public void userNavigateToOrderHistoryFromTheAccountHeader() {
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightOrderHistoryFromTheAccountHeader();
        stickyHeaderStepSerenity.userClicksOrderHistoryFromTheAccountHeader();
    }

    @Then("user click Shopping List option from the account header")
    public void userClickShoppingListOptionFromUtilityMenu() {
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightShoppingListFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickShoppingListFromTheAccountHeader();
    }

    @Then("clear Shopping List if any value is present")
    public void clearShoppingListIfAnyValueIsPresent() throws InterruptedException {
        stickyHeaderStepSerenity.clear_ShoppingListIfAnyValueIsPresent();
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
    }

    @Then("validate Shopping List count '(.*)'")
    public void validateShoppingListCountIsDisplayed(String expval) {
        stickyHeaderStepSerenity.validate_ShoppingListCountIsDisplayed(expval);
    }

    @Then("enter '(.*)' in Shopping List")
    public void enterItemIntoShoppingList(String noofitemadd) throws InterruptedException {
        stickyHeaderStepSerenity.enter_ItemIntoShoppingList(noofitemadd);
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
    }

    @Then("click on Sign-In button on Sign-In to Create Your Shopping List modal")
    public void clickOnSignInButtonOnSignInToCreateYourShoppingListModal() {
        stickyHeaderStepSerenity.highLightSignInButtonOnSignInToCreateYourShoppingListModal();
        stickyHeaderStepSerenity.click_SignInButtonOnSignInToCreateYourShoppingListModal();
    }

    @Then("validate Shopping List Modal is displayed")
    public void validateShoppingListModalDisplay() {
        stickyHeaderStepSerenity.validate_ShoppingListModal_Display();
    }

    @Then("user click account settings from the account header")
    public void userClickAccountSettingsFromTheAccountHeader(){
        stickyHeaderStepSerenity.userClicksAccountHeaderCaret();
        stickyHeaderStepSerenity.highLightAccountSettingsFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickAccountSettingsFromTheAccountHeader();
    }

    @Then("validate Please Sign-In to Create Your Shopping List popup modal display")
    public void validatePleaseSignInToCreateYourShoppingListPopupModalDisplay() {
        stickyHeaderStepSerenity.validate_PleaseSignInToCreateYourShoppingListPopupModalDisplay();
    }

    @Then("user click change store from the account header")
    public void userClickChangeStoreFromTheAccountHeader() {
        stickyHeaderStepSerenity.highLightChangeStoreFromTheAccountHeader();
        stickyHeaderStepSerenity.userClickChangeStoreFromTheAccountHeader();
    }

    @Then("verify 'Not You' link displays on the account header")
    public void notYouLinkDisplaysOnTheAccountHeader() {
        stickyHeaderStepSerenity.notYouLinkDisplaysOnTheAccountHeader();
    }

    @Then("verify account header widget displays welcome message")
    public void accountHeaderWidgetDisplaysWelcome() {
        stickyHeaderStepSerenity.accountHeaderWidgetDisplaysWelcome();
    }

    @Then("verify account header widget does not display welcome message")
    public void accountHeaderWidgetDoesNotDisplayWelcome() {
        stickyHeaderStepSerenity.accountHeaderWidgetDoesNotDisplayWelcome();
    }

    @Then("click 'Not You' link on the account header")
    public void clickNotYouLinkOnTheAccountHeader() {
        stickyHeaderStepSerenity.highLightNotYouLinkOnTheAccountHeader();
        stickyHeaderStepSerenity.clickNotYouLinkOnTheAccountHeader();
    }

    @Then("verify 'Not You' link does not display on the account header")
    public void verifyNotMeLinkDoesNotDisplayOnTheAccountHeader() {
        stickyHeaderStepSerenity.notYouLinkDoesNotDisplayOnTheAccountHeader();
    }

    @Then ("user scroll page up")
    public void userScrollPageUp(){
        stickyHeaderStepSerenity.userScrollPageUp();
    }

    @Then("user scroll page down")
    public void userScrollPageDown(){
        stickyHeaderStepSerenity.userScrollPageDown();
    }

    @Then ("verify banner and navigation are displayed")
    public void verifyBannerAndNavigationAreDisplayed(){
        stickyHeaderStepSerenity.verifyBannerIsDisplayed();
        stickyHeaderStepSerenity.verifyNavigationIsDisplayed();
    }

    @Then ("verify banner and navigation is not displayed")
    public void verifyBannerAndNavigationIsNotDisplayed(){
        stickyHeaderStepSerenity.verifyBannerIsNotDisplayed();
        stickyHeaderStepSerenity.verifyNavigationIsNotDisplayed();
    }

}
