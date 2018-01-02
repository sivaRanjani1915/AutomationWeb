package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.HomePage;
import com.tcs.automation.pages.LaunchPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import static com.tcs.automation.Definition_RunnerClass.Environment;


public class LaunchStepsSerenity extends ScenarioSteps {
    LaunchPage launchPage;

    public static Boolean isSSI_State = false;
    HomePage homePage;
    utilityhelper UtilityHelper;


    @Step
    @Title("Launching \"" + Environment + "\"")
    public void launchURL() {
//        getDriver().manage().window().maximize();
        // sets size to VM's resolution
        getDriver().manage().window().setSize(new Dimension(1050, 795));
        launchPage.openAt(Environment);
        System.out.println("=== LAUNCHING " + Environment.toUpperCase());
    }

    @Step
    public void verifyPageLoad() {
        Assert.assertTrue(UtilityHelper.isDisplayed(homePage.MEIJER_LOGO));
    }

    @Step
    public void refreshBrowserWindow() {
        getDriver().navigate().refresh();
    }

    @Step
    public void closeBrowserWindow() {
        getDriver().close();
    }

    @Step
    public void enterSSI_State() throws InterruptedException, IOException, ParseException {
        saveAllCookies();
        getDriver().close();
        launchURL();
        loadAllCookies();
        isSSI_State = true;
    }

    @Step
    public void closeTab() {
        getDriver().close();
    }

    public void saveAllCookies() throws IOException {
        System.out.println("============= SAVE ALL COOKIES ==========");
        File f = new File("Cookies.data");
        if (f.exists())
            f.delete();
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        //DEBUG
//        System.out.println("Number of cookies: " + getDriver().manage().getCookies().size());

        for (Cookie ck : getDriver().manage().getCookies()) {
            //skip domains that arent .meijer.com or the exact domain we're at, otherwise loadAllCookies chokes.
            //this is fine, as caccounts.meijer.com isnt carried over between browser sessions anyways
            if ((!ck.getDomain().equals(".meijer.com")) && (!ck.getDomain().equals(Environment.toLowerCase())))
                continue;

//            System.out.println("=== Cookie Name:   " + ck.getName());
//            System.out.println("=== Cookie Domain: " + ck.getDomain());
//            System.out.println("=== Cookie Expiry: " + ck.getExpiry() + "\n");

            bw.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();
    }


    public void loadAllCookies() throws IOException, ParseException {
        System.out.println("================ ENABLE SSI =============");
        File f = new File("Cookies.data");
        FileReader fileReader = new FileReader(f);
        BufferedReader bf = new BufferedReader(fileReader);
        String strline;
        while ((strline = bf.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(strline, ";");
            while (token.hasMoreTokens()) {
                String name = token.nextToken();
                String value = token.nextToken();
                String domain = token.nextToken();
                String path = token.nextToken();
                Date expiry = null;
                String val;
                if (!(val = token.nextToken()).equals("null")) {
                    DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z y");
                    expiry = originalFormat.parse(val);
                    Boolean isSecure = new Boolean(token.nextToken());
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
//                    System.out.println("=== Cookie Name: " + ck.getName());
                    getDriver().manage().addCookie(ck); // This will add the stored cookie to your current session
                } else
                    token.nextToken(); //chew up boolean token if theres no date, to keep data alignment
            }
        }
        getDriver().navigate().refresh();
    }

}
