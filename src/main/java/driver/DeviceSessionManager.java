package driver;

import java.util.concurrent.atomic.AtomicInteger;
import utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

public final class DeviceSessionManager {

    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static final AtomicInteger deviceCounter = new AtomicInteger(0);
    private static final int DEVICE_COUNT = 1;
    private DeviceSessionManager() {
    }

    public static void startDevices() throws Exception {
        String prefix = "device1";
        AndroidDriver d = DriverFactory.createDriver(
                ConfigReader.get(prefix + ".name"),
                ConfigReader.get(prefix + ".udid"),
                ConfigReader.get(prefix + ".appium.url"),
                Integer.parseInt(ConfigReader.get(prefix + ".systemPort")),
                ConfigReader.get("appPackage"),
                ConfigReader.get("appActivity")
        );

        driver.set(d);
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static boolean isDriverActive() {
        return driver.get() != null;
    }

    public static void quitDevice() {

        AndroidDriver d = driver.get();

        try {
            if (d != null) {
                d.quit();
            }
        } finally {
            driver.remove();
        }
    }
}
