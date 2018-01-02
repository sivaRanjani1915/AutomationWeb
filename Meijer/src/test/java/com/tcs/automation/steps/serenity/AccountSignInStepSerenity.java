package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.AccountSignInPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountSignInStepSerenity extends ScenarioSteps {

    AccountSignInPage accountSignInPage;

    @Step
    public void user_Enter_Correct_Email_Address(String correctemail) throws InterruptedException {
        accountSignInPage.validEmailAddress(correctemail);
    }

    @Step
    public void highLightNextButton() {
        accountSignInPage.highLightNextButton();
    }

    @Step
    public void nextButonAfterEnteringEmail() throws InterruptedException {
        accountSignInPage.nextButtonAfterEnteringEmail();
    }

    @Step
    public void user_ShouldNavigateToEnterPasswordScreen() {
        accountSignInPage.navigateToPasswordScreen();
    }

    @Step
    public void user_EnterValidPassword(String correctpassword) {
        accountSignInPage.enterCorrectPassword(correctpassword);
    }

    @Step
    public void highLightSignInButton() {
        accountSignInPage.highLightSignInButton();
    }

    @Step
    public void clickSignInButtonAfterEnteringPassword() throws InterruptedException {
        accountSignInPage.clickSignInButtonAfterEnteringPassword();
    }



}
