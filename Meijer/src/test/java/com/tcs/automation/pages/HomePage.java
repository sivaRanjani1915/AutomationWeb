package com.tcs.automation.pages;

import com.tcs.automation.Definition_RunnerClass;
import com.tcs.utilityhelpers.Constants;
import com.tcs.utilityhelpers.ExcelData_Input;
import com.tcs.utilityhelpers.utilityhelper;
import net.thucydides.core.pages.PageObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tcs.utilityhelpers.utilityhelper.*;
import static org.junit.Assert.*;

public class HomePage extends PageObject {

    public static List<String> suggestionsList = new ArrayList<>();
    public static List<String> favoritesList = new ArrayList<>();
    public static List<String> frequentPurchasesList = new ArrayList<>();
    public static List<String> searchResults = new ArrayList<>();
    public static List<String> shoppingCartFulfillmentGroupArrayList = new ArrayList<>();
    public static List<String> namesOfItemList = new ArrayList<>();
    public static List<String> verifyItemList = new ArrayList<>();
    public static List<String> orderByTimeAddedStringList = new ArrayList<>();
    public static String reservationHeader;
    public static String headerCount;
    public static String cartID;
    public static String g_store;
    public static String firstavailablePickupTime = null;
    public static String TierHyperlink = null;

    public static String SearchHyperlink = null;
    public static String verifyPageSource = null;
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileOutputStream outFile;
    //siva
    public static XSSFWorkbook excelworkbook;
    public static XSSFSheet excelsheet;
    public static XSSFRow excelrow;
    public static XSSFCell excelcell;
    public static FileOutputStream exceloutFile;
    static String excelfileName = "./datasource/myExcelData_output.xlsx";
    static String excelsheetName = "VIngWar";
    public String text_Comparison = null;

    /*-------------------------------Meijer Home Page Elements------------------------------*/
    @FindBy(xpath = "//*[@id='shop']")
    public WebElement shopOptionMeijerHP;

    //Your Store Name field
    @FindBy(xpath = "//*[@id='js-storeNameMsg']")
    public WebElement yourStoreNameMeijerHP;


    /*-----------Nutritional Information----------------*/


    @FindBy(xpath = "//*[contains(@class,'wfDesktop')]")
    public WebElement wayfindingContainer;

    @FindBy(xpath = "//*[@id='product-nutrition-label']/div")
    public WebElement nutritionDetails_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelVit-Min']/tbody/tr[14]/td")
    public WebElement StaticNutritionFooter;

    @FindBy(xpath = "//*[@id='more-nutrition-info']/div[3]")
    public WebElement nutritionHeader_PDP;

    //Sign In to reserve a time slot
    @FindBy(xpath = "//*[@id='js-curbside-display-msg']//*[@class='line1 mjr-small']")
    public WebElement SIGN_IN_TO_RESERVE_SLOT_LINK;

    //Reserved Until display section
    @FindBy(xpath = "//*[@id='js-curbside-display-msg']//*[@class='mjr-small active line2 hideFromMobileHeader']")
    public WebElement reservedUntildisplaySectionMeijerHP;

    //Footer link - Store Locator
    @FindBy(xpath = "//*[text()='Store Locator']")
    public WebElement storeLocatorLinkFooterMeijerHP;

    //Curbside Wizard available timeslot Text
    @FindBy(xpath = "//*[@id='js-startTimePickupMsg']/p")
    public WebElement availableassoonastextMeijerHP;

    //Past Orders link
    @FindBy(xpath = "//*[@id='js-startTimePickupMsg']//*[text()='Past Orders']")
    public WebElement PAST_ORDERS_CURBSIDE_LINK;

    //Quick Shop link
    @FindBy(xpath = "//*[@id='js-startTimePickupMsg']//*[text()='Quick Shop']")
    public WebElement QUICK_SHOP_CURBSIDE_LINK;

    /*--------------------------Quick Shop-------------------------------*/

    //Frequent Purchases Header Text
    @FindBy(xpath = "//h2[@class='quickShopHeadline' and text()='Frequent Purchases']")
    public WebElement frequentPurchasesHeaderTextQuickShop;

    //Your Favorites Header Text
    @FindBy(xpath = "//h2[@class='quickShopHeadline' and text()='Your Favorites']")
    public WebElement yourFavoritesHeaderTextQuickShop;

    //Top Recommendations Header Text
    @FindBy(xpath = "//h2[@class='quickShopHeadline' and text()='Top Recommendations']")
    public WebElement yourRecommendationsHeaderTextQuickShop;

    //Store Location Search text box field
    @FindBy(xpath = "//*[@class='clr']//*[@name='cityStateZip']")
    public WebElement searchStoreLocationTextBoxFieldMeiejrHP;

    @FindBy(xpath = "//*[@id='nav_search']")
    public WebElement SEARCH_TEXTBOX;

    /*------------------------------------Store Select popup -------------------------------------*/

    @FindBy(xpath = "//*[@id='tierResults']/div[3]/ul/li/div/div[1]/a")
    public WebElement thumbnail;

       /*----------------------------------------SHOP Menu-------------------------------------------*/

    //Select this Store Button on Store Location
    @FindBy(xpath = "//*[@id='save-store']")
    public WebElement selectThisStoreButtonStoreLocationMeijerHP;

    //Note for Releasing Curbside Reservation
    @FindBy(xpath = "//*[@id='save-store-wrapper']/div[contains (@class, 'noteWrapper')]")
    public WebElement warningNoteForDroppingReserveSlotSelectStore;

    //Next Page button on product page
    @FindBy(xpath = "//button[@class='btn nav-btn next-btn']")
    public WebElement nextpageButtonProductPage;

    /*--------------------------------Product Page --------------------------------------------*/

    //last page number icon
    @FindBy(xpath = "//*[@id='lastNum']")
    public WebElement lastPageNumberProductPage;

    //Result Per Page Dropdown
    @FindBy(xpath = "//button[@class='btn btn-plain dropdown-toggle text-left squared results']")
    public WebElement resultPerPageDropdownProductPage;

    //Quantity field
    @FindBy(xpath = "//*[@name='quantity']")
    public WebElement productQuantityTextBoxField;

    //Hazardous warning pop-up - Add To Cart Button
    @FindBy(xpath = "//*[@id='modalContent']//button[text()='Add To Cart']")
    public WebElement addToCartButtonHazadous;

    @FindBy(xpath = "//*[@id='nutiTabelMain']")
    public WebElement productLabelMain_PDP;

    //Normal Add to Cart button
    @FindBy(xpath = "//*[@class='mjr-btn mjr-secondary add-to-cart' and @type='submit']")
    public WebElement addToCartButton;

    //Add To Card for Cake
    @FindBy(xpath = "//button[text()='Add To Cart']")
    public WebElement addToCartButtonForCake;

    /*------------Cart--------------------------------*/

    @FindBy(xpath = "//*[@id='info']")
    public WebElement tooltipque;

    //Checkout button disabled
    @FindBy(xpath = "//*[@id='mcFooter']//button[contains (@class, 'disabled')]")
    public WebElement DISABLED_CHECKOUT_BUTTON;

    //Active order pickup time
    @FindBy(xpath = "//*[@id='js-curbside-display-msg']//*[@onclick='pickTimeSlot();']")
    public WebElement activeOrderPickupTimeDisplayCurbsideWidgetHP;

    //View Order Link
    @FindBy(xpath = "//*[@text()='View Order']")
    public WebElement viewOrderLinkCurbsideWidgetHP;

    //Edit Order Link
    @FindBy(xpath = "//*[@text()='Edit Order']")
    public WebElement editOrderLinkCurbsideWidgetHP;

    //CHOKING HAZARD WARNING ppopup header text
    @FindBy(xpath = "//*[@id='pgwModal']//*[@class='pm-title']")
    public WebElement chockingHazardWarningHeaderTextPopUp;

    //Mini Cart Title
    @FindBy(xpath = "//*[@id='cart2']/div[contains (@class, 'cartTitle')]")
    public WebElement miniCartTitle;

    //Creat a cake link under Shop menu
    @FindBy(xpath = "//*[text()='Create a Cake']")
    public WebElement createACakeLinkShopMenu;

    /*=======================Add Cake related Elements================================*/

    //Create this Cake Button
    @FindBy(xpath = "//button[text()='Create This Cake']")
    public WebElement CREATE_THIS_CAKE_BUTTON;

    /*-----------Size-----------------------*/

    //Size option
    @FindBy(xpath = "//*[@id='sidebar']/div/div/ul/li[1]//*[@class='cake-sidebar-group']/div[1]")
    public WebElement sizeOptionbarcake;

    /*-----------Flavor-----------------------*/

    //Flavor option
    @FindBy(xpath = "//*[@id='sidebar']/div/div/ul/li[2]//*[@class='cake-sidebar-group']/div[1]")
    public WebElement flavorOptionbarcake;

    /*-----------Icing-----------------------*/

    //Icing option
    @FindBy(xpath = "//*[@id='sidebar']/div/div/ul/li[3]//*[@class='cake-sidebar-group']/div[1]")
    public WebElement icingOptionbarcake;
    /*-----------Filling-----------------------*/

    //Filling option
    @FindBy(xpath = "//*[@id='sidebar']//*[text()='Filling']")
    public WebElement fillingOptionbarcake;

    /*-----------Border Color-----------------------*/

    //Border Color option
    @FindBy(xpath = "//*[@id='sidebar']/div/div/ul/li[5]//*[@class='cake-sidebar-group']/div[1]")
    public WebElement borderOptionbarcake;

    //Custom Message option
    @FindBy(xpath = "//*[@id='sidebar']//*[text()='Custom Message']")
    public WebElement custommsgOptionbarcake;


    /*-------------------------------Custom Message---------------------*/

    //Custom Message TextBox
    @FindBy(xpath = "//*[@id='sidebar']//*[@maxlength='50']")
    public WebElement custommsgTextBoxcake;

    //Custom Message option
    @FindBy(xpath = "//*[@id='sidebar']//*[text()='Add a photo']")
    public WebElement addaphotoOptionbarcake;


    /*-------------------------------Add a Photo---------------------*/

    //Image upload confirmation Accept button
    @FindBy(xpath = "//*[@class='btn btn-success btn-block btn-lg copyright-confirm']")
    public WebElement acceptButtonUploadImageConfirmationcake;

    //Text Field For Photo placement
    @FindBy(xpath = "//*[@id='photo-comments']")
    public WebElement addphotoCommentCake;

    //Special Instruction option list
    @FindBy(xpath = "//*[@id='sidebar']//span[text()='Special Instructions']")
    public WebElement specialInstrOptionbarcake;

    /*-------------------------------Special Instruction---------------------*/

    //Special Instruction Text Box
    @FindBy(xpath = "//*[@id='sidebar']//*[@maxlength='2000']")
    public WebElement specialInstrTextBoxcake;

    @FindBy(xpath = "//*[@name='emailAddress']")
    public WebElement email_field;

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement first_name;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement last_name;

    //cupcake cake option on LHS navigation
    @FindBy(xpath = "//*[@id='filter-Cupcake Cake']/div[1]/h4/a")
    public WebElement cupcakeCakeLHSnavigationCustomCake;

    /*--------------------End Custom cake options----------------------------------*/

    //Special Occasions option LHS Navigation
    @FindBy(xpath = "//*[@id='filter-Special Occasions']/div[1]/h4/a")
    public WebElement specialOccasionsLHSNavigation;

    //Special Occasions - Graduation Cake
    @FindBy(xpath = "//*[@id='filter-Special Occasions']//*[@id='filter-Graduation']/div[contains (@class, 'panel-heading')]/h4/a/span")
    public WebElement specialOccasionsGraduationLHSNavigation;

    //Store Locator - Michigan icon
    @FindBy(xpath = "//*[@id='Michigan']")
    public WebElement michiganOnMapStoreLocator;

    /*-------------------------MY List----------------------------------------------*/

    //Find a Store Header Text
    @FindBy(xpath = "//*[@id='find_store']/h1")
    public WebElement findaStoreHeaderTextStoreLocator;

    //2nd Page icon
    @FindBy(xpath = "//*[@id='Pagination']/a[contains (text(), 2)]")
    public WebElement secondPageIconStoreLocator;

    /*------------------------------Store Locator------------------------------------*/

    //Alpine Store - Make this my store button
    @FindBy(xpath = "//*[@id='storeDetailsFlyout20']//button[@class='btn btn-primary makeStore']")
    public WebElement alpineStoreMakeThisMyStoreButtonStoreLocator;

    /*----------------------------------Pickup Time will not saved confirmation message pop up window------------------*/

    //Use Current Location Button
    @FindBy(xpath = "//*[@id='useCurrentLocation']")
    public WebElement useCurrentLocationButton;

    /*----------- New pop up screen to select your location-------------*/

    //Sign In link
    @FindBy(xpath = "//*[@id='storePrefSignInLink']")
    public WebElement signInLinkSetLocationPopup;


    /*------------------Online Shopping menu-----------------------*/

    //Online shopping menu from header Menu
    @FindBy(xpath = "//li[contains(@class,'online')]")
    public WebElement ONLINE_SHOPPING_DROPDOWN;

    @FindBy(xpath = "//*[@id='online-nav-menu']/li[1]/a")
    public WebElement OPTION_1IN_ONLINE_SHOPPING_DROPDOWN;

    @FindBy(xpath = "//*[text()='Meijer Curbside']")
    public WebElement CURBSIDE_OPTION_ONLINE_SHOPPING_DROPDOWN;


    @FindBy(xpath = "//*[@id='online-nav-menu']/li[2]/a")
    public WebElement OPTION_2IN_ONLINE_SHOPPING_DROPDOWN;

    @FindBy(xpath = "//*[text()='Shipt Home Delivery']")
    public WebElement SHIPT_OPTION_ONLINE_SHOPPING_DROPDOWN;
    /*-------------------Services menu-----------------------------*/

    //Services option from Header Menu
    @FindBy(xpath = "//li[contains(@class,'services')]")
    public WebElement SERVICES_DROPDOWN;

    //3 option in the menu dropdown
    @FindBy(xpath = "//*[@id='services-nav-menu']/li[3]/a")
    public WebElement OPTION_3IN_SERVICES_DROPDOWN;

    //Curbside Option
    @FindBy(xpath = "//*[text()='Curbside']")
    public WebElement curbsideoptionServiceDropdown;

    /*-------------------Services menu-----------------------------*/

    @FindBy(xpath = "//*[@id='cityStateZip']")
    public WebElement cityStateZipField;

    @FindBy(xpath = "//button[@class='mjr-btn mjr-secondary short findStores']")
    public WebElement findStoresButton;

    /*-----------Excel Import Trial----------------*/

    //siva
    @FindBy(xpath = "//*[@id='product-ingredients']/p")
    public WebElement HWIngredient;

    @FindBy(xpath = "//*[@id='product-warnings']/p")
    public WebElement HWWarnings;

    /*---------------------------PDP Functionalities---------------------------*/

    @FindBy(xpath = "//*[@class='modalInner']")
    public WebElement addingItemWarningModal;

    @FindBy(xpath = "//*[@id='addItemToCart']")
    public WebElement continueAddItemToCartButton;

    @FindBy(xpath = "//*[@id='leaveItemOut']")
    public WebElement leaveOutOfCartButton;

    @FindBy(xpath = "//*[@class='mjr-modal-copy']/p[1]")
    public WebElement getWarningMessageCopy;

    @FindBy(xpath = "//button[text()='Email Test']")
    public WebElement emailtest;

    @FindBy(xpath = "//*[@id='home']/div[4]/div")
    public WebElement emailform;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitemail;

    @FindBy(xpath = "//*[@id='home']/div[1]/div[5]/div")
    public WebElement verisuccess;

    @FindBy(xpath = "//*[@id='home']/div[1]/div[5]/div")
    public WebElement invalid;

    @FindBy(xpath = "//*[@id='home']/div[1]/div[5]/div")
    public WebElement blank;

    @FindBy(xpath = "//*[contains(@class,'detail-info')]")
    public WebElement PDP;

    @FindBy(xpath = "//input[contains(@class,'quantity')]")
    public WebElement QTY_INPUT_PDP;

    @FindBy(xpath = "//*[contains(@class,'plus')]")
    public WebElement PLUS_QTY_BUTTON;

    @FindBy(xpath = "//*[contains(@class,'details-extra')]//*[text()='Product Details']")
    public WebElement productDetailsTitle_PDP;

    @FindBy(xpath = "//*[@id='product']//*[@itemprop='description']")
    public WebElement productDetailsText_PDP;

    @FindBy(xpath = "//*[@id='add-product']//*[@class='select-store']/small")
    public WebElement selectANewStore_PDP;

    @FindBy(xpath = "//*[@id='add-product']//*[contains(@class, 'in-stock')]")
    public WebElement availableCopy_PDP;

    @FindBy(xpath = "//*[@id='pdp-actions']//button[@type='submit']")
    public WebElement ADD_TO_CART_BUTTON_PDP;

    @FindBy(xpath = "//*[@class='mjr-section-title-2']")
    public WebElement PRODUCT_NAME_PDP;

    @FindBy(xpath = "//*[@id='qty-stock-block']/span")
    public WebElement outOfStock_PDP;

    @FindBy(xpath = "//*[@id='newStore']")
    public WebElement YOUR_STORE_PDP;

    @FindBy(xpath = "//ul[@id='regulatory-claims']")
    public WebElement nutritionalAttributes_PDP;

    /*-----------Nutritional Information----------------*/

    @FindBy(xpath = "//*[@id='product-ingredients']")
    public WebElement productIngredients_PDP;

    @FindBy(xpath = "//*[@id='product-ingredients']/h3")
    public WebElement productIngredientsHeader_PDP;

    @FindBy(xpath = "//*[@id='product-warnings']")
    public WebElement productWarnings_PDP;

    @FindBy(xpath = "//*[@id='product-warnings']/h3")
    public WebElement productWarningsHeader_PDP;

    @FindBy(xpath = "//*[@id='product-disclaimer']/h3")
    public WebElement productDisclaimers_PDP;

    @FindBy(xpath = "//*[@id='product-supplement-disclaimer-copy']")
    public WebElement noncollapseLegalDisclaimer_PDP;

    @FindBy(xpath = "//*[@id='product-disclaimer-copy']")
    public WebElement collapseLegalDisclaimer_PDP;

    @FindBy(xpath = "//*[@id='product-disclaimer-more-link']")
    public WebElement showMoreDisclaimerButton_PDP;

    @FindBy(xpath = "//*[@id='product-nutrition-label']/h3")
    public WebElement nutritionalDetails_PDP;

    @FindBy(xpath = "//*[@id='calories']//*[@class='nut-val']")
    public WebElement caloriesTileVal_PDP;

    @FindBy(xpath = "//*[@id='calories']//*[@class='nut-label']")
    public WebElement caloriesTileLabel_PDP;

    @FindBy(xpath = "//*[@id='fat']//*[@class='nut-val']")
    public WebElement fatTileVal_PDP;

    @FindBy(xpath = "//*[@id='fat']//*[@class='nut-label']")
    public WebElement fatTileLabel_PDP;

    @FindBy(xpath = "//*[@id='carbs']//*[@class='nut-val']")
    public WebElement carbsTileVal_PDP;

    @FindBy(xpath = "//*[@id='carbs']//*[@class='nut-label']")
    public WebElement carbsTileLabel_PDP;

    @FindBy(xpath = "//*[@id='protein']//*[@class='nut-val']")
    public WebElement proteinTileVal_PDP;

    @FindBy(xpath = "//*[@id='protein']//*[@class='nut-label']")
    public WebElement proteinTileLabel_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelHead']")
    public WebElement nutritionalLabelHeader_PDP;

    @FindBy(xpath = "//*[@id='more-nutrition-info']/h3")
    public WebElement nutritionFactsHeading_PDP;

    @FindBy(xpath = "//*[@id='servingsPerContainer']/span")
    public WebElement servingsPerContainer_PDP;

    @FindBy(xpath = "//*[@id='servingsSize']//span[1]")
    public WebElement servingSize1_PDP;

    @FindBy(xpath = "//*[@id='servingsSize']//span[2]")
    public WebElement servingSize2_PDP;

    @FindBy(xpath = "//*[@id='label-calories']/td[2]")
    public WebElement calorieCount_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelHead']//tr[2]//td[@class='col-xs-8 nutri-normal-text']")
    public WebElement caloriesFromFatCount_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelMain']")
    public WebElement nutritionalLabelMain_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelVit-Min']")
    public WebElement nutritionalMicronutrients_PDP;

    @FindBy(xpath = "//*[@id='nutiTabelVit-Min']//td[@class='mjr-small']")
    public WebElement nutritionalLabelFooter_PDP;

    //Ways to Save mPerks Checkbox
    @FindBy(xpath = "//*[@id='left_waystosave_mPerks']")
    public WebElement mPerksLeft;

    //Ways to Save mPerks Checkbox
    @FindBy(xpath = "//*[@id='left_waystosave_Sale']")
    public WebElement saleLeft;

    //Ways to Save mPerks Checkbox
//    @FindBy(xpath = "//*[@id='topButton_waystosave_mPerks']")
    @FindBy(xpath = "//li[not(contains(@class,'hide'))]//*[@for='topButton_waystosave_mPerks']")
    public WebElement mPerksTop;

    //Ways to Save mPerks Checkbox
//    @FindBy(xpath = "//*[@id='topButton_waystosave_Sale']")
    @FindBy(xpath = "//li[not(contains(@class,'hide'))]//*[@for='topButton_waystosave_Sale']")
    public WebElement saleTop;

    //Ways to Save dropdown manu
    @FindBy(xpath = "//*[@id='top_waystosave']")
    public WebElement waysToSaveDropDown;

    //Your Store Page Display
    @FindBy(xpath = "//*[@class='store-info-container']")
    public WebElement yourStorePage;

    @FindBy(xpath = "//*[@id='breadcrumb-wrapper']")
    public WebElement breadcrumbs;

    @FindBy(xpath = "//*[@id='quickShop_favorited_controls']/a")
    public WebElement VIEW_ALL_FAVORITES;

    @FindBy(xpath = "//*[@class='favoritedItems']")
    public WebElement YOUR_FAVORITES;

    @FindBy(xpath = "//*[@class='mjr-page-title']")
    public WebElement categoryTitle;

    //Close Pickup Time Modal
    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement clickCancelInPickupTimeModal;

    @FindBy(xpath = "//*[text()='Update Pickup Time']")
    public WebElement updatePickupTimeButton;

    @FindBy(xpath = "//*[@class='prev-day']")
    public WebElement daySliderLeftArrow;

    @FindBy(xpath = "//*[@class='next-day']")
    public WebElement daySliderRightArrow;

    //First Day is selected in Pickup Time Modal by default
    @FindBy(xpath = "//*[@id='date-0']")
    public WebElement firstDayIsSelectedByDefault;

    //Reserve Pickup Time Button in Pickup Time Modal
    @FindBy(xpath = "//*[@class='buttonWrapInner']/button[2]")
    public WebElement reservePickupTimeButtonInPickupTimeModal;

    //Update Pickup Time Button in Pickup Time Modal
    @FindBy(xpath = "//*[@class='buttonWrapInner']/button[2]")
    public WebElement updatePickupTimeButtonInPickupTimeModal;

    //Quantity Field Error Message - "/EA"
    @FindBy(xpath = "//*[@class='error-message'][text()='Please enter increments of 1']")
    public WebElement productQtyErrorMessage_Eaches;

    //Quantity Field Error Message - "/LB"
    @FindBy(xpath = "//*[@class='error-message'][text()='Please enter increments of .25']")
    public WebElement productQtyErrorMessage_Weight;

    //To Validate 'Available at Your Store' copy for Alcohol product Availability on Product Tile
    @FindBy(xpath = "//*[@class='availability-message instore']")
    public WebElement availableAtYourStoreTile;

    //To Validate the number of items out of stock
    @FindBy(xpath = "//*[@class='availability-message unavailable']")
    public WebElement outOfStockTile;

    @FindBy(xpath = "//*//*[@id='left_PMM98t_SAMSUNG                                 ']")
    public WebElement SamsungBrandFilter;

    @FindBy(xpath = "//*[@class='sorting']//*[@class='icon-meijer_listview']")
    public WebElement LIST_VIEW_ICON;

    /*---------Eliminate Best Pricing (Weight Messaging)-----*/

    @FindBy(xpath = "//*[@class='prodDtlSalePrice']//*[@class='uom']")
    public WebElement PDPWeightPrice;

    @FindBy(xpath = "//*[@class='prod-price-sort']//*[@class='uom']")
    public WebElement WeightPrice;

    @FindBy(xpath = "//*[@class='mjr-disclaimers']/p")
    public WebElement PDPDisclaimer;

    @FindBy(xpath = "//*[@class='mjr-disclaimers']//*[@class='mjr-default mjr-small']")
    public WebElement MiniCartDisclaimer;

    @FindBy(xpath = "//*[@id='mjr-rightSidebar']/div/div[2]/div[2]/p")
    public WebElement CartDisclaimer;

