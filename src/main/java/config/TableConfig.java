package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TableConfig {

    public static final TableConfig INSTANCE = new TableConfig();
    private String tableName;

    private TableConfig() {
        init();
    }

    private void init() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            tableName = properties.getProperty("database.table.name");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
