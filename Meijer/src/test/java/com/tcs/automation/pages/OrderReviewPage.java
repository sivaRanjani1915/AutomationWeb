package com.tcs.automation.pages;

import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertNotEquals;

public class OrderReviewPage extends PageObject {


    private static List<String> listoforderReviewitem = new ArrayList<>();
    private List<String> PriceList1 = new ArrayList<>();
    private List<String> QtyList1 = new ArrayList<>();
    private List<String> subtotalPrice = new ArrayList<>();
    private List<String> pricevaluelist = new ArrayList<>();

    /*------------------------------------------------------------------------*/
    /*-------------------- Order Review Page Elements ------------------------*/
    /*------------------------------------------------------------------------*/

    //Order Review Header Text
    @FindBy(xpath = "//li[text()='Order Review']")
    public WebElement ORDER_REVIEW_TITLE;

    //Edit Cart link
    @FindBy(linkText = "Edit Cart")
    public WebElement editCartLinkReview;

    //Order Overall TOTAL Price
    @FindBy(xpath = "//*[@class='total-cost']")
    public WebElement overallTOTALpriceOrderReview;

    //Savings Price value Field
    @FindBy(xpath = "//*[@class='savings-row bordered']/td/table/tbody/tr[2]/td[2]")
    public WebElement savingPriceValueOrderReview;

    //Taxes Price Value field
    @FindBy(xpath = "//*[@class='taxes-row']/td/table/tbody/tr[1]/td[2]")
    public WebElement taxesPriceValueOrderReview;

    //Shipping charge Price Value field
    @FindBy(xpath = "//*[@class='taxes-row']/td/table/tbody/tr[2]/td[2]")
    public WebElement shippingPriceValueOrderReview;

    //Name on Credit Card field
    @FindBy(xpath = "//*[@class='card-info-panel clearfix']/strong")
    public WebElement nameOnCreditCardFieldReview;

    //Credit Card Display
    @FindBy(xpath = "//*[@class='card-info-panel clearfix']/div[1]")
    public WebElement creditCardDisplayReview;

    //Place Order Button
    @FindBy(xpath = "//*[@id='place-order']")
    public WebElement PLACE_ORDER_BUTTON;

    //Credit Card Billing Address1
    @FindBy(xpath = "//*[@class='card-info-panel clearfix']/div[2]")
    public WebElement creditCardBillingAddress1OrderReveiwPage;

    //Credit Card Billing Address2
    @FindBy(xpath = "//*[@class='card-info-panel clearfix']/div[4]")
    public WebElement creditCardBillingAddress2OrderReveiwPage;

    //Subtotal price
    @FindBy(xpath = "//*[@class='price-amount']")
    public WebElement subTotalSystemGenerated;

    //Shipping address1
    @FindBy(xpath = "//*[@class='address-panel']/div[1]")
    public WebElement shippingAddress1OrderReview;

    //Shipping address2
    @FindBy(xpath = "//*[@class='address-panel']/div[3]")
    public WebElement shippingAddress2OrderReview;

    //Delivery Method display
    @FindBy(xpath = "//*[@class='address-panel']/div[6]/span")
    public WebElement shipDeliveryMethodOrderReview;

    //Confirm Age Restriction Item header **
    @FindBy(xpath = "//div[text()='Confirm Age Restricted Items']")
    public WebElement confirmAgeRestrictionTextOnPopUpPlaceOrder;

    //Confirm Age Restriction Description text
    @FindBy(xpath = "//*[@id='modalContent']/div[1]/span[1]")
    public WebElement confirmAgeRestrictionDescriptionPopupPlaceOrder;


    /*-----------------------------Age Confirmation pop-up screen------------------------*/

    //Confirm button
    @FindBy(xpath = "//*[@id = 'modalBtn']")
    public WebElement confirmButtonAgeRestrictionPopupPlaceOrder;

    //Curbside Pickup Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[1]/td/table/tbody/tr[2]/td[2]")
    public WebElement cncSubTotal;

    //curbside Est Taxes Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[1]/td/table/tbody/tr[3]/td[2]")
    public WebElement cncEstTax;


