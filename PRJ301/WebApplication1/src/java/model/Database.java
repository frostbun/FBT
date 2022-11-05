package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String HOST = "localhost";
    private static final String PORT = "1433";
    private static final String NAME = "ProductOrder";
    private static final String USER = "mssql";
    private static final String PASS = "12345679";
    private static final String URL = String.format("jdbc:sqlserver://%s:%s;databaseName=%s", HOST, PORT, NAME);

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e) {
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
