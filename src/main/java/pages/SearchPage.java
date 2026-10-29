package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {
    public AndroidDriver driver;
    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"search-input\")")
    public WebElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"search-button\")")
    public WebElement searchButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Explore businesses\")")
    public WebElement exploreBusinessesTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Aroma Cafe\")")
    public WebElement businessNames;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"chip-verified\")")
    public WebElement verifiedFilter;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"4+ rating\")")
    public WebElement ratingFilter;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Featured\")")
    public WebElement featuredFilter;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Most relevant\")")
    public WebElement sortOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Open today\")")
    public WebElement openToday;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"5.0\")")
    public WebElement rating;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Road\")")
    public WebElement location;

    @AndroidFindBy(xpath = "//*[@text=\"Aroma Cafe\" or @content-desc=\"Aroma Cafe\"]")
    public WebElement dynamicBusiness;

    @AndroidFindBy(xpath = "//*[@text=\"Aroma Cafe\" or @content-desc=\"Aroma Cafe\"]")
    public WebElement dynamicResult;

    @AndroidFindBy(xpath = "//*[@text=\"Most relevant\"]")
    public WebElement dynamicSortOption;

}
