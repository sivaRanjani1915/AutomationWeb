package com.tcs.utilityhelpers;

import com.tcs.vstsupdate.VstsTestStatus;

import java.io.IOException;

public class VstsStatusUpdate {


    public static void updateTestStatus(int testpointId, int testplanId, boolean scenarioFailedStatus) throws IOException {
        int runid;
        String status;
        runid = VstsTestStatus.createTestRun(testpointId, testplanId);
        if (scenarioFailedStatus)
            status = "Failed";
        else
            status = "Passed";
        VstsTestStatus.updateTestResult(runid, status);
        VstsTestStatus.updateTestRun(runid);
    }

}
