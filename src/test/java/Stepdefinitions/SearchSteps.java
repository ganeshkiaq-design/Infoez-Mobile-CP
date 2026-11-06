package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.SearchPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class SearchSteps {

    AndroidDriver driver;
    SearchPage searchPage;

    @Before(order = 1)
    public void initializePages() {
        driver = (AndroidDriver) DeviceSessionManager.getDriver();

        Assert.assertNotNull(driver,
                "Android driver is not initialized");

        searchPage = new SearchPage(driver);
    }

    @Given("user is on the Explore Businesses page")
    public void user_is_on_the_explore_businesses_page() {

        Assert.assertTrue(
                BaseClass.isElementDisplayed(
                        driver, searchPage.businessSearchField),
                "Explore Businesses page is not displayed"
        );
    }

    @When("user enters {string} in the business search field")
    public void user_enters_search_keyword(String searchKeyword) {

        BaseClass.sendKeys(
                driver,
                searchPage.businessSearchField,
                searchKeyword
        );
    }

    @When("user taps the business search button")
    public void user_taps_the_business_search_button() {

        BaseClass.click(
                driver,
                searchPage.businessSearchButton
        );
    }

    @Then("matching businesses should be displayed for {string}")
    public void matching_businesses_should_be_displayed(
            String searchKeyword) {

        try {
            String selector =
                    "new UiSelector().textContains(\""
                    + searchKeyword + "\")";

            WebElement businessElement =
                    driver.findElement(
                            AppiumBy.androidUIAutomator(selector)
                    );

            Assert.assertTrue(
                    BaseClass.isElementDisplayed(
                            driver, businessElement),
                    "Matching business not found: " + searchKeyword
            );

        } catch (Exception e) {
            Assert.fail(
                    "No matching business found for: " + searchKeyword
            );
        }
    }

    @Then("the business search should show {string}")
    public void business_search_should_show_expected_result(
            String expectedResult) {

        switch (expectedResult) {

            case "NO_RESULTS":

                Assert.assertTrue(
                        BaseClass.isElementDisplayed(
                                driver, searchPage.noBusinessMessage),
                        "No-results message is not displayed"
                );
                break;

            case "VALIDATION":

                Assert.assertTrue(
                        BaseClass.isElementDisplayed(
                                driver, searchPage.validationMessage),
                        "Search validation message is not displayed"
                );
                break;

            default:
                Assert.fail(
                        "Unknown expected search result: "
                        + expectedResult
                );
        }
    }

    // ================= FILTER SELECTION =================

    @When("user taps the {string} filter")
    public void user_taps_the_filter(String filterType) {

        WebElement filterElement = getFilterElement(filterType);

        BaseClass.click(driver, filterElement);
    }

    @Then("the {string} filter should be selected")
    public void filter_should_be_selected(String filterType) {

        WebElement filterElement = getFilterElement(filterType);

        Assert.assertTrue(
                isFilterSelected(filterElement),
                filterType + " filter is not selected"
        );
    }

    @Then("{string} should be displayed")
    public void expected_filtered_businesses_should_be_displayed(
            String expectedResult) {

        switch (expectedResult) {

            case "Only verified businesses":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, searchPage.verifiedBusinessIndicator),
                        "Verified businesses are not displayed");
                break;

            case "Businesses with 4 or above rating":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, searchPage.businessRating),
                        "Business ratings are not displayed");
                break;

            case "Only featured businesses":

                Assert.assertTrue(BaseClass.isElementDisplayed(driver, searchPage.featuredBusinessIndicator),
                        "Featured businesses are not displayed");
                break;

            default:
                Assert.fail("Unknown filter result: " + expectedResult);
        }
    }

    // ================= FILTER DESELECTION =================

    @Then("the {string} filter should be deselected")
    public void filter_should_be_deselected(String filterType) {

        WebElement filterElement = getFilterElement(filterType);

        Assert.assertFalse(isFilterSelected(filterElement),
                filterType + " filter is still selected");
    }

    @Then("all matching businesses should be displayed")
    public void all_matching_businesses_should_be_displayed() {

        Assert.assertTrue(BaseClass.isElementDisplayed(driver, searchPage.businessResultContainer),
                "Business results are not displayed");
    }

    // ================= SORT FUNCTIONALITY =================

    @When("user taps the Most relevant sorting option")
    public void user_taps_most_relevant_sorting_option() {

        BaseClass.click(driver,searchPage.sortDropdown);
    }

    @When("user selects {string}")
    public void user_selects_sort_option(String sortOption) {

        WebElement sortElement;

        if (sortOption.equalsIgnoreCase("Most relevant")) {
            sortElement = searchPage.mostRelevantOption;

        } else if (sortOption.equalsIgnoreCase("Rating")) {
            sortElement = searchPage.ratingOption;

        } else {
            Assert.fail("Invalid sorting option: " + sortOption);
            return;
        }

        BaseClass.click(driver, sortElement);
    }

    @Then("businesses should be sorted by {string}")
    public void businesses_should_be_sorted_by(String sortOption) {

        String actualSortOption =
                searchPage.selectedSortOption.getText().trim();

        Assert.assertEquals(actualSortOption, sortOption,"Business sorting option does not match");
    }

    private WebElement getFilterElement(String filterType) {

        switch (filterType.toLowerCase().trim()) {

            case "verified":
                return searchPage.verifiedFilter;

            case "4 plus rating":
                return searchPage.ratingFilter;

            case "featured":
                return searchPage.featuredFilter;

            default:
                throw new IllegalArgumentException(
                        "Unknown filter type: " + filterType
                );
        }
    }

    private boolean isFilterSelected(WebElement filterElement) {

        String selected = filterElement.getAttribute("selected");
        String checked = filterElement.getAttribute("checked");
        return "true".equalsIgnoreCase(selected) ||
               "true".equalsIgnoreCase(checked);
    }
}
