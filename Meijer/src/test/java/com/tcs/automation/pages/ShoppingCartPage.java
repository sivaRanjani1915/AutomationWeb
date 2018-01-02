package com.tcs.automation.pages;

import com.tcs.automation.Definition_RunnerClass;
import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.utilityhelper;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotEquals;

//import junit.framework.Assert;

public class ShoppingCartPage extends PageObject {

    public static List<String> listOfShoppingCardItem = new ArrayList<String>();

    public static List<String> listOfDeletedItemNameShoppingCart = new ArrayList<String>();

    public static List<String> ListOfMiniCartItems = new ArrayList<String>();
    /*----------------- Shopping Cart - common -------------------*/
    //Shopping Cart Text H1 heading
    @FindBy(xpath = "//h1[text()='Shopping Cart']")
    public WebElement SHOPPING_CART_PAGE_TITLE;
    //Qty field edit 1st item
    @FindBy(xpath = "//*[@id='productGroup_8']/li//*[@class='mjr-input-field mjr-qtyInput form-control quantity']")
    public WebElement qtyeditfieldFirstItem;
    // + button (plus) of 1st item STH
    @FindBy(xpath = "//*[@id='productGroup_8']/li//*[@class='mjr-qtyButton plus noSelect']")
    public WebElement qtyPlusIconBasketSec1ShoppingCart;
    //Grocery Substitutions heading text
    @FindBy(xpath = "//h3[text()='Grocery Substitutions']")
    public WebElement grocerySubstitutionsHeadingShoppingCart;
    /*---------------Grocery Substitution common -----------------------*/
    //Grocery Substitution Dropdown field
    @FindBy(xpath = "//select[@name='substitution']")
    public WebElement grocerySubstitutionDropdownShoppingCart;
    //Grocery Substitution Selected Value
    @FindBy(xpath = "//select[@name='substitution']/option[contains (@selected, 'selected')]")
    public WebElement grocerySubSelectedValue;
    //Comments Heading text
    @FindBy(xpath = "//h3[text()='Comments']")
    public WebElement commentsHeadingTextShoppingCart;
    //Comment text box field
    @FindBy(xpath = "//*[@id='ordernotes']/textarea")
    public WebElement addCommentTextBoxFieldShoppingCart;
    //Items Count display
    @FindBy(xpath = "//*[@id='js-RightRailItemCount']")
    public WebElement ITEM_COUNT_ON_SHOPPING_CART;
    //Estimated SubTotal Price Display
    @FindBy(xpath = "//*[@id='js_orderTotal']/span[2]")
    public WebElement estimatedSubTotalPriceDisplayShoppingCart;
    //Checkout As Guest Button
    @FindBy(xpath = "//input[@value='Checkout As Guest']")
    public WebElement CHECKOUT_AS_GUEST_BUTTON;
    /*---------------------------common end------------------------------*/
    //Log In & Check out Button
    @FindBy(xpath = "//input[@value='Log In & Check Out']")
    public WebElement LOG_IN_AND_CHECKOUT_BUTTON;
    //Checkout Button for SignIn Account
    @FindBy(xpath = "//button[contains(text(), 'Checkout')]")
    public WebElement CHECKOUT_BUTTON;
    //Checkout Button for SignIn Account
    @FindBy(xpath = "//*[@id='mcFooter']/div[2]/div/button")
    public WebElement checkoutButtonMiniCart;
    //To Click + Icon of Gift Card Under STH
    @FindBy(xpath = "//*[@id='productGroup_8']/li//*[@class='mjr-qtyButton plus noSelect']")
    public WebElement plusIcon1stunderGiftCardsectionShoppingCartPage;
    //To click -icon of CNC item
    @FindBy(xpath = "//*[@id='productGroup_1']/li//*[@type='button' and text()='-']")
    public WebElement minusIcon1stunderCNCsectionShoppingCartPage;
    //To click +icon of CNC item
    @FindBy(xpath = "//*[@id='productGroup_1']/li//*[@type='button' and text()='+']")
    public WebElement plusIcon1stunderCNCsectionShoppingCartPage;

    @FindBy(xpath = "//*[contains(@class,'modalInstructions')]")
    public WebElement UnavailableItems_Modal;

    @FindBy(xpath = "//*[contains(@data-action,'close')]")
    public WebElement UnavailableItems_Modal_Close;

    @FindBy(xpath = "//button[contains(@data-action,'removeitems')]")
    public WebElement UnavailableItems_Modal_Button;

    @FindBy(xpath = "//*[contains(@class,'product_remove_head')]")
    public WebElement CLEAR_ALL_ITEMS_LINK;

    @FindBy(xpath = "//*[@class='pm-title']")
    public WebElement CONFIRM_CLEAR_ITEMS_MODAL;

    @FindBy(xpath = "//*[contains(@class,'clearItemsForm')]")
    public WebElement CONFIRM_CLEAR_ITEMS_BUTTON;

    @FindBy(xpath = "//*[@class='mid']")
    public WebElement EMPTY_SHOPPING_CART;

    List<String> PriceList = new ArrayList<>();
    List<String> QtyList = new ArrayList<>();
    utilityhelper UtilityHelper;
    HomePage homePage;
    LaunchPage launchPage;

    //Shopping Cart Look and Feel Validation


    /*================================================================================================================================*/

/*---------------------------------------Shopping Cart Page Actions--------------------------------------------------------------*/

