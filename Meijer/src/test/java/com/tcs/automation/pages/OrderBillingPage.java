package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

public class OrderBillingPage extends PageObject {



    //Billing and Payment Header Text
    @FindBy(xpath = "//li[text()='Billing and Payment']")
    public WebElement billingAndPaymentHeaderText;

    //Billing Text on Progress Bar
    @FindBy(xpath = "//span[text()='Billing']")
    public WebElement billingTextOnProgressBar;

    /*------------------------Enter Payment Information-----------------------*/
    //Enter Payment Information H3 Header
    @FindBy(xpath = "//h3[text()='Enter Payment Information']")
    public WebElement enterPaymentInformationH3TextBilling;

    //Credit Card select dropdown field Payment info for SignIn account
    @FindBy(xpath = "//*[@id = 'credit-card-select']")
    public WebElement selectCreditCardDropdownEnterPaymentInfo;

    //First Name text box field
    @FindBy(xpath = "//*[@id = 'firstName']")
    public WebElement FIRST_NAME_TEXTBOX;

    //Last Name textbox field
    @FindBy(xpath = "//*[@id = 'lastName']")
    public WebElement LAST_NAME_TEXTBOX;

    //Credit Card Number TextBox Field
    @FindBy(xpath = "//*[@id = 'ccNumber']")
    public WebElement CREDIT_CARD_TEXTBOX;

    //Expiration Date Month Dropdown field
    @FindBy(xpath = "//select[@name='ccMonth']")
    public WebElement EXPIRE_MONTH_DROPDOWN;

    //Expiration Date Year Dropdown field
    @FindBy(xpath = "//select[@name='ccYear']")
    public WebElement EXPIRE_YEAR_DROPDOWN;

    //CC Security Code TextBox Field
    @FindBy(xpath = "//*[@id = 'ccSecurityCode']")
    public WebElement SECURITY_CODE_TEXTBOX;

    //Billing Address 1 TextBox Field
    @FindBy(xpath = "//*[@id = 'address1']")
    public WebElement ADDRESS_TEXTBOX;

    //Billing City TextBox Field
    @FindBy(xpath = "//*[@id = 'city']")
    public WebElement CITY_TEXTBOX;

    //Billing State TextBox Field
    @FindBy(xpath = "//select[@name='state']")
    public WebElement STATE_DROPDOWN;

    //Billing Zip
    @FindBy(xpath = "//*[@id = 'zipCode']")
    public WebElement ZIP_CODE_TEXTBOX;

    //Save this Credit Card CheckBox
    @FindBy(xpath = "//*[@name='saveCreditCard']")
    public WebElement saveCreditCardCheckBox;

    /*-------------Pickup Info--------------------*/

    //Pickup Date/ Time value Display under pickup info section
    @FindBy(xpath = "//*[@id='hide']/div/div[3]/strong[1]/span")
    public WebElement pickupDateTimeValueDisplayPickupInfoBilling;

    //Car Description value display under pickup info section
    @FindBy(xpath = "//*[@id='hide']/div/div[3]/strong[2]")
    public WebElement carDescriptionValueDisplayPickupInfoBilling;

    //Pickup Location with Car desc
    @FindBy(xpath = "//*[@id='hide']/div/div[3]/strong[3]")
    public WebElement pickuplocationWithoutCarDescInfoBilling;

    //Pickup Location Curbside without car description
    @FindBy(xpath = "//*[@id='hide']/div/div[3]/strong[2]")
    public WebElement pickuplocationWithCarDescInfoBilling;

    /*---------------------- Error Messaging ----------------------*/

    //Street Address
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a street address.')]")
    public WebElement errorMsgStreetAddress;

    //Zip Code
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a ZIP code.')]")
    public WebElement errorMsgZipCode;

    //City
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a city.')]")
    public WebElement errorMsgCity;

    //State
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please select a state.')]")
    public WebElement errorMsgState;

