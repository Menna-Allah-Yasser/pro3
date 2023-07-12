package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private final String user = "root";
    private final String password = "password";
    private final String url = "jdbc:mysql://localhost/Center";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
