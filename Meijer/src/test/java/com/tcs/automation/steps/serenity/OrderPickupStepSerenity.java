package com.tcs.automation.steps.serenity;

import com.tcs.automation.pages.OrderPickupPage;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.text.ParseException;

public class OrderPickupStepSerenity extends ScenarioSteps {

    OrderPickupPage orderPickUpPage;
    utilityhelper UtilityHelper;

    @Step
    public void validateScheduleAndPickupCopyDisplays() {
        orderPickUpPage.validateScheduleAndPickupCopyDisplays();
    }

    @Step
    public void checkForNoCurbsideRadioButton() {
        orderPickUpPage.checkForNoCurbsideRadioButton();
    }

    @Step
    public void checkForNoDeliRadioButton() {
        orderPickUpPage.checkForNoDeliRadioButton();
    }


    @Step
    public void verify_PickupInfoDisplayOnPickup(String storename, String address1, String shipadr2, String dvrymethd, String itemcount) {
        orderPickUpPage.verifyPickupInfoDisplayPickupPage(storename, address1, shipadr2, dvrymethd, itemcount);
    }

    @Step
    public void PickupTimeSlotPopupWindowDisplay() {
        orderPickUpPage.waitUntilTimeSlotAppears();
    }

    @Step
    public void user_EnterPhoneAndEmailPickupInfo(String ph_number, String email) {
        orderPickUpPage.enterPhoneNumber(ph_number);
        orderPickUpPage.enterEmail(email);
    }

    @Step
    public void enterFullPickupInfoDetails(String firstName, String lastName, String phoneNumber, String email) {
        orderPickUpPage.enterFirstName(firstName);
        orderPickUpPage.enterLastName(lastName);
        orderPickUpPage.enterPhoneNumber(phoneNumber);
        orderPickUpPage.enterEmail(email);
    }

    @Step
    public void select_NextDayFirstDayAvailablePickupSlot() throws InterruptedException {
        orderPickUpPage.selectRandomPickupSlot(false);
    }

    @Step
    public void select_SeveralDayinFutureFirstAvailablePickupSlot() {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.waitUntilTimeSlotAppears();
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
        orderPickUpPage.selectseveraldayfuturepickuptime();
        orderPickUpPage.click_SelectPickupTimeButton_PickupTimesPopup();
    }

    @Step
    public void highLightSelectOrChangePickUpTimeButton() {
        if (UtilityHelper.elementExists(orderPickUpPage.SELECT_PICKUP_BUTTON)) {
            // 'Select' Button
            UtilityHelper.highLightElement(orderPickUpPage.SELECT_PICKUP_BUTTON);
        } else {
            // 'Change' Link
            UtilityHelper.highLightElement(orderPickUpPage.CHANGE_PICKUP_LINK);
        }
    }

    @Step
    public void userClicksSelectPickUpTimeButtonViaCheckout() {
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
    }

    @Step
    public void pickup_LocationInfo(String carDescription) {
        orderPickUpPage.enterPickupLocation(carDescription);
    }


    @Step
    public void user_VerifyAutoFilledNameValueOnEnterPickupInfoFields(String firstname, String lastname) {
        orderPickUpPage.autoFilledNameValueValidationPickupInfo(firstname, lastname);
    }


    @Step
    public void validate_PickupLocationForCakeDeliitem() {
        orderPickUpPage.validateDeliBakeryPresectPickupLocation();
    }


    @Step
    public void validateFirstNameTextBoxFieldPickupInfo(String firstname) {
        orderPickUpPage.validateFirstNameTextBoxFieldPickupInfo(firstname);
    }

    @Step
    public void validateLastNameTextBoxFieldPickupInfo(String lastname) {
        orderPickUpPage.validateLastNameTextBoxFieldPickupInfo(lastname);
    }

    @Step
    public void validateEmailAddressTextBoxFieldPickup(String email) {
        orderPickUpPage.validateEmailAddressTextBoxFieldPickup(email);
    }

    @Step
    public void validatePhoneNumberTextBoxFieldPickup(String ph_number) {
        orderPickUpPage.validatePhoneNumberTextBoxFieldPickup(ph_number);
    }

    @Step
    public void select_PickupSlotAtLeast4hrsInFuture() {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.waitUntilTimeSlotAppears();
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
        orderPickUpPage.topickup4hrslaterCNCitem();
        orderPickUpPage.click_SelectPickupTimeButton_PickupTimesPopup();
    }

    @Step
    public void validateSlotReservationIsDisplayCorrectInCheckoutFlow() {
        orderPickUpPage.validateSlotReservationIsDisplayCorrectInCheckoutFlow();
    }

    @Step
    public void validateSlotReservationIsDisplayCorrectInRHR() {
        orderPickUpPage.validateSlotReservationIsDisplayCorrectInRHR();
    }

