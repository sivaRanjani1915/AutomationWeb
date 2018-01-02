package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderPickupPage extends PageObject {

    static String pickupTime = null;
    static String pickupDate = null;
    static String reserveduntil = null;
    public static String firstSLOTavailable = null;
    public static String firstDAYavailable = null;

    // Schedule and Pickup Header Label
    @FindBy(xpath = "//li[text()='Schedule and Pickup']")
    public WebElement SCHEDULE_AND_PICKUP_TITLE;

    // Pickup Label in Progress Bar
    @FindBy(xpath = "//span[text()='Pickup']")
    public WebElement PICKUP_LABEL_PROGRESS_BAR;

    @FindBy(xpath = "//*[@id='pickup-info']/h3")
    public WebElement PICKUP_INFORMATION_TITLE;
    // First Name
    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement FIRST_NAME_TEXTBOX;

    // Home Page "Your Store" value
    @FindBy(xpath = "//*[@id='js-storeNameMsg']")
    public WebElement yourStoreValue;

    /*----------------------Pickup Info------------------------------------------*/
    // Last Name
    @FindBy(xpath = "//*[@id = 'lastName']")
    public WebElement LAST_NAME_TEXTBOX;

    // Phone Number - Textbox field
    @FindBy(xpath = "//*[@id = 'phoneNumber']")
    public WebElement PHONE_NUMBER_TEXTBOX;

    // Email Address textbox field
    @FindBy(xpath = "//*[@id = 'emailAddress']")
    public WebElement EMAIL_TEXTBOX;

    // Store Name field
    @FindBy(xpath = "//h4[@class='storeLocation-name']")
    public WebElement storeNameDisplayFieldShippingPickupInfo;

	/*------------ Pickup Info Error Messaging ------------*/

    // First Name
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a first name.')]")
    public WebElement errorMsgFirstName;

    // Last Name
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a last name.')]")
    public WebElement errorMsgLastName;

    // Phone Number
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter a valid phone number, including area code.')]")
    public WebElement errorMsgPhoneNumber;

    // Email Address
    @FindBy(xpath = "//*[contains(@class,'form-group')]//*[contains(text(),'Please enter an email.')]")
    public WebElement errorMsgEmailAddress;

	/*-------Pickup Information----------------*/

    // Shipping Method display Pickup Info
    @FindBy(xpath = "//*[@class='address-panel']/div[6]/span")
    public WebElement shippingMethodDisplayPickUpInfo;

    // Shipping Address Header Text Pickup Info
    @FindBy(xpath = "//h3[text()='Shipping Address']")
    public WebElement shippingAddressHeaderTextPickupInfo;

    // Address1 Display Pickup Info
    @FindBy(xpath = "//*[@class='address-panel']/div[1]")
    public WebElement address1DisplayPickupInfo;

    // Address 2 Display Pickup info
    @FindBy(xpath = "//*[@class='address-panel']/div[3]")
    public WebElement address2DisplayPickupInfo;

    // Item Number Count
    @FindBy(xpath = "//span[@class='items-number']")
    public WebElement itemNumberCountPickupInfo;

    // Pickup Location Info
    @FindBy(xpath = "//label[text()='Curbside']")
    public WebElement curbsideTextPickupLocationDisplayPickuoInfo;

    // Car Description textbox field
    @FindBy(xpath = "//*[@id='carDescription']")
    public WebElement CAR_DESCRIPTION_TEXTBOX;

    // Next Day Available Pickup time
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']/div[contains (@class, 'dayGroup day-1')]//*[@class='pickup-time-slot available']")
    public WebElement selectNextdayFirstavailablePickupslot;

    // TODO: This should ideally be moved out to select pickup time button, and
    // select pickup time link JoeG
    // Select Pick Up Time Button
    @FindBy(xpath = "//*[@id='pickReservationTime']//*[@class='mjr-btn mjr-secondary selectTime' or @id='changeLink']")
    public WebElement selectPickUpTimeButtonPickupPage;

    /*-------------------New Pickup Time----------------------*/
    // Date-0
    @FindBy(xpath = "//*[@id = 'date-0']")
    public WebElement clickFirstDayPickupPage;

    @FindBy(xpath = ".//*[@id='pickup-time-slots-id']")
    public WebElement allTimeslots;

    // Date-1
    @FindBy(xpath = "//*[@id = 'date-1']")
    public WebElement clickNextDayPickupPage;

    // Date-3
    @FindBy(xpath = "//*[@id = 'date-3']")
    public WebElement click3rdDayPickupPage;

    // Date-5
    @FindBy(xpath = "//*[@id = 'date-5']")
    public WebElement click5thDayPickupPage;

    // Pickup Times Heading Text
    @FindBy(xpath = "//*[@class='mainContent changePickupTime']/h1")
    public WebElement pickupTimesHeaderTextPickupPage;

    // Select Pickup Time Button
    @FindBy(xpath = "//button[text()='Select Pickup Time']")
    public WebElement selectPickupTimeButtonPickupTimesPopupPickupPage;

    @FindBy(xpath = "//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]")
    public WebElement seconddaypickup;

    // Disabled Select Pickup Time Button
    @FindBy(xpath = "//*[@id='pickupForm']//button[@class='mjr-btn mjr-secondary mjr-disabled']")
    public WebElement disabledSelectPickupTimeButton;

    // Update or Reserve Pickup Time Button
    // @FindBy(xpath = "//button[contains(text(), 'Pickup Time')]")
    @FindBy(xpath = "//*[@class='pickup-time-slot available selected']//button[@class='mjr-btn mjr-secondary' and text()='Reserve']")
    public WebElement RESERVE_TIME_BUTTON;

    // Cancel Button on Pickup Times popup
    @FindBy(xpath = "//button[@class='mjr-link cancelEditPickupTime' and text()='Cancel']")
    public WebElement cancelButtonPickupTimesPopupPickupPage;

    // Slot where HOLD Pickup Time Display- Signed In
    @FindBy(xpath = "//*[@id='reservationTime']/span[contains (@class, 'holdTime')]")
    public WebElement holdPickupTimeDisplayPickupPage;

    // Edit Store on RHS
    @FindBy(xpath = "//*[@class='store-address-panel']//a[text()='Edit']")
    public WebElement editlinkforChangeStorePickupPage;

    // change link to edit pickup time
    @FindBy(xpath = "//*[@id='reservationTime']/span[contains (text(), 'change')]")
    public WebElement changeLinktoEditPickupTime;

    // Pickup Time Model Header text
    @FindBy(xpath = "//*[@class='mjr-section-title' and text()='Pickup Times']")
    public WebElement pickupTimesHeaderonPopup;

    // Current HOLD Pickup Times
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']//*[@class='pickup-time-slot available selected active']")
    public WebElement currentHoldSlotPickUpTime;

    @FindBy(xpath = "//*[@id='pickup-time-slots-id']//*[contains(@class, 'selected')]")
    public WebElement selectedUpdateReservationPickupTime;

    // Validate Slot Reservation Pickup Time
    @FindBy(xpath = "//*[@id='reservationTime']/span[1]")
    public WebElement slotReservationInCheckoutFlow;

    // Validate RHR Slot Reservation
    @FindBy(xpath = "//*[@class='rightRail_holdTime']")
    public WebElement rigthHandRailSlotReserved;

    // Right Arrow on Pickup Times
    @FindBy(xpath = "//*[@id='pickUpArrowRight']/button")
    public WebElement rightArrowPickupTimesPopupWizard;

    @FindBy(xpath = "//*[@id='pickupDaySliderWindow']/ul/li[1]/span[1]")
    public WebElement pickupDaySliderWindow1;

    @FindBy(xpath = "//*[@class='dayGroup day-0']/div[contains (@class, 'noAvailableTimeMessage')]")
    public WebElement noslotavailableErrorMsgPickupTime;

    // Pickup Times Error message
    @FindBy(xpath = "//*[@id='pickupForm']/div[contains (@class, 'form-group')]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgPickupTimePickupPage;

    /*----Error Message Element-----*/
    // First name error message
    @FindBy(xpath = "//*[@id='pickup-info']/div[contains (@class, 'col-xs-12 col-md-6')]/div[1]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgFirstNamePickupPage;

    @FindBy(xpath = "//*[@class='fl curbsideMessage']")
    public WebElement curbsideWidget;

    // Curbside Widget - With Reservation Text
    @FindBy(xpath = "//*[@class='active line1 mjr-small clickable']")
    public WebElement curbsideWidgetWithActiveReservation;

    @FindBy(xpath = "//*[@class='mjr-small active pickupTime']")
    public WebElement curbsideWidgetWithActiveOrder;

    // Current Reserved Pickup Time in Pickup Time Modal
    @FindBy(xpath = "//*[@id='pickup-time-slots-id']//*[contains(@class, 'active')]")
    public WebElement currentReservedPickupTime;

    // Validate that Slot Reserved 'Day' is selected
    @FindBy(xpath = "//*[@id='pickupDaySliderWindow']//*[contains(@class, 'click')]")
    public WebElement reservedDateIsSelectedValidation;

    // Last name error message
    @FindBy(xpath = "//*[@id='pickup-info']/div[contains (@class, 'col-xs-12 col-md-6')]/div[2]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgLastNamePickupPage;

    // Phone Number error message
    @FindBy(xpath = "//*[@id='pickup-info']/div[contains (@class, 'col-xs-12 col-md-6')]/div[3]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgPhoneNumberPickupPage;

    // Email Address error message
    @FindBy(xpath = "//*[@id='pickup-info']/div[contains (@class, 'col-xs-12 col-md-6')]/div[4]/div[contains (@class, 'error-message')]")
    public WebElement errorMsgEmailAddressPickupPage;


    @FindBy(xpath = "//*[@id='modalContent']//*[@id='pickupForm']")
    public WebElement TIME_SLOT_MODAL;

    //list of pickup days available
    @FindBy(xpath = "//*[@id='pickupDaySliderWindow']/ul/li")
    public List<WebElement> PICKUP_DAY_SLIDER_LIST;

    @FindBy(xpath = "//*[@id='modalPickup_modal']/div/div/div[2]")
    public WebElement TIME_SLOT_MODAL_CLOSE_BUTTON;

    @FindBy(xpath = "//*[@class='holdTime']")
    public WebElement HOLD_TIME_PICKUP_PAGE;

    @FindBy(xpath = "//*[@id='pickReservationTime']//span[@class='mjr-btn mjr-secondary selectTime']")
    public WebElement SELECT_PICKUP_BUTTON;

    @FindBy(xpath = "//*[@onclick='pickTimeSlot();']")
    public WebElement CHANGE_PICKUP_LINK;

    //current or first day pickup slot day i.e Today
    @FindBy(xpath = "//*[@id='pickupDaySliderWindow']/ul/li[1]/span[1]")
    public WebElement todayPickup;


    utilityhelper UtilityHelper;

	/*-------------------------------------------------Order Pickup Page Action----------------------------------------------*/


    // To generate Random number
    private static int getRandomNumber(int min, int max) {
        if (min > max) {
            System.out.println("Incorrect number range defined!!!");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void validateScheduleAndPickupCopyDisplays() {
        Assert.assertEquals("Schedule and Pickup", UtilityHelper.elementGetText(SCHEDULE_AND_PICKUP_TITLE));
        Assert.assertEquals("Pickup", UtilityHelper.elementGetText(PICKUP_LABEL_PROGRESS_BAR));
        Assert.assertEquals("Pickup Information", UtilityHelper.elementGetText(PICKUP_INFORMATION_TITLE));
    }

    public void checkForNoCurbsideRadioButton() {
        WebElement staticmessage_shop = getDriver().findElement(By.xpath(".//*[@id='pickupForm']/div[2]"));
        Assert.assertNotEquals("curbside", staticmessage_shop.getText());
        System.out.println("===Verified No curbside radio button is available for CNC or CNC+SPO order===");
    }

    public void checkForNoDeliRadioButton() {
        WebElement staticmessage_shop = getDriver().findElement(By.xpath(".//*[@id='pickupForm']/div[2]"));
        Assert.assertNotEquals("Deli", staticmessage_shop.getText());
        System.out.println("===Verified No Deli/Bakery radio button is available for SPO order===");
    }

    // Verify auto filled value in Pickup info
    public void autoFilledNameValueValidationPickupInfo(String firstname, String lastname) {
        Assert.assertEquals("=== Asserting firstname:", firstname,
                FIRST_NAME_TEXTBOX.getAttribute("value"));
        Assert.assertEquals("=== Asserting lastname:", lastname, LAST_NAME_TEXTBOX.getAttribute("value"));
    }

    // Enter Pickup Info Name
    public void enterFirstName(String firstName) {
        UtilityHelper.typeIntoElement(FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterLastName(String lastName) {
        UtilityHelper.typeIntoElement(LAST_NAME_TEXTBOX, lastName);
    }

    // Enter Pickup Info
    public void enterPhoneNumber(String phoneNumber) {
        UtilityHelper.typeIntoElement(PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void enterEmail(String email) {
        UtilityHelper.typeIntoElement(EMAIL_TEXTBOX, email);
    }

    public void enterPickupLocation(String carDescription) {
        UtilityHelper.moveToViewElement(CAR_DESCRIPTION_TEXTBOX);
        Assert.assertTrue(curbsideTextPickupLocationDisplayPickuoInfo.getText().contains("Curbside"));
        UtilityHelper.typeIntoElement(CAR_DESCRIPTION_TEXTBOX, carDescription);
    }

    // DELI/BAKERY Radio button preselect
    public void validateDeliBakeryPresectPickupLocation() {
        if (!getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='deliBakery']")).isSelected()) {
            getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='deliBakery']")).click();
        }
        Assert.assertTrue(getDriver().findElement(org.openqa.selenium.By.xpath("//*[@id='deliBakery']")).isSelected());
    }

    // Pickup information page display Validation
    public void verifyPickupInfoDisplayPickupPage(String storename, String address1, String shipadr2, String dvrymethd,
                                                  String itemcount) {
        Assert.assertEquals("=== Assert Shipping Address: ", "Shipping Address",
                shippingAddressHeaderTextPickupInfo.getText());
        Assert.assertTrue("=== Assert storename displays: ",
                storeNameDisplayFieldShippingPickupInfo.getText().toUpperCase().contains(storename.toUpperCase()));
        Assert.assertTrue("=== Assert address displays: ",
                address1DisplayPickupInfo.getText().toUpperCase().contains(address1.toUpperCase()));
        Assert.assertEquals("=== Assert shipping address displays: ", shipadr2.toUpperCase(),
                address2DisplayPickupInfo.getText().toUpperCase());
        Assert.assertEquals("=== Assert delivery method displays: ", dvrymethd.toUpperCase(),
                shippingMethodDisplayPickUpInfo.getText().toUpperCase());
        Assert.assertEquals("=== Assert item count: ", itemcount, itemNumberCountPickupInfo.getText());
    }

    public void validateSlotReservationIsDisplayCorrectInCheckoutFlow() {
        System.out.println(" === slotReservationInCheckoutFlow.getText(): " + slotReservationInCheckoutFlow.getText());
        System.out.println(" === Current Stored Pickup Time: " + pickupTime);

        Assert.assertTrue("=== Slot Reservation via Checkout Flow: ",
                slotReservationInCheckoutFlow.getText().contains(pickupTime));
    }

    public void validateSlotReservationIsDisplayCorrectInRHR() {
        System.out.println(" === rightHandRailSlotReserved.getText(): " + rigthHandRailSlotReserved.getText());
        Assert.assertTrue(" === Validate RHR Slot Reservation: ",
                rigthHandRailSlotReserved.getText().contains(pickupTime));
    }

    // Click on Select OR Change Pick Up Time via Checkout Flow
    public void userClicksSelectPickUpTimeButtonViaCheckout() {
        if (UtilityHelper.elementExists(SELECT_PICKUP_BUTTON)) {
            // 'Select' Button
            UtilityHelper.click(SELECT_PICKUP_BUTTON);
        } else {
            // 'Change' Link
            UtilityHelper.click(CHANGE_PICKUP_LINK);
        }
    }

    public void clickReserveTimeButton() {
        UtilityHelper.waitUntilClickable(RESERVE_TIME_BUTTON);
        UtilityHelper.click(RESERVE_TIME_BUTTON);
    }

    public void waitUntilTimeSlotNoLongerExists() {
        UtilityHelper.waitUntilElementNotVisible(TIME_SLOT_MODAL);
    }

    // To select FIRST Available Pickup Slot
    public void select_FIRSTpickupslot() {
        UtilityHelper.waitUntilClickable(clickFirstDayPickupPage);
        clickFirstDayPickupPage.click();
        for (int i = 0; i < 27; i++) {
            try {
                WebElement pickupslot = getDriver().findElement(By.xpath(
                        "//*[@id='pickup-time-slots-id']/div[1]/div[" + i + "][contains (@class, 'slot available')]"));
                pickupTime = pickupslot.getAttribute("data-starttime");
                pickupDate = pickupslot.getAttribute("data-date");
                pickupslot.click();
                reserveduntil = getDriver()
                        .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[1]/div[" + i
                                + "][contains (@class, 'slot available')]/div[contains(@class,'slotMessage')]/strong"))
                        .getText();
                System.out.println(" === Pickup time: " + pickupTime);
                System.out.println(" === Reserve Until time is: " + reserveduntil);
                break;
            } catch (Exception e) {
                System.out.println("Pickup time is not active!!!!");
            }
        }
    }

    // JoeG 11-21-16
    // assumes timeslot modal is already open
    public void selectRandomPickupSlot(Boolean sameday) throws InterruptedException {

        UtilityHelper.waitUntilClickable(getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li")));
        List<WebElement> days = getDriver().findElements(By.xpath("//*[contains(@class, 'availDate')]"));
        // discard first day.
        if (sameday)
            days.remove(0);
        Collections.shuffle(days);
        WebElement day = days.get(0);
        // grab the nth day for creating xpath to find associated slots
        Pattern dayPattern = Pattern.compile("(\\d+$)");
        Matcher matcher = dayPattern.matcher(day.getAttribute("id"));
        if (!matcher.find())
            return;
        String dayIdx = matcher.group();
        System.out.println("dayIdx: " + dayIdx);
        // click next until the selected day is visible
        while (UtilityHelper.isNotClickable(day))
            getDriver().findElement(By.xpath("//*[@class='icon-meijer_caratright']")).click();
        day.click();
        // sleep so it doesnt pick up a stale timeslot before the new ones load
        Thread.sleep(2000);
        List<WebElement> slots = getDriver().findElements(By.xpath("//*[@class='pickup-time-slot available' and starts-with(@id, 'day-" + dayIdx + "')]"));
        Collections.shuffle(slots);
        WebElement slot = slots.get(0);
        UtilityHelper.moveToViewElement(slot);
        pickupTime = slot.getAttribute("data-starttime");
        pickupDate = slot.getAttribute("data-date");
        slot.click();
        System.out.println(" === Pickup time: " + pickupTime);
        System.out.println(" === Pickup date: " + pickupDate);
        WebElement submitSlotButton = slot.findElement(By.xpath(".//button[contains(text(), 'Reserve')]"));

        submitSlotButton.click();
    }

    /*------------------------Specially for Cake only item----------------------------------------------------------*/// To
    // select, HOLD and store pickup slot 2 days Later
    public void select_pickuptime_2DaysLater() {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println("===Available Number of days for Pickup Slot : " + allpickupDate.size());
        int randval1 = getRandomNumber(3, allpickupDate.size());
        System.out.println("===Random value of select Day is : " + randval1);
        WebElement pickupDate = getDriver()
                .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + randval1 + "]"));
        pickupDate.click();
        List<WebElement> avblepickupslot = getDriver().findElements(By.xpath(
                "//*[@id='pickup-time-slots-id']/div[" + randval1 + "]//*[@class='pickup-time-slot available']"));
        for (int i = 0; i < 27; i++) {

            int randval = getRandomNumber(1, avblepickupslot.size());
            System.out.println("===Random value of Slot i is : " + randval);
            try {
                WebElement pickupslot = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div["
                        + randval1 + "]//*[@class='pickup-time-slot available' and @data-index='" + randval + "']"));
                pickupTime = pickupslot.getAttribute("data-starttime");
                OrderPickupPage.pickupDate = pickupslot.getAttribute("data-date");
                pickupslot.click();
                reserveduntil = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + randval1
                        + "]//*[@class='pickup-time-slot available selected' and @data-index='" + randval
                        + "']/div[contains (@class, 'slotMessage')]/strong")).getText();
                System.out.println("===Pickup time: " + pickupTime);
                System.out.println("===Reserve Until time is : " + reserveduntil);
                break;
            } catch (Exception e) {
                System.out.println("Pickup time is not active!!!!");
            }
        }
    }

    // SIVA for THURSDAY ADBREAK on 02/17/2017
    public void verifythuadbreak() throws InterruptedException {
        Calendar cl = Calendar.getInstance();
        System.out.println(cl.get(Calendar.DAY_OF_WEEK) + "========TODAY_DAY==========");

        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            System.out.println("Today is Monday " + Calendar.MONDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("TUE")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("THU") || slot_day.getText().contains("FRI")
                        || slot_day.getText().contains("SAT")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }

        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            System.out.println("Today is Tuesday " + Calendar.TUESDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("WED")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());

                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());

                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");

                if (slot_day.getText().contains("THU") || slot_day.getText().contains("FRI")
                        || slot_day.getText().contains("SAT") || slot_day.getText().contains("SUN")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);

                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    // Assert.assertTrue(adbreak.isDisplayed()==false);
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());

                }

            }

        }

        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            System.out.println("Today is Wednesday " + Calendar.WEDNESDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("THU")) {
                WebElement element = getDriver().findElement(
                        By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                UtilityHelper.waitUntilElementVisible(element);
                String adbreak_slot = element.getText();
                System.out.println("verify the adbreak text ===" + adbreak_slot + "===Adbreak is available");
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("THU") || slot_day.getText().contains("FRI")
                        || slot_day.getText().contains("SAT") || slot_day.getText().contains("SUN")
                        || slot_day.getText().contains("MON")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            System.out.println("Today is Thursday " + Calendar.THURSDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("FRI")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("WED")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            System.out.println("Today is Friday " + Calendar.FRIDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("SAT")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("THU")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            System.out.println("Today is Saturday " + Calendar.SATURDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("SUN")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("THU")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("Today is Saturday " + Calendar.SUNDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("MON")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Thursday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("THU") || slot_day.getText().contains("FRI")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Adbreak is not available====" + slot_day.getText());
                }
            }
        }
    }

    // SIVA SUNDAY ADBREAK on 02/17/2017
    public void verifySUNadbreak() {
        Calendar cl = Calendar.getInstance();
        System.out.println(cl.get(Calendar.DAY_OF_WEEK) + "========TODAY_DAY==========");
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            System.out.println("Today is Monday " + Calendar.MONDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("TUE")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday Store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            System.out.println("Today is Tuesday " + Calendar.TUESDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("WED")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                if (pickupDaySliderWindow1.getText().contains("TODAY")) {
                    break;
                }
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            System.out.println("Today is Wednesday " + Calendar.WEDNESDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("THU")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN") || slot_day.getText().contains("MON")) {
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            System.out.println("Today is Thursday " + Calendar.THURSDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("FRI")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN") || slot_day.getText().contains("MON")
                        || slot_day.getText().contains("TUE")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            System.out.println("Today is Friday " + Calendar.FRIDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("SAT")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN") || slot_day.getText().contains("MON")
                        || slot_day.getText().contains("TUE") || slot_day.getText().contains("WED")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            System.out.println("Today is Saturday " + Calendar.SATURDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("SUN")) {
                WebElement element = getDriver().findElement(
                        By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                UtilityHelper.waitUntilElementVisible(element);
                String adbreak_slot = element.getText();
                System.out
                        .println("verify the adbreak text ===" + adbreak_slot + "===Sunday store Adbreak is available");
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SUN") || slot_day.getText().contains("MON")
                        || slot_day.getText().contains("TUE") || slot_day.getText().contains("WED")
                        || slot_day.getText().contains("THU")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
        if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("Today is Saturday " + Calendar.SUNDAY);
            List<WebElement> allslots = getDriver().findElements(By.xpath(".//*[@id='pickupDaySliderWindow']/ul/li"));
            int rowcount_slots = allslots.size();
            System.out.println("size of time slot" + rowcount_slots);
            System.out.println("print the first slot " + pickupDaySliderWindow1.getText());
            if (pickupDaySliderWindow1.getText().contains("Today")) {
                System.out.println("==No Adbreak for today==");
            } else if (seconddaypickup.getText().contains("MON")) {
                Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                        allTimeslots.getText());
                WebElement slot_day_after5pm = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[1]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day_after5pm.getText());
                System.out.println("====Sunday store Adbreak is not available====" + slot_day_after5pm.getText());
            }
            for (int i = 2; i <= rowcount_slots; i++) {
                WebElement slot = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                slot.click();
                WebElement slot_day = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]"));
                System.out.println("$$$$$$$$$TextDay$$$$$ " + slot_day.getText());
                System.out.println("SLOT_DAY ===>> [" + slot_day.getText() + "] ");
                if (slot_day.getText().contains("SAT")) {
                    System.out.println("=====testing========");
                    WebElement element = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                            + "]//div[contains (@id, 'adBreakMessage')]/span"));
                    UtilityHelper.waitUntilElementVisible(element);
                    String adbreak_slot = element.getText();
                    System.out.println("verify the adbreak text ===" + adbreak_slot + slot_day.getText()
                            + "===Sunday store Adbreak is available");
                } else {
                    Assert.assertNotEquals("Sale prices may differ on this day due to a new weekly ad.",
                            allTimeslots.getText());
                    System.out.println("====Sunday store Adbreak is not available====" + slot_day.getText());
                }
            }
        }
    }

    // SIVA THU Adbreak for SPO order only
    public void verifythuadbreakSPO() throws InterruptedException {
        int index, x, i;
        String pickupDay1slot;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        WebElement day1slot = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[1]/span[2]"));

        switch (today.toLowerCase()) {
            case "monday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("tue")) {
                    for (x = 0; x < 2; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 2; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "tuesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("wed")) {
                    for (x = 0; x < 1; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                    for (i = 0; i <= 5; i++) {
                        while (x < 5) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                            x++;
                        }
                        x = 0;
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "wednesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("thu")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && x < 1) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                }
                break;
            case "thursday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("fri")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && x < 1) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i == 0 && x < 5) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                }
                break;
            case "friday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("sat")) {
                    for (x = 0; x < 5; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 5; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "saturday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sun")) {
                    for (x = 0; x < 4; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 4; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "sunday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("mon")) {
                    for (x = 0; x < 3; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 3; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    // SIVA SUNDAY Adbreak for SPO
    public void AdbreakSPOsunday() {
        int index;
        int x = 0, i = 0;
        String pickupDay1slot = null;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        WebElement day1slot = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[1]/span[2]"));
        switch (today.toLowerCase()) {
            case "thursday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("fri")) {
                    for (x = 0; x < 2; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 2; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "friday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sat")) {
                    for (x = 0; x < 1; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                    for (i = 0; i <= 5; i++) {
                        while (x < 5) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                            x++;
                        }
                        x = 0;
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "saturday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sun")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            setImplicitTimeout(5, TimeUnit.SECONDS);
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && x < 1) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                }
                break;
            case "sunday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("mon")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && x < 1) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i == 0 && x < 5) {
//                      getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                setImplicitTimeout(5, TimeUnit.SECONDS);
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                    }
                }
                break;
            case "monday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("tue")) {
                    for (x = 0; x < 5; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 5; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "tuesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("wed")) {
                    for (x = 0; x < 4; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 4; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
            case "wednesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("thu")) {
                    for (x = 0; x < 3; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 3; x++) {
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        setImplicitTimeout(5, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    setImplicitTimeout(5, TimeUnit.SECONDS);
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }


    // To select any Random Available Pickup Slot
    public void selectAnyAvailablePickuptime_Random() {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println(" === Available Number of days for Pickup Slot: " + allpickupDate.size());
        int randval1 = getRandomNumber(1, allpickupDate.size());
        System.out.println(" === Random value of of i is: " + randval1);
        WebElement pickupDate = getDriver()
                .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + randval1 + "]"));
        pickupDate.click();
        List<WebElement> avblepickupslot = getDriver().findElements(By.xpath(
                "//*[@id='pickup-time-slots-id']/div[" + randval1 + "]//*[@class='pickup-time-slot available']"));
        for (int i = 0; i < 27; i++) {
            int randval2 = getRandomNumber(1, avblepickupslot.size());
            // TODO: Implement Lead Time Variable CNC Cart Order
            // Implement lead Time variable for selecting slot pickup time.
            // This will help ensure the ability of canceling an order when
            // placed
            if (randval1 == 1) {
                randval2 = getRandomNumber(5, avblepickupslot.size());
            }
            System.out.println("Random value of of i is ====> " + randval2);
            try {
                WebElement pickupslot = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div["
                        + randval1 + "]//*[@class='pickup-time-slot available' and @data-index='" + randval2 + "']"));
                pickupTime = pickupslot.getAttribute("data-starttime");
                OrderPickupPage.pickupDate = pickupslot.getAttribute("data-date");
                pickupslot.click();
                System.out.println(" === Pickup time: " + pickupTime);
                System.out.println(" === Pickup Date: " + OrderPickupPage.pickupDate);
                break;
            } catch (Exception e) {
                System.out.println(" === Pickup time is not active!!!!");
            }
        }
    }

    // To click on Right Arrow of Pickup Times popup modal
    private void clickRightArrow_XnumberofTimes_PickupTimeModal(int randval1) throws InterruptedException {
        int noofclick = 0;
        System.out.println("Value of Random value is = " + randval1);
        if (randval1 > 5 && randval1 < 11) {
            noofclick = 1;
        } else if (randval1 > 10 && randval1 < 16) {
            noofclick = 2;
        } else if (randval1 > 15 && randval1 < 21) {
            noofclick = 3;
        } else if (randval1 > 20 && randval1 < 26) {
            noofclick = 4;
        } else if (randval1 > 25 && randval1 < 31) {
            noofclick = 5;
        }
        System.out.println("User need to click Right Arrow [" + noofclick + "] Times");
        for (int i = 1; i <= noofclick; i++) {
            if (UtilityHelper.isClickable(rightArrowPickupTimesPopupWizard)) {
                rightArrowPickupTimesPopupWizard.click();
                Thread.sleep(1000);
            }
        }
    }

    // To navigate and select future date (Day 3)
    public String selectseveraldayfuturepickuptime() {
        UtilityHelper.waitUntilClickable(click3rdDayPickupPage);
        click3rdDayPickupPage.click();
        List<WebElement> avblepickupslot = getDriver().findElements(By.xpath(
                "//*[@id='pickup-time-slots-id']/div[contains (@class, 'day-3')]//*[@class='pickup-time-slot available']"));
        for (int i = 0; i < 27; i++) {

            int maxval = avblepickupslot.size() - 1;
            int randval = getRandomNumber(0, maxval);
            System.out.println("Random value of of i is ====> " + randval);
            try {
                WebElement pickupslot = getDriver().findElement(By
                        .xpath("//*[@id='pickup-time-slots-id']/div[contains (@class, 'dayGroup day-3')]//*[@class='pickup-time-slot available' and @data-index='"
                                + randval + "']"));
                pickupTime = pickupslot.getAttribute("data-starttime");
                pickupDate = pickupslot.getAttribute("data-date");
                System.out.println("===Pickup time:" + pickupTime);
                pickupslot.click();
                break;
            } catch (Exception e) {
                System.out.println("Pickup time is not active!!!!");
            }
        }
        return pickupTime;
    }
    /*--------------------------------------End for Cake only Item---------------------------------------------------------------*/

    // To select any Random Available Pickup Slot for Mixed Cart Items
    public void selectAnyAvailablePickuptime_Randomfor_MixedCart() throws InterruptedException {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println(" === Available Number of days for Pickup Slot: " + allpickupDate.size());
        int randval1 = getRandomNumber(2, allpickupDate.size());
        System.out.println(" === Random value of randval 1 is: " + randval1);
        if (randval1 > 5) {
            clickRightArrow_XnumberofTimes_PickupTimeModal(randval1);
        }
        WebElement pickupDate = getDriver()
                .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + randval1 + "]"));
        pickupDate.click();
        List<WebElement> avblepickupslot = getDriver().findElements(By.xpath(
                "//*[@id='pickup-time-slots-id']/div[" + randval1 + "]//*[@class='pickup-time-slot available']"));
        for (int i = 0; i < 27; i++) {
            int randval2 = getRandomNumber(1, 27);

            // TODO: Implement Lead Time Variable Mixed Cart Order
            // Implement lead Time variable for selecting slot pickup time.
            // This will help ensure the ability of canceling an order when
            // order is placed
            if (randval1 == 2) {
                randval2 = getRandomNumber(8, avblepickupslot.size());
            }

            System.out.println("Random value of randval 2 is ====> " + randval2);
            try {
                WebElement pickupslot = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div["
                        + randval1 + "]//*[@class='pickup-time-slot available' and @data-index='" + randval2 + "']"));
                pickupTime = pickupslot.getAttribute("data-starttime");
                OrderPickupPage.pickupDate = pickupslot.getAttribute("data-date");
                pickupslot.click();
                System.out.println(" === Pickup time: " + pickupTime);
                System.out.println(" === Pickup Date: " + OrderPickupPage.pickupDate);
                break;
            } catch (Exception e) {
                System.out.println(" === Pickup time is not active!!!!");
            }
        }
    }

    public void validateFirstNameTextBoxFieldPickupInfo(String firstname) {
        Assert.assertEquals("Validate Auto Fill - First Name", firstname,
                FIRST_NAME_TEXTBOX.getAttribute("value"));
    }

    public void validateLastNameTextBoxFieldPickupInfo(String lastname) {
        Assert.assertEquals("Validate Auto Fill - Last Name", lastname,
                LAST_NAME_TEXTBOX.getAttribute("value"));
    }

    public void validateEmailAddressTextBoxFieldPickup(String email) {
        Assert.assertEquals("Validate Auto Fill - Email", email, EMAIL_TEXTBOX.getAttribute("value"));
    }

    public void validatePhoneNumberTextBoxFieldPickup(String ph_number) {
        Assert.assertEquals("Validate Auto Fill - Phone#", ph_number,
                PHONE_NUMBER_TEXTBOX.getAttribute("value").replaceAll("[^0-9]", ""));
    }

    public void topickup4hrslaterCNCitem() {
        List<WebElement> availableslotcount = getDriver().findElements(
                By.xpath("//*[@id='pickup-time-slots-id']/div[1]//*[@class='pickup-time-slot available']"));
        System.out.println(" === available slots for today's pickup is: " + availableslotcount.size());
        if (availableslotcount.size() >= 2) {
            for (int i = 3; i <= availableslotcount.size(); i++) { // First Pickup slot should be enabled only
                // after 3.5 hrs later from current time
                try {
                    pickupTime = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[1]/div[" + i
                            + "][@class='pickup-time-slot available']")).getAttribute("data-starttime");
                    pickupDate = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[1]/div[" + i
                            + "][@class='pickup-time-slot available']")).getAttribute("data-date");

                    System.out.println(" === Pickup time: " + pickupTime);
                    getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[1]/div[" + i
                            + "][@class='pickup-time-slot available']")).click();
                    break;
                } catch (Exception e) {
                    System.out.println(" === Pickup time is not active!!!!");
                }
            }
        } else {
            clickNextDayPickupPage.click();
            pickupTime = selectNextdayFirstavailablePickupslot.getAttribute("data-starttime");
            pickupDate = selectNextdayFirstavailablePickupslot.getAttribute("data-date");
            System.out.println(" === Pickup time: " + pickupTime);
            selectNextdayFirstavailablePickupslot.click();
        }
    }

    public void reserveAvailableTimeSlot(int leadTime) {
        String data_startTime_string, data_date_string, date_startTime, str_dateSlider, noAvailability;
        DateTime date = new DateTime(), timeSlotValue, configLeadTime;
        List<WebElement> daySliderCount, totalSlotCount;
        int isLaterThan;
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm a");
        daySliderCount = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));

        for (int i = 1; i < daySliderCount.size(); i++) {
            totalSlotCount = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]/div"));
            getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
            str_dateSlider = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText();

            noAvailability = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]/div[1]")).getAttribute("class");
            if ((noAvailability.contains("noAvailableTimeMessage"))) {
                continue;
            }
            System.out.println(" === Total Slot Count for Date [" + str_dateSlider + "]:  " + totalSlotCount.size());
            for (int j = 1; j <= totalSlotCount.size(); j++) {
                String stringXpath = "//*[@id='pickup-time-slots-id']/div[" + i + "]/div[" + j + "][not(contains(@id,'adBreakMessage'))]";
                String availability = getDriver().findElement(By.xpath(stringXpath)).getAttribute("class");
                data_date_string = getDriver().findElement(By.xpath(stringXpath)).getAttribute("data-date");
                data_startTime_string = getDriver().findElement(By.xpath(stringXpath)).getAttribute("data-starttime");
                if (availability.contains("not-available")) {
                    continue;
                }
                date_startTime = data_date_string + " " + data_startTime_string;
                timeSlotValue = dateTimeFormatter.parseDateTime(date_startTime);
                configLeadTime = date.plusHours(leadTime).plusMinutes(30);
                /*
                 * //TODO: review for later. //By: 107793 12/27/16 //Me believes
				 * it was .plusHours(8) repeatedly.. if
				 * (!str_dateSlider.contains("Today")) { //condition to ensure
				 * testers cancellation of a SPO/Mixed cart order configLeadTime
				 * = configLeadTime.plusHours(8); }
				 */
                isLaterThan = timeSlotValue.compareTo(configLeadTime);
                if (isLaterThan < 0) {
                    continue;
                }
                if (isLaterThan > 0) {
                    getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]/div[" + j + "]")).click();
                    pickupDate = str_dateSlider;
                    pickupTime = data_startTime_string;
                    System.out.println(" === Pickup Time Slot: " + str_dateSlider + " @ " + pickupTime);
                    return;
                }
            }
        }
    }

    public void validate_ReservedPickupTimeInCurbsideWidget() {
        UtilityHelper.waitUntilElementVisible(
                getDriver().findElement(By.xpath("//*[@class='fl curbsideMessage']/span[@onclick='pickTimeSlot();']")));
        System.out.println(
                " === Curbside Widget Reserved Pickup Time COPY: " + curbsideWidgetWithActiveReservation.getText());
        if (pickupTime.charAt(0) == '0') {
            pickupTime = pickupTime.substring(1);
        }
        System.out.println(" === Stored Pickup Time: " + pickupTime);
        Assert.assertTrue(" === Curbside Widget Time Slot Validation: ",
                curbsideWidgetWithActiveReservation.getText().contains(pickupTime));
    }

    public void validate_ActiveOrderInCurbsideWidget() {
        UtilityHelper.waitUntilElementVisible(curbsideWidget);
        Assert.assertTrue(" === Curbside Widget Active Order Validate:  ",
                curbsideWidgetWithActiveOrder.getText().contains(pickupTime));
    }

    public void clickActiveReserveCurbsidePickupTimeInCurbsideWidget() {
        UtilityHelper.waitUntilElementVisible(curbsideWidget);
        curbsideWidgetWithActiveReservation.click();
    }

    public void pickupTimeModal_WithReservation() {
        UtilityHelper.waitUntilElementVisible(currentReservedPickupTime);
        String date = currentReservedPickupTime.getAttribute("id");
        String removeDay = date.substring(4);
        String dayNum = removeDay.split("-")[0];
        Assert.assertTrue(reservedDateIsSelectedValidation.getAttribute("id").contains(dayNum));
        Assert.assertTrue(currentReservedPickupTime.getText().contains(Constants.reservedPickupTime));
        Assert.assertTrue(currentReservedPickupTime.getText().contains(pickupTime));
    }

    public void pickupTimeModal_WithUpdatingReservation() {
        UtilityHelper.waitUntilElementVisible(currentReservedPickupTime);
        String date = currentReservedPickupTime.getAttribute("id");
        String removeDay = date.substring(4);
        String dayNum = removeDay.split("-")[0];
        int d = Integer.valueOf(dayNum);

        for (int i = d; i <= d; i++) {
            String firstpickupday = getDriver()
                    .findElement(By.xpath(
                            "//*[@id='pickup-time-slots-id']/div[" + i + "+1]//*[@class='pickup-time-slot available']"))
                    .getAttribute("id");
            System.out.println(" === Pickup day: " + firstpickupday);
            System.out.print(" === Pickup Time Slot [" + pickupTime + "] UPDATED TO:  ");
            pickupTime = getDriver()
                    .findElement(By.xpath(
                            "//*[@id='pickup-time-slots-id']/div[" + i + "+1]//*[@class='pickup-time-slot available']"))
                    .getAttribute("data-starttime");
            System.out.println("[" + pickupTime + "]");
            getDriver()
                    .findElement(By.xpath(
                            "//*[@id='pickup-time-slots-id']/div[" + i + "+1]//*[@class='pickup-time-slot available']"))
                    .click();
        }
        Assert.assertTrue(reservedDateIsSelectedValidation.getAttribute("id").contains(dayNum));
        Assert.assertTrue(currentReservedPickupTime.getText().contains(Constants.reservedPickupTime));
        Assert.assertTrue(
                selectedUpdateReservationPickupTime.getText().contains(Constants.selectedNewPickUptTime));

    }

    // click on Select Pickup Time Button on Pickup Times pop up
    public void click_SelectPickupTimeButton_PickupTimesPopup() {
        selectPickupTimeButtonPickupTimesPopupPickupPage.click();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    // Click on Edit Link for Change Store
    public void clickEdit_ChangeStore() {
        editlinkforChangeStorePickupPage.click();
    }

    // Validate Selected Pickup Time display
    public void validate_SelectedPickupTime() throws ParseException {
        UtilityHelper.waitUntilClickable(FIRST_NAME_TEXTBOX);
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = originalFormat.parse(pickupDate);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        String text = formatter.format(startDate);
        System.out.println(" === Day of the week is: " + text);
        String expPickupTimedisplay = text + "," + " " + pickupTime;
        System.out.println("ExpPickup Time is: " + expPickupTimedisplay);
        System.out.println("System display Pickup Time is: " + holdPickupTimeDisplayPickupPage.getText());
        Assert.assertEquals(expPickupTimedisplay, holdPickupTimeDisplayPickupPage.getText());
    }

    // click on change link to edit Pickup Time
    public void click_ChangeLink_editpickuptime() {
        UtilityHelper.waitUntilClickable(changeLinktoEditPickupTime);
        changeLinktoEditPickupTime.click();
    }

    // Pickup modal display validation
    public void PickupTimeSlotPopupWindowDisplay() {
        UtilityHelper.waitUntilElementVisible(pickupTimesHeaderonPopup);
        Assert.assertEquals(Constants.pickUpTimeHeaderText, pickupTimesHeaderonPopup.getText());
    }

    // Validate Selected Pickup time display correct
    public void validate_HoldPickupTime_DisplayCorrect() {
        UtilityHelper.waitUntilElementVisible(currentHoldSlotPickUpTime);
        String holddate = currentHoldSlotPickUpTime.getAttribute("data-starttime");
        Assert.assertTrue(holddate.contains(pickupTime));
    }

    // Validate Reserved Pickup Time Drop
    public void reserved_pickuptime_drop() {
        UtilityHelper.waitUntilClickable(selectPickUpTimeButtonPickupPage);
        Assert.assertTrue(selectPickUpTimeButtonPickupPage.isDisplayed());
        List<WebElement> list = getDriver()
                .findElements(By.xpath("//*[@id='reservationTime']/span[contains (text(), 'change')]"));
        Assert.assertTrue(" === Change link is Not Display!", list.size() == 0);
    }

    // Generic method to store first available pickup Day/time
    public void firstAvailableSlot_PickupTimes() {
        List<WebElement> pickupDaycount = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        for (int i = 1; i <= pickupDaycount.size(); i++) {
            WebElement selectDay = getDriver()
                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[1]"));
            selectDay.click();
            List<WebElement> avblepickupslot = getDriver().findElements(
                    By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//*[@class='pickup-time-slot available']"));
            if (avblepickupslot.size() > 0) {
                for (int j = 1; j <= 28; j++) {
                    try {
                        WebElement avaslot = getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                + "]/div[" + j + "][contains (@class, 'slot available')]"));
                        String slotavailable1 = avaslot.getAttribute("data-starttime");
                        System.out.println(" === value of 1st available slot is :" + slotavailable1);
                        firstSLOTavailable = slotavailable1;
                        break;
                    } catch (Exception e) {
                        System.out.println("Slot is not available!!!");
                    }
                }
                break;
            }
        }
    }

    public void validate_firstavailableSlot_Display() {
        UtilityHelper.validate_FirstAvailable_PickupTimeDisplayCorrect();
    }

    // Get First day of slot available
    public void firstAvaiableDay_ForPickupSlot() {
        List<WebElement> pickupDaycount = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        for (int i = 1; i <= pickupDaycount.size(); i++) {
            WebElement selectDay = getDriver()
                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[1]"));
            selectDay.click();
            List<WebElement> avblepickupslot = getDriver().findElements(
                    By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//*[@class='pickup-time-slot available']"));
            if (avblepickupslot.size() > 0) {
                String pickupday = selectDay.getText();
                System.out.println(" === First slot available date is: " + pickupday);
                firstDAYavailable = pickupday;
                break;
            }
        }
    }

    // Cancel on Pickup Times Pop up
    public void click_Cancel_PickupTimesPopup() {
        cancelButtonPickupTimesPopupPickupPage.click();
    }

    // Validate Upto 5 Business Days Pickup Enabled
    public void validate_5DaysAdvance_PickupSlot() {
        UtilityHelper.waitUntilElementVisible(pickupTimesHeaderTextPickupPage);
        click5thDayPickupPage.click();
        List<WebElement> noDaysAvailable = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        int Expectedvalue = 6;
        Assert.assertEquals(Expectedvalue, noDaysAvailable.size());
        List<WebElement> day5availableslot = getDriver().findElements(
                By.xpath("//*[@class='dayGroup day-5']/div[contains (@class, 'pickup-time-slot available')]"));
        Assert.assertTrue("Available slot present on Day 5!!!", day5availableslot.size() > 0);
    }

    // To select All Available slot and validate content of the slot
    public void highlightPickuptimeSlot_ValidateContent() {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println(" === Available Number of days for Pickup Slot: " + allpickupDate.size());
        for (int i = 1; i <= allpickupDate.size(); i++) {
            WebElement pickupDate = getDriver()
                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
            pickupDate.click();
            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                    + "]/div[contains (@class, 'pickup-time-slot available')]"));
            System.out.println(" === Available Number of Pickup Slot: " + as.size());
            for (WebElement element : as) {
                element.click();
                String newpickuptime = getDriver()
                        .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                + "]//*[@class='pickup-time-slot available selected']/div[contains (@class, 'slotMessage')]/strong"))
                        .getText();
                Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                String wewillholduntiltext = getDriver()
                        .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                + "]//*[@class='pickup-time-slot available selected']//div[contains (@class, 'slotMessage')]/strong"))
                        .getText();
                Assert.assertTrue(wewillholduntiltext.contains(Constants.weWillHoldUntilText));
            }
        }
    }

    // Close Pickup Times pop up window
    public void clickClosePickupTimeSlotPopupWindow() {
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    // Validate Upto 30 Days pickup Days display for Cake
    public void validatePickup30DaysAdvance_ForCake() {
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        int expectedvalue = 30;
        Assert.assertEquals(" === SPO Day Slider in Time Slot Modal: ", expectedvalue, allpickupDate.size());
    }

    //
    public void validate_SelectPickupTime_ButtonTextDisplay() {
        UtilityHelper.waitUntilClickable(RESERVE_TIME_BUTTON);
        Assert.assertEquals(Constants.selectPickupTimeButtonText,
                RESERVE_TIME_BUTTON.getText());
    }

    // validate Blank pickup Time Error Message
    public void validate_Blank_PickupTime_ErrorMsg() {
        Assert.assertEquals(Constants.pickupTimeBlankErrorMsg, errorMsgPickupTimePickupPage.getText());
    }

    // To select All Available slot and validate content of the slot
    public void highlight_PickuptimeSlot_ValidateContent_PickupPage() throws InterruptedException {
        UtilityHelper.waitUntilClickable(pickupTimesHeaderTextPickupPage);
        List<WebElement> allpickupDate = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        System.out.println(" === Available Number of days for Pickup Slot: " + allpickupDate.size());
        String newpickuptime = null;
        if (allpickupDate.size() > 6) {
            int val = allpickupDate.size() / 6;
            for (int j = 1; j <= val; j++) {
                switch (j) {
                    case 1: {
                        for (int i = 1; i < 6; i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                        System.out.println(" === Case 1 loop is executed!!!");
                    }

                    case 2: {
                        rightArrowPickupTimesPopupWizard.click();
                        Thread.sleep(1000);
                        for (int i = 6; i < 11; i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                        System.out.println(" === Case 2 loop is executed!!!");
                    }

                    case 3: {
                        rightArrowPickupTimesPopupWizard.click();
                        Thread.sleep(1000);
                        for (int i = 11; i < 16; i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                        System.out.println(" === Case 3 loop is executed!!!");
                    }

                    case 4: {
                        rightArrowPickupTimesPopupWizard.click();
                        Thread.sleep(1000);
                        for (int i = 16; i < 21; i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                        System.out.println(" === Case 4 loop is executed!!!");
                    }

                    case 5: {
                        rightArrowPickupTimesPopupWizard.click();
                        Thread.sleep(1000);
                        for (int i = 21; i <= 26; i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                        System.out.println(" === Case 5 loop is executed!!!");
                    }
                    case 6: {
                        rightArrowPickupTimesPopupWizard.click();
                        Thread.sleep(1000);
                        for (int i = 26; i <= allpickupDate.size(); i++) {
                            WebElement pickupDate = getDriver()
                                    .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                            pickupDate.click();
                            List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div["
                                    + i + "]/div[contains (@class, 'pickup-time-slot available')]"));
                            System.out.println(" === Available Number of Pickup Slot: " + as.size());
                            if (as.size() > 0) {
                                for (WebElement element : as) {
                                    element.click();
                                    newpickuptime = getDriver()
                                            .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                                    + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                            .getText();
                                    Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                                }
                            }
                        }
                    }
                    System.out.println(" === Case 5 loop is executed!!!");
                }
            }

        } else {
            for (int i = 1; i <= allpickupDate.size(); i++) {
                WebElement pickupDate = getDriver()
                        .findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]"));
                pickupDate.click();
                List<WebElement> as = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                        + "]/div[contains (@class, 'pickup-time-slot available')][not (contains (@class, 'selected'))]"));
                System.out.println("Available Number of Pickup Slot: " + as.size());
                if (as.size() > 0) {
                    for (WebElement element : as) {
                        element.click();
                        newpickuptime = getDriver()
                                .findElement(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i
                                        + "]//*[@class='pickup-time-slot available selected']/div[contains(@class,'slotMessage')]/strong"))
                                .getText();
                        Assert.assertEquals(Constants.newPickUpTimeText, newpickuptime);
                        // String
                        // weWillHoldUntilText=getDriver().findElement(By.xpath("//*[@id='pickup-time-slots-id']/div["+i+"]//*[@class='pickup-time-slot
                        // available selected']/span[2]")).getText();
                        // Assert.assertTrue(weWillHoldUntilText.contains(Constants.weWillHoldUntilText));
                    }
                }
            }
        }

    }

    // validate Blank First Name Error Message
    public void validate_Blank_FirstName_ErrorMsg() {
        Assert.assertEquals(Constants.firstNameBlankErrorMsg, errorMsgFirstNamePickupPage.getText());
    }

    // validate Blank Last Name Error Message
    public void validate_Blank_LastName_ErrorMsg() {
        Assert.assertEquals(Constants.lastNameBlankErrorMsg, errorMsgLastNamePickupPage.getText());
    }

    // validate Blank Phone Number Name Error Message
    public void validate_Blank_PhoneNumbere_ErrorMsg() {
        Assert.assertEquals(Constants.phoneNoBlankErrorMsg, errorMsgPhoneNumberPickupPage.getText());
    }

    // validate Blank Email Address Name Error Message
    public void validate_Blank_EmailAddress_ErrorMsg() {
        Assert.assertEquals(Constants.emailAddressBlankErrorMsg, errorMsgEmailAddressPickupPage.getText());
    }

    // Pickup Times Pop up Window - Select Pickup Times Button disabled
    public void valdiate_SelectPickupTimesButton_Disabled() {
        Assert.assertTrue(disabledSelectPickupTimeButton.isDisplayed());
    }

    public void noSlot_Errormsg_Today_TimeSlot() {
        UtilityHelper.waitUntilClickable(pickupTimesHeaderonPopup);
        System.out.println(noslotavailableErrorMsgPickupTime.getText());
        System.out.println(Constants.noavailableSlotPickupTimesErrorMsg1stline);
        Assert.assertEquals(Constants.noavailableSlotPickupTimesErrorMsg1stline,
                noslotavailableErrorMsgPickupTime.getText());
    }

    // To validate Next Day Slot is displayed in Day slider 1
    public void validate_NexDaySlots_Display_DaySlider1() {
        clickFirstDayPickupPage.click();
        System.out.println(clickFirstDayPickupPage.getText());
        Assert.assertFalse(clickFirstDayPickupPage.getText().contains("Today"));
        List<WebElement> slotavailable = getDriver().findElements(
                By.xpath("//*[@id='pickup-time-slots-id']/div[1]//*[@class='pickup-time-slot available']"));
        System.out.println("Available Slot count is :" + slotavailable.size());
        Assert.assertTrue("No Slot Available", slotavailable.size() > 0);
    }

    // Created By: 107793 10/22/16
    // Validate Time slots with the respected Store ID
    public void verifyStoreIdInTimeSlotModal() {
        String storeID, actual = null;
        if (UtilityHelper.elementExists(yourStoreValue)) {
            // Grab via Home Page
            actual = yourStoreValue.getText();
            System.out.println("Grabbing Store ID value via Home Page ");
        } else if (UtilityHelper.elementExists(storeNameDisplayFieldShippingPickupInfo)) {
            // Grab via Pickup Info Page
            actual = storeNameDisplayFieldShippingPickupInfo.getText();
            System.out.println("Grabbing Store ID value via Pickup Info Page");
        } else if (UtilityHelper.elementExists(By.xpath("//p[@class='edit-pickup-time']/a"))) {
            // Grab via Edit Active Order Page
            actual = storeNameDisplayFieldShippingPickupInfo.getText();
            System.out.println("Grabbing Store ID value via Edit Active Order");
        }
        storeID = getDriver().findElement(By.xpath("//*[@id='QA-ScheduleStoreID']")).getAttribute("data-storeid");
        Assert.assertEquals("Verifying Hidden Store Id == Current Store", verifyStoreId(storeID), actual);
        System.out.println("Store Name = [" + actual + "]");
    }

    // To compare Store Id with Store Name
    String verifyStoreId(String storeId) {
        String value = null;
        // Common Curbside Enabled Store Id's
        /* Implement additional Store Id's and Name's as needed */
        switch (storeId) {
            case "11":
                value = "28th and Kalamazoo";
                break;
            case "12":
                value = "Plainfield Ave.";
                break;
            case "20":
                value = "Alpine";
                break;
            case "23":
                value = "W Saginaw Hwy";
                break;
            case "25":
                value = "Okemos";
                break;
            case "26":
                value = "Jenison";
                break;
            case "50":
                value = "Cascade";
                break;
            case "64":
                value = "Saline Rd";
                break;
            case "123":
                value = "Southgate";
                break;
            case "146":
                value = "Champaign/Urbana";
                break;
            case "158":
                value = "Knapps Corner";
                break;
            case "247":
                value = "Urbana";
                break;
            case "311":
                value = "28th and Kalamazoo";
                break;
            case "312":
                value = "Plainfield Ave.";
                break;
            case "154":
                value = "E 96th St";
                break;

            default:
                System.out.println("Store Id value [" + storeId + "] is listed in Switch()");
                System.out.println("Please verify verifyStoreId() method and confirm switch()");
                break;
        }
        System.out.println("Store Id === [" + storeId + "]");
        return value;
    }

    // To validate a time slot is not selected from the user
    // Created By: 107793 10/31/16
    public void selectPickUpTimeButtonIsDisplayed() {
        Assert.assertTrue("=== Can Not Go To Billing Page WITHOUT a Time Slot Selected: ",
                selectPickUpTimeButtonPickupPage.isDisplayed());
    }

    // Created By: 107793 11/07/16
    public void clearFirstName() {
        FIRST_NAME_TEXTBOX.clear();
    }

    // Created By: 107793 11/07/16
    public void clearLastName() {
        LAST_NAME_TEXTBOX.clear();
    }

    // Created By: 107793 11/07/16
    public void clearPhoneNumber() {
        PHONE_NUMBER_TEXTBOX.clear();
    }

    // Created By: 107793 11/07/16
    public void clearEmailAddress() {
        EMAIL_TEXTBOX.clear();
    }

    // Created By: 107793 11/07/16
    public void errorMessageFirstName() {
        UtilityHelper.moveToViewElement(errorMsgFirstName);
        Assert.assertTrue("Verify First Name Error Message Display ", errorMsgFirstName.isDisplayed());
        Assert.assertTrue("Verify First Name Error Message Copy ",
                Constants.msgErrorFirstName.contains(errorMsgFirstName.getText()));
    }

    // Created By: 107793 11/07/16
    public void errorMessageLastName() {
        UtilityHelper.moveToViewElement(errorMsgLastName);
        Assert.assertTrue("Verify Last Name Error Message Display ", errorMsgLastName.isDisplayed());
        Assert.assertTrue("Verify Last Name Error Message Copy ",
                Constants.msgErrorLastName.contains(errorMsgLastName.getText()));
    }

    // Created By: 107793 11/07/16
    public void errorMessagePhoneNumber() {
        UtilityHelper.moveToViewElement(errorMsgPhoneNumber);
        Assert.assertTrue("Verify Phone Number Error Message Display ", errorMsgPhoneNumber.isDisplayed());
        Assert.assertTrue("Verify Phone Number Error Message Copy ",
                Constants.msgErrorPhoneNumber.contains(errorMsgPhoneNumber.getText()));
    }

    // Created By: 107793 11/07/16
    public void errorMessageEmailAddress() {
        UtilityHelper.moveToViewElement(errorMsgEmailAddress);
        Assert.assertTrue("Verify Email Address Error Message Display ", errorMsgEmailAddress.isDisplayed());
        Assert.assertTrue("Verify Email Address Error Message Copy ",
                Constants.msgErrorEmailAddress.contains(errorMsgEmailAddress.getText()));
    }

    public void waitUntilTimeSlotAppears() {
        try {
            int counter = 0, limit = 3;
            if (UtilityHelper.elementNotExists(TIME_SLOT_MODAL)) {
                Thread.sleep(5000);
                while (UtilityHelper.elementNotExists(TIME_SLOT_MODAL)) {
                    Thread.sleep(5000);
                    if (counter == limit) {
                        Assert.fail("Failed to load Time Slot Modal");
                    }
                    counter++;
                }
            }
            UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validate_FirstPickup_Slot_SPOItem() throws ParseException {
        pickupTime = getDriver().findElement(By.xpath("//*[@class='dayGroup day-0']/div[1][contains (@class, 'slot available')]")).getAttribute("data-starttime");
        pickupDate = getDriver().findElement(By.xpath("//*[@class='dayGroup day-0']/div[1]")).getAttribute("data-date");
        System.out.println("Value od timeone ===> " + pickupTime);
        System.out.println("Value od timeone ===> " + pickupDate);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentdate = df.format(date);
        System.out.println(df.format(date)); // 2014/08/06 15:59:48
        Date date1 = df.parse(currentdate);
        DateFormat of = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = of.parse(pickupDate);
        String Timeslotdate = of.format(startDate);
        System.out.println("Formatted Date of selected Pickup Time Slot is: ===========>>> " + Timeslotdate);
        long diffday = startDate.getDate() - date1.getDate();
        System.out.println(diffday + "Days");
        if (diffday > 0) {
            System.out.println("Slot is displayed one day after current day");
        }
    }

    public void Sunday_Ad_Break_message_is_displayed() {
        String pickupDay = null;
        int k = 1, indexofToday = 1;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        switch (today.toLowerCase()) {
            case "sunday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "monday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "tuesday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "wednesday":
                for (int i = 1; i < PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);

                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);

                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                    i++;
                    if (pickupDay.contains("SUN") || pickupDay.contains("MON")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;

                    }

                    i--;
                }
                break;
            case "thursday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if ((i == 1) && todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                        i++;
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("MON") || pickupDay.contains("TUE") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("FRI") || pickupDay.contains("SAT")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "friday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "saturday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    public void Thursday_Ad_Break_message_is_displayed() {
        String pickupDay = null;
        int k = 1;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        switch (today.toLowerCase()) {
            case "sunday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
//                        i++;
                        continue;
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "monday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "tuesday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "wednesday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                        i++;
                        continue;
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN") || pickupDay.contains("MON")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "thursday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "friday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
            case "saturday":
                for (int i = 1; i <= PICKUP_DAY_SLIDER_LIST.size(); i++) {
                    if (todayPickup.getText().contains("Today")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[1]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for TODAY & Value is " + value);
                    }
                    getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")).click();
                    pickupDay = getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")).getText().toUpperCase();
                    System.out.println(pickupDay);
                    if (pickupDay.contains("THU") || pickupDay.contains("FRI") || pickupDay.contains("SAT") || pickupDay.contains("SUN")) {
                        String pickupMessage = getDriver().findElement(By.xpath("(.//*[@id='adBreakMessage']/span)[" + k + "]")).getText();
                        System.out.println("Ad Break Message is displayed for " + pickupDay + "DAY");
                        Assert.assertTrue(pickupMessage.contains("Sale prices may differ on this day due to a new weekly ad."));
                        k++;
                    }
                    if (pickupDay.contains("WED")) {
                        Boolean value = UtilityHelper.elementNotExists(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        System.out.println("AdBreak Message is not present for " + pickupDay + "DAY & Value is " + value);
                    }
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    //109384
    public void Sunday_Ad_Break_message_displayed_forSPO() throws InterruptedException {
        int index, x, i, j;
        String pickupDay1slot;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        WebElement day1slot = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[1]/span[2]"));
        switch (today.toLowerCase()) {
            case "thursday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("fri")) {
                    for (x = 0; x < 2; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 2; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "friday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sat")) {
                    for (x = 0; x < 1; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                    for (i = 0; i <= 5; i++) {
                        while (x < 5) {
                            Thread.sleep(2000);
                            getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                            x++;
                        }
                        x = 0;
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            Thread.sleep(2000);
                            getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "saturday":
                index = 1;
                j = 0;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                List<WebElement> pickupDaySliderWindow2 = getDriver().findElements(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li"));
                int slotsAvailable = pickupDaySliderWindow2.size();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sun")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 5 && x < 5) {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && j < 6) {
                                Thread.sleep(1000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                                j++;
                            } else {
                                if (index <= slotsAvailable) {
                                    Thread.sleep(1000);
                                    getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                    Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                    Assert.assertTrue("", value);
                                    String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                    String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                    System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                    index++;
                                }
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                }
                break;
            case "sunday":
                index = 1;
                j = 0;
                day1slot.click();
                pickupDaySliderWindow2 = getDriver().findElements(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li"));
                slotsAvailable = pickupDaySliderWindow2.size();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("mon")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && j < 6) {
                                Thread.sleep(1000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                                j++;
                            } else {
                                if (index <= slotsAvailable) {
                                    Thread.sleep(1000);
                                    getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                    Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                    Assert.assertTrue("", value);
                                    String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                    String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                    System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                    index++;
                                }
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i == 0 && x < 5) {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                }
                break;
            case "monday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("tue")) {
                    for (x = 0; x < 5; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 5; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "tuesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);

                if (day1slot.getText().toLowerCase().contains("wed")) {
                    for (x = 0; x < 4; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 4; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }

                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "wednesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("thu")) {
                    for (x = 0; x < 3; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 3; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        setImplicitTimeout(15, TimeUnit.SECONDS);
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    //	109384
    public void Thursday_Ad_Break_message_displayed_forSPO() throws InterruptedException {
        int index, x, i;
        String pickupDay1slot;
        String daysArray[] = {"0", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(":::::::::::::::::   DAY IS   ::::::::::::  " + day);
        String today = daysArray[day];
        System.out.println(":::::::::::::::::   TODAY IS   ::::::::::::  " + today);
        UtilityHelper.waitUntilElementVisible(By.xpath(".//*[@class='mjr-modal pickupTimeModalWrap']/div"));
        WebElement day1slot = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[1]/span[2]"));
        switch (today.toLowerCase()) {
            case "monday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("tue")) {
                    for (x = 0; x < 2; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 2; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "tuesday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("wed")) {
                    for (x = 0; x < 1; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                    for (i = 0; i <= 5; i++) {
                        while (x < 5) {
                            Thread.sleep(2000);
                            getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                            x++;
                        }
                        x = 0;
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            Thread.sleep(2000);
                            getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                            Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                            Assert.assertTrue("", value);
                            String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                            String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                            System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                            index++;
                        }
                    }
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "wednesday":
                index = 1;
                int j = 0;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                List<WebElement> pickupDaySliderWindow2 = getDriver().findElements(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li"));
                int slotsAvailable = pickupDaySliderWindow2.size();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("thu")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 5 && x < 5) {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && j < 6) {
                                Thread.sleep(1000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                                j++;
                            } else {
                                if (index <= slotsAvailable) {
                                    Thread.sleep(1000);
                                    getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                    Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                    Assert.assertTrue("", value);
                                    String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                    String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                    System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                    index++;
                                }
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                }
                break;
            case "thursday":
                index = 1;
                j = 0;
                day1slot.click();
                pickupDaySliderWindow2 = getDriver().findElements(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li"));
                slotsAvailable = pickupDaySliderWindow2.size();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("fri")) {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i <= 1 && j < 6) {
                                Thread.sleep(1000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                                j++;
                            } else {
                                if (index <= slotsAvailable) {
                                    Thread.sleep(1000);
                                    getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                    Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                    Assert.assertTrue("", value);
                                    String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                    String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                    System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                    index++;
                                }
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                } else {
                    for (i = 0; i <= 5; i++) {
                        for (x = 0; x < 5; x++) {
                            if (i == 0 && x < 5) {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            } else {
                                Thread.sleep(2000);
                                getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                                Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                                Assert.assertTrue("", value);
                                String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                                String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                                System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                                index++;
                            }
                        }
                        getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                        Thread.sleep(2000);
                    }
                }
                break;
            case "friday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println(" Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sat")) {
                    for (x = 0; x < 5; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 5; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "saturday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("sun")) {
                    for (x = 0; x < 4; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 4; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
            case "sunday":
                index = 1;
                day1slot.click();
                pickupDay1slot = day1slot.getText().toLowerCase();
                System.out.println("  Slots starts with: " + pickupDay1slot);
                if (day1slot.getText().toLowerCase().contains("mon")) {
                    for (x = 0; x < 3; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                } else {
                    for (x = 1; x < 3; x++) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementNotExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message not present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                    }
                }
                for (i = 0; i <= 5; i++) {
                    while (x < 5) {
                        Thread.sleep(2000);
                        getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]")).click();
                        Boolean value = UtilityHelper.elementExists(By.xpath(".//*[@id='pickup-time-slots-id']/div[" + index + "]//div[contains (@id, 'adBreakMessage')]/span"));
                        Assert.assertTrue("", value);
                        String avail_PickupDay = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[2]")).getText();
                        String avail_PickupDate = getDriver().findElement(By.xpath(".//*[@id='pickup-time-navbar']/div[2]/ul/li[" + index + "]/span[1]")).getText();
                        System.out.println("Adbreak message present for " + avail_PickupDay + " / " + avail_PickupDate);
                        index++;
                        x++;
                    }
                    x = 0;
                    getDriver().findElement(By.xpath(".//*[@id='pickUpArrowRight']/button")).click();
                    Thread.sleep(2000);
                }
                break;
        }
        UtilityHelper.click(TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    public void atRandomReserveAvailablePickUpTime() {
        List<WebElement> daySliderCount, totalSlotCount;
        daySliderCount = getDriver().findElements(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li"));
        UtilityHelper.shuffleList(2, daySliderCount.size());
        int i = UtilityHelper.popShuffledList();
        System.out.println("=== DESIRED DAY: " + i);
        if (i > 6) {
            try {
                clickRightArrow_XnumberofTimes_PickupTimeModal(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        UtilityHelper.click(getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]")));
        String xpath = "//*[@id='pickup-time-slots-id']/div[" + i + "][not(contains(@class,'noDisplay'))]";
        UtilityHelper.waitUntilClickable(By.xpath(xpath));
        totalSlotCount = getDriver().findElements(By.xpath("//*[@id='pickup-time-slots-id']/div[" + i + "]/div"));
        UtilityHelper.shuffleList(1, totalSlotCount.size());
        for (int k = 1; k <= totalSlotCount.size(); k++) {
            int j = UtilityHelper.popShuffledList();
            System.out.println("=== DESIRED SLOT: " + j);
            String byXpath = "//*[@id='pickup-time-slots-id']/div[" + i + "]/div[" + j + "]";
            boolean isNotAvailable = UtilityHelper.elementGetAttribute(getDriver().findElement(By.xpath(byXpath)), "class").contains("not-available");
            if (isNotAvailable) {
                continue;
            }
            boolean isAdBreakMessage = getDriver().findElement(By.xpath(byXpath)).getAttribute("id").contains("adBreakMessage");
            if (isAdBreakMessage){
                continue;
            }
            UtilityHelper.click(By.xpath(byXpath));
            String DATE = UtilityHelper.elementGetText(getDriver().findElement(By.xpath("//*[@id='pickupDaySliderWindow']/ul/li[" + i + "]/span[2]")));
            String TIME = UtilityHelper.elementGetAttribute(By.xpath(byXpath), "data-starttime").substring(0, 5);
            pickupDate = DATE;
            pickupTime = TIME;
            System.out.println("DATE = [" + DATE + "]");
            System.out.println("TIME = [" + TIME + "]");
            break;
        }
    }

    public void validateSelectedDateAndTimeViaPickUpPage() {
        String value = UtilityHelper.elementGetText(HOLD_TIME_PICKUP_PAGE);
        Assert.assertTrue("Verify DATE of slot reservation: ", value.toUpperCase().contains(pickupDate));
        Assert.assertTrue("Verify TIME of slot reservation: ", value.toUpperCase().contains(pickupTime));
    }

    public void verifyCurrentDateAndTimeViaOrderDetailsPage() {
        String actualDATE = UtilityHelper.elementGetText(By.xpath("//*[contains(@class,'click')]/span[2]"));
        String actualTIME = UtilityHelper.elementGetText(By.xpath("//*[contains(@class,'selected active')]/div[1]")).substring(0, 5);
        if (actualTIME.charAt(0) == '0') {
            actualTIME = actualTIME.substring(1);
        }
        Assert.assertEquals("Verify DATE on Active Order: ", pickupDate.toUpperCase(), actualDATE.toUpperCase());
        Assert.assertEquals("Verify TIME on Active Order: ", pickupTime.toUpperCase(), actualTIME.toUpperCase());
    }

    public void verifyStaticMessageIsDisplayed_PickupPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='disclaimerText']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified the static message in Pickup page===");
    }
}

