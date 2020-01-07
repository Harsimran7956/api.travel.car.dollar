package com.kamadhenu.api.travel.car.dollar.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * File utilities
 */
public class File {

    private static final Logger LOGGER = LoggerFactory.getLogger(File.class);

    /**
     * Read properties from file
     *
     * @param resource
     * @return
     */
    public static Properties getProperties(String resource) {
        LOGGER.debug("Loading properties");
        Properties properties = new Properties();
        try {
            InputStream inputStream =
                    File.class.getClassLoader().getResourceAsStream(resource);
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Error whilst loading properties {}", e.getMessage());
        }
        return properties;
    }

}
