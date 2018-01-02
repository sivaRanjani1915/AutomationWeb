package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.*;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;

public class HomePageStepSerenity extends ScenarioSteps {

    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    OrderDetailPage orderDetailPage;
    OrderPickupPage orderPickupPage;
    OrderReviewPage orderReviewPage;
    utilityhelper UtilityHelper;

    @Step
    public void userClosesMiniCart() {
        homePage.userClosesMiniCart();
    }

    @Step
    public void user_addsOneGiftCardToCart(String qty) {
        homePage.addOneGiftCardToCart(Integer.parseInt(qty));
    }

    @Step
    public void user_addsMultipleGiftCardsToCart(String qty) {
        homePage.addMultipleGiftCardsToCart(Integer.parseInt(qty));
    }

    @Step
    public void user_addsOneProductToCart(String qty) {
        homePage.addOneProductToCart(Integer.parseInt(qty));
    }

    @Step
    public void user_addsMultipleProductsToCart(String qty) {
        homePage.addMultipleProductsToCart(Integer.parseInt(qty));
    }

    @Step
    public void highLightSearchIconToViewProducts() {
        UtilityHelper.highLightElement(homePage.SEARCH_BAR_ICON);
    }

    @Step
    public void userSearchesForProductType(String productType) throws InterruptedException {
        homePage.userSearchesForProductType(productType);
    }

    @Step
    public void clickOnSearchIconToViewProducts() {
        homePage.clickOnSearchIconToViewProducts();
    }

    @Step
    public void verifySearchResultsDisplay() throws InterruptedException {
        homePage.verifySearchResultsDisplay();
    }

    @Step
    public void javaScriptExecuteCreationLog() {
        homePage.javaScriptExecuteCreationLog();
    }

    @Step
    public void user_addsItemsToCartUntilPriceIsMet(String price) {
        homePage.addItemsToCartUntilPriceIsMet(Double.parseDouble(price));
    }

    @Step
    public void userRecordsSearchResults() {
        homePage.userRecordsSearchResults();
    }

    @Step
    public void userVerifiesSearchResultsMatchPreviousResults() {
        homePage.userVerifiesSearchResultsMatchPreviousResults();
    }

    @Step
    public void verify_CurbsideToNonCurbsideConflictModalAppears() {
        homePage.curbsideToNonCurbsideConflictModalAppears();
    }

    @Step
    public void verify_ChangeStoreConflictModalDetails() {
        homePage.changeStoreConflictModalDetails();
    }

    @Step
    public void highLightKeepStoreButton() {
        UtilityHelper.highLightElement(homePage.STORE_CONFLICT_KEEP_STORE_BUTTON);
    }

    @Step
    public void userClicksKeepStoreButton() {
        homePage.clickKeepStoreButton();
    }

    @Step
    public void highLightContinueChangeStoreButton() {
        UtilityHelper.highLightElement(homePage.STORE_CONFLICT_CHANGE_STORE_BUTTON);
    }

    @Step
    public void userClicksContinueChangeStore() {
        homePage.clickContinueChangeStoreButton();
    }

    @Step
    public void user_AltersResultsPerPageCountTo(int perPg) {
        homePage.alterResultsPerPageCountTo(perPg);
    }

    @Step
    public void highLightShopByCategory(String category) {
        homePage.highLightShopByCategory(category);
    }

    @Step
    public void user_ClicksShopByCategoryOption_SearchResults(String category) {
        homePage.clickShopByCategory_SearchResults(category);
        homePage.verifyShopByCategoryHasLoaded(category);
    }

    @Step
    public void moveToViewYourFavoritesViaQuickShopPage() {
        homePage.moveToViewYourFavoritesViaQuickShopPage();
    }

    @Step
    public void userClicksViewAllOnYourFavorites() {
        homePage.userClicksViewAllOnYourFavorites();
    }

    @Step
    public void atRandomMoveToViewProduct(WebElement element) {
        homePage.atRandomMoveToViewProduct(element);
    }

    @Step
    public void attemptToAddChokingHazardItemToCart(WebElement element, String itemQty) {
        homePage.attemptToAddChokingHazardItemToCart(element, itemQty);
    }

    @Step
    public void clickOnProductToViewItsPDP(WebElement element) {
        homePage.clickOnProductToViewItsPDP(element);
    }

    @Step
    public void nutrilabelmain() {
        homePage.verifylabelmain();
    }

    @Step
    public void productDetailsInMetaDescription() {
        homePage.verifyProductDetailsInMetaDescription();
    }

    @Step
    public void verifyPDP_Displays() {
        homePage.verify_productDetailTitle();
        homePage.verify_productDetailPage();
//        homePage.verify_featuresTitle();
//        homePage.verify_relatedProductsTitle();
    }

    @Step
    public void clickPlusQuantityStepperOnPdpPage() {
        homePage.clickPlusQuantityStepperOnPdpPage();
    }

    @Step
    public void clickMinusQuantityStepperOnPdpPage() {
        homePage.clickMinusQuantityStepperOnPdpPage();
    }

    @Step
    public void verifyValueInQuantityFieldOnPdpPageIsOne() {
        homePage.verifyValueInQuantityFieldOnPdpPageIsOne();
    }

    @Step
    public void verifyTheQuantityInTheInputFieldOnPdpPageMatchesTheQuantityInTheWinkbar() {
        homePage.verifyTheQuantityInTheInputFieldOnPdpPageMatchesTheQuantityInTheWinkbar();
    }

    @Step
    public void clickAddToCartButtonOnPdpPage() {
        homePage.clickAddToCartButtonOnPdpPage();
    }

    @Step
    public void verifyQtyStepperError() {
        homePage.verifyQtyStepperError();
    }

    @Step
    public void verifyAddToCartDisabledOnPdp() {
        homePage.verifyAddToCartDisabledOnPdp();
    }

    @Step
    public void verifyQuantityDoesNotGoBelowStepQuantity() {
        homePage.verifyQuantityDoesNotGoBelowStepQuantity();
    }

    @Step
    public void verifyQuantityInQuantityFieldGoesUpBy1() {
        homePage.verifyQuantityInQuantityFieldGoesUpBy1();
    }

    @Step
    public void verifyQuantityInQuantityFieldGoesDownBy1() {
        homePage.verifyQuantityInQuantityFieldGoesDownBy1();
    }

    @Step
    public void typeAmountIntoQuantityFieldOnPdpPage(String qty) {
        homePage.typeAmountIntoQuantityFieldOnPdpPage(qty);
    }

    @Step
    public void verifyQuantityFieldDisplaysErrorsOnPdpPage() {
        homePage.verifyQuantityFieldDisplaysErrorsOnPdpPage();
    }

    @Step
    public void verifywayfindingtier2() throws InterruptedException {
        homePage.verifywayfinding_tier2_tier1();
    }

