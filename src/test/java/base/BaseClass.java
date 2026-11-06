package base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;

public class BaseClass {

    private static final Duration TIMEOUT = Duration.ofSeconds(80);
    public static AndroidDriver driver;
    public static AndroidDriver getDriver() {

        driver = DriverFactory.getDriver();
        return driver;
    }
    public void launchApplication() throws Exception {

        DriverFactory.createDriver();
        driver = DriverFactory.getDriver();
    }
    public void closeApplication() {

        try {
            AndroidDriver activeDriver = getDriver();
            if (activeDriver != null) {
                DriverFactory.quitDriver();
            }

        } catch (Exception e) {
            System.out.println(
                "Unable to close application cleanly: " + e.getMessage()
            );

        } finally {
            driver = null;
        }
    }

    // Take Screenshot
    public byte[] takeScreenshot() {

        AndroidDriver activeDriver = getDriver();
        return ((TakesScreenshot) activeDriver)
                .getScreenshotAs(OutputType.BYTES);
    }

    // Click with Wait
    public static void click(AndroidDriver driver, WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }
    // Visibility Wait
    public static void visibilityWait(AndroidDriver driver, WebElement element) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }
    // View Wait
    public void ViewWait(AndroidDriver driver, WebElement element) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static void relaunchApp(AndroidDriver driver) {

        driver.terminateApp("com.infoez.app");
        driver.activateApp("com.infoez.app");
    }
    public void navigateBack(AndroidDriver driver) {

        driver.navigate().back();
    }
    public static void clickableWait(AndroidDriver driver, WebElement element) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void sendKeys(
            AndroidDriver driver, WebElement element, String text) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(text);
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {

        }
    }

    // Clear with Wait
    public static void clear(AndroidDriver driver, WebElement element) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));

        element.clear();
    }

    // Check Displayed
    public static boolean displayed(AndroidDriver driver, WebElement element) {

        try {

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Wait and Check Element Visibility
    public static boolean isElementDisplayed(
            AndroidDriver driver, WebElement element) {

        try {

            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(element))
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Wait and Check Element Selection
    public static boolean isElementSelected(
            AndroidDriver driver, WebElement element) {

        try {

            return new WebDriverWait(driver, TIMEOUT)
                    .until(
                        ExpectedConditions.elementSelectionStateToBe(
                            element, true
                        )
                    );

        } catch (Exception e) {

            return false;
        }
    }

    public static boolean isAnyElementDisplayed(
            AndroidDriver driver, WebElement... elements) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

            ExpectedCondition<Boolean> condition = currentDriver -> {

                for (WebElement element : elements) {

                    try {

                        if (element.isDisplayed()) {
                            return true;
                        }

                    } catch (Exception ignored) {

                        }
                }

                return false;
            };

            return wait.until(condition);

        } catch (Exception e) {

            return false;
        }
    }

    // Wait Until Element Becomes Invisible
    public static boolean isElementInvisible(
            AndroidDriver driver, WebElement element) {

        try {

            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.invisibilityOf(element));

        } catch (Exception e) {

            return false;
        }
    }

    // Screenshot for Cucumber Report
    public static void takeScreenshot(
            AppiumDriver driver, Scenario scenario, String status) {

        try {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            String name = status + " - " + scenario.getName();

            scenario.attach(screenshot, "image/png", name);

            System.out.println(
                "Screenshot attached to Cucumber report: " + name
            );

        } catch (Exception e) {

            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    // Swipe Up
    public static void swipeUp(AndroidDriver driver) {

        driver.executeScript("mobile: swipeGesture", Map.of(
                "left", 100,
                "top", 100,
                "width", 200,
                "height", 600,
                "direction", "up",
                "percent", 0.75
        ));
    }

    // Swipe Down
    public static void swipeDown(AndroidDriver driver) {

        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", 100,
                "top", 800,
                "width", 800,
                "height", 900,
                "direction", "down",
                "percent", 0.5
        ));
    }

    // Scroll List
    public static void ScrollList(AndroidDriver driver) {

        try {

            WebElement list = driver.findElement(
                    AppiumBy.androidUIAutomator(
                        "new UiSelector().scrollable(true)"
                    )
            );

            driver.executeScript("mobile: scrollGesture", Map.of(
                    "elementId", ((RemoteWebElement) list).getId(),
                    "direction", "down",
                    "percent", 0.5
            ));

        } catch (Exception e) {

            driver.executeScript("mobile: scrollGesture", Map.of(
                    "left", 100,
                    "top", 800,
                    "width", 800,
                    "height", 900,
                    "direction", "down",
                    "percent", 0.5
            ));
        }
    }

    // Get Text with Wait
    public static String gettext(AndroidDriver driver, WebElement element) {

        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    // Scroll to Element by Text
    public void scrollToElementByText(AndroidDriver driver, String text) {

        String safeText = text.replace("\\", "\\\\")
                              .replace("\"", "\\\"");

        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\""
                + safeText + "\"))"
            )
        );
    }

    // Horizontal Scroll Left
    public void ScrollLeft(AndroidDriver driver) {

        org.openqa.selenium.Dimension size =
                driver.manage().window().getSize();

        int y = (int) (size.getHeight() * 0.42);

        int startX = (int) (size.getWidth() * 0.85);

        int endX = (int) (size.getWidth() * 0.15);

        PointerInput finger =
                new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
            finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                y
            )
        );

        swipe.addAction(
            finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()
            )
        );

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(),
                endX,y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        java.util.List<Sequence> actions = new ArrayList<>();
        actions.add(swipe);
        driver.perform(actions);
    }
    public void scrollCategoriesUntilvisible(
            AndroidDriver driver, WebElement category) {

        int screenWidth = driver.manage().window().getSize().getWidth();

        for (int i = 0; i < 10; i++) {

            try {

                Rectangle rect = category.getRect();

                int centerX = rect.getX() + rect.getWidth() / 2;

                if (centerX > 0 && centerX < screenWidth) {
                    return;
                }

            } catch (Exception e) {

                System.out.println(
                    "Category visibility check " + i + " failed: "
                    + e.getClass().getSimpleName()
                );
            }

            ScrollLeft(driver);
        }

        throw new NoSuchElementException(
            "Category not visible after horizontal swipes"
        );
    }
}
