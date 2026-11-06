package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.SavedPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Savedbusiness {

    AndroidDriver driver;
    SavedPage page;

    @Before(order = 1)
    public void initialize() {

        driver = (AndroidDriver) DeviceSessionManager.getDriver();

        Assert.assertNotNull(driver,"Appium driver is not initialized. Check Hooks.");

        page = new SavedPage(driver);
    }

    @Given("the user launches the Infoez application")
    public void launchApplication() {

        Assert.assertNotNull(driver,"Infoez application is not launched");
    }

    @Given("the user navigates to the Saved Places module")
    public void navigateToSavedPlaces() {

        BaseClass.click(driver, page.savedTab);

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.savedPlacesScreen),
            "Saved Places screen is not displayed");
    }

    @When("the user views the saved places list")
    public void viewSavedPlaces() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.savedPlacesScreen),
            "Saved Places list is not displayed");
    }

    @Then("the saved places screen should be displayed")
    public void verifySavedPlacesScreen() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.savedPlacesScreen),
            "Saved Places screen is not displayed");
    }

    @Then("the saved places count should be {string}")
    public void verifySavedPlacesCount(String count) {

        Assert.assertEquals(BaseClass.gettext(driver, page.savedPlacesCount), count,
            "Saved places count is mismatched");
    }

    @Then("the place {string} should be displayed")
    public void verifyPlaceName(String placeName) {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.placeName),
            "Place name is not displayed");

        Assert.assertEquals(
            BaseClass.gettext(driver, page.placeName), placeName,
            "Place name is mismatched");
    }

    @Then("the rating should be {string}")
    public void verifyRating(String rating) {

        Assert.assertEquals(
            BaseClass.gettext(driver, page.placeRating),rating,
            "Place rating is mismatched");
    }

    @Then("the review count should be {string}")
    public void verifyReviewCount(String reviews) {

        Assert.assertEquals(BaseClass.gettext(driver, page.reviewCount), reviews,
            "Review count is mismatched");
    }

    @Then("the location should be {string}")
    public void verifyLocation(String location) {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.placeLocation),
            "Place location is not displayed");

        Assert.assertEquals(BaseClass.gettext(driver, page.placeLocation),
            location, "Place location is mismatched");
    }

    @Then("the application should handle {string} correctly")
    public void verifyNegativeCondition(String condition) {

        switch (condition) {

            case "No saved places":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.emptySavedPlaces),
                    "Empty saved places message is not displayed");

                break;

            case "Location name is unavailable":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.placeName),
                    "Place details are not displayed");
                Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.locationUnavailable),
                    "Location unavailable indicator is not displayed");
                break;
            default:
                Assert.fail("Unknown negative condition: " + condition);
        }
    }

    @Then("the application should display {string}")
    public void verifyExpectedResult(String expectedResult) {

        switch (expectedResult) {

            case "No saved places message":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.emptySavedPlaces),
                    "No saved places message is not displayed");
                break;

            case "Location unavailable message":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, page.locationUnavailable),
                    "Location unavailable message is not displayed");
                break;
            default:
                Assert.fail("Unknown expected result: " + expectedResult);
        }
    }
}