    @Step
    public void verify_upc_ingreditent_warning() throws IOException, InterruptedException {
        homePage.verify_ingredientswarnings_forallupc();
    }


    @Step
    public void verifyNutritionalAttributes_Displayed() {
        homePage.verify_NutritionalAttributesDisplayed();
    }

    @Step
    public void verifyclaims_Displayed() {
        homePage.verify_NutritionalAttributesDisplayed();
    }

    @Step
    public void verifyNutritionalAttributes_NotDisplayed() {
        homePage.verify_NutritionalAttributesNotDisplayed();
    }

    @Step
    public void verifyclaims_NotDisplayed() {
        homePage.verify_NutritionalAttributesNotDisplayed();
    }

    @Step
    public void user_hoversOverTier(String tier1) throws InterruptedException {
        homePage.userHoversOverTier(tier1);
    }

    @Step
    public void verifyNoMoreThan12Attributes_Displayed() {
        homePage.verify_NoMoreThan12AttributesDisplayed();
    }

    @Step
    public void verifyNutritional_Attributes(String... attributes) {
        homePage.verify_NutritionalAttributes(attributes);
    }

    @Step
    public void verifyProductIngredients_Displayed() {
        homePage.verify_ProductIngredientsDisplayed();
        homePage.verify_IngredientsSectionHeader();
    }

    @Step
    public void verifyProductIngredients_NotDisplayed() {
        homePage.verify_ProductIngredientsNotDisplayed();
    }

    @Step
    public void verifyno_Ingredients() {
        homePage.verify_ProductIngredientsNotDisplayed();
    }

    @Step
    public void verifyIngredients_NotDisplayed() {
        homePage.verify_ProductIngredientsNotDisplayed();
    }

    @Step
    public void verifyProductWarnings_Displayed() {
        homePage.verify_ProductWarningsDisplayed();
        homePage.verify_WarningsSectionHeader();
    }

    @Step
    public void verifyProductWarnings_NotDisplayed() {
        homePage.verify_ProductWarningsNotDisplayed();
    }

    @Step
    public void verifyWarnings_NotDisplayed() {
        homePage.verify_ProductWarningsNotDisplayed();
    }

    @Step
    public void verifyCopy_MatchesNoncollapseLegalDisclaimer2() {
        homePage.verify_CopyMatchesNoncollapseLegalDisclaimer2();
    }

    @Step
    public void userClicksShowMore_Disclaimer() {
        homePage.user_ClicksShowMoreDisclaimer();
    }

    @Step
    public void verifyCopy_MatchesCollapseLegalDisclaimer2() {
        homePage.verify_CopyMatchesCollapseLegalDisclaimer2();
    }

    @Step
    public void verifyCopy_MatchesNoncollapseLegalDisclaimer1() {
        homePage.verify_CopyMatchesNoncollapseLegalDisclaimer1();
    }

    @Step
    public void verifyCopy_MatchesCollapseLegalDisclaimer1() {
        homePage.verify_CopyMatchesCollapseLegalDisclaimer1();
    }

    @Step
    public void verifyHeaderHeading_DisplaysNutritionFacts() {
        homePage.verify_HeaderHeadingDisplaysNutritionFacts();
    }

    @Step
    public void verifynutritiondetails() {
        homePage.verify_nutritiondetails();
    }

    @Step
    public void verifynutritionheader() {
        homePage.verify_nutritionheader();
    }

    @Step
    public void verifyServingsPerContainerIs_DisplayedAndReflectsCorrectData(String servingsPerContainer) {
        homePage.verify_ServingsPerContainerIsDisplayedAndReflectsCorrectData(servingsPerContainer);
    }

    @Step
    public void verifyServingSizeIs_DisplayedAndReflectsCorrectData(String servingSize1, String servingSize2) {
        homePage.verify_ServingSizeIsDisplayedAndReflectsCorrectData(servingSize1, servingSize2);
    }

    @Step
    public void verifyCalorieCountIs_DisplayedAndReflectsCorrectData(String calorieCount) {
        homePage.verify_CalorieCountIsDisplayedAndReflectsCorrectData(calorieCount);
    }

    @Step
    public void verifyCaloriesFromFatIs_DisplayedAndReflectsCorrectData(String caloriesFromFat) {
        homePage.verify_CaloriesFromFatIsDisplayedAndReflectsCorrectData(caloriesFromFat);
    }

    @Step
    public void verifyDisplay_OfNutriLabelMain() {
        homePage.verify_DisplayOfNutriLabelMain();
    }

    @Step
    public void verifystatic_footer() {
        homePage.verify_staticfooter();
    }

    @Step
    public void validateNutritionLabelMain_Data(String... items) {
        homePage.validate_NutritionLabelMainData(items);
    }

    @Step
    public void validateMandatoryMicronutrientsAre_Displayed() {
        homePage.validate_MandatoryMicronutrientsAreDisplayed();
    }

    @Step
    public void verifyDisclaimersDisplayedBeforeNutritionalDetails() {
        homePage.verifyDisclaimersDisplayedBeforeNutritionalDetails();
    }

    @Step
    public void verifyNutritionalAttributesDisplayedBeforeIngredients() {
        homePage.verifyNutritionalAttributesDisplayedBeforeIngredients();
    }

    @Step
    public void verifyNutritionalAttributesDisplayedBeforeWarnings() {
        homePage.verifyNutritionalAttributesDisplayedBeforeWarnings();

    }

    @Step
    public void verifyNutritionalAttributesDisplayedBeforeDisclaimers() {
        homePage.verifyNutritionalAttributesDisplayedBeforeDisclaimers();

    }

    @Step
    public void verifyNutritionalAttributesDisplayedBeforeNutritionalDetails() {
        homePage.verifyNutritionalAttributesDisplayedBeforeNutritionalDetails();

    }

    @Step
    public void verifyProductIngredientsDisplayedBeforeWarnings() {
        homePage.verifyProductIngredientsDisplayedBeforeWarnings();
    }

    @Step
    public void verifyProductIngredientsDisplayedBeforeDisclaimers() {
        homePage.verifyProductIngredientsDisplayedBeforeDisclaimers();
    }

    @Step
    public void verifyProductIngredientsDisplayedBeforeNutritionDetails() {
        homePage.verifyProductIngredientsDisplayedBeforeNutritionDetails();
    }

    @Step
    public void verifyProductWarningsDisplayedBeforeDisclaimers() {
        homePage.verifyProductWarningsDisplayedBeforeDisclaimers();
    }

    @Step
    public void verifyProductWarningsDisplayedBeforeNutritionDetails() {
        homePage.verifyProductWarningsDisplayedBeforeNutritionDetails();
    }

    @Step
    public void verifyNutritionalDetailsPanelDisplayedBeforeNutritionalLabelHeader() {
        homePage.verifyNutritionalDetailsPanelDisplayedBeforeNutritionalLabelHeader();
    }

