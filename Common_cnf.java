import java.io.Reader;
import java.util.Properties;
public class Common_cnf {
	public static final String COMMON_FILENAME = "Common.cfg";
    public static Properties read (Reader reader) throws Exception {
    	//Getting the properties from the config file. For now assuming that the file
    	//is of the default form property=value.
    	final Properties conf = new Properties ();
        conf.load (reader);
        return conf;
    }
}
