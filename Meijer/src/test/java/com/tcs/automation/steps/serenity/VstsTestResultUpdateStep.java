package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.VstsTestResultUpdate;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class VstsTestResultUpdateStep extends ScenarioSteps {

    VstsTestResultUpdate vstsTestResultUpdate;

    @Step
    public void userExecuteTestCaseDS(String tcName, int testPointId, int testPlanId) {
        vstsTestResultUpdate.vstsInitialize(tcName, testPointId, testPlanId);
    }
}
