package market.db;

import java.sql.SQLException;

public interface StructureDAO {
    void createStructure() throws SQLException;
    void destroyStructure() throws SQLException;
}
