package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.OrderReviewStepSerenity;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OrderReviewStepDefinition {

    @Steps
    OrderReviewStepSerenity orderReviewStepSerenity;

    @Then("order review page display")
    public void orderReviewPageDisplay() {
        orderReviewStepSerenity.orderReviewPageDisplay();
    }

    @Then("user validate entered credit card details '(.*)' '(.*)'")
    public void userValidateEnteredCreditCardDetails(String ccname, String ccnumber) {
        orderReviewStepSerenity.user_ValidateEnteredCreditCardDetails(ccname, ccnumber);
    }

    @Then("user validate price displayed in order review page")
    public void userValidatePriceDisplayedInOrderReviewPage() {
        orderReviewStepSerenity.user_ValidatePriceDisplayedInOrderReviewPage();
    }

    @Then("revalidate selected item details")
    public void revalidateSelectedItemDetails() {
        orderReviewStepSerenity.revalidate_SelectedItemDetails();
    }

    @Then("click on Place Order")
    public void clickOnPlaceOrder() {
        orderReviewStepSerenity.highLightPlaceOrderButton();
        orderReviewStepSerenity.clickOnPlaceOrder();
    }

    @Then("age restriction popup appear while placing order")
    public void ageRestrictionPopupAppearWhilePlacingOrder() {
        orderReviewStepSerenity.age_RestrictionPopupAppearWhilePlacingOrder();
    }

    @Then("user confirm on age restriction popup")
    public void userConfirmOnAgeRestrictionPopup() throws InterruptedException {
        orderReviewStepSerenity.user_ConfirmOnAgeRestrictionPopup();
    }

    @Then("user validate billing information on Order Review Page '(.*)' '(.*)'")
    public void userValidateBillingInformationOnOrderReviewPage(String address1, String ccaddress2) {
        orderReviewStepSerenity.user_ValidateBillingInformationOnOrderReviewPage(address1, ccaddress2);
    }

    @Then("user validate pickup information on Order Review Page '(.*)' '(.*)'")
    public void userValidatePickupInformationOnOrderReviewPage(String cardesc, String pickuploc) {
        orderReviewStepSerenity.user_ValidatePickupInfo_withCarDesc_OrderReviewPage(cardesc, pickuploc);
    }

    @Then("user validate pickup infor without Car Description on Order Review Page '(.*)'")
    public void userValidatePickupInforWithoutCarDescOrderReviewPage(String pickuploc) {
        orderReviewStepSerenity.user_ValidatePickupInfo_withoutCarDesc_OrderReviewPage(pickuploc);
    }

    @Then("user validate Shipping information display on Order Review Page '(.*)' '(.*)' '(.*)'")
    public void userValidateShippingInformationDisplayOnOrderReviewPage(String address1, String address2, String deliverymethod) {
        orderReviewStepSerenity.user_ValidateShippingInformationDisplayOnOrderReviewPage(address1, address2, deliverymethod);
    }

    @Then("validate promotional discount display correct")
    public void validatePromotionalDiscountDisplayCorrect() {
        orderReviewStepSerenity.validate_PromotionalDiscountDisplayCorrect();
    }

    @Then("validate Bulk Order Overall Total Price display correct")
    public void validateBulkOrderOverallTotalPriceDisplayCorrect() {
        orderReviewStepSerenity.validate_BulkOrderOverallTotalPriceDisplayCorrect();
    }

    @Then("validate Price calculation for each section of item type including alchol items")
    public void validateWhetherOverallTotalPriceCalculationIsCorrect() {
        orderReviewStepSerenity.validate_WhetherOverallTotalPriceCalculationIsCorrect();
    }

    @Then("validate calculated total value display correct")
    public void validateCalculatedTotalValueDisplayCorrect() {
        orderReviewStepSerenity.validate_CalculatedTotalValueDisplayCorrect();
    }

    @Then("user validate overall Total Calulation of Single Item")
    public void userValidateOverallTotalCalulationSingleItem() {
        orderReviewStepSerenity.user_ValidateOverallTotalCalulationSingleItem();
    }

    @Then("user click Edit Cart on Order Reveiew Page")
    public void userClickEditCartonOrderReveiewPage() {
        orderReviewStepSerenity.user_ClickEditCartonOrderReveiewPage();
    }

    @Then("click edit pickup time link on Order Review Page")
    public void userClickEditPickupLinkOnOrderReviewPage() {
        orderReviewStepSerenity.user_ClickEditPickupLinkOnOrderReviewPage();
    }

    @Then("verify no static message in review page")
    public void verifyNoStaticMessageReviewPage() {
        orderReviewStepSerenity.verifyNoStaticMessageReviewPage();
    }


    @Then("verify static message is displayed in review page")
    public void verifyStaticMessageReviewPage() {
        orderReviewStepSerenity.verifyStaticMessageReviewPage();
    }


}
