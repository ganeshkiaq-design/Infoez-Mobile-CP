package Stepdefinitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseClass {
   private HomePage lp;
   private String selectedLocation;
   private String selectedCategory;
   private AndroidDriver getDriver() {
       return (AndroidDriver) DeviceSessionManager.getDriver();
   }
   private HomePage getPage() {
       if (lp == null) {
           lp = new HomePage(getDriver());
       }
       return lp;
   }
   @Given("user is on the Infoez home screen")
   public void home() {
       visibilityWait(
               getDriver(),
               getPage().searchField
       );
       Assert.assertTrue(
               getPage().searchField.isDisplayed(),
               "Infoez home screen is not displayed"
       );
   }
   @Then("user should see Infoez logo")
   public void logo() {
       visibilityWait(
               getDriver(),
               getPage().infoezLogo
       );
       Assert.assertTrue(
               getPage().infoezLogo.isDisplayed(),
               "Infoez logo is not displayed"
       );
   }
   @Then("user should see search field")
   public void searchField() {
       visibilityWait(
               getDriver(),
               getPage().searchField
       );
       Assert.assertTrue(
               getPage().searchField.isDisplayed(),
               "Search field is not displayed"
       );
   }
   @Then("user should see Near Me button")
   public void nearMe() {
       visibilityWait(
               getDriver(),
               getPage().nearMeButton
       );
       Assert.assertTrue(
               getPage().nearMeButton.isDisplayed(),
               "Near Me button is not displayed"
       );
   }
   @Then("user should see current location")
   public void location() {
       visibilityWait(
               getDriver(),
               getPage().currentLocation
       );
       Assert.assertTrue(
               getPage().currentLocation.isDisplayed(),
               "Current location is not displayed"
       );
   }
   @Then("user should see Explore Categories section")
   public void categories() {
       visibilityWait(
               getDriver(),
               getPage().exploreCategories
       );
       Assert.assertTrue(
               getPage().exploreCategories.isDisplayed(),
               "Explore Categories section is not displayed"
       );
   }
   @Then("user should see Featured section")
   public void featured() {
       visibilityWait(
               getDriver(),
               getPage().featuredSection
       );
       Assert.assertTrue(
               getPage().featuredSection.isDisplayed(),
               "Featured section is not displayed"
       );
   }
   @Then("user should see bottom navigation")
   public void bottomNavigation() {
       visibilityWait(
               getDriver(),
               getPage().bottomNavigation
       );
       Assert.assertTrue(
               getPage().bottomNavigation.isDisplayed(),
               "Bottom navigation is not displayed"
       );
   }
   
   @When("user enters {string} in the search field")
   public void search(String keyword) {
       visibilityWait(
               getDriver(),
               getPage().searchField
       );
       click(
               getDriver(),
               getPage().searchField
       );
       clear(
               getDriver(),
               getPage().editableSearchField
       );
       if (keyword.equals("EMPTY")) {
           return;
       }
       if (keyword.equals("SPACES")) {
           sendKeys(
                   getDriver(),
                   getPage().editableSearchField,
                   "   "
           );
           return;
       }
       sendKeys(
               getDriver(),
               getPage().editableSearchField,
               keyword
       );
   }
   @When("user clicks the search button")
   public void searchButton() {
       visibilityWait(
               getDriver(),
               getPage().searchButton
       );
       click(
               getDriver(),
               getPage().searchButton
       );
   }
   @Then("user should see search results")
   public void results() {
       visibilityWait(
               getDriver(),
               getPage().matchingSearchResult
       );
       Assert.assertTrue(
               getPage().matchingSearchResult.isDisplayed(),
               "Search results are not displayed"
       );
   }
   @Then("user should see {string}")
   public void verifySearchMessage(String expectedMessage) {
       switch (expectedMessage) {
           case "NO_RESULTS":
               visibilityWait(
                       getDriver(),
                       getPage().searchEmptyState
               );
               Assert.assertTrue(
                       getPage().searchEmptyState.isDisplayed(),
                       "No results message is not displayed"
               );
               break;
           case "VALIDATION":
               visibilityWait(
                       getDriver(),
                       getPage().searchValidationMessage
               );
               Assert.assertTrue(
                       getPage().searchValidationMessage.isDisplayed(),
                       "Search validation message is not displayed"
               );
               break;
           default:
               Assert.fail(
                       "Unknown expected search message: " + expectedMessage
               );
       }
   }
   
   @When("user clicks Near Me button")
   public void tapNearMe() {
       visibilityWait(
               getDriver(),
               getPage().nearMeButton
       );
       click(
               getDriver(),
               getPage().nearMeButton
       );
   }
   @Then("user should see nearby businesses")
   public void nearby() {
       visibilityWait(
               getDriver(),
               getPage().nearbyPlacesScreen
       );
       Assert.assertTrue(
               getPage().nearbyPlacesScreen.isDisplayed(),
               "Nearby businesses are not displayed"
       );
   }
   @When("user denies location permission")
   public void denyLocationPermission() {
       getDriver().executeScript(
               "mobile: changePermissions",
               Map.of(
                       "appPackage", "com.infoez.app",
                       "permissions", List.of(
                               "android.permission.ACCESS_FINE_LOCATION",
                               "android.permission.ACCESS_COARSE_LOCATION"
                       ),
                       "action", "deny"
               )
       );
   }
   @Then("user should see location permission message")
   public void locationPermissionMessage() {
       visibilityWait(
               getDriver(),
               getPage().locationPermissionMessage
       );
       Assert.assertTrue(
               getPage().locationPermissionMessage.isDisplayed(),
               "Location permission message is not displayed"
       );
   }
   
   @When("user clicks current location")
   public void tapLocation() {
       visibilityWait(
               getDriver(),
               getPage().currentLocation
       );
       click(
               getDriver(),
               getPage().currentLocation
       );
   }
   @Then("user should navigate to location selection screen")
   public void locationScreen() {
       visibilityWait(
               getDriver(),
               getPage().locationSelectionScreen
       );
       Assert.assertTrue(
               getPage().locationSelectionScreen.isDisplayed(),
               "Location selection screen is not displayed"
       );
   }
   @When("user selects location {string}")
   public void selectLocation(String location) {
       selectedLocation = location;
       visibilityWait(
               getDriver(),
               getPage().locationSearchField
       );
       click(
               getDriver(),
               getPage().locationSearchField
       );
       clear(
               getDriver(),
               getPage().locationSearchField
       );
       sendKeys(
               getDriver(),
               getPage().locationSearchField,
               location
       );
       WebElement option = getDriver().findElement(getPage().getLocationOption(location));
       visibilityWait(
               getDriver(),
               option
       );
       click(
               getDriver(),
               option
       );
   }
   @Then("selected location should be displayed")
   public void selectedLocation() {
       Assert.assertNotNull(
               selectedLocation,
               "No location was selected"
       );
       WebElement selected = getDriver().findElement(getPage().getSelectedLocation(selectedLocation));
       visibilityWait(
               getDriver(),
               selected
       );
       Assert.assertTrue(
               selected.isDisplayed(),
               "Selected location is not displayed: " + selectedLocation
       );
   }
   @When("user searches for {string}")
   public void searchLocation(String location) {
       visibilityWait(
               getDriver(),getPage().locationSearchField
    		   );
       click(
       getDriver(),
       getPage().locationSearchField
       );
       clear(
       getDriver(),
       getPage().locationSearchField
       );
       sendKeys(
       getDriver(),
       getPage().locationSearchField,
       location
       );
       }
       @Then("user should see location message {string}")
       public void locationMessage(String expectedMessage) {
       switch (expectedMessage) {
       case "LOCATION_NOT_FOUND":
       visibilityWait(
       getDriver(),
       getPage().locationNotFoundMessage
       );
       Assert.assertTrue(
       getPage().locationNotFoundMessage.isDisplayed(),
       "Location not found message is not displayed"
       );
       break;
       default:
       Assert.fail(
       "Unknown location message: " + expectedMessage
       );
       }
       }
       public Map<String, WebElement> categoriesMap() {
       return Map.of(
       "Restaurants", getPage().restaurantsCategory,
       "Beauty & Spa", getPage().beautyCategory,
       "Fitness & Wellness", getPage().fitnessCategory,
       "Home Services", getPage().homeServicesCategory
       );
       }
       @When("user selects {string} category")
       public void category(String category) {
       Assert.assertTrue(
       categoriesMap().containsKey(category),
       "Unknown category: " + category
       );
       selectedCategory = category;
       visibilityWait(
       getDriver(),
       categoriesMap().get(category)
       );
       click(
       getDriver(),
       categoriesMap().get(category)
       );
       }
       @Then("user should navigate to the selected category")
       public void categoryPage() {
       Assert.assertNotNull(
       selectedCategory,
       "No category was selected"
       );
       WebElement selected = getDriver().findElement(getPage().getSelectedCategory(selectedCategory));
       visibilityWait(
       getDriver(),
       selected
       );
       Assert.assertTrue(
       selected.isDisplayed(),
       "Selected category page is not displayed: " + selectedCategory
       );
       }
       @When("user clicks See All categories")
       public void seeAllCategories() {
       visibilityWait(
       getDriver(),
       getPage().seeAllCategories
       );
       click(
       getDriver(),
       getPage().seeAllCategories
       );
       }
       @Then("user should see all available categories")
       public void allCategories() {
       visibilityWait(
       getDriver(),
       getPage().allCategoriesScreen
       );
       Assert.assertTrue(
       getPage().allCategoriesScreen.isDisplayed(),
       "All categories screen is not displayed"
       );
       }
       }