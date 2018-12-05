package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static String pathToProp = "d:\\Project\\practice2\\src\\main\\resources\\configuration.properties ";

    private static String url;
    private static String browser;
    private static String implicitlyWait;

    public static PropertyManager getInstance(){
        if(instance == null){
            instance = new PropertyManager();
            instance.loadData();

        }
        return instance;
    }

    private void loadData(){

        Properties prop = new Properties();

        try{
            prop.load(new FileInputStream(pathToProp));

        }catch(IOException e){
            Log.info("Configuration file cannot be found");
        }


        browser = prop.getProperty("browser");
        implicitlyWait = prop.getProperty("implicitlyWait");
        url = prop.getProperty("url");
    }

    public static String getUrl() {
        return url;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getImplicitlyWait() {
        return implicitlyWait;
    }
}
