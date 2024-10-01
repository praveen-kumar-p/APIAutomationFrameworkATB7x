package org.example.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class propertyReader {

    public static String readkey(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
            properties.load(fileInputStream);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(properties.getProperty(key));
    }

}