    @FindBy(xpath = "//*[@class='mjr-disclaimers']/p")
    public WebElement CheckoutDisclaimer;

    @FindBy(xpath = "//*[@class='mjr-disclaimers']/p")
    public WebElement OrderViewDisclaimer;

    @FindBy(xpath = "//*[@class='mjr-disclaimers']/p")
    public WebElement EditOrderDisclaimer;


    /* --------------------- General Element -----------------------*/
    //Meijer Logo
    @FindBy(xpath = "//*[@id='logo']")
    public WebElement MEIJER_LOGO;

    // To get 'Your Store: ' value
    @FindBy(xpath = "//*[@id='js-storeNameMsg']")
    public WebElement YOUR_STORE_VALUE;

    @FindBy(xpath = "//div[@class='modal-header']//button[@class='close']")
    public WebElement SIGN_IN_MODAL_CLOSE;

    @FindBy(xpath = "//*[contains(@class,'pagination-panel')]")
    public WebElement PAGINATION;

    @FindBy(xpath = "//*[@id='nextEllipsis']")
    public WebElement NEXT_ELLIPSIS;

    // Page Loader
    @FindBy(xpath = "//*[contains(@class,'loader') and contains(@style,'block')]")
    public WebElement PAGE_LOADER;

    // "No Search Results Found"
    @FindBy(xpath = "//*[contains(text(),'SEARCH TIPS')]")
    public WebElement NO_SEARCH_RESULTS_FOUND;

//  ------------ Passive Store Dialog Elements ------------

    @FindBy(xpath = "//ul[@role='dialog']/li")
    public WebElement PASSIVE_STORE_DIALOG;

    // Keep Store button
    @FindBy(xpath = "//ul[@role='dialog']//button[@id='keepStoreButton']")
    public WebElement KEEP_STORE;

    //Wink Bar
    @FindBy(xpath = "//*[contains(@class,'success')]")
    public WebElement WINK_BAR;

    //Wink Bar Message
    @FindBy(xpath = "//*[@class='message']")
    public WebElement WINK_BAR_MSG;

    /* ------------ Curbside Time Slot Widget Elements ------------ */


    // Guest user Time Slot Widget
    @FindBy(xpath = "//*[@id='quickshop' and not(contains(@class,'hide'))]")
    public WebElement GUEST_CURBSIDE_WIDGET;

    @FindBy(xpath = "//*[@id='quickshop' and not(contains(@class,'hide'))]")
    public WebElement SIGN_IN_CURBSIDE_WIDGET;

    @FindBy(xpath = "//*[@id='quickshop' and contains(@class,'hide')]")
    public WebElement NON_CURBSIDE_STORE;

    //Click Reserve Curbside Pickup Time
    @FindBy(xpath = "//*[text()='Reserve Curbside Pickup Time']")
    public WebElement RESERVE_CURBSIDE_PICKUP_TIME_LINK;

    //Pickup Time Modal
    @FindBy(xpath = "//*[@class='modalContent']//*[@id='pickupForm']")
    public WebElement TIME_SLOT_MODAL;

    /* ------------ Mini-Cart, Cart Icon Elements ------------ */

    //Cart Icon on meijer Home page
    @FindBy(xpath = "//i[@class='icon-meijer_cart']")
    public WebElement CART_ICON;

    //Cart Item count on Cart Icon Meijer Home Page
    @FindBy(xpath = "//*[@id='js-headerItemCount']")
    public WebElement CART_ICON_ITEM_COUNT;

    //Item Count when Mini-Cart is Opened "Shopping Cart (x)"
    @FindBy(xpath = "//*[@id='js-headerItemCount2']")
    public WebElement MINI_CART_ITEM_COUNT;

    @FindBy(xpath = "//div[@id='cartOverlay']")
    public WebElement CART_OVER_LAY;

    @FindBy(xpath = "//*[@id='mcFooter']//button[text()='Checkout']")
    public WebElement MINI_CART_CHECKOUT_BUTTON;

    @FindBy(xpath = "//*[@ui-view='mainContent']")
    public WebElement TIER_RESULTS;

    //Search Product text box field
    @FindBy(xpath = "//*[@id='nav_search']")
    public WebElement SEARCH_PRODUCTS_TEXTBOX;

    //Search product submit icon (magnifying glass)
    @FindBy(xpath = "//*[@id='search-form']//*[@id='nav_search_submit']")
    public WebElement SEARCH_BAR_ICON;

    /* ------------ Store Conflict Modal -------*/

    @FindBy(xpath = "//*[@class='modalInner']")
    public WebElement STORE_CONFLICT_MODAL;

    @FindBy(xpath = "//button[text()='Keep Current Store']")
    public WebElement STORE_CONFLICT_KEEP_STORE_BUTTON;

    @FindBy(xpath = "//button[text()='Continue, Change Store']")
    public WebElement STORE_CONFLICT_CHANGE_STORE_BUTTON;


    OrderPickupPage orderPickupPage = new OrderPickupPage();
    utilityhelper UtilityHelper;
    LaunchPage launchPage;

    /*=====================================-------------------Home Page Action ----------------------================================================================*/

