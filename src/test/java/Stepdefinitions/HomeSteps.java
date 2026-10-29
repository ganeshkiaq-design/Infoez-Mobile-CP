
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.HomePage;

import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class HomeSteps {

    AndroidDriver driver;
    HomePage page;
    WebDriverWait wait;

    void initialize() {

        driver = (AndroidDriver)
                DriverSessionManager.getDriver();

        Assert.assertNotNull(
            driver,
            "Appium driver is not initialized. Check Hooks."
        );

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(20)
        );

        page = new HomePage(driver);
    }

   void click(WebElement element) {

        wait.until(
            ExpectedConditions.elementToBeClickable(element)
        ).click();
    }

    void show(WebElement element) {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(element)
            ).isDisplayed(),
            "Expected element is not displayed"
        );
    }

    void enter(WebElement element, String value) {

        WebElement field = wait.until(
            ExpectedConditions.visibilityOf(element)
        );

        field.clear();
        field.sendKeys(value);
    }

    @Given("user is on the Infoez home page")
    public void home() {

        initialize();

        show(page.searchField);
    }

    @Then("the current location should be visible")
    public void location() {

        show(page.currentLocation);
    }

    @Then("the search field should be visible")
    public void searchField() {

        show(page.searchField);
    }

    @Then("the Near me button should be visible")
    public void nearMe() {

        show(page.nearMeButton);
    }

    @Then("the Explore categories section should be visible")
    public void categories() {

        show(page.exploreCategories);
    }

    @Then("the Featured in Chennai section should be visible")
    public void featured() {

        show(page.featuredSection);
    }

    @Then("the bottom navigation should be visible")
    public void bottom() {

        show(page.homeTab);
        show(page.searchTab);
        show(page.savedTab);
        show(page.profileTab);
    }

   @When("user enters {string} in the search field")
    public void search(String keyword) {

        click(page.searchField);
        enter(page.editableSearchField, keyword);
    }

    @When("user taps the search button")
    public void searchButton() {

        click(page.searchButton);
    }

    @Then("search results should be displayed for {string}")
    public void results(String keyword) {

        show(page.matchingSearchResult);
    }

   Map<String, WebElement> categoriesMap() {

        return Map.of(
            "Restaurants", page.restaurantsCategory,
            "Beauty & Spa", page.beautyCategory,
            "Fitness", page.fitnessCategory
        );
    }

    @When("user selects the {string} category")
    public void category(String category) {

        Assert.assertTrue(
            categoriesMap().containsKey(category),
            "Unknown category: " + category
        );

        click(categoriesMap().get(category));
    }

    @Then("the selected category page should be displayed for {string}")
    public void categoryPage(String category) {

        Assert.assertTrue(
            categoriesMap().containsKey(category),
            "Unknown category: " + category
        );

        show(categoriesMap().get(category));
    }

    Map<String, WebElement> navigationMap() {

        return Map.of(
            "Home", page.homeTab,
            "Search", page.searchTab,
            "Saved", page.savedTab,
            "Profile", page.profileTab
        );
    }

    @When("user taps the {string} tab")
    public void tab(String tab) {

        Assert.assertTrue(
            navigationMap().containsKey(tab),
            "Unknown navigation tab: " + tab
        );

        click(navigationMap().get(tab));
    }

    @Then("the {string} page should be displayed")
    public void tabPage(String tab) {

        Assert.assertTrue(
            navigationMap().containsKey(tab),
            "Unknown page: " + tab
        );

        show(navigationMap().get(tab));
    }

   @When("user taps the current location")
    public void tapLocation() {

        click(page.currentLocation);
    }

    @Then("the location selection screen should be displayed")
    public void locationScreen() {

        show(page.locationSelectionScreen);
    }

    @When("user taps the Near me button")
    public void tapNearMe() {

        click(page.nearMeButton);
    }

    @Then("the nearby places screen should be displayed")
    public void nearby() {

        show(page.nearbyPlacesScreen);
    }

    // =====================================
    // FEATURED PLACES
    // =====================================

    @When("user taps View all in the featured section")
    public void viewAll() {

        click(page.viewAllFeatured);
    }

    @Then("the featured places screen should be displayed")
    public void featuredPlaces() {

        show(page.featuredPlacesScreen);
    }
}
