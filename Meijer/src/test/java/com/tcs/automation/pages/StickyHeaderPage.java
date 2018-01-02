package com.tcs.automation.pages;


import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by 108588 on 4/18/2017.
 */
public class StickyHeaderPage extends PageObject {

    //Select Sign In option
    @FindBy(xpath = "//a[@class='sign_in']")
    public WebElement SIGN_IN_LINK;
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    public WebElement SSI_SIGN_IN_LINK;
    //Link to change to a different store
    @FindBy(xpath = "//a[@class='select-store mjr-link']")
    public WebElement CHANGE_STORE;
    //Caret in account header
    @FindBy(xpath = "//*[contains(@id,'menuDropdown')]")
    public WebElement ACCOUNT_HEADER_CARET;
    //Quick shop link in account header
    @FindBy(xpath = "//*[text()='Quick Shop']")
    public WebElement QUICK_SHOP_LINK;
    //Shopping List link in account header
    @FindBy(xpath = "//*[@id='mylist']/a")
    public WebElement SHOPPING_LIST_LINK;
    //Order History link in account header
    @FindBy(xpath = "//*[text()='Order History']")
    public WebElement ORDER_HISTORY_LINK;
    //Sign out link in account header
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement SIGN_OUT_LINK;
    @FindBy(xpath = "//*[@class='createAccount']")
    public WebElement CREATE_ACCOUNT_LINK;
    @FindBy(xpath = "//*[@id='create-account-steps']/h3[2]")
    public WebElement CREATE_ACCOUNT_MODAL;
    //Account settings link in account header
    @FindBy(xpath = "//ul[@class='user-menu2']/li[4]/a")
    public WebElement ACCOUNT_SETTINGS_LINK;
    //Store Location Search text box field
    @FindBy(xpath = "//*[@class='clr']//*[@name='cityStateZip']")
    public WebElement STORE_SELECTOR_TEXTBOX;
    //Find Magnifying Glass icon for Store Location Search
    @FindBy(xpath = "//button[@class='icon-meijer_search meijer_search']")
    public WebElement STORE_SELECTOR_SEARCH_BUTTON;
    //Select this Store Button on Store Location
    @FindBy(xpath = "//*[@id='save-store']")
    public WebElement SELECT_THIS_STORE_BUTTON;
    @FindBy(xpath = "//*[@id='mapLayer']")
    public WebElement STORE_SELECTOR;
    //My List slider right arrow
    @FindBy(xpath = "//*[@id='sl-container']//*[@class='sl-close']")
    public WebElement sliderArrowShoppingList;
    //Clear button
    @FindBy(xpath = "//*[@id='sl-container']//*[text()='Clear']")
    public WebElement clearlinkShoppingList;
    //Yes, Clear List button on Clear confirmation
    @FindBy(xpath = "//button[@class='sl-btn sl-blue-btn sl-modal-ok']")
    public WebElement yesClearListClearConfirmShoppingList;
    //Add Item Search Field
    @FindBy(xpath = "//*[@id='sl-add-form']/input")
    public WebElement additemSearchFieldShoppingList;
    // + Button to add to my list
    @FindBy(xpath = "//*[@id='sl-add-form']/button")
    public WebElement plusButtonToAddtoShoppingList;
    // To click on Store Name
    @FindBy(xpath = "//*[@id='js-storeNameMsg']")
    public WebElement YOUR_STORE;
    //counter for shopping list
    @FindBy(xpath = "//*[@id='myListCounter']")
    public WebElement SHOPPING_LIST_COUNTER;
    //Please Sign In to Create Your Shopping List text
    @FindBy(xpath = "//*[@id='home']//*[@class='alert-modal-body']/p")
    public WebElement pleaseSignInToCreateYourShoppingListTextpopup;
    //Sign In Button on Please Sign In to Create Your Shopping List Modal
    @FindBy(xpath = "//*[@id='home']//*[@class='alert-modal-footer']/button[contains (text(), 'Sign In')]")
    public WebElement signInButtonSignInToCreateShoppingListModal;
    //My List Header Text
    @FindBy(xpath = "//*[@id='sl-container']//*[@class='sl-header-text' and text()='My List']")
    public WebElement myListHeaderTextonmyListModal;
    //SSI - Not you link
    @FindBy(xpath = "//a[contains(text(),'not') and contains(text(),'?')]")
    public WebElement NOT_YOU_LINK;
    //Header Promo banner
    @FindBy(xpath = "//*[@id='header_promo']")
    public WebElement HEADER_PROMO;
    //Weekly Ads Link
    @FindBy(xpath = "//li[@id='weekly-ads']")
    public WebElement WEEKLY_ADS_LINK;
    //Shipt Hom Delivery Button
    @FindBy(xpath = "//*[@id='shopShipt']")
    public WebElement SHIPT_HOME_DELIVERY_BUTTON;
    utilityhelper UtilityHelper;

    /*--------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------- Page Object Actions ---------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------*/