    private static int getRandomNumber(int min, int max) {
        if (min > max) {
            System.out.println("Incorrect number range defined!!!");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    //JoeG 11-23-16
    public Boolean isMiniCartOpen() {
        return UtilityHelper.elementExists(CART_OVER_LAY);
    }

    public void userClosesMiniCart() {
        if (isMiniCartOpen()) {
            UtilityHelper.click(CART_OVER_LAY);
            UtilityHelper.waitUntilElementNotVisible(CART_OVER_LAY);
        }
        UtilityHelper.waitUntilClickable(CART_ICON);
    }

    public void chooseDifferentStoreFromAnAlreadyOpenStoreModal() throws InterruptedException {
        String storeName = UtilityHelper.elementGetText(YOUR_STORE_VALUE);
        //search for the desired store in the default list of stores before bothering to search for a zipcode
        List<WebElement> storeNames = getDriver().findElements(By.xpath("//*[@class='storeName']"));
        for (WebElement name : storeNames) {
            if (!name.getText().equals(storeName)) {
                UtilityHelper.moveToViewElement(name);
                name.click();
                System.out.println("=== STORE [" + name.getText() + "]");
                selectThisStoreButtonStoreLocationMeijerHP.click();
                UtilityHelper.waitUntilElementNotVisible(By.xpath("//*[@class='pm-container' or @id='pgwModalBackdrop']"));
                return;
            }
        }
    }

    //Created By: 107793 11/20/16
    public void moveToViewAndOpenMiniCart() {
        UtilityHelper.moveToViewElement(CART_ICON_ITEM_COUNT);
        UtilityHelper.waitUntilClickable(CART_ICON_ITEM_COUNT);
        //Determine Rather Mini-Cart is Opened or Not.
        if (!isMiniCartOpen()) { //id='cartOverlay' indicates the mini-cart is Opened if != 0
            UtilityHelper.click(CART_ICON_ITEM_COUNT);
            verifyMiniCartHasLoaded();
            if (!UtilityHelper.elementGetText(MINI_CART_ITEM_COUNT).equals("0")) {
                //stale element reference. Changed to in-line xpath
                UtilityHelper.waitUntilClickable(MINI_CART_CHECKOUT_BUTTON); //"checkoutCart" will NOT be clickable IF getText().equals("0")
            }
        }
    }

    public void moveToViewMiniCartIcon() {
        UtilityHelper.moveToViewElement(CART_ICON);
    }

    //Mini Cart Reset Shopping Cart Item Count
    //Created By: 107793 11/19/16
    public void resetMiniCartTo0Items() {
        if (!isMiniCartOpen()) {
            UtilityHelper.click(CART_ICON);
            verifyMiniCartHasLoaded();
        }
        if (!UtilityHelper.elementGetText(MINI_CART_ITEM_COUNT).equals("0")) {
            List<WebElement> itemsToRemove = getDriver().findElements(By.xpath("//*[contains(@id,'productGroup_')]/li"));
            for (WebElement item : itemsToRemove) {
                UtilityHelper.waitUntilClickable(MINI_CART_CHECKOUT_BUTTON);
                WebElement removeButton = item.findElement(By.xpath(".//a[text()='Remove']"));
                UtilityHelper.moveToViewElement(removeButton);
                UtilityHelper.click(removeButton);
            }
            System.out.println("[" + itemsToRemove.size() + "] Items Removed");
        }
        namesOfItemList.clear(); // To empty ArrayList of Added Items
    }

    public void verifyMiniCartHasLoaded() {
        try {
            int limit = 3, counter = 0;
            if (UtilityHelper.elementNotExists(MINI_CART_CHECKOUT_BUTTON)) {
                while (UtilityHelper.elementNotExists(MINI_CART_CHECKOUT_BUTTON)) {
                    Thread.sleep(5000);
                    if (limit == counter) {
                        Assert.fail("Mini-cart failed to load after [" + (limit * 5) + "] seconds...");
                    }
                    counter++;
                }
            }
            Assert.assertEquals("Verify Mini-Cart Has Loaded: ", true, UtilityHelper.isDisplayed(MINI_CART_CHECKOUT_BUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //To Remove Desired fGroup Item(s) From Mini-Cart
    //Created By: 107793 11/19/16
    public void removeAllDesiresFulfillmentType_MiniCart(String fGroup) {
        String fGroupType = miniCartFulfillmentGroupReturnSwitch(fGroup);
        List<WebElement> fGroupToRemove = getDriver().findElements(By.xpath("//*[contains(@id, 'productGroup_" + fGroupType + "')]//a[text()='Remove']"));
        if (fGroupToRemove.size() == 0) {
            System.out.println("Fulfillment Group [" + fGroupType + "] Does Not Exist In Mini-Cart");
        } else {
            for (WebElement item : fGroupToRemove) {
                UtilityHelper.waitUntilClickable(MINI_CART_CHECKOUT_BUTTON);
                item.findElement(By.xpath("//*[contains(@id,'productGroup_" + fGroupType + "')]//a[text()='Remove']"));
                UtilityHelper.moveToViewElement(item);
                item.click();
            }
        }
    }

    private String miniCartFulfillmentGroupReturnSwitch(String fGroup) {
        String value = null;
        switch (fGroup.toUpperCase()) {
            case "CNC":
                value = "1";
                break;
            case "SPO":
                value = "2";
                break;
            case "STH":
                value = "8";
                break;
            case "ALL":
                value = ""; //Empty will remove ALL items
                break;
            default:
                System.out.println("=== ERROR === Not Acceptable [Fulfillment Group Type] Value");
                break;
        }
        return value;
    }

    public void highLightShopByCategory(String category) {
        WebElement shopByCategory = getDriver().findElement(By.xpath("//*[@id='cat-list']//a[contains(text(),'" + category + "')]"));
        UtilityHelper.moveToViewElement(shopByCategory);
        UtilityHelper.highLightElement(shopByCategory);

    }

    //To Click desired "Shop By Category" option in Search Results
    public void clickShopByCategory_SearchResults(String category) {
        WebElement shopByCategory = getDriver().findElement(By.xpath("//*[@id='cat-list']//a[contains(text(),'" + category + "')]"));
        UtilityHelper.moveToViewElement(shopByCategory);
        shopByCategory.click();
    }

    //To Verify "Shop By Category" option has loaded
    public void verifyShopByCategoryHasLoaded(String category) {
        WebElement desiredCategory = getDriver().findElement(By.xpath("//b[contains(text(),'" + category + "')]"));
        UtilityHelper.waitUntilElementVisible(desiredCategory);
    }

    //To Change "Results Per Page" to desired Value
    //Created By: 107793 11/21/16
    public void alterResultsPerPageCountTo(int perPage) {
        try {
            UtilityHelper.waitUntilClickable(resultPerPageDropdownProductPage);
            UtilityHelper.moveToViewElement(resultPerPageDropdownProductPage);
            resultPerPageDropdownProductPage.click();
            WebElement perPageInt = getDriver().findElement(By.xpath("//ul[@id='sort2']//a[contains(text(),'" + perPage + "')]"));
            UtilityHelper.waitUntilClickable(perPageInt);
            perPageInt.click();
            WebElement resultsRefresh = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul"));
            UtilityHelper.waitUntilElementVisible(resultsRefresh);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void moveToViewYourFavoritesViaQuickShopPage() {
        UtilityHelper.moveToViewElement(YOUR_FAVORITES);
    }

    public void userClicksViewAllOnYourFavorites() {
        UtilityHelper.moveToViewElement(VIEW_ALL_FAVORITES);
        UtilityHelper.waitUntilClickable(VIEW_ALL_FAVORITES);
        UtilityHelper.click(VIEW_ALL_FAVORITES);
    }

    public void userHoversOverTier(String tier1) throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        Actions move = new Actions(getDriver());
        WebElement tier1ame = getDriver().findElement(By.linkText(tier1));
        move.moveToElement(tier1ame).build().perform();
        Thread.sleep(1000);
    }

    //Generic Method to Navigate to Tier 1 Item
    public void navigateTo_GivenTier1Items_FromShopMenu(String tier1) throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        Actions move = new Actions(getDriver());
        WebElement tier1name = getDriver().findElement(By.linkText(tier1));
        move.moveToElement(tier1name).click().perform();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Generic Method to Navigate to Tier 2 Item
    public void navigateTo_GivenTier2Items_FromShopMenu(String tier1, String tier2) throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        Actions move = new Actions(getDriver());
        WebElement tier1name = getDriver().findElement(By.linkText(tier1));
        move.moveToElement(tier1name).build().perform();
        Thread.sleep(1000);
        WebElement tier2name = getDriver().findElement(By.linkText(tier2));
        move.moveToElement(tier2name).click().perform();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Generic Method to Navigate to Tier 3 Item
    public void navigateTo_GivenTier3Items_FromShopMenu(String tier1, String tier2, String tier3) throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        Actions move = new Actions(getDriver());
        WebElement tier1name = getDriver().findElement(By.linkText(tier1));
        move.moveToElement(tier1name).build().perform();
        Thread.sleep(1000);
        WebElement tier2name = getDriver().findElement(By.linkText(tier2));
        move.moveToElement(tier2name).build().perform();
        Thread.sleep(1000);
        WebElement tier3name = getDriver().findElement(By.linkText(tier3));
        move.moveToElement(tier3name).click().perform();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Generic Method to Navigate to Tier 4 Item
    public void navigateTo_GivenTier4Items_FromShopMenu(String tier1, String tier2, String tier3, String tier4) throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        Actions move = new Actions(getDriver());
        move.moveToElement(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        WebElement tier1name = getDriver().findElement(By.linkText(tier1));
        move.moveToElement(tier1name).build().perform();
        Thread.sleep(1000);
        WebElement tier2name = getDriver().findElement(By.linkText(tier2));
        move.moveToElement(tier2name).build().perform();
        Thread.sleep(1000);
        WebElement tier3name = getDriver().findElement(By.linkText(tier3));
        move.moveToElement(tier3name).build().perform();
        Thread.sleep(1000);
        WebElement tier4name = getDriver().findElement(By.linkText(tier4));
        move.moveToElement(tier4name).click().perform();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void searchItemInSearchField(String itemToSearch) {
        UtilityHelper.moveToViewElement(SEARCH_PRODUCTS_TEXTBOX);
        UtilityHelper.typeIntoElement(SEARCH_PRODUCTS_TEXTBOX, itemToSearch);
    }

    public void clickOnSearchIconToViewProducts() {
        UtilityHelper.click(SEARCH_BAR_ICON);
    }

    // if "No Search Results found.." continue to search for product. Max of 3 attempts
    public void verifySearchResultsDisplay() throws InterruptedException {
        int count = 0;
        if (UtilityHelper.elementExists(NO_SEARCH_RESULTS_FOUND)) {
            while (UtilityHelper.elementExists(NO_SEARCH_RESULTS_FOUND)) {
                UtilityHelper.click(SEARCH_BAR_ICON);
                Thread.sleep(3000);
                if (count > 2) {
                    Assert.fail("Search Results Service Call Failed to Populate.");
                }
                count++;
            }
        } else {
            UtilityHelper.waitUntilElementVisible(TIER_RESULTS); //to wait for expected search results.
        }
    }

    //JoeG 9-21-2016
    public void userSearchesForProductType(String productType) throws InterruptedException {
        String searchTerm = "";
        switch (productType.toLowerCase()) {
            case "cnc":
                searchTerm = "is_click_and_collect:true";
                break;

            case "sellable":
                searchTerm = "is_sellable:true";
                break;

            case "alcohol":
                searchTerm = "is_alcohol:true";
                break;

            case "tobacco":
                searchTerm = "is_tobacco:true";
                break;

            case "hazardous":
                searchTerm = "is_hazardous_material:true";
                break;

            case "spo":
                searchTerm = "is_prepared_item:true";
                break;

            case "sth":
                searchTerm = "is_ship_to_home:true";
                break;

            case "prepared item":
                searchTerm = "is_prepared_item:true";
                break;

            case "age restricted":
                searchTerm = "is_age_restricted:true";
                break;

            case "on sale":
                searchTerm = "ways_to_save:Sale";
                break;

            case "mperks":
                searchTerm = "ways_to_save:mPerks";
                break;

            case "hot item":
                searchTerm = "hot_item_flag:true";
                break;

            case "random weight":
                searchTerm = "is_random_weight:true";
                break;

            case "price less than map":
                searchTerm = "price_less_than_map:true";
                break;
//not flags
            case "not cnc":
                searchTerm = "is_click_and_collect:false";
                break;

            case "not sellable":
                searchTerm = "is_sellable:false";
                break;

            case "not alcohol":
                searchTerm = "is_alcohol:false";
                break;

            case "not tobacco":
                searchTerm = "is_tobacco:false";
                break;

            case "not hazardous":
                searchTerm = "is_hazardous_material:false";
                break;

            case "not spo":
                searchTerm = "is_prepared_item:false";
                break;

            case "not sth":
                searchTerm = "is_ship_to_home:false";
                break;

            case "not prepared item":
                searchTerm = "is_prepared_item:false";
                break;

            case "not age restricted":
                searchTerm = "is_age_restricted:false";
                break;

            case "not hot item":
                searchTerm = "hot_item_flag:false";
                break;

            case "not random weight":
                searchTerm = "is_random_weight:false";
                break;

            case "price greater than map":
                searchTerm = "price_less_than_map:false";
                break;

            default:
                searchTerm = productType;
                break;
        }
        System.out.println("=== SEARCHING [" + searchTerm + "]");
        searchItemInSearchField(searchTerm);
    }

    public void javaScriptExecuteCreationLog() {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        Object object = js.executeScript("return binder.vars.creationLog");
        ArrayList<String> objectArrayList;
        objectArrayList = (ArrayList<String>) object;
        for (Object aStr : objectArrayList) {
            System.out.println("String[] " + aStr);
        }
    }

    public void verifyProductPageIsSorted(String sortWhat, String sortBy) {
        String sortXpath;
        if (sortWhat.equals("name"))
            sortXpath = "//*[@class='mjr-product-name']//a";
        else
            sortXpath = "//input[@name='price']";

        List<String> productList = new ArrayList<>();
        List<String> unsortedProductList = new ArrayList<>();
        List<WebElement> products = getDriver().findElements(By.xpath(sortXpath));
//        <input name="price" type="hidden" value="0.5" autofillparam="ON">
        for (WebElement product : products) {
            if (sortWhat.equals("name")) {
                unsortedProductList.add(product.getText());
                productList.add(product.getText());
            } else {
                //TODO: need to get an actual unit price here. value here often does not mean unit price. So sort by price is broken until this gets rectified
                unsortedProductList.add(product.getAttribute("value"));
                productList.add(product.getAttribute("value"));
            }
        }
        Collections.sort(productList);

        if (sortBy.equals("[Z-A]"))
            Collections.reverse(productList);
        if (sortBy.equals("high to low"))
            Collections.reverse(productList);

        System.out.println("products: " + products + "\n");
        System.out.println("sorted: " + productList + "\n");
        System.out.println("unsorted: " + unsortedProductList + "\n");

        Assert.assertEquals("=== Assert product list is sorted properly: ", productList, unsortedProductList);
    }

    //To click on Cart Icon **AND Click** Checkout
    public void clickCartIconInHeaderAndClickViewCart() {
        UtilityHelper.moveToViewElement(CART_ICON_ITEM_COUNT);
        UtilityHelper.waitUntilClickable(CART_ICON_ITEM_COUNT);
        UtilityHelper.click(CART_ICON_ITEM_COUNT);
        setImplicitTimeout(6, TimeUnit.SECONDS);
        implicitTimoutMilliseconds();
        UtilityHelper.waitUntilClickable(MINI_CART_CHECKOUT_BUTTON);
        UtilityHelper.click(MINI_CART_CHECKOUT_BUTTON);
        setImplicitTimeout(5, TimeUnit.SECONDS);
        implicitTimoutMilliseconds();
    }

    public void userClicksCheckOutButtonViaMiniCart() {
        UtilityHelper.waitUntilClickable(MINI_CART_CHECKOUT_BUTTON);
        UtilityHelper.click(MINI_CART_CHECKOUT_BUTTON);

    }

    //===========siva=============

    public void clicktooltip_verify() {
        UtilityHelper.waitUntilClickable(tooltipque);
        tooltipque.click();
        WebElement tooltip_message = getDriver().findElement(By.xpath(".//*[@id='info_c']/p"));
        Assert.assertEquals("Prices shown today may differ at time of pickup due to weighted items and weekly ad pricing.", tooltip_message.getText());
        System.out.println("===Verified the tooltip message is Displayed===");
    }
    //===========siva============

    //To Open Mini-Cart
    public void userOpensMiniCart() {
        if (!isMiniCartOpen()) {
            UtilityHelper.moveToViewElement(CART_ICON);
            UtilityHelper.waitUntilClickable(CART_ICON);
            UtilityHelper.click(CART_ICON);
        }
    }

    public void clickSortByNameLowToHigh() {
        getDriver().findElement(By.xpath("//button[@id='sortDropDown']")).click();
        getDriver().findElement(By.xpath("//*[@id='alphabet_sort1']")).click();
        UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
    }

    public void clickSortByNameHighToLow() {
        getDriver().findElement(By.xpath("//button[@id='sortDropDown']")).click();
        getDriver().findElement(By.xpath("//*[@id='alphabet_sort2']")).click();
        UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
    }

    public void clickSortByPriceLowToHigh() {
        getDriver().findElement(By.xpath("//button[@id='sortDropDown']")).click();
        getDriver().findElement(By.xpath("//*[@id='low_to_high_sort']")).click();
        UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
    }

    public void clickSortByPriceHighToLow() {
        getDriver().findElement(By.xpath("//button[@id='sortDropDown']")).click();
        getDriver().findElement(By.xpath("//*[@id='high_to_low_sort']")).click();
        UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
    }

    public void validate_cartIconCount(String expCount) {
        UtilityHelper.waitUntilElementVisible(CART_ICON);
        Assert.assertEquals("validate_cartIconCount()", expCount, CART_ICON_ITEM_COUNT.getText());
    }

    public void clickXtoCloseSignInModal() {
        UtilityHelper.click(SIGN_IN_MODAL_CLOSE);
    }

    public void click_eemailtestbutton() {
        UtilityHelper.waitUntilClickable(emailtest);
        emailtest.click();

    }

    public void email_form() {
        UtilityHelper.waitUntilClickable(emailform);

    }

    public void ee_firstname(String efirstname) {
        UtilityHelper.waitUntilClickable(first_name);
        first_name.clear();
        first_name.sendKeys(efirstname);
    }

    public void e_lastname(String elastname) {
        UtilityHelper.waitUntilClickable(last_name);
        last_name.clear();
        last_name.sendKeys(elastname);
    }

    public void e_email(String eemail) {


        UtilityHelper.waitUntilClickable(email_field);
        email_field.clear();
        text_Comparison = eemail;
        email_field.sendKeys(text_Comparison);
        System.out.println("=== EMAIL [" + eemail + "]");


    }

    public void submitbutton() {
        UtilityHelper.waitUntilClickable(submitemail);
        submitemail.click();
    }

    public void verifysuccess() {


        if (verisuccess.getText().contains(Constants.emailtestsuccess.toUpperCase())) {
            System.out.println("Successfully submit the email");
        } else {
            System.out.println("Failed to submit the email");
        }

    }

    public void errorinvalid() {
        UtilityHelper.waitUntilClickable(invalid);

        if (verisuccess.getText().contains(Constants.emailtestfailure.toUpperCase())) {
            System.out.println("Invalid details are submitted");
        } else {
            System.out.println("Failed to submit the invalid email");
        }

    }

    public void errorblank() {
        UtilityHelper.waitUntilClickable(blank);
        if (verisuccess.getText().contains(Constants.emailtestfailure.toUpperCase())) {
            System.out.println("blank details are submitted");
        } else {
            System.out.println("Failed to submit the blank email");
        }
    }

    public void verifySSItokenExists() {
        Cookie ck = getDriver().manage().getCookieNamed("ssi_id");
        assertTrue("=== assert SSI cookie exists: ", ck != null);

        System.out.println("ssi-id Value: " + ck.getValue());
    }

    public void verifySSItokenDoesNotExist() {
        Cookie ck = getDriver().manage().getCookieNamed("ssi_id");
        assertTrue("=== assert SSI cookie does NOT exist: ", ck == null);
    }

    //Meijer Home Page is displayed for Guest User
    public void meijerHomePageDisplay() throws InterruptedException {
        int limit = 5, count = 0;
        if (UtilityHelper.elementNotExists(GUEST_CURBSIDE_WIDGET)) {
            Thread.sleep(5000);
            while (UtilityHelper.elementNotExists(GUEST_CURBSIDE_WIDGET)) {
                getDriver().navigate().refresh();
                Thread.sleep(2000);
                count++;
                if (limit < count) {
                    Assert.fail("Failed to Fully Load 'Time Slot Header Widget' after [" + (2 * count + 5) + "] seconds ...");
                }
            }
        }
        Assert.assertTrue("Verify Successful Page Load: ", UtilityHelper.isDisplayed(GUEST_CURBSIDE_WIDGET));
    }

    public String mapShippingNamesToMenuNames(String shippingName) {
        switch (shippingName) {
            case "Standard Shipping":
                shippingName = "GROUND";
                break;
            case "Expedited Shipping":
                shippingName = "2DAY";
                break;
            case "Express Shipping":
                shippingName = "NEXTDAY";
                break;
            default:
//                value not found, leaving value alone
                break;
        }

        return shippingName;
    }

    public String getGiftcardRate(String shippingType, String giftCardQuanitity) throws IOException, InterruptedException {
        File f = new File("./datasource/giftCardRates.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s = wb.getSheetAt(0);
        Iterator<Row> rows = s.iterator();
        Row row;

        shippingType = mapShippingNamesToMenuNames(shippingType);

        String s_type, s_lower, s_upper, s_amount;
        s_amount = "null";

        while (rows.hasNext()) {
            row = rows.next();
            s_type = row.getCell(3).getStringCellValue();
            s_lower = Double.toString(row.getCell(4).getNumericCellValue());
            s_upper = Double.toString(row.getCell(5).getNumericCellValue());
            s_amount = Double.toString(row.getCell(6).getNumericCellValue());


            if (!shippingType.equals(s_type))
                continue;

            if (Double.parseDouble(giftCardQuanitity) < Double.parseDouble(s_lower))
                return "check your data, something no good, result less than lower bounds. -JoeG";

            if (Double.parseDouble(giftCardQuanitity) > Double.parseDouble(s_upper))
                continue;

            return s_amount;
        }
        return s_amount;
    }

    //this checks rate and method on site, and check against table
    public void validateGiftCardRate(String priceORqty, String shippingMethod) throws IOException, InterruptedException {
        String shippingCharge = getDriver().findElement(By.xpath("//td[text()='Shipping']/following-sibling::td")).getText();

        Assert.assertEquals("Validate gift card rate: ", getGiftcardRate(shippingMethod, priceORqty), Double.toString(extractPrice(shippingCharge)));
    }

    public void validateZeroTaxesForGiftCardOnlyOrder() {
        String taxCharge = getDriver().findElement(By.xpath("//td[text()='Taxes']/following-sibling::td")).getText();

        Assert.assertEquals("Validate $0 taxes for gift card only order: ", taxCharge, "$0.00");
    }

    public void userPokesAtGiftCardRates() throws IOException, InterruptedException {
        int i;

        for (i = 14; i < 9500; i += 53)
            System.out.println("cost for " + Integer.toString(i) + " giftcards: " + getGiftcardRate("2DAY", Integer.toString(i)));


        Assert.assertTrue("bananas: ", i == 2);
    }

    //Meijer Home page is displayed successfully after login
    public void validateMeijerHomePageAfterLogInSuccessfully() throws InterruptedException {
        if (UtilityHelper.elementNotExists(SIGN_IN_CURBSIDE_WIDGET)) {
            Thread.sleep(5000);
            if (UtilityHelper.elementNotExists(SIGN_IN_CURBSIDE_WIDGET)) {
                getDriver().navigate().refresh();
                Thread.sleep(5000);
            }
        }
        UtilityHelper.waitUntilElementVisible(SIGN_IN_CURBSIDE_WIDGET);
    }

    //To verify user has no active order(s) placed
    public void validateUserHasNoActiveOrder() {
        if (UtilityHelper.elementNotExists(By.xpath("//*[contains(@class,'line1 mjr-small')]"))) {
            Assert.assertEquals("Verify Header Widget for Test Case : ", "No Active Orders", "User had an Active Order Placed");
        }
    }

    //Shopping Cart 0 item count validation
    public void shoppingCart0ItemCountvaldiation() {
        Assert.assertEquals("0", CART_ICON_ITEM_COUNT.getText());
    }

    //Validate Pickup Time Modal Displays
    public void pickupTimeModal_WithoutReservation() {
        UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        Assert.assertTrue("=== Verify Time Slot Modal Appears ", TIME_SLOT_MODAL.isDisplayed());
        Assert.assertTrue("=== Verify Default DAY isSelected() ", firstDayIsSelectedByDefault.isDisplayed());
        Assert.assertFalse("=== Verify 'Reserve Pickup Time' button NOT isEnabled() ", reservePickupTimeButtonInPickupTimeModal.isEnabled());
    }

    //Validate Pickup Time Modal - SPO
    public void pickupTimeModal_SPO_WithoutReservation() {
        UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        Assert.assertTrue("=== Verify Time Slot Modal Appears ", TIME_SLOT_MODAL.isDisplayed());
        Assert.assertTrue("=== Verify 'left arrow' slider ", daySliderLeftArrow.isDisplayed());
        Assert.assertTrue("=== Verify 'right arrow' slider ", daySliderRightArrow.isDisplayed());
        Assert.assertTrue("=== Verify Default DAY isSelected() ", firstDayIsSelectedByDefault.isDisplayed());
        Assert.assertFalse("=== Verify 'Reserve Pickup Time' button NOT isEnabled() ", reservePickupTimeButtonInPickupTimeModal.isEnabled());
    }

    //Validate Pickup Time Modal - Mixed Cart
    public void pickupTimeModal_MixedCart_WithoutReservation() {
        UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        Assert.assertTrue("=== Verify Time Slot Modal Appears ", TIME_SLOT_MODAL.isDisplayed());
        Assert.assertTrue("=== Verify Default DAY isSelected() ", firstDayIsSelectedByDefault.isDisplayed());
        Assert.assertFalse("=== Verify 'Reserve Pickup Time' button NOT isEnabled() ", reservePickupTimeButtonInPickupTimeModal.isEnabled());
    }

    public void validate_PickupTimeModal_WithReservation() {
        UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        Assert.assertTrue("=== Verify Time Slot Modal Appears ", TIME_SLOT_MODAL.isDisplayed());
        Assert.assertFalse("=== Verify 'Update Pickup Time' button NOT isEnabled() ", updatePickupTimeButtonInPickupTimeModal.isEnabled());
    }

    public void click_updatePickupTimeButton() throws InterruptedException {
        UtilityHelper.waitUntilClickable(updatePickupTimeButton);
        updatePickupTimeButton.click();
        Thread.sleep(5000);
    }

    public void closePickupTimeModal() {
        //UtilityHelper.waitUntilElementVisible(TIME_SLOT_MODAL);
        clickCancelInPickupTimeModal.click();
    }

    public void validateDATEDisplayUnderCurbsideWidgetViaHomePage() {
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().toUpperCase().contains(OrderPickupPage.pickupDate.toUpperCase()));
    }

    public void validateTIMEDisplayUnderCurbsideWidgetViaHomePage() {
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().toUpperCase().contains(OrderPickupPage.pickupTime.toUpperCase()));
    }

    //View Order Link Display under Curbside Widget Validation
    public void viewLinkDisplayCurbsideWidget() {
        Assert.assertTrue("View Order Text link isDisplayed() ===>> ", viewOrderLinkCurbsideWidgetHP.isDisplayed());
    }

    //Edit Order Link Display under Curbside Widget Validation
    public void editLinkDisplayCurbsideWidget() {
        Assert.assertTrue("Edit Order Text Link isDisplayed() ===>> ", editOrderLinkCurbsideWidgetHP.isDisplayed());
    }

    //Click on Edit Order Link on Curbside Widget
    public void clickEditOrderLink_curbsideWidget() {
        editOrderLinkCurbsideWidgetHP.click();
    }

    //Click on View Order Link on Curbside Widget
    public void clickViewOrderLink_curbsideWidget() {
        viewOrderLinkCurbsideWidgetHP.click();
    }

    //Click on Reserve Curbside Pickup Time on Curbside Widget
    public void userReserveCurbsidePickupTimeCurbsideWidget() {
        UtilityHelper.moveToViewElement(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
        UtilityHelper.waitUntilClickable(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
        UtilityHelper.click(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
    }

    public void validate_reservationDropped() {
        UtilityHelper.waitUntilElementVisible(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
        Assert.assertTrue(RESERVE_CURBSIDE_PICKUP_TIME_LINK.isDisplayed());
    }

    //Created By: 107793 12/27/16
    //To Validate Warning Message Not Displayed
    public void verify_ItemWarningMsgNotDisplayed() {
        Assert.assertTrue("=== Verify Time Slot Conflict Warning Message Not Displayed ",
                UtilityHelper.elementNotExists(By.xpath("//*[@class='modalInner']")));
        //same xpath as public WebElement 'addingItemWarningModal'
    }

    //Validate Adding SPO Warning Message While Slot is Reserved
    public void validate_ItemWarningMessage_SPO() {
        UtilityHelper.waitUntilElementVisible(addingItemWarningModal);
        Assert.assertTrue(UtilityHelper.isDisplayed(addingItemWarningModal));
        Assert.assertTrue(UtilityHelper.isDisplayed(continueAddItemToCartButton));
        Assert.assertTrue(UtilityHelper.isDisplayed(leaveOutOfCartButton));
        Assert.assertTrue("=== Adding SPO Conflict Copy ",
                UtilityHelper.elementGetText(getWarningMessageCopy).equals(Constants.addingSPOitemWarningMessageCopy));
    }

    public void validate_ItemWarningMessage_CNC() {
        UtilityHelper.waitUntilElementVisible(addingItemWarningModal);
        Assert.assertTrue(UtilityHelper.isDisplayed(addingItemWarningModal));
        Assert.assertTrue(UtilityHelper.isDisplayed(continueAddItemToCartButton));
        Assert.assertTrue(UtilityHelper.isDisplayed(leaveOutOfCartButton));
        Assert.assertTrue("=== Adding CNC Conflict COPY ",
                UtilityHelper.elementGetText(getWarningMessageCopy).equals(Constants.addingCurbsideItemWarningMessageCopy));
    }

    //To Click 'Leave Out of Cart' Button
    public void clickLeaveOutOfCartButton() {
        UtilityHelper.waitUntilClickable(leaveOutOfCartButton);
        UtilityHelper.click(leaveOutOfCartButton);
    }

    //To Click 'Continue, Add Item To Cart' Button
    public void clickContinueAddItemToCart() throws InterruptedException {
        UtilityHelper.waitUntilClickable(continueAddItemToCartButton);
        UtilityHelper.click(continueAddItemToCartButton);
    }

    //Created By: 107793 12/27/16
    //To Verify Item is added to Cart Via Slot Type Conflict Pop Up - Click "Continue, Add to Cart"
    public void cartUpdateViaSlotTypeConflictMsg_AddItem() {
        UtilityHelper.moveToViewElement(CART_ICON_ITEM_COUNT);
//        String currentCartCount = CART_ICON_ITEM_COUNT.getText();
//        String currentCartCount = "0"; //Hard Coded value for custom cake validating. 12/27/16
//        verifyAddedQtyViaCartIcon("1", currentCartCount);
    }

    //Created By: 107793 12/27/16
    //To Verify slot reservation is dropped Via Slot Type Conflict Pop Up - Click "Continue, Add to Cart"
    public void reservedTimeSlotIsDropped() {
        UtilityHelper.waitUntilElementVisible(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
        Assert.assertTrue("=== Verify Slot Reservation has dropped Due to Slot Type Conflicts ",
                UtilityHelper.isDisplayed(RESERVE_CURBSIDE_PICKUP_TIME_LINK));
    }

    public void verifylabelmain() {
        UtilityHelper.waitUntilElementVisible(productLabelMain_PDP);
        Assert.assertTrue("Product Label Main are displayed =====>> ", productLabelMain_PDP.isDisplayed());
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Eaches_LessThanOneValue(WebElement element) {
        WebElement prodqtyfield = element.findElement(By.xpath(".//*[@name='quantity']"));
        prodqtyfield.clear();
        prodqtyfield.sendKeys("0");
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product Tile /EA Error Message Display ", productQtyErrorMessage_Eaches.isDisplayed());
        Assert.assertEquals("Verify Product Tile /EA Error Message Copy ", productQtyErrorMessage_Eaches.getText(), "Please enter increments of 1");
        WebElement addToCartTile = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        String classValue = addToCartTile.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Tile Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Eaches_DecimalValue(WebElement element) {
        WebElement prodqtyfield = element.findElement(By.xpath(".//*[@name='quantity']"));
        prodqtyfield.clear();
        prodqtyfield.sendKeys(".25");
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product Tile /EA Error Message Display ", productQtyErrorMessage_Eaches.isDisplayed());
        Assert.assertEquals("Verify Product Tile /EA Error Message Copy ", productQtyErrorMessage_Eaches.getText(), "Please enter increments of 1");
        WebElement addToCartTile = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        String classValue = addToCartTile.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Tile Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Weight_LessThanOneValue(WebElement element) {
        WebElement prodqtyfield = element.findElement(By.xpath(".//*[@name='quantity']"));
        prodqtyfield.clear();
        prodqtyfield.sendKeys("0");
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product Tile /EA Error Message Display ", productQtyErrorMessage_Weight.isDisplayed());
        Assert.assertEquals("Verify Product Tile /EA Error Message Copy ", productQtyErrorMessage_Weight.getText(), "Please enter increments of .25");
        WebElement addToCartTile = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        String classValue = addToCartTile.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Tile Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Weight_DecimalValue(WebElement element) {
        WebElement prodqtyfield = element.findElement(By.xpath(".//*[@name='quantity']"));
        prodqtyfield.clear();
        prodqtyfield.sendKeys(".60");
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product Tile /EA Error Message Display ", productQtyErrorMessage_Weight.isDisplayed());
        Assert.assertEquals("Verify Product Tile /EA Error Message Copy ", productQtyErrorMessage_Weight.getText(), "Please enter increments of .25");
        WebElement addToCartTile = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        String classValue = addToCartTile.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Tile Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Default_PDP() {
        Assert.assertTrue("Verify Selected Product Name =====>> ", namesOfItemList.contains(PRODUCT_NAME_PDP.getText()));
        Assert.assertTrue("Verify Add to Cart button is Displayed", ADD_TO_CART_BUTTON_PDP.isDisplayed());
        String classValue = ADD_TO_CART_BUTTON_PDP.getAttribute("class");
        Assert.assertFalse("Verify Add to Cart Button is Active ", classValue.contains("disabled"));
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Eaches_LessThanOneValue_PDP() {
        UtilityHelper.moveToViewElement(PDP);
        QTY_INPUT_PDP.clear();
        QTY_INPUT_PDP.sendKeys("0");
        UtilityHelper.waitUntilElementVisible(productQtyErrorMessage_Eaches);
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product /EA Error Message Copy ", productQtyErrorMessage_Eaches.getText().contains("Please enter increments of 1"));
        Assert.assertTrue("Verify Add to Cart Button is Displayed ", ADD_TO_CART_BUTTON_PDP.isDisplayed());
        String classValue = ADD_TO_CART_BUTTON_PDP.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Eaches_DecimalValue_PDP() {
        UtilityHelper.moveToViewElement(PDP);
        QTY_INPUT_PDP.clear();
        QTY_INPUT_PDP.sendKeys(".50");
        UtilityHelper.waitUntilElementVisible(productQtyErrorMessage_Eaches);
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product /EA Error Message Copy ", productQtyErrorMessage_Eaches.getText().contains("Please enter increments of 1"));
        Assert.assertTrue("Verify Add to Cart Button is Displayed ", ADD_TO_CART_BUTTON_PDP.isDisplayed());
        String classValue = ADD_TO_CART_BUTTON_PDP.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Weight_LessThanOneValue_PDP() {
        UtilityHelper.moveToViewElement(PDP);
        QTY_INPUT_PDP.clear();
        QTY_INPUT_PDP.sendKeys("0");
        UtilityHelper.waitUntilElementVisible(productQtyErrorMessage_Weight);
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product /LB Error Message Copy ", productQtyErrorMessage_Weight.getText().contains("Please enter increments of .25"));
        Assert.assertTrue("Verify Add to Cart Button is Displayed ", ADD_TO_CART_BUTTON_PDP.isDisplayed());
        String classValue = ADD_TO_CART_BUTTON_PDP.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    //Created By: 107793 11/04/16
    public void errorMessage_Weight_DecimalValue_PDP() {
        UtilityHelper.moveToViewElement(PDP);
        QTY_INPUT_PDP.clear();
        QTY_INPUT_PDP.sendKeys(".80");
        UtilityHelper.waitUntilElementVisible(productQtyErrorMessage_Weight);
        setImplicitTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue("Verify Product /EA Error Message Copy ", productQtyErrorMessage_Weight.getText().contains("Please enter increments of .25"));
        Assert.assertTrue("Verify Add to Cart Button is Displayed ", ADD_TO_CART_BUTTON_PDP.isDisplayed());
        String classValue = ADD_TO_CART_BUTTON_PDP.getAttribute("class");
        Assert.assertTrue("Verify Add to Cart Button is NOT Active ", classValue.contains("disabled"));
        setImplicitTimeout(3, TimeUnit.SECONDS);
    }

    public void openAndselectAvailableItems(int noitem, String itemqty) throws InterruptedException {

        //Available items
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        System.out.println("=== total number of avaiable item to add to cart: " + noofitems.size());
        int j = 0;
        for (int i = 1; i <= noofitems.size(); i++) {
            int randval = getRandomNumber(1, noofitems.size());
            System.out.println("Random value of of i is ====> " + randval);
            try {
                Actions action = new Actions(getDriver());
                action.moveToElement(getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "][not (contains(@class, 'unavailable'))]"))).perform();
                WebElement productName = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "]//*[@class='mjr-product-name']//a"));
                System.out.println("ProductName : " + productName.getText());
                addNameToHomePageArrayList(productName.getText());
                //WebElement prodname = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li["+i+"]//*[@class='mjr-product-name']//a"));
                productName.click();
                UtilityHelper.waitUntilClickable(productQuantityTextBoxField);
                productQuantityTextBoxField.clear();
                productQuantityTextBoxField.sendKeys(itemqty);
                addToCartButton.click();
                //UtilityHelper.waitUntilClickable(itemAddedtoCartFlashNotification);
                Thread.sleep(8000);
                j = j + 1;
                System.out.println("=== The number of selected item is: " + j);
                if (j == noitem) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("=== Element not found");
            }
        }
    }

    //Created By: 108588 11/15/16
    public void verify_NutritionalAttributesDisplayed() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        Assert.assertTrue("Claims displayed =====>> ", nutritionalAttributes_PDP.isDisplayed());
    }

    //Created By: 108588 11/15/16
    public void verify_NutritionalAttributesNotDisplayed() {
        List<WebElement> AttributesList = getDriver().findElements(By.xpath("//*[@id='regulatory-claims']/li"));
        Assert.assertTrue(AttributesList.isEmpty());
    }

    //Created By: 108588 11/17/16
    public void verify_NoMoreThan12AttributesDisplayed() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        List<WebElement> AttributesList = getDriver().findElements(By.xpath("//*[@id='regulatory-claims']/li"));
        System.out.println("Number of items in list");
        System.out.println(AttributesList.size());
        System.out.println("-=====================Attributes List========================================-");
        WebElement product;
        for (int i = 0; i < AttributesList.size(); i++) {
            System.out.println("Element" + i);
            product = AttributesList.get(i);
            System.out.println(product.getText());
        }
        Assert.assertFalse(AttributesList.size() > 13);

    }

    public void verify_NutritionalAttributes(String... attributes) {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        List<WebElement> AttributesList = getDriver().findElements(By.xpath("//*[@id='regulatory-claims']/li"));

        Integer idx = 0;
        for (String attribute : attributes) {
            if (attribute.equals(""))
                continue;
            Assert.assertEquals(attribute, AttributesList.get(idx).getText());
            System.out.println("Attribute " + AttributesList.get(idx).getText());
            System.out.println("Attributes " + attribute);
            idx++;
        }
    }

    //Created By: 108588 11/15/16
    public void verify_ProductIngredientsDisplayed() {
        UtilityHelper.waitUntilElementVisible(productIngredients_PDP);
        Assert.assertTrue("Product Ingredients are displayed =====>> ", productIngredients_PDP.isDisplayed());
    }

    //Create By: 108588 11/16/16
    public void verify_IngredientsSectionHeader() {
        UtilityHelper.waitUntilElementVisible(productIngredientsHeader_PDP);
        Assert.assertTrue("Product Ingredients header is displayed =====>> ", productIngredientsHeader_PDP.isDisplayed());
    }

    //Created By: 108588 11/15/16
    public void verify_ProductIngredientsNotDisplayed() {
        List<WebElement> list = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.name("Ingredients"));
        Assert.assertTrue("Product Ingredients Section ======>>>> Not Present!", list.size() == 0);
    }

    //Created By: 108588 11/15/16
    public void verify_ProductWarningsDisplayed() {
        UtilityHelper.waitUntilElementVisible(productWarnings_PDP);
        Assert.assertTrue("Product Warnings are displayed =====>> ", productWarnings_PDP.isDisplayed());
    }

    //Create By: 108588 11/16/16
    public void verify_WarningsSectionHeader() {
        UtilityHelper.waitUntilElementVisible(productWarningsHeader_PDP);
        Assert.assertTrue("Product Warnings Header is displayed =====>> ", productWarningsHeader_PDP.isDisplayed());
    }

    //Created By: 108588 11/15/16
    public void verify_ProductWarningsNotDisplayed() {
        List<WebElement> list = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.name("Warnings"));
        Assert.assertTrue("Product Warnings Section ======>>>> Not Present!", list.size() == 0);
    }

    //Created By: 108588 12/1/16
    public void verify_CopyMatchesNoncollapseLegalDisclaimer2() {
        UtilityHelper.waitUntilElementVisible(noncollapseLegalDisclaimer_PDP);

        Assert.assertTrue(noncollapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementNonCollapseDisclaimer2));
    }

    public void user_ClicksShowMoreDisclaimer() {
        UtilityHelper.waitUntilElementVisible(showMoreDisclaimerButton_PDP);
        showMoreDisclaimerButton_PDP.click();
    }

    //Created By: 108588 12/1/16
    public void verify_CopyMatchesCollapseLegalDisclaimer2() {
        UtilityHelper.waitUntilElementVisible(collapseLegalDisclaimer_PDP);
        //TODO: look into disclaimer
        Assert.assertTrue("=== Disclaimer2part1", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementNonCollapseDisclaimer2));
        Assert.assertTrue("=== Disclaimer2part2", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer2part2));
        Assert.assertTrue("=== Disclaimer2part3", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer2part3));
        Assert.assertTrue("=== Disclaimer2part4", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer2part4));

    }

    //Created By: 108588 12/1/16
    public void verify_CopyMatchesNoncollapseLegalDisclaimer1() {

        UtilityHelper.waitUntilElementVisible(noncollapseLegalDisclaimer_PDP);

        Assert.assertTrue(noncollapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementNonCollapseDisclaimer2));
    }

    //Created By: 108588 12/1/16
    public void verify_CopyMatchesCollapseLegalDisclaimer1() {
        UtilityHelper.waitUntilElementVisible(collapseLegalDisclaimer_PDP);
        Assert.assertTrue("=== Disclaimer1part1", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer1part1));
        Assert.assertTrue("=== Disclaimer1part2", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer1part2));
        Assert.assertTrue("=== Disclaimer1part3", collapseLegalDisclaimer_PDP.getText().contains(Constants.vitaminAndSupplementCollapseDisclaimer1part3));
    }

    //Created By: 108588 12/1/16
    public void verify_HeaderHeadingDisplaysNutritionFacts() {
        UtilityHelper.waitUntilElementVisible(nutritionFactsHeading_PDP);
        Assert.assertEquals(nutritionFactsHeading_PDP.getText(), "Nutrition Facts");
    }

    public void verify_nutritiondetails() {
        UtilityHelper.waitUntilElementVisible(nutritionDetails_PDP);
        Assert.assertEquals(nutritionDetails_PDP.getText(), "Nutrition Details");
    }

    //Created By: 108588 12/1/16
    public void verify_ServingsPerContainerIsDisplayedAndReflectsCorrectData(String servingsPerContainer) {
        UtilityHelper.waitUntilElementVisible(servingsPerContainer_PDP);
        Assert.assertEquals(servingsPerContainer_PDP.getText().trim(), servingsPerContainer);
    }

    //Created By: 108588 12/1/16
    public void verify_ServingSizeIsDisplayedAndReflectsCorrectData(String servingSize1, String servingSize2) {
        UtilityHelper.waitUntilElementVisible(servingSize1_PDP);
        UtilityHelper.waitUntilElementVisible(servingSize2_PDP);
        Assert.assertEquals(servingSize1_PDP.getText(), servingSize1);
        Assert.assertEquals(servingSize2_PDP.getText().trim(), servingSize2);
    }

    //Created By: 108588 12/1/16
    public void verify_CalorieCountIsDisplayedAndReflectsCorrectData(String calorieCount) {
        UtilityHelper.waitUntilElementVisible(calorieCount_PDP);
        Assert.assertEquals(calorieCount_PDP.getText().trim(), calorieCount);
    }

    //Created By: 108588 12/1/16
    public void verify_CaloriesFromFatIsDisplayedAndReflectsCorrectData(String caloriesFromFat) {
        UtilityHelper.waitUntilElementVisible(caloriesFromFatCount_PDP);
        Assert.assertEquals(caloriesFromFatCount_PDP.getText().trim(), caloriesFromFat);
    }

    //Created By: 108588 12/7/16
    public void verify_DisplayOfNutriLabelMain() {
        UtilityHelper.waitUntilElementVisible(nutritionalLabelMain_PDP);
        Assert.assertTrue("Nutritional label Main is displayed =====>> ", nutritionalLabelMain_PDP.isDisplayed());
    }

    public void verify_staticfooter() {
        UtilityHelper.waitUntilElementVisible(StaticNutritionFooter);
        Assert.assertTrue("Nutritional StaticNutritionFooter is displayed =====>> ", StaticNutritionFooter.isDisplayed());
        String Expextedfooter = "*The % Daily Value tells you how much a nutrient in a serving of food contributes to a daily diet. 2,000 calories a day is used for general nutrition advice.";
        Assert.assertEquals(StaticNutritionFooter.getText(), Expextedfooter);
    }

    public void verify_nutritionheader() {
        UtilityHelper.waitUntilElementVisible(nutritionHeader_PDP);
        Assert.assertTrue("Nutritional header is displayed =====>> ", nutritionHeader_PDP.isDisplayed());
    }

    //Created By: 108588 12/7/16
    public void validate_NutritionLabelMainData(String... items) {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        List<WebElement> itemsList = getDriver().findElements(By.xpath("//*[@id='nutiTabelMain']/tbody/tr/td"));

        Integer idx = 0;
        for (String item : items) {
            if (item.equals(""))
                continue;
            Assert.assertEquals(item, itemsList.get(idx).getText().trim());
            System.out.println("Item " + itemsList.get(idx).getText().trim());
            System.out.println("Items " + item);
            idx++;
        }
    }

    //Created By: 108588 12/1/16
    public void validate_MandatoryMicronutrientsAreDisplayed() {
        UtilityHelper.waitUntilClickable(nutritionalMicronutrients_PDP);
        System.out.println(nutritionalMicronutrients_PDP.getText());
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Vitamin D"));
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Calcium"));
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Iron"));
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Potassium"));
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Vitamin A"));
        Assert.assertTrue(nutritionalMicronutrients_PDP.getText().contains("Vitamin C"));
    }

    //siva
    public void verifywayfinding_tier2_tier1() throws InterruptedException {


        List<WebElement> nooftier2 = getDriver().findElements(By.xpath(".//*[@id='tier-1_container-0']/li"));
        System.out.println("=== total number of avaiable tier2 for corresponding tier1: " + nooftier2.size());

        for (int i = 3; i <= nooftier2.size(); i++) {
            WebElement tiernam1 = getDriver().findElement(By.xpath(".//*[@id='tier-1_container-0']/li[" + i + "]"));
            String tier1name = tiernam1.getText();
            tiernam1.click();

            UtilityHelper.waitUntilElementVisible(wayfindingContainer);
            // Assert.assertTrue("Wayfinding tiles are displayed =====>> ", wayfindingContainer.isDisplayed());
            if (wayfindingContainer.isDisplayed()) {
                System.out.println("===Wayfinding is displayed" + tier1name);

            } else {
                System.out.println("====Wayfinding not displayed" + tier1name);
            }

            UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
            shopOptionMeijerHP.click();
            Thread.sleep(1000);
            Actions move = new Actions(getDriver());
            WebElement tiername = getDriver().findElement(By.linkText("Grocery"));
            move.moveToElement(tiername).build().perform();
            Thread.sleep(1000);

        }
    }

    //siva
    //TODO learn excel
    public void verify_ingredientswarnings_forallupc() throws IOException, InterruptedException {
        exceloutFile = new FileOutputStream(excelfileName);
        excelworkbook = new XSSFWorkbook();
        excelsheet = excelworkbook.createSheet(excelsheetName);
        Vector dataHolder = ExcelData_Input.read_Column_HWFile();
        for (int i = 4; i < dataHolder.size(); i += 3) {
            Vector cellHWVector = (Vector) dataHolder.elementAt(i);
            excelrow = excelsheet.createRow(i);
            for (int j = 0; j < cellHWVector.size(); j++) {
                excelcell = (XSSFCell) cellHWVector.elementAt(j);
                String stringCellValue = excelcell.toString();
                SEARCH_TEXTBOX.clear();
                SEARCH_TEXTBOX.sendKeys(stringCellValue);
                SEARCH_TEXTBOX.sendKeys(Keys.ENTER);
                Thread.sleep(2000);

                String actualurl = getDriver().getCurrentUrl();

                String excpextedurl = "https://uat-qa.meijer.com/catalog/search_command.cmd";

                if (actualurl == excpextedurl) {
                    break;
                }

                thumbnail.click();

                String actualIngredient = HWIngredient.getText();
                excelcell = (XSSFCell) cellHWVector.elementAt(j + 1);
                if (excelcell.toString() != "NULL") {
                    String stringCellValue1 = excelcell.toString();
                    if (stringCellValue1.equals(actualIngredient)) {
                        excelcell = excelrow.createCell(0);
                        excelcell.setCellValue(stringCellValue1);
                        excelcell = excelrow.createCell(1);
                        excelcell.setCellValue("Ingredient Matched");
                    } else {
                        excelcell = excelrow.createCell(0);
                        excelcell.setCellValue(stringCellValue1);
                        excelcell = excelrow.createCell(1);
                        excelcell.setCellValue("Ingredient Not Matched");
                    }

                    String actualWarnings = HWWarnings.getText();
                    excelcell = (XSSFCell) cellHWVector.elementAt(j + 2);
                    if (excelcell.toString() != "NULL") {
                        String stringCellValue2 = excelcell.toString();
                        if (stringCellValue2.equals(actualWarnings)) {
                            excelcell = excelrow.createCell(2);
                            excelcell.setCellValue(stringCellValue2);
                            excelcell = excelrow.createCell(3);
                            excelcell.setCellValue("Warnings Matched");
                        } else {
                            excelcell = excelrow.createCell(2);
                            excelcell.setCellValue(stringCellValue2);
                            excelcell = excelrow.createCell(3);
                            excelcell.setCellValue("Warnings Not Matched");
                        }
                    }
                } else {
                    String actualWarnings = HWWarnings.getText();
                    excelcell = (XSSFCell) cellHWVector.elementAt(j + 2);
                    if (excelcell.toString() != "NULL") {
                        String stringCellValue2 = excelcell.toString();
                        if (stringCellValue2.equals(actualWarnings)) {
                            excelcell = excelrow.createCell(2);
                            excelcell.setCellValue(stringCellValue2);
                            excelcell = excelrow.createCell(3);
                            excelcell.setCellValue("Warnings Matched");
                        } else {
                            excelcell = excelrow.createCell(2);
                            excelcell.setCellValue(stringCellValue2);
                            excelcell = excelrow.createCell(3);
                            excelcell.setCellValue("Warnings Not Matched");
                        }
                    }
                }

            }
        }
        excelworkbook.write(exceloutFile);
        exceloutFile.close();
    }

    public void verifywayfinding_tile() {
        UtilityHelper.waitUntilElementVisible(wayfindingContainer);
        Assert.assertTrue("Wayfinding tiles are displayed =====>> ", wayfindingContainer.isDisplayed());
    }

    public void OneItemBeforeAnotherItem(WebElement... items) {

        WebElement item2;
        int idx = 0;

        System.out.println("length of items: " + items.length + "\n");
        for (WebElement item : items) {
            System.out.println("Index: " + idx);

            if (idx + 1 >= items.length) {
                System.out.println("skipping remaining lines");
                continue;
            }

            item2 = items[idx + 1];
            System.out.println(item.getText());
            System.out.println(item2.getText());
            Point item1Point = item.getLocation();
            int ycorditem1 = item1Point.getY();
            System.out.println("1st Element's Position from top is " + ycorditem1);
            Point item2Point = item2.getLocation();
            int ycorditem2 = item2Point.getY();
            System.out.println("2nd Element's Position from top is " + ycorditem2);
            Assert.assertTrue("item1 above item2", ycorditem1 < ycorditem2);
            idx++;
        }
    }


    //Created By: 108588 11/17/16
    public void verifyNutritionalAttributesDisplayedBeforeIngredients() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        UtilityHelper.waitUntilElementVisible(productIngredients_PDP);
        OneItemBeforeAnotherItem(nutritionalAttributes_PDP, productIngredients_PDP);
    }

    //Created By: 108588 12/13/16
    public void verifyNutritionalAttributesDisplayedBeforeWarnings() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        UtilityHelper.waitUntilElementVisible(productWarnings_PDP);
        OneItemBeforeAnotherItem(nutritionalAttributes_PDP, productWarnings_PDP);
    }

    //Created by: 108558 12/13/16
    public void verifyNutritionalAttributesDisplayedBeforeDisclaimers() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        UtilityHelper.waitUntilElementVisible(productDisclaimers_PDP);
        OneItemBeforeAnotherItem(nutritionalAttributes_PDP, productDisclaimers_PDP);
    }

    //Created by: 108558 12/13/16
    public void verifyNutritionalAttributesDisplayedBeforeNutritionalDetails() {
        UtilityHelper.waitUntilElementVisible(nutritionalAttributes_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalDetails_PDP);
        OneItemBeforeAnotherItem(nutritionalAttributes_PDP, nutritionalDetails_PDP);
    }

    //Created By: 108588 11/17/16
    public void verifyProductIngredientsDisplayedBeforeWarnings() {
        UtilityHelper.waitUntilElementVisible(productIngredients_PDP);
        UtilityHelper.waitUntilElementVisible(productWarnings_PDP);
        OneItemBeforeAnotherItem(productIngredients_PDP, productWarnings_PDP);

    }

    //Created by: 108558 12/13/16
    public void verifyProductIngredientsDisplayedBeforeDisclaimers() {
        UtilityHelper.waitUntilElementVisible(productIngredients_PDP);
        UtilityHelper.waitUntilElementVisible(productDisclaimers_PDP);
        OneItemBeforeAnotherItem(productIngredients_PDP, productDisclaimers_PDP);
    }

    //Created by: 108558 12/13/16
    public void verifyProductIngredientsDisplayedBeforeNutritionDetails() {
        UtilityHelper.waitUntilElementVisible(productIngredients_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalDetails_PDP);
        OneItemBeforeAnotherItem(productIngredients_PDP, nutritionalDetails_PDP);
    }

    //Created By: 108588 12/13/16
    public void verifyProductWarningsDisplayedBeforeDisclaimers() {
        UtilityHelper.waitUntilElementVisible(productWarnings_PDP);
        UtilityHelper.waitUntilElementVisible(productDisclaimers_PDP);
        OneItemBeforeAnotherItem(productIngredients_PDP, productDisclaimers_PDP);
    }


    //Created By: 108588 11/28/16
    public void verifyProductWarningsDisplayedBeforeNutritionDetails() {
        UtilityHelper.waitUntilElementVisible(productWarnings_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalDetails_PDP);
        OneItemBeforeAnotherItem(productIngredients_PDP, productWarnings_PDP);
    }

    //Created by: 108558 12/5/16
    public void verifyDisclaimersDisplayedBeforeNutritionalDetails() {
        UtilityHelper.waitUntilElementVisible(productDisclaimers_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalDetails_PDP);
        OneItemBeforeAnotherItem(productDisclaimers_PDP, nutritionalDetails_PDP);
    }

    public void verifyNutritionalDetailsPanelDisplayedBeforeNutritionalLabelHeader() {
        UtilityHelper.waitUntilElementVisible(nutritionalDetails_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalLabelHeader_PDP);
        OneItemBeforeAnotherItem(nutritionalDetails_PDP, nutritionalLabelHeader_PDP);
    }

    //Created By: 108588 12/1/16
    public void verifyNutritionLabelHeaderDisplayedBeforeNutritionLabelMain() {
        UtilityHelper.waitUntilElementVisible(nutritionalLabelHeader_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalLabelMain_PDP);
        OneItemBeforeAnotherItem(nutritionalLabelHeader_PDP, nutritionalLabelMain_PDP);
    }

    public void verifyNutritionLabelMainDisplayedBeforeNutritionLabelMicronutrients() {
        UtilityHelper.waitUntilElementVisible(nutritionalLabelMain_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalMicronutrients_PDP);
        OneItemBeforeAnotherItem(nutritionalLabelMain_PDP, nutritionalMicronutrients_PDP);
    }

    public void verifyNutritionLabelMicronutrients() {
        UtilityHelper.waitUntilElementVisible(nutritionalMicronutrients_PDP);
        Assert.assertTrue("Nutrition micronutrition is displayed =====>> ", nutritionalMicronutrients_PDP.isDisplayed());

    }

    //Created By: 108588 12/1/16
    public void verifyNutritionLabelMicronutrientsDisplayedBeforeNutritionLabelFooter() {
        UtilityHelper.waitUntilElementVisible(nutritionalMicronutrients_PDP);
        UtilityHelper.waitUntilElementVisible(nutritionalLabelFooter_PDP);
        OneItemBeforeAnotherItem(nutritionalMicronutrients_PDP, nutritionalLabelFooter_PDP);
    }

    //Created By: 108588 12/1/16
    public void verify_TilesForCaloriesFatCarbsProtein() {
        UtilityHelper.waitUntilElementVisible(caloriesTileVal_PDP);
        Assert.assertTrue("Nutrition Detail Calories is displayed =====>> ", caloriesTileVal_PDP.isDisplayed());

        UtilityHelper.waitUntilElementVisible(fatTileVal_PDP);
        Assert.assertTrue("Nutrition Detail Fat is displayed =====>> ", fatTileVal_PDP.isDisplayed());

        UtilityHelper.waitUntilElementVisible(carbsTileVal_PDP);
        Assert.assertTrue("Nutrition Detail Carbs is displayed =====>> ", carbsTileVal_PDP.isDisplayed());

        UtilityHelper.waitUntilElementVisible(proteinTileVal_PDP);
        Assert.assertTrue("Nutrition Detail Protein is displayed =====>> ", proteinTileVal_PDP.isDisplayed());

    }

    //Created By: 108588 12/1/16
    public void validate_DataInEachTileIsCorrectData(String cal, String fat, String carbs, String protein) {
        UtilityHelper.waitUntilElementVisible(caloriesTileVal_PDP);
        UtilityHelper.waitUntilElementVisible(fatTileVal_PDP);
        UtilityHelper.waitUntilElementVisible(carbsTileVal_PDP);
        UtilityHelper.waitUntilElementVisible(proteinTileVal_PDP);

        Assert.assertEquals(caloriesTileVal_PDP.getText().trim(), cal);
        Assert.assertEquals(caloriesTileLabel_PDP.getText(), "Calories");
        Assert.assertEquals(fatTileVal_PDP.getText().trim(), fat);
        Assert.assertEquals(fatTileLabel_PDP.getText(), "Fat");
        Assert.assertEquals(carbsTileVal_PDP.getText().trim(), carbs);
        Assert.assertEquals(carbsTileLabel_PDP.getText(), "Carbs");
        Assert.assertEquals(proteinTileVal_PDP.getText().trim(), protein);
        Assert.assertEquals(proteinTileLabel_PDP.getText(), "Protein");
    }

    //Created By: 108588 12/1/16
    public void verify_NoNutritionalDataDisplayed() {
        Assert.assertFalse(PDP.getText().contains("Nutrition Facts"));
    }

    public void atRandomMoveToViewProduct(WebElement element) {
        String productName, fGroup;

        UtilityHelper.moveToViewElement(element);
        productName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='mjr-product-name']//a")));
        fGroup = element.findElement(By.xpath(".//*[@name='fulfillmentGroupTypeId']")).getAttribute("value");
        // To ensure product name is not duplicated in ArrayList 'namesOfItemList'
        ensureNoDuplicatesExistInArrayList(productName, fGroup);
        addNameToHomePageArrayList(productName);
        shoppingCartFulfillmentGroupArrayList.add(fGroup);
        System.out.println("NAME: [" + productName + "]");
        System.out.println("TYPE: [" + fGroup + "]");
    }

    public void clickOnProductToViewItsPDP(WebElement element) {
        verifyProductUnitOfMeasure(element);
        WebElement toView_PDP = element.findElement(By.xpath(".//*[@class='mjr-product-name']//a"));
        UtilityHelper.click(toView_PDP);
    }

    public void clickAddToCartViaPDP(String itemQty) {
        String currentCartCount = CART_ICON_ITEM_COUNT.getText();

        enterQtyOfItemViaPDP(itemQty);
        UtilityHelper.waitUntilClickable(ADD_TO_CART_BUTTON_PDP);
        UtilityHelper.click(ADD_TO_CART_BUTTON_PDP);

        verifyAddedQtyViaCartIcon(itemQty, currentCartCount);
    }

    private void enterQtyOfItemViaPDP(String itemQty) {
        // If Quantity is a decimal (LB). Clear and type desired quantity
        if (itemQty.contains(".")) {
            UtilityHelper.waitUntilClickable(QTY_INPUT_PDP);
            UtilityHelper.typeIntoElement(QTY_INPUT_PDP, itemQty);
        } else {
            // If itemQty > 1. click '+' qty button
            int desiredQty = Integer.valueOf(itemQty);
            if (desiredQty != 1) {
                for (int i = 1; i < desiredQty; i++) {
                    UtilityHelper.waitUntilClickable(PLUS_QTY_BUTTON);
                    UtilityHelper.click(PLUS_QTY_BUTTON);
                }
            }
        }
    }

    //Created By: 107793 10/24/16
    public void verify_productDetailPage() {
        UtilityHelper.waitUntilElementVisible(PDP);
        Assert.assertTrue("=== PDP is displayed ===>> ", PDP.isDisplayed());
    }

    //Created By: 107793 10/24/16
    public void verify_productDetailTitle() {
        UtilityHelper.waitUntilElementVisible(productDetailsTitle_PDP);
        Assert.assertEquals("=== PDP 'Product Details' Title is Displayed ===>> ", Constants.productDetailsTitle, productDetailsTitle_PDP.getText());
    }

    public void clickPlusQuantityStepperOnPdpPage() {
        WebElement plusButton = getDriver().findElement(By.xpath("//button[contains(@class, 'plus']"));
        plusButton.click();
    }

    public void clickMinusQuantityStepperOnPdpPage() {
        WebElement minusButton = getDriver().findElement(By.xpath("//button[contains(@class, 'minus']"));
        minusButton.click();
    }

    public void verifyValueInQuantityFieldOnPdpPageIsOne() {
        Double qtyValue = Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
        Assert.assertTrue("Assert value in quantity field on pdp page is 1", qtyValue.equals(1.0));
    }

    public void verifyTheQuantityInTheInputFieldOnPdpPageMatchesTheQuantityInTheWinkbar() {

        WebElement WE_winkBar = getDriver().findElement(By.xpath("//*[contains(@id, 'page-notification')]"));
        UtilityHelper.waitUntilClickable(WE_winkBar);

        String winkBarMessage = WE_winkBar.findElement(By.xpath(".//span[@class='message']")).getText();

        String qtyValue = getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value");
        Assert.assertEquals("verify input quantity matches winkbar count", qtyValue, winkBarMessage);
    }

    public void clickAddToCartButtonOnPdpPage() {
        UtilityHelper.waitUntilClickable(ADD_TO_CART_BUTTON_PDP);
        UtilityHelper.click(ADD_TO_CART_BUTTON_PDP);
    }

    public void verifyQtyStepperError() {
        String qtyStep;
        List<WebElement> errorMsg;
        qtyStep = getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("step");

        //strip leading zero
        if (qtyStep.substring(0, 1).equals("0"))
            qtyStep = qtyStep.substring(1);

        errorMsg = getDriver().findElements(By.xpath("//div[@class='error-message' and contains(text(), 'Please enter increments of " + qtyStep + "')]"));
        Assert.assertTrue("Assert pdp quantity stepper error is present: ", errorMsg.size() > 0);
    }

    public void verifyQuantityDoesNotGoBelowStepQuantity() {
        Double qtyValue, qtyStep;
        qtyValue = Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
        qtyStep = Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("step"));
        Assert.assertFalse("assert quantity field does not drop below step value", qtyValue < qtyStep);
    }

