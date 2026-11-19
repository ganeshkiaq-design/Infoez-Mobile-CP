package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {

    public AndroidDriver driver;
    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Murali\")")
    public WebElement profileName;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"customer@infoez.com\")")
    public WebElement profileEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Customer account\")")
    public WebElement customerAccount;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your Infoez space\")")
    public WebElement profileHeading;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
    public WebElement profileTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
    public WebElement homeTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\")")
    public WebElement searchTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved\")")
    public WebElement savedTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Explore businesses\")")
    public WebElement exploreBusinesses;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved places\")")
    public WebElement savedPlaces;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"My enquiries\")")
    public WebElement myEnquiries;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Notifications\")")
    public WebElement notifications;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\"]")
    public WebElement logoutButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    public WebElement logoutConfirmation;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Log in\"]")
    public WebElement loginScreen;

    @AndroidFindBy(xpath = "//*[@text='Explore businesses' or @text='Explore' or @text='Search businesses']")
    public WebElement exploreDestination;

    @AndroidFindBy(xpath = "//*[@text='Saved places' or @text='Saved']")
    public WebElement savedDestination;

    @AndroidFindBy(xpath = "//*[@text='My enquiries' or @text='Enquiries']")
    public WebElement enquiriesDestination;

    @AndroidFindBy(xpath = "//*[@text='Notifications']")
    public WebElement notificationsDestination;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    public WebElement businessSearchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Search\")")
    public WebElement businessSearchButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"No businesses\")")
    public WebElement noBusinessMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Explore businesses\")")
    public WebElement businessListing;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add to favorites\")")
    public WebElement addFavoriteButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Remove from favorites\")")
    public WebElement removeFavoriteButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").instance(1)")
    public WebElement businessResult;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquiries\")")
    public WebElement enquiriesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    public WebElement enquiryMessageField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit\")")
    public WebElement submitEnquiryButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"success\")")
    public WebElement enquirySuccessMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"required\")")
    public WebElement enquiryValidationError;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Claim Approved\")")
    public WebElement claimApprovedNotification;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Claim Rejected\")")
    public WebElement claimRejectedNotification;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
    public WebElement businessText;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
    public WebElement notificationText;

}
