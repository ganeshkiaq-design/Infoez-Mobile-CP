package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Createaccountpage {

    public AndroidDriver driver;

    public Createaccountpage(AndroidDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }

    @AndroidFindBy(xpath ="//*[@text='Create account'][1]")
    public WebElement createAccountTab;

    @AndroidFindBy(xpath ="//*[@text='Infoez']")
    public WebElement createAccountTitle;

    @AndroidFindBy(xpath ="//*[@text='Customer'][1]")
    public WebElement customerOption;

    @AndroidFindBy(xpath ="//*[@text='Business owner']")
    public WebElement businessOwnerOption;

    @AndroidFindBy(xpath ="//*[@text='Your name' or @hint='Your name']")
    public WebElement fullNameInput;

    @AndroidFindBy(xpath ="//*[@text='you@example.com' or " + "@hint='you@example.com']")
    public WebElement emailInput;

    @AndroidFindBy(xpath ="//*[@text='At least 8 characters' or " +"@hint='At least 8 characters']")
    public WebElement passwordInput;

    @AndroidFindBy(xpath ="(//*[@text='Create account'])[last()]")
    public WebElement createAccountButton;

    @AndroidFindBy(xpath ="//*[contains(@text,'success') or " +
        "contains(@text,'Welcome') or " + "contains(@text,'created')]")
    public WebElement registrationSuccessMessage;

    @AndroidFindBy(xpath ="//*[contains(@text,'invalid') or " +
        "contains(@text,'valid email') or " + "contains(@text,'email address')]")
    public WebElement invalidEmailMessage;

    @AndroidFindBy(xpath ="//*[contains(@text,'8 characters') or " + "contains(@text,'too short')]")
    public WebElement shortPasswordMessage;

    @AndroidFindBy(xpath ="//*[@text='Log in']")
    public WebElement loginTab;

    @AndroidFindBy(xpath ="//*[contains(@text,'Welcome back') or " + "contains(@text,'Forgot password')]")
    public WebElement loginScreenTitle;

    @AndroidFindBy(xpath ="(//*[@text='Customer'])[last()]")
    public WebElement customerDemoButton;

    @AndroidFindBy(xpath ="//*[contains(@text,'Explore') or " + "contains(@text,'Home')]")
    public WebElement customerDemoHome;

    @AndroidFindBy(xpath ="//*[@content-desc='Close' or @text='×']")
    public WebElement closeButton;

    @AndroidFindBy(xpath ="(//*[@text='Owner'])[last()]")
    public WebElement ownerDemoButton;

    @AndroidFindBy(xpath ="//*[@text='Admin']")
    public WebElement adminDemoButton;

}
