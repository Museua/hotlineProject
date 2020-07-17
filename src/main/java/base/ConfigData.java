package base;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *  That class provides static methods for getting values from Config file
 */
public class ConfigData {
    public static String cfgFile="src/main/resources/config.properties";

    /*
     *  Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) {
        Properties p = null;
        try (FileInputStream cfg = new FileInputStream(fileName)){
            p = new Properties();
            p.load(cfg);
        }
        catch (Exception e){
            System.out.println("Catch" + e);
        }
        return p.getProperty(key);
    }

    /*
     *  Return value from config file.
     *  Note, please, that returned value is String.
     *  We should take care of value's type by himself when will use config data value in the test.
     */
    public static String getCfgValue(String key) {

        return(getValueFromFile(key, cfgFile));
    }
}