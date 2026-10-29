package Stepdefinitions;

import driver.DriverSessionManager;
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
import pages.SearchPage;

public class SearchSteps {
    AndroidDriver driver;
    WebDriverWait wait;
    void initialize() {
        driver = (AndroidDriver) DriverSessionManager.getDriver();
        Assert.assertNotNull(driver, "Appium driver is not initialized. Check Hooks.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    void click(WebElement element) { wait.until(ExpectedConditions.elementToBeClickable(element)).click(); }
    void show(WebElement element) { Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()); }
    void enter(WebElement element, String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOf(element));
        field.clear();
        field.sendKeys(value);
    }
    SearchPage page;
    void initPage() { 
    initialize(); 
    page = new SearchPage(driver); 
    }

    @Given("the user is on the Explore Businesses page") 
    public void explore() {
    	initPage(); 
    	show(page.exploreBusinessesTitle);
    	}
    
    @When("the user searches for {string}") 
    public void search(String text) {
    	enter(page.searchField,text); 
    	click(page.searchButton); }
    
    @Then("the search results should be displayed") 
    public void results() {
    	show(page.businessNames); }
    
    @Then("the results should match the search text {string}")
    public void matching(String text) {
    	show(page.dynamicResult); 
    	}
    
    @When("the user selects the {string} filter") 
    public void filter(String name) {
    	click(filters().get(name)); }
    
    @Then("the {string} filter should be selected") 
    public void selected(String name) {
    	show(filters().get(name)); 
    	}
    
    Map<String,WebElement> filters() {
    	return Map.of("Verified",page.verifiedFilter,"4+ rating",page.ratingFilter,
    			"Featured",page.featuredFilter); }
    
    @Then("the filtered business results should be displayed")
    public void filtered() { 
    	show(page.businessNames); }
    
    @When("the user sorts results by {string}")
    public void sort(String option) {
    	click(page.sortOption); 
    	click(page.dynamicSortOption); 
    	}
    
    @Then("the results should be sorted by {string}")
    public void sorted(String option) {
    	show(page.dynamicSortOption); }
    
    @Then("the business {string} should be displayed")
    public void business(String name) { 
    	show(page.dynamicBusiness); }
    
    @Then("the business rating should be displayed") 
    public void rating() {
    	show(page.rating); }
    
    @Then("the business location should be displayed")
    public void location() { 
    	show(page.location); }
    
    @Then("the business availability should be displayed")
    public void available() {
    	show(page.openToday); }
    
    @When("I search for {string}") 
    public void searchBusiness(String name) {
    	search(name); }
    
    @When("I open the first business result") 
    public void openBusiness() {
    	click(page.businessNames); 
    	}
}