    public void verifyQuantityInQuantityFieldGoesUpBy1() {
        String isLB = getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("step");
        WebElement plusButton = getDriver().findElement(By.xpath("//button[contains(@class,'plus')]"));
        if (isLB.contains("0.")) { // if LB item
            Double delta = 0.0; // this is required for Assert with Doubles. Don't know why..
            Double currentQtyValue = Double.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            plusButton.click();
            Double updateQtyValue = Double.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            Assert.assertEquals("=== Verify PLUS quantity Stepper action: ", (currentQtyValue + .25), updateQtyValue, delta);
        } else { // any other type
            int currentQtyValue = Integer.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            plusButton.click();
            int updateQtyValue = Integer.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            Assert.assertEquals("=== Verify PLUS quantity Stepper action: ", (currentQtyValue + 1), updateQtyValue);
        }
    }

    public void verifyQuantityInQuantityFieldGoesDownBy1() {
        String isLB = getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("step");
        WebElement minusButton = getDriver().findElement(By.xpath("//button[contains(@class,'minus')]"));
        if (isLB.contains("0.")) { // if LB item
            Double delta = 0.0; // this is required for Assert with Doubles. Don't know why..
            Double currentQtyValue = Double.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            minusButton.click();
            Double updateQtyValue = Double.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            Assert.assertEquals("=== Verify PLUS quantity Stepper action: ", (currentQtyValue - .25), updateQtyValue, delta);
        } else { // any other type
            int currentQtyValue = Integer.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            minusButton.click();
            int updateQtyValue = Integer.valueOf(getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("value"));
            Assert.assertEquals("=== Verify PLUS quantity Stepper action: ", (currentQtyValue - 1), updateQtyValue);
        }
    }

