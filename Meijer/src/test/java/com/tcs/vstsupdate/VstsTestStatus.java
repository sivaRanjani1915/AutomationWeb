package com.tcs.vstsupdate;

import com.tcs.automation.pages.VstsTestResultUpdate;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VstsTestStatus {

    static DefaultHttpClient httpClient = new DefaultHttpClient();


    public static int createTestRun(int testPointId, int testPlanId) throws IOException {

        int runid;
        HttpPost postRequest = new HttpPost("https://Meijervsts.visualstudio.com/Meijer/_apis/test/runs?api-version=1.0");
        String req = createRunRequest(testPointId, testPlanId);
        StringEntity input = new StringEntity(req);
        input.setContentType("application/json");

        postRequest.addHeader("Authorization",
                "Basic OmllcmIzeWl5c2p3a3gzb2c0b2ptc3hyaHVvcjVkaXVpd3JyYWk3cmIzcW1oNDZucWQzaXE=");
        postRequest.addHeader("Content-Type", "application/json");
        postRequest.setEntity(input);

        HttpResponse response = httpClient.execute(postRequest);

		/*
         * if (response.getStatusLine().getStatusCode() != 201) { throw new
		 * RuntimeException("Failed : HTTP error code : " +
		 * response.getStatusLine().getStatusCode()); }
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (response.getEntity().getContent())));

        String output;
        // System.out.println("Output from Server .... \n");
        output = br.readLine();

        JSONObject myObject = new JSONObject(output);

        runid = myObject.getInt("id");
        //System.out.println(runid);

        return runid;
    }


    private static String createRunRequest(int pointid, int testPlanId) {
        String runreq = null;
        JSONObject object = new JSONObject();
        object.put("name", VstsTestResultUpdate.scenarioName);
        JSONObject plan = new JSONObject();
        plan.put("id", testPlanId);
        object.put("plan", plan);
        object.put("state", "NotStarted");

        JSONArray array = new JSONArray();
        array.put(0, pointid);

        object.put("pointIds", array);
        runreq = object.toString();
        // System.out.print(runreq);
        return runreq;
    }


    public static void updateTestResult(int runid, String status) throws IOException {
        HttpPatch httpPatch = new HttpPatch("https://Meijervsts.visualstudio.com/Meijer/_apis/test/runs/"
                + runid + "/results?api-version=2.0-preview");
        String req = updateResultReq(status);
        StringEntity input = new StringEntity(req);
        input.setContentType("application/json");

        httpPatch.addHeader("Authorization",
                "Basic OmllcmIzeWl5c2p3a3gzb2c0b2ptc3hyaHVvcjVkaXVpd3JyYWk3cmIzcW1oNDZucWQzaXE=");
        httpPatch.addHeader("Content-Type", "application/json");
        httpPatch.setEntity(input);

        HttpResponse response = httpClient.execute(httpPatch);
        HttpEntity enty = response.getEntity();
        if (enty != null)
            enty.consumeContent();
        //httpClient.getConnectionManager().shutdown();
    }

    private static String updateResultReq(String Status) {
        String req = null;
        JSONObject object = new JSONObject();

        JSONObject testresult = new JSONObject();
        testresult.put("id", 100000);
        object.put("testResult", testresult);
        object.put("state", "Completed");
        // object.put("outcome", "Passed");
        object.put("outcome", Status);
        JSONArray array = new JSONArray();
        array.put(0, object);
        // System.out.print(array);
        req = array.toString();
        return req;

    }

    public static void updateTestRun(int runid)
            throws IOException {
        HttpPatch httpPatch = new HttpPatch("https://Meijervsts.visualstudio.com/Meijer/_apis/test/runs/" + runid + "?api-version=2.0-preview");
        String req = updateRunReq();
        StringEntity input = new StringEntity(req);
        input.setContentType("application/json");

        httpPatch.addHeader("Authorization",
                "Basic OmllcmIzeWl5c2p3a3gzb2c0b2ptc3hyaHVvcjVkaXVpd3JyYWk3cmIzcW1oNDZucWQzaXE=");
        httpPatch.addHeader("Content-Type", "application/json");
        httpPatch.setEntity(input);

        HttpResponse response = httpClient.execute(httpPatch);
        HttpEntity enty = response.getEntity();
        if (enty != null)
            enty.consumeContent();
    }

    private static String updateRunReq() {
        String req = null;
        JSONObject object = new JSONObject();
        object.put("state", "Completed");
        req = object.toString();
        return req;

    }
}

