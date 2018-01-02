package com.tcs.automation.pages;


import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;




public class AccountSignInPage extends PageObject {

    utilityhelper UtilityHelper;

    //Email Address or mPerks Phone Number Field
    @FindBy(xpath = "//*[@name='email']")
    public static WebElement emailaddressfield;

    //NEXT Button
    @FindBy(xpath = "//button[contains(.,'Next')]")
    public static WebElement NEXT_BUTTON;

    //Password text box field
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordtextboxfield;

    //Sign In button
    @FindBy(xpath = "//*[@class='form-group email-login-btn ng-scope']//*[@ng-click='formSignin()']")
    public WebElement SIGN_IN_BUTTON;

    public String textComparison = null;

    //Enter Email screen
    public void validEmailAddress(String correctemail) {
        textComparison = correctemail;
        UtilityHelper.waitUntilClickable(emailaddressfield);
        UtilityHelper.typeIntoElement(emailaddressfield, correctemail);
        System.out.println("=== EMAIL [" + correctemail + "]");
    }

    public void highLightNextButton() {
        UtilityHelper.highLightElement(NEXT_BUTTON);
    }

    public void nextButtonAfterEnteringEmail() throws InterruptedException {
       UtilityHelper.click(NEXT_BUTTON);
        Thread.sleep(1000);
    }

    public void navigateToPasswordScreen() {
        UtilityHelper.waitUntilElementVisible(passwordtextboxfield);
    }

    public void enterCorrectPassword(String correctpassword) {
        UtilityHelper.waitUntilClickable(passwordtextboxfield);
        UtilityHelper.typeIntoElement(passwordtextboxfield, correctpassword);
    }

    public void highLightSignInButton() {
        UtilityHelper.highLightElement(SIGN_IN_BUTTON);
    }

    public void clickSignInButtonAfterEnteringPassword() {
        UtilityHelper.waitUntilClickable(SIGN_IN_BUTTON);
       UtilityHelper.click(SIGN_IN_BUTTON);
        String by = "//input[@name='password']";
        if (UtilityHelper.elementExists(By.xpath(by))) {
            UtilityHelper.waitUntilElementNotVisible(By.xpath(by));
        }
        Assert.assertTrue("Verify Log In Modal Vanished: ", UtilityHelper.elementNotExists(By.xpath(by)));
    }

}