    //CheckBox - Billing Info same as Shipping
    @FindBy(xpath = "//*[@id = 'useBillingAddress']")
    public WebElement checkBoxBillingInfoSameAsShippingBillingPage;

    //First name error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[1]/fieldset/div[1]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgFirstNameBillingPage;

    //Last name error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[1]/fieldset/div[2]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgLastNameBillingPage;

    //Credit Card error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[1]/fieldset/div[3]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgCreditCardBillingPage;

    /*---Error message field elements ----*/

    //Billing Address error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[2]/fieldset/div[1]/div[2][contains (@class, 'error-message')]")
    public WebElement errorMsgBillingAddressBillingPage;

    //Billing Zip error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[2]/fieldset/div[3]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgBillingZipBillingPage;

    //Billing City error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[2]/fieldset/div[4]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgBillingCityBillingPage;

    //Billing State error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[2]/fieldset/div[5]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgBillingStateBillingPage;

    //Expire Date error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[1]/fieldset/div[4]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgCCExpirationDateBillingPage;

    //Security Code error message
    @FindBy(xpath = "//*[@class='col-xs-12 col-md-4 enter-billing_info']/div[1]/fieldset/div[5]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgCCSecurityCodeBillingPage;

    utilityhelper UtilityHelper;




/*=====================================Billing Page Action==================================================*/

    public void userClickEditPickupLinkOnBillingPage() {
        getDriver().findElement(By.xpath("//*[@id='editPickup']")).click();
    }

    public void billingPageDisplay() {
        UtilityHelper.waitUntilClickable(billingAndPaymentHeaderText);
        Assert.assertEquals("Billing and Payment", billingAndPaymentHeaderText.getText());
        Assert.assertEquals("Billing", billingTextOnProgressBar.getText());
        Assert.assertEquals("Enter Payment Information", enterPaymentInformationH3TextBilling.getText());
    }

    //Select existing credit card details of Billing page
    public void userSelectExistingCreditCardForProvidingPaymentInfo(String ccsecurityCode) {
        Select dropdown = new Select(selectCreditCardDropdownEnterPaymentInfo);
        dropdown.selectByIndex(0);
        SECURITY_CODE_TEXTBOX.sendKeys(ccsecurityCode);
    }

    //Enter Payment Information
    public void enterCreditCardPaymentInfoBilling(String ccNumber, String expireMon, String expireYr, String ccSecurity) {
        UtilityHelper.typeIntoElement(CREDIT_CARD_TEXTBOX, ccNumber);
        UtilityHelper.selectFromDropdownMenu(EXPIRE_MONTH_DROPDOWN, hybridSelectExpirationMonth(expireMon));
        UtilityHelper.selectFromDropdownMenu(EXPIRE_YEAR_DROPDOWN, expireYr);
        UtilityHelper.typeIntoElement(SECURITY_CODE_TEXTBOX, ccSecurity);
    }

    public void enterNameInfoBilling(String firstName, String lastName) {
        UtilityHelper.waitUntilClickable(FIRST_NAME_TEXTBOX);
        UtilityHelper.typeIntoElement(FIRST_NAME_TEXTBOX, firstName);
        UtilityHelper.typeIntoElement(LAST_NAME_TEXTBOX, lastName);
    }

    public void enterAddressInfoBilling(String address1, String city, String state, String zipCode) {
        UtilityHelper.typeIntoElement(ADDRESS_TEXTBOX, address1);
        UtilityHelper.typeIntoElement(ZIP_CODE_TEXTBOX, zipCode);
        UtilityHelper.typeIntoElement(CITY_TEXTBOX, city);
        UtilityHelper.highLightElement(STATE_DROPDOWN);
        STATE_DROPDOWN.sendKeys(state);
    }

    private String hybridSelectExpirationMonth(String expireMon) {
        String month = null;
        switch (expireMon.toUpperCase()) {
            case "1":
            case "JANUARY":
                month = "January (01)";
                break;
            case "2":
            case "FEBRUARY":
                month = "February (02)";
                break;
            case "3":
            case "MARCH":
                month = "March (03)";
                break;
            case "4":
            case "APRIL":
                month = "April (04)";
                break;
            case "5":
            case "MAY":
                month = "May (05)";
                break;
            case "6":
            case "JUNE":
                month = "June (06)";
                break;
            case "7":
            case "JULY":
                month = "July (07)";
                break;
            case "8":
            case "AUGUST":
                month = "August (08)";
                break;
            case "9":
            case "SEPTEMBER":
                month = "September (09)";
                break;
            case "10":
            case "OCTOBER":
                month = "October (10)";
                break;
            case "11":
            case "NOVEMBER":
                month = "November (11)";
                break;
            case "12":
            case "DECEMBER":
                month = "December (12)";
                break;
            default:
                Assert.fail("Invalid Month parameter [" + expireMon + "]");
        }
        return month;
    }

    //Auto filled value validation Billing Page
    public void autoFilledValidationBillingPage(String firstname, String lastname, String address1, String city, String statecode, String zipcode) {
        Assert.assertEquals("=== Assert first name textbox ", firstname.toUpperCase(), FIRST_NAME_TEXTBOX.getAttribute("value").toUpperCase());
        Assert.assertEquals("=== Assert last name textbox ", lastname.toUpperCase(), LAST_NAME_TEXTBOX.getAttribute("value").toUpperCase());
        Assert.assertEquals("=== Assert address1 textbox ", address1.toUpperCase(), ADDRESS_TEXTBOX.getAttribute("value").toUpperCase());
        Assert.assertEquals("=== Assert city textbox ", city.toUpperCase(), CITY_TEXTBOX.getAttribute("value").toUpperCase());
        Assert.assertEquals("=== Assert state code textbox ", statecode.toUpperCase(), STATE_DROPDOWN.getAttribute("value").toUpperCase());
        Assert.assertEquals("=== Assert zipcode textbox ", zipcode, ZIP_CODE_TEXTBOX.getAttribute("value"));
    }

    public void userSelectsUseBillingAddressCheckbox() {
        getDriver().findElement(By.xpath("//input[@id='useBillingAddress']")).click();
    }

    //Pickup info validation for pickup related details
    public void pickupDateAndTimeValidationBillingPage() {
        System.out.println("=== pickup time from pickup page: " + OrderPickupPage.pickupTime);
        System.out.println("=== Element value display: " + pickupDateTimeValueDisplayPickupInfoBilling.getText());
        Assert.assertTrue(pickupDateTimeValueDisplayPickupInfoBilling.getText().contains(OrderPickupPage.pickupTime));
    }

    public void pickupDetailsCarDescValidationBillingPage(String cardesc) {
        System.out.println("=== Car description return from Element: " + carDescriptionValueDisplayPickupInfoBilling.getText());
        Assert.assertEquals(cardesc.toUpperCase(), carDescriptionValueDisplayPickupInfoBilling.getText().toUpperCase());
    }

    public void pickupLocationValidation_withCarDesc_BillingPage(String pickuploc) {
        Assert.assertEquals(pickuploc.toUpperCase(), pickuplocationWithoutCarDescInfoBilling.getText().toUpperCase());
    }

    public void pickupLocationValidation_WithoutCarDesc_BillingPage(String pickuploc) {
        Assert.assertEquals(pickuploc.toUpperCase(), pickuplocationWithCarDescInfoBilling.getText().toUpperCase());
    }

    public void errorMessageStreetAddress() {
        UtilityHelper.moveToViewElement(errorMsgStreetAddress);
        Assert.assertTrue("Verify Street Address Error Message Display ", errorMsgStreetAddress.isDisplayed());
        Assert.assertTrue("Verify Street Address Error Message Copy ", Constants.msgErrorStreetAddress.contains(errorMsgStreetAddress.getText()));
    }

    public void errorMessageZipCode() {
        UtilityHelper.moveToViewElement(errorMsgZipCode);
        Assert.assertTrue("Verify Zip Code Error Message Display ", errorMsgZipCode.isDisplayed());
        Assert.assertTrue("Verify Zip Code Error Message Copy ", Constants.msgErrorZipCode.contains(errorMsgZipCode.getText()));
    }

    public void errorMessageCity() {
        UtilityHelper.moveToViewElement(errorMsgCity);
        Assert.assertTrue("Verify City Error Message Display ", errorMsgCity.isDisplayed());
        Assert.assertTrue("Verify City Error Message Copy ", Constants.msgErrorCity.contains(errorMsgCity.getText()));
    }

    public void errorMessageState() {
        UtilityHelper.moveToViewElement(errorMsgState);
        Assert.assertTrue("Verify State Error Message Display ", errorMsgState.isDisplayed());
        Assert.assertTrue("Verify State Error Message Copy ", Constants.msgErrorState.contains(errorMsgState.getText()));
    }

    //To click on Save This Address On Address Book CheckBox
    public void toSelectSaveCreditCardToYourAccountCheckbox() {
        saveCreditCardCheckBox.click();
    }

    //To click on CheckBox for Billing Info Same as Shipping
    public void clickCheckBox_BillingInfoSameasShipping() {
        UtilityHelper.waitUntilClickable(checkBoxBillingInfoSameAsShippingBillingPage);
        checkBoxBillingInfoSameAsShippingBillingPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //validate Blank First Name Error Message - Billing Page
    public void validate_Blank_FirstName_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.firstNameBlankErrorMsg, errorMsgFirstNameBillingPage.getText());
    }

