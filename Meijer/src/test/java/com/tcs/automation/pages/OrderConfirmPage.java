package com.tcs.automation.pages;

import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotEquals;


public class OrderConfirmPage extends PageObject {



    static String orderNumber = null;

    HomePage homePage;
    OrderReviewPage orderReviewPage;
    utilityhelper UtilityHelper;

    /*------------------------------------------------------*/
    /*---------- Order Confirmation Page Elements ----------*/
    /*------------------------------------------------------*/

    //Order Placed Header text
    @FindBy(xpath = "//li[text()='Order Placed']")
    public WebElement ORDER_PLACED_TITLE;

    //Confirm Label on Progress Bar
    @FindBy(xpath = "//span[text()='Confirm']")
    public WebElement CONFIRM_LABEL;

    //H3 Header - Your Order Has Been Placed!
    @FindBy(xpath = "//h3[text()='Your Order Has Been Placed!']")
    public WebElement YOUR_ORDER_BEEN_PLACE_MSG;

    //Order Number Field
    @FindBy(xpath = "//*[@id='confirmation']/div[1]/div[1]/a")
    public WebElement ORDER_CONFIRM_NUMBER;

    //Error Message
    @FindBy(xpath = "//*[@class='error-message']")
    public WebElement ERROR_MESSAGE;

    //Return Home Button
    @FindBy(xpath = "//*[@id='confirmation']//button[text()='Return Home']")
    public WebElement RETURN_HOME_BUTTON;

    //Edit Order Button
    @FindBy(xpath = "//button[text()='Edit Order']")
    public WebElement EDIT_ORDER_BUTTON;


    /*---------------------------------------------------------------------------*/
    /*------------------------ Confirm Page Action ------------------------------*/
    /*---------------------------------------------------------------------------*/

    //Review Page Heading text validation
    public void confirmPageDisplay() {
        if (UtilityHelper.elementExists(ERROR_MESSAGE)) {
            orderReviewPage.clickOnPlaceOrder(); // Attempt to reSubmit order
            if (UtilityHelper.elementExists(ERROR_MESSAGE)) {
                String actual = UtilityHelper.elementGetText(ERROR_MESSAGE);
                Assert.assertEquals("Invalid Order Placed Message is displayed: ", "Your Order Has Been Placed!", actual);
            } else {
                Assert.assertEquals("Order Placed", UtilityHelper.elementGetText(ORDER_PLACED_TITLE));
                Assert.assertEquals("Confirm", UtilityHelper.elementGetText(CONFIRM_LABEL));
                Assert.assertEquals("Your Order Has Been Placed!", UtilityHelper.elementGetText(YOUR_ORDER_BEEN_PLACE_MSG));
            }
        }
    }

    //Store the order Number
    public void noteDownOrderNumberAfterOrderPlaced() {
        orderNumber = UtilityHelper.elementGetText(ORDER_CONFIRM_NUMBER);
        System.out.println("=== Order Id [" + orderNumber + "]");
    }

    public void highLightClickReturnHomeButton() {
        UtilityHelper.highLightElement(RETURN_HOME_BUTTON);
    }

    public void userClickReturnHomeButton() {
       UtilityHelper.click(RETURN_HOME_BUTTON);
        UtilityHelper.waitUntilElementVisible(homePage.MEIJER_LOGO);
        Assert.assertTrue("Verify Successful Page Load: ", UtilityHelper.isDisplayed(homePage.MEIJER_LOGO));
    }

    public void highLightEditOrderButton() {
        UtilityHelper.highLightElement(EDIT_ORDER_BUTTON);
    }

    public void userClickEditOrderButton() {
       UtilityHelper.click(EDIT_ORDER_BUTTON);
    }

    public void verifyNoStaticMessage_ConfirmPage() {
        WebElement staticmessage_shop = getDriver().findElement(By.xpath(".//*[@id='mjr-rightSidebar']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message in confirmation page for STH order===");
    }

    public void verifyStaticMessage_ConfirmPage() {
        WebElement staticmessage_shop = getDriver().findElement(By.xpath(".//*[@id='disclaimerText']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified the static message in confirmation page===");
    }

}