    @Step
    public void verifyNutritionLabelHeaderDisplayedBeforeNutritionLabelMain() {
        homePage.verifyNutritionLabelHeaderDisplayedBeforeNutritionLabelMain();
    }

    @Step
    public void verifyNutritionLabelMainDisplayedBeforeNutritionLabelMicronutrients() {
        homePage.verifyNutritionLabelMainDisplayedBeforeNutritionLabelMicronutrients();
    }

    @Step
    public void verifyNutritionLabelMicronutrients() {
        homePage.verifyNutritionLabelMicronutrients();
    }

    @Step
    public void verifyNutritionLabelMicronutrientsDisplayedBeforeNutritionLabelFooter() {
        homePage.verifyNutritionLabelMicronutrientsDisplayedBeforeNutritionLabelFooter();
    }

    @Step
    public void verifyTilesFor_CaloriesFatCarbsProtein() {
        homePage.verify_TilesForCaloriesFatCarbsProtein();
    }

    @Step
    public void validateDataInEachTileIs_CorrectData(String cal, String fat, String carbs, String protein) {
        homePage.validate_DataInEachTileIsCorrectData(cal, fat, carbs, protein);
    }

    @Step
    public void verifyNoNutritionalData_Displayed() {
        homePage.verify_NoNutritionalDataDisplayed();
    }

    @Step
    public void verifyCopyRemovalOnPDP_page() {
        homePage.verifyCopyRemoval_PDP();
    }

    @Step
    public void verifySeePriceInCartCopyOnPDP() {
        homePage.verifySeePriceInCartCopyOnPDP();
    }

    @Step
    public void verifyH1TagsOnProductNamePDP() {
        homePage.verifyH1Tags_ProductNamePDP();
    }

    @Step
    public void verifyAltTagsOnProductImagePDP() {
        homePage.verifyAltTags_ProductImagePDP();
    }

    @Step
    public void verifyWindowTabTitle_PDP() {
        homePage.windowTabTitleOnPDP();
    }

    @Step
    public void verifyCopyRemoval_eCommFlagOff() {
        homePage.verifyCopy_eCommFlagOff();
    }

    @Step
    public void verifyRemoval_AddToCartButton_OutOfStockItem() {
        homePage.verify_AddToCartButtonRemoved_OutOfStockItem();
    }

    @Step
    public void h3TagsForProductName() {
        homePage.h3Tags_ProductName();
    }

    @Step
    public void verifyH1Tag_CategoryName() {
        homePage.h1TagOnCategoryName();
    }

    @Step
    public void altTagsForProductImages() {
        homePage.altTags_ProductImage();
    }

    @Step
    public void lookAndFeelBreadcrumbs() {
        homePage.breadCrumbsValidate();
    }

    @Step
    public void highLightXtoCloseSignInModal() {
        UtilityHelper.highLightElement(homePage.SIGN_IN_MODAL_CLOSE);
    }

    @Step
    public void clickXtoCloseSignInModal() {
        homePage.clickXtoCloseSignInModal();
    }

    @Step
    public void verifySSItokenExists() {
        homePage.verifySSItokenExists();
    }

    @Step
    public void verifySSItokenDoesNotExist() {
        homePage.verifySSItokenDoesNotExist();
    }

    @Step
    public void meijer_HomePageDisplayUserIsSignedInSuccessfully() throws InterruptedException {
        homePage.validateMeijerHomePageAfterLogInSuccessfully();
    }

    @Step
    public void verify_UserHasNoActiveOrder() {
        homePage.validateUserHasNoActiveOrder();
    }

    @Step
    public void meijerHomePageDisplay() throws InterruptedException {
        homePage.meijerHomePageDisplay();
    }

    @Step
    public void userPokesAtGiftCardRates() throws IOException, InterruptedException {
        homePage.userPokesAtGiftCardRates();
    }

    @Step
    public void validateGiftCardRate(String priceORqty, String shippingMethod) throws IOException, InterruptedException {
        homePage.validateGiftCardRate(priceORqty, shippingMethod);
    }

    @Step
    public void validateZeroTaxesForGiftCardOnlyOrder() {
        homePage.validateZeroTaxesForGiftCardOnlyOrder();
    }

    @Step
    public void choose_AgeRestrictedProductUpdateQtyto13andClickAddtoCart(int noitem, String itemqty) throws InterruptedException {
        homePage.selectAvailableItems_WithMoreThan1QTY(noitem, itemqty);
    }

    @Step
    public void clickCartIconInHeaderAndClickViewCart() {
        homePage.clickCartIconInHeaderAndClickViewCart();
    }

    @Step
    public void highLightCheckOutButtonViaMiniCart() {
        UtilityHelper.highLightElement(homePage.MINI_CART_CHECKOUT_BUTTON);
    }

    @Step
    public void userClicksCheckOutButtonViaMiniCart() {
        homePage.userClicksCheckOutButtonViaMiniCart();
    }

    @Step
    public void user_verifiesProductsAreSorted(String what, String type) {
        homePage.verifyProductPageIsSorted(what, type);
    }

    @Step
    public void user_ClicksSortByNameLowToHigh() {
        homePage.clickSortByNameLowToHigh();
    }

    @Step
    public void user_ClicksSortByNameHighToLow() {
        homePage.clickSortByNameHighToLow();
    }

    @Step
    public void user_ClicksSortByPriceLowToHigh() {
        homePage.clickSortByPriceLowToHigh();
    }

    @Step
    public void user_ClicksSortByPriceHighToLow() {
        homePage.clickSortByPriceHighToLow();
    }

    @Step
    public void highLightCartIcon() {
        UtilityHelper.highLightElement(homePage.CART_ICON);
    }

    @Step
    public void verifyMiniCartHasLoaded() {
        homePage.verifyMiniCartHasLoaded();
    }

    @Step
    public void userOpensMiniCart() {
        homePage.userOpensMiniCart();
    }

    @Step
    public void moveToViewMiniCartIcon() {
        homePage.moveToViewMiniCartIcon();
    }

    @Step
    public void navigate_ToNextPageOfProductList() throws InterruptedException {
        homePage.clickNextPage_ProductList();
    }

    @Step
    public void validateHomepageDisplay0ItemInCart() {
        homePage.shoppingCart0ItemCountvaldiation();
    }

    @Step
    public void validateMeijerHomepageDisplayActiveOrderPickupTimeUnderCurbsideWidget() {
        homePage.viewLinkDisplayCurbsideWidget();
        homePage.editLinkDisplayCurbsideWidget();
    }

    @Step
    public void validateDATEAndTIMEDisplayUnderCurbsideWidgetViaHomePage() {
        homePage.validateDATEDisplayUnderCurbsideWidgetViaHomePage();
        homePage.validateTIMEDisplayUnderCurbsideWidgetViaHomePage();
    }

    @Step
    public void resetShoppingCartTo0Item_miniCart() {
        homePage.resetMiniCartTo0Items();
    }

