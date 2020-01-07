package com.kamadhenu.api.travel.car.dollar.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Loads config.properties file properties
 */
@Data
@ToString
@EqualsAndHashCode
public class Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private static Config config = null;

    private Properties properties;

    /**
     * Load properties once
     */
    private Config() {
        // load properties
        properties = File.getProperties("config.properties");
    }

    /**
     * Create single of config
     *
     * @return
     */
    public static Config config() {
        return config == null ? new Config() : config;
    }
}
