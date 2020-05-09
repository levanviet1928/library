package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String DATABASENAME = "LMDB";
    private final String USER = "sa";
    private final String PASSWORD = "123456";
    private final String MURL = "jdbc:sqlserver://localhost:1433;";

    private static DBConnection instance = new DBConnection();

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName="+DATABASENAME+";"
                + "integratedSecurity=true";
        String url = MURL +"databaseName="+DATABASENAME+";user="+USER+";password="+PASSWORD+";";

        Connection conn = null;
        try {

            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
