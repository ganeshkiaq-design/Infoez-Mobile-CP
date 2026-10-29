package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BusinessPage {

    public BusinessPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(5)),this);
    }

   @AndroidFindBy(
        xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]"
    )
    public WebElement businessDetails;

   @AndroidFindBy(
        xpath = "//android.view.ViewGroup[@content-desc=', Call']/android.view.ViewGroup"
    )
    public WebElement callButton;

   @AndroidFindBy(
        xpath = "//android.view.ViewGroup[@content-desc=', WhatsApp']/android.view.ViewGroup"
    )
    public WebElement whatsAppButton;

   @AndroidFindBy(
        xpath = "//android.view.ViewGroup[@content-desc=', Directions']/android.view.ViewGroup"
    )
    public WebElement directionsButton;

   @AndroidFindBy(
        xpath = "//android.view.ViewGroup[@content-desc=', Share']/android.view.ViewGroup"
    )
    public WebElement shareButton;
}
