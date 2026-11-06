
package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SavedPage {

    public AndroidDriver driver;

    public SavedPage(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
            new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved\")")
    public WebElement savedTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved places\")")
    public WebElement savedPlacesScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"5 places worth coming back to\")")
    public WebElement savedPlacesCount;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Petal & Loom Bakery\")")
    public WebElement placeName;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"5.0\")")
    public WebElement placeRating;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"2 reviews\")")
    public WebElement reviewCount;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Jubilee Hills, Hyderabad\")")
    public WebElement placeLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Remove from favorites\")")
    public WebElement removeFavoriteButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"No saved places\")")
    public WebElement emptySavedPlaces;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Location unavailable\")")
    public WebElement locationUnavailable;

}
