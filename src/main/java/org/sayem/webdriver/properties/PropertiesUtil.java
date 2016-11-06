package org.sayem.webdriver.properties;

import org.sayem.webdriver.Repository;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by sayem on 12/28/15.
 */
public class PropertiesUtil {
    private static final Logger log = getLogger(PropertiesUtil.class);
    private String dataLocation;
    private Properties properties;

    private PropertiesUtil(String dataLocation) {
        this.dataLocation = dataLocation;
        loadProperties();
    }

    public static PropertiesUtil create(String dataLocation) {
        return new PropertiesUtil(dataLocation);
    }

    static <T> T valueOf(Class<T> clazz, String arg) {
        Exception cause = null;
        T ret = null;
        try {
            ret = clazz.cast(clazz.getDeclaredMethod("valueOf", String.class).invoke(null, arg)
            );
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            cause = e;
        }
        if (cause == null) {
            return ret;
        } else {
            throw new IllegalArgumentException(cause);
        }
    }

    private void loadProperties() {
        FileInputStream fileInputStream = null; //"src/test/resources/xxx.properties"
        try {
            fileInputStream = new FileInputStream(dataLocation);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            log.error("failed or interrupted I/O operations", e);
            ;
        }
    }

    @SuppressWarnings("unchecked")
    public String getProperties(String name) {
        String prop = null;
        try {
            prop = properties.getProperty(name);

        } catch (Exception e) {
            log.error("Exception while execution", e);
        }
        return prop;
    }

    public <T> T getProperties(String name, Class<T> type) {
        T prop = null;
        try {

            String temp = properties.getProperty(name);
            prop = valueOf(type, temp);

        } catch (Exception e) {
            log.error("Exception while execution", e);
        }
        return prop;
    }

    public String data(Repository value) {
        return getProperties(value.getValue());
    }
}
