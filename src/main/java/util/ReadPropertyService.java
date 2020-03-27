package util;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ReadPropertyService {

    private static final Properties properties;

    static {
        properties = new Properties();
    }

    public static String readProperty(String property, String defaultValue) {

        String propertyPeople = System.getProperty(property);

        if (propertyPeople == null) {

            try (InputStream is = ReadPropertyService.class.getResourceAsStream("/application.properties")) {
                properties.load(is);
            } catch (Exception e) {

                log.warn("File with properties can't be read");
                log.info("Will used default value");
            }

            propertyPeople = properties.getProperty("people", defaultValue);
        }

        log.info("Property=" + propertyPeople);
        return propertyPeople;

    }

    public int readProperty(String stringProperty) {

        return Integer.parseInt(ReadPropertyService.readProperty(stringProperty, "100"));

    }

}
