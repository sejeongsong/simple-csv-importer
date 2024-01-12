package infrastructure;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class DatabaseConnectionProvider {

    private final HikariDataSource dataSource;

    public DatabaseConnectionProvider(DatabaseConfig databaseConfig) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(databaseConfig.getDriver());
        config.setJdbcUrl(databaseConfig.getUrl());
        config.setUsername(databaseConfig.getUsername());
        config.setPassword(databaseConfig.getPassword());
        this.dataSource = new HikariDataSource(config);
    }

    private DatabaseConnectionProvider(String driver, String url, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        this.dataSource = new HikariDataSource(config);
    }

    public static DataBaseConnectionProviderBuilder builder() {
        return new DataBaseConnectionProviderBuilder();
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static class DataBaseConnectionProviderBuilder {

        private String driver;
        private String databaseName;
        private String username;
        private String password;

        private DataBaseConnectionProviderBuilder() {
        }

        public DataBaseConnectionProviderBuilder withDriver(String driver) {
            this.driver = driver;
            return this;
        }

        public DataBaseConnectionProviderBuilder withDatabaseName(String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        public DataBaseConnectionProviderBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public DataBaseConnectionProviderBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public DatabaseConnectionProvider build() {
            if (Objects.isNull(this.driver)
                    || Objects.isNull(this.databaseName)
                    || Objects.isNull(this.username)
                    || Objects.isNull(this.password)) {
                throw new IllegalStateException();
            }
            return new DatabaseConnectionProvider(
                    this.driver,
                    this.databaseName,
                    this.username,
                    this.password);
        }
    }

}