    @Step
    public void user_RemovesAllFulfillmentTypeFromMiniCart(String fGroup) {
        homePage.moveToViewAndOpenMiniCart();
        homePage.removeAllDesiresFulfillmentType_MiniCart(fGroup);
    }

    @Step
    public void user_VerifyToolTipErrorMessaging_Eaches(WebElement element) {
//        int item = homePage.errorMessage_Eaches_Default();
        homePage.errorMessage_Eaches_LessThanOneValue(element);
        homePage.errorMessage_Eaches_DecimalValue(element);
    }

    @Step
    public void user_VerifyToolTipErrorMessaging_Weight(WebElement element) {
        homePage.errorMessage_Weight_LessThanOneValue(element);
        homePage.errorMessage_Weight_DecimalValue(element);
    }

    @Step
    public void user_VerifyToolTipErrorMessagingEaches_PDP() {
        homePage.errorMessage_Default_PDP();
        homePage.errorMessage_Eaches_LessThanOneValue_PDP();
        homePage.errorMessage_Eaches_DecimalValue_PDP();
    }

    @Step
    public void user_VerifyToolTipErrorMessagingWeight_PDP() {
        homePage.errorMessage_Default_PDP();
        homePage.errorMessage_Weight_LessThanOneValue_PDP();
        homePage.errorMessage_Weight_DecimalValue_PDP();
    }

    @Step
    public void atRandomViewProductAndAddToCart(WebElement element, String itemQty) {
        homePage.atRandomViewProductAndAddToCart(element, itemQty);
    }

    @Step
    public void user_BrowsethroughShopAndSelectCreateACake() throws InterruptedException {
        homePage.clickcreateacakeoption();
    }

    @Step
    public void custom_CakeLandingpageDisplay() throws InterruptedException {
        homePage.cakelandingpage();
    }

    @Step
    public void user_ClickCreateThisCakeonaThemeCake() {
        homePage.switchframeforcake();
        homePage.clickCreateACakeButton();
    }

    @Step
    public void user_ClickCreateThisCakeForTheSelectedCategory() {
        homePage.clickCreateACakeButton();
    }

    @Step
    public void user_SelectMandatoryAttributesonCustomCake(int indexofsize, int indexofflavor, int icingIdxFrostType, int icingIdxFrostFlvr) throws InterruptedException {
        homePage.clicksizebar();
        homePage.selectSizeRadioButton(indexofsize);
        homePage.clickflavorbar();
        homePage.selectFlavorRadioButton(indexofflavor);
        homePage.clickIcingbar();
        homePage.selectIcingFrostingTypeRadioButton(icingIdxFrostType);
        homePage.selectIcingFrostingFlavorRadioButton(icingIdxFrostFlvr);
    }

    @Step
    public void select_MandatoryAttribute_SpecialOccassionCake(int indexofsize, int indexofflavor, int icingIdxFrostType, int icingIdxFrostFlvr) throws InterruptedException {
        homePage.clicksizebar();
        homePage.selectSizeRadioButton(indexofsize);
        homePage.clickflavorbar();
        homePage.selectFlavorRadioButton(indexofflavor);
        homePage.clickIcingbar();
        homePage.selectIcingFrostingTypeRadioButton(icingIdxFrostType);
        homePage.selectIcingFrostingFlavorRadioButton(icingIdxFrostFlvr);
        homePage.clickAddaPhotoBar();
        homePage.upload_photo_forCake();
        homePage.txtcommentforCakePhoto();
    }

    @Step
    public void select_OptionalAttributesOnCustomCake(int idxfilling, int idxtopbordrclr, int idxbtmbordrclr, String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePage.clickFillingbar();
        homePage.selectFillingRadioButtons(idxfilling);
        homePage.clickBorderColorBar();
        homePage.selectTopBorderColorRadioButton(idxtopbordrclr);
        homePage.selectBottomBorderColorRadioButton(idxbtmbordrclr);
        homePage.clickCustomeMsgBar();
        homePage.selectCustomMgsTextBox(txtcustmsg);
        homePage.selectCustomMsgRadioButton(idxcustmsgclr);
        homePage.clickSpecialInstructionBar();
        homePage.selectSpecialInstructionTextBox(txtspcInstrmsg);
    }

    @Step
    public void user_ClickOnAddToCartForDesignCake() {
        homePage.clickAddToCart_CustomCake();
    }

    @Step
    public void user_SelectCupcakeCakefromLHSNavigation() {
        homePage.switchframeforcake();
        homePage.cupcakeCakeLHSNavigation();
    }

    @Step
    public void user_SelectSpecialOccasionsGraduationOptionFromLHSNavigation() {
        homePage.switchframeforcake();
        homePage.specialOccasionsOptionLHS();
        homePage.graduation_SpecialOccasionsOptionLHS();
    }

    @Step
    public void select_CupcakeCakeOptionalAttributes(String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePage.clickCustomeMsgBar();
        homePage.selectCustomMgsTextBox(txtcustmsg);
        homePage.selectCustomMsgRadioButton(idxcustmsgclr);
        homePage.clickSpecialInstructionBar();
        homePage.selectSpecialInstructionTextBox(txtspcInstrmsg);
    }

    @Step
    public void select_SpecialOccasionsCakeOptionalAttributes(int idxfilling, String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePage.clickFillingbar();
        homePage.selectFillingRadioButtons(idxfilling);
        homePage.clickCustomeMsgBar();
        homePage.selectCustomMgsTextBox(txtcustmsg);
        homePage.selectCustomMsgRadioButton(idxcustmsgclr);
        homePage.clickSpecialInstructionBar();
        homePage.selectSpecialInstructionTextBox(txtspcInstrmsg);
    }

    @Step
    public void click_tooltipandverify() {
        homePage.clicktooltip_verify();
    }


    @Step
    public void clickAddToCartViaPDP(String qty) {
        homePage.clickAddToCartViaPDP(qty);
    }

    @Step
    public void open_AnAgeRestrictedItemandSelectQtyandAddToCart(String itemqty) throws InterruptedException {
        homePage.openAndselectAlcoholItems(itemqty);
    }

    @Step
    public void click_OnLastPageOfTheProductList() throws InterruptedException {
        homePage.clickLastPage_ProductList();
    }

    @Step
    public void user_ClickEditLinkInCurbsideWidget() {
        homePage.clickEditOrderLink_curbsideWidget();
    }

    @Step
    public void user_ClickViewLinkInCurbsideWidget() {
        homePage.clickViewOrderLink_curbsideWidget();
    }

    @Step
    public void select_HazardousItemandUpdateQtyandAddtoCart(int noitem, String itemqty) throws InterruptedException {
        homePage.identifyHazardousItemandAddtoCart(noitem, itemqty);
    }

    @Step
    public void user_NavigateBackTomPerksHomeScreen() {
        homePage.navigate_mPerksHomePage_HittingBrowserBackButton();
    }

