package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderHistoryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class OrderHistoryStepSerenity extends ScenarioSteps {

    OrderHistoryPage orderHistoryPage;

    @Step
    public void orderHistorySummaryPageDisplay() {
        orderHistoryPage.orderHistorySummaryPageDisplay();
    }

    @Step
    public void validate_OrderHistorySummaryPageForOrderItems() {
        orderHistoryPage.orderNumber_validation_OrderHistory();
        orderHistoryPage.orderStatus_validation_OrderHistory();
    }

    @Step
    public void validate_OrderHistorySummaryPageForLinks() {
        orderHistoryPage.orderHistorySummaryLinksDisplayValidation();
    }

    @Step
    public void highLightActiveOrderViewFirstRowTextLink() {
        orderHistoryPage.highLightActiveOrderViewFirstRowTextLink();
    }

    @Step
    public void userClickOnViewOptionNextToOrderJustPlaced() {
        orderHistoryPage.userClickOnViewOptionNextToOrderJustPlaced();
    }

    @Step
    public void userEntersRecentlyPlacedOrderID() {
        orderHistoryPage.userEntersRecentlyPlacedOrderID();
    }

    @Step
    public void userEntersBillingZipCode(String zipcode) {
        orderHistoryPage.userEntersBillingZipCode(zipcode);
    }

    @Step
    public void highLightLookUpOrderButton() {
        orderHistoryPage.highLightLookUpOrderButton();
    }

    @Step
    public void clickLookUpOrderButton() {
        orderHistoryPage.clickLookUpOrderButton();
    }

    @Step
    public void user_EnterOrderNoAndBillingzipCodeAndSearchOrder(String orderno, String zipCode) {
        orderHistoryPage.enterProvidedOrderID(orderno);
        orderHistoryPage.userEntersBillingZipCode(zipCode);
    }

    @Step
    public void validate_TheOrderCouldNotFoundMessageDisplay() {
        orderHistoryPage.orderCouldNotFoundErrorMsgSPOItem();
    }

    @Step
    public void user_ClickEditLinkOptionNextToOrderJustPlaced() {
        orderHistoryPage.clickEditLinkOrderHistorySummaryPage();
    }

    @Step
    public void validate_PastOrderSummaryPageDisplay() {
        orderHistoryPage.orderHistorySummaryPageDisplay();
        orderHistoryPage.orderHistorySummary_RecentOrders_TextValidation();
    }

    @Step
    public void validate_EditLink_NotDisplayonOrderHistorypageForSPOonlyitem() {
        orderHistoryPage.edit_linkNotDisplay_OrderHistory();
    }

    @Step
    public void validate_ActiveOrderByOrderType(String orderType) {
        orderHistoryPage.verifyActiveOrderByOrderType(orderType);
    }

    @Step
    public void enterProvidedOrderID(String orderId) {
        orderHistoryPage.enterProvidedOrderID(orderId);
    }

}
