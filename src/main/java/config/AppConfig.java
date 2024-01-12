package config;

import infrastructure.DatabaseConnectionProvider;
import infrastructure.StoreRepositoryImpl;
import application.CsvParser;
import application.StoreImporter;

public class AppConfig {

    public static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
    }

    public DatabaseConfig databaseConfig() {
        return DatabaseConfig.INSTANCE;
    }

    public CsvConfig csvConfig() {
        return CsvConfig.INSTANCE;
    }

    public CsvParser csvParser() {
        return new CsvParser(csvConfig());
    }

    public DatabaseConnectionProvider databaseConnectionProvider() {
        return new DatabaseConnectionProvider(databaseConfig());
    }

    public StoreRepositoryImpl storeRepository() {
        return new StoreRepositoryImpl(databaseConnectionProvider());
    }

    public StoreImporter storeImporter() {
        return new StoreImporter(csvConfig(), csvParser(), storeRepository());
    }

}