    @Step
    public void yourStorePageDisplay() {
        homePage.yourStore_display();
    }

    @Step
    public void user_viewSourceCode() {
        homePage.viewSourceCode();
    }

    @Step
    public void storePageSchemaNameAddressHours() {
        homePage.storePageSchemaName();
        homePage.storePageSchemaAddress();
        homePage.storePageSchemaHours();
    }

    @Step
    public void pdpSchemaNameImageDescriptionPrice() {
        homePage.schemaName_PDP();
        homePage.schemaImage_PDP();
        homePage.schemaDescription_PDP();
        homePage.schemaPrice_PDP();
    }

    @Step
    public void highLightSignInToReserveATimeSlotLink() {
        UtilityHelper.highLightElement(homePage.SIGN_IN_TO_RESERVE_SLOT_LINK);
    }

    @Step
    public void userClicksSignInToReserveATimeSlotLink() {
        homePage.userClicksSignInToReserveATimeSlotLink();
    }

    @Step
    public void validate_HeaderWidgetDropsYourCurrentReservationHold() {
        homePage.validate_CurrentReservationSlot_Drop();
    }

    @Step
    public void validate_TimeSlotReservedUntilisDisplayed() {
        homePage.reserveduntil_display_validation();
    }

    @Step
    public void validate_CurbsideDisplayReserveCurbsidePickupTime() {
        homePage.validateText_reserveCurbsidePickupTime_display();
    }

    @Step
    public void select_StoreLocatorfromFooterLink() {
        homePage.click_StoreLocator_Footer();
    }

    @Step
    public void select_MIiconFromMapOnStoreLocatorPge() {
        homePage.select_MI_fromMap();
    }

    @Step
    public void select_CurbsideEnabledStoreFromStoreLocatorPage() {
        homePage.select_CurbsideEnabledStore_Alpine();
    }

    @Step
    public void validate_ContentsOfCurbsideWizard() {
        homePage.validate_AvailableASATimeDisplay();
        homePage.availabletimevalue();
    }

    @Step
    public void validate_PastOrders_QuickShop_LinksDisplay() {
        homePage.validatePastOrderLink_Display();
        homePage.validateQuickShopLink_Display();
    }

    @Step
    public void validate_SignIntoReserveATimeSlotText_OnCurbsideWizard() {
        homePage.validate_SignInToReserveTimeSlot_TextDisplay();
    }

    @Step
    public void verify_wayfindingtile() {
        homePage.verifywayfinding_tile();
    }

    @Step
    public void userNavigatesToGivenTier1Item(String tier1) throws InterruptedException {
        homePage.navigateTo_GivenTier1Items_FromShopMenu(tier1);
    }

    @Step
    public void userNavigatesToGivenTier2Item(String tier1, String tier2) throws InterruptedException {
        homePage.navigateTo_GivenTier2Items_FromShopMenu(tier1, tier2);
    }

    @Step
    public void userNavigatesToGivenTier3Item(String tier1, String tier2, String tier3) throws InterruptedException {
        homePage.navigateTo_GivenTier3Items_FromShopMenu(tier1, tier2, tier3);
    }

    @Step
    public void userNavigatesToGivenTier4Item(String tier1, String tier2, String tier3, String tier4) throws InterruptedException {
        homePage.navigateTo_GivenTier4Items_FromShopMenu(tier1, tier2, tier3, tier4);
    }

    @Step
    public void clickOn_PastOrderLink_DisplayOnCurbsideWizard() {
        homePage.click_PastOrderlink_CurbsideWizard();
    }

    @Step
    public void validateLinks_PastOrder_NotDisplay() {
        homePage.pastOrder_linkNotDisplay();
    }

    @Step
    public void validateLinks_QuickShop_NotDisplay() {
        homePage.quickShop_linkNotDisplay();
    }

    @Step
    public void click_QuickShopLink_CurbsideWizard() throws InterruptedException {
        homePage.click_QuickShoplink_CurbsideWizard();
    }

    @Step
    public void validate_QuickShopPage_Display_pageTitle() {
        homePage.validate_QuickShop_pageTitle();
    }

    @Step
    public void validate_QuickShopPage_Display_FrequentPurchase_Text() {
        homePage.validate_FrequentPurchases_Text();
    }

    @Step
    public void waitUntilHomepageLoads() {
        homePage.waitUntilHomepageLoads();
    }

    @Step
    public void validate_QuickShopPage_Display_YourFavorites_Text() {
        homePage.validate_YourFavorites_Text();
    }

    @Step
    public void validate_QuickShopPage_Display_YourRecommendations_Text() {
        homePage.validate_YourRecommendations_Text();
    }

    @Step
    public void validateQuickShopFavoritesSection_SSI() {
        homePage.validateQuickShopFavoritesSection_SSI();
    }

    @Step
    public void validate_ViewOrderlink_NotDisplayinCurbsideWizard() {
        homePage.validate_ViewOrderLink_NotDisplay();
    }

    @Step
    public void validate_EditOrderlinkNotDisplayinCurbsideWizard() {
        homePage.validate_EditOrderLink_NotDisplay();
    }

    @Step
    public void click_EditOrderlinkinCurbsideWidget() {
        homePage.clickEditOrderLink_curbsideWidget();
    }

    @Step
    public void validateWarningNoteDisplayToDropCurbsideReservationOnSelectStore() {
        homePage.validateWarningNoteDisplayToDropCurbsideReservationOnSelectStore();
    }

    @Step
    public void validate_YourStoreDisplaysUserSelectedStore(String storename) {
        homePage.validate_SelectedStore_Display(storename);
    }

    @Step
    public void validate_TimeZoneDisplayinET() {
        homePage.validate_ET_TimeZone();
    }

    @Step
    public void validate_TimeZoneDisplayInCentralTimeZone() {
        homePage.validate_CT_TimeZone();
    }

    @Step
    public void validate_TimeZoneDisplay_CurbsidePickupTimeAfterSlotReserved() throws ParseException {
        homePage.valdiate_TimeZone_Curbside_AfterSlotReserved();
    }

    @Step
    public void click_UseCurrentLocation_ButtonOnYourLocationSetup() {
        homePage.click_UseCurrentLocation_button();
    }

    @Step
    public void validate_CurbsideHeaderDisplayTimeZoneAs_EasternTime() {
        homePage.validate_ET_Curbside_AfterSlotReserved();
    }

    @Step
    public void validate_CurbsideHeaderDisplayTimeZoneas_CentralTime() {
        homePage.validate_CT_Curbside_AfterSlotReserved();
    }

    @Step
    public void userSelect_SignIn_FromSettingStoreLocationPopup() {
        homePage.click_SignIn_GeoLocationPopUp();
    }

    @Step
    public void userClickOnHeaderMenuServices() {
        homePage.userClickOnHeaderMenuServices();
    }

    @Step
    public void userClickOnHeaderMenuOnlineShopping(){
        homePage.userClickOnHeaderMenuOnlineShopping();
    }