    public void userClickChangeStoreFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(CHANGE_STORE);
        UtilityHelper.click(CHANGE_STORE);
    }

    public void userClicksAccountHeaderCaret() {
        UtilityHelper.waitUntilClickable(ACCOUNT_HEADER_CARET);
        UtilityHelper.click(ACCOUNT_HEADER_CARET);
    }

    public void userClickSignInFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(SIGN_IN_LINK);
        UtilityHelper.click(SIGN_IN_LINK);

    }

    public void SSISignInFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(SSI_SIGN_IN_LINK);
        UtilityHelper.click(SSI_SIGN_IN_LINK);
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    public void userClickQuickShopFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(QUICK_SHOP_LINK);
        UtilityHelper.click(QUICK_SHOP_LINK);
    }

    public void userClickShoppingListFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(SHOPPING_LIST_LINK);
        UtilityHelper.click(SHOPPING_LIST_LINK);

    }

    public void userClicksOrderHistoryFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(ORDER_HISTORY_LINK);
        UtilityHelper.click(ORDER_HISTORY_LINK);
    }

    public void clickAccountSettingsFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(ACCOUNT_SETTINGS_LINK);
        UtilityHelper.click(ACCOUNT_SETTINGS_LINK);
    }

    public void userClickLogoutFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(SIGN_OUT_LINK);
        UtilityHelper.click(SIGN_OUT_LINK);
    }

    public void userClickCreateAccountFromTheAccountHeader() {
        UtilityHelper.waitUntilClickable(CREATE_ACCOUNT_LINK);
        UtilityHelper.click(CREATE_ACCOUNT_LINK);
    }

    public  void verifyCreateAccountModalDisplays(){
        UtilityHelper.waitUntilClickable(CREATE_ACCOUNT_MODAL);
        UtilityHelper.click(CREATE_ACCOUNT_MODAL);
    }

    public void waitForStoreSelectorModalToAppear() {
        UtilityHelper.waitUntilElementVisible(STORE_SELECTOR);
    }

    public void userEntersZipCodeInStoreSelectorModal(String zipCode) {
        UtilityHelper.typeIntoElement(STORE_SELECTOR_TEXTBOX, zipCode);
    }

    public void userClicksSearchButtonInStoreSelectorModal() {
        try {
            UtilityHelper.click(STORE_SELECTOR_SEARCH_BUTTON);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userSearchesForDesiredStore(String storeName) {
        UtilityHelper.waitUntilClickable(STORE_SELECTOR);
        List<WebElement> storeNames = getDriver().findElements(By.xpath("//*[@class='storeName']"));
        for (WebElement name : storeNames) {
            UtilityHelper.waitUntilClickable(name);
            if (UtilityHelper.elementGetText(name).equals(storeName)) {
                UtilityHelper.moveToViewElement(name);
                UtilityHelper.click(name);
                System.out.println("=== STORE [" + name.getText() + "]");
                return;
            }
        }
    }

    // To Click 'Select This Store' button on Store Select Modal
    public void userClicksSelectThisStoreButton() {
        UtilityHelper.click(SELECT_THIS_STORE_BUTTON);
        UtilityHelper.waitUntilElementNotVisible(STORE_SELECTOR);
    }

    public void verifyUserHasCorrectStore(String store) {
        UtilityHelper.waitUntilElementNotVisible(By.xpath("//*[@class='pgwModalBackdrop']"));
        UtilityHelper.waitUntilClickable(YOUR_STORE);
        Assert.assertEquals("Verify Successful Store Change", store, UtilityHelper.elementGetText(YOUR_STORE));
    }

    //Clear items in shopping list
    public void clear_ShoppingListItems() {
        List<WebElement> myListItems = getDriver().findElements(By.xpath("//*[@id='sl-active-list']/div/div"));
        System.out.println("=== total number of avaiable item to add to cart:" + myListItems.size());
        if (myListItems.size() != 0) {
            for (WebElement element : myListItems) {
                element = getDriver().findElement(By.xpath("//*[@id='sl-active-list']/div/div[1]//*[@class='sl-checkbox']"));
                UtilityHelper.waitUntilClickable(element);
                UtilityHelper.click(element);
            }
            UtilityHelper.waitUntilClickable(clearlinkShoppingList);
            UtilityHelper.click(clearlinkShoppingList);
            UtilityHelper.waitUntilClickable(yesClearListClearConfirmShoppingList);
            UtilityHelper.click(yesClearListClearConfirmShoppingList);
        } else {
            System.out.println("No Item to clear in my List");
        }
        //To Close the My List Slider
        UtilityHelper.click(sliderArrowShoppingList);
    }


    public void validate_ShoppingListCountDisplay(String expval) {
        UtilityHelper.waitUntilClickable(SHOPPING_LIST_COUNTER);
        System.out.println("Shopping List Count " + UtilityHelper.elementGetText(SHOPPING_LIST_COUNTER));
        Assert.assertEquals(expval, UtilityHelper.elementGetText(SHOPPING_LIST_COUNTER));
    }

    //TODO: update this method for adding more items
    //Add 1 or 2 items to shopping list
    public void addItemsTo_ShoppingList(String noofitemadd) throws InterruptedException {
        UtilityHelper.waitUntilClickable(additemSearchFieldShoppingList);
        switch (noofitemadd) {
            case "1":
                UtilityHelper.typeIntoElement(additemSearchFieldShoppingList, Constants.product_Apple);
                UtilityHelper.click(plusButtonToAddtoShoppingList);
                UtilityHelper.click(sliderArrowShoppingList);
            case "2":
                additemSearchFieldShoppingList.clear();
                additemSearchFieldShoppingList.sendKeys(Constants.product_Apple);
                UtilityHelper.waitUntilClickable(plusButtonToAddtoShoppingList);
                UtilityHelper.click(plusButtonToAddtoShoppingList);
                Thread.sleep(3000);
                additemSearchFieldShoppingList.clear();
                UtilityHelper.typeIntoElement(additemSearchFieldShoppingList, Constants.product_Orange);
                UtilityHelper.waitUntilClickable(plusButtonToAddtoShoppingList);
                UtilityHelper.click(plusButtonToAddtoShoppingList);
                UtilityHelper.click(sliderArrowShoppingList);
        }
    }

    //To validate 'Please Sign-In to Create Your Shopping List' Modal Display
    public void validate_PleaseSignInToCreateYourShoppingListModal_Display() {
        UtilityHelper.waitUntilElementVisible(pleaseSignInToCreateYourShoppingListTextpopup);
        Assert.assertEquals("Verify 'Shopping List' sign in modal: ", Constants.pleaseSignInToCreateYourShoppingListtext, UtilityHelper.elementGetText(pleaseSignInToCreateYourShoppingListTextpopup));
    }

    //Click Sign In button on popup - Please Sign in to create your shopping list modal
    public void click_SignIn_toCreateShoppingList() {
        UtilityHelper.click(signInButtonSignInToCreateShoppingListModal);
    }

    //Validate Shopping List Modal Display
    public void validate_ShoppingListModal_Display() {
        UtilityHelper.waitUntilElementVisible(myListHeaderTextonmyListModal);
        Assert.assertEquals("Verify 'My List' title in slide out: ", Constants.myListHeaderText, UtilityHelper.elementGetText(myListHeaderTextonmyListModal));
    }

    // SSI - validate 'not you?' link displays
    public void notYouLinkDisplaysOnTheAccountHeader() {
        assertTrue(UtilityHelper.elementExists(By.xpath("//a[contains(text(),'not') and contains(text(),'?')]")));
    }

    // SSI - verify 'not you?' link NOT displayed
    public void notYouLinkDoesNotDisplayOnTheAccountHeader() {
        assertTrue(UtilityHelper.elementNotExists(By.xpath("//a[contains(text(),'not') and contains(text(),'?')]")));
    }

    // To click 'not you?' link
    public void clickNotYouLinkOnTheAccountHeader() {
        UtilityHelper.waitUntilClickable(NOT_YOU_LINK);
        UtilityHelper.click(NOT_YOU_LINK);
    }

    // SSI - Verify account header message exists
    public void accountHeaderWidgetDisplaysWelcome() {
        assertTrue(UtilityHelper.elementExists(By.xpath("//*[contains(text(),'Welcome back, ')]")));
    }

    // SSI - Verify account header message does NOT exists
    public void accountHeaderWidgetDoesNotDisplayWelcome() {
        assertTrue(UtilityHelper.elementNotExists(By.xpath("//*[contains(text(),'Welcome back, ')]")));
    }

    //Move to top of page
    public void userScrollPageUp() {
        UtilityHelper.scrollUpPage();
    }

    //Move to bottom of page
    public void userScrollPageDown() {
        UtilityHelper.scrollDownPage();
    }

    //Banner is not displayed
    public void verifyBannerIsDisplayed(){
        assertTrue(UtilityHelper.isClickable(HEADER_PROMO));
    }

    //Banner is not displayed
    public void verifyBannerIsNotDisplayed(){
        assertFalse(UtilityHelper.isClickable(HEADER_PROMO));
    }

    //Main navigation is not displayed
    public void verifyNavigationIsDisplayed(){
        assertTrue(UtilityHelper.isClickable(WEEKLY_ADS_LINK));
    }

    //Main navigation is not displayed
    public void verifyNavigationIsNotDisplayed(){
        assertFalse(UtilityHelper.isClickable(WEEKLY_ADS_LINK));
    }

    //Shipt Home Delivery button exists
    public void verifyShiptHomeDeliveryButton() {
        assertTrue(UtilityHelper.isClickable(SHIPT_HOME_DELIVERY_BUTTON));
    }

    //Shipt Home Delivery button does NOT exists
    public void verifyShiptNotDisplayed() {
        assertFalse(UtilityHelper.isClickable(SHIPT_HOME_DELIVERY_BUTTON));
    }
}