    //JoeG 11-18-*2016
    private static Double grabPriceText(String s_input, String s_label) {
        Pattern dollabillsyall = Pattern.compile("[0-9]{1,4}[.][0-9]{0,4}");
        Matcher matcher = dollabillsyall.matcher(s_input);

        if (matcher.find())
            System.out.println("=== " + s_label + ": " + matcher.group(0));
        else
            System.out.println("=== " + s_label + ": " + "no match");

        return Double.parseDouble(matcher.group(0));
    }

    public void shoppingCartPageDisplay() {
        UtilityHelper.waitUntilElementVisible(SHOPPING_CART_PAGE_TITLE);
        Assert.assertEquals("Shopping Cart", UtilityHelper.elementGetText(SHOPPING_CART_PAGE_TITLE));
    }

    public void fromShoppingCartPageGetUserCartId() {
        UtilityHelper.waitUntilElementVisible(SHOPPING_CART_PAGE_TITLE);
        launchPage.openAt(Definition_RunnerClass.Environment + "/checkout/test/getCartId.jsp");
        UtilityHelper.elementGetText(getDriver().findElement(org.openqa.selenium.By.xpath("//h1[contains(text(), 'cartId')]")));
    }

    public void navigateBackFromGetCartIdWindow() {
        getDriver().navigate().back();
    }

    //method to increase the item qty to give sub total of > $3000
    private String bulkorderqtycalculation() {
        String strSubtotal = estimatedSubTotalPriceDisplayShoppingCart.getText();
        float intSubtotal = Float.parseFloat(strSubtotal.replaceAll("[^0-9.]", ""));
        DecimalFormat df = new DecimalFormat("#");
        String forSubtotal = df.format(intSubtotal);
        int forIntSubtotal = Integer.parseInt(forSubtotal);
        System.out.println("=== Subtotal after trimming: " + forIntSubtotal);
        int reqqty = 0;
        reqqty = (3000 / forIntSubtotal);
        System.out.println("=== Qty Require is: " + reqqty);
        String qtystr = String.valueOf(reqqty);
        return qtystr;
    }

    //method increase qty of item
    public void editQTYtoreach3000subtotal() throws InterruptedException {
        qtyeditfieldFirstItem.clear();
        qtyeditfieldFirstItem.sendKeys(bulkorderqtycalculation());
        Thread.sleep(1000);
        qtyPlusIconBasketSec1ShoppingCart.click();
        Thread.sleep(5000);
    }


    //JoeG 12-20-16
    //updated to match new UOM behavior where random weight items get counted as eaches
    private int countProductsInCart_UPDATED() {
        System.out.println("-=====================Shopping Cart List========================================-");
        int count, value;
        count = 0;
        List<WebElement> cakes = getDriver().findElements(By.xpath("//*[text()='Edit Your Cake']"));
        List<WebElement> sthAndCnC = getDriver().findElements(By.xpath("//*[starts-with(@id, 'basketBody_') and @type='number']"));
        System.out.println(" === adding " + cakes.size() + " cakes to count");
        count += cakes.size();
        for (WebElement product : sthAndCnC) {
            if ((!product.getAttribute("value").equals("")) && (product.getAttribute("value") != null)) {
                String checkForLB = product.getAttribute("data-qtyincrement");
                if (checkForLB.contains("0.")) { //To validate for LB(s) items
                    value = 1;
                } else {
                    value = Integer.valueOf(product.getAttribute("value"));
                }
                System.out.println("=== adding " + value + " cnc or sth item to cart");
                count += value;
            } else {
                System.out.println("=== error adding product quantity");
            }
        }
        System.out.println(" === Count was: " + count);
        System.out.println("-=====================Shopping Cart List========================================-");
        return count;
    }

    public void validate_ShoppingCartItemCount() {
        Assert.assertEquals(Integer.toString(countProductsInCart_UPDATED()), UtilityHelper.elementGetText(ITEM_COUNT_ON_SHOPPING_CART));
    }

    //
    public void ProductName_ComparisionShoppingCart() {
        UtilityHelper.compareListString();
    }

    public void compareGuestCartToSignedInCart() {
        UtilityHelper.compareGuestCartToSignedInCart();
    }


    public void moveToViewCheckOutAsGuestButton() {
        UtilityHelper.moveToViewElement(CHECKOUT_AS_GUEST_BUTTON);
        UtilityHelper.waitUntilClickable(CHECKOUT_AS_GUEST_BUTTON);
    }

    public void clickCheckoutAsGuestButton() {
        UtilityHelper.click(CHECKOUT_AS_GUEST_BUTTON);
    }

    public void grocerySubstitutionTextDisplay() {
        Assert.assertEquals("=== Grocery Substitutions", "Grocery Substitutions", grocerySubstitutionsHeadingShoppingCart.getText());
    }

    public void shoppingCartSubstitutionComment(String comment) {
        Assert.assertEquals("=== Comments", "Comments", commentsHeadingTextShoppingCart.getText());
        addCommentTextBoxFieldShoppingCart.clear();
        addCommentTextBoxFieldShoppingCart.sendKeys(comment);
    }

    public void validate1024charactersOrFewer() {
        Assert.assertTrue("=== assert comments section contains 1024 characters or fewer: ", addCommentTextBoxFieldShoppingCart.getText().length() <= 1024);
    }

    public void enter_Max1024characterComment() {
        addCommentTextBoxFieldShoppingCart.clear();
        addCommentTextBoxFieldShoppingCart.sendKeys(Constants.max1024characterofcommentsection);
    }

    public void enter_Max1024characterCommentWithoutClearingFirst() {
        addCommentTextBoxFieldShoppingCart.sendKeys(Constants.max1024characterofcommentsection);
    }

