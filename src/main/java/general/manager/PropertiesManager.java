package general.manager;

/**
 * Created by AKhawatrah on 1/13/2019.
 */

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

//import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;

public class PropertiesManager {

    public static Properties props = new Properties();
    public static Properties localeProps = new Properties();
    public static Properties extentReportProps = new Properties();

    /*
    test
     */
    private static ThreadLocal<Properties> appProps = new ThreadLocal();

    //private static ThreadLocal<Properties> reportProps = new ThreadLocal();
    /*static Logger log;

    static {
        log = Logger.getLogger(PropertiesManager.class);
    }*/
    public PropertiesManager() {
        //props = new Properties();
    }

    public static Properties getProperties() {

        String fileName = "RunProperties";

        props = new Properties();
        props = loadProperties(fileName, props);

        return props;
    }

    public static Properties getLocaleProperties(String locale) {


        String fileName;
        switch (locale.toLowerCase()) {
            case "ar":
                fileName = "Locale_AR.properties";
                break;
            case "en":
                fileName = "Locale_EN.properties";
                break;
            case "fr":
                fileName = "Locale_FR.properties";
                break;
            default:
                fileName = "Locale_EN.properties";
        }
        localeProps = new Properties();
        localeProps = loadProperties(fileName, localeProps);

        return localeProps;
    }


    public static Properties getExtentReportProperties() {

        extentReportProps = new Properties();
        extentReportProps = loadProperties("extent.properties", extentReportProps);
        //System.out.println(extentReportProps.get("extent.reporter.html.out"));
        //extentReportProps.setProperty("extent.reporter.html.out" , "test-output/HtmlReport/ExtentHtmlaaa.html");

        return extentReportProps;
    }
/*    public  static Properties loadPropertiesStatic(String fileName) {

        // InputStream inputStream = getResourceAsStream(fileName);
        InputStream inputStream =  Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(fileName);

        try {
            //if (inputStream != null)
            // props.load(inputStream);
            appProps.set(new Properties());
            appProps.get().load(inputStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (inputStream == null) {
            String message = "property file '" + fileName
                    + "' not found in the classpath";
            // log.error(message);

        }

        return appProps.get();
    }*/

    public static Properties loadProperties(String fileName, Properties props) {

        // InputStream inputStream = getResourceAsStream(fileName);
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(fileName);

        try {
            //if (inputStream != null)
            props.load(inputStream);
            appProps.set(new Properties());
            appProps.get().load(inputStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (inputStream == null) {
            String message = "property file '" + fileName
                    + "' not found in the classpath";
            // log.error(message);

        }

        return props;
    }

    /*public String getReportConfigPath() {
        String reportConfigPath = props.getProperty("reportConfigPath");
        if (reportConfigPath != null)
            return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }*/


    public static void updateProperties(String fileName, Properties props, String key, String value) {


        try {
            //FileInputStream in = new FileInputStream("First.properties");
            //props.setProperty()
            FileOutputStream out = new FileOutputStream(fileName);
            props.setProperty(key, value);
            props.store(out, null);
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println(e.toString());

        }


    }

}
