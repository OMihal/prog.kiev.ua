package market.db;

import market.Customer;

import java.sql.SQLException;

public interface CustomerDAO {
    int insertCustomer(String taxNumber, String name) throws SQLException;
    Customer findCustomer(int id) throws SQLException;
}
