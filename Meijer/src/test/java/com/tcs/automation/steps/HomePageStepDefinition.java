package com.tcs.automation.steps;

import com.tcs.automation.Definition_RunnerClass;
import com.tcs.automation.pages.HomePage;
import com.tcs.automation.steps.serenity.HomePageStepSerenity;
import com.tcs.utilityhelpers.utilityhelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomePageStepDefinition {
    HomePage homePage;
    utilityhelper UtilityHelper;

    @Steps
    HomePageStepSerenity homePageStepSerenity;


    @Then("quick and easy thread.sleep'(.*)' method")
    public static void quickThreadSleepMethod(int seconds) throws InterruptedException {
        String millis = seconds + "000";
        Thread.sleep(Integer.valueOf(millis));
    }

    @Then("clear all array list")
    @Screenshots(disabled = true)
    public void clearAllArrayList() {
        UtilityHelper.clearAllArrayList();
        restartWebDriver();
    }

    @Screenshots(disabled = true)
    private void restartWebDriver() {
        getDriver().quit();
    }

    ////these gift card specific add to cart functions are here as a hack to get around the missing upc data gift cards on the site
    //JoeG 12-5-2016
    @When("user adds '(.*)' of one gift card to cart")
    public void userAddsOneGiftCardToCart(String qty) {
        homePageStepSerenity.user_addsOneGiftCardToCart(qty);
    }

    ////these gift card specific add to cart functions are here as a hack to get around the missing upc data gift cards on the site
    //JoeG 12-5-2016
    @When("user adds '(.*)' different gift cards to cart")
    public void userAddsMultipleGiftCardsToCart(String qty) {
        homePageStepSerenity.user_addsMultipleGiftCardsToCart(qty);
    }

    //JoeG 9-21-2016
    @When("user adds '(.*)' of one product to cart")
    public void userAddsOneProductToCart(String qty) {
        homePageStepSerenity.user_addsOneProductToCart(qty);
    }

    //JoeG 9-21-2016
    @When("user adds '(.*)' different products to cart")
    public void userAddsMultipleProductsToCart(String qty) {
        homePageStepSerenity.user_addsMultipleProductsToCart(qty);
    }

    @Then("execute javaScript - binder.vars.creationLogs")
    public void javaScriptExecuteCreationLog() {
        homePageStepSerenity.javaScriptExecuteCreationLog();
    }

    @When("user searches for '(.*)' product")
    public void userSearchesForProductType(String productType) throws InterruptedException {
        homePageStepSerenity.userSearchesForProductType(productType);
        homePageStepSerenity.highLightSearchIconToViewProducts();
        homePageStepSerenity.clickOnSearchIconToViewProducts();
        homePageStepSerenity.verifySearchResultsDisplay();
    }

    @Then("user searches for '(.*)' in '(.*)' environment")
    public void userSearchesForProductTypeInDesiredEnvironment(String productType, String environment) throws InterruptedException {
        if (environment.equals("DEV") && Definition_RunnerClass.Environment.contains("dev")) {
            homePageStepSerenity.userSearchesForProductType(productType);
            homePageStepSerenity.highLightSearchIconToViewProducts();
            homePageStepSerenity.clickOnSearchIconToViewProducts();
            homePageStepSerenity.verifySearchResultsDisplay();
        }
        if (environment.equals("UAT") && Definition_RunnerClass.Environment.contains("uat")) {
            homePageStepSerenity.userSearchesForProductType(productType);
            homePageStepSerenity.highLightSearchIconToViewProducts();
            homePageStepSerenity.clickOnSearchIconToViewProducts();
            homePageStepSerenity.verifySearchResultsDisplay();
        }
    }

    //JoeG 9-23-2016
    @When("user adds over '(.*)' worth of products to cart")
    public void useraddsItemsToCartUntilPriceIsMet(String price) {
        homePageStepSerenity.user_addsItemsToCartUntilPriceIsMet(price);
    }

    @Then("user records search results")
    public void userRecordsSearchResults() {
        homePageStepSerenity.userRecordsSearchResults();
    }

    @Then("user verifies search results match previous results")
    public void userVerifiesSearchResultsMatchPreviousResults() {
        homePageStepSerenity.userVerifiesSearchResultsMatchPreviousResults();
    }

    //Created By: 107793 12/29/16
    @Then("verify changing from Curbside to Non-Curbside conflict modal appears")
    public void verifyCurbsideToNonCurbsideConflictModal() {
        homePageStepSerenity.verify_CurbsideToNonCurbsideConflictModalAppears();
        homePageStepSerenity.verify_ChangeStoreConflictModalDetails();
    }

    //Created By: 107793 12/30/16
    @Then("user clicks Keep Store button")
    public void userClicksKeepStoreButton() {
        homePageStepSerenity.highLightKeepStoreButton();
        homePageStepSerenity.userClicksKeepStoreButton();
    }

    //Created By: 107793 12/30/16
    @Then("user clicks Continue, Change Store button")
    public void userClicksContinueChangeStore() {
        homePageStepSerenity.highLightContinueChangeStoreButton();
        homePageStepSerenity.userClicksContinueChangeStore();
    }

    @Then("user closes miniCart")
    public void userClosesMiniCart() {
        if (homePage.isMiniCartOpen()) {
            homePageStepSerenity.userClosesMiniCart();
        }
    }

    //Created By: 107793 11/21/16
    @Then("user alters results per page count to '(.*)'")
    public void userAltersResultsPerPageCountTo(int perPg) {
        homePageStepSerenity.user_AltersResultsPerPageCountTo(perPg);
    }

    //Created By: 107793 11/18/16
    @Then("user clicks shop by category option '(.*)' in search results")
    public void userClicksShopByCategoryOptionOnSearchResults(String category) {
        homePageStepSerenity.highLightShopByCategory(category);
        homePageStepSerenity.user_ClicksShopByCategoryOption_SearchResults(category);
    }

    //Created By: 107793 10/17/16
    @Then("user clicks view all form your favorites")
    public void userClicksViewAllOnYourFavorites() {
        homePageStepSerenity.moveToViewYourFavoritesViaQuickShopPage();
        homePageStepSerenity.userClicksViewAllOnYourFavorites();
    }

    @Then("verify display of nutrition label main")
    public void nutri_labelmain() {
        homePageStepSerenity.nutrilabelmain();
    }

    //Created By: 107793 10/27/16
    @Then("verify product details in meta description")
    public void verify_productDetailsInMetaDescription() {
        homePageStepSerenity.productDetailsInMetaDescription();
    }

    //Created By: 107793 10/5/16
    @Then("verify display of PDP page")
    public void verifyPDP_pageDisplays() {
        homePageStepSerenity.verifyPDP_Displays();
    }

    @Then("click PLUS quantity stepper on pdp page")
    public void clickPlusQuantityStepperOnPdpPage() {
        homePageStepSerenity.clickPlusQuantityStepperOnPdpPage();
    }

    @Then("click MINUS quantity stepper on pdp page")
    public void clickMinusQuantityStepperOnPdpPage() {
        homePageStepSerenity.clickMinusQuantityStepperOnPdpPage();
    }

    @Then("verify value in quantity field on pdp page is 1")
    public void verifyValueInQuantityFieldOnPdpPageIsOne() {
        homePageStepSerenity.verifyValueInQuantityFieldOnPdpPageIsOne();
    }

    @Then("verify the quantity in the input field on pdp page matches the quantity in the winkbar")
    public void verifyTheQuantityInTheInputFieldOnPdpPageMatchesTheQuantityInTheWinkbar() {
        homePageStepSerenity.verifyTheQuantityInTheInputFieldOnPdpPageMatchesTheQuantityInTheWinkbar();
    }

    @Then("click add to cart button on pdp page")
    public void clickAddToCartButtonOnPdpPage() {
        homePageStepSerenity.clickAddToCartButtonOnPdpPage();
    }

    @Then("verify error Please enter increments of stepsize")
    public void verifyQtyStepperError() {
        homePageStepSerenity.verifyQtyStepperError();
    }

    @Then("verify add to cart button is disabled on pdp page")
    public void verifyAddToCartDisabledOnPdp() {
        homePageStepSerenity.verifyAddToCartDisabledOnPdp();
    }


    @Then("verify quantity field displays errors on pdp page")
    public void verifyQuantityFieldDisplaysErrorsOnPdpPage() {
        homePageStepSerenity.verifyQuantityFieldDisplaysErrorsOnPdpPage();
    }

    @Then("type (.*) into quantity field on pdp page")
    public void typeAmountIntoQuantityFieldOnPdpPage(String qty) {
        homePageStepSerenity.typeAmountIntoQuantityFieldOnPdpPage(qty);
    }

    @Then("click MINUS quantity stepper on pdp page and verify quantity in quantity field goes down by 1")
    public void verifyQuantityInQuantityFieldGoesDownBy1() {
        homePageStepSerenity.verifyQuantityInQuantityFieldGoesDownBy1();
    }

    @Then("click PLUS quantity stepper on pdp page and verify quantity in quantity field goes up by 1")
    public void verifyQuantityInQuantityFieldGoesUpBy1() {
        homePageStepSerenity.verifyQuantityInQuantityFieldGoesUpBy1();
    }


    @Then("verify quantity does not go below step quantity")
    public void verifyQuantityDoesNotGoBelowStepQuantity() {
        homePageStepSerenity.verifyQuantityDoesNotGoBelowStepQuantity();
    }

    @Then("verify wayfinding is displayed in all tier2 for corresponding tier1")
    public void verifywayfindingtier2fortier1() throws InterruptedException {
        homePageStepSerenity.verifywayfindingtier2();
    }

    /*------------------------Health and Wellness--------------------------------*/
    //siva
    @Then("validate for all upc having HW ingredient and warnings")
    public void verifyingreditentWarningsforallupc() throws IOException, InterruptedException {
        homePageStepSerenity.verify_upc_ingreditent_warning();
    }


    //Created By: 108588 11/15/16
    @Then("verify nutritional attributes are displayed")
    public void verifyNutritionalAttributesDisplayed() {
        homePageStepSerenity.verifyNutritionalAttributes_Displayed();
    }

    @Then("verify claims are displayed")
    public void verifyclaimsDisplayed() {
        homePageStepSerenity.verifyclaims_Displayed();
    }

    //Created By: 108588 11/15/16
    @Then("verify nutritional attributes are not displayed")
    public void verifyNutritionalAttributesNotDisplayed() {
        homePageStepSerenity.verifyNutritionalAttributes_NotDisplayed();
    }

    @Then("verify No claims are displayed")
    public void verifyclaimsNotDisplayed() {
        homePageStepSerenity.verifyclaims_NotDisplayed();
    }

    //Created By: 108588 11/17/16
    @Then("verify disclaimers displayed before nutritional details")
    public void verifyDisclaimersDisplayedBeforeNutritionalDetails() {
        homePageStepSerenity.verifyDisclaimersDisplayedBeforeNutritionalDetails();
    }

    //Created By: 108588 11/17/16
    @Then("verify nutritional attributes displayed before ingredients")
    public void verifyNutritionalAttributesDisplayedBeforeIngredients() {
        homePageStepSerenity.verifyNutritionalAttributesDisplayedBeforeIngredients();
    }


    //Created By: 108588 11/17/16
    @Then("verify nutritional attributes displayed before warnings")
    public void verify_NutritionalAttributesDisplayedBeforeWarnings() {
        homePageStepSerenity.verifyNutritionalAttributesDisplayedBeforeWarnings();
    }

    //Created by: 108558 12/5/16
    @Then("verify nutritional attributes displayed before disclaimers")
    public void verify_NutritionalAttributesDisplayedBeforeDisclaimers() {
        homePageStepSerenity.verifyNutritionalAttributesDisplayedBeforeDisclaimers();
    }

    //Created by: 108558 12/5/16
    @Then("verify nutritional attributes displayed before nutritional details")
    public void verify_NutritionalAttributesDisplayedBeforeNutritionalDetails() {
        homePageStepSerenity.verifyNutritionalAttributesDisplayedBeforeNutritionalDetails();
    }

    //Created By: 1085889 11/17/16
    @Then("verify there are no more than 12 attributes displayed")
    public void verifyNoMoreThan12AttributesDisplayed() {
        homePageStepSerenity.verifyNoMoreThan12Attributes_Displayed();
    }

    @Then("verify nutritional attributes '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void verifyNutritionalAttributes(String att1, String att2, String att3, String att4, String att5, String att6, String att7, String att8, String att9, String att10, String att11, String att12) {
        homePageStepSerenity.verifyNutritional_Attributes(att1, att2, att3, att4, att5, att6, att7, att8, att9, att10, att11, att12);
    }

    //Created By: 108588 11/15/16
    @Then("verify product ingredients are displayed")
    public void verifyProductIngredientsDisplayed() {
        homePageStepSerenity.verifyProductIngredients_Displayed();
    }

    //Created By: 108588 11/15/16
    @Then("verify product ingredients are not displayed")
    public void verifyProductIngredientsNotDisplayed() {
        homePageStepSerenity.verifyProductIngredients_NotDisplayed();
    }

    @Then("verify No product ingredients are not displayed")
    public void verifynoingredients() {
        homePageStepSerenity.verifyno_Ingredients();
    }

    @Then("verify  No product ingredients are not displayed")
    public void verifyIngredientsNotDisplayed() {
        homePageStepSerenity.verifyIngredients_NotDisplayed();
    }


    //Created By: 108588 11/17/16
    @Then("verify product ingredients displayed before warnings")
    public void verifyProductIngredientsDisplayedBeforeWarnings() {
        homePageStepSerenity.verifyProductIngredientsDisplayedBeforeWarnings();
    }

    //Created by: 108558 12/13/16
    @Then("verify product ingredients displayed before disclaimers")
    public void verifyProductIngredientsDisplayedBeforeDisclaimers() {
        homePageStepSerenity.verifyProductIngredientsDisplayedBeforeDisclaimers();
    }

    //Created by: 108558 12/13/16
    @Then("verify product ingredients displayed before nutrition details")
    public void verifyProductIngredientsDisplayedBeforeNutritionDetails() {
        homePageStepSerenity.verifyProductIngredientsDisplayedBeforeNutritionDetails();
    }

    //Created by: 108558 12/13/16
    @Then("verify product warnings displayed before disclaimers")
    public void verifyProductWarningsDisplayedBeforeDisclaimers() {
        homePageStepSerenity.verifyProductWarningsDisplayedBeforeDisclaimers();
    }

    //Created By: 108588 11/15/16
    @Then("verify product warnings are displayed")
    public void verifyProductWarningsDisplayed() {
        homePageStepSerenity.verifyProductWarnings_Displayed();
    }

    //Created By: 108588 11/15/16
    @Then("verify product warnings are not displayed")
    public void verifyProductWarningsNotDisplayed() {
        homePageStepSerenity.verifyProductWarnings_NotDisplayed();
    }

    @Then("verify No product warnings are displayed")
    public void verifyWarningsNotDisplayed() {
        homePageStepSerenity.verifyWarnings_NotDisplayed();
    }

    //Created By: 108588 12/1/16
    @Then("verify copy matches noncollapse legal disclaimer1")
    public void verifyCopyMatchesNoncollapseLegalDisclaimer1() {
        homePageStepSerenity.verifyCopy_MatchesNoncollapseLegalDisclaimer1();
    }

    @Then("user clicks show more disclaimer")
    public void userClicksShowMoreDisclaimer() {
        homePageStepSerenity.userClicksShowMore_Disclaimer();
    }

    //Created By: 108588 12/1/16
    @Then("verify copy matches collapse legal disclaimer1")
    public void verifyCopyMatchesCollapseLegalDisclaimer1() {
        homePageStepSerenity.verifyCopy_MatchesCollapseLegalDisclaimer1();
    }

    //Created By: 108588 12/1/16
    @Then("verify copy matches noncollapse legal disclaimer2")
    public void verifyCopyMatchesNoncollapseLegalDisclaimer2() {
        homePageStepSerenity.verifyCopy_MatchesNoncollapseLegalDisclaimer2();
    }

    //Created By: 108588 12/1/16
    @Then("verify copy matches collapse legal disclaimer2")
    public void verifyCopyMatchesCollapseLegalDisclaimer2() {
        homePageStepSerenity.verifyCopy_MatchesCollapseLegalDisclaimer2();
    }

    //Created By: 108588 11/28/16
    @Then("verify product warnings displayed before nutrition details")
    public void verifyProductWarningsDisplayedBeforeNutritionDetails() {
        homePageStepSerenity.verifyProductWarningsDisplayedBeforeNutritionDetails();
    }

    //Created By: 108588 12/5/16
    @Then("verify nutritional details panel displayed before nutritional label header")
    public void verifyNutritionalDetailsPanelDisplayedBeforeNutritionalLabelHeader() {
        homePageStepSerenity.verifyNutritionalDetailsPanelDisplayedBeforeNutritionalLabelHeader();
    }

    //Created By: 108588 12/1/16
    @Then("verify nutrition Label header displayed before nutrition label main")
    public void verifyNutritionLabelHeaderDisplayedBeforeNutritionLabelMain() {
        homePageStepSerenity.verifyNutritionLabelHeaderDisplayedBeforeNutritionLabelMain();
    }

    //Created By: 108588 12/1/16
    @Then("verify header heading displays Nutrition Facts")
    public void verifyHeaderHeadingDisplaysNutritionFacts() {
        homePageStepSerenity.verifyHeaderHeading_DisplaysNutritionFacts();
    }

    @Then("verify Nutrition details are displayed")
    public void verifynutritiondetailsdisplay() {
        homePageStepSerenity.verifynutritiondetails();
    }

    @Then("verify Nutrition header are displayed")
    public void verifynutritionheader() {
        homePageStepSerenity.verifynutritionheader();
    }


    //Created By: 108588 12/1/16
    @Then("verify servings per container is displayed and reflects correct data '(.*)'")
    public void verifyServingsPerContainerIsDisplayedAndReflectsCorrectData(String servingsPerContainer) {
        homePageStepSerenity.verifyServingsPerContainerIs_DisplayedAndReflectsCorrectData(servingsPerContainer);
    }

    //Created By: 108588 12/1/16
    @Then("verify serving size is displayed and reflects correct data '(.*)' '(.*)'")
    public void verifyServingSizeIsDisplayedAndReflectsCorrectData(String servingSize1, String servingSize2) {
        homePageStepSerenity.verifyServingSizeIs_DisplayedAndReflectsCorrectData(servingSize1, servingSize2);
    }

    //Created By: 108588 12/1/16
    @Then("verify calorie count is displayed and reflects correct data '(.*)'")
    public void verifyCalorieCountIsDisplayedAndReflectsCorrectData(String calorieCount) {
        homePageStepSerenity.verifyCalorieCountIs_DisplayedAndReflectsCorrectData(calorieCount);
    }

    //Created By: 108588 12/1/16
    @Then("verify calories from fat is displayed and reflects correct data '(.*)'")
    public void verifyCaloriesFromFatIsDisplayedAndReflectsCorrectData(String caloriesFromFat) {
        homePageStepSerenity.verifyCaloriesFromFatIs_DisplayedAndReflectsCorrectData(caloriesFromFat);
    }

    //Created By: 108588 12/7/16
    @Then("Verify Nutritional Main are displayed")
    public void verifyDisplayOfNutriLabelMain() {
        homePageStepSerenity.verifyDisplay_OfNutriLabelMain();
    }

    @Then("verify the static footer is displayed")
    public void verifystaticfooter() {
        homePageStepSerenity.verifystatic_footer();
    }


    //Created By: 108588 12/7/16
    @Then("validate nutrition label main data '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void validateNutritionLabelMainData(String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9, String item10, String item11, String item12, String item13, String item14, String item15, String item16) {
        homePageStepSerenity.validateNutritionLabelMain_Data(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16);
    }

    //Created By: 108588 12/5/16
    @Then("verify nutrition label main displayed before nutrition label micronutrients")
    public void NutritionLabelMainDisplayedBeforeNutritionLabelMicronutrients() {
        homePageStepSerenity.verifyNutritionLabelMainDisplayedBeforeNutritionLabelMicronutrients();
    }

    @Then("Verify Nutritional Micronutrients are displayed")
    public void NutritionLabelMicronutrients() {
        homePageStepSerenity.verifyNutritionLabelMicronutrients();
    }

    //Created By: 108588 12/1/16
    @Then("verify nutrition label micronutrients displayed before Nutrition label footer")
    public void verifyNutritionLabelMicronutrientsDisplayedBeforeNutritionLabelFooter() {
        homePageStepSerenity.verifyNutritionLabelMicronutrientsDisplayedBeforeNutritionLabelFooter();
    }

    //Created By: 108588 12/1/16
    @Then("validate mandatory micronutrients are displayed")
    public void validateMandatoryMicronutrientsAreDisplayed() {
        homePageStepSerenity.validateMandatoryMicronutrientsAre_Displayed();
    }


    //Created By: 108588 12/1/16
    @Then("verify tiles for calories Fat Carbs Protein")
    public void verifyTilesForCaloriesFatCarbsProtein() {
        homePageStepSerenity.verifyTilesFor_CaloriesFatCarbsProtein();
    }

    //Created By: 108588 12/1/16
    @Then("validate data in each tile is correct data '(.*)' '(.*)' '(.*)' '(.*)'")
    public void validateDataInEachTileIsCorrectData(String cal, String fat, String carbs, String protein) {
        homePageStepSerenity.validateDataInEachTileIs_CorrectData(cal, fat, carbs, protein);
    }

    //Created By: 108588 12/1/16
    @Then("verify no nutritional data displayed")
    public void verifyNoNutritionalDataDisplayed() {
        homePageStepSerenity.verifyNoNutritionalData_Displayed();
    }


    /*----------------------End of Health and Wellness--------------------------------------*/

    //Created By: 107793 10/17/16
    @Then("verify h1 tag on product name")
    public void verifyH1TagsOnProductNamePDP() {
        homePageStepSerenity.verifyH1TagsOnProductNamePDP();
    }

    //Created By: 107793 10/17/16
    @Then("verify alt tags on product image on PDP")
    public void verifyAltTagsOnProductImagePDP() {
        homePageStepSerenity.verifyAltTagsOnProductImagePDP();
    }

    //Created By: 107793 10/17/16
    @Then("verify title windows tab on PDP")
    public void verifyWindowTabTitleOn_PDP() {
        homePageStepSerenity.verifyWindowTabTitle_PDP();
    }

    //Created By: 107793 10/5/16
    @Then("verify removal of copy on PDP page")
    public void verifyRemovalOfCopyOnPDP_page() {
        homePageStepSerenity.verifyCopyRemovalOnPDP_page();
    }

    @Then("verify 'price less than map' copy on PDP page")
    public void verifyPriceLessThanMapCopyOnPDP() {
        homePageStepSerenity.verifySeePriceInCartCopyOnPDP();
    }

    //Created By: 107793 10/5/16
    @Then("verify removal of 'Find a Store Near You' if e-comm flag is off")
    public void verifyCopyRemoval_eCommFlagOff() {
        homePageStepSerenity.verifyCopyRemoval_eCommFlagOff();
    }

    //Created By: 107793 10/6/16
    @Then("verify removal of 'Add to Cart' button for Out of Stock item")
    public void verifyRemovalOfAddToCardButton() {
        homePageStepSerenity.verifyRemoval_AddToCartButton_OutOfStockItem();
    }

    //Created By: 107793 10/6/16
    @Then("verify h3 tags for product name")
    public void verifyH3TagsForProductName() {
        homePageStepSerenity.h3TagsForProductName();
    }

    //Created By: 107793 10/17/16
    @Then("verify h1 tag on category name")
    public void verifyH1TagOnCategoryName() {
        homePageStepSerenity.verifyH1Tag_CategoryName();
    }

    //Created By: 107793 10/15/16
    @Then("verify alt tags on product images")
    public void verifyAltTagsForProductImages() {
        homePageStepSerenity.altTagsForProductImages();
    }

    //Created By: 107793 10/15/16
    @Then("user verify look and feel of breadcrumbs")
    public void verifyBreadcrumbs() {
        homePageStepSerenity.lookAndFeelBreadcrumbs();
    }

    //Created By: 107793 1/23/17
    @Then("user clicks Keep this Store on passive store selection modal")
    public void userClicksKeepThisStoreOnPassiveStoreSelectionModal() {
        if (UtilityHelper.elementExists(homePage.PASSIVE_STORE_DIALOG)) {
            homePageStepSerenity.verifyPassiveStoreModalIsDisplayed();
            homePageStepSerenity.highLightKeepThisStoreButton();
            homePageStepSerenity.userClicksKeepThisStoreOnPassiveStoreSelectionModal();
        }
    }

    @Then("user selects Keep this Store on passive store selection modal")
    public void click_keepStore_PassiveStoreSelection() {
        homePageStepSerenity.click_keepStore_PassiveStoreSelection();
    }

    @Then("click on the email test")
    public void clickemailtest() {
        homePageStepSerenity.click_emailtest();
    }

    @Then("email test form display")
    public void emailform() {
        homePageStepSerenity.emailform_check();
    }

    @Then("enter firstname '(.*)'")
    public void firstname_email(String efirst_name) {
        homePageStepSerenity.email_firstname(efirst_name);
    }

    @Then("enter lastname '(.*)'")
    public void lastname_email(String elast_name) {
        homePageStepSerenity.email_lastname(elast_name);
    }

    @Then("enter email '(.*)'")
    public void e_email(String eemail) {
        homePageStepSerenity.email_e(eemail);
    }

    @Then("click on emailtest submit button")
    public void submitbutton() {
        homePageStepSerenity.submit_button();
    }

    @Then("verify the success status message")
    public void ver_succes() {
        homePageStepSerenity.ver_success();
    }

    @Then("verify the error message for invalid")
    public void verifyerror_invalid() {
        homePageStepSerenity.error_invalid();
    }

    @Then("verify the error message for blank")
    public void verifyerror_blank() {
        homePageStepSerenity.error_blank();
    }

    @Then("user clicks x to close sign in modal")
    public void clickXtoCloseSignInModal() {
        homePageStepSerenity.highLightXtoCloseSignInModal();
        homePageStepSerenity.clickXtoCloseSignInModal();
    }

    @Then("Meijer Home page displays User is signed in successfully")
    public void meijerHomePageDisplayUserIsSignedInSuccessfully() throws InterruptedException {
        homePageStepSerenity.meijer_HomePageDisplayUserIsSignedInSuccessfully();
    }

    @Then("verify SSI token exists")
    public void verifySSItokenExists() {
        homePageStepSerenity.verifySSItokenExists();
    }


    @Then("verify SSI token does NOT exist")
    public void verifySSItokenDoesNotExist() {
        homePageStepSerenity.verifySSItokenDoesNotExist();
    }


    @Then("verify user has no active order")
    public void verifyUserHasNoActiveOrder() {
        homePageStepSerenity.verify_UserHasNoActiveOrder();
    }

    //Created By: 107793 11/02/16
    @Then("Meijer Home page displays for Guest user")
    public void meijerHomePageDisplay() throws InterruptedException {
        homePageStepSerenity.meijerHomePageDisplay();
    }

    @Then("validate shipping rate for '(.*)' with shipping method '(.*)'")
    public void validateGiftCardRate(String priceORqty, String shippingMethod) throws IOException, InterruptedException {
        homePageStepSerenity.validateGiftCardRate(priceORqty, shippingMethod);
    }

    @Then("validate giftcard only order has zero taxes")
    public void validateZeroTaxesForGiftCardOnlyOrder() {
        homePageStepSerenity.validateZeroTaxesForGiftCardOnlyOrder();
    }

    @Then("user pokes at gift card rates")
    public void userPokesAtGiftCardRates() throws IOException, InterruptedException {
        homePageStepSerenity.userPokesAtGiftCardRates();
    }

    @Then("click Cart Icon in Header and click View Cart")
    public void clickCartIconInHeaderAndClickViewCart() {
        homePageStepSerenity.clickCartIconInHeaderAndClickViewCart();
    }

    @Then("user clicks Checkout button via Mini-Cart")
    public void userClicksCheckOutButtonViaMinCart() {
        homePageStepSerenity.highLightCheckOutButtonViaMiniCart();
        homePageStepSerenity.userClicksCheckOutButtonViaMiniCart();
    }

    @Then("user clicks sort product name by A-Z")
    public void userClicksSortByNameLowToHigh() {
        homePageStepSerenity.user_ClicksSortByNameLowToHigh();
    }

    @Then("user clicks sort product name by Z-A")
    public void userClicksSortByNameHighToLow() {
        homePageStepSerenity.user_ClicksSortByNameHighToLow();
    }


    @Then("user clicks sort product price low to high")
    public void userClicksSortByPriceLowToHigh() {
        homePageStepSerenity.user_ClicksSortByPriceLowToHigh();
    }

    @Then("user clicks sort product price high to low")
    public void userClicksSortByPriceHighToLow() {
        homePageStepSerenity.user_ClicksSortByPriceHighToLow();
    }


    @Then("verify product '(.*)' is sorted '(.*)'")
    public void verifyProductsAreSorted(String sortWhat, String sortType) {
        homePageStepSerenity.user_verifiesProductsAreSorted(sortWhat, sortType);
    }

    @Then("user opens mini-cart")
    public void userOpensMiniCart() {
        if (!homePage.isMiniCartOpen()) {
            homePageStepSerenity.moveToViewMiniCartIcon();
            homePageStepSerenity.highLightCartIcon();
            homePageStepSerenity.userOpensMiniCart();
            homePageStepSerenity.verifyMiniCartHasLoaded();
        }
    }

    @Then("navigate to next page of product list")
    public void navigateToNextPageOfProductList() throws InterruptedException {
        homePageStepSerenity.navigate_ToNextPageOfProductList();
    }

    @Then("user click Edit link in Curbside Widget")
    public void userClickEditLinkInCurbsideWidget() {
        homePageStepSerenity.user_ClickEditLinkInCurbsideWidget();
    }

    @Then("user click View link in Curbside Widget")
    public void userClickViewLinkInCurbsideWidget() {
        homePageStepSerenity.user_ClickViewLinkInCurbsideWidget();
    }

    @Then("In Curbside Widget, user clicks Reserve Curbside Pickup Time")
    public void userReserveCurbsidePickupTimeCurbsideWidget() {
        homePageStepSerenity.highLightReserveCurbsidePickupTimeWidget();
        homePageStepSerenity.userReserveCurbsidePickupTimeCurbsideWidget();
    }

    @Then("In Curbside Widget validate the reserved pickup time display correct")
    public void validateReservedPickupTimeDisplayCorrectInCurbsideWidget() {
        homePageStepSerenity.validate_ReservedPickupTimeDisplayCorrectInCurbsideWidget();
    }

    @Then("In Curbside Widget validate the newly reserved pickup time display correct")
    public void validateNewReservedPickupTimeDisplayInCurbsideWidget() {
        homePageStepSerenity.validate_NewReservedPickupTimeInCurbsideWidget();
    }

    @Then("In Curbside Widget validate active order is display correct")
    public void validateActiveOrderInCurbsideWidget() {
        homePageStepSerenity.validate_ActiveOrderInCurbsideWidget();
    }

    @Then("validate item was not added via Cart Icon and slot still reserved '(.*)'")
    public void validate_itemNotAddedAndSlotStillReserved(String expCount) {
        homePageStepSerenity.validate_itemNotAddedAndSlotReserved(expCount);
    }

    @Then("validate item was added via Cart Icon and reserved slot is dropped '(.*)'")
    public void validate_itemAddedAndReservedSlotDropped(String expCount) {
        homePageStepSerenity.validate_itemAddedAndReservationDropped(expCount);
    }

    @Then("In Curbside Widget edit reserve curbside pickup time")
    public void editReserveCurbsidePickupTimeInCurbsideWidget() {
        homePageStepSerenity.editReserveCurbsidePickupTimeInCurbsideWidget();
    }

    @Then("user close edit pickup time modal")
    public void userCloseEditPickupTimeModal() {
        homePageStepSerenity.userCloseEditPickupTimeModal();
    }

    @Then("validate pickup time modal - Without Reservation")
    public void validatePickupTimeModalDisplays_WithoutReservation() {
        homePageStepSerenity.validate_pickupTimeModal_WithoutReservation();
    }

    @Then("validate pickup time modal - SPO - Without Reservation")
    public void validatePickupTimeModal_SPO_WithoutReservation() {
        homePageStepSerenity.validate_pickupTimeModal_SPO_WithoutReservation();
    }

    @Then("validate pickup time modal - Mixed Cart - Without Reservation")
    public void validatePickupTimeModal_MixedCart_WithoutReservation() {
        homePageStepSerenity.validate_pickupTimeModal_MixedCart_WithoutReservation();
    }

    @Then("validate pickup time modal - With Reservation")
    public void validatePickupTimeModalDisplay_WithReservation() {
        homePageStepSerenity.validate_pickupTimeModal_WithReservation();
    }

    @Then("validate pickup time modal - With Updating Reservation")
    public void validatePickupTimeModalDisplay_WithUpdatingReservation() {
        homePageStepSerenity.validate_pickupTimeModal_WithUpdatingReservation();
    }

    @Then("user updates reservation pickup time")
    public void userUpdatesReservationPickupTime() throws InterruptedException {
        homePageStepSerenity.updateReservationPickupTime();
    }

    @Then("validate adding SPO item warning message display")
    public void validate_addingSPOitemWarningMessage() {
        homePageStepSerenity.addingItemWarningMessage_SPO();
    }

    @Then("validate item warning message not display")
    public void validate_ItemWarningMessageNotDisplayed() {
        homePageStepSerenity.validateItemWarningMasNotDisplayed();
    }

    @Then("validate adding CNC item warning message display")
    public void validate_addingCurbsideItemWarningMessage() {
        homePageStepSerenity.addingItemWarningMessage_CNC();
    }

    @Then("user clicks leave out of cart button")
    public void clickLeaveOutOfCartButton() {
        homePageStepSerenity.clickLeaveOutOfCartButton();
    }

    @Then("user clicks continue, add item to cart button")
    public void clickContinueAddItemToCart() throws InterruptedException {
        homePageStepSerenity.clickContinueAddItemToCart();

    }

    //Created By: 107793 12/27/16
    @Then("validate cart update and reserved slot is dropped")
    public void validateCartUpdateAndReservedSlotDropped() {
//        homePageStepSerenity.cartUpdateViaSlotTypeConflictMsg_AddItem();
        homePageStepSerenity.reservedTimeSlotIsDropped();
    }

    @Then("validate homepage display 0 item in Cart")
    public void validateHomepageDisplay0ItemInCart() {
        homePageStepSerenity.validateHomepageDisplay0ItemInCart();
    }

    @Then("validate Meijer homepage display Edit and View Order text links under curbside widget")
    public void validateMeijerHomepageDisplayActiveOrderPickupTimeUnderCurbsideWidget() {
        homePageStepSerenity.validateMeijerHomepageDisplayActiveOrderPickupTimeUnderCurbsideWidget();
    }

    //TODO: Reg4.1 - Remove items via Shopping Cart temp fix.
    @Then("validate and reset shopping cart to 0 item")
    public void validateAndResetShoppingCartTo0Item() {
//        homePageStepSerenity.validate_AndResetShoppingCartTo0Item();      //does not work because minicart count doesnt update, or updates slow. faster just to use the minicart clear function JoeG 11-30-2016
        homePageStepSerenity.resetShoppingCartTo0Item_miniCart();
    }

    //Created By: 107793 11/19/16
    @Then("user removes all '(.*)' items from mini-cart")
    public void userRemovesAllFulfillmentTypeFromMiniCart(String fGroup) {
        homePageStepSerenity.user_RemovesAllFulfillmentTypeFromMiniCart(fGroup);
    }

    //Created By: 107793 11/19/16
    @Then("reset shopping cart to 0 item - mini cart")
    public void resetShoppingCartTo0Item_miniCart() {
        homePageStepSerenity.resetShoppingCartTo0Item_miniCart();
    }


    @Then("user Browse through Shop and select Create a Cake")
    public void userBrowsethroughShopAndSelectCreateACake() throws InterruptedException {
        homePageStepSerenity.user_BrowsethroughShopAndSelectCreateACake();
    }

    @Then("custom Cake Landing page display")
    public void customCakeLandingpageDisplay() throws InterruptedException {
        homePageStepSerenity.custom_CakeLandingpageDisplay();
    }

    @Then("user Click Create This Cake on a Theme Cake")
    public void userClickCreateThisCakeonaThemeCake() {
        homePageStepSerenity.user_ClickCreateThisCakeonaThemeCake();
    }

    @Then("user click Create This Cake for the selected category")
    public void userClickCreateThisCakeForTheSelectedCategory() {
        homePageStepSerenity.user_ClickCreateThisCakeForTheSelectedCategory();
    }

    @Then("user Select mandatory attributes on Custom Cake '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userSelectMandatoryAttributesonCustomCake(int indexofsize, int indexofflavor, int icingIdxFrostType, int icingIdxFrostFlvr) throws InterruptedException {
        homePageStepSerenity.user_SelectMandatoryAttributesonCustomCake(indexofsize, indexofflavor, icingIdxFrostType, icingIdxFrostFlvr);
    }

    @Then("select Mandatory Attribute for Special Occassion Cake '(.*)' '(.*)' '(.*)' '(.*)'")
    public void selectMandatoryAttribute_SpecialOccassionCake(int indexofsize, int indexofflavor, int icingIdxFrostType, int icingIdxFrostFlvr) throws InterruptedException {
        homePageStepSerenity.select_MandatoryAttribute_SpecialOccassionCake(indexofsize, indexofflavor, icingIdxFrostType, icingIdxFrostFlvr);
    }

    @Then("select optional attributes on Custom Cake '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void selectOptionalAttributesOnCustomCake(int idxfilling, int idxtopbordrclr, int idxbtmbordrclr, String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePageStepSerenity.select_OptionalAttributesOnCustomCake(idxfilling, idxtopbordrclr, idxbtmbordrclr, txtcustmsg, idxcustmsgclr, txtspcInstrmsg);
    }

    @Then("user click on Add to Cart for design cake")
    public void userClickOnAddToCartForDesignCake() {
        homePageStepSerenity.user_ClickOnAddToCartForDesignCake();
    }

    @Then("user select Cupcake Cake from LHS navigation")
    public void userSelectCupcakeCakefromLHSNavigation() {
        homePageStepSerenity.user_SelectCupcakeCakefromLHSNavigation();
    }

    @Then("user select Special Occasions - Graduation option from LHS navigation")
    public void userSelectSpecialOccasionsGraduationOptionFromLHSNavigation() {
        homePageStepSerenity.user_SelectSpecialOccasionsGraduationOptionFromLHSNavigation();
    }

    @Then("select Cupcake Cake optional attributes '(.*)' '(.*)' '(.*)'")
    public void selectCupcakeCakeOptionalAttributes(String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePageStepSerenity.select_CupcakeCakeOptionalAttributes(txtcustmsg, idxcustmsgclr, txtspcInstrmsg);
    }

    @Then("select special occasions cake optional attributes '(.*)' '(.*)' '(.*)' '(.*)'")
    public void selectSpecialOccasionsCakeOptionalAttributes(int idxfilling, String txtcustmsg, int idxcustmsgclr, String txtspcInstrmsg) throws InterruptedException {
        homePageStepSerenity.select_SpecialOccasionsCakeOptionalAttributes(idxfilling, txtcustmsg, idxcustmsgclr, txtspcInstrmsg);
    }

    @Then("click on questionmark and verify tooltip")
    public void clicktooltipnverify() {
        homePageStepSerenity.click_tooltipandverify();
    }

    //Created By: 107793 11/04/16
    @Then("user add '(.*)' product via PDP page")
    public void user_addsQtyOfProductPDP(String qty) {
        homePageStepSerenity.clickAddToCartViaPDP(qty);
    }


    @Then("user adds 'choking hazard' item with qty '(.*)'")
    public void addsChokingHazardItemToCart(String itemQty) throws InterruptedException {
        quickThreadSleepMethod(3);
        String availability;
        boolean isChokingHazard;
        WebElement hazardousItem;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + UtilityHelper.popShuffledList() + "]"));

            hazardousItem = element.findElement(By.xpath(".//input[@name='chokingHazardDetails']"));
            isChokingHazard = UtilityHelper.elementGetAttribute(hazardousItem, "value").contains("Small Parts");

            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore") || !isChokingHazard) {
                continue;
            }

            homePageStepSerenity.atRandomMoveToViewProduct(element);
            homePageStepSerenity.attemptToAddChokingHazardItemToCart(element, itemQty);
            break;
        }
    }

    //Created By: 107793 11/04/16
    @Then("user verify tool tip error messaging via PDP page '/EA'")
    public void userVerifyToolTipErrorMessagingEachesPDP() {
        homePageStepSerenity.user_VerifyToolTipErrorMessagingEaches_PDP();
    }

    //Created By: 107793 11/04/16
    @Then("user verify tool tip error messaging via PDP page '/LB'")
    public void userVerifyToolTipErrorMessagingWeightPDP() {
        homePageStepSerenity.user_VerifyToolTipErrorMessagingWeight_PDP();
    }

    /**
     * @param productType: outOfStock, inStoreOnly, chokingHazard
     */
    @Then("at random, click on an '(.*)' product to view its PDP")
    public void atRandomClickOnProductToViewPDP(String productType) throws InterruptedException {
        quickThreadSleepMethod(3);
        boolean isChokingHazard;
        WebElement hazardousItem;
        String productAvailability;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + UtilityHelper.popShuffledList() + "]"));
            productAvailability = UtilityHelper.elementGetAttribute(element, "class");
            hazardousItem = element.findElement(By.xpath(".//input[@name='chokingHazardDetails']"));
            isChokingHazard = UtilityHelper.elementGetAttribute(hazardousItem, "value").contains("Small Parts");
            UtilityHelper.moveToViewElement(element);
            boolean outOfStock = productAvailability.contains("unavailable");
            boolean inStoreOnly = productAvailability.contains("instore");

            // OUT OF STOCK
            if (outOfStock && productType.toUpperCase().equals("OUTOFSTOCK")) {
                homePageStepSerenity.atRandomMoveToViewProduct(element);
                homePageStepSerenity.clickOnProductToViewItsPDP(element);
                productType = null;
                break;
            }
