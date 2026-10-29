package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewsPage {
    public AndroidDriver driver;
    public ReviewsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(accessibility = "reviews-button")
    public WebElement reviewsButton;

    @AndroidFindBy(accessibility = "review-text")
    public WebElement reviewField;

    @AndroidFindBy(accessibility = "submit-review")
    public WebElement submitReviewButton;

    @AndroidFindBy(accessibility = "review-success")
    public WebElement reviewSuccess;

    @AndroidFindBy(accessibility = "review-validation-error")
    public WebElement validationError;

    @AndroidFindBy(accessibility = "rating-1")
    public WebElement rating1;

    @AndroidFindBy(accessibility = "rating-2")
    public WebElement rating2;

    @AndroidFindBy(accessibility = "rating-3")
    public WebElement rating3;

    @AndroidFindBy(accessibility = "rating-4")
    public WebElement rating4;

    @AndroidFindBy(accessibility = "rating-5")
    public WebElement rating5;

}