    public void verifyCheckoutAsGuestIsDisplayed() {
        UtilityHelper.moveToViewElement(getDriver().findElement(By.xpath("//*[@name='guest-checkout' and contains(@value,'Guest')]")));
        Assert.assertTrue("Checkout as Guest button is present: ", UtilityHelper.isDisplayed(By.xpath("//*[@name='guest-checkout' and contains(@value,'Guest')]")));
    }

    public void verifyCheckoutAsGuestIsNotDisplayed() {
        Assert.assertTrue("Checkout as Guest button is NOT present: ", UtilityHelper.elementNotExists(By.xpath("//*[@name='guest-checkout' and contains(@value,'Guest')]")));
    }

    public void verifyLoginAndCheckoutButtonIsDisplayed() {
        UtilityHelper.moveToViewElement(getDriver().findElement(By.xpath("//*[contains(@name,'checkout') and contains(@value,'Log')]")));
        Assert.assertTrue("Login and Checkout is present: ", UtilityHelper.isDisplayed(By.xpath("//*[contains(@name,'checkout') and contains(@value,'Log')]")));
    }

    public void verifyLoginAndCheckoutButtonIsNotDisplayed() {
        Assert.assertTrue("Login and Checkout is NOT present: ", UtilityHelper.elementNotExists(By.xpath("//*[contains(@name,'checkout') and contains(@value,'Log')]")));
    }

    public void verifyCheckoutButtonIsDisplayed() {
        UtilityHelper.moveToViewElement(getDriver().findElement(By.xpath("//*[@name='guest-checkout' and contains(text(),'Checkout')]")));
        Assert.assertTrue("Checkout is present: ", UtilityHelper.isDisplayed(By.xpath("//*[@name='guest-checkout' and contains(text(),'Checkout')]")));
    }

    public void verifyCheckoutButtonIsNotDisplayed() {
        Assert.assertTrue("Checkout is NOT present: ", UtilityHelper.elementNotExists(By.xpath("//*[@name='guest-checkout' and contains(text(),'Checkout')]")));
    }

    public void miniCartCheckout() {
        UtilityHelper.waitUntilClickable(checkoutButtonMiniCart);
        checkoutButtonMiniCart.click();
    }

    public void moveToViewCheckOutButton() {
        UtilityHelper.waitUntilClickable(CHECKOUT_BUTTON);
        UtilityHelper.moveToViewElement(CHECKOUT_BUTTON);
    }

    public void clickCheckOutButton() {
        UtilityHelper.click(CHECKOUT_BUTTON);
    }

    public void plusIconClick$5GiftCard16thItemShoppingCart() throws InterruptedException {
        UtilityHelper.waitUntilClickable(plusIcon1stunderGiftCardsectionShoppingCartPage);
        UtilityHelper.moveToViewElement(plusIcon1stunderGiftCardsectionShoppingCartPage);
        plusIcon1stunderGiftCardsectionShoppingCartPage.click();
        Thread.sleep(4000);
    }

    /*==============================================Sub total Calculation ================================================*/
    //JoeG 11-18-*2016
    public Double shoppingCart_getSubtotal() {
        Double total, subtotal;
        int int_quantity;
        subtotal = 0.0;
        List<WebElement> rows = getDriver().findElements(By.xpath("//*[contains(@id, '00_row')]"));
        for (WebElement row : rows) {
            WebElement w_input = row.findElement(By.xpath(".//input[contains(@class,'mjr-qtyInput')]"));
            WebElement w_price = row.findElement(By.xpath(".//*[@class='prodDtlSalePriceDollars']"));
            String s_quantity = w_input.getAttribute("value");

            String checkForLB = w_input.getAttribute("data-qtyincrement");
            System.out.println("checkForLB [" + checkForLB + "]");
            if (checkForLB.contains("0.")) { //To validate for LB(s) items
                int_quantity = 1;
            } else {
                int_quantity = Integer.parseInt(s_quantity);
            }
            System.out.println("-------------------------------------------");
            Double dbl_price = grabPriceText(w_price.getText(), "price");
            System.out.println("=== quantity: " + s_quantity);
            System.out.println("=== altuom: " + w_input.getAttribute("selectedbyaltuom") + "\n");

            if (w_input.getAttribute("selectedbyaltuom").equals("true")) {
                WebElement w_altPrice = row.findElement(By.xpath(".//*[contains (@class, 'mjr-price-desc')]"));
                Double dbl_ppLb = grabPriceText(w_altPrice.getText(), "price per lb");
                Double dbl_avgWeight = grabPriceText(w_input.getAttribute("selectedaltweighteach"), "avg weight");
                total = dbl_avgWeight * dbl_ppLb * int_quantity;
            } else {
                total = int_quantity * dbl_price;
            }
            subtotal += total;
        }
        subtotal = Double.parseDouble(new DecimalFormat("##.##").format(subtotal));
        System.out.println("=== subtotal: " + subtotal);
        return subtotal;
    }

