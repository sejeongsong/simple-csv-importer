package context;

import application.StoreImporter;
import config.AppConfig;

public class SimpleApplicationContext {

    public static final SimpleApplicationContext INSTANCE = new SimpleApplicationContext();

    private AppConfig appConfig;

    private SimpleApplicationContext() {
        this.appConfig = AppConfig.INSTANCE;
    }

    public StoreImporter getStoreImporter() {
        return appConfig.storeImporter();
    }
}
