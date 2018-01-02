package com.tcs.automation.steps;

import com.tcs.automation.steps.serenity.OrderPickupStepSerenity;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.text.ParseException;

public class OrderPickupStepDefinition {

    @Steps
    OrderPickupStepSerenity orderPickUpStepSerenity;

    @Then("pickup Page display")
    public void pickupPageDisplay() {
        orderPickUpStepSerenity.validateScheduleAndPickupCopyDisplays();
    }

    @Then("Verify there is no curbside radio button is displayed")
    public void checkForNoCurbsideRadioButton() {
        orderPickUpStepSerenity.checkForNoCurbsideRadioButton();
    }

    @Then("Verify there is no Deli radio button is displayed")
    public void checkForNoDeliRadioButton() {
        orderPickUpStepSerenity.checkForNoDeliRadioButton();
    }

    @Then("validate slot reservation is display correct in checkout flow")
    public void validateSlotReservationIsDisplayCorrectInCheckoutFlow() {
        orderPickUpStepSerenity.validateSlotReservationIsDisplayCorrectInCheckoutFlow();
        orderPickUpStepSerenity.validateSlotReservationIsDisplayCorrectInRHR();
    }

    @Then("verify Pickup Info Display on Pickup page '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'")
    public void verify2ndTCPickupInfoDisplayonPickup(String storename, String address1, String shipadr2, String dvrymethd, String itemcount) {
        orderPickUpStepSerenity.verify_PickupInfoDisplayOnPickup(storename, address1, shipadr2, dvrymethd, itemcount);
    }

    @Then("Pickup Timeslot pop up window display")
    public void PickupTimeSlotPopupWindowDisplay() {
        orderPickUpStepSerenity.PickupTimeSlotPopupWindowDisplay();
    }

    @Then("user enter Phone and Email details in Pickup Info '(.*)' '(.*)'")
    public void userEnterPhoneAndEmailInPickupInfo(String ph_number, String email) {
        orderPickUpStepSerenity.user_EnterPhoneAndEmailPickupInfo(ph_number, email);
    }

    @Then("enter full pickup info details '(.*)' '(.*)' '(.*)' '(.*)'")
    public void enterFullPickupInfoDetails(String firstname, String lastname, String ph_number, String email) {
        orderPickUpStepSerenity.enterFullPickupInfoDetails(firstname, lastname, ph_number, email);
    }

    @Then("select next day first day available Pickup slot")
    public void selectNextDayFirstDayAvailablePickupSlot() throws InterruptedException {
        orderPickUpStepSerenity.select_NextDayFirstDayAvailablePickupSlot();
    }

    @Then("enter pickup location info '(.*)'")
    public void pickupLocationInfo(String cardesc) {
        orderPickUpStepSerenity.pickup_LocationInfo(cardesc);
    }

    @Then("user verify auto filled Name value on enter pickup info fields '(.*)' '(.*)'")
    public void userVerifyAutoFilledValueOnEnterPickupInfoFields(String firstname, String lastname) {
        orderPickUpStepSerenity.user_VerifyAutoFilledNameValueOnEnterPickupInfoFields(firstname, lastname);
    }

    @Then("validate pickup location for cake/deli item")
    public void validatePickupLocationForCakeDeliitem() {
        orderPickUpStepSerenity.validate_PickupLocationForCakeDeliitem();
    }

    @Then("validate complete prefilled value under pickup info fields '(.*)' '(.*)' '(.*)' '(.*)'")
    public void validateCompletePreFilledValueUnderPickupInfoFields(String firstname, String lastname, String ph_number, String email) {
        orderPickUpStepSerenity.validateFirstNameTextBoxFieldPickupInfo(firstname);
        orderPickUpStepSerenity.validateLastNameTextBoxFieldPickupInfo(lastname);
        orderPickUpStepSerenity.validatePhoneNumberTextBoxFieldPickup(ph_number);
        orderPickUpStepSerenity.validateEmailAddressTextBoxFieldPickup(email);
    }

    @Then("select Pickup slot several days in future")
    public void selectPickupSlotSeveralDaysInFuture() {
        orderPickUpStepSerenity.select_SeveralDayinFutureFirstAvailablePickupSlot();
    }

