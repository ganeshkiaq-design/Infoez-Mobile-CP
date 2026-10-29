
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.FavoritesPage;

import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import java.time.Duration;

public class FavoritesSteps {

    AndroidDriver driver;
    FavoritesPage page;
    WebDriverWait wait;

    @Before(order = 1)
    public void initialize() {

        driver = (AndroidDriver)
                DriverSessionManager.getDriver();

        Assert.assertNotNull(
            driver,
            "Appium driver is not initialized"
        );

        page = new FavoritesPage(driver);

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(20)
        );
    }

    // ADD FAVORITES

    @When("I add the business to Favorites")
    public void addFavorite() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.favoriteButton
            )
        ).click();
    }

    // REMOVE FAVORITES

    @When("I remove the business from Favorites")
    public void removeFavorite() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.removeFavoriteButton
            )
        ).click();
    }

    // PERFORM ADD

    @When("I perform Add on the business Favorites")
    public void performAdd() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.favoriteButton
            )
        ).click();
    }

    // PERFORM REMOVE

    @When("I perform Remove on the business Favorites")
    public void performRemove() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.removeFavoriteButton
            )
        ).click();
    }

    // OPEN FAVORITES

    @When("I open Favorites")
    public void openFavorites() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.favoritesMenu
            )
        ).click();
    }

    // VERIFY SAVED BUSINESS

    @Then("the saved business should be displayed")
    public void savedBusiness() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.savedBusiness
                )
            ).isDisplayed(),
            "Saved business is not displayed"
        );
    }
}
