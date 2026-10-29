package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationsPage {
    public AndroidDriver driver;
    public NotificationsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(accessibility = ", Notifications, ")
    public WebElement notificationsButton;

    @AndroidFindBy(accessibility = "notification-item")
    public WebElement notificationItem;

}
