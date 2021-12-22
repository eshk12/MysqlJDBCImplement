import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static DatabaseConnection dbIsntance = null;
    private static Connection con;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new DatabaseConnection();
        }
        return dbIsntance;
    }

    public synchronized Connection getConnection() throws Exception {
        if (con == null || con.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "db";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";

            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, userName, password);
        }
        return con;
    }

    public void closeConnection(Connection conn) {
        try {
            if (con != null || !con.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
}