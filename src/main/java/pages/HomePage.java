package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    public AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")"
    )
    public WebElement currentLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='What are you looking for?']"
    )
    public WebElement searchField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='']"
    )
    public WebElement searchButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=', Near me']"
    )
    public WebElement nearMeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore categories']"
    )
    public WebElement exploreCategories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Featured in Chennai']"
    )
    public WebElement featuredSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='']"
    )
    public WebElement bottomNavigation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View all']"
    )
    public WebElement viewAllFeatured;

   @AndroidFindBy(className = "android.widget.EditText"
    )
    public WebElement editableSearchField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"A, AS PITSHOP, , 0.0, · 0 reviews, · ,  3/98r Chennai, Chennai, ￼ Open today, $$$, , Verified\"]"
    )
    public WebElement matchingSearchResult;

   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restaurants\")"
    )
    public WebElement restaurantsCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty & Spa\")"
    )
    public WebElement beautyCategory;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Fitness\")"
    )
    public WebElement fitnessCategory;

    @AndroidFindBy(xpath = "//*[@text='Restaurants' or @content-desc='Restaurants']"
    )
    public WebElement categoryOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")"
    )
    public WebElement homeTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\")"
    )
    public WebElement searchTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved\")"
    )
    public WebElement savedTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")"
    )
    public WebElement profileTab;

    @AndroidFindBy(xpath = "//*[@text='Home' or @content-desc='Home']"
    )
    public WebElement navigationOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"
    )
    public WebElement locationSelectionScreen;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=', Near me']"
    )
    public WebElement nearbyPlacesScreen;

    @AndroidFindBy(xpath = "//*[contains(@text,'Featured') or contains(@text,'Places')]"
    )
    public WebElement featuredPlacesScreen;
}
