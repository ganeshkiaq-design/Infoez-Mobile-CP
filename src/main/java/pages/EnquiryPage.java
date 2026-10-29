package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryPage {

    public EnquiryPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(accessibility = "enquiries-button")
    public WebElement enquiriesButton;

    @AndroidFindBy(accessibility = "enquiry-message")
    public WebElement messageField;

    @AndroidFindBy(accessibility = "submit-enquiry")
    public WebElement submitButton;

    @AndroidFindBy(accessibility = "enquiry-success")
    public WebElement successMessage;

    @AndroidFindBy(accessibility = "enquiry-validation-error")
    public WebElement validationError;
}
