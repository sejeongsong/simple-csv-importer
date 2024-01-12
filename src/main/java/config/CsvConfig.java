package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class CsvConfig {

    public static final CsvConfig INSTANCE = new CsvConfig();

    private URL path;

    private CsvConfig() {
        init();
    }

    private void init() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            path = getClass().getClassLoader().getResource(properties.getProperty("csv.path"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public URL getPath() {
        return path;
    }
}
