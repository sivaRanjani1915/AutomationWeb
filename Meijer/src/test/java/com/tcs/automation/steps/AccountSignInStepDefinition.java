package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.AccountSignInStepSerenity;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AccountSignInStepDefinition {


    @Steps
    AccountSignInStepSerenity accountSignInStepSerenity;


    //Correct email address
    @When("user enter correct email '(.*)'")
    public void userEnterCorrectEmailAddress(String correctemail) throws InterruptedException {
        accountSignInStepSerenity.user_Enter_Correct_Email_Address(correctemail);
        accountSignInStepSerenity.highLightNextButton();
        accountSignInStepSerenity.nextButonAfterEnteringEmail();
    }

    @Then("user should navigate to Enter Password screen")
    public void userShouldNavigateToEnterPasswordScreen() {
        accountSignInStepSerenity.user_ShouldNavigateToEnterPasswordScreen();
    }

    @When("user enter valid password '(.*)'")
    public void userEnterValidPassword(String correctpassword) throws InterruptedException {
        accountSignInStepSerenity.user_EnterValidPassword(correctpassword);
        accountSignInStepSerenity.highLightSignInButton();
        accountSignInStepSerenity.clickSignInButtonAfterEnteringPassword();
    }

}

	