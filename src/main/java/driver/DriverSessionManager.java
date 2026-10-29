
package driver;

import io.appium.java_client.AppiumDriver;

public final class DriverSessionManager {

    private static final ThreadLocal<AppiumDriver> driver =
            new ThreadLocal<>();

    private DriverSessionManager() {
            }

    public static void setDriver(AppiumDriver appiumDriver) {

        if (appiumDriver == null) {
            throw new IllegalArgumentException(
                "AppiumDriver cannot be null"
            );
        }

        driver.set(appiumDriver);
    }

    public static AppiumDriver getDriver() {

        return driver.get();
    }

    public static boolean hasDriver() {

        return driver.get() != null;
    }

    public static void removeDriver() {

        driver.remove();
    }
}