    //To calculate Sub total price in Shopping Cart
    public String callSubTotalValueCommonLogicShoppingCart() {

        //get count of CNC item price listed
        List<WebElement> listcountCNC = getDriver().findElements(By.xpath("//*[@id='productGroup_1']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count CNC Items : " + listcountCNC.size());

        //get count of SPO  item price listed
        List<WebElement> listcountSPO = getDriver().findElements(By.xpath("//*[@id='productGroup_2']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count SPO Items: " + listcountSPO.size());

        //get count of CNC item price listed
        List<WebElement> listcountSTH = getDriver().findElements(By.xpath("//*[@id='productGroup_8']//*[@class='prodDtlSalePriceDollars']"));
        System.out.println("=== Price list count STH Items: " + listcountSTH.size());

        //to add price of items
        try {
            for (int k = 1; k <= listcountCNC.size(); k++) {
                String itempriceCNC = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                System.out.println("=== Price List of CNC is: " + itempriceCNC);
                PriceList.add(itempriceCNC.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain CNC item");
        }


        try {
            for (int k = 1; k <= listcountSPO.size(); k++) {
                String itempriceSPO = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                //PriceList.add(itemprice.replaceAll("\\$+\\s+\\/(ea|bag)", ""));
                System.out.println("=== Price List of SPO is: " + itempriceSPO);
                PriceList.add(itempriceSPO.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain SPO item");
        }

        try {
            for (int k = 1; k <= listcountSTH.size(); k++) {
                String itempriceSTH = getDriver().findElement(By.xpath("//*[@id='productGroup_8']/li[" + k + "]//*[@class='prodDtlSalePriceDollars']")).getText();
                //PriceList.add(itemprice.replaceAll("\\$+\\s+\\/(ea|bag)", ""));
                System.out.println("=== Price List of STH is: " + itempriceSTH);
                PriceList.add(itempriceSTH.replaceAll("[^0-9.]", ""));
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain STH item");
        }

        //Qty for CNC
        try {
            for (int j = 1; j <= listcountCNC.size(); j++) {
                String qtyCNC = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + j + "]//*[@class='mjr-input-field mjr-qtyInput form-control quantity']")).getAttribute("value");
                System.out.println("=== Qty of CNC item(s) is: " + qtyCNC);
                QtyList.add(qtyCNC);
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain CNC item");
        }

        //QTY for SPO
        try {
            for (int j = 1; j <= listcountSPO.size(); j++) {
                String qtySPO = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + j + "]//*[@class='mjr-input-field mjr-qtyInput form-control quantity']")).getAttribute("value");
                System.out.println("=== Qty od SPO item(s) is: " + qtySPO);
                QtyList.add(qtySPO);
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain SPO item editable");
        }

        //Qty for STH
        try {
            for (int j = 1; j <= listcountSTH.size(); j++) {
                String qtySTH = getDriver().findElement(By.xpath("//*[@id='productGroup_8']/li[" + j + "]//*[@class='mjr-input-field mjr-qtyInput form-control quantity']")).getAttribute("value");
                System.out.println("=== Qty is:  " + qtySTH);
                QtyList.add(qtySTH);
            }
        } catch (Exception e) {
            System.out.println("=== Item doesn't contain STH item");
        }


        //convert string array to float array for Price
        List<Float> PriceListflt = new ArrayList<Float>(PriceList.size());

        for (String mypriceInt : PriceList) {
            PriceListflt.add(Float.valueOf(mypriceInt));
        }
        System.out.println("=== value of pricelist array " + PriceListflt);

        //convert string array to float array for Qty
        List<Float> QtyListflt = new ArrayList<Float>(QtyList.size());

        for (String myqtyInt : QtyList) {
            QtyListflt.add(Float.valueOf(myqtyInt));
        }
        System.out.println("=== value of pricelist array " + QtyListflt);

        String formattedSubtotal;
        float finalitemPrice = 0;
        float subtotal = 0;
        {
            for (int z = 0; z < PriceListflt.size(); z++) {
                finalitemPrice = PriceListflt.get(z) * QtyListflt.get(z);
                System.out.println("=== finalitemPrice in for loop: " + finalitemPrice);
                subtotal = subtotal + finalitemPrice;
                System.out.println("=== Subtotal Price in forloop: " + subtotal);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            formattedSubtotal = df.format(subtotal);
            System.out.println("=== Return subtotal value is: " + formattedSubtotal);
        }
        return formattedSubtotal;

    }


	/*==============================================Subtotal Calculation end================================================*/

    //To validate shopping cart price is displayed correct
    public void compareCalSubtotalPriceVsSystemDisplay() {

        String systemsubtotal = estimatedSubTotalPriceDisplayShoppingCart.getText();
        Assert.assertEquals(callSubTotalValueCommonLogicShoppingCart(), systemsubtotal.replaceAll("[^0-9.]", ""));
        //Assert.assertEquals("$"+callSubTotalValueCommonLogicShoppingCart(), estimatedSubTotalPriceDisplayShoppingCart.getText());
        System.out.println("=== Subtotal Calculation: Success");
    }

    //
    public void selectShoppingCartSubstitutionoption(String shopcartsub) {
        Select dropdown = new Select(grocerySubstitutionDropdownShoppingCart);
        dropdown.selectByVisibleText(shopcartsub);
    }

    //8th TC Price and Item Count Display Validation
    public void shoppingCartTC008PriceDisplayValidation(String totalitemQty) {
        Assert.assertEquals(totalitemQty, ITEM_COUNT_ON_SHOPPING_CART.getText());
    }

    public void valdiate_shoppingCartItemCount(String itemcount) {
        Assert.assertEquals(itemcount, ITEM_COUNT_ON_SHOPPING_CART.getText());
    }

    public void reMoveAnyUnavailableItems(WebElement element) {
        try {
            UtilityHelper.moveToViewElement(element);
            UtilityHelper.waitUntilClickable(element);
            String getName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='mjr-product-name']")));
            System.out.println("Name to remove: [" + getName + "]");
            WebElement removeLink = element.findElement(By.xpath(".//a[contains(@class,'remove-item')]"));
            UtilityHelper.click(removeLink);
            homePage.removeNameFromNamesOfItemListArrayList(getName);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //To get Item names from Shopping Cart
    public void setArrayListOfItemsInShoppingCart(WebElement element) {
        UtilityHelper.moveToViewElement(element);
        String name = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='mjr-product-name']")));
        addNameToShoppingCartPgeArrayList(name);
    }

    public List<String> getListOfShoppingCartItem() {
        Collections.sort(listOfShoppingCardItem);
        return listOfShoppingCardItem;
    }

    private void addNameToShoppingCartPgeArrayList(String productName) {
        // shopping cart and mini cart replaces special
        // character symbols with question marks (?) in DEV and UAT
        productName = productName.replace("?", "");
        productName = productName.replace("®", "");
        productName = productName.replace("™", "");
        listOfShoppingCardItem.add(productName);
    }

    public List<String> getMiniCartStringList() {
        Collections.sort(ListOfMiniCartItems);
        return ListOfMiniCartItems;
    }

    public void moveToViewLogInAndCheckOutButton() {
        UtilityHelper.moveToViewElement(LOG_IN_AND_CHECKOUT_BUTTON);
        UtilityHelper.waitUntilClickable(LOG_IN_AND_CHECKOUT_BUTTON);
    }

    //
    public void clickLogInAndCheckOutButton() {
        UtilityHelper.click(LOG_IN_AND_CHECKOUT_BUTTON);
    }

    //To validate Grocery Substitution option not Display
    public void validate_GrocerySubOption_NotDisplay() {
        List<WebElement> list = getDriver().findElements(By.name("substitution"));
        Assert.assertTrue("=== Grocery Substitution Option Field Not Present!", list.size() == 0);
    }

    //To validate Comment Field not Display
    public void validate_CommentField_NotDisplay() {
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id='ordernotes']/textarea"));
        Assert.assertTrue("=== Comment Field Not Present!", list.size() == 0);
    }

    //Buttons display on shopping cart page for Anonymous user
    public void validate_ButtonsDisplayAnonymousUser_ShoppingCartPage() {
        Assert.assertTrue(CHECKOUT_AS_GUEST_BUTTON.isDisplayed());
        Assert.assertTrue(LOG_IN_AND_CHECKOUT_BUTTON.isDisplayed());
    }

    //Default Display of Comment field
    public void validate_defaultDisplayCommentField_ShoppingCart() {
        Assert.assertTrue(commentsHeadingTextShoppingCart.isDisplayed());
        Assert.assertEquals(Constants.placeholderTextCommentField, addCommentTextBoxFieldShoppingCart.getAttribute("placeholder"));
    }

    //Default display of Grocery Substitution options
    public void validate_DefaultOptionGrocerySubstitution_ShoppingCart() {
        System.out.println("=== Default value of grocery substitution display is: " + grocerySubSelectedValue.getText());
        Assert.assertEquals(Constants.defaultvalueGrocerySubstitutionOption, grocerySubSelectedValue.getText());
    }

    //To click remove button on CNC item
    public void clickRemoveButton_CNCItem(int noitemremove) {
        for (int i = 1; i <= noitemremove; i++) {
            WebElement clickremove = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + i + "]//a[text()='Remove']"));
            String nameofproduct = getDriver().findElement(By.xpath("//*[@id='productGroup_1']/li[" + i + "]//*[@class='product_name']/span")).getText();
            clickremove.click();
            System.out.println("=== Name of the product Removed: " + nameofproduct);
            listOfDeletedItemNameShoppingCart.add(nameofproduct);
        }
    }

    //To click remove button on SPO item
    public void clickRemoveButton_SPOItem(int noitemremove) {
        for (int i = 1; i <= noitemremove; i++) {
            WebElement clickremove = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + i + "]//a[text()='Remove']"));
            String nameofproduct = getDriver().findElement(By.xpath("//*[@id='productGroup_2']/li[" + i + "]//*[@class='product_name']/span")).getText();
            clickremove.click();
            System.out.println("=== Name of the product Removed: " + nameofproduct);
            listOfDeletedItemNameShoppingCart.add(nameofproduct);
        }
    }

    //to validate whether deleted item present in shopping cart
    public void validate_remainingItem_ShoppingCart() {
        System.out.println("List of remaining items ===>> " + listOfShoppingCardItem);
        System.out.println("List of Deleted items =====>> " + listOfDeletedItemNameShoppingCart);
        Assert.assertTrue(!(listOfShoppingCardItem.containsAll(listOfDeletedItemNameShoppingCart)));
    }

    //To Clear Array List
    public void emptyArrayList_ListOfShoppingCardItems() {
        listOfShoppingCardItem.clear();
        System.out.println("    Clear Shopping Cart Item Array List: " + listOfShoppingCardItem);
    }

    //To Clear Array List In Mini-Cart
    public void emptyArrayList_ListOfMiniCartItems() {
        ListOfMiniCartItems.clear();
        System.out.println("    Clear Mini-Cart Item Array List: " + ListOfMiniCartItems);
    }

    //To Clear Array List for Deleted Item stored
    public void emptyArrayList_DeletedItemsFromShoppingCard() {
        listOfDeletedItemNameShoppingCart.clear();
        System.out.println("    Clear Deleted Items stored in Shopping Cart Array List: " + listOfDeletedItemNameShoppingCart);
    }

    //To Clear Array list of Price and Qty
    public void emptyArrayList_PriceQTY_ShoppingCard() {
        PriceList.clear();
        QtyList.clear();
        System.out.println("    Clear Price Array List: " + PriceList);
        System.out.println("    Clear Qty History Array List: " + QtyList);
    }

    //To reduce Qty of CNC item
    public void reduceQty_CNCItem(int qtytoreduce) throws InterruptedException {
        UtilityHelper.waitUntilClickable(minusIcon1stunderCNCsectionShoppingCartPage);
        for (int i = 0; i < qtytoreduce; i++) {
            minusIcon1stunderCNCsectionShoppingCartPage.click();
        }
        Thread.sleep(3000);
    }

    //To Increase Qty of CNC item
    public void increaseQty_CNCItem(int qtytoincrease) throws InterruptedException {
        UtilityHelper.waitUntilClickable(plusIcon1stunderCNCsectionShoppingCartPage);
        for (int i = 0; i < qtytoincrease; i++) {
            plusIcon1stunderCNCsectionShoppingCartPage.click();
        }
        Thread.sleep(3000);
    }

    //To compare item names for ReOrder Item
    public void compareShoppingCartToReOrderItems() {
        UtilityHelper.compareShoppingCartToReOrderItems();
    }

    //Created By: 107793 11/17/16
    //To validate Update State for Unavailable Items In Shopping Cart Page
    public void stateForUnavailableItems_InShoppingCart() {
        List<WebElement> productList = getDriver().findElements(By.xpath("//*[@id='itemList']//li"));
        for (int i = 1; i <= productList.size(); i++) {
            WebElement itemList = getDriver().findElement(By.xpath("//*[@id='itemList']//li[" + i + "]"));
            String status = itemList.getAttribute("class");
            if (!status.contains("outofstock")) {
                continue;
            }
            String productName = getDriver().findElement(By.xpath("//*[@id='itemList']//li[" + i + "]//*[@class='mjr-product-name']")).getText();
            System.out.println("=== Product Index [" + i + "], Name [" + productName + "] is Unavailable");
            WebElement qtyStepper = getDriver().findElement(By.xpath("//*[@id='itemList']//li[" + i + "]//div[@class='mjr-qty-stepper']"));
            Assert.assertFalse("=== Verify Qty-Steppers Are Removed for Unavailable Item ", qtyStepper.isDisplayed());
            String notAvailMsg = getDriver().findElement(By.xpath("//*[@id='itemList']//li[" + i + "]//*[contains(@class,'msgNotAvail')]")).getText();
            Assert.assertEquals("=== Verify Product Not Available Message - Shopping Cart Page ", Constants.notAvailProd_shoppingCart, notAvailMsg);
            WebElement checkoutButtons = getDriver().findElement(By.xpath("//*[@class='rightSidebar-footer-inner']//*[@type='submit']"));
            Assert.assertFalse("=== Verify Checkout Buttons are Disabled for Guest OR Signed-In User ", checkoutButtons.isEnabled());
        }
    }

    //Created By: 107793 12/22/16
    public void stateForUnavailableItems_InMiniCart() {
        int count = 0;
        List<WebElement> itemInMiniCart = getDriver().findElements(By.xpath("//*[@id='itemList']//li"));
        for (WebElement unavailable : itemInMiniCart) {
            if (count != itemInMiniCart.size()) {
                if (!String.valueOf(unavailable.getAttribute("class")).contains("outofstock")) {
                    continue;
                }
                count++;
                System.out.println("unavailable ===>> " + String.valueOf(unavailable.findElement(By.xpath("//*[@class='productNameInner']")).getText()));
                WebElement childQtyStepper = unavailable.findElement(By.xpath(".//*[@class='mjr-qtyButton plus noSelect']"));
                Assert.assertFalse("Verify Qty Stepper NOT displayed for Unavailable Product via Mini-Cart", (childQtyStepper.isDisplayed()));
            }
        }
        System.out.println("=== Total Number of Products [" + itemInMiniCart.size() + "]");
        System.out.println("=== Number of Unavailable Products In Mini-Cart [" + count + "]");
        Assert.assertEquals("Verify there is at least one (1) unavailable product ", 1, count);
    }

    //Created By: 107793 11/17/16
    public void setSelectedItemsToValidation_MiniCart() {
        if (ListOfMiniCartItems.isEmpty()) {
            List<WebElement> inMiniCart = getDriver().findElements(By.xpath("//*[@class='productNameInner']"));
            for (WebElement lineItem : inMiniCart) {
                ListOfMiniCartItems.add(lineItem.getText());
            }
        }
    }

    //Created By: 107793 11/17/16
    public void productName_Comparision_MiniCart() {
        UtilityHelper.miniCart_CompareListString();
    }

    //Created By: 107793 11/18/16
    public void miniCartFulfillmentGroupOrder() {
        List<WebElement> fGroupType1 = getDriver().findElements(By.xpath("//*[contains(@id,'group-type-1')]"));
        List<WebElement> fGroupType2 = getDriver().findElements(By.xpath("//*[contains(@id,'group-type-2')]"));
        List<WebElement> fGroupType8 = getDriver().findElements(By.xpath("//*[contains(@id,'group-type-8')]"));

        //CNC ONLY
        if (fGroupType1.size() == 1 && fGroupType2.size() == 0 && fGroupType8.size() == 0) {
            System.out.println("=== Attempting [CNC] Fulfillment Group Order ===");
            String fGroupTitle1 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            Assert.assertEquals(Constants.cncFulfillmentTitle, fGroupTitle1);
        }
        //SPO ONLY
        if (fGroupType2.size() == 1 && fGroupType1.size() == 0 && fGroupType8.size() == 0) {
            System.out.println("=== Attempting [SPO] Fulfillment Group Order ===");
            String fGroupTitle2 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            Assert.assertEquals(Constants.spoFulfillmentTitle, fGroupTitle2);
        }
        //STH ONLY
        if (fGroupType8.size() == 1 && fGroupType1.size() == 0 && fGroupType2.size() == 0) {
            System.out.println("=== Attempting [STH] Fulfillment Group Order ===");
            String fGroupTitle8 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            Assert.assertEquals(Constants.sthFulfillmentTitle, fGroupTitle8);
        }
        //CNC & SPO
        if (fGroupType2.size() == 1 && fGroupType1.size() == 1 && fGroupType8.size() == 0) {
            System.out.println("=== Attempting [CNC][SPO] Fulfillment Group Order ===");
            String fGroupTitle1 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            String fGroupTitle2 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[2]/h5")).getText();
            Assert.assertEquals(Constants.cncFulfillmentTitle, fGroupTitle1);
            Assert.assertEquals(Constants.spoFulfillmentTitle, fGroupTitle2);
        }
        //CNC & STH
        if (fGroupType8.size() == 1 && fGroupType1.size() == 1 && fGroupType2.size() == 0) {
            System.out.println("=== Attempting [CNC][STH] Fulfillment Group Order ===");
            String fGroupTitle1 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            String fGroupTitle8 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[2]/h5")).getText();
            Assert.assertEquals(Constants.cncFulfillmentTitle, fGroupTitle1);
            Assert.assertEquals(Constants.sthFulfillmentTitle, fGroupTitle8);
        }
        //SPO & STH
        if (fGroupType2.size() == 1 && fGroupType8.size() == 1 && fGroupType1.size() == 0) {
            System.out.println("=== Attempting [SPO][STH] Fulfillment Group Order ===");
            String fGroupTitle2 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            String fGroupTitle8 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[2]/h5")).getText();
            Assert.assertEquals(Constants.spoFulfillmentTitle, fGroupTitle2);
            Assert.assertEquals(Constants.sthFulfillmentTitle, fGroupTitle8);
        }
        //CNC & SPO & STH
        if (fGroupType1.size() == 1 && fGroupType2.size() == 1 && fGroupType8.size() == 1) {
            System.out.println("=== Attempting [CNC][SPO][STH] Fulfillment Group Order ===");
            String fGroupTitle1 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[1]/h5")).getText();
            String fGroupTitle2 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[2]/h5")).getText();
            String fGroupTitle8 = getDriver().findElement(By.xpath("//*[@id='prod-sort-list']/div[3]/h5")).getText();
            Assert.assertEquals(Constants.cncFulfillmentTitle, fGroupTitle1);
            Assert.assertEquals(Constants.spoFulfillmentTitle, fGroupTitle2);
            Assert.assertEquals(Constants.sthFulfillmentTitle, fGroupTitle8);
        }
    }

    // To validate Modal Notification Modal appears, if/when unavailable items are in shopping cart
    public void verifyNotificationOfUnavailableItemsModalAppears() {
        UtilityHelper.waitUntilElementVisible(UnavailableItems_Modal);
        Assert.assertTrue("Notification of Unavailable Items Modal Appear: ", UnavailableItems_Modal.isDisplayed());
    }

    // TO validate the look and feel of the Notification Modal
    public void lookAndFeelOfNotificationModal() {
        String actualBanner1 = UtilityHelper.elementGetText(UnavailableItems_Modal.findElement(By.xpath(".//p[1]")));
        String actualBanner2 = UtilityHelper.elementGetText(UnavailableItems_Modal.findElement(By.xpath(".//p[2]")));
        String actualBanner3 = UtilityHelper.elementGetText(UnavailableItems_Modal.findElement(By.xpath(".//p[3]")));
        Assert.assertEquals("Verify Unavailable Modal Banner Text 1: ", Constants.UnavailableBannerText1, actualBanner1);
        Assert.assertEquals("Verify Unavailable Modal Banner Text 2: ", Constants.UnavailableBannerText2, actualBanner2);
        Assert.assertEquals("Verify Unavailable Modal Banner Text 3: ", Constants.UnavailableBannerText3, actualBanner3);
        Assert.assertTrue("Verify Unavailable Modal Button: ", UtilityHelper.isDisplayed(UnavailableItems_Modal_Button));
    }

    // To set List of items in Notification modal
    public void setArrayListOfItemsToBeDeletedViaNotificationModal() {
        List<WebElement> itemsToBeRemoved = UnavailableItems_Modal.findElements(By.xpath(".//*[@class='mjr-product-name']"));
        for (WebElement item : itemsToBeRemoved) {
            listOfDeletedItemNameShoppingCart.add(UtilityHelper.elementGetText(item));
        }
    }

    // To click 'Remove Items From Cart' button via Notification modal
    public void userClicksRemoveItemsFromCartButton() {
        UtilityHelper.waitUntilClickable(UnavailableItems_Modal_Button);
        UtilityHelper.click(UnavailableItems_Modal_Button);
        UtilityHelper.waitUntilElementNotVisible(UnavailableItems_Modal);
    }

    // To Close the Notification modal
    public void userClosesNotificationOfUnavailableItemsModal() {
        if (UtilityHelper.elementExists(UnavailableItems_Modal)) {
            UtilityHelper.waitUntilClickable(UnavailableItems_Modal_Close);
            UtilityHelper.click(UnavailableItems_Modal_Close);
            UtilityHelper.waitUntilElementNotVisible(UnavailableItems_Modal);
        }
    }

    // To click Qty Stepper 'Plus' in Shopping Cart page
    public void increaseQtyStepperOfRandomProductsInShoppingCartPage(WebElement element, int clickPlus) {
        UtilityHelper.moveToViewElement(element);
        for (int i = 0; i < clickPlus; i++) {
            String itemCountIcon = UtilityHelper.elementGetText(ITEM_COUNT_ON_SHOPPING_CART);
            WebElement qtyInput = element.findElement(By.xpath(".//*[contains(@class,'qtyInput')]"));
            String qtyStep = UtilityHelper.elementGetAttribute(qtyInput, "step");
            UtilityHelper.click(element.findElement(By.xpath(".//*[contains(@id,'plus')]")));
            if (!(qtyStep.equals("0.25"))) {
                // If Alt UoM != LB, calculate quantity
                waitUntilQuantityUpdate("plus", itemCountIcon);
            }
        }
    }

    // To click Qty Stepper 'Minus' in Shopping Cart page
    public void decreaseQtyStepperOfRandomProductsInShoppingCartPage(WebElement element, int clickMinus) {
        UtilityHelper.moveToViewElement(element);
        for (int i = 0; i < clickMinus; i++) {
            WebElement qtyInput = element.findElement(By.xpath(".//*[contains(@class,'qtyInput')]"));
            String qtyValue = UtilityHelper.elementGetAttribute(qtyInput, "value");
            String qtyStep = UtilityHelper.elementGetAttribute(qtyInput, "step");
            if (((Double.valueOf(qtyValue) != 1.00) || qtyStep.equals("0.25")) && Double.valueOf(qtyValue) != 0.25) {
                String itemCountIcon = UtilityHelper.elementGetText(ITEM_COUNT_ON_SHOPPING_CART);
                UtilityHelper.click(element.findElement(By.xpath(".//*[contains(@id,'minus')]")));
                if (!(qtyStep.equals("0.25"))) {
                    // If Alt UoM != LB, calculate quantity
                    waitUntilQuantityUpdate("minus", itemCountIcon);
                }
            }
        }
    }

    // To wait until Qty Stepper action is complete
    private void waitUntilQuantityUpdate(String stepper, String itemCountIcon) {
        String expected;
        switch (stepper) {
            case "plus":
                expected = String.valueOf((Integer.valueOf(itemCountIcon)) + 1);
                UtilityHelper.waitUntilExpectedCondition(ITEM_COUNT_ON_SHOPPING_CART, expected);
                Assert.assertEquals("Verify Qty Stepper 'Plus': ", expected, ITEM_COUNT_ON_SHOPPING_CART.getText());
                break;
            case "minus":
                expected = String.valueOf((Integer.valueOf(itemCountIcon)) - 1);
                UtilityHelper.waitUntilExpectedCondition(ITEM_COUNT_ON_SHOPPING_CART, expected);
                Assert.assertEquals("Verify Qty Stepper 'Minus': ", expected, ITEM_COUNT_ON_SHOPPING_CART.getText());
                break;
        }
    }

    public void moveToViewClearAllItemsLink() {
        UtilityHelper.moveToViewElement(CLEAR_ALL_ITEMS_LINK);
    }

    public void clickClearAllItemsLink() {
        UtilityHelper.click(CLEAR_ALL_ITEMS_LINK);
    }

    public void clickConfirmClearItemsButton() {
        UtilityHelper.click(CONFIRM_CLEAR_ITEMS_BUTTON);
    }

    public void waitForEmptyShoppingCart() {
        try {
            if (UtilityHelper.elementNotExists(EMPTY_SHOPPING_CART)) {
                Thread.sleep(2000);
                while (UtilityHelper.elementNotExists(EMPTY_SHOPPING_CART)) {
                    Thread.sleep(5000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UtilityHelper.waitUntilElementVisible(EMPTY_SHOPPING_CART);
    }

    //To verify the staticmessage in minicart
    public void verifyStaticMessageOnMiniCart() {
        String element = "//*[@id='disclaimerText']";
        if (UtilityHelper.isNotClickable(org.openqa.selenium.By.xpath(element))) {
            UtilityHelper.waitUntilClickable(org.openqa.selenium.By.xpath(element));
        }
        WebElement staticmessage = getDriver().findElement(org.openqa.selenium.By.xpath(element));
        UtilityHelper.waitUntilClickable(staticmessage);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage.getText());
        System.out.println("==========Static message is displayed in minicart======== ");
    }

    public void verifyNoStaticMessageOnMiniCart() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mcFooter']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message and tooltip in Minicart page ===");

    }

    public void verifyStaticMessageIsDisplayedInShoppingCart() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='disclaimerText']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified the static message in Shopping cart page===");
    }

    public void verifyNoStaticMessageIsDisplayedInShoppingCart() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mjr-rightSidebar']/div/div[2]/div[1]"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message in Shopping cart page for STH order===");
    }

    public void verifyNoStaticMessageAndTooltipAppearsWhenEmptyCart() {
        WebElement staticmessage_shop = getDriver().findElement(org.openqa.selenium.By.xpath(".//*[@id='mcFooter']"));
        UtilityHelper.waitUntilClickable(staticmessage_shop);
        Assert.assertNotEquals("Final price and discounts will be determined at pickup.", staticmessage_shop.getText());
        System.out.println("===Verified No static message and tooltip in empty cart===");
    }

}
