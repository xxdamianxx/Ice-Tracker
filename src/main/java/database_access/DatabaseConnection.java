package database_access;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    public Connection getConnection() throws SQLException;
}
