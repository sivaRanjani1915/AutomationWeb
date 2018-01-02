package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.OrderConfirmStepsSerenity;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OrderConfirmStepDefinition {

    @Steps
    OrderConfirmStepsSerenity orderConfirmStepSerenity;

    @Then("confirm page display")
    public void confirmPageDisplay() {
        orderConfirmStepSerenity.confirmPageDisplay();
    }

    @Then("user click Return Home button on confirm page")
    public void userClickReturnHomeButton() {
        orderConfirmStepSerenity.highLightClickReturnHomeButton();
        orderConfirmStepSerenity.userClickReturnHomeButton();
    }

    @Then("note down order number after order placed")
    public void noteDownOrderNumberAfterOrderPlaced() {
        orderConfirmStepSerenity.noteDownOrderNumberAfterOrderPlaced();
    }

    @Then("user clicks edit order button on order confirmation page")
    public void userClickEditOrderButton() {
        orderConfirmStepSerenity.highLightEditOrderButton();
        orderConfirmStepSerenity.userClickEditOrderButton();
    }

    @Then("verify no static message in confirm page")
    public void verifyNoStaticMessage_ConfirmPage() {
        orderConfirmStepSerenity.verifyNoStaticMessage_ConfirmPage();
    }

    @Then("verify static message is displayed in confirm page")
    public void verifyStaticMessage_ConfirmPage() {
        orderConfirmStepSerenity.verifyStaticMessage_ConfirmPage();
    }

}
