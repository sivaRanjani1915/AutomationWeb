package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;



public class OrderHistoryPage extends PageObject {

   utilityhelper UtilityHelper;
    /*---------------------------------------------------------------------*/
    /*----------------- Order History Page Elements -----------------------*/
    /*---------------------------------------------------------------------*/

    //Order History Heading Text
    @FindBy(xpath = "//h1[text()='Order History']")
    public WebElement ORDER_HISTORY_PAGE_TITLE;

    //Active - Order Number value 1st row
    @FindBy(xpath = "//*[@id='order-history']/div[2]//*[@class='td order-id-cell col-sm-2']")
    public WebElement activeOrderNumberValue1stRowOHPage;

    //Active - Order Status value 1st row
    @FindBy(xpath = "//*[@id='order-history']/div[2]//*[@class='td order-status-cell tableDataCenter col-sm-2']")
    public WebElement activeOrderStatusValue1stRowOHPage;

    //Active - Order Edit link 1st row
    @FindBy(xpath = "//span[@class='editOrderLink']")
    public WebElement ACTIVE_ORDER_EDIT_LINK_1ST_ROW;

    //Active - Order View Link 1st row
    @FindBy(xpath = "//*[@id='order-history']//a[text()='View']")
    public WebElement ACTIVE_ORDER_VIEW_LINK_1ST_ROW;

    //Recent Order Sub-Heading
    @FindBy(xpath = "//*[@id='order-history-container']/div[1]")
    public WebElement RECENT_ORDERS_TITLE;

    //Order number field
    @FindBy(xpath = "//*[@name='orderId']")
    public WebElement LOOK_UP_ORDER_ORDERID_TEXTBOX;

    //billing ZipCode field
    @FindBy(xpath = "//*[@name='billingZipCode']")
    public WebElement LOOK_UP_ORDER_ZIPCODE_TEXTBOX;

    //View Order Details Button
    @FindBy(xpath = "//button[text()='View Order Details']")
    public WebElement LOOK_UP_ORDER_BUTTON;

    //order could not found error message
    @FindBy(xpath = "//*[@class='main-content']/div[2]/div[1]//*[@class='error-message']")
    public WebElement ORDER_NOT_FOUND_ERROR_MSG;

    //Cancel Order Header Widget Validation
    @FindBy(xpath = "//*[@id='js-curbside-display-msg']//*[text()='Reserve Curbside Pickup Time']")
    public WebElement curbsideHeaderWidgetAfterCancellation;


	/*-----------------------------------------------------------------------------------*/
	/*------------------------ Order History Page Action --------------------------------*/
	/*-----------------------------------------------------------------------------------*/

    //Order History Text display
    public void orderHistorySummaryPageDisplay() {
        UtilityHelper.waitUntilElementVisible(ORDER_HISTORY_PAGE_TITLE);
        Assert.assertEquals("Order History", UtilityHelper.elementGetText(ORDER_HISTORY_PAGE_TITLE));
    }

    //Order History Page look and feel validation
    public void orderHistorySummary_RecentOrders_TextValidation() {
        Assert.assertTrue(UtilityHelper.elementGetText(RECENT_ORDERS_TITLE).contains("Recent Orders"));
    }

    //Order Number validation
    public void orderNumber_validation_OrderHistory() {
        System.out.println("This is Order Number ======================================================>> [" + OrderConfirmPage.orderNumber + "]");
        Assert.assertEquals(OrderConfirmPage.orderNumber, activeOrderNumberValue1stRowOHPage.getText());
    }

    //Order Status validation
    public void orderStatus_validation_OrderHistory() {
        Assert.assertEquals("Order Placed", activeOrderStatusValue1stRowOHPage.getText());
    }

    //
    public void orderHistorySummaryLinksDisplayValidation() {
        Assert.assertTrue(UtilityHelper.isEnabled(ACTIVE_ORDER_EDIT_LINK_1ST_ROW));
        Assert.assertTrue(UtilityHelper.isEnabled(ACTIVE_ORDER_VIEW_LINK_1ST_ROW));
    }

