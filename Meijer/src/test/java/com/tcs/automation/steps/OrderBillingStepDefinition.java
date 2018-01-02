package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.OrderBillingStepsSerenity;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class OrderBillingStepDefinition {

    @Steps
    OrderBillingStepsSerenity orderBillingStepSerenity;

    @Then("click edit pickup time link on Billing Page")
    public void userClickEditPickupLinkOnBillingPage() {
        orderBillingStepSerenity.userClickEditPickupLinkOnBillingPage();
    }

    @Then("billing page display")
    public void billingPageDisplay() {
        orderBillingStepSerenity.billingPageDisplay();
    }

    @Then("validate pickup details on Billing page '(.*)' '(.*)'")
    public void validatePickupDetailsOnBillingPage(String cardesc, String pickuploc) {
        orderBillingStepSerenity.validatePickupDetailsOnBillingPage(cardesc, pickuploc);
    }

    @Then("select use billing address checkbox")
    public void userSelectsUseBillingAddressCheckbox() {
        orderBillingStepSerenity.userSelectsUseBillingAddressCheckbox();
    }

    @Then("user validate pickup information on Order Review Page without car desc Deli-Cake '(.*)'")
    public void userValidatePickupInformationOnOrderReviewPage(String pickuploc) {
        orderBillingStepSerenity.userValidatePickupInformationOnOrderReviewPage(pickuploc);
    }


    @Then("user validate pickup information on Order Review Page without Car desc curbside '(.*)'")
    public void userValidatePickupInformationOnOrderReviewPageWithoutCarDescCurbside(String pickuploc) {
        orderBillingStepSerenity.userValidatePickupInformationOnOrderReviewPageWithoutCarDescCurbside(pickuploc);
    }

    @Then("validate auto filled value in payment info section '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void validateAutoFilledValueInPaymentInfoSection(String firstname, String lastname, String address1, String city, String statecode, String zipcode) {
        orderBillingStepSerenity.validateAutoFilledValueInPaymentInfoSection(firstname, lastname, address1, city, statecode, zipcode);
    }

    @Then("user enter Credit Card payment info details '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userEnterCreditCardPaymentInfoDetails(String ccnumber, String idxccexpmn, String idxccexpyr, String ccSecurity) {
        orderBillingStepSerenity.userEnterCreditCardPaymentInfoDetails(ccnumber, idxccexpmn, idxccexpyr, ccSecurity);
    }

    @Then("user Enter Full Payment info details '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userEnterFullPaymentInfoDetails(String firstname, String lastname, String ccnumber, String idxccexpmn, String idxccexpyr, String ccSecurity, String address1, String city, String state, String zipcode) {
        orderBillingStepSerenity.userEnterFullPaymentInfoDetails(firstname, lastname, ccnumber, idxccexpmn, idxccexpyr, ccSecurity, address1, city, state, zipcode);
    }

    /**
     * @param firstName ,
     * @param lastName  ,
     * @param table     | ccNum | expMon | expYr | ccSecurity | address | city | state | zipCode |
     */
    @Then("user Enter Full Payment info details: '(.*)' '(.*)'")
    public void enterFullPaymentInformation(String firstName, String lastName, DataTable table) {
        String ccNum = null, expMon = null, expYr = null, ccSecurity = null,
                address = null, city = null, state = null, zipCode = null;

        for (Map<String, String> map : table.asMaps(String.class, String.class)) {
            ccNum = map.get("ccNum");
            expMon = map.get("expMon");
            expYr = map.get("expYr");
            ccSecurity = map.get("ccSecurity");
            address = map.get("address");
            city = map.get("city");
            state = map.get("state");
            zipCode = map.get("zipCode");
        }
        orderBillingStepSerenity.userEnterFullPaymentInfoDetails(firstName, lastName, ccNum, expMon, expYr, ccSecurity, address, city, state, zipCode);

    }

    @Then("user select existing Credit Card for providing payment info '(.*)'")
    public void userSelectExistingCreditCardForProvidingPaymentInfo(String ccsecurityCode) {
        orderBillingStepSerenity.userSelectExistingCreditCardForProvidingPaymentInfo(ccsecurityCode);
    }

    @Then("user select Save Credit Card to your Account checkbox")
    public void userSelectSaveCreditCardToYourAccountCheckbox() {
        orderBillingStepSerenity.user_SelectSaveCreditCardToYourAccountCheckbox();
    }

    @Then("user select Billing Info same as Shipping Info Checkbox")
    public void userSelectBillingInfoSameAsShippingInfoCheckbox() {
        orderBillingStepSerenity.user_SelectBillingInfoSameAsShippingInfoCheckbox();
    }

    @Then("validate error messages displayed for mandatory fields on Billing and Payment Page")
    public void validateErrorMessagesDisplayedForMandatoryFieldsOnBillingPaymentPage() {
        orderBillingStepSerenity.validate_ErrorMessagesDisplayedForMandatoryFieldsOnBillingPaymentPage();
    }

    //Created By: 107793 11/07/16
    @Then("verify error messaging on Billing page")
    public void verifyErrorMessagingOnBillingPage() {
        //TODO: Possible Bug On Billing Page
        /* First Name, Last Name, & Credit Card error message
         * does not get populated 100% of the time.
         * Bug not reported as of 12/15/16
         */
//        orderBillingStepSerenity.errorMessage_FirstName();
//        orderBillingStepSerenity.errorMessage_LastName();
//        orderBillingStepSerenity.errorMessage_CreditCard();
        orderBillingStepSerenity.errorMessage_StreetAddress();
        orderBillingStepSerenity.errorMessage_ZipCode();
        orderBillingStepSerenity.errorMessage_City();
        orderBillingStepSerenity.errorMessage_State();
    }

    @Then("user enter only credit card number '(.*)'")
    public void userEnterOnlyCreditCardNumber(String creditcard) {
        orderBillingStepSerenity.user_EnterOnlyCreditCardNumber(creditcard);
    }

    @Then("validate error messages displayed for CC Expiration Date and Security Code fields")
    public void validateErrorMessagesDisplayedForCCExpirationDateandSecurityCodeFields() {
        orderBillingStepSerenity.validate_ErrorMessagesDisplayedForCCExpirationDateandSecurityCodeFields();
    }

    @Then("verify there is no static message in billing page")
    public void verifyNoStaticMessage_BillingPage() {
        orderBillingStepSerenity.verifyNoStaticMessage_BillingPage();
    }

    @Then("verify the static message is displayed in billing page")
    public void verifyStaticMessage_BillingPage() {
        orderBillingStepSerenity.verifyStaticMessage_BillingPage();
    }

}
