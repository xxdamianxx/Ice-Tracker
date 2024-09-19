package database_access;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class LocalDatabase implements DatabaseConnection {
    private final DataSource dataSource;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public LocalDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // You can add more methods specific to local database operations if needed
    
}
