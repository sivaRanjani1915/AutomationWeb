package com.tcs.automation.steps;

import com.tcs.automation.pages.VstsTestResultUpdate;
import com.tcs.automation.steps.serenity.VstsTestResultUpdateStep;
import com.tcs.utilityhelpers.VstsStatusUpdate;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class VstsTestResultUpdateStepDefinition {

    @Steps
    VstsTestResultUpdateStep vstsTestResultUpdateStep;

    @Given("the user sets testcase configurations (?:\"|')(.*)(?:\"|') (?:\"|')(.*)(?:\"|') (?:\"|')(.*)(?:\"|')")
    public void theUserExecuteTestCaseDS(String tcName, int testPointId, int testPlanId) {
        vstsTestResultUpdateStep.userExecuteTestCaseDS(tcName, testPointId, testPlanId);
    }


    // This is "disabled" in DEV branch.
    // But will be enabled in UAT branch.
    // ** This way, VSTS will have test scripts updated as pass/fail according to UAT test results. **
//    @After
    public void vstsStatusUpdation(Scenario scenario) throws IOException {
        VstsStatusUpdate.updateTestStatus(VstsTestResultUpdate.pointId, VstsTestResultUpdate.planId, scenario.isFailed());
    }

}
