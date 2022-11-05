package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String host = "localhost";
    private static final String port = "1433";
    private static final String name = "Test";
    private static final String user = "mssql";
    private static final String pass = "12345679";
    private static final String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s", host, port, name);

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e) {
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
