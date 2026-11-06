package driver;
import io.appium.java_client.AppiumDriver;


public final class DeviceSessionManager {
   
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
   
   private DeviceSessionManager() {
   }
   
   public static void startDevices() throws Exception {
      
	   DriverFactory.createDriver();
       AppiumDriver localDriver = DriverFactory.getDriver();
       setDriver(localDriver);
   }
   public static void setDriver(AppiumDriver appiumDriver) {
       if (appiumDriver == null) {
           throw new IllegalArgumentException("AppiumDriver cannot be null");
       }
       driver.set(appiumDriver);
   }
   public static AppiumDriver getDriver() {
       return driver.get();
   }
   public static boolean hasDriver() {
       return driver.get() != null;
   }
   public static void quitDevice() {
       AppiumDriver localDriver = driver.get();
       try {
           if (localDriver != null) {
               localDriver.quit();
           }
       } finally {
           driver.remove();
       }
   }
}