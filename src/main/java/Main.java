import context.SimpleApplicationContext;
import application.StoreImporter;

public class Main {

    public static void main(String[] args) {
        SimpleApplicationContext context = SimpleApplicationContext.INSTANCE;
        StoreImporter storeImporter = context.getStoreImporter();
        storeImporter.toDatabase();
    }

}
