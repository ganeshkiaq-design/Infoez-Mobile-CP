package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FavoritesPage {

    public FavoritesPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(accessibility = "add-to-favorites")
    public WebElement favoriteButton;

    @AndroidFindBy(accessibility = "remove-from-favorites")
    public WebElement removeFavoriteButton;

    @AndroidFindBy(accessibility = "favorites-menu")
    public WebElement favoritesMenu;

    @AndroidFindBy(accessibility = "saved-business")
    public WebElement savedBusiness;
}
