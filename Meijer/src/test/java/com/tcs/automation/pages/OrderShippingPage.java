package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertNotEquals;


public class OrderShippingPage extends PageObject {

    //Shipping text on progress bar
    @FindBy(xpath = "//*[@id='main-container']/div[1]/div/div[1]/span[1]")
    public WebElement SHIPPING_TITLE_PROGRESS_BAR;

    //Enter Shipping Address Label
    @FindBy(xpath = "//h3[text()='Enter Shipping Address']")
    public WebElement ENTER_SHIPPING_ADDRESS_TITLE;

    //Enter Shipping Information Label
    @FindBy(xpath = "//h3[text()='Enter Shipping Information']")
    public WebElement ENTER_SHIPPING_INFORMATION_TITLE;


	/*-------------------Enter Shipping Address -----------------------*/

    //First Name text box field
    @FindBy(xpath = "//*[@id = 'firstName']")
    public WebElement FIRST_NAME_TEXTBOX;

    //Last Name text box field
    @FindBy(xpath = "//*[@id = 'lastName']")
    public WebElement LAST_NAME_TEXTBOX;

    //Address 1 textbox field
    @FindBy(xpath = "//*[@id='address1']")
    public WebElement ADDRESS_TEXTBOX;

    //City textbox field
    @FindBy(xpath = "//*[@id = 'city']")
    public WebElement CITY_TEXTBOX;

    //State Dropdown field
    @FindBy(xpath = "//*[@id = 'state']")
    public WebElement STATE_DROPDOWN;

    //zip code text box field
    @FindBy(xpath = "//*[@id='zipCode']")
    public WebElement ZIP_CODE_TEXTBOX;

    //Phone number textbox field
    @FindBy(xpath = "//*[@id = 'phoneNumber']")
    public WebElement PHONE_NUMBER_TEXTBOX;

    //Email textbox field
    @FindBy(xpath = "//*[@id = 'email']")
    public WebElement EMAIL_TEXTBOX;

    //Delivery Method dropdown field
    @FindBy(xpath = "//select[@name='shipType']")
    public WebElement DELIVERY_METHOD_DROPDOWN;

    /*-----------------Entered Shipping Information-------------------*/

    //Gift Message textbox field
    @FindBy(xpath = "//*[@id='giftMessage']")
    public WebElement GIFT_MESSAGE_TEXTBOX;

    //Next Button on Shipping Page
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement NEXT_BUTTON_CHECKOUT_FLOW;

    @FindBy(xpath = "//*[@id='ccSecurityCode']")
    public WebElement SECURITY_CODE_TEXTBOX;

    @FindBy(xpath = "//*[@id='ccNumber']")
    public WebElement CREDIT_CARD_TEXTBOX;

    @FindBy(xpath = "(//*[@class='error-message'])[1]")
    public WebElement CHECKOUT_FLOW_ERROR_CHECK;

    utilityhelper UtilityHelper;


/*======================================================Shipping Page Action====================================================*/

    //
    public void shippingPageDisplay() {
        Assert.assertEquals(Constants.shippingLabelOnProgressBar, UtilityHelper.elementGetText(SHIPPING_TITLE_PROGRESS_BAR));
        Assert.assertEquals(Constants.enterShippingAddressLabel, UtilityHelper.elementGetText(ENTER_SHIPPING_ADDRESS_TITLE));
        Assert.assertEquals(Constants.enterShippingInformationLabel, UtilityHelper.elementGetText(ENTER_SHIPPING_INFORMATION_TITLE));
    }

    //Enter First Name in Shipping Info
    public void enterFirstName(String firstName) {
        UtilityHelper.waitUntilClickable(FIRST_NAME_TEXTBOX);
        UtilityHelper.typeIntoElement(FIRST_NAME_TEXTBOX, firstName);
    }

    //Enter Last Name in Shipping Info
    public void enterLastName(String lastName) {
        UtilityHelper.typeIntoElement(LAST_NAME_TEXTBOX, lastName);
    }

