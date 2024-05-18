package com.dennis;

import static com.dennis.utils.Logging.LOGGER;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author DennisMutethia
 */
public class Init {
   

    public final static Properties APPLICATION_PROPERTIES = new Properties();
    public final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (FileInputStream fis = new FileInputStream("application.properties")) {
            APPLICATION_PROPERTIES.load(fis);            
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "{0}", ex);
        }
    }

    public static void main(String[] args) {
        
    }
}
