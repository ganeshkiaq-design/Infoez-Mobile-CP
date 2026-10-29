package utils;

import driver.DriverSessionManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverSessionManager.getDriver(),
                Duration.ofSeconds(ConfigReader.getInt("wait.seconds")));
    }
    public static WebElement visible(By locator) {
        return getWait().until(ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }
    public static WebElement clickable(By locator) {
        return getWait().until(ExpectedConditions
                        .elementToBeClickable(locator));
    }
    public static boolean displayed(By locator) {
        try {
            return visible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}