    //Created By:107793 11/04/16

    @Then("user clicks Select Pick Up Time button via checkout")
    public void userClicksSelectPickUpTimeButtonViaCheckout() {
        orderPickUpStepSerenity.highLightSelectOrChangePickUpTimeButton();
        orderPickUpStepSerenity.userClicksSelectPickUpTimeButtonViaCheckout();
    }

    @Then("select pickup slot for same day")
    public void selectPickupSlotAtLeast4hrsInFuture() {
        orderPickUpStepSerenity.select_PickupSlotAtLeast4hrsInFuture();
    }

    @Then("Select Randomly Available time Slot to Place HOLD a Slot")
    public void PickupTimeslotDisplayAndSelectAvailableSlotToPlaceHOLDaSlot() {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.atRandomReserveAvailablePickUpTime();
    }

    @Then("verify thu adbreak for all time slot")
    public void verifytimeslotthuradbreak() throws InterruptedException {
        orderPickUpStepSerenity.timeslot_thu_adbreak();
    }

    @Then("verify thu adbreak for all time slot spo")
    public void verifytimeslotthuradbreakspo() throws InterruptedException {
        orderPickUpStepSerenity.timeslot_thu_adbreakspo();
    }


    @Then("verify sun adbreak for all time slot")
    public void verifytimeslotsunadbreak() {
        orderPickUpStepSerenity.timeslotsunadbreak();
    }


    @Then("sun spo adbreak for all time slot")
    public void sunadbreak_spo() {
        orderPickUpStepSerenity.sposunday();
    }

    @Then("select Edit link to Change Store on Pickup Page")
    public void selectEditLinkToChangeStore() {
        orderPickUpStepSerenity.select_EditLinkToChangeStore();
    }

    @Then("validate pre-selected time slot HOLD display correct")
    public void validatePreSelectedTimeSlotHoldDisplayCorrect() throws ParseException {
        orderPickUpStepSerenity.validate_PreSelectedTimeSlotHoldDisplayCorrect();
    }

    @Then("select Available time Slot 2Days Later to Place HOLD a Slot")
    public void PickupTimeslotDisplayAndSelectAvailableSlot2DaysLaterSlot() {
        orderPickUpStepSerenity.pickupTimeslot_DisplayAndSelect_AvailableSlot2DaysLaterSlot();
    }

    @Then("user click on change link to edit Pickup Time")
    public void userClickOnChangeLinkToEditPickupTime() {
        orderPickUpStepSerenity.user_ClickOnChangeLinkToEditPickupTime();
    }

    @Then("validate Pickup Time modal display")
    public void validatePickupTimeModalDisplay() {
        orderPickUpStepSerenity.validate_PickupTimeModalDisplay();
    }

    @Then("validate current hold slot display correctly")
    public void validatecurrentholdslotdisplaycorrectly() {
        orderPickUpStepSerenity.validate_currentholdslotdisplaycorrectly();
    }

    @Then("validate user is able to select a new pickup date")
    public void validateUserIsAbleToSelectANewPickupDate() {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.atRandomReserveAvailablePickUpTime();
    }

    @Then("validate pickup time drop reserved drop")
    public void validatePickupTimeDropReservedDrop() {
        orderPickUpStepSerenity.validate_PickupTimeDropReservedDrop();
    }

    @Then("compare first available time Slot is same as displayed in curbside wizard")
    public void compareFirstAvailableTimeSlotSameAsDisplayedInCurbsideWizard() {
        orderPickUpStepSerenity.compareFirstAvailable_TimeSlotSameAsDisplayedInCurbsideWizard();
    }

    @Then("validate user is allow upto additional 5 business days for advanced pickup time selection")
    public void validateUserAllowUptoAdditional5BusinessDaysForAdvancedPickupTimeSelection() {
        orderPickUpStepSerenity.validate_UserAllowUptoAdditional5BusinessDaysForAdvancedPickupTimeSelection();
    }

    @Then("validate content of each slot on Pickup Timeslot wizard")
    public void validateContentofEachSlotonPickupTimeslotWizard() {
        orderPickUpStepSerenity.validate_ContentofEachSlotonPickupTimeslotWizard();
    }

