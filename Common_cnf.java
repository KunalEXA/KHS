import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;
public class Common_cnf 
{
	public static final String COMMON_FILENAME = "Common.cfg";
    public static Properties read () throws Exception {
    	Reader reader = new FileReader (COMMON_FILENAME);
    	final Properties conf = new Properties ();
        conf.load (reader);
        return conf;
    }
}