//             IN STORE ONLY
            if (inStoreOnly && productType.toUpperCase().equals("INSTOREONLY")) {
                homePageStepSerenity.atRandomMoveToViewProduct(element);
                homePageStepSerenity.clickOnProductToViewItsPDP(element);
                productType = null;
                break;
            }
//             CHOKING HAZARD
            if (isChokingHazard && productType.toUpperCase().equals("CHOKINGHAZARD") && !(outOfStock || inStoreOnly)) {
                homePageStepSerenity.atRandomMoveToViewProduct(element);
                homePageStepSerenity.clickOnProductToViewItsPDP(element);
                productType = null;
                break;
            }
        }
        // fail when we've looked at every product and could not find what we wanted
        if (productType != null) {
            Assert.fail("Error: Failed to find a [" + productType + "] product type in Search results");
        }
    }

    @Then("at random, click on a product to view its PDP")
    public void atRandomClickProductToViewPDP() throws InterruptedException {
        quickThreadSleepMethod(3);
        String availability;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + UtilityHelper.popShuffledList() + "]"));
            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            homePageStepSerenity.atRandomMoveToViewProduct(element);
            homePageStepSerenity.clickOnProductToViewItsPDP(element);
            break;
        }
    }

    /**
     * @param UoM , bag, ea, lb, pkg, bunches
     */
    @Then("at random, click on a '(.*)' product to view its PDP")
    public void atRandomClickProductWithDesiredUoMToViewPDP(String UoM) throws InterruptedException {
        quickThreadSleepMethod(3);
        String availability;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + UtilityHelper.popShuffledList() + "]"));
            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            String desired_UoM = element.findElement(By.xpath(".//p[@class='product-price']//span[@class='uom']")).getText().toUpperCase();
            if (!(desired_UoM.contains(UoM.toUpperCase()))) {
                continue;
            }
            homePageStepSerenity.atRandomMoveToViewProduct(element);
            homePageStepSerenity.clickOnProductToViewItsPDP(element);
            break;
        }
    }

    /**
     * @param itemCount ,
     * @param itemQty   ,
     * @param UoM       , bag, ea, lb, pkg, bunches
     */
    @Then("select '(.*)' item '(.*)' qty with desired '(.*)' UOM message")
    public void atRandomViewProductWithExpectedUoM_Message(int itemCount, String itemQty, String UoM) throws InterruptedException {
        quickThreadSleepMethod(3);
        int counter = 0, elementIndex;
        String availability, desired_UoM;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            if (counter != itemCount) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + elementIndex + "]"));
                availability = UtilityHelper.elementGetAttribute(element, "class");
                UtilityHelper.moveToViewElement(element);
                if (availability.contains("unavailable") || availability.contains("instore")) {
                    continue;
                }
                desired_UoM = element.findElement(By.xpath(".//p[@class='product-price']//span[@class='uom']")).getText().toUpperCase();
                if (!(desired_UoM.contains(UoM.toUpperCase()))) {
                    continue;
                }
                homePageStepSerenity.atRandomViewProductAndAddToCart(element, itemQty);
                counter++;
            }
        }
    }

    //Created By: 107793 updated: 8/9/17
    @Then("user verify tool tip error messaging '/EA'")
    public void userVerifyToolTipErrorMessaging_Eaches() {
        int elementIndex;
        String availability, desired_UoM;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            elementIndex = UtilityHelper.popShuffledList();
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + elementIndex + "]"));
            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            desired_UoM = element.findElement(By.xpath(".//p[@class='product-price']//span[@class='uom']")).getText().toUpperCase();
            if (!(desired_UoM.contains("EA"))) {
                continue;
            }
            homePageStepSerenity.user_VerifyToolTipErrorMessaging_Eaches(element);
            break;
        }
    }

    //Created By: 107793 updated: 8/9/17
    @Then("user verify tool tip error messaging '/LB'")
    public void userVerifyToolTipErrorMessaging_Weight() {
        int elementIndex;
        String availability, desired_UoM;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            elementIndex = UtilityHelper.popShuffledList();
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + elementIndex + "]"));
            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            desired_UoM = element.findElement(By.xpath(".//p[@class='product-price']//span[@class='uom']")).getText().toUpperCase();
            if (!(desired_UoM.contains("LB"))) {
                continue;
            }
            homePageStepSerenity.user_VerifyToolTipErrorMessaging_Weight(element);
            break;
        }
    }

    @Then("select item '(.*)' with desire qty '(.*)' and Add to Cart")
    public void atRandomViewProductAndAddToCart(int itemCount, String itemQty) throws InterruptedException {
        quickThreadSleepMethod(3);
        int limit = 0, elementIndex;
        String availability;
        List<WebElement> productList = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, productList.size());
        for (WebElement element : productList) {
            if (limit != itemCount) {
                elementIndex = UtilityHelper.popShuffledList();
                element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + elementIndex + "]"));
                availability = UtilityHelper.elementGetAttribute(element, "class");
                UtilityHelper.moveToViewElement(element);
                if (availability.contains("unavailable") || availability.contains("instore")) {
                    continue;
                }
                homePageStepSerenity.atRandomViewProductAndAddToCart(element, itemQty);
                limit++;
            }
        }
    }

    @Then("click on last page of the product list")
    public void clickOnLastPageOfTheProductList() throws InterruptedException {
        homePageStepSerenity.click_OnLastPageOfTheProductList();
    }

    //TODO: Enhance Age Restricted Items Cucumber Step
    @Then("open an Age Restricted Item and select qty '(.*)' and Add to Cart")
    public void openAnAgeRestrictedItemandSelectQtyandAddToCart(String itemqty) throws InterruptedException {
        homePageStepSerenity.open_AnAgeRestrictedItemandSelectQtyandAddToCart(itemqty);
    }

    @Then("choose '(.*)' Age Restricted Product Update Qty to '(.*)' and Click Add to Cart")
    public void chooseAgeRestrictedProductUpdateQtyandClickAddtoCart(int noitem, String itemqty) throws InterruptedException {
        homePageStepSerenity.choose_AgeRestrictedProductUpdateQtyto13andClickAddtoCart(noitem, itemqty);
    }

    @Then("select '(.*)' hazardous Item and update Qty to '(.*)' and Add to Cart")
    public void selectHazardousItemandUpdateQtyandAddtoCart(int noitem, String itemqty) throws InterruptedException {
        homePageStepSerenity.select_HazardousItemandUpdateQtyandAddtoCart(noitem, itemqty);
    }

    @Then("user navigate back to mPerks Home screen")
    public void userNavigateBackTomPerksHomeScreen() {
        homePageStepSerenity.user_NavigateBackTomPerksHomeScreen();
    }

    @Then("click on Quick Shop link on Curbside Wizard")
    public void clickOnQuickShopLinkonCurbsideWizard() throws InterruptedException {
        homePageStepSerenity.click_QuickShopLink_CurbsideWizard();
    }

    //TODO: FIXME! IM CRASHING FOR NO APPARENT REASON AND ITS MAKING ME FEEL BAD!
    @Then("validate Quick Shop Page display")
    public void validateQuickShopPageDisplay() {
        homePageStepSerenity.waitUntilHomepageLoads();
        homePageStepSerenity.validate_QuickShopPage_Display_FrequentPurchase_Text();
        homePageStepSerenity.validate_QuickShopPage_Display_pageTitle();
        homePageStepSerenity.validate_QuickShopPage_Display_YourFavorites_Text();
        homePageStepSerenity.validate_QuickShopPage_Display_YourRecommendations_Text();
    }

    @Then("validate SSI Quick Shop 'Favorites' section")
    public void validateQuickShopFavoritesSection_SSI() {
        homePageStepSerenity.validateQuickShopFavoritesSection_SSI();
    }

    @Then("validate alcohol is Available at Your Store")
    public void validateAlcoholIsAvailableAtYourStore() {
        homePageStepSerenity.validate_availableAtYourStore();
    }

    @Then("validate add to cart is not available")
    public void validateNotAbleToAddToCart() {
        homePageStepSerenity.validate_notAbleToAddToCart();
    }

    //Created By: 107793 10/21/16
    @Then("verify your store page displays")
    public void yourStorePageDisplays() {
        homePageStepSerenity.yourStorePageDisplay();
    }

    //Created By: 107793 10/21/16
    @Then("user view source code")
    public void userViewSourceCode() {
        homePageStepSerenity.user_viewSourceCode();
    }

    //Created By: 107793 10/28/16
    @Then("verify store page schema - name, address, store hours")
    public void verifyStorePageSchemaNameAddressHours() {
        homePageStepSerenity.storePageSchemaNameAddressHours();
    }

    //Created By: 107793 10/28/16
    @Then("verify PDP schema - name, image, description, price, priceValidUntil")
    public void verifyPDPschemaNameImageDescriptionPrice() {
        homePageStepSerenity.pdpSchemaNameImageDescriptionPrice();
    }

    @Then("user clicks 'Sign In to Reserve a Time Slot' link")
    public void userClicksSignInToReserveATimeSlotLink() {
        homePageStepSerenity.highLightSignInToReserveATimeSlotLink();
        homePageStepSerenity.userClicksSignInToReserveATimeSlotLink();
    }

    @Then("validate timeslot Reserved Until is displayed")
    public void validateTimeSlotReservedUntilisDisplayed() {
        homePageStepSerenity.validate_TimeSlotReservedUntilisDisplayed();
    }

    @Then("validate Header widget drops your current reservation hold")
    public void validateHeaderWidgetDropsYourCurrentReservationHold() {
        homePageStepSerenity.validate_HeaderWidgetDropsYourCurrentReservationHold();
    }

    @Then("validate curbside display Reserve Curbside Pickup Time Text")
    public void validateCurbsideDisplayReserveCurbsidePickupTime() {
        homePageStepSerenity.validate_CurbsideDisplayReserveCurbsidePickupTime();
    }

    @Then("validate DATE and TIME display under curbside widget via Home page")
    public void validateDATEAndTIMEDisplayUnderCurbsideWidgetViaHomePage() throws ParseException {
        homePageStepSerenity.validateDATEAndTIMEDisplayUnderCurbsideWidgetViaHomePage();
    }

    @Then("select Store Locator from Footer")
    public void selectStoreLocatorfromFooterLink() {
        homePageStepSerenity.select_StoreLocatorfromFooterLink();
    }

    @Then("select MI icon from map on Store Locator Pge")
    public void selectMIiconFromMapOnStoreLocatorPge() {
        homePageStepSerenity.select_MIiconFromMapOnStoreLocatorPge();
    }

    @Then("Select a Curbside Enabled Store from Store Locator Page")
    public void selectaCurbsideEnabledStoreFromStoreLocatorPage() {
        homePageStepSerenity.select_CurbsideEnabledStoreFromStoreLocatorPage();
    }


    @Then("validate timeslot available display contents of curbside wizard")
    public void validateContentsOfCurbsideWizard() {
        homePageStepSerenity.validate_ContentsOfCurbsideWizard();
    }

    @Then("validate past orders and Quick shop links display")
    public void validatePastOrdersAndQuickShopLinksDisplay() {
        homePageStepSerenity.validate_PastOrders_QuickShop_LinksDisplay();
    }

    @Then("validate Sign In to Reserve A time Slot text on curbside wizard")
    public void validateSignIntoReserveATimeSlotTextOnCurbsideWizard() {
        homePageStepSerenity.validate_SignIntoReserveATimeSlotText_OnCurbsideWizard();
    }


    @Then("user hovers over '(.*)")
    public void usernavigatestoGivenTier1Item(String tier1) throws InterruptedException {
        homePageStepSerenity.user_hoversOverTier(tier1);
    }

    @Then("verify the wayfinding tiles are displayed")
    public void verifywayfingdingtile() {
        homePageStepSerenity.verify_wayfindingtile();
    }

    @Then("user navigates Shop to '(.*)' submenu Tier1")
    public void userNavigatesToGivenTier1Item(String tier1) throws InterruptedException {
        homePageStepSerenity.userNavigatesToGivenTier1Item(tier1);
    }

    @Then("user navigates Shop to '(.*)' to '(.*)' submenu Tier2")
    public void userNavigatesToGivenTier2Item(String tier1, String tier2) throws InterruptedException {
        homePageStepSerenity.userNavigatesToGivenTier2Item(tier1, tier2);
    }

    @Then("user navigates Shop to '(.*)' to '(.*)' to '(.*)' submenu Tier3")
    public void userNavigatesToGivenTier3Item(String tier1, String tier2, String tier3) throws InterruptedException {
        homePageStepSerenity.userNavigatesToGivenTier3Item(tier1, tier2, tier3);
    }

    @Then("user navigates Shop to '(.*)' to '(.*)' to '(.*)' to '(.*)' submenu Tier4")
    public void userNavigatesToGivenTier4Item(String tier1, String tier2, String tier3, String tier4) throws InterruptedException {
        homePageStepSerenity.userNavigatesToGivenTier4Item(tier1, tier2, tier3, tier4);
    }

    @Then("click on Past Order link display on Curbside Wizard")
    public void clickOnPastOrderLinkDisplayOnCurbsideWizard() {
        homePageStepSerenity.clickOn_PastOrderLink_DisplayOnCurbsideWizard();
    }

    @Then("validate Links Past Order not display")
    public void validateLinksPastOrderNotDisplay() {
        homePageStepSerenity.validateLinks_PastOrder_NotDisplay();
    }

    @Then("validate Links Quick Shop not display")
    public void validateLinksQuickShopNotDisplay() {
        homePageStepSerenity.validateLinks_QuickShop_NotDisplay();
    }

    @Then("validate View Order link not display in Curbside wizard")
    public void validateViewOrderlinkNotDisplayinCurbsideWizard() {
        homePageStepSerenity.validate_ViewOrderlink_NotDisplayinCurbsideWizard();
    }

    @Then("validate EditOrder link Not Display in Curbside wizard")
    public void validateEditOrderlinkNotDisplayinCurbsideWizard() {
        homePageStepSerenity.validate_EditOrderlinkNotDisplayinCurbsideWizard();
    }

    @Then("user click Edit Order link in Curbside Widget")
    public void userClickEditOrderlinkinCurbsideWidget() {
        homePageStepSerenity.click_EditOrderlinkinCurbsideWidget();
    }

    @Then("validate the warning note display to drop Curbside Reservation on Select Store screen")
    public void validateWarningNoteDisplayToDropCurbsideReservationOnSelectStore() {
        homePageStepSerenity.validateWarningNoteDisplayToDropCurbsideReservationOnSelectStore();
    }

    @Then("validate Your Store displays user selected store '(.*)'")
    public void validateYourStoreDisplaysUserSelectedStore(String storename) {
        homePageStepSerenity.validate_YourStoreDisplaysUserSelectedStore(storename);
    }

    @Then("validate Time Zone display in Eastern Time")
    public void validateTimeZoneDisplayinET() {
        homePageStepSerenity.validate_TimeZoneDisplayinET();
    }

    @Then("validate Time Zone display in Central Time Zone")
    public void validateTimeZoneDisplayInCentralTimeZone() {
        homePageStepSerenity.validate_TimeZoneDisplayInCentralTimeZone();
    }

    @Then("validate Time Zone display in Curbside Pickup Time after Slot Reserved")
    public void validateTimeZoneDisplayInCurbsidePickupTimeAfterSlotReserved() throws ParseException {
        homePageStepSerenity.validate_TimeZoneDisplay_CurbsidePickupTimeAfterSlotReserved();
    }

    @Then("validate curbside header display TimeZone as Eastern Time")
    public void validateCurbsideHeaderDisplayTimeZoneAsEasternTime() {
        homePageStepSerenity.validate_CurbsideHeaderDisplayTimeZoneAs_EasternTime();
    }

    @Then("validate curbside header display TimeZone as Central Time")
    public void validateCurbsideHeaderDisplayTimeZoneasCentralTime() {
        homePageStepSerenity.validate_CurbsideHeaderDisplayTimeZoneas_CentralTime();
    }

    @Then("user select Sign In from Setting Geo Location popup")
    public void userSelectSignInFromSettingStoreLocationPopup() {
        homePageStepSerenity.userSelect_SignIn_FromSettingStoreLocationPopup();
    }

    @Then("user Click on header menu online shopping")
    public void userClickOnHeaderMenuOnlineShopping() {
        homePageStepSerenity.userClickOnHeaderMenuOnlineShopping();
    }

    @Then("validate curbside 1st on dropdown list")
    public void validateCurbside1stOnDropdownlist() {
        homePageStepSerenity.validateCurbside1stOnDropdownlist();
    }

    @Then("click curbside from online shopping dropdown")
    public void clickCurbsideFromOnlineShoppingDropdown() {
        homePageStepSerenity.clickCurbsideFromOnlineShoppingDropdown();
    }


    @Then("validate Curbside page display successfully")
    public void validateCurbsidePageDisplaySuccessfully() {
        homePageStepSerenity.validateCurbsidePageDisplaySuccessfully();
    }

    @Then("validate shipt 2nd on dropdown list")
    public void validateShipt2ndOnDropdownlist() {
        homePageStepSerenity.validateShipt2ndOnDropdownlist();
    }

    @Then("click shipt from online shopping dropdown")
    public void clickShiptFromOnlineShoppingDropdown() {
        homePageStepSerenity.clickShiptFromOnlineShoppingDropdown();
    }


    @Then("validate Shipt page display successfully")
    public void validateShiptPageDisplaySuccessfully() {
        homePageStepSerenity.validateShiptPageDisplaySuccessfully();
    }


    @When("user provide '(.*)' on GeoLocation Setting screen")
    public void userprovideZipCodeonGeoLocationSettingscreen(String zipcode) throws IOException {
        homePageStepSerenity.user_provideZipCodeonGeoLocationSettingscreen(zipcode);
    }

    @Then("click Find Stores Button on GeoLOcation Setting")
    public void clickFindStoresButtononGeoLOcationSetting() {
        homePageStepSerenity.click_FindStoresButtononGeoLOcationSetting();
    }

    @Then("click on Shopping Cart Icon on HomePage")
    public void clickShoppingCartIcononHomePage() {
        homePageStepSerenity.click_ShoppingCartIcononHomePage();
    }

    @Then("validate Checkout button is disabled on mini card")
    public void validateCheckoutButtonIsDisabledonMiniCard() {
        homePageStepSerenity.validate_CheckoutButtonIsDisabledonMiniCard();
    }

    @Then("click on Use Current Location button on your Location setup")
    public void clickUseCurrentLocationButtonOnYourLocationSetup() {
        homePageStepSerenity.click_UseCurrentLocation_ButtonOnYourLocationSetup();
    }

    @Then("click mPerks ways to save from bottom left")
    public void click_mPerksWaysToSaveFromBottomLeft() {
        homePageStepSerenity.click_mPerksWaysToSaveFromBottomLeft();
        homePageStepSerenity.verifyPageLoadAfterFilterEdit();
    }

    @Then("click Sale ways to save from bottom left")
    public void clickSalesWaysToSaveFromBottomLeft() {
        homePageStepSerenity.click_SaleWaysToSaveFromBottomLeft();
        homePageStepSerenity.verifyPageLoadAfterFilterEdit();
    }

    @Then("click Sale ways to save from top dropdown")
    public void clickSalesWaysToSaveFromTopDropDown() {
        homePageStepSerenity.click_WaysToSaveDropdownMenu();
        homePageStepSerenity.highLightSaleWaysToSaveFromTopDropdown();
        homePageStepSerenity.click_SaleWaysToSaveFromTopDropDown();
        homePageStepSerenity.verifyPageLoadAfterFilterEdit();
    }

    @When("click mPerks ways to save from top dropdown")
    public void clickmPerksWaysToSaveFromTopDropDown() {
        homePageStepSerenity.click_WaysToSaveDropdownMenu();
        homePageStepSerenity.highLightMperksWaysToSaveFromTopDropdown();
        homePageStepSerenity.click_mPerksWaysToSaveFromTopDropdown();
        homePageStepSerenity.verifyPageLoadAfterFilterEdit();
    }


    @Then("verify weight messaging is not present on product tile")
    public void verifyWeightMessagingIsNotPresentOnProductTitle() {
        homePageStepSerenity.verify_weightMessagingIsNotPresentOnProductTitle();
    }

    @Then("verify weight messaging is present on product display page")
    public void verifyweightMessagingIsPresentOnProductDisplayPage() {
        homePageStepSerenity.verify_weightMessagingIsPresentOnProductDisplayPage();
    }

    @Then("verify weight disclaimer is present on product display page")
    public void verifyweightDisclaimerIsPresentOnProductDisplayPage() {
        homePageStepSerenity.verify_weightDisclaimerIsPresentOnProductDisplayPage();
    }

    @Then("verify weight disclaimer is present in mini cart")
    public void verifyWeightDisclaimerIsPresentInMiniCart() {
        homePageStepSerenity.verify_WeightDisclaimerIsPresentInMiniCart();
    }

    @Then("verify weight disclaimer is present in cart")
    public void verifyWeightDisclaimerIsPresentInCart() {
        homePageStepSerenity.verify_WeightDisclaimerIsPresentInCart();
    }

    @Then("verify weight disclaimer is present in checkout")
    public void verifyWeightDisclaimerIsPresentInCheckout() {
        homePageStepSerenity.verify_WeightDisclaimerIsPresentInCheckout();
    }

    @Then("verify weight disclaimer is present in order review")
    public void verifyWeightDisclaimerIsPresentInOrderReview() {
        homePageStepSerenity.verify_WeightDisclaimerIsPresentInOrderReview();
    }

	/*------------------------------hyperlink-------------------------------*/

    @Then("verify weight disclaimer is present in edit order")
    public void verifyWeightDisclaimerIsPresentInEditOrder() {
        homePageStepSerenity.verify_WeightDisclaimerIsPresentInEditOrder();
    }

    @When("user clicks on list view")
    public void userClicksOnListView() {
        homePageStepSerenity.clickListViewIcon();
    }


    @Then("verify url should match mperks filters for tier2")
    public void verifyurlShouldMatchmPerksFiltersForTier2() {
        homePageStepSerenity.verify_urlShouldMatchmPerksFilters_ForTier2();
    }

    @Then("verify url should match Sale filters for tier2")
    public void verifyurlShouldMatchSaleFiltersForTier2() {
        homePageStepSerenity.verify_urlShouldMatchSaleFilters_ForTier2();
    }

    @Then("verify url should match mPerks and Sale filters for tier2")
    public void verifyurlShouldMatchmPerksAndSaleFilters_ForTier2() {
        homePageStepSerenity.verify_urlShouldMatchmPerksAndSaleFilters_ForTier2();
    }

    @Then("verify url should match Sale filters for tier3")
    public void verifyurlShouldMatchSaleFiltersForTier3() {
        homePageStepSerenity.verify_urlShouldMatchSaleFilters_ForTier3();
    }

    @Then("verify url should match Sale filters for tier4")
    public void verifyurlShouldMatchSaleFiltersForTier4() {
        homePageStepSerenity.verify_urlShouldMatchSaleFilters_ForTier4();
    }


    @Then("verify url should match mperks filters for search")
    public void verifyurlShouldMatchmPerksFiltersForSearch() {
        homePageStepSerenity.verify_urlShouldMatchmPerksFilters_ForSearch();
    }

    @Then("verify url should match Sale filters for search")
    public void verifyurlShouldMatchSaleFiltersForSearch() {
        homePageStepSerenity.verify_urlShouldMatchSaleFilters_ForSearch();
    }

    @Then("verify url should match mPerks and Sale filters for search")
    public void verifyurlShouldMatchmPerksAndSaleFilters_ForSearch() {
        homePageStepSerenity.verify_urlShouldMatchmPerksAndSaleFilters_ForSearch();
    }

    @When("user clicks brand in left navigation")
    public void userClicksBrandInLeftNavigation() {
        homePageStepSerenity.user_ClickBrandInLeftNavigation();
    }

    @Then("verify url should match brand filters for tiers")
    public void verifyUrlShouldMatchBrandFiltersForTiers() {
        homePageStepSerenity.verify_urlShouldMatchBrandFilters_ForTiers();
    }

    //Created By: 107793 11/08/16
    @Then("validate each product tile button functionality")
    public void validateEachProductTileButtonFunctionality() {
        homePageStepSerenity.validate_EachProductTileButtonFunctionality();
    }


    @Then("user view page '(.*)' of search results")
    public void userViewPageIndexOfSearchResults(String pageIndex) throws InterruptedException {
        homePageStepSerenity.moveToViewPagination();
        homePageStepSerenity.highLightDesiredPageIndex(pageIndex);
        homePageStepSerenity.clickDesiredPageIndex(pageIndex);
        homePageStepSerenity.waitUntilPageReLoads();
    }

    /*-----------------------------------Managed Content--------------------------------*/
    @Then("verify managed content block exists")
    public void verifyManagedContentBlockExists() {
        homePageStepSerenity.verify_managedContentBlockExists();
    }

    @Then("TEST CASE FAILS DUE TO BUG REPORT #'(.*)'")
    public void testCaseFailDueToBugReport(String bugId) {
        homePageStepSerenity.testCaseFailsDueToBugReport(bugId);
    }

    @Then("user click on header menu Services")
    public void userClickOnHeaderMenuServices() {
        homePageStepSerenity.userClickOnHeaderMenuServices();
    }

    @Then("user verify number of items displayed per page is 40")
    public void theUserVerify_ItemsDisplayedPerPage() {
        homePageStepSerenity.userVerify_ItemsDisplayedPerPage();
    }

    @Then("user verify Store against each item and main store selected are same")
    public void theUserVerify_StoreAgainstEachItemAndMainStoreSelectedSame() {
        homePageStepSerenity.userVerify_StoreAgainstEachItemAndMainStoreSelectedSame();
    }

    @Then("verify the Passive Store modal is displayed")
    public void verifyPassiveStoreModalIsDisplayed() {
        homePageStepSerenity.verifyPassiveStoreModalIsDisplayed();
    }

    @Then("delete cookie to simulate having not seen Passive Store modal")
    public void deleteCookieToSimulateHavingNotSeenPassiveStoreModal() {
        homePageStepSerenity.deleteCookieToSimulateHavingNotSeenPassiveStoreModal();
    }

    @Then("verify DefaultStore cookie is set to '(.*)'")
    public void verifyDefaultStoreCookieIsSetToStoreName(String storeName) {
        homePageStepSerenity.verifyDefaultStoreCookieIsSetToStoreName(storeName);
    }

    @Then("verify DefaultStore cookie remains unchanged")
    public void verifyDefaultStoreCookieRemainsUnchanged() {
        homePageStepSerenity.verifyDefaultStoreCookieRemainsUnchanged();
    }

    @Then("verify DefaultStoreNotificationCookie is set to true indicating the user has seen the Passive Store modal")
    public void verifyPassiveStoreCookieIsSet() {
        homePageStepSerenity.verifyPassiveStoreCookieIsSet();
    }

    @Then("grab and save store name from header")
    public void grabAndSaveStoreNameFromHeader() {
        homePageStepSerenity.grabAndSaveStoreNameFromHeader();
    }

    @Then("user clicks Select New Store on passive store selection modal")
    public void userClicksSelectNewStoreOnPassiveStoreSelectionModal() {
        homePageStepSerenity.user_ClicksSelectNewsStore_PassiveStoreSelection();
    }

    @Then("user clicks Off of passive store selection modal to close it")
    public void userClickOffPassiveStoreSelectionModal() {
        homePageStepSerenity.user_clickOffPassiveStoreSelectionModal();
    }

    @Then("verify store saved in DefaultStore cookie matches store in header")
    public void verifyDefaultStoreCookieMatchesHeader() {
        homePageStepSerenity.verifyDefaultStoreCookieMatchesHeader();
    }


    @When("user selects new store from an already open store selection modal")
    public void chooseDifferentStoreFromAnAlreadyOpenStoreModal() throws InterruptedException {
        homePageStepSerenity.chooseDifferentStoreFromAnAlreadyOpenStoreModal();
    }

    @Then("store cartID")
    public void storeCartID() {
        homePageStepSerenity.storeCartID();
    }

    @Then("verify cartID matches previous cartID")
    public void verifyCartIdMatchesPreviousCartID() {
        homePageStepSerenity.verifyCartIdMatchesPreviousCartID();
    }

    @Then("verify cartID does NOT match previous cartID")
    public void verifyCartIdDoesNOTmatchPreviousCartID() {
        homePageStepSerenity.verifyCartIdDoesNOTmatchPreviousCartID();
    }

    @Then("verify products in shopping cart match products list")
    public void verifyProductsInShoppingCartMatchProductsList() {
        homePageStepSerenity.verifyProductsInShoppingCartMatchProductsList();
    }

    @Then("verify products in minicart match products list")
    public void verifyProductsInMinicartMatchProductsList() {
        homePageStepSerenity.verifyProductsInMinicartMatchProductsList();
    }


    @Then("save information for minicart header and reservation header")
    public void saveInformationForMinicartHeaderAndReservationHeader() {
        homePageStepSerenity.saveInformationForMinicartHeaderAndReservationHeader();
    }

    @Then("verify minicart header and reservation header match previous state")
    public void verifyMinicartHeaderAndReservationHeaderMatchPreviousState() {
        homePageStepSerenity.verifyMinicartHeaderAndReservationHeaderMatchPreviousState();
    }

    @Then("user clicks on wayfinding tiles '(.*)' and '(.*)'")
    public void user_clicks_on_wayfinding_tiles(String tier2, String tier3) {
        homePageStepSerenity.user_clicks_on_wayfinding_tiles(tier2, tier3);
    }

    @Then("user clicks on wayfinding tiles '(.*)'")
    public void user_clicks_on_wayfinding_tiles(String tier2) {
        homePageStepSerenity.user_clicks_on_wayfinding_tiles(tier2);
    }


    @Then("verify Minicart Widget Shows Zero Items")
    public void verifyMinicartWidgetShowsZeroItems() {
        homePageStepSerenity.verifyMinicartWidgetShowsZeroItems();
    }


    @Then("verify Minicart Is Empty")
    public void verifyMinicartIsEmpty() {
        homePageStepSerenity.verifyMinicartIsEmpty();
    }

    @Then("verify Reservation Widget Shows Sign In To Reserve Timeslot")
    public void verifyReservationWidgetShowsSignInToReserveTimeslot() {
        homePageStepSerenity.verifyReservationWidgetShowsSignInToReserveTimeslot();
    }

    @Then("wait Until Winkbar Dissappears")
    public void waitUntilWinkbarDissappears() {
        homePageStepSerenity.waitUntilWinkbarDissappears();
    }


    //verifying user is not brough to quickshop proper when logged out, but rather, to an emptyish landing page -JoeG
    @Then("verify quickshop lists are not present")
    public void verifyQuickshopListsAreNotPresent() {
        homePageStepSerenity.verifyQuickshopListsAreNotPresent();
    }

    @Then("verify user is prompted with 'Please sign in' modal")
    public void verifyUserIsPromptedToLogin() {
        homePageStepSerenity.verifyUserIsPromptedToLogin();
    }

    @Then("verify user is NOT prompted with 'Please sign in' modal")
    public void verifyUserIsNotPromptedToLogin() {
        homePageStepSerenity.verifyUserIsNotPromptedToLogin();
    }


    @Then("store suggested purchase list")
    public void storeSuggestedPurchaseList() {
        homePageStepSerenity.storeSuggestedPurchaseList();
    }

    @Then("validate suggested purchases list matches previous state")
    public void validateSuggestedPurchasesListMatchesPreviousState() {
        homePageStepSerenity.validateSuggestedPurchasesListMatchesPreviousState();
    }

    @Then("store frequent purchases list")
    public void storeFrequentPurchasesList() {
        homePageStepSerenity.storeFrequentPurchasesList();
    }


    @Then("store view all frequent purchases list")
    public void storeFrequentPurchasesListViewAll() {
        homePageStepSerenity.storeFrequentPurchasesListViewAll();
    }


    @Then("verify frequent purchases list previous state")
    public void verifyFrequentPurchasesListMatchesPreviousState() {
        homePageStepSerenity.verifyFrequentPurchasesListMatchesPreviousState();
    }


    @Then("verify view all frequent purchases list matches previous state")
    public void verifyViewAllFrequentPurchasesListMatchesPreviousState() {
        homePageStepSerenity.verifyViewAllFrequentPurchasesListMatchesPreviousState();
    }


    @Then("Verify active order message is not displayed in header widget")
    public void verifyActiveOrderMessageIsNotDisplayedInHeaderWidget() {
        homePageStepSerenity.verifyActiveOrderMessageIsNotDisplayedInHeaderWidget();
    }


    @Then("verify header widget is not present")
    public void verifyHeaderWidgetIsNotPresent() {
        homePageStepSerenity.verifyHeaderWidgetIsNotPresent();
    }


    @Then("Verify header widget says Reserve Curbside Pickup Time")
    public void verifyHeaderWidgetSaysReserveCurbsidePickupTime() {
        homePageStepSerenity.verifyHeaderWidgetSaysReserveCurbsidePickupTime();
    }


    @Then("verify order history page loads")
    public void verifyOrdersPageLoads() {
        homePageStepSerenity.verifyOrdersPageLoads();
    }

    @Then("user clicks view all from Frequent Purchases")
    public void userClicksViewAllFromFrequentPurchases() {
        homePageStepSerenity.userClicksViewAllFromFrequentPurchases();
    }


    @Then("store favorites list")
    public void storeFavoritesList() {
        homePageStepSerenity.storeFavoritesList();
    }

    @Then("validate favorites list matches previous state")
    public void validateFavoritesListMatchesPreviousState() {
        homePageStepSerenity.validateFavoritesListMatchesPreviousState();
    }

    @Then("verify frequent purchases view all list matches previous state")
    public void verifyFrequentPurchasesViewAllListMatchesPreviousState() {
        homePageStepSerenity.verifyFrequentPurchasesViewAllListMatchesPreviousState();
    }


    @Then("verify suggested purchases view all list matches previous state")
    public void verifySuggestedPurchasesViewAllListMatchesPreviousState() {
        homePageStepSerenity.verifySuggestedPurchasesViewAllListMatchesPreviousState();
    }


    @Then("verify favorites view all list matches previous state")
    public void verifyFavoritesViewAllListMatchesPreviousState() {
        homePageStepSerenity.verifyFavoritesViewAllListMatchesPreviousState();
    }

    @Then("user clicks '(.*)' icon on product via QuickShop page")
    public void userClicksDesiredIconOnProductViaQuickShopPage(String icon) {
        homePageStepSerenity.userClicksDesiredIconOnProductViaQuickShopPage(icon);
    }

    @Then("user randomly selects '(.*)' icon on product via Search Results")
    public void userClicksDesiredIconOnProductViaSearchResults(String icon) throws InterruptedException {

        quickThreadSleepMethod(3);
        String availability;
        List<WebElement> totalItems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        UtilityHelper.shuffleList(1, totalItems.size());
        for (WebElement element : totalItems) {
            element = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + UtilityHelper.popShuffledList() + "]"));
            availability = UtilityHelper.elementGetAttribute(element, "class");
            UtilityHelper.moveToViewElement(element);
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            homePageStepSerenity.atRandomMoveToViewProduct(element);
            homePageStepSerenity.clickOnProductIconViaSearchResults(element, icon);
            break;
        }
    }

    //Created: PI6
    @Then("verify successful active order DATE and TIME in header widget")
    public void verifySuccessfulActiveOrderDateAndTimeInHeaderWidget() {
        homePageStepSerenity.verifySuccessfulActiveOrderDateAndTimeInHeaderWidget();
    }

    // Created: PI6
    @Then("verify successful active order for NON-CNC Order")
    public void verifySuccessfulActiveOrderHeaderWidgetForNonCNC_Order() {
        homePageStepSerenity.verifySuccessfulActiveOrderHeaderWidgetForNonCNC_Order();
    }

    // Created: PI6
    @Then("verify breadcrumb is displayed below title and managed content")
    public void verifyBreadcrumbIsDisplayedBelowTitleAndManagedContent() {
        homePageStepSerenity.verifyBreadcrumbIsDisplayedBelowTitleAndManagedContent();
    }

    @Then("verify best sellers carousel is displayed")
    public void verifyBestSellersCarouselIsDisplayed() {
        homePageStepSerenity.verifyBestSellersCarouselIsDisplayed();
    }

    @Then("user click on product name in product tile")
    public void userClickOnProductNameInProductTile() {
        homePageStepSerenity.userClickOnProductNameInProductTile();
    }

    @Then("verify best sellers carousel has total of 20 products")
    public void verifyBestSellersCarouselHasTotalOf20Products() {
        homePageStepSerenity.verifyBestSellersCarouselHasTotalOf20Products();
    }

    @Then("user click view all from best sellers carousel")
    public void userClickViewAllFromBestSellersCarousel() {
        homePageStepSerenity.userClickViewAllFromBestSellersCarousel();
    }

    @Then("verify view all best sellers page displays")
    public void verifyviewAllBestSellersPageDisplays() {
        homePageStepSerenity.verifyViewAllBestSellersPageDisplays();
    }
}
