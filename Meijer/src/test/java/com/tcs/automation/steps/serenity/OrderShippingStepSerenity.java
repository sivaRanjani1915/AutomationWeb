package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderShippingPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class OrderShippingStepSerenity extends ScenarioSteps {

    OrderShippingPage orderShippingPage;
    utilityhelper UtilityHelper;

    @Step
    public void shippingPageDisplay() {
        orderShippingPage.shippingPageDisplay();
    }

    @Step
    public void user_EnterShippingDetails(String firstname, String lastname, String address1, String city, String state, String zipcode, String phnumber, String email) {
        orderShippingPage.enterFirstName(firstname);
        orderShippingPage.enterLastName(lastname);
        orderShippingPage.enterAddress(address1);
        orderShippingPage.enterZipCode(zipcode);
        orderShippingPage.enterCity(city);
        orderShippingPage.selectState(state);
        orderShippingPage.enterPhoneNumber(phnumber);
        orderShippingPage.enterEmail(email);
    }

    @Step
    public void user_EnterShippingDetailsExceptEmail(String firstname, String lastname, String address1, String city, String state, String zipcode, String phnumber) {
        orderShippingPage.enterFirstName(firstname);
        orderShippingPage.enterLastName(lastname);
        orderShippingPage.enterAddress(address1);
        orderShippingPage.enterZipCode(zipcode);
        orderShippingPage.enterCity(city);
        orderShippingPage.selectState(state);
        orderShippingPage.enterPhoneNumber(phnumber);
    }

    @Step
    public void user_EnterDeliveryMethodShippingInformationDetails(String dvrymethd, String giftmsg) {
        orderShippingPage.selectShippingDeliveryMethod(dvrymethd);
        orderShippingPage.enterGiftMessage(giftmsg);
    }

    @Step
    public void user_EnterDeliveryMethodShippingInformationDetailswithoutGiftCardMsg(String dvrymethd) {
        orderShippingPage.selectShippingDeliveryMethod(dvrymethd);
    }

    @Step
    public void highLightNextButtonOnOrderFlow() {
        UtilityHelper.highLightElement(orderShippingPage.NEXT_BUTTON_CHECKOUT_FLOW);
    }

    @Step
    public void clickNextButtonOnOrderFlow() {
        orderShippingPage.clickNextButtonOnOrderFlow();
    }

    @Step
    public void checkForAnyErrorsDuringCheckoutFlow() throws InterruptedException {
        orderShippingPage.checkForAnyErrorsDuringCheckoutFlow();
    }

    @Step
    public void select_ExpeditedShippingOptionUnderDeliveryMethod(String dvrymethd, String giftmsg) {
        orderShippingPage.selectShippingDeliveryMethod(dvrymethd);
        orderShippingPage.enterGiftMessage(giftmsg);
    }

    @Step
    public void verifyNoStaticMessage_ShippingPage() {
        orderShippingPage.verifyNoStaticMessage_ShippingPage();
    }


}