    public void typeAmountIntoQuantityFieldOnPdpPage(String qty) {
        WebElement qtyField = getDriver().findElement(By.xpath("//input[@name='quantity']"));
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    public void verifyQuantityFieldDisplaysErrorsOnPdpPage() {
        String errorMessage;
        WebElement qtyField = getDriver().findElement(By.xpath("//input[@name='quantity']"));
        qtyField.clear();
        getDriver().findElement(By.xpath("//*[@id='newStore']")).click(); // to click off from QTY field
        UtilityHelper.waitUntilElementVisible(By.xpath("//*[@class='error-message']")); //To wait until Error Msg is displayed
        String isLB = getDriver().findElement(By.xpath("//input[@name='quantity']")).getAttribute("step");
        if (isLB.contains("0.")) { // if LB item
            errorMessage = getDriver().findElement(By.xpath("//*[@class='error-message']")).getText();
            Assert.assertEquals("=== Verify LB Error Message: ", Constants.qtyErrorMsg_LB, errorMessage);
        } else { // any other type
            errorMessage = getDriver().findElement(By.xpath("//*[@class='error-message']")).getText();
            Assert.assertEquals("=== Verify NON-LB Error Message: ", Constants.qtyErrorMsg_NONLB, errorMessage);
        }
        Assert.assertTrue("=== Verify Error Message IS displayed: ", getDriver().findElement(By.xpath("//*[@class='error-message']")).isDisplayed());
        String addToCart = getDriver().findElement(By.xpath("//*[contains(@class,'add-to-cart')]")).getAttribute("class");
        Assert.assertTrue("=== Verify 'Add to Cart' is disabled: ", addToCart.contains("disabled"));
    }

    //Created By: 107793 10/27/16
    public void verifyProductDetailsInMetaDescription() {
        String metaDescription, detailsText;
        metaDescription = getDriver().findElement(By.xpath("html/head//*[@name='description']")).getAttribute("content");
        detailsText = productDetailsText_PDP.getText();
        if (detailsText.contains("<br>") || metaDescription.contains("  ")/* Double space */) {
            detailsText = detailsText.replace("<br>", "");
            metaDescription = metaDescription.replace("  ", " "); /* Single Space */
        }
        Assert.assertTrue("=== Verify Product Details in Meta Description ===>> ", metaDescription.contains(detailsText));
    }

    //Created By: 107793 10/17/16
    public void verifyH1Tags_ProductNamePDP() {
        List<WebElement> h1Tags = getDriver().findElements(By.xpath("//*[contains(@class,'detail-info')]/h1"));
        List<WebElement> productName = getDriver().findElements(By.xpath("//*[@class='mjr-section-title-2']"));
        Assert.assertEquals("=== Verify Product Name Count == H1 Tag Count ===>>", h1Tags.size(), productName.size());
        Assert.assertTrue("=== Verify Selected Product Name ===>> ", namesOfItemList.contains(PRODUCT_NAME_PDP.getText()));
    }

    //Created By: 107793 10/24/16
    public void verifyAltTags_ProductImagePDP() {
        List<WebElement> image = getDriver().findElements(By.xpath("//*[@id='product-image']/img"));
        List<WebElement> altTag = getDriver().findElements(By.xpath("//*[@id='product-image']/img[(contains(alt,''))]"));
        String imgAltTagValue = getDriver().findElement(By.xpath("//*[@id='product-image']/img")).getAttribute("alt");
        addNameToHomePageArrayList(imgAltTagValue);
        String prodName = PRODUCT_NAME_PDP.getText();
        if (prodName.contains(",") || prodName.contains("'")) {
            prodName = prodName.replace(",", "");
            prodName = prodName.replace("'", "");
        }
        Assert.assertEquals("=== Verify Product Image Count == Alt Image Count", image.size(), altTag.size());
        Assert.assertTrue("=== Verify Product Alt Value == Product Name ===>>", namesOfItemList.contains(prodName));
    }

    //Created By: 107793 10/17/16
    public void windowTabTitleOnPDP() {
        String expectedTitle = getDriver().getTitle();
        String actualTitle = PRODUCT_NAME_PDP.getText() + " | Meijer.com";
        if (actualTitle.contains(",") || actualTitle.contains("'")) {
            actualTitle = actualTitle.replace(",", "");
            actualTitle = actualTitle.replace("'", "");
        }
        Assert.assertTrue("=== Title on Window Tab == 'Product Name' | Meijer.com ", actualTitle.equals(expectedTitle));
    }

    //Created By: 107793 10/5/16
    public void verifyCopyRemoval_PDP() {
        System.out.println("[" + namesOfItemList + "]");
        System.out.println("[" + UtilityHelper.elementGetText(PRODUCT_NAME_PDP) + "]");
        Assert.assertTrue("=== Verify Selected Product Name ===>> ", namesOfItemList.contains(UtilityHelper.elementGetText(PRODUCT_NAME_PDP)));
        Assert.assertTrue("=== Removal of Copy 'Select a New Store' ===>> ", UtilityHelper.isDisplayed(availableCopy_PDP));
        Assert.assertTrue("=== Verify Your Store: '<value>' on PDP ===>> ",
                UtilityHelper.elementGetText(YOUR_STORE_PDP).contains(UtilityHelper.elementGetText(yourStoreNameMeijerHP)));
        Assert.assertTrue("=== Ability to Add to Cart Button ===>>> ", UtilityHelper.isDisplayed(ADD_TO_CART_BUTTON_PDP));
    }

    public void verifySeePriceInCartCopyOnPDP() {
        Assert.assertTrue("=== Verify Selected Product Name ===>> ", namesOfItemList.contains(UtilityHelper.elementGetText(PRODUCT_NAME_PDP)));
        Assert.assertTrue("=== Item In-Stock - E-Comm Flag is off ", UtilityHelper.elementGetText(availableCopy_PDP).contains(Constants.availableCopyOnPDP));
        Assert.assertTrue("=== Button Copy ===>> 'Available In-Store Only' ", UtilityHelper.elementGetText(ADD_TO_CART_BUTTON_PDP).contains(Constants.availableIn_StoreOnlyCopy));
        Assert.assertFalse("=== Add To Cart Button ===>> Disabled ", UtilityHelper.isEnabled(ADD_TO_CART_BUTTON_PDP));

        if (UtilityHelper.elementExists(NON_CURBSIDE_STORE)) {
            By inStore = By.xpath("//*[contains(text(), 'See price in-store')]");
            Assert.assertTrue("=== 'See price in-store' copy - Non Curbside", UtilityHelper.elementGetText(inStore).contains(Constants.priceLessThanMap_NonCurbside));
        } else {
            By inCart = By.xpath("//*[contains(text(), 'See price in cart')]");
            Assert.assertTrue("=== 'See price in cart' copy  - Curbside", UtilityHelper.elementGetText(inCart).contains(Constants.priceLessThanMap_Curbside));
        }

    }

    //Created By: 107793 10/5/16
    public void verifyCopy_eCommFlagOff() {
        Assert.assertTrue("=== Verify Selected Product Name ===>> ", namesOfItemList.contains(UtilityHelper.elementGetText(PRODUCT_NAME_PDP)));
        Assert.assertTrue("=== Item In-Stock - E-Comm Flag is off ", UtilityHelper.elementGetText(availableCopy_PDP).contains(Constants.availableCopyOnPDP));
        Assert.assertTrue("=== Button Copy ===>> 'Available In-Store Only' ", UtilityHelper.elementGetText(ADD_TO_CART_BUTTON_PDP).contains(Constants.availableIn_StoreOnlyCopy));
        Assert.assertFalse("=== Add To Cart Button ===>> Disabled ", UtilityHelper.isEnabled(ADD_TO_CART_BUTTON_PDP));
        Assert.assertTrue("=== Verify Your Store: '<value>' on PDP ===>> ",
                UtilityHelper.elementGetText(YOUR_STORE_PDP).contains(UtilityHelper.elementGetText(yourStoreNameMeijerHP)));
    }

    //Created By: 107793 10/6/16
    public void verify_AddToCartButtonRemoved_OutOfStockItem() {
        Assert.assertTrue("=== Verify Selected Product Name ===>> ", namesOfItemList.contains(UtilityHelper.elementGetText(PRODUCT_NAME_PDP)));
        Assert.assertTrue("=== Item ===>> Currently Out of Stock ", UtilityHelper.elementGetText(outOfStock_PDP).contains(Constants.currentlyOutOfStockCopyPDP));
        Assert.assertTrue("=== 'Select a New Store' Copy ===>> Enabled ", UtilityHelper.elementGetText(selectANewStore_PDP).contains(Constants.selectANewStorePDP));
        Assert.assertTrue("=== Verify Your Store: '<value>' on PDP ===>> ",
                UtilityHelper.elementGetText(YOUR_STORE_PDP).contains(UtilityHelper.elementGetText(yourStoreNameMeijerHP)));
    }

    //Created By: 107793 10/17/16
    public void h1TagOnCategoryName() {
        UtilityHelper.waitUntilElementVisible(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        String lastBreadcrumb = getDriver().findElement(By.xpath("//*[@id='breadcrumb-wrapper']/ol/li/span")).getText();
        Assert.assertTrue("=== Verifying Last Breadcrumb == Category Title Displayed", lastBreadcrumb.contains(categoryTitle.getText()));
    }

    //Created By: 10793 10/15/16
    public void h3Tags_ProductName() {
        List<WebElement> h3Tags = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li/div/div[2]/h3/a"));
        for (int i = 1; i < (h3Tags.size() + 1); i++) {
            String h3Tag = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]/div/div[2]/h3/a")).getText();
            if (h3Tag.contains(",") || h3Tag.contains("'")) {
                h3Tag = h3Tag.replace(",", "");
                h3Tag = h3Tag.replace("'", "");
            }
            addNameToHomePageArrayList(h3Tag);
        }
        List<WebElement> verifyH3 = getDriver().findElements(By.xpath("//*[@class='mjr-product-name']//a"));
        for (int i = 1; i < (verifyH3.size() + 1); i++) {
            String verifyH3Tag = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]/div/div[2]/h3/a")).getText();
            if (verifyH3Tag.contains(",") || verifyH3Tag.contains("'")) {
                verifyH3Tag = verifyH3Tag.replace(",", "");
                verifyH3Tag = verifyH3Tag.replace("'", "");
            }
            verifyItemList.add(verifyH3Tag);
        }
        Assert.assertEquals("=== Number of Tiles = Number of H3 Tags ===>> ", verifyH3.size(), h3Tags.size());
        Assert.assertTrue("=== Verifying h3 Tags on Class 'mjr-product-name' For Tier/Search Results ===>>", namesOfItemList.containsAll(verifyItemList));
    }

    //Created By: 107793 10/15/16
    public void altTags_ProductImage() {
        List<WebElement> imageAltTags = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        for (int i = 1; i < (imageAltTags.size() + 1); i++) {
            WebElement hasImage = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]/div/div[1]/a/img"));
            //assertTrue will println if False && give the product tile number if it is not displayed
            Assert.assertTrue("Verify Product Has Image is Displayed =====>> [" + i + "]", hasImage.isDisplayed());
            String altTagValue = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]/div/div[1]/a/img")).getAttribute("alt");
            addNameToHomePageArrayList(altTagValue);
        }
        List<WebElement> totalTiles = getDriver().findElements(By.xpath("//*[@class='mjr-product-name']//a"));
        for (int i = 1; i < (totalTiles.size() + 1); i++) {
            String verifyH3Tag = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]/div/div[2]/h3/a")).getText();
            if (verifyH3Tag.contains(",") || verifyH3Tag.contains("'")) {
                verifyH3Tag = verifyH3Tag.replace(",", "");
                verifyH3Tag = verifyH3Tag.replace("'", "");
            }
            verifyItemList.add(verifyH3Tag);
        }
        Assert.assertEquals("=== Number of Tiles = Number of H3 Tags ===>> ", totalTiles.size(), imageAltTags.size());
        Assert.assertTrue("=== Verifying Product Alt Tags Value MATCHES Product's Name For Tier/Search Results ===>>", namesOfItemList.containsAll(verifyItemList));
    }

    //Created By: 107793 10/24/16
    public void breadCrumbsValidate() {
        WebElement getClass;
        String urlPath, name;
        List<WebElement> breadcrumbs = getDriver().findElements(By.xpath("//*[@id='breadcrumb-wrapper']/ol[1]/li"));
        for (int i = 1; i < breadcrumbs.size(); i++) {
            getClass = getDriver().findElement(By.xpath("//*[@id='breadcrumb-wrapper']/ol[1]/li[" + i + "]/a"));
            Assert.assertTrue("Breadcrumbs Active Links ===>> [" + i + "]", getClass.getAttribute("class").contains("mjr-link"));
            if (i > 1) {
                urlPath = getClass.getAttribute("href");/* this will = "/t1/grocery...." */
                int tier = Integer.parseInt(urlPath.substring(24, 25)); /* Only want to obtain the number value, e.g. '1' */
                name = getClass.getText();
                if (name.contains("&") || name.contains(" ")) {
                    name = name.replace(" & ", "-");
                    name = name.replace(" ", "-");
                }
                Assert.assertTrue("=== Verifying Tier Name in Breadcrumb 'Href' ========>> [" + i + "}", urlPath.substring(23).toLowerCase().contains(name.toLowerCase()));
                Assert.assertTrue("=== Verifying Tier Numbering in Breadcrumb 'Href' ===>> [" + i + "]", (i - 1) == tier);
            }
        }
    }

    /*-------------------- Add Available Item Dependant on UoM Message - bag(s), ea, lb(s), pkg(s), bunch(s) ----------------------------------*/

    //To Verify Qty Added to Basket is Displayed Correctly via Wink Bar
    private void verifyWinkBarDisplayCorrectQty(String itemQty) {
        try {
            Thread.sleep(2000);

            if (!isModalDisplayed()) {

                System.out.println("INNER STEP: verifyWinkBarDisplayCorrectQty()");
                double itemQtyDouble, winkBarDouble;
                int itemQtyInt, winkBarInt;
                if (getIsAltUoM()) {  //To accommodate for '/LB' UoM items
                    if (getAltUoM_Type().contains("LB")) {
                        itemQty = "1";
                        double delta = 0.0; //required for Assert.assertEquals validation
                        itemQtyDouble = Double.valueOf(itemQty);
                        UtilityHelper.waitUntilElementVisible(WINK_BAR);
                        winkBarDouble = Double.valueOf(WINK_BAR_MSG.getText().substring(0, 2).trim());
                        Assert.assertEquals("=== Verify Wink Bar Double Value === ", itemQtyDouble, winkBarDouble, delta);
                    } else {
                        itemQtyInt = Integer.valueOf(itemQty);
                        UtilityHelper.waitUntilElementVisible(WINK_BAR);
                        winkBarInt = Integer.valueOf(WINK_BAR_MSG.getText().substring(0, 2).trim());
                        Assert.assertEquals("=== Verify Wink Bar Int Value: ", itemQtyInt, winkBarInt);
                    }
                } else {
                    itemQtyInt = Integer.valueOf(itemQty);
                    UtilityHelper.waitUntilElementVisible(WINK_BAR);
                    winkBarInt = Integer.valueOf(WINK_BAR_MSG.getText().substring(0, 2).trim());
                    Assert.assertEquals("=== Verify Wink Bar Int Value: ", itemQtyInt, winkBarInt);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Boolean isModalDisplayed() {
        String clazz = getDriver().findElement(By.xpath("//body")).getAttribute("class");
        return (clazz.contains("pgwModalOpen") || clazz.contains("mjr-modalBody"));
    }

    //To Verify Qty Added to Basket is Calculated at Cart Icon Correctly
    private void verifyAddedQtyViaCartIcon(String itemQty, String currentCartCount) {
        try {
            Thread.sleep(2000);

            if (!isModalDisplayed()) {
                String conditionalStr;
                int itemQtyInt, currentCountInt, updateCartCount;
                if (getIsAltUoM()) {  //To accommodate for '/LB' UoM items
                    if (getAltUoM_Type().contains("LB")) {
                        double itemQtyDouble, currentCountDouble, updateCartDouble;
                        itemQty = "1";
                        conditionalStr = String.valueOf((Double.valueOf(itemQty)) + (Double.valueOf(currentCartCount)));
                        UtilityHelper.waitUntilExpectedCondition(CART_ICON_ITEM_COUNT, conditionalStr.substring(0, 1));
                        double delta = 0.0; //required for Assert.assertEquals validation
                        itemQtyDouble = Double.valueOf(itemQty);
                        currentCountDouble = Double.valueOf(currentCartCount);
                        updateCartDouble = Double.valueOf(CART_ICON_ITEM_COUNT.getText());
                        Assert.assertEquals("Verify Item Qty is Calculated on Cart Icon Correctly: ", (currentCountDouble + itemQtyDouble), updateCartDouble, delta);
                    } else {
                        conditionalStr = String.valueOf((Integer.valueOf(itemQty)) + (Integer.valueOf(currentCartCount)));
                        UtilityHelper.waitUntilExpectedCondition(CART_ICON_ITEM_COUNT, conditionalStr);
                        itemQtyInt = Integer.valueOf(itemQty);
                        currentCountInt = Integer.valueOf(currentCartCount);
                        updateCartCount = Integer.valueOf(CART_ICON_ITEM_COUNT.getText());
                        Assert.assertEquals("Verify Item Qty is Calculated on Cart Icon Correctly: ", (currentCountInt + itemQtyInt), updateCartCount);
                    }
                } else {
                    conditionalStr = String.valueOf((Integer.valueOf(itemQty)) + (Integer.valueOf(currentCartCount)));
                    UtilityHelper.waitUntilExpectedCondition(CART_ICON_ITEM_COUNT, conditionalStr);
                    itemQtyInt = Integer.valueOf(itemQty);
                    currentCountInt = Integer.valueOf(currentCartCount);
                    updateCartCount = Integer.valueOf(CART_ICON_ITEM_COUNT.getText());
                    Assert.assertEquals("Verify Item Qty is Calculated on Cart Icon Correctly: ", (currentCountInt + itemQtyInt), updateCartCount);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //To Verify Qty Added to Basket is Calculated In Mini-Cart Correctly
    private void verifyQtyCountInMiniCart(String itemQty, String currentMiniCartCount) {
        double itemQtyDouble = 0.0, miniCartCountDouble = 0.0, updateMiniCartDouble = 0.0;
        int itemQtyInt = 0, miniCartCountInt = 0, updateMiniCartCount = 0;
        moveToViewAndOpenMiniCart();
        UtilityHelper.waitUntilElementVisible(MINI_CART_ITEM_COUNT);
        if (getIsAltUoM()) {  //To accommodate for '/LB' UoM
            if (getAltUoM_Type().contains("LB")) {
                itemQty = "1";
                double delta = 0.0; //required for Assert.assertEquals validation
                itemQtyDouble = Double.valueOf(itemQty);
                miniCartCountDouble = Double.valueOf(currentMiniCartCount);
                updateMiniCartDouble = Double.valueOf(MINI_CART_ITEM_COUNT.getText());
                Assert.assertEquals("=== Verify Item Qty is Calculated In Mini-Cart Correctly ", (miniCartCountDouble + itemQtyDouble), updateMiniCartDouble, delta);
            } else {
                itemQtyInt = Integer.valueOf(itemQty);
                miniCartCountInt = Integer.valueOf(currentMiniCartCount);
                updateMiniCartCount = Integer.valueOf(MINI_CART_ITEM_COUNT.getText());
                Assert.assertEquals("=== Verify Item Qty is Calculated In Mini-Cart Correctly ", (miniCartCountInt + itemQtyInt), updateMiniCartCount);
            }
        } else {
            itemQtyInt = Integer.valueOf(itemQty);
            miniCartCountInt = Integer.valueOf(currentMiniCartCount);
            updateMiniCartCount = Integer.valueOf(MINI_CART_ITEM_COUNT.getText());
            Assert.assertEquals("=== Verify Item Qty is Calculated In Mini-Cart Correctly ", (miniCartCountInt + itemQtyInt), updateMiniCartCount);
        }
        userClosesMiniCart();
    }

    public void attemptToAddChokingHazardItemToCart(WebElement element, String itemQty) {
        WebElement addToCart;
        String productName, fGroup;

        UtilityHelper.waitUntilClickable(element);
        // To determine products alt_UoM
        verifyProductUnitOfMeasure(element);
        // To fetch products name
        productName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='mjr-product-name']//a")));
        fGroup = UtilityHelper.elementGetAttribute(element.findElement(By.xpath(".//*[@name='fulfillmentGroupTypeId']")), "value");
        // To ensure product name is not duplicated in ArrayList 'namesOfItemList'
        ensureNoDuplicatesExistInArrayList(productName, fGroup);
        addNameToHomePageArrayList(productName);
        shoppingCartFulfillmentGroupArrayList.add(fGroup);
        // To enter desired Qty
        productTileQuantityStepperAction(element, itemQty);
        // To click Add to Cart
        addToCart = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        UtilityHelper.moveToViewElement(addToCart);
        UtilityHelper.click(addToCart);
        UtilityHelper.moveToViewElement(element);
    }

    public void atRandomViewProductAndAddToCart(WebElement element, String itemQty) {
        WebElement addToCart;
        String productName, fGroup, currentCartCount;

        UtilityHelper.waitUntilClickable(element);
        // To determine products alt_UoM
        verifyProductUnitOfMeasure(element);
        // To fetch products name
        productName = UtilityHelper.elementGetText(element.findElement(By.xpath(".//*[@class='mjr-product-name']//a")));
        fGroup = UtilityHelper.elementGetAttribute(element.findElement(By.xpath(".//*[@name='fulfillmentGroupTypeId']")), "value");
        // To ensure product name is not duplicated in ArrayList 'namesOfItemList'
        ensureNoDuplicatesExistInArrayList(productName, fGroup);
        // To enter desired Qty
        productTileQuantityStepperAction(element, itemQty);
        // To click Add to Cart
        addToCart = element.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        currentCartCount = CART_ICON_ITEM_COUNT.getText();
        UtilityHelper.moveToViewElement(addToCart);
        UtilityHelper.click(addToCart);
        System.out.println("NAME: [" + productName + "]");
        System.out.println(" QTY: [" + itemQty + "]");
        System.out.println("TYPE: [" + fGroup + "]");

        addNameToHomePageArrayList(productName);
        shoppingCartFulfillmentGroupArrayList.add(fGroup);
        UtilityHelper.moveToViewElement(element);
        verifyAddedQtyViaCartIcon(itemQty, currentCartCount);
    }


    // To click Quantity 'plus' button to desired quantity
    private void productTileQuantityStepperAction(WebElement element, String itemQty) {
        WebElement plusQtyButton, prodQtyField;
        prodQtyField = element.findElement(By.xpath(".//*[@name='quantity']"));
        plusQtyButton = element.findElement(By.xpath(".//input[contains(@class,'plus')]"));
        // If Quantity is a decimal (LB). Clear and type desired quantity
        if (itemQty.contains(".")) {
            UtilityHelper.moveToViewElement(prodQtyField);
            UtilityHelper.typeIntoElement(prodQtyField, itemQty);
        } else {
            // If qty > 1. click '+' qty button.
            int desiredQty = Integer.valueOf(itemQty);
            if (Integer.valueOf(itemQty) != 1) {
                for (int i = 1; i < desiredQty; i++) {
                    UtilityHelper.moveToViewElement(plusQtyButton);
                    UtilityHelper.waitUntilClickable(plusQtyButton);
                    UtilityHelper.click(plusQtyButton);
                }
            }
        }
    }

	/*--------------------Available Item add to cart ----------------------------------*/

    public void selectAvailableItems_WithMoreThan1QTY(int noitem, String itemqty) {
        //Available items
        WebElement addToCart, prodQtyField;
        String availability, productName, fGroup, currentCartCount;
        int counter = 0, randomVal;
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        System.out.println("=== Total Number of Products in Search Results: " + noofitems.size());
        UtilityHelper.shuffleList(1, noofitems.size());
        for (WebElement desiredItem : noofitems) {
            if (counter != noitem) {
                currentCartCount = CART_ICON_ITEM_COUNT.getText();
                randomVal = UtilityHelper.popShuffledList();
                desiredItem = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randomVal + "]"));
                UtilityHelper.waitUntilClickable(desiredItem);
                availability = desiredItem.getAttribute("class");
                if (availability.contains("unavailable") || availability.contains("instore")) { //To catch both 'out of stock' and 'in store only'
                    continue;
                }
                UtilityHelper.moveToViewElement(desiredItem);
                verifyProductUnitOfMeasure(desiredItem);
                addToCart = desiredItem.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
                prodQtyField = desiredItem.findElement(By.xpath(".//*[@name='quantity']"));
                prodQtyField.clear();
                prodQtyField.sendKeys(itemqty);
                productName = desiredItem.findElement(By.xpath(".//*[@class='mjr-product-name']//a")).getText();
                fGroup = desiredItem.findElement(By.xpath(".//*[@name='fulfillmentGroupTypeId']")).getAttribute("value");
                addNameToHomePageArrayList(productName);
                shoppingCartFulfillmentGroupArrayList.add(fGroup);
                addToCart.click();
                System.out.println("=== NAME: [" + productName + "]");
                System.out.println("===  QTY: [" + itemqty + "]");
                System.out.println("=== TYPE: [" + fGroup + "]");
//                verifyWinkBarDisplayCorrectQty(itemqty);
                verifyAddedQtyViaCartIcon(itemqty, currentCartCount);
                counter++;
            }
        }
    }

    private void verifyProductUnitOfMeasure(WebElement element) {
        WebElement UoM = element.findElement(By.xpath(".//p[@class='product-price']//span[@class='uom']"));
        setIsProductAltUoM(UtilityHelper.elementExists(UoM));
        if (getIsAltUoM()) { // if alt_UoM type IS found, capture value
            String value = UtilityHelper.elementGetText(UoM).toUpperCase();
            setAltUoM_Type(value);
        } else {
            setAltUoM_Type(""); // set as empty.
        }
    }

    //JoeG 9-21-2016
    public void addItemToCart(WebElement product, int qty) {
        Actions action = new Actions(getDriver());
        action.moveToElement(product).perform();
        String productName = product.findElement(By.xpath(".//*[@class='mjr-product-name']//a")).getText();
        addNameToHomePageArrayList(productName);
        WebElement inputButton = product.findElement(By.xpath(".//input[@name='quantity']"));
        UtilityHelper.waitUntilClickable(inputButton);
        if (qty > 1) {
            inputButton.clear();
            inputButton.sendKeys(Integer.toString(qty));
        }
        WebElement cartButton = product.findElement(By.xpath(".//*[contains(@class, 'addToCartButton')]"));
        UtilityHelper.waitUntilClickable(cartButton);
        cartButton.click();

        WebElement WE_winkBar = getDriver().findElement(By.xpath("//*[contains(@id, 'page-notification')]"));
        UtilityHelper.waitUntilClickable(WE_winkBar);

        String winkBarMessage = WE_winkBar.findElement(By.xpath(".//span[@class='message']")).getText();
        System.out.println("=== " + productName + ": " + winkBarMessage);
    }

    //JoeG 12-5-2016
    public WebElement addOneGiftCardToCart(int qty) {
        List<WebElement> products = getDriver().findElements(By.xpath("//li[contains(@class, 'thumbFlexChild') and (not (contains(@class, 'unavailable'))) and descendant::img[contains(@title, 'Meijer Gift Card - ')]]"));
        if (products.size() < qty) {
            System.out.println("=== Not enough products to add quantity to cart");
            return null;
        }
        addItemToCart(products.get(0), qty);
        return products.get(0);
    }

    public void verifyAddToCartDisabledOnPdp() {
        List<WebElement> addToCart = getDriver().findElements(By.xpath("//button[contains(text(), 'Add to Cart') and contains(@class, 'disabled')]"));
        Assert.assertTrue("Assert add to cart button is disabled on pdp page: ", addToCart.size() > 0);
    }

    //JoeG 12-5-2016
    public void addMultipleGiftCardsToCart(int qty) {
        //remember to go to next page if there are next pages and not enough products on one page
        List<WebElement> products = getDriver().findElements(By.xpath("//li[contains(@class, 'thumbFlexChild') and (not (contains(@class, 'unavailable'))) and descendant::img[contains(@title, 'Meijer Gift Card - ')]]"));
        Collections.shuffle(products);
        if (products.size() < qty) {
            System.out.println("=== Not enough products to add quantity to cart");
            return;
        }
        for (WebElement product : products) {
            if (products.indexOf(product) < (qty))
                addItemToCart(product, 1);
        }
    }

    //JoeG 9-21-2016
    public WebElement addOneProductToCart(int qty) {
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li[not (contains(@class, 'unavailable'))]"));
        if (products.size() < qty) {
            System.out.println("=== Not enough products to add quantity to cart");
            return null;
        }
        addItemToCart(products.get(0), qty);
        return products.get(0);
    }

    //JoeG 9-21-2016
    public void addMultipleProductsToCart(int qty) {
        //remember to go to next page if there are next pages and not enough products on one page
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li[not (contains(@class, 'unavailable'))]"));
        Collections.shuffle(products);
        if (products.size() < qty) {
            System.out.println("=== Not enough products to add quantity to cart");
            return;
        }
        for (WebElement product : products) {
            if (products.indexOf(product) < (qty))
                addItemToCart(product, 1);
        }
    }

    // Created By: 107793 9-22-2016
    private double extractPrice(String price) throws InvalidParameterException {
        Pattern patternPrice = Pattern.compile("(\\d{1,3}[.]\\d{2}]*)");
        Matcher matcher = patternPrice.matcher(price);
        if (!matcher.find())
            throw new InvalidParameterException(price + " is not a valid parameter.");
        String match = matcher.group();
        if (match.contains(" ")) {
            match = match.replace(" ", "");
        }
        if (match.contains(",")) {
            if (match.contains(".") || match.length() - match.replace(",", "").length() > 1) {
                match = match.replace(",", "");
            } else {
                match = match.replace(",", ".");
            }
        }
        return Double.parseDouble(match);
    }

    //JoeG 9-22-2016
    private double getProductPrice(WebElement product) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        decimal.setMaximumFractionDigits(2);

        String itemPrice = product.findElement(By.xpath(".//*[@class='product-price']")).getText();
        return extractPrice(itemPrice);
    }

    //JoeG 9-22-2016
    public void addItemsToCartUntilPriceIsMet(Double desiredTotal) {
        WebElement product;
        Double total = 0.00;
        while (total < desiredTotal) {
            product = addOneProductToCart(1);
            if (product == null) {
                System.out.println("=== Add Items until price is met: product is null.");
                return;
            }
            System.out.println("=== Price Before: " + total);
            total += getProductPrice(product);
            System.out.println("=== Price After: " + total);
        }
    }

    /*-------------------------------------To open Alcohol Item using Picture and add to Cart--------------------------------------------*/
    public void openAndselectAlcoholItems(String itemqty) throws InterruptedException {

        //Available items
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li[not (contains(@class, 'unavailable'))]"));
        System.out.println("=== total number of avaiable item to add to cart: " + noofitems.size());
        for (int i = 1; i < noofitems.size(); i++) {
            int randval = getRandomNumber(1, noofitems.size());
            System.out.println("=== Random value of of i is: " + randval);
            try {
                Actions action = new Actions(getDriver());
                action.moveToElement(getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "][not (contains(@class, 'unavailable'))]//*[@class='warning mjr_primary age-restricted']"))).perform();
                String ProdPrice = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "]//*[@class='product-price']/span")).getText();
                if (ProdPrice.contains("+ Deposit")) {
                    String productName = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "]//*[@class='mjr-product-name']//a")).getText();
                    System.out.println("ProductName : " + productName);
                    addNameToHomePageArrayList(productName);
                    WebElement prodImg = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + randval + "]//*[@class='thumb-image prod-title']/a/img"));
                    prodImg.click();
                    UtilityHelper.waitUntilClickable(addToCartButton);
                    productQuantityTextBoxField.clear();
                    productQuantityTextBoxField.sendKeys(itemqty);
                    addToCartButton.click();
                    Thread.sleep(8000);
                    break;
                }
            } catch (Exception e) {
                System.out.println("This item is Out of Stock!!!");
            }
        }
    }

