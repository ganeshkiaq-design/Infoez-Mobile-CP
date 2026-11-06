package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties =
            new Properties();

    private ConfigReader() {
        
    }

       static {
        try (InputStream input =
                ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                    "config.properties not found. " +
                    "Place it in src/test/resources"
                );
            }

            properties.load(input);

            System.out.println(
                "ConfigReader: config.properties loaded successfully"
            );

        } catch (IOException e) {
            throw new ExceptionInInitializerError(
                "Unable to load config.properties: " +
                e.getMessage()
            );
        }
    }


    public static String get(String key) {

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException(
                "Configuration key cannot be null or empty"
            );
        }

        // System properties take priority
        String value = System.getProperty(key);

        if (value == null || value.isBlank()) {
            value = properties.getProperty(key);
        }

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                "Missing or empty configuration property: " + key
            );
        }

        value = value.trim();

        if (value.startsWith("${") &&
            value.endsWith("}")) {

            String envName = value.substring(
                2, value.length() - 1
            ).trim();

            if (envName.isBlank()) {
                throw new IllegalStateException(
                    "Empty environment variable name for: " + key
                );
            }

            String envValue = System.getenv(envName);

            if (envValue == null || envValue.isBlank()) {
                throw new IllegalStateException(
                    "Environment variable '" + envName +
                    "' is missing for property: " + key
                );
            }

            return envValue.trim();
        }

        return value;
    }

    public static int getInt(String key) {

        String value = get(key);

        try {
            return Integer.parseInt(value);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Invalid integer for property: " +
                key + " = " + value,
                e
            );
        }
    }

    public static long getLong(String key) {

        String value = get(key);

        try {
            return Long.parseLong(value);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Invalid long for property: " +
                key + " = " + value,
                e
            );
        }
    }

    public static boolean getBoolean(String key) {

        String value = get(key);

        if ("true".equalsIgnoreCase(value)) {
            return true;
        }

        if ("false".equalsIgnoreCase(value)) {
            return false;
        }

        throw new IllegalArgumentException(
            "Invalid boolean for property: " +
            key + " = " + value +
            ". Expected true or false."
        );
    }
}
