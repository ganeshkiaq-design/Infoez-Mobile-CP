package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    public AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
    }

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

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editableSearchField;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'PITSHOP') or contains(@text, 'PITSHOP') or self::android.widget.Button]")
    public WebElement matchingSearchResult;

    @AndroidFindBy(xpath = "//*[contains(@text, 'No matching') or contains(@text, 'No result') or contains(@text, 'Empty')]")
    public WebElement searchEmptyState;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter') or contains(@text, 'required') or contains(@text, 'empty')]")
    public WebElement searchValidationMessage;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restaurants\")")
    public WebElement restaurantsCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty & Spa\")")
    public WebElement beautyCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fitness & Wellness\")")
    public WebElement fitnessCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fitness\")")
    public WebElement fitnessCategoryShort;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home Services\")")
    public WebElement homeServicesCategory;

    @AndroidFindBy(xpath = "//*[@text='Restaurants' or @content-desc='Restaurants']")
    public WebElement categoryOption;

    @AndroidFindBy(xpath = "//*[@text='See all' or @text='See All']")
    public WebElement seeAllCategories;

    @AndroidFindBy(xpath = "//*[contains(@text,'Categories')]")
    public WebElement allCategoriesScreen;


    // ================= BOTTOM NAVIGATION =================

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
    public WebElement homeTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\")")
    public WebElement searchTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved\")")
    public WebElement savedTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
    public WebElement profileTab;

    @AndroidFindBy(xpath = "//*[@text='Home' or @content-desc='Home']")
    public WebElement navigationOption;


    // ================= LOCATION NAVIGATION =================

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='']")
    public WebElement locationDropdown;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='android:id/content']//android.view.ViewGroup[2]")
    public WebElement locationSelectionScreen;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement locationSearchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai\")")
    public WebElement chennaiLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bangalore\")")
    public WebElement bangaloreLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mumbai\")")
    public WebElement mumbaiLocation;

    @AndroidFindBy(xpath = "//*[contains(@text,'Location not found') or contains(@text,'No location')]")
    public WebElement locationNotFoundMessage;

    @AndroidFindBy(xpath = "//*[contains(@text,'Chennai, India') or contains(@content-desc,'Chennai, India')]")
    public WebElement selectedLocation;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=', Near me']")
    public WebElement nearbyPlacesScreen;

    @AndroidFindBy(xpath = "//*[contains(@text,'Nearby') or contains(@text,'Near me')]")
    public WebElement nearbyResults;

    @AndroidFindBy(xpath = "//*[contains(@text,'permission') or contains(@text,'location access')]")
    public WebElement locationPermissionMessage;

    @AndroidFindBy(xpath = "//*[contains(@text,'Featured') or contains(@text,'Places')]")
    public WebElement featuredPlacesScreen;

}
