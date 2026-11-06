package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Map;

public class HomeSteps {

    AndroidDriver driver;
    HomePage page;

    @Before(order = 1)
    public void initialize() {

        driver = (AndroidDriver) DeviceSessionManager.getDriver();

        Assert.assertNotNull(driver,"Appium driver is not initialized. Check Hooks.");
        page = new HomePage(driver);
    }

    @Given("user is on the Infoez home page")
    public void home() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.searchField), 
        		"Infoez home page is not displayed");
    }

    @Then("the current location should be visible")
    public void location() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.currentLocation),
            "Current location is not displayed"
        );
    }

    @Then("the search field should be visible")
    public void searchField() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.searchField),
            "Search field is not displayed");
    }

    @Then("the Near me button should be visible")
    public void nearMe() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.nearMeButton),
            "Near me button is not displayed");
    }

    @Then("the Explore categories section should be visible")
    public void categories() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.exploreCategories),
            "Explore categories section is not displayed");
    }

    @Then("the Featured in Chennai section should be visible")
    public void featured() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.featuredSection),
            "Featured in Chennai section is not displayed");
    }

    @Then("the bottom navigation should be visible")
    public void bottom() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.homeTab),
            "Home tab is not displayed");

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.searchTab),
            "Search tab is not displayed");

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.savedTab),
            "Saved tab is not displayed"
        );

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.profileTab),
            "Profile tab is not displayed");
    }


    @When("user enters {string} in the search field")
    public void search(String keyword) {

        BaseClass.click(driver, page.searchField);
        BaseClass.clear(driver, page.editableSearchField);

        if (!keyword.equals("EMPTY") && !keyword.equals("SPACES")) {

            BaseClass.sendKeys(driver, page.editableSearchField, keyword);
        }

        if (keyword.equals("SPACES")) {

            BaseClass.sendKeys(driver, page.editableSearchField, "   ");
        }
    }

    @When("user taps the search button")
    public void searchButton() {

        BaseClass.click(driver, page.searchButton);
    }

    @Then("search results should be displayed for {string}")
    public void results(String keyword) {

        Assert.assertTrue(
            BaseClass.isElementDisplayed(driver, page.matchingSearchResult),
            "Search results are not displayed for: " + keyword
        );
    }

    @Then("the home search should show no matching result")
    public void noHomeSearchResults() {

        Assert.assertTrue(
            BaseClass.isElementDisplayed(driver, page.searchEmptyState),
            "Search empty state is not displayed"
        );
    }
    Map<String, WebElement> categoriesMap() {

        return Map.of("Restaurants", page.restaurantsCategory,
            "Beauty & Spa", page.beautyCategory,
            "Fitness", page.fitnessCategory);
    }

    @When("user selects the {string} category")
    public void category(String category) {

        Assert.assertTrue(categoriesMap().containsKey(category),
            "Unknown category: " + category);

        BaseClass.click(driver,categoriesMap().get(category)
        );
    }

    @Then("the selected category page should be displayed for {string}")
    public void categoryPage(String category) {

        Assert.assertTrue(categoriesMap().containsKey(category),
            "Unknown category: " + category);

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.categoryOption),
            "Category page view is not displayed for: " + category);
    }

    Map<String, WebElement> navigationMap() {

        return Map.of("Home", page.homeTab,
            "Search", page.searchTab,
            "Saved", page.savedTab,
            "Profile", page.profileTab);
    }

    @When("user taps the {string} tab")
    public void tab(String tab) {

        Assert.assertTrue(navigationMap().containsKey(tab),
            "Unknown navigation tab: " + tab);

        BaseClass.click(driver,navigationMap().get(tab));
    }

    @Then("the {string} page should be displayed")
    public void tabPage(String tab) {

        Assert.assertTrue(navigationMap().containsKey(tab),
            "Unknown page name: " + tab);

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.navigationOption),
            "Target navigation page view is not displayed: " + tab);
    }

    @When("user taps the current location")
    public void tapLocation() {

        BaseClass.click(driver, page.currentLocation);
    }

    @Then("the location selection screen should be displayed")
    public void locationScreen() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.locationSelectionScreen),
            "Location selection screen is not displayed");
    }
    @When("user taps the Near me button")
    public void tapNearMe() {

        BaseClass.click(driver, page.nearMeButton);
    }

    @Then("the nearby places screen should be displayed")
    public void nearby() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.nearbyPlacesScreen),
            "Nearby places screen is not displayed"
        );
    }

    @When("user taps View all in the featured section")
    public void viewAll() {

        BaseClass.click(driver, page.viewAllFeatured);
    }

    @Then("the featured places screen should be displayed")
    public void featuredPlaces() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.featuredPlacesScreen),
            "Featured places screen is not displayed");
    }
}
