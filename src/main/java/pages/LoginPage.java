package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

    public AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='login-email']"
    )
    public WebElement emailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='login-password']"
    )
    public WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Log in')]"
    )
    public WebElement loginButton;

   @AndroidFindBy(id = "com.infoez.app:id/error_message"
    )
    public WebElement errorLabel;

    @AndroidFindBy(id = "com.infoez.app:id/home_or_explore_indicator"
    )
    public WebElement homeOrExploreIndicator;
}