    //Enter Address1 in Shipping Info
    public void enterAddress(String address) {
        UtilityHelper.waitUntilClickable(ADDRESS_TEXTBOX);
        UtilityHelper.typeIntoElement(ADDRESS_TEXTBOX, address);
    }

    //Enter City in Shipping Info
    public void enterCity(String city) {
        UtilityHelper.typeIntoElement(CITY_TEXTBOX, city);
    }

    //Select State in Shipping Info
    public void selectState(String state) {
        UtilityHelper.highLightElement(STATE_DROPDOWN);
        Select dropdown = new Select(STATE_DROPDOWN);
        dropdown.selectByVisibleText(state);
    }

    //Select State in Shipping Info
    public void enterZipCode(String zipCode) {
        UtilityHelper.typeIntoElement(ZIP_CODE_TEXTBOX, zipCode);
    }

    //Enter Ph number in Shipping Info
    public void enterPhoneNumber(String phoneNumber) {
        UtilityHelper.typeIntoElement(PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    //Enter Email in Shipping Info
    public void enterEmail(String email) {
        UtilityHelper.typeIntoElement(EMAIL_TEXTBOX, email);
    }

    public void enterGiftMessage(String giftmsg) {
        UtilityHelper.typeIntoElement(GIFT_MESSAGE_TEXTBOX, giftmsg);
    }

    //
    public void clickNextButtonOnOrderFlow() {
        UtilityHelper.waitUntilClickable(NEXT_BUTTON_CHECKOUT_FLOW);
        UtilityHelper.click(NEXT_BUTTON_CHECKOUT_FLOW);
    }

    public void checkForAnyErrorsDuringCheckoutFlow() throws InterruptedException {
        String error = UtilityHelper.elementGetText(CHECKOUT_FLOW_ERROR_CHECK);
        WebElement topOfThePage = getDriver().findElement(By.xpath("//*[@id='logo']"));
        Boolean isOnBillingPage = UtilityHelper.elementExists(By.xpath("//h3[text()='Enter Payment Information']"));
        UtilityHelper.moveToViewElement(topOfThePage);
        // if error message is UE error
        if (error.contains(Constants.UE_ERROR) && isOnBillingPage) {
            reEnterCreditCardCVV_Code();
        } else {
            getDriver().navigate().refresh();
        }
        Thread.sleep(5000);
        // if error message is bypassed. Proceed through checkout
        if (UtilityHelper.elementExists(NEXT_BUTTON_CHECKOUT_FLOW)) {
            UtilityHelper.moveToViewElement(NEXT_BUTTON_CHECKOUT_FLOW);
            UtilityHelper.click(NEXT_BUTTON_CHECKOUT_FLOW);
        }
        Thread.sleep(3000);
    }

    private void reEnterCreditCardCVV_Code() {
        UtilityHelper.waitUntilClickable(CREDIT_CARD_TEXTBOX);
        String CVV;
        String creditCard = UtilityHelper.elementGetText(CREDIT_CARD_TEXTBOX);
        switch (creditCard) {
            // American Express
            case "341111597242000":
                CVV = "1154";
                break;
            // Discover
            case "6011000993464365":
                CVV = "812";
                break;
            // Meijer CC
            case "5127112000500983":
                CVV = "909";
                break;
            // Master Card / Visa
            default:
                CVV = "222";
                break;
        }
        System.out.println("CC  [" + creditCard + "]");
        System.out.println("CVV [" + CVV + "]");
        UtilityHelper.typeIntoElement(SECURITY_CODE_TEXTBOX, CVV);
    }

    //To Select Shipping Method
    public void selectShippingDeliveryMethod(String dvrymethd) {
        UtilityHelper.highLightElement(DELIVERY_METHOD_DROPDOWN);
        Select dropdown = new Select(DELIVERY_METHOD_DROPDOWN);
        dropdown.selectByVisibleText(dvrymethd);
    }

    public void verifyNoStaticMessage_ShippingPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='hide']/div"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message in Shipping page for STH order===");
    }

}
