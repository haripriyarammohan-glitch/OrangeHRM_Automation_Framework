package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties  properties = new Properties();
	
	static {

	    try {
	    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
	    	properties.load(fis);
	    	properties.getProperty("browser");

	    } catch (IOException e) {

	        e.printStackTrace();
	    }
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}