    /*========================Calculation of Price=================================*/
    //Deposit Fee
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[1]/td/table/tbody/tr[5]/td[2]")
    public WebElement cncDepositFee;

    //Estimated Subtotal Curbside Pickup
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[1]/td/table/tbody/tr[6]/td[2]")
    public WebElement cncEstSubtoal;

    //SPO Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
    public WebElement spoSubTotal;

    //SPO Estimated Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
    public WebElement spoEstSubtotal;

    //STH Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[3]/td/table/tbody/tr[2]/td[2]")
    public WebElement sthSubTotal;

    //STH Subtotal
    @FindBy(xpath = "//*[@class='price-table subAmounts']/tbody/tr[3]/td/table/tbody/tr[5]/td[2]")
    public WebElement sthEstSubTotal;
    utilityhelper UtilityHelper;

    /*-------------------------------------------------------------------------------------------------*/
    /*-------------------------------- Order Review Page Action ---------------------------------------*/
    /*-------------------------------------------------------------------------------------------------*/

    public void clickEditPickupLink() {
        getDriver().findElement(By.xpath("//*[@id='editPickup']")).click();
    }

    //Review Page Heading text validation
    public void orderReviewPageDisplay() {
        UtilityHelper.waitUntilElementVisible(ORDER_REVIEW_TITLE);
        Assert.assertEquals("Order Review", UtilityHelper.elementGetText(ORDER_REVIEW_TITLE));
    }

    //Method to calculate and validate mask credit card display
    public void enteredCardDetailsvalidationReviewPage(String ccname, String ccnumber) {
        Assert.assertEquals(ccname.toUpperCase(), nameOnCreditCardFieldReview.getText().toUpperCase());
        String cType = null;
        if (ccnumber.startsWith("4")) {
            cType = "Visa";
            System.out.println("=== Card Type is: " + cType);
        } else if (ccnumber.startsWith("5")) {
            cType = "MasterCard";
            System.out.println("=== Card Type is: " + cType);
        } else if (ccnumber.startsWith("6")) {
            cType = "Discover";
            System.out.println("=== Card Type is: " + cType);
        } else if (ccnumber.startsWith("3")) {
            cType = "American Express";
            System.out.println("=== Card Type is: " + cType);
        } else {
            cType = "Unknown type";
            System.out.println("Card Type is =======>>>>" + cType);
        }
        String maskcc = ccnumber.replaceAll("\\w(?=\\w{4})", "*");
        System.out.println("=== Mask credit card number:  " + maskcc);
        String displaycc = cType + maskcc;
        Assert.assertEquals(displaycc, creditCardDisplayReview.getText());
    }

    public void clickOnPlaceOrder() {
        UtilityHelper.waitUntilClickable(PLACE_ORDER_BUTTON);
        UtilityHelper.click(PLACE_ORDER_BUTTON);
    }

    public void ageRestrictionPopupPlaceOrderWhilePlacingOrder() {
        Assert.assertTrue(confirmAgeRestrictionTextOnPopUpPlaceOrder.getText().contains("Confirm Age Restricted Items"));
        Assert.assertEquals(Constants.confirmAgeRestrictionDescriptionPopupPlaceOrder, confirmAgeRestrictionDescriptionPopupPlaceOrder.getText());
    }

	
/*==============================================SubTotal Calculation ================================================*/

    public void clickConfirmOnAgeRestrictionPopUp() throws InterruptedException {
        confirmButtonAgeRestrictionPopupPlaceOrder.click();
        Thread.sleep(3000);
    }

    public void billingInformationOnCreditCard(String address1, String ccaddress2) {
        Assert.assertEquals(address1.toUpperCase(), creditCardBillingAddress1OrderReveiwPage.getText().toUpperCase());
        Assert.assertEquals(ccaddress2.toUpperCase(), creditCardBillingAddress2OrderReveiwPage.getText().toUpperCase());
    }

    //
    public void shippingAddressValidation(String address1, String address2) {
        Assert.assertTrue("", shippingAddress1OrderReview.getText().contains(address1.toUpperCase()));
        Assert.assertEquals("", address2.toUpperCase(), shippingAddress2OrderReview.getText().toUpperCase());
    }