/*-------------------------------------Identify Hazardous Item and Add to Cart--------------------------------------------*/

    public void identifyHazardousItemandAddtoCart(int noitem, String itemqty) throws InterruptedException {
        //Available items
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='tierResults']//*[@class='grid-view view ']/ul/li"));
        System.out.println("=== total number of item display: " + noofitems.size());
        int j = 0;
        if (noitem < noofitems.size()) {
            for (int i = 1; i <= noofitems.size(); i++) {
                try {
                    Actions action = new Actions(getDriver());
                    action.moveToElement(getDriver().findElement(By.xpath("//*[@id='tierResults']//*[@class='grid-view view ']/ul/li[" + i + "]"))).perform();
                    String HazdProd = getDriver().findElement(By.xpath("//*[@id='tierResults']//*[@class='grid-view view ']/ul/li[" + i + "][not (contains(@class, 'unavailable'))]//*[@class='warning mjr_primary has-warning']/span")).getText();
                    if (HazdProd.contains("Warning: Choking Hazard")) {
                        WebElement addtocart = getDriver().findElement(By.xpath("//*[@id='tierResults']//*[@class='grid-view view ']/ul/li[" + i + "]//*[@class='addToCartButton round_primary options-btn hazardAddToCart hazard']"));
                        WebElement prodqtyfield = getDriver().findElement(By.xpath("//*[@id='tierResults']//*[@class='grid-view view ']/ul/li[" + i + "]//*[@name='quantity']"));
                        prodqtyfield.clear();
                        prodqtyfield.sendKeys(itemqty);
                        String productName = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + i + "]//*[@class='mjr-product-name']//a")).getText();
                        System.out.println("ProductName : " + productName);
                        addNameToHomePageArrayList(productName);
                        addtocart.click();
                        //UtilityHelper.waitUntilClickable(itemAddedtoCartFlashNotification);
                        Thread.sleep(2000);
                        Assert.assertTrue(chockingHazardWarningHeaderTextPopUp.getText().contains(Constants.chokingHazardpopupheadertext));
                        addToCartButtonHazadous.click();
                        Thread.sleep(6000);
                        j = j + 1;
                        System.out.println("=== Total number of selected item is: " + j);
                        if (j == noitem) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("=== Item is NOT Hazardous Item!!!");
                }
            }
        } else {
            System.out.println("=== Desire item count is not present in this page!");
        }
    }

    public List<String> getNamesOfItemList() {
        Collections.sort(namesOfItemList);
        return namesOfItemList;
    }

    private void ensureNoDuplicatesExistInArrayList(String productName, String fGroup) {
        if ((namesOfItemList.contains(productName)) && !(fGroup.equals("2"))) {
            namesOfItemList.remove(productName);
        }
    }

    private void addNameToHomePageArrayList(String name) {
        // removing special character symbol for DEV and UAT
        // shopping cart and mini cart replaces these symbols with question mark (?)
        name = name.replace("®", "");
        name = name.replace("™", "");
        namesOfItemList.add(name);
    }
    public List<String> getShoppingCartFulfillmentGroupArrayList() {
        return shoppingCartFulfillmentGroupArrayList;
    }

    public List<String> getOrderByTimeAddedStringList() {
        Collections.sort(orderByTimeAddedStringList);
        return orderByTimeAddedStringList;
    }

    //Reverse the Order of List<String> namesOfItemList to match order displayed in Mini-Cart
    //Created By: 107793 11/17/16
    public void setOrderByTimeAddedStringList() {
        if (orderByTimeAddedStringList.isEmpty()) {
            for (int i = (namesOfItemList.size() - 1); i >= 0; i--) {
                orderByTimeAddedStringList.add(namesOfItemList.get(i));
            }
        }
    }

/*-------------------------------------- Product Tile Validation -----------------------------------*/

    public void validate_availabilityMessageInstore() {
        //'Available at Your Store' count
        List<WebElement> noofitems = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li[not (contains(@class, 'unavailable'))]"));
        System.out.println("=== total number of '" + availableAtYourStoreTile.getText() + "' items: " + noofitems.size());
        //'Out of Stock' count
        List<WebElement> noofitems2 = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li[(contains(@class, 'unavailable'))]"));
        System.out.println("=== Total number of '" + outOfStockTile.getText() + "' items: " + noofitems2.size());
        //Total Product Tiles count
        List<WebElement> noofitems3 = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        System.out.println("=== Total number of Product tiles on page: " + noofitems3.size());

        for (int i = 1; i < noofitems.size(); i++) {
            try {
                Actions action = new Actions(getDriver());
                action.moveToElement(getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[\"+i+\"]//*[@class='availability-message instore']"))).perform();
                //Assert.assertTrue(availableAtYourStore.isDisplayed());
                Assert.assertEquals("'" + availableAtYourStoreTile.getText() + "' Counting Error", noofitems.size(), (noofitems3.size() - noofitems2.size()));

            } catch (Exception e) {
                System.out.println("Element not found");
            }
        }
    }

    public void validate_thumbActions_notAvailable() {
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        System.out.println("=== Total number of viewable Product Tiles: " + list.size());
        List<WebElement> list2 = getDriver().findElements(By.className("mjr_grid"));
        System.out.println("=== Number of 'Add to Cart' items: " + list2.size());
        Assert.assertTrue("=== At Non-Curbside Store - Ability to Add to Cart ====>>> Not Available", list2.size() == 0);
    }