    @Then("close Pickup Timeslot pop up window")
    public void closePickupTimeSlotPopupWindow() {
        orderPickUpStepSerenity.highLightClosePickupTimeSlotModal();
        orderPickUpStepSerenity.clickClosePickupTimeSlotPopupWindow();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("select FIRST available pickup time slot")
    public void selectFIRSTavailablePickupTimeSlot() {
        orderPickUpStepSerenity.select_FIRSTavailablePickupTimeSlot();
    }

    @Then("Select Randomly any Available time Slot")
    public void SelectRandomlyAnyAvailableTimeSlot() {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.atRandomReserveAvailablePickUpTime();
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("Randomly select any Available Slot for Mixed Cart")
    public void randomlySelectAnyAvailableSlotforMixedCart() throws InterruptedException {
        orderPickUpStepSerenity.randomlySelect_AnyAvailableSlotfor_MixedCart();
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("select Reserve Time button")
    public void selectReserveTimeButton() {
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("validate user is allowed to select pickup time up to 30 Days in advance")
    public void validateUserisAllowedToSelectPickupTimeUpTo30DaysInAdvance() {
        orderPickUpStepSerenity.validate_UserisAllowedToSelectPickupTimeUpTo_30DaysInAdvance();
    }

    @Then("Randomly Highlight an available TimeSlot")
    public void clickPickupTimeButtonAndRandomlySelectAvailableTimeSlot() {
        orderPickUpStepSerenity.Select_Randomly_AnyAvailableTimeSlot();
    }

    @Then("validate Button Text is Select Pickup Time")
    public void validateButtonTextdisplaySelectPickupTime() {
        orderPickUpStepSerenity.validate_ButtonText_SelectPickupTime();
    }

    @Then("validate content of each Pickup Time slot on Pickup page")
    public void validateContentofEachPickupTimeSlotOnPickupPage() throws InterruptedException {
        orderPickUpStepSerenity.validate_ContentofEachPickupTimeSlotOn_PickupPage();
    }

    @Then("validate user Selected Pickup Time display correct")
    public void validateUserSelectedPickupTimeDisplayCorrect() throws ParseException {
        orderPickUpStepSerenity.validate_PreSelectedTimeSlotHoldDisplayCorrect();
    }


    @Then("Randomly select any Available Slot for CAKE only Item")
    public void randomlySelectAnyAvailableSlotforCAKEonlyItem() throws InterruptedException {
        orderPickUpStepSerenity.randomlySelect_AnyAvailableSlotfor_CAKEonlyItem();
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
    }

    @Then("validate the error messages displayed for mandatory fields on Pickup Page")
    public void validateErrorMessagesDisplayForMandatoryFieldsonPickupPage() {
        orderPickUpStepSerenity.validate_ErrorMessagesDisplayForMandatoryFieldson_PickupPage();
    }

    @Then("validate Select Pickup Time button on Pickup Times popup window is disabled")
    public void validateSelectPickupTimeButtonOnPickupTimesPopupWindowIsDisabled() {
        orderPickUpStepSerenity.validate_SelectPickupTimeButtonOnPickupTimesPopupWindow_IsDisabled();
    }

    @Then("validate Error Message for Today Slot")
    public void validateErrorMessageForTodaySlot() {
        orderPickUpStepSerenity.validate_ErrorMessageForTodaySlot();
    }

    @Then("validate next day slot is displayed as Day1 slot")
    public void validateNextDaySlotIsDisplayedAsDay1Slot() {
        orderPickUpStepSerenity.validate_NextDaySlotIsDisplayedAsDay1Slot();
    }

    //Created By: 107793 10/31/16
    @Then("verify pickup time not selected, time slot modal appears")
    public void pickupTimeNotSelected_TimeSlotModalAppears() {
        orderPickUpStepSerenity.noPickupTimeSelected_TimeSlotModalAppears();
    }

    //Created By: 107793 10/27/16
    @Then("verify store id in time slot modal")
    public void verifyStoreID_InTimeSlotModal() {
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
    }

    //Created By: 107793 11/07/16
    @Then("reserve an available pickup slot at least '(.*)' hours in future and click Reserve button")
    public void reserveAvailablePickupSlot4hrsInFuture(int xhours) throws InterruptedException {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.reserveAvailablePickupSlot4hrsInFuture(xhours);
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("wait until the slot appears")
    public void waituntilslot() {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
    }

    //Created By: 107793 11/07/16
    @Then("reserve an available pickup with lead time of '(.*)' hrs for Mixed Cart")
    public void reserveAvailablePickupSlotWithLeadTime_MixedCart(int xhours) throws InterruptedException {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.reserveAvailablePickupSlot4hrsInFuture(xhours);
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    //Created By: 107793 11/07/16
    @Then("reserve an available pickup with lead time of '(.*)' hrs for SPO Cart")
    public void reserveAvailablePickupSlotWithLeadTime_SPOCart(int xhours) throws InterruptedException {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.reserveAvailablePickupSlot4hrsInFuture(xhours);
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("clear input values on Pickup Page")
    public void userClearsInputValuesOnPickupPage() {
        orderPickUpStepSerenity.clearInputValuesOnPickupPage();
    }

    //Created By: 107793 11/07/16
    @Then("verify error messaging on Pickup Page")
    public void verifyErrorMessagingOnPickupPage() {
        orderPickUpStepSerenity.errorMessage_FirstName();
        orderPickUpStepSerenity.errorMessage_LastName();
        orderPickUpStepSerenity.errorMessage_PhoneNumber();
        orderPickUpStepSerenity.errorMessage_EmailAddress();
    }


    @Then("validate First timeslot display with minimum 24 hrs lead time")
    public void validateFirstTimeslotDisplayWithMinimum24hrsLeadTime() throws ParseException {
        orderPickUpStepSerenity.validate_FirstTimeslotDisplayWithMinimum24hrsLeadTime();
    }

    @Then("validate Max 30 days slider display for SPO only item")
    public void validateMax30daysSliderDisplayForSPOItem() {
        orderPickUpStepSerenity.validate_Max30daysSliderDisplayForSPOItem();
    }

    @Then("Validate the thursday Ad Break message is displayed")
    public void Validate_the_thursday_Ad_Break_message_is_displayed() {
        orderPickUpStepSerenity.the_thursday_Ad_Break_message_is_displayed();
    }

    @Then("Validate the Sunday Ad Break message is displayed")
    public void Validate_the_Sunday_Ad_Break_message_is_displayed() {
        orderPickUpStepSerenity.the_Sunday_Ad_Break_message_is_displayed();
    }

    @Then("Validate the thursday Ad Break message displayed for SPO")
    public void Validate_the_thursday_Ad_Break_message_displayed_for_SPO() throws InterruptedException {
        orderPickUpStepSerenity.the_thursday_Ad_Break_message_displayed_for_SPO();
    }

    @Then("Validate the Sunday Ad Break message displayed for SPO")
    public void Validate_the_Sunday_Ad_Break_message_displayed_for_SPO() throws InterruptedException {
        orderPickUpStepSerenity.the_Sunday_Ad_Break_message_displayed_for_SPO();
    }

    @Then("at random, reserve an available pick up time and click Reserve button")
    public void atRandomReserveAvailablePickUpTimeAndClickReserveButton() {
        orderPickUpStepSerenity.waitUntilTimeSlotAppears();
        orderPickUpStepSerenity.verifyStoreIdInTimeSlotModal();
        orderPickUpStepSerenity.atRandomReserveAvailablePickUpTime();
        orderPickUpStepSerenity.highLightReserveTimeButton();
        orderPickUpStepSerenity.clickReserveTimeButton();
        orderPickUpStepSerenity.waitUntilTimeSlotNoLongerExists();
    }

    @Then("validate DATE and TIME of selected Time Slot via Pickup Page")
    public void validateSelectedDateAndTimeViaPickUpPage() {
        orderPickUpStepSerenity.validateSelectedDateAndTimeViaPickUpPage();
    }

    @Then("verify static message is displayed in pickup page")
    public void verifyStaticMessageIsDisplayed_PickupPage() {
        orderPickUpStepSerenity.verifyStaticMessageIsDisplayed_PickupPage();
    }
}

