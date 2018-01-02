package com.tcs.utilityhelpers;

import com.tcs.automation.pages.*;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.Dropdown;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import static java.util.Collections.shuffle;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class utilityhelper extends PageObject {

    private static Boolean isAltUoM;
    private static String altUoM_Type;
    private static String lastElement;
    private static String lastElementStyle;
    private static Stack<Integer> myShuffledList = new Stack<>();

    private HomePage homePage = new HomePage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private OrderDetailPage orderDetailPage = new OrderDetailPage();
    private OrderReviewPage orderReviewPage = new OrderReviewPage();

    //To determine if product is an Alt_UoM product
    public static void setIsProductAltUoM(Boolean value) {
        isAltUoM = value;
    }

    public static Boolean getIsAltUoM() {
        return isAltUoM;
    }

    public static String getAltUoM_Type() {
        return altUoM_Type;
    }

    //To get the Alt_UoM value of the product
    public static void setAltUoM_Type(String value) {
        altUoM_Type = value.toUpperCase();
    }

    public void typeIntoElement(WebElement element, String text) {
        if (elementExists(element)) {
            highLightElement(element);
            element.clear();
            getActions_WebDriver().sendKeys(element, text).perform();
        }
    }

    public void typeIntoElement(By by, String text) {
        WebElement element = getDriver().findElement(by);
        typeIntoElement(element, text);
    }

    public void selectFromDropdownMenu(WebElement element, String visibleLabel) {
        if (elementExists(element)) {
            highLightElement(element);
            Dropdown.forWebElement(element).select(visibleLabel);
        }
    }

    public void selectFromDropdownMenu(By by, String visibleLabel) {
        WebElement element = getDriver().findElement(by);
        selectFromDropdownMenu(element, visibleLabel);
    }

    public void moveToViewElement(WebElement element) {
        if (elementExists(element)) {
            // move mouse over desired element
            moveMouseTo(element);
            int Y = element.getLocation().getY();
            String clazz = getDriver().findElement(By.xpath("//body")).getAttribute("class");
            // first check if stickyHeader is enabled && a 'overlay' div is NOT displayed
            if (clazz.contains("fix-sticky") && !(isBackSplash())) {
                // No modal is displayed, now ensure the element is NOT under the sticky header
                // Note: '130' is the height of the sticky header
                getJavaScript().executeScript("window.scrollTo(0, " + (Y - 130) + ");");
            }
            highLightElement(element);
        }
    }

    private Boolean isBackSplash() {
        String clazz = getDriver().findElement(By.xpath("//body")).getAttribute("class");
        //pgwModalOpen == choking hazard modal. mjr-modalBody == more modern/update-to-date modals
        return (clazz.contains("pgwModalOpen") || clazz.contains("mjr-modalBody") || clazz.contains("show-miniCart"));
    }

    public void moveToViewElement(By by) {
        WebElement element = getDriver().findElement(by);
        moveToViewElement(element);
    }

    public void click(WebElement element) {
        if (elementExists(element)) {
            highLightElement(element);
            getActions_WebDriver().click(element).perform();
        }
    }

    public void click(By by) {
        WebElement element = getDriver().findElement(by);
        click(element);
    }

    public Boolean isDisplayed(WebElement element) {
        Boolean value = false;
        if (elementExists(element)) {
            value = element.isDisplayed();
            if (value) {
                highLightElement(element);
            }
        }
        return value;
    }

    public Boolean isDisplayed(By by) {
        WebElement element = getDriver().findElement(by);
        return isDisplayed(element);
    }

    public Boolean isEnabled(WebElement element) {
        Boolean value = false;
        if (elementExists(element)) {
            value = element.isEnabled();
            if (value) {
                highLightElement(element);
            }
        }
        return value;
    }

    public Boolean isEnabled(By by) {
        WebElement element = getDriver().findElement(by);
        return isEnabled(element);
    }

    public Boolean isSelected(WebElement element) {
        Boolean value = false;
        if (elementExists(element)) {
            value = element.isSelected();
            if (value) {
                highLightElement(element);
            }
        }
        return value;
    }

    public Boolean isSelected(By by) {
        WebElement element = getDriver().findElement(by);
        return isSelected(element);
    }

    public String elementGetText(WebElement element) {
        String value;
        if (elementExists(element)) {
            value = element.getText().trim();
            highLightElement(element);
        } else {
            value = "";
        }
        return value;
    }

    public String elementGetText(By by) {
        WebElement element = getDriver().findElement(by);
        return elementGetText(element);
    }

    public String elementGetAttribute(WebElement element, String attribute) {
        String value;
        if (elementExists(element)) {
            value = element.getAttribute(attribute).trim();
        } else {
            value = "";
        }
        return value;
    }

    public String elementGetAttribute(By by, String attribute) {
        WebElement element = getDriver().findElement(by);
        return elementGetAttribute(element, attribute);
    }

    public String elementGetCssValue(WebElement element, String propertyName) {
        String value;
        if (elementExists(element)) {
            value = element.getCssValue(propertyName).trim();
            highLightElement(element);
        } else {
            value = "";
        }
        return value;
    }

    public String elementGetCssValue(By by, String propertyName) {
        WebElement element = getDriver().findElement(by);
        return elementGetCssValue(element, propertyName);
    }

    public boolean isClickable(WebElement element) {
        try {
            getWebDriverWait(2).until(elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isClickable(By by) {
        WebElement element = getDriver().findElement(by);
        return isClickable(element);
    }

    public Boolean elementExists(WebElement element) {
        By by = By.xpath(splitElementToXpath(element));
        return elementExists(by);
    }

    public Boolean elementExists(By by) {
        return getDriver().findElements(by).size() > 0;
    }

    public Boolean elementNotExists(WebElement element) {
        By by = By.xpath(splitElementToXpath(element));
        return elementNotExists(by);
    }

    public Boolean elementNotExists(By by) {
        return getDriver().findElements(by).size() < 1;
    }

    public void waitUntilClickable(WebElement element) {
        getWebDriverWait(30).until(elementToBeClickable(element));
        highLightElement(element);
    }

    public void waitUntilClickable(By by) {
        WebElement element = getDriver().findElement(by);
        waitUntilClickable(element);
    }

    public void waitUntilExpectedCondition(WebElement element, String text) {
        getWebDriverWait(30).until(textToBePresentInElement(element, text));
    }

    public void waitUntilExpectedCondition(By by, String text) {
        WebElement element = getDriver().findElement(by);
        waitUntilExpectedCondition(element, text);
    }

    public void waitUntilElementVisible(WebElement element) {
        getWebDriverWait(35).until(visibilityOf(element));
        highLightElement(element);
    }

    public void waitUntilElementVisible(By by) {
        WebElement element = getDriver().findElement(by);
        waitUntilElementVisible(element);
    }

    public void waitUntilElementNotVisible(WebElement element) {
        By by = By.xpath(splitElementToXpath(element));
        waitUntilElementNotVisible(by);
    }

    public void waitUntilElementNotVisible(By by) {
        getWebDriverWait(30).until(invisibilityOfElementLocated(by));
    }

    public boolean isNotClickable(WebElement element) {
        try {
            getWebDriverWait(2).until(ExpectedConditions.elementToBeClickable(element));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isNotClickable(By by) {
        WebElement element = getDriver().findElement(by);
        return isNotClickable(element);
    }

    public void highLightElement(WebElement element) {
        try {
            String newElement = splitElementToXpath(element);
            if (elementExists(By.xpath(newElement))) {
                if (lastElement != null) {
                    if (!(newElement.equals(lastElement))) {
                        resetStyleToLastElement();
                    }
                }
                if (!(newElement.equals(lastElement))) {
                    lastElement = newElement;
                    lastElementStyle = getDriver().findElement(By.xpath(newElement)).getAttribute("style");
                    // To maintain elements current 'style' + border: 4px solid #00CC00
                    getJavaScript().executeScript("arguments[0].setAttribute('style', '" + lastElementStyle + " border: 4px solid #00CC00 !important;');", getDriver().findElement(By.xpath(newElement)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void highLightElement(By by) {
        if (elementExists(by)) {
            WebElement element = getDriver().findElement(by);
            highLightElement(element);
        }
    }

    private void resetStyleToLastElement() {
        if (elementExists(By.xpath(lastElement))) {
            getJavaScript().executeScript("arguments[0].setAttribute('style', '" + lastElementStyle + "');", getDriver().findElement(By.xpath(lastElement)));
        }
    }

    private Mouse getMouse() {
        return ((HasInputDevices) getDriver()).getMouse();
    }

    private Actions getActions_WebDriver() {
        return new Actions(getDriver());
    }

    private JavascriptExecutor getJavaScript() {
        return ((JavascriptExecutor) getDriver());
    }

    private WebDriverWait getWebDriverWait(int timeOutInSeconds) {
        return new WebDriverWait(getDriver(), timeOutInSeconds);
    }

    private void moveMouseTo(WebElement element) {
        try {
            getMouse().mouseMove(coordinatesOf(element));
        } catch (MoveTargetOutOfBoundsException e) {
            getJavaScript().executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    private Coordinates coordinatesOf(WebElement element) {
        return ((Locatable) element).getCoordinates();
    }

    // Return as String. Use as -> By.xpath(xpath)
    private String splitElementToXpath(WebElement element) {
        String xpath;
        if (element.toString().contains(".//")) {
            xpath = mergeXpath(element);
        } else {
            xpath = convertToXpath(element);
        }
        return xpath;
    }

    // Used to merge a Parent xpath with Child xpath as one xpath
    // Example: WebElement parentXpath = "xpath";
    // parentXpath.findElement(By.xpath(".//[childXpath]"));
    private String mergeXpath(WebElement element) {
        String merge;
        String value1, value2;
        String xpath1 = null, xpath2 = null;
        String[] splitElement = element.toString().split(" -> xpath:");
        // To remove the extra end brackets ']'
        if (!(Strings.isNullOrEmpty(splitElement[1]))) {
            value1 = splitElement[1].trim();
            xpath1 = value1.substring(0, (value1.length() - 2)).trim();
        }
        // To remove '.' in './/*[ .... ]' and the extra end brackets ']'
        if (!(Strings.isNullOrEmpty(splitElement[2]))) {
            value2 = splitElement[2].trim();
            xpath2 = value2.substring(1, (value2.length() - 1)).trim();
        }
        merge = xpath1 + xpath2;
        return merge;
    }

    // Used to convert WebElement into Xpath
    private String convertToXpath(WebElement element) {
        String xpath;
        // To split element
        String[] splitElement = element.toString().split(":");
        // To capture xpath
        String value = splitElement[2].trim();
        if (element.toString().contains("Proxy")) {
            xpath = value.trim();
        } else {
            // If 'getDriver().findElement(By.xpath)' is passed through.
            // Remove last char ']' of String value
            xpath = value.substring(0, (value.length() - 1)).trim();
        }
        return xpath;
    }

    public void shuffleList(int min, int max) {
        Stack<Integer> list = new Stack<>();
        for (int i = min; i < (max + 1); i++) {
            list.push(i);
        }
        shuffle(list);
        myShuffledList = list;
    }

    public Integer popShuffledList() {
        return myShuffledList.pop();
    }

    @Screenshots(disabled = true)
    public void clearAllArrayList() {
        System.out.println("\n---------------- Clearing Array Lists ----------------");
        System.out.println("SHOPPING CART ARRAY LISTS");
        shoppingCartPage.emptyArrayList_ListOfMiniCartItems();
        shoppingCartPage.emptyArrayList_ListOfShoppingCardItems();
        shoppingCartPage.emptyArrayList_DeletedItemsFromShoppingCard();
        shoppingCartPage.emptyArrayList_PriceQTY_ShoppingCard();
        System.out.println("ORDER REVIEW ARRAY LISTS");
        orderReviewPage.emptyArrayList_VerifyCalculationArrayList();
        System.out.println("ORDER HISTORY ARRAY LISTS");
        orderDetailPage.emptyArrayList_ListOfOrderHistoryItem();
        orderDetailPage.emptyArrayList_ListOfOrderHistoryItemExceptCake();
        orderDetailPage.emptyArrayList_NameOfItemDeleteList();
        orderDetailPage.emptyArrayList_ItemListAfterDel();
        orderDetailPage.emptyArrayList_ExtrNamesOfItemList();
        orderDetailPage.emptyArrayList_SelectedReorderItemList();
        orderDetailPage.emptyArrayList_ReOrderItemList();
        orderDetailPage.emptyArrayList_OrderBySelectedReorderItemList();
        orderDetailPage.emptyArrayList_NewlyAddedItems();
        System.out.println("HOME PAGE ARRAY LISTS");
        homePage.emptyArrayList_NamesOfItemList();
        homePage.emptyArrayList_verifyItemList();
        homePage.emptyArrayList_OrderByTimeAddedStringList();
        homePage.emptyArrayList_ShoppingCartFulfillmentGroupList();
        System.out.println("------------------- END Array Lists --------------------\n");

    }


    /*===================Comparing List=============================================*/

    public void compareListString() {
        System.out.println("Product name list in Home Array ============>> " + homePage.getNamesOfItemList());
        System.out.println("Product name list in Shopping Cart Array ===>> " + shoppingCartPage.getListOfShoppingCartItem());
        Assert.assertTrue("Items added [" + homePage.getNamesOfItemList() + "] " +
                        "!= Items in Shopping Cart Page [" + shoppingCartPage.getListOfShoppingCartItem() + "]",
                homePage.getNamesOfItemList().containsAll(shoppingCartPage.getListOfShoppingCartItem()));
    }

    public void compareGuestCartToSignedInCart() {
        if (shoppingCartComparedToItemsAddedBoolean())
            Assert.assertTrue("Validate Items in Cart == Items Added during Test ", homePage.getNamesOfItemList().containsAll(shoppingCartPage.getListOfShoppingCartItem()));
        // else: Continue through test and fail at cucumber Step: "while on Shopping Cart Page, remove all existing items"
    }

    public Boolean shoppingCartComparedToItemsAddedBoolean() {
        return homePage.getNamesOfItemList().containsAll(shoppingCartPage.getListOfShoppingCartItem());
    }

    public void miniCart_CompareListString() {
        System.out.println("Product Name List In Mini-Cart getListOfShoppingCartItem Array ===>> " + shoppingCartPage.getMiniCartStringList());
        System.out.println("Product Name List setOrderByTimeAddedStringList Array ============>> " + homePage.getOrderByTimeAddedStringList());
        Assert.assertTrue("Validate Items in Mini-Cart are Ordered Correctly ", homePage.getOrderByTimeAddedStringList().containsAll(shoppingCartPage.getMiniCartStringList()));
    }

    public void compareShoppingCartToReOrderItems() {
        System.out.println("Product Name List in ReOrder getStringReorderList Array ==============>>\n" + orderDetailPage.getStringReorderList());
        System.out.println("Product Name List in Shopping Cart getListOfShoppingCartItem Array ===>>\n" + shoppingCartPage.getListOfShoppingCartItem());
        Assert.assertTrue("Validate Item Name in Order Review Page ", shoppingCartPage.getListOfShoppingCartItem().containsAll(orderDetailPage.getStringReorderList()));
    }

    public void productNameCompareOrderHistoryDetailPage() {
        System.out.println("Product name list in Home getListOfShoppingCartItem Array ====>> " + homePage.getNamesOfItemList());
        System.out.println("Product name list in getStringListOrderHistory ===============>> " + orderDetailPage.getListOfOrderHistoryItems());
        Assert.assertTrue("Validate Item Name in Order History Detail Page ", homePage.getNamesOfItemList().containsAll(orderDetailPage.getListOfOrderHistoryItems()));
    }

    public void productNameCompareOrderHistoryDetailPageExceptCake() {
        System.out.println("Product name list in Home getListOfShoppingCartItem Array ==============>>  " + homePage.getNamesOfItemList());
        System.out.println("Product name list in getStringListOrderHistoryExceptCake ===>> " + orderDetailPage.getStringListOrderHistoryExceptCake());
        Assert.assertTrue("Validate Item Name Excluding Cake in Order History Detail Page ", homePage.getNamesOfItemList().containsAll(orderDetailPage.getStringListOrderHistoryExceptCake()));
    }

    public void validate_FirstAvailable_PickupTimeDisplayCorrect() {
        Assert.assertTrue("Validate First SLOT ", HomePage.firstavailablePickupTime.contains(OrderPickupPage.firstSLOTavailable));
        Assert.assertTrue("Validate First DAY ", HomePage.firstavailablePickupTime.contains(OrderPickupPage.firstDAYavailable));
    }

    public void additionalProdNameCompareOrderHistoryDetailPage() {
        Assert.assertTrue("Validate Newly Added Item is Displayed ", orderDetailPage.getListOfOrderHistoryItems().retainAll(orderDetailPage.getStringAddList()));
    }

/*===================End Comparing List=============================================*/


    //To generate Random number
    public int getRandomNumber(int min, int max) {
        if (min > max) {
            System.out.println("Incorrect number range defined!!!");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * This method is been created for performing click action using Javascript Executor.
     *
     * @param element, Webelement is passing as parameter.
     */
    public void click_JavaScriptExecutor(WebElement element) {
        JavascriptExecutor click = (JavascriptExecutor) getDriver();
        getJavaScript().executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll horizontally & vertically
     */
    public void scrollUpPage() {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        getJavaScript().executeScript("scroll(0, -500);");
    }

    public void scrollDownPage() {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        getJavaScript().executeScript("scroll(0, 500);");
    }

    public void scroll(String script) {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        getJavaScript().executeScript(script);
    }

    /**
     * Pressing & Releasing keys with the help of java based utility(Robot)
     */
    public void escapeKeyPressRelease() throws AWTException {
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_ESCAPE);
        rbt.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void openNewTab() throws AWTException {
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_T);
        rbt.keyRelease(KeyEvent.VK_T);
        rbt.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * This method is been created for performing as page refresh action.
     *
     * @throws InterruptedException, This is Interrupted exception for using wait.
     */
    public void refreshPage() throws InterruptedException {
        getDriver().navigate().refresh();
        Thread.sleep(2000);
    }

    /**
     * Press Enter Key from key
     */
    public void userPress_EnterKey(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public String getCurrentWindow() {
        return getDriver().getWindowHandle();
    }

    public String switchToSubWinow() {
        String myvalue = "";
        String subWindowHandle = getDriver().getWindowHandle();
        String subWindowHandler = null;

        java.util.Set<String> handles = getDriver().getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        WebDriver swd = getDriver().switchTo().window(subWindowHandler);
        if (swd != null) {
            myvalue = subWindowHandle;
        }
        return myvalue;
    }

    public boolean switchToParentWindow(String parent_win_handle) {
        Boolean myvalue = false;
        WebDriver wd = getDriver().switchTo().window(parent_win_handle);
        if (wd != null) {
            Boolean isfound = true;
            myvalue = isfound;
        }
        return myvalue;
    }
}