    @Step
    public void validateCurbside1stOnDropdownlist() {
        homePage.validateCurbside1stOnDropdownlist();
    }

    @Step
    public void clickCurbsideFromOnlineShoppingDropdown() {
        homePage.clickCurbsideFromOnlineShoppingDropdown();
    }


    @Step
    public void validateCurbsidePageDisplaySuccessfully() {
        homePage.validateCurbsidePageDisplayCorrect();
    }

    @Step
    public void validateShipt2ndOnDropdownlist() {
        homePage.validateShipt2ndOnDropdownlist();
    }

    @Step
    public void clickShiptFromOnlineShoppingDropdown() {
        homePage.clickShiptFromOnlineShoppingDropdown();
    }

    @Step
    public void validateShiptPageDisplaySuccessfully() {
        homePage.validateShiptPageDisplaySuccessfully();
    }

    @Step
    public void user_provideZipCodeonGeoLocationSettingscreen(String zipcode) throws IOException {
        homePage.enterZipCode_GeoLocationScreen(zipcode);
    }

    @Step
    public void click_FindStoresButtononGeoLOcationSetting() {
        homePage.click_findStoreButton_GeoLocation();
    }

    @Step
    public void click_ShoppingCartIcononHomePage() {
        homePage.click_CartIcon();
    }

    @Step
    public void validate_CheckoutButtonIsDisabledonMiniCard() {
        homePage.validate_Checkout_button_Disabled();
    }

    @Step
    public void userVerify_ItemsDisplayedPerPage() {
        homePage.userVerifyItemsDisplayedPerPage();
    }

    @Step
    public void userVerify_StoreAgainstEachItemAndMainStoreSelectedSame() {
        homePage.userVerifyStoreAgainstEachItemAndMainStoreSelectedSame();
    }

    @Step
    public void highLightReserveCurbsidePickupTimeWidget() {
        UtilityHelper.highLightElement(homePage.RESERVE_CURBSIDE_PICKUP_TIME_LINK);
    }

    @Step
    public void userReserveCurbsidePickupTimeCurbsideWidget() {
        homePage.userReserveCurbsidePickupTimeCurbsideWidget();
    }

    @Step
    public void validate_pickupTimeModal_WithoutReservation() {
        homePage.pickupTimeModal_WithoutReservation();
    }

    @Step
    public void validate_pickupTimeModal_SPO_WithoutReservation() {
        homePage.pickupTimeModal_SPO_WithoutReservation();
    }

    @Step
    public void validate_pickupTimeModal_MixedCart_WithoutReservation() {
        homePage.pickupTimeModal_MixedCart_WithoutReservation();
    }

    @Step
    public void validate_pickupTimeModal_WithReservation() {
        homePage.validate_PickupTimeModal_WithReservation();
        orderPickupPage.pickupTimeModal_WithReservation();
    }

    @Step
    public void validate_pickupTimeModal_WithUpdatingReservation() {
        orderPickupPage.clickActiveReserveCurbsidePickupTimeInCurbsideWidget();
        homePage.validate_PickupTimeModal_WithReservation();
    }

    @Step
    public void updateReservationPickupTime() throws InterruptedException {
        orderPickupPage.clickActiveReserveCurbsidePickupTimeInCurbsideWidget();
        orderPickupPage.pickupTimeModal_WithUpdatingReservation();
        homePage.click_updatePickupTimeButton();
    }

    @Step
    public void validate_ReservedPickupTimeDisplayCorrectInCurbsideWidget() {
        orderPickupPage.validate_ReservedPickupTimeInCurbsideWidget();
    }

    @Step
    public void validate_NewReservedPickupTimeInCurbsideWidget() {
        orderPickupPage.validate_ReservedPickupTimeInCurbsideWidget();
    }

    @Step
    public void validate_ActiveOrderInCurbsideWidget() {
        orderPickupPage.validate_ActiveOrderInCurbsideWidget();
        homePage.viewLinkDisplayCurbsideWidget();
        homePage.editLinkDisplayCurbsideWidget();
    }

    @Step
    public void validate_itemNotAddedAndSlotReserved(String expCount) {
        homePage.validate_cartIconCount(expCount);
        orderPickupPage.validate_ReservedPickupTimeInCurbsideWidget();
    }

    @Step
    public void validate_itemAddedAndReservationDropped(String expCount) {
        homePage.validate_cartIconCount(expCount);
        homePage.validate_reservationDropped();
    }

    @Step
    public void editReserveCurbsidePickupTimeInCurbsideWidget() {
        orderPickupPage.clickActiveReserveCurbsidePickupTimeInCurbsideWidget();
    }

    @Step
    public void userCloseEditPickupTimeModal() {
        homePage.closePickupTimeModal();
    }

    @Step
    public void addingItemWarningMessage_SPO() {
        homePage.validate_ItemWarningMessage_SPO();
    }

    @Step
    public void validateItemWarningMasNotDisplayed() {
        homePage.verify_ItemWarningMsgNotDisplayed();
    }

    @Step
    public void addingItemWarningMessage_CNC() {
        homePage.validate_ItemWarningMessage_CNC();
    }

    @Step
    public void clickLeaveOutOfCartButton() {
        homePage.clickLeaveOutOfCartButton();
    }

    @Step
    public void clickContinueAddItemToCart() throws InterruptedException {
        homePage.clickContinueAddItemToCart();
    }

    @Step
    public void cartUpdateViaSlotTypeConflictMsg_AddItem() {
        homePage.cartUpdateViaSlotTypeConflictMsg_AddItem();
    }

    @Step
    public void reservedTimeSlotIsDropped() {
        homePage.reservedTimeSlotIsDropped();
    }

    @Step
    public void validate_availableAtYourStore() {
        homePage.validate_availabilityMessageInstore();
    }

    @Step
    public void validate_notAbleToAddToCart() {
        homePage.validate_thumbActions_notAvailable();
    }

    @Step
    public void click_mPerksWaysToSaveFromBottomLeft() {
        homePage.Click_mPerksWaysToSaveFromBottomLeftMenu();
    }

    @Step
    public void verifyPageLoadAfterFilterEdit() {
        homePage.waitUntilPageLoaderVanishes();
    }

    @Step
    public void click_SaleWaysToSaveFromBottomLeft() {
        homePage.Click_SaleWaysToSaveFromBottomLeftMenu();
    }

    @Step
    public void click_WaysToSaveDropdownMenu() {
        homePage.Click_WaysToSaveDropdownMenu();
    }

    @Step
    public void highLightSaleWaysToSaveFromTopDropdown() {
        if (UtilityHelper.elementExists(homePage.saleTop)) {
            UtilityHelper.highLightElement(homePage.saleTop);
        }
    }

    @Step
    public void highLightMperksWaysToSaveFromTopDropdown() {
        if (UtilityHelper.elementExists(homePage.mPerksTop)) {
            UtilityHelper.highLightElement(homePage.mPerksTop);
        }
    }

