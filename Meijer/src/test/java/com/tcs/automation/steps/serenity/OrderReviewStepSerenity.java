package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderBillingPage;
import com.tcs.automation.pages.OrderReviewPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class OrderReviewStepSerenity extends ScenarioSteps {

    OrderReviewPage orderReviewPage;
    OrderBillingPage orderBillingPage;
    utilityhelper UtilityHelper;

    @Step
    public void orderReviewPageDisplay() {
        orderReviewPage.orderReviewPageDisplay();
    }

    @Step
    public void user_ValidateEnteredCreditCardDetails(String ccname, String ccnumber) {
        orderReviewPage.enteredCardDetailsvalidationReviewPage(ccname, ccnumber);
    }

    @Step
    public void user_ValidatePriceDisplayedInOrderReviewPage() {
        orderReviewPage.compareCalSubtotalPriceVsSystemDisplay();
    }

    @Step
    public void revalidate_SelectedItemDetails() {
        orderReviewPage.compareCalSubtotalPriceVsSystemDisplay();
        orderReviewPage.selecteditemvalidation_OrderReview();
        orderReviewPage.productname_validation();
    }

    @Step
    public void highLightPlaceOrderButton() {
        UtilityHelper.highLightElement(orderReviewPage.PLACE_ORDER_BUTTON);
    }

    @Step
    public void clickOnPlaceOrder() {
        orderReviewPage.clickOnPlaceOrder();
    }

    @Step
    public void age_RestrictionPopupAppearWhilePlacingOrder() {
        orderReviewPage.ageRestrictionPopupPlaceOrderWhilePlacingOrder();
    }

    @Step
    public void user_ConfirmOnAgeRestrictionPopup() throws InterruptedException {
        orderReviewPage.clickConfirmOnAgeRestrictionPopUp();
    }

    @Step
    public void user_ValidateBillingInformationOnOrderReviewPage(String address1, String ccaddress2) {
        orderReviewPage.billingInformationOnCreditCard(address1, ccaddress2);
    }

    @Step
    public void user_ValidatePickupInfo_withCarDesc_OrderReviewPage(String cardesc, String pickuploc) {
        orderBillingPage.pickupDateAndTimeValidationBillingPage();
        orderBillingPage.pickupDetailsCarDescValidationBillingPage(cardesc);
        orderBillingPage.pickupLocationValidation_withCarDesc_BillingPage(pickuploc);
    }

    @Step
    public void user_ValidatePickupInfo_withoutCarDesc_OrderReviewPage(String pickuploc) {
        orderBillingPage.pickupDateAndTimeValidationBillingPage();
        orderBillingPage.pickupLocationValidation_WithoutCarDesc_BillingPage(pickuploc);
    }

    @Step
    public void user_ValidateShippingInformationDisplayOnOrderReviewPage(String address1, String address2, String deliverymethod) {
        orderReviewPage.shippingAddressValidation(address1, address2);
        orderReviewPage.shippingDeliveryMethodValidation(deliverymethod);
    }

    @Step
    public void validate_PromotionalDiscountDisplayCorrect() {
        orderReviewPage.validate_buldorderdiscount();
    }

    @Step
    public void validate_BulkOrderOverallTotalPriceDisplayCorrect() {
        orderReviewPage.validate_BulkOrderOverallTOTALpriceDisplay();
    }

    @Step
    public void validate_WhetherOverallTotalPriceCalculationIsCorrect() {
        orderReviewPage.totalvalDisplayCNCSPOSTHItemsInCart_validation();
    }

    @Step
    public void validate_CalculatedTotalValueDisplayCorrect() {
        orderReviewPage.calculatedTotalValue_common();
    }

    @Step
    public void user_ValidateOverallTotalCalulationSingleItem() {
        orderReviewPage.singleItem_TotalCal();
    }

    @Step
    public void user_ClickEditCartonOrderReveiewPage() {
        orderReviewPage.click_EditCart_Link();
    }

    @Step
    public void user_ClickEditPickupLinkOnOrderReviewPage() {
        orderReviewPage.clickEditPickupLink();
    }

    @Step
    public void verifyNoStaticMessageReviewPage() {
        orderReviewPage.verifyNoStaticMessageReviewPage();
    }

    @Step
    public void verifyStaticMessageReviewPage() {
        orderReviewPage.verifyStaticMessageReviewPage();
    }

}
