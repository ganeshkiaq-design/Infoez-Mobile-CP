package Stepdefinitions;

import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.SavedPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Savedbusiness extends BaseClass {
   
	private SavedPage lp;
   private AndroidDriver getDriver() {
       return (AndroidDriver) DeviceSessionManager.getDriver();
   }
   private SavedPage getPage() {
       if (lp == null) {
           lp = new SavedPage(getDriver());
       }
       return lp;
   }
   
   @Given("the user launches the Infoez application")
   public void launchApplication() {
       Assert.assertNotNull(
               getDriver(),
               "Infoez application is not launched"
       );
   }
   @Given("the user navigates to the Saved Places module")
   public void navigateToSavedPlaces() {
       visibilityWait(getDriver(), getPage().savedTab);
       click(getDriver(), getPage().savedTab);
       visibilityWait(getDriver(), getPage().savedPlacesScreen);
       Assert.assertTrue(
               getPage().savedPlacesScreen.isDisplayed(),
               "Saved Places screen is not displayed"
       );
   }
   @When("the user views the saved places list")
   public void viewSavedPlaces() {
       visibilityWait(getDriver(), getPage().savedPlacesScreen);
       Assert.assertTrue(
               getPage().savedPlacesScreen.isDisplayed(),
               "Saved Places list is not displayed"
       );
   }
   @Then("the saved places screen should be displayed")
   public void verifySavedPlacesScreen() {
       visibilityWait(getDriver(), getPage().savedPlacesScreen);
       Assert.assertTrue(
               getPage().savedPlacesScreen.isDisplayed(),
               "Saved Places screen is not displayed"
       );
   }
   @Then("the saved places count should be {string}")
   public void verifySavedPlacesCount(String count) {
       visibilityWait(getDriver(), getPage().savedPlacesCount);
       String actualCount = gettext(
               getDriver(),
               getPage().savedPlacesCount
       );
       Assert.assertEquals(
               actualCount,
               count,
               "Saved places count is mismatched"
       );
       System.out.println("Saved Places Count: " + actualCount);
   }
   @Then("the place {string} should be displayed")
   public void verifyPlaceName(String placeName) {
       visibilityWait(getDriver(), getPage().placeName);
       String actualPlaceName = gettext(
               getDriver(),
               getPage().placeName
       );
       Assert.assertEquals(
               actualPlaceName,
               placeName,
               "Place name is mismatched"
       );
       System.out.println("Place Name: " + actualPlaceName);
   }
   @Then("the rating should be {string}")
   public void verifyRating(String rating) {
       visibilityWait(getDriver(), getPage().placeRating);
       String actualRating = gettext(
               getDriver(),
               getPage().placeRating
       );
       Assert.assertEquals(
               actualRating,
               rating,
               "Place rating is mismatched"
       );
       System.out.println("Place Rating: " + actualRating);
   }
   @Then("the review count should be {string}")
   public void verifyReviewCount(String reviews) {
       visibilityWait(getDriver(), getPage().reviewCount);
       String actualReviews = gettext(
               getDriver(),
               getPage().reviewCount
       );
       Assert.assertEquals(
               actualReviews,
               reviews,
               "Review count is mismatched"
       );
       System.out.println("Review Count: " + actualReviews);
   }
   @Then("the location should be {string}")
   public void verifyLocation(String location) {
       visibilityWait(getDriver(), getPage().placeLocation);
       String actualLocation = gettext(
               getDriver(),
               getPage().placeLocation
       );
       Assert.assertEquals(
               actualLocation,
               location,
               "Place location is mismatched"
       );
       System.out.println("Place Location: " + actualLocation);
   }
   @Then("the application should handle {string} correctly")
   public void verifyNegativeCondition(String condition) {
       switch (condition) {
           case "No saved places":
               visibilityWait(getDriver(), getPage().emptySavedPlaces);
               Assert.assertTrue(
                       getPage().emptySavedPlaces.isDisplayed(),
                       "Empty saved places message is not displayed"
               );
               System.out.println("No saved places message is displayed");
               break;
           case "Location name is unavailable":
               visibilityWait(getDriver(), getPage().placeName);
               Assert.assertTrue(
                       getPage().placeName.isDisplayed(),
                       "Place details are not displayed"
               );
               visibilityWait(getDriver(), getPage().locationUnavailable);
               Assert.assertTrue(
                       getPage().locationUnavailable.isDisplayed(),
                       "Location unavailable indicator is not displayed"
               );
               System.out.println("Location unavailable indicator is displayed");
               break;
           default:
               Assert.fail("Unknown negative condition: " + condition);
       }
   }
   @Then("the application should display {string}")
   public void verifyExpectedResult(String expectedResult) {
       switch (expectedResult) {
           case "No saved places message":
               visibilityWait(getDriver(), getPage().emptySavedPlaces);
               Assert.assertTrue(
                       getPage().emptySavedPlaces.isDisplayed(),
                       "No saved places message is not displayed"
               );
               System.out.println("No saved places message verified");
               break;
           case "Location unavailable message":
               visibilityWait(getDriver(), getPage().locationUnavailable);
               Assert.assertTrue(
                       getPage().locationUnavailable.isDisplayed(),
                       "Location unavailable message is not displayed"
               );
               System.out.println("Location unavailable message verified");
               break;
           default:
               Assert.fail("Unknown expected result: " + expectedResult);
       }
   }
}