    @Step
    public void click_mPerksWaysToSaveFromTopDropdown() {
        homePage.Click_mPerksWaysToSaveFromTopDropdownMenu();
    }

    @Step
    public void click_SaleWaysToSaveFromTopDropDown() {
        homePage.Click_SaleWaysToSaveFromTopDropdownMenu();
    }

    @Step
    public void verify_weightMessagingIsNotPresentOnProductTitle() {
        homePage.verify_NoWeightMessagingOnProductTitle();
    }

    @Step
    public void verify_weightMessagingIsPresentOnProductDisplayPage() {
        homePage.verify_weightMessagingOnProductDisplayPage();
    }

    @Step
    public void verify_weightDisclaimerIsPresentOnProductDisplayPage() {
        homePage.verify_weightDisclaimerOnProductDisplayPage();
    }

    @Step
    public void verify_WeightDisclaimerIsPresentInMiniCart() {
        homePage.verify_WeightDisclaimerInMiniCart();
    }

    @Step
    public void verify_WeightDisclaimerIsPresentInCheckout() {
        homePage.verify_WeightDisclaimerInCheckout();
    }

    @Step
    public void verify_WeightDisclaimerIsPresentInOrderReview() {
        homePage.verify_WeightDisclaimerInOrderReview();
    }

    @Step
    public void verify_WeightDisclaimerIsPresentInEditOrder() {
        homePage.verify_WeightDisclaimerInEditOrder();
    }

    @Step
    public void verify_WeightDisclaimerIsPresentInCart() {
        homePage.verify_WeightDisclaimerInCart();
    }

    @Step
    public void clickListViewIcon() {
        homePage.clickListViewIcon();
    }

    @Step
    public void verify_urlShouldMatchmPerksFilters_ForTier2() {
        homePage.verify_urlShouldMatchmPerksFiltersForTier2();
    }

    @Step
    public void verify_urlShouldMatchSaleFilters_ForTier2() {
        homePage.verify_urlShouldMatchSaleFiltersForTier2();
    }

    @Step
    public void verify_urlShouldMatchmPerksAndSaleFilters_ForTier2() {
        homePage.verify_urlShouldMatchmPerksAndSaleFiltersForTier2();
    }

    @Step
    public void verify_urlShouldMatchSaleFilters_ForTier3() {
        homePage.verify_urlShouldMatchSaleFiltersForTier3();
    }

    @Step
    public void verify_urlShouldMatchSaleFilters_ForTier4() {
        homePage.verify_urlShouldMatchSaleFiltersForTier4();
    }

    @Step
    public void verify_urlShouldMatchBrandFilters_ForTiers() {
        homePage.verify_urlShouldMatchBrandFiltersForTiers();
    }

    @Step
    public void verify_urlShouldMatchmPerksFilters_ForSearch() {
        homePage.verify_urlShouldMatchmPerksFiltersForSearch();
    }

    @Step
    public void verify_urlShouldMatchSaleFilters_ForSearch() {
        homePage.verify_urlShouldMatchSaleFiltersForSearch();
    }

    @Step
    public void verify_urlShouldMatchmPerksAndSaleFilters_ForSearch() {
        homePage.verify_urlShouldMatchmPerksAndSaleFiltersForSearch();
    }

    @Step
    public void user_ClickBrandInLeftNavigation() {
        homePage.click_brandInLeftNavigation();
    }

    @Step
    public void verify_managedContentBlockExists() {
        homePage.managedContentBlockExists();
    }

    @Step
    public void validate_EachProductTileButtonFunctionality() {
        homePage.productTileButtonFunctionality();
        homePage.verifyTotalAddAbleCount();
    }

    @Step
    public void moveToViewPagination() {
        UtilityHelper.moveToViewElement(homePage.PAGINATION);
    }

    @Step
    public void highLightDesiredPageIndex(String pageIndex) {
        homePage.highLightDesiredPageIndex(pageIndex);
    }

    @Step
    public void clickDesiredPageIndex(String pageIndex) {
        homePage.clickDesiredPageIndex(pageIndex);
    }

    @Step
    public void waitUntilPageReLoads() throws InterruptedException {
        homePage.waitUntilPageLoaderVanishes();
    }

    @Step
    public void testCaseFailsDueToBugReport(String bugId) {
        homePage.standByForBugReportIsFixed(bugId);
    }

    @Step
    public void highLightKeepThisStoreButton() {
        if (UtilityHelper.elementExists(homePage.PASSIVE_STORE_DIALOG)) {
            UtilityHelper.highLightElement(homePage.KEEP_STORE);
        }
    }

    @Step
    public void userClicksKeepThisStoreOnPassiveStoreSelectionModal() {
        homePage.userClicksKeepThisStoreOnPassiveStoreSelectionModal();
    }

    @Step
    public void click_emailtest() {
        homePage.click_eemailtestbutton();
    }

    @Step
    public void emailform_check() {
        homePage.email_form();
    }

    @Step
    public void email_firstname(String efirst_name) {
        homePage.ee_firstname(efirst_name);
    }

    @Step
    public void email_lastname(String elast_name) {
        homePage.e_lastname(elast_name);
    }

    @Step
    public void email_e(String eemail) {
        homePage.e_email(eemail);
    }

    @Step
    public void submit_button() {
        homePage.submitbutton();
    }

    @Step
    public void error_invalid() {
        homePage.errorinvalid();
    }

    @Step
    public void error_blank() {
        homePage.errorblank();
    }

    @Step
    public void ver_success() {
        homePage.verifysuccess();
    }

    @Step
    public void verifyPassiveStoreModalIsDisplayed() {
        homePage.verifyPassiveStoreModalIsDisplayed();
    }

    @Step
    public void deleteCookieToSimulateHavingNotSeenPassiveStoreModal() {
        homePage.deleteCookieToSimulateHavingNotSeenPassiveStoreModal();
    }

    @Step
    public void verifyDefaultStoreCookieRemainsUnchanged() {
        homePage.verifyDefaultStoreCookieRemainsUnchanged();
    }

    @Step
    public void verifyDefaultStoreCookieIsSetToStoreName(String storeName) {
        homePage.verifyDefaultStoreCookieIsSetToStoreName(storeName);
    }

    @Step
    public void verifyPassiveStoreCookieIsSet() {
        homePage.verifyPassiveStoreCookieIsSet();
    }

    @Step
    public void grabAndSaveStoreNameFromHeader() {
        homePage.grabAndSaveStoreNameFromHeader();
    }

    @Step
    public void user_ClicksSelectNewsStore_PassiveStoreSelection() {
        homePage.click_SelectNewStore_PassiveStoreSelection();
    }

    @Step
    public void click_keepStore_PassiveStoreSelection() {
        homePage.click_keepStore_PassiveStoreSelection();
    }