    //validate Blank Last Name Error Message - Billing Page
    public void validate_Blank_LastName_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.lastNameBlankErrorMsg, errorMsgLastNameBillingPage.getText());
    }

    //validate Blank Credit Card Error Message - Billing Page
    public void validate_Blank_CreditCard_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.creditcardBlankErrorMsg, errorMsgCreditCardBillingPage.getText());
    }

    //validate Blank Billing Address Error Message - Billing Page
    public void validate_Blank_BillingAddresse_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.billingaddressBlankErrorMsgBillingPage, errorMsgBillingAddressBillingPage.getText());
    }

    //validate Blank Billing Zip Error Message - Billing Page
    public void validate_Blank_BillingZip_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.billingzipBlankErrorMsg, errorMsgBillingZipBillingPage.getText());
    }

    //validate Blank Billing City Error Message - Billing Page
    public void validate_Blank_BillingCity_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.billingCityBlankErrorMsg, errorMsgBillingCityBillingPage.getText());
    }

    //validate Blank Billing State Error Message - Billing Page
    public void validate_Blank_BillingState_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.billingStateBlankErrorMsg, errorMsgBillingStateBillingPage.getText());
    }

    //Validate Blank CC Expiration Date - Billing page
    public void validate_Blank_CCExpirationDate_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.ccExpirationDateBlankErrorMsg, errorMsgCCExpirationDateBillingPage.getText());
    }

    //Validate Blank Security Code - Billing page
    public void validate_Blank_CCSecurityCode_ErrorMsg_billingpage() {
        Assert.assertEquals(Constants.ccSecurityCodeBlankErrorMsg, errorMsgCCSecurityCodeBillingPage.getText());
    }

    //Enter only credit card details
    public void enter_CCDetailsOnly(String ccnumber) {
        CREDIT_CARD_TEXTBOX.clear();
        CREDIT_CARD_TEXTBOX.sendKeys(ccnumber); //Visa Card
    }

    public void verifynostaticmessbill() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mjr-rightSidebar']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message in Billing page for STH order===");
    }

    public void verifyNoStaticMessage_BillingPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mjr-rightSidebar']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Prices shown today may differ at time of pickup due to weighted items and weekly ad pricing.", staticmessage_shop.getText());
        System.out.println("===Verified No Tooltip  in billing page for STH order===");
    }

    public void verifyStaticMessage_BillingPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='disclaimerText']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified the static message in billing page===");
    }


}