    public void highLightActiveOrderViewFirstRowTextLink() {
        UtilityHelper.highLightElement(ACTIVE_ORDER_VIEW_LINK_1ST_ROW);
    }

    public void userClickOnViewOptionNextToOrderJustPlaced() {
       UtilityHelper.click(ACTIVE_ORDER_VIEW_LINK_1ST_ROW);
    }

    public void clickEditLinkOrderHistorySummaryPage() {
       UtilityHelper.click(ACTIVE_ORDER_EDIT_LINK_1ST_ROW);
    }

    //Edit link Not display for Cake only order
    public void edit_linkNotDisplay_OrderHistory() {
        List<WebElement> list = getDriver().findElements(By.xpath("//span[@class='editOrderLink']"));
        Assert.assertTrue("=== Edit Link is Present!", list.size() == 0);

    }

    public void userEntersRecentlyPlacedOrderID() {
        UtilityHelper.waitUntilElementVisible(LOOK_UP_ORDER_ORDERID_TEXTBOX);
        UtilityHelper.typeIntoElement(LOOK_UP_ORDER_ORDERID_TEXTBOX, OrderConfirmPage.orderNumber);
    }

    //Search order just ordered
    public void userEntersBillingZipCode(String zipCode) {
        UtilityHelper.typeIntoElement(LOOK_UP_ORDER_ZIPCODE_TEXTBOX, zipCode);
        System.out.println("Zip Code: [" + zipCode + "]");
    }

    public void highLightLookUpOrderButton() {
        UtilityHelper.highLightElement(LOOK_UP_ORDER_BUTTON);
    }

    public void clickLookUpOrderButton() {
       UtilityHelper.click(LOOK_UP_ORDER_BUTTON);
    }

    //Pass order number from feature file
    public void enterProvidedOrderID(String orderId) {
        UtilityHelper.waitUntilElementVisible(LOOK_UP_ORDER_ORDERID_TEXTBOX);
        UtilityHelper.typeIntoElement(LOOK_UP_ORDER_ORDERID_TEXTBOX, orderId);
        System.out.println("Order Id: [" + orderId + "]");
    }

    //Order could not found error message validation
    public void orderCouldNotFoundErrorMsgSPOItem() {
        Assert.assertEquals(Constants.ordercouldnotfoundErrorMsgOrderHistorySearch, UtilityHelper.elementGetText(ORDER_NOT_FOUND_ERROR_MSG));
    }

    //To verify Active Order that *contains(CNC)* products via Order History Page
    //Created By: 107793 12/28/16
    public void verifyActiveOrderByOrderType(String orderType) {
        WebElement row = getDriver().findElement(By.xpath("//div[@class='row' and descendant::*[contains(@class,'order-id-cell') and text()='" + OrderConfirmPage.orderNumber + "']]"));
        String status = UtilityHelper.elementGetText(row.findElement(By.xpath(".//div[contains(@class,'status')]")));
        String orderLinks = UtilityHelper.elementGetText(row.findElement(By.xpath(".//div[contains(@class,'orderLinks')]//*")));
        if (orderType.equals("CNC")) {
            Assert.assertEquals("=== Verify Order Status for Click-And-Collect Active Order", Constants.orderHistoryStatus_OrderPlaced, status);
            Assert.assertTrue("=== Verify 'Edit' is Clickable", orderLinks.contains("Edit"));
        } else {
            Assert.assertEquals("=== Verify NON Click-And-Collect Active Order ", Constants.reserveCurbSidePickUpTimeText, UtilityHelper.elementGetText(curbsideHeaderWidgetAfterCancellation));
            Assert.assertEquals("=== Verify Order Status for NON Click-And-Collect Active Order ", Constants.orderHistoryStatus_OrderPlaced, status);
            Assert.assertEquals("=== Verify 'View' is only Clickable ", "View", orderLinks);
        }
    }

}
