package base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {
    public static String cfgFile="src/main/resources/config.properties";

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

    public static String getCfgValue(String key) {

        return(getValueFromFile(key, cfgFile));
    }
}