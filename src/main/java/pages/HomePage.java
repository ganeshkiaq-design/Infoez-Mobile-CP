
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.support.PageFactory;

public class HomePage {

    public AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
            new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),
            this
        );
    }

    // ================= HOME SCREEN ELEMENTS =================

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Infoez']")
    public WebElement infoezLogo;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")")
    public WebElement currentLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='What are you looking for?']")
    public WebElement searchField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='']")
    public WebElement searchButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=', Near me']")
    public WebElement nearMeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore categories']")
    public WebElement exploreCategories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Featured in Chennai']")
    public WebElement featuredSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='']")
    public WebElement bottomNavigation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View all']")
    public WebElement viewAllFeatured;


    // ================= SEARCH ELEMENTS =================

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editableSearchField;

    @AndroidFindBy(xpath =
        "//*[contains(@content-desc,'PITSHOP') or " +
        "contains(@text,'PITSHOP') or self::android.widget.Button]")
    public WebElement matchingSearchResult;

    @AndroidFindBy(xpath =
        "//*[contains(@text,'No matching') or " +
        "contains(@text,'No result') or contains(@text,'Empty')]")
    public WebElement searchEmptyState;

    @AndroidFindBy(xpath =
        "//*[contains(@text,'Please enter') or " +
        "contains(@text,'required') or contains(@text,'empty')]")
    public WebElement searchValidationMessage;


    // ================= EXPLORE CATEGORIES =================

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restaurants\")")
    public WebElement restaurantsCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty & Spa\")")
    public WebElement beautyCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fitness & Wellness\")")
    public WebElement fitnessCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home Services\")")
    public WebElement homeServicesCategory;

    @AndroidFindBy(xpath = "//*[@text='Restaurants' or @content-desc='Restaurants']")
    public WebElement categoryOption;

    @AndroidFindBy(xpath = "//*[@text='See all' or @text='See All']")
    public WebElement seeAllCategories;

    @AndroidFindBy(xpath = "//*[contains(@text,'Categories')]")
    public WebElement allCategoriesScreen;


    // ================= LOCATION ELEMENTS =================

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='']")
    public WebElement locationDropdown;

    @AndroidFindBy(xpath =
        "//android.view.ViewGroup[@resource-id='android:id/content']//android.view.ViewGroup[2]")
    public WebElement locationSelectionScreen;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement locationSearchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai\")")
    public WebElement chennaiLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bangalore\")")
    public WebElement bangaloreLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mumbai\")")
    public WebElement mumbaiLocation;

    @AndroidFindBy(xpath =
        "//*[contains(@text,'Location not found') or " +
        "contains(@text,'No location')]")
    public WebElement locationNotFoundMessage;

    @AndroidFindBy(xpath =
        "//*[contains(@text,'permission') or " +
        "contains(@text,'location access')]")
    public WebElement locationPermissionMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Location')]")
    public WebElement locationMessage;


    // ================= NEAR ME ELEMENTS =================

    @AndroidFindBy(xpath =
        "//*[contains(@text,'Nearby') or contains(@text,'Near me')]")
    public WebElement nearbyPlacesScreen;

    @AndroidFindBy(xpath =
        "//*[contains(@text,'Nearby') or contains(@text,'Near me')]")
    public WebElement nearbyResults;


    // ================= FEATURED ELEMENTS =================

    @AndroidFindBy(xpath =
        "//*[contains(@text,'Featured') or contains(@text,'Places')]")
    public WebElement featuredPlacesScreen;


    // ================= DYNAMIC LOCATION LOCATOR =================

    public By getLocationOption(String location) {

        return AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"" + location + "\")"
        );
    }

    public By getSelectedLocation(String location) {

        return AppiumBy.xpath(
            "//*[contains(@text,'" + location + "') or " +
            "contains(@content-desc,'" + location + "')]"
        );
    }


    // ================= DYNAMIC CATEGORY LOCATOR =================

    public By getSelectedCategory(String category) {

        return AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"" + category + "\")"
        );
    }

}
