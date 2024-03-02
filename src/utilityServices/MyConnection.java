package utilityServices;

import java.sql.*;
public class MyConnection {

    private static final String DB_URL = "jdbc:mysql:///utilityservices";
    private static final String USER = "root";
    private static final String PASSWORD = "Pemisire8@";

    private Connection conn;
    private Statement statement;

    public MyConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        statement = conn.createStatement();
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
