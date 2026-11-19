package Stepdefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.ProfilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends BaseClass {
   
	private ProfilePage lp;
    private AndroidDriver getDriver() {
       return (AndroidDriver) DeviceSessionManager.getDriver();
   }
    private ProfilePage getPage() {
       if (lp == null) {
           lp = new ProfilePage(getDriver());
       }
       return lp;
   }
   
   @When("user navigates to explore businesses")
   public void user_navigates_to_explore_businesses() {
       visibilityWait(getDriver(), getPage().exploreBusinesses);
       click(getDriver(), getPage().exploreBusinesses);
   }
   @When("user searches for business {string}")
   public void user_searches_for_business(String businessName) {
       visibilityWait(getDriver(), getPage().businessSearchField);
       sendKeys(getDriver(), getPage().businessSearchField, businessName);
       click(getDriver(), getPage().businessSearchButton);
   }
   @Then("business listing should be displayed")
   public void business_listing_should_be_displayed() {
       visibilityWait(getDriver(), getPage().businessSearchField);
       Assert.assertTrue(
               getPage().businessSearchField.isDisplayed(),
               "Business listing is not displayed"
       );
   }
   @Then("business {string} should be available")
   public void business_should_be_available(String businessName) {
       List<WebElement> businessList =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().text(\"" + businessName + "\")"
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
               "Business not found: " + businessName
       );
   }
   @Then("no matching business should be displayed")
   public void no_matching_business_should_be_displayed() {
       visibilityWait(getDriver(), getPage().noBusinessMessage);
       Assert.assertTrue(
               getPage().noBusinessMessage.isDisplayed(),
               "No-business-found message is not displayed"
       );
   }
  
   @When("user saves the business {string}")
   public void user_saves_the_business(String businessName) {
       visibilityWait(getDriver(), getPage().addFavoriteButton);
       click(getDriver(), getPage().addFavoriteButton);
   }
   @Given("business {string} is already saved")
   public void business_is_already_saved(String businessName) {
       click(getDriver(), getPage().exploreBusinesses);
       visibilityWait(getDriver(), getPage().businessSearchField);
       sendKeys(getDriver(), getPage().businessSearchField, businessName);
       click(getDriver(), getPage().businessSearchButton);
       List<WebElement> removeButtons =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().description(\"Remove from favorites\")"
                       )
               );
       boolean alreadySaved = false;
       for (WebElement button : removeButtons) {
           if (button.isDisplayed()) {
               alreadySaved = true;
               break;
           }
       }
       if (!alreadySaved) {
           visibilityWait(getDriver(), getPage().addFavoriteButton);
           click(getDriver(), getPage().addFavoriteButton);
       }
   }
   @When("user navigates to saved places")
   public void user_navigates_to_saved_places() {
       visibilityWait(getDriver(), getPage().savedPlaces);
       click(getDriver(), getPage().savedPlaces);
   }
   @Then("saved business {string} should be displayed")
   public void saved_business_should_be_displayed(String businessName) {
       List<WebElement> savedBusinessList =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().text(\"" + businessName + "\")"
                       )
               );
       boolean found = false;
       for (WebElement business : savedBusinessList) {
           if (business.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertTrue(
               found,
               "Saved business not found: " + businessName
       );
   }
   @When("user removes the saved business {string}")
   public void user_removes_the_saved_business(String businessName) {
       visibilityWait(getDriver(), getPage().removeFavoriteButton);
       click(getDriver(), getPage().removeFavoriteButton);
   }
   @Then("saved business {string} should not be displayed")
   public void saved_business_should_not_be_displayed(String businessName) {
       By businessLocator = AppiumBy.androidUIAutomator(
               "new UiSelector().text(\"" + businessName + "\")"
       );
       new WebDriverWait(getDriver(), Duration.ofSeconds(10))
               .until(ExpectedConditions.invisibilityOfElementLocated(businessLocator));
       List<WebElement> savedBusinessList =
               getDriver().findElements(businessLocator);
       boolean found = false;
       for (WebElement business : savedBusinessList) {
           if (business.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertFalse(
               found,
               "Business is still present in Saved Places: " + businessName
       );
   }
   
   @When("user navigates to notifications")
   public void user_navigates_to_notifications() {
       visibilityWait(getDriver(), getPage().notifications);
       click(getDriver(), getPage().notifications);
   }
   @Then("notification {string} should be displayed")
   public void notification_should_be_displayed(String title) {
       List<WebElement> notificationList =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().textContains(\"" + title + "\")"
                       )
               );
       boolean found = false;
       for (WebElement notification : notificationList) {
           if (notification.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertTrue(
               found,
               "Notification not found: " + title
       );
   }
   @Then("notification message should contain {string}")
   public void notification_message_should_contain(String message) {
       List<WebElement> messageList =
               getDriver().findElements(
                       AppiumBy.androidUIAutomator(
                               "new UiSelector().textContains(\"" + message + "\")"
                       )
               );
       boolean found = false;
       for (WebElement notification : messageList) {
           if (notification.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertTrue(
               found,
               "Notification message not found: " + message
       );
   }
   @Then("notification {string} should not be displayed")
   public void notification_should_not_be_displayed(String title) {
       By notificationLocator = AppiumBy.androidUIAutomator(
               "new UiSelector().textContains(\"" + title + "\")"
       );
       new WebDriverWait(getDriver(), Duration.ofSeconds(10))
               .until(ExpectedConditions.invisibilityOfElementLocated(notificationLocator));
       List<WebElement> notificationList =
               getDriver().findElements(notificationLocator);
       boolean found = false;
       for (WebElement notification : notificationList) {
           if (notification.isDisplayed()) {
               found = true;
               break;
           }
       }
       Assert.assertFalse(found,"Unexpected notification found: " + title);
   }
   
   @When("user opens the first business result")
   public void user_opens_the_first_business_result() {
       visibilityWait(getDriver(), getPage().businessResult);
       click(getDriver(), getPage().businessResult);
   }
   @Then("the Business Details screen should be displayed")
   public void business_details_screen_should_be_displayed() {
       visibilityWait(getDriver(), getPage().enquiriesButton);
       Assert.assertTrue(
               getPage().enquiriesButton.isDisplayed(),
               "Business Details screen is not displayed"
       );
   }
   @When("user opens Enquiries")
   public void user_opens_enquiries() {
       visibilityWait(getDriver(), getPage().enquiriesButton);
       click(getDriver(), getPage().enquiriesButton);
   }
   @When("user enters enquiry message {string}")
   public void user_enters_enquiry_message(String message) {
	   if (message == null || message.trim().isEmpty()) {
		   return;
		   }
		   visibilityWait(getDriver(), getPage().enquiryMessageField);
		   sendKeys(getDriver(), getPage().enquiryMessageField, message);
		   }
		   @When("user submits the enquiry")
		   public void user_submits_the_enquiry() {
		   visibilityWait(getDriver(), getPage().submitEnquiryButton);
		   click(getDriver(), getPage().submitEnquiryButton);
		   }
		   @Then("the enquiry should be submitted successfully")
		   public void enquiry_should_be_submitted_successfully() {
		   visibilityWait(getDriver(), getPage().enquirySuccessMessage);
		   Assert.assertTrue(
		   getPage().enquirySuccessMessage.isDisplayed(),
		   "Enquiry success message is not displayed"
		   );
		   }
		   @Then("an enquiry validation error should be displayed")
		   public void enquiry_validation_error_should_be_displayed() {
		   visibilityWait(getDriver(), getPage().enquiryValidationError);
		   Assert.assertTrue(
		   getPage().enquiryValidationError.isDisplayed(),
		   "Enquiry validation error is not displayed"
		   );
		   }
		   }