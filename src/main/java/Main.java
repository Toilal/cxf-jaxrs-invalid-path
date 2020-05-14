import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LoggingFeature loggingFeature = new LoggingFeature();
        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider();
        try {
            // See the logs, generated Address is http://nounderscore/aquagliss/bar, which is what we expect.
            FooService client = JAXRSClientFactory.create("http://nounderscore/aquagliss", FooService.class, Arrays.asList(jacksonProvider), Arrays.asList(loggingFeature), null);
            client.bar();
        } catch (Exception e) {
        }

        try {
            // See the logs, generated Address is http://with_underscore/aquagliss which is really unexpected.
            FooService client = JAXRSClientFactory.create("http://with_underscore/aquagliss", FooService.class, Arrays.asList(jacksonProvider), Arrays.asList(loggingFeature), null);
            client.bar();
        } catch (Exception e) {
        }
    }
}
