package com.tcs.automation.steps;

import com.tcs.automation.pages.HomePage;
import com.tcs.automation.pages.ShoppingCartPage;
import com.tcs.automation.steps.serenity.ShoppingCartStepSerenity;
import com.tcs.utilityhelpers.utilityhelper;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ShoppingCartStepDefinition {

    HomePage homePage;
    utilityhelper UtilityHelper;
    ShoppingCartPage shoppingCartPage;
    @Steps
    ShoppingCartStepSerenity shoppingCartStepSerenity;

    @Then("shopping cart page display")
    public void shoppingCartPageDisplay() {
        if (UtilityHelper.elementExists(shoppingCartPage.UnavailableItems_Modal)) {
            shoppingCartStepSerenity.userClosesNotificationOfUnavailableItemsModal();
            List<WebElement> unavailableItems = getDriver().findElements(By.xpath("(//ul[contains(@id,'productGroup')]/li[@data-invaliditem])"));
            for (WebElement element : unavailableItems) {
                By xpath = By.xpath("(//ul[contains(@id,'productGroup')]/li[@data-invaliditem])[1]");

                element = getDriver().findElement(xpath);
                shoppingCartStepSerenity.reMoveAnyUnavailableItems(element);
            }
        }
        shoppingCartStepSerenity.fromShoppingCartPageGetUserCartId();
        shoppingCartStepSerenity.navigateBackFromGetCartIdWindow();
        shoppingCartStepSerenity.shoppingCartPageDisplay();
    }

    private void setArrayListOfItemsInShoppingCart(String fGroupType, List<WebElement> fGroup) {
        int elementIndex = 1;
        for (WebElement element : fGroup) {
            By xpath = By.xpath("//ul[contains(@id,'productGroup_" + fGroupType + "')]/li[" + elementIndex + "]");
            if (UtilityHelper.elementNotExists(xpath)) {
                elementIndex++;
                continue;
            }
            element = getDriver().findElement(xpath);
            shoppingCartStepSerenity.setArrayListOfItemsInShoppingCart(element);
            elementIndex++;
        }
    }

    @Then("validate shopping cart display for ProductNames TotalItemQty and Subtotal")
    public void validateShoppingCartDisplayForProductNamesTotalItemQtyAndSubtotal() {
        String fulfillmentGroup1 = "1", fulfillmentGroup2 = "2", fulfillmentGroup8 = "8";
        UtilityHelper.waitUntilClickable(By.xpath("//ul[contains(@id,'productGroup')]"));
        List<WebElement> fGroup1 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_1')]/li"));
        List<WebElement> fGroup2 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_2')]/li"));
        List<WebElement> fGroup8 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_8')]/li"));
        if (fGroup1.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup1, fGroup1);
        }
        if (fGroup2.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup2, fGroup2);
        }
        if (fGroup8.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup8, fGroup8);
        }
        shoppingCartStepSerenity.validateShoppingCartItemCount();
        shoppingCartStepSerenity.CompareProductNameToShoppingCart();
    }

    @Then("validate guest cart merged with signed in user")
    public void validateGuestCartMergedWithSignedInUser() {
        String fulfillmentGroup1 = "1", fulfillmentGroup2 = "2", fulfillmentGroup8 = "8";
        UtilityHelper.waitUntilClickable(By.xpath("//ul[contains(@id,'productGroup')]"));
        List<WebElement> fGroup1 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_1')]/li"));
        List<WebElement> fGroup2 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_2')]/li"));
        List<WebElement> fGroup8 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_8')]/li"));
        if (fGroup1.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup1, fGroup1);
        }
        if (fGroup2.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup2, fGroup2);
        }
        if (fGroup8.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup8, fGroup8);
        }
        shoppingCartStepSerenity.compareGuestCartToSignedInCart();

    }

    @Then("validate shopping cart display for ProductNames, TotalItemQty and SubTotal via ReOrder Process")
    public void validateShoppingCart_ProductNameTotalItemQtySubTotal_ViaReOrderProcess() {
        String fulfillmentGroup1 = "1", fulfillmentGroup2 = "2", fulfillmentGroup8 = "8";
        UtilityHelper.waitUntilClickable(By.xpath("//ul[contains(@id,'productGroup')]"));
        List<WebElement> fGroup1 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_1')]/li"));
        List<WebElement> fGroup2 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_2')]/li"));
        List<WebElement> fGroup8 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_8')]/li"));
        if (fGroup1.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup1, fGroup1);
        }
        if (fGroup2.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup2, fGroup2);
        }
        if (fGroup8.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup8, fGroup8);
        }
        shoppingCartStepSerenity.validateShoppingCartItemCount();
        shoppingCartStepSerenity.compareShoppingCartToReOrderItems();
    }

    @Then("while on Shopping Cart Page, remove all existing items")
    public void whileOnShoppingCartPageRemoveAllExistingItems() {
        shoppingCartStepSerenity.moveToViewClearAllItemsLink();
        shoppingCartStepSerenity.highLightClearAllItemsLink();
        shoppingCartStepSerenity.clickClearAllItemsLink();
        shoppingCartStepSerenity.highLightClearAllPopUp();
        shoppingCartStepSerenity.highLightConfirmClearItemsButton();
        shoppingCartStepSerenity.clickConfirmClearItemsButton();
        shoppingCartStepSerenity.waitForEmptyShoppingCart();

        if (!UtilityHelper.shoppingCartComparedToItemsAddedBoolean())
            Assert.fail("[" + homePage.getNamesOfItemList() + "] ::: != ::: [" + shoppingCartPage.getListOfShoppingCartItem() + "]");
    }

    @Then("validate No text field for comments display")
    public void validateNoTextFieldForCommentDisplay() {
        shoppingCartStepSerenity.validate_NoTextFieldForCommentDisplay();
    }

    @Then("validate the buttons display on Shopping Cart page for Anonymous user")
    public void validateButtonsDisplayOnShoppingCartForAnonymousUser() {
        shoppingCartStepSerenity.validate_ButtonsDisplayOnShoppingCartForAnonymousUser();
    }

    @Then("validate default display of Comment Text field")
    public void validateDefaultDisplayofCommentTextfield() {
        shoppingCartStepSerenity.validate_DefaultDisplayofCommentTextfield();
    }

    @Then("validate default display of Grocery Substitution option on Shopping Cart Page")
    public void validateDefaultDisplayofGrocerySubstitutionOptionOnShoppingCartPage() {
        shoppingCartStepSerenity.validate_DefaultDisplayofGrocerySubstitutionOptionOnShoppingCartPage();
    }

    @Then("validate No Grocery Substitution options field display")
    public void validateNoGrocerySubstitutionOptionsFieldDisplay() {
        shoppingCartStepSerenity.validate_NoGrocerySubstitutionOptionsFieldDisplay();
    }

    @Then("select Shopping Cart Substitution For Grocery '(.*)'")
    public void selectShoppingCartSubstitutionForGrocery(String shopcartsub) {
        shoppingCartStepSerenity.select_ShoppingCartSubstitutionForGrocery(shopcartsub);
    }

    @Then("set Substitution Preference to No Substitution Shopping Cart '(.*)'")
    public void setSubstitutionPreferenceToNoSbstitution(String shopcartsub) {
        shoppingCartStepSerenity.set_SubstitutionPreferenceToNoSbstitution(shopcartsub);
    }

    @Then("user enter text on Comment field Shopping Cart '(.*)'")
    public void userEnterTextonCommentFieldShoppingCart(String comment) {
        shoppingCartStepSerenity.user_EnterTextonCommentFieldShoppingCart(comment);
    }

    @Then("validate 1024 or fewer characters in comments section")
    public void userValidate1024orFewerCharactersInCommentsSection() {
        shoppingCartStepSerenity.user_Validate1024orFewerCharactersInCommentsSection();
    }

    @Then("user enter max 1024 character in comment section")
    public void userEnterMax1024CharacterInCommentSection() {
        shoppingCartStepSerenity.user_EnterMax1024CharacterInCommentSection();
    }

    @Then("user enters max 1024 character in comment section without first clearing the field")
    public void userEnterMax1024CharacterInCommentSectionWithoutClearingTheField() {
        shoppingCartStepSerenity.user_EnterMax1024CharacterInCommentSectionWithoutClearingTheField();
    }

    @Then("verify 'Checkout as guest' is displayed")
    public void verifyCheckoutAsGuestIsDisplayed() {
        shoppingCartStepSerenity.verifyCheckoutAsGuestIsDisplayed();
    }

    @Then("verify 'Checkout as guest' is NOT displayed")
    public void verifyCheckoutAsGuestIsNotDisplayed() {
        shoppingCartStepSerenity.verifyCheckoutAsGuestIsNotDisplayed();
    }

    @Then("verify 'Log in and Check Out' button is displayed")
    public void verifyLoginAndCheckoutButtonIsDisplayed() {
        shoppingCartStepSerenity.verifyLoginAndCheckoutButtonIsDisplayed();
    }

    @Then("verify 'Log in and Check Out' button is NOT displayed")
    public void verifyLoginAndCheckoutButtonIsNotDisplayed() {
        shoppingCartStepSerenity.verifyLoginAndCheckoutButtonIsNotDisplayed();
    }

    @Then("verify 'Checkout' button is displayed")
    public void verifyCheckoutButtonIsDisplayed() {
        shoppingCartStepSerenity.verifyCheckoutButtonIsDisplayed();
    }

    @Then("verify 'Checkout' button is NOT displayed")
    public void verifyCheckoutButtonIsNotDisplayed() {
        shoppingCartStepSerenity.verifyCheckoutButtonIsNotDisplayed();
    }

    // Fully Signed In User
    @Then("click Checkout on Shopping Cart page")
    public void clickCheckoutOnShoppingCartPage() {
        shoppingCartStepSerenity.moveToViewCheckOutButton();
        shoppingCartStepSerenity.highLightCheckOutButton();
        shoppingCartStepSerenity.clickCheckOutButton();
    }

    // Checkout as Guest
    @Then("click Checkout as Guest on Shopping Cart page")
    public void selectCheckoutAsGuestOnShoppingCartPage() {
        shoppingCartStepSerenity.moveToViewCheckOutAsGuestButton();
        shoppingCartStepSerenity.highLightCheckoutAsGuestButton();
        shoppingCartStepSerenity.clickCheckoutAsGuestButton();
    }

    // Log In And Checkout
    @Then("click Log In and Checkout on Shopping Cart page")
    public void userClickOnLogInAndCheckoutButton() {
        shoppingCartStepSerenity.moveToViewLogInAndCheckOutButton();
        shoppingCartStepSerenity.highLightLogInAndCheckOutButton();
        shoppingCartStepSerenity.clickLogInAndCheckOutButton();
    }

    @Then("user increase Qty of Gift card by one")
    public void userIncreaseQtyOfGiftCardByOne() throws InterruptedException {
        shoppingCartStepSerenity.user_IncreaseQtyOfGiftCardByOne();
    }

    @Then("click Checkout on Mini Cart")
    public void clickCheckoutOnMiniCart() {
        shoppingCartStepSerenity.click_CheckoutOnMiniCart();
    }


    @Then("set Shopping Cart Substitution to National Brand '(.*)'")
    public void setShoppingCartSubstitutiontoNationalBrand(String shopcartsub) {
        shoppingCartStepSerenity.set_ShoppingCartSubstitution(shopcartsub);
    }

    @Then("set Shopping Cart Substitution to Meijer Brand '(.*)'")
    public void setShoppingCartSubstitutiontoMeijerBrand(String shopcartsub) {
        shoppingCartStepSerenity.set_ShoppingCartSubstitution(shopcartsub);
    }

    @Then("change the qty of item to get 3000 or more Subtotal")
    public void changeQtyofItemToGet3000orMoreSubtotal() throws InterruptedException {
        shoppingCartStepSerenity.change_QtyofItemToGet3000orMoreSubtotal();
    }

    @Then("user click remove button of the general merchandise product '(.*)'")
    public void userClickRemoveButtonofGeneralMerchandiseProduct(int noitemremove) {
        shoppingCartStepSerenity.user_ClickRemoveButtonofGeneralMerchandiseProduct(noitemremove);
    }

    @Then("shopping cart page refresh and update correct item count and subtotal price '(.*)'")
    public void shoppingCartStepSerenityPageRefreshAndUpdateCorrectItemCountAndSubtotalPrice(String itemcount) {
        shoppingCartStepSerenity.shopping_CartPageRefreshAndUpdateCorrectItemCountAndSubtotalPrice(itemcount);
    }

    @Then("user click remove button next to produce item '(.*)'")
    public void userClickRemoveButtonNextToProduceItem(int noitemremove) {
        shoppingCartStepSerenity.user_ClickRemoveButtonNextToProduceItem(noitemremove);
    }

    @Then("user click remove button next to custom cake item '(.*)'")
    public void userClickRemoveButtonNextToCustomCakeItem(int noitemremove) {
        shoppingCartStepSerenity.user_ClickRemoveButtonNextToCustomCakeItem(noitemremove);
    }

    @Then("clear arraylist of shopping cart")
    public void clearArraylistOfShoppingCart() {
        shoppingCartStepSerenity.clear_ArrayListOfShoppingCart();
    }

    @Then("user reduce QTY of CNC item '(.*)'")
    public void userReduceQTYofCNCItem(int qtytoreduce) throws InterruptedException {
        shoppingCartStepSerenity.user_ReduceQTYofCNCItem(qtytoreduce);
    }

    @Then("user increase QTY of CNC item '(.*)'")
    public void userIncreaseQTYofCNCitem(int qtytoincrease) throws InterruptedException {
        shoppingCartStepSerenity.user_IncreaseQTYofCNCItem(qtytoincrease);
    }

    //Created By: 107793 11/17/16
    @Then("validate state of Unavailable items in Shopping Cart")
    public void validateStateOfUnavailableItems_InShoppingCartPage() {
        String fulfillmentGroup1 = "1", fulfillmentGroup2 = "2", fulfillmentGroup8 = "8";
        UtilityHelper.waitUntilClickable(By.xpath("//ul[contains(@id,'productGroup')]"));
        List<WebElement> fGroup1 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_1')]/li"));
        List<WebElement> fGroup2 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_2')]/li"));
        List<WebElement> fGroup8 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_8')]/li"));
        if (fGroup1.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup1, fGroup1);
        }
        if (fGroup2.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup2, fGroup2);
        }
        if (fGroup8.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup8, fGroup8);
        }
        shoppingCartStepSerenity.validate_ShoppingCartFor_SelectedProductNamesDisplay();
        shoppingCartStepSerenity.validate_StateOfUnavailableItems_InShoppingCart();
    }

    //Created By: 107793 11/17/16
    @Then("validate state of Unavailable items in Mini-Cart")
    public void validateStateOfUnavailableItem_InMiniCart() throws InterruptedException {
        homePage.setOrderByTimeAddedStringList();
        HomePageStepDefinition.quickThreadSleepMethod(2);
        shoppingCartStepSerenity.validate_MiniCartFor_SelectedProductNamesDisplay();
        shoppingCartStepSerenity.validate_StateOfUnavailableItems_InMiniCart();
    }

    //Created By: 107793 11/17/16
    @Then("validate mini-cart sort by newest item added")
    public void validateMiniCartSortByNewestItemAdded() throws InterruptedException {
        homePage.setOrderByTimeAddedStringList();
        HomePageStepDefinition.quickThreadSleepMethod(2);
        shoppingCartStepSerenity.validate_MiniCartFor_SelectedProductNamesDisplay();
        HomePageStepDefinition.quickThreadSleepMethod(2);
    }

    //Created By: 107793 11/18/16
    @Then("validate fulfillment group order in mini-cart")
    public void validateMiniCartFulfillmentGroup() throws InterruptedException {
        HomePageStepDefinition.quickThreadSleepMethod(2);
        shoppingCartStepSerenity.validate_MiniCartFulfillmentGroup();
        HomePageStepDefinition.quickThreadSleepMethod(2);
    }

    @Then("verify modal notification of unavailable items appears")
    public void verifyNotificationOfUnavailableItemsModalAppears() {
        shoppingCartStepSerenity.verifyNotificationOfUnavailableItemsModalAppears();
        shoppingCartStepSerenity.lookAndFeelOfNotificationModal();
    }

    @Then("set array list of items to be deleted via Notification Modal")
    public void setArrayListOfItemsToBeDeletedViaNotificationModal() {
        shoppingCartStepSerenity.setArrayListOfItemsToBeDeletedViaNotificationModal();
    }

    @Then("user clicks Remove Items From Cart button via Notification Modal")
    public void userClicksRemoveItemsFromCartButton() {
        shoppingCartStepSerenity.userClicksRemoveItemsFromCartButton();
    }

    @Then("user closes notification of unavailable items modal")
    public void userClosesNotificationOfUnavailableItemsModal() {
        shoppingCartStepSerenity.userClosesNotificationOfUnavailableItemsModal();
    }

    @Then("compare items Removed with existing items in Shopping Cart Page")
    public void compareItemsRemovedWithExistingItemsInShoppingCartPage() {
        String fulfillmentGroup1 = "1", fulfillmentGroup2 = "2", fulfillmentGroup8 = "8";
        UtilityHelper.waitUntilClickable(By.xpath("//ul[contains(@id,'productGroup')]"));
        List<WebElement> fGroup1 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_1')]/li"));
        List<WebElement> fGroup2 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_2')]/li"));
        List<WebElement> fGroup8 = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup_8')]/li"));
        if (fGroup1.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup1, fGroup1);
        }
        if (fGroup2.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup2, fGroup2);
        }
        if (fGroup8.size() > 0) {
            setArrayListOfItemsInShoppingCart(fulfillmentGroup8, fGroup8);
        }
        shoppingCartStepSerenity.compareItemsRemovedWithExistingItemsInShoppingCartPage();
    }

    @Then("^increase the Quantity by '(.*)' of '(.*)' products in Shopping Cart page$")
    public void increaseQtyStepperOfRandomProductsInShoppingCartPage(int clickPlus, String productCount) {
        int limit = 0;
        List<WebElement> productsInShoppingCart = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup')]/li"));
        if ((productCount.toUpperCase().equals("ALL")) || (Integer.valueOf(productCount) > productsInShoppingCart.size())) {
            productCount = String.valueOf(productsInShoppingCart.size());
        }
        UtilityHelper.shuffleList(1, productsInShoppingCart.size());
        for (WebElement element : productsInShoppingCart) {
            if (limit != Integer.valueOf(productCount)) {
                By xpath = By.xpath("//ul[contains(@id,'productGroup')]/li[contains(@id,'" + UtilityHelper.popShuffledList() + "')]");
                if (UtilityHelper.elementNotExists(xpath)) {
                    continue;
                }
                element = getDriver().findElement(xpath);
                shoppingCartStepSerenity.increaseQtyStepperOfRandomProductsInShoppingCartPage(element, clickPlus);
                limit++;
            }
        }
    }

    @Then("^decrease the Quantity by '(.*)' of '(.*)' products in Shopping Cart page$")
    public void decreaseQtyStepperOfRandomProductsInShoppingCartPage(int clickMinus, String productCount) {
        int limit = 0;
        List<WebElement> productsInShoppingCart = getDriver().findElements(By.xpath("//ul[contains(@id,'productGroup')]/li"));
        if ((productCount.toUpperCase().equals("ALL")) || (Integer.valueOf(productCount) > productsInShoppingCart.size())) {
            productCount = String.valueOf(productsInShoppingCart.size());
        }
        UtilityHelper.shuffleList(1, productsInShoppingCart.size());
        for (WebElement element : productsInShoppingCart) {
            if (limit != Integer.valueOf(productCount)) {
                By xpath = By.xpath("//ul[contains(@id,'productGroup')]/li[contains(@id,'" + UtilityHelper.popShuffledList() + "')]");
                if (UtilityHelper.elementNotExists(xpath)) {
                    continue;
                }
                element = getDriver().findElement(xpath);
                shoppingCartStepSerenity.decreaseQtyStepperOfRandomProductsInShoppingCartPage(element, clickMinus);
                limit++;
            }
        }

    }

    @Then("verify the static message on mini-cart")
    public void verifyStaticMessageOnMiniCart() {
        shoppingCartStepSerenity.verifyStaticMessageOnMiniCart();
    }

    @Then("verify no static message on mini-cart")
    public void verifyNoStaticMessageOnMiniCart() {
        shoppingCartStepSerenity.verifyNoStaticMessageOnMiniCart();
    }

    @Then("verify the static message is displayed in shopping cart")
    public void verifyStaticMessageIsDisplayedInShoppingCart() {
        shoppingCartStepSerenity.verifyStaticMessageIsDisplayedInShoppingCart();
    }

    @Then("verify there is no static message in shopping cart")
    public void verifyNoStaticMessageIsDisplayedInShoppingCart() {
        shoppingCartStepSerenity.verifyNoStaticMessageIsDisplayedInShoppingCart();
    }

    @Then("verify no static message and tooltip appears when empty cart")
    public void verifyNoStaticMessageAndTooltipAppearsWhenEmptyCart() {
        shoppingCartStepSerenity.verifyNoStaticMessageAndTooltipAppearsWhenEmptyCart();
    }




}