    @Step
    public void timeslot_thu_adbreak() throws InterruptedException {
        orderPickUpPage.verifythuadbreak();
    }

    @Step
    public void timeslot_thu_adbreakspo() throws InterruptedException {
        orderPickUpPage.verifythuadbreakSPO();
    }

    @Step
    public void timeslotsunadbreak() {
        orderPickUpPage.verifySUNadbreak();
    }

    @Step
    public void sposunday() {
        orderPickUpPage.AdbreakSPOsunday();
    }

    @Step
    public void highLightReserveTimeButton() {
        UtilityHelper.highLightElement(orderPickUpPage.RESERVE_TIME_BUTTON);
    }

    @Step
    public void clickReserveTimeButton() {
        orderPickUpPage.clickReserveTimeButton();
    }

    @Step
    public void waitUntilTimeSlotNoLongerExists() {
        orderPickUpPage.waitUntilTimeSlotNoLongerExists();
    }

    @Step
    public void select_EditLinkToChangeStore() {
        orderPickUpPage.clickEdit_ChangeStore();
    }

    @Step
    public void validate_PreSelectedTimeSlotHoldDisplayCorrect() throws ParseException {
        orderPickUpPage.validate_SelectedPickupTime();
    }

    @Step
    public void pickupTimeslot_DisplayAndSelect_AvailableSlot2DaysLaterSlot() {
        orderPickUpPage.select_pickuptime_2DaysLater();
    }

    @Step
    public void user_ClickOnChangeLinkToEditPickupTime() {
        orderPickUpPage.click_ChangeLink_editpickuptime();
    }

    @Step
    public void validate_PickupTimeModalDisplay() {
        orderPickUpPage.PickupTimeSlotPopupWindowDisplay();
    }

    @Step
    public void compareFirstAvailable_TimeSlotSameAsDisplayedInCurbsideWizard() {
        orderPickUpPage.firstAvaiableDay_ForPickupSlot();
        orderPickUpPage.firstAvailableSlot_PickupTimes();
        orderPickUpPage.validate_firstavailableSlot_Display();
        orderPickUpPage.click_Cancel_PickupTimesPopup();
    }

    @Step
    public void validate_UserAllowUptoAdditional5BusinessDaysForAdvancedPickupTimeSelection() {
        orderPickUpPage.validate_5DaysAdvance_PickupSlot();
    }

    @Step
    public void validate_ContentofEachSlotonPickupTimeslotWizard() {
        orderPickUpPage.highlightPickuptimeSlot_ValidateContent();
    }

    @Step
    public void highLightClosePickupTimeSlotModal() {
        UtilityHelper.highLightElement(orderPickUpPage.TIME_SLOT_MODAL_CLOSE_BUTTON);
    }

    @Step
    public void clickClosePickupTimeSlotPopupWindow() {
        orderPickUpPage.clickClosePickupTimeSlotPopupWindow();
    }

    @Step
    public void select_FIRSTavailablePickupTimeSlot() {
        orderPickUpPage.waitUntilTimeSlotAppears();
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
        orderPickUpPage.select_FIRSTpickupslot();
    }

    //Created By: 107793 11/07/16
    @Step
    public void reserveAvailablePickupSlot4hrsInFuture(int xHours) {
        orderPickUpPage.reserveAvailableTimeSlot(xHours);
    }

    @Step
    public void Select_Randomly_AnyAvailableTimeSlot() {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.waitUntilTimeSlotAppears();
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
        orderPickUpPage.selectAnyAvailablePickuptime_Random();
    }

    @Step
    public void randomlySelect_AnyAvailableSlotfor_CAKEonlyItem() throws InterruptedException {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.selectAnyAvailablePickuptime_Randomfor_MixedCart();
    }

    @Step
    public void randomlySelect_AnyAvailableSlotfor_MixedCart() throws InterruptedException {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.waitUntilTimeSlotAppears();
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
        orderPickUpPage.selectAnyAvailablePickuptime_Randomfor_MixedCart();
    }

    @Step
    public void validate_UserisAllowedToSelectPickupTimeUpTo_30DaysInAdvance() {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.validatePickup30DaysAdvance_ForCake();
        orderPickUpPage.clickClosePickupTimeSlotPopupWindow();
    }

    @Step
    public void validate_ButtonText_SelectPickupTime() {
        orderPickUpPage.validate_SelectPickupTime_ButtonTextDisplay();
    }

    @Step
    public void validate_ContentofEachPickupTimeSlotOn_PickupPage() throws InterruptedException {
        highLightSelectOrChangePickUpTimeButton();
        orderPickUpPage.userClicksSelectPickUpTimeButtonViaCheckout();
        orderPickUpPage.highlight_PickuptimeSlot_ValidateContent_PickupPage();
    }

