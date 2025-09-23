package Database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    public static final Properties prorieties = new Properties();

    static {
        try(InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("database.properties.txt")){
            if(input == null){
                System.out.println("Unable to find the proprieties file");
                System.exit(1);
            }

            // Load the proprieties file
            prorieties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String GetUrl(){
        return prorieties.getProperty("database.url");
    }

    public static String GetUsername(){
        return prorieties.getProperty("database.username");
    }

    public static String GetPassword(){
        return prorieties.getProperty("database.password");
    }
}
