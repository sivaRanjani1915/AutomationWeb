package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.LaunchStepsSerenity;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.text.ParseException;


public class LaunchStepDefinition {

    @Steps
    LaunchStepsSerenity launchSteps;

    @Given("user navigate to test environment URL")
    public void launchMeijerDotCom() throws InterruptedException {
        launchSteps.launchURL();
        Thread.sleep(5000);
        launchSteps.verifyPageLoad();
    }

    @Given("user navigate to MeijerDotCom")
    public void launchesMperks() throws InterruptedException {
        launchSteps.launchURL();
        Thread.sleep(5000);
        launchSteps.verifyPageLoad();
    }

    @Then("user refreshes the browser window")
    public void refreshBrowserWindow() {
        launchSteps.refreshBrowserWindow();
    }

    @Then("user closes browser window to end browser session")
    public void closeBrowserWindow() {
        launchSteps.closeBrowserWindow();
    }

    @Then("user closes and opens browser to enter SSI state")
    public void enterSSI_State() throws InterruptedException, IOException, ParseException {
        launchSteps.enterSSI_State();
    }

    @Then("user closes tab")
    public void closeTab() {
        launchSteps.closeTab();
    }
}