    @Step
    public void validate_ErrorMessagesDisplayForMandatoryFieldson_PickupPage() {
        orderPickUpPage.validate_Blank_PickupTime_ErrorMsg();
        orderPickUpPage.validate_Blank_FirstName_ErrorMsg();
        orderPickUpPage.validate_Blank_LastName_ErrorMsg();
        orderPickUpPage.validate_Blank_PhoneNumbere_ErrorMsg();
        orderPickUpPage.validate_Blank_EmailAddress_ErrorMsg();
    }

    @Step
    public void validate_NextDaySlotIsDisplayedAsDay1Slot() {
        orderPickUpPage.validate_NexDaySlots_Display_DaySlider1();
    }

    @Step
    public void validate_FirstTimeslotDisplayWithMinimum24hrsLeadTime() throws ParseException {
        orderPickUpPage.validate_FirstPickup_Slot_SPOItem();
    }

    @Step
    public void validate_Max30daysSliderDisplayForSPOItem() {
        orderPickUpPage.validatePickup30DaysAdvance_ForCake();
    }

    @Step
    public void verifyStoreIdInTimeSlotModal() {
        orderPickUpPage.verifyStoreIdInTimeSlotModal();
    }


    //Created By: 107793 10/31/16
    @Step
    public void noPickupTimeSelected_TimeSlotModalAppears() {
        orderPickUpPage.selectPickUpTimeButtonIsDisplayed();
        orderPickUpPage.PickupTimeSlotPopupWindowDisplay();
    }

    //Created By: 10793 11/07/16
    @Step
    public void validate_currentholdslotdisplaycorrectly() {
        orderPickUpPage.validate_HoldPickupTime_DisplayCorrect();
    }

    @Step
    public void validate_PickupTimeDropReservedDrop() {
        orderPickUpPage.reserved_pickuptime_drop();
    }

    @Step
    public void validate_SelectPickupTimeButtonOnPickupTimesPopupWindow_IsDisabled() {
        orderPickUpPage.valdiate_SelectPickupTimesButton_Disabled();
    }

    @Step
    public void validate_ErrorMessageForTodaySlot() {
        orderPickUpPage.noSlot_Errormsg_Today_TimeSlot();
    }

    //Created By: 10793 11/07/16
    @Step
    public void clearInputValuesOnPickupPage() {
        orderPickUpPage.clearFirstName();
        orderPickUpPage.clearLastName();
        orderPickUpPage.clearPhoneNumber();
        orderPickUpPage.clearEmailAddress();
    }

    //Created By: 107793 11/07/16
    @Step
    public void errorMessage_FirstName() {
        orderPickUpPage.errorMessageFirstName();
    }

    //Created By: 107793 11/07/16
    @Step
    public void errorMessage_LastName() {
        orderPickUpPage.errorMessageLastName();
    }

    //Created By: 107793 11/07/16
    @Step
    public void errorMessage_PhoneNumber() {
        orderPickUpPage.errorMessagePhoneNumber();
    }

    //Created By: 107793 11/07/16
    @Step
    public void errorMessage_EmailAddress() {
        orderPickUpPage.errorMessageEmailAddress();
    }

    //Created By: 107793 12/27/16
    @Step
    public void waitUntilTimeSlotAppears() {
        orderPickUpPage.waitUntilTimeSlotAppears();
    }

    //109384
    @Step
    public void the_thursday_Ad_Break_message_is_displayed() {
        orderPickUpPage.Thursday_Ad_Break_message_is_displayed();
    }

    //109384
    @Step
    public void the_Sunday_Ad_Break_message_is_displayed() {
        orderPickUpPage.Sunday_Ad_Break_message_is_displayed();
    }

    //109384
    @Step
    public void the_thursday_Ad_Break_message_displayed_for_SPO() throws InterruptedException {
        orderPickUpPage.Thursday_Ad_Break_message_displayed_forSPO();
    }

    //109384
    @Step
    public void the_Sunday_Ad_Break_message_displayed_for_SPO() throws InterruptedException {
        orderPickUpPage.Sunday_Ad_Break_message_displayed_forSPO();
    }


    @Step
    public void atRandomReserveAvailablePickUpTime() {
        orderPickUpPage.atRandomReserveAvailablePickUpTime();
    }

    @Step
    public void validateSelectedDateAndTimeViaPickUpPage() {
        orderPickUpPage.validateSelectedDateAndTimeViaPickUpPage();
    }

    @Step
    public void verifyStaticMessageIsDisplayed_PickupPage() {
        orderPickUpPage.verifyStaticMessageIsDisplayed_PickupPage();
    }

}
