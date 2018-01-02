package com.tcs.automation.steps;

import com.google.common.base.Strings;
import com.tcs.automation.pages.OrderShippingPage;
import com.tcs.automation.steps.serenity.OrderShippingStepSerenity;
import com.tcs.utilityhelpers.utilityhelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class OrderShippingStepDefinition {

    utilityhelper UtilityHelper;
    OrderShippingPage orderShippingPage;

    @Steps
    OrderShippingStepSerenity orderShippingStepSerenity;

    @Then("shipping Page display")
    public void shippingPageDisplay() {
        orderShippingStepSerenity.shippingPageDisplay();
    }

    @Then("user Enter Shipping details '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userEnterShippingDetails(String firstname, String lastname, String address1, String city, String state, String zipcode, String phnumber, String email) {
        orderShippingStepSerenity.user_EnterShippingDetails(firstname, lastname, address1, city, state, zipcode, phnumber, email);
    }

    /**
     * @param firstName   ,
     * @param lastName    ,
     * @param phoneNumber ,
     * @param email       ,
     * @param table       | address | city | state | zipCode |
     */
    @Then("user Enter Shipping details '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userEnterShippingDetails(String firstName, String lastName, String phoneNumber, String email, DataTable table) {
        String address = null, city = null, state = null, zipCode = null;

        for (Map<String, String> map : table.asMaps(String.class, String.class)) {
            address = map.get("address");
            city = map.get("city");
            state = map.get("state");
            zipCode = map.get("zipCode");
        }

        orderShippingStepSerenity.user_EnterShippingDetails(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
    }

    @Then("user Enter Shipping details except email '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void userEnterShippingDetailsExceptEmail(String firstname, String lastname, String address1, String city, String state, String zipcode, String phnumber) {
        orderShippingStepSerenity.user_EnterShippingDetailsExceptEmail(firstname, lastname, address1, city, state, zipcode, phnumber);
    }

    @Then("user enter delivery method shipping information details '(.*)' '(.*)'")
    public void userEnterDeliveryMethodShippingInformationDetails(String dvrymethd, String giftmsg) {
        orderShippingStepSerenity.user_EnterDeliveryMethodShippingInformationDetails(dvrymethd, giftmsg);
    }

    @Then("user enter delivery method shipping information details without giftcard msg '(.*)'")
    public void userEnterDeliveryMethodShippingInformationDetailswithoutGiftCardMsg(String dvrymethd) {
        orderShippingStepSerenity.user_EnterDeliveryMethodShippingInformationDetailswithoutGiftCardMsg(dvrymethd);
    }

    @Then("click Next button on order flow")
    public void clickNextButtonOnOrderFlow() throws InterruptedException {
        orderShippingStepSerenity.highLightNextButtonOnOrderFlow();
        orderShippingStepSerenity.clickNextButtonOnOrderFlow();
        if (UtilityHelper.elementExists(orderShippingPage.CHECKOUT_FLOW_ERROR_CHECK)) {
            if(!Strings.isNullOrEmpty(orderShippingPage.CHECKOUT_FLOW_ERROR_CHECK.getText())) {
                orderShippingStepSerenity.checkForAnyErrorsDuringCheckoutFlow();
            }
        }
    }

    @Then("select Expedited Shipping option under Delivery method '(.*)' '(.*)'")
    public void selectExpeditedShippingOptionUnderDeliveryMethod(String dvrymethd, String giftmsg) {
        orderShippingStepSerenity.select_ExpeditedShippingOptionUnderDeliveryMethod(dvrymethd, giftmsg);
    }

    @Then("user click on Next button without providing any details")
    public void userclickonNextbuttonWithoutProvidingAnyDetails() {
        orderShippingStepSerenity.clickNextButtonOnOrderFlow();
    }

    @Then("verify no static message in shipping page")
    public void verifyNoStaticMessage_ShippingPage() {
        orderShippingStepSerenity.verifyNoStaticMessage_ShippingPage();
    }



}
