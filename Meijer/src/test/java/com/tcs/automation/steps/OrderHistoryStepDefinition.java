package com.tcs.automation.steps;

import com.tcs.automation.Definition_RunnerClass;
import com.tcs.automation.steps.serenity.OrderHistoryStepSerenity;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OrderHistoryStepDefinition {

    @Steps
    OrderHistoryStepSerenity orderHistoryStepSerenity;

    @Then("order history summary page display")
    public void orderHistorySummaryPageDisplay() {
        orderHistoryStepSerenity.orderHistorySummaryPageDisplay();
    }

    @Then("validate order History summary page for order items")
    public void validateOrderHistorySummaryPageForOrderItems() {
        orderHistoryStepSerenity.validate_OrderHistorySummaryPageForOrderItems();
    }

    @Then("validate order History summary page for links")
    public void validateOrderHistorySummaryPageForLinks() {
        orderHistoryStepSerenity.validate_OrderHistorySummaryPageForLinks();
    }

    @Then("user click on view option next to order just placed")
    public void userClickOnViewOptionNextToOrderJustPlaced() {
        orderHistoryStepSerenity.highLightActiveOrderViewFirstRowTextLink();
        orderHistoryStepSerenity.userClickOnViewOptionNextToOrderJustPlaced();
    }

    @Then("user provide order number and billing zip code and search for order '(.*)'")
    public void enterOrderNumberAndBillingZipCodeAndSearchForOrder(String zipCode) {
        orderHistoryStepSerenity.userEntersRecentlyPlacedOrderID();
        orderHistoryStepSerenity.userEntersBillingZipCode(zipCode);
        orderHistoryStepSerenity.highLightLookUpOrderButton();
        orderHistoryStepSerenity.clickLookUpOrderButton();
    }

    @Then("user enter '(.*)' and billing '(.*)' and search order")
    public void userEnterOrderNoAndBillingzipCodeAndSearchOrder(String orderno, String zipCode) {
        orderHistoryStepSerenity.user_EnterOrderNoAndBillingzipCodeAndSearchOrder(orderno, zipCode);
    }

    @Then("validate the order could not found Message display")
    public void validateTheOrderCouldNotFoundMessageDisplay() {
        orderHistoryStepSerenity.validate_TheOrderCouldNotFoundMessageDisplay();
    }

    @Then("user click Edit Link option next to order just placed")
    public void userClickEditLinkOptionNextToOrderJustPlaced() {
        orderHistoryStepSerenity.user_ClickEditLinkOptionNextToOrderJustPlaced();
    }

    @Then("validate Past Order Summary Page display")
    public void validatePastOrderSummaryPageDisplay() {
        orderHistoryStepSerenity.validate_PastOrderSummaryPageDisplay();
    }

    @Then("validate Edit link not display on Order History page for SPO only item")
    public void validateEditLinkNotDisplayOnOrderHistoryPageFor_SPOonlyItem() {
        orderHistoryStepSerenity.validate_EditLink_NotDisplayonOrderHistorypageForSPOonlyitem();
    }

    //Created By: 107793 12/28/16
    @Then("validate active order by order type '(.*)'")
    public void validateActiveOderByOrderType(String orderType) {
        orderHistoryStepSerenity.validate_ActiveOrderByOrderType(orderType);
    }

    @Then("user enter '(.*)' and billing '(.*)' and search for Order in '(.*)' environment")
    public void userEntersOrderIDAndBillingZipCodeToSearchForOrder(String orderID, String zipCode, String environment) {
        if (environment.toUpperCase().equals("DEV") && Definition_RunnerClass.Environment.contains("dev")) {
            orderHistoryStepSerenity.enterProvidedOrderID(orderID);
            orderHistoryStepSerenity.userEntersBillingZipCode(zipCode);
            orderHistoryStepSerenity.highLightLookUpOrderButton();
            orderHistoryStepSerenity.clickLookUpOrderButton();
        }
        if (environment.toUpperCase().equals("UAT") && Definition_RunnerClass.Environment.contains("uat")) {
            orderHistoryStepSerenity.enterProvidedOrderID(orderID);
            orderHistoryStepSerenity.userEntersBillingZipCode(zipCode);
            orderHistoryStepSerenity.highLightLookUpOrderButton();
            orderHistoryStepSerenity.clickLookUpOrderButton();
        }
    }
}