    @Step
    public void user_clickOffPassiveStoreSelectionModal() {
        homePage.click_off_PassiveStoreSelectionModal();
    }

    @Step
    public void verifyDefaultStoreCookieMatchesHeader() {
        homePage.verifyDefaultStoreCookieMatchesHeader();
    }

    @Step
    public void chooseDifferentStoreFromAnAlreadyOpenStoreModal() throws InterruptedException {
        homePage.chooseDifferentStoreFromAnAlreadyOpenStoreModal();
    }

    @Step
    public void storeCartID() {
        homePage.storeCartID();
    }

    @Step
    public void verifyCartIdMatchesPreviousCartID() {
        homePage.verifyCartIdMatchesPreviousCartID();
    }

    @Step
    public void verifyCartIdDoesNOTmatchPreviousCartID() {
        homePage.verifyCartIdDoesNOTmatchPreviousCartID();
    }

    @Step
    public void verifyProductsInShoppingCartMatchProductsList() {
        homePage.verifyProductsInShoppingCartMatchProductsList();
    }

    @Step
    public void verifyProductsInMinicartMatchProductsList() {
        homePage.verifyProductsInMinicartMatchProductsList();
    }

    @Step
    public void saveInformationForMinicartHeaderAndReservationHeader() {
        homePage.saveInformationForMinicartHeaderAndReservationHeader();
    }

    @Step
    public void verifyMinicartHeaderAndReservationHeaderMatchPreviousState() {
        homePage.verifyMinicartHeaderAndReservationHeaderMatchPreviousState();
    }

    @Step
    public void user_clicks_on_wayfinding_tiles(String tier2, String tier3) {
        homePage.clicks_on_wayfinding_tiles(tier2, tier3);
    }

    @Step
    public void user_clicks_on_wayfinding_tiles(String tier2) {
        homePage.clicks_on_wayfinding_tiles(tier2);
    }

    @Step
    public void verifyMinicartWidgetShowsZeroItems() {
        homePage.verifyMinicartWidgetShowsZeroItems();
    }

    @Step
    public void verifyMinicartIsEmpty() {
        homePage.verifyMinicartIsEmpty();
    }

    @Step
    public void verifyReservationWidgetShowsSignInToReserveTimeslot() {
        homePage.verifyReservationWidgetShowsSignInToReserveTimeslot();
    }

    @Step
    public void waitUntilWinkbarDissappears() {
        homePage.waitUntilWinkbarDissappears();
    }

    @Step
    public void verifyQuickshopListsAreNotPresent() {
        homePage.verifyQuickshopListsAreNotPresent();
    }

    @Step
    public void verifyUserIsPromptedToLogin() {
        homePage.verifyUserIsPromptedToLogin();
    }

    @Step
    public void verifyUserIsNotPromptedToLogin() {
        homePage.verifyUserIsNotPromptedToLogin();
    }

    @Step
    public void storeSuggestedPurchaseList() {
        homePage.storeSuggestedPurchaseList();
    }

    @Step
    public void storeFrequentPurchasesList() {
        homePage.storeFrequentPurchasesList();
    }

    @Step
    public void storeFrequentPurchasesListViewAll() {
        homePage.storeFrequentPurchasesListViewAll();
    }

    @Step
    public void verifyFrequentPurchasesListMatchesPreviousState() {
        homePage.verifyFrequentPurchasesListMatchesPreviousState();

    }

    @Step
    public void verifyViewAllFrequentPurchasesListMatchesPreviousState() {
        homePage.verifyViewAllFrequentPurchasesListMatchesPreviousState();

    }

    @Step
    public void validateSuggestedPurchasesListMatchesPreviousState() {
        homePage.validateSuggestedPurchasesListMatchesPreviousState();
    }

    @Step
    public void verifyActiveOrderMessageIsNotDisplayedInHeaderWidget() {
        homePage.verifyActiveOrderMessageIsNotDisplayedInHeaderWidget();
    }

    @Step
    public void verifyHeaderWidgetIsNotPresent() {
        homePage.verifyHeaderWidgetIsNotPresent();
    }

    @Step
    public void verifyHeaderWidgetSaysReserveCurbsidePickupTime() {
        homePage.verifyHeaderWidgetSaysReserveCurbsidePickupTime();
    }

    @Step
    public void verifyOrdersPageLoads() {
        homePage.verifyOrdersPageLoads();
    }

    @Step
    public void userClicksViewAllFromFrequentPurchases() {
        homePage.userClicksViewAllFromFrequentPurchases();
    }

    @Step
    public void storeFavoritesList() {
        homePage.storeFavoritesList();
    }

    @Step
    public void validateFavoritesListMatchesPreviousState() {
        homePage.validateFavoritesListMatchesPreviousState();
    }

    @Step
    public void verifyFrequentPurchasesViewAllListMatchesPreviousState() {
        homePage.verifyFrequentPurchasesViewAllListMatchesPreviousState();
    }

    @Step
    public void verifySuggestedPurchasesViewAllListMatchesPreviousState() {
        homePage.verifySuggestedPurchasesViewAllListMatchesPreviousState();
    }

    @Step
    public void verifyFavoritesViewAllListMatchesPreviousState() {
        homePage.verifyFavoritesViewAllListMatchesPreviousState();
    }

    @Step
    public void userClicksDesiredIconOnProductViaQuickShopPage(String icon) {
        homePage.userClicksDesiredIconOnProductViaQuickShopPage(icon);
    }

    @Step
    public void clickOnProductIconViaSearchResults(WebElement element, String icon) {
        homePage.clickOnProductIconViaSearchResults(element, icon);
    }

    @Step
    public void verifySuccessfulActiveOrderDateAndTimeInHeaderWidget() {
        homePage.verifySuccessfulActiveOrderDateAndTimeInHeaderWidget();
    }

    @Step
    public void verifySuccessfulActiveOrderHeaderWidgetForNonCNC_Order() {
        homePage.validateQuickShopLink_Display();
        homePage.validatePastOrderLink_Display();
    }

    @Step
    public void verifyBreadcrumbIsDisplayedBelowTitleAndManagedContent() {
        homePage.verifyBreadcrumbIsDisplayedBelowTitleAndManagedContent();
    }

    @Step
    public void verifyBestSellersCarouselIsDisplayed() {
        homePage.verifyBestSellersCarouselIsDisplayed();
    }

    @Step
    public void userClickOnProductNameInProductTile(){
        homePage.userClickOnProductNameInProductTile();
    }
    @Step
    public void verifyBestSellersCarouselHasTotalOf20Products() {
        homePage.verifyBestSellersCarouselHasTotalOf20Products();
    }

    @Step
    public void userClickViewAllFromBestSellersCarousel() {
        homePage.userClickViewAllFromBestSellersCarousel();
    }

    @Step
    public void verifyViewAllBestSellersPageDisplays() {
        homePage.verifyViewAllBestSellersPageDisplays();
    }
}