    public void shippingDeliveryMethodValidation(String deliverymethod) {
        Assert.assertEquals(deliverymethod.toUpperCase(), shipDeliveryMethodOrderReview.getText().toUpperCase());
    }

/*==============================================Sub-Total Calculation end================================================*/


    //TODO: Could not Successfully clear 'PriceListInt' array. Re look at later. 12/29/16
    //To calculate Sub total price in Shopping Cart
    public String calSubTotalValueCommonLogic() {
        //get count of CNC item price listed
        List<WebElement> listCountCNC = null, listCountSPO = null, listCountSTH = null;
        listCountCNC = getDriver().findElements(By.xpath("//*[@id='productGroup_1']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count CNC Items: " + listCountCNC.size());
        //get count of SPO  item price listed
        listCountSPO = getDriver().findElements(By.xpath("//*[@id='productGroup_2']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count SPO Items: " + listCountSPO.size());
        //get count of STH item price listed
        listCountSTH = getDriver().findElements(By.xpath("//*[@id='productGroup_8']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count STH Items: " + listCountSTH.size());

        //to add PRICE of CNC items into Array
        try {
            for (int k = 1; k <= listCountCNC.size(); k++) {
                String itemPriceCNC = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                System.out.println("=== Price List is: " + itemPriceCNC);
                PriceList1.add(itemPriceCNC.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== No CNC item(s)");
        }
        // to add QTY of CNC items into Array
        try {
            for (int j = 1; j <= listCountCNC.size(); j++) {
                String qtyCNC = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + j + "]//*[@class='reviewQty']/span")).getText();
                System.out.println("=== Qty is: " + qtyCNC);
                QtyList1.add(qtyCNC);
            }
        } catch (Exception e) {
            System.out.println("=== No CNC Price");
        }

        //to add PRICE of SPO item into Array
        try {
            for (int k = 1; k <= listCountSPO.size(); k++) {
                String itemPriceSPO = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                System.out.println("=== Price List is: " + itemPriceSPO);
                PriceList1.add(itemPriceSPO.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== No SPO item(s)");
        }
        // to add QTY of SPO items into Array
        try {
            for (int j = 1; j <= listCountSPO.size(); j++) {
                String qtySPO = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + j + "]//*[@class='reviewQty']/span")).getText();
                System.out.println("=== Qty is: " + qtySPO);
                QtyList1.add(qtySPO);
            }
        } catch (Exception e) {
            System.out.println("=== No SPO Price");
        }

        //to add PRICE of STH item into Array
        try {
            for (int k = 1; k <= listCountSTH.size(); k++) {
                String itemPriceSTH = getDriver().findElement(By.xpath("//*[@id='productGroup_8']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                System.out.println("=== Price List is: " + itemPriceSTH);
                PriceList1.add(itemPriceSTH.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== No STH item(s)");
        }
        // to add QTY of STH items into Array
        try {
            for (int j = 1; j <= listCountSTH.size(); j++) {
                String qtySTH = getDriver().findElement(By.xpath("//*[@id='productGroup_8']/li[" + j + "]//*[@class='reviewQty']/span")).getText();
                System.out.println("=== Qty is: " + qtySTH);
                QtyList1.add(qtySTH);
            }
        } catch (Exception e) {
            System.out.println("=== No STH Price");
        }
        //convert string array to float array for Price
        List<Float> PriceListInt = null;
        PriceListInt = new ArrayList<>(PriceList1.size());

        for (String myPriceInt : PriceList1) {
            PriceListInt.add(Float.valueOf(myPriceInt));
        }
        System.out.println("=== value of PriceList array " + PriceListInt);

        //convert string array to float array for qty
        List<Float> QtyListInt = null;
        QtyListInt = new ArrayList<>(QtyList1.size());

        for (String myQtyInt : QtyList1) {
            QtyListInt.add(Float.valueOf(myQtyInt));
        }
        System.out.println("=== value of QtyListInt array " + QtyListInt);
        String formattedSubtotal;
        float eachItemPrice = 0, subtotal = 0;
        for (int z = 0; z < PriceListInt.size(); z++) {
            eachItemPrice = (PriceListInt.get(z)) * QtyListInt.get(z);
            System.out.println("=== each item Price in forLoop: " + eachItemPrice);
            subtotal += eachItemPrice;
        }
        System.out.println("=== Subtotal Price in forLoop: " + subtotal);
        DecimalFormat df = new DecimalFormat("#.00");
        formattedSubtotal = df.format(subtotal);

        System.out.println("=== Return subtotal value is: " + formattedSubtotal);
        PriceListInt.clear();
        QtyListInt.clear();

        return formattedSubtotal;
    }

    //To validate shopping cart price is displayed correct
    public void compareCalSubtotalPriceVsSystemDisplay() {
        String systemsubtotal = subTotalSystemGenerated.getText();
        Assert.assertEquals(calSubTotalValueCommonLogic(), systemsubtotal.replaceAll("[^0-9.]", ""));
        System.out.println("=== Subtotal Calculation Success");
    }

    public void emptyArrayList_VerifyCalculationArrayList() {
        PriceList1.clear();
        QtyList1.clear();
        System.out.println("    Clear Order Review PriceList1 Array: " + PriceList1);
        System.out.println("    Clear Order Review QtyList1 Array: " + QtyList1);
    }

    //item names validation
    public void productname_validation() {
        UtilityHelper.compareListString();
    }

    //To compare Item in Shopping Cart
    public void selecteditemvalidation_OrderReview() {
        List<WebElement> iteminshoppingcart = getDriver().findElements(By.xpath("//*[@class='mjr-product-name']"));
        for (WebElement scitem : iteminshoppingcart) {
            listoforderReviewitem.add(scitem.getText().replaceAll("\\s*\\bSALE\\b\\s*", ""));
        }
    }

    public List<String> getStringList() {
        return listoforderReviewitem;
    }

    //Calculate Promotional Discount for Bulk Gift Card
    private String promotional01PercentDiscountBulkGiftCardCalculation() {
        UtilityHelper.moveToViewElement(subTotalSystemGenerated);
        float subtotal = Float.valueOf(subTotalSystemGenerated.getText().replaceAll("[^0-9.]", ""));
        System.out.println("=== Subtotal: " + subtotal);
        float discPerc = 0;
        float discountprice = 0;
        String formattedDisPrice;
        if (subtotal < 3000) {
            System.out.println("=== Not eligible for bulk discount");
        } else {
            if (subtotal >= 3000 && subtotal <= 4000) {
                discPerc = 1;
            } else if (subtotal >= 4000 && subtotal <= 5000) {
                discPerc = 2;
            } else if (subtotal >= 5000) {
                discPerc = 3;
            }
            discountprice = subtotal * discPerc / 100;
            System.out.println("=== Bulk Discount value is: " + discountprice);
        }

        DecimalFormat df = new DecimalFormat("#.00");
        formattedDisPrice = df.format(discountprice);
        return formattedDisPrice;
    }

    //Discount Price validation
    public void validate_buldorderdiscount() {
        UtilityHelper.moveToViewElement(savingPriceValueOrderReview);
        Assert.assertEquals(promotional01PercentDiscountBulkGiftCardCalculation(), savingPriceValueOrderReview.getText().replaceAll("[^0-9.]", ""));
    }


	/*==============================================Validation Price=============================================*/

    //Overall Total Calculation - bulk order
    public String overallBulkOrderTOTALPriceValueCalculation() {
        String valsubtotal = subTotalSystemGenerated.getText();
        float subtotal = Float.valueOf(valsubtotal.replaceAll("[^0-9.]", ""));
        System.out.println("=== Subtotal:  " + subtotal);

        String valtaxes = taxesPriceValueOrderReview.getText();
        float taxes = Float.valueOf(valtaxes.replaceAll("[^0-9.]", ""));
        System.out.println("=== Taxes:  " + taxes);

        String valship = shippingPriceValueOrderReview.getText();
        float shipping = Float.valueOf(valship.replaceAll("[^0-9.]", ""));
        System.out.println("=== Shipping Charge:  " + shipping);

        float promodisc = Float.valueOf(promotional01PercentDiscountBulkGiftCardCalculation());

        float overallTotal = subtotal + taxes + shipping - promodisc;

        System.out.println("=== Overall Total Price Value return is: " + overallTotal);

        DecimalFormat df = new DecimalFormat("#.00");
        String totalestmprice = df.format(overallTotal);
        return totalestmprice;
    }

    //overall Total value display validation
    public void validate_BulkOrderOverallTOTALpriceDisplay() {
        Assert.assertEquals(overallBulkOrderTOTALPriceValueCalculation(), overallTOTALpriceOrderReview.getText().replaceAll("[^0-9.]", ""));
    }

	/*==========================================Total Calculation Generic============================================*/

    public void totalvalDisplayCNCSPOSTHItemsInCart_validation() {

        try {
            String cncsubtotal = cncSubTotal.getText().replaceAll("[^0-9.]", "");
            subtotalPrice.add(cncsubtotal);
            float fltcncsubtotal = Float.valueOf(cncsubtotal.replaceAll("[^0-9.]", ""));

            System.out.println("=== Subtotal:  " + fltcncsubtotal);

            float cnctax = 0;
            float cncdepofee = 0;
            float estCNCSubtotal = 0;

            if (!cncEstTax.getText().equals("$0.00")) {
                cnctax = 6 * fltcncsubtotal / 100;
                DecimalFormat df = new DecimalFormat("#.00");
                String fmtCNCtax = df.format(cnctax);
                subtotalPrice.add(fmtCNCtax);
                System.out.println("=== cnctax value is:  " + fmtCNCtax);
                Assert.assertEquals(fmtCNCtax, cncEstTax.getText().replaceAll("[^0-9.]", ""));
            }

            try {
                String cncdepositefee = cncDepositFee.getText().replaceAll("[^0-9.]", "");
                System.out.println("=== deposit fee to add in array start");
                subtotalPrice.add(cncdepositefee);
                cncdepofee = Float.valueOf(cncdepositefee);
                System.out.println("=== deposit fee to add in array End");
                System.out.println("=== deposite fee is: " + cncdepositefee);
            } catch (Exception e) {
                System.out.println("=== No Deposite item present in the Order");
            }

            String cursidefee = Constants.curbsidefee;
            subtotalPrice.add(cursidefee);
            System.out.println("=== curbside fee value is: " + cursidefee);
            float fltcurbsidefee = Float.valueOf(cursidefee);
            estCNCSubtotal = fltcncsubtotal + cnctax + fltcurbsidefee + cncdepofee;
            DecimalFormat df = new DecimalFormat("#.00");
            String fmtEstCNCSubtotal = df.format(estCNCSubtotal);
            System.out.println("=== Total value of CNC items is: " + fmtEstCNCSubtotal);
            Assert.assertEquals(fmtEstCNCSubtotal, cncEstSubtoal.getText().replaceAll("[^0-9.]", ""));
            System.out.println("=== CNC Total Calculation is Correct");

        } catch (Exception e) {
            System.out.println("=== No CNC item present in the Order");
        }


        try {
            String sposubtotal = spoSubTotal.getText().replaceAll("[^0-9.]", "");
            subtotalPrice.add(sposubtotal);
            System.out.println("=== Sustotal value of SPO items is: " + sposubtotal);
            float fltsposubtotal = Float.valueOf(sposubtotal.replaceAll("[^0-9.]", ""));
            System.out.println("=== Subtotal: " + fltsposubtotal);
            float estSPOSubtotal = 0;
            String spotaxesval = Constants.spoitemtaxes;
            subtotalPrice.add(spotaxesval);
            float spotaxval = Float.valueOf(spotaxesval);
            estSPOSubtotal = fltsposubtotal + spotaxval;
            DecimalFormat df = new DecimalFormat("#.00");
            String fmtEstSPOSubtotal = df.format(estSPOSubtotal);
            System.out.println("=== Total value of SPO items is: " + fmtEstSPOSubtotal);
            Assert.assertEquals(fmtEstSPOSubtotal, spoEstSubtotal.getText().replaceAll("[^0-9.]", ""));
            System.out.println("=== SPO Total Calculation is Correct");
        } catch (Exception e) {
            System.out.println("=== No SPO item present in the Order");
        }

        try {
            String sthsubtotal = sthSubTotal.getText().replaceAll("[^0-9.]", "");
            subtotalPrice.add(sthsubtotal);
            System.out.println("=== Sustotal value of STH items is: " + sthsubtotal);
            float fltsthsubtotal = Float.valueOf(sthsubtotal);
            System.out.println("=== Subtotal: " + fltsthsubtotal);
            float estSTHSubtotal = 0;
            float shippingfee = 0;
            if (shipDeliveryMethodOrderReview.getText() == "Standard Shipping") {
                shippingfee = Float.valueOf(Constants.standardshippingfee);
                System.out.println("=== shippingfee value is: " + shippingfee);
            } else if (shipDeliveryMethodOrderReview.getText() == "Expedited Shipping") {
                shippingfee = Float.valueOf(Constants.expeditedshippingfee);
                System.out.println("=== shippingfee value is: " + shippingfee);
            } else if (shipDeliveryMethodOrderReview.getText() == "Express Shipping") {
                shippingfee = Float.valueOf(Constants.expressshippingfee);
                System.out.println("=== shippingfee value is: " + shippingfee);
            }
            String strshipfee = String.valueOf(shippingfee);
            subtotalPrice.add(strshipfee);
            float fltshippingfee = Float.valueOf(strshipfee);
            float sthtaxval = Float.valueOf(Constants.shiptohometaxes);
            estSTHSubtotal = fltsthsubtotal + fltshippingfee + sthtaxval;
            DecimalFormat df = new DecimalFormat("#.00");
            String fmtEstSTHSubtotal = df.format(estSTHSubtotal);
            System.out.println("=== Total STH cal value is: " + fmtEstSTHSubtotal);
            Assert.assertEquals(fmtEstSTHSubtotal, sthEstSubTotal.getText().replaceAll("[^0-9.]", ""));
            System.out.println("=== STH Total Calculation is Correct");
        } catch (Exception e) {
            System.out.println("=== No STH item present in the Order");
        }

        List<Float> subtotalPriceFloat = new ArrayList<Float>(subtotalPrice.size());

        for (String mypricelist : subtotalPrice) {
            subtotalPriceFloat.add(Float.valueOf(mypricelist));
        }
        System.out.println("value of subtotalPrice array" + subtotalPriceFloat);

        float overallpricesum = 0;
        for (int i = 0; i < subtotalPriceFloat.size(); i++) {
            overallpricesum += subtotalPriceFloat.get(i);
            System.out.println("=== Calculated overall total price is:" + overallpricesum);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String fmtEstSTHSubtotal = df.format(overallpricesum);
        Assert.assertEquals(fmtEstSTHSubtotal, overallTOTALpriceOrderReview.getText().replaceAll("[^0-9.]", ""));
        System.out.println("=== Overall TOTAL value Calculation is  Correct!!!!!");

    }

    public void calculatedTotalValue_common() {
        List<WebElement> listcountitemtype = getDriver().findElements(By.xpath("//*[@class='price-table subAmounts']/tbody/tr"));
        System.out.println("=== Different type of item listed: " + listcountitemtype.size());

        for (int i = 1; i <= listcountitemtype.size(); i++) {
            List<WebElement> listofitemSec = getDriver().findElements(By.xpath("//*[@class='price-table subAmounts']/tbody/tr[" + i + "]/td/table/tbody/tr"));
            for (int j = 2; j < listofitemSec.size(); j++) {
                String pricevalue = getDriver().findElement(By.xpath("//*[@class='price-table subAmounts']/tbody/tr[" + i + "]/td/table/tbody/tr[" + j + "]/td[2]")).getText();
                System.out.println("=== Price List is: " + pricevalue);
                pricevaluelist.add(pricevalue.replaceAll("[^0-9.]", ""));
            }
        }

        List<Float> pricevaluelistfloat = new ArrayList<Float>(pricevaluelist.size());

        for (String mypricelist : pricevaluelist) {
            pricevaluelistfloat.add(Float.valueOf(mypricelist));
        }
        System.out.println("=== value of subtotalPrice array: " + pricevaluelistfloat);

        float overallpricesum = 0;
        for (int i = 0; i < pricevaluelistfloat.size(); i++) {
            overallpricesum += pricevaluelistfloat.get(i);
            System.out.println("=== Calculated overall total price is: " + overallpricesum);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String fmtEstSTHSubtotal = df.format(overallpricesum);
        Assert.assertEquals(fmtEstSTHSubtotal, overallTOTALpriceOrderReview.getText().replaceAll("[^0-9.]", ""));
        System.out.println("=== Overall TOTAL value Calculation is Correct!!!!!");

    }

	/*===================================Total Cal for single item ========================================*/

    public void singleItem_TotalCal() {

        String valsubtotal = subTotalSystemGenerated.getText();
        float subtotal = Float.valueOf(valsubtotal.replaceAll("[^0-9.]", ""));
        System.out.println("=== Subtotal: " + subtotal);

        List<WebElement> listofitemSec = getDriver().findElements(By.xpath("//*[@class='price-table']/tbody/tr[contains (@class, 'taxes-row')]/td/table/tbody/tr"));
        System.out.println("=== Different type of item listed: " + listofitemSec.size());
        float TaxesAmt = 0;
        float SavingAmt = 0;
        float totaltaxamt = 0;
        float totalsavingamt = 0;
        for (int i = 1; i <= listofitemSec.size(); i++) {
            String pricevalue = getDriver().findElement(By.xpath("//*[@class='price-table']/tbody/tr[contains (@class, 'taxes-row')]/td/table/tbody/tr[" + i + "]/td[2]")).getText();
            //System.out.println("Price List is =================>>" + pricevalue);
            TaxesAmt = Float.valueOf(pricevalue.replaceAll("[^0-9.]", ""));
            //System.out.println("Float Tax price is ===========>>> " + TaxesAmt);
            totaltaxamt = totaltaxamt + TaxesAmt;
            System.out.println("=== Total Calculation value: " + totaltaxamt);
        }

        try {
            List<WebElement> listofpromotionSec = getDriver().findElements(By.xpath("//*[@class='price-table']/tbody/tr[contains (@class, 'savings-row bordered')]/td/table/tbody/tr"));
            System.out.println("=== Different type of Promotion Listed: " + listofpromotionSec.size());
            for (int j = 2; j <= listofpromotionSec.size(); j++) {
                String promotionvalue = getDriver().findElement(By.xpath("//*[@class='price-table']/tbody/tr[contains (@class, 'savings-row bordered')]/td/table/tbody/tr[" + j + "]/td[2]")).getText();
                //System.out.println("Price List is =================>>" + promotionvalue);
                SavingAmt = Float.valueOf(promotionvalue.replaceAll("[^0-9.]", ""));
                //System.out.println("Float Tax price is ===========>>> " + SavingAmt);
                totalsavingamt = totalsavingamt + SavingAmt;
                System.out.println("=== Total Saving value is: " + totalsavingamt);
            }
        } catch (Exception e) {
            System.out.println("=== There is no Promotion Discount on price calculation!!!!!");
        }

        float overallpricesum = 0;
        overallpricesum = subtotal + totaltaxamt - totalsavingamt;
        System.out.println("=== overallprice sum is: " + overallpricesum);
        DecimalFormat df = new DecimalFormat("#.00");
        String fmtEstSTHSubtotal = df.format(overallpricesum);
        Assert.assertEquals(fmtEstSTHSubtotal, overallTOTALpriceOrderReview.getText().replaceAll("[^0-9.]", ""));
        System.out.println("=== Overall TOTAL value Calculation is Correct!!!!!");
    }


    //To Clear Array List
    public void emptyArrayList_listoforderhistoryitem() {
        listoforderReviewitem.clear();
        System.out.println("Clear Order History Array List: " + listoforderReviewitem);
    }

    //Click on Edit Cart
    public void click_EditCart_Link() {
        UtilityHelper.waitUntilClickable(editCartLinkReview);
        editCartLinkReview.click();
    }

    public void verifyNoStaticMessageReviewPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mjr-rightSidebar']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message in Review page for STH order===");
    }

    public void verifyStaticMessageReviewPage() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='disclaimerText']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified the static message in review page===");
    }


}
