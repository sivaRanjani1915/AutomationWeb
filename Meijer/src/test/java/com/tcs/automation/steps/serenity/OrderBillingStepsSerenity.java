package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderBillingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class OrderBillingStepsSerenity extends ScenarioSteps {

    OrderBillingPage orderBillingPage;


    @Step
    public void userClickEditPickupLinkOnBillingPage() {
        orderBillingPage.userClickEditPickupLinkOnBillingPage();
    }

    @Step
    public void billingPageDisplay() {
        orderBillingPage.billingPageDisplay();
    }

    @Step
    public void userSelectsUseBillingAddressCheckbox() {
        orderBillingPage.userSelectsUseBillingAddressCheckbox();
    }

    @Step
    public void validatePickupDetailsOnBillingPage(String cardesc, String pickuploc) {
        orderBillingPage.pickupDateAndTimeValidationBillingPage();
        orderBillingPage.pickupDetailsCarDescValidationBillingPage(cardesc);
        orderBillingPage.pickupLocationValidation_withCarDesc_BillingPage(pickuploc);
    }

    @Step
    public void userValidatePickupInformationOnOrderReviewPage(String pickuploc) {
        orderBillingPage.pickupDateAndTimeValidationBillingPage();
        orderBillingPage.pickupLocationValidation_WithoutCarDesc_BillingPage(pickuploc);
    }

    @Step
    public void userValidatePickupInformationOnOrderReviewPageWithoutCarDescCurbside(String pickuploc) {
        orderBillingPage.pickupDateAndTimeValidationBillingPage();
        orderBillingPage.pickupLocationValidation_WithoutCarDesc_BillingPage(pickuploc);
    }

    @Step
    public void validateAutoFilledValueInPaymentInfoSection(String firstname, String lastname, String address1, String city, String statecode, String zipcode) {
        orderBillingPage.autoFilledValidationBillingPage(firstname, lastname, address1, city, statecode, zipcode);
    }

    @Step
    public void userEnterCreditCardPaymentInfoDetails(String ccnumber, String idxccexpmn, String idxccexpyr, String ccSecurity) {
        orderBillingPage.enterCreditCardPaymentInfoBilling(ccnumber, idxccexpmn, idxccexpyr, ccSecurity);
    }

    @Step
    public void userSelectExistingCreditCardForProvidingPaymentInfo(String ccsecurityCode) {
        orderBillingPage.userSelectExistingCreditCardForProvidingPaymentInfo(ccsecurityCode);
    }

    @Step
    public void userEnterFullPaymentInfoDetails(String firstName, String lastName, String creditCard, String exprMon, String exprYr, String ccSecurity, String address, String city, String state, String zipCode) {
        orderBillingPage.enterNameInfoBilling(firstName, lastName);
        orderBillingPage.enterCreditCardPaymentInfoBilling(creditCard, exprMon, exprYr, ccSecurity);
        orderBillingPage.enterAddressInfoBilling(address, city, state, zipCode);
    }

    @Step
    public void user_SelectSaveCreditCardToYourAccountCheckbox() {
        orderBillingPage.toSelectSaveCreditCardToYourAccountCheckbox();
    }

    @Step
    public void user_SelectBillingInfoSameAsShippingInfoCheckbox() {
        orderBillingPage.clickCheckBox_BillingInfoSameasShipping();
    }

    @Step
    public void errorMessage_StreetAddress() {
        orderBillingPage.errorMessageStreetAddress();
    }

    @Step
    public void errorMessage_ZipCode() {
        orderBillingPage.errorMessageZipCode();
    }

    @Step
    public void errorMessage_City() {
        orderBillingPage.errorMessageCity();
    }

    @Step
    public void errorMessage_State() {
        orderBillingPage.errorMessageState();
    }

    @Step
    public void validate_ErrorMessagesDisplayedForMandatoryFieldsOnBillingPaymentPage() {
        orderBillingPage.validate_Blank_FirstName_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_LastName_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_CreditCard_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_BillingAddresse_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_BillingZip_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_BillingCity_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_BillingState_ErrorMsg_billingpage();
    }

    @Step
    public void user_EnterOnlyCreditCardNumber(String ccnumber) {
        orderBillingPage.enter_CCDetailsOnly(ccnumber);
    }

    @Step
    public void validate_ErrorMessagesDisplayedForCCExpirationDateandSecurityCodeFields() {
        orderBillingPage.validate_Blank_CCExpirationDate_ErrorMsg_billingpage();
        orderBillingPage.validate_Blank_CCSecurityCode_ErrorMsg_billingpage();
    }

    @Step
    public void verify_nostaticmessbill() {
        orderBillingPage.verifynostaticmessbill();
    }

    @Step
    public void verifyNoStaticMessage_BillingPage() {
        orderBillingPage.verifyNoStaticMessage_BillingPage();
    }

    @Step
    public void verifyStaticMessage_BillingPage() {
        orderBillingPage.verifyStaticMessage_BillingPage();
    }


}
