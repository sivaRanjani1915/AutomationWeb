package com.tcs.automation.pages;

import net.thucydides.core.pages.PageObject;

public class VstsTestResultUpdate extends PageObject {

    public static String scenarioName;
    public static int pointId;
    public static int planId;

    public void vstsInitialize(String tcName, int testPointId, int testPlanId) {
        scenarioName = tcName;
        pointId = testPointId;
        planId = testPlanId;
    }

}


