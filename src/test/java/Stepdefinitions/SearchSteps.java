package Stepdefinitions;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.SearchPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseClass {
   private SearchPage lp;
   private AndroidDriver getDriver() {
       return (AndroidDriver) DeviceSessionManager.getDriver();
   }
   private SearchPage getPage() {
       if (lp == null) {
           lp = new SearchPage(getDriver());
       }
       return lp;
   }
   @Given("user is on the Explore Businesses page")
   public void user_is_on_the_explore_businesses_page() {
       visibilityWait(getDriver(), getPage().businessSearchField);
       Assert.assertTrue(
               getPage().businessSearchField.isDisplayed(),
               "Explore Businesses page is not displayed"
       );
   }
   @When("user enters {string} in the business search field")
   public void user_enters_search_keyword(String searchKeyword) {
       visibilityWait(getDriver(), getPage().businessSearchField);
       sendKeys(
               getDriver(),
               getPage().businessSearchField,
               searchKeyword
       );
   }
   @When("user taps the business search button")
   public void user_taps_the_business_search_button() {
       visibilityWait(getDriver(), getPage().businessSearchButton);
       click(
               getDriver(),
               getPage().businessSearchButton
       );
   }
   @Then("matching businesses should be displayed for {string}")
   public void matching_businesses_should_be_displayed(String searchKeyword) {
       List<WebElement> businessList =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().textContains(\""
                                       + searchKeyword + "\")"
                       )
               );
       boolean found = false;
       for (WebElement business : businessList) {
           if (business.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertTrue(
               found,
               "No matching business found for: " + searchKeyword
       );
   }
   @Then("the business search should show {string}")
   public void business_search_should_show_expected_result(String expectedResult) {
       switch (expectedResult) {
           case "NO_RESULTS":
               visibilityWait(getDriver(), getPage().noBusinessMessage);
               Assert.assertTrue(
                       getPage().noBusinessMessage.isDisplayed(),
                       "No-results message is not displayed"
               );
               break;
           case "VALIDATION":
               visibilityWait(getDriver(), getPage().validationMessage);
               Assert.assertTrue(
                       getPage().validationMessage.isDisplayed(),
                       "Search validation message is not displayed"
               );
               break;
           default:
               Assert.fail("Unknown expected search result: " + expectedResult);
       }
   }
   
   @When("user taps the {string} filter")
   public void user_taps_the_filter(String filterType) {
       WebElement filterElement = getFilterElement(filterType);
       visibilityWait(getDriver(), filterElement);
       click(getDriver(), filterElement);
   }
   @Then("the {string} filter should be selected")
   public void filter_should_be_selected(String filterType) {
       WebElement filterElement = getFilterElement(filterType);
       visibilityWait(getDriver(), filterElement);
       Assert.assertTrue(
               isFilterSelected(filterElement),
               filterType + " filter is not selected"
       );
   }
   @Then("{string} should be displayed")
   public void expected_filtered_businesses_should_be_displayed(String expectedResult) {
       switch (expectedResult) {
           case "Only verified businesses":
               visibilityWait(getDriver(), getPage().verifiedBusinessIndicator);
               Assert.assertTrue(
                       getPage().verifiedBusinessIndicator.isDisplayed(),
                       "Verified businesses are not displayed"
               );
               break;
           case "Businesses with 4 or above rating":
               visibilityWait(getDriver(), getPage().businessRating);
               Assert.assertTrue(
                       getPage().businessRating.isDisplayed(),
                       "Business ratings are not displayed"
               );
               break;
           case "Only featured businesses":
               visibilityWait(getDriver(), getPage().featuredBusinessIndicator);
               Assert.assertTrue(
                       getPage().featuredBusinessIndicator.isDisplayed(),
                       "Featured businesses are not displayed"
               );
               break;
           default:
               Assert.fail("Unknown filter result: " + expectedResult);
       }
   }
   
   @Then("the {string} filter should be deselected")
   public void filter_should_be_deselected(String filterType) {
       WebElement filterElement = getFilterElement(filterType);
       Assert.assertFalse(
               isFilterSelected(filterElement),
               filterType + " filter is still selected"
       );
   }
   @Then("all matching businesses should be displayed")
   public void all_matching_businesses_should_be_displayed() {
       visibilityWait(getDriver(), getPage().businessResultContainer);
       Assert.assertTrue(
               getPage().businessResultContainer.isDisplayed(),
               "Business results are not displayed"
       );
   }
  
   @When("user taps the Most relevant sorting option")
   public void user_taps_most_relevant_sorting_option() {
       visibilityWait(getDriver(), getPage().sortDropdown);
       click(getDriver(), getPage().sortDropdown);
   }
   @When("user selects {string}")
   public void user_selects_sort_option(String sortOption) {
       WebElement sortElement;
       if (sortOption.equalsIgnoreCase("Most relevant")) {
           sortElement = getPage().mostRelevantOption;
       } else if (sortOption.equalsIgnoreCase("Rating")) {
           sortElement = getPage().ratingOption;
       } else {
           Assert.fail("Invalid sorting option: " + sortOption);
           return;
       }
       visibilityWait(getDriver(), sortElement);
       click(getDriver(), sortElement);
   }
   @Then("businesses should be sorted by {string}")
   public void businesses_should_be_sorted_by(String sortOption) {
       visibilityWait(getDriver(), getPage().selectedSortOption);
       String actualSortOption = gettext(
               getDriver(),
               getPage().selectedSortOption
       ).trim();
       Assert.assertEquals(
               actualSortOption,
               sortOption,
               "Business sorting option does not match"
       );
       System.out.println("Selected Sorting Option: " + actualSortOption);
   }
   
   private WebElement getFilterElement(String filterType) {
       switch (filterType.toLowerCase().trim()) {
           case "verified":
               return getPage().verifiedFilter;
           case "4 plus rating":
               return getPage().ratingFilter;
           case "featured":
               return getPage().featuredFilter;
           default:
               Assert.fail("Unknown filter type: " + filterType);
               return null;
       }
   }
   
   private boolean isFilterSelected(WebElement filterElement) {
       String selected = filterElement.getAttribute("selected");
       String checked = filterElement.getAttribute("checked");
       return "true".equalsIgnoreCase(selected)
               || "true".equalsIgnoreCase(checked);
   }
}