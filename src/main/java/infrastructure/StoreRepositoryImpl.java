package infrastructure;

import domain.Repository;
import domain.entity.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreRepositoryImpl extends Dao implements Repository<Store> {

    public StoreRepositoryImpl(DatabaseConnectionProvider connectionProvider) {
        super(connectionProvider);
    }

    @Override
    public void save(Store store) {
        try (
                Connection connection = connectionProvider.getConnection();
                PreparedStatement psmt = connection.prepareStatement(
                        "INSERT INTO store(id, opn_sf_team_code, mgt_no, opn_svc_id, name, road_address, address, phone, x, y, status) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ) {
            psmt.setString(1, store.getId());
            psmt.setString(2, store.getOpnSfTeamCode());
            psmt.setString(3, store.getMgtNo());
            psmt.setString(4, store.getOpnSvcId());
            psmt.setString(5, store.getName());
            psmt.setString(6, store.getRoadAddress());
            psmt.setString(7, store.getAddress());
            psmt.setString(8, store.getPhone());
            psmt.setDouble(9, store.getX());
            psmt.setDouble(10, store.getY());
            psmt.setInt(11, store.getStatus());
            psmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