/*-------------------------------------- END Product Tile Validation -----------------------------------*/

    /*------------------------------ Cake ---------------------------------------*/
    //Create a cake link
    public void clickcreateacakeoption() throws InterruptedException {
        UtilityHelper.waitUntilClickable(shopOptionMeijerHP);
        shopOptionMeijerHP.click();
        Thread.sleep(1000);
        Actions move = new Actions(getDriver());
        move.moveToElement(createACakeLinkShopMenu).click().perform();
        setImplicitTimeout(5, TimeUnit.SECONDS);
    }

    //Cake Landing Page Display
    public void cakelandingpage() throws InterruptedException {
        Assert.assertEquals("Meijer.com | Create a Cake", getDriver().getTitle());
        Thread.sleep(3000);
    }

    //switch frame
    public void switchframeforcake() {
        getDriver().switchTo().frame(1);
    }

    //User click create a theme cake - unlicensed
    public void clickCreateACakeButton() {
        //getDriver().switchTo().frame(1);
        UtilityHelper.waitUntilClickable(CREATE_THIS_CAKE_BUTTON);
        List<WebElement> themecakeunlicensed = getDriver().findElements(By.xpath("//*[@class='grid-view']/ul/li"));
        System.out.println("=== Total number of avaiable Theme cake - unlicensed: " + themecakeunlicensed.size());

        for (int i = 1; i < themecakeunlicensed.size(); i++) {
            String productName = getDriver().findElement(By.xpath("//*[@class='grid-view']/ul/li[" + i + "]//*[@class='theme-title prod-title ng-binding']")).getText();
            System.out.println("ProductName : " + productName);
            addNameToHomePageArrayList(productName);
            CREATE_THIS_CAKE_BUTTON.click();
            break;
        }
    }

    //click on Size toggler
    public void clicksizebar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(sizeOptionbarcake);
        sizeOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Size Radio Button
    public void selectSizeRadioButton(int indexofsize) throws InterruptedException {
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[1]//*[@class='cake-radio-editor']/ul/li"));
        System.out.println("=== Number of Radio Buttons in Size: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(indexofsize).click();
            break;
        }
        System.out.println("=== User Selected Index Size: " + indexofsize);
        Thread.sleep(2000);
    }

    //click on Flavor toggler
    public void clickflavorbar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(flavorOptionbarcake);
        flavorOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Flavor radio button
    public void selectFlavorRadioButton(int indexofflavor) throws InterruptedException {
        setImplicitTimeout(5, TimeUnit.SECONDS);
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[2]//*[@class='cake-radio-editor']/ul/li"));
        System.out.println("=== Number of Radio Buttons in Flavor: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(indexofflavor).click();
            break;
        }
        System.out.println("=== User Selected Index Flavor: " + indexofflavor);
        Thread.sleep(2000);
    }

    //click on Icing toggler
    public void clickIcingbar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(icingOptionbarcake);
        icingOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Icing Frosting Type radio button
    public void selectIcingFrostingTypeRadioButton(int icingIdxFrostType) throws InterruptedException {
        setImplicitTimeout(5, TimeUnit.SECONDS);
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[3]//*[@class='cake-radio-editor']/ul/li"));
        System.out.println("=== Number of Radio Buttons in Frosting Type: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(icingIdxFrostType).click();
            break;
        }
        System.out.println("=== User Selected Index Frosting Type: " + icingIdxFrostType);
        Thread.sleep(2000);
    }

    //select Icing radio button
    public void selectIcingFrostingFlavorRadioButton(int icingIdxFrostFlvr) throws InterruptedException {
        try {
            List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[3]//*[@class='cake-color-editor']/ul/li"));
            System.out.println("=== Number of Radio Buttons in Frosting Flavor: " + radiobuttoncount.size());
            for (int i = 0; i < radiobuttoncount.size(); i++) {
                radiobuttoncount.get(icingIdxFrostFlvr).click();
                break;
            }
            System.out.println("===  User Selected Index Frosting Flavor: " + icingIdxFrostFlvr);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("=== Radio Button is not clickable");
        }
    }

    //click on Filling toggler
    public void clickFillingbar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(fillingOptionbarcake);
        fillingOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Filling radio button
    public void selectFillingRadioButtons(int idxfilling) throws InterruptedException {
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[4]//*[@class='cake-radio-editor']/ul/li"));
        System.out.println("=== Number of Radio Buttons in Filling: " + radiobuttoncount.size());
        radiobuttoncount.get(idxfilling).click();
        System.out.println("=== User Selected Index Filling: " + idxfilling);
        Thread.sleep(2000);
    }

    //click on Border Color Bar toggler
    public void clickBorderColorBar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(borderOptionbarcake);
        borderOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select TopBorderColor radio button
    public void selectTopBorderColorRadioButton(int idxtopbordrclr) throws InterruptedException {
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[5]//*[@class='editors']/div[1]/div/div/ul/li"));
        System.out.println("=== Number of Radio Buttons in Top Border Color: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(idxtopbordrclr).click();
            System.out.println("=== User Selected Index Top Border Color: " + idxtopbordrclr);
            break;
        }
        Thread.sleep(2000);
    }

    //select Bottom BorderColor radio button
    public void selectBottomBorderColorRadioButton(int idxbtmbordrclr) throws InterruptedException {
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[5]//*[@class='editors']/div[2]/div/div/ul/li"));
        System.out.println("=== Number of Radio Buttons in Bottom Border Color: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(idxbtmbordrclr).click();
            System.out.println("=== User Selected Index Bottom Border Color: " + idxbtmbordrclr);
            break;
        }
        Thread.sleep(2000);
    }

    //click on Custom Message Bar toggler
    public void clickCustomeMsgBar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(custommsgOptionbarcake);
        custommsgOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Custom Msg Text
    public void selectCustomMgsTextBox(String txtcustmsg) throws InterruptedException {
        custommsgTextBoxcake.sendKeys(txtcustmsg);
        Thread.sleep(1000);
    }

    //select Custom Msg Color Radio Button
    public void selectCustomMsgRadioButton(int idxcustmsgclr) throws InterruptedException {
        List<WebElement> radiobuttoncount = getDriver().findElements(By.xpath("//*[@id='sidebar']/div/div/ul/li[6]//*[@class='cake-color-editor']/ul/li"));
        System.out.println("=== Number of Radio Buttons in Custom Msg Color: " + radiobuttoncount.size());
        for (int i = 0; i < radiobuttoncount.size(); i++) {
            radiobuttoncount.get(idxcustmsgclr).click();
            System.out.println("=== User Selected Index Custom Msg Color: " + idxcustmsgclr);
            break;
        }
        Thread.sleep(2000);
    }

    //click on Add a Photo toggler Bar
    public void clickAddaPhotoBar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(addaphotoOptionbarcake);
        addaphotoOptionbarcake.click();
        Thread.sleep(2000);
    }

    //Add a Photo for cake
    public void upload_photo_forCake() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@class='select-photo-button']/input")).sendKeys(Constants.PHOTO_PATH);
        Thread.sleep(2000);
        acceptButtonUploadImageConfirmationcake.click();
        Thread.sleep(4000);
    }

    //Add Text Comment for photo
    public void txtcommentforCakePhoto() {
        UtilityHelper.waitUntilClickable(addphotoCommentCake);
        addphotoCommentCake.sendKeys(Constants.photocommenttext);
    }

    //click on Special Instruction Bar toggler
    public void clickSpecialInstructionBar() throws InterruptedException {
        UtilityHelper.waitUntilClickable(specialInstrOptionbarcake);
        specialInstrOptionbarcake.click();
        Thread.sleep(1000);
    }

    //select Special Instruction Msg Text
    public void selectSpecialInstructionTextBox(String txtspcInstrmsg) throws InterruptedException {
        specialInstrTextBoxcake.sendKeys(txtspcInstrmsg);
        Thread.sleep(1000);
    }

    //
    public void clickAddToCart_CustomCake() {
        addToCartButtonForCake.click();
//        Thread.sleep(8000); By: 107793 12/27/16
        getDriver().switchTo().defaultContent();
    }

    //Navigate to CupCake
    public void cupcakeCakeLHSNavigation() {
        //getDriver().switchTo().frame(1);
        UtilityHelper.waitUntilClickable(cupcakeCakeLHSnavigationCustomCake);
        cupcakeCakeLHSnavigationCustomCake.click();
    }

    public void specialOccasionsOptionLHS() {
        UtilityHelper.waitUntilClickable(specialOccasionsLHSNavigation);
        specialOccasionsLHSNavigation.click();
    }

    public void graduation_SpecialOccasionsOptionLHS() {
        UtilityHelper.waitUntilClickable(specialOccasionsGraduationLHSNavigation);
        specialOccasionsGraduationLHSNavigation.click();
    }

    public void clickNextPage_ProductList() throws InterruptedException {
        UtilityHelper.waitUntilClickable(nextpageButtonProductPage);
        nextpageButtonProductPage.click();
        Thread.sleep(3000);
    }

    void removeNameFromNamesOfItemListArrayList(String name) {
        namesOfItemList.remove(name);
    }

    //To Clear Array List
    public void emptyArrayList_NamesOfItemList() {
        namesOfItemList.clear();
        System.out.println("    Clear Order History Array List: " + namesOfItemList);
    }

    //Created By: 107793 11/17/16
    //To Clear 'Order By Create Date' List
    public void emptyArrayList_OrderByTimeAddedStringList() {
        orderByTimeAddedStringList.clear();
        System.out.println("    Clear Order By Time Added Array List: " + orderByTimeAddedStringList);
    }

    //Created By: 107793 12/29/16
    public void emptyArrayList_ShoppingCartFulfillmentGroupList() {
        shoppingCartFulfillmentGroupArrayList.clear();
        System.out.println("    Clear fGroup Type Id Array List: " + shoppingCartFulfillmentGroupArrayList);
    }

    //Created By: 107793 10/15/16
    public void emptyArrayList_verifyItemList() {
        verifyItemList.clear();
        System.out.println("    Clear Item History Array List: " + verifyItemList);
    }

    //To click on last page number 18
    public void clickLastPage_ProductList() throws InterruptedException {
        UtilityHelper.waitUntilClickable(lastPageNumberProductPage);
        lastPageNumberProductPage.click();
        Thread.sleep(3000);
    }

    //To click on Meijer Home logo
    public void userClickMeijerLogo() {
        UtilityHelper.waitUntilClickable(MEIJER_LOGO);
        UtilityHelper.click(MEIJER_LOGO);
    }

    //Navigate to mPerks Home page screen
    public void navigate_mPerksHomePage_HittingBrowserBackButton() {
        MEIJER_LOGO.sendKeys(Keys.BACK_SPACE);
    }

    public void Click_mPerksWaysToSaveFromBottomLeftMenu() {
        if (UtilityHelper.elementExists(mPerksLeft)) {
            UtilityHelper.waitUntilClickable(mPerksLeft);
            UtilityHelper.click(mPerksLeft);
        }
    }

    public void Click_SaleWaysToSaveFromBottomLeftMenu() {
        if (UtilityHelper.elementExists(saleLeft)) {
            UtilityHelper.waitUntilClickable(saleLeft);
            UtilityHelper.click(saleLeft);
        }
    }

    public void Click_WaysToSaveDropdownMenu() {
        if (!waysToSaveDropDown.getAttribute("class").contains("focus")) {
            // Open menu
            UtilityHelper.waitUntilClickable(waysToSaveDropDown);
            UtilityHelper.click(waysToSaveDropDown);
        }
    }

    public void Click_mPerksWaysToSaveFromTopDropdownMenu() {
        if (UtilityHelper.elementExists(mPerksTop)) {
            UtilityHelper.waitUntilClickable(mPerksTop);
            UtilityHelper.click(mPerksTop);
        }
    }

    public void Click_SaleWaysToSaveFromTopDropdownMenu() {
        if (UtilityHelper.elementExists(saleTop)) {
            UtilityHelper.waitUntilClickable(saleTop);
            UtilityHelper.click(saleTop);
        }
    }

    //Created By: 107793 10/21/16
    public void yourStore_display() {
        UtilityHelper.waitUntilElementVisible(yourStorePage);
        Assert.assertTrue("=== Your Store Page Displays ======>>> ", yourStorePage.isDisplayed());
    }

    //Created By: 107793 10/21/16
    public void viewSourceCode() {
        verifyPageSource = getDriver().findElement(By.xpath("html")).getAttribute("innerHTML");
    }

    //Created By: 107793 10/28/16
    public void storePageSchemaName() {
        Assert.assertTrue("Store Page Schema - itemtype=\"http://schema.org/LocalBusiness\" ====>> ", verifyPageSource.contains("itemtype=\"http://schema.org/LocalBusiness\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"name\" ====>> ", verifyPageSource.contains("itemprop=\"name\""));
    }

    //Created By: 107793 10/28/16
    public void storePageSchemaAddress() {
        Assert.assertTrue("Store Page Schema - itemtype=\"http://schema.org/PostalAddress\" ====>> ", verifyPageSource.contains("itemtype=\"http://schema.org/PostalAddress\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"address\" ====>> ", verifyPageSource.contains("itemprop=\"address\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"streetAddress\" ====>> ", verifyPageSource.contains("itemprop=\"streetAddress\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"addressLocality\" ====>> ", verifyPageSource.contains("itemprop=\"addressLocality\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"addressRegion\" ====>> ", verifyPageSource.contains("itemprop=\"addressRegion\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"postalCode\" ====>> ", verifyPageSource.contains("itemprop=\"postalCode\""));
    }

    //Created By: 107793 10/28/16
    public void storePageSchemaHours() {
        Assert.assertTrue("Store Page Schema - itemprop=\"telephone\" ====>> ", verifyPageSource.contains("itemprop=\"telephone\""));
        Assert.assertTrue("Store Page Schema - itemprop=\"openingHours\" ====>> ", verifyPageSource.contains("itemprop=\"openingHours\""));
    }

    //Created By: 107793 10/28/16
    public void schemaName_PDP() {
        Assert.assertTrue("PDP Schema - itemtype=\"http://schema.org/Product\" ====>> ", verifyPageSource.contains("itemtype=\"http://schema.org/Product\""));
        Assert.assertTrue("PDP Schema - itemprop=\"name\" ====>> ", verifyPageSource.contains("itemprop=\"name\""));
    }

    //Created By: 107793 10/28/16
    public void schemaImage_PDP() {
        Assert.assertTrue("PDP Schema - itemprop=\"image\" ====>> ", verifyPageSource.contains("itemprop=\"image\""));
    }

    //Created By: 107793 10/28/16
    public void schemaDescription_PDP() {
        Assert.assertTrue("PDP Schema - itemprop=\"description\" ====>> ", verifyPageSource.contains("itemprop=\"description\""));
    }

    //Created By: 107793 10/28/16
    public void schemaPrice_PDP() {
        List<WebElement> priceGoodThough_PDP = getDriver().findElements(By.xpath("//*[contains(text(), 'Price good through')]"));
        Assert.assertTrue("PDP Schema - itemtype=\"http://schema.org/Offer\" ====>> ", verifyPageSource.contains("itemtype=\"http://schema.org/Offer\""));
        Assert.assertTrue("PDP Schema - itemprop=\"priceCurrency\" content=\"USD\" ====>> ", verifyPageSource.contains("itemprop=\"priceCurrency\" content=\"USD\""));
        Assert.assertTrue("PDP Schema - itemprop=\"price\" ====>> ", verifyPageSource.contains("itemprop=\"price\""));
        if (priceGoodThough_PDP.size() > 0) {
            Assert.assertTrue("PDP Schema - itemprop=\"priceValidUntil\" ====>> ", verifyPageSource.contains("itemprop=\"priceValidUntil\""));
        }
    }

    public void userClicksSignInToReserveATimeSlotLink() {
        UtilityHelper.click(SIGN_IN_TO_RESERVE_SLOT_LINK);
    }

    public void validate_CurrentReservationSlot_Drop() {
        UtilityHelper.waitUntilClickable(SIGN_IN_TO_RESERVE_SLOT_LINK);
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id='js-curbside-display-msg']//*[@class='mjr-small active line2 hideFromMobileHeader']"));
        Assert.assertTrue("Reserved Until time Not Display!", list.size() == 0);
        Assert.assertTrue(SIGN_IN_TO_RESERVE_SLOT_LINK.isDisplayed());

    }

    public void reserveduntil_display_validation() {
        String compareval = Constants.reservedUntilText;
        Assert.assertTrue(reservedUntildisplaySectionMeijerHP.getText().contains(compareval));
    }

    public void validateText_reserveCurbsidePickupTime_display() {
        Assert.assertEquals(SIGN_IN_TO_RESERVE_SLOT_LINK.getText(), Constants.reserveCurbSidePickUpTimeText);
    }

    public void click_StoreLocator_Footer() {
        UtilityHelper.waitUntilClickable(storeLocatorLinkFooterMeijerHP);
        storeLocatorLinkFooterMeijerHP.click();
    }

    public void select_MI_fromMap() {
        UtilityHelper.waitUntilElementVisible(findaStoreHeaderTextStoreLocator);
        michiganOnMapStoreLocator.click();
    }

    public void select_CurbsideEnabledStore_Alpine() {
        UtilityHelper.waitUntilClickable(secondPageIconStoreLocator);
        secondPageIconStoreLocator.click();
        UtilityHelper.waitUntilElementVisible(findaStoreHeaderTextStoreLocator);
        alpineStoreMakeThisMyStoreButtonStoreLocator.click();
    }

    public void validate_SignInToReserveTimeSlot_TextDisplay() {
        UtilityHelper.waitUntilElementVisible(SIGN_IN_TO_RESERVE_SLOT_LINK);
        Assert.assertEquals(Constants.signInToReserveTimeSlot, SIGN_IN_TO_RESERVE_SLOT_LINK.getText());
    }

    public void validate_AvailableASATimeDisplay() {
        Assert.assertTrue(availableassoonastextMeijerHP.getText().contains(Constants.availableAsSoonAsText));
    }

    public String availabletimevalue() {
        String pickupTimedisplay = availableassoonastextMeijerHP.getText();
        String trimvalue1 = pickupTimedisplay.substring(21);
        System.out.println("=== My Trim value is:" + trimvalue1);
        firstavailablePickupTime = trimvalue1;
        return firstavailablePickupTime;
    }

    //Validate Past order link Display
    public void validatePastOrderLink_Display() {
        UtilityHelper.waitUntilClickable(PAST_ORDERS_CURBSIDE_LINK);
        Assert.assertTrue("Verify 'Past Orders' link is displayed: ", PAST_ORDERS_CURBSIDE_LINK.isDisplayed());
    }

    //Validate Past Order Not Display
    public void pastOrder_linkNotDisplay() {
        List<WebElement> list = getDriver().findElements(By.linkText("Past Orders"));
        Assert.assertTrue("Verify 'Past Order' Link is NOT Displayed: ", list.size() == 0);
    }

    //Validate Quick Shop link Display
    public void validateQuickShopLink_Display() {
        UtilityHelper.waitUntilClickable(QUICK_SHOP_CURBSIDE_LINK);
        Assert.assertTrue("Verify 'Quick Shop' link is displayed: ", QUICK_SHOP_CURBSIDE_LINK.isDisplayed());
    }

    //Validate Past Order Not Display
    public void quickShop_linkNotDisplay() {
        List<WebElement> list = getDriver().findElements(By.linkText("Quick Shop"));
        Assert.assertTrue("Verify 'Quick Shop' Link is NOT Displayed: ", list.size() == 0);
    }

    //Click on Past Order link display under curbside wizard
    public void click_PastOrderlink_CurbsideWizard() {
        UtilityHelper.waitUntilClickable(PAST_ORDERS_CURBSIDE_LINK);
        PAST_ORDERS_CURBSIDE_LINK.click();
    }

    //Click on Quick Shop link display under curbside wizard
    public void click_QuickShoplink_CurbsideWizard() throws InterruptedException {
        UtilityHelper.waitUntilClickable(QUICK_SHOP_CURBSIDE_LINK);
        QUICK_SHOP_CURBSIDE_LINK.click();
        Thread.sleep(2000);
    }

    public void waitUntilHomepageLoads() {
        UtilityHelper.waitUntilClickable(getDriver().findElement(By.xpath("//img[contains(@src, 'icon_curbside')]")));
    }

    //Validate Quick Shop Landing Page
    public void validate_QuickShop_pageTitle() {
        Assert.assertTrue(getDriver().getTitle().contains(Constants.quickShopPageTitleText));
    }

    //Validate Quick Shop page - Frequent Purchases Header Text
    public void validate_FrequentPurchases_Text() {
        Assert.assertEquals(Constants.frequentPurchasesText, frequentPurchasesHeaderTextQuickShop.getText());
    }

    //Validate Quick Shop page - Your Favorites Header Text
    public void validate_YourFavorites_Text() {
        Assert.assertEquals(Constants.yourFavoritesText, yourFavoritesHeaderTextQuickShop.getText());
    }

    //Validate Quick Shop page - Your Recommendations Header Text
    public void validate_YourRecommendations_Text() {
        Assert.assertEquals(Constants.yourRecommendationsText, yourRecommendationsHeaderTextQuickShop.getText());
    }

    public void validateQuickShopFavoritesSection_SSI() {
        moveToViewYourFavoritesViaQuickShopPage();
        WebElement favorites_SSI = getDriver().findElement(By.xpath("//*[@class='favoritedItems']//h5"));
        UtilityHelper.elementGetText(favorites_SSI);
        Assert.assertTrue("=== SSI Favorites Section", favorites_SSI.getText().contains("sign in"));
    }

    //Validate 'View Order' link not display
    public void validate_ViewOrderLink_NotDisplay() {
        List<WebElement> viewOrder = getDriver().findElements(By.linkText("View Order"));
        Assert.assertTrue("=== View Order link is Displayed!", viewOrder.size() == 0);
    }

    //Validate Edit Order link not display
    public void validate_EditOrderLink_NotDisplay() {
        List<WebElement> editOrder = getDriver().findElements(By.linkText("Edit Order"));
        Assert.assertTrue("=== Edit Order link is Displayed!", editOrder.size() == 0);
    }

    //
    public void validateWarningNoteDisplayToDropCurbsideReservationOnSelectStore() {
        UtilityHelper.waitUntilElementVisible(searchStoreLocationTextBoxFieldMeiejrHP);
        Assert.assertEquals(Constants.warningNoteCurbsideRelease, warningNoteForDroppingReserveSlotSelectStore.getText());
    }

    public void validate_SelectedStore_Display(String storename) {
        UtilityHelper.waitUntilElementVisible(yourStoreNameMeijerHP);
        Assert.assertEquals(storename, yourStoreNameMeijerHP.getText());
    }

    //ET time zone  text validation
    public void validate_ET_TimeZone() {
        Assert.assertTrue(availableassoonastextMeijerHP.getText().contains(Constants.timezoneET));
    }

    //CT time zone  text validation
    public void validate_CT_TimeZone() {
        Assert.assertTrue(availableassoonastextMeijerHP.getText().contains(Constants.timezoneCT));
    }

    //Validate TimeZone Display in Curbside after Pickup Slot Reserved
    public void valdiate_TimeZone_Curbside_AfterSlotReserved() throws ParseException {
        String storePickupDate = OrderPickupPage.pickupDate;
        System.out.println("=== stored date format is: " + storePickupDate);
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = originalFormat.parse(storePickupDate);
        SimpleDateFormat formatter = new SimpleDateFormat("z");
        String text = formatter.format(startDate);
        String timezoneSF = text.replace("D", "");
        System.out.println("=== Time Zone is: " + timezoneSF);
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(timezoneSF));
        Assert.assertTrue(reservedUntildisplaySectionMeijerHP.getText().contains(timezoneSF));
    }

    //Validate ET TimeZone Display in Curbside after Pickup Slot Reserved
    public void validate_ET_Curbside_AfterSlotReserved() {
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(Constants.timezoneET));
        Assert.assertTrue(reservedUntildisplaySectionMeijerHP.getText().contains(Constants.timezoneET));
    }

    //Validate ET TimeZone Display in Curbside after Pickup Slot Reserved
    public void validate_CT_Curbside_AfterSlotReserved() {
        Assert.assertTrue(activeOrderPickupTimeDisplayCurbsideWidgetHP.getText().contains(Constants.timezoneCT));
        Assert.assertTrue(reservedUntildisplaySectionMeijerHP.getText().contains(Constants.timezoneCT));
    }

    /* Geo Location Setting is implemented in uat.meijer.com on 10/6/16*/
    public void click_UseCurrentLocation_button() {
        try {
            UtilityHelper.waitUntilClickable(useCurrentLocationButton);
            useCurrentLocationButton.click();
        } catch (Exception e) {
            System.out.println("=== Select Geo Location pop is not displayed while launching meijer.com!");
        }
    }

    //Method to Select Sign In from Geo Location popup Screen
    public void click_SignIn_GeoLocationPopUp() {
        UtilityHelper.waitUntilClickable(signInLinkSetLocationPopup);
        signInLinkSetLocationPopup.click();
    }

    public void userClickOnHeaderMenuOnlineShopping() {
        UtilityHelper.waitUntilClickable(ONLINE_SHOPPING_DROPDOWN);
        UtilityHelper.click(ONLINE_SHOPPING_DROPDOWN);
    }

    //Validate Curbside option display on 3rd of the dropdown list
    public void validateCurbside1stOnDropdownlist() {
        UtilityHelper.waitUntilClickable(ONLINE_SHOPPING_DROPDOWN);
        Assert.assertEquals(Constants.onlineShoppingDropdown1stItem, UtilityHelper.elementGetText(OPTION_1IN_ONLINE_SHOPPING_DROPDOWN));
    }

    //Method to click on Curbside option from Dropdown
    public void clickCurbsideFromOnlineShoppingDropdown() {
        UtilityHelper.waitUntilClickable(CURBSIDE_OPTION_ONLINE_SHOPPING_DROPDOWN);
        CURBSIDE_OPTION_ONLINE_SHOPPING_DROPDOWN.click();
        setImplicitTimeout(10, TimeUnit.SECONDS);
    }

    //To validate Curbside page Display successfully
    public void validateCurbsidePageDisplayCorrect() {
        Assert.assertEquals(Constants.curbsidePageTitle, getDriver().getTitle());
    }


    public void validateShipt2ndOnDropdownlist() {
        UtilityHelper.waitUntilClickable(ONLINE_SHOPPING_DROPDOWN);
        Assert.assertEquals(Constants.onlineShoppingDropdown2ndItem, UtilityHelper.elementGetText(OPTION_2IN_ONLINE_SHOPPING_DROPDOWN));
    }


    public void clickShiptFromOnlineShoppingDropdown() {
        UtilityHelper.waitUntilClickable(SHIPT_OPTION_ONLINE_SHOPPING_DROPDOWN);
        SHIPT_OPTION_ONLINE_SHOPPING_DROPDOWN.click();
        setImplicitTimeout(10, TimeUnit.SECONDS);
    }

    public void validateShiptPageDisplaySuccessfully() {
        Assert.assertEquals(Constants.shiptPageTitle, getDriver().getTitle());
    }

    //Method to click on Menu Header - 'Services'
    public void userClickOnHeaderMenuServices() {
        UtilityHelper.waitUntilClickable(SERVICES_DROPDOWN);
        UtilityHelper.click(SERVICES_DROPDOWN);
    }




    /*---------------Excel Import Action ---------------------------*/

    public void enterZipCode_GeoLocationScreen(String zipcode) {
        UtilityHelper.waitUntilClickable(cityStateZipField);
        cityStateZipField.clear();
        cityStateZipField.sendKeys(zipcode);
    }

    public void click_findStoreButton_GeoLocation() {
        findStoresButton.click();
    }

    //click on Cart Icon
    public void click_CartIcon() {
        UtilityHelper.waitUntilClickable(CART_ICON_ITEM_COUNT);
        CART_ICON_ITEM_COUNT.click();
    }

    //Checkout Button Disabled Validation
    public void validate_Checkout_button_Disabled() {
        UtilityHelper.waitUntilElementVisible(DISABLED_CHECKOUT_BUTTON);
        Assert.assertTrue(DISABLED_CHECKOUT_BUTTON.isDisplayed());
        miniCartTitle.click();
    }

    /**
     * This method has been created for verifying number of items display in a page is 40.
     */
    public void userVerifyItemsDisplayedPerPage() {
        List<WebElement> itemsDisplayed = getDriver().findElements(By.xpath("//form[@name='add-product']"));
        int numberOfItems = itemsDisplayed.size();
        Assert.assertTrue(numberOfItems == 40);
    }

    /**
     * This method has been created for verifying that store displayed against each item should be based on selected main store, here store id for selected store(Cascade) is 50.
     */
    public void userVerifyStoreAgainstEachItemAndMainStoreSelectedSame() {
/*		int storeCountAgainstItem=storeAgainstItems.size();
        boolean condition=storeCountAgainstItem==40;
		Assert.assertTrue(condition);*/
        String yourStoreSelected = yourStoreNameMeijerHP.getText();
        String expectedStore = "Cascade";
        Assert.assertEquals(expectedStore, yourStoreSelected);
    }

    /*-------------------------Eliminate Best Pricing-------------------------*/

    public void verify_NoWeightMessagingOnProductTitle() {
        UtilityHelper.waitUntilClickable(WeightPrice);
        Assert.assertFalse(WeightPrice.getText().contains("*"));
    }

    public void verify_weightMessagingOnProductDisplayPage() {
        UtilityHelper.waitUntilClickable(PDPWeightPrice);
        Assert.assertTrue(PDPWeightPrice.getText().contains("*"));
    }

    public void verify_weightDisclaimerOnProductDisplayPage() {
        UtilityHelper.waitUntilClickable(PDPDisclaimer);
        Assert.assertTrue(PDPDisclaimer.getText()
                .contentEquals("*Actual price will be determined at pickup based on weight"));
    }

    public void verify_WeightDisclaimerInCheckout() {
        UtilityHelper.waitUntilClickable(CheckoutDisclaimer);
        Assert.assertTrue(CheckoutDisclaimer.getText()
                .contentEquals("Actual price and discounts will be determined at pickup."));
    }

    public void verify_WeightDisclaimerInCart() {
        UtilityHelper.waitUntilClickable(CartDisclaimer);
        Assert.assertTrue(CartDisclaimer.getText()
                .contentEquals("Actual price and discounts will be determined at pickup."));
    }

    public void verify_WeightDisclaimerInMiniCart() {
        UtilityHelper.waitUntilClickable(MiniCartDisclaimer);
        Assert.assertTrue(MiniCartDisclaimer.getText()
                .contentEquals("Actual price and discounts will be determined at pickup."));
    }

    public void verify_WeightDisclaimerInOrderReview() {
        UtilityHelper.waitUntilClickable(OrderViewDisclaimer);
        Assert.assertTrue(OrderViewDisclaimer.getText()
                .contentEquals("Actual price and discounts will be determined at pickup."));
    }

    public void verify_WeightDisclaimerInEditOrder() {
        UtilityHelper.waitUntilClickable(EditOrderDisclaimer);
        Assert.assertTrue(EditOrderDisclaimer.getText()
                .contentEquals("Actual price and discounts will be determined at pickup."));
    }

    /*------------------------------Hyperlinks---------------------------------------*/

    public void clickListViewIcon() {
        UtilityHelper.click(LIST_VIEW_ICON);
    }

    public void verify_urlShouldMatchmPerksFiltersForTier2() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("mPerks"));
    }

    public void verify_urlShouldMatchSaleFiltersForTier2() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("Sale"));
    }

    public void verify_urlShouldMatchmPerksAndSaleFiltersForTier2() {
        System.out.println("Here I am");
        String newUrl = getDriver().getCurrentUrl();
        UtilityHelper.waitUntilClickable(MEIJER_LOGO);
        Assert.assertTrue(newUrl.contains("mPerks") && newUrl.contains("Sale"));

    }

    public void verify_urlShouldMatchSaleFiltersForTier3() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("Sale"));
    }

    public void verify_urlShouldMatchSaleFiltersForTier4() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("Sale"));
    }

    public void verify_urlShouldMatchmPerksFiltersForSearch() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("mPerks"));
    }

    public void verify_urlShouldMatchSaleFiltersForSearch() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("Sale"));
    }

    public void verify_urlShouldMatchmPerksAndSaleFiltersForSearch() {
        waitUntilPageLoaderVanishes();
        String newUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("mPerks") && newUrl.contains("Sale"));

    }

    public void managedContentBlockExists() {
        Boolean iselementpresent = getDriver().findElements(By.xpath("//*[@class='mjr-manContentBillboard']")).size()
                != 0 || getDriver().findElements(By.xpath("//*[@class='container mjr-manContentBillboard']")).size() != 0;

        Assert.assertTrue(iselementpresent);
    }

    public void click_brandInLeftNavigation() {
        UtilityHelper.waitUntilClickable(SamsungBrandFilter);
        SamsungBrandFilter.click();
    }

    public void verify_urlShouldMatchBrandFiltersForTiers() {
        String newUrl = getDriver().getCurrentUrl();
        String oldPlusFilterUrl = TierHyperlink + "?tierId=T3-459&keyword=&sort=1&rows=40&start=0&spellCorrection=undefined&facet=PMM_98_t:SAMSUNG&=true";
        Assert.assertEquals(oldPlusFilterUrl, newUrl);
    }

    public void highLightDesiredPageIndex(String pageIndex) {
        WebElement pageNumber = getDriver().findElement(By.xpath("//li/span[text()='" + pageIndex + "']"));
        UtilityHelper.highLightElement(pageNumber);
    }

    public void clickDesiredPageIndex(String pageIndex) {
        if (!Strings.isNullOrEmpty(pageIndex)) {
            WebElement pageNumber = getDriver().findElement(By.xpath("//li/span[text()='" + pageIndex + "']"));
            if (Integer.valueOf(pageIndex) > 5) {
                NEXT_ELLIPSIS.click();
                pageNumber.click();
            } else {
                UtilityHelper.click(pageNumber);
            }
        }
    }

    public void waitUntilPageLoaderVanishes() {
        if (UtilityHelper.elementExists(PAGE_LOADER)) {
            UtilityHelper.waitUntilElementNotVisible(PAGE_LOADER);
        }
    }

    /*------------------ Product Tile Button Functionality ------------------*/

    //Created By: 107793 11/08/16
    public void productTileButtonFunctionality() {
        int item;
        List<WebElement> searchResults = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li"));
        for (item = 1; item < (searchResults.size() + 1); item++) {
//        for (item = 1; item < 10; item++) {
            WebElement productTile = getDriver().findElement(By.xpath("//*[@id='tierResults']/div[3]/ul/li[" + item + "]"));
            String availability = productTile.getAttribute("class");
            if (availability.contains("unavailable") || availability.contains("instore")) {
                continue;
            }
            UtilityHelper.moveToViewElement(productTile);
            //Validate Increase Quantity
            increaseQTYFunctionality(item);
            //Validate Decrease Quantity
            decreaseQTYFunctionality(item);
            //Validate Add to Cart - Cart Count +1
            addToCartFunctionality(item);
        }
    }

    //Created By: 107793 11/10/16
    public void verifyTotalAddAbleCount() {
        List<WebElement> searchResults = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li//*[@name='quantity']"));
        int currentCartCount = Integer.valueOf(CART_ICON_ITEM_COUNT.getText());
        Assert.assertEquals("Verify Total Mini Cart Count == Sellable Products ", searchResults.size(), currentCartCount);
    }

    //Created By: 107793 11/08/16
    private void increaseQTYFunctionality(int item) {
        try {
            WebElement qtyInputBox = getDriver().findElement(By.xpath("//*[@id='tierResults']//li[" + item + "]//*[@name='quantity']"));
            UtilityHelper.moveToViewElement(qtyInputBox);
            //Verify Default Quantity Value
            int qtyValue = Integer.valueOf(qtyInputBox.getAttribute("value"));
            Assert.assertEquals("Default Index [" + item + "] Quantity Text Box Value", 1, qtyValue);
            //Click "+" Button
            WebElement increaseQty = getDriver().findElement(By.xpath("//*[@id='tierResults']//li[" + item + "]//*[@value='+']"));
            increaseQty.click();
            Thread.sleep(1000);
            //Verify Updated Quantity Value
            int updateQtyValue = Integer.valueOf(qtyInputBox.getAttribute("value"));
            Assert.assertEquals("Verify Index [" + item + "] Quantity Value ++ ", (qtyValue) + 1, updateQtyValue);
        } catch (InterruptedException e) {
            System.out.println("Element Index [" + item + "] Increase Qty: " + e.getMessage());
        }
    }

    //Created By: 107793 11/08/16
    private void decreaseQTYFunctionality(int item) {
        try {
            WebElement qtyInputBox = getDriver().findElement(By.xpath("//*[@id='tierResults']//li[" + item + "]//*[@name='quantity']"));
            UtilityHelper.moveToViewElement(qtyInputBox);
            //Verify Quantity Value
            int qtyValue = Integer.valueOf(qtyInputBox.getAttribute("value"));
            Assert.assertEquals("Index [" + item + "] Quantity Text Box Value ", 2, qtyValue);
            //Click "-" Button
            WebElement decreaseQty = getDriver().findElement(By.xpath("//*[@id='tierResults']//li[" + item + "]//*[@value='-']"));
            decreaseQty.click();
            Thread.sleep(1000);
            //Verify Updated Quantity Value
            int updateQtyValue = Integer.valueOf(qtyInputBox.getAttribute("value"));
            Assert.assertEquals("Verify Index [" + item + "] Quantity Value -- ", (qtyValue) - 1, updateQtyValue);
        } catch (InterruptedException e) {
            System.out.println("Element Index [" + item + "]  Decrease Qty: " + e.getMessage());
        }
    }

    //Created By: 107793 11/08/16
    private void addToCartFunctionality(int item) {
        WebElement addToCart = getDriver().findElement(By.xpath("//*[@id='tierResults']//li[" + item + "]//*[contains(@class,'add-to-cart') and @type='submit']"));
        Assert.assertTrue("Verify Product Index [" + item + "] 'Add to Cart' isDisplayed() ", addToCart.isDisplayed());
        addToCart.click();
        UtilityHelper.moveToViewElement(CART_ICON_ITEM_COUNT);
        verifyWinkBarDisplayCorrectQty("1");
        verifyAddedQtyViaCartIcon("1", CART_ICON_ITEM_COUNT.getText());
    }

    /*------------------ END Product Tile Button Functionality ------------------*/

    //To verify Changing From Curbside -> Non-Curbside Warning Message
    //Created By: 107793 12/29/16
    public void curbsideToNonCurbsideConflictModalAppears() {
        UtilityHelper.waitUntilElementVisible(STORE_CONFLICT_MODAL);

        Assert.assertTrue("Verify Change Store Conflict Modal Appears", UtilityHelper.elementExists(STORE_CONFLICT_MODAL));
        Assert.assertTrue("Verify Button 'Keep Current Store' ", UtilityHelper.elementExists(STORE_CONFLICT_KEEP_STORE_BUTTON));
        Assert.assertTrue("Verify Button 'Continue, Change Store' ", UtilityHelper.elementExists(STORE_CONFLICT_CHANGE_STORE_BUTTON));
    }

    public void changeStoreConflictModalDetails() {
        String Title = "Items in Cart Will Not Be Available";
        String Question = "Do you want to continue with the new store?";
        WebElement title = getDriver().findElement(By.xpath("//p[contains(@class,'mjr-alert')]"));
        WebElement message = getDriver().findElement(By.xpath("//*[@class='switchStoreNoCurbOrSPO']/p[2]"));
        WebElement question = getDriver().findElement(By.xpath("//*[@class='switchStoreNoCurbOrSPO']/p[3]"));
        Assert.assertEquals("Verify Modal Title ", Title, UtilityHelper.elementGetText(title));
        if (shoppingCartFulfillmentGroupArrayList.contains("2")) {
            Assert.assertEquals("Verify Modal Message - With SPO ", Constants.withSPO, UtilityHelper.elementGetText(message));
        } else {
            Assert.assertEquals("Verify Modal Message - Without SPO ", Constants.withoutSPO, UtilityHelper.elementGetText(message));
        }
        Assert.assertEquals("Verify Modal Question ", Question, UtilityHelper.elementGetText(question));
    }

    //To click button 'Keep Store' via switch store conflict modal
    public void clickKeepStoreButton() {
        if (UtilityHelper.elementExists(STORE_CONFLICT_KEEP_STORE_BUTTON)) {
            UtilityHelper.click(STORE_CONFLICT_KEEP_STORE_BUTTON);
        }
    }

    //To click button 'Continue, Change Store' via switch store conflict modal
    public void clickContinueChangeStoreButton() {
        if (UtilityHelper.elementExists(STORE_CONFLICT_KEEP_STORE_BUTTON)) {
            UtilityHelper.click(STORE_CONFLICT_CHANGE_STORE_BUTTON);
        }
    }

    //To show evidence that a script is failing due to a Bug that has been reported
    public void standByForBugReportIsFixed(String bugId) {
        Assert.assertEquals("VSTS BUG #" + bugId + ".", "To be Fixed", "Still Broken");
    }

    public void verifyPassiveStoreModalIsDisplayed() {
        if (UtilityHelper.elementExists(PASSIVE_STORE_DIALOG)) {
            UtilityHelper.isDisplayed(PASSIVE_STORE_DIALOG);
        }
    }

    public void deleteCookieToSimulateHavingNotSeenPassiveStoreModal() {
        getDriver().manage().deleteCookie(getDriver().manage().getCookieNamed("DefaultStoreNotificationCookie"));
    }

    public void verifyDefaultStoreCookieIsSetToStoreName(String storeName) {
        Assert.assertEquals("Assert DefaultStore in cookie is set to <store>: ", grabStoreFromDefaultStoreCookie(), storeName);

    }

    public void verifyDefaultStoreCookieRemainsUnchanged() {
        Assert.assertEquals("Assert DefaultStore in cookie was unchanged: ", grabStoreFromDefaultStoreCookie(), g_store);
    }

    public void userClicksKeepThisStoreOnPassiveStoreSelectionModal() {
        if (UtilityHelper.elementExists(PASSIVE_STORE_DIALOG)) {
            UtilityHelper.click(KEEP_STORE);
        }
    }

    public void verifyPassiveStoreCookieIsSet() {
        Cookie ck = getDriver().manage().getCookieNamed("DefaultStoreNotificationCookie");
        Assert.assertTrue("=== assert cookie exists: ", ck != null);
        Assert.assertEquals("=== assert cookie is set to true: ", "true", ck.getValue());
        System.out.println("DefaultStoreNotificationCookie Value: " + ck.getValue());
    }

    public void grabAndSaveStoreNameFromHeader() {
        g_store = UtilityHelper.elementGetText(YOUR_STORE_VALUE);
    }

    private String grabStoreFromDefaultStoreCookie() {
        Cookie ck = getDriver().manage().getCookieNamed("DefaultStore");
        Assert.assertTrue("=== assert cookie exists: ", ck != null);
        return orderPickupPage.verifyStoreId(ck.getValue().replace("\"", "").split("[|]")[0]);
    }

    public void verifyDefaultStoreCookieMatchesHeader() {
        String storeName = UtilityHelper.elementGetText(YOUR_STORE_VALUE);
        Cookie ck = getDriver().manage().getCookieNamed("DefaultStore");
        Assert.assertTrue("=== assert cookie exists: ", ck != null);

        String storeId = ck.getValue().replace("\"", "").split("[|]")[0];
        Assert.assertEquals("=== assert DefaultStore cookie matches header store text: ", storeName, orderPickupPage.verifyStoreId(storeId));
    }

    public void click_keepStore_PassiveStoreSelection() {
        WebElement newStore = getDriver().findElement(By.xpath("//li[@class='yourStore']//button[@id='keepStoreButton']"));
        newStore.click();
    }

    public void click_SelectNewStore_PassiveStoreSelection() {
        WebElement newStore = getDriver().findElement(By.xpath("//li[@class='yourStore']//button[@id='pickNewStoreButton']"));
        newStore.click();
    }

    public void click_off_PassiveStoreSelectionModal() {
        WebElement clickOutsideModal = getDriver().findElement(By.xpath("//*[@id='nav_search_submit']"));
        clickOutsideModal.click();
    }

    //TODO: PI 5.3 shopping cart page work
    public void verifyProductsInShoppingCartMatchProductsList() {
        List<WebElement> products = getDriver().findElements(By.xpath("//span[@class='mjr-product-name']"));
        for (WebElement product : products) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify minicart matches previous state: ", namesOfItemList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifyProductsInMinicartMatchProductsList() {
        List<WebElement> products = getDriver().findElements(By.xpath("//span[@class='productNameInner']"));
        for (WebElement product : products) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify minicart matches previous state: ", namesOfItemList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void saveInformationForMinicartHeaderAndReservationHeader() {
        reservationHeader = getDriver().findElement(By.xpath("//*[@class='fl curbsideMessage']/a")).getText();
        headerCount = UtilityHelper.elementGetText(CART_ICON_ITEM_COUNT);
    }

    public void verifyMinicartHeaderAndReservationHeaderMatchPreviousState() {
        String reservationHeaderCurrent = getDriver().findElement(By.xpath("//*[@class='fl curbsideMessage']/a")).getText();
        String headerCountCurrent = UtilityHelper.elementGetText(CART_ICON_ITEM_COUNT);

        assertEquals("Assert reservation widget text matches previous state: ", reservationHeaderCurrent, reservationHeader);
        assertEquals("Assert minicart widget count matches previous state: ", headerCountCurrent, headerCount);
    }

    public void storeCartID() {
        launchPage.openAt(Definition_RunnerClass.Environment + "/checkout/test/getCartId.jsp");
        cartID = getDriver().findElement(By.xpath("//h1[contains(text(), 'cartId')]")).getText();
        System.out.println("cartID: " + cartID);
    }

    public void verifyCartIdMatchesPreviousCartID() {
        launchPage.openAt(Definition_RunnerClass.Environment + "/checkout/test/getCartId.jsp");
        String cartID2 = getDriver().findElement(By.xpath("//h1[contains(text(), 'cartId')]")).getText();
        System.out.println("OldCartID: " + cartID);
        System.out.println("cartID: " + cartID2);
        assertEquals("Assert cartid matches previous cartID: ", cartID2, cartID);
    }

    public void verifyCartIdDoesNOTmatchPreviousCartID() {
        launchPage.openAt(Definition_RunnerClass.Environment + "/checkout/test/getCartId.jsp");
        String cartID2 = getDriver().findElement(By.xpath("//h1[contains(text(), 'cartId')]")).getText();

        System.out.println("OldCartID: " + cartID);
        System.out.println("cartID: " + cartID2);

        assertNotEquals("Assert cartid does NOT match previous cartID: ", cartID2, cartID);
    }

    public void verifyMinicartWidgetShowsZeroItems() {
        String miniCartCount = getDriver().findElement(By.xpath("//span[@id='js-headerItemCount']")).getText();
        assertEquals("Assert miniCart count is zero: ", miniCartCount, "0");
    }

    public void verifyMinicartIsEmpty() {
        //open minicart
        if (!isMiniCartOpen()) {
            CART_ICON_ITEM_COUNT.click();
            verifyMiniCartHasLoaded();
        }
        //check cart for zero products
        List<WebElement> products = getDriver().findElements(By.xpath("//span[@class='productNameInner']"));
        assertEquals("Assert miniCart count is empty: ", products.size(), 0);
        //close minicart
        userClosesMiniCart();
    }

    public void verifyReservationWidgetShowsSignInToReserveTimeslot() {
        String msg = getDriver().findElement(By.xpath("//*[@id='js-curbside-display-msg']//*[@class='line1 mjr-small']")).getText();
        assertEquals("Assert reservation text is Reserve Curbside Pickup Time: ", "Sign In to Reserve a Time Slot", msg);
    }

    public void waitUntilWinkbarDissappears() {
        UtilityHelper.waitUntilElementNotVisible(By.xpath("//*[contains(@id, 'page-notification')]"));
    }

    public void verifyQuickshopListsAreNotPresent() {
        Assert.assertTrue(UtilityHelper.elementNotExists(By.xpath("//div[@id='quickShop_favorited']")));
        Assert.assertTrue(UtilityHelper.elementNotExists(By.xpath("//div[@id='quickShop_frequent']")));
        Assert.assertTrue(UtilityHelper.elementNotExists(By.xpath("//div[@id='quickShop_recommendations']")));
    }

    public void clicks_on_wayfinding_tiles(String tier2) {
        UtilityHelper.waitUntilElementVisible(By.xpath("//*[contains(@class,'wfDesktop')]"));
        List<WebElement> allWayfindingTiles = getDriver().findElements(By.xpath("//*[contains(@class,'wfDesktop')]/a"));
        for (WebElement element : allWayfindingTiles) {
            String wayfindingIcid = element.getAttribute("href");
            Assert.assertTrue(wayfindingIcid.contains("icid="));
        }
        for (int i = 1; i < (allWayfindingTiles.size() + 1); i++) {
            String xpath = "//*[contains(@class,'wfDesktop')]/a[" + i + "]";
            if (UtilityHelper.isNotClickable(By.xpath(xpath))) {
                UtilityHelper.waitUntilClickable(By.xpath(xpath));
            }
            getDriver().findElement(By.xpath(xpath)).click();
            setImplicitTimeout(5, TimeUnit.SECONDS);
            String tier2Url = getDriver().getCurrentUrl();
            Assert.assertTrue(tier2Url.contains("icid=T2:T3:Grocery:" + tier2));
            getDriver().navigate().back();
        }
    }

    public void clicks_on_wayfinding_tiles(String tier2, String tier3) {
        UtilityHelper.waitUntilElementVisible(By.xpath("//*[contains(@class,'wfDesktop')]"));
        List<WebElement> allWayfindingTiles = getDriver().findElements(By.xpath("//*[contains(@class,'wfDesktop')]/a"));
        for (WebElement element : allWayfindingTiles) {
            String wayfindingIcid = element.getAttribute("href");
            Assert.assertTrue(wayfindingIcid.contains("icid="));
        }

        for (int j = 1; j <= allWayfindingTiles.size(); j++) {
            String xpath = "//*[contains(@class,'wfDesktop')]/a[" + j + "]";
            if (UtilityHelper.isNotClickable(By.xpath(xpath))) {
                UtilityHelper.waitUntilClickable(By.xpath(xpath));
            }
            getDriver().findElement(By.xpath(xpath)).click();
            setImplicitTimeout(5, TimeUnit.SECONDS);
            String tier3Url = getDriver().getCurrentUrl();
            Assert.assertTrue(tier3Url.contains("icid=T3:T4:Grocery:" + tier2 + ":" + tier3));
            getDriver().navigate().back();
        }
    }

    public void userRecordsSearchResults() {
        UtilityHelper.waitUntilClickable(getDriver().findElement(By.xpath("//img[contains(@src, 'icon_curbside')]")));
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li//*[@class='mjr-product-name']//a"));
        for (WebElement product : products) {
            searchResults.add(product.getText());
        }
    }

    public void userVerifiesSearchResultsMatchPreviousResults() {
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li//*[@class='mjr-product-name']//a"));
        for (WebElement product : products) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify search results match previous results: ", searchResults.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifyUserIsPromptedToLogin() {
        UtilityHelper.waitUntilClickable(getDriver().findElement(By.xpath("//*[@class='modalContent']//button")));
        Assert.assertTrue(UtilityHelper.elementExists(By.xpath("//*[@class='modalContent']//button")));
    }

    public void verifyUserIsNotPromptedToLogin() {
        Assert.assertTrue(UtilityHelper.elementNotExists(By.xpath("//*[@class='modalContent']//button")));
    }

    public void storeSuggestedPurchaseList() {
        int elementIndex = 1;
        WebElement rightArrow = getDriver().findElement(By.xpath("//*[@id='quickShop_recommendations_right']"));
        String pageIndex = getDriver().findElement(By.xpath("//*[@id='quickShop_recommendations_of']")).getText();
        WebElement suggestedPurchasesContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_recommendations']"));
        List<WebElement> suggestions = suggestedPurchasesContainer.findElements(By.xpath(".//h3[@class='mjr-product-name']"));
        int modIndex = carouselIndexing(suggestions.size(), Integer.valueOf(pageIndex));

        for (WebElement product : suggestions) {
            product = getDriver().findElement(By.xpath("(//div[@id='quickShop_recommendations']//h3[@class='mjr-product-name'])[" + elementIndex + "]"));
            UtilityHelper.moveToViewElement(product);
            if (elementIndex % modIndex == 0) {
                UtilityHelper.moveToViewElement(rightArrow);
                UtilityHelper.click(rightArrow);
            }
            UtilityHelper.waitUntilClickable(product);
            elementIndex++;
            suggestionsList.add(product.getText());
        }
    }

    public void validateSuggestedPurchasesListMatchesPreviousState() {
        int elementIndex = 1;
        WebElement rightArrow = getDriver().findElement(By.xpath("//*[@id='quickShop_recommendations_right']"));
        String pageIndex = getDriver().findElement(By.xpath("//*[@id='quickShop_recommendations_of']")).getText();
        WebElement suggestedPurchasesContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_recommendations']"));
        List<WebElement> suggestions = suggestedPurchasesContainer.findElements(By.xpath(".//h3[@class='mjr-product-name']"));
        int modIndex = carouselIndexing(suggestions.size(), Integer.valueOf(pageIndex));

        for (WebElement product : suggestions) {
            product = getDriver().findElement(By.xpath("(//div[@id='quickShop_recommendations']//h3[@class='mjr-product-name'])[" + elementIndex + "]"));
            UtilityHelper.moveToViewElement(product);
            if (elementIndex % modIndex == 0) {
                UtilityHelper.moveToViewElement(rightArrow);
                UtilityHelper.click(rightArrow);
            }
            UtilityHelper.waitUntilClickable(product);
            elementIndex++;
            String productName = product.getText();
            Assert.assertTrue("=== Verify suggested purchases match previous results: ", suggestionsList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifySuggestedPurchasesViewAllListMatchesPreviousState() {
        System.out.println("suggested purchases does not have a view all link");
    }

    //this and its cousins appear to be grabbing products indiscriminantly, instead of products from their given category.
    public void storeFrequentPurchasesList() {
        WebElement frequentPurchasesContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_frequent']"));
        List<WebElement> purchases = frequentPurchasesContainer.findElements(By.xpath("//h3[@class='mjr-product-name']"));

        for (WebElement product : purchases) {
            frequentPurchasesList.add(product.getText());
        }
    }

    public void storeFrequentPurchasesListViewAll() {
        List<WebElement> purchases = getDriver().findElements(By.xpath("//h3[@class='mjr-product-name']"));
        int elementIndex = 1;
        for (WebElement product : purchases) {
            product = getDriver().findElement(By.xpath("(//h3[@class='mjr-product-name'])[" + elementIndex + "]"));
            UtilityHelper.moveToViewElement(product);
            String name = UtilityHelper.elementGetText(product);
            frequentPurchasesList.add(name);
            elementIndex++;
        }
    }

    public void verifyFrequentPurchasesListMatchesPreviousState() {
        WebElement frequentPurchasesContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_frequent']"));
        List<WebElement> frequentPurchases = frequentPurchasesContainer.findElements(By.xpath("//h3[@class='mjr-product-name']"));

        for (WebElement product : frequentPurchases) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify frequent purchases match previous results: ", frequentPurchasesList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifyViewAllFrequentPurchasesListMatchesPreviousState() {
        List<WebElement> frequentPurchases = getDriver().findElements(By.xpath("//h3[@class='mjr-product-name']"));
        int elementIndex = 1;
        Assert.assertTrue("=== Verify frequent purchases list is not empty: ", frequentPurchases.size() > 0);

        for (WebElement product : frequentPurchases) {
            product = getDriver().findElement(By.xpath("(//h3[@class='mjr-product-name'])[" + elementIndex + "]"));
            UtilityHelper.moveToViewElement(product);
            String productName = UtilityHelper.elementGetText(product);
            Assert.assertTrue("=== Verify frequent purchases match previous results: ", frequentPurchasesList.contains(productName));
            System.out.println("Product exists: " + productName);
            elementIndex++;
        }
    }

    public void verifyFrequentPurchasesViewAllListMatchesPreviousState() {
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li//*[@class='mjr-product-name']//a"));

        Assert.assertTrue("=== Verify frequent purchases list is not empty: ", products.size() > 0);

        for (WebElement product : products) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify frequent purchases view all match previous results: ", frequentPurchasesList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifyActiveOrderMessageIsNotDisplayedInHeaderWidget() {
        String activeOrderMessage = getDriver().findElement(By.xpath("//div[@class='fl curbsideMessage']")).getText();
        Assert.assertFalse(activeOrderMessage.equals("Your Curbside Pickup"));
    }

    public void verifyHeaderWidgetIsNotPresent() {
        //TODO: may be hidden and not simply nonexistant. so make sure this function works as intended
        Assert.assertTrue(" === Verify curbside header does not appear: ", UtilityHelper.elementNotExists(By.xpath("//div[@class='fl curbsideMessage']")));
//     Assert.assertEquals(" === Verify curbside header does not appear: ", getDriver().findElement(By.xpath(getDriver().findElement(By.xpath("//input[@class='quantity']")).getAttribute("hidden"))));
    }

    public void verifyHeaderWidgetSaysReserveCurbsidePickupTime() {
        String activeOrderMessage = UtilityHelper.elementGetText(RESERVE_CURBSIDE_PICKUP_TIME_LINK);
        System.out.println(activeOrderMessage);
        Assert.assertTrue(activeOrderMessage.contains("Reserve Curbside Pickup Time"));
    }

    public void verifyOrdersPageLoads() {
        WebElement pickupSummary = getDriver().findElement(By.xpath("//div[@id='pickupSummary']"));
        UtilityHelper.waitUntilClickable(pickupSummary);
    }

    public void userClicksViewAllFromFrequentPurchases() {
        WebElement frequentPurchasesBlock = getDriver().findElement(By.xpath("//div[contains(@class, 'frequentPurchases')]"));
        WebElement viewAllLink = frequentPurchasesBlock.findElement(By.xpath(".//a[contains(@class, 'viewmore') and text()='View All']"));

        UtilityHelper.waitUntilClickable(viewAllLink);
        UtilityHelper.click(viewAllLink);
    }

    public void storeFavoritesList() {
        WebElement favoritesListContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_favorited']"));
        List<WebElement> favorites = favoritesListContainer.findElements(By.xpath(".//h3[@class='mjr-product-name']"));

        for (WebElement favorite : favorites) {
            favoritesList.add(favorite.getText());
        }
    }

    public void validateFavoritesListMatchesPreviousState() {
        WebElement favoritesListContainer = getDriver().findElement(By.xpath("//div[@id='quickShop_favorited']"));
        List<WebElement> favorites = favoritesListContainer.findElements(By.xpath(".//h3[@class='mjr-product-name']"));

        for (WebElement product : favorites) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify favorites match previous results: ", favoritesList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void verifyFavoritesViewAllListMatchesPreviousState() {
        List<WebElement> products = getDriver().findElements(By.xpath("//*[@id='tierResults']/div[3]/ul/li//*[@class='mjr-product-name']//a"));
        for (WebElement product : products) {
            String productName = product.getText();
            Assert.assertTrue("=== Verify favorites view all match previous results: ", favoritesList.contains(productName));
            System.out.println("Product exists: " + productName);
        }
    }

    public void userClicksDesiredIconOnProductViaQuickShopPage(String icon) {
        UtilityHelper.shuffleList(1, 3);
        int index = UtilityHelper.popShuffledList();// select a random number 1-5
        WebElement element = getDriver().findElement(By.xpath("//*[@id='quickShop_frequent']/ul/li[" + index + "]"));
        UtilityHelper.moveToViewElement(element);
        favoritesAndShoppingListIconAction(element, icon);
    }

    public void clickOnProductIconViaSearchResults(WebElement element, String icon) {
        favoritesAndShoppingListIconAction(element, icon);
    }

    private void favoritesAndShoppingListIconAction(WebElement element, String icon) {
        switch (icon.toLowerCase()) {
            case "heart":
                By fav_icon = By.xpath(".//button[contains(@class,'addToFav')]/i");
                UtilityHelper.waitUntilClickable(element.findElement(fav_icon));
                UtilityHelper.click(element.findElement(fav_icon));
                break;
            case "list":
                By list_icon = By.xpath(".//button[contains(@class,'addToList')]/i");
                UtilityHelper.waitUntilClickable(element.findElement(list_icon));
                UtilityHelper.click(element.findElement(list_icon));
                break;
        }
    }

    public void verifySuccessfulActiveOrderDateAndTimeInHeaderWidget() {
        UtilityHelper.waitUntilElementVisible(activeOrderPickupTimeDisplayCurbsideWidgetHP);
        String value = activeOrderPickupTimeDisplayCurbsideWidgetHP.getText();
        String storePickUpTime = OrderPickupPage.pickupTime.substring(0, 1);
        String firstValue = storePickUpTime.substring(0, 1);

        Assert.assertTrue("Verify DATE of Active Order Header Widget: ", value.toUpperCase().contains(OrderPickupPage.pickupDate));
        if (firstValue.equals("0")) {
            String removeFirstIndex = storePickUpTime.substring(1);
            Assert.assertTrue("Verify TIME of Active Order Header Widget: ", value.toUpperCase().contains(removeFirstIndex));
        } else {
            Assert.assertTrue("Verify TIME of Active Order Header Widget: ", value.toUpperCase().contains(storePickUpTime));
        }
    }

    public void verifyBreadcrumbIsDisplayedBelowTitleAndManagedContent() {
        WebElement managedContent = getDriver().findElement(By.xpath("//div[@class='container mjr-manContentBillboard']"));
        WebElement pageTitle = getDriver().findElement(By.xpath("//h1[@class='mjr-page-title']"));
        OneItemBeforeAnotherItem(managedContent, pageTitle, breadcrumbs);
    }

    public void verifyBestSellersCarouselIsDisplayed() {
        WebElement BEST_SELLERS_CAROUSEL = getDriver().findElement(By.xpath("//*[@id='topSellers']"));
        Assert.assertTrue(BEST_SELLERS_CAROUSEL.isDisplayed());
    }

    public void userClickOnProductNameInProductTile() {
        WebElement BEST_SELLER_NAME = getDriver().findElement(By.xpath("//*[@id='section_topSellers']//li[3]//h3/a"));
        UtilityHelper.click(BEST_SELLER_NAME);
    }

    public void verifyBestSellersCarouselHasTotalOf20Products() {
        int elementIndex = 1;
        WebElement BEST_SELLERS_RIGHT_ARROW = getDriver().findElement(By.xpath("//*[@id='section_topSellers_right']"));
        List<WebElement> BEST_SELLERS_ITEMS = getDriver().findElements(By.xpath("//div[@id='section_topSellers']/ul/li"));
        int countOfBestSellerItems = BEST_SELLERS_ITEMS.size();
        String numberOfBestSellerPages = getDriver().findElement(By.xpath("//*[@id='section_topSellers_of']")).getText();
        UtilityHelper.moveToViewElement(BEST_SELLERS_ITEMS.get(0));
        for (WebElement item : BEST_SELLERS_ITEMS) {
            int modIndex = carouselIndexing(countOfBestSellerItems, Integer.valueOf(numberOfBestSellerPages));
            item = getDriver().findElement(By.xpath("//div[@id='section_topSellers']/ul/li[" + elementIndex + "]"));
            UtilityHelper.waitUntilClickable(item);

            if (elementIndex % modIndex == 0) {
                UtilityHelper.click(BEST_SELLERS_RIGHT_ARROW);
            }
            elementIndex++;
            WebElement itemName = item.findElement(By.xpath(".//*[@class='mjr-product-name']//a"));
            System.out.println(itemName.getText());
            System.out.println("**********************************************************************");
        }
        Assert.assertTrue("There is not 20 items in the best Sellers Carousel", countOfBestSellerItems == 20);
    }

    private int carouselIndexing(int totalItems, int numberOfPages) {
        return (totalItems / numberOfPages);
    }

    public void userClickViewAllFromBestSellersCarousel() {
        WebElement VIEW_ALL_BEST_SELLERS_LINK = getDriver().findElement(By.xpath("//*[@id='section_topSellers_controls']/a[@class='viewmore mjr-link']"));
        UtilityHelper.waitUntilClickable(VIEW_ALL_BEST_SELLERS_LINK);
        UtilityHelper.click(VIEW_ALL_BEST_SELLERS_LINK);
    }

    public void verifyViewAllBestSellersPageDisplays() {
        WebElement VIEW_ALL_TOP_SELLERS_HEADER = getDriver().findElement(By.xpath("//h1[@class='quickShopHeadline']"));
        Assert.assertTrue(VIEW_ALL_TOP_SELLERS_HEADER.isDisplayed());
    }
}

