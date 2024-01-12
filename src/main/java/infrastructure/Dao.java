package infrastructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao {

    protected final DatabaseConnectionProvider connectionProvider;

    protected Dao(DatabaseConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        try (
                Connection connection = connectionProvider.getConnection();
                ResultSet resultSet = connection.prepareStatement("show tables").executeQuery();
        ) {
            while (resultSet.next()) {
                tableNames.add(resultSet.getString(1));
            }
            return tableNames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getColumnsByTableName(String tableName) {
        List<String> tableNames = new ArrayList<>();
        try (
                Connection connection = connectionProvider.getConnection();
                ResultSet resultSet = connection.prepareStatement("describe " + tableName).executeQuery();
        ) {
            while (resultSet.next()) {
                tableNames.add(resultSet.getString(1));
            }
            return tableNames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
