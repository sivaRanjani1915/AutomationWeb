package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderConfirmPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class OrderConfirmStepsSerenity extends ScenarioSteps {

    OrderConfirmPage orderConfirmPage;

    @Step
    public void confirmPageDisplay() {
        orderConfirmPage.confirmPageDisplay();
    }

    @Step
    public void highLightClickReturnHomeButton() {
        orderConfirmPage.highLightClickReturnHomeButton();
    }

    @Step
    public void userClickReturnHomeButton() {
        orderConfirmPage.userClickReturnHomeButton();
    }

    @Step
    public void noteDownOrderNumberAfterOrderPlaced() {
        orderConfirmPage.noteDownOrderNumberAfterOrderPlaced();
    }

    @Step
    public void highLightEditOrderButton() {
        orderConfirmPage.highLightEditOrderButton();
    }

    @Step
    public void userClickEditOrderButton() {
        orderConfirmPage.userClickEditOrderButton();
    }

    @Step
    public void verifyNoStaticMessage_ConfirmPage() {
        orderConfirmPage.verifyNoStaticMessage_ConfirmPage();
    }


    @Step
    public void verifyStaticMessage_ConfirmPage() {
        orderConfirmPage.verifyStaticMessage_ConfirmPage();
    }

}
