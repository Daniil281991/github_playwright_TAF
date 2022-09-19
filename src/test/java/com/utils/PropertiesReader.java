package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public String propertiesFilePath = "src/test/java/com/config/config.properties";

    public String getProperties(String propertyName) {
        try {
            Properties propertiesInstance = new Properties();
            InputStream input = new FileInputStream(propertiesFilePath);
            propertiesInstance.load(input);
            return propertiesInstance